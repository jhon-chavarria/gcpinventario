package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the SOTCSR database table.
 * 
 */
@Entity
@Table(name = "SOTCSR") 
@XmlRootElement
public class Sotcsr implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SotcsrPK sotcsrPK;
	
	public Sotcsr() {
		// TODO Auto-generated constructor stub
	}

	public void setSotcsrPK(SotcsrPK sotcsrPK) {
		this.sotcsrPK = sotcsrPK;
	}

	public SotcsrPK getSotcsrPK() {
		return sotcsrPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sotcsrPK == null) ? 0 : sotcsrPK.hashCode());
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
		Sotcsr other = (Sotcsr) obj;
		if (sotcsrPK == null) {
			if (other.sotcsrPK != null)
				return false;
		} else if (!sotcsrPK.equals(other.sotcsrPK))
			return false;
		return true;
	}
}