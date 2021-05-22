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
@Table(name = "GCP_CONF_PHONENUMBER", catalog = "SISTEMIP", schema = CollectionScheme.Scheme)
public class GcpConfPhoneNumber {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "CUSTOMER_CODE")
	private int customerCode;

	private int number;

	private String extention;

	@Column(name = "IS_DEFAULT")
	private int isDefault;

	@Column(name = "USER_INSERT")
	private int userInsert;

	@Column(name = "DATE_INSERT")
	private Date dateInsert;

	@Column(name = "TIME_INSERT")
	private Date timeInsert;

	private int status;

	public GcpConfPhoneNumber() {
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getExtention() {
		return extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}

	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	public int getUserInsert() {
		return userInsert;
	}

	public void setUserInsert(int userInsert) {
		this.userInsert = userInsert;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}

	public Date getTimeInsert() {
		return timeInsert;
	}

	public void setTimeInsert(Date timeInsert) {
		this.timeInsert = timeInsert;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
