package ni.com.casapellas.gcpquiosco.pojo;

/**
 * 
 * Descripcion de DetalleDocumentoQuiosco.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Dec 5, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class DetalleDocumentoQuiosco {
	private String codigoSucursal;
	private String codigoUnidadNegocio;
	private Long numeroDocumento;
	private String tipoDocumento;
	private String codigoItem;
	private String descripcionItem;
	private Double valorItem;
	private Double cantidad;
	private Double subTotal;
	private Double impuesto;
	private Double Total;
	
	private Long codigoCliente;
	private Double principal;
	private Double interes;
	private Double mora;
	private String fechaPago;
	private String codigoCompania;
	
	private Double montoPendiente;
	private Double montoCuota;
	
	public Double getMontoPendiente() {
		return montoPendiente;
	}
	public void setMontoPendiente(Double montoPendiente) {
		this.montoPendiente = montoPendiente;
	}
	public Double getMontoCuota() {
		return montoCuota;
	}
	public void setMontoCuota(Double montoCuota) {
		this.montoCuota = montoCuota;
	}
	public String getCodigoSucursal() {
		return codigoSucursal;
	}
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}
	public String getCodigoUnidadNegocio() {
		return codigoUnidadNegocio;
	}
	public void setCodigoUnidadNegocio(String codigoUnidadNegocio) {
		this.codigoUnidadNegocio = codigoUnidadNegocio;
	}
	public Long getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
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
	public Double getValorItem() {
		return valorItem;
	}
	public void setValorItem(Double valorItem) {
		this.valorItem = valorItem;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
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
	public Double getTotal() {
		return Total;
	}
	public void setTotal(Double total) {
		Total = total;
	}
	public Long getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
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
	public Double getMora() {
		return mora;
	}
	public void setMora(Double mora) {
		this.mora = mora;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
}
