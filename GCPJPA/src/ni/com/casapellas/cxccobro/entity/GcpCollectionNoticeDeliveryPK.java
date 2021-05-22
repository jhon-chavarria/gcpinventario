package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GCP_COLLECTION_NOTICE_DELIVERY database table.
 * 
 */
@Embeddable
public class GcpCollectionNoticeDeliveryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ACTIVITY_RESULT")
	private int idActivityResult;

	@Column(name="ID_ACTIVITY")
	private int idActivity;

	@Column(name="ACTIVITY_SEQUENCE")
	private int activitySequence;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTIVITY_DATE")
	private java.util.Date activityDate;

	public GcpCollectionNoticeDeliveryPK() {
	}
	public int getIdActivityResult() {
		return this.idActivityResult;
	}
	public void setIdActivityResult(int idActivityResult) {
		this.idActivityResult = idActivityResult;
	}
	public int getIdActivity() {
		return this.idActivity;
	}
	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
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
		if (!(other instanceof GcpCollectionNoticeDeliveryPK)) {
			return false;
		}
		GcpCollectionNoticeDeliveryPK castOther = (GcpCollectionNoticeDeliveryPK)other;
		return 
			(this.idActivityResult == castOther.idActivityResult)
			&& (this.idActivity == castOther.idActivity)
			&& (this.activitySequence == castOther.activitySequence)
			&& this.activityDate.equals(castOther.activityDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idActivityResult;
		hash = hash * prime + this.idActivity;
		hash = hash * prime + this.activitySequence;
		hash = hash * prime + this.activityDate.hashCode();
		
		return hash;
	}
}