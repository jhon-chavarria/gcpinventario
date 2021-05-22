package ni.com.casapellas.qs36f.pojos;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

public class PSotreco {
	private String compan;
	private BigDecimal norden;
	private BigDecimal numlin;
	private Date rcfech;
	private String rchech;
	private Time rchora;
	private String rcpant;
	private String rcprog;
	private String recomen;
	private String sucurs;
	
	public String getCompan() {
		return compan;
	}
	public void setCompan(String compan) {
		this.compan = compan;
	}
	public BigDecimal getNorden() {
		return norden;
	}
	public void setNorden(BigDecimal norden) {
		this.norden = norden;
	}
	public BigDecimal getNumlin() {
		return numlin;
	}
	public void setNumlin(BigDecimal numlin) {
		this.numlin = numlin;
	}
	public Date getRcfech() {
		return rcfech;
	}
	public void setRcfech(Date rcfech) {
		this.rcfech = rcfech;
	}
	public String getRchech() {
		return rchech;
	}
	public void setRchech(String rchech) {
		this.rchech = rchech;
	}
	public Time getRchora() {
		return rchora;
	}
	public void setRchora(Time rchora) {
		this.rchora = rchora;
	}
	public String getRcpant() {
		return rcpant;
	}
	public void setRcpant(String rcpant) {
		this.rcpant = rcpant;
	}
	public String getRcprog() {
		return rcprog;
	}
	public void setRcprog(String rcprog) {
		this.rcprog = rcprog;
	}
	public String getRecomen() {
		return recomen;
	}
	public void setRecomen(String recomen) {
		this.recomen = recomen;
	}
	public String getSucurs() {
		return sucurs;
	}
	public void setSucurs(String sucurs) {
		this.sucurs = sucurs;
	}
}
