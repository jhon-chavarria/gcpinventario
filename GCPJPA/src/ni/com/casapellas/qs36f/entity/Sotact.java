package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the SOTACT database table.
 * 
 */
@Entity
@Table(name = "SOTACT") //catalog="SYSTEMIP",
@XmlRootElement
public class Sotact implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SotactPK sotactPK;
	
	public Sotact(){}

	public void setSotactPK(SotactPK sotactPK) {
		this.sotactPK = sotactPK;
	}

	public SotactPK getSotactPK() {
		return sotactPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sotactPK == null) ? 0 : sotactPK.hashCode());
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
		Sotact other = (Sotact) obj;
		if (sotactPK == null) {
			if (other.sotactPK != null)
				return false;
		} else if (!sotactPK.equals(other.sotactPK))
			return false;
		return true;
	}

	
}