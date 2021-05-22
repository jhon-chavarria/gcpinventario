package ni.com.casapellas.gcpfmu.pojo;

public class OrderReservation {
	
	private int sellerId;
	private String branchReservationId;
	private String cellarReservationId;
	private int quantityReservation;
	private String productId;
	private int orderId;
	private String companyReservationId;
	private String lineReservationId;
	
	// Detail Oorder
	private int quantity;
	private String lineId;
	private String companyId;
	private String categoryId;

	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getBranchReservationId() {
		return branchReservationId;
	}
	public void setBranchReservationId(String branchReservationId) {
		this.branchReservationId = branchReservationId;
	}
	public String getCellarReservationId() {
		return cellarReservationId;
	}
	public void setCellarReservationId(String cellarReservationId) {
		this.cellarReservationId = cellarReservationId;
	}
	public int getQuantityReservation() {
		return quantityReservation;
	}
	public void setQuantityReservation(int quantityReservation) {
		this.quantityReservation = quantityReservation;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
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

	public String getCompanyReservationId() {
		return companyReservationId;
	}
	public void setCompanyReservationId(String companyReservationId) {
		this.companyReservationId = companyReservationId;
	}
	public String getLineReservationId() {
		return lineReservationId;
	}
	public void setLineReservationId(String lineReservationId) {
		this.lineReservationId = lineReservationId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

}