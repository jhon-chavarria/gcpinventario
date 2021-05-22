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
import ni.com.casapellas.ejb.erp.util.StringHelper;
import ni.com.casapellas.erp.cliente.ClienteService;
import ni.com.casapellas.erp.inventario.configuracion.EquivalenciaService;
import ni.com.casapellas.erp.util.AuditLogService;
import ni.com.casapellas.erp.util.CustomInventory;
import ni.com.casapellas.gcpinventario.InvExistGlobal;
import ni.com.casapellas.gcpinventario.PedidoReservacion;
import ni.com.casapellas.gcpinventario.PedidoReservacionDetalle;
import ni.com.casapellas.gcpinventario.ProductInfo;
import ni.com.casapellas.gcpinventario.TABMUL;
import ni.com.casapellas.rest.erp.inventario.configuracion.ConfigurationService;
import ni.com.casapellas.rest.erp.inventario.configuracion.ContadorService;
import ni.com.casapellas.util.CollectionScheme;

public class PedidoReservacionService {
	EntityManager connection = null;
	String Guid;

	/**
	 * 
	 */
	public PedidoReservacionService(EntityManager em) {
		this.connection = em;
	}
	
	public PedidoReservacionService(EntityManager em, String uGuid) {
		this.connection = em;
		this.Guid = uGuid;
	}
	
	public String Insert(PedidoReservacion objInput) throws Exception {
		SqlQuery sq = new SqlQuery();
		Query q = null;
		String strQuery = "";
		String result = "success";
		
		try {
			Date inputDate = DateTimeHelper.CastStringToDate(objInput.getFecha(), "yyyy-MM-dd hh:mm:ss");
			String currentDate = DateTimeHelper.CastDateToString(new Date(), "yyyy-MM-dd");
			
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
				
			String tBodega = objInput.getDetalle().get(0).getCodigoBodega();
			
			String[] strDataType = new String[]{
					"String","String","String","String","Number","Number","String","String","Number", 
					"Number","Number","String","Number","String","String","String","Number","String", 
					"String","String", "String", "Date"
			};
			
			String[] strValidationRequired = new String[]{
					"S","S","S","S","S","S","S","S","S", 
					"S","S","S","S","S","S","S","S","S", 
					"S","S", "S", "S"
			};
			
			Integer validityDay = 30;
			ConfigurationService cfgService = new ConfigurationService(connection, this.Guid);
			TABMUL cfg = cfgService.GetReservationValidity("01"); // Vencimiento Normal
			
			if (cfg != null) {
				validityDay = StringHelper.convertToInteger(cfg.getOTROS());
			}
			
			Integer numericDate = DateTimeHelper.CastDateToNumber(inputDate, "yyyyMMdd");
			Integer numericTime = DateTimeHelper.CastTimeToNumber(inputDate);
			String expirationDate = DateTimeHelper.CastDateToString(DateTimeHelper.AddDatePartToDate(inputDate, "d", validityDay), "yyyy-MM-dd");
			
			ContadorService contador = new ContadorService(connection, this.Guid);
			
			Integer sequence = contador.getNextCounterValue(objInput.getCodigoCompania(), objInput.getCodigoSucursal(), tBodega, "RE");
			
			strQuery = "INSERT INTO " + CollectionScheme.SchemeInventario + ".INVD38("
					+ "COMPAN, SUCURS, DEPART, BODEGA, DOCUME, FECHAM, NPARTE, DESCRI, CANRES, CANRLO, RSCANTIDR, VENDED, "
					+ "CLIENT, CLNOMB, MOTIVO, STSRES, HORAM, PANTAL, HECHOP, NPROGR, NATURA, INVFECVEN)";
			
			ProductoService productoService = new ProductoService(connection);
			
			Integer noLinea = 1;
			
			for (Iterator<PedidoReservacionDetalle> iterator = objInput.getDetalle().iterator(); iterator.hasNext();) {
				PedidoReservacionDetalle detItem = (PedidoReservacionDetalle) iterator.next();
				
				ProductInfo pInfo = productoService.getProductInfo(objInput.getCodigoCompania(), objInput.getCodigoSucursal(), detItem.getCodigoBodega(), detItem.getCodigoArticulo());
				
				if (pInfo == null) {
					throw new Exception("El producto " + detItem.getCodigoArticulo() + " no ha podido ser encontrado");
				}
				
				String[] strValues = new String[]{
						objInput.getCodigoCompania(), objInput.getCodigoSucursal(), objInput.getCodigoDepartamento(), detItem.getCodigoBodega(),
						sequence.toString(), numericDate.toString(), detItem.getCodigoArticulo(), pInfo.getDescripcion(), detItem.getCantidad().toString(),
						detItem.getCantidad().toString(), detItem.getCantidad().toString(), objInput.getCodigoVendedorC(), objInput.getCodigoCliente().toString(), objInput.getNombreCliente(),
						objInput.getMotivo(), "R", numericTime.toString(), "LSR", objInput.getUsuario(), "INV618", "O", expirationDate
				};
				
				String strValuesInsert =  sq.BodyValuesInsert(strValues, strValidationRequired, strDataType);
				
				String tmpQuery = strQuery + " " + strValuesInsert;
				
				AuditLogService.SaveLogDetail("Insert",tmpQuery,Guid);
				
				q = this.connection.createNativeQuery(tmpQuery);
				sq.QueryParameterValue(q, strValues, strValidationRequired, strDataType);
				q.executeUpdate();
				
				// Actualizar las cantidades en reserva en las tablas correspondiente
				String strQueryUpdate = "";
				
				switch (pInfo.getArchivoExistencia()) {
				case "INVD01":
					strQueryUpdate = "UPDATE " + CollectionScheme.SchemeInventario + ".INVD01 SET ICAV01 = (ICAV01 + ?1) "
								+ "WHERE ICOMPAN = ?2 AND INOPAR = ?3 AND ILINEA = ?4";
					q = this.connection.createNativeQuery(strQueryUpdate);
					q.setParameter(1, detItem.getCantidad());
					q.setParameter(2, objInput.getCodigoCompania());
					q.setParameter(3, detItem.getCodigoArticulo());
					q.setParameter(4, pInfo.getCodigoLinea());
					break;
				case "INVV01":
					strQueryUpdate = "UPDATE " + CollectionScheme.SchemeInventario + ".INVV01 SET ICAV01 = (ICAV01 + ?1) "
							+ "WHERE ICOMPAN = ?2 AND INOPAR = ?3 AND ILINEA = ?4";
					q = this.connection.createNativeQuery(strQueryUpdate);
					q.setParameter(1, detItem.getCantidad());
					q.setParameter(2, objInput.getCodigoCompania());
					q.setParameter(3, detItem.getCodigoArticulo());
					q.setParameter(4, pInfo.getCodigoLinea());
					break;
				case "INVD02":
					strQueryUpdate = "UPDATE " + CollectionScheme.SchemeInventario + ".INVD02 SET SCANR00 = (SCANR00 + ?1) "
							+ "WHERE SCOMPAN = ?2 AND SSUCURS = ?3 AND SINOPAR = ?4 AND SDEPART = ?5";
					q = this.connection.createNativeQuery(strQueryUpdate);
					q.setParameter(1, detItem.getCantidad());
					q.setParameter(2, objInput.getCodigoCompania());
					q.setParameter(3, objInput.getCodigoSucursal());
					q.setParameter(4, detItem.getCodigoArticulo());
					q.setParameter(5, pInfo.getCodigoLinea().trim());
					break;
				case "INVD03":
					strQueryUpdate = "UPDATE " + CollectionScheme.SchemeInventario + ".INVD03 SET BCANRESER = (BCANRESER + ?1) "
							+ "WHERE BCOMPAN = ?2 AND BSUCURS = ?3 AND BBODEGA = ?4 AND BINOPAR = ?5 AND BDEPART = ?6";
					q = this.connection.createNativeQuery(strQueryUpdate);
					q.setParameter(1, detItem.getCantidad());
					q.setParameter(2, objInput.getCodigoCompania());
					q.setParameter(3, objInput.getCodigoSucursal());
					q.setParameter(4, detItem.getCodigoBodega());
					q.setParameter(5, detItem.getCodigoArticulo());
					q.setParameter(6, pInfo.getCodigoLinea().trim());
					break;
				default:
					break;
				}
				
				AuditLogService.SaveLogDetail("Insert",strQueryUpdate,Guid);
				
				q.executeUpdate();
				
				noLinea ++;
				
			}
			
			result = sequence.toString();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("No se ha podido crear la reservacion " + e.getMessage());
		}
		
		return result;
	}
	
	private Boolean ValidateEntity(PedidoReservacion objInput) throws Exception {
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
			clService = new ClienteService(this.connection);
			if (!clService.ExistCustomer(objInput.getCodigoCliente())) {
				throw new Exception("El cliente suministrado no es valido");
			}
			
			// Validar que solo venga una bodega
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
	
	private Boolean ValidateProducts(PedidoReservacion objInput) throws Exception {
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
