package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

import ni.com.casapellas.util.CollectionScheme;

import java.sql.Date;
import java.sql.Time;


/**
 * The persistent class for the GCP_CUSTOMER_PREJUDICIAL database table.
 * 
 */
@Entity
@Table(name="GCP_CUSTOMER_PREJUDICIAL",schema = CollectionScheme.Scheme)
public class GcpCustomerPrejudicial implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GcpCustomerPrejudicialPK id;

	private int status;

	@Column(name="\"TIME\"")
	private Time time;
	
	@Column(name="\"DATE\"")
	private Date date;

	@Column(name="\"USER\"")
	private int user;

	public GcpCustomerPrejudicial() {
	}

	public GcpCustomerPrejudicialPK getId() {
		return this.id;
	}

	public void setId(GcpCustomerPrejudicialPK id) {
		this.id = id;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}