package ni.com.casapellas.gcpinventario;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Productos Relacionados")
public class ProductoRelacionados {
	
	@ApiModelProperty(name = "codigoLinea", value = "Codigo de Linea", dataType = "String")
	private String codigoLinea;
	
	@ApiModelProperty(name = "codigoArticulo", value = "Codigo del Articulo", dataType = "String")
	private String codigoArticulo;
	
	@ApiModelProperty(name = "descripcionCorta", value = "Descripcion corta del Articulo", dataType = "String")
	private String descripcionCorta;
	
	@ApiModelProperty(name = "descripcionLarga", value = "Descripcion larga del Articulo", dataType = "String")
	private String descripcionLarga;
	
	@ApiModelProperty(name = "existencia", value = "Disponibilidad del producto", dataType = "Number")
	private BigDecimal existencia;
	
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
	 * @return the descripcionCorta
	 */
	public String getDescripcionCorta() {
		return descripcionCorta;
	}
	/**
	 * @param descripcionCorta the descripcionCorta to set
	 */
	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}
	/**
	 * @return the descripcionLarga
	 */
	public String getDescripcionLarga() {
		return descripcionLarga;
	}
	/**
	 * @param descripcionLarga the descripcionLarga to set
	 */
	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}
	/**
	 * @return the existencia
	 */
	public BigDecimal getExistencia() {
		return existencia;
	}
	/**
	 * @param existencia the existencia to set
	 */
	public void setExistencia(BigDecimal existencia) {
		this.existencia = existencia;
	}
}
