package ni.com.casapellas.gcpinventario;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ni.com.casapellas.util.CustomValidationMessage;
import ni.com.casapellas.util.ValidDate;

@ApiModel(value = "Pedido Especial Proveedor (Cabecera)")
public class PedidoEspecialProveedor {
	
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
	@ApiModelProperty(name = "codigoDepartamento", required = true, value = "Codigo de departamento", example = "00", dataType = "String")
	private String codigoDepartamento;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ValidDate(message = CustomValidationMessage.FECHA_FORMATO_INVALIDO)
	@ApiModelProperty(name = "fecha", required = true, value = "Fecha", example = "2021-01-01 00:00:00", dataType = "String")
	private String fecha;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = CustomValidationMessage.CODIGO_VENDEDOR_CORTO_REQUERIDO)
	@ApiModelProperty(name = "codigoVendedorC", required = true, value = "Codigo del vendedor", example = "1A", dataType = "String")
	private String codigoVendedorC;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "codigoCliente", required = true, value = "Codigo del cliente", example = "2541025", dataType = "Integer")
	private Integer codigoCliente;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "nombreCliente", required = true, value = "Nombre del Cliente", example = "Luis Peralta", dataType = "String")
	private String nombreCliente;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "motivo", required = true, value = "Motivo del pedido", dataType = "String")
	private String motivo;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "chassis", required = true, value = "Numero de Chassis del vehiculo", dataType = "String")
	private String chassis;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "modelo", required = true, value = "Modelo del vehiculo", dataType = "String")
	private String modelo;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "formaPago", required = true, value = "Forma de Pago", dataType = "String")
	private String formaPago;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "modalidadEntrega", required = true, value = "Modalidad Entrega", dataType = "String")
	private String modalidadEntrega;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "tipoTransporte", required = true, value = "Tipo de Transporte", dataType = "String")
	private String tipoTransporte;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 5, max = 10, message = CustomValidationMessage.CODIGO_USUARIO_REQUERIDO)
	@ApiModelProperty(name = "usuario", required = true, value = "Usuario que genero el pedido", dataType = "String")
	private String usuario;
	
	@NotNull(message = CustomValidationMessage.LISTA_NONULO)
	@Valid
	@ApiModelProperty(name = "detalle", required = true, value = "Detalle del pedido")
	private List<PedidoEspecialProveedorDetalle> detalle;
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
	 * @return the motivo
	 */
	public String getMotivo() {
		return motivo;
	}
	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	/**
	 * @return the chassis
	 */
	public String getChassis() {
		return chassis;
	}
	/**
	 * @param chassis the chassis to set
	 */
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @return the formaPago
	 */
	public String getFormaPago() {
		return formaPago;
	}
	/**
	 * @param formaPago the formaPago to set
	 */
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	/**
	 * @return the modalidadEntrega
	 */
	public String getModalidadEntrega() {
		return modalidadEntrega;
	}
	/**
	 * @param modalidadEntrega the modalidadEntrega to set
	 */
	public void setModalidadEntrega(String modalidadEntrega) {
		this.modalidadEntrega = modalidadEntrega;
	}
	/**
	 * @return the tipoTransporte
	 */
	public String getTipoTransporte() {
		return tipoTransporte;
	}
	/**
	 * @param tipoTransporte the tipoTransporte to set
	 */
	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
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
	 * @return the detalle
	 */
	public List<PedidoEspecialProveedorDetalle> getDetalle() {
		return detalle;
	}
	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<PedidoEspecialProveedorDetalle> detalle) {
		this.detalle = detalle;
	}
	/**
	 * 
	 */
	public PedidoEspecialProveedor() {
		// TODO Auto-generated constructor stub
	}
}
