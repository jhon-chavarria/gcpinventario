package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the SOTAUT database table.
 * 
 */
@Entity
@Table(name = "SOTAUT") 
@XmlRootElement
public class Sotaut implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SotautPK sotautPK;
	
	public Sotaut(){}

	public void setSotautPK(SotautPK sotautPK) {
		this.sotautPK = sotautPK;
	}

	public SotautPK getSotautPK() {
		return sotautPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sotautPK == null) ? 0 : sotautPK.hashCode());
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
		Sotaut other = (Sotaut) obj;
		if (sotautPK == null) {
			if (other.sotautPK != null)
				return false;
		} else if (!sotautPK.equals(other.sotautPK))
			return false;
		return true;
	}

}