package ni.com.casapellas.gcpinventario;

public class AuditMaster {
	private String GID;	
	private String ApplicationName;
	private String MethodName;
	private String MethodType;
	private String UserName;
	private String ActionType;
	private String CreatedOn;
	private String RequestPath; 
	private String PuntoVenta;
	private String ResponseDate;
	
	public String getResponseDate() {
		return ResponseDate;
	}
	public void setResponseDate(String responseDate) {
		ResponseDate = responseDate;
	}
	public String getPuntoVenta() {
		return PuntoVenta;
	}
	public void setPuntoVenta(String puntoVenta) {
		PuntoVenta = puntoVenta;
	}
	public String getRequestPath() {
		return RequestPath;
	}
	public void setRequestPath(String requestPath) {
		RequestPath = requestPath;
	}
	public String getGID() {
		return GID;
	}
	public String getApplicationName() {
		return ApplicationName;
	}
	public String getMethodName() {
		return MethodName;
	}
	public String getMethodType() {
		return MethodType;
	}
	public String getUserName() {
		return UserName;
	}
	public String getActionType() {
		return ActionType;
	}
	public String getCreatedOn() {
		return CreatedOn;
	}
	public void setGID(String gID) {
		GID = gID;
	}
	public void setApplicationName(String applicationName) {
		ApplicationName = applicationName;
	}
	public void setMethodName(String methodName) {
		MethodName = methodName;
	}
	public void setMethodType(String methodType) {
		MethodType = methodType;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public void setActionType(String actionType) {
		ActionType = actionType;
	}
	public void setCreatedOn(String createdOn) {
		CreatedOn = createdOn;
	}
}
