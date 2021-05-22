package ni.com.casapellas.gcpinventario;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the INVD38 database table.
 * 
 */
public class Invd38 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String bodega;

	private String caja1;

	private BigDecimal canrcpd1;

	private BigDecimal canrcpd4;

	private BigDecimal canrcpd8;

	private BigDecimal canres;

	private BigDecimal canrlo;

	private BigDecimal canrmv;

	private BigDecimal canrped;

	//@Column(name="\"CLIENT\"")
	private BigDecimal client;

	private String clnomb;

	private String compan;

	private String depart;

	private String descri;

	private BigDecimal docume;

	private BigDecimal fecham;

	private BigDecimal fechat;

	private String hechop;

	private BigDecimal horam;

	@Temporal(TemporalType.DATE)
	private Date invfecven;

	private String invhechop;

	private BigDecimal invhoram;

	private String invnprogr;

	private String invpantal;

	private String motivo;

	private BigDecimal mvalor;

	private String natura;

	private BigDecimal nfactu;

	private BigDecimal nliqui;

	private BigDecimal nopedi;

	private BigDecimal norden;

	private String nparte;

	private BigDecimal npresu;

	private BigDecimal nprofo;

	private String nprogr;

	private String pantal;

	private BigDecimal rcantidc;

	private String rhechop;

	private String rhechopc;

	private String rhechopd;

	private String rhechopf;

	private BigDecimal rhoram;

	private BigDecimal rhoramc;

	private BigDecimal rhoramd;

	private BigDecimal rhoramf;

	private String rnprogr;

	private String rnprogrc;

	private String rnprogrd;

	private String rnprogrf;

	private String rpantal;

	private String rpantalc;

	private String rpantald;

	private String rpantalf;

	private BigDecimal rscantidf;

	private BigDecimal rscantidr;

	private String rslote;

	private String rsunimed;

	private String stades;

	private String stconfi;

	private String stdesp;

	private String stsres;

	private String sucurs;

	private String vended;

	public Invd38() {
	}

	public String getBodega() {
		return this.bodega;
	}

	public void setBodega(String bodega) {
		this.bodega = bodega;
	}

	public String getCaja1() {
		return this.caja1;
	}

	public void setCaja1(String caja1) {
		this.caja1 = caja1;
	}

	public BigDecimal getCanrcpd1() {
		return this.canrcpd1;
	}

	public void setCanrcpd1(BigDecimal canrcpd1) {
		this.canrcpd1 = canrcpd1;
	}

	public BigDecimal getCanrcpd4() {
		return this.canrcpd4;
	}

	public void setCanrcpd4(BigDecimal canrcpd4) {
		this.canrcpd4 = canrcpd4;
	}

	public BigDecimal getCanrcpd8() {
		return this.canrcpd8;
	}

	public void setCanrcpd8(BigDecimal canrcpd8) {
		this.canrcpd8 = canrcpd8;
	}

	public BigDecimal getCanres() {
		return this.canres;
	}

	public void setCanres(BigDecimal canres) {
		this.canres = canres;
	}

	public BigDecimal getCanrlo() {
		return this.canrlo;
	}

	public void setCanrlo(BigDecimal canrlo) {
		this.canrlo = canrlo;
	}

	public BigDecimal getCanrmv() {
		return this.canrmv;
	}

	public void setCanrmv(BigDecimal canrmv) {
		this.canrmv = canrmv;
	}

	public BigDecimal getCanrped() {
		return this.canrped;
	}

	public void setCanrped(BigDecimal canrped) {
		this.canrped = canrped;
	}

	public BigDecimal getClient() {
		return this.client;
	}

	public void setClient(BigDecimal client) {
		this.client = client;
	}

	public String getClnomb() {
		return this.clnomb;
	}

	public void setClnomb(String clnomb) {
		this.clnomb = clnomb;
	}

	public String getCompan() {
		return this.compan;
	}

	public void setCompan(String compan) {
		this.compan = compan;
	}

	public String getDepart() {
		return this.depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getDescri() {
		return this.descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	public BigDecimal getDocume() {
		return this.docume;
	}

	public void setDocume(BigDecimal docume) {
		this.docume = docume;
	}

	public BigDecimal getFecham() {
		return this.fecham;
	}

	public void setFecham(BigDecimal fecham) {
		this.fecham = fecham;
	}

	public BigDecimal getFechat() {
		return this.fechat;
	}

	public void setFechat(BigDecimal fechat) {
		this.fechat = fechat;
	}

	public String getHechop() {
		return this.hechop;
	}

	public void setHechop(String hechop) {
		this.hechop = hechop;
	}

	public BigDecimal getHoram() {
		return this.horam;
	}

	public void setHoram(BigDecimal horam) {
		this.horam = horam;
	}

	public Date getInvfecven() {
		return this.invfecven;
	}

	public void setInvfecven(Date invfecven) {
		this.invfecven = invfecven;
	}

	public String getInvhechop() {
		return this.invhechop;
	}

	public void setInvhechop(String invhechop) {
		this.invhechop = invhechop;
	}

	public BigDecimal getInvhoram() {
		return this.invhoram;
	}

	public void setInvhoram(BigDecimal invhoram) {
		this.invhoram = invhoram;
	}

	public String getInvnprogr() {
		return this.invnprogr;
	}

	public void setInvnprogr(String invnprogr) {
		this.invnprogr = invnprogr;
	}

	public String getInvpantal() {
		return this.invpantal;
	}

	public void setInvpantal(String invpantal) {
		this.invpantal = invpantal;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public BigDecimal getMvalor() {
		return this.mvalor;
	}

	public void setMvalor(BigDecimal mvalor) {
		this.mvalor = mvalor;
	}

	public String getNatura() {
		return this.natura;
	}

	public void setNatura(String natura) {
		this.natura = natura;
	}

	public BigDecimal getNfactu() {
		return this.nfactu;
	}

	public void setNfactu(BigDecimal nfactu) {
		this.nfactu = nfactu;
	}

	public BigDecimal getNliqui() {
		return this.nliqui;
	}

	public void setNliqui(BigDecimal nliqui) {
		this.nliqui = nliqui;
	}

	public BigDecimal getNopedi() {
		return this.nopedi;
	}

	public void setNopedi(BigDecimal nopedi) {
		this.nopedi = nopedi;
	}

	public BigDecimal getNorden() {
		return this.norden;
	}

	public void setNorden(BigDecimal norden) {
		this.norden = norden;
	}

	public String getNparte() {
		return this.nparte;
	}

	public void setNparte(String nparte) {
		this.nparte = nparte;
	}

	public BigDecimal getNpresu() {
		return this.npresu;
	}

	public void setNpresu(BigDecimal npresu) {
		this.npresu = npresu;
	}

	public BigDecimal getNprofo() {
		return this.nprofo;
	}

	public void setNprofo(BigDecimal nprofo) {
		this.nprofo = nprofo;
	}

	public String getNprogr() {
		return this.nprogr;
	}

	public void setNprogr(String nprogr) {
		this.nprogr = nprogr;
	}

	public String getPantal() {
		return this.pantal;
	}

	public void setPantal(String pantal) {
		this.pantal = pantal;
	}

	public BigDecimal getRcantidc() {
		return this.rcantidc;
	}

	public void setRcantidc(BigDecimal rcantidc) {
		this.rcantidc = rcantidc;
	}

	public String getRhechop() {
		return this.rhechop;
	}

	public void setRhechop(String rhechop) {
		this.rhechop = rhechop;
	}

	public String getRhechopc() {
		return this.rhechopc;
	}

	public void setRhechopc(String rhechopc) {
		this.rhechopc = rhechopc;
	}

	public String getRhechopd() {
		return this.rhechopd;
	}

	public void setRhechopd(String rhechopd) {
		this.rhechopd = rhechopd;
	}

	public String getRhechopf() {
		return this.rhechopf;
	}

	public void setRhechopf(String rhechopf) {
		this.rhechopf = rhechopf;
	}

	public BigDecimal getRhoram() {
		return this.rhoram;
	}

	public void setRhoram(BigDecimal rhoram) {
		this.rhoram = rhoram;
	}

	public BigDecimal getRhoramc() {
		return this.rhoramc;
	}

	public void setRhoramc(BigDecimal rhoramc) {
		this.rhoramc = rhoramc;
	}

	public BigDecimal getRhoramd() {
		return this.rhoramd;
	}

	public void setRhoramd(BigDecimal rhoramd) {
		this.rhoramd = rhoramd;
	}

	public BigDecimal getRhoramf() {
		return this.rhoramf;
	}

	public void setRhoramf(BigDecimal rhoramf) {
		this.rhoramf = rhoramf;
	}

	public String getRnprogr() {
		return this.rnprogr;
	}

	public void setRnprogr(String rnprogr) {
		this.rnprogr = rnprogr;
	}

	public String getRnprogrc() {
		return this.rnprogrc;
	}

	public void setRnprogrc(String rnprogrc) {
		this.rnprogrc = rnprogrc;
	}

	public String getRnprogrd() {
		return this.rnprogrd;
	}

	public void setRnprogrd(String rnprogrd) {
		this.rnprogrd = rnprogrd;
	}

	public String getRnprogrf() {
		return this.rnprogrf;
	}

	public void setRnprogrf(String rnprogrf) {
		this.rnprogrf = rnprogrf;
	}

	public String getRpantal() {
		return this.rpantal;
	}

	public void setRpantal(String rpantal) {
		this.rpantal = rpantal;
	}

	public String getRpantalc() {
		return this.rpantalc;
	}

	public void setRpantalc(String rpantalc) {
		this.rpantalc = rpantalc;
	}

	public String getRpantald() {
		return this.rpantald;
	}

	public void setRpantald(String rpantald) {
		this.rpantald = rpantald;
	}

	public String getRpantalf() {
		return this.rpantalf;
	}

	public void setRpantalf(String rpantalf) {
		this.rpantalf = rpantalf;
	}

	public BigDecimal getRscantidf() {
		return this.rscantidf;
	}

	public void setRscantidf(BigDecimal rscantidf) {
		this.rscantidf = rscantidf;
	}

	public BigDecimal getRscantidr() {
		return this.rscantidr;
	}

	public void setRscantidr(BigDecimal rscantidr) {
		this.rscantidr = rscantidr;
	}

	public String getRslote() {
		return this.rslote;
	}

	public void setRslote(String rslote) {
		this.rslote = rslote;
	}

	public String getRsunimed() {
		return this.rsunimed;
	}

	public void setRsunimed(String rsunimed) {
		this.rsunimed = rsunimed;
	}

	public String getStades() {
		return this.stades;
	}

	public void setStades(String stades) {
		this.stades = stades;
	}

	public String getStconfi() {
		return this.stconfi;
	}

	public void setStconfi(String stconfi) {
		this.stconfi = stconfi;
	}

	public String getStdesp() {
		return this.stdesp;
	}

	public void setStdesp(String stdesp) {
		this.stdesp = stdesp;
	}

	public String getStsres() {
		return this.stsres;
	}

	public void setStsres(String stsres) {
		this.stsres = stsres;
	}

	public String getSucurs() {
		return this.sucurs;
	}

	public void setSucurs(String sucurs) {
		this.sucurs = sucurs;
	}

	public String getVended() {
		return this.vended;
	}

	public void setVended(String vended) {
		this.vended = vended;
	}

}