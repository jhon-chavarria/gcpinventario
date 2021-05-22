package ni.com.casapellas.gcpinventario;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Vista Existencia Producto")
public class ProductExistence {
	@ApiModelProperty(name = "codigoCompania", value = "Codigo de la Compania", dataType = "String")
	private String codigoCompania; 
	
	@ApiModelProperty(name = "codigoSucursal", value = "Codigo de la Sucursal", dataType = "String")
	private String codigoSucursal; 
	
	@ApiModelProperty(name = "codigoBodega", value = "Codigo de la Bodega", dataType = "String")
	private String codigoBodega;
	
	@ApiModelProperty(name = "tipoBodega", value = "Tipo de Bodega", dataType = "String")
	private String tipoBodega;
	
	@ApiModelProperty(name = "codigoLinea", value = "Codigo de la linea del producto", dataType = "String")
	private String codigoLinea; 
	
	@ApiModelProperty(name = "codigoArticulo", value = "Codigo del Producto", dataType = "String")
	private String codigoArticulo; 
	
	@ApiModelProperty(name = "descripcionArticulo", value = "Descripcion del producto", dataType = "String")
	private String descripcionArticulo;
	
	@ApiModelProperty(name = "cantidadDisponible", value = "Existencia del producto", dataType = "Number")
	private BigDecimal cantidadDisponible; 
	
	@ApiModelProperty(name = "ubicacion", value = "Ubicacion del producto", dataType = "String")
	private String ubicacion;
	
	@ApiModelProperty(name = "productoRelacionado", value = "Lista de productos relacionados")
	private List<ProductoRelacionados> productoRelacionado;

	/**
	 * @return the codigoCompania
	 */
	public String getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoSucursal
	 */
	public String getCodigoSucursal() {
		return codigoSucursal;
	}

	/**
	 * @param codigoSucursal the codigoSucursal to set
	 */
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
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
	 * @return the tipoBodega
	 */
	public String getTipoBodega() {
		return tipoBodega;
	}

	/**
	 * @param tipoBodega the tipoBodega to set
	 */
	public void setTipoBodega(String tipoBodega) {
		this.tipoBodega = tipoBodega;
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
	 * @return the descripcionArticulo
	 */
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	/**
	 * @param descripcionArticulo the descripcionArticulo to set
	 */
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	/**
	 * @return the cantidadDisponible
	 */
	public BigDecimal getCantidadDisponible() {
		return cantidadDisponible;
	}

	/**
	 * @param cantidadDisponible the cantidadDisponible to set
	 */
	public void setCantidadDisponible(BigDecimal cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the productoRelacionado
	 */
	public List<ProductoRelacionados> getProductoRelacionado() {
		return productoRelacionado;
	}

	/**
	 * @param productoRelacionado the productoRelacionado to set
	 */
	public void setProductoRelacionado(List<ProductoRelacionados> productoRelacionado) {
		this.productoRelacionado = productoRelacionado;
	}
	
}
