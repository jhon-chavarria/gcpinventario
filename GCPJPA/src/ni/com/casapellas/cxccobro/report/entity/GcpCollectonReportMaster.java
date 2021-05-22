package ni.com.casapellas.cxccobro.report.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import ni.com.casapellas.util.CollectionScheme;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the GCP_COLLECTON_REPORT_MASTER database table.
 * 
 */
@Entity
@Table(name="GCP_COLLECTION_REPORT_MASTER", catalog = "SISTEMIP", schema = CollectionScheme.Scheme)
public class GcpCollectonReportMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date gdate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CLOSING_DATE")
	private Date closingDate;

	private Time ghour;

	private int guser;

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="ID_RANGE_CONFIGURATION")
	private int idRangeConfiguration;

	private int status;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public GcpCollectonReportMaster() {
	}

	public Date getGdate() {
		return this.gdate;
	}

	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}

	public Time getGhour() {
		return this.ghour;
	}

	public void setGhour(Time ghour) {
		this.ghour = ghour;
	}

	public int getGuser() {
		return this.guser;
	}

	public void setGuser(int guser) {
		this.guser = guser;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdRangeConfiguration() {
		return this.idRangeConfiguration;
	}

	public void setIdRangeConfiguration(int idRangeConfiguration) {
		this.idRangeConfiguration = idRangeConfiguration;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	
}