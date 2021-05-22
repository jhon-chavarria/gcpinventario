package ni.com.casapellas.gcpmcaja.pojos;

import java.util.ArrayList;
import java.util.List;

public class RequestInformation {

	private String branch;
	private String branchName;
	private String company;
	private String companyName;
	private String requestDate;
	private int customer;
	private String customerName;
	private double customerIncomes;
	private String businessLine;
	private String businessLineName;
	private int quantity;
	private double amountCor;
	private double initialPaymentCor;
	private double exchangeRate;
	private double amountUsd;
	private double initialPaymentUsd;
	private String currentState;
	private String paymentMode;
	private String paymentModeName;
	private double maxRate;
	private String productType;
	private String productTypeName;
	private String currency;
	private int requestnumber;
	private int employeecode;
	private String employeename;
	private String guarantor;
	private String juridicalGuarantor;
	
	private  List<Clientinfo> lstClients = new ArrayList<Clientinfo>();
	
	private Producto product = new Producto(); 
	
	
	public Producto getProduct() {
		return product;
	}
	public void setProduct(Producto product) {
		this.product = product;
	}
	public int getEmployeecode() {
		return employeecode;
	}
	public void setEmployeecode(int employeecode) {
		this.employeecode = employeecode;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getGuarantor() {
		return guarantor;
	}
	public void setGuarantor(String guarantor) {
		this.guarantor = guarantor;
	}
	public String getJuridicalGuarantor() {
		return juridicalGuarantor;
	}
	public void setJuridicalGuarantor(String juridicalGuarantor) {
		this.juridicalGuarantor = juridicalGuarantor;
	}
	public int getRequestnumber() {
		return requestnumber;
	}
	public void setRequestnumber(int requestnumber) {
		this.requestnumber = requestnumber;
	}
	public List<Clientinfo> getLstClients() {
		return lstClients;
	}
	public void setLstClients(List<Clientinfo> lstClients) {
		this.lstClients = lstClients;
	}
	public double getCustomerIncomes() {
		return customerIncomes;
	}
	public void setCustomerIncomes(double customerIncomes) {
		this.customerIncomes = customerIncomes;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public int getCustomer() {
		return customer;
	}
	public void setCustomer(int customer) {
		this.customer = customer;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getBusinessLine() {
		return businessLine;
	}
	public void setBusinessLine(String businessLine) {
		this.businessLine = businessLine;
	}
	public String getBusinessLineName() {
		return businessLineName;
	}
	public void setBusinessLineName(String businessLineName) {
		this.businessLineName = businessLineName;
	}
	public double getAmountCor() {
		return amountCor;
	}
	public void setAmountCor(double amountCor) {
		this.amountCor = amountCor;
	}
	public double getInitialPaymentCor() {
		return initialPaymentCor;
	}
	public void setInitialPaymentCor(double initialPaymentCor) {
		this.initialPaymentCor = initialPaymentCor;
	}
	public double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public double getAmountUsd() {
		return amountUsd;
	}
	public void setAmountUsd(double amountUsd) {
		this.amountUsd = amountUsd;
	}
	public double getInitialPaymentUsd() {
		return initialPaymentUsd;
	}
	public void setInitialPaymentUsd(double initialPaymentUsd) {
		this.initialPaymentUsd = initialPaymentUsd;
	}
	public String getCurrentState() {
		return currentState;
	}
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getPaymentModeName() {
		return paymentModeName;
	}
	public void setPaymentModeName(String paymentModeName) {
		this.paymentModeName = paymentModeName;
	}
	public double getMaxRate() {
		return maxRate;
	}
	public void setMaxRate(double maxRate) {
		this.maxRate = maxRate;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
