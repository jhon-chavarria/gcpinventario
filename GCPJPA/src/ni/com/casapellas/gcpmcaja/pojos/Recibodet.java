package ni.com.casapellas.gcpmcaja.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


public class Recibodet implements Serializable {
	private static final long serialVersionUID = 1L;
	private int caid;
	private double caidpos;
	private String codcomp;
	private String codsuc;
	private double equiv;
	private String moneda;
	private double monto;
	private String mpago;
	private String mpagoDescri;
	private String nombre;
	private Integer numrec;
	private Integer numrecm;
	private String refer1;
	private String refer2;
	private String refer3;
	private String refer4;
	private String refer5;
	private String refer6;
	private String refer7;
	private double tasa;
	private String tiporec;
	private String vmanual;

	public Recibodet() {
	}


	public String getCodcomp() {
		return this.codcomp;
	}

	public void setCodcomp(String codcomp) {
		this.codcomp = codcomp;
	}

	public String getCodsuc() {
		return this.codsuc;
	}

	public void setCodsuc(String codsuc) {
		this.codsuc = codsuc;
	}

	public String getMoneda() {
		return this.moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}


	public String getMpago() {
		return this.mpago;
	}

	public void setMpago(String mpago) {
		this.mpago = mpago;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRefer1() {
		return this.refer1;
	}

	public void setRefer1(String refer1) {
		this.refer1 = refer1;
	}

	public String getRefer2() {
		return this.refer2;
	}

	public void setRefer2(String refer2) {
		this.refer2 = refer2;
	}

	public String getRefer3() {
		return this.refer3;
	}

	public void setRefer3(String refer3) {
		this.refer3 = refer3;
	}

	public String getRefer4() {
		return this.refer4;
	}

	public void setRefer4(String refer4) {
		this.refer4 = refer4;
	}

	public String getRefer5() {
		return this.refer5;
	}

	public void setRefer5(String refer5) {
		this.refer5 = refer5;
	}

	public String getRefer6() {
		return this.refer6;
	}

	public void setRefer6(String refer6) {
		this.refer6 = refer6;
	}

	public String getRefer7() {
		return this.refer7;
	}

	public void setRefer7(String refer7) {
		this.refer7 = refer7;
	}


	public String getTiporec() {
		return this.tiporec;
	}

	public void setTiporec(String tiporec) {
		this.tiporec = tiporec;
	}

	public String getVmanual() {
		return this.vmanual;
	}

	public void setVmanual(String vmanual) {
		this.vmanual = vmanual;
	}

	public String getMpagoDescri() {
		return mpagoDescri;
	}

	public void setMpagoDescri(String mpagoDescri) {
		this.mpagoDescri = mpagoDescri;
	}


	public int getCaid() {
		return caid;
	}


	public void setCaid(int caid) {
		this.caid = caid;
	}


	public double getCaidpos() {
		return caidpos;
	}


	public void setCaidpos(double caidpos) {
		this.caidpos = caidpos;
	}


	public double getEquiv() {
		return equiv;
	}


	public void setEquiv(double equiv) {
		this.equiv = equiv;
	}


	public double getMonto() {
		return monto;
	}


	public void setMonto(double monto) {
		this.monto = monto;
	}


	public Integer getNumrec() {
		return numrec;
	}


	public void setNumrec(Integer numrec) {
		this.numrec = numrec;
	}


	public Integer getNumrecm() {
		return numrecm;
	}


	public void setNumrecm(Integer numrecm) {
		this.numrecm = numrecm;
	}


	public double getTasa() {
		return tasa;
	}


	public void setTasa(double tasa) {
		this.tasa = tasa;
	}
	
	

}