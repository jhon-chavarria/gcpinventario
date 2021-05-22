package ni.com.casapellas.gcpinventario;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Pedido Contact Center (Consulta)")
public class ConsultaPedidoCallCenter {
	@ApiModelProperty(value = "Codigo de Compania", dataType = "String")
	private String codigoCompania;
	@ApiModelProperty(value = "Codigo de Sucursal", dataType = "String")
	private String codigoSucursal;
	@ApiModelProperty(value = "Numero de Pedido", dataType = "Number")
	private BigDecimal numeroPedido;
	@ApiModelProperty(value = "Numero de Proforma", dataType = "Number")
	private BigDecimal numeroProforma;
	@ApiModelProperty(value = "Fecha del pedido", dataType = "String")
	private String fecha;
	@ApiModelProperty(value = "Codigo de Bodega", dataType = "String")
	private String codigoBodega;
	@ApiModelProperty(value = "Codigo de Cliente", dataType = "Number")
	private BigDecimal codigoCliente;
	@ApiModelProperty(value = "Nombre de Cliente", dataType = "String")
	private String nombreCliente;
	@ApiModelProperty(value = "Direccion del Cliente", dataType = "String")
	private String direccion;
	@ApiModelProperty(value = "Codigo corto del vendedor", dataType = "String")
	private String codigoVendedor;
	@ApiModelProperty(value = "Condicion de Pago", dataType = "String")
	private String condicionPago;
	@ApiModelProperty(value = "Observaciones", dataType = "String")
	private String observaciones;
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
	 * @return the numeroPedido
	 */
	public BigDecimal getNumeroPedido() {
		return numeroPedido;
	}
	/**
	 * @param numeroPedido the numeroPedido to set
	 */
	public void setNumeroPedido(BigDecimal numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	/**
	 * @return the numeroProforma
	 */
	public BigDecimal getNumeroProforma() {
		return numeroProforma;
	}
	/**
	 * @param numeroProforma the numeroProforma to set
	 */
	public void setNumeroProforma(BigDecimal numeroProforma) {
		this.numeroProforma = numeroProforma;
	}
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
	 * @return the codigoCliente
	 */
	public BigDecimal getCodigoCliente() {
		return codigoCliente;
	}
	/**
	 * @param codigoCliente the codigoCliente to set
	 */
	public void setCodigoCliente(BigDecimal codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}
	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the codigoVendedor
	 */
	public String getCodigoVendedor() {
		return codigoVendedor;
	}
	/**
	 * @param codigoVendedor the codigoVendedor to set
	 */
	public void setCodigoVendedor(String codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	/**
	 * @return the condicionPago
	 */
	public String getCondicionPago() {
		return condicionPago;
	}
	/**
	 * @param condicionPago the condicionPago to set
	 */
	public void setCondicionPago(String condicionPago) {
		this.condicionPago = condicionPago;
	}
	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
