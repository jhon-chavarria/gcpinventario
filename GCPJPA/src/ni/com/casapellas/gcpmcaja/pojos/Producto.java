package ni.com.casapellas.gcpmcaja.pojos;

import java.io.Serializable;

public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	private double cant;
	private double codcli;
	private String codmarca;
	private String codmodelo;
	private String codprod;
	private String codsuc;
	private String descmarca;
	private String descmodelo;
	private double nosol;
	private double precioun;
	private double r2fup;
	private double r2uprc;
	private String tiposol;
	private String descprod;
	private String chasis;

	public String getDescprod() {
		return descprod;
	}

	public void setDescprod(String descprod) {
		this.descprod = descprod;
	}

	public Producto() {
	}

	public double getCant() {
		return cant;
	}

	public void setCant(double cant) {
		this.cant = cant;
	}

	public double getCodcli() {
		return codcli;
	}

	public void setCodcli(double codcli) {
		this.codcli = codcli;
	}

	public String getCodmarca() {
		return codmarca;
	}

	public void setCodmarca(String codmarca) {
		this.codmarca = codmarca;
	}

	public String getCodmodelo() {
		return codmodelo;
	}

	public void setCodmodelo(String codmodelo) {
		this.codmodelo = codmodelo;
	}

	public String getCodprod() {
		return codprod;
	}

	public void setCodprod(String codprod) {
		this.codprod = codprod;
	}

	public String getCodsuc() {
		return codsuc;
	}

	public void setCodsuc(String codsuc) {
		this.codsuc = codsuc;
	}

	public String getDescmarca() {
		return descmarca;
	}

	public void setDescmarca(String descmarca) {
		this.descmarca = descmarca;
	}

	public String getDescmodelo() {
		return descmodelo;
	}

	public void setDescmodelo(String descmodelo) {
		this.descmodelo = descmodelo;
	}

	public double getNosol() {
		return nosol;
	}

	public void setNosol(double nosol) {
		this.nosol = nosol;
	}

	public double getPrecioun() {
		return precioun;
	}

	public void setPrecioun(double precioun) {
		this.precioun = precioun;
	}

	public double getR2fup() {
		return r2fup;
	}

	public void setR2fup(double r2fup) {
		this.r2fup = r2fup;
	}

	public double getR2uprc() {
		return r2uprc;
	}

	public void setR2uprc(double r2uprc) {
		this.r2uprc = r2uprc;
	}

	public String getTiposol() {
		return tiposol;
	}

	public void setTiposol(String tiposol) {
		this.tiposol = tiposol;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	

}