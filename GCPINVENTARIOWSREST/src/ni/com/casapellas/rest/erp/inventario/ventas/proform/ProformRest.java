package ni.com.casapellas.rest.erp.inventario.ventas.proform;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import ni.com.casapellas.ejb.erp.inventario.ventas.proform.ProformBl;
import ni.com.casapellas.gcpsisinv.pojo.Proform;
import ni.com.casapellas.geninfo.pojo.Parameter;
import ni.com.casapellas.rest.erp.inventario.responsecodes.ResponseCodes;
import ni.com.casapellas.restful.ResponseCode;

/**
 * 
 * @author Luis Fonseca
 *
 */
@Stateless
@Path("/ProFormRest")
public class ProformRest {
	@EJB
	private ProformBl proform;
	@EJB
	private ni.com.casapellas.acces.keyAcces keyAcces;
	
	/**
	 * @author Luis Fonseca
	 * @param headers
	 * @return
	 */
	@GET
	@Path("/getProform")
	@Produces({ MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON})
	public Response getProformList(@Context HttpHeaders headers)
	{
//		for (String header : headers.getRequestHeaders().keySet()) {
//			System.out.println(header + " : "
//					+ headers.getRequestHeader(header));
//		}
		
		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}
		
		String tsCompanyCode = headers.getRequestHeaders().get("CompanyCode").get(0);
		
		String tsProformNumber = headers.getRequestHeaders().get("ProformNumber").get(0);
		String tsCustomerCode = headers.getRequestHeaders().get("CustomerCode").get(0);
		String tsChassis = headers.getRequestHeaders().get("Chassis").get(0);
		
		Gson gson = new Gson();
		
		Parameter paramCompanyCode = (tsCompanyCode.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsCompanyCode, Parameter.class);
		Parameter paramProformNumber = (tsProformNumber.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsProformNumber, Parameter.class);
		Parameter paramCustomerCode = (tsCustomerCode.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsCustomerCode, Parameter.class);
		Parameter paramChassis = (tsChassis.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsChassis, Parameter.class);
		
		String tsSucursCode = headers.getRequestHeaders().get("SucursCode").get(0);
		String tsWareHouse = headers.getRequestHeaders().get("WareHouse").get(0);
		
		Parameter paramSucursCode = (tsSucursCode.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsSucursCode, Parameter.class);
		Parameter paramWareHouse = (tsWareHouse.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsWareHouse, Parameter.class);
		
		String[] sSucursCode = (paramSucursCode != null) ? paramSucursCode.getParameters().toArray(
				new String[paramSucursCode.getParameters().size()]) : null;
				
		String[] sWareHouse = (paramWareHouse != null) ? paramWareHouse.getParameters().toArray(
				new String[paramWareHouse.getParameters().size()]) : null;
				
		String[] sCompanyCode = (paramCompanyCode != null) ? paramCompanyCode.getParameters().toArray(
				new String[paramCompanyCode.getParameters().size()]) : null;
				
		String[] sProformNumber = (paramProformNumber != null) ? paramProformNumber.getParameters().toArray(
				new String[paramProformNumber.getParameters().size()]) : null;
				
		String[] sCustomerCode = (paramCustomerCode != null) ? paramCustomerCode.getParameters().toArray(
				new String[paramCustomerCode.getParameters().size()]) : null;
		
		String[] sChassis = (paramChassis != null) ? paramChassis.getParameters().toArray(
				new String[paramChassis.getParameters().size()]) : null;
				
		try {
			List<Proform> lstP = proform.getProformList(sCompanyCode[0], 
														sSucursCode[0],
														sWareHouse[0],
														sProformNumber[0], 
														sCustomerCode[0], 
														sChassis[0]);
			
//			System.out.println("Lista de : " + lstP.size());
			GenericEntity<List<Proform>> listentity = 
		            new GenericEntity<List<Proform>>(lstP) {};
		    
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	/**
	 * @author Luis Fonseca
	 * @param headers
	 * @return
	 */
	@GET
	@Path("/getProformAll")
	@Produces({ MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON})
	public Response getProformAll(@Context HttpHeaders headers)
	{
//			for (String header : headers.getRequestHeaders().keySet()) {
//				System.out.println(header + " : "
//						+ headers.getRequestHeader(header));
//			}
		
		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}
		
		String tsCompanyCode = headers.getRequestHeaders().get("CompanyCode").get(0);
		String tsProformNumber = headers.getRequestHeaders().get("ProformNumber").get(0);
		String tsBudgetCode = headers.getRequestHeaders().get("BudgetCode").get(0);
		String tsItemCode = headers.getRequestHeaders().get("ItemCode").get(0);
		
		Gson gson = new Gson();
		
		Parameter paramCompanyCode = (tsCompanyCode.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsCompanyCode, Parameter.class);
		Parameter paramProformNumber = (tsProformNumber.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsProformNumber, Parameter.class);
		Parameter paramBudgetCode = (tsBudgetCode.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsBudgetCode, Parameter.class);
		Parameter paramItemCode = (tsItemCode.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsItemCode, Parameter.class);
		
		String tsSucursCode = headers.getRequestHeaders().get("SucursCode").get(0);
		String tsWareHouse = headers.getRequestHeaders().get("WareHouse").get(0);
		
		Parameter paramSucursCode = (tsSucursCode.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsSucursCode, Parameter.class);
		Parameter paramWareHouse = (tsWareHouse.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsWareHouse, Parameter.class);
		
		String tsWorkshopCode = headers.getRequestHeaders().get("WorkshopCode").get(0);
		String tsBudgetType = headers.getRequestHeaders().get("BudgetType").get(0);
		
		Parameter paramWorkshopCode = (tsWorkshopCode.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsWorkshopCode, Parameter.class);
		Parameter paramBudgetType = (tsBudgetType.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsBudgetType, Parameter.class);
		
		String tsBudgetApp = headers.getRequestHeaders().get("BudgetApp").get(0);
		String tsBudgetDate = headers.getRequestHeaders().get("BudgetDate").get(0);
		
		Parameter paramBudgetApp = (tsBudgetApp.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsBudgetApp, Parameter.class);
		Parameter paramBudgetDate = (tsBudgetDate.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsBudgetDate, Parameter.class);
		
		String[] sBudgetApp = (paramBudgetApp != null) ? paramBudgetApp.getParameters().toArray(
				new String[paramBudgetApp.getParameters().size()]) : null;
				
		String[] sBudgetDate = (paramBudgetDate != null) ? paramBudgetDate.getParameters().toArray(
				new String[paramBudgetDate.getParameters().size()]) : null;
				
		String[] sWorkshopCode = (paramWorkshopCode != null) ? paramWorkshopCode.getParameters().toArray(
				new String[paramWorkshopCode.getParameters().size()]) : null;
				
		String[] sBudgetType = (paramBudgetType != null) ? paramBudgetType.getParameters().toArray(
				new String[paramBudgetType.getParameters().size()]) : null;
				
		String[] sSucursCode = (paramSucursCode != null) ? paramSucursCode.getParameters().toArray(
				new String[paramSucursCode.getParameters().size()]) : null;
				
		String[] sWareHouse = (paramWareHouse != null) ? paramWareHouse.getParameters().toArray(
				new String[paramWareHouse.getParameters().size()]) : null;
				
		String[] sCompanyCode = (paramCompanyCode != null) ? paramCompanyCode.getParameters().toArray(
				new String[paramCompanyCode.getParameters().size()]) : null;
				
		String[] sProformNumber = (paramProformNumber != null) ? paramProformNumber.getParameters().toArray(
				new String[paramProformNumber.getParameters().size()]) : null;
				
		String[] sBudgetCode = (paramBudgetCode != null) ? paramBudgetCode.getParameters().toArray(
				new String[paramBudgetCode.getParameters().size()]) : null;
		
		String[] sItemCode = (paramItemCode != null) ? paramItemCode.getParameters().toArray(
				new String[paramItemCode.getParameters().size()]) : null;
				
		try {
			List<Proform> lstP = proform.getProformAll(sCompanyCode[0], 
														sSucursCode[0],
														sWareHouse[0],
														sProformNumber[0], 
														sWorkshopCode[0],
														sBudgetCode,
														sBudgetType,
														sBudgetDate,
														sBudgetApp,
														sItemCode[0]);
			
//				System.out.println("Lista de : " + lstP.size());
			GenericEntity<List<Proform>> listentity = 
		            new GenericEntity<List<Proform>>(lstP) {};
		    
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
}
