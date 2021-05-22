package ni.com.casapellas.gcpfmu.pojo;

public class CashReceipt {

	private int receiptNumber;
	private float applyAmount;
	private float receivedAmount;
	private String concept;
	private String typeReceipt;
	private String clientName;
	private int codCli;
	private String sellerName;
	private String jdCompanyId;
	private int cashId;
    private int cashSheetId;

	private String jdBranchId;
	private String jdLineId;
	private String coin;
	private String userId;
    private String softwareId;
	private boolean sync;
    private String corAccount;
    private int date;
    private int hour;
    private String cellarId;

    private String corAccountPart1;
    private String corAccountPart2;
    private String corAccountPart3;
    private String account;
    private String companyId2;
    private float exchange;
    
    // for Authorization
    private int code;
    private String typeCode;

    // JDE
    private int batchNumber;
    private int jdeReceiptNumber;
    
    private String deviceId;

	public int getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(int receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	public float getApplyAmount() {
		return applyAmount;
	}

	public void setApplyAmount(float applyAmount) {
		this.applyAmount = applyAmount;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public String getTypeReceipt() {
		return typeReceipt;
	}

	public void setTypeReceipt(String typeReceipt) {
		this.typeReceipt = typeReceipt;
	}

	/*public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}*/

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getCodCli() {
		return codCli;
	}

	public void setCodCli(int codCli) {
		this.codCli = codCli;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getJdBranchId() {
		return jdBranchId;
	}

	public void setJdBranchId(String jdBranchId) {
		this.jdBranchId = jdBranchId;
	}

	public String getJdLineId() {
		return jdLineId;
	}

	public void setJdLineId(String jdLineId) {
		this.jdLineId = jdLineId;
	}

	public String getCoin() {
		return coin;
	}

	public void setCoin(String coin) {
		this.coin = coin;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isSync() {
		return sync;
	}

	public void setSync(boolean sync) {
		this.sync = sync;
	}

	public String getJdCompanyId() {
		return jdCompanyId;
	}

	public void setJdCompanyId(String jdCompanyId) {
		this.jdCompanyId = jdCompanyId;
	}

	public float getReceivedAmount() {
		return receivedAmount;
	}

	public void setReceivedAmount(float receivedAmount) {
		this.receivedAmount = receivedAmount;
	}


	public float getExchange() {
		return exchange;
	}

	public void setExchange(float exchange) {
		this.exchange = exchange;
	}

	public String getCorAccount() {
		return corAccount;
	}

	public void setCorAccount(String corAccount) {
		this.corAccount = corAccount;
	}

	public String getCorAccountPart1() {
		return corAccountPart1;
	}

	public void setCorAccountPart1(String corAccountPart1) {
		this.corAccountPart1 = corAccountPart1;
	}

	public String getCorAccountPart2() {
		return corAccountPart2;
	}

	public void setCorAccountPart2(String corAccountPart2) {
		this.corAccountPart2 = corAccountPart2;
	}

	public String getCorAccountPart3() {
		return corAccountPart3;
	}

	public void setCorAccountPart3(String corAccountPart3) {
		this.corAccountPart3 = corAccountPart3;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCompanyId2() {
		return companyId2;
	}

	public void setCompanyId2(String companyId2) {
		this.companyId2 = companyId2;
	}

	public String getSoftwareId() {
		return softwareId;
	}

	public void setSoftwareId(String softwareId) {
		this.softwareId = softwareId;
	}

	public int getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(int batchNumber) {
		this.batchNumber = batchNumber;
	}

	public int getJdeReceiptNumber() {
		return jdeReceiptNumber;
	}

	public void setJdeReceiptNumber(int jdeReceiptNumber) {
		this.jdeReceiptNumber = jdeReceiptNumber;
	}

	public int getCashId() {
		return cashId;
	}

	public void setCashId(int cashId) {
		this.cashId = cashId;
	}

	public int getCashSheetId() {
		return cashSheetId;
	}

	public void setCashSheetId(int cashSheetId) {
		this.cashSheetId = cashSheetId;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
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

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public String getCellarId() {
		return cellarId;
	}

	public void setCellarId(String cellarId) {
		this.cellarId = cellarId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
