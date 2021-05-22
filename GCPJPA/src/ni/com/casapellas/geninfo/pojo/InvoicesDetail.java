package ni.com.casapellas.geninfo.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InvoicesDetail {

	private  String invoiceType; 
	private  String invoiceNumber; 
	private  String invoiceInstallment; 
	private  Date invoiceExpirationDate; 
	private String invoicePendingAmountCor;
	private String invoiceAmountUsd;
	private String invoiceAmountCor;
	private String invoicePendingAmountUsd;
	private  String documentNumber;
	private  String invoiceCompany;
	private  String invoiceStatus;
	private  String voucherNumber;
	private String companyCode;
	private String currency;
	private String companyName;
	private String status;
	private String creditStatus;
	private String creditStatusValue;	
	private String julianDate;
	private String businessUnit;
	private String branchOffice;
	private String businessUnitCode;
	private String branchCode;
	private String orderInvoiceType;
	   
	
	 
	public String getBusinessUnitCode() {
		return businessUnitCode;
	}
	public void setBusinessUnitCode(String businessUnitCode) {
		this.businessUnitCode = businessUnitCode;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public String getBranchOffice() {
		return branchOffice;
	}
	public void setBranchOffice(String branchOffice) {
		this.branchOffice = branchOffice;
	}
	public String getCreditStatusValue() {
		return creditStatusValue;
	}
	public void setCreditStatusValue(String creditStatusValue) {
		this.creditStatusValue = creditStatusValue;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getInvoiceInstallment() {
		return invoiceInstallment;
	}
	public void setInvoiceInstallment(String invoiceInstallment) {
		this.invoiceInstallment = invoiceInstallment;
	}
	 
	public String getOrderInvoiceType() {
		return orderInvoiceType;
	}
	public void setOrderInvoiceType(String orderInvoiceType) {
		this.orderInvoiceType = orderInvoiceType;
	}

	 
	public String getInvoiceExpirationDate() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			return sdf.format(invoiceExpirationDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invoiceExpirationDate+"";
	}
	public void setInvoiceExpirationDate(Date invoiceExpirationDate) {
		this.invoiceExpirationDate = invoiceExpirationDate;
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
	public String getInvoiceCompany() {
		return invoiceCompany;
	}
	public void setInvoiceCompany(String invoiceCompany) {
		this.invoiceCompany = invoiceCompany;
	}
	public String getInvoiceStatus() {
		return invoiceStatus;
	}
	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	public String getVoucherNumber() {
		return voucherNumber;
	}
	public void setVoucherNumber(String voucherNumber) {
		this.voucherNumber = voucherNumber;
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
	public String getInvoiceAmountCor() {
		return invoiceAmountCor;
	}
	public void setInvoiceAmountCor(String invoiceAmountCor) {
		this.invoiceAmountCor = invoiceAmountCor;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
	
	
}
