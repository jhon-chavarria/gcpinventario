package ni.com.casapellas.gcpinventario;

import java.math.BigDecimal;

public class ProductInfo {
	private String codigoCompania;
	private String codigoArticulo;
	private String articuloEquivalente;
	private String descripcion;
	private String codigoAgrupacion;
	private String codigoCategoria;
	private String codigoLinea;
	private BigDecimal codigoArancel;
	private String partidaArancelaria;
	private String unidadMedida;
	private String ubicacion;
	private BigDecimal costo;
	private BigDecimal costoTotal;
	private BigDecimal iva;
	private BigDecimal isc;
	private BigDecimal existenciaBodega;
	private BigDecimal existenciaNacional;
	private BigDecimal existenciaTotalSucursal;
	private BigDecimal precioFob;
	private BigDecimal pedidoProveedor;
	private String archivoExistencia;
	private Boolean articuloBloqueado;
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
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	/**
	 * @return the articuloEquivalente
	 */
	public String getArticuloEquivalente() {
		return articuloEquivalente;
	}
	/**
	 * @param articuloEquivalente the articuloEquivalente to set
	 */
	public void setArticuloEquivalente(String articuloEquivalente) {
		this.articuloEquivalente = articuloEquivalente;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the codigoAgrupacion
	 */
	public String getCodigoAgrupacion() {
		return codigoAgrupacion;
	}
	/**
	 * @param codigoAgrupacion the codigoAgrupacion to set
	 */
	public void setCodigoAgrupacion(String codigoAgrupacion) {
		this.codigoAgrupacion = codigoAgrupacion;
	}
	/**
	 * @return the codigoCategoria
	 */
	public String getCodigoCategoria() {
		return codigoCategoria;
	}
	/**
	 * @param codigoCategoria the codigoCategoria to set
	 */
	public void setCodigoCategoria(String codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}
	/**
	 * @return the codigoLinea
	 */
	public String getCodigoLinea() {
		return codigoLinea;
	}
	/**
	 * @param codigoLinea the codigoLinea to set
	 */
	public void setCodigoLinea(String codigoLinea) {
		this.codigoLinea = codigoLinea;
	}
	/**
	 * @return the codigoArancel
	 */
	public BigDecimal getCodigoArancel() {
		return codigoArancel;
	}
	/**
	 * @param codigoArancel the codigoArancel to set
	 */
	public void setCodigoArancel(BigDecimal codigoArancel) {
		this.codigoArancel = codigoArancel;
	}
	/**
	 * @return the partidaArancelaria
	 */
	public String getPartidaArancelaria() {
		return partidaArancelaria;
	}
	/**
	 * @param partidaArancelaria the partidaArancelaria to set
	 */
	public void setPartidaArancelaria(String partidaArancelaria) {
		this.partidaArancelaria = partidaArancelaria;
	}
	/**
	 * @return the unidadMedida
	 */
	public String getUnidadMedida() {
		return unidadMedida;
	}
	/**
	 * @param unidadMedida the unidadMedida to set
	 */
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	/**
	 * @return the costo
	 */
	public BigDecimal getCosto() {
		return costo;
	}
	/**
	 * @param costo the costo to set
	 */
	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}
	/**
	 * @return the iva
	 */
	public BigDecimal getIva() {
		return iva;
	}
	/**
	 * @param iva the iva to set
	 */
	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}
	/**
	 * @return the isc
	 */
	public BigDecimal getIsc() {
		return isc;
	}
	/**
	 * @param isc the isc to set
	 */
	public void setIsc(BigDecimal isc) {
		this.isc = isc;
	}
	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}
	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	/**
	 * @return the existenciaBodega
	 */
	public BigDecimal getExistenciaBodega() {
		return existenciaBodega;
	}
	/**
	 * @param existenciaBodega the existenciaBodega to set
	 */
	public void setExistenciaBodega(BigDecimal existenciaBodega) {
		this.existenciaBodega = existenciaBodega;
	}
	/**
	 * @return the existenciaNacional
	 */
	public BigDecimal getExistenciaNacional() {
		return existenciaNacional;
	}
	/**
	 * @param existenciaNacional the existenciaNacional to set
	 */
	public void setExistenciaNacional(BigDecimal existenciaNacional) {
		this.existenciaNacional = existenciaNacional;
	}
	/**
	 * @return the precioFob
	 */
	public BigDecimal getPrecioFob() {
		return precioFob;
	}
	/**
	 * @param precioFob the precioFob to set
	 */
	public void setPrecioFob(BigDecimal precioFob) {
		this.precioFob = precioFob;
	}
	/**
	 * @return the pedidoProveedor
	 */
	public BigDecimal getPedidoProveedor() {
		return pedidoProveedor;
	}
	/**
	 * @param pedidoProveedor the pedidoProveedor to set
	 */
	public void setPedidoProveedor(BigDecimal pedidoProveedor) {
		this.pedidoProveedor = pedidoProveedor;
	}
	/**
	 * @return the archivoExistencia
	 */
	public String getArchivoExistencia() {
		return archivoExistencia;
	}
	/**
	 * @param archivoExistencia the archivoExistencia to set
	 */
	public void setArchivoExistencia(String archivoExistencia) {
		this.archivoExistencia = archivoExistencia;
	}
	/**
	 * @return the costoTotal
	 */
	public BigDecimal getCostoTotal() {
		return costoTotal;
	}
	/**
	 * @return the existenciaTotalSucursal
	 */
	public BigDecimal getExistenciaTotalSucursal() {
		return existenciaTotalSucursal;
	}
	/**
	 * @return the articuloBloqueado
	 */
	public Boolean getArticuloBloqueado() {
		return articuloBloqueado;
	}
	/**
	 * @param costoTotal the costoTotal to set
	 */
	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}
	/**
	 * @param existenciaTotalSucursal the existenciaTotalSucursal to set
	 */
	public void setExistenciaTotalSucursal(BigDecimal existenciaTotalSucursal) {
		this.existenciaTotalSucursal = existenciaTotalSucursal;
	}
	/**
	 * @param articuloBloqueado the articuloBloqueado to set
	 */
	public void setArticuloBloqueado(Boolean articuloBloqueado) {
		this.articuloBloqueado = articuloBloqueado;
	}
	/**
	 * 
	 */
	public ProductInfo() {
		// TODO Auto-generated constructor stub
	}

}
