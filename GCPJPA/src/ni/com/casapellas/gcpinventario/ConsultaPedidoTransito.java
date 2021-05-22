package ni.com.casapellas.gcpinventario;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Pedido Transito")
public class ConsultaPedidoTransito {
	
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
	
	@ApiModelProperty(name = "codigoProveedor", value = "Codigo del proveedor", dataType = "Number")
	private BigDecimal codigoProveedor;
	
	@ApiModelProperty(name = "nombreProveedor", value = "Nombre del proveedor", dataType = "String")
	private String nombreProveedor;
	
	@ApiModelProperty(name = "fechaPedido", value = "Fecha del pedido", dataType = "String")
	private String fechaPedido;
	
	@ApiModelProperty(name = "codigoArticulo", value = "Codigo del Articulo", dataType = "String")
	private String codigoArticulo;
	
	@ApiModelProperty(name = "nombreArticulo", value = "Nombre del Articulo", dataType = "String")
	private String nombreArticulo;
	
	@ApiModelProperty(name = "cantidadPedida", value = "Cantidad solicitada", dataType = "Number")
	private BigDecimal cantidadPedida;
	
	@ApiModelProperty(name = "motivo", value = "Motivo del pedido", dataType = "String")
	private String motivo;
	
	@ApiModelProperty(name = "fechaLlegada", value = "Fecha de llegada del pedido", dataType = "String")
	private String fechaLlegada;
	
	@ApiModelProperty(name = "tipoPedido", value = "Tipo del pedido", dataType = "String")
	private String tipoPedido;
	
	@ApiModelProperty(name = "estado", value = "Estado del pedido", dataType = "String")
	private String estado;
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
	 * @return the codigoProveedor
	 */
	public BigDecimal getCodigoProveedor() {
		return codigoProveedor;
	}
	/**
	 * @return the nombreProveedor
	 */
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	/**
	 * @return the fechaPedido
	 */
	public String getFechaPedido() {
		return fechaPedido;
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
	 * @return the cantidadPedida
	 */
	public BigDecimal getCantidadPedida() {
		return cantidadPedida;
	}
	/**
	 * @return the motivo
	 */
	public String getMotivo() {
		return motivo;
	}
	/**
	 * @return the fechaLlegada
	 */
	public String getFechaLlegada() {
		return fechaLlegada;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
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
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(BigDecimal codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	/**
	 * @param nombreProveedor the nombreProveedor to set
	 */
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	/**
	 * @param fechaPedido the fechaPedido to set
	 */
	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
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
	 * @param cantidadPedida the cantidadPedida to set
	 */
	public void setCantidadPedida(BigDecimal cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}
	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	/**
	 * @param fechaLlegada the fechaLlegada to set
	 */
	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the tipoPedido
	 */
	public String getTipoPedido() {
		return tipoPedido;
	}
	/**
	 * @param tipoPedido the tipoPedido to set
	 */
	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}
	/**
	 * 
	 */
	public ConsultaPedidoTransito() {
		// TODO Auto-generated constructor stub
	}
}
