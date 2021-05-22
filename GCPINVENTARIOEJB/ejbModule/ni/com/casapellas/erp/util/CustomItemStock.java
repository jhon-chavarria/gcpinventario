package ni.com.casapellas.erp.util;

import java.math.BigDecimal;

public class CustomItemStock {
	private String codigoCompania;
	private String codigoSucursal;
	private String codigoLinea;
	private String codigoBodega;
	private String codigoArticulo;
	private BigDecimal existenciaDispBodega;
	private BigDecimal existenciaTotalBodega;
	private BigDecimal costoUnitario;
	private BigDecimal costoTotalSucursal;
	private BigDecimal existenciaTotalSucursal;
	private Integer Bloqueado;
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
	 * @return the existenciaDispBodega
	 */
	public BigDecimal getExistenciaDispBodega() {
		return existenciaDispBodega;
	}
	/**
	 * @param existenciaDispBodega the existenciaDispBodega to set
	 */
	public void setExistenciaDispBodega(BigDecimal existenciaDispBodega) {
		this.existenciaDispBodega = existenciaDispBodega;
	}
	/**
	 * @return the existenciaTotalBodega
	 */
	public BigDecimal getExistenciaTotalBodega() {
		return existenciaTotalBodega;
	}
	/**
	 * @param existenciaTotalBodega the existenciaTotalBodega to set
	 */
	public void setExistenciaTotalBodega(BigDecimal existenciaTotalBodega) {
		this.existenciaTotalBodega = existenciaTotalBodega;
	}
	/**
	 * @return the costoUnitario
	 */
	public BigDecimal getCostoUnitario() {
		return costoUnitario;
	}
	/**
	 * @param costoUnitario the costoUnitario to set
	 */
	public void setCostoUnitario(BigDecimal costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	/**
	 * @return the costoTotalSucursal
	 */
	public BigDecimal getCostoTotalSucursal() {
		return costoTotalSucursal;
	}
	/**
	 * @param costoTotalSucursal the costoTotalSucursal to set
	 */
	public void setCostoTotalSucursal(BigDecimal costoTotalSucursal) {
		this.costoTotalSucursal = costoTotalSucursal;
	}
	/**
	 * @return the existenciaTotalSucursal
	 */
	public BigDecimal getExistenciaTotalSucursal() {
		return existenciaTotalSucursal;
	}
	/**
	 * @param existenciaTotalSucursal the existenciaTotalSucursal to set
	 */
	public void setExistenciaTotalSucursal(BigDecimal existenciaTotalSucursal) {
		this.existenciaTotalSucursal = existenciaTotalSucursal;
	}
	/**
	 * @return the bloqueado
	 */
	public Integer getBloqueado() {
		return Bloqueado;
	}
	/**
	 * @param bloqueado the bloqueado to set
	 */
	public void setBloqueado(Integer bloqueado) {
		Bloqueado = bloqueado;
	}
}
