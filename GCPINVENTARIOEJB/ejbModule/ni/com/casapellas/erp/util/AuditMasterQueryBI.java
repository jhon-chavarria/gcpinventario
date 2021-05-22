package ni.com.casapellas.erp.util;

import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import ni.com.casapellas.gcpinventario.AuditDetail;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
@LocalBean
public class AuditMasterQueryBI {
	protected EntityManager em;

	CustomFormat format = new CustomFormat();

	public AuditMasterQueryBI(EntityManager em2, SessionContext sessionContext2) {

		if (em == null)
			this.em = em2;
	}

	public AuditMasterQueryBI() {

	}

	public void saveLogDetail(String methodName, String query, String GuidString) throws Exception {
//		String strQuery;
		// Query q = null;

		AuditDetail detail = new AuditDetail();
		detail.setAuditMasterGID(GuidString);
		detail.setCallType(methodName);
		detail.setCreatedOn(format.getCurrentStringDate());
		detail.setMessage(query);
		
		AuditLogService.SaveLogDetail(detail);
		
//		strQuery = "INSERT INTO " + CollectionScheme.SchemeInventario + ".AuditDetail ("
//				+ "AuditMasterGID, CallType, Message, " + "CreatedOn) Values (?1,?2,?3,?4)";
//
//		try {
//			q = em.createNativeQuery(strQuery);
//
//			q.setParameter(1, detail.getAuditMasterGID());
//			q.setParameter(2, detail.getCallType());
//			q.setParameter(3, detail.getMessage());
//			q.setParameter(4, detail.getCreatedOn());
//
//			q.executeUpdate();
//		} catch (Exception e) {
//			throw e;
//		}
	}
}
