package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

import ni.com.casapellas.util.CollectionScheme;

import java.util.Date;


/**
 * The persistent class for the GCP_REQUESTED_ACTIVITY database table.
 * 
 */
@Entity
@Table(name="GCP_REQUESTED_ACTIVITY" ,schema = CollectionScheme.Scheme)
public class GcpRequestedActivity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GcpRequestedActivityPK id;

	@Column(name="\"COMMENT\"")
	private String comment;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_TO_SUBJECT")
	private Date dateToSubject;

	@Column(name="EMPLOYEE_CODE")
	private int employeeCode;

	@Column(name="ID_ACTIVITY")
	private int idActivity;

	private short status;

	@Column(name="\"USER\"")
	private int user;
	
	
	@Column(name="ID_MOTIVE")
	private int idMotive;
	
	@Column(name="\"CURRENCY\"")
	private String currency;

	@Column(name="\"AMOUNT\"")
	private Double amount;
	
	public GcpRequestedActivity() {
	}

	public GcpRequestedActivityPK getId() {
		return this.id;
	}

	public void setId(GcpRequestedActivityPK id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDateToSubject() {
		return this.dateToSubject;
	}

	public void setDateToSubject(Date dateToSubject) {
		this.dateToSubject = dateToSubject;
	}

	public int getEmployeeCode() {
		return this.employeeCode;
	}

	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}

	public int getIdActivity() {
		return this.idActivity;
	}

	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getIdMotive() {
		return idMotive;
	}

	public void setIdMotive(int idMotive) {
		this.idMotive = idMotive;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}



}