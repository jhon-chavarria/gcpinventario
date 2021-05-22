package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GCP_REQUESTED_ACTIVITY database table.
 * 
 */
@Embeddable
public class GcpRequestedActivityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"TIME\"")
	private java.util.Date time;

	@Column(name="CUSTOMER_CODE")
	private int customerCode;

	@Temporal(TemporalType.DATE)
	@Column(name="\"DATE\"")
	private java.util.Date date;

	public GcpRequestedActivityPK() {
	}
	public java.util.Date getTime() {
		return this.time;
	}
	public void setTime(java.util.Date time) {
		this.time = time;
	}
	public int getCustomerCode() {
		return this.customerCode;
	}
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	public java.util.Date getDate() {
		return this.date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GcpRequestedActivityPK)) {
			return false;
		}
		GcpRequestedActivityPK castOther = (GcpRequestedActivityPK)other;
		return 
			this.time.equals(castOther.time)
			&& (this.customerCode == castOther.customerCode)
			&& this.date.equals(castOther.date);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.time.hashCode();
		hash = hash * prime + this.customerCode;
		hash = hash * prime + this.date.hashCode();
		
		return hash;
	}
}