package ni.com.casapellas.cxccobro.pojo;

import java.io.Serializable;
import java.util.Date;


public class GcpCollectionNotice implements Serializable {
	private static final long serialVersionUID = 1L;

	private String activityCode;
	private int activityId;
	private String activityTitle;
	private int activityType;
	private double amountBaseCor;
	private double amountBaseUsd;
	private double amountCor;
	private double amountInterestCor;
	private double amountInterestUsd;
	private double amountMoratoryInterestCor;
	private double amountMoratoryInterestUsd;
	private double amountUsd;
	private int automatic;
	private String branchCode;
	private String businessLine;
	private int collectionCodeId;
	private String collectionTitle;
	private String companyCode;
	private int customerCode;
	private String customerName;
	private String customerType;
	private int documentNumber;
	private String documentType;
	private int employeeCode;
	private int installmentQuantity;
	private Date processDate;
	private int range;
	private int recipeId;
	private String requestNumber;
	private int sent;
	private int sequence;
	private int status;
	private int idScript;
	private String customerInfo;
	private String employeeInfo;
	private String guarantorInfo;
	
	public GcpCollectionNotice() {
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getActivityTitle() {
		return activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}

	public double getAmountBaseCor() {
		return amountBaseCor;
	}

	public void setAmountBaseCor(double amountBaseCor) {
		this.amountBaseCor = amountBaseCor;
	}

	public double getAmountBaseUsd() {
		return amountBaseUsd;
	}

	public void setAmountBaseUsd(double amountBaseUsd) {
		this.amountBaseUsd = amountBaseUsd;
	}

	public double getAmountCor() {
		return amountCor;
	}

	public void setAmountCor(double amountCor) {
		this.amountCor = amountCor;
	}

	public double getAmountInterestCor() {
		return amountInterestCor;
	}

	public void setAmountInterestCor(double amountInterestCor) {
		this.amountInterestCor = amountInterestCor;
	}

	public double getAmountInterestUsd() {
		return amountInterestUsd;
	}

	public void setAmountInterestUsd(double amountInterestUsd) {
		this.amountInterestUsd = amountInterestUsd;
	}

	public double getAmountMoratoryInterestCor() {
		return amountMoratoryInterestCor;
	}

	public void setAmountMoratoryInterestCor(double amountMoratoryInterestCor) {
		this.amountMoratoryInterestCor = amountMoratoryInterestCor;
	}

	public double getAmountMoratoryInterestUsd() {
		return amountMoratoryInterestUsd;
	}

	public void setAmountMoratoryInterestUsd(double amountMoratoryInterestUsd) {
		this.amountMoratoryInterestUsd = amountMoratoryInterestUsd;
	}

	public double getAmountUsd() {
		return amountUsd;
	}

	public void setAmountUsd(double amountUsd) {
		this.amountUsd = amountUsd;
	}

	public int getAutomatic() {
		return automatic;
	}

	public void setAutomatic(int automatic) {
		this.automatic = automatic;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBusinessLine() {
		return businessLine;
	}

	public void setBusinessLine(String businessLine) {
		this.businessLine = businessLine;
	}

	public int getCollectionCodeId() {
		return collectionCodeId;
	}

	public void setCollectionCodeId(int collectionCodeId) {
		this.collectionCodeId = collectionCodeId;
	}

	public String getCollectionTitle() {
		return collectionTitle;
	}

	public void setCollectionTitle(String collectionTitle) {
		this.collectionTitle = collectionTitle;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

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

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public int getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(int documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public int getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}

	public int getInstallmentQuantity() {
		return installmentQuantity;
	}

	public void setInstallmentQuantity(int installmentQuantity) {
		this.installmentQuantity = installmentQuantity;
	}

	public Date getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}

	public int getSent() {
		return sent;
	}

	public void setSent(int sent) {
		this.sent = sent;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIdScript() {
		return idScript;
	}

	public void setIdScript(int idScript) {
		this.idScript = idScript;
	}

	public String getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(String customerInfo) {
		this.customerInfo = customerInfo;
	}

	public String getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(String employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public String getGuarantorInfo() {
		return guarantorInfo;
	}

	public void setGuarantorInfo(String guarantorInfo) {
		this.guarantorInfo = guarantorInfo;
	}


}