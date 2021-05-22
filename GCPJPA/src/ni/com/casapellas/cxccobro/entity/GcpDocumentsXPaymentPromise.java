package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

import ni.com.casapellas.util.CollectionScheme;


/**
 * The persistent class for the GCP_DOCUMENTS_X_PAYMENT_PROMISE database table.
 * 
 */
@Entity
@Table(name="GCP_DOCUMENTS_X_PAYMENT_PROMISE",schema = CollectionScheme.Scheme)
public class GcpDocumentsXPaymentPromise implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GcpDocumentsXPaymentPromisePK id;

	public GcpDocumentsXPaymentPromise() {
	}

	public GcpDocumentsXPaymentPromisePK getId() {
		return this.id;
	}

	public void setId(GcpDocumentsXPaymentPromisePK id) {
		this.id = id;
	}

}