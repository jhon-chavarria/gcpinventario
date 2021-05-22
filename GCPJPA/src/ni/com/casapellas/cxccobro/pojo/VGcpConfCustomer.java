package ni.com.casapellas.cxccobro.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


public class VGcpConfCustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	private int code;
	private String business_Name;
	private String country_Code;
	private String country_Name;
	private BigDecimal credit_Limit;
	private String customer_Category_Description;
	private String customer_Segment7_Description;
	private String customer_Segment8_Description;
	private String customer_Segment4_Description;
	private String district_Code;
	private String district_Name;
	private String emails;
	private String first_Name;
	private String id_Business_Name;
	private String id_Customer_Category_Code;
	private String id_Customer_Segment7_Code;
	private String id_Customer_Segment8_Code;
	private String id_Treatment_Type_Code;
	private String identification;
	private String last_Name;
	private String municipality_Code;
	private String municipality_Description;
	private String name;
	private String phones;
	private String second_Name;
	private short status;
	private String street_Address;  
	private String treatment_Type_Description;
	private String contacts;

	public VGcpConfCustomer() {
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getBusiness_Name() {
		return business_Name;
	}

	public void setBusiness_Name(String business_Name) {
		this.business_Name = business_Name;
	}

	public String getCountry_Code() {
		return country_Code;
	}

	public void setCountry_Code(String country_Code) {
		this.country_Code = country_Code;
	}

	public String getCountry_Name() {
		return country_Name;
	}

	public void setCountry_Name(String country_Name) {
		this.country_Name = country_Name;
	}

	public BigDecimal getCredit_Limit() {
		return credit_Limit;
	}

	public void setCredit_Limit(BigDecimal credit_Limit) {
		this.credit_Limit = credit_Limit;
	}

	public String getCustomer_Category_Description() {
		return customer_Category_Description;
	}

	public void setCustomer_Category_Description(
			String customer_Category_Description) {
		this.customer_Category_Description = customer_Category_Description;
	}

	public String getCustomer_Segment7_Description() {
		return customer_Segment7_Description;
	}

	public void setCustomer_Segment7_Description(
			String customer_Segment7_Description) {
		this.customer_Segment7_Description = customer_Segment7_Description;
	}

	public String getCustomer_Segment8_Description() {
		return customer_Segment8_Description;
	}

	public void setCustomer_Segment8_Description(
			String customer_Segment8_Description) {
		this.customer_Segment8_Description = customer_Segment8_Description;
	}

	public String getDistrict_Code() {
		return district_Code;
	}

	public void setDistrict_Code(String district_Code) {
		this.district_Code = district_Code;
	}

	public String getDistrict_Name() {
		return district_Name;
	}

	public void setDistrict_Name(String district_Name) {
		this.district_Name = district_Name;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getId_Business_Name() {
		return id_Business_Name;
	}

	public void setId_Business_Name(String id_Business_Name) {
		this.id_Business_Name = id_Business_Name;
	}

	public String getId_Customer_Category_Code() {
		return id_Customer_Category_Code;
	}

	public void setId_Customer_Category_Code(String id_Customer_Category_Code) {
		this.id_Customer_Category_Code = id_Customer_Category_Code;
	}

	public String getId_Customer_Segment7_Code() {
		return id_Customer_Segment7_Code;
	}

	public void setId_Customer_Segment7_Code(String id_Customer_Segment7_Code) {
		this.id_Customer_Segment7_Code = id_Customer_Segment7_Code;
	}

	public String getId_Customer_Segment8_Code() {
		return id_Customer_Segment8_Code;
	}

	public void setId_Customer_Segment8_Code(String id_Customer_Segment8_Code) {
		this.id_Customer_Segment8_Code = id_Customer_Segment8_Code;
	}

	public String getId_Treatment_Type_Code() {
		return id_Treatment_Type_Code;
	}

	public void setId_Treatment_Type_Code(String id_Treatment_Type_Code) {
		this.id_Treatment_Type_Code = id_Treatment_Type_Code;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getMunicipality_Code() {
		return municipality_Code;
	}

	public void setMunicipality_Code(String municipality_Code) {
		this.municipality_Code = municipality_Code;
	}

	public String getMunicipality_Description() {
		return municipality_Description;
	}

	public void setMunicipality_Description(String municipality_Description) {
		this.municipality_Description = municipality_Description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhones() {
		return phones;
	}

	public void setPhones(String phones) {
		this.phones = phones;
	}

	public String getSecond_Name() {
		return second_Name;
	}

	public void setSecond_Name(String second_Name) {
		this.second_Name = second_Name;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getStreet_Address() {
		return street_Address;
	}

	public void setStreet_Address(String street_Address) {
		this.street_Address = street_Address;
	}

	public String getTreatment_Type_Description() {
		return treatment_Type_Description;
	}

	public void setTreatment_Type_Description(String treatment_Type_Description) {
		this.treatment_Type_Description = treatment_Type_Description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getCustomer_Segment4_Description() {
		return customer_Segment4_Description;
	}

	public void setCustomer_Segment4_Description(
			String customer_Segment4_Description) {
		this.customer_Segment4_Description = customer_Segment4_Description;
	}


}