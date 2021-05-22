package ni.com.casapellas.gcpinventario;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the INVD34 database table.
 * 
 */
public class Invd34 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String aproba2;

	private String bodega;

	private BigDecimal canexi;

	private BigDecimal canped;

	private BigDecimal canrec;

	private BigDecimal cantra;

	private BigDecimal capedi;

	private String catego;

	private String chasis;

	//@Column(name="\"CLIENT\"")
	private BigDecimal client;

	private String clnomb;

	private String comentad;

	private String comentco;

	private String compan;

	private String depart;

	private String descri;

	private BigDecimal direcc;

	private BigDecimal fechaad;

	private BigDecimal fechaap;

	private BigDecimal fechaco;

	private BigDecimal fechafa;

	private BigDecimal fecham;

	private BigDecimal fecliq;

	private BigDecimal fecped;

	private BigDecimal fecrec;

	private String formpa;

	private String hechoad;

	private String hechoco;

	private String hechofa;

	private String hechop;

	private String hechpe;

	private String hechre;

	private BigDecimal horaad;

	private BigDecimal horaco;

	private BigDecimal horafa;

	private BigDecimal horam;

	private BigDecimal horam2;

	private BigDecimal horape;

	private BigDecimal horrec;

	private String modelo;

	private String modent;

	private String motivo;

	private String ncaja;

	private BigDecimal nfactu;

	private BigDecimal nliqui;

	private BigDecimal nofact;

	private BigDecimal noprof;

	private BigDecimal norden;

	private String nparte;

	private String npartepas1;

	private String nprogr;

	private String nprogr2;

	private String nprograd;

	private String nprogrco;

	private String nprogrfa;

	private String nprope;

	private String nprore;

	private String pantal;

	private String pantal2;

	private BigDecimal pedido;

	private BigDecimal pedjap;

	private String pproce;

	private String pproce2;

	private String pproce3;

	private BigDecimal precioad;

	private BigDecimal precioad2;

	private BigDecimal precioad3;

	private BigDecimal precitad1;

	private BigDecimal precitad2;

	private BigDecimal precitad3;

	private String prmoneda;

	private BigDecimal qprfob;

	private String statu1;

	private String statu2;

	private String statu3;

	private String statu4;

	private String status;

	private String status2;

	private String sucurs;

	private String titran;

	private String vended;

	public Invd34() {
	}

	public String getAproba2() {
		return this.aproba2;
	}

	public void setAproba2(String aproba2) {
		this.aproba2 = aproba2;
	}

	public String getBodega() {
		return this.bodega;
	}

	public void setBodega(String bodega) {
		this.bodega = bodega;
	}

	public BigDecimal getCanexi() {
		return this.canexi;
	}

	public void setCanexi(BigDecimal canexi) {
		this.canexi = canexi;
	}

	public BigDecimal getCanped() {
		return this.canped;
	}

	public void setCanped(BigDecimal canped) {
		this.canped = canped;
	}

	public BigDecimal getCanrec() {
		return this.canrec;
	}

	public void setCanrec(BigDecimal canrec) {
		this.canrec = canrec;
	}

	public BigDecimal getCantra() {
		return this.cantra;
	}

	public void setCantra(BigDecimal cantra) {
		this.cantra = cantra;
	}

	public BigDecimal getCapedi() {
		return this.capedi;
	}

	public void setCapedi(BigDecimal capedi) {
		this.capedi = capedi;
	}

	public String getCatego() {
		return this.catego;
	}

	public void setCatego(String catego) {
		this.catego = catego;
	}

	public String getChasis() {
		return this.chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
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

	public String getComentad() {
		return this.comentad;
	}

	public void setComentad(String comentad) {
		this.comentad = comentad;
	}

	public String getComentco() {
		return this.comentco;
	}

	public void setComentco(String comentco) {
		this.comentco = comentco;
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

	public BigDecimal getDirecc() {
		return this.direcc;
	}

	public void setDirecc(BigDecimal direcc) {
		this.direcc = direcc;
	}

	public BigDecimal getFechaad() {
		return this.fechaad;
	}

	public void setFechaad(BigDecimal fechaad) {
		this.fechaad = fechaad;
	}

	public BigDecimal getFechaap() {
		return this.fechaap;
	}

	public void setFechaap(BigDecimal fechaap) {
		this.fechaap = fechaap;
	}

	public BigDecimal getFechaco() {
		return this.fechaco;
	}

	public void setFechaco(BigDecimal fechaco) {
		this.fechaco = fechaco;
	}

	public BigDecimal getFechafa() {
		return this.fechafa;
	}

	public void setFechafa(BigDecimal fechafa) {
		this.fechafa = fechafa;
	}

	public BigDecimal getFecham() {
		return this.fecham;
	}

	public void setFecham(BigDecimal fecham) {
		this.fecham = fecham;
	}

	public BigDecimal getFecliq() {
		return this.fecliq;
	}

	public void setFecliq(BigDecimal fecliq) {
		this.fecliq = fecliq;
	}

	public BigDecimal getFecped() {
		return this.fecped;
	}

	public void setFecped(BigDecimal fecped) {
		this.fecped = fecped;
	}

	public BigDecimal getFecrec() {
		return this.fecrec;
	}

	public void setFecrec(BigDecimal fecrec) {
		this.fecrec = fecrec;
	}

	public String getFormpa() {
		return this.formpa;
	}

	public void setFormpa(String formpa) {
		this.formpa = formpa;
	}

	public String getHechoad() {
		return this.hechoad;
	}

	public void setHechoad(String hechoad) {
		this.hechoad = hechoad;
	}

	public String getHechoco() {
		return this.hechoco;
	}

	public void setHechoco(String hechoco) {
		this.hechoco = hechoco;
	}

	public String getHechofa() {
		return this.hechofa;
	}

	public void setHechofa(String hechofa) {
		this.hechofa = hechofa;
	}

	public String getHechop() {
		return this.hechop;
	}

	public void setHechop(String hechop) {
		this.hechop = hechop;
	}

	public String getHechpe() {
		return this.hechpe;
	}

	public void setHechpe(String hechpe) {
		this.hechpe = hechpe;
	}

	public String getHechre() {
		return this.hechre;
	}

	public void setHechre(String hechre) {
		this.hechre = hechre;
	}

	public BigDecimal getHoraad() {
		return this.horaad;
	}

	public void setHoraad(BigDecimal horaad) {
		this.horaad = horaad;
	}

	public BigDecimal getHoraco() {
		return this.horaco;
	}

	public void setHoraco(BigDecimal horaco) {
		this.horaco = horaco;
	}

	public BigDecimal getHorafa() {
		return this.horafa;
	}

	public void setHorafa(BigDecimal horafa) {
		this.horafa = horafa;
	}

	public BigDecimal getHoram() {
		return this.horam;
	}

	public void setHoram(BigDecimal horam) {
		this.horam = horam;
	}

	public BigDecimal getHoram2() {
		return this.horam2;
	}

	public void setHoram2(BigDecimal horam2) {
		this.horam2 = horam2;
	}

	public BigDecimal getHorape() {
		return this.horape;
	}

	public void setHorape(BigDecimal horape) {
		this.horape = horape;
	}

	public BigDecimal getHorrec() {
		return this.horrec;
	}

	public void setHorrec(BigDecimal horrec) {
		this.horrec = horrec;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getModent() {
		return this.modent;
	}

	public void setModent(String modent) {
		this.modent = modent;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getNcaja() {
		return this.ncaja;
	}

	public void setNcaja(String ncaja) {
		this.ncaja = ncaja;
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

	public BigDecimal getNofact() {
		return this.nofact;
	}

	public void setNofact(BigDecimal nofact) {
		this.nofact = nofact;
	}

	public BigDecimal getNoprof() {
		return this.noprof;
	}

	public void setNoprof(BigDecimal noprof) {
		this.noprof = noprof;
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

	public String getNpartepas1() {
		return this.npartepas1;
	}

	public void setNpartepas1(String npartepas1) {
		this.npartepas1 = npartepas1;
	}

	public String getNprogr() {
		return this.nprogr;
	}

	public void setNprogr(String nprogr) {
		this.nprogr = nprogr;
	}

	public String getNprogr2() {
		return this.nprogr2;
	}

	public void setNprogr2(String nprogr2) {
		this.nprogr2 = nprogr2;
	}

	public String getNprograd() {
		return this.nprograd;
	}

	public void setNprograd(String nprograd) {
		this.nprograd = nprograd;
	}

	public String getNprogrco() {
		return this.nprogrco;
	}

	public void setNprogrco(String nprogrco) {
		this.nprogrco = nprogrco;
	}

	public String getNprogrfa() {
		return this.nprogrfa;
	}

	public void setNprogrfa(String nprogrfa) {
		this.nprogrfa = nprogrfa;
	}

	public String getNprope() {
		return this.nprope;
	}

	public void setNprope(String nprope) {
		this.nprope = nprope;
	}

	public String getNprore() {
		return this.nprore;
	}

	public void setNprore(String nprore) {
		this.nprore = nprore;
	}

	public String getPantal() {
		return this.pantal;
	}

	public void setPantal(String pantal) {
		this.pantal = pantal;
	}

	public String getPantal2() {
		return this.pantal2;
	}

	public void setPantal2(String pantal2) {
		this.pantal2 = pantal2;
	}

	public BigDecimal getPedido() {
		return this.pedido;
	}

	public void setPedido(BigDecimal pedido) {
		this.pedido = pedido;
	}

	public BigDecimal getPedjap() {
		return this.pedjap;
	}

	public void setPedjap(BigDecimal pedjap) {
		this.pedjap = pedjap;
	}

	public String getPproce() {
		return this.pproce;
	}

	public void setPproce(String pproce) {
		this.pproce = pproce;
	}

	public String getPproce2() {
		return this.pproce2;
	}

	public void setPproce2(String pproce2) {
		this.pproce2 = pproce2;
	}

	public String getPproce3() {
		return this.pproce3;
	}

	public void setPproce3(String pproce3) {
		this.pproce3 = pproce3;
	}

	public BigDecimal getPrecioad() {
		return this.precioad;
	}

	public void setPrecioad(BigDecimal precioad) {
		this.precioad = precioad;
	}

	public BigDecimal getPrecioad2() {
		return this.precioad2;
	}

	public void setPrecioad2(BigDecimal precioad2) {
		this.precioad2 = precioad2;
	}

	public BigDecimal getPrecioad3() {
		return this.precioad3;
	}

	public void setPrecioad3(BigDecimal precioad3) {
		this.precioad3 = precioad3;
	}

	public BigDecimal getPrecitad1() {
		return this.precitad1;
	}

	public void setPrecitad1(BigDecimal precitad1) {
		this.precitad1 = precitad1;
	}

	public BigDecimal getPrecitad2() {
		return this.precitad2;
	}

	public void setPrecitad2(BigDecimal precitad2) {
		this.precitad2 = precitad2;
	}

	public BigDecimal getPrecitad3() {
		return this.precitad3;
	}

	public void setPrecitad3(BigDecimal precitad3) {
		this.precitad3 = precitad3;
	}

	public String getPrmoneda() {
		return this.prmoneda;
	}

	public void setPrmoneda(String prmoneda) {
		this.prmoneda = prmoneda;
	}

	public BigDecimal getQprfob() {
		return this.qprfob;
	}

	public void setQprfob(BigDecimal qprfob) {
		this.qprfob = qprfob;
	}

	public String getStatu1() {
		return this.statu1;
	}

	public void setStatu1(String statu1) {
		this.statu1 = statu1;
	}

	public String getStatu2() {
		return this.statu2;
	}

	public void setStatu2(String statu2) {
		this.statu2 = statu2;
	}

	public String getStatu3() {
		return this.statu3;
	}

	public void setStatu3(String statu3) {
		this.statu3 = statu3;
	}

	public String getStatu4() {
		return this.statu4;
	}

	public void setStatu4(String statu4) {
		this.statu4 = statu4;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus2() {
		return this.status2;
	}

	public void setStatus2(String status2) {
		this.status2 = status2;
	}

	public String getSucurs() {
		return this.sucurs;
	}

	public void setSucurs(String sucurs) {
		this.sucurs = sucurs;
	}

	public String getTitran() {
		return this.titran;
	}

	public void setTitran(String titran) {
		this.titran = titran;
	}

	public String getVended() {
		return this.vended;
	}

	public void setVended(String vended) {
		this.vended = vended;
	}

}