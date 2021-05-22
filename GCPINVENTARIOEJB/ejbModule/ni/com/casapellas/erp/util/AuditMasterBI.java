package ni.com.casapellas.erp.util;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ni.com.casapellas.gcpinventario.AuditDetail;
import ni.com.casapellas.gcpinventario.AuditMaster;
import ni.com.casapellas.util.CollectionScheme;

@Stateless
@LocalBean
public class AuditMasterBI {
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	@Resource SessionContext sessionContext;
	
	public AuditMasterBI() {
		
	}
	public AuditMasterBI(EntityManager em2) {
		if (em == null)
			this.em = em2;
	}
	
	
	
	public String saveLogHeader(AuditMaster item) throws Exception {
		String strQuery;
		Query q = null;
		strQuery="INSERT INTO "+CollectionScheme.SchemeInventario+".AuditMaster ("
				+ "GID, ApplicationName, MethodName, "
				+ "MethodType, UserName, ActionType,"
				+ "CreatedOn,RequestPath,PuntoVenta) Values (?1,?2,?3,?4,?5,?6,?7,?8,?9)";
		
		try {				
			
			
			q = em.createNativeQuery(strQuery);
			
			q.setParameter(1, item.getGID());
			q.setParameter(2, item.getApplicationName());
			q.setParameter(3, item.getMethodName());
			q.setParameter(4, item.getMethodType());
			q.setParameter(5, item.getUserName());
			q.setParameter(6, item.getActionType());
			q.setParameter(7, item.getCreatedOn());
			q.setParameter(8, item.getRequestPath());
			q.setParameter(9, item.getPuntoVenta());
			q.executeUpdate();
		}catch(Exception e) {
			
			throw e;
		}
		return "LogMasterCreated";
	}
	
	public String saveLogDetail(AuditDetail item) throws Exception {
		String strQuery;
		Query q = null;
		strQuery="INSERT INTO "+CollectionScheme.SchemeInventario+".AuditDetail ("
				+ "AuditMasterGID, CallType, Message, "				
				+ "CreatedOn) Values (?1,?2,?3,?4)";
		
		try {				
			
			
			q = em.createNativeQuery(strQuery);
			
			q.setParameter(1, item.getAuditMasterGID());
			q.setParameter(2, item.getCallType());
			q.setParameter(3, item.getMessage());
			q.setParameter(4, item.getCreatedOn());
	
			q.executeUpdate();
			
		}catch(Exception e) {
			
			throw e;
		}
		return "LogMasterCreated";
	}
	
}
