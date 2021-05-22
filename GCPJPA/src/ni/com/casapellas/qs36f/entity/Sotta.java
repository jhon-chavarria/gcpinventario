package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the SOTTAS database table.
 * 
 */
@Entity
@Table(name = "SOTTAS")
@XmlRootElement
public class Sotta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SottaPK sottaPK;
	
	public Sotta() {
		// TODO Auto-generated constructor stub
	}

	public void setSottaPK(SottaPK sottaPK) {
		this.sottaPK = sottaPK;
	}

	public SottaPK getSottaPK() {
		return sottaPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sottaPK == null) ? 0 : sottaPK.hashCode());
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
		Sotta other = (Sotta) obj;
		if (sottaPK == null) {
			if (other.sottaPK != null)
				return false;
		} else if (!sottaPK.equals(other.sottaPK))
			return false;
		return true;
	}
}