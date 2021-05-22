package ni.com.casapellas.gcpmcaja.pojos;

/**
 * 
 * Descripcion de CatalogoCuentas.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Aug 3, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class CatalogoCuentas {
	private String sucursal;
	private String idCuenta;
	private String unidadNegocio;
	private String objeto;
	private String sub;
	private String descripcionCuenta;
	
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public String getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}
	public String getUnidadNegocio() {
		return unidadNegocio;
	}
	public void setUnidadNegocio(String unidadNegocio) {
		this.unidadNegocio = unidadNegocio;
	}
	public String getObjeto() {
		return objeto;
	}
	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getDescripcionCuenta() {
		return descripcionCuenta;
	}
	public void setDescripcionCuenta(String descripcionCuenta) {
		this.descripcionCuenta = descripcionCuenta;
	}
}
