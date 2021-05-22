package ni.com.casapellas.cxccobro.entity;//ni.com.casapellas.cxccobro.entity.GcpConfCatalogo

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import ni.com.casapellas.util.CollectionScheme;

@XmlRootElement
@Entity
@Table(name = "GCP_CONF_CUSTOMER_CONTACT_ND", catalog = "SISTEMIP", schema = CollectionScheme.Scheme)
public class GcpConfCustomerContactND {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ID_CUSTOMER_N")
	private int idCustomerN;

	private int type;

	@Column(name = "PHONE_NUMBER")
	private int phoneNumber;
	
	@Column(name = "CONTACT_NAME")
	private String contactName;
	
	@Column(name = "PHONE_TYPE")
	private String phoneType;

	private String email;

	private int reminder;

	@Column(name = "ACCOUNT_STATEMENT")
	private int accountStatement;

	@Column(name = "COLLECTION_NOTICE")
	private int collectionNotice;

	private int status;

	public GcpConfCustomerContactND() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCustomerN() {
		return idCustomerN;
	}

	public void setIdCustomerN(int idCustomerN) {
		this.idCustomerN = idCustomerN;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getReminder() {
		return reminder;
	}

	public void setReminder(int reminder) {
		this.reminder = reminder;
	}

	public int getAccountStatement() {
		return accountStatement;
	}

	public void setAccountStatement(int accountStatement) {
		this.accountStatement = accountStatement;
	}

	public int getCollectionNotice() {
		return collectionNotice;
	}

	public void setCollectionNotice(int collectionNotice) {
		this.collectionNotice = collectionNotice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

}
