package ni.com.casapellas.gcpfmu.pojo;

public class CLientBrandDiscount {

	private int clientId;
	private String companyId;
	private int percentDiscount;
	private String brandId;

	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public int getPercentDiscount() {
		return percentDiscount;
	}
	public void setPercentDiscount(int percentDiscount) {
		this.percentDiscount = percentDiscount;
	}
}
