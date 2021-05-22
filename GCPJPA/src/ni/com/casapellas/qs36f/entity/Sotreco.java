package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the SOTRECO database table.
 * 
 */
@Entity
@Table(name = "SOTRECO")
@XmlRootElement
public class Sotreco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SotrecoPK sotrecoPK;
	
	public Sotreco() {
		// TODO Auto-generated constructor stub
	}

	public void setSotrecoPK(SotrecoPK sotrecoPK) {
		this.sotrecoPK = sotrecoPK;
	}

	public SotrecoPK getSotrecoPK() {
		return sotrecoPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sotrecoPK == null) ? 0 : sotrecoPK.hashCode());
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
		Sotreco other = (Sotreco) obj;
		if (sotrecoPK == null) {
			if (other.sotrecoPK != null)
				return false;
		} else if (!sotrecoPK.equals(other.sotrecoPK))
			return false;
		return true;
	}
}