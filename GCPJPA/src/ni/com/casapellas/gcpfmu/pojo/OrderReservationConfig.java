package ni.com.casapellas.gcpfmu.pojo;


public class OrderReservationConfig {

	private int sellerId;
	private String branchId;
	private String cellarId;
	private String companyId;
	private String lineId;
	private int totalAvailable;

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
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

	public int getTotalAvailable() {
		return totalAvailable;
	}

	public void setTotalAvailable(int totalAvailable) {
		this.totalAvailable = totalAvailable;
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
	
}