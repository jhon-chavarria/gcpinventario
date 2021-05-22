package ni.com.casapellas.gcpcxccobro.pojos;

public class PositiveBalance {
	
	private String branch;
	private String documentType;
	private String date;
	private double amountCor;
	private double amountUsd;
	private String checkout;
	private String cashier;

	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAmountCor() {
		return amountCor;
	}
	public void setAmountCor(double amountCor) {
		this.amountCor = amountCor;
	}
	public double getAmountUsd() {
		return amountUsd;
	}
	public void setAmountUsd(double amountUsd) {
		this.amountUsd = amountUsd;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public String getCashier() {
		return cashier;
	}
	public void setCashier(String cashier) {
		this.cashier = cashier;
	}
	
	
	

}
