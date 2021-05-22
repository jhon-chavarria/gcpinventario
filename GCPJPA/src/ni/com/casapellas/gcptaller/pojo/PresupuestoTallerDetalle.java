package ni.com.casapellas.gcptaller.pojo;

import java.math.BigDecimal;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Api(value = "Presupuesto (Detalle)")
public class PresupuestoTallerDetalle {
	@ApiModelProperty(value = "Fecha", dataType = "String", example = "01-01-0001")
	private String fecha;
	
	@ApiModelProperty(value = "Codigo del Elemento", dataType = "String", example = "12")
	private String codigoElemento;
	
	@ApiModelProperty(value = "Descripcion del elemento", dataType = "String", example = "")
	private String descripcion;
	
	@ApiModelProperty(value = "Tipo de elemento", dataType = "String", example = "M")
	private String tipoElemento;
	
	@ApiModelProperty(value = "Numero de horas asociadas", dataType = "Number", example = "25")
	private BigDecimal horas;
	
	@ApiModelProperty(value = "Cantidad", dataType = "Number", example = "12")
	private BigDecimal cantidad;
	
	@ApiModelProperty(value = "Valor", dataType = "Number", example = "25.23")
	private BigDecimal valor;
	
	@ApiModelProperty(value = "Valor del descuento", dataType = "Number", example = "25.23")
	private BigDecimal descuento;
	
	@ApiModelProperty(value = "Valor de actividad alterno", dataType = "Number", example = "25.23")
	private BigDecimal valorAlterno;
	
	@ApiModelProperty(value = "Tipo de Linea", dataType = "String", example = "E")
	private String tipoLinea;
	
	@ApiModelProperty(value = "Descripcion Adicional", dataType = "String", example = "")
	private String descripcionAdicional;
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the codigoElemento
	 */
	public String getCodigoElemento() {
		return codigoElemento;
	}
	/**
	 * @param codigoElemento the codigoElemento to set
	 */
	public void setCodigoElemento(String codigoElemento) {
		this.codigoElemento = codigoElemento;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the tipoElemento
	 */
	public String getTipoElemento() {
		return tipoElemento;
	}
	/**
	 * @param tipoElemento the tipoElemento to set
	 */
	public void setTipoElemento(String tipoElemento) {
		this.tipoElemento = tipoElemento;
	}
	/**
	 * @return the horas
	 */
	public BigDecimal getHoras() {
		return horas;
	}
	/**
	 * @param horas the horas to set
	 */
	public void setHoras(BigDecimal horas) {
		this.horas = horas;
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
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	/**
	 * @return the descuento
	 */
	public BigDecimal getDescuento() {
		return descuento;
	}
	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}
	/**
	 * @return the valorTotal
	 */
	public BigDecimal getValorAlterno() {
		return valorAlterno;
	}
	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorAlterno(BigDecimal valorAlterno) {
		this.valorAlterno = valorAlterno;
	}
	/**
	 * @return the tipoLinea
	 */
	public String getTipoLinea() {
		return tipoLinea;
	}
	/**
	 * @param tipoLinea the tipoLinea to set
	 */
	public void setTipoLinea(String tipoLinea) {
		this.tipoLinea = tipoLinea;
	}
	/**
	 * @return the descripcionAdicional
	 */
	public String getDescripcionAdicional() {
		return descripcionAdicional;
	}
	/**
	 * @param descripcionAdicional the descripcionAdicional to set
	 */
	public void setDescripcionAdicional(String descripcionAdicional) {
		this.descripcionAdicional = descripcionAdicional;
	}
}
