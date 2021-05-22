package ni.com.casapellas.erp.inventario.almacen;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ni.com.casapellas.ejb.erp.inventario.util.SqlQuery;
import ni.com.casapellas.ejb.erp.util.DateTimeHelper;
import ni.com.casapellas.erp.cliente.ClienteService;
import ni.com.casapellas.erp.inventario.configuracion.EquivalenciaService;
import ni.com.casapellas.erp.util.AuditLogService;
import ni.com.casapellas.erp.util.CustomInventory;
import ni.com.casapellas.gcpinventario.ConsultaPedidoCallCenter;
import ni.com.casapellas.gcpinventario.InvExistGlobal;
import ni.com.casapellas.gcpinventario.PedidoContactCenter;
import ni.com.casapellas.gcpinventario.PedidoContactCenterDetail;
import ni.com.casapellas.gcpinventario.ProductInfo;
import ni.com.casapellas.gcpinventario.RecoleccionArticulo;
import ni.com.casapellas.rest.erp.inventario.configuracion.ContadorService;
import ni.com.casapellas.util.CollectionScheme;

public class PedidoContactCenterService {
	EntityManager connection = null;
	String Guid;
	/**
	 * 
	 */
	public PedidoContactCenterService(EntityManager em,String GuidMaster) {
		this.connection = em;
		this.Guid = GuidMaster;
	}
	
	public PedidoContactCenterService(EntityManager em) {
		this.connection = em;
	}
	
	public String Insert(PedidoContactCenter objInput) throws Exception {
		SqlQuery sq = new SqlQuery();
		Query q = null;
		String strQuery = "";
		String result = "success";
		
		try {
			String currentDate = DateTimeHelper.CastDateToString(new Date(), "yyyy-MM-dd");
			Date inputDate = DateTimeHelper.CastStringToDate(objInput.getFecha(), "yyyy-MM-dd HH:mm:ss");
			
			// Validar que el pedido sea del dia
			Long diff = DateTimeHelper.DateDiff("d", currentDate, DateTimeHelper.CastDateToString(inputDate, "yyyy-MM-dd"), "yyyy-MM-dd");
			if (diff != 0) {
				throw new Exception("La fecha es invalida. No corresponde a la fecha actual.");
			}
			
			if (objInput.getDetalle() == null || objInput.getDetalle().size() <= 0) {
				throw new Exception("No existen articulos para procesar");
			}
			
			if (!ValidateEntity(objInput)) {
				throw new Exception("No se han logrado validar la entidad");
			}
			
			if (!ValidateProducts(objInput)) {
				throw new Exception("No se han logrado validar los productos");
			}

			// Obtener el numero
			String[] strDataType = new String[]{
					"String", "String", "Number", "Number", "Number", 
					"String", "String", "String", "String", "Number", 
					"Number", "String", "Number", "Number", "String", 
					"String", "String"
			};
			
			Integer numericDate = DateTimeHelper.CastDateToNumber(inputDate, "yyyyMMdd");
			Integer numericTime = DateTimeHelper.CastTimeToNumber(inputDate);
			Integer numItems = (objInput.getDetalle() == null) ? 0 : objInput.getDetalle().size();
			
			ContadorService contador = new ContadorService(connection, this.Guid);
			
			String counterBodega = objInput.getDetalle().get(0).getCodigoBodega();
			
			Integer sequence = contador.getNextCounterValue(objInput.getCodigoCompania(), objInput.getCodigoSucursal(), counterBodega, "RC");
			
			String[] strValues = new String[]{
					objInput.getCodigoCompania(), objInput.getCodigoSucursal(), sequence.toString(), objInput.getNumeroProforma().toString(),
					objInput.getCodigoCliente().toString(), objInput.getNombreCliente(), objInput.getDireccionCliente(), objInput.getCodigoVendedorC(),
					objInput.getCondicionPago(), objInput.getPorcentajeImpuesto().toString(), numItems.toString().toString(), "R",
					numericDate.toString(), numericTime.toString(), "LSR", objInput.getUsuario(), "LSRWS"
			};
			
			String[] strValidationRequired = new String[]{
					"S", "S", "S", "S", "S", 
					"S", "S", "S", "S", "S", 
					"S", "S", "S", "S", "S", 
					"S", "S"
			};
			
			String strValuesInsert =  sq.BodyValuesInsert(strValues, strValidationRequired, strDataType);
			
			// Hacer el insert en la cabecera
			strQuery = "INSERT INTO " + CollectionScheme.SchemeInventario + ".INVD44("
						+ "RCCOMP, RCSUCU, RCPEDI, RCPROF, RCCLIE, RCNOMBRE, RCDIRECCIO, RCVEND, "
						+ "RCCOND, RCXIGV, RCLINS, RCSTAT, RCFECM1, RCHORA1, RCPANT1, RCHECH1, RCPROG1)";
			
			strQuery = strQuery + " " + strValuesInsert;
			
			q = this.connection.createNativeQuery(strQuery);
			sq.QueryParameterValue(q, strValues, strValidationRequired, strDataType);
			
			AuditLogService.SaveLogDetail("Insert",strQuery,Guid);
			
			q.executeUpdate();
			

			// Hacer el insert en el detalle
			strDataType = new String[]{
					"String", "String", "String", "String", "Number", "Number",
					"Number", "String", "String", "Number", "Number", "String",
					"Number", "Number", "Number", "String", "Number", "Number",
					"String", "Number", "Number", "String", "String", "String"
			};
			
			strValidationRequired = new String[]{
					"S", "S", "S", "S", "S", "S",
					"S", "S", "S", "S", "S", "S",
					"S", "S", "S", "S", "S", "S",
					"S", "S", "S", "S", "S", "S"
			};
			
			ProductoService productoService = new ProductoService(connection, this.Guid);
			Integer noLinea = 1;
			
			for (Iterator<PedidoContactCenterDetail> item = objInput.getDetalle().iterator(); item.hasNext();) {
				PedidoContactCenterDetail detItems = item.next();
				
				// Obtener la info del producto
				ProductInfo pInfo = productoService.getProductInfo(objInput.getCodigoCompania(), objInput.getCodigoSucursal(), detItems.getCodigoBodega(), detItems.getCodigoArticulo());
				
				if (pInfo == null) {
					throw new Exception("El producto " + detItems.getCodigoArticulo() + " no ha podido ser encontrado");
				}
				
				strQuery = "INSERT INTO " + CollectionScheme.SchemeInventario + ".INVD45(RCCOMP, RCSUCU, RCDEPA, RCBODE, RCPEDI, RCPROF, RCLINEA, "
						+ "RCPART, RCUBIC, RCCANP, RCCANP1, RCUNIMEDR, RCXIGV, RCPREC, RCXDES, RCMONEDA, RCTASA, "
						+ "RCCOST, RCSTAL, RCFECHAM, RCHORAM, RCPANTAL, RCHECHOP, RCNPROGR)";
				
				strValues = new String[]{
						objInput.getCodigoCompania(), objInput.getCodigoSucursal(), detItems.getCodigoLinea(), detItems.getCodigoBodega(),
						sequence.toString(), objInput.getNumeroProforma().toString(), noLinea.toString(), detItems.getCodigoArticulo(),
						pInfo.getUbicacion(), detItems.getCantidad().toString(), detItems.getCantidad().toString(),  pInfo.getUnidadMedida(), pInfo.getIva().toString(),
						Double.toString(detItems.getPrecio()), Double.toString(detItems.getDescuento()), objInput.getMoneda(), objInput.getFactorCambio().toString(), 
						pInfo.getCosto().toString(), "R", numericDate.toString(), numericTime.toString(), "LSR", objInput.getUsuario(), "LSRWS"
				};
				
				strValuesInsert =  sq.BodyValuesInsert(strValues, strValidationRequired, strDataType);
				
				strQuery = strQuery + " " + strValuesInsert;
				
				q = this.connection.createNativeQuery(strQuery);
				sq.QueryParameterValue(q, strValues, strValidationRequired, strDataType);
				
				AuditLogService.SaveLogDetail("Insert",strQuery,Guid);
				
				q.executeUpdate();

				// Actualizar las cantidades en reserva en las tablas correspondiente
				switch (pInfo.getArchivoExistencia()) {
				case "INVD01":
					strQuery = "UPDATE " + CollectionScheme.SchemeInventario + ".INVD01 SET ICAV01 = (ICAV01 + ?1) "
								+ "WHERE ICOMPAN = ?2 AND INOPAR = ?3 AND ILINEA = ?4";
					q = this.connection.createNativeQuery(strQuery);
					q.setParameter(1, detItems.getCantidad());
					q.setParameter(2, objInput.getCodigoCompania());
					q.setParameter(3, detItems.getCodigoArticulo());
					q.setParameter(4, pInfo.getCodigoLinea());
					break;
				case "INVV01":
					strQuery = "UPDATE " + CollectionScheme.SchemeInventario + ".INVV01 SET ICAV01 = (ICAV01 + ?1) "
							+ "WHERE ICOMPAN = ?2 AND INOPAR = ?3 AND ILINEA = ?4";
					q = this.connection.createNativeQuery(strQuery);
					q.setParameter(1, detItems.getCantidad());
					q.setParameter(2, objInput.getCodigoCompania());
					q.setParameter(3, detItems.getCodigoArticulo());
					q.setParameter(4, pInfo.getCodigoLinea());
					break;
				case "INVD02":
					strQuery = "UPDATE " + CollectionScheme.SchemeInventario + ".INVD02 SET SCANR00 = (SCANR00 + ?1) "
							+ "WHERE SCOMPAN = ?2 AND SSUCURS = ?3 AND SINOPAR = ?4 AND SDEPART = ?5";
					q = this.connection.createNativeQuery(strQuery);
					q.setParameter(1, detItems.getCantidad());
					q.setParameter(2, objInput.getCodigoCompania());
					q.setParameter(3, objInput.getCodigoSucursal());
					q.setParameter(4, detItems.getCodigoArticulo());
					q.setParameter(5, pInfo.getCodigoLinea().trim());
					break;
				case "INVD03":
					strQuery = "UPDATE " + CollectionScheme.SchemeInventario + ".INVD03 SET BCANRESER = (BCANRESER + ?1) "
							+ "WHERE BCOMPAN = ?2 AND BSUCURS = ?3 AND BBODEGA = ?4 AND BINOPAR = ?5 AND BDEPART = ?6";
					q = this.connection.createNativeQuery(strQuery);
					q.setParameter(1, detItems.getCantidad());
					q.setParameter(2, objInput.getCodigoCompania());
					q.setParameter(3, objInput.getCodigoSucursal());
					q.setParameter(4, detItems.getCodigoBodega());
					q.setParameter(5, detItems.getCodigoArticulo());
					q.setParameter(6, pInfo.getCodigoLinea().trim());
					break;
				default:
					break;
				}
				
				AuditLogService.SaveLogDetail("Insert",strQuery,Guid);
				
				q.executeUpdate();

				noLinea++;
			}
			
			// Insertar en INVD76
			RecoleccionArticuloService recArticuloService = new RecoleccionArticuloService(this.connection, this.Guid);
			
			//Verificar las bodegas que vienen
			List<String> bodegas = objInput.getDetalle().stream()
					.collect(Collectors.groupingBy(x -> x.getCodigoBodega() , Collectors.counting()))
					.entrySet().stream()
					.map(m -> m.getKey()).collect(Collectors.toList());
			
			for (Iterator<String> iterator = bodegas.iterator(); iterator.hasNext();) {
				String bodega = (String) iterator.next();
				
				RecoleccionArticulo entity = new RecoleccionArticulo(
						objInput.getCodigoCompania(), 
						objInput.getCodigoSucursal(), 
						bodega, 
						"RC", 
						new BigDecimal(sequence),
						new BigDecimal(numericDate), 
						new BigDecimal(numericTime), 
						"LSR", 
						"LSRWS", 
						objInput.getUsuario()
						);
				
				recArticuloService.Insert(entity);
			}
			
			result = sequence.toString();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al crear el pedido al contact center" + e.getMessage());
		}

		return result;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ConsultaPedidoCallCenter> GetConfirmedOrders(String pCompany, String pBranch) throws Exception {
		List<ConsultaPedidoCallCenter> result = null;
		Query q = null;
		String strQuery = "";
		
		try {
			strQuery = "SELECT "
					+ "    RCCOMP AS CODIGOCOMPANIA, " 
					+ "    RCSUCU AS CODIGOSUCURSAL, " 
					+ "    RCPEDI AS NUMEROPEDIDO, " 
					+ "    RCPROF AS NUMEROPROFORMA, "
					+ "    VARCHAR_FORMAT(TIMESTAMP_FORMAT(CAST(RCFECM1 AS VARCHAR(8)), 'YYYYMMDD'),'YYYY-MM-DD') AS FECHA, " 
					+ "    RCBODE AS CODIGOBODEGA, " 
					+ "    RCCLIE AS CODIGOCLIENTE, " 
					+ "    RCNOMBRE AS NOMBRECLIENTE, " 
					+ "    RCDIRECCIO AS DIRECCION, " 
					+ "    RCVEND AS CODIGOVENDEDOR, " 
					+ "    RCCOND AS CONDICIONPAGO, " 
					+ "    RCOBSE AS OBSERVACIONES " 
					+ "FROM " 
					+ "    " + CollectionScheme.SchemeInventario + ".INVD44 " 
					+ "WHERE " 
					+ "    RCCOMP = ?1 AND RCSUCU = ?2 AND RCSTAT = 'C'";
			
			q = this.connection.createNativeQuery(strQuery, ConsultaPedidoCallCenter.class);
			q.setParameter(1, pCompany);
			q.setParameter(2, pBranch);
			
			AuditLogService.SaveLogDetail("GetConfirmedOrders",strQuery,Guid);
			
			result = (List<ConsultaPedidoCallCenter>)q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al consultar los pedidos al contact center" + e.getMessage());
		}
		
		return result;
	}
	
	private Boolean ValidateEntity(PedidoContactCenter objInput) throws Exception {
		Boolean IsValid = false;
		EquivalenciaService eqService = null;
		ClienteService clService = null;
		
		try {
			// Validar la compania y la sucursal
			eqService = new EquivalenciaService(this.connection, this.Guid);
			
			if (!eqService.IsValidConfiguration(objInput.getCodigoCompania(), objInput.getCodigoSucursal(), objInput.getCodigoDepartamento())) {
				throw new Exception("La configuracion de compania, sucursal y departamento no es valida");
			}
			
			// Validar que el cliente sea valido
			clService = new ClienteService(this.connection, this.Guid);
			if (!clService.ExistCustomer(objInput.getCodigoCliente())) {
				throw new Exception("El cliente suministrado no es valido");
			}
			
			// Validar la bodega que solo pueda venir una
			List<String> uniqueWarehouse = objInput.getDetalle().stream()
					.collect(Collectors.groupingBy(x -> x.getCodigoBodega(), Collectors.counting()))
					.entrySet().stream()
					//.filter(entry -> entry.getValue() > 1)
					.map(m -> m.getKey()).collect(Collectors.toList());
			
			if (uniqueWarehouse != null && uniqueWarehouse.size() > 1) {
				throw new Exception("El pedido tiene mas de una bodega asociada");
			}
			
			IsValid = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			eqService = null;
		}
		
		
		
		return IsValid;
	}
	
	private Boolean ValidateProducts(PedidoContactCenter objInput) throws Exception {
		Boolean isValid = false;
		
		try {
			List<CustomInventory> customInventory = new ArrayList<CustomInventory>();
			// Agrupar los items para validarlos.
			Map<List<String>, Double> map = objInput.getDetalle().stream()
					.collect(Collectors.groupingBy(x -> new ArrayList<String>(Arrays.asList(x.getCodigoArticulo(), x.getCodigoBodega())), 
							Collectors.summingDouble(x -> x.getCantidad().doubleValue())));
			
			map.forEach((k,v) -> {
				customInventory.add(
						new CustomInventory(
								k.get(0),
								k.get(1), 
								BigDecimal.valueOf(v)
								)
						);
			});
			
			// Verificar si existe el producto y si las cantidades no sobregiran el inventario antes de hacer cualquier insercion
			List<String> uniqueCodes = objInput.getDetalle().stream()
					.collect(Collectors.groupingBy(x -> x.getCodigoArticulo(), Collectors.counting()))
					.entrySet().stream()
					//.filter(entry -> entry.getValue() == 1)
					.map(m -> m.getKey()).collect(Collectors.toList());
			
			ProductoService productoService = new ProductoService(connection, this.Guid);
			
			List<InvExistGlobal> global = productoService.getProductExistenceTotal(
					objInput.getCodigoCompania(), 
					objInput.getCodigoSucursal(), objInput.getCodigoDepartamento(), uniqueCodes);
			
			if (global == null || global.size() <= 0) {
				throw new Exception("No se ha logrado validar los productos");
			}
			
			String message = "";
			
			for (Iterator<CustomInventory> iterator = customInventory.iterator(); iterator.hasNext();) {
				CustomInventory v = iterator.next();
				List<InvExistGlobal> filterResult = global.stream()
						.filter(f -> f.getArticulo().trim().equals(v.getArticulo().trim()) && f.getBodega().trim().equals(v.getBodega().trim()))
						.collect(Collectors.toList());
				
				if (filterResult == null || filterResult.size() <= 0) {
					message = "No se encontro el producto " + v.getArticulo();
					break;
				}
				
				int bdRes = filterResult.get(0).getExistencia().compareTo(v.getCantidad());
				
				if (bdRes == -1) {
					message = "No existen suficiente existencias del producto " + v.getArticulo();
					break;
				}
			}
			
			if (message.trim().length() > 0) {
				throw new Exception(message);
			}
			
			isValid = true;

		} catch (Exception ex) {
			throw ex;
		}
		
		return isValid;
	}
	
}
