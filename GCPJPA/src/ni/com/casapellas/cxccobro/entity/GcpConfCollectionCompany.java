package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import ni.com.casapellas.util.CollectionScheme;

import java.util.Date;

/**
 * The persistent class for the GCP_COLLECTION_PROCESS database table.
 * 
 */
@Entity
@Table(name = "GCP_CONF_COLLECTION_COMPANY", schema = CollectionScheme.Scheme)
public class GcpConfCollectionCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "IUSER")
	private int iuser;

	@Temporal(TemporalType.DATE)
	@Column(name = "IDATE")
	private Date idate;

	@Temporal(TemporalType.TIME)
	@Column(name = "ITIME")
	private Date itime;

	@Column(name = "UUSER")
	private int uuser;

	@Temporal(TemporalType.DATE)
	@Column(name = "UDATE")
	private Date udate;

	@Temporal(TemporalType.TIME)
	@Column(name = "UTIME")
	private Date utime;

	@Column(name = "STATUS")
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getIuser() {
		return iuser;
	}

	public void setIuser(int iuser) {
		this.iuser = iuser;
	}

	public Date getIdate() {
		return idate;
	}

	public void setIdate(Date idate) {
		this.idate = idate;
	}

	public Date getItime() {
		return itime;
	}

	public void setItime(Date itime) {
		this.itime = itime;
	}

	public int getUuser() {
		return uuser;
	}

	public void setUuser(int uuser) {
		this.uuser = uuser;
	}

	public Date getUdate() {
		return udate;
	}

	public void setUdate(Date udate) {
		this.udate = udate;
	}

	public Date getUtime() {
		return utime;
	}

	public void setUtime(Date utime) {
		this.utime = utime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}