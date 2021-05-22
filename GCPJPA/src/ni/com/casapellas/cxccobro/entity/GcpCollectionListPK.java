package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GcpCollectionListPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PROCESS_DATE")
	private Date processDate;
	@Column(name = "ACTIVITY_ID")
	private int activityId;
	@Column(name = "ACTIVITY_TITLE")
	private String activityTitle;
	@Column(name = "CUSTOMER_CODE")
	private int customerCode;
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	@Column(name = "CUSTOMER_TYPE")
	private String customerType;
	@Column(name = "COLLECTION_CODE_ID")
	private int collectionCodeId;
	@Column(name = "COLLECTION_TITLE")
	private String collectionTitle;
	@Column(name = "AMOUNT_COR")
	private double amountCor;
	@Column(name = "AMOUNT_USD")
	private double amountUsd;
	@Column(name = "COLLECTION_STATUS")
	private int collectionStatus;
	@Column(name = "RECIPE_ID")
	private int receipeId;
	@Column(name = "STATUS")
	private int status;

	public GcpCollectionListPK() {
	}

	public Date getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getActivityTitle() {
		return activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public int getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCollectionCodeId() {
		return collectionCodeId;
	}

	public void setCollectionCodeId(int collectionCodeId) {
		this.collectionCodeId = collectionCodeId;
	}

	public String getCollectionTitle() {
		return collectionTitle;
	}

	public void setCollectionTitle(String collectionTitle) {
		this.collectionTitle = collectionTitle;
	}

	public double getAmountCor() {
		return amountCor;
	}

	public void setAmountCor(double amountCor) {
		this.amountCor = amountCor;
	}

	public double getAmountUsd() {
		return amountUsd;
	}

	public void setAmountUsd(double amountUsd) {
		this.amountUsd = amountUsd;
	}

	public int getCollectionStatus() {
		return collectionStatus;
	}

	public void setCollectionStatus(int collectionStatus) {
		this.collectionStatus = collectionStatus;
	}

	public int getReceipeId() {
		return receipeId;
	}

	public void setReceipeId(int receipeId) {
		this.receipeId = receipeId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activityId;
		result = prime * result
				+ ((activityTitle == null) ? 0 : activityTitle.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amountCor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(amountUsd);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + collectionCodeId;
		result = prime * result + collectionStatus;
		result = prime * result
				+ ((collectionTitle == null) ? 0 : collectionTitle.hashCode());
		result = prime * result + customerCode;
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result
				+ ((processDate == null) ? 0 : processDate.hashCode());
		result = prime * result + receipeId;
		result = prime * result + status;
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
		GcpCollectionListPK other = (GcpCollectionListPK) obj;
		if (activityId != other.activityId)
			return false;
		if (activityTitle == null) {
			if (other.activityTitle != null)
				return false;
		} else if (!activityTitle.equals(other.activityTitle))
			return false;
		if (Double.doubleToLongBits(amountCor) != Double
				.doubleToLongBits(other.amountCor))
			return false;
		if (Double.doubleToLongBits(amountUsd) != Double
				.doubleToLongBits(other.amountUsd))
			return false;
		if (collectionCodeId != other.collectionCodeId)
			return false;
		if (collectionStatus != other.collectionStatus)
			return false;
		if (collectionTitle == null) {
			if (other.collectionTitle != null)
				return false;
		} else if (!collectionTitle.equals(other.collectionTitle))
			return false;
		if (customerCode != other.customerCode)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (processDate == null) {
			if (other.processDate != null)
				return false;
		} else if (!processDate.equals(other.processDate))
			return false;
		if (receipeId != other.receipeId)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

}
