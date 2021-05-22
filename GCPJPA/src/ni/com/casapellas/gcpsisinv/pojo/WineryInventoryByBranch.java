/**
 * 
 */
package ni.com.casapellas.gcpsisinv.pojo;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Talleres
 * Objetivo       :  
 * Fecha Creacion :  02/02/2015 09:49:32
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */

public class WineryInventoryByBranch {
	
	private String CodCompania;
	private String CodSucursal;
	private String CodArticulo;
	private int ExisteBodPrincipal;
	private int ReservaBodPrincipal;
	private String DescripSucursal;
	private String SucursalManagua;
	
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
	public int getExisteBodPrincipal() {
		return ExisteBodPrincipal;
	}
	public void setExisteBodPrincipal(int existeBodPrincipal) {
		ExisteBodPrincipal = existeBodPrincipal;
	}
	public int getReservaBodPrincipal() {
		return ReservaBodPrincipal;
	}
	public void setReservaBodPrincipal(int reservaBodPrincipal) {
		ReservaBodPrincipal = reservaBodPrincipal;
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
	public String getCodArticulo() {
		return CodArticulo;
	}
	public void setCodArticulo(String codArticulo) {
		CodArticulo = codArticulo;
	}
}
