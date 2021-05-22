package ni.com.casapellas.erp.inventario.ventas.factura;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ni.com.casapellas.ejb.erp.util.DateTimeHelper;
import ni.com.casapellas.ejb.erp.util.GlobalHelper;
import ni.com.casapellas.ejb.erp.util.PagedInfo;
import ni.com.casapellas.ejb.erp.util.PagedResult;
import ni.com.casapellas.erp.util.AuditLogService;
import ni.com.casapellas.erp.util.CustomFormat;
import ni.com.casapellas.gcpinventario.ConsultaFacturaHistorico;
import ni.com.casapellas.gcpinventario.ConsultaFacturaHistoricoDetalle;
import ni.com.casapellas.util.CollectionScheme;

public class FacturaService {
	EntityManager connection = null;
	String Guid;
	CustomFormat format = new CustomFormat(); 
	/**
	 * 
	 */
	public FacturaService(EntityManager em) {
		this.connection = em;
	}
	public FacturaService(EntityManager em,String GuidMaster) {
		this.connection = em;
		this.Guid = GuidMaster;
	}
	
//	public FacturaService(EntityManager em,String GuidMaster,SessionContext scontex) {
//		this.connection = em;
//		this.Guid = GuidMaster;
//		this.sContext = scontex;
//	}
	
	public PagedResult<ConsultaFacturaHistorico> GetInvoices(String pCompania, String pSucursal, PagedInfo pageInfo) throws Exception {
		PagedResult<ConsultaFacturaHistorico> pagedResult = null;
		Query q = null;
		String strQuery = "";
		
		try {
			int offSet = (pageInfo.getPageSize()*(pageInfo.getPageNumber()-1));
			String strOffSet = " OFFSET " + offSet + " ROWS FETCH FIRST " + pageInfo.getPageSize() + " ROWS ONLY";
			List<String> params = new ArrayList<String>();
			String orderBy = "";
			Integer totalRows = 0;
			
			if (pageInfo.getOrderBy() != null && pageInfo.getOrderBy().trim().length() > 0) {
				orderBy = " ORDER BY " + pageInfo.getOrderBy().trim().toUpperCase();
				
				if (pageInfo.getOrderDirection() != null && pageInfo.getOrderDirection().trim().length() > 0) {
					String orderDirection = pageInfo.getOrderDirection().trim();
					@SuppressWarnings("serial")
					List<String> orderEnum = new ArrayList<String>() {
						{
							add("asc");
							add("desc");
						}
					};
					
					orderBy = orderBy + " " 
					+ (orderEnum.contains(orderDirection.trim().toLowerCase()) ? orderDirection.trim().toUpperCase() : "ASC");
				} else {
					orderBy = orderBy + " DESC";
				}
			}
			String strSelectCount = "SELECT COUNT(1) AS TOTAL FROM " + CollectionScheme.SchemeInventario + ".INV_FACTURAS_LSRETAIL";
			String strSelect = "SELECT " 
					+ "    CODIGOCOMPANIA, " 
					+ "    CODIGOSUCURSAL, " 
					+ "    CODIGODEPARTAMENTO, " 
					+ "    TIPOMOVIMIENTO, " 
					+ "    SUBTIPOMOVIMIENTO, " 
					+ "    NUMERODOCUMENTO, " 
					+ "    CASE WHEN FECHA = 0 THEN 'N/D' ELSE SUBSTR(FECHA, 1, 4) || '-' || SUBSTR(FECHA, 5, 2) || '-' || SUBSTR(FECHA, 7, 2) END AS FECHA," 
					+ "    TASACAMBIO, " 
					+ "    MOTIVO, " 
					+ "    NUMEROREFERENCIA, " 
					+ "    CODIGOVENDEDORC, " 
					+ "    MODALIDADCANAL, " 
					+ "    CODIGOVENDEDORL, " 
					+ "    NOMBREVENDEDOR," 
					+ "    CODIGOCLIENTE, " 
					+ "    NOMBRECLIENTE, " 
					+ "    MODALIDADFACTURA, " 
					+ "    TIPOFACTURA, " 
					+ "    CONDICIONPAGO," 
					+ "    CODIGOMONEDA," 
					+ "    TOTALFACTURAL, " 
					+ "    TOTALDESCUENTOL, " 
					+ "    TOTALIMPVENTAL, " 
					+ "    TOTALIMPISCL, " 
					+ "    TOTALFACTURAF, " 
					+ "    TOTALDESCUENTOF, " 
					+ "    TOTALIMPVENTAF, " 
					+ "    TOTALIMPISCF, " 
					+ "    TOTALCOSTO "
					+ "FROM " 
					+ "    " + CollectionScheme.SchemeInventario + ".INV_FACTURAS_LSRETAIL";
			
			String strFilter = " WHERE CODIGOCOMPANIA = ?1 AND CODIGOSUCURSAL = ?2";
			params.add(pCompania);
			params.add(pSucursal);
			
			if (pageInfo.getFilterBy() != null && pageInfo.getFilterBy().trim().length() > 0) {
				String search = pageInfo.getFilterBy().trim();
				List<String> generalTypes = GlobalHelper.GetJavaTypesFromValue(search);
				String customFilter = "";
				int idx = 3;
				
				if (generalTypes.size() > 0) {
					@SuppressWarnings("serial")
					HashMap<String, String> columnsMap = new HashMap<String, String>() {{
						put("MOTIVO", "String");
						put("NOMBREVENDEDOR", "String");
						put("NOMBRECLIENTE", "String");
						put("NUMERODOCUMENTO", "Number");
						put("NUMEROREFERENCIA", "Number");
						put("CODIGOVENDEDORL", "Number");
						put("CODIGOCLIENTE", "Number");
						put("FECHA", "DateTime");
					}};
					
					strFilter = strFilter + " AND (";
					for (Entry<String, String> entry : columnsMap.entrySet()) {
						if (generalTypes.contains(entry.getValue())) {
							switch (entry.getValue()) {
							case "String":
								customFilter = (customFilter.length() == 0 ? entry.getKey() : customFilter + " OR " + entry.getKey()) + " LIKE ?" + idx;
								params.add("%" + search.trim().toUpperCase() + "%");	
								break;
							case "Number":
								customFilter = (customFilter.length() == 0 ? entry.getKey() : customFilter + " OR " + entry.getKey()) + " = ?" + idx;
								params.add(search.trim().toUpperCase());
								break;
							case "DateTime":
								customFilter = (customFilter.length() == 0 ? entry.getKey() : customFilter + " OR " + entry.getKey()) + " = ?" + idx;
								Integer tmpDate = DateTimeHelper.CastDateToNumber(DateTimeHelper.CastStringToDate(search, "yyyy-MM-dd"), "yyyy-MM-dd"); 
								params.add(tmpDate.toString());
								break;
							}
							idx++;
						}
					}
					
					strFilter = strFilter + customFilter + " )";
				}
			}

			strQuery = strSelectCount + strFilter;
			q = this.connection.createNativeQuery(strQuery);
			for (int i = 0; i < params.size(); i++) {
				q.setParameter((i + 1), params.get(i));
			}
			
			totalRows = (Integer) q.getSingleResult();
			
			strQuery = strSelect + strFilter + orderBy + strOffSet;
			q = this.connection.createNativeQuery(strQuery, ConsultaFacturaHistorico.class);
			for (int i = 0; i < params.size(); i++) {
				q.setParameter((i + 1), params.get(i));
			}
			
			AuditLogService.SaveLogDetail("GetInvoices",strQuery,Guid);
			
			@SuppressWarnings("unchecked")
			List<ConsultaFacturaHistorico> result = (List<ConsultaFacturaHistorico>)q.getResultList();
			
			pagedResult = new PagedResult<ConsultaFacturaHistorico>(totalRows, pageInfo.getPageNumber(), pageInfo.getPageSize(), result);
			

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al consultar el historico de facturas" + e.getMessage());
		}

		return pagedResult;
	}

	@SuppressWarnings("unchecked")
	public ConsultaFacturaHistorico GetInvoiceByNumber(String pCompania, String pSucursal, String pFecha, Integer pNoDocumento) throws Exception {
		ConsultaFacturaHistorico result = null;
		Query q = null;
		String strQuery = "";
		
		try {
			strQuery = "SELECT " 
					+ "    CODIGOCOMPANIA, " 
					+ "    CODIGOSUCURSAL, " 
					+ "    CODIGODEPARTAMENTO, " 
					+ "    TIPOMOVIMIENTO, " 
					+ "    SUBTIPOMOVIMIENTO, " 
					+ "    NUMERODOCUMENTO, " 
					+ "    CASE WHEN FECHA = 0 THEN 'N/D' ELSE SUBSTR(FECHA, 1, 4) || '-' || SUBSTR(FECHA, 5, 2) || '-' || SUBSTR(FECHA, 7, 2) END AS FECHA," 
					+ "    TASACAMBIO, " 
					+ "    MOTIVO, " 
					+ "    NUMEROREFERENCIA, " 
					+ "    CODIGOVENDEDORC, " 
					+ "    MODALIDADCANAL, " 
					+ "    CODIGOVENDEDORL, " 
					+ "    NOMBREVENDEDOR," 
					+ "    CODIGOCLIENTE, " 
					+ "    NOMBRECLIENTE, " 
					+ "    MODALIDADFACTURA, " 
					+ "    TIPOFACTURA, " 
					+ "    CONDICIONPAGO," 
					+ "    CODIGOMONEDA," 
					+ "    TOTALFACTURAL, " 
					+ "    TOTALDESCUENTOL, " 
					+ "    TOTALIMPVENTAL, " 
					+ "    TOTALIMPISCL, " 
					+ "    TOTALFACTURAF, " 
					+ "    TOTALDESCUENTOF, " 
					+ "    TOTALIMPVENTAF, " 
					+ "    TOTALIMPISCF, "
					+ "    TOTALCOSTO, "
					+ "    NUMEROORDENTALLER, "
					+ "    TIPODOCUMENTOTALLER, "
					+ "    CODIGOTALLER, "
					+ "    CODIGOTECNICO, "
					+ "    NOMBRETECNICO, "
					+ "    ESTADO "
					+ "FROM " 
					+ "    " + CollectionScheme.SchemeInventario + ".INV_FACTURAS_LSRETAIL "
					+ "WHERE "
					+ "    CODIGOCOMPANIA = ?1 AND CODIGOSUCURSAL = ?2 AND FECHA = ?3 AND NUMERODOCUMENTO = ?4";
			
			Integer parsedDate = DateTimeHelper.CastDateToNumber(DateTimeHelper.CastStringToDate(pFecha, "yyyy-MM-dd"), "yyyyMMdd");
			
			q = this.connection.createNativeQuery(strQuery, ConsultaFacturaHistorico.class);
			q.setParameter(1, pCompania);
			q.setParameter(2, pSucursal);
			q.setParameter(3, parsedDate);
			q.setParameter(4, pNoDocumento);
			
			AuditLogService.SaveLogDetail("GetInvoiceByNumber",strQuery,Guid);
			
			List<ConsultaFacturaHistorico> invoiceHistory = (List<ConsultaFacturaHistorico>)q.getResultList();
			
			if (invoiceHistory != null && invoiceHistory.size() > 0) {
				result = invoiceHistory.get(0);
				
				// Consultar el detalle
				strQuery = "SELECT" 
						+ "    BODEGA AS codigoBodega,"
						+ "    DEPART AS codigoLinea,"
						+ "    HISECUE AS secuencia,"
						+ "    NPARTE AS codigoArticulo,"
						+ "    ISTAT2 AS codigoCategoria,"
						+ "    CANTID AS cantidad,"
						+ "    CANVEN AS cantidadDevuelta,"
						+ "    PRECIO AS precioUnitarioL,"
						+ "    PRECIOUF AS precioUnitarioF,"
						+ "    IMPUES AS porcentajeImpVenta,"
						+ "    IMPISC AS porcentajeImpIsc,"
						+ "    DESCUE AS porcentajeDescuento, "
						+ "    VALORU AS costoUnitario " 
						+ "FROM"
						+ "    " + CollectionScheme.SchemeInventario + ".INVD35 " 
						+ "WHERE"
						+ "    COMPAN = ?1"
						+ "    AND SUCURS = ?2"
						+ "    AND TIPOMO = '21' "
						+ "    AND DOCUME = ?3"
						+ "    AND FECHAM = ?4";
				
				q = this.connection.createNativeQuery(strQuery, ConsultaFacturaHistoricoDetalle.class);
				q.setParameter(1, pCompania);
				q.setParameter(2, pSucursal);
				q.setParameter(3, pNoDocumento);
				q.setParameter(4, parsedDate);
				
				AuditLogService.SaveLogDetail("GetInvoiceDetailByNumber",strQuery,Guid);
				
				List<ConsultaFacturaHistoricoDetalle> detalle = (List<ConsultaFacturaHistoricoDetalle>)q.getResultList();
				
				if (detalle != null && detalle.size() > 0) {
					result.setDetalle(detalle);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al consultar el historico de facturas" + e.getMessage());
		}

		return result;
	}
	
}
