package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

import ni.com.casapellas.util.CollectionScheme;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the GCP_COLLECTION_PROCESS database table.
 * 
 */
@Entity
@Table(name="GCP_COLLECTION_PROCESS",schema = CollectionScheme.Scheme)
public class GcpCollectionProcess implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GcpCollectionProcessPK id;

	@Column(name="COMMENT")
	private String comment;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE")
	private Date date;

	@Column(name="ID_ACTION_RESULT")
	private int idActionResult;
	
	@Column(name="ID_ACTIVITY")
	private int idAtivity;

	@Column(name="ID_ACTIVITY_RESULT")
	private int idActivityResult;

	@Temporal(TemporalType.DATE)
	@Column(name="NEXT_EXECUTION")
	private Date nextExecution;  

	private short status;
	
	@Column(name="CURRENCY")
	private String currency;
	
	@Column(name="USER_NEXT_EXECUTION")
	private int userNextExecution;
	
	@Column(name="USER")
	private int user;
	
	@Column(name="AMOUNT")
	private Double amount;
	
	@Column(name="STATUS_NEXT_EXECUTION")
	private int statusNextExecution;
	
	@Column(name="COLLECTION_VISIT")
	private int collectionVisit;
	

	
	
	 
	public int getCollectionVisit() {
		return collectionVisit;
	}

	public void setCollectionVisit(int collectionVisit) {
		this.collectionVisit = collectionVisit;
	}

	public int getIdAtivity() {
		return idAtivity;
	}

	public void setIdAtivity(int idAtivity) {
		this.idAtivity = idAtivity;
	}

	public GcpCollectionProcess() {
	}

	public GcpCollectionProcessPK getId() {
		return this.id;
	}

	public void setId(GcpCollectionProcessPK id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdActionResult() {
		return this.idActionResult;
	}

	public void setIdActionResult(int idActionResult) {
		this.idActionResult = idActionResult;
	}

	 

	public int getIdActivityResult() {
		return idActivityResult;
	}

	public void setIdActivityResult(int idActivityResult) {
		this.idActivityResult = idActivityResult;
	}

	public Date getNextExecution() {
		return this.nextExecution;
	}

	public void setNextExecution(Date nextExecution) {
		this.nextExecution = nextExecution;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}


	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getUserNextExecution() {
		return userNextExecution;
	}

	public void setUserNextExecution(int userNextExecution) {
		this.userNextExecution = userNextExecution;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public int getUser() {
		return this.user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getStatusNextExecution() {
		return statusNextExecution;
	}

	public void setStatusNextExecution(int statusNextExecution) {
		this.statusNextExecution = statusNextExecution;
	}

}