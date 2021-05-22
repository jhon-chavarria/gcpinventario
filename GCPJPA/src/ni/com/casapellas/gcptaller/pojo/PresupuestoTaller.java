package ni.com.casapellas.gcptaller.pojo;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Api(value = "Presupuesto (Cabecera)")
public class PresupuestoTaller {
	@ApiModelProperty(value = "Codigo de la compania", dataType = "String", example = "01")
	private String codigoCompania;
	
	@ApiModelProperty(value = "Codigo del taller", dataType = "String", example = "08")
	private String codigoTaller;
	
	@ApiModelProperty(value = "Numero del presupuesto", dataType = "Number", example = "99999")
	private BigDecimal numeroPresupuesto;
	
	@ApiModelProperty(value = "Numero de Orden de Taller", dataType = "Number", example = "99999")
	private BigDecimal numeroOrden;
	
	@ApiModelProperty(value = "Fecha del presupuesto", dataType = "String", example = "01-01-0001")
	private String fecha;
	
	@ApiModelProperty(value = "Fecha de vencimiento del presupuesto", dataType = "String", example = "01-01-0001")
	private String fechaVencimiento;
	
	@ApiModelProperty(value = "Moneda del presupuesto", dataType = "String", example = "DOL")
	private String moneda;
	
	@ApiModelProperty(value = "Codigo del Cliente", dataType = "Number", example = "999999")
	private BigDecimal codigoCliente;
	
	@ApiModelProperty(value = "Nombre del cliente", dataType = "String", example = "Juan Mena")
	private String nombreCliente;
	
	@ApiModelProperty(value = "Numero de Telefono del cliente", dataType = "String", example = "88888888")
	private BigDecimal telefono;
	
	@ApiModelProperty(value = "Direccion del cliente", dataType = "String", example = "Managua, Nicaragua")
	private String direccion;
	
	@ApiModelProperty(value = "Nombre de la aseguradora", dataType = "String", example = "Aseguradora")
	private String nombreAseguradora;
	
	@ApiModelProperty(value = "Codigo de la Marca del vehiculo", dataType = "String", example = "01")
	private String codigoMarca;
	
	@ApiModelProperty(value = "Descripcion de la marca del vehiculo", dataType = "String", example = "Marca")
	private String descripcionMarca;
	
	@ApiModelProperty(value = "Modelo del vehiculo", dataType = "String", example = "Yaris")
	private String modelo;
	
	@ApiModelProperty(value = "Codigo del color del vehiculo", dataType = "String", example = "001")
	private String codigoColor;
	
	@ApiModelProperty(value = "Descripcion del color del vehiculo", dataType = "String", example = "Rojo")
	private String descripcionColor;
	
	@ApiModelProperty(value = "Annio del vehiculo", dataType = "String", example = "2000")
	private BigDecimal annio;
	
	@ApiModelProperty(value = "Numero de placa del vehiculo", dataType = "String", example = "M000-000")
	private String placa;
	
	@ApiModelProperty(value = "Numero de chasis del vehiculo", dataType = "String", example = "H3242")
	private String chasis;
	
	@ApiModelProperty(value = "Valor de la Mano de Obra", dataType = "Number", example = "12.5")
	private BigDecimal valorManoObra;
	
	@ApiModelProperty(value = "Valor de los materiales", dataType = "Number", example = "12.5")
	private BigDecimal valorMateriales;
	
	@ApiModelProperty(value = "Valor de los repuestos", dataType = "Number", example = "12.5")
	private BigDecimal valorRepuestos;
	
	@ApiModelProperty(value = "Valor total del presupuesto", dataType = "Number", example = "12.5")
	private BigDecimal valorTotal;
	
	@ApiModelProperty(value = "Tipo de presupuesto", dataType = "String", example = "M")
	private String tipoPresupuesto;
	
	@ApiModelProperty(value = "Codigo del tecnico asociado", dataType = "Number", example = "12656")
	private BigDecimal codigoTecnico;
	
	@ApiModelProperty(value = "Nombre del Tecnico", dataType = "String", example = "Jose Garcia")
	private String nombreTecnico;
	
	@ApiModelProperty(value = "Observaciones del presupuesto", dataType = "String", example = "")
	private String observaciones;
	
	@ApiModelProperty(value = "Detalle del presupuesto")
	private List<PresupuestoTallerDetalle> detalle;
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
	 * @return the codigoTaller
	 */
	public String getCodigoTaller() {
		return codigoTaller;
	}
	/**
	 * @param codigoTaller the codigoTaller to set
	 */
	public void setCodigoTaller(String codigoTaller) {
		this.codigoTaller = codigoTaller;
	}
	/**
	 * @return the numeroPresupuesto
	 */
	public BigDecimal getNumeroPresupuesto() {
		return numeroPresupuesto;
	}
	/**
	 * @param numeroPresupuesto the numeroPresupuesto to set
	 */
	public void setNumeroPresupuesto(BigDecimal numeroPresupuesto) {
		this.numeroPresupuesto = numeroPresupuesto;
	}
	/**
	 * @return the numeroOrden
	 */
	public BigDecimal getNumeroOrden() {
		return numeroOrden;
	}
	/**
	 * @param numeroOrden the numeroOrden to set
	 */
	public void setNumeroOrden(BigDecimal numeroOrden) {
		this.numeroOrden = numeroOrden;
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
	 * @return the fechaVencimiento
	 */
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	/**
	 * @param fechaVencimiento the fechaVencimiento to set
	 */
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
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
	 * @return the telefono
	 */
	public BigDecimal getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(BigDecimal telefono) {
		this.telefono = telefono;
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
	 * @return the nombreAseguradora
	 */
	public String getNombreAseguradora() {
		return nombreAseguradora;
	}
	/**
	 * @param nombreAseguradora the nombreAseguradora to set
	 */
	public void setNombreAseguradora(String nombreAseguradora) {
		this.nombreAseguradora = nombreAseguradora;
	}
	/**
	 * @return the codigoMarca
	 */
	public String getCodigoMarca() {
		return codigoMarca;
	}
	/**
	 * @param codigoMarca the codigoMarca to set
	 */
	public void setCodigoMarca(String codigoMarca) {
		this.codigoMarca = codigoMarca;
	}
	/**
	 * @return the descripcionMarca
	 */
	public String getDescripcionMarca() {
		return descripcionMarca;
	}
	/**
	 * @param descripcionMarca the descripcionMarca to set
	 */
	public void setDescripcionMarca(String descripcionMarca) {
		this.descripcionMarca = descripcionMarca;
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
	 * @return the codigoColor
	 */
	public String getCodigoColor() {
		return codigoColor;
	}
	/**
	 * @param codigoColor the codigoColor to set
	 */
	public void setCodigoColor(String codigoColor) {
		this.codigoColor = codigoColor;
	}
	/**
	 * @return the descripcionColor
	 */
	public String getDescripcionColor() {
		return descripcionColor;
	}
	/**
	 * @param descripcionColor the descripcionColor to set
	 */
	public void setDescripcionColor(String descripcionColor) {
		this.descripcionColor = descripcionColor;
	}
	/**
	 * @return the annio
	 */
	public BigDecimal getAnnio() {
		return annio;
	}
	/**
	 * @param annio the annio to set
	 */
	public void setAnnio(BigDecimal annio) {
		this.annio = annio;
	}
	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}
	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	/**
	 * @return the chasis
	 */
	public String getChasis() {
		return chasis;
	}
	/**
	 * @param chasis the chasis to set
	 */
	public void setChasis(String chasis) {
		this.chasis = chasis;
	}
	/**
	 * @return the valorManoObra
	 */
	public BigDecimal getValorManoObra() {
		return valorManoObra;
	}
	/**
	 * @param valorManoObra the valorManoObra to set
	 */
	public void setValorManoObra(BigDecimal valorManoObra) {
		this.valorManoObra = valorManoObra;
	}
	/**
	 * @return the valorMateriales
	 */
	public BigDecimal getValorMateriales() {
		return valorMateriales;
	}
	/**
	 * @param valorMateriales the valorMateriales to set
	 */
	public void setValorMateriales(BigDecimal valorMateriales) {
		this.valorMateriales = valorMateriales;
	}
	/**
	 * @return the valorRepuestos
	 */
	public BigDecimal getValorRepuestos() {
		return valorRepuestos;
	}
	/**
	 * @param valorRepuestos the valorRepuestos to set
	 */
	public void setValorRepuestos(BigDecimal valorRepuestos) {
		this.valorRepuestos = valorRepuestos;
	}
	/**
	 * @return the valorTotal
	 */
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	/**
	 * @return the tipoPresupesto
	 */
	public String getTipoPresupuesto() {
		return tipoPresupuesto;
	}
	/**
	 * @param tipoPresupesto the tipoPresupesto to set
	 */
	public void setTipoPresupuesto(String tipoPresupuesto) {
		this.tipoPresupuesto = tipoPresupuesto;
	}
	/**
	 * @return the codigoTecnico
	 */
	public BigDecimal getCodigoTecnico() {
		return codigoTecnico;
	}
	/**
	 * @param codigoTecnico the codigoTecnico to set
	 */
	public void setCodigoTecnico(BigDecimal codigoTecnico) {
		this.codigoTecnico = codigoTecnico;
	}
	/**
	 * @return the nombreTecnico
	 */
	public String getNombreTecnico() {
		return nombreTecnico;
	}
	/**
	 * @param nombreTecnico the nombreTecnico to set
	 */
	public void setNombreTecnico(String nombreTecnico) {
		this.nombreTecnico = nombreTecnico;
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
	 * @return the detalle
	 */
	public List<PresupuestoTallerDetalle> getDetalle() {
		return detalle;
	}
	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<PresupuestoTallerDetalle> detalle) {
		this.detalle = detalle;
	}
}
