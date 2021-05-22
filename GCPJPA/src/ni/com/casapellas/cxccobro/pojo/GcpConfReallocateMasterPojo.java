package ni.com.casapellas.cxccobro.pojo;

import java.util.List;

import ni.com.casapellas.geninfo.pojo.ResponseFromServer;

public class GcpConfReallocateMasterPojo {
	private int id;
	private int employeeCode;
	private int quantity;
	private String dateInsert;
	private String timeInsert;
	private int status;

	private List<GcpConfReallocateDatailPojo> detail;

	private ResponseFromServer rfs;

	public GcpConfReallocateMasterPojo() {
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(String dateInsert) {
		this.dateInsert = dateInsert;
	}

	public String getTimeInsert() {
		return timeInsert;
	}

	public void setTimeInsert(String timeInsert) {
		this.timeInsert = timeInsert;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ResponseFromServer getRfs() {
		return rfs;
	}

	public void setRfs(ResponseFromServer rfs) {
		this.rfs = rfs;
	}

	public List<GcpConfReallocateDatailPojo> getDetail() {
		return detail;
	}

	public void setDetail(List<GcpConfReallocateDatailPojo> detail) {
		this.detail = detail;
	}

}
