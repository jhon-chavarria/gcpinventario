package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

public class VclientesGcp implements Serializable {
	private static final long serialVersionUID = 1L;

	private int code;
	private String companyIdentification= "";
	private String countryCode = "";
	private String countryName = "";
	private String creditLimit = "";
	private String customerCategoryDescription  = "";
	private String customerSegmentDescriptionCat4 = "";
	private String customerSegmentDescriptionCat7 = "";
	private String customerSegmentDescriptionCat8= "";
	private String customerStatus = "";
	private String districtCode = "";
	private String districtName = "";
	private String emails = "";
	private int employee;
	private String firstName = "";
	private String idBusinessName = "";
	private String idCustomerCategoryCode = "";
	private String idCustomerSegmentCodeCat4 = "";
	private String idCustomerSegmentCodeCat7 = "";
	private String idCustomerSegmentCodeCat8 = "";
	private String lastName = "";
	private String municipalityCode = "";
	private String municipalityDescription = ""; 
	private String name = "";
	private String naturalIdentification = "";
	private String phones = "";
	private String secondName = "";
	private String streetAddress = "";

	public VclientesGcp() {
	}

	 

	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	public String getCompanyIdentification() {
		return this.companyIdentification;
	}

	public void setCompanyIdentification(String companyIdentification) {
		this.companyIdentification = companyIdentification;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCreditLimit() {
		return this.creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getCustomerCategoryDescription() {
		return this.customerCategoryDescription;
	}

	public void setCustomerCategoryDescription(String customerCategoryDescription) {
		this.customerCategoryDescription = customerCategoryDescription;
	}

	public String getCustomerSegmentDescriptionCat4() {
		return this.customerSegmentDescriptionCat4;
	}

	public void setCustomerSegmentDescriptionCat4(String customerSegmentDescriptionCat4) {
		this.customerSegmentDescriptionCat4 = customerSegmentDescriptionCat4;
	}

	public String getCustomerSegmentDescriptionCat7() {
		return this.customerSegmentDescriptionCat7;
	}

	public void setCustomerSegmentDescriptionCat7(String customerSegmentDescriptionCat7) {
		this.customerSegmentDescriptionCat7 = customerSegmentDescriptionCat7;
	}

	public String getCustomerSegmentDescriptionCat8() {
		return this.customerSegmentDescriptionCat8;
	}

	public void setCustomerSegmentDescriptionCat8(String customerSegmentDescriptionCat8) {
		this.customerSegmentDescriptionCat8 = customerSegmentDescriptionCat8;
	}

	public String getCustomerStatus() {
		return this.customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}

	public String getDistrictCode() {
		return this.districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictName() {
		return this.districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getEmails() {
		return this.emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public int getEmployee() {
		return this.employee;
	}

	public void setEmployee(int employee) {
		this.employee = employee;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getIdBusinessName() {
		return this.idBusinessName;
	}

	public void setIdBusinessName(String idBusinessName) {
		this.idBusinessName = idBusinessName;
	}

	public String getIdCustomerCategoryCode() {
		return this.idCustomerCategoryCode;
	}

	public void setIdCustomerCategoryCode(String idCustomerCategoryCode) {
		this.idCustomerCategoryCode = idCustomerCategoryCode;
	}

	public String getIdCustomerSegmentCodeCat4() {
		return this.idCustomerSegmentCodeCat4;
	}

	public void setIdCustomerSegmentCodeCat4(String idCustomerSegmentCodeCat4) {
		this.idCustomerSegmentCodeCat4 = idCustomerSegmentCodeCat4;
	}

	public String getIdCustomerSegmentCodeCat7() {
		return this.idCustomerSegmentCodeCat7;
	}

	public void setIdCustomerSegmentCodeCat7(String idCustomerSegmentCodeCat7) {
		this.idCustomerSegmentCodeCat7 = idCustomerSegmentCodeCat7;
	}

	public String getIdCustomerSegmentCodeCat8() {
		return this.idCustomerSegmentCodeCat8;
	}

	public void setIdCustomerSegmentCodeCat8(String idCustomerSegmentCodeCat8) {
		this.idCustomerSegmentCodeCat8 = idCustomerSegmentCodeCat8;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMunicipalityCode() {
		return this.municipalityCode;
	}

	public void setMunicipalityCode(String municipalityCode) {
		this.municipalityCode = municipalityCode;
	}

	public String getMunicipalityDescription() {
		return this.municipalityDescription;
	}

	public void setMunicipalityDescription(String municipalityDescription) {
		this.municipalityDescription = municipalityDescription;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNaturalIdentification() {
		return this.naturalIdentification;
	}

	public void setNaturalIdentification(String naturalIdentification) {
		this.naturalIdentification = naturalIdentification;
	}

	public String getPhones() {
		return this.phones;
	}

	public void setPhones(String phones) {
		this.phones = phones;
	}

	public String getSecondName() {
		return this.secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

}