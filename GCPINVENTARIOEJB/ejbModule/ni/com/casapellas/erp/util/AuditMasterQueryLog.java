package ni.com.casapellas.erp.util;

import javax.ejb.EJB;
import javax.persistence.EntityManager;

import ni.com.casapellas.gcpinventario.AuditDetail;

public class AuditMasterQueryLog {
	
	
	
	private String date;
	CustomFormat format = new CustomFormat();
	//---
	private String Guid;
	public String getGuid() {
		return Guid;
	}

	public void setGuid(String guid) {
		Guid = guid;
	}

	

	@EJB
	private AuditMasterQueryBI ejbService;
	
	public AuditMasterQueryLog(EntityManager em) {
		//ejbService=new AuditMasterQueryBI(em);
	}
	
	public  void logAuditDetailQueryEJB(String methodName,String query,String GuidString) {
		
		
		date = format.getCurrentStringDate();
		AuditDetail detail = new AuditDetail();
		detail.setAuditMasterGID(GuidString);
		detail.setCallType(methodName);
		detail.setCreatedOn(date);	
		detail.setMessage(query);
		
		try {
			//ejbService.saveLogDetail(detail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
