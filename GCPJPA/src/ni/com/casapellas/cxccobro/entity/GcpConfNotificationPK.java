package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The primary key class for the GCP_CONF_NOTIFICATION database table.
 * 
 */
@Embeddable
public class GcpConfNotificationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="\"SEQUENCE\"")
	private int sequence;

	@Temporal(TemporalType.DATE)
	@Column(name="PROCESS_DATE")
	private java.util.Date processDate;
	
	@Column(name="ID_ACTIVITY")
	private int idActivity;

	public GcpConfNotificationPK() {
	}
	public int getSequence() {
		return this.sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public java.util.Date getProcessDate() {
		return this.processDate;
	}
	public void setProcessDate(java.util.Date processDate) {
		this.processDate = processDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GcpConfNotificationPK)) {
			return false;
		}
		GcpConfNotificationPK castOther = (GcpConfNotificationPK)other;
		return 
			(this.sequence == castOther.sequence)
			&& this.processDate.equals(castOther.processDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.sequence;
		hash = hash * prime + this.processDate.hashCode();
		
		return hash;
	}
	public int getIdActivity() {
		return idActivity;
	}
	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
	}
}