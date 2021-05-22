package ni.com.casapellas.cxccobro.pojo;//ni.com.casapellas.cxccobro.entity.GcpConfCatalogo

import ni.com.casapellas.geninfo.pojo.ResponseFromServer;


public class GcpConfCustomerPhoneNotification {
	private int id;
	private int customerCode;
	private int sms;
	private int email;
	private int status;
	private int type;
	private ResponseFromServer response;

	public GcpConfCustomerPhoneNotification() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}

	public int getSms() {
		return sms;
	}

	public void setSms(int sms) {
		this.sms = sms;
	}

	public int getEmail() {
		return email;
	}

	public void setEmail(int email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ResponseFromServer getResponse() {
		return response;
	}

	public void setResponse(ResponseFromServer response) {
		this.response = response;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
