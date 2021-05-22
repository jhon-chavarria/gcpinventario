package ni.com.casapellas.cxccobro.cxc;

// Generated Dec 29, 2011 4:46:25 PM by Hibernate Tools 3.2.2.GA

import java.math.BigDecimal;  
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ni.com.casapellas.cxccobro.pojo.ValoresBienFinanciamiento;

/**
 * Hdrestcta generated by hbm2java
 */
public class Hdrestcta implements java.io.Serializable {

	private long idec;
	private Logestcta logestcta;
	private String codcomp;
	private int codcli;
	private int mes;
	private int anio;
	private BigDecimal saldoantd = BigDecimal.ZERO;
	private BigDecimal saldod = BigDecimal.ZERO;
	private BigDecimal principald;
	private BigDecimal ineteresmd;
	private BigDecimal cargoadmind;
	private BigDecimal saldoantf;
	private BigDecimal principalf;
	private BigDecimal interesmf;
	private BigDecimal cargoadminf;
	private String nosol="";
	private String companies="";
	private String tiposol;
	private String hechopor;
	private Date fecha;
	private BigDecimal saldof = BigDecimal.ZERO;
	private Set<Detestcta> detestctas = new HashSet<Detestcta>(0);
	private Set<Antiguedad> antiguedads = new HashSet<Antiguedad>(0);
	private Set<ResumenFinan> resumenFinans = new HashSet<ResumenFinan>(0);
	
	private List<ValoresBienFinanciamiento> lstValues = new ArrayList<ValoresBienFinanciamiento>();
	
	private String CompSol = "";

	private String ciudad;
	private String municipio;
	
	/*****************************/
	private String nomcli;
	private String compania;
	private String correo;
	private String direccion;
	private Date fechacorte;
	//finan
	private int anioProd;
	private String marca;
	private String modelo;
	private String chasis;
	private String color;
	private BigDecimal valorbien;
	private BigDecimal prima;
	private BigDecimal seguro;
	private BigDecimal comision;
	private BigDecimal totalfinan = BigDecimal.ZERO;
	private BigDecimal interesfinan;
	private int nofactura;
	private Date fechacuota;
	private Date fechapago;
	private BigDecimal montocuota;
	private int diapago;
	private String producto;
	private BigDecimal saldoliquidacion;
	private BigDecimal totalcontrato;
	private BigDecimal saldocontrato;
	
	private BigDecimal ineteresmf;
	private String codsuc;
	/*****************************/

	public Hdrestcta() {
	}

	public Hdrestcta(long idec, Logestcta logestcta, String codcomp, int codcli, int mes,
			int anio, BigDecimal saldoantd, BigDecimal saldod,
			BigDecimal principald, BigDecimal ineteresmd,
			BigDecimal cargoadmind, BigDecimal saldoantf,
			BigDecimal principalf, BigDecimal interesmf,
			BigDecimal cargoadminf, String nosol, String tiposol, String hechopor,
			Date fecha, BigDecimal saldof) {
		this.idec = idec;
		this.logestcta = logestcta;
		this.codcomp = codcomp;
		this.codcli = codcli;
		this.mes = mes;
		this.anio = anio;
		this.saldoantd = saldoantd;
		this.saldod = saldod;
		this.principald = principald;
		this.ineteresmd = ineteresmd;
		this.cargoadmind = cargoadmind;
		this.saldoantf = saldoantf;
		this.principalf = principalf;
		this.interesmf = interesmf;
		this.cargoadminf = cargoadminf;
		this.nosol = nosol;
		this.tiposol = tiposol;
		this.hechopor = hechopor;
		this.fecha = fecha;
		this.saldof = saldof;
	}

	public Hdrestcta(long idec, Logestcta logestcta, String codcomp, int codcli, int mes,
			int anio, BigDecimal saldoantd, BigDecimal saldod,
			BigDecimal principald, BigDecimal ineteresmd,
			BigDecimal cargoadmind, BigDecimal saldoantf,
			BigDecimal principalf, BigDecimal interesmf,
			BigDecimal cargoadminf, String nosol, String tiposol, String hechopor,
			Date fecha, BigDecimal saldof, Set<Detestcta> detestctas,
			Set<Antiguedad> antiguedads,Set resumenFinans) {
		this.idec = idec;
		this.logestcta = logestcta;
		this.codcomp = codcomp;
		this.codcli = codcli;
		this.mes = mes;
		this.anio = anio;
		this.saldoantd = saldoantd;
		this.saldod = saldod;
		this.principald = principald;
		this.ineteresmd = ineteresmd;
		this.cargoadmind = cargoadmind;
		this.saldoantf = saldoantf;
		this.principalf = principalf;
		this.interesmf = interesmf;
		this.cargoadminf = cargoadminf;
		this.nosol = nosol;
		this.tiposol = tiposol;
		this.hechopor = hechopor;
		this.fecha = fecha;
		this.saldof = saldof;
		this.detestctas = detestctas;
		this.antiguedads = antiguedads;
		this.resumenFinans = resumenFinans;
	}

	public long getIdec() {
		return this.idec;
	}

	public void setIdec(long idec) {
		this.idec = idec;
	}
	
	public Logestcta getLogestcta() {
		return this.logestcta;
	}

	public void setLogestcta(Logestcta logestcta) {
		this.logestcta = logestcta;
	}
	
	public String getCodcomp() {
		return this.codcomp;
	}

	public void setCodcomp(String codcomp) {
		this.codcomp = codcomp;
	}

	public int getCodcli() {
		return this.codcli;
	}

	public void setCodcli(int codcli) {
		this.codcli = codcli;
	}

	public int getMes() {
		return this.mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return this.anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public BigDecimal getSaldoantd() {
		return this.saldoantd;
	}

	public void setSaldoantd(BigDecimal saldoantd) {
		this.saldoantd = saldoantd;
	}

	public BigDecimal getSaldod() {
		return this.saldod;
	}

	public void setSaldod(BigDecimal saldod) {
		this.saldod = saldod;
	}

	public BigDecimal getPrincipald() {
		return this.principald;
	}

	public void setPrincipald(BigDecimal principald) {
		this.principald = principald;
	}

	public BigDecimal getIneteresmd() {
		return this.ineteresmd;
	}

	public void setIneteresmd(BigDecimal ineteresmd) {
		this.ineteresmd = ineteresmd;
	}

	public BigDecimal getCargoadmind() {
		return this.cargoadmind;
	}

	public void setCargoadmind(BigDecimal cargoadmind) {
		this.cargoadmind = cargoadmind;
	}

	public BigDecimal getSaldoantf() {
		return this.saldoantf;
	}

	public void setSaldoantf(BigDecimal saldoantf) {
		this.saldoantf = saldoantf;
	}

	public BigDecimal getPrincipalf() {
		return this.principalf;
	}

	public void setPrincipalf(BigDecimal principalf) {
		this.principalf = principalf;
	}

	public BigDecimal getInteresmf() {
		return this.interesmf;
	}

	public void setInteresmf(BigDecimal interesmf) {
		this.interesmf = interesmf;
	}

	public BigDecimal getCargoadminf() {
		return this.cargoadminf;
	}

	public void setCargoadminf(BigDecimal cargoadminf) {
		this.cargoadminf = cargoadminf;
	}

	 

	public String getTiposol() {
		return this.tiposol;
	}

	public String getNosol() {
		return nosol;
	}

	public void setNosol(String nosol) {
		this.nosol = nosol;
	}

	public void setTiposol(String tiposol) {
		this.tiposol = tiposol;
	}

	public String getHechopor() {
		return this.hechopor;
	}

	public void setHechopor(String hechopor) {
		this.hechopor = hechopor;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getSaldof() {
		return this.saldof;
	}

	public void setSaldof(BigDecimal saldof) {
		this.saldof = saldof;
	}

	public Set<Detestcta> getDetestctas() {
		return this.detestctas;
	}

	public void setDetestctas(Set<Detestcta> detestctas) {
		this.detestctas = detestctas;
	}

	public Set<Antiguedad> getAntiguedads() {
		return this.antiguedads;
	}

	public void setAntiguedads(Set<Antiguedad> antiguedads) {
		this.antiguedads = antiguedads;
	}

	public String getNomcli() {
		return nomcli;
	}

	public void setNomcli(String nomcli) {
		this.nomcli = nomcli;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechacorte() {
		return fechacorte;
	}

	public void setFechacorte(Date fechacorte) {
		this.fechacorte = fechacorte;
	}

	public Set<ResumenFinan> getResumenFinans() {
		return resumenFinans;
	}

	public void setResumenFinans(Set<ResumenFinan> resumenFinans) {
		this.resumenFinans = resumenFinans;
	}

	public int getAnioProd() {
		return anioProd;
	}

	public void setAnioProd(int anioProd) {
		this.anioProd = anioProd;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public BigDecimal getValorbien() {
		return valorbien;
	}

	public void setValorbien(BigDecimal valorbien) {
		this.valorbien = valorbien;
	}

	public BigDecimal getPrima() {
		return prima;
	}

	public void setPrima(BigDecimal prima) {
		this.prima = prima;
	}

	public BigDecimal getSeguro() {
		return seguro;
	}

	public void setSeguro(BigDecimal seguro) {
		this.seguro = seguro;
	}

	public BigDecimal getComision() {
		return comision;
	}

	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}

	public BigDecimal getTotalfinan() {
		return totalfinan;
	}

	public void setTotalfinan(BigDecimal totalfinan) {
		this.totalfinan = totalfinan;
	}

	public BigDecimal getInteresfinan() {
		return interesfinan;
	}

	public void setInteresfinan(BigDecimal interesfinan) {
		this.interesfinan = interesfinan;
	}

	public int getNofactura() {
		return nofactura;
	}

	public void setNofactura(int nofactura) {
		this.nofactura = nofactura;
	}

	public Date getFechacuota() {
		return fechacuota;
	}

	public void setFechacuota(Date fechacuota) {
		this.fechacuota = fechacuota;
	}

	public Date getFechapago() {
		return fechapago;
	}

	public void setFechapago(Date fechapago) {
		this.fechapago = fechapago;
	}

	public BigDecimal getMontocuota() {
		return montocuota;
	}

	public void setMontocuota(BigDecimal montocuota) {
		this.montocuota = montocuota;
	}

	public int getDiapago() {
		return diapago;
	}

	public void setDiapago(int diapago) {
		this.diapago = diapago;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public BigDecimal getSaldoliquidacion() {
		return saldoliquidacion;
	}

	public void setSaldoliquidacion(BigDecimal saldoliquidacion) {
		this.saldoliquidacion = saldoliquidacion;
	}

	public BigDecimal getTotalcontrato() {
		return totalcontrato;
	}

	public void setTotalcontrato(BigDecimal totalcontrato) {
		this.totalcontrato = totalcontrato;
	}

	public BigDecimal getSaldocontrato() {
		return saldocontrato;
	}

	public void setSaldocontrato(BigDecimal saldocontrato) {
		this.saldocontrato = saldocontrato;
	}

	public BigDecimal getIneteresmf() {
		return ineteresmf;
	}

	public void setIneteresmf(BigDecimal ineteresmf) {
		this.ineteresmf = ineteresmf;
	}

	public String getCodsuc() {
		return codsuc;
	}

	public void setCodsuc(String codsuc) {
		this.codsuc = codsuc;
	}
	public String getCompanies() {
		return companies;
	}

	public void setCompanies(String companies) {
		this.companies = companies;
	}

	public List<ValoresBienFinanciamiento> getLstValues() {
		return lstValues;
	}

	public void setLstValues(List<ValoresBienFinanciamiento> lstValues) {
		this.lstValues = lstValues;
	}

	public String getCompSol() {
		return CompSol;
	}

	public void setCompSol(String compSol) {
		CompSol = compSol;
	}
	
}
