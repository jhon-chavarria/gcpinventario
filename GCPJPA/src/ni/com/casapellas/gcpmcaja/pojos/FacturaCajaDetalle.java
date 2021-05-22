package ni.com.casapellas.gcpmcaja.pojos;

/**
 * 
 * Descripcion de FacturaCajaDetalle.java
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
public class FacturaCajaDetalle {
	private Long numeroFactura;
	private String tipoFactura;
	private String codigoItem;
	private String descripcionItem;
	private Double precioUnitario;
	private Double cantidad;
	private String impuesto;
	private Integer factor;
	private Double costo;
	private Long codigoCliente;
	
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
	public String getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}
	public String getDescripcionItem() {
		return descripcionItem;
	}
	public void setDescripcionItem(String descripcionItem) {
		this.descripcionItem = descripcionItem;
	}
	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public String getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}
	public Integer getFactor() {
		return factor;
	}
	public void setFactor(Integer factor) {
		this.factor = factor;
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	public Long getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
}
