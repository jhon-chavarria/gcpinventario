package ni.com.casapellas.cxccobro.pojo;

import java.util.Date;

import ni.com.casapellas.geninfo.pojo.ResponseFromServer;

public class GcpConfCollectionCompanyPojo {
	private int id;
	private String code;
	private int iuser;
	private String siuser;
	private String idate;
	private String itime;
	private int uuser;
	private String suuser;
	private String udate;
	private String utime;
	private int status;
	private String companyName;
	private ResponseFromServer response;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getIuser() {
		return iuser;
	}

	public void setIuser(int iuser) {
		this.iuser = iuser;
	}

	public String getIdate() {
		return idate;
	}

	public void setIdate(String idate) {
		this.idate = idate;
	}

	public String getItime() {
		return itime;
	}

	public void setItime(String itime) {
		this.itime = itime;
	}

	public int getUuser() {
		return uuser;
	}

	public void setUuser(int uuser) {
		this.uuser = uuser;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSiuser() {
		return siuser;
	}

	public void setSiuser(String siuser) {
		this.siuser = siuser;
	}

	public String getSuuser() {
		return suuser;
	}

	public void setSuuser(String suuser) {
		this.suuser = suuser;
	}

	public ResponseFromServer getResponse() {
		return response;
	}

	public void setResponse(ResponseFromServer response) {
		this.response = response;
	}

	public String getUdate() {
		return udate;
	}

	public void setUdate(String udate) {
		this.udate = udate;
	}

	public String getUtime() {
		return utime;
	}

	public void setUtime(String utime) {
		this.utime = utime;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
