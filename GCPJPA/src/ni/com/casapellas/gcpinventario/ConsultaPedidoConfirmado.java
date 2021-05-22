package ni.com.casapellas.gcpinventario;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Pedido Confirmado")
public class ConsultaPedidoConfirmado {
	
	@ApiModelProperty(name = "codigoCompania", value = "Codigo de la Compania", dataType = "String")
	private String codigoCompania;
	
	@ApiModelProperty(name = "nombreCompania", value = "Nombre de la Compania", dataType = "String")
	private String nombreCompania;
	
	@ApiModelProperty(name = "codigoSucursal", value = "Codigo de la Sucursal", dataType = "String")
	private String codigoSucursal;
	
	@ApiModelProperty(name = "nombreSucursal", value = "Nombre de la Sucursal", dataType = "String")
	private String nombreSucursal;
	
	@ApiModelProperty(name = "codigoDepartamento", value = "Codigo del departamento", dataType = "String")
	private String codigoDepartamento;
	
	@ApiModelProperty(name = "nombreDepartamento", value = "Nombre del departamento", dataType = "String")
	private String nombreDepartamento;
	
	@ApiModelProperty(name = "codigoBodega", value = "Codigo de la bodega", dataType = "String")
	private String codigoBodega;
	
	@ApiModelProperty(name = "noDocumento", value = "Numero de documento", dataType = "Number")
	private BigDecimal noDocumento;
	
	@ApiModelProperty(name = "noPedido", value = "Numero de pedido", dataType = "Number")
	private BigDecimal noPedido;
	
	@ApiModelProperty(name = "codigoCaja", value = "Codigo de Caja", dataType = "String")
	private String codigoCaja;
	
	@ApiModelProperty(name = "codigoCategoria", value = "Codigo de Categoria", dataType = "String")
	private String codigoCategoria;
	
	@ApiModelProperty(name = "fechaLlegada", value = "Fecha de llegada", dataType = "String")
	private String fechaLlegada;
	
	@ApiModelProperty(name = "codigoArticulo", value = "Codigo del Articulo", dataType = "String")
	private String codigoArticulo;
	
	@ApiModelProperty(name = "nombreArticulo", value = "Nombre del Articulo", dataType = "String")
	private String nombreArticulo;
	
	@ApiModelProperty(name = "cantidad", value = "Cantidad solicitada", dataType = "Number")
	private BigDecimal cantidad;
	/**
	 * @return the codigoCompania
	 */
	public String getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @return the nombreCompania
	 */
	public String getNombreCompania() {
		return nombreCompania;
	}

	/**
	 * @return the codigoSucursal
	 */
	public String getCodigoSucursal() {
		return codigoSucursal;
	}

	/**
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * @return the codigoDepartamento
	 */
	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}

	/**
	 * @return the nombreDepartamento
	 */
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	/**
	 * @return the codigoBodega
	 */
	public String getCodigoBodega() {
		return codigoBodega;
	}

	/**
	 * @return the noDocumento
	 */
	public BigDecimal getNoDocumento() {
		return noDocumento;
	}

	/**
	 * @return the noPedido
	 */
	public BigDecimal getNoPedido() {
		return noPedido;
	}

	/**
	 * @return the codigoCaja
	 */
	public String getCodigoCaja() {
		return codigoCaja;
	}

	/**
	 * @return the codigoCategoria
	 */
	public String getCodigoCategoria() {
		return codigoCategoria;
	}

	/**
	 * @return the fechaLlegada
	 */
	public String getFechaLlegada() {
		return fechaLlegada;
	}

	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @return the nombreArticulo
	 */
	public String getNombreArticulo() {
		return nombreArticulo;
	}

	/**
	 * @return the cantidad
	 */
	public BigDecimal getCantidad() {
		return cantidad;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @param nombreCompania the nombreCompania to set
	 */
	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	/**
	 * @param codigoSucursal the codigoSucursal to set
	 */
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}

	/**
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * @param codigoDepartamento the codigoDepartamento to set
	 */
	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	/**
	 * @param nombreDepartamento the nombreDepartamento to set
	 */
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	/**
	 * @param codigoBodega the codigoBodega to set
	 */
	public void setCodigoBodega(String codigoBodega) {
		this.codigoBodega = codigoBodega;
	}

	/**
	 * @param noDocumento the noDocumento to set
	 */
	public void setNoDocumento(BigDecimal noDocumento) {
		this.noDocumento = noDocumento;
	}

	/**
	 * @param noPedido the noPedido to set
	 */
	public void setNoPedido(BigDecimal noPedido) {
		this.noPedido = noPedido;
	}

	/**
	 * @param codigoCaja the codigoCaja to set
	 */
	public void setCodigoCaja(String codigoCaja) {
		this.codigoCaja = codigoCaja;
	}

	/**
	 * @param codigoCategoria the codigoCategoria to set
	 */
	public void setCodigoCategoria(String codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	/**
	 * @param fechaLlegada the fechaLlegada to set
	 */
	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/**
	 * @param nombreArticulo the nombreArticulo to set
	 */
	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public ConsultaPedidoConfirmado() {
		// TODO Auto-generated constructor stub
	}
}
