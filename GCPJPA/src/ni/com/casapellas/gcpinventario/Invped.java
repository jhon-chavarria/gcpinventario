package ni.com.casapellas.gcpinventario;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the INVPEDS database table.
 * 
 */
public class Invped implements Serializable {
	private static final long serialVersionUID = 1L;

	private String bodega;

	private String bodego;

	private BigDecimal calle;

	private BigDecimal cantid;

	private BigDecimal cantie;

	private BigDecimal cantif;

	private BigDecimal cantre;

	private BigDecimal casilla;

	private String ccateg;

	private BigDecimal cexist;

	private BigDecimal cexist1;

	private BigDecimal ciclo;

	private BigDecimal columna;

	private String compan;

	private String compao;

	private String deparo;

	private String depart;

	private BigDecimal docume;

	private String equiv;

	private BigDecimal fecha10;

	private BigDecimal fecha12;

	private BigDecimal fecha13;

	private BigDecimal fecha2;

	private BigDecimal fecha3;

	private BigDecimal fecha4;

	private BigDecimal fecha7;

	private BigDecimal fecha8;

	private BigDecimal fecha9;

	private BigDecimal fecham;

	private String hecho10;

	private String hecho12;

	private String hecho13;

	private String hecho2;

	private String hecho3;

	private String hecho4;

	private String hecho7;

	private String hecho8;

	private String hecho9;

	private String hechop;

	private BigDecimal horam;

	private BigDecimal horam10;

	private BigDecimal horam12;

	private BigDecimal horam13;

	private BigDecimal horam2;

	private BigDecimal horam3;

	private BigDecimal horam4;

	private BigDecimal horam7;

	private BigDecimal horam8;

	private BigDecimal horam9;

	private String motivo;

	private BigDecimal ncanti;

	private BigDecimal nclclie;

	private BigDecimal ncodig;

	private BigDecimal ndocum;

	private BigDecimal nnpedi;

	private String noment;

	private String nparte;

	private String nprog10;

	private String nprog12;

	private String nprog13;

	private String nprog2;

	private String nprog3;

	private String nprog4;

	private String nprog7;

	private String nprog8;

	private String nprog9;

	private String nprogr;

	private String nstat10;

	private String nstat12;

	private String nstat13;

	private String nstat2;

	private String nstat3;

	private String nstat4;

	private String nstat7;

	private String nstat8;

	private String nstat9;

	private String nucaja;

	private String ordenn;

	private String panta10;

	private String panta12;

	private String panta13;

	private String panta2;

	private String panta3;

	private String panta4;

	private String panta7;

	private String panta8;

	private String panta9;

	private String pantal;

	private BigDecimal pedsuc;

	private String peunimed;

	private String rutare;

	private BigDecimal secuen;

	private String sstatu;

	private String status;

	private BigDecimal subci;

	private String sucdes;

	private String sucuro;

	private String sucurs;

	private String tipotr;

	private String ubicac;

	private String urgente;

	private BigDecimal valorr;

	private String zona;

	public Invped() {
	}

	public String getBodega() {
		return this.bodega;
	}

	public void setBodega(String bodega) {
		this.bodega = bodega;
	}

	public String getBodego() {
		return this.bodego;
	}

	public void setBodego(String bodego) {
		this.bodego = bodego;
	}

	public BigDecimal getCalle() {
		return this.calle;
	}

	public void setCalle(BigDecimal calle) {
		this.calle = calle;
	}

	public BigDecimal getCantid() {
		return this.cantid;
	}

	public void setCantid(BigDecimal cantid) {
		this.cantid = cantid;
	}

	public BigDecimal getCantie() {
		return this.cantie;
	}

	public void setCantie(BigDecimal cantie) {
		this.cantie = cantie;
	}

	public BigDecimal getCantif() {
		return this.cantif;
	}

	public void setCantif(BigDecimal cantif) {
		this.cantif = cantif;
	}

	public BigDecimal getCantre() {
		return this.cantre;
	}

	public void setCantre(BigDecimal cantre) {
		this.cantre = cantre;
	}

	public BigDecimal getCasilla() {
		return this.casilla;
	}

	public void setCasilla(BigDecimal casilla) {
		this.casilla = casilla;
	}

	public String getCcateg() {
		return this.ccateg;
	}

	public void setCcateg(String ccateg) {
		this.ccateg = ccateg;
	}

	public BigDecimal getCexist() {
		return this.cexist;
	}

	public void setCexist(BigDecimal cexist) {
		this.cexist = cexist;
	}

	public BigDecimal getCexist1() {
		return this.cexist1;
	}

	public void setCexist1(BigDecimal cexist1) {
		this.cexist1 = cexist1;
	}

	public BigDecimal getCiclo() {
		return this.ciclo;
	}

	public void setCiclo(BigDecimal ciclo) {
		this.ciclo = ciclo;
	}

	public BigDecimal getColumna() {
		return this.columna;
	}

	public void setColumna(BigDecimal columna) {
		this.columna = columna;
	}

	public String getCompan() {
		return this.compan;
	}

	public void setCompan(String compan) {
		this.compan = compan;
	}

	public String getCompao() {
		return this.compao;
	}

	public void setCompao(String compao) {
		this.compao = compao;
	}

	public String getDeparo() {
		return this.deparo;
	}

	public void setDeparo(String deparo) {
		this.deparo = deparo;
	}

	public String getDepart() {
		return this.depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public BigDecimal getDocume() {
		return this.docume;
	}

	public void setDocume(BigDecimal docume) {
		this.docume = docume;
	}

	public String getEquiv() {
		return this.equiv;
	}

	public void setEquiv(String equiv) {
		this.equiv = equiv;
	}

	public BigDecimal getFecha10() {
		return this.fecha10;
	}

	public void setFecha10(BigDecimal fecha10) {
		this.fecha10 = fecha10;
	}

	public BigDecimal getFecha12() {
		return this.fecha12;
	}

	public void setFecha12(BigDecimal fecha12) {
		this.fecha12 = fecha12;
	}

	public BigDecimal getFecha13() {
		return this.fecha13;
	}

	public void setFecha13(BigDecimal fecha13) {
		this.fecha13 = fecha13;
	}

	public BigDecimal getFecha2() {
		return this.fecha2;
	}

	public void setFecha2(BigDecimal fecha2) {
		this.fecha2 = fecha2;
	}

	public BigDecimal getFecha3() {
		return this.fecha3;
	}

	public void setFecha3(BigDecimal fecha3) {
		this.fecha3 = fecha3;
	}

	public BigDecimal getFecha4() {
		return this.fecha4;
	}

	public void setFecha4(BigDecimal fecha4) {
		this.fecha4 = fecha4;
	}

	public BigDecimal getFecha7() {
		return this.fecha7;
	}

	public void setFecha7(BigDecimal fecha7) {
		this.fecha7 = fecha7;
	}

	public BigDecimal getFecha8() {
		return this.fecha8;
	}

	public void setFecha8(BigDecimal fecha8) {
		this.fecha8 = fecha8;
	}

	public BigDecimal getFecha9() {
		return this.fecha9;
	}

	public void setFecha9(BigDecimal fecha9) {
		this.fecha9 = fecha9;
	}

	public BigDecimal getFecham() {
		return this.fecham;
	}

	public void setFecham(BigDecimal fecham) {
		this.fecham = fecham;
	}

	public String getHecho10() {
		return this.hecho10;
	}

	public void setHecho10(String hecho10) {
		this.hecho10 = hecho10;
	}

	public String getHecho12() {
		return this.hecho12;
	}

	public void setHecho12(String hecho12) {
		this.hecho12 = hecho12;
	}

	public String getHecho13() {
		return this.hecho13;
	}

	public void setHecho13(String hecho13) {
		this.hecho13 = hecho13;
	}

	public String getHecho2() {
		return this.hecho2;
	}

	public void setHecho2(String hecho2) {
		this.hecho2 = hecho2;
	}

	public String getHecho3() {
		return this.hecho3;
	}

	public void setHecho3(String hecho3) {
		this.hecho3 = hecho3;
	}

	public String getHecho4() {
		return this.hecho4;
	}

	public void setHecho4(String hecho4) {
		this.hecho4 = hecho4;
	}

	public String getHecho7() {
		return this.hecho7;
	}

	public void setHecho7(String hecho7) {
		this.hecho7 = hecho7;
	}

	public String getHecho8() {
		return this.hecho8;
	}

	public void setHecho8(String hecho8) {
		this.hecho8 = hecho8;
	}

	public String getHecho9() {
		return this.hecho9;
	}

	public void setHecho9(String hecho9) {
		this.hecho9 = hecho9;
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

	public BigDecimal getHoram10() {
		return this.horam10;
	}

	public void setHoram10(BigDecimal horam10) {
		this.horam10 = horam10;
	}

	public BigDecimal getHoram12() {
		return this.horam12;
	}

	public void setHoram12(BigDecimal horam12) {
		this.horam12 = horam12;
	}

	public BigDecimal getHoram13() {
		return this.horam13;
	}

	public void setHoram13(BigDecimal horam13) {
		this.horam13 = horam13;
	}

	public BigDecimal getHoram2() {
		return this.horam2;
	}

	public void setHoram2(BigDecimal horam2) {
		this.horam2 = horam2;
	}

	public BigDecimal getHoram3() {
		return this.horam3;
	}

	public void setHoram3(BigDecimal horam3) {
		this.horam3 = horam3;
	}

	public BigDecimal getHoram4() {
		return this.horam4;
	}

	public void setHoram4(BigDecimal horam4) {
		this.horam4 = horam4;
	}

	public BigDecimal getHoram7() {
		return this.horam7;
	}

	public void setHoram7(BigDecimal horam7) {
		this.horam7 = horam7;
	}

	public BigDecimal getHoram8() {
		return this.horam8;
	}

	public void setHoram8(BigDecimal horam8) {
		this.horam8 = horam8;
	}

	public BigDecimal getHoram9() {
		return this.horam9;
	}

	public void setHoram9(BigDecimal horam9) {
		this.horam9 = horam9;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public BigDecimal getNcanti() {
		return this.ncanti;
	}

	public void setNcanti(BigDecimal ncanti) {
		this.ncanti = ncanti;
	}

	public BigDecimal getNclclie() {
		return this.nclclie;
	}

	public void setNclclie(BigDecimal nclclie) {
		this.nclclie = nclclie;
	}

	public BigDecimal getNcodig() {
		return this.ncodig;
	}

	public void setNcodig(BigDecimal ncodig) {
		this.ncodig = ncodig;
	}

	public BigDecimal getNdocum() {
		return this.ndocum;
	}

	public void setNdocum(BigDecimal ndocum) {
		this.ndocum = ndocum;
	}

	public BigDecimal getNnpedi() {
		return this.nnpedi;
	}

	public void setNnpedi(BigDecimal nnpedi) {
		this.nnpedi = nnpedi;
	}

	public String getNoment() {
		return this.noment;
	}

	public void setNoment(String noment) {
		this.noment = noment;
	}

	public String getNparte() {
		return this.nparte;
	}

	public void setNparte(String nparte) {
		this.nparte = nparte;
	}

	public String getNprog10() {
		return this.nprog10;
	}

	public void setNprog10(String nprog10) {
		this.nprog10 = nprog10;
	}

	public String getNprog12() {
		return this.nprog12;
	}

	public void setNprog12(String nprog12) {
		this.nprog12 = nprog12;
	}

	public String getNprog13() {
		return this.nprog13;
	}

	public void setNprog13(String nprog13) {
		this.nprog13 = nprog13;
	}

	public String getNprog2() {
		return this.nprog2;
	}

	public void setNprog2(String nprog2) {
		this.nprog2 = nprog2;
	}

	public String getNprog3() {
		return this.nprog3;
	}

	public void setNprog3(String nprog3) {
		this.nprog3 = nprog3;
	}

	public String getNprog4() {
		return this.nprog4;
	}

	public void setNprog4(String nprog4) {
		this.nprog4 = nprog4;
	}

	public String getNprog7() {
		return this.nprog7;
	}

	public void setNprog7(String nprog7) {
		this.nprog7 = nprog7;
	}

	public String getNprog8() {
		return this.nprog8;
	}

	public void setNprog8(String nprog8) {
		this.nprog8 = nprog8;
	}

	public String getNprog9() {
		return this.nprog9;
	}

	public void setNprog9(String nprog9) {
		this.nprog9 = nprog9;
	}

	public String getNprogr() {
		return this.nprogr;
	}

	public void setNprogr(String nprogr) {
		this.nprogr = nprogr;
	}

	public String getNstat10() {
		return this.nstat10;
	}

	public void setNstat10(String nstat10) {
		this.nstat10 = nstat10;
	}

	public String getNstat12() {
		return this.nstat12;
	}

	public void setNstat12(String nstat12) {
		this.nstat12 = nstat12;
	}

	public String getNstat13() {
		return this.nstat13;
	}

	public void setNstat13(String nstat13) {
		this.nstat13 = nstat13;
	}

	public String getNstat2() {
		return this.nstat2;
	}

	public void setNstat2(String nstat2) {
		this.nstat2 = nstat2;
	}

	public String getNstat3() {
		return this.nstat3;
	}

	public void setNstat3(String nstat3) {
		this.nstat3 = nstat3;
	}

	public String getNstat4() {
		return this.nstat4;
	}

	public void setNstat4(String nstat4) {
		this.nstat4 = nstat4;
	}

	public String getNstat7() {
		return this.nstat7;
	}

	public void setNstat7(String nstat7) {
		this.nstat7 = nstat7;
	}

	public String getNstat8() {
		return this.nstat8;
	}

	public void setNstat8(String nstat8) {
		this.nstat8 = nstat8;
	}

	public String getNstat9() {
		return this.nstat9;
	}

	public void setNstat9(String nstat9) {
		this.nstat9 = nstat9;
	}

	public String getNucaja() {
		return this.nucaja;
	}

	public void setNucaja(String nucaja) {
		this.nucaja = nucaja;
	}

	public String getOrdenn() {
		return this.ordenn;
	}

	public void setOrdenn(String ordenn) {
		this.ordenn = ordenn;
	}

	public String getPanta10() {
		return this.panta10;
	}

	public void setPanta10(String panta10) {
		this.panta10 = panta10;
	}

	public String getPanta12() {
		return this.panta12;
	}

	public void setPanta12(String panta12) {
		this.panta12 = panta12;
	}

	public String getPanta13() {
		return this.panta13;
	}

	public void setPanta13(String panta13) {
		this.panta13 = panta13;
	}

	public String getPanta2() {
		return this.panta2;
	}

	public void setPanta2(String panta2) {
		this.panta2 = panta2;
	}

	public String getPanta3() {
		return this.panta3;
	}

	public void setPanta3(String panta3) {
		this.panta3 = panta3;
	}

	public String getPanta4() {
		return this.panta4;
	}

	public void setPanta4(String panta4) {
		this.panta4 = panta4;
	}

	public String getPanta7() {
		return this.panta7;
	}

	public void setPanta7(String panta7) {
		this.panta7 = panta7;
	}

	public String getPanta8() {
		return this.panta8;
	}

	public void setPanta8(String panta8) {
		this.panta8 = panta8;
	}

	public String getPanta9() {
		return this.panta9;
	}

	public void setPanta9(String panta9) {
		this.panta9 = panta9;
	}

	public String getPantal() {
		return this.pantal;
	}

	public void setPantal(String pantal) {
		this.pantal = pantal;
	}

	public BigDecimal getPedsuc() {
		return this.pedsuc;
	}

	public void setPedsuc(BigDecimal pedsuc) {
		this.pedsuc = pedsuc;
	}

	public String getPeunimed() {
		return this.peunimed;
	}

	public void setPeunimed(String peunimed) {
		this.peunimed = peunimed;
	}

	public String getRutare() {
		return this.rutare;
	}

	public void setRutare(String rutare) {
		this.rutare = rutare;
	}

	public BigDecimal getSecuen() {
		return this.secuen;
	}

	public void setSecuen(BigDecimal secuen) {
		this.secuen = secuen;
	}

	public String getSstatu() {
		return this.sstatu;
	}

	public void setSstatu(String sstatu) {
		this.sstatu = sstatu;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getSubci() {
		return this.subci;
	}

	public void setSubci(BigDecimal subci) {
		this.subci = subci;
	}

	public String getSucdes() {
		return this.sucdes;
	}

	public void setSucdes(String sucdes) {
		this.sucdes = sucdes;
	}

	public String getSucuro() {
		return this.sucuro;
	}

	public void setSucuro(String sucuro) {
		this.sucuro = sucuro;
	}

	public String getSucurs() {
		return this.sucurs;
	}

	public void setSucurs(String sucurs) {
		this.sucurs = sucurs;
	}

	public String getTipotr() {
		return this.tipotr;
	}

	public void setTipotr(String tipotr) {
		this.tipotr = tipotr;
	}

	public String getUbicac() {
		return this.ubicac;
	}

	public void setUbicac(String ubicac) {
		this.ubicac = ubicac;
	}

	public String getUrgente() {
		return this.urgente;
	}

	public void setUrgente(String urgente) {
		this.urgente = urgente;
	}

	public BigDecimal getValorr() {
		return this.valorr;
	}

	public void setValorr(BigDecimal valorr) {
		this.valorr = valorr;
	}

	public String getZona() {
		return this.zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

}