package ni.com.casapellas.gcpmcaja.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Clientinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String address;
	private double antiquity;
	private String countryname;
	private String city;
	private int customercode;
	private String customername;
	private String districtcode;
	private String email;
	private String fax;
	private String gender;
	private String id;
	private String major;
	private String maritalstatus;
	private String mobile;
	private String municipalitydescription;
	private String noruc;
	private double otherincomes;
	private String phone;
	private String position;
	private String postalcode;
	private double salary;
	private String type;
	private String workplace;
	


	private List<Vcustomerphone> lstCustomerPhones = new ArrayList<Vcustomerphone>();
	private List<CustomerReferences> lstCustomerReferences = new ArrayList<CustomerReferences>();

	public Clientinfo() {
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getAntiquity() {
		return antiquity;
	}

	public void setAntiquity(double antiquity) {
		this.antiquity = antiquity;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCustomercode() {
		return customercode;
	}

	public void setCustomercode(int customercode) {
		this.customercode = customercode;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getDistrictcode() {
		return districtcode;
	}

	public void setDistrictcode(String districtcode) {
		this.districtcode = districtcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMunicipalitydescription() {
		return municipalitydescription;
	}

	public void setMunicipalitydescription(String municipalitydescription) {
		this.municipalitydescription = municipalitydescription;
	}

	public String getNoruc() {
		return noruc;
	}

	public void setNoruc(String noruc) {
		this.noruc = noruc;
	}

	public double getOtherincomes() {
		return otherincomes;
	}

	public void setOtherincomes(double otherincomes) {
		this.otherincomes = otherincomes;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Vcustomerphone> getLstCustomerPhones() {
		return lstCustomerPhones;
	}

	public void setLstCustomerPhones(List<Vcustomerphone> lstCustomerPhones) {
		this.lstCustomerPhones = lstCustomerPhones;
	}

	public List<CustomerReferences> getLstCustomerReferences() {
		return lstCustomerReferences;
	}

	public void setLstCustomerReferences(List<CustomerReferences> lstCustomerReferences) {
		this.lstCustomerReferences = lstCustomerReferences;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	

}