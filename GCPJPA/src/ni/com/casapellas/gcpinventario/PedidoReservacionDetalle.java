package ni.com.casapellas.gcpinventario;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ni.com.casapellas.util.CustomValidationMessage;

@ApiModel(value = "Perdido Reservacion (Detalle)")
public class PedidoReservacionDetalle {
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = CustomValidationMessage.BODEGA_REQUERIDO)
	@ApiModelProperty(name = "codigoBodega", required = true, value = "Codigo de la Bodega", example = "00", dataType = "String")
	private String codigoBodega;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = CustomValidationMessage.LINEA_REQUERIDO)
	@ApiModelProperty(name = "codigoLinea", required = true, value = "Codigo de linea", example = "00", dataType = "String")
	private String codigoLinea;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = CustomValidationMessage.ARTICULO_REQUERIDO)
	@ApiModelProperty(name = "codigoArticulo", required = true, value = "Codigo del Articulo", example = "000001B", dataType = "String")
	private String codigoArticulo;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Min(value = 1, message = CustomValidationMessage.CANTIDAD_REQUERIDO)
	@ApiModelProperty(name = "cantidad", required = true, value = "Cantidad a reservar", example = "2", dataType = "String")
	private BigDecimal cantidad;
	/**
	 * @return the codigoBodega
	 */
	public String getCodigoBodega() {
		return codigoBodega;
	}
	/**
	 * @return the codigoLinea
	 */
	public String getCodigoLinea() {
		return codigoLinea;
	}
	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	/**
	 * @return the cantidad
	 */
	public BigDecimal getCantidad() {
		return cantidad;
	}
	/**
	 * @param codigoBodega the codigoBodega to set
	 */
	public void setCodigoBodega(String codigoBodega) {
		this.codigoBodega = codigoBodega;
	}
	/**
	 * @param codigoLinea the codigoLinea to set
	 */
	public void setCodigoLinea(String codigoLinea) {
		this.codigoLinea = codigoLinea;
	}
	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * 
	 */
	public PedidoReservacionDetalle() {
		// TODO Auto-generated constructor stub
	}
}
