package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "INVD731")
@XmlRootElement
public class Invd731 implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private Invd731PK invd731pk;

	public void setInvd731pk(Invd731PK invd731pk) {
		this.invd731pk = invd731pk;
	}

	public Invd731PK getInvd731pk() {
		return invd731pk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((invd731pk == null) ? 0 : invd731pk.hashCode());
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
		Invd731 other = (Invd731) obj;
		if (invd731pk == null) {
			if (other.invd731pk != null)
				return false;
		} else if (!invd731pk.equals(other.invd731pk))
			return false;
		return true;
	}

}
