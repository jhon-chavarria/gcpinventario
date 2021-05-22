package ni.com.casapellas.geninfo.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the VCUSTOMER_DETAIL database table.
 * 
 */

public class VcustomerDetail implements Serializable {

	private String businessName;
	private int code;
	private String countryCode;
	private String countryName;
	private BigDecimal creditLimit;
	private String customerCategoryDescription;
	private String customerSegment7Description;
	private String customerSegment8Description;
	private String districtCode;
	private String districtName;
	private String emails;
	private String firstName;
	private String idBusinessLine;
	private String idBusinessName;
	private int idCreditLine;
	private String idCustomerCategoryCode;
	private String idCustomerSegment7Code;
	private String idCustomerSegment8Code;
	private String idTreatmentTypeCode;
	private String identification;
	private String lastName;
	private String municipalityCode;
	private String municipalityDescription;
	private String name;
	private String phones;
	private String secondName;
	private short status;
	private String streetAddress;
	private String treatmentTypeDescription;

	public VcustomerDetail() {
	}

	public String getBusinessName() {
		return this.businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
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

	public BigDecimal getCreditLimit() {
		return this.creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getCustomerCategoryDescription() {
		return this.customerCategoryDescription;
	}

	public void setCustomerCategoryDescription(String customerCategoryDescription) {
		this.customerCategoryDescription = customerCategoryDescription;
	}

	public String getCustomerSegment7Description() {
		return this.customerSegment7Description;
	}

	public void setCustomerSegment7Description(String customerSegment7Description) {
		this.customerSegment7Description = customerSegment7Description;
	}

	public String getCustomerSegment8Description() {
		return this.customerSegment8Description;
	}

	public void setCustomerSegment8Description(String customerSegment8Description) {
		this.customerSegment8Description = customerSegment8Description;
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

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getIdBusinessLine() {
		return this.idBusinessLine;
	}

	public void setIdBusinessLine(String idBusinessLine) {
		this.idBusinessLine = idBusinessLine;
	}

	public String getIdBusinessName() {
		return this.idBusinessName;
	}

	public void setIdBusinessName(String idBusinessName) {
		this.idBusinessName = idBusinessName;
	}

	public int getIdCreditLine() {
		return this.idCreditLine;
	}

	public void setIdCreditLine(int idCreditLine) {
		this.idCreditLine = idCreditLine;
	}

	public String getIdCustomerCategoryCode() {
		return this.idCustomerCategoryCode;
	}

	public void setIdCustomerCategoryCode(String idCustomerCategoryCode) {
		this.idCustomerCategoryCode = idCustomerCategoryCode;
	}

	public String getIdCustomerSegment7Code() {
		return this.idCustomerSegment7Code;
	}

	public void setIdCustomerSegment7Code(String idCustomerSegment7Code) {
		this.idCustomerSegment7Code = idCustomerSegment7Code;
	}

	public String getIdCustomerSegment8Code() {
		return this.idCustomerSegment8Code;
	}

	public void setIdCustomerSegment8Code(String idCustomerSegment8Code) {
		this.idCustomerSegment8Code = idCustomerSegment8Code;
	}

	public String getIdTreatmentTypeCode() {
		return this.idTreatmentTypeCode;
	}

	public void setIdTreatmentTypeCode(String idTreatmentTypeCode) {
		this.idTreatmentTypeCode = idTreatmentTypeCode;
	}

	public String getIdentification() {
		return this.identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
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

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getTreatmentTypeDescription() {
		return this.treatmentTypeDescription;
	}

	public void setTreatmentTypeDescription(String treatmentTypeDescription) {
		this.treatmentTypeDescription = treatmentTypeDescription;
	}

}