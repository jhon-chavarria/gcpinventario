package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;

import javax.persistence.*;

import ni.com.casapellas.util.CollectionScheme;

/**
 * The persistent class for the GCP_DOCUMENTS_DETAIL database table.
 * 
 */
@Entity
@Table(name = "GCP_DOCUMENTS_DETAIL", schema = CollectionScheme.Scheme)
public class GcpDocumentsDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GcpDocumentsDetailPK id;

	private String content;

	public GcpDocumentsDetail() {
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public GcpDocumentsDetailPK getId() {
		return id;
	}

	public void setId(GcpDocumentsDetailPK id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		GcpDocumentsDetail other = (GcpDocumentsDetail) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}