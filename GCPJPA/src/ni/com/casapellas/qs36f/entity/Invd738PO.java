package ni.com.casapellas.qs36f.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Invd738PO {

	private int cantBox;
	private int units;
	private double sale;
	private double saleus;
	private double returns;
	private double returnsus;
	private double rebates;	
	private double rebatesus;
	private double credit_sale_cor;
	private double credit_sale_usd;
	private double utility_range_cor;
	private double utility_range_usd;
	private String label;
	private String code;
	private String name;
	private String year;
	private String month;
	private String nday;
	private String othercode;

	public Invd738PO() {
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	public int getCantBox() {
		return cantBox;
	}

	public void setCantBox(int cantBox) {
		this.cantBox = cantBox;
	}	

	public double getSale() {
		return sale;
	}

	public void setSale(double sale) {
		this.sale = sale;
	}

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getReturns() {
		return returns;
	}

	public void setReturns(double returns) {
		this.returns = returns;
	}

	public double getRebates() {
		return rebates;
	}

	public void setRebates(double rebates) {
		this.rebates = rebates;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getSaleus() {
		return saleus;
	}

	public void setSaleus(double saleus) {
		this.saleus = saleus;
	}

	public double getReturnsus() {
		return returnsus;
	}

	public void setReturnsus(double returnsus) {
		this.returnsus = returnsus;
	}

	public double getRebatesus() {
		return rebatesus;
	}

	public void setRebatesus(double rebatesus) {
		this.rebatesus = rebatesus;
	}

	public double getCredit_sale_cor() {
		return credit_sale_cor;
	}

	public void setCredit_sale_cor(double credit_sale_cor) {
		this.credit_sale_cor = credit_sale_cor;
	}

	public double getCredit_sale_usd() {
		return credit_sale_usd;
	}

	public void setCredit_sale_usd(double credit_sale_usd) {
		this.credit_sale_usd = credit_sale_usd;
	}

	public double getUtility_range_cor() {
		return utility_range_cor;
	}

	public void setUtility_range_cor(double utility_range_cor) {
		this.utility_range_cor = utility_range_cor;
	}


	public double getUtility_range_usd() {
		return utility_range_usd;
	}

	public void setUtility_range_usd(double utility_range_usd) {
		this.utility_range_usd = utility_range_usd;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getNday() {
		return nday;
	}

	public void setNday(String nday) {
		this.nday = nday;
	}

	public String getOthercode() {
		return othercode;
	}

	public void setOthercode(String othercode) {
		this.othercode = othercode;
	}



}
