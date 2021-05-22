package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the SOTMAT database table.
 * 
 */
@Entity
@Table(name = "SOTMAT")
@XmlRootElement
public class Sotmat implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SotmatPK sotmatPK;
	
	public Sotmat() {
		// TODO Auto-generated constructor stub
	}

	public void setSotmatPK(SotmatPK sotmatPK) {
		this.sotmatPK = sotmatPK;
	}

	public SotmatPK getSotmatPK() {
		return sotmatPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sotmatPK == null) ? 0 : sotmatPK.hashCode());
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
		Sotmat other = (Sotmat) obj;
		if (sotmatPK == null) {
			if (other.sotmatPK != null)
				return false;
		} else if (!sotmatPK.equals(other.sotmatPK))
			return false;
		return true;
	}
}