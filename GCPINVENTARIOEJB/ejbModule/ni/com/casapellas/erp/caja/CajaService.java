package ni.com.casapellas.erp.caja;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ni.com.casapellas.erp.util.AuditLogService;
import ni.com.casapellas.util.CollectionScheme;

public class CajaService {
	EntityManager connection = null;
	String Guid;

	/**
	 * 
	 */
	public CajaService(EntityManager em) {
		this.connection = em;
	}
	
	public CajaService(EntityManager em, String uGuid) {
		this.connection = em;
		this.Guid = uGuid;
	}
	
	public Boolean HasPaymentSlip(String pCompanyJde, String pBranchJde, String pDepartmentJde, Integer pNoDocument, String pDocType) {
		Query q = null;
		String strQuery = "";
		Boolean result = false;
		
		try {			
			strQuery = "SELECT COUNT(*) AS PAYMENTCOUNT "
					+ "FROM " + CollectionScheme.SchemeCAJA  + ".RECIBOFAC "
					+ "WHERE CODCOMP = ?1 AND CODSUC = ?2 AND CODUNINEG = ?3 AND NUMFAC = ?4 AND TIPOFACTURA = ?5 AND ESTADO = ''";
			
			q = this.connection.createNativeQuery(strQuery);
			q.setParameter(1, pCompanyJde);
			q.setParameter(2, pBranchJde);
			q.setParameter(3, pDepartmentJde);
			q.setParameter(4, pNoDocument);
			q.setParameter(5, pDocType);
			
			AuditLogService.SaveLogDetail("HasPaymentSlip",strQuery,Guid);
			
			Integer paymentCount = (Integer) q.getSingleResult();
			
			result = paymentCount > 0 ? true : false;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
