package ni.com.casapellas.gcpfmu.pojo;

import java.util.List;

public class SellerConfig {
	private int sellerId;
	private String zoneId;
	private String branchId;
	private String cellarId;
	private String userId;
	private String deliverId;
	private String deliverIdPre;


	// For web Admin
	private String branchName;
	
	// For companies
	private List<GeneralCatalog> companies;
	
	// For Lines
	private List<GeneralCatalog> lines;
	
	// Seller Info
	private Seller seller; 
	
	// For Brands
	private List<GeneralCatalog> branches;


	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
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
	public List<GeneralCatalog> getCompanies() {
		return companies;
	}
	public void setCompanies(List<GeneralCatalog> companies) {
		this.companies = companies;
	}
	public List<GeneralCatalog> getLines() {
		return lines;
	}
	public void setLines(List<GeneralCatalog> lines) {
		this.lines = lines;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public List<GeneralCatalog> getBranches() {
		return branches;
	}
	public void setBranches(List<GeneralCatalog> branches) {
		this.branches = branches;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getDeliverId() {
		return deliverId;
	}
	public void setDeliverId(String deliverId) {
		this.deliverId = deliverId;
	}
	public String getDeliverIdPre() {
		return deliverIdPre;
	}
	public void setDeliverIdPre(String deliverIdPre) {
		this.deliverIdPre = deliverIdPre;
	}
	

}
