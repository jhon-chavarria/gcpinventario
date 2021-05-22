package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

import ni.com.casapellas.util.CollectionScheme;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the GCP_COLLECTION_NOTICE_DELIVERY database table.
 * 
 */
@Entity
@Table(name="GCP_COLLECTION_NOTICE_DELIVERY" , schema = CollectionScheme.Scheme)
public class GcpCollectionNoticeDelivery implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GcpCollectionNoticeDeliveryPK id;

	@Column(name="\"COMMENT\"")
	private String comment;

	@Temporal(TemporalType.DATE)
	@Column(name="\"DATE\"")
	private Date date;

	private short status;

	@Column(name="\"TIME\"")
	private Time time;

	@Column(name="\"USER\"")
	private int user = 0;

	
	@Column(name="AMOUNT")
	private Double amount = 0.00;

	@Temporal(TemporalType.DATE)
	@Column(name="NEXT_EXECUTION")
	private Date nextExecution;  


	@Column(name="CURRENCY")
	private String currency = "";
	
	@Column(name="STATUS_NEXT_EXECUTION")
	private int statusNextExecution;
	 
	
	public GcpCollectionNoticeDelivery() {
	}

	public GcpCollectionNoticeDeliveryPK getId() {
		return this.id;
	}

	public void setId(GcpCollectionNoticeDeliveryPK id) {
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

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public int getUser() {
		return this.user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getNextExecution() {
		return nextExecution;
	}

	public void setNextExecution(Date nextExecution) {
		this.nextExecution = nextExecution;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getStatusNextExecution() {
		return statusNextExecution;
	}

	public void setStatusNextExecution(int statusNextExecution) {
		this.statusNextExecution = statusNextExecution;
	}

	
	
	
}