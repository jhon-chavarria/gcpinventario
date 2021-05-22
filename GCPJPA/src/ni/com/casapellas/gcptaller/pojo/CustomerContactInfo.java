package ni.com.casapellas.gcptaller.pojo;

public class CustomerContactInfo {
	private Integer CustomerCode;
	private String TelephoneType;
	private String Prefix;
	private String Telephone;
	private String PrimaryEmail;
	private String extencion;
	
	public String getTelephoneType() {
		return TelephoneType;
	}
	public void setTelephoneType(String telephoneType) {
		TelephoneType = telephoneType;
	}
	public String getPrefix() {
		return Prefix;
	}
	public void setPrefix(String prefix) {
		Prefix = prefix;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getPrimaryEmail() {
		return PrimaryEmail;
	}
	public void setPrimaryEmail(String primaryEmail) {
		PrimaryEmail = primaryEmail;
	}
	public Integer getCustomerCode() {
		return CustomerCode;
	}
	public void setCustomerCode(Integer customerCode) {
		CustomerCode = customerCode;
	}
	public String getExtencion() {
		return extencion;
	}
	public void setExtencion(String extencion) {
		this.extencion = extencion;
	}
}
