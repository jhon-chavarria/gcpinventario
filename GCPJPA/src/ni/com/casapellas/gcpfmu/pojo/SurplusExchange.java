package ni.com.casapellas.gcpfmu.pojo;

public class SurplusExchange {

	private int receiptId;
	private int cashId;
	private float amount;
	private float diffAmount;
	private float exchange;
	private String coin;
	private String type;
    private float diffExchangeAmount;
    private String jdCompanyId;

    private String accountPart1;
    private String accountPart2;
    private String accountPart3;
    private String account;
    private String companyId2;
    private String account2;
    private String coinLastPaymentItem;

	
    private int billId;
    private String billType;

	public int getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}

	public int getCashId() {
		return cashId;
	}

	public void setCashId(int cashId) {
		this.cashId = cashId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getDiffAmount() {
		return diffAmount;
	}

	public void setDiffAmount(float diffAmount) {
		this.diffAmount = diffAmount;
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

	public float getDiffExchangeAmount() {
		return diffExchangeAmount;
	}

	public void setDiffExchangeAmount(float diffExchangeAmount) {
		this.diffExchangeAmount = diffExchangeAmount;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
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

	public String getCompanyId2() {
		return companyId2;
	}

	public void setCompanyId2(String companyId2) {
		this.companyId2 = companyId2;
	}

	public String getAccount2() {
		return account2;
	}

	public void setAccount2(String account2) {
		this.account2 = account2;
	}

	public String getCoinLastPaymentItem() {
		return coinLastPaymentItem;
	}

	public void setCoinLastPaymentItem(String coinLastPaymentItem) {
		this.coinLastPaymentItem = coinLastPaymentItem;
	}

	public String getJdCompanyId() {
		return jdCompanyId;
	}

	public void setJdCompanyId(String jdCompanyId) {
		this.jdCompanyId = jdCompanyId;
	}
}
