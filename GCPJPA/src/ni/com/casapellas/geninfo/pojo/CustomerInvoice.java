package ni.com.casapellas.geninfo.pojo;

import java.util.ArrayList;
import java.util.List;


public class CustomerInvoice {

	private String companyCode;
	private String invoiceNumber;
	private String invoiceAmountCor;
	private String invoicePendingAmountCor;
	private String invoiceAmountUsd;
	private String invoicePendingAmountUsd;
	private String invoiceDate;
	private String documentNumber;
	private String businessLine;
	private String currency;
	private String productFamily;
	private String status;
	private String creditStatus;
	private String julianDate;
	private String invoiceType; 
	private String branch;
	private String documentNumberType;
	private String branchName;
	private String bussUnit;
	private String orderInvoiceType;
	
	
	
	
	public String getBussUnit() {
		return bussUnit;
	}
	public void setBussUnit(String bussUnit) {
		this.bussUnit = bussUnit;
	}
	public String getOrderInvoiceType() {
		return orderInvoiceType;
	}
	public void setOrderInvoiceType(String orderInvoiceType) {
		this.orderInvoiceType = orderInvoiceType;
	}
	public String getDocumentNumberType() {
		return documentNumberType;
	}
	public void setDocumentNumberType(String documentNumberType) {
		this.documentNumberType = documentNumberType;
	}
	private List<InvoicesDetail> lstDetail = new ArrayList<InvoicesDetail>();
	  
	
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	
	public String getInvoiceAmountCor() {
		return invoiceAmountCor;
	}
	public void setInvoiceAmountCor(String invoiceAmountCor) {
		this.invoiceAmountCor = invoiceAmountCor;
	}
	public String getInvoicePendingAmountCor() {
		return invoicePendingAmountCor;
	}
	public void setInvoicePendingAmountCor(String invoicePendingAmountCor) {
		this.invoicePendingAmountCor = invoicePendingAmountCor;
	}
	public String getInvoiceAmountUsd() {
		return invoiceAmountUsd;
	}
	public void setInvoiceAmountUsd(String invoiceAmountUsd) {
		this.invoiceAmountUsd = invoiceAmountUsd;
	}
	public String getInvoicePendingAmountUsd() {
		return invoicePendingAmountUsd;
	}
	public void setInvoicePendingAmountUsd(String invoicePendingAmountUsd) {
		this.invoicePendingAmountUsd = invoicePendingAmountUsd;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getBusinessLine() {
		return businessLine;
	}
	public void setBusinessLine(String businessLine) {
		this.businessLine = businessLine;
	}
	public List<InvoicesDetail> getLstDetail() {
		return lstDetail;
	}
	public void setLstDetail(InvoicesDetail obj) {
		this.lstDetail.add(obj);
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getProductFamily() {
		return productFamily;
	}
	public void setProductFamily(String productFamily) {
		this.productFamily = productFamily;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getCreditStatus() {
		return creditStatus;
	}
	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}
	public String getJulianDate() {
		return julianDate;
	}
	public void setJulianDate(String julianDate) {
		this.julianDate = julianDate;
	}
	 
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
		
	
	
}
