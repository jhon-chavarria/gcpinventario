package ni.com.casapellas.gcpfmu.pojo;

public class AuthorizationCode {
	private int codeId;
	private String cellarId;
	private String user;
	private int date;
	private int hourTime;
	private int state;
	private String companyId;
	private String branchId;
	private String type;
	private int foreign;

	public int getCodeId() {
		return codeId;
	}
	public void setCodeId(int codeId) {
		this.codeId = codeId;
	}
	public String getCellarId() {
		return cellarId;
	}
	public void setCellarId(String cellarId) {
		this.cellarId = cellarId;
	}
	
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getForeign() {
		return foreign;
	}
	public void setForeign(int foreign) {
		this.foreign = foreign;
	}
	public int getHourTime() {
		return hourTime;
	}
	public void setHourTime(int hourTime) {
		this.hourTime = hourTime;
	}
	
}
