package ni.com.casapellas.gcpmcaja.pojos;

/**
 * 
 * Descripcion de FacturaFinanciamientoDetalle.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Jul 5, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class FacturaFinanciamientoDetalleBanco {
	private String codigoCompania;
	private String nombreCompania;
	private String codigoSucursal;
	private String nombreSucursal; 
	private int numeroSolicitud; 
	private String tipoSolicitud; 
	private long codigoCliente;
	private int numeroCuota;
	private int fechaJuliano;
	private Double valorCordobas;
	private Double saldoCuotaCordobas;
	private Double saldoPrincipalCordobas;
	private Double saldoInteresesCordobas;
	private Double valorDolares; 
	private Double saldoCuotaDolares; 
	private Double saldoInteresesDolares;
	private Double monto;
	private Double montoPendiente;
	private Double principal;
	private Double interes;
	private Double impuesto;
	private String fechaPago;
	private String fechaActual;
	private int diasMora;
	private int diasVencimiento;
	private Double mora;
	private Double moraP;
	private String moneda;
	private Double tasa; 
	private long numeroBatch;
	private String nombreCliente;
	private String descripcionBien;
	private String unidadNegocio;
	private Double saldoPrincipalDolares;
	private String linea;
	private Double montoAtrasadoSeguro;
	private Double montoSeguro;
	private String unidadNegocioRecibo;
	
	public Double getMontoAtrasadoSeguro() {
		return montoAtrasadoSeguro;
	}
	public void setMontoAtrasadoSeguro(Double montoAtrasadoSeguro) {
		this.montoAtrasadoSeguro = montoAtrasadoSeguro;
	}
	public Double getMontoSeguro() {
		return montoSeguro;
	}
	public void setMontoSeguro(Double montoSeguro) {
		this.montoSeguro = montoSeguro;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getDescripcionBien() {
		return descripcionBien;
	}
	public void setDescripcionBien(String descripcionBien) {
		this.descripcionBien = descripcionBien;
	}

	public String getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public String getNombreCompania() {
		return nombreCompania;
	}
	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}
	public String getCodigoSucursal() {
		return codigoSucursal;
	}
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}
	public int getNumeroSolicitud() {
		return numeroSolicitud;
	}
	public void setNumeroSolicitud(int numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}
	public String getTipoSolicitud() {
		return tipoSolicitud;
	}
	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public long getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public int getFechaJuliano() {
		return fechaJuliano;
	}
	public void setFechaJuliano(int fechaJuliano) {
		this.fechaJuliano = fechaJuliano;
	}
	public Double getValorCordobas() {
		return valorCordobas;
	}
	public void setValorCordobas(Double valorCordobas) {
		this.valorCordobas = valorCordobas;
	}
	public Double getSaldoCuotaCordobas() {
		return saldoCuotaCordobas;
	}
	public void setSaldoCuotaCordobas(Double saldoCuotaCordobas) {
		this.saldoCuotaCordobas = saldoCuotaCordobas;
	}
	public Double getSaldoPrincipalCordobas() {
		return saldoPrincipalCordobas;
	}
	public void setSaldoPrincipalCordobas(Double saldoPrincipalCordobas) {
		this.saldoPrincipalCordobas = saldoPrincipalCordobas;
	}
	public Double getSaldoInteresesCordobas() {
		return saldoInteresesCordobas;
	}
	public void setSaldoInteresesCordobas(Double saldoInteresesCordobas) {
		this.saldoInteresesCordobas = saldoInteresesCordobas;
	}
	public Double getValorDolares() {
		return valorDolares;
	}
	public void setValorDolares(Double valorDolares) {
		this.valorDolares = valorDolares;
	}
	public Double getSaldoCuotaDolares() {
		return saldoCuotaDolares;
	}
	public void setSaldoCuotaDolares(Double saldoCuotaDolares) {
		this.saldoCuotaDolares = saldoCuotaDolares;
	}
	public Double getSaldoInteresesDolares() {
		return saldoInteresesDolares;
	}
	public void setSaldoInteresesDolares(Double saldoInteresesDolares) {
		this.saldoInteresesDolares = saldoInteresesDolares;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Double getMontoPendiente() {
		return montoPendiente;
	}
	public void setMontoPendiente(Double montoPendiente) {
		this.montoPendiente = montoPendiente;
	}
	public Double getPrincipal() {
		return principal;
	}
	public void setPrincipal(Double principal) {
		this.principal = principal;
	}
	public Double getInteres() {
		return interes;
	}
	public void setInteres(Double interes) {
		this.interes = interes;
	}
	public Double getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getFechaActual() {
		return fechaActual;
	}
	public void setFechaActual(String fechaActual) {
		this.fechaActual = fechaActual;
	}
	public int getDiasMora() {
		return diasMora;
	}
	public void setDiasMora(int diasMora) {
		this.diasMora = diasMora;
	}
	public int getDiasVencimiento() {
		return diasVencimiento;
	}
	public void setDiasVencimiento(int diasVencimiento) {
		this.diasVencimiento = diasVencimiento;
	}
	public Double getMora() {
		return mora;
	}
	public void setMora(Double mora) {
		this.mora = mora;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Double getTasa() {
		return tasa;
	}
	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}
	public long getNumeroBatch() {
		return numeroBatch;
	}
	public void setNumeroBatch(long numeroBatch) {
		this.numeroBatch = numeroBatch;
	}
	public Double getMoraP() {
		return moraP;
	}
	public void setMoraP(Double moraP) {
		this.moraP = moraP;
	}
	public Double getSaldoPrincipalDolares() {
		return saldoPrincipalDolares;
	}
	public void setSaldoPrincipalDolares(Double saldoPrincipalDolares) {
		this.saldoPrincipalDolares = saldoPrincipalDolares;
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public String getUnidadNegocio() {
		return unidadNegocio;
	}
	public void setUnidadNegocio(String unidadNegocio) {
		this.unidadNegocio = unidadNegocio;
	}
	public String getUnidadNegocioRecibo() {
		return unidadNegocioRecibo;
	}
	public void setUnidadNegocioRecibo(String unidadNegocioRecibo) {
		this.unidadNegocioRecibo = unidadNegocioRecibo;
	}
	public int getNumeroCuota() {
		return numeroCuota;
	}
	public void setNumeroCuota(int numeroCuota) {
		this.numeroCuota = numeroCuota;
	}
}
