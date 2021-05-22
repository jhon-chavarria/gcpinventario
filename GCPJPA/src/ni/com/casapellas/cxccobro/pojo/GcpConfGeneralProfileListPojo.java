package ni.com.casapellas.cxccobro.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GcpConfGeneralProfileListPojo {
	private int id;
	private int employeeCode;
	private List<Integer> employeeCodeSubordinates;
	private int status;

	public GcpConfGeneralProfileListPojo() {
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

	public List<Integer> getEmployeeCodeSubordinates() {
		return employeeCodeSubordinates;
	}

	public void setEmployeeCodeSubordinates(
			List<Integer> employeeCodeSubordinates) {
		this.employeeCodeSubordinates = employeeCodeSubordinates;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
