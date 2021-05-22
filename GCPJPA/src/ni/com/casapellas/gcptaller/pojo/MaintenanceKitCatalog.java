/**
 * 
 */
package ni.com.casapellas.gcptaller.pojo;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Talleres
 * Objetivo       :  
 * Fecha Creacion :  23/02/2015 11:21:32
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */

public class MaintenanceKitCatalog {
	private String CodigoKit;
	private String KitMantenimiento;
	
	public String getCodigoKit() {
		return CodigoKit;
	}
	public void setCodigoKit(String codigoKit) {
		CodigoKit = codigoKit;
	}
	public String getKitMantenimiento() {
		return KitMantenimiento;
	}
	public void setKitMantenimiento(String kitMantenimiento) {
		KitMantenimiento = kitMantenimiento;
	}
}
