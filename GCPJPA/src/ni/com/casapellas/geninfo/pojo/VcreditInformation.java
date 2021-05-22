package ni.com.casapellas.geninfo.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class VcreditInformation implements Serializable {
	private static final long serialVersionUID = 1L;

	private double creditLimit;
	private int customerNumber;
	private double debtAverage;
	private String firstInvoice;
	private String lastInvoice;
	private String lastPayment;
	private String lastStatement;
	private String creditDays;
	private double debts;

	public VcreditInformation() {
	}
	public int getCustomerNumber() {  
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getFirstInvoice() {
		return firstInvoice;
	}

	public void setFirstInvoice(String firstInvoice) {
		this.firstInvoice = firstInvoice;
	}

	public String getLastInvoice() {
		return lastInvoice;
	}

	public void setLastInvoice(String lastInvoice) {
		this.lastInvoice = lastInvoice;
	}

	public String getLastPayment() {
		return lastPayment;
	}

	public void setLastPayment(String lastPayment) {
		this.lastPayment = lastPayment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLastStatement() {
		return lastStatement;
	}

	public void setLastStatement(String lastStatement) {
		this.lastStatement = lastStatement;
	}

	public String getCreditDays() {
		return creditDays;
	}

	public void setCreditDays(String creditDays) {
		this.creditDays = creditDays;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public double getDebtAverage() {
		return debtAverage;
	}
	public void setDebtAverage(double debtAverage) {
		this.debtAverage = debtAverage;
	}
	public double getDebts() {
		return debts;
	}
	public void setDebts(double debts) {
		this.debts = debts;
	}

	
	
	
	
}