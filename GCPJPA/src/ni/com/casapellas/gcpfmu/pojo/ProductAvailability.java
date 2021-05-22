package ni.com.casapellas.gcpfmu.pojo;

public class ProductAvailability {

	private String companyId;
	private String branchId;
	private String cellarId;
	private String productId;
	private int available;
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getCellarId() {
		return cellarId;
	}
	public void setCellarId(String cellarId) {
		this.cellarId = cellarId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	
}
