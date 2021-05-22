package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

import ni.com.casapellas.util.CollectionScheme;

import java.util.Date;


/**
 * The persistent class for the GPC_DOCUMENTS_MASTER database table.
 * 
 */
@Entity
@Table(name="GCP_DOCUMENTS_MASTER" , catalog = "SISTEMIP", schema = CollectionScheme.Scheme)
public class GcPDocumentsMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_TIME")
	private String dateTime;

	@Column(name="\"EXTENSION\"")
	private String extension;

	@Column(name="FILE_CODE")
	private String fileCode;

	private String name;

	@Column(name="\"USER\"")
	private int user;

	@Column(name="USER_INTERFACE")
	private String userInterface;

	public GcPDocumentsMaster() {
	}

	public String getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getFileCode() {
		return this.fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUser() {
		return this.user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public String getUserInterface() {
		return this.userInterface;
	}

	public void setUserInterface(String userInterface) {
		this.userInterface = userInterface;
	}

}