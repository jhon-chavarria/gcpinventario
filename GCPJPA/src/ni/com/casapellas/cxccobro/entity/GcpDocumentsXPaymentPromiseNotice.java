package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

import ni.com.casapellas.util.CollectionScheme;


/**
 * The persistent class for the GCP_DOCUMENTS_X_PAYMENT_PROMISE database table.
 * 
 */
@Entity
@Table(name="GCP_DOCUMENTS_X_PAYMENT_PROMISE_NOTICE",schema = CollectionScheme.Scheme)
public class GcpDocumentsXPaymentPromiseNotice implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GcpDocumentsXPaymentPromiseNoticePK id;

	public GcpDocumentsXPaymentPromiseNoticePK getId() {
		return id;
	}

	public void setId(GcpDocumentsXPaymentPromiseNoticePK id) {
		this.id = id;
	}

	public GcpDocumentsXPaymentPromiseNotice() {
	}

 

}