package ni.com.casapellas.erp.inventario.almacen;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ni.com.casapellas.ejb.erp.inventario.util.SqlQuery;
import ni.com.casapellas.ejb.erp.util.DateTimeHelper;
import ni.com.casapellas.ejb.erp.util.StringHelper;
import ni.com.casapellas.ejb.taller.TallerService;
import ni.com.casapellas.erp.inventario.configuracion.EquivalenciaService;
import ni.com.casapellas.erp.util.AuditLogService;
import ni.com.casapellas.gcpinventario.PedidoEspecialCpd;
import ni.com.casapellas.gcpinventario.PedidoEspecialCpdDetalle;
import ni.com.casapellas.gcpinventario.ProductInfo;
import ni.com.casapellas.gcpinventario.TABMUL;
import ni.com.casapellas.gcptaller.pojo.OrdenTrabajo;
import ni.com.casapellas.rest.erp.inventario.configuracion.ConfigurationService;
import ni.com.casapellas.rest.erp.inventario.configuracion.ContadorService;
import ni.com.casapellas.util.CollectionScheme;

public class PedidoEspecialCpdService {
	EntityManager connection = null;
	String Guid;
	
	public PedidoEspecialCpdService(EntityManager em) {
		this.connection = em;
	}
	
	public PedidoEspecialCpdService(EntityManager em, String uGuid) {
		this.connection = em;
		this.Guid = uGuid;
	}
	
	public String Insert(PedidoEspecialCpd objInput) throws Exception {
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
			
			Integer numericDate = DateTimeHelper.CastDateToNumber(inputDate, "yyyyMMdd");
			Integer numericTime = DateTimeHelper.CastTimeToNumber(inputDate);
			String route = "X*";
			
			// Validar que la combinacion compania, sucursal, departamento exista
			EquivalenciaService eqService = new EquivalenciaService(this.connection, this.Guid);
			
			if (!eqService.IsValidConfiguration(objInput.getCodigoCompania(), objInput.getCodigoSucursal(), objInput.getCodigoDepartamento())) {
				throw new Exception("La configuracion de compania, sucursal y departamento no es valida");
			}
			
			// Validar la orden de talle si vienen los campos
			if (objInput.getNumeroOrden() != null &&  StringHelper.IsNotNullOrEmpty(objInput.getCodigoTaller())) {
				TallerService tallerService = new TallerService(this.connection, this.Guid);
				OrdenTrabajo ot = tallerService.getWorkShopOrder(objInput.getCodigoCompania(), objInput.getCodigoTaller(), objInput.getNumeroOrden());
				
				if (ot == null) {
					throw new Exception("No se encontro la orden de trabajo suministrada o ya fue cerrada");
				}
				
				route = "U";
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
			
			// Obtener la bodega.. TODO: Preguntar que pasa si tiene mas de una bodega. El contador toma en cuenta la bodega
			String tBodega = objInput.getDetalle().get(0).getCodigoBodega();
			
			String[] strDataType = new String[]{
					"String","String","String","String","Number","String","String","Number", 
					"String","Number","String","Number","Number","String","String","String", 
					"Number","String","Number","String","String","String","String", "Number",
					"String", "String"
			};
			
			String[] strValidationRequired = new String[]{
					"S","S","S","S","S","S","S","S", 
					"S","S","S","S","S","S","S","S", 
					"S","S","S","S","S","S","S","S",
					"S", "S"
			};
			
			ContadorService contador = new ContadorService(connection, this.Guid);
			Integer sequence = contador.getNextCounterValue(objInput.getCodigoCompania(), objInput.getCodigoSucursal(), tBodega, "PE");
			
			result = sequence.toString();
			
			strQuery = "INSERT INTO " + CollectionScheme.SchemeInventario + ".INVPEDS("
					+ "COMPAO, SUCURO, DEPARO, BODEGO, PEDSUC, TIPOTR, SUCDES, FECHAM, NPARTE, CANTID, PEUNIMED, "
					+ "CEXIST, CEXIST1, CCATEG, URGENTE, MOTIVO, SECUEN, STATUS, HORAM, PANTAL, HECHOP, NPROGR, NDOCUM, NCLCLIE, DEPART, RUTARE)";		
			
			ProductoService productoService = new ProductoService(connection, this.Guid);
			
			ConfigurationService cfgService = new ConfigurationService(connection, this.Guid);
			TABMUL cfg = cfgService.GetCpdConfiguration();
			String cpdBranch = cfg != null ? cfg.getCODIDE().trim() : "";
			
			Integer noLinea = 1;
			
			for (Iterator<PedidoEspecialCpdDetalle> iterator = objInput.getDetalle().iterator(); iterator.hasNext();) {
				PedidoEspecialCpdDetalle detItem = (PedidoEspecialCpdDetalle) iterator.next();
				
				ProductInfo pInfo = productoService.getProductInfo(objInput.getCodigoCompania(), objInput.getCodigoSucursal(), detItem.getCodigoBodega(), detItem.getCodigoArticulo());
				BigDecimal cpdExistencia = new BigDecimal(0);
				
				if (pInfo == null) {
					throw new Exception("El producto " + detItem.getCodigoArticulo() + " no ha podido ser encontrado");
				}
				
				if (!cpdBranch.equals("")) {
					cpdExistencia = productoService.getAVailableBranchStock(objInput.getCodigoCompania(), objInput.getCodigoDepartamento(), cpdBranch, detItem.getCodigoArticulo());
				}
				
				String[] strValues = new String[]{
						objInput.getCodigoCompania(), objInput.getCodigoSucursal(), objInput.getCodigoDepartamento(), detItem.getCodigoBodega(),
						sequence.toString(), "PE", objInput.getCodigoSucDestino(), numericDate.toString(), detItem.getCodigoArticulo(), detItem.getCantidad().toString(),
						pInfo.getUnidadMedida(), pInfo.getExistenciaNacional().toString(), cpdExistencia.toString(), pInfo.getCodigoCategoria(), 
						!objInput.getEsUrgente() ? "N" : "S", objInput.getMotivo(), noLinea.toString(),
						"", numericTime.toString(), "LSR", objInput.getUsuario(), "LSRWS", sequence.toString(), objInput.getCodigoCliente().toString(),
						objInput.getCodigoDepartamento(), route
				};
				
				String strValuesInsert =  sq.BodyValuesInsert(strValues, strValidationRequired, strDataType);
				
				String tmpQuery = strQuery + " " + strValuesInsert;
				
				q = this.connection.createNativeQuery(tmpQuery);
				sq.QueryParameterValue(q, strValues, strValidationRequired, strDataType);
				
				AuditLogService.SaveLogDetail("Insert",tmpQuery,Guid);
				
				q.executeUpdate();
				
				noLinea ++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al crear el pedido al CPD: " + e.getMessage());
		}
		
		return result;
	}
}
