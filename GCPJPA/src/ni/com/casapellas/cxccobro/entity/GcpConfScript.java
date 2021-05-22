package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ni.com.casapellas.util.CollectionScheme;

/**
 * The persistent class for the GCP_CONF_SCRIPT database table.
 * 
 */
@Entity
@Table(name = "GCP_CONF_SCRIPT",schema = CollectionScheme.Scheme)
public class GcpConfScript implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)      
	private int id;  
	@Column(name="COLLECTION_TYPE")
	private int collectionType;
	private String name;
	@Column(name="SCRIPT_TYPE")  
	private int scriptType;
	private short status;  
	private String subject;
	private String title;
	 
	public GcpConfScript() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCollectionType() {
		return this.collectionType;
	}

	public void setCollectionType(int collectionType) {
		this.collectionType = collectionType;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScriptType() {
		return this.scriptType;
	}

	public void setScriptType(int scriptType) {
		this.scriptType = scriptType;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}