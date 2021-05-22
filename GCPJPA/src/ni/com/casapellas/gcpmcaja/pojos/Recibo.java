package ni.com.casapellas.gcpmcaja.pojos;

import java.io.Serializable;
import java.util.List;

public class Recibo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int caid;
	private String caidname;
	private String cajero;
	private String cliente;
	private int codcli;
	private String codcomp;
	private String codsuc;
	private String codunineg;
	private String coduser;
	private String codusera;
	private String concepto;
	private String estado;
	private String fecha;
	private String fecham;
	private String hora;
	private String horamod;
	private String monedaapl;
	private double montoapl;
	private double montorec;
	private String motivo;
	private String motivoct;
	private double nodoco;
	private Integer numrec;
	private Integer numrecm;
	private double recjde;
	private String tipodoco;
	private String tiporec;
	private double change;
	private List<Recibodet> recibodet;
	private List<Recibofac> recibofac;
	private Recibojde  recibojde;
	
	private String companyName;
	
	//---------------------------------
	private int NoRecibo;
	private long NoReciboJDE;
	private long NoBatch;
	private String FechaRecibo;
	private long CodCliente;
	private String CodCompania;
	private String CodSucursal;

	//---------------------------------
	
	
	public String getCompanyName() {
		return companyName;
	}

	public int getNoRecibo() {
		return NoRecibo;
	}

	public void setNoRecibo(int noRecibo) {
		NoRecibo = noRecibo;
	}

	public long getNoReciboJDE() {
		return NoReciboJDE;
	}

	public void setNoReciboJDE(long noReciboJDE) {
		NoReciboJDE = noReciboJDE;
	}

	public long getNoBatch() {
		return NoBatch;
	}

	public void setNoBatch(long noBatch) {
		NoBatch = noBatch;
	}

	public String getFechaRecibo() {
		return FechaRecibo;
	}

	public void setFechaRecibo(String fechaRecibo) {
		FechaRecibo = fechaRecibo;
	}

	public long getCodCliente() {
		return CodCliente;
	}

	public void setCodCliente(long codCliente) {
		CodCliente = codCliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Recibo() {
	}

	public int getCaid() {
		return caid;
	}

	public void setCaid(int caid) {
		this.caid = caid;
	}

	public String getCajero() {
		return cajero;
	}

	public void setCajero(String cajero) {
		this.cajero = cajero;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getCodcli() {
		return codcli;
	}

	public void setCodcli(int codcli) {
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

	public String getCodunineg() {
		return codunineg;
	}

	public void setCodunineg(String codunineg) {
		this.codunineg = codunineg;
	}

	public String getCoduser() {
		return coduser;
	}

	public void setCoduser(String coduser) {
		this.coduser = coduser;
	}

	public String getCodusera() {
		return codusera;
	}

	public void setCodusera(String codusera) {
		this.codusera = codusera;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFecham() {
		return fecham;
	}

	public void setFecham(String fecham) {
		this.fecham = fecham;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getHoramod() {
		return horamod;
	}

	public void setHoramod(String horamod) {
		this.horamod = horamod;
	}

	public String getMonedaapl() {
		return monedaapl;
	}

	public void setMonedaapl(String monedaapl) {
		this.monedaapl = monedaapl;
	}

	public double getMontoapl() {
		return montoapl;
	}

	public void setMontoapl(double montoapl) {
		this.montoapl = montoapl;
	}

	public double getMontorec() {
		return montorec;
	}

	public void setMontorec(double montorec) {
		this.montorec = montorec;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getMotivoct() {
		return motivoct;
	}

	public void setMotivoct(String motivoct) {
		this.motivoct = motivoct;
	}

	public double getNodoco() {
		return nodoco;
	}

	public void setNodoco(double nodoco) {
		this.nodoco = nodoco;
	}

	public Integer getNumrec() {
		return numrec;
	}

	public void setNumrec(Integer numrec) {
		this.numrec = numrec;
	}

	public Integer getNumrecm() {
		return numrecm;
	}

	public void setNumrecm(Integer numrecm) {
		this.numrecm = numrecm;
	}

	public double getRecjde() {
		return recjde;
	}

	public void setRecjde(double recjde) {
		this.recjde = recjde;
	}

	public String getTipodoco() {
		return tipodoco;
	}

	public void setTipodoco(String tipodoco) {
		this.tipodoco = tipodoco;
	}

	public String getTiporec() {
		return tiporec;
	}

	public void setTiporec(String tiporec) {
		this.tiporec = tiporec;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

	public List<Recibodet> getRecibodet() {
		return recibodet;
	}

	public void setRecibodet(List<Recibodet> recibodet) {
		this.recibodet = recibodet;
	}

	public List<Recibofac> getRecibofac() {
		return recibofac;
	}

	public void setRecibofac(List<Recibofac> recibofac) {
		this.recibofac = recibofac;
	}

	public Recibojde getRecibojde() {
		return recibojde;
	}

	public void setRecibojde(Recibojde recibojde) {
		this.recibojde = recibojde;
	}

	public String getCaidname() {
		return caidname;
	}

	public void setCaidname(String caidname) {
		this.caidname = caidname;
	}

	public String getCodCompania() {
		return CodCompania;
	}

	public void setCodCompania(String codCompania) {
		CodCompania = codCompania;
	}

	public String getCodSucursal() {
		return CodSucursal;
	}

	public void setCodSucursal(String codSucursal) {
		CodSucursal = codSucursal;
	}
}