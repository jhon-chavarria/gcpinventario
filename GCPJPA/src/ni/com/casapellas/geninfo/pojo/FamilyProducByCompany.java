package ni.com.casapellas.geninfo.pojo;

import java.util.ArrayList;
import java.util.List;

public class FamilyProducByCompany {

	public String companyCode;
	public String companyName;
	public List<String> productFamily = new ArrayList<String>();
	public List<String> expiredDocuments = new ArrayList<String>();
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public List<String> getProductFamily() {
		return productFamily;
	}
	public void addProductFamily(String productFamily) {
		this.productFamily.add(productFamily);
	}
	public List<String> getExpiredDocuments() {
		return expiredDocuments;
	}
	public void addExpiredDocuments(String expiredDocuments) {
		this.expiredDocuments.add(expiredDocuments);
	}
	
	
	
	
	
}
