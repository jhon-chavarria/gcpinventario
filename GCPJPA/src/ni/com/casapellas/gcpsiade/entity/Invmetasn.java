package ni.com.casapellas.gcpsiade.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the INVMETASN database table.
 * 
 */
@Entity
@Table(name = "INVMETASN", catalog = "SYSTEMIP", schema = "QS36F")
public class Invmetasn implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InvmetasnPK id;

	public Invmetasn() {
	}

	public InvmetasnPK getId() {
		return this.id;
	}

	public void setId(InvmetasnPK id) {
		this.id = id;
	}

}