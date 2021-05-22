package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;

import javax.persistence.*;

import ni.com.casapellas.util.CollectionScheme;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the GCP_ACCOUNT_STATEMENT_EMAIL_SHIPMENT database table.
 * 
 */
@Entity
@Table(name="GCP_ACCOUNT_STATEMENT_EMAIL_SHIPMENT" , catalog = "SISTEMIP", schema = CollectionScheme.Scheme)
public class GcpAccountStatementEmailShipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_TIME")
	private String dateTime;

	@Column(name="CURRENT_FILE_KEY")
	private String currentFileKey;

	@Column(name="CUSTOMER_CODE")
	private int customerCode;

	@Column(name="EMPLOYEE_CODE")
	private int employeeCode;

	@Column(name="ID_SCRIPT")
	private int idScript;

	@Column(name="PREVIOUS_FILE_KEY")
	private String previousFileKey;

	@Column(name="USER_INTERFACE")
	private String userInterface;
	
	@Column(name="SEQUENCE")
	private int secuence;
	
	@Column(name="PROCESS_DATE")
	private Date processDate;

	public GcpAccountStatementEmailShipment() {
	}

	public String getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getCurrentFileKey() {
		return this.currentFileKey;
	}

	public void setCurrentFileKey(String currentFileKey) {
		this.currentFileKey = currentFileKey;
	}

	public int getCustomerCode() {
		return this.customerCode;
	}

	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}

	public int getEmployeeCode() {
		return this.employeeCode;
	}

	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}

	public int getIdScript() {
		return this.idScript;
	}

	public void setIdScript(int idScript) {
		this.idScript = idScript;
	}

	public String getPreviousFileKey() {
		return this.previousFileKey;
	}

	public void setPreviousFileKey(String previousFileKey) {
		this.previousFileKey = previousFileKey;
	}

	public String getUserInterface() {
		return this.userInterface;
	}

	public void setUserInterface(String userInterface) {
		this.userInterface = userInterface;
	}

	public int getSecuence() {
		return secuence;
	}

	public void setSecuence(int secuence) {
		this.secuence = secuence;
	}

	public Date getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

}