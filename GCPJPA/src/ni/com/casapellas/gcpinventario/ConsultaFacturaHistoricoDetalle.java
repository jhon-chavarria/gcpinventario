package ni.com.casapellas.gcpinventario;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Factura Historico(Detalle)")
public class ConsultaFacturaHistoricoDetalle {
	
	@ApiModelProperty(name = "codigoBodega", value = "Codigo de la Bodega", dataType = "String")
	private String codigoBodega;
	
	@ApiModelProperty(name = "codigoLinea", value = "Codigo de la Linea", dataType = "String")
	private String codigoLinea;
	
	@ApiModelProperty(name = "secuencia", value = "Secuencia de item", dataType = "Number")
	private BigDecimal secuencia;
	
	@ApiModelProperty(name = "codigoArticulo", value = "Codigo del Articulo", dataType = "String")
	private String codigoArticulo;
	
	@ApiModelProperty(name = "codigoCategoria", value = "Codigo de la Categoria", dataType = "String")
	private String codigoCategoria;
	
	@ApiModelProperty(name = "cantidad", value = "Cantidad Factura", dataType = "Number")
	private BigDecimal cantidad;
	
	@ApiModelProperty(name = "cantidadDevuelta", value = "Cantidad Devuelta", dataType = "Number")
	private BigDecimal cantidadDevuelta;

	@ApiModelProperty(name = "precioUnitarioL", value = "Precio en moneda local", dataType = "Number")
	private BigDecimal precioUnitarioL;
	
	@ApiModelProperty(name = "precioUnitarioF", value = "Precio en moneda foranea", dataType = "Number")
	private BigDecimal precioUnitarioF;
	
	@ApiModelProperty(name = "porcentajeImpVenta", value = "Porcentaje del impuesto sobre la venta", dataType = "Number")
	private BigDecimal porcentajeImpVenta;
	
	@ApiModelProperty(name = "porcentajeImpIsc", value = "Porcentaje del ISC", dataType = "Number")
	private BigDecimal porcentajeImpIsc;
	
	@ApiModelProperty(name = "porcentajeDescuento", value = "Porcentaje de descuento", dataType = "Number")
	private BigDecimal porcentajeDescuento;
	
	@ApiModelProperty(name = "costoUnitario", value = "Costo del producto", dataType = "Number")
	private BigDecimal costoUnitario;
	
	/**
	 * @return the codigoBodega
	 */
	public String getCodigoBodega() {
		return codigoBodega;
	}
	
	/**
	 * @param codigoBodega the codigoBodega to set
	 */
	public void setCodigoBodega(String codigoBodega) {
		this.codigoBodega = codigoBodega;
	}
	/**
	 * @return the codigoLinea
	 */
	public String getCodigoLinea() {
		return codigoLinea;
	}
	/**
	 * @param codigoLinea the codigoLinea to set
	 */
	public void setCodigoLinea(String codigoLinea) {
		this.codigoLinea = codigoLinea;
	}
	/**
	 * @return the secuencia
	 */
	public BigDecimal getSecuencia() {
		return secuencia;
	}

	/**
	 * @param secuencia the secuencia to set
	 */
	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	/**
	 * @return the codigoCategoria
	 */
	public String getCodigoCategoria() {
		return codigoCategoria;
	}
	/**
	 * @param codigoCategoria the codigoCategoria to set
	 */
	public void setCodigoCategoria(String codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}
	/**
	 * @return the cantidad
	 */
	public BigDecimal getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the cantidadDevuelta
	 */
	public BigDecimal getCantidadDevuelta() {
		return cantidadDevuelta;
	}
	/**
	 * @param cantidadDevuelta the cantidadDevuelta to set
	 */
	public void setCantidadDevuelta(BigDecimal cantidadDevuelta) {
		this.cantidadDevuelta = cantidadDevuelta;
	}
	/**
	 * @return the precioUnitarioL
	 */
	public BigDecimal getPrecioUnitarioL() {
		return precioUnitarioL;
	}
	/**
	 * @param precioUnitarioL the precioUnitarioL to set
	 */
	public void setPrecioUnitarioL(BigDecimal precioUnitarioL) {
		this.precioUnitarioL = precioUnitarioL;
	}
	/**
	 * @return the precioUnitarioF
	 */
	public BigDecimal getPrecioUnitarioF() {
		return precioUnitarioF;
	}
	/**
	 * @param precioUnitarioF the precioUnitarioF to set
	 */
	public void setPrecioUnitarioF(BigDecimal precioUnitarioF) {
		this.precioUnitarioF = precioUnitarioF;
	}
	/**
	 * @return the porcentajeImpVenta
	 */
	public BigDecimal getPorcentajeImpVenta() {
		return porcentajeImpVenta;
	}
	/**
	 * @param porcentajeImpVenta the porcentajeImpVenta to set
	 */
	public void setPorcentajeImpVenta(BigDecimal porcentajeImpVenta) {
		this.porcentajeImpVenta = porcentajeImpVenta;
	}
	/**
	 * @return the porcentajeImpIsc
	 */
	public BigDecimal getPorcentajeImpIsc() {
		return porcentajeImpIsc;
	}
	/**
	 * @param porcentajeImpIsc the porcentajeImpIsc to set
	 */
	public void setPorcentajeImpIsc(BigDecimal porcentajeImpIsc) {
		this.porcentajeImpIsc = porcentajeImpIsc;
	}
	/**
	 * @return the porcentajeDescuento
	 */
	public BigDecimal getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	/**
	 * @param porcentajeDescuento the porcentajeDescuento to set
	 */
	public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	/**
	 * @return the costoUnitario
	 */
	public BigDecimal getCostoUnitario() {
		return costoUnitario;
	}
	/**
	 * @param costoUnitario the costoUnitario to set
	 */
	public void setCostoUnitario(BigDecimal costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	/**
	 * 
	 */
	public ConsultaFacturaHistoricoDetalle() {
		// TODO Auto-generated constructor stub
	}
}
