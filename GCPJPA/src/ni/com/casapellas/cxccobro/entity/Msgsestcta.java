package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;

import ni.com.casapellas.util.CollectionScheme;

import java.util.Date;


/**
 * The persistent class for the MSGSESTCTA database table.
 * 
 */
@Entity
@Table(name = "MSGSESTCTA", catalog = "SISTEMIP", schema = "GCPCXC")
public class Msgsestcta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long idmsgestcta;

	private String codcomp;

	private java.math.BigDecimal estado;

	@Temporal(TemporalType.DATE)
	private Date fechacrea;

	@Temporal(TemporalType.DATE)
	private Date fechamodi;

	private String hechopor;

	@Lob
	private byte[] logocomp;

	private String mfooter1;

	private String mfooter2;

	private String mheader1;

	private String mheader2;

	private String modificadopor;

	private String nombrefile;

	public Msgsestcta() {
	}

	public long getIdmsgestcta() {
		return this.idmsgestcta;
	}

	public void setIdmsgestcta(long idmsgestcta) {
		this.idmsgestcta = idmsgestcta;
	}

	public String getCodcomp() {
		return this.codcomp;
	}

	public void setCodcomp(String codcomp) {
		this.codcomp = codcomp;
	}

	public java.math.BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(java.math.BigDecimal estado) {
		this.estado = estado;
	}

	public Date getFechacrea() {
		return this.fechacrea;
	}

	public void setFechacrea(Date fechacrea) {
		this.fechacrea = fechacrea;
	}

	public Date getFechamodi() {
		return this.fechamodi;
	}

	public void setFechamodi(Date fechamodi) {
		this.fechamodi = fechamodi;
	}

	public String getHechopor() {
		return this.hechopor;
	}

	public void setHechopor(String hechopor) {
		this.hechopor = hechopor;
	}

	public byte[] getLogocomp() {
		return this.logocomp;
	}

	public void setLogocomp(byte[] logocomp) {
		this.logocomp = logocomp;
	}

	public String getMfooter1() {
		return this.mfooter1;
	}

	public void setMfooter1(String mfooter1) {
		this.mfooter1 = mfooter1;
	}

	public String getMfooter2() {
		return this.mfooter2;
	}

	public void setMfooter2(String mfooter2) {
		this.mfooter2 = mfooter2;
	}

	public String getMheader1() {
		return this.mheader1;
	}

	public void setMheader1(String mheader1) {
		this.mheader1 = mheader1;
	}

	public String getMheader2() {
		return this.mheader2;
	}

	public void setMheader2(String mheader2) {
		this.mheader2 = mheader2;
	}

	public String getModificadopor() {
		return this.modificadopor;
	}

	public void setModificadopor(String modificadopor) {
		this.modificadopor = modificadopor;
	}

	public String getNombrefile() {
		return this.nombrefile;
	}

	public void setNombrefile(String nombrefile) {
		this.nombrefile = nombrefile;
	}

}