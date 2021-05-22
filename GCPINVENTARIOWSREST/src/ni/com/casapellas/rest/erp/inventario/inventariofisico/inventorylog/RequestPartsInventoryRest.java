package ni.com.casapellas.rest.erp.inventario.inventariofisico.inventorylog;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import ni.com.casapellas.ejb.erp.inventario.inventariofisico.inventorylog.RequestPartsInventoryBl;
import ni.com.casapellas.gcpsisinv.pojo.RequestPartsInventory;
import ni.com.casapellas.geninfo.pojo.Parameter;
import ni.com.casapellas.rest.erp.inventario.responsecodes.ResponseCodes;
import ni.com.casapellas.restful.ResponseCode;

/**
 * 
 * @author Luis Fonseca
 *
 */
@Stateless
@Path("/RequestPartsInventoryRest/")
public class RequestPartsInventoryRest {
	@EJB
	private RequestPartsInventoryBl requestPartsInventory;
	@EJB
	private ni.com.casapellas.acces.keyAcces keyAcces;
	
	/**
	 * @author Luis Fonseca
	 * @param map
	 * @param headers
	 * @return
	 */
	@POST
	@Path("/getRequestPartsInventory")
	public Response getRequestPartsInventory(Map<String,Parameter> map,
											 @Context HttpHeaders headers)
	{
		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}
		
		Parameter paramCompanyCode = getParameterMap(map, "CompanyCode");
		Parameter paramSucursOrigen = getParameterMap(map, "SucursOrigen");
		Parameter paramSucursDestiny = getParameterMap(map, "SucursDestiny");
		Parameter paramDatingCode = getParameterMap(map, "DatingCode");
		Parameter paramProductCode = getParameterMap(map, "ProductCode");
		Parameter paramProformCode = getParameterMap(map, "ProformCode");
		Parameter paramBudgetCode = getParameterMap(map, "BudgetCode");
		
		Parameter paramBudgetType = getParameterMap(map, "BudgetType");
		Parameter paramWorkshopCode = getParameterMap(map, "WorkshopCode");
		
		String[] strBudgetType = (paramBudgetType != null) ? paramBudgetType.getParameters().toArray(
				new String[paramBudgetType.getParameters().size()]) : null;
				
		String[] strWorkshopCode = (paramWorkshopCode != null) ? paramWorkshopCode.getParameters().toArray(
				new String[paramWorkshopCode.getParameters().size()]) : null;
				
				
		String[] strProductCode = (paramProductCode != null) ? paramProductCode.getParameters().toArray(
				new String[paramProductCode.getParameters().size()]) : null;
				
		String[] strCompanyCode = (paramCompanyCode != null) ? paramCompanyCode.getParameters().toArray(
				new String[paramCompanyCode.getParameters().size()]) : null;
				
		String[] strSucursOrigen = (paramSucursOrigen != null) ? paramSucursOrigen.getParameters().toArray(
				new String[paramSucursOrigen.getParameters().size()]) : null;
				
		String[] strSucursDestiny = (paramSucursDestiny != null) ? paramSucursDestiny.getParameters().toArray(
				new String[paramSucursDestiny.getParameters().size()]) : null;
				
		String[] strDatingCode = (paramDatingCode != null) ? paramDatingCode.getParameters().toArray(
				new String[paramDatingCode.getParameters().size()]) : null;
				
		String[] strProformCode = (paramProformCode != null) ? paramProformCode.getParameters().toArray(
				new String[paramProformCode.getParameters().size()]) : null;
				
		String[] strBudgetCode = (paramBudgetCode != null) ? paramBudgetCode.getParameters().toArray(
				new String[paramBudgetCode.getParameters().size()]) : null; 
		
		try
		{
			List<RequestPartsInventory> lstRequestPartsInventory = requestPartsInventory.getRequestPartsInventory(strCompanyCode[0], 
																												  strSucursOrigen[0], 
																												  strSucursDestiny[0], 
																												  strDatingCode[0], 
																												  strProformCode[0],
																												  strWorkshopCode[0],
																												  strBudgetCode[0], 
																												  strBudgetType[0],
																												  strProductCode);
			
			GenericEntity<List<RequestPartsInventory>> listentity = 
		            new GenericEntity<List<RequestPartsInventory>>(lstRequestPartsInventory) {};
		    
			return Response.status(201).entity(listentity).build();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	/**
	 * @author Luis Fonseca
	 * @param map
	 * @param headers
	 * @return
	 */
	@POST
	@Path("/setRequestPartsInventoryIns")
	public Response setRequestPartsInventoryIns(Map<String,Parameter> map,
											 @Context HttpHeaders headers)
	{
		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}
		
		Parameter paramCompanyCode = getParameterMap(map, "CompanyCode");
		Parameter paramSucursOrigen = getParameterMap(map, "SucursOrigen");
		Parameter paramSucursDestiny = getParameterMap(map, "SucursDestiny");
		Parameter paramDatingCode = getParameterMap(map, "DatingCode");
		Parameter paramProductCode = getParameterMap(map, "ProductCode");
		Parameter paramProformCode = getParameterMap(map, "ProformCode");
		Parameter paramBudgetCode = getParameterMap(map, "BudgetCode");
		
		Parameter paramProductDescription = getParameterMap(map, "ProductDescription");
		Parameter paramQuantity = getParameterMap(map, "Quantity");
		Parameter paramUserName = getParameterMap(map, "UserName");
		
		String[] strProductDescription = (paramProductDescription != null) ? paramProductDescription.getParameters().toArray(
				new String[paramProductCode.getParameters().size()]) : null;
				
		String[] strQuantity = (paramQuantity != null) ? paramQuantity.getParameters().toArray(
				new String[paramProductCode.getParameters().size()]) : null;
				
		String[] strUserName = (paramUserName != null) ? paramUserName.getParameters().toArray(
				new String[paramUserName.getParameters().size()]) : null;
		
		String[] strProductCode = (paramProductCode != null) ? paramProductCode.getParameters().toArray(
				new String[paramProductCode.getParameters().size()]) : null;
				
		String[] strCompanyCode = (paramCompanyCode != null) ? paramCompanyCode.getParameters().toArray(
				new String[paramCompanyCode.getParameters().size()]) : null;
				
		String[] strSucursOrigen = (paramSucursOrigen != null) ? paramSucursOrigen.getParameters().toArray(
				new String[paramSucursOrigen.getParameters().size()]) : null;
				
		String[] strSucursDestiny = (paramSucursDestiny != null) ? paramSucursDestiny.getParameters().toArray(
				new String[paramSucursDestiny.getParameters().size()]) : null;
				
		String[] strDatingCode = (paramDatingCode != null) ? paramDatingCode.getParameters().toArray(
				new String[paramDatingCode.getParameters().size()]) : null;
				
		String[] strProformCode = (paramProformCode != null) ? paramProformCode.getParameters().toArray(
				new String[paramProformCode.getParameters().size()]) : null;
				
		String[] strBudgetCode = (paramBudgetCode != null) ? paramBudgetCode.getParameters().toArray(
				new String[paramBudgetCode.getParameters().size()]) : null; 
		
		try
		{
			String sResultado = requestPartsInventory.setRequestPartsInventoryIns(strCompanyCode[0], 
																				  strSucursOrigen[0], 
																				  strSucursDestiny[0], 
																				  strDatingCode[0], 
																				  strProformCode[0], 
																				  strBudgetCode[0], 
																				  strProductCode, 
																				  strProductDescription, 
																				  strQuantity, 
																				  strUserName[0]);
			
			
			return ResponseCodes.status201(sResultado);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	/**
	 * @author Luis Fonseca
	 * @param map
	 * @param key
	 * @return
	 */
	private static Parameter getParameterMap(Map<String,Parameter> map, 
											 String key){
		Parameter parameter = null;
		if(map.containsKey(key)){
			parameter =  map.get(key);
		}
		return parameter;
	}
}
