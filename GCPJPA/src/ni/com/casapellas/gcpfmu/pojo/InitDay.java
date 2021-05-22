package ni.com.casapellas.gcpfmu.pojo;

import java.sql.Date;
import java.util.List;

public class InitDay {

	private int id;
	private int date;
	private int hourTime;
	private String cellarId;
	private String userId;
	private String zoneId;
	private String branchId;
	private int endDate;
	private int endHour;
	private int available;
	private String branchName;
	private int hour;


    private List<InitDayAction> initDayActionList;

    
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	
	public String getCellarId() {
		return cellarId;
	}
	public void setCellarId(String cellarId) {
		this.cellarId = cellarId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public int getEndDate() {
		return endDate;
	}
	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}
	public int getEndHour() {
		return endHour;
	}
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
	
	public List<InitDayAction> getInitDayActionList() {
		return initDayActionList;
	}
	public void setInitDayActionList(List<InitDayAction> initDayActionList) {
		this.initDayActionList = initDayActionList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getHourTime() {
		return hourTime;
	}
	public void setHourTime(int hourTime) {
		this.hourTime = hourTime;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
}
