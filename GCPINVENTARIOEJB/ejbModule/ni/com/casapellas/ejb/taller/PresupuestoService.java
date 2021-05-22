package ni.com.casapellas.ejb.taller;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ni.com.casapellas.ejb.erp.util.DateTimeHelper;
import ni.com.casapellas.erp.util.AuditLogService;
import ni.com.casapellas.gcptaller.pojo.PresupuestoTaller;
import ni.com.casapellas.gcptaller.pojo.PresupuestoTallerDetalle;
import ni.com.casapellas.util.CollectionScheme;

public class PresupuestoService {
	EntityManager connection = null;
	String Guid;

	/**
	 * 
	 */
	public PresupuestoService(EntityManager em) {
		this.connection = em;
	}
	
	public PresupuestoService(EntityManager em, String uGuid) {
		this.connection = em;
		this.Guid = uGuid;
	}
	
	public PresupuestoTaller GetWorkshopBudget(String pCompany, String pWorkShop, String pBudgetType, String pBudgetDate, BigDecimal pBudgetNumber) throws Exception {
		PresupuestoTaller budget = null;
		
		try {
			Query q = null;
			String strQuery = "SELECT" 
					+ "    C.COMPANIA AS CODIGOCOMPANIA," 
					+ "    C.CODTALLER AS CODIGOTALLER," 
					+ "    C.NOPRES AS NUMEROPRESUPUESTO," 
					+ "    VARCHAR_FORMAT(C.FECHA, 'DD-MM-YYYY') AS FECHA," 
					+ "    C.CODCLI AS CODIGOCLIENTE," 
					+ "    C.NOMCLI AS NOMBRECLIENTE," 
					+ "    C.CHASIS AS CHASIS," 
					+ "    C.VALMAO AS VALORMANOOBRA," 
					+ "    C.VALMAT AS VALORMATERIALES," 
					+ "    C.VALREP AS VALORREPUESTOS," 
					+ "    C.NORDEN AS NUMEROORDEN," 
					+ "    C.CODTECNO AS CODIGOTECNICO," 
					+ "    COALESCE(TEC.TECNOM, '') AS NOMBRETECNICO," 
					+ "    C.TIPO AS TIPOPRESUPUESTO," 
					+ "    C.OBSER1 || C.OBSER2 || C.OBSER3 AS OBSERVACIONES," 
					+ "    C.VALTOTAL AS VALORTOTAL," 
					+ "    C.P1MONEDA AS MONEDA," 
					+ "    CASE WHEN C.FECHAVENCIMIENTO IS NULL THEN '' ELSE VARCHAR_FORMAT(C.FECHAVENCIMIENTO, 'DD-MM-YYYY') END AS FECHAVENCIMIENTO," 
					+ "    C.TELEF AS TELEFONO," 
					+ "    C.DIRECC AS DIRECCION," 
					+ "    C.CIASEGURO AS NOMBREASEGURADORA," 
					+ "    C.MARCA AS CODIGOMARCA," 
					+ "    COALESCE(CM.TBDESC, '') AS DESCRIPCIONMARCA," 
					+ "    C.MODELO AS MODELO," 
					+ "    C.COLOR AS CODIGOCOLOR," 
					+ "    COALESCE(CL.TBDESC, '') AS DESCRIPCIONCOLOR," 
					+ "    C.ANIO AS ANNIO," 
					+ "    C.PLACA AS PLACA " 
					+ "FROM " 
					+ "    " + CollectionScheme.SchemePresupuesto + ".PRESHDR C LEFT OUTER JOIN ( SELECT TBCIA, TBESPE, TBDESC FROM " + CollectionScheme.SchemeTaller + ".SOTTAB WHERE TBCODI = '034' ) CM" 
					+ "        ON C.MARCA = CM.TBESPE" 
					+ "    LEFT OUTER JOIN ( SELECT TBCIA, TBESPE, TBDESC FROM " + CollectionScheme.SchemeTaller + ".SOTTAB WHERE TBCODI = '033' ) CL" 
					+ "        ON CL.TBESPE = C.COLOR" 
					+ "    LEFT OUTER JOIN " + CollectionScheme.SchemeTaller + ".SOTTEC TEC" 
					+ "        ON TEC.TECEMP = C.CODTECNO " 
					+ "WHERE " 
					+ "    C.COMPANIA = ?1 AND C.CODTALLER = ?2 AND C.TIPO = ?3 AND VARCHAR_FORMAT(C.FECHA, 'YYYYMMDD') = ?4 AND C.NOPRES = ?5";
			
			Integer intDate = DateTimeHelper.CastDateToNumber(DateTimeHelper.CastStringToDate(pBudgetDate, "yyyy-MM-dd"), "yyyyMMdd");
			
			q = this.connection.createNativeQuery(strQuery, PresupuestoTaller.class);
			q.setParameter(1, pCompany);
			q.setParameter(2, pWorkShop);
			q.setParameter(3, pBudgetType);
			q.setParameter(4, intDate);
			q.setParameter(5, pBudgetNumber);
			
			AuditLogService.SaveLogDetail("GetWorkshopBudget",strQuery,Guid);
			
			@SuppressWarnings("unchecked")
			List<PresupuestoTaller> result = (List<PresupuestoTaller>)q.getResultList();
			
			if (result != null && result.size() > 0) {
				budget = result.get(0);
				
				List<PresupuestoTallerDetalle> detalle = GetWorkshopBudgetDetail(pCompany, pWorkShop, pBudgetType, pBudgetNumber);
				
				if (detalle != null && detalle.size() > 0) {
					budget.setDetalle(detalle);	
				}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		
		return budget;
	}
	
	@SuppressWarnings("unchecked")
	private List<PresupuestoTallerDetalle> GetWorkshopBudgetDetail(String pCompany, String pWorkShop, String pBudgetType, BigDecimal pBudgetNumber) {
		List<PresupuestoTallerDetalle> result = null;
		
		try {
			Query q = null;
			String strQuery = "SELECT" 
					+ "    FECHA AS FECHA, "
					+ "    CODACT AS CODIGOELEMENTO, "
					+ "    DESC AS DESCRIPCION, "
					+ "    TIPO AS TIPOELEMENTO, "
					+ "    HORAS AS HORAS, "
					+ "    CANTIDAD AS CANTIDAD, "
					+ "    VALOR AS VALOR, "
					+ "    DESCUENTO AS DESCUENTO, "
					+ "    VALORALT AS VALORALTERNO, "
					+ "    TIPOLINEA AS TIPOLINEA, "
					+ "    DESC2 AS DESCRIPCIONADICIONAL " 
					+ "FROM"
					+ "    " + CollectionScheme.SchemePresupuesto + ".PRESDTL " 
					+ "WHERE"
					+ "    COMPANIA = ?1 AND CODTALLER = ?2 AND TIPOP = ?3 AND NOPRES = ?4";
			
			q = this.connection.createNativeQuery(strQuery, PresupuestoTallerDetalle.class);
			q.setParameter(1, pCompany);
			q.setParameter(2, pWorkShop);
			q.setParameter(3, pBudgetType);
			q.setParameter(4, pBudgetNumber);
			
			AuditLogService.SaveLogDetail("GetWorkshopBudgetDetail",strQuery,Guid);
			
			result = (List<PresupuestoTallerDetalle>)q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return result;
	}
}
