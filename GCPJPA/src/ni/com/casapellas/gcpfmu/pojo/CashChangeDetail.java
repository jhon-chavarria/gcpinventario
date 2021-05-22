package ni.com.casapellas.gcpfmu.pojo;

public class CashChangeDetail {
	private int receiptNumber;
	private String coin;
	private float change;
	private String branchId;
	private int cashId;
	private float exchange;
	private String type;
	private String jdCompanyId;

	public int getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(int receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	public String getCoin() {
		return coin;
	}

	public void setCoin(String coin) {
		this.coin = coin;
	}

	public float getChange() {
		return change;
	}

	public void setChange(float change) {
		this.change = change;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public float getExchange() {
		return exchange;
	}

	public void setExchange(float exchange) {
		this.exchange = exchange;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCashId() {
		return cashId;
	}

	public void setCashId(int cashId) {
		this.cashId = cashId;
	}

	public String getJdCompanyId() {
		return jdCompanyId;
	}

	public void setJdCompanyId(String jdCompanyId) {
		this.jdCompanyId = jdCompanyId;
	}
}
