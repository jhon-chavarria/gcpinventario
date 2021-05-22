package ni.com.casapellas.qs36f.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "VTABMUL", catalog = "SYSTEMIP", schema = "FAC400")
@XmlRootElement
public class Vtabmul implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VtabmulPK vtabmulPK;

	public Vtabmul() {
	}

	public VtabmulPK getVtabmulPK() {
		return vtabmulPK;
	}

	public void setVtabmulPK(VtabmulPK vtabmulPK) {
		this.vtabmulPK = vtabmulPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((vtabmulPK == null) ? 0 : vtabmulPK.hashCode());
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
		Vtabmul other = (Vtabmul) obj;
		if (vtabmulPK == null) {
			if (other.vtabmulPK != null)
				return false;
		} else if (!vtabmulPK.equals(other.vtabmulPK))
			return false;
		return true;
	}

}
