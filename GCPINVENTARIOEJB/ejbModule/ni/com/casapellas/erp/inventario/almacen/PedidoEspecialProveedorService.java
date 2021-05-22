package ni.com.casapellas.erp.inventario.almacen;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ni.com.casapellas.ejb.erp.inventario.util.SqlQuery;
import ni.com.casapellas.ejb.erp.util.DateTimeHelper;
import ni.com.casapellas.erp.cliente.ClienteService;
import ni.com.casapellas.erp.inventario.configuracion.EquivalenciaService;
import ni.com.casapellas.erp.util.AuditLogService;
import ni.com.casapellas.gcpinventario.PedidoEspecialProveedor;
import ni.com.casapellas.gcpinventario.PedidoEspecialProveedorDetalle;
import ni.com.casapellas.gcpinventario.ConsultaPedidoConfirmado;
import ni.com.casapellas.gcpinventario.ConsultaPedidoEspecialProveedor;
import ni.com.casapellas.gcpinventario.ConsultaPedidoTransito;
import ni.com.casapellas.gcpinventario.ProductInfo;
import ni.com.casapellas.rest.erp.inventario.configuracion.ContadorService;
import ni.com.casapellas.util.CollectionScheme;

public class PedidoEspecialProveedorService {
	EntityManager connection = null;
	String Guid;
	/**
	 * 
	 */
	public PedidoEspecialProveedorService(EntityManager em) {
		this.connection = em;
	}
	
	public PedidoEspecialProveedorService(EntityManager em, String GuidMaster) {
		this.connection = em;
		this.Guid = GuidMaster;
	}
	
	public String Insert(PedidoEspecialProveedor objInput) throws Exception {
		SqlQuery sq = new SqlQuery();
		Query q = null;
		String strQuery = "";
		String result = "success";
		
		try {
			if (objInput.getDetalle() == null || objInput.getDetalle().size() <= 0) {
				throw new Exception("No existen articulos para procesar");
			}
			
			if (!ValidateEntity(objInput)) {
				throw new Exception("No se han logrado validar la entidad");
			}
			
			String[] strDataType = new String[]{
					"String","String","String","String","Number","Number","String","String","Number","Number", 
					"String","Number","String","String","Number","Number","Number","String","String","Number", 
					"String","String","String","String","String","String","String"
			};
			
			String[] strValidationRequired = new String[]{
					"S","S","S","S","S","S","S","S","S","S", 
					"S","S","S","S","S","S","S","S","S","S", 
					"S","S","S","S","S","S","S"
			};
			
			Date inputDate = DateTimeHelper.CastStringToDate(objInput.getFecha(), "yyyy-MM-dd hh:mm:ss");
			Integer numericDate = DateTimeHelper.CastDateToNumber(inputDate, "yyyyMMdd");
			Integer numericTime = DateTimeHelper.CastTimeToNumber(inputDate);
			
			ContadorService contador = new ContadorService(connection, this.Guid);
			
			Integer sequence = contador.getNextCounterValue(objInput.getCodigoCompania(), objInput.getCodigoSucursal(), "", "PI");
			
			strQuery = "INSERT INTO " + CollectionScheme.SchemeInventario + ".INVD34("
					+ "COMPAN, SUCURS, DEPART, BODEGA, PEDIDO, FECHAM, NPARTE, DESCRI, CANPED, QPRFOB, VENDED, CLIENT, CLNOMB, MOTIVO, "
					+ "CANEXI, CANTRA, CAPEDI, HECHOP, PANTAL, HORAM, NPROGR, CHASIS, MODELO, FORMPA, MODENT, CATEGO, TITRAN)";
			
			ProductoService productoService = new ProductoService(connection, this.Guid);
			
			Integer noLinea = 1;
			result = sequence.toString();
			
			for (Iterator<PedidoEspecialProveedorDetalle> iterator = objInput.getDetalle().iterator(); iterator.hasNext();) {
				PedidoEspecialProveedorDetalle detItem = iterator.next();
				
				ProductInfo pInfo = productoService.getProductInfo(objInput.getCodigoCompania(), objInput.getCodigoSucursal(), detItem.getCodigoBodega(), detItem.getCodigoArticulo());
				
				if (pInfo == null) {
					throw new Exception("El producto " + detItem.getCodigoArticulo() + " no ha podido ser encontrado");
				}
				
				//TODO: El precio de donde los vamos a sacar(QPRFOB), existencias en transito como se obtiene(CANTRA)
				String[] strValues = new String[]{
						objInput.getCodigoCompania(), objInput.getCodigoSucursal(), objInput.getCodigoDepartamento(), detItem.getCodigoBodega(),
						sequence.toString(), numericDate.toString(), detItem.getCodigoArticulo(), pInfo.getDescripcion(), detItem.getCantidad().toString(),
						pInfo.getPrecioFob().toString(), objInput.getCodigoVendedorC(), objInput.getCodigoCliente().toString(), objInput.getNombreCliente(), objInput.getMotivo(),
						pInfo.getExistenciaNacional().toString(), "0", detItem.getCantidad().toString(), objInput.getUsuario(), "LSR", numericTime.toString(),
						"LSRWS", objInput.getChassis(), objInput.getModelo(), objInput.getFormaPago(), objInput.getModalidadEntrega(), pInfo.getCodigoCategoria(),
						objInput.getTipoTransporte()
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
			throw new Exception("Error al crear el pedido al proveedor " + e.getMessage());
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<ConsultaPedidoTransito> getOrderInTransit(String pCompania, String pArticulo) {
		Query q = null;
		String strQuery = "";
		List<ConsultaPedidoTransito> result = null;
		
		try {
			strQuery = "SELECT " 
						+ "    INV.COMPAN AS codigoCompania, "
						+ "    COM.DESCRI AS nombreCompania, "
						+ "    INV.SUCURS AS codigoSucursal, "
						+ "    SUC.DESCRI AS nombreSucursal, "
						+ "    INV.DEPART AS codigoDepartamento, "
						+ "    INV.BODEGA AS codigoBodega, "
						+ "    INV.NPEDID AS noDocumento, "
						+ "    INV.PCODPROV AS codigoProveedor, "
						+ "    COALESCE(AB.ABALPH, 'N/D') AS nombreProveedor, "
						+ "    CASE WHEN INV.FECPED = 0 THEN 'N/D' ELSE SUBSTR(INV.FECPED, 1, 4) || '-' || SUBSTR(INV.FECPED, 5, 2) || '-' || SUBSTR(INV.FECPED, 7, 2) END AS fechaPedido, "
						+ "    INV.NPARTE AS codigoArticulo, "
						+ "    INV.DESCRI AS nombreArticulo, "
						+ "    (INV.CANPED - INV.CANREC) AS cantidadPedida, "
						+ "    INV.MOTIVO AS motivo, "
						+ "    CASE WHEN INV.FECLLE = 0 THEN 'N/D' ELSE SUBSTR(INV.FECLLE, 1, 4) || '-' || SUBSTR(INV.FECLLE, 5, 2) || '-' || SUBSTR(INV.FECLLE, 7, 2) END AS fechaLlegada, "
						+ "    CASE WHEN INV.STAPAG = 'A' THEN 'EN TRANSITO' ELSE 'EN PROCESO' END AS estado " 
						+ "FROM "
						+ "    " + CollectionScheme.SchemeInventario + ".INVD08 INV INNER JOIN ( SELECT CODIDE, DESCRI FROM " + CollectionScheme.SchemeInventario + ".TABMUL WHERE CODTAB = '01' AND CODIDE <> '' ) COM " 
						+ "        ON INV.COMPAN = COM.CODIDE "
						+ "    INNER JOIN ( SELECT CODIDE, DESCRI FROM " + CollectionScheme.SchemeInventario + ".TABMUL WHERE CODTAB = '02' AND CODIDE <> '' ) SUC " 
						+ "        ON SUC.CODIDE = INV.SUCURS " 
						+ "    LEFT OUTER JOIN " + CollectionScheme.SchemeJdeErp + ".F0101 AB " 
						+ "        ON AB.ABAN8 = INV.PCODPROV " 
						+ "WHERE "
						+ "    INV.COMPAN = ?1 AND INV.NPARTE = ?2 AND INV.PESTA3 = '' AND (INV.CANPED - INV.CANREC) > 0";
			
			q = this.connection.createNativeQuery(strQuery, ConsultaPedidoTransito.class);
			q.setParameter(1,  pCompania);
			q.setParameter(2,  pArticulo);
			
			AuditLogService.SaveLogDetail("getOrderInTransit",strQuery,Guid);
			
			result = q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<ConsultaPedidoConfirmado> getConfirmedOrder(String pCompania, String pArticulo) {
		List<ConsultaPedidoConfirmado> result = null;
		Query q = null;
		String strQuery = "";
		
		try {

			strQuery = "SELECT " 
					+ "    INV.CODCIA AS codigoCompania, "
					+ "    COM.DESCRI AS nombreCompania, "
					+ "    INV.CODSUC AS codigoSucursal, "
					+ "    SUC.DESCRI AS nombreSucursal, "
					+ "    INV.DEPART AS codigoDepartamento, "
					+ "    INV.CODBOD AS codigoBodega, "
					+ "    INV.NLIQUI AS noDocumento, "
					+ "    INV.PEDIDO AS noPedido, "
					+ "    INV.CAJA1 AS codigoCaja, "
					+ "    INV.CATEGO AS codigoCategoria, "
					+ "    CASE WHEN INV.FECHAT = 0 THEN 'N/D' ELSE SUBSTR(INV.FECHAT, 1, 4) || '-' || SUBSTR(INV.FECHAT, 5, 2) || '-' || SUBSTR(INV.FECHAT, 7, 2) END AS fechaLlegada, "
					+ "    INV.NPARTE AS codigoArticulo, "
					+ "    MA.IDESCR AS nombreArticulo, "
					+ "    INV.CANTID AS cantidad " 
					+ "FROM  "
					+ "    " + CollectionScheme.SchemeInventario + ".INVD41 INV INNER JOIN ( SELECT CODIDE, DESCRI FROM " + CollectionScheme.SchemeInventario + ".TABMUL WHERE CODTAB = '01' AND CODIDE <> '' ) COM " 
					+ "        ON INV.CODCIA = COM.CODIDE "
					+ "    INNER JOIN ( SELECT CODIDE, DESCRI FROM " + CollectionScheme.SchemeInventario + ".TABMUL WHERE CODTAB = '02' AND CODIDE <> '' ) SUC " 
					+ "        ON SUC.CODIDE = INV.CODSUC "
					+ "    INNER JOIN " + CollectionScheme.SchemeInventario + "." + (pCompania.equals("01") ? "INVD01" : "INVV01") + " MA "
					+ "        ON MA.ICOMPAN = INV.CODCIA AND MA.INOPAR = INV.NPARTE AND MA.ILINEA = INV.DEPART "
					+ "WHERE "
					+ "    INV.CODCIA = ?1 AND INV.NPARTE = ?2 AND INV.FLAAPL = '' AND TIPREG = 2";
					
			q = this.connection.createNativeQuery(strQuery, ConsultaPedidoConfirmado.class);
			q.setParameter(1,  pCompania);
			q.setParameter(2,  pArticulo);
			
			AuditLogService.SaveLogDetail("getConfirmedOrder",strQuery,Guid);
			
			result = q.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	 
	@SuppressWarnings("unchecked")
	public List<ConsultaPedidoEspecialProveedor> GetConfirmedOrders(String pCompany, String pBranch) throws Exception {
		List<ConsultaPedidoEspecialProveedor> result = null;
		Query q = null;
		String strQuery = "";
		
		try {
			strQuery = "SELECT DISTINCT" 
					+ "    COMPAN AS CODIGOCOMPANIA, " 
					+ "    SUCURS AS CODIGOSUCURSAL, " 
					+ "    DEPART AS CODIGODEPARTAMENTO, " 
					+ "    BODEGA AS CODIGOBODEGA, " 
					+ "    PEDIDO AS NUMEROPEDIDO, " 
					+ "    VARCHAR_FORMAT(TIMESTAMP_FORMAT(CAST(FECHAM AS VARCHAR(8)), 'YYYYMMDD'),'YYYY-MM-DD') AS FECHA, " 
					+ "    NORDEN AS NUMEROORDEN, " 
					+ "    VENDED AS CODIGOVENDEDOR, " 
					+ "    CLIENT AS CODIGOCLIENTE, " 
					+ "    CLNOMB AS NOMBRECLIENTE, " 
					+ "    MOTIVO AS MOTIVO, " 
					+ "    FORMPA AS FORMAPAGO, " 
					+ "    MODENT AS MODALIDADENTREGA, " 
					+ "    NOPROF AS NUMEROPROFORMA, " 
					+ "    TITRAN AS TIPOTRANSPORTE " 
					//+ "    CATEGO AS CATEGORIA " 
					+ "FROM " 
					+ "    " + CollectionScheme.SchemeInventario + ".INVD34 " 
					+ "WHERE " 
					+ "    COMPAN = ?1 AND SUCURS = ?2 AND STATU2 <> 'R' AND CANREC > 0";
			
			q = this.connection.createNativeQuery(strQuery, ConsultaPedidoEspecialProveedor.class);
			q.setParameter(1, pCompany);
			q.setParameter(2, pBranch);
			
			AuditLogService.SaveLogDetail("GetConfirmedOrders",strQuery,Guid);
			
			result = (List<ConsultaPedidoEspecialProveedor>)q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al consultar los pedidos al proveedor " + e.getMessage());
		}

		return result;
	}
	
	private Boolean ValidateEntity(PedidoEspecialProveedor objInput) throws Exception {
		Boolean IsValid = false;
		EquivalenciaService eqService = null;
		ClienteService clService = null;
		
		try {
			// Validar la compania y la sucursal
			eqService = new EquivalenciaService(this.connection,Guid);
			
			if (!eqService.IsValidConfiguration(objInput.getCodigoCompania(), objInput.getCodigoSucursal(), objInput.getCodigoDepartamento())) {
				throw new Exception("La configuracion de compania, sucursal y departamento no es valida");
			}
			
			// Validar que el cliente sea valido
			clService = new ClienteService(this.connection,Guid);
			if (!clService.ExistCustomer(objInput.getCodigoCliente())) {
				throw new Exception("El cliente suministrado no es valido");
			}
			
			// Si viene mas de una bodega entonces rechazar el pedido
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
}
