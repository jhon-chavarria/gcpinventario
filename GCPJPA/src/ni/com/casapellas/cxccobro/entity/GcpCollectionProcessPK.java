package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.*;

/**
 * The primary key class for the GCP_COLLECTION_PROCESS database table.
 * 
 */
@Embeddable
public class GcpCollectionProcessPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ACTIVITY_SEQUENCE")
	private int activitySequence;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTIVITY_DATE")
	private java.util.Date activityDate;
	
	
	@Column(name="TIME")
	private Time time;


	public GcpCollectionProcessPK() {
	}
	public int getActivitySequence() {
		return this.activitySequence;
	}
	public void setActivitySequence(int activitySequence) {
		this.activitySequence = activitySequence;
	}
	public java.util.Date getActivityDate() {
		return this.activityDate;
	}
	public void setActivityDate(java.util.Date activityDate) {
		this.activityDate = activityDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GcpCollectionProcessPK)) {
			return false;
		}
		GcpCollectionProcessPK castOther = (GcpCollectionProcessPK)other;
		return 
			(this.activitySequence == castOther.activitySequence)
			&& this.activityDate.equals(castOther.activityDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.activitySequence;
		hash = hash * prime + this.activityDate.hashCode();
		
		return hash;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
}