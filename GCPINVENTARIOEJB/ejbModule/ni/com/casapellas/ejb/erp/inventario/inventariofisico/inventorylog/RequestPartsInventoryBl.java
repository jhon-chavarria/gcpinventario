package ni.com.casapellas.ejb.erp.inventario.inventariofisico.inventorylog;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ni.com.casapellas.erp.inventario.inventariofisico.inventorylog.ClsInventaryLog;
import ni.com.casapellas.erp.inventario.ventas.proform.ClsRequestPartsInventory;
import ni.com.casapellas.gcpsisinv.pojo.RequestPartsInventory;

/**
 * 
 * @author Luis Fonseca
 *
 */
@Stateless
@LocalBean
public class RequestPartsInventoryBl {
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	
	/**
	 * @author Luis Fonseca
	 * @param strCompanyCode
	 * @param strSucursOrigen
	 * @param strSucursDestiny
	 * @param strDatingCode
	 * @param strProformCode
	 * @param strBudgetCode
	 * @param strProductCode
	 * @return
	 * @throws Exception
	 */
	public List<RequestPartsInventory> getRequestPartsInventory(String strCompanyCode,
																  String strSucursOrigen,
																  String strSucursDestiny,
																  String strDatingCode,
																  String strProformCode,
																  String strWorkshopCode,
																  String strBudgetCode,
																  String strBudgetType,
																  String[] strProductCode) throws Exception
	{
		ClsRequestPartsInventory requestPartsInventory = new ClsRequestPartsInventory();
		return requestPartsInventory.getRequestPartsInventory(em, 
															  strCompanyCode, 
															  strSucursOrigen, 
															  strSucursDestiny, 
															  strDatingCode, 
															  strProformCode,
															  strWorkshopCode,
															  strBudgetCode, 
															  strBudgetType,
															  strProductCode);
	}
	
	/**
	 * @author Luis Fonseca
	 * @param strCompanyCode
	 * @param strSucursOrigen
	 * @param strSucursDestiny
	 * @param strDatingCode
	 * @param strProformCode
	 * @param strBudgetCode
	 * @param strProductCode
	 * @param strProductDescription
	 * @param strQuantity
	 * @param strUserName
	 * @return
	 * @throws Exception
	 */
	public String setRequestPartsInventoryIns(String strCompanyCode,
										  	  String strSucursOrigen,
										  	  String strSucursDestiny,
										  	  String strDatingCode,
										  	  String strProformCode,
										  	  String strBudgetCode,
										  	  String[] strProductCode,
										  	  String[] strProductDescription,
										  	  String[] strQuantity,
										  	  String strUserName) throws Exception
	{
		ClsRequestPartsInventory requestPartsInventory = new ClsRequestPartsInventory();
		
		String sRD = requestPartsInventory.delRequestPartsInventory(em, 
																	   strCompanyCode, 
																	   strSucursOrigen, 
																	   strSucursDestiny, 
																	   strDatingCode, 
																	   strProformCode, 
																	   strBudgetCode, 
																	   null);
		
		if(sRD.equals("N"))
			ClsInventaryLog.StrSQLException(em, "Error al intentar eliminar registros de pedidos de inventarios.");
		
		for(int i = 0; i < strProductCode.length ; i++)
		{
			String sR = requestPartsInventory.setRequestPartsInventoryIns(em, 
																		 strCompanyCode, 
																		 strSucursOrigen, 
																		 strSucursDestiny, 
																		 strDatingCode, 
																		 strProformCode, 
																		 strBudgetCode, 
																		 strProductCode[i], 
																		 strProductDescription[i], 
																		 strQuantity[i], 
																		 strUserName);
			
			if(sR.equals("N"))
				ClsInventaryLog.StrSQLException(em, "Error al intentar insertar el pedido del articulo : " +  strProductCode[i]);
		}
		
		return "S";
	}
}
