package ni.com.casapellas.erp.cliente;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ni.com.casapellas.erp.util.AuditLogService;
import ni.com.casapellas.util.CollectionScheme;

public class ClienteService {
	EntityManager connection = null;
	String Guid;
	/**
	 * 
	 */
	public ClienteService(EntityManager em) {
		this.connection = em;
	}
	public ClienteService(EntityManager em,String GuidMaster) {
		this.connection = em;
		this.Guid = GuidMaster;
	}
	
	public Boolean ExistCustomer(Integer customerId) {
		Boolean exist = false;
		Query q = null;
		String strQuery = "";
		
		try {
			strQuery = "SELECT COUNT(1) AS CUSTOMER FROM " + CollectionScheme.SchemeJdeErp + ".F0101 WHERE ABAN8 = ?1";
			q = connection.createNativeQuery(strQuery);
			q.setParameter(1, customerId);
			
			AuditLogService.SaveLogDetail("ExistCustomer",strQuery,Guid);
			
			Integer result = (Integer)q.getSingleResult();
			
			
			exist = result > 0 ? true : false;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return exist;
	}
	
}
