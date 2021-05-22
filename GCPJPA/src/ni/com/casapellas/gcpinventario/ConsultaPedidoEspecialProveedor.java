package ni.com.casapellas.gcpinventario;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Pedido Especial Proveedor (Consulta)")
public class ConsultaPedidoEspecialProveedor {
	@ApiModelProperty(value = "Codigo de Compania", dataType = "String")
	private String codigoCompania;
	@ApiModelProperty(value = "Codigo de la Sucursal", dataType = "String")
	private String codigoSucursal;
	@ApiModelProperty(value = "Codigo del Departamento", dataType = "String")
	private String codigoDepartamento;
	@ApiModelProperty(value = "Codigo de Bodega", dataType = "String")
	private String codigoBodega;
	@ApiModelProperty(value = "Numero de Pedido", dataType = "Number")
	private BigDecimal numeroPedido;
	@ApiModelProperty(value = "Fecha del Pedido", dataType = "String")
	private String fecha;
	@ApiModelProperty(value = "Numero de Orden", dataType = "Number")
	private BigDecimal numeroOrden;
	@ApiModelProperty(value = "Codigo corto del vendedor", dataType = "String")
	private String codigoVendedor;
	@ApiModelProperty(value = "Codigo del Cliente", dataType = "Number")
	private BigDecimal codigoCliente;
	@ApiModelProperty(value = "Nombre del Cliente", dataType = "String")
	private String nombreCliente;
	@ApiModelProperty(value = "Motivo de generacion del pedido", dataType = "String")
	private String motivo;
	@ApiModelProperty(value = "Forma de Pago", dataType = "String")
	private String formaPago;
	@ApiModelProperty(value = "Modalidad de Entrega", dataType = "String")
	private String modalidadEntrega;
	@ApiModelProperty(value = "Numero de Proforma", dataType = "Number")
	private BigDecimal numeroProforma;
	@ApiModelProperty(value = "Tipo de Transporte", dataType = "String")
	private String tipoTransporte;
	/**
	 * @return the codigoCompania
	 */
	public String getCodigoCompania() {
		return codigoCompania;
	}
	/**
	 * @return the codigoSucursal
	 */
	public String getCodigoSucursal() {
		return codigoSucursal;
	}
	/**
	 * @return the codigoDepartamento
	 */
	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}
	/**
	 * @return the codigoBodega
	 */
	public String getCodigoBodega() {
		return codigoBodega;
	}
	/**
	 * @return the numeroPedido
	 */
	public BigDecimal getNumeroPedido() {
		return numeroPedido;
	}
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @return the numeroOrden
	 */
	public BigDecimal getNumeroOrden() {
		return numeroOrden;
	}
	/**
	 * @return the codigoVendedor
	 */
	public String getCodigoVendedor() {
		return codigoVendedor;
	}
	/**
	 * @return the codigoCliente
	 */
	public BigDecimal getCodigoCliente() {
		return codigoCliente;
	}
	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}
	/**
	 * @return the motivo
	 */
	public String getMotivo() {
		return motivo;
	}
	/**
	 * @return the formaPago
	 */
	public String getFormaPago() {
		return formaPago;
	}
	/**
	 * @return the modalidadEntrega
	 */
	public String getModalidadEntrega() {
		return modalidadEntrega;
	}
	/**
	 * @return the numeroProforma
	 */
	public BigDecimal getNumeroProforma() {
		return numeroProforma;
	}
	/**
	 * @return the tipoTransporte
	 */
	public String getTipoTransporte() {
		return tipoTransporte;
	}
	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	/**
	 * @param codigoSucursal the codigoSucursal to set
	 */
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}
	/**
	 * @param codigoDepartamento the codigoDepartamento to set
	 */
	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}
	/**
	 * @param codigoBodega the codigoBodega to set
	 */
	public void setCodigoBodega(String codigoBodega) {
		this.codigoBodega = codigoBodega;
	}
	/**
	 * @param numeroPedido the numeroPedido to set
	 */
	public void setNumeroPedido(BigDecimal numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @param numeroOrden the numeroOrden to set
	 */
	public void setNumeroOrden(BigDecimal numeroOrden) {
		this.numeroOrden = numeroOrden;
	}
	/**
	 * @param codigoVendedor the codigoVendedor to set
	 */
	public void setCodigoVendedor(String codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	/**
	 * @param codigoCliente the codigoCliente to set
	 */
	public void setCodigoCliente(BigDecimal codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	/**
	 * @param formaPago the formaPago to set
	 */
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	/**
	 * @param modalidadEntrega the modalidadEntrega to set
	 */
	public void setModalidadEntrega(String modalidadEntrega) {
		this.modalidadEntrega = modalidadEntrega;
	}
	/**
	 * @param numeroProforma the numeroProforma to set
	 */
	public void setNumeroProforma(BigDecimal numeroProforma) {
		this.numeroProforma = numeroProforma;
	}
	/**
	 * @param tipoTransporte the tipoTransporte to set
	 */
	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}
}
