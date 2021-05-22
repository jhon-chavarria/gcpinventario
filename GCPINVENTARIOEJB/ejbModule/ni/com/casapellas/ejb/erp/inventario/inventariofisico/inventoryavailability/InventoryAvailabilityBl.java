/**
 * 
 */
package ni.com.casapellas.ejb.erp.inventario.inventariofisico.inventoryavailability;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ni.com.casapellas.erp.inventario.inventariofisico.inventoryavailability.ClsWineryInventoryAdditional;
import ni.com.casapellas.erp.inventario.inventariofisico.inventoryavailability.ClsWineryInventoryByBranch;
import ni.com.casapellas.erp.inventario.inventariofisico.inventoryavailability.ClsWineryInventoryCPD;
import ni.com.casapellas.erp.inventario.pojo.AvailabilityWineryInventory;
import ni.com.casapellas.erp.inventario.ventas.proform.ClsOrderInventory;
import ni.com.casapellas.gcpsisinv.pojo.OrderInventory;
import ni.com.casapellas.gcpsisinv.pojo.WineryInventoryAdditional;
import ni.com.casapellas.gcpsisinv.pojo.WineryInventoryByBranch;
import ni.com.casapellas.gcpsisinv.pojo.WineryInventoryCPD;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Talleres
 * Objetivo       :  
 * Fecha Creacion :  02/02/2015 17:43:44
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */
@Stateless
@LocalBean
public class InventoryAvailabilityBl {
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	
	
	// override method
	public List<AvailabilityWineryInventory> getAvailabilityWineryInventory(String[] strProductCode) throws Exception {
		return getAvailabilityWineryInventory(strProductCode, null);
	}
		
		
	public List<AvailabilityWineryInventory> getAvailabilityWineryInventory(String[] strProductCode, String companyId) throws Exception
	{
		List<AvailabilityWineryInventory> lstAvailabilityWineryInventories = new ArrayList<AvailabilityWineryInventory>();
		
		try
		{
			ClsWineryInventoryAdditional clsWineryInventoryAdditional = new ClsWineryInventoryAdditional();
			ClsWineryInventoryByBranch clsWineryInventoryByBranch = new ClsWineryInventoryByBranch();
			ClsWineryInventoryCPD clsWineryInventoryCPD = new ClsWineryInventoryCPD();
			ClsOrderInventory clsOrderInventory = new ClsOrderInventory();
			
			List<WineryInventoryCPD> lstInventoryCPDs = clsWineryInventoryCPD.getWineryInventoryCPD(em, strProductCode, companyId);
			List<WineryInventoryAdditional> lstInventoryAdditionals = clsWineryInventoryAdditional.getWineryInventoryAdditional(em, 
																																null, 
																																null, 
																																null,
																																strProductCode);
			List<WineryInventoryByBranch> lstInventoryByBranchs = clsWineryInventoryByBranch.getWineryInventoryByBranch(em, 
																														null, 
																														null, 
																														strProductCode);
			
			List<OrderInventory> lstOrderInventories = clsOrderInventory.getOrderInventory(em, 
																						   null, 
																						   strProductCode, 
																						   null, 
																						   null, 
																						   "A");
			
			AvailabilityWineryInventory awi = new AvailabilityWineryInventory();
			awi.setLstWineryInventoryAdditionals(lstInventoryAdditionals);
			awi.setLstWineryInventoryByBranchs(lstInventoryByBranchs);
			awi.setLstWineryInventoryCPDs(lstInventoryCPDs);
			awi.setLstOrderInventories(lstOrderInventories);
			
			lstAvailabilityWineryInventories.add(awi);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return lstAvailabilityWineryInventories;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param strOrderNumber
	 * @param strProductCode
	 * @param strOrderDate1
	 * @param strOrderDate2
	 * @return
	 * @throws Exception
	 */
	public List<OrderInventory> getOrderInventory(String strOrderNumber,
												  String[] strProductCode,
												  String strOrderDate1,
												  String strOrderDate2) throws Exception
	{
		ClsOrderInventory orderInventory = new ClsOrderInventory();
		List<OrderInventory> lstOrderInventories = orderInventory.getOrderInventory(em, 
																					strOrderNumber, 
																					strProductCode, 
																					strOrderDate1, 
																					strOrderDate2, 
																					"A");
		
		return lstOrderInventories;
	}
}
