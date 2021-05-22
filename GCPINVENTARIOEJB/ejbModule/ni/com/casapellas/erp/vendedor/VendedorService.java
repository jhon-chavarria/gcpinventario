package ni.com.casapellas.erp.vendedor;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ni.com.casapellas.erp.util.AuditMasterQueryBI;
import ni.com.casapellas.util.CollectionScheme;

public class VendedorService {
	EntityManager connection = null;
	String Guid;
	@Resource 
	private SessionContext sessionContext;  
	@EJB
	private AuditMasterQueryBI audit;
	/**
	 * 
	 */
	public VendedorService(EntityManager em) {
		this.connection = em;
	}
	
	public VendedorService(EntityManager em,String GuidMaster) {
		this.connection = em;
		this.Guid = GuidMaster;
	}
	
	
	public Boolean ExistVendor(String pCompany, String pBranch, Integer pVendorId) {
		Boolean exist = false;
		Query q = null;
		String strQuery = "";
		
		try {
			strQuery = "SELECT COUNT(1) AS VENDOR FROM " + CollectionScheme.SchemeJdeErp + ".F0101 WHERE ABAN8 = ?1";
			q = connection.createNativeQuery(strQuery);
			q.setParameter(1, pVendorId);
			
			Integer result = (Integer)q.getSingleResult();
			
			exist = result > 0 ? true : false;
			/*
			 * Ya no se va a usar esa tabla para manejar los codigos de los vendedores
			if (result > 0) {
				strQuery = "SELECT COUNT(1) FROM E1QS36F.TABMUL WHERE CODTAB = '05' AND OTROS = ?1 AND ORDEN = ?2";
				q = connection.createNativeQuery(strQuery);
				q.setParameter(1, pVendorId);
				q.setParameter(2, pBranch);
				
				Integer v = (Integer)q.getSingleResult();
				exist = v > 0 ? true : false;
			}
			*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		try {
			audit = new AuditMasterQueryBI(this.connection, sessionContext);
			audit.saveLogDetail("ExistVendor",strQuery,Guid);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return exist;
	}
}
