package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GCP_DOCUMENTS_X_PAYMENT_PROMISE database table.
 * 
 */
@Embeddable
public class GcpDocumentsXPaymentPromiseNoticePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTIVITY_DATE")
	private java.util.Date activityDate;

	@Column(name="ACTIVITY_SEQUENCE")
	private int activitySequence;

	@Column(name="ID_ACTION_RESULT")
	private int idActionResult;

	private String company;

	@Column(name="BRANCH_OFFICE")
	private String branchOffice;

	@Column(name="DOCUMENT_TYPE")
	private String documentType;

	@Column(name="DOCUMENT_NUMBER")
	private int documentNumber;

	@Column(name="INSTALLMENT_NUMBER")
	private int installmentNumber;

	@Column(name="REQUEST_NUMBER")
	private String requestNumber;

	@Column(name="\"USER\"")
	private int user;

	@Temporal(TemporalType.DATE)
	@Column(name="\"DATE\"")
	private java.util.Date date;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="\"TIME\"")
	private java.util.Date time;

	public GcpDocumentsXPaymentPromiseNoticePK() {
	}
	public java.util.Date getActivityDate() {
		return this.activityDate;
	}
	public void setActivityDate(java.util.Date activityDate) {
		this.activityDate = activityDate;
	}
	public int getActivitySequence() {
		return this.activitySequence;
	}
	public void setActivitySequence(int activitySequence) {
		this.activitySequence = activitySequence;
	}
	public int getIdActionResult() {
		return this.idActionResult;
	}
	public void setIdActionResult(int idActionResult) {
		this.idActionResult = idActionResult;
	}
	public String getCompany() {
		return this.company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBranchOffice() {
		return this.branchOffice;
	}
	public void setBranchOffice(String branchOffice) {
		this.branchOffice = branchOffice;
	}
	public String getDocumentType() {
		return this.documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public int getDocumentNumber() {
		return this.documentNumber;
	}
	public void setDocumentNumber(int documentNumber) {
		this.documentNumber = documentNumber;
	}
	public int getInstallmentNumber() {
		return this.installmentNumber;
	}
	public void setInstallmentNumber(int installmentNumber) {
		this.installmentNumber = installmentNumber;
	}
	public String getRequestNumber() {
		return this.requestNumber;
	}
	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}
	public int getUser() {
		return this.user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public java.util.Date getDate() {
		return this.date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public java.util.Date getTime() {
		return this.time;
	}
	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GcpDocumentsXPaymentPromiseNoticePK)) {
			return false;
		}
		GcpDocumentsXPaymentPromiseNoticePK castOther = (GcpDocumentsXPaymentPromiseNoticePK)other;
		return 
			this.activityDate.equals(castOther.activityDate)
			&& (this.activitySequence == castOther.activitySequence)
			&& (this.idActionResult == castOther.idActionResult)
			&& this.company.equals(castOther.company)
			&& this.branchOffice.equals(castOther.branchOffice)
			&& this.documentType.equals(castOther.documentType)
			&& (this.documentNumber == castOther.documentNumber)
			&& (this.installmentNumber == castOther.installmentNumber)
			&& this.requestNumber.equals(castOther.requestNumber)
			&& (this.user == castOther.user)
			&& this.date.equals(castOther.date)
			&& this.time.equals(castOther.time);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.activityDate.hashCode();
		hash = hash * prime + this.activitySequence;
		hash = hash * prime + this.idActionResult;
		hash = hash * prime + this.company.hashCode();
		hash = hash * prime + this.branchOffice.hashCode();
		hash = hash * prime + this.documentType.hashCode();
		hash = hash * prime + this.documentNumber;
		hash = hash * prime + this.installmentNumber;
		hash = hash * prime + this.requestNumber.hashCode();
		hash = hash * prime + this.user;
		hash = hash * prime + this.date.hashCode();
		hash = hash * prime + this.time.hashCode();
		
		return hash;
	}
}