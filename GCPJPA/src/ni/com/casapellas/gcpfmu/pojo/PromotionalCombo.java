package ni.com.casapellas.gcpfmu.pojo;

public class PromotionalCombo {
	
	private String companyId;
	private String lineId;
	private String comboId;
	private String productId;
	private int quantity;
	private float discount;
	private int initialDate;
	private int endDate;
	private String comboName;
	private String comboState;

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public String getComboId() {
		return comboId;
	}

	public void setComboId(String comboId) {
		this.comboId = comboId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}


	public String getComboName() {
		return comboName;
	}

	public void setComboName(String comboName) {
		this.comboName = comboName;
	}

	public String getComboState() {
		return comboState;
	}

	public void setComboState(String comboState) {
		this.comboState = comboState;
	}

	public int getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(int initialDate) {
		this.initialDate = initialDate;
	}

}
