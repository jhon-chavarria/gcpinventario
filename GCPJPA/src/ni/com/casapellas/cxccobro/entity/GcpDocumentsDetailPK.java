package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the GCP_DOCUMENTS_DETAIL database table.
 * 
 */
@Embeddable
public class GcpDocumentsDetailPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="DATE_TIME")
	private String dateTime;

	@Column(name="\"ORDER\"")
	private int order;

	public GcpDocumentsDetailPK() {
	}

	public String getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
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
		GcpDocumentsDetailPK other = (GcpDocumentsDetailPK) obj;
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