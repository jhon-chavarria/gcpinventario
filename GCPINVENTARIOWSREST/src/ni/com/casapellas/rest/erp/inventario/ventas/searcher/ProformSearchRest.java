/**
 * 
 */
package ni.com.casapellas.rest.erp.inventario.ventas.searcher;

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

import ni.com.casapellas.ejb.erp.inventario.ventas.searcher.ProformSearch;
import ni.com.casapellas.gcpsisinv.pojo.Proform;
import ni.com.casapellas.geninfo.pojo.Parameter;
import ni.com.casapellas.restful.ResponseCode;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Talleres
 * Objetivo       :  
 * Fecha Creacion :  19/01/2015 16:11:16
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */
@Stateless
@Path("/ProformSearchRest")
public class ProformSearchRest {
	@EJB
	private ni.com.casapellas.acces.keyAcces keyAcces;
	@EJB
	private ProformSearch proformSearch;
	
	/**
	 * @author Luis Fonseca
	 * @param headers
	 * @return
	 */
	@GET
	@Path("/getProform")
	@Produces({ MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON})
	public Response getProformSearchList(@Context HttpHeaders headers)
	{
//		for (String header : headers.getRequestHeaders().keySet()) {
//			System.out.println(header + " : "
//					+ headers.getRequestHeader(header));
//		}
		
		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}
		
		String tsCompanyCode = headers.getRequestHeaders().get("CompanyCode").get(0);
		String tsSearchItem = headers.getRequestHeaders().get("SearchItem").get(0);
		
		Gson gson = new Gson();
		
		Parameter paramCompanyCode = (tsCompanyCode.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsCompanyCode, Parameter.class);
		Parameter paramSearchItem = (tsSearchItem.compareToIgnoreCase("") == 0) ? null : gson.fromJson(tsSearchItem, Parameter.class);
		
		String[] sCompanyCode = (paramCompanyCode != null) ? paramCompanyCode.getParameters().toArray(
						new String[paramCompanyCode.getParameters().size()]) : null;
				
		String[] sSearchItem = (paramSearchItem != null) ? paramSearchItem.getParameters().toArray(
						new String[paramSearchItem.getParameters().size()]) : null;
						
		List<Proform> lstP = proformSearch.getProformList(sCompanyCode[0], sSearchItem[0]);
		
//		System.out.println("Lista de : " + lstP.size());
		GenericEntity<List<Proform>> listentity = 
	            new GenericEntity<List<Proform>>(lstP) {};
	    
		return Response.status(201).entity(listentity).build();
	}
}
