package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GCP_CUSTOMER_PREJUDICIAL database table.
 * 
 */
@Embeddable
public class GcpCustomerPrejudicialPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="EMPLOYEE_CODE")
	private int employeeCode;
	
	@Column(name="LAWYER_CODE")
	private int lawyerCode;

	@Column(name="CUSTOMER_CODE")
	private int customerCode;

	@Column(name="\"SEQUENCE\"")
	private int sequence;

	@Column(name="\"RANGE\"")
	private int range;
	
	@Temporal(TemporalType.DATE)
	@Column(name="PROCESS_DATE")
	private java.util.Date processDate;

	public GcpCustomerPrejudicialPK() {
	}
	public int getEmployeeCode() {
		return this.employeeCode;
	}
	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}
	public int getCustomerCode() {
		return this.customerCode;
	}
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	public int getSequence() {
		return this.sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public java.util.Date getProcessDate() {
		return this.processDate;
	}
	public void setProcessDate(java.util.Date processDate) {
		this.processDate = processDate;
	}
	public int getLawyerCode() {
		return lawyerCode;
	}
	public void setLawyerCode(int lawyerCode) {
		this.lawyerCode = lawyerCode;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerCode;
		result = prime * result + employeeCode;
		result = prime * result + lawyerCode;
		result = prime * result
				+ ((processDate == null) ? 0 : processDate.hashCode());
		result = prime * result + range;
		result = prime * result + sequence;
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
		GcpCustomerPrejudicialPK other = (GcpCustomerPrejudicialPK) obj;
		if (customerCode != other.customerCode)
			return false;
		if (employeeCode != other.employeeCode)
			return false;
		if (lawyerCode != other.lawyerCode)
			return false;
		if (processDate == null) {
			if (other.processDate != null)
				return false;
		} else if (!processDate.equals(other.processDate))
			return false;
		if (range != other.range)
			return false;
		if (sequence != other.sequence)
			return false;
		return true;
	}
	

	 
	
	
}