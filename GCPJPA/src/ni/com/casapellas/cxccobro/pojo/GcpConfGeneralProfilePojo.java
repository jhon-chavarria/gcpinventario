package ni.com.casapellas.cxccobro.pojo;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class GcpConfGeneralProfilePojo {
	private int id;
	private int employeeCode;
	private int employeeCodeSubordinate;
	private int status;
	private String employeeName;
	private String employeeNameSubordinate;

	public GcpConfGeneralProfilePojo() {
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

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeNameSubordinate() {
		return employeeNameSubordinate;
	}

	public void setEmployeeNameSubordinate(String employeeNameSubordinate) {
		this.employeeNameSubordinate = employeeNameSubordinate;
	}

}
