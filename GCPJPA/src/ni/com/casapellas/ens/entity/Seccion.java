package ni.com.casapellas.ens.entity;

import java.io.Serializable;


/**
 * The persistent class for the SECCION database table.
 * 
 */
public class Seccion implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codsec;
	private String activa;
	private String codsuper;
	private String descrip;
	private String enhome;
	private String enmenu;
	private String fregistro;
	private String iconurl;
	private String nombre;
	private String outcome;
	private String url;
	private String seccionlogo;
	private String seccionicon;

    public Seccion() {
    }

	public String getCodsec() {
		return this.codsec;
	}

	public void setCodsec(String codsec) {
		this.codsec = codsec;
	}

	public String getActiva() {
		return this.activa;
	}

	public void setActiva(String activa) {
		this.activa = activa;
	}

	public String getCodsuper() {
		return this.codsuper;
	}

	public void setCodsuper(String codsuper) {
		this.codsuper = codsuper;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getEnhome() {
		return this.enhome;
	}

	public void setEnhome(String enhome) {
		this.enhome = enhome;
	}

	public String getEnmenu() {
		return this.enmenu;
	}

	public void setEnmenu(String enmenu) {
		this.enmenu = enmenu;
	}

	public String getIconurl() {
		return this.iconurl;
	}

	public void setIconurl(String iconurl) {
		this.iconurl = iconurl;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOutcome() {
		return this.outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFregistro() {
		return fregistro;
	}

	public void setFregistro(String fregistro) {
		this.fregistro = fregistro;
	}

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

}