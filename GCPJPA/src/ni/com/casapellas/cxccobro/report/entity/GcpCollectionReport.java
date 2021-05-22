package ni.com.casapellas.cxccobro.report.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import ni.com.casapellas.util.CollectionScheme;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GCP_COLLECTION_REPORT database table.
 * 
 */
@Entity
@Table(name="GCP_COLLECTION_REPORT", catalog = "SISTEMIP", schema = CollectionScheme.Scheme)
public class GcpCollectionReport implements Serializable {
	private static final long serialVersionUID = 1L;

	//se lo agrego lfonseca, consultar con enrique. 2019-09-18
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="ACCOUNTING_CLASS")
	private String accountingClass;

	@Column(name="CATEGORY_8")
	private String category8;

	private String city;

	@Column(name="COLLECTION_BRANCH")
	private String collectionBranch;

	@Column(name="COLLECTION_BUSSINES_LINE")
	private String collectionBussinesLine;

	@Column(name="COLLECTION_RODE")
	private String collectionRode;

	private String comment1;

	private String comment2;

	private String comment3;

	private String company;

	private String currency;

	@Column(name="CUSTOMER_ADDRESS")
	private String customerAddress;

	@Column(name="CUSTOMER_CODE")
	private int customerCode;

	@Column(name="CUSTOMER_GROUP")
	private String customerGroup;

	@Column(name="CUSTOMER_NAME")
	private String customerName;

	@Column(name="CUSTOMER_TYPE")
	private String customerType;

	private String district;

	@Column(name="DOCUMENT_TYPE")
	private String documentType;

	@Temporal(TemporalType.DATE)
	@Column(name="FINANCING_DATE")
	private Date financingDate;

	@Column(name="ID_REPORT_MASTER")
	private int idReportMaster;

	@Column(name="LAWYER_ASSIGNED")
	private String lawyerAssigned;

	private String municipality;

	@Column(name="ORIGINAL_BUSSINES_LINE_INVOICE")
	private String originalBussinesLineInvoice;

	@Column(name="PENDING_INSTALLMENTS")
	private int pendingInstallments;

	@Column(name="REMAINING_AMOUNT")
	private BigDecimal remainingAmount;

	@Column(name="REMAINING_CURRENT_AMOUNT")
	private BigDecimal remainingCurrentAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="REQUEST_DATE")
	private Date requestDate;

	@Column(name="REQUEST_NUMBER")
	private String requestNumber;

	@Column(name="REQUEST_TYPE")
	private String requestType;

	@Column(name="TOTAL_INSTALLMENTS")
	private int totalInstallments;

	@Column(name="TOTAL_PAYMENT_MONTH1")
	private BigDecimal totalPaymentMonth1;

	@Column(name="TOTAL_PAYMENT_MONTH2")
	private BigDecimal totalPaymentMonth2;

	@Column(name="TOTAL_PAYMENT_MONTH3")
	private BigDecimal totalPaymentMonth3;

	@Column(name="TOTAL_PAYMENT_MONTH4")
	private BigDecimal totalPaymentMonth4;

	@Column(name="TOTAL_PAYMENT_MONTH5")
	private BigDecimal totalPaymentMonth5;

	@Column(name="TOTAL_PAYMENT_MONTH6")
	private BigDecimal totalPaymentMonth6;

	public GcpCollectionReport() {
	}

	public String getAccountingClass() {
		return this.accountingClass;
	}

	public void setAccountingClass(String accountingClass) {
		this.accountingClass = accountingClass;
	}

	public String getCategory8() {
		return this.category8;
	}

	public void setCategory8(String category8) {
		this.category8 = category8;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCollectionBranch() {
		return this.collectionBranch;
	}

	public void setCollectionBranch(String collectionBranch) {
		this.collectionBranch = collectionBranch;
	}

	public String getCollectionBussinesLine() {
		return this.collectionBussinesLine;
	}

	public void setCollectionBussinesLine(String collectionBussinesLine) {
		this.collectionBussinesLine = collectionBussinesLine;
	}

	public String getCollectionRode() {
		return this.collectionRode;
	}

	public void setCollectionRode(String collectionRode) {
		this.collectionRode = collectionRode;
	}

	public String getComment1() {
		return this.comment1;
	}

	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}

	public String getComment2() {
		return this.comment2;
	}

	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}

	public String getComment3() {
		return this.comment3;
	}

	public void setComment3(String comment3) {
		this.comment3 = comment3;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public int getCustomerCode() {
		return this.customerCode;
	}

	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerGroup() {
		return this.customerGroup;
	}

	public void setCustomerGroup(String customerGroup) {
		this.customerGroup = customerGroup;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public Date getFinancingDate() {
		return this.financingDate;
	}

	public void setFinancingDate(Date financingDate) {
		this.financingDate = financingDate;
	}

	public int getIdReportMaster() {
		return this.idReportMaster;
	}

	public void setIdReportMaster(int idReportMaster) {
		this.idReportMaster = idReportMaster;
	}

	public String getLawyerAssigned() {
		return this.lawyerAssigned;
	}

	public void setLawyerAssigned(String lawyerAssigned) {
		this.lawyerAssigned = lawyerAssigned;
	}

	public String getMunicipality() {
		return this.municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getOriginalBussinesLineInvoice() {
		return this.originalBussinesLineInvoice;
	}

	public void setOriginalBussinesLineInvoice(String originalBussinesLineInvoice) {
		this.originalBussinesLineInvoice = originalBussinesLineInvoice;
	}

	public int getPendingInstallments() {
		return this.pendingInstallments;
	}

	public void setPendingInstallments(int pendingInstallments) {
		this.pendingInstallments = pendingInstallments;
	}

	public BigDecimal getRemainingAmount() {
		return this.remainingAmount;
	}

	public void setRemainingAmount(BigDecimal remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public BigDecimal getRemainingCurrentAmount() {
		return this.remainingCurrentAmount;
	}

	public void setRemainingCurrentAmount(BigDecimal remainingCurrentAmount) {
		this.remainingCurrentAmount = remainingCurrentAmount;
	}

	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestNumber() {
		return this.requestNumber;
	}

	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}

	public String getRequestType() {
		return this.requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public int getTotalInstallments() {
		return this.totalInstallments;
	}

	public void setTotalInstallments(int totalInstallments) {
		this.totalInstallments = totalInstallments;
	}

	public BigDecimal getTotalPaymentMonth1() {
		return this.totalPaymentMonth1;
	}

	public void setTotalPaymentMonth1(BigDecimal totalPaymentMonth1) {
		this.totalPaymentMonth1 = totalPaymentMonth1;
	}

	public BigDecimal getTotalPaymentMonth2() {
		return this.totalPaymentMonth2;
	}

	public void setTotalPaymentMonth2(BigDecimal totalPaymentMonth2) {
		this.totalPaymentMonth2 = totalPaymentMonth2;
	}

	public BigDecimal getTotalPaymentMonth3() {
		return this.totalPaymentMonth3;
	}

	public void setTotalPaymentMonth3(BigDecimal totalPaymentMonth3) {
		this.totalPaymentMonth3 = totalPaymentMonth3;
	}

	public BigDecimal getTotalPaymentMonth4() {
		return this.totalPaymentMonth4;
	}

	public void setTotalPaymentMonth4(BigDecimal totalPaymentMonth4) {
		this.totalPaymentMonth4 = totalPaymentMonth4;
	}

	public BigDecimal getTotalPaymentMonth5() {
		return this.totalPaymentMonth5;
	}

	public void setTotalPaymentMonth5(BigDecimal totalPaymentMonth5) {
		this.totalPaymentMonth5 = totalPaymentMonth5;
	}

	public BigDecimal getTotalPaymentMonth6() {
		return this.totalPaymentMonth6;
	}

	public void setTotalPaymentMonth6(BigDecimal totalPaymentMonth6) {
		this.totalPaymentMonth6 = totalPaymentMonth6;
	}

}