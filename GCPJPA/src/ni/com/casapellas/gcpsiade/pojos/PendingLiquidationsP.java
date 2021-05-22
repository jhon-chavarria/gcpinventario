package ni.com.casapellas.gcpsiade.pojos;

public class PendingLiquidationsP {

	private String nparte;
	private int quantity;
	private int liquidation_number;
	private String cashbox;
	private String type;
	private String arrive_date;
	private int requested;
	private int invoice;

	public String getNparte() {
		return nparte;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getLiquidation_number() {
		return liquidation_number;
	}

	public String getArrive_date() {
		return arrive_date;
	}

	public void setNparte(String nparte) {
		this.nparte = nparte;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setLiquidation_number(int liquidation_number) {
		this.liquidation_number = liquidation_number;
	}

	public void setArrive_date(String arrive_date) {
		this.arrive_date = arrive_date;
	}

	public String getCashbox() {
		return cashbox;
	}

	public void setCashbox(String cashbox) {
		this.cashbox = cashbox;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRequested() {
		return requested;
	}

	public void setRequested(int requested) {
		this.requested = requested;
	}

	public int getInvoice() {
		return invoice;
	}

	public void setInvoice(int invoice) {
		this.invoice = invoice;
	}

}
