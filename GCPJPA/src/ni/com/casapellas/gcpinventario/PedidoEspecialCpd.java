package ni.com.casapellas.gcpinventario;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ni.com.casapellas.util.CustomValidationMessage;
import ni.com.casapellas.util.ValidDate;

@ApiModel(value = "Pedido Especial CPD (Cabecera)")
public class PedidoEspecialCpd {
	
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
	@Size(min = 1, message = "El codigo de la sucursal destino es requerido")
	@ApiModelProperty(name = "codigoSucDestino", required = true, value = "Codigo de Sucursal Destino", example = "00", dataType = "String")
	private String codigoSucDestino;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ValidDate(message = CustomValidationMessage.FECHA_FORMATO_INVALIDO)
	@ApiModelProperty(name = "fecha", required = true, value = "Fecha", example = "2021-01-01 00:00:00", dataType = "String")
	private String fecha;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "codigoCliente", required = true, value = "Codigo del cliente", example = "2541025", dataType = "Integer")
	private Integer codigoCliente;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "esUrgente", required = true, value = "Indica si el pedido es urgente", example = "false", dataType = "Boolean")
	private Boolean esUrgente;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 5, max = 60, message = "La longitud de este campo debe de ser entre 5 y 60 caracteres")
	@ApiModelProperty(name = "motivo", required = true, value = "Motivo del pedido", dataType = "String")
	private String motivo;
	
	@ApiModelProperty(name = "numeroOrden", required = false, value = "Numero de Orden asociada al pedido", dataType = "Integer")
	private Integer numeroOrden;
	
	@ApiModelProperty(name = "codigoTaller", required = false, value = "Codigo del taller asociado a la orden", dataType = "Integer")
	private String codigoTaller;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 5, max = 10, message = CustomValidationMessage.CODIGO_USUARIO_REQUERIDO)
	@ApiModelProperty(name = "usuario", required = true, value = "Usuario que genero el pedido", dataType = "String")
	private String usuario;
	
	@NotNull(message = CustomValidationMessage.LISTA_NONULO)
	@Valid
	@ApiModelProperty(name = "detalle", required = true, value = "Detalle del pedido")
	private List<PedidoEspecialCpdDetalle> detalle;
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
	 * @return the codigoSucDestino
	 */
	public String getCodigoSucDestino() {
		return codigoSucDestino;
	}
	/**
	 * @param codigoSucDestino the codigoSucDestino to set
	 */
	public void setCodigoSucDestino(String codigoSucDestino) {
		this.codigoSucDestino = codigoSucDestino;
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
	 * @return the esUrgente
	 */
	public Boolean getEsUrgente() {
		return esUrgente;
	}
	/**
	 * @param esUrgente the esUrgente to set
	 */
	public void setEsUrgente(Boolean esUrgente) {
		this.esUrgente = esUrgente;
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
	 * @return the numeroOrden
	 */
	public Integer getNumeroOrden() {
		return numeroOrden;
	}
	/**
	 * @param numeroOrden the numeroOrden to set
	 */
	public void setNumeroOrden(Integer numeroOrden) {
		this.numeroOrden = numeroOrden;
	}
	/**
	 * @return the codigTaller
	 */
	public String getCodigoTaller() {
		return codigoTaller;
	}
	/**
	 * @param codigTaller the codigTaller to set
	 */
	public void setCodigoTaller(String codigTaller) {
		this.codigoTaller = codigTaller;
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
	public List<PedidoEspecialCpdDetalle> getDetalle() {
		return detalle;
	}
	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<PedidoEspecialCpdDetalle> detalle) {
		this.detalle = detalle;
	}
	/**
	 * 
	 */
	public PedidoEspecialCpd() {
		// TODO Auto-generated constructor stub
	}
	
}
