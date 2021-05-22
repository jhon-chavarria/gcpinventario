/**
 * 
 */
package ni.com.casapellas.erp.inventario.pojo;

import java.util.List;

import ni.com.casapellas.gcpsisinv.pojo.OrderInventory;
import ni.com.casapellas.gcpsisinv.pojo.WineryInventoryAdditional;
import ni.com.casapellas.gcpsisinv.pojo.WineryInventoryByBranch;
import ni.com.casapellas.gcpsisinv.pojo.WineryInventoryCPD;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Talleres
 * Objetivo       :  
 * Fecha Creacion :  02/02/2015 17:47:22
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */

public class AvailabilityWineryInventory {
	private List<WineryInventoryAdditional> lstWineryInventoryAdditionals;
	private List<WineryInventoryByBranch> lstWineryInventoryByBranchs;
	private List<WineryInventoryCPD> lstWineryInventoryCPDs;
	private List<OrderInventory> lstOrderInventories;
	
	public List<WineryInventoryAdditional> getLstWineryInventoryAdditionals() {
		return lstWineryInventoryAdditionals;
	}
	public void setLstWineryInventoryAdditionals(
			List<WineryInventoryAdditional> lstWineryInventoryAdditionals) {
		this.lstWineryInventoryAdditionals = lstWineryInventoryAdditionals;
	}
	public List<WineryInventoryByBranch> getLstWineryInventoryByBranchs() {
		return lstWineryInventoryByBranchs;
	}
	public void setLstWineryInventoryByBranchs(
			List<WineryInventoryByBranch> lstWineryInventoryByBranchs) {
		this.lstWineryInventoryByBranchs = lstWineryInventoryByBranchs;
	}
	public List<WineryInventoryCPD> getLstWineryInventoryCPDs() {
		return lstWineryInventoryCPDs;
	}
	public void setLstWineryInventoryCPDs(
			List<WineryInventoryCPD> lstWineryInventoryCPDs) {
		this.lstWineryInventoryCPDs = lstWineryInventoryCPDs;
	}
	public List<OrderInventory> getLstOrderInventories() {
		return lstOrderInventories;
	}
	public void setLstOrderInventories(List<OrderInventory> lstOrderInventories) {
		this.lstOrderInventories = lstOrderInventories;
	}
	
}
