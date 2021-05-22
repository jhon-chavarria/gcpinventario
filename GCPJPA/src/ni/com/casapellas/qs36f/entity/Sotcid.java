package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the SOTCID database table.
 * 
 */

@Entity
@Table(name = "SOTCID")
@XmlRootElement
public class Sotcid implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SotcidPK sotcidPK;
	
	public Sotcid(){}

	public void setSotcidPK(SotcidPK sotcidPK) {
		this.sotcidPK = sotcidPK;
	}

	public SotcidPK getSotcidPK() {
		return sotcidPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sotcidPK == null) ? 0 : sotcidPK.hashCode());
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
		Sotcid other = (Sotcid) obj;
		if (sotcidPK == null) {
			if (other.sotcidPK != null)
				return false;
		} else if (!sotcidPK.equals(other.sotcidPK))
			return false;
		return true;
	}


}