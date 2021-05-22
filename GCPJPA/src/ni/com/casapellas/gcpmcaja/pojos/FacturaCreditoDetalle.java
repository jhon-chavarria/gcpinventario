package ni.com.casapellas.gcpmcaja.pojos;

/**
 * 
 * Descripcion de FacturaCreditoDetalle.java
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
public class FacturaCreditoDetalle {
	private long numeroFactura;
	private String tipoFactura;
	private String codigoItem;
	private String DescripcionItem;
	private Double precioUnitario;
	private Double Cantidad; 
	private String impuesto;
	private Double factor;
	private String codigoUnidadNegocio;
	private String codigoSucursal;
	private String moneda;
	
	private Double valorImpuesto;
	
	public long getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(long numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public String getTipoFactura() {
		return tipoFactura;
	}
	public void setTipoFactura(String tipoFactura) {
		this.tipoFactura = tipoFactura;
	}
	public String getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}
	public String getDescripcionItem() {
		return DescripcionItem;
	}
	public void setDescripcionItem(String descripcionItem) {
		DescripcionItem = descripcionItem;
	}
	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public Double getCantidad() {
		return Cantidad;
	}
	public void setCantidad(Double cantidad) {
		Cantidad = cantidad;
	}
	public String getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}
	public Double getFactor() {
		return factor;
	}
	public void setFactor(Double factor) {
		this.factor = factor;
	}
	public String getCodigoUnidadNegocio() {
		return codigoUnidadNegocio;
	}
	public void setCodigoUnidadNegocio(String codigoUnidadNegocio) {
		this.codigoUnidadNegocio = codigoUnidadNegocio;
	}
	public String getCodigoSucursal() {
		return codigoSucursal;
	}
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}
	public Double getValorImpuesto() {
		return valorImpuesto;
	}
	public void setValorImpuesto(Double valorImpuesto) {
		this.valorImpuesto = valorImpuesto;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
}
