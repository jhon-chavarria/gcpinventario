package ni.com.casapellas.cxccobro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import ni.com.casapellas.util.CollectionScheme;

@XmlRootElement
@Entity
@Table(name = "GCP_CONF_GENERAL_PROFILE", catalog = "SISTEMIP", schema = CollectionScheme.Scheme)
public class GcpConfGeneralProfile {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "EMPLOYEE_CODE")
	private int employeeCode;

	@Column(name = "EMPLOYEE_CODE_SUBORDINATE")
	private int employeeCodeSubordinate;

	@Column(name = "STATUS")
	private int status;

	public GcpConfGeneralProfile() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}

	public int getEmployeeCodeSubordinate() {
		return employeeCodeSubordinate;
	}

	public void setEmployeeCodeSubordinate(int employeeCodeSubordinate) {
		this.employeeCodeSubordinate = employeeCodeSubordinate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
