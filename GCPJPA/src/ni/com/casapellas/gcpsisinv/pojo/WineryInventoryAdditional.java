/**
 * 
 */
package ni.com.casapellas.gcpsisinv.pojo;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Talleres
 * Objetivo       :  
 * Fecha Creacion :  02/02/2015 11:59:36
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */

public class WineryInventoryAdditional {

	private String CodCompania;
	private String CodSucursal;
	private String CodBodega;
	private String CodArticulo;
	private int Existencia;
	private int Reservas;
	
	private String DescripSucursal;
	private String SucursalManagua;
	
	private String Ubicacion;
	
	
	public String getDescripSucursal() {
		return DescripSucursal;
	}
	public void setDescripSucursal(String descripSucursal) {
		DescripSucursal = descripSucursal;
	}
	public String getSucursalManagua() {
		return SucursalManagua;
	}
	public void setSucursalManagua(String sucursalManagua) {
		SucursalManagua = sucursalManagua;
	}
	public int getExistencia() {
		return Existencia;
	}
	public void setExistencia(int existencia) {
		Existencia = existencia;
	}
	public int getReservas() {
		return Reservas;
	}
	public void setReservas(int reservas) {
		Reservas = reservas;
	}
	public String getCodCompania() {
		return CodCompania;
	}
	public void setCodCompania(String codCompania) {
		CodCompania = codCompania;
	}
	public String getCodSucursal() {
		return CodSucursal;
	}
	public void setCodSucursal(String codSucursal) {
		CodSucursal = codSucursal;
	}
	public String getCodBodega() {
		return CodBodega;
	}
	public void setCodBodega(String codBodega) {
		CodBodega = codBodega;
	}
	public String getCodArticulo() {
		return CodArticulo;
	}
	public void setCodArticulo(String codArticulo) {
		CodArticulo = codArticulo;
	}
	public String getUbicacion() {
		return Ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		Ubicacion = ubicacion;
	}
	
}
