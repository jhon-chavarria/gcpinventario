/**
 * 
 */
package ni.com.casapellas.rest.erp.inventario.inventariofisico.inventoryavailability;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ni.com.casapellas.ejb.erp.inventario.inventariofisico.inventoryavailability.InventoryAvailabilityBl;
import ni.com.casapellas.erp.inventario.pojo.AvailabilityWineryInventory;
import ni.com.casapellas.gcpsisinv.pojo.OrderInventory;
import ni.com.casapellas.geninfo.pojo.Parameter;
import ni.com.casapellas.rest.erp.inventario.responsecodes.ResponseCodes;
import ni.com.casapellas.restful.ResponseCode;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Talleres
 * Objetivo       :  
 * Fecha Creacion :  02/02/2015 18:38:54
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */
@Stateless
@Path("/InventoryAvailabilityRest")
public class InventoryAvailabilityRest {
	@EJB
	private InventoryAvailabilityBl inventoryAvailabilityBl;
	@EJB
	private ni.com.casapellas.acces.keyAcces keyAcces;
	
	@POST
	@Path("/getInventoryAvailability")
	@Produces({ MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON})
	public Response getInventoryAvailability(Map<String,Parameter> map,
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
		
		String[] strProductCode = (paramProductCode != null) ? paramProductCode.getParameters().toArray(
				new String[paramProductCode.getParameters().size()]) : null; 
		
		try
		{
			List<AvailabilityWineryInventory> lstAvailabilityWineryInventories = inventoryAvailabilityBl.getAvailabilityWineryInventory(strProductCode);
			
//			System.out.println("Lista de : " + lstAvailabilityWineryInventories.size());
			GenericEntity<List<AvailabilityWineryInventory>> listentity = 
		            new GenericEntity<List<AvailabilityWineryInventory>>(lstAvailabilityWineryInventories) {};
		    
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
	@Path("/getOrderInventory")
	@Produces({ MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON})
	public Response getOrderInventory(Map<String,Parameter> map,
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
		Parameter paramOrderNumber = getParameterMap(map, "OrderNumber");
		Parameter paramOrderDate1 = getParameterMap(map, "OrderDate1");
		Parameter paramOrderDate2 = getParameterMap(map, "OrderDate2");
		
		String[] strProductCode = (paramProductCode != null) ? paramProductCode.getParameters().toArray(
				new String[paramProductCode.getParameters().size()]) : null; 
				
		String[] strOrderNumber = (paramOrderNumber != null) ? paramOrderNumber.getParameters().toArray(
				new String[paramOrderNumber.getParameters().size()]) : null; 
				
		String[] strOrderDate1 = (paramOrderDate1 != null) ? paramOrderDate1.getParameters().toArray(
				new String[paramOrderDate1.getParameters().size()]) : null; 
				
		String[] strOrderDate2 = (paramOrderDate2 != null) ? paramOrderDate2.getParameters().toArray(
				new String[paramOrderDate2.getParameters().size()]) : null; 
				
		try
		{
			List<OrderInventory> lstOI = inventoryAvailabilityBl.getOrderInventory(strOrderNumber[0], 
																				   strProductCode, 
																				   strOrderDate1[0], 
																				   strOrderDate2[0]); 
			
//			System.out.println("Lista de : " + lstOI.size());
			GenericEntity<List<OrderInventory>> listentity = 
		            new GenericEntity<List<OrderInventory>>(lstOI) {};
		    
			return Response.status(201).entity(listentity).build();
			
		}
		catch(Exception e)
		{
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
