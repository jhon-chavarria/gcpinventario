package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the SOTTAB database table.
 * 
 */
@Entity
@Table(name = "SOTTAB") 
@XmlRootElement
public class Sottab implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SottabPK id;
	
	public Sottab() {
		// TODO Auto-generated constructor stub
	}

	public void setId(SottabPK id) {
		this.id = id;
	}

	public SottabPK getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Sottab other = (Sottab) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}