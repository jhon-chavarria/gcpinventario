package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the SOTCON database table.
 * 
 */
@Entity
@Table(name = "SOTCON") 
@XmlRootElement
public class Sotcon implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SotconPK sotconPK;

	public Sotcon()
	{}
	
	public SotconPK getSotconPK() {
		return sotconPK;
	}

	public void setSotconPK(SotconPK sotconPK) {
		this.sotconPK = sotconPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sotconPK == null) ? 0 : sotconPK.hashCode());
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
		Sotcon other = (Sotcon) obj;
		if (sotconPK == null) {
			if (other.sotconPK != null)
				return false;
		} else if (!sotconPK.equals(other.sotconPK))
			return false;
		return true;
	}
}