package ni.com.casapellas.qs36f.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "VCLIENTES_GCP", catalog = "SYSTEMIP", schema = "QS36F")
@XmlRootElement
public class VclientesGcp implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VclientesGcpPK vclientesGcpPK;

	public VclientesGcp() {
	}

	public VclientesGcpPK getVclientesGcpPK() {
		return vclientesGcpPK;
	}

	public void setVclientesGcpPK(VclientesGcpPK vclientesGcpPK) {
		this.vclientesGcpPK = vclientesGcpPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((vclientesGcpPK == null) ? 0 : vclientesGcpPK.hashCode());
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
		VclientesGcp other = (VclientesGcp) obj;
		if (vclientesGcpPK == null) {
			if (other.vclientesGcpPK != null)
				return false;
		} else if (!vclientesGcpPK.equals(other.vclientesGcpPK))
			return false;
		return true;
	}

}
