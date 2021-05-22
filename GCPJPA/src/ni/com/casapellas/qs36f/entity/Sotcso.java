package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the SOTCSO database table.
 * 
 */
@Entity
@Table(name = "SOTCSO") 
@XmlRootElement
public class Sotcso implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SotcsoPK sotcsoPK;
	
	public Sotcso() {
		// TODO Auto-generated constructor stub
	}

	public void setSotcsoPK(SotcsoPK sotcsoPK) {
		this.sotcsoPK = sotcsoPK;
	}

	public SotcsoPK getSotcsoPK() {
		return sotcsoPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sotcsoPK == null) ? 0 : sotcsoPK.hashCode());
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
		Sotcso other = (Sotcso) obj;
		if (sotcsoPK == null) {
			if (other.sotcsoPK != null)
				return false;
		} else if (!sotcsoPK.equals(other.sotcsoPK))
			return false;
		return true;
	}
}