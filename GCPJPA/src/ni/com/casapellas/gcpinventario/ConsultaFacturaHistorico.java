package ni.com.casapellas.gcpinventario;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Factura Historico(Cabecera)")
public class ConsultaFacturaHistorico {
	@ApiModelProperty(name = "codigoCompania", value = "Codigo de la Compania", dataType = "String")
	private String codigoCompania;
	
	@ApiModelProperty(name = "codigoSucursal", value = "Codigo de Sucusal", dataType = "String")
	private String codigoSucursal;
	
	@ApiModelProperty(name = "codigoDepartamento", value = "Codigo de departamento", dataType = "String")
	private String codigoDepartamento;
	
	@ApiModelProperty(name = "tipoMovimiento", value = "Tipo de Movimiento", dataType = "String")
	private String tipoMovimiento;
	
	@ApiModelProperty(name = "subTipoMovimiento", value = "SubTipo de Movimiento", dataType = "String")
	private String subTipoMovimiento;
	
	@ApiModelProperty(name = "numeroDocumento", value = "Numero de Factura", dataType = "Number")
	private BigDecimal numeroDocumento;
	
	@ApiModelProperty(name = "fecha", value = "Fecha de Factura", dataType = "String")
	private String fecha;
	
	@ApiModelProperty(name = "tasaCambio", value = "Tasa de cambio", dataType = "number")
	private BigDecimal tasaCambio;
	
	@ApiModelProperty(name = "motivo", value = "Descripcion", dataType = "String")
	private String motivo;
	
	@ApiModelProperty(name = "numeroReferencia", value = "Numero de Referencia", dataType = "String")
	private BigDecimal numeroReferencia;
	
	@ApiModelProperty(name = "codigoVendedorC", value = "Codigo corto del vendedor", dataType = "String")
	private String codigoVendedorC;
	
	@ApiModelProperty(name = "modalidadCanal", value = "Tipo de modalidad del Canal", dataType = "String")
	private String modalidadCanal;
	
	@ApiModelProperty(name = "codigoVendedorL", value = "Codigo largo del vendedor", dataType = "Number")
	private BigDecimal codigoVendedorL;
	
	@ApiModelProperty(name = "nombreVendedor", value = "Nombre del vendedor", dataType = "String")
	private String nombreVendedor;
	
	@ApiModelProperty(name = "codigoCliente", value = "Codigo del cliente", dataType = "Number")
	private BigDecimal codigoCliente;
	
	@ApiModelProperty(name = "nombreCliente", value = "Nombre del Cliente", dataType = "String")
	private String nombreCliente;
	
	@ApiModelProperty(name = "modalidadFactura", value = "Modalidad de la Factura", dataType = "String")
	private String modalidadFactura;
	
	@ApiModelProperty(name = "tipoFactura", value = "Tipo de la Factura", dataType = "String")
	private String tipoFactura;
	
	@ApiModelProperty(name = "condicionPago", value = "Condicion de Pago", dataType = "String")
	private String condicionPago;
	
	@ApiModelProperty(name = "codigoMoneda", value = "Moneda de la Factura", dataType = "String")
	private String codigoMoneda;
	
	@ApiModelProperty(name = "totalFacturaL", value = "Monto total en moneda local", dataType = "Number")
	private BigDecimal totalFacturaL;
	
	@ApiModelProperty(name = "totalDescuentoL", value = "Monto del descuento en moneda local", dataType = "Number")
	private BigDecimal totalDescuentoL;
	
	@ApiModelProperty(name = "totalImpVentaL", value = "Monto del impuesto de venta en moneda local", dataType = "Number")
	private BigDecimal totalImpVentaL;
	
	@ApiModelProperty(name = "totalImpIscL", value = "Monto del impuesto al consumo en moneda local", dataType = "Number")
	private BigDecimal totalImpIscL;
	
	@ApiModelProperty(name = "totalFacturaF", value = "Monto total en moneda foranea", dataType = "Number")
	private BigDecimal totalFacturaF;
	
	@ApiModelProperty(name = "totalDescuentoF", value = "Monto del descuento en moneda foranea", dataType = "Number")
	private BigDecimal totalDescuentoF;
	
	@ApiModelProperty(name = "totalImpVentaF", value = "Monto del impuesto de venta en moneda foranea", dataType = "Number")
	private BigDecimal totalImpVentaF;
	
	@ApiModelProperty(name = "totalImpIscF", value = "Monto del impuesto al consumo en moneda foranea", dataType = "Number")
	private BigDecimal totalImpIscF;
	
	@ApiModelProperty(name = "totalCosto", value = "Monto del costo total de los productos", dataType = "Number")
	private BigDecimal totalCosto;
	
	@ApiModelProperty(name = "numeroOrdenTaller", value = "Numero de Orden de taller", dataType = "Number")
	private BigDecimal numeroOrdenTaller;
	
	@ApiModelProperty(name = "tipoDocumentoTaller", value = "Tipo de documento asociado a la factura FC o RQ", dataType = "String")
	private String tipoDocumentoTaller;
	
	@ApiModelProperty(name = "codigoTaller", value = "Codigo del Taller asociado a la factura", dataType = "String")
	private String codigoTaller;
	
	@ApiModelProperty(name = "codigoTecnico", value = "Codigo del Tecnico asociado a la factura", dataType = "String")
	private String codigoTecnico;
	
	@ApiModelProperty(name = "nombreTecnico", value = "Nombre del Taller asociado a la factura", dataType = "String")
	private String nombreTecnico;
	
	@ApiModelProperty(name = "estado", value = "Estado de la Factura", dataType = "String")
	private String estado;
	
	@ApiModelProperty(name = "detalle", value = "Lista de Item asociados a la factura")
	private List<ConsultaFacturaHistoricoDetalle> detalle;
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
	 * @return the tipoMovimiento
	 */
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	
	/**
	 * @return the subTipoMovimiento
	 */
	public String getSubTipoMovimiento() {
		return subTipoMovimiento;
	}
	/**
	 * @return the numeroDocumento
	 */
	public BigDecimal getNumeroDocumento() {
		return numeroDocumento;
	}
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @return the tasaCambio
	 */
	public BigDecimal getTasaCambio() {
		return tasaCambio;
	}
	/**
	 * @return the motivo
	 */
	public String getMotivo() {
		return motivo;
	}
	/**
	 * @return the numeroReferencia
	 */
	public BigDecimal getNumeroReferencia() {
		return numeroReferencia;
	}
	/**
	 * @return the codigoVendedorC
	 */
	public String getCodigoVendedorC() {
		return codigoVendedorC;
	}
	/**
	 * @return the modalidadCanal
	 */
	public String getModalidadCanal() {
		return modalidadCanal;
	}
	/**
	 * @return the codigoVendedorL
	 */
	public BigDecimal getCodigoVendedorL() {
		return codigoVendedorL;
	}
	/**
	 * @return the nombreVendedor
	 */
	public String getNombreVendedor() {
		return nombreVendedor;
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
	 * @return the modalidadFactura
	 */
	public String getModalidadFactura() {
		return modalidadFactura;
	}
	/**
	 * @return the tipoFactura
	 */
	public String getTipoFactura() {
		return tipoFactura;
	}
	/**
	 * @return the condicionPago
	 */
	public String getCondicionPago() {
		return condicionPago;
	}
	/**
	 * @return the codigoMoneda
	 */
	public String getCodigoMoneda() {
		return codigoMoneda;
	}
	/**
	 * @return the totalFacturaL
	 */
	public BigDecimal getTotalFacturaL() {
		return totalFacturaL;
	}
	/**
	 * @return the totalDescuentoL
	 */
	public BigDecimal getTotalDescuentoL() {
		return totalDescuentoL;
	}
	/**
	 * @return the totalImpVentaL
	 */
	public BigDecimal getTotalImpVentaL() {
		return totalImpVentaL;
	}
	/**
	 * @return the totalImpIscL
	 */
	public BigDecimal getTotalImpIscL() {
		return totalImpIscL;
	}
	/**
	 * @return the totalFacturaF
	 */
	public BigDecimal getTotalFacturaF() {
		return totalFacturaF;
	}
	/**
	 * @return the totalDescuentoF
	 */
	public BigDecimal getTotalDescuentoF() {
		return totalDescuentoF;
	}
	/**
	 * @return the totalImpVentaF
	 */
	public BigDecimal getTotalImpVentaF() {
		return totalImpVentaF;
	}
	/**
	 * @return the totalImpIscF
	 */
	public BigDecimal getTotalImpIscF() {
		return totalImpIscF;
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
	 * @param tipoMovimiento the tipoMovimiento to set
	 */
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	/**
	 * @param subTipoMovimiento the subTipoMovimiento to set
	 */
	public void setSubTipoMovimiento(String subTipoMovimiento) {
		this.subTipoMovimiento = subTipoMovimiento;
	}
	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(BigDecimal numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @param tasaCambio the tasaCambio to set
	 */
	public void setTasaCambio(BigDecimal tasaCambio) {
		this.tasaCambio = tasaCambio;
	}
	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	/**
	 * @param numeroReferencia the numeroReferencia to set
	 */
	public void setNumeroReferencia(BigDecimal numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}
	/**
	 * @param codigoVendedorC the codigoVendedorC to set
	 */
	public void setCodigoVendedorC(String codigoVendedorC) {
		this.codigoVendedorC = codigoVendedorC;
	}
	/**
	 * @param modalidadCanal the modalidadCanal to set
	 */
	public void setModalidadCanal(String modalidadCanal) {
		this.modalidadCanal = modalidadCanal;
	}
	/**
	 * @param codigoVendedorL the codigoVendedorL to set
	 */
	public void setCodigoVendedorL(BigDecimal codigoVendedorL) {
		this.codigoVendedorL = codigoVendedorL;
	}
	/**
	 * @param nombreVendedor the nombreVendedor to set
	 */
	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
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
	 * @param modalidadFactura the modalidadFactura to set
	 */
	public void setModalidadFactura(String modalidadFactura) {
		this.modalidadFactura = modalidadFactura;
	}
	/**
	 * @param tipoFactura the tipoFactura to set
	 */
	public void setTipoFactura(String tipoFactura) {
		this.tipoFactura = tipoFactura;
	}
	/**
	 * @param condicionPago the condicionPago to set
	 */
	public void setCondicionPago(String condicionPago) {
		this.condicionPago = condicionPago;
	}
	/**
	 * @param codigoMoneda the codigoMoneda to set
	 */
	public void setCodigoMoneda(String codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}
	/**
	 * @param totalFacturaL the totalFacturaL to set
	 */
	public void setTotalFacturaL(BigDecimal totalFacturaL) {
		this.totalFacturaL = totalFacturaL;
	}
	/**
	 * @param totalDescuentoL the totalDescuentoL to set
	 */
	public void setTotalDescuentoL(BigDecimal totalDescuentoL) {
		this.totalDescuentoL = totalDescuentoL;
	}
	/**
	 * @param totalImpVentaL the totalImpVentaL to set
	 */
	public void setTotalImpVentaL(BigDecimal totalImpVentaL) {
		this.totalImpVentaL = totalImpVentaL;
	}
	/**
	 * @param totalImpIscL the totalImpIscL to set
	 */
	public void setTotalImpIscL(BigDecimal totalImpIscL) {
		this.totalImpIscL = totalImpIscL;
	}
	/**
	 * @param totalFacturaF the totalFacturaF to set
	 */
	public void setTotalFacturaF(BigDecimal totalFacturaF) {
		this.totalFacturaF = totalFacturaF;
	}
	/**
	 * @param totalDescuentoF the totalDescuentoF to set
	 */
	public void setTotalDescuentoF(BigDecimal totalDescuentoF) {
		this.totalDescuentoF = totalDescuentoF;
	}
	/**
	 * @param totalImpVentaF the totalImpVentaF to set
	 */
	public void setTotalImpVentaF(BigDecimal totalImpVentaF) {
		this.totalImpVentaF = totalImpVentaF;
	}
	/**
	 * @param totalImpIscF the totalImpIscF to set
	 */
	public void setTotalImpIscF(BigDecimal totalImpIscF) {
		this.totalImpIscF = totalImpIscF;
	}
	/**
	 * @return the totalCosto
	 */
	public BigDecimal getTotalCosto() {
		return totalCosto;
	}
	/**
	 * @param totalCosto the totalCosto to set
	 */
	public void setTotalCosto(BigDecimal totalCosto) {
		this.totalCosto = totalCosto;
	}
	/**
	 * @return the numeroOrdenTaller
	 */
	public BigDecimal getNumeroOrdenTaller() {
		return numeroOrdenTaller;
	}
	/**
	 * @param numeroOrdenTaller the numeroOrdenTaller to set
	 */
	public void setNumeroOrdenTaller(BigDecimal numeroOrdenTaller) {
		this.numeroOrdenTaller = numeroOrdenTaller;
	}
	/**
	 * @return the tipoDocumentoTaller
	 */
	public String getTipoDocumentoTaller() {
		return tipoDocumentoTaller;
	}
	/**
	 * @param tipoDocumentoTaller the tipoDocumentoTaller to set
	 */
	public void setTipoDocumentoTaller(String tipoDocumentoTaller) {
		this.tipoDocumentoTaller = tipoDocumentoTaller;
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
	 * @return the codigoTecnico
	 */
	public String getCodigoTecnico() {
		return codigoTecnico;
	}
	/**
	 * @param codigoTecnico the codigoTecnico to set
	 */
	public void setCodigoTecnico(String codigoTecnico) {
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
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the detalle
	 */
	public List<ConsultaFacturaHistoricoDetalle> getDetalle() {
		return detalle;
	}
	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<ConsultaFacturaHistoricoDetalle> detalle) {
		this.detalle = detalle;
	}
	/**
	 * 
	 */
	public ConsultaFacturaHistorico() {
		// TODO Auto-generated constructor stub
	}
}
