package ni.com.casapellas.cxccobro.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


public class GcpCollectionNoticeDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	private int activity_Id;
	private double amount_Base_Cor;
	private double amount_Base_Usd;
	private double amount_Cor;
	private double amount_Installment_Cor;
	private double amount_Installment_Usd;
	private double amount_Interest_Cor;
	private double amount_Interest_Usd;
	private double amount_Moratory_Interest_Cor;
	private double amount_Moratory_Interest_Usd;
	private double amount_Usd;
	private String branch_Code;
	private int customer_Code;
	private int document_Number;
	private String document_Type;
	private Date expiration_Date;
	private int installment_Number;
	private Date process_Date;
	private int recipe_Id;
	private String request_Number;

	public GcpCollectionNoticeDetail() {
	}

	public int getActivity_Id() {
		return activity_Id;
	}

	public void setActivity_Id(int activity_Id) {
		this.activity_Id = activity_Id;
	}

	public double getAmount_Base_Cor() {
		return amount_Base_Cor;
	}

	public void setAmount_Base_Cor(double amount_Base_Cor) {
		this.amount_Base_Cor = amount_Base_Cor;
	}

	public double getAmount_Base_Usd() {
		return amount_Base_Usd;
	}

	public void setAmount_Base_Usd(double amount_Base_Usd) {
		this.amount_Base_Usd = amount_Base_Usd;
	}

	public double getAmount_Cor() {
		return amount_Cor;
	}

	public void setAmount_Cor(double amount_Cor) {
		this.amount_Cor = amount_Cor;
	}

	public double getAmount_Installment_Cor() {
		return amount_Installment_Cor;
	}

	public void setAmount_Installment_Cor(double amount_Installment_Cor) {
		this.amount_Installment_Cor = amount_Installment_Cor;
	}

	public double getAmount_Installment_Usd() {
		return amount_Installment_Usd;
	}

	public void setAmount_Installment_Usd(double amount_Installment_Usd) {
		this.amount_Installment_Usd = amount_Installment_Usd;
	}

	public double getAmount_Interest_Cor() {
		return amount_Interest_Cor;
	}

	public void setAmount_Interest_Cor(double amount_Interest_Cor) {
		this.amount_Interest_Cor = amount_Interest_Cor;
	}

	public double getAmount_Interest_Usd() {
		return amount_Interest_Usd;
	}

	public void setAmount_Interest_Usd(double amount_Interest_Usd) {
		this.amount_Interest_Usd = amount_Interest_Usd;
	}

	public double getAmount_Moratory_Interest_Cor() {
		return amount_Moratory_Interest_Cor;
	}

	public void setAmount_Moratory_Interest_Cor(double amount_Moratory_Interest_Cor) {
		this.amount_Moratory_Interest_Cor = amount_Moratory_Interest_Cor;
	}

	public double getAmount_Moratory_Interest_Usd() {
		return amount_Moratory_Interest_Usd;
	}

	public void setAmount_Moratory_Interest_Usd(double amount_Moratory_Interest_Usd) {
		this.amount_Moratory_Interest_Usd = amount_Moratory_Interest_Usd;
	}

	public double getAmount_Usd() {
		return amount_Usd;
	}

	public void setAmount_Usd(double amount_Usd) {
		this.amount_Usd = amount_Usd;
	}

	public String getBranch_Code() {
		return branch_Code;
	}

	public void setBranch_Code(String branch_Code) {
		this.branch_Code = branch_Code;
	}

	public int getCustomer_Code() {
		return customer_Code;
	}

	public void setCustomer_Code(int customer_Code) {
		this.customer_Code = customer_Code;
	}

	public int getDocument_Number() {
		return document_Number;
	}

	public void setDocument_Number(int document_Number) {
		this.document_Number = document_Number;
	}

	public String getDocument_Type() {
		return document_Type;
	}

	public void setDocument_Type(String document_Type) {
		this.document_Type = document_Type;
	}

	public Date getExpiration_Date() {
		return expiration_Date;
	}

	public void setExpiration_Date(Date expiration_Date) {
		this.expiration_Date = expiration_Date;
	}

	public int getInstallment_Number() {
		return installment_Number;
	}

	public void setInstallment_Number(int installment_Number) {
		this.installment_Number = installment_Number;
	}

	public Date getProcess_Date() {
		return process_Date;
	}

	public void setProcess_Date(Date process_Date) {
		this.process_Date = process_Date;
	}

	public int getRecipe_Id() {
		return recipe_Id;
	}

	public void setRecipe_Id(int recipe_Id) {
		this.recipe_Id = recipe_Id;
	}

	public String getRequest_Number() {
		return request_Number;
	}

	public void setRequest_Number(String request_Number) {
		this.request_Number = request_Number;
	}

	
	
}