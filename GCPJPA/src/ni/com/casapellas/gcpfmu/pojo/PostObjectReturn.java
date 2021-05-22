package ni.com.casapellas.gcpfmu.pojo;

import java.util.List;

public class PostObjectReturn {
	
	// Bill
	private String companyId;
	private int clientId;
	private boolean state;
    private String movementType;
    
    // for receipt
	private int batchNumber;
	
	// also used for receipt Number on bill
	private int jdeNumber;
	
	// Both
	private String billId;
    private String errorMsg;
    
    // For order detail
    private List<OrderDetail> orderDetails;
    
    private boolean useCustomErrorMsg;
    
    // For credit card itech device.
    private List<CashReceiptPaymentItem> cashReceiptPaymentItems;
    private List<CashBillReceiptRelation> cashBillReceiptRelation;

 
    
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getMovementType() {
		return movementType;
	}
	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}
	public int getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(int batchNumber) {
		this.batchNumber = batchNumber;
	}
	public int getJdeNumber() {
		return jdeNumber;
	}
	public void setJdeNumber(int jdeNumber) {
		this.jdeNumber = jdeNumber;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public List<CashReceiptPaymentItem> getCashReceiptPaymentItems() {
		return cashReceiptPaymentItems;
	}
	public void setCashReceiptPaymentItems(List<CashReceiptPaymentItem> cashReceiptPaymentItems) {
		this.cashReceiptPaymentItems = cashReceiptPaymentItems;
	}
	public boolean isUseCustomErrorMsg() {
		return useCustomErrorMsg;
	}
	public void setUseCustomErrorMsg(boolean useCustomErrorMsg) {
		this.useCustomErrorMsg = useCustomErrorMsg;
	}
	public List<CashBillReceiptRelation> getCashBillReceiptRelation() {
		return cashBillReceiptRelation;
	}
	public void setCashBillReceiptRelation(List<CashBillReceiptRelation> cashBillReceiptRelation) {
		this.cashBillReceiptRelation = cashBillReceiptRelation;
	}
}
