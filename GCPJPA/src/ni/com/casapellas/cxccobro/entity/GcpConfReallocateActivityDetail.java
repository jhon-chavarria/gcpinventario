package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import ni.com.casapellas.util.CollectionScheme;

@XmlRootElement
@Entity
@Table(name = "GCP_CONF_REALLOCATE_ACTIVITY_DETAIL", catalog = "SISTEMIP", schema = CollectionScheme.Scheme)
public class GcpConfReallocateActivityDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ID_ACTIVITY_DETAIL")
	private int idActivityDetail;

	@Column(name = "PROCESS_DATE")
	@Temporal(TemporalType.DATE)
	private Date processDate;

	@Column(name = "SEQUENCE")
	private int sequence;
	
	

	@Column(name = "DATE_INSERT")
	@Temporal(TemporalType.DATE)
	private Date dateInsert;

	@Column(name = "TIME_INSERT")
	@Temporal(TemporalType.TIME)
	private Date timeInsert;

	@Column(name = "USER")
	private int user;

	public GcpConfReallocateActivityDetail() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
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

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public int getIdActivityDetail() {
		return idActivityDetail;
	}

	public void setIdActivityDetail(int idActivityDetail) {
		this.idActivityDetail = idActivityDetail;
	}

}
