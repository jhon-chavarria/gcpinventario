package ni.com.casapellas.gcpmcaja.pojos;

/**
 * 
 * Descripcion de FacturaCredito.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Jul 4, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class FacturaCreditoCabecera {
	private long numeroFactura;
	private long codigoCliente;
	private String nombreCliente;
	private String tipoFactura;
	private String partida;
	private String codigoUnidadNegocio; 
	private String unidadNegocio;
	private String codigoSucursal;
	private String nombreSucursal;
	private String codigoCompania;
	private String nombreCompania; 
	private String moneda;
	private Double tasa;
	private Double saldoPendienteCordoba;
	private Double saldoPendienteDolares;
	private Double totalCordoba;
	private Double totalDolares; 
	private Double impuestoCordobas;
	private Double impuestoDolares;
	private Double subTotalCordobas;
	private Double subTotalDolares;
	private Double monto;
	private Double montoPendiente;
	private Double subTotal;
	private Double impuesto;
	private String fechaFactura;
	private String fechaVencimiento;
	private String compenslm; 
	private String tipoPago;
	private int fechaFacturaJuliano;
	private int fechaVencimientoJuliano;
	private String numeroSolicitud;
	private String tipoCartera;
	private Double totalPendiente;
	private String concepto;
	private int plazo;
	private int limiteCredito;
	
	private Double totalFacturaDolares;
	private Double totalFacturaCordobas;
	private Double totalInteresMoraDolares;
	private Double totalInteresMoraCordobas;
	private String lineaNegocio;
	private Long batchNumber;
	
	private Double tasaActual;
	
	public Double getTotalInteresMoraDolares() {
		return totalInteresMoraDolares;
	}
	public void setTotalInteresMoraDolares(Double totalInteresMoraDolares) {
		this.totalInteresMoraDolares = totalInteresMoraDolares;
	}
	public Double getTotalInteresMoraCordobas() {
		return totalInteresMoraCordobas;
	}
	public void setTotalInteresMoraCordobas(Double totalInteresMoraCordobas) {
		this.totalInteresMoraCordobas = totalInteresMoraCordobas;
	}
	public Double getTotalFacturaDolares() {
		return totalFacturaDolares;
	}
	public void setTotalFacturaDolares(Double totalFacturaDolares) {
		this.totalFacturaDolares = totalFacturaDolares;
	}
	public Double getTotalFacturaCordobas() {
		return totalFacturaCordobas;
	}
	public void setTotalFacturaCordobas(Double totalFacturaCordobas) {
		this.totalFacturaCordobas = totalFacturaCordobas;
	}
	public long getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(long numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public long getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getTipoFactura() {
		return tipoFactura;
	}
	public void setTipoFactura(String tipoFactura) {
		this.tipoFactura = tipoFactura;
	}
	public String getPartida() {
		return partida;
	}
	public void setPartida(String partida) {
		this.partida = partida;
	}
	public String getCodigoUnidadNegocio() {
		return codigoUnidadNegocio;
	}
	public void setCodigoUnidadNegocio(String codigoUnidadNegocio) {
		this.codigoUnidadNegocio = codigoUnidadNegocio;
	}
	public String getUnidadNegocio() {
		return unidadNegocio;
	}
	public void setUnidadNegocio(String unidadNegocio) {
		this.unidadNegocio = unidadNegocio;
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
	public Double getSaldoPendienteCordoba() {
		return saldoPendienteCordoba;
	}
	public void setSaldoPendienteCordoba(Double saldoPendienteCordoba) {
		this.saldoPendienteCordoba = saldoPendienteCordoba;
	}
	public Double getSaldoPendienteDolares() {
		return saldoPendienteDolares;
	}
	public void setSaldoPendienteDolares(Double saldoPendienteDolares) {
		this.saldoPendienteDolares = saldoPendienteDolares;
	}
	public Double getTotalCordoba() {
		return totalCordoba;
	}
	public void setTotalCordoba(Double totalCordoba) {
		this.totalCordoba = totalCordoba;
	}
	public Double getTotalDolares() {
		return totalDolares;
	}
	public void setTotalDolares(Double totalDolares) {
		this.totalDolares = totalDolares;
	}
	public Double getImpuestoCordobas() {
		return impuestoCordobas;
	}
	public void setImpuestoCordobas(Double impuestoCordobas) {
		this.impuestoCordobas = impuestoCordobas;
	}
	public Double getImpuestoDolares() {
		return impuestoDolares;
	}
	public void setImpuestoDolares(Double impuestoDolares) {
		this.impuestoDolares = impuestoDolares;
	}
	public Double getSubTotalCordobas() {
		return subTotalCordobas;
	}
	public void setSubTotalCordobas(Double subTotalCordobas) {
		this.subTotalCordobas = subTotalCordobas;
	}
	public Double getSubTotalDolares() {
		return subTotalDolares;
	}
	public void setSubTotalDolares(Double subTotalDolares) {
		this.subTotalDolares = subTotalDolares;
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
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public Double getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}
	public String getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(String fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getCompenslm() {
		return compenslm;
	}
	public void setCompenslm(String compenslm) {
		this.compenslm = compenslm;
	}
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public int getFechaFacturaJuliano() {
		return fechaFacturaJuliano;
	}
	public void setFechaFacturaJuliano(int fechaFacturaJuliano) {
		this.fechaFacturaJuliano = fechaFacturaJuliano;
	}
	public int getFechaVencimientoJuliano() {
		return fechaVencimientoJuliano;
	}
	public void setFechaVencimientoJuliano(int fechaVencimientoJuliano) {
		this.fechaVencimientoJuliano = fechaVencimientoJuliano;
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
	public Double getTotalPendiente() {
		return totalPendiente;
	}
	public void setTotalPendiente(Double totalPendiente) {
		this.totalPendiente = totalPendiente;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public int getPlazo() {
		return plazo;
	}
	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}
	public int getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(int limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	public String getLineaNegocio() {
		return lineaNegocio;
	}
	public void setLineaNegocio(String lineaNegocio) {
		this.lineaNegocio = lineaNegocio;
	}
	public Long getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(Long batchNumber) {
		this.batchNumber = batchNumber;
	}
	public Double getTasaActual() {
		return tasaActual;
	}
	public void setTasaActual(Double tasaActual) {
		this.tasaActual = tasaActual;
	}
	
}
