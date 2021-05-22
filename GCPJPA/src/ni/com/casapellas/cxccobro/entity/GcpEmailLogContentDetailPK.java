package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GCP_EMAIL_LOG_CONTENT_DETAIL database table.
 * 
 */
@Embeddable
public class GcpEmailLogContentDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="\"ORDER\"")
	private int order;

	@Column(name="DATE_TIME")
	private String dateTime;

	public GcpEmailLogContentDetailPK() {
	}
	public int getOrder() {
		return this.order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
	

	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + order;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GcpEmailLogContentDetailPK other = (GcpEmailLogContentDetailPK) obj;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (order != other.order)
			return false;
		return true;
	}
 
}