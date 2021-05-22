package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the SOTKCSV database table.
 * 
 */
@Entity
@Table(name = "SOTKCSV") //catalog="SYSTEMIP",
@XmlRootElement
public class Sotkcsv implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SotkcsvPK sotkcsvPK;
	
	public Sotkcsv() {
		// TODO Auto-generated constructor stub
	}

	public void setSotkcsvPK(SotkcsvPK sotkcsvPK) {
		this.sotkcsvPK = sotkcsvPK;
	}

	public SotkcsvPK getSotkcsvPK() {
		return sotkcsvPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sotkcsvPK == null) ? 0 : sotkcsvPK.hashCode());
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
		Sotkcsv other = (Sotkcsv) obj;
		if (sotkcsvPK == null) {
			if (other.sotkcsvPK != null)
				return false;
		} else if (!sotkcsvPK.equals(other.sotkcsvPK))
			return false;
		return true;
	}
}