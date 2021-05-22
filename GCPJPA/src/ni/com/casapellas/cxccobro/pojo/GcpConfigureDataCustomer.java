package ni.com.casapellas.cxccobro.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GcpConfigureDataCustomer {
	
	private int id;
	private int customerCode;
	private int sendSms;
	private int sendEmail;
	private int telConfig;
	private int emailConfig;
	private String customerName;
	
	private String phoneNumbers;
	private String emails;

	public GcpConfigureDataCustomer() {
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

	public int getSendSms() {
		return sendSms;
	}

	public void setSendSms(int sendSms) {
		this.sendSms = sendSms;
	}

	public int getSendEmail() {
		return sendEmail;
	}

	public void setSendEmail(int sendEmail) {
		this.sendEmail = sendEmail;
	}

	public int getTelConfig() {
		return telConfig;
	}

	public void setTelConfig(int telConfig) {
		this.telConfig = telConfig;
	}

	public int getEmailConfig() {
		return emailConfig;
	}

	public void setEmailConfig(int emailConfig) {
		this.emailConfig = emailConfig;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(String phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

}
