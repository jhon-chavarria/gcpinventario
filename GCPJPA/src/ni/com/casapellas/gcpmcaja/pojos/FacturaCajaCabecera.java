package ni.com.casapellas.gcpmcaja.pojos;

/**
 * 
 * Descripcion de FacturaCajaCabecera.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Sep 22, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class FacturaCajaCabecera {
	private Long numeroFactura;
	private String tipoFactura;
	private Long codCliente;
	private String nombreCliente;
	private String codigoUnidadNeg;
	private String unidadNegocio;
	private String codigoSucursal;
	private String nombreSucursal;
	private String codigoCompania;
	private String nombreCompania;
	private String fecha;
	private Double subTotal;
	private String moneda;
	private Double tasa;
	private String tipoPago;
	private String estado;
	private Double total;
	private Long codigoVendedor;
	private Double subTotalMonedaExt;
	private Double totalMonedaExt;
	private Double costoTotal;
	private Double descuentoTotal;
	private Long enviadoA;
	
	private String lineaNegocio;
	
	public Long getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(Long numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public String getTipoFactura() {
		return tipoFactura;
	}
	public void setTipoFactura(String tipoFactura) {
		this.tipoFactura = tipoFactura;
	}
	public Long getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(Long codCliente) {
		this.codCliente = codCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getCodigoUnidadNeg() {
		return codigoUnidadNeg;
	}
	public void setCodigoUnidadNeg(String codigoUnidadNeg) {
		this.codigoUnidadNeg = codigoUnidadNeg;
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
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
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Long getCodigoVendedor() {
		return codigoVendedor;
	}
	public void setCodigoVendedor(Long codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	public Double getSubTotalMonedaExt() {
		return subTotalMonedaExt;
	}
	public void setSubTotalMonedaExt(Double subTotalMonedaExt) {
		this.subTotalMonedaExt = subTotalMonedaExt;
	}
	public Double getTotalMonedaExt() {
		return totalMonedaExt;
	}
	public void setTotalMonedaExt(Double totalMonedaExt) {
		this.totalMonedaExt = totalMonedaExt;
	}
	public Double getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(Double costoTotal) {
		this.costoTotal = costoTotal;
	}
	public Double getDescuentoTotal() {
		return descuentoTotal;
	}
	public void setDescuentoTotal(Double descuentoTotal) {
		this.descuentoTotal = descuentoTotal;
	}
	public Long getEnviadoA() {
		return enviadoA;
	}
	public void setEnviadoA(Long enviadoA) {
		this.enviadoA = enviadoA;
	}
	public String getLineaNegocio() {
		return lineaNegocio;
	}
	public void setLineaNegocio(String lineaNegocio) {
		this.lineaNegocio = lineaNegocio;
	}
	
}
