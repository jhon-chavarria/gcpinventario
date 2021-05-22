package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the INVD736 database table.
 * 
 */
@Entity
public class Invd736 implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private Invd736PK invd736pk;

	public Invd736() {
	}

	public void setInvd736pk(Invd736PK invd736pk) {
		this.invd736pk = invd736pk;
	}

	public Invd736PK getInvd736pk() {
		return invd736pk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((invd736pk == null) ? 0 : invd736pk.hashCode());
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
		Invd736 other = (Invd736) obj;
		if (invd736pk == null) {
			if (other.invd736pk != null)
				return false;
		} else if (!invd736pk.equals(other.invd736pk))
			return false;
		return true;
	}

}