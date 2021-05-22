package ni.com.casapellas.cxccobro.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GcpRequestedActivityPojo {

	private Date date;
	private int customerCode;
	private String customerName;
	private int idActivity;
	private String activityName;
	private int employeeCode;
	private String employeeName;
	private Date dateToSubject;
	private String comment;
	private String time;
	private int idMotive;
	private String amount;
	private String currency;
	private int status;
	
	
	 
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
	public int getIdActivity() {
		return idActivity;
	}
	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public int getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDateToSubject() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sdf.format(dateToSubject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateToSubject+"";
	}
	public void setDateToSubject(Date dateToSubject) {
		this.dateToSubject = dateToSubject;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	 
	public int getIdMotive() {
		return idMotive;
	}
	public void setIdMotive(int idMotive) {
		this.idMotive = idMotive;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	
}
