package ni.com.casapellas.gcpinventario;

import java.math.BigDecimal;

public class InvExistGlobal {
	private String compania;
	private String sucursal;
	private String bodega;
	private String linea;
	private String articulo;
	private BigDecimal existencia;
	private BigDecimal existenciaTotal;
	private BigDecimal costo;
	private BigDecimal costoSucursal;
	private String iFile;
	private String iPfile;
	/**
	 * @return the compania
	 */
	public String getCompania() {
		return compania;
	}
	
	/**
	 * @param compania the compania to set
	 */
	public void setCompania(String compania) {
		this.compania = compania;
	}
	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * @return the bodega
	 */
	public String getBodega() {
		return bodega;
	}
	/**
	 * @param bodega the bodega to set
	 */
	public void setBodega(String bodega) {
		this.bodega = bodega;
	}
	/**
	 * @return the linea
	 */
	public String getLinea() {
		return linea;
	}
	/**
	 * @param linea the linea to set
	 */
	public void setLinea(String linea) {
		this.linea = linea;
	}
	/**
	 * @return the articulo
	 */
	public String getArticulo() {
		return articulo;
	}
	/**
	 * @param articulo the articulo to set
	 */
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	/**
	 * @return the existencia
	 */
	public BigDecimal getExistencia() {
		return existencia;
	}
	/**
	 * @param existencia the existencia to set
	 */
	public void setExistencia(BigDecimal existencia) {
		this.existencia = existencia;
	}
	/**
	 * @return the existenciaTotal
	 */
	public BigDecimal getExistenciaTotal() {
		return existenciaTotal;
	}

	/**
	 * @param existenciaTotal the existenciaTotal to set
	 */
	public void setExistenciaTotal(BigDecimal existenciaTotal) {
		this.existenciaTotal = existenciaTotal;
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
	 * @return the costoSucursal
	 */
	public BigDecimal getCostoSucursal() {
		return costoSucursal;
	}

	/**
	 * @param costoSucursal the costoSucursal to set
	 */
	public void setCostoSucursal(BigDecimal costoSucursal) {
		this.costoSucursal = costoSucursal;
	}

	/**
	 * @return the iFile
	 */
	public String getiFile() {
		return iFile;
	}
	/**
	 * @param iFile the iFile to set
	 */
	public void setiFile(String iFile) {
		this.iFile = iFile;
	}
	/**
	 * @return the iPfile
	 */
	public String getiPfile() {
		return iPfile;
	}
	/**
	 * @param iPfile the iPfile to set
	 */
	public void setiPfile(String iPfile) {
		this.iPfile = iPfile;
	}
}
