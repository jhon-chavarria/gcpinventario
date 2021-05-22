package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

import ni.com.casapellas.util.CollectionScheme;


/**
 * The persistent class for the GCP_CONF_NOTIFICATION database table.
 * 
 */
@Entity
@Table(name="GCP_CONF_NOTIFICATION" ,schema = CollectionScheme.Scheme) 
public class GcpConfNotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GcpConfNotificationPK id;

	@Column(name="DAYS_BEFORE")
	private int daysBefore;

	private short status;

	public GcpConfNotification() {
	}

	public GcpConfNotificationPK getId() {
		return this.id;
	}

	public void setId(GcpConfNotificationPK id) {
		this.id = id;
	}

	public int getDaysBefore() {
		return this.daysBefore;
	}

	public void setDaysBefore(int daysBefore) {
		this.daysBefore = daysBefore;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

}