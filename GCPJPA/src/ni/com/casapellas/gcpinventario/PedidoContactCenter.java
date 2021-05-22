package ni.com.casapellas.gcpinventario;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ni.com.casapellas.util.CustomValidationMessage;
import ni.com.casapellas.util.ValidCurrency;
import ni.com.casapellas.util.ValidDate;
import ni.com.casapellas.util.ValidPaymentCondition;
import ni.com.casapellas.util.ValidPositiveDecimal;
import ni.com.casapellas.util.ValidTax;

@ApiModel(value = "Pedido Contact Center (Cabecera)")
public class PedidoContactCenter {

	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = CustomValidationMessage.COMPANIA_REQUERIDA)
	@ApiModelProperty(name = "codigoCompania", required = true, value = "Codigo de la Compania", example = "00", dataType = "String")
	private String codigoCompania;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = CustomValidationMessage.SUCURSAL_REQUERIDA)
	@ApiModelProperty(name = "codigoSucursal", required = true, value = "Codigo de la sucursal", example = "00", dataType = "String")
	private String codigoSucursal;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = CustomValidationMessage.DEPARTAMENTO_REQUERIDO)
	@ApiModelProperty(name = "codigoDepartamento", required = true, value = "Codigo del departamento o linea", example = "01", dataType = "String")
	private String codigoDepartamento;
	
	@ApiModelProperty(name = "numeroProforma", required = false, value = "Numero de Proforma", example = "999999", dataType = "Integer")
	private Integer numeroProforma;

	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "codigoCliente", required = true, value = "Codigo del cliente", example = "2541025", dataType = "Integer")
	private Integer codigoCliente;

	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 3, max = 40, message = "El nombre del cliente debe contener entre 3 y 40 caracteres")
	@ApiModelProperty(name = "nombreCliente", required = true, value = "Nombre del Cliente", example = "Luis Peralta", dataType = "String")
	private String nombreCliente;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 3, max = 60, message = "La direccion del cliente debe contener entre 3 y 60 caracteres")
	@ApiModelProperty(name = "direccionCliente", required = true, value = "Direccion del Cliente", example = "Luis Peralta", dataType = "String")
	private String direccionCliente;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = CustomValidationMessage.CODIGO_VENDEDOR_CORTO_REQUERIDO)
	@ApiModelProperty(name = "codigoVendedorC", required = true, value = "Codigo del vendedor", example = "1A", dataType = "String")
	private String codigoVendedorC;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 2, max = 2, message = "La condicion de pago debe contener dos caracteres maximo")
	@ValidPaymentCondition()
	@ApiModelProperty(name = "condicionPago", required = true, value = "Condicion de Pago", example = "CO", dataType = "String")
	private String condicionPago;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Min(value = 0, message = CustomValidationMessage.CAMPO_POSITIVO)
	@ApiModelProperty(name = "porcentajeImpuesto", required = true, value = "Porcentaje de Impuesto", example = "15", dataType = "Number")
	@ValidTax(taxName = "IVA")
	private Integer porcentajeImpuesto;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ValidDate(message = CustomValidationMessage.FECHA_FORMATO_INVALIDO)
	@ApiModelProperty(name = "fecha", required = true, value = "Fecha", example = "2021-01-01 00:00:00", dataType = "String")
	private String fecha;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	// @Min(value = 1L, message = CustomValidationMessage.CAMPO_POSITIVO)
	@ValidPositiveDecimal(Min = 0.0001)
	@ApiModelProperty(name = "factorCambio", required = true, value = "Factor Cambio", dataType = "Number")
	private BigDecimal factorCambio;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ValidCurrency()
	@ApiModelProperty(name = "moneda", required = true, example = "COR", value = "Moneda de solicitud", dataType = "String")
	private String moneda;

	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 5, max = 10, message = CustomValidationMessage.CODIGO_USUARIO_REQUERIDO)
	@ApiModelProperty(name = "usuario", required = true, example = "prueba", value = "Usuario que genero el pedido", dataType = "String")
	private String usuario;
	
	@NotNull(message = CustomValidationMessage.LISTA_NONULO)
	@Valid
	@ApiModelProperty(name = "detalle", required = true, value = "Detalle del pedido")
	private List<PedidoContactCenterDetail> detalle;
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
	 * @return the codigoDepartamento
	 */
	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}
	/**
	 * @param codigoDepartamento the codigoDepartamento to set
	 */
	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}
	/**
	 * @return the numeroProforma
	 */
	public Integer getNumeroProforma() {
		return numeroProforma;
	}
	/**
	 * @param numeroProforma the numeroProforma to set
	 */
	public void setNumeroProforma(Integer numeroProforma) {
		this.numeroProforma = numeroProforma;
	}
	/**
	 * @return the codigoCliente
	 */
	public Integer getCodigoCliente() {
		return codigoCliente;
	}
	/**
	 * @param codigoCliente the codigoCliente to set
	 */
	public void setCodigoCliente(Integer codigoCliente) {
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
	 * @return the direccionCliente
	 */
	public String getDireccionCliente() {
		return direccionCliente;
	}
	/**
	 * @param direccionCliente the direccionCliente to set
	 */
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	/**
	 * @return the codigoVendedorC
	 */
	public String getCodigoVendedorC() {
		return codigoVendedorC;
	}
	/**
	 * @param codigoVendedorC the codigoVendedorC to set
	 */
	public void setCodigoVendedorC(String codigoVendedorC) {
		this.codigoVendedorC = codigoVendedorC;
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
	 * @return the porcentajeImpuesto
	 */
	public Integer getPorcentajeImpuesto() {
		return porcentajeImpuesto;
	}
	/**
	 * @param porcentajeImpuesto the porcentajeImpuesto to set
	 */
	public void setPorcentajeImpuesto(Integer porcentajeImpuesto) {
		this.porcentajeImpuesto = porcentajeImpuesto;
	}
	/**
	 * @return the detalle
	 */
	public List<PedidoContactCenterDetail> getDetalle() {
		return detalle;
	}
	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<PedidoContactCenterDetail> detalle) {
		this.detalle = detalle;
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
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the factorCambio
	 */
	public BigDecimal getFactorCambio() {
		return factorCambio;
	}
	/**
	 * @param factorCambio the factorCambio to set
	 */
	public void setFactorCambio(BigDecimal factorCambio) {
		this.factorCambio = factorCambio;
	}
	/**
	 * @return the moneda
	 */
	public String getMoneda() {
		return moneda;
	}
	/**
	 * @param moneda the moneda to set
	 */
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	/**
	 * 
	 */
	public PedidoContactCenter() {
		// TODO Auto-generated constructor stub
	}
}
