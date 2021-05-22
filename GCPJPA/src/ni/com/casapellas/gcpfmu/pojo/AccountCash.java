package ni.com.casapellas.gcpfmu.pojo;

public class AccountCash {

	private String companyId;
	private String account;
	
	private String  lineTransientId;
	private String objectTransientId;

	private String TransientIdCompletedAccount;

	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getLineTransientId() {
		return lineTransientId;
	}
	public void setLineTransientId(String lineTransientId) {
		this.lineTransientId = lineTransientId;
	}
	public String getObjectTransientId() {
		return objectTransientId;
	}
	public void setObjectTransientId(String objectTransientId) {
		this.objectTransientId = objectTransientId;
	}
	public String getTransientIdCompletedAccount() {
		return TransientIdCompletedAccount;
	}
	public void setTransientIdCompletedAccount(String transientIdCompletedAccount) {
		TransientIdCompletedAccount = transientIdCompletedAccount;
	}
	

}
