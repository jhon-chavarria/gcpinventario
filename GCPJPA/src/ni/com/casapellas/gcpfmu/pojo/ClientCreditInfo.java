package ni.com.casapellas.gcpfmu.pojo;

import java.util.Date;

public class ClientCreditInfo {
	
	private String branchId;
	private String lineId;
	private String documentType;
	private int billId;
	private String date;
	private String paymentDay;
	private float importeBrutoCR;
	private float corBalance;	
	private float corImporteNotIva;	
	private float corIva;	
	private String coin;
	private float exchange;
	private float importeBrutoDR;
	private float drBalance;	
	private float drImporteNotIva;	
	private float drIva;	
	private int clientId;
	private String fee;
	private String jdLineName;
	private String jdCompanyId;
	private String jdCompanyName;
	private String clientName;
	private String clientType;

	
	  // For accounting
    // Account
    private String accountPart1;
    private String accountPart2;
    private String accountPart3;
    private String account;

    private String accountRegistered;
 
    private int payDate;
    
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getLineId() {
		return lineId;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPaymentDay() {
		return paymentDay;
	}
	public void setPaymentDay(String paymentDay) {
		this.paymentDay = paymentDay;
	}

	public float getCorBalance() {
		return corBalance;
	}
	public void setCorBalance(float corBalance) {
		this.corBalance = corBalance;
	}
	public float getImporteBrutoCR() {
		return importeBrutoCR;
	}
	public void setImporteBrutoCR(float importeBrutoCR) {
		this.importeBrutoCR = importeBrutoCR;
	}
	public String getCoin() {
		return coin;
	}
	public void setCoin(String coin) {
		this.coin = coin;
	}
	public float getExchange() {
		return exchange;
	}
	public void setExchange(float exchange) {
		this.exchange = exchange;
	}
	public float getImporteBrutoDR() {
		return importeBrutoDR;
	}
	public void setImporteBrutoDR(float importeBrutoDR) {
		this.importeBrutoDR = importeBrutoDR;
	}
	public float getDrBalance() {
		return drBalance;
	}
	public void setDrBalance(float drBalance) {
		this.drBalance = drBalance;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	
	public float getCorIva() {
		return corIva;
	}
	public void setCorIva(float corIva) {
		this.corIva = corIva;
	}

	public float getDrIva() {
		return drIva;
	}
	public void setDrIva(float drIva) {
		this.drIva = drIva;
	}
	public float getCorImporteNotIva() {
		return corImporteNotIva;
	}
	public void setCorImporteNotIva(float corImporteNotIva) {
		this.corImporteNotIva = corImporteNotIva;
	}
	public float getDrImporteNotIva() {
		return drImporteNotIva;
	}
	public void setDrImporteNotIva(float drImporteNotIva) {
		this.drImporteNotIva = drImporteNotIva;
	}
	public String getJdLineName() {
		return jdLineName;
	}
	public void setJdLineName(String jdLineName) {
		this.jdLineName = jdLineName;
	}
	public String getJdCompanyId() {
		return jdCompanyId;
	}
	public void setJdCompanyId(String jdCompanyId) {
		this.jdCompanyId = jdCompanyId;
	}
	public String getJdCompanyName() {
		return jdCompanyName;
	}
	public void setJdCompanyName(String jdCompanyName) {
		this.jdCompanyName = jdCompanyName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getAccountPart1() {
		return accountPart1;
	}
	public void setAccountPart1(String accountPart1) {
		this.accountPart1 = accountPart1;
	}
	public String getAccountPart2() {
		return accountPart2;
	}
	public void setAccountPart2(String accountPart2) {
		this.accountPart2 = accountPart2;
	}
	public String getAccountPart3() {
		return accountPart3;
	}
	public void setAccountPart3(String accountPart3) {
		this.accountPart3 = accountPart3;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccountRegistered() {
		return accountRegistered;
	}
	public void setAccountRegistered(String accountRegistered) {
		this.accountRegistered = accountRegistered;
	}
	public int getPayDate() {
		return payDate;
	}
	public void setPayDate(int payDate) {
		this.payDate = payDate;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
}
