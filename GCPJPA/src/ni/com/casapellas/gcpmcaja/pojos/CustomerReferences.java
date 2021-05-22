package ni.com.casapellas.gcpmcaja.pojos;

import java.io.Serializable;

public class CustomerReferences implements Serializable {
	private static final long serialVersionUID = 1L;

	private String referencename;
	private String companyname;
	private String phone;
	private String ruc;
	public String getReferencename() {
		return referencename;
	}
	public void setReferencename(String referencename) {
		this.referencename = referencename;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
	
	
}