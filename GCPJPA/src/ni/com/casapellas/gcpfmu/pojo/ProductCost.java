package ni.com.casapellas.gcpfmu.pojo;

public class ProductCost {

	private String companyId;
	private String branchId;
	private String categoryId;
	private float uniqueCost;
	private float globalCost;
	private String productId;
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
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
	public float getUniqueCost() {
		return uniqueCost;
	}
	public void setUniqueCost(float uniqueCost) {
		this.uniqueCost = uniqueCost;
	}
	public float getGlobalCost() {
		return globalCost;
	}
	public void setGlobalCost(float globalCost) {
		this.globalCost = globalCost;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}
