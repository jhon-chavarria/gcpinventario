package ni.com.casapellas.gcpsiade.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CATALOGOS_JDEDWARDS", catalog = "SYSTEMIP", schema = "FAC400")
@XmlRootElement
public class CatalogosJdedward implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CatalogosJdedwardPK catalogosJdedwardPK;

	public CatalogosJdedward() {
	}

	public CatalogosJdedwardPK getCatalogosJdedwardPK() {
		return catalogosJdedwardPK;
	}

	public void setCatalogosJdedwardPK(CatalogosJdedwardPK catalogosJdedwardPK) {
		this.catalogosJdedwardPK = catalogosJdedwardPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((catalogosJdedwardPK == null) ? 0 : catalogosJdedwardPK
						.hashCode());
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
		CatalogosJdedward other = (CatalogosJdedward) obj;
		if (catalogosJdedwardPK == null) {
			if (other.catalogosJdedwardPK != null)
				return false;
		} else if (!catalogosJdedwardPK.equals(other.catalogosJdedwardPK))
			return false;
		return true;
	}

}
