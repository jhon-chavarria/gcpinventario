package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

import ni.com.casapellas.util.CollectionScheme;


/**
 * The persistent class for the GCP_EMAIL_LOG_ELEMENT database table.
 * 
 */
@Entity
@Table(name="GCP_EMAIL_LOG_ELEMENT" ,schema = CollectionScheme.Scheme)
public class GcpEmailLogElement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String description;

	private String name;

	public GcpEmailLogElement() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}