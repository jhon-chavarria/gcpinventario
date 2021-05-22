package ni.com.casapellas.cxccobro.report.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import ni.com.casapellas.util.CollectionScheme;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the GCP_CONF_COLLECTION_RANGE database table.
 * 
 */
@Entity
@Table(name="GCP_CONF_COLLECTION_RANGE", catalog = "SISTEMIP", schema = CollectionScheme.Scheme)
public class GcpConfCollectionRange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date gdate;

	private Time gtime;

	private int guser;

	private int status;

	public GcpConfCollectionRange() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getGdate() {
		return this.gdate;
	}

	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}

	public Time getGtime() {
		return this.gtime;
	}

	public void setGtime(Time gtime) {
		this.gtime = gtime;
	}

	public int getGuser() {
		return this.guser;
	}

	public void setGuser(int guser) {
		this.guser = guser;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}