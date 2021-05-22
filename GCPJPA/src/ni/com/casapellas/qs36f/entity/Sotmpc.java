package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Time;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SOTMPC database table.
 * 
 */
@Entity
@Table(name = "SOTMPC")
@XmlRootElement
public class Sotmpc implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SotmpcPK id;

	private String chasis;

	private BigDecimal cliente;

    @Temporal( TemporalType.DATE)
	private Date fecctto;

    @Temporal( TemporalType.DATE)
	private Date fecfin;

    @Temporal( TemporalType.DATE)
	private Date fecham;

    @Temporal( TemporalType.DATE)
	private Date fecini;

    @Temporal( TemporalType.DATE)
	private Date fecrecibo;

    @Temporal( TemporalType.DATE)
	private Date fecstat;

    @Temporal( TemporalType.DATE)
	private Date fecven;

	private String hechoc;

	private String hechom;

	private Time horam;

	private Time horctto;

	private BigDecimal kmfin;

	private BigDecimal kmini;

	private String motor;

	private String mppmcu;

	private String mppobj;

	private String mppsbl;

	private String mppsblt;

	private String mppsub;

	private String nprogrc;

	private String nprogrm;

	private BigDecimal numcttodes;

	private BigDecimal numprop;

	private BigDecimal numrecibo;

	private BigDecimal numrev;

	private String numtarj;

	private String obsctto;

	private String pantalc;

	private String pantalm;

	private BigDecimal poriva;

	private String status;

	private BigDecimal tecnico;

	private BigDecimal tipcam;

	private String tipofact;

	private BigDecimal tvalctto;

	private BigDecimal tvalrcto;

	private String vendidox;

    public Sotmpc() {
    }

	public SotmpcPK getId() {
		return this.id;
	}

	public void setId(SotmpcPK id) {
		this.id = id;
	}
	
	public String getChasis() {
		return this.chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public BigDecimal getCliente() {
		return this.cliente;
	}

	public void setCliente(BigDecimal cliente) {
		this.cliente = cliente;
	}

	public Date getFecctto() {
		return this.fecctto;
	}

	public void setFecctto(Date fecctto) {
		this.fecctto = fecctto;
	}

	public Date getFecfin() {
		return this.fecfin;
	}

	public void setFecfin(Date fecfin) {
		this.fecfin = fecfin;
	}

	public Date getFecham() {
		return this.fecham;
	}

	public void setFecham(Date fecham) {
		this.fecham = fecham;
	}

	public Date getFecini() {
		return this.fecini;
	}

	public void setFecini(Date fecini) {
		this.fecini = fecini;
	}

	public Date getFecrecibo() {
		return this.fecrecibo;
	}

	public void setFecrecibo(Date fecrecibo) {
		this.fecrecibo = fecrecibo;
	}

	public Date getFecstat() {
		return this.fecstat;
	}

	public void setFecstat(Date fecstat) {
		this.fecstat = fecstat;
	}

	public Date getFecven() {
		return this.fecven;
	}

	public void setFecven(Date fecven) {
		this.fecven = fecven;
	}

	public String getHechoc() {
		return this.hechoc;
	}

	public void setHechoc(String hechoc) {
		this.hechoc = hechoc;
	}

	public String getHechom() {
		return this.hechom;
	}

	public void setHechom(String hechom) {
		this.hechom = hechom;
	}

	public Time getHoram() {
		return this.horam;
	}

	public void setHoram(Time horam) {
		this.horam = horam;
	}

	public Time getHorctto() {
		return this.horctto;
	}

	public void setHorctto(Time horctto) {
		this.horctto = horctto;
	}

	public BigDecimal getKmfin() {
		return this.kmfin;
	}

	public void setKmfin(BigDecimal kmfin) {
		this.kmfin = kmfin;
	}

	public BigDecimal getKmini() {
		return this.kmini;
	}

	public void setKmini(BigDecimal kmini) {
		this.kmini = kmini;
	}

	public String getMotor() {
		return this.motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getMppmcu() {
		return this.mppmcu;
	}

	public void setMppmcu(String mppmcu) {
		this.mppmcu = mppmcu;
	}

	public String getMppobj() {
		return this.mppobj;
	}

	public void setMppobj(String mppobj) {
		this.mppobj = mppobj;
	}

	public String getMppsbl() {
		return this.mppsbl;
	}

	public void setMppsbl(String mppsbl) {
		this.mppsbl = mppsbl;
	}

	public String getMppsblt() {
		return this.mppsblt;
	}

	public void setMppsblt(String mppsblt) {
		this.mppsblt = mppsblt;
	}

	public String getMppsub() {
		return this.mppsub;
	}

	public void setMppsub(String mppsub) {
		this.mppsub = mppsub;
	}

	public String getNprogrc() {
		return this.nprogrc;
	}

	public void setNprogrc(String nprogrc) {
		this.nprogrc = nprogrc;
	}

	public String getNprogrm() {
		return this.nprogrm;
	}

	public void setNprogrm(String nprogrm) {
		this.nprogrm = nprogrm;
	}

	public BigDecimal getNumcttodes() {
		return this.numcttodes;
	}

	public void setNumcttodes(BigDecimal numcttodes) {
		this.numcttodes = numcttodes;
	}

	public BigDecimal getNumprop() {
		return this.numprop;
	}

	public void setNumprop(BigDecimal numprop) {
		this.numprop = numprop;
	}

	public BigDecimal getNumrecibo() {
		return this.numrecibo;
	}

	public void setNumrecibo(BigDecimal numrecibo) {
		this.numrecibo = numrecibo;
	}

	public BigDecimal getNumrev() {
		return this.numrev;
	}

	public void setNumrev(BigDecimal numrev) {
		this.numrev = numrev;
	}

	public String getNumtarj() {
		return this.numtarj;
	}

	public void setNumtarj(String numtarj) {
		this.numtarj = numtarj;
	}

	public String getObsctto() {
		return this.obsctto;
	}

	public void setObsctto(String obsctto) {
		this.obsctto = obsctto;
	}

	public String getPantalc() {
		return this.pantalc;
	}

	public void setPantalc(String pantalc) {
		this.pantalc = pantalc;
	}

	public String getPantalm() {
		return this.pantalm;
	}

	public void setPantalm(String pantalm) {
		this.pantalm = pantalm;
	}

	public BigDecimal getPoriva() {
		return this.poriva;
	}

	public void setPoriva(BigDecimal poriva) {
		this.poriva = poriva;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTecnico() {
		return this.tecnico;
	}

	public void setTecnico(BigDecimal tecnico) {
		this.tecnico = tecnico;
	}

	public BigDecimal getTipcam() {
		return this.tipcam;
	}

	public void setTipcam(BigDecimal tipcam) {
		this.tipcam = tipcam;
	}

	public String getTipofact() {
		return this.tipofact;
	}

	public void setTipofact(String tipofact) {
		this.tipofact = tipofact;
	}

	public BigDecimal getTvalctto() {
		return this.tvalctto;
	}

	public void setTvalctto(BigDecimal tvalctto) {
		this.tvalctto = tvalctto;
	}

	public BigDecimal getTvalrcto() {
		return this.tvalrcto;
	}

	public void setTvalrcto(BigDecimal tvalrcto) {
		this.tvalrcto = tvalrcto;
	}

	public String getVendidox() {
		return this.vendidox;
	}

	public void setVendidox(String vendidox) {
		this.vendidox = vendidox;
	}

}