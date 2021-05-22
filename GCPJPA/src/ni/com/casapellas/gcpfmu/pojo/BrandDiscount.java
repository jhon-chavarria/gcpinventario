package ni.com.casapellas.gcpfmu.pojo;

public class BrandDiscount {

	private String brandId;
	private String companyId;
	private int percentDiscount;
	private String departmentId;
	private int lineId;
	private float montoFactI;
	private float montoFactS;
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public int getLineId() {
		return lineId;
	}
	public void setLineId(int lineId) {
		this.lineId = lineId;
	}
	public float getMontoFactI() {
		return montoFactI;
	}
	public void setMontoFactI(float montoFactI) {
		this.montoFactI = montoFactI;
	}
	public float getMontoFactS() {
		return montoFactS;
	}
	public void setMontoFactS(float montoFactS) {
		this.montoFactS = montoFactS;
	}
	public int getPercentDiscount() {
		return percentDiscount;
	}
	public void setPercentDiscount(int percentDiscount) {
		this.percentDiscount = percentDiscount;
	}
	
}
