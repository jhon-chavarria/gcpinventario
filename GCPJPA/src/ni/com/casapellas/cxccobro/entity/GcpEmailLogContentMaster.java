package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

import ni.com.casapellas.util.CollectionScheme;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the GCP_EMAIL_LOG_CONTENT_MASTER database table.
 * 
 */
@Entity
@Table(name="GCP_EMAIL_LOG_CONTENT_MASTER" , schema = CollectionScheme.Scheme)
public class GcpEmailLogContentMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DATE_TIME")
	private String dateTime;

	@Column(name="DATE_TIME_MASTER")
	private String dateTimeMaster;

	private int element;

	public GcpEmailLogContentMaster() {
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getDateTimeMaster() {
		return dateTimeMaster;
	}

	public void setDateTimeMaster(String dateTimeMaster) {
		this.dateTimeMaster = dateTimeMaster;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

}