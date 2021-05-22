package ni.com.casapellas.gcpmcaja.pojos;

import java.io.Serializable;

public class Recibojde implements Serializable {
	private static final long serialVersionUID = 1L;
	private int caid;
	private String codcomp;
	private String codsuc;
	private Integer nobatch;
	private Integer numrec;
	private Integer recjde;
	private String tipodoc;
	private String tiporec;
  
	public Recibojde() {
	}

	
	public int getCaid() {
		return caid;
	}


	public void setCaid(int caid) {
		this.caid = caid;
	}


	public String getCodcomp() {
		return codcomp;
	}


	public void setCodcomp(String codcomp) {
		this.codcomp = codcomp;
	}


	public String getCodsuc() {
		return codsuc;
	}


	public void setCodsuc(String codsuc) {
		this.codsuc = codsuc;
	}


	public Integer getNobatch() {
		return nobatch;
	}


	public void setNobatch(Integer nobatch) {
		this.nobatch = nobatch;
	}


	public Integer getNumrec() {
		return numrec;
	}


	public void setNumrec(Integer numrec) {
		this.numrec = numrec;
	}


	public Integer getRecjde() {
		return recjde;
	}


	public void setRecjde(Integer recjde) {
		this.recjde = recjde;
	}


	public String getTipodoc() {
		return this.tipodoc;
	}

	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}

	public String getTiporec() {
		return this.tiporec;
	}

	public void setTiporec(String tiporec) {
		this.tiporec = tiporec;
	}

}