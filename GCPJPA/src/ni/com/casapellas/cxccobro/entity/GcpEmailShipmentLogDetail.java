package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

import ni.com.casapellas.util.CollectionScheme;


/**
 * The persistent class for the GCP_EMAIL_SHIPMENT_LOG_DETAIL database table.
 * 
 */
@Entity
@Table(name="GCP_EMAIL_SHIPMENT_LOG_DETAIL" ,schema = CollectionScheme.Scheme)
public class GcpEmailShipmentLogDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GcpEmailShipmentLogDetailPK id;

	private int element;

	@Column(name="\"VALUE\"")
	private String value;

	public GcpEmailShipmentLogDetail() {
	}

	public GcpEmailShipmentLogDetailPK getId() {
		return this.id;
	}

	public void setId(GcpEmailShipmentLogDetailPK id) {
		this.id = id;
	}

	public int getElement() {
		return this.element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}