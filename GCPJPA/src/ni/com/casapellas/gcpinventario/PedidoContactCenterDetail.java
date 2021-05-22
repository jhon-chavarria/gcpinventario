package ni.com.casapellas.gcpinventario;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ni.com.casapellas.util.CustomValidationMessage;
import ni.com.casapellas.util.ValidPositiveDecimal;

@ApiModel(value = "Pedido Contact Center (Detalle)")
public class PedidoContactCenterDetail {

	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = CustomValidationMessage.LINEA_REQUERIDO)
	@ApiModelProperty(name = "codigoLinea", required = true, value = "Codigo de la linea", example = "01", dataType = "String")
	private String codigoLinea;

	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = CustomValidationMessage.BODEGA_REQUERIDO)
	@ApiModelProperty(name = "codigoBodega", required = true, value = "Codigo de la Bodega", example = "01", dataType = "String")
	private String codigoBodega;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = CustomValidationMessage.ARTICULO_REQUERIDO)
	@ApiModelProperty(name = "codigoArticulo", required = true, example = "01A12546", value = "Codigo del Articulo", dataType = "String")
	private String codigoArticulo;

	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Min(value = 1, message = CustomValidationMessage.CANTIDAD_REQUERIDO)
	@ApiModelProperty(name = "cantidad", required = true, example = "1", value = "Cantidad", dataType = "Number")
	private Integer cantidad;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ValidPositiveDecimal(Min = 0.1)
	@ApiModelProperty(name = "precio", required = true, example = "1.25", value = "Precio del articulo", dataType = "Number")
	private double precio;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ValidPositiveDecimal(Min = 0)
	@ApiModelProperty(name = "descuento", required = true, example = "5", value = "Descuento otorgado", dataType = "Number")
	private double descuento;
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
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	/**
	 * @return the descuento
	 */
	public double getDescuento() {
		return descuento;
	}
	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	/**
	 * 
	 */
	public PedidoContactCenterDetail() {
		// TODO Auto-generated constructor stub
	}
	
}
