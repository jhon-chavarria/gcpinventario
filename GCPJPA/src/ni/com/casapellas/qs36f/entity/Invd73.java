package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the INVD73 database table.
 * 
 */
@Entity
@Table(name = "INVD733", catalog = "SYSTEMIP", schema = "QS36F")
@XmlRootElement
public class Invd73 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Invd73PK invd73PK;

	public Invd73PK getInvd73PK() {
		return invd73PK;
	}

	public void setInvd73PK(Invd73PK invd73PK) {
		this.invd73PK = invd73PK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((invd73PK == null) ? 0 : invd73PK.hashCode());
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
		Invd73 other = (Invd73) obj;
		if (invd73PK == null) {
			if (other.invd73PK != null)
				return false;
		} else if (!invd73PK.equals(other.invd73PK))
			return false;
		return true;
	}

}