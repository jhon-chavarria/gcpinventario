package ni.com.casapellas.erp.jde.pojo;

/**
 * 
 * Descripcion de CuentasPorCobrar.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Jul 15, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class CuentasPorCobrar {
	private String codigoSucursal;
	private Long codigoCliente;
	private String tipoDocumento;
	private Long numeroDocumento;
	private String cuota;
	private int fechaFactura;
	private String tipoDocDisminuyeSaldo;
	private Long numeroDocDisminuyeSaldo;
	private int fechaPago;
	private int fechaLibroMayor;
	private int anio;
	private int mes;
	private String codigoSucursal2;
	private Long numeroBatch;
	private int fechaBatch;
	private Long codigoClientePadre;
	private String estadoContabilizacion; 
	private Double importeBrutoCordobas;
	private Double saldoCordobas;
	private String codigoMoneda;
	private Double tasaCambio;
	private Double importeBrutoDolares;
	private Double saldoDolares;
	private String cuentasCaja;
	private String unidadNegocio;
	private String numeroSolicitud;
	private String tipoCartera;
	private String nombreCliente;
	private String tipoBatch;
	private String tipoPago;
	
	public String getCodigoSucursal() {
		return codigoSucursal;
	}
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}
	public Long getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Long getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getCuota() {
		return cuota;
	}
	public void setCuota(String cuota) {
		this.cuota = cuota;
	}
	public int getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(int fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public String getTipoDocDisminuyeSaldo() {
		return tipoDocDisminuyeSaldo;
	}
	public void setTipoDocDisminuyeSaldo(String tipoDocDisminuyeSaldo) {
		this.tipoDocDisminuyeSaldo = tipoDocDisminuyeSaldo;
	}
	public Long getNumeroDocDisminuyeSaldo() {
		return numeroDocDisminuyeSaldo;
	}
	public void setNumeroDocDisminuyeSaldo(Long numeroDocDisminuyeSaldo) {
		this.numeroDocDisminuyeSaldo = numeroDocDisminuyeSaldo;
	}
	public int getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(int fechaPago) {
		this.fechaPago = fechaPago;
	}
	public int getFechaLibroMayor() {
		return fechaLibroMayor;
	}
	public void setFechaLibroMayor(int fechaLibroMayor) {
		this.fechaLibroMayor = fechaLibroMayor;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public String getCodigoSucursal2() {
		return codigoSucursal2;
	}
	public void setCodigoSucursal2(String codigoSucursal2) {
		this.codigoSucursal2 = codigoSucursal2;
	}
	public Long getNumeroBatch() {
		return numeroBatch;
	}
	public void setNumeroBatch(Long numeroBatch) {
		this.numeroBatch = numeroBatch;
	}
	public int getFechaBatch() {
		return fechaBatch;
	}
	public void setFechaBatch(int fechaBatch) {
		this.fechaBatch = fechaBatch;
	}
	public Long getCodigoClientePadre() {
		return codigoClientePadre;
	}
	public void setCodigoClientePadre(Long codigoClientePadre) {
		this.codigoClientePadre = codigoClientePadre;
	}
	public String getEstadoContabilizacion() {
		return estadoContabilizacion;
	}
	public void setEstadoContabilizacion(String estadoContabilizacion) {
		this.estadoContabilizacion = estadoContabilizacion;
	}
	public Double getImporteBrutoCordobas() {
		return importeBrutoCordobas;
	}
	public void setImporteBrutoCordobas(Double importeBrutoCordobas) {
		this.importeBrutoCordobas = importeBrutoCordobas;
	}
	public Double getSaldoCordobas() {
		return saldoCordobas;
	}
	public void setSaldoCordobas(Double saldoCordobas) {
		this.saldoCordobas = saldoCordobas;
	}
	public String getCodigoMoneda() {
		return codigoMoneda;
	}
	public void setCodigoMoneda(String codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}
	public Double getTasaCambio() {
		return tasaCambio;
	}
	public void setTasaCambio(Double tasaCambio) {
		this.tasaCambio = tasaCambio;
	}
	public Double getImporteBrutoDolares() {
		return importeBrutoDolares;
	}
	public void setImporteBrutoDolares(Double importeBrutoDolares) {
		this.importeBrutoDolares = importeBrutoDolares;
	}
	public Double getSaldoDolares() {
		return saldoDolares;
	}
	public void setSaldoDolares(Double saldoDolares) {
		this.saldoDolares = saldoDolares;
	}
	public String getCuentasCaja() {
		return cuentasCaja;
	}
	public void setCuentasCaja(String cuentasCaja) {
		this.cuentasCaja = cuentasCaja;
	}
	public String getUnidadNegocio() {
		return unidadNegocio;
	}
	public void setUnidadNegocio(String unidadNegocio) {
		this.unidadNegocio = unidadNegocio;
	}
	public String getNumeroSolicitud() {
		return numeroSolicitud;
	}
	public void setNumeroSolicitud(String numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}
	public String getTipoCartera() {
		return tipoCartera;
	}
	public void setTipoCartera(String tipoCartera) {
		this.tipoCartera = tipoCartera;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getTipoBatch() {
		return tipoBatch;
	}
	public void setTipoBatch(String tipoBatch) {
		this.tipoBatch = tipoBatch;
	}
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
}
