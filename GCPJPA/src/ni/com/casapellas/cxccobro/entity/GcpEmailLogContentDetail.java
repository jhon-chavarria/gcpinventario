package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

import ni.com.casapellas.util.CollectionScheme;


/**
 * The persistent class for the GCP_EMAIL_LOG_CONTENT_DETAIL database table.
 * 
 */
@Entity
@Table(name="GCP_EMAIL_LOG_CONTENT_DETAIL"  ,schema = CollectionScheme.Scheme)
public class GcpEmailLogContentDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GcpEmailLogContentDetailPK id;

	private String content;

	public GcpEmailLogContentDetail() {
	}

	public GcpEmailLogContentDetailPK getId() {
		return this.id;
	}

	public void setId(GcpEmailLogContentDetailPK id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}