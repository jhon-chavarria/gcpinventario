package ni.com.casapellas.gcpmcaja.pojos;

import java.io.Serializable;
import java.util.List;

public class Finanhdr implements Serializable {
	private static final long serialVersionUID = 1L;

	private double ataap;
	private double atacr;
	private double atag;
	private double atctam;
	private String atexr1;
	private double atfap;
	private double atintd;
	private double atintf;
	private double atprid;
	private double atprif;
	private double atstam;
	private String attxa1;
	private double codcli;
	private String codcomp;
	private String codsuc;
	private String fecha;
	private double impuesto;
	private double interes;
	private String linea;
	private String moneda;
	private double monto;
	private double montopend;
	private double mora;
	private String nomcli;
	private String nomlinea;
	private double nosol;
	private double principal;
	private String recibido;
	private double tasa;
	private String tiposol;
	
	
	private List<Finandet> finandet;
	private List<Producto> producto;

	public List<Finandet> getFinandet() {
		return finandet;
	}

	public void setFinandet(List<Finandet> finandet) {
		this.finandet = finandet;
	}

	public Finanhdr() {
	}

	public double getAtaap() {
		return ataap;
	}

	public void setAtaap(double ataap) {
		this.ataap = ataap;
	}

	public double getAtacr() {
		return atacr;
	}

	public void setAtacr(double atacr) {
		this.atacr = atacr;
	}

	public double getAtag() {
		return atag;
	}

	public void setAtag(double atag) {
		this.atag = atag;
	}

	public double getAtctam() {
		return atctam;
	}

	public void setAtctam(double atctam) {
		this.atctam = atctam;
	}

	public String getAtexr1() {
		return atexr1;
	}

	public void setAtexr1(String atexr1) {
		this.atexr1 = atexr1;
	}

	public double getAtfap() {
		return atfap;
	}

	public void setAtfap(double atfap) {
		this.atfap = atfap;
	}

	public double getAtintd() {
		return atintd;
	}

	public void setAtintd(double atintd) {
		this.atintd = atintd;
	}

	public double getAtintf() {
		return atintf;
	}

	public void setAtintf(double atintf) {
		this.atintf = atintf;
	}

	public double getAtprid() {
		return atprid;
	}

	public void setAtprid(double atprid) {
		this.atprid = atprid;
	}

	public double getAtprif() {
		return atprif;
	}

	public void setAtprif(double atprif) {
		this.atprif = atprif;
	}

	public double getAtstam() {
		return atstam;
	}

	public void setAtstam(double atstam) {
		this.atstam = atstam;
	}

	public String getAttxa1() {
		return attxa1;
	}

	public void setAttxa1(String attxa1) {
		this.attxa1 = attxa1;
	}

	public double getCodcli() {
		return codcli;
	}

	public void setCodcli(double codcli) {
		this.codcli = codcli;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getMontopend() {
		return montopend;
	}

	public void setMontopend(double montopend) {
		this.montopend = montopend;
	}

	public double getMora() {
		return mora;
	}

	public void setMora(double mora) {
		this.mora = mora;
	}

	public String getNomcli() {
		return nomcli;
	}

	public void setNomcli(String nomcli) {
		this.nomcli = nomcli;
	}

	public String getNomlinea() {
		return nomlinea;
	}

	public void setNomlinea(String nomlinea) {
		this.nomlinea = nomlinea;
	}

	public double getNosol() {
		return nosol;
	}

	public void setNosol(double nosol) {
		this.nosol = nosol;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public String getRecibido() {
		return recibido;
	}

	public void setRecibido(String recibido) {
		this.recibido = recibido;
	}

	public double getTasa() {
		return tasa;
	}

	public void setTasa(double tasa) {
		this.tasa = tasa;
	}

	public String getTiposol() {
		return tiposol;
	}

	public void setTiposol(String tiposol) {
		this.tiposol = tiposol;
	}

	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

	
}