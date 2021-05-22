package ni.com.casapellas.gcpinventario;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ni.com.casapellas.util.CustomValidationMessage;
import ni.com.casapellas.util.ValidDate;

@ApiModel(value = "Perdido Reservacion (Cabecera)")
public class PedidoReservacion {
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = "El codigo de la compania es requerido")
	@ApiModelProperty(name = "codigoCompania", required = true, value = "Codigo de la Compania", example = "00", dataType = "String")
	private String codigoCompania;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = "El codigo de la sucursal es requerido")
	@ApiModelProperty(name = "codigoSucursal", required = true, value = "Codigo de la Sucursal", example = "00", dataType = "String")
	private String codigoSucursal;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = "El codigo del departamento es requerido")
	@ApiModelProperty(name = "codigoDepartamento", required = true, value = "Codigo del departamento", example = "00", dataType = "String")
	private String codigoDepartamento;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ValidDate(message = "La fecha tiene un formato invalido.")
	@ApiModelProperty(name = "fecha", required = true, value = "Fecha del pedido", example = "2020-01-01 08:10:10", dataType = "String", notes = "La fecha del pedido tiene que ser en el formato yyyy-MM-dd hh:mm:ss")
	private String fecha;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = "El codigo del departamento es requerido")
	@ApiModelProperty(name = "codigoVendedorC", required = true, value = "Codigo del vendedor", example = "1A", dataType = "String")
	private String codigoVendedorC;
	
	@ApiModelProperty(name = "codigoCliente", required = true, value = "Codigo del cliente", example = "2541025", dataType = "Integer")
	private Integer codigoCliente;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 5, max = 50, message = "El nombre del cliente debe contener entre 3 y 40 caracteres")
	@ApiModelProperty(name = "nombreCliente", required = true, value = "Nombre del cliente", example = "Jose Pavon", dataType = "String")
	private String nombreCliente;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 5, max = 50, message = "El motivo debe contener entre 5 y 50 caracteres")
	@ApiModelProperty(name = "motivo", required = true, value = "Motivo del pedido", example = "Pedido", dataType = "String")
	private String motivo;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 5, max = 10, message = CustomValidationMessage.CODIGO_USUARIO_REQUERIDO)
	@ApiModelProperty(name = "usuario", required = true, value = "Usuario que genero el pedido", example = "pruebas", dataType = "String")
	private String usuario;
	
	@NotNull(message = CustomValidationMessage.LISTA_NONULO)
	@Valid
	@ApiModelProperty(name = "detalle", required = true, value = "Lista de Items que contiene el pedido")
	private List<PedidoReservacionDetalle> detalle;
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
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @return the codigoVendedorC
	 */
	public String getCodigoVendedorC() {
		return codigoVendedorC;
	}
	/**
	 * @return the codigoCliente
	 */
	public Integer getCodigoCliente() {
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
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @return the detalle
	 */
	public List<PedidoReservacionDetalle> getDetalle() {
		return detalle;
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
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @param codigoVendedorC the codigoVendedorC to set
	 */
	public void setCodigoVendedorC(String codigoVendedorC) {
		this.codigoVendedorC = codigoVendedorC;
	}
	/**
	 * @param codigoCliente the codigoCliente to set
	 */
	public void setCodigoCliente(Integer codigoCliente) {
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
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<PedidoReservacionDetalle> detalle) {
		this.detalle = detalle;
	}
	/**
	 * 
	 */
	public PedidoReservacion() {
		// TODO Auto-generated constructor stub
	}
}
