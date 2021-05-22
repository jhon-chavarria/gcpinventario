package ni.com.casapellas.cxccobro.pojo;

import java.io.Serializable;

public class GcpActivityListByCustomerPojo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int empCode;
	private int customerCode;
	private int activityIdBasic;
	private String activityCode;
	private String activityNameBasic;
	private String activityTypeCode;
	private String statusAct;
	private String companyCode;
	private String companyName;
	private String collectionTitle;

	public GcpActivityListByCustomerPojo() {
	}

	public int getEmpCode() {
		return empCode;
	}

	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}

	public int getActivityIdBasic() {
		return activityIdBasic;
	}

	public void setActivityIdBasic(int activityIdBasic) {
		this.activityIdBasic = activityIdBasic;
	}

	public String getActivityNameBasic() {
		return activityNameBasic;
	}

	public void setActivityNameBasic(String activityNameBasic) {
		this.activityNameBasic = activityNameBasic;
	}

	public int getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getActivityTypeCode() {
		return activityTypeCode;
	}

	public void setActivityTypeCode(String activityTypeCode) {
		this.activityTypeCode = activityTypeCode;
	}

	public String getStatusAct() {
		return statusAct;
	}

	public void setStatusAct(String statusAct) {
		this.statusAct = statusAct;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCollectionTitle() {
		return collectionTitle;
	}

	public void setCollectionTitle(String collectionTitle) {
		this.collectionTitle = collectionTitle;
	}

}
