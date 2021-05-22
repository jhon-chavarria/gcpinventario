package ni.com.casapellas.rest.erp.inventario.inventariofisico.setting;

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

import ni.com.casapellas.ejb.erp.inventario.inventariofisico.setting.EmailNotificationSettingBl;
import ni.com.casapellas.gcpsisinv.pojo.EmailNotificationSetting;
import ni.com.casapellas.geninfo.pojo.Parameter;
import ni.com.casapellas.rest.erp.inventario.responsecodes.ResponseCodes;

/**
 * 
 * @author Luis Fonseca
 *
 */
@Stateless
@Path("/EmailNotificationSettingRest")
public class EmailNotificationSettingRest {
	@EJB
	private EmailNotificationSettingBl emailNotification;
	@EJB
	private ni.com.casapellas.acces.keyAcces keyAcces;
	
	/**
	 * @author Luis Fonseca
	 * @param map
	 * @param headers
	 * @return
	 */
	@POST
	@Path("/getEmailNotificationSetting")
	@Produces({ MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON})
	public Response getEmailNotificationSetting(Map<String,Parameter> map,
											 @Context HttpHeaders headers)
	{
		Parameter paramCompanyCode= getParameterMap(map, "CompanyCode");
		Parameter paramSucursCode = getParameterMap(map, "SucursCode");
		Parameter paramWareHouse = getParameterMap(map, "WareHouse");
		Parameter paramMoveType = getParameterMap(map, "MoveType");
		
		String[] sCompanyCode = (paramCompanyCode != null) ? paramCompanyCode.getParameters().toArray(
				new String[paramCompanyCode.getParameters().size()]) : null;
				
		String[] sSucursCode = (paramSucursCode != null) ? paramSucursCode.getParameters().toArray(
				new String[paramSucursCode.getParameters().size()]) : null;
				
		String[] sWareHouse = (paramWareHouse != null) ? paramWareHouse.getParameters().toArray(
				new String[paramWareHouse.getParameters().size()]) : null;
				
		String[] sMoveType = (paramMoveType != null) ? paramMoveType.getParameters().toArray(
				new String[paramMoveType.getParameters().size()]) : null; 
		
		try
		{
			List<EmailNotificationSetting> lstEmailNotificationSettings = emailNotification.getEmailNotificationSetting(sCompanyCode[0], 
																														sSucursCode[0], 
																														sWareHouse[0], 
																														sMoveType[0]);
			
			GenericEntity<List<EmailNotificationSetting>> listentity = 
		            new GenericEntity<List<EmailNotificationSetting>>(lstEmailNotificationSettings) {};
		    
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
	@Path("/setEmailNotificationSetting")
	public Response setEmailNotificationSetting(Map<String,Parameter> map,
											 @Context HttpHeaders headers)
	{
		Parameter paramCompanyCode= getParameterMap(map, "CompanyCode");
		Parameter paramSucursCode = getParameterMap(map, "SucursCode");
		Parameter paramWareHouse = getParameterMap(map, "WareHouse");
		Parameter paramMoveType = getParameterMap(map, "MoveType");
		
		Parameter paramPrimaryEmail = getParameterMap(map, "PrimaryEmail");
		Parameter paramSecundaryEmail = getParameterMap(map, "SecundaryEmail");
		Parameter paramUserName = getParameterMap(map, "UserName");
		
		String[] sPrimaryEmail = (paramPrimaryEmail != null) ? paramPrimaryEmail.getParameters().toArray(
				new String[paramPrimaryEmail.getParameters().size()]) : null;
				
		String[] sSecundaryEmail = (paramSecundaryEmail != null) ? paramSecundaryEmail.getParameters().toArray(
				new String[paramSecundaryEmail.getParameters().size()]) : null;
				
		String[] sUserName = (paramUserName != null) ? paramUserName.getParameters().toArray(
				new String[paramUserName.getParameters().size()]) : null;
				
		String[] sCompanyCode = (paramCompanyCode != null) ? paramCompanyCode.getParameters().toArray(
				new String[paramCompanyCode.getParameters().size()]) : null;
				
		String[] sSucursCode = (paramSucursCode != null) ? paramSucursCode.getParameters().toArray(
				new String[paramSucursCode.getParameters().size()]) : null;
				
		String[] sWareHouse = (paramWareHouse != null) ? paramWareHouse.getParameters().toArray(
				new String[paramWareHouse.getParameters().size()]) : null;
				
		String[] sMoveType = (paramMoveType != null) ? paramMoveType.getParameters().toArray(
				new String[paramMoveType.getParameters().size()]) : null; 
		
		try
		{
			
			String sResult = "";
			for(int i = 0; i < sMoveType.length; i ++)
			{
				sResult = emailNotification.setEmailNotificationSetting(sCompanyCode[i], 
																		   sSucursCode[i], 
																		   sWareHouse[i], 
																		   sMoveType[i], 
																		   sPrimaryEmail[i], 
																		   sSecundaryEmail[i], 
																		   sUserName[i]);
				
				if(!sResult.equals("S"))
					break;
			}
			
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
