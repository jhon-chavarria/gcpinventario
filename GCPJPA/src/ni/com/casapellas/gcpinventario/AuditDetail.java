package ni.com.casapellas.gcpinventario;

public class AuditDetail {
	private String AuditMasterGID;	
	private String CallType;
	private String Message;
	private String CreatedOn;
	public String getAuditMasterGID() {
		return AuditMasterGID;
	}
	public String getCallType() {
		return CallType;
	}
	public String getMessage() {
		return Message;
	}
	public String getCreatedOn() {
		return CreatedOn;
	}
	public void setAuditMasterGID(String auditMasterGID) {
		AuditMasterGID = auditMasterGID;
	}
	public void setCallType(String callType) {
		CallType = callType;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public void setCreatedOn(String createdOn) {
		CreatedOn = createdOn;
	}
	
}
