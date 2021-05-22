package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the SOTCIT database table.
 * 
 */
@Entity
@Table(name = "SOTCIT") 
@XmlRootElement
public class Sotcit implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SotcitPK sotcitPK;
	
	public Sotcit() {}

	public void setSotcitPK(SotcitPK sotcitPK) {
		this.sotcitPK = sotcitPK;
	}

	public SotcitPK getSotcitPK() {
		return sotcitPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sotcitPK == null) ? 0 : sotcitPK.hashCode());
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
		Sotcit other = (Sotcit) obj;
		if (sotcitPK == null) {
			if (other.sotcitPK != null)
				return false;
		} else if (!sotcitPK.equals(other.sotcitPK))
			return false;
		return true;
	}
}