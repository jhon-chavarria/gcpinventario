package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

import ni.com.casapellas.util.CollectionScheme;

import java.util.Date;


/**
 * The persistent class for the GCP_EMAIL_SHIPMENT_LOG database table.
 * 
 */
@Entity
@Table(name="GCP_EMAIL_SHIPMENT_LOG" ,schema = CollectionScheme.Scheme)
public class GcpEmailShipmentLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DATE_TIME")
	private String dateTime;

	private String application;

	@Column(name="\"USER\"")
	private int user;
	
	@Column(name="\"ACTIVITY_ID\"")
	private int activityId;

	public GcpEmailShipmentLog() {
	}

	 
	public String getDateTime() {
		return dateTime;
	}


	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}


	public String getApplication() {
		return this.application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public int getUser() {
		return this.user;
	}

	public void setUser(int user) {
		this.user = user;
	}


	public int getActivityId() {
		return activityId;
	}


	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

}