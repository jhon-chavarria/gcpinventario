package ni.com.casapellas.gcpfmu.pojo;

import java.util.List;

public class BillHeader {

	private int billId;	
    private String companyId;
    private String typeMove;
    private int clientId;

    // For return bill on cash table update
    private int returnBillId;
    private String type;
    private int returnBillDate;
    private int cashId;
    
    // if is credit (receivable)
    private int feedAmount;
    private int daysLimit;
    
    // Authorization Codes
    private int code;
    private String typeCode;

	private List<BillPost> billPosts;
	
    private List<ClientCreditInfo> creditBills;
	
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public List<BillPost> getBillPosts() {
		return billPosts;
	}
	public void setBillPosts(List<BillPost> billPosts) {
		this.billPosts = billPosts;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getTypeMove() {
		return typeMove;
	}
	public void setTypeMove(String typeMove) {
		this.typeMove = typeMove;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getFeedAmount() {
		return feedAmount;
	}
	public void setFeedAmount(int feedAmount) {
		this.feedAmount = feedAmount;
	}
	public int getDaysLimit() {
		return daysLimit;
	}
	public void setDaysLimit(int daysLimit) {
		this.daysLimit = daysLimit;
	}
	public int getCashId() {
		return cashId;
	}
	public void setCashId(int cashId) {
		this.cashId = cashId;
	}
	public List<ClientCreditInfo> getCreditBills() {
		return creditBills;
	}
	public void setCreditBills(List<ClientCreditInfo> creditBills) {
		this.creditBills = creditBills;
	}
	public int getReturnBillId() {
		return returnBillId;
	}
	public void setReturnBillId(int returnBillId) {
		this.returnBillId = returnBillId;
	}
	public int getReturnBillDate() {
		return returnBillDate;
	}
	public void setReturnBillDate(int returnBillDate) {
		this.returnBillDate = returnBillDate;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

}
