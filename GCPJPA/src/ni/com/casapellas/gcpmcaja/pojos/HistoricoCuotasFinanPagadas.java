package ni.com.casapellas.gcpmcaja.pojos;

/**
 * 
 * Descripcion de HistoricoCuotasPagadas.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Jan 18, 2017
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class HistoricoCuotasFinanPagadas {
	private Integer numeroSolicitud;
	private Integer codigoCliente; 
	private String codigoCompania;
	private String codigoSucursal;
	private String codigoUniNeg;
	private Integer numeroCaja; 
	private Integer numeroRecibo; 
	private Integer numeroCuota; 
	private Double montoCuotaCordobas; 
	private Double saldoCuotaCordobas; 
	private Double montoCuotaDolares;
	private Double saldoCuotaDolares;
	private Double montoPrincipalCordobas;
	private Double montoPrincipalDolares;
	private Double montoInteresTotalCordobas;
	private Double montoInteresCuotaDolares;
	private String fechaRecibo;
	private String horaRecibo;
	private String fechaGrabacion;
	private Integer codigoUsuario;
	private String loginUsuario;
	private Integer pagoPrincipal;
	private Integer estado;
	
	public Integer getNumeroCaja() {
		return numeroCaja;
	}
	public void setNumeroCaja(Integer numeroCaja) {
		this.numeroCaja = numeroCaja;
	}
	public Integer getNumeroRecibo() {
		return numeroRecibo;
	}
	public void setNumeroRecibo(Integer numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}
	public Integer getNumeroCuota() {
		return numeroCuota;
	}
	public void setNumeroCuota(Integer numeroCuota) {
		this.numeroCuota = numeroCuota;
	}
	public Double getMontoCuotaCordobas() {
		return montoCuotaCordobas;
	}
	public void setMontoCuotaCordobas(Double montoCuotaCordobas) {
		this.montoCuotaCordobas = montoCuotaCordobas;
	}
	public Double getSaldoCuotaCordobas() {
		return saldoCuotaCordobas;
	}
	public void setSaldoCuotaCordobas(Double saldoCuotaCordobas) {
		this.saldoCuotaCordobas = saldoCuotaCordobas;
	}
	public Double getMontoCuotaDolares() {
		return montoCuotaDolares;
	}
	public void setMontoCuotaDolares(Double montoCuotaDolares) {
		this.montoCuotaDolares = montoCuotaDolares;
	}
	public Double getSaldoCuotaDolares() {
		return saldoCuotaDolares;
	}
	public void setSaldoCuotaDolares(Double saldoCuotaDolares) {
		this.saldoCuotaDolares = saldoCuotaDolares;
	}
	public Double getMontoPrincipalCordobas() {
		return montoPrincipalCordobas;
	}
	public void setMontoPrincipalCordobas(Double montoPrincipalCordobas) {
		this.montoPrincipalCordobas = montoPrincipalCordobas;
	}
	public Double getMontoPrincipalDolares() {
		return montoPrincipalDolares;
	}
	public void setMontoPrincipalDolares(Double montoPrincipalDolares) {
		this.montoPrincipalDolares = montoPrincipalDolares;
	}
	public Double getMontoInteresTotalCordobas() {
		return montoInteresTotalCordobas;
	}
	public void setMontoInteresTotalCordobas(Double montoInteresTotalCordobas) {
		this.montoInteresTotalCordobas = montoInteresTotalCordobas;
	}
	public Double getMontoInteresCuotaDolares() {
		return montoInteresCuotaDolares;
	}
	public void setMontoInteresCuotaDolares(Double montoInteresCuotaDolares) {
		this.montoInteresCuotaDolares = montoInteresCuotaDolares;
	}
	public Integer getNumeroSolicitud() {
		return numeroSolicitud;
	}
	public void setNumeroSolicitud(Integer numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}
	public Integer getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public String getCodigoSucursal() {
		return codigoSucursal;
	}
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}
	public String getCodigoUniNeg() {
		return codigoUniNeg;
	}
	public void setCodigoUniNeg(String codigoUniNeg) {
		this.codigoUniNeg = codigoUniNeg;
	}
	public String getFechaRecibo() {
		return fechaRecibo;
	}
	public void setFechaRecibo(String fechaRecibo) {
		this.fechaRecibo = fechaRecibo;
	}
	public String getHoraRecibo() {
		return horaRecibo;
	}
	public void setHoraRecibo(String horaRecibo) {
		this.horaRecibo = horaRecibo;
	}
	public String getFechaGrabacion() {
		return fechaGrabacion;
	}
	public void setFechaGrabacion(String fechaGrabacion) {
		this.fechaGrabacion = fechaGrabacion;
	}
	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public String getLoginUsuario() {
		return loginUsuario;
	}
	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}
	public Integer getPagoPrincipal() {
		return pagoPrincipal;
	}
	public void setPagoPrincipal(Integer pagoPrincipal) {
		this.pagoPrincipal = pagoPrincipal;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
}
