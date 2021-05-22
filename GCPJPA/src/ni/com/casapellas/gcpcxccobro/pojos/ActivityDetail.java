package ni.com.casapellas.gcpcxccobro.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityDetail {

	private  int customerCode;
	private String customerNAme;
	private String activityTitle;
	private String date;
	private String time;
	private String amount;
	private String promissoryNote;
	private String employeeInCharge;
	private String comment;
	private int reminder;
	private int employeeCode;
	private String employeeName;
	private String activityTypeCode;
	private String activitycode;
	private int sequence;
	private String processDate;
	private int status;
	private int det1;
	private int det2;
	private int td;
	private String currency;
	private String processDateb;
	private String pF;
	private String cF;
	private String pFName;
	private String cFName;
	
	
	
	public int getTd() {
		return td;
	}
	public void setTd(int td) {
		this.td = td;
	}
	public String getpFName() {
		return pFName;
	}
	public void setpFName(String pFName) {
		this.pFName = pFName;
	}
	public String getcFName() {
		return cFName;
	}
	public void setcFName(String cFName) {
		this.cFName = cFName;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	private List<CollectionDetail> collectionDetail = new ArrayList<CollectionDetail>();
	
	private List<DocumentsDetail> documentDetail = new ArrayList<DocumentsDetail>();
	
	private List<Document_Shipment> documentShipment = new ArrayList<Document_Shipment>();  
	
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	 
	public String getProcessDate() {
		return processDate;
	}
	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
	public String getActivityTypeCode() {
		return activityTypeCode;
	}
	public void setActivityTypeCode(String activityTypeCode) {
		this.activityTypeCode = activityTypeCode;
	}
	public String getActivitycode() {
		return activitycode;
	}
	public void setActivitycode(String activitycode) {
		this.activitycode = activitycode;
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
	public List<CollectionDetail> getCollectionDetail() {
		return collectionDetail;
	}
	public void setCollectionDetail(List<CollectionDetail> collectionDetail) {
		this.collectionDetail = collectionDetail;
	}
	public List<DocumentsDetail> getDocumentDetail() {
		return documentDetail;
	}
	public void setDocumentDetail(List<DocumentsDetail> documentDetail) {
		this.documentDetail = documentDetail;
	}
	public int getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerNAme() {
		return customerNAme;
	}
	public void setCustomerNAme(String customerNAme) {
		this.customerNAme = customerNAme;
	}
	public String getActivityTitle() {
		return activityTitle;
	}
	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	 
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPromissoryNote() {
		return promissoryNote;
	}
	public void setPromissoryNote(String promissoryNote) {
		this.promissoryNote = promissoryNote;
	}
	public String getEmployeeInCharge() {
		return employeeInCharge;
	}
	public void setEmployeeInCharge(String employeeInCharge) {
		this.employeeInCharge = employeeInCharge;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getReminder() {
		return reminder;
	}
	public void setReminder(int reminder) {
		this.reminder = reminder;
	}
	public int getDet1() {
		return det1;
	}
	public void setDet1(int det1) {
		this.det1 = det1;
	}
	public int getDet2() {
		return det2;
	}
	public void setDet2(int det2) {
		this.det2 = det2;
	}
	public String getProcessDateb() {
		return processDateb;
	}
	public void setProcessDateb(String processDateb) {
		this.processDateb = processDateb;
	}
	public String getpF() {
		return pF;
	}
	public void setpF(String pF) {
		this.pF = pF;
	}
	public String getcF() {
		return cF;
	}
	public void setcF(String cF) {
		this.cF = cF;
	}
	public List<Document_Shipment> getDocumentShipment() {
		return documentShipment;
	}
	public void setDocumentShipment(List<Document_Shipment> documentShipment) {
		this.documentShipment = documentShipment;
	}
	 
	
	
	
	
}
