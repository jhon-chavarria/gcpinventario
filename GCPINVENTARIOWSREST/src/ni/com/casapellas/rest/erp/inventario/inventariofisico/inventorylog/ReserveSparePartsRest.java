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

import ni.com.casapellas.ejb.erp.inventario.inventariofisico.inventorylog.InventoryLogBl;
import ni.com.casapellas.ejb.erp.inventario.inventariofisico.inventorylog.ReserveSparePartsBl;
import ni.com.casapellas.gcpsisinv.pojo.InventoryLog;
import ni.com.casapellas.geninfo.pojo.Parameter;
import ni.com.casapellas.rest.erp.inventario.responsecodes.ResponseCodes;
import ni.com.casapellas.restful.ResponseCode;

/**
 * 
 * @author Luis Fonseca
 *
 */
@Stateless
@Path("/ReserveSparePartsRest/")
public class ReserveSparePartsRest {
	@EJB
	private ReserveSparePartsBl reserveSpareParts;
	@EJB
	private InventoryLogBl inventoryLog;
	@EJB
	private ni.com.casapellas.acces.keyAcces keyAcces;
	
	/**
	 * @author Luis Fonseca
	 * @param map
	 * @param headers
	 * @return
	 */
	@POST
	@Path("/getReserveSpareParts")
	public Response getReserveSpareParts(Map<String,Parameter> map,
											 @Context HttpHeaders headers)
	{
		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Parameter paramWareHouse = getParameterMap(map, "WareHouse");
		Parameter paramSucursCode = getParameterMap(map, "SucursCode");
		Parameter paramCompanyCode = getParameterMap(map, "CompanyCode");
		
		Parameter paramProformNumber = getParameterMap(map, "ProformNumber");
		Parameter paramBudgetNumber = getParameterMap(map, "BudgetNumber");
		
		String[] strBudgetNumber = (paramBudgetNumber != null) ? paramBudgetNumber.getParameters().toArray(
				new String[paramBudgetNumber.getParameters().size()]) : null;
				
		String[] strProformNumber = (paramProformNumber != null) ? paramProformNumber.getParameters().toArray(
				new String[paramProformNumber.getParameters().size()]) : null;

		String[] strWareHouse = (paramWareHouse != null) ? paramWareHouse.getParameters().toArray(
				new String[paramWareHouse.getParameters().size()]) : null;
				
		String[] strSucursCode = (paramSucursCode != null) ? paramSucursCode.getParameters().toArray(
				new String[paramSucursCode.getParameters().size()]) : null;
				
		String[] strCompanyCode = (paramCompanyCode != null) ? paramCompanyCode.getParameters().toArray(
				new String[paramCompanyCode.getParameters().size()]) : null; 
		
		try
		{

			
			List<InventoryLog> lstIL = reserveSpareParts.getReserveSpareParts(strCompanyCode[0], 
																			  strSucursCode[0], 
																			  strWareHouse[0],
																			  strProformNumber[0], 
																			  strBudgetNumber[0]);
			
			GenericEntity<List<InventoryLog>> listentity = 
	            new GenericEntity<List<InventoryLog>>(lstIL) {};
		    
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
	@Path("/getReserveSparePartsByDating")
	public Response getReserveSparePartsByDating(Map<String,Parameter> map,
											 @Context HttpHeaders headers)
	{
		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Parameter paramDatingNumer = getParameterMap(map, "DatingNumer");
		Parameter paramWorkshopCode = getParameterMap(map, "WorkshopCode");
		Parameter paramCompanyCode = getParameterMap(map, "CompanyCode");
		
		Parameter paramDateInitial = getParameterMap(map, "DateInitial");
		Parameter paramDateFinal = getParameterMap(map, "DateFinal");
		
		String[] strDateFinal = (paramDateFinal != null) ? paramDateFinal.getParameters().toArray(
				new String[paramDateFinal.getParameters().size()]) : null;
				
		String[] strDateInitial = (paramDateInitial != null) ? paramDateInitial.getParameters().toArray(
				new String[paramDateInitial.getParameters().size()]) : null;

		String[] strDatingNumer = (paramDatingNumer != null) ? paramDatingNumer.getParameters().toArray(
				new String[paramDatingNumer.getParameters().size()]) : null;
				
		String[] strWorkshopCode = (paramWorkshopCode != null) ? paramWorkshopCode.getParameters().toArray(
				new String[paramWorkshopCode.getParameters().size()]) : null;
				
		String[] strCompanyCode = (paramCompanyCode != null) ? paramCompanyCode.getParameters().toArray(
				new String[paramCompanyCode.getParameters().size()]) : null; 
		
		try
		{

			
			List<InventoryLog> lstIL = reserveSpareParts.getReserveSparePartsByDating(strCompanyCode[0], 
																					  strWorkshopCode[0], 
																					  strDatingNumer[0], 
																					  strDateInitial[0], 
																					  strDateFinal[0]);
			
			GenericEntity<List<InventoryLog>> listentity = 
	            new GenericEntity<List<InventoryLog>>(lstIL) {};
		    
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
	@Path("/setReserveSpareParts")
	public Response setReserveSpareParts(Map<String,Parameter> map,
											 @Context HttpHeaders headers)
	{
//		for (String header : headers.getRequestHeaders().keySet()) {
//			System.out.println(header + " : "
//					+ headers.getRequestHeader(header));
//		}
		
		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}
		
		Parameter paramProductCode = getParameterMap(map, "ProductCode");
		Parameter paramWareHouse = getParameterMap(map, "WareHouse");
		Parameter paramSucursCode = getParameterMap(map, "SucursCode");
		Parameter paramCompanyCode = getParameterMap(map, "CompanyCode");
		
		Parameter paramProformNumber = getParameterMap(map, "ProformNumber");
		Parameter paramBudgetNumber = getParameterMap(map, "BudgetNumber");
		Parameter paramQuantityReserve = getParameterMap(map, "QuantityReserve");
		Parameter paramCPD1Reserve = getParameterMap(map, "CPD1Reserve");
		Parameter paramCPD8Reserve = getParameterMap(map, "CPD8Reserve");
		Parameter paramCustomerCode = getParameterMap(map, "CustomerCode");
		
		Parameter paramCustomerName = getParameterMap(map, "CustomerName");
		Parameter paramUserName = getParameterMap(map, "UserName");
		
		String[] strCPD8Reserve = (paramCPD8Reserve != null) ? paramCPD8Reserve.getParameters().toArray(
				new String[paramCPD8Reserve.getParameters().size()]) : null;
				
		String[] strUserName = (paramUserName != null) ? paramUserName.getParameters().toArray(
				new String[paramUserName.getParameters().size()]) : null;
				
		String[] strCustomerName = (paramCustomerName != null) ? paramCustomerName.getParameters().toArray(
				new String[paramCustomerName.getParameters().size()]) : null;
				
		String[] strProductCode = (paramProductCode != null) ? paramProductCode.getParameters().toArray(
				new String[paramProductCode.getParameters().size()]) : null;
				
		String[] strCustomerCode = (paramCustomerCode != null) ? paramCustomerCode.getParameters().toArray(
				new String[paramCustomerCode.getParameters().size()]) : null;
				
		String[] strCPD1Reserve = (paramCPD1Reserve != null) ? paramCPD1Reserve.getParameters().toArray(
				new String[paramCPD1Reserve.getParameters().size()]) : null;
				
		String[] strQuantityReserve = (paramQuantityReserve != null) ? paramQuantityReserve.getParameters().toArray(
				new String[paramQuantityReserve.getParameters().size()]) : null;
				
		String[] strBudgetNumber = (paramBudgetNumber != null) ? paramBudgetNumber.getParameters().toArray(
				new String[paramBudgetNumber.getParameters().size()]) : null;
				
		String[] strProformNumber = (paramProformNumber != null) ? paramProformNumber.getParameters().toArray(
				new String[paramProformNumber.getParameters().size()]) : null;

				
		String[] strWareHouse = (paramWareHouse != null) ? paramWareHouse.getParameters().toArray(
				new String[paramWareHouse.getParameters().size()]) : null;
				
		String[] strSucursCode = (paramSucursCode != null) ? paramSucursCode.getParameters().toArray(
				new String[paramSucursCode.getParameters().size()]) : null;
				
		String[] strCompanyCode = (paramCompanyCode != null) ? paramCompanyCode.getParameters().toArray(
				new String[paramCompanyCode.getParameters().size()]) : null; 
		
		try
		{
			if(strProductCode.length == 0)
				return ResponseCodes.status201("Error al momento de intentar leer los codigos de productos");
			
			String sDocumentNumber = inventoryLog.getDocumentNumberInv(strCompanyCode[0], 
																	   strSucursCode[0], 
																	   strWareHouse[0], 
																	   "RE");
			
			
			String sResult = reserveSpareParts.setReserveSpareParts(strCompanyCode[0], 
																	strSucursCode[0], 
																	strWareHouse[0], 
																	sDocumentNumber, 
																	strProformNumber[0], 
																	strBudgetNumber[0], 
																	strProductCode, 
																	strQuantityReserve,  
																	strCPD1Reserve, 
																	strCPD8Reserve, 
																	strCustomerCode[0], 
																	strCustomerName[0], 
																	strUserName[0]);
			
			if(sResult.equals("N"))
				throw new Exception("Error al momento de reservar inventario.");
				
			
			
			return ResponseCodes.status201(sDocumentNumber);
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
	@Path("/setUnReserveSpareParts")
	public Response setUnReserveSpareParts(Map<String,Parameter> map,
											 @Context HttpHeaders headers)
	{
//		for (String header : headers.getRequestHeaders().keySet()) {
//			System.out.println(header + " : "
//					+ headers.getRequestHeader(header));
//		}
		
		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}
		
		Parameter paramProductCode = getParameterMap(map, "ProductCode");
		Parameter paramWareHouse = getParameterMap(map, "WareHouse");
		Parameter paramSucursCode = getParameterMap(map, "SucursCode");
		Parameter paramCompanyCode = getParameterMap(map, "CompanyCode");
		
		Parameter paramProformNumber = getParameterMap(map, "ProformNumber");
		Parameter paramBudgetNumber = getParameterMap(map, "BudgetNumber");
		Parameter paramQuantityReserve = getParameterMap(map, "QuantityReserve");
		Parameter paramCPD1Reserve = getParameterMap(map, "CPD1Reserve");
		Parameter paramCPD8Reserve = getParameterMap(map, "CPD8Reserve");
		Parameter paramCustomerCode = getParameterMap(map, "CustomerCode");
		
		Parameter paramCustomerName = getParameterMap(map, "CustomerName");
		Parameter paramUserName = getParameterMap(map, "UserName");
		
		String[] strCPD8Reserve = (paramCPD8Reserve != null) ? paramCPD8Reserve.getParameters().toArray(
				new String[paramCPD8Reserve.getParameters().size()]) : null;
				
		String[] strUserName = (paramUserName != null) ? paramUserName.getParameters().toArray(
				new String[paramUserName.getParameters().size()]) : null;
				
		String[] strCustomerName = (paramCustomerName != null) ? paramCustomerName.getParameters().toArray(
				new String[paramCustomerName.getParameters().size()]) : null;
				
		String[] strProductCode = (paramProductCode != null) ? paramProductCode.getParameters().toArray(
				new String[paramProductCode.getParameters().size()]) : null;
				
		String[] strCustomerCode = (paramCustomerCode != null) ? paramCustomerCode.getParameters().toArray(
				new String[paramCustomerCode.getParameters().size()]) : null;
				
		String[] strCPD1Reserve = (paramCPD1Reserve != null) ? paramCPD1Reserve.getParameters().toArray(
				new String[paramCPD1Reserve.getParameters().size()]) : null;
				
		String[] strQuantityReserve = (paramQuantityReserve != null) ? paramQuantityReserve.getParameters().toArray(
				new String[paramQuantityReserve.getParameters().size()]) : null;
				
		String[] strBudgetNumber = (paramBudgetNumber != null) ? paramBudgetNumber.getParameters().toArray(
				new String[paramBudgetNumber.getParameters().size()]) : null;
				
		String[] strProformNumber = (paramProformNumber != null) ? paramProformNumber.getParameters().toArray(
				new String[paramProformNumber.getParameters().size()]) : null;
				
		String[] strWareHouse = (paramWareHouse != null) ? paramWareHouse.getParameters().toArray(
				new String[paramWareHouse.getParameters().size()]) : null;
				
		String[] strSucursCode = (paramSucursCode != null) ? paramSucursCode.getParameters().toArray(
				new String[paramSucursCode.getParameters().size()]) : null;
				
		String[] strCompanyCode = (paramCompanyCode != null) ? paramCompanyCode.getParameters().toArray(
				new String[paramCompanyCode.getParameters().size()]) : null; 
		
		try
		{
			if(strProductCode.length == 0)
				return ResponseCodes.status201("Error al momento de intentar leer los codigos de productos");
			
			String sResult = "N";
			sResult = reserveSpareParts.setUnReserveSpareParts(strCompanyCode[0], 
															  strSucursCode[0], 
															  strWareHouse[0], 
															  strProformNumber[0], 
															  strBudgetNumber[0], 
															  strProductCode, 
															  strQuantityReserve, 
															  strCPD1Reserve, 
															  strCPD8Reserve, 
															  strCustomerCode[0], 
															  strCustomerName[0], 
															  strUserName[0]);
			
			if(sResult.equals("N"))
				throw new Exception("Error al momento de reservar inventario.");
				
			
			
			return ResponseCodes.status201(sResult);
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
