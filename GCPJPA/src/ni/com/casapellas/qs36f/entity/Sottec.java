package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the SOTTEC database table.
 * 
 */
@Entity
@Table(name = "SOTTEC")
@XmlRootElement
public class Sottec implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SottecPK sottecPK;
	
	public Sottec() {
		// TODO Auto-generated constructor stub
	}

	public void setSottecPK(SottecPK sottecPK) {
		this.sottecPK = sottecPK;
	}

	public SottecPK getSottecPK() {
		return sottecPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sottecPK == null) ? 0 : sottecPK.hashCode());
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
		Sottec other = (Sottec) obj;
		if (sottecPK == null) {
			if (other.sottecPK != null)
				return false;
		} else if (!sottecPK.equals(other.sottecPK))
			return false;
		return true;
	}
}