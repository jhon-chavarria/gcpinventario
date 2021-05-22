package ni.com.casapellas.erp.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;

import ni.com.casapellas.ejb.erp.util.DateTimeHelper;
import ni.com.casapellas.ejb.erp.util.NumericHelper;
import ni.com.casapellas.ejb.taller.TallerService;
import ni.com.casapellas.erp.caja.CajaService;
import ni.com.casapellas.erp.cliente.ClienteService;
import ni.com.casapellas.erp.inventario.almacen.ProductoService;
import ni.com.casapellas.erp.inventario.configuracion.EquivalenciaService;
import ni.com.casapellas.erp.inventario.ventas.factura.FacturaService;
import ni.com.casapellas.erp.vendedor.VendedorService;
import ni.com.casapellas.gcpinventario.ConsultaFacturaHistorico;
import ni.com.casapellas.gcpinventario.ConsultaFacturaHistoricoDetalle;
import ni.com.casapellas.gcpinventario.Factura;
import ni.com.casapellas.gcpinventario.FacturaDetalle;
import ni.com.casapellas.gcpinventario.FacturaTaller;
import ni.com.casapellas.gcpinventario.Invd35;
import ni.com.casapellas.gcpinventario.InventarioEquivalencia;
import ni.com.casapellas.gcpinventario.TABMUL;
import ni.com.casapellas.gcpmcaja.pojos.Producto;
import ni.com.casapellas.gcptaller.pojo.OrdenTrabajo;
import ni.com.casapellas.rest.erp.inventario.configuracion.ConfigurationBI;
import ni.com.casapellas.rest.erp.inventario.configuracion.ConfigurationService;

public class CustomValidation {
	protected EntityManager em;
	private String guid;
	private ConsultaFacturaHistorico facturaOriginal = null;

	public CustomValidation(EntityManager emComming) {
		this.em = emComming;
	}

	public CustomValidation(EntityManager emComming, String guidMaster) {
		this.em = emComming;
		this.guid = guidMaster;
	}

	private Boolean ValidateInvoice(Factura doc) throws Exception {
		Boolean isValid = false;

		try {
			String currentDate = DateTimeHelper.CastDateToString(new Date(), "yyyy-MM-dd");
			// Validar compania, sucursal y linea
			EquivalenciaService eqService = new EquivalenciaService(this.em, guid);

			// Validar que los documentos sean del dia
			// No anular facturas que no son del dia
			Date dtMov = DateTimeHelper.CastStringToDate(doc.getFECHA_MOVIMIENTO(), "yyyyMMdd");
			Long diffMov = DateTimeHelper.DateDiff("d", currentDate,
					DateTimeHelper.CastDateToString(dtMov, "yyyy-MM-dd"), "yyyy-MM-dd");
			if (diffMov != 0) {
				throw new Exception("No es posible crear documentos que no sean del dia.");
			}

			InventarioEquivalencia eq = eqService.GetConfigurationRow(doc.getCODIGO_COMPANNIA(),
					doc.getCODIGO_SUCURSAL(), doc.getCODIGO_DEPARTAMENTO());

			if (eq == null) {
				throw new Exception("La configuracion del documento es invalida");
			}

			// Validar el vendedor
			VendedorService vService = new VendedorService(em, guid);
			if (!vService.ExistVendor(doc.getCODIGO_COMPANNIA(), doc.getCODIGO_SUCURSAL(),
					Integer.parseInt(doc.getCODIGO_VENDEDOR_L()))) {
				throw new Exception("El codigo del vendedor es invalido");
			}

			// Validar el codigo del cliente siempre y cuando venga en el json
			if (doc.getCODIGO_CLIENTE() != null && doc.getCODIGO_CLIENTE().trim().length() > 0
					&& Integer.parseInt(doc.getCODIGO_CLIENTE().trim()) > 0) {
				ClienteService cService = new ClienteService(em, guid);
				if (!cService.ExistCustomer(Integer.parseInt(doc.getCODIGO_CLIENTE().trim()))) {
					throw new Exception("El codigo del cliente es invalido");
				}
			}

			ConfigurationService cfgService = new ConfigurationService(this.em, guid);
			TABMUL cfg = cfgService.GetJdeTipoMov(doc.getCODIGO_DEPARTAMENTO());

			if ((doc.getTIPO_CONDICION_PAGO().toLowerCase().equals("anulacion")
					|| doc.getTIPO_CONDICION_PAGO().toLowerCase().equals("devolucion"))) {

				// Validar la fecha y el documento
				if (doc.getNUMERO_DOCUMENTO_ORIGINAL() == null
						|| !NumericHelper.isNumeric(doc.getNUMERO_DOCUMENTO_ORIGINAL())) {
					throw new Exception("El numero de documento original es invalido");
				}

				if (doc.getFECHA_REGISTRO() == null || doc.getFECHA_REGISTRO().trim().length() <= 0) {
					throw new Exception("La fecha del documento original es invalida");
				}
				
				FacturaService fService = new FacturaService(em, guid);
				
				Date dt = DateTimeHelper.CastStringToDate(doc.getFECHA_REGISTRO(), "yyyyMMdd");
				facturaOriginal = fService.GetInvoiceByNumber(doc.getCODIGO_COMPANNIA(), doc.getCODIGO_SUCURSAL(),
						DateTimeHelper.CastDateToString(dt, "yyyy-MM-dd"),
						Integer.parseInt(doc.getNUMERO_DOCUMENTO_ORIGINAL()));

				if (facturaOriginal == null) {
					throw new Exception("La factura original no se encuentra o ya se encuentra anulada.");
				}			

				TABMUL cfgReturnType = cfgService.GetReturnTypeByCode(doc.getMOTIVO_ANULACION());
				if (cfgReturnType == null) {
					throw new Exception("El motivo de devolucion es invalido, no corresponde con los definidos.");
				}

			}

			switch (doc.getTIPO_CONDICION_PAGO().toLowerCase()) {
			case "contado":
				if (!doc.getTIPO_MOVIMIENTO().toLowerCase().equals("21")) {
					throw new Exception(
							"El tipo de movimiento es invalido para el tipo de condicion de pago requerido");
				}

				if (cfg == null) {
					throw new Exception("No se encontro la configuracion del tipo de movimiento asociado al JDE");
				}

				if (!cfg.getORDEN().toLowerCase().equals(doc.getTIPO_MOVIMIENTO_JDE().toLowerCase())) {
					throw new Exception(
							"El valor del campo TIPO_MOVIMIENTO_JDE no coincide con el configurado para el movimiento");
				}

				// Validar el detalle
				if (!ValidateInvoiceDetail(doc.getCODIGO_COMPANNIA(), doc.getCODIGO_SUCURSAL(),
						doc.getCODIGO_DEPARTAMENTO(), doc.getTIPO_CONDICION_PAGO(), doc.getProductos())) {
					throw new Exception("No se ha logrado validar los productos del documento");
				}
				break;
			case "credito":
				if (!doc.getTIPO_MOVIMIENTO().toLowerCase().equals("21")) {
					throw new Exception(
							"El tipo de movimiento es invalido para el tipo de condicion de pago requerido");
				}

				if (cfg == null) {
					throw new Exception("No se encontro la configuracion del tipo de movimiento asociado al JDE");
				}

				if (!cfg.getORDEN().toLowerCase().equals(doc.getTIPO_MOVIMIENTO_JDE().toLowerCase())) {
					throw new Exception(
							"El valor del campo TIPO_MOVIMIENTO_JDE no coincide con el configurado para el movimiento");
				}

				// Validar el detalle
				if (!ValidateInvoiceDetail(doc.getCODIGO_COMPANNIA(), doc.getCODIGO_SUCURSAL(),
						doc.getCODIGO_DEPARTAMENTO(), doc.getTIPO_CONDICION_PAGO(), doc.getProductos())) {
					throw new Exception("No se ha logrado validar los productos del documento");
				}
				break;
			case "anulacion":
				if (!doc.getTIPO_MOVIMIENTO().toLowerCase().equals("af")) {
					throw new Exception(
							"El tipo de movimiento es invalido para el tipo de condicion de pago requerido");
				}
				// No anular facturas que no son del dia
				Date dt = DateTimeHelper.CastStringToDate(doc.getFECHA_REGISTRO(), "yyyyMMdd");
				Long diff = DateTimeHelper.DateDiff("d", currentDate, DateTimeHelper.CastDateToString(dt, "yyyy-MM-dd"),
						"yyyy-MM-dd");
				if (diff != 0) {
					throw new Exception("No es posible anular facturas que no son del dia.");
				}

				// Validar que la factura no tenga devoluciones
				long count = facturaOriginal.getDetalle().stream()
						.filter(c -> c.getCantidadDevuelta().doubleValue() > 0).count();
				if (count > 0) {
					throw new Exception("No es posible anular la factura por que tiene devoluciones asociadas.");
				}
				
				// Como es una anulacion no deben existir diferencias entre los productos a anular
				for (Iterator<ConsultaFacturaHistoricoDetalle> iterator = facturaOriginal.getDetalle().iterator(); iterator.hasNext();) {
					ConsultaFacturaHistoricoDetalle detItem = (ConsultaFacturaHistoricoDetalle) iterator.next();
					
					List<FacturaDetalle> listInputFilter = doc.getProductos().stream()
							.filter(x -> x.getCODIGO_ARTICULO().trim().equals(detItem.getCodigoArticulo().trim())
											&& x.getCODIGO_BODEGA().trim().equals(detItem.getCodigoBodega().trim())
											&& x.getSECUENCIA() == detItem.getSecuencia().intValue())
							.collect(Collectors.toList());
					
					if (listInputFilter == null || listInputFilter.size() <= 0) {
						throw new Exception("El producto " + detItem.getCodigoArticulo().trim() + " no se encuentra en la factura original");
					}
					
					FacturaDetalle tItem = listInputFilter.get(0);
					
					if (detItem.getCantidad().floatValue() != tItem.getCANTIDAD() ) {
						throw new Exception("No puede anular la factura por que las unidades del producto " + detItem.getCodigoArticulo().trim() + " no son iguales a las unidades del documento original");
					}
				}

				// Validar que la factura no este pagada en caja
				CajaService cjService = new CajaService(em, this.guid);
				if (cjService.HasPaymentSlip(eq.getCodigoCompaniaJde().trim(), eq.getCodigoSucursalJde().trim(),
						eq.getCodigoDepartamentoJde().trim(), facturaOriginal.getNumeroDocumento().intValue(),
						facturaOriginal.getSubTipoMovimiento().trim())) {
					throw new Exception("No es posible anular la factura por que tiene recibos asociados.");
				}

				// Si estoy anulando una devolucion validar el inventario ????
				if (facturaOriginal.getTipoMovimiento().trim().equals("21") && facturaOriginal.getSubTipoMovimiento().trim().toLowerCase().equals("rm")) {
					// Validar el detalle
					if (!ValidateInvoiceDetail(doc.getCODIGO_COMPANNIA(), doc.getCODIGO_SUCURSAL(),
							doc.getCODIGO_DEPARTAMENTO(), doc.getTIPO_CONDICION_PAGO(), doc.getProductos())) {
						throw new Exception("No se ha logrado validar los productos del documento");
					}
				}
				break;
			case "devolucion":
				if(facturaOriginal.getNumeroOrdenTaller() != null && facturaOriginal.getCodigoTaller()!=null) {
					TallerService taller = new TallerService(em, guid);
					OrdenTrabajo otrabajo = taller.getWorkShopOrder(facturaOriginal.getCodigoCompania(), facturaOriginal.getCodigoTaller(),
							facturaOriginal.getNumeroOrdenTaller().intValue());

					if (otrabajo == null) {
						throw new Exception("La orden de trabajo no esta abierta o no existe");
					}	
				}
				
				if (!doc.getTIPO_MOVIMIENTO().toLowerCase().equals("21")) {
					throw new Exception(
							"El tipo de movimiento es invalido para el tipo de condicion de pago requerido");
				}

				if (!doc.getTIPO_MOVIMIENTO_JDE().toLowerCase().equals("rm")) {
					throw new Exception(
							"El valor del campo TIPO_MOVIMIENTO_JDE no coincide con el configurado para el movimiento");
				}
				
				if (facturaOriginal.getTipoMovimiento().trim().equals("21") && facturaOriginal.getSubTipoMovimiento().trim().toLowerCase().equals("rm")) {
					throw new Exception("Solo puede generar devoluciones de facturas.");
				}
				
				// Como es una devolucion no se deben permitir devolver mas de las unidades facturadas
				for (Iterator<FacturaDetalle> iterator = doc.getProductos().iterator(); iterator.hasNext();) {
					FacturaDetalle detItem = (FacturaDetalle) iterator.next();
					
					List<ConsultaFacturaHistoricoDetalle> listInputFilter = facturaOriginal.getDetalle().stream()
							.filter(x -> x.getCodigoArticulo().trim().equals(detItem.getCODIGO_ARTICULO().trim())
									&& x.getCodigoBodega().trim().equals(detItem.getCODIGO_BODEGA().trim())
									&& x.getSecuencia().intValue() == detItem.getSECUENCIA() )
							.collect(Collectors.toList());
					
					if (listInputFilter == null || listInputFilter.size() <= 0) {
						throw new Exception("El producto " + detItem.getCODIGO_ARTICULO().trim() + " no se encuentra en la factura original");
					}
					
					ConsultaFacturaHistoricoDetalle tItem = listInputFilter.get(0);
					
					if ((tItem.getCantidad().floatValue() - tItem.getCantidadDevuelta().floatValue()) < detItem.getCANTIDAD()) {
						throw new Exception("No puede devolver una cantidad mayor de unidades a las facturadas del producto " + detItem.getCODIGO_ARTICULO().trim());
					}
					
					if(facturaOriginal.getNumeroOrdenTaller() != null && facturaOriginal.getCodigoTaller()!=null) {
						if(tItem.getCantidadDevuelta() != null  && tItem.getCantidadDevuelta().floatValue() != 0) {
							throw new Exception("El producto " + detItem.getCODIGO_ARTICULO().trim() + " tiene cantidades devueltas.");
						}
						if ((tItem.getCantidad().floatValue() - detItem.getCANTIDAD()) != 0) {
							throw new Exception("Las unidades devueltas del producto " + detItem.getCODIGO_ARTICULO().trim() + " deben ser iguales.");
						}
					}
					
				}
				break;
			default:
				break;
			}

			// Validar las bodegas
			isValid = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return isValid;
	}

	private Boolean ValidateInvoiceDetail(String codigoCompania, String codigoSucursal, String codigoDepartamento,
			String tipoCondicionPago, List<FacturaDetalle> detalle) throws Exception {
		Boolean IsValid = true;

		try {
			if (detalle == null || detalle.size() <= 0) {
				throw new Exception("No existen productos asociados a la factura");
			}

			// Validar que no existan duplicados en la secuencia
			List<Integer> secuenseInfo = detalle.stream().map(FacturaDetalle::getSECUENCIA).distinct()
					.collect(Collectors.toList());

			if (secuenseInfo.size() != detalle.size())
				throw new Exception("La secuencia no debe poseer numeros duplicados");

			// Obtener la lista de productos totales con sus bodegas
			List<CustomInventory> customInventory = new ArrayList<CustomInventory>();
			// Agrupar los items para validarlos.
			Map<List<String>, Double> map = detalle.stream()
					.collect(Collectors.groupingBy(
							x -> new ArrayList<String>(Arrays.asList(x.getCODIGO_ARTICULO(), x.getCODIGO_BODEGA())),
							Collectors.summingDouble(x -> x.getCANTIDAD())));

			map.forEach((k, v) -> {
				customInventory.add(new CustomInventory(k.get(0), k.get(1), BigDecimal.valueOf(v)));
			});

			if (customInventory == null || customInventory.size() <= 0) {
				throw new Exception("No existen productos asociados a la factura");
			}
			
			// Obtener la lista de Bodegas y Articulos
			List<String> distinctArticulo = customInventory
					.stream().map(x -> x.getArticulo()).distinct().collect(Collectors.toList());
			
			List<String> distinctBodega = customInventory
					.stream().map(x -> x.getBodega()).distinct().collect(Collectors.toList());

			ProductoService ps = new ProductoService(this.em, this.guid);
			ConfigurationService cService = new ConfigurationService(em, guid);
			float variacionAceptada = 3;

			TABMUL configuration = cService.GetMaxAllowVariationCost();
			if (configuration != null) {
				if (NumericHelper.isNumeric(configuration.getOTROS().trim())) {
					variacionAceptada = Math.abs(Float.parseFloat(configuration.getOTROS().trim()));
				}
			}
			
			// Nuevo metodo para extrae la informacion de los productos a validar con la factura
			List<CustomItemStock> listStock = ps.GetProductToInvoice(codigoCompania, codigoSucursal, distinctBodega, distinctArticulo);

			AuditLogService.SaveLogDetail("ValidateItems", "JAVA-RUNTIME", this.guid);
			
			for (Iterator<CustomInventory> iterator = customInventory.iterator(); iterator.hasNext();) {
				CustomInventory ci = (CustomInventory) iterator.next();
				CustomItemStock invArticulo = null;
				
				List<CustomItemStock> filterList = listStock.stream().filter(x -> 
						x.getCodigoArticulo().trim().equals(ci.getArticulo().trim())
						&& x.getCodigoBodega().trim().equals(ci.getBodega().trim())
						).collect(Collectors.toList());
				
				if (filterList == null || filterList.size() <= 0) {
					throw new Exception(
							"No se encuentran existencias disponibles para el producto " + ci.getArticulo());
				}
				
				invArticulo = filterList.get(0);

				if (invArticulo.getExistenciaDispBodega() == null) {
					throw new Exception(
							"No se encontraron existencias disponibles para el producto " + ci.getArticulo());
				}

				if (invArticulo.getExistenciaDispBodega().floatValue() < ci.getCantidad().floatValue()) {
					throw new Exception(
							"El producto " + ci.getArticulo() + " no tiene suficientes existencias disponibles");
				}
				
				float costoGlobal = (invArticulo.getCostoUnitario().floatValue() * invArticulo.getExistenciaTotalSucursal().floatValue())
						- invArticulo.getCostoTotalSucursal().floatValue();

				if (!(costoGlobal >= (variacionAceptada * -1) && costoGlobal <= variacionAceptada)) {
					throw new Exception("El costo del producto " + ci.getArticulo()
							+ " no permite realizar transacciones sobre el mismo");
				}
				
				if (invArticulo.getBloqueado() == 1) {
					throw new Exception("El producto " + ci.getArticulo() + " esta bloqueado");
				}
				
				/*
				 * Primera forma de extraer todo
				// Extraer las existencias del producto
				InvExistGlobal invArticulo = ps.getProductExistenceByProduct(codigoCompania, codigoSucursal,
						ci.getBodega(), codigoDepartamento, ci.getArticulo());

				if (invArticulo == null) {
					throw new Exception(
							"No se encuentran existencias disponibles para el producto " + ci.getArticulo());
				}

				if (invArticulo.getExistencia() == null) {
					throw new Exception(
							"No se encontraron existencias disponibles para el producto " + ci.getArticulo());
				}

				if (invArticulo.getExistencia().floatValue() < ci.getCantidad().floatValue()) {
					throw new Exception(
							"El producto " + ci.getArticulo() + " no tiene suficientes existencias disponibles");
				}

				BigDecimal existSucursal = ps.getTotalBranchStock(codigoCompania, codigoDepartamento, codigoSucursal,
						ci.getArticulo());

				float costoGlobal = (invArticulo.getCosto().floatValue() * existSucursal.floatValue())
						- invArticulo.getCostoSucursal().floatValue();

				if (!(costoGlobal >= (variacionAceptada * -1) && costoGlobal <= variacionAceptada)) {
					throw new Exception("El costo del producto " + ci.getArticulo()
							+ " no permite realizar transacciones sobre el mismo");
				}

				Boolean bloqueado = ps.IsProductBlock(codigoCompania, codigoSucursal, ci.getBodega(),
						codigoDepartamento, ci.getArticulo());

				if (bloqueado) {
					throw new Exception("El producto " + ci.getArticulo() + " esta bloqueado");
				}
				*/
			}

			IsValid = true;
		} catch (Exception e) {
			throw e;
		}

		return IsValid;
	}

	public List<Invd35> getInvd35Format(Factura inputFormat) throws Exception {
		List<Invd35> outputFormat = new ArrayList<Invd35>();
		try {
			Invd35 returnInfo;

			if (!ValidateInvoice(inputFormat)) {
				throw new Exception("La factura es invalida");
			}

			if (inputFormat.getProductos() != null && inputFormat.getProductos().size() > 0) {
				for (FacturaDetalle item : inputFormat.getProductos()) {
					returnInfo = new Invd35();
					// Validacion de valores nulos para campos genericos
					if (inputFormat.getNUMERO_DOCUMENTO().length() == 0) {
						throw new Exception("Ingrese el numero de documento");
					}

					if (inputFormat.getTIPO_CONDICION_PAGO().toLowerCase().equals("anulacion")
							|| inputFormat.getTIPO_CONDICION_PAGO().toLowerCase().equals("devolucion")) {

//						returnInfo.setVALORG(billInformation.getVALORG());
//						returnInfo.setVALORU(billInformation.getVALORU());
//						returnInfo.setDEPARD(billInformation.getDEPARD());
						returnInfo.setREFERE(facturaOriginal.getNumeroOrdenTaller()); // Numero de Orden de taller
						returnInfo.setNCAJA(facturaOriginal.getTipoDocumentoTaller().trim()); // Tipo documento taller
						returnInfo.setTIPOTR(facturaOriginal.getCodigoTaller().trim()); // Codigo del taller
						
						returnInfo.setIUSUAR(facturaOriginal.getCodigoTecnico().trim()); // Codigo del Tecnico
						
						if (facturaOriginal.getTipoFactura() != null && facturaOriginal.getTipoFactura().trim().toLowerCase().equals("c") ) {
							returnInfo.setTIPOFD("E");
						} else {
							returnInfo.setTIPOFD("D");
						}
					}

					returnInfo.setISTAT4(inputFormat.getMOTIVO_ANULACION());
					returnInfo.setCOMPAN(inputFormat.getCODIGO_COMPANNIA());
					returnInfo.setSUCURS(inputFormat.getCODIGO_SUCURSAL());
					returnInfo.setDEPART(inputFormat.getCODIGO_DEPARTAMENTO());
					returnInfo.setTIPOMO(inputFormat.getTIPO_MOVIMIENTO());
					returnInfo.setTIPOMV(inputFormat.getTIPO_MOVIMIENTO_JDE());
					returnInfo.setBODEGA(item.getCODIGO_BODEGA());
					returnInfo.setDOCUME(new BigDecimal(inputFormat.getNUMERO_DOCUMENTO()));
					returnInfo.setFECHAM(new BigDecimal(inputFormat.getFECHA_MOVIMIENTO()));
					returnInfo.setNPARTE(item.getCODIGO_ARTICULO().trim());
					returnInfo.setISTAT2(item.getCODIGO_CATEGORIA().trim());
					returnInfo.setCOSTUA(new BigDecimal(0));
					returnInfo.setEXISTA(new BigDecimal(0));
					returnInfo.setCANTID(new BigDecimal(item.getCANTIDAD()));
					returnInfo.setCANTIDD(BigDecimal.ZERO);
					returnInfo.setSTATUA(" ");
					returnInfo.setTIPOCA(new BigDecimal(inputFormat.getTIPO_CAMBIO()));
					returnInfo.setHORAM(new BigDecimal((inputFormat.getHORA_MOVIMIENTO())));
					returnInfo.setPANTAL("LR");
					returnInfo.setHECHOP(inputFormat.getUSUARIO());
					returnInfo.setNPROGR("LR");
					returnInfo.setVENDED(inputFormat.getCODIGO_VENDEDOR_C());
					returnInfo.setCVCANAL("M");
					returnInfo.setCVENDED(new BigDecimal(inputFormat.getCODIGO_VENDEDOR_L()));
					returnInfo.setCLCLIE(new BigDecimal(inputFormat.getCODIGO_CLIENTE()));
					returnInfo.setCLNOMB(inputFormat.getNOMBRE_CLIENTE());
					returnInfo.setNBATCH(BigDecimal.ZERO);
					returnInfo.setHISECUE(new BigDecimal(item.getSECUENCIA()));

					switch (inputFormat.getTIPO_CONDICION_PAGO().toLowerCase()) {
					case "contado":

						returnInfo.setCANVEN(BigDecimal.ZERO);
						returnInfo.setTIPOFA("M");
						returnInfo.setTIPOFD("");
						returnInfo.setFECHAA(BigDecimal.ZERO);
						returnInfo.setNFACTU(BigDecimal.ZERO);
						returnInfo.setUSUAIN("");
						returnInfo.setHORAIN(BigDecimal.ZERO);
						returnInfo.setFECHIN(BigDecimal.ZERO);
						returnInfo.setSTATIN("");
						returnInfo.setSTATCV("");
						returnInfo.setINDCT("Y1");
						returnInfo.setVALORU(new BigDecimal(0));
						break;
					case "credito":
						returnInfo.setCODMONEDA("USD");
						returnInfo.setCANVEN(BigDecimal.ONE);
						returnInfo.setTIPOFA("M");
						returnInfo.setTIPOFD("C");
						returnInfo.setFECHAA(BigDecimal.ZERO);
						returnInfo.setNFACTU(BigDecimal.ZERO);
						returnInfo.setUSUAIN(inputFormat.getUSUARIO());
						returnInfo.setHORAIN(new BigDecimal((inputFormat.getHORA_MOVIMIENTO())));
						returnInfo.setFECHIN(new BigDecimal(inputFormat.getFECHA_MOVIMIENTO()));
						returnInfo.setSTATIN("F");
						returnInfo.setSTATCV("");
						returnInfo.setINDCT("Y1");
						returnInfo.setVALORU(new BigDecimal(0));
						break;
					case "anulacion":
						returnInfo.setCANVEN(BigDecimal.ZERO);
						returnInfo.setTIPOFA(inputFormat.getFACTURA_DENEGADA());
						returnInfo.setFECHAA(new BigDecimal((inputFormat.getFECHA_REGISTRO())));
						returnInfo.setNFACTU(new BigDecimal(inputFormat.getNUMERO_DOCUMENTO_ORIGINAL()));
						returnInfo.setUSUAIN("");
						returnInfo.setFECHIN(BigDecimal.ZERO);
						returnInfo.setSTATIN("");
						returnInfo.setSTATCV("A");
						returnInfo.setINDCT("Y1");

						break;
					case "devolucion":

						returnInfo.setCANVEN(BigDecimal.ZERO);
						returnInfo.setTIPOFA(inputFormat.getFACTURA_DENEGADA());
						returnInfo.setFECHAA(new BigDecimal((inputFormat.getFECHA_REGISTRO())));
						returnInfo.setNFACTU(new BigDecimal(inputFormat.getNUMERO_DOCUMENTO_ORIGINAL()));
						returnInfo.setUSUAIN(inputFormat.getUSUARIO());
						returnInfo.setHORAIN(new BigDecimal((inputFormat.getHORA_MOVIMIENTO())));
						returnInfo.setFECHIN(new BigDecimal(inputFormat.getFECHA_MOVIMIENTO()));
						returnInfo.setSTATIN("F");
						returnInfo.setSTATCV("");
						returnInfo.setINDCT("");
						break;
					}

					returnInfo.setDESCUE(new BigDecimal(item.getDESCUENTO()));
					returnInfo.setIMPUES(new BigDecimal(item.getIMPUESTO_VENTA()));
					returnInfo.setIMPISC(new BigDecimal(item.getIMPUESTO_ISC()));
					returnInfo.setPRECIO(new BigDecimal(item.getPRECIO()));
					returnInfo.setPRECIOUF(new BigDecimal(item.getPRECIOUSD()));
					returnInfo.setCODMONEDA(item.getCODIGO_MODENA());
					returnInfo.setPREDES(BigDecimal.ZERO);
					returnInfo.setVALORISC(BigDecimal.ZERO);
					returnInfo.setVALORDESCV(BigDecimal.ZERO);
					returnInfo.setVALORDESCI(BigDecimal.ZERO);
					returnInfo.setTFACTU(inputFormat.getTOTAL_ML());
					returnInfo.setTDESCU(inputFormat.getTOTAL_DESCUENTO_ML());
					returnInfo.setTIGV(inputFormat.getTOTAL_IMPIVA_ML());
					returnInfo.setTISC(inputFormat.getTOTAL_IMPISC_ML());
					returnInfo.setTFACTUF(inputFormat.getTOTAL_ME());
					returnInfo.setTDESCUF(inputFormat.getTOTAL_DESCUENTO_ME());
					returnInfo.setTIGVF(inputFormat.getTOTAL_IMPIVA_ME());
					returnInfo.setTISCF(inputFormat.getTOTAL_IMPISC_ME());
					returnInfo.setTCOST1(BigDecimal.ZERO);
					returnInfo.setNOTELF(BigDecimal.ZERO);
					returnInfo.setNLIQUI(item.getCODIGO_MODENA());
					returnInfo.setNPEDID(BigDecimal.ZERO);
					returnInfo.setNBATCV(BigDecimal.ZERO);
					returnInfo.setHORACV(BigDecimal.ZERO);
					returnInfo.setFECHCV(BigDecimal.ZERO);
					returnInfo.setINNUMB(BigDecimal.ZERO);
					returnInfo.setISTAT9("N");
					returnInfo.setHCODPROMO(inputFormat.getCODIGO_PROMOCIONAL());

					outputFormat.add(returnInfo);
				}

			} else {
				throw new Exception("No existen productos a facturar!");
			}
		} catch (Exception e) {
			throw e;
		}
		return outputFormat;

	}

	private Boolean ValidateWorkShopInvoice(FacturaTaller doc) throws Exception {
		Boolean isValid = false;

		try {
			String currentDate = DateTimeHelper.CastDateToString(new Date(), "yyyy-MM-dd");
			// Validar compania, sucursal y linea
			EquivalenciaService eqService = new EquivalenciaService(this.em, this.guid);

			// Validar que los documentos sean del dia
			// No anular facturas que no son del dia
			Date dtMov = DateTimeHelper.CastStringToDate(doc.getFECHA_MOVIMIENTO(), "yyyyMMdd");
			Long diffMov = DateTimeHelper.DateDiff("d", currentDate,
					DateTimeHelper.CastDateToString(dtMov, "yyyy-MM-dd"), "yyyy-MM-dd");
			if (diffMov != 0) {
				throw new Exception("No es posible crear documentos que no sean del dia.");
			}

			InventarioEquivalencia eq = eqService.GetConfigurationRow(doc.getCODIGO_COMPANNIA(),
					doc.getCODIGO_SUCURSAL(), doc.getCODIGO_DEPARTAMENTO());

			if (eq == null) {
				throw new Exception("La configuracion del documento es invalida");
			}

			// Validar el vendedor
			VendedorService vService = new VendedorService(em, this.guid);
			if (!vService.ExistVendor(doc.getCODIGO_COMPANNIA(), doc.getCODIGO_SUCURSAL(),
					Integer.parseInt(doc.getCODIGO_VENDEDOR_L()))) {
				throw new Exception("El codigo del vendedor es invalido");
			}

			// Validar el codigo del cliente siempre y cuando venga en el json
			if (doc.getCODIGO_CLIENTE() != null && doc.getCODIGO_CLIENTE().trim().length() > 0
					&& Integer.parseInt(doc.getCODIGO_CLIENTE().trim()) > 0) {
				ClienteService cService = new ClienteService(em, this.guid);
				if (!cService.ExistCustomer(Integer.parseInt(doc.getCODIGO_CLIENTE().trim()))) {
					throw new Exception("El codigo del cliente es invalido");
				}
			}

			ConfigurationService cfgService = new ConfigurationService(this.em, this.guid);
			TABMUL cfg = cfgService.GetJdeTipoMov(doc.getCODIGO_DEPARTAMENTO());

			if (!doc.getTIPO_MOVIMIENTO().toLowerCase().equals("21")) {
				throw new Exception("El tipo de movimiento es invalido para el tipo de condicion de pago requerido");
			}

			if (cfg == null) {
				throw new Exception("No se encontro la configuracion del tipo de movimiento asociado al JDE");
			}

			if (!cfg.getORDEN().toLowerCase().equals(doc.getTIPO_MOVIMIENTO_JDE().toLowerCase())) {
				throw new Exception(
						"El valor del campo TIPO_MOVIMIENTO_JDE no coincide con el configurado para el movimiento");
			}

			// Validar que la sucursal atienda al taller suministrado
			ConfigurationBI configurationInfo = new ConfigurationBI(em, this.guid);
			List<TABMUL> catalogoBodega = configurationInfo.getVerificarTaller(doc.getCODIGO_SUCURSAL(),
					doc.getCODIGO_TALLER());
			if (catalogoBodega == null) {
				throw new Exception("La bodega no posee el taller");
			}

			// Validar orden Activa
			TallerService taller = new TallerService(em, guid);
			OrdenTrabajo otrabajo = taller.getWorkShopOrder(doc.getCODIGO_COMPANNIA(), doc.getCODIGO_TALLER(),
					Integer.parseInt(doc.getNUMERO_ORDEN()));

			if (otrabajo == null) {
				throw new Exception("La orden de trabajo no esta abierta o no existe");
			}

			// Validar que el tecnico este asociado a la orden
			if (taller.getTechnicianByBranch(doc.getCODIGO_TALLER(),
					Integer.parseInt(doc.getCODIGO_TECNICO())) == null) {
				throw new Exception("El codigo del tecnico no ha podido ser encontrado");
			}
			
			// Validar el detalle de los productos
			if (!ValidateInvoiceDetail(doc.getCODIGO_COMPANNIA(), doc.getCODIGO_SUCURSAL(), doc.getCODIGO_DEPARTAMENTO(), "CREDITO", doc.getProductos())) {
				throw new Exception("No se ha logrado validar los productos del documento");
			}
			

			isValid = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return isValid;
	}

	public List<Invd35> getInvd35FormatTaller(FacturaTaller inputFormat) throws Exception {
		List<Invd35> outputFormat = new ArrayList<Invd35>();

		try {
			if (!ValidateWorkShopInvoice(inputFormat)) {
				throw new Exception("La factura es invalida");
			}

			// Validacion de valores nulos para campos genericos
			if (inputFormat.getNUMERO_DOCUMENTO().length() == 0) {
				throw new Exception("Ingrese el numero de documento");
			}

			for (FacturaDetalle item : inputFormat.getProductos()) {
				Invd35 returnInfo = new Invd35();

				returnInfo.setISTAT4(inputFormat.getMOTIVO_ANULACION());
				returnInfo.setCOMPAN(inputFormat.getCODIGO_COMPANNIA());
				returnInfo.setSUCURS(inputFormat.getCODIGO_SUCURSAL());
				returnInfo.setDEPART(inputFormat.getCODIGO_DEPARTAMENTO());
				returnInfo.setTIPOMO(inputFormat.getTIPO_MOVIMIENTO());
				returnInfo.setTIPOMV(inputFormat.getTIPO_MOVIMIENTO_JDE());
				returnInfo.setBODEGA(item.getCODIGO_BODEGA());
				returnInfo.setDOCUME(new BigDecimal(inputFormat.getNUMERO_DOCUMENTO()));
				returnInfo.setFECHAM(new BigDecimal(inputFormat.getFECHA_MOVIMIENTO()));
				returnInfo.setNPARTE(item.getCODIGO_ARTICULO());
				returnInfo.setISTAT2(item.getCODIGO_CATEGORIA());
				returnInfo.setCOSTUA(new BigDecimal(0));
				returnInfo.setEXISTA(new BigDecimal(0));
				returnInfo.setCANTID(new BigDecimal(item.getCANTIDAD()));
				returnInfo.setCANTIDD(BigDecimal.ZERO);
				returnInfo.setSTATUA(" ");
				returnInfo.setTIPOCA(new BigDecimal(inputFormat.getTIPO_CAMBIO()));
				returnInfo.setREFERE(BigDecimal.ZERO);
				returnInfo.setHORAM(new BigDecimal((inputFormat.getHORA_MOVIMIENTO())));
				returnInfo.setPANTAL("LR");
				returnInfo.setHECHOP(inputFormat.getUSUARIO());
				returnInfo.setNPROGR("LR");
				returnInfo.setVENDED(inputFormat.getCODIGO_VENDEDOR_C());
				returnInfo.setCVCANAL("T");
				returnInfo.setHIID(new BigDecimal(inputFormat.getCODIGO_CLIENTE()));
				returnInfo.setCVENDED(new BigDecimal(inputFormat.getCODIGO_VENDEDOR_L()));
				returnInfo.setCLCLIE(new BigDecimal(inputFormat.getCODIGO_CLIENTE()));
				returnInfo.setCLNOMB(inputFormat.getNOMBRE_CLIENTE());
				returnInfo.setNBATCH(BigDecimal.ZERO);
				returnInfo.setHISECUE(new BigDecimal(item.getSECUENCIA()));

				returnInfo.setCODMONEDA("USD");
				returnInfo.setCANVEN(BigDecimal.ONE);
				returnInfo.setTIPOFA("M");
				returnInfo.setTIPOFD("C");
				returnInfo.setISTAT4("");
				returnInfo.setFECHAA(BigDecimal.ZERO);
				returnInfo.setNFACTU(BigDecimal.ZERO);
				returnInfo.setUSUAIN(inputFormat.getUSUARIO());
				returnInfo.setHORAIN(new BigDecimal((inputFormat.getHORA_MOVIMIENTO())));
				returnInfo.setFECHIN(new BigDecimal(inputFormat.getFECHA_MOVIMIENTO()));
				returnInfo.setSTATIN("F");
				returnInfo.setSTATCV("");
				returnInfo.setINDCT("Y1");

				returnInfo.setVALORU(new BigDecimal(0));
				returnInfo.setDESCUE(new BigDecimal(item.getDESCUENTO()));
				returnInfo.setIMPUES(new BigDecimal(item.getIMPUESTO_VENTA()));
				returnInfo.setIMPISC(new BigDecimal(item.getIMPUESTO_ISC()));
				returnInfo.setPRECIO(new BigDecimal(item.getPRECIO()));
				returnInfo.setPRECIOUF(new BigDecimal(item.getPRECIOUSD()));
				returnInfo.setCODMONEDA(item.getCODIGO_MODENA());
				returnInfo.setPREDES(BigDecimal.ZERO);
				returnInfo.setVALORISC(BigDecimal.ZERO);
				returnInfo.setVALORDESCV(BigDecimal.ZERO);
				returnInfo.setVALORDESCI(BigDecimal.ZERO);
				returnInfo.setTFACTU(inputFormat.getTOTAL_ML());
				returnInfo.setTDESCU(inputFormat.getTOTAL_DESCUENTO_ML());
				returnInfo.setTIGV(inputFormat.getTOTAL_IMPIVA_ML());
				returnInfo.setTISC(inputFormat.getTOTAL_IMPISC_ML());
				returnInfo.setTFACTUF(inputFormat.getTOTAL_ME());
				returnInfo.setTDESCUF(inputFormat.getTOTAL_DESCUENTO_ME());
				returnInfo.setTIGVF(inputFormat.getTOTAL_IMPIVA_ME());
				returnInfo.setTISCF(inputFormat.getTOTAL_IMPISC_ME());
				returnInfo.setTCOST1(BigDecimal.ZERO);
				returnInfo.setNOTELF(BigDecimal.ZERO);
				returnInfo.setNLIQUI(item.getCODIGO_MODENA());
				returnInfo.setNPEDID(BigDecimal.ZERO);
				returnInfo.setNBATCV(BigDecimal.ZERO);
				returnInfo.setHORACV(BigDecimal.ZERO);
				returnInfo.setFECHCV(BigDecimal.ZERO);
				returnInfo.setINNUMB(BigDecimal.ZERO);
				returnInfo.setISTAT9("N");
				returnInfo.setREFERE(new BigDecimal(inputFormat.getNUMERO_ORDEN()));
				returnInfo.setNCAJA(inputFormat.getTIPO_DOCUMENTO_TALLER());
				returnInfo.setTIPOTR(inputFormat.getCODIGO_TALLER());
				returnInfo.setIUSUAR(inputFormat.getCODIGO_TECNICO());
				outputFormat.add(returnInfo);
			}
		} catch (Exception e) {
			throw e;
		}
		return outputFormat;

	}

}
