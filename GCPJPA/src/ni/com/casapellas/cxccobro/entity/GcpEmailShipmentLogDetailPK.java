package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GCP_EMAIL_SHIPMENT_LOG_DETAIL database table.
 * 
 */
@Embeddable
public class GcpEmailShipmentLogDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="\"INDEX\"")
	private int index;
	
	@Column(name="\"DATE_TIME\"")
	private String dateTime;
	
	@Column(name="\"DATE_TIME_MASTER\"")
	private String dateTimeMaster;

	public GcpEmailShipmentLogDetailPK() {
	}
	public int getIndex() {
		return this.index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getDateTime() {
		return this.dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getDateTimeMaster() {
		return this.dateTimeMaster;
	}
	public void setDateTimeMaster(String dateTimeMaster) {
		this.dateTimeMaster = dateTimeMaster;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GcpEmailShipmentLogDetailPK)) {
			return false;
		}
		GcpEmailShipmentLogDetailPK castOther = (GcpEmailShipmentLogDetailPK)other;
		return 
			(this.index == castOther.index)
			&& this.dateTime.equals(castOther.dateTime)
			&& this.dateTimeMaster.equals(castOther.dateTimeMaster);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.index;
		hash = hash * prime + this.dateTime.hashCode();
		hash = hash * prime + this.dateTimeMaster.hashCode();
		
		return hash;
	}
}