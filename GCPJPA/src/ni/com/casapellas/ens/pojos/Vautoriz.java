package ni.com.casapellas.ens.pojos;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.Size;



public class Vautoriz  {
	private String coduser;

	private String login;

	private String tipuser;

	private BigDecimal codreg;

	private String codper;

	private String nomper;

	private String codapp;

	private String nomcorto;

	private String nomapp;

	private String codsec;

	private String codsuper;

	private String nomsec;

	private String iconurl;

	private String outcome;

	private String enmenu;

	private String codaut;

	private String nomaut;

	private String alcance;

	private String url;

	private int orden;
	
	private String seccionlogo;
	
	public String getSeccionlogo() {
		return seccionlogo;
	}

	public void setSeccionlogo(String seccionlogo) {
		this.seccionlogo = seccionlogo;
	}

	public String getSeccionicon() {
		return seccionicon;
	}

	public void setSeccionicon(String seccionicon) {
		this.seccionicon = seccionicon;
	}

	public String getAplicacionlogo() {
		return aplicacionlogo;
	}

	public void setAplicacionlogo(String aplicacionlogo) {
		this.aplicacionlogo = aplicacionlogo;
	}

	public String getAplicacionicon() {
		return aplicacionicon;
	}

	public void setAplicacionicon(String aplicacionicon) {
		this.aplicacionicon = aplicacionicon;
	}

	public String getAplicacionversion() {
		return aplicacionversion;
	}

	public void setAplicacionversion(String aplicacionversion) {
		this.aplicacionversion = aplicacionversion;
	}

	public String getAplicacioncopyright() {
		return aplicacioncopyright;
	}

	public void setAplicacioncopyright(String aplicacioncopyright) {
		this.aplicacioncopyright = aplicacioncopyright;
	}

	private String seccionicon;
	
	private String aplicacionlogo;
	
	private String aplicacionicon;
	
	private String aplicacionversion;
	
	private String aplicacioncopyright;

	public Vautoriz() {
		super();
	}

	public String getCoduser() {
		return this.coduser;
	}

	public void setCoduser(String coduser) {
		this.coduser = coduser;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTipuser() {
		return this.tipuser;
	}

	public void setTipuser(String tipuser) {
		this.tipuser = tipuser;
	}

	public BigDecimal getCodreg() {
		return this.codreg;
	}

	public void setCodreg(BigDecimal codreg) {
		this.codreg = codreg;
	}

	public String getCodper() {
		return this.codper;
	}

	public void setCodper(String codper) {
		this.codper = codper;
	}

	public String getNomper() {
		return this.nomper;
	}

	public void setNomper(String nomper) {
		this.nomper = nomper;
	}

	public String getCodapp() {
		return this.codapp;
	}

	public void setCodapp(String codapp) {
		this.codapp = codapp;
	}

	public String getNomcorto() {
		return this.nomcorto;
	}

	public void setNomcorto(String nomcorto) {
		this.nomcorto = nomcorto;
	}

	public String getNomapp() {
		return this.nomapp;
	}

	public void setNomapp(String nomapp) {
		this.nomapp = nomapp;
	}

	public String getCodsec() {
		return this.codsec;
	}

	public void setCodsec(String codsec) {
		this.codsec = codsec;
	}

	public String getCodsuper() {
		return this.codsuper;
	}

	public void setCodsuper(String codsuper) {
		this.codsuper = codsuper;
	}

	public String getNomsec() {
		return this.nomsec;
	}

	public void setNomsec(String nomsec) {
		this.nomsec = nomsec;
	}

	public String getIconurl() {
		return this.iconurl;
	}

	public void setIconurl(String iconurl) {
		this.iconurl = iconurl;
	}

	public String getOutcome() {
		return this.outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getEnmenu() {
		return this.enmenu;
	}

	public void setEnmenu(String enmenu) {
		this.enmenu = enmenu;
	}

	public String getCodaut() {
		return this.codaut;
	}

	public void setCodaut(String codaut) {
		this.codaut = codaut;
	}

	public String getNomaut() {
		return this.nomaut;
	}

	public void setNomaut(String nomaut) {
		this.nomaut = nomaut;
	}

	public String getAlcance() {
		return this.alcance;
	}

	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

}
