package ni.com.casapellas.gcpmcaja.pojos;

import java.io.Serializable;

public class Vcustomerphone implements Serializable {
	private static final long serialVersionUID = 1L;

	private String number;
	private String prefix;
	private String type;
	private int customerCode;

	public Vcustomerphone() {
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}

}