package ni.com.casapellas.rest.erp.inventario.cponline;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import ni.com.casapellas.ejb.erp.inventario.cponline.SolicitudDespachoBl;
import ni.com.casapellas.gcpsisinv.pojo.SolicitudDespachoCabecera;
import ni.com.casapellas.gcpsisinv.pojo.SolicitudDespachoDetalle;
import ni.com.casapellas.geninfo.pojo.Parameter;
import ni.com.casapellas.rest.erp.inventario.responsecodes.ResponseCodes;
import ni.com.casapellas.restful.ResponseCode;

/**
 * 
 * @author luisfonseca
 *
 */
@Stateless
@Path("/SolicitudDespachoRest/")
public class SolicitudDespachoRest {
	@EJB
	private SolicitudDespachoBl solicitudDespacho;
	@EJB
	private ni.com.casapellas.acces.keyAcces keyAcces;
	
	/**
	 * @author luisfonseca
	 * @param headers
	 * @return
	 */
	@GET
	@Path("/getControlSolicitudDespachoC")
	@Produces({ MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON})
	public Response getControlSolicitudDespachoC(@Context HttpHeaders headers)
	{
		if (!keyAcces.requestAccess(headers)) {
  			return ResponseCode.status403();
  		}
		
		String strTsNumeroSolicitud = headers.getRequestHeaders().get("NumeroSolicitud").get(0);
		String strTsCodigoCliente = headers.getRequestHeaders().get("CodigoCliente").get(0);
		String strTsUnidadNegocio = headers.getRequestHeaders().get("UnidadNegocio").get(0);
		String strTsNumeroCotizacion = headers.getRequestHeaders().get("NumeroCotizacion").get(0);

		Gson gson = new Gson();
		
		Parameter paramNumeroSolicitud =  (strTsNumeroSolicitud.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsNumeroSolicitud, Parameter.class);
		Parameter paramCodigoCliente =  (strTsCodigoCliente.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsCodigoCliente, Parameter.class);
		Parameter paramUnidadNegocio =  (strTsUnidadNegocio.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsUnidadNegocio, Parameter.class);
		Parameter paramNumeroCotizacion =  (strTsNumeroCotizacion.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsNumeroCotizacion, Parameter.class);

		String[] strNumeroSolicitud = (paramNumeroSolicitud != null) ? paramNumeroSolicitud.getParameters().toArray( new String[paramNumeroSolicitud.getParameters().size()]) : null;
		String[] strCodigoCliente = (paramCodigoCliente != null) ? paramCodigoCliente.getParameters().toArray( new String[paramCodigoCliente.getParameters().size()]) : null;
		String[] strUnidadNegocio = (paramUnidadNegocio != null) ? paramUnidadNegocio.getParameters().toArray( new String[paramUnidadNegocio.getParameters().size()]) : null;
		String[] strNumeroCotizacion = (paramNumeroCotizacion != null) ? paramNumeroCotizacion.getParameters().toArray( new String[paramNumeroCotizacion.getParameters().size()]) : null;
					
		try
		{
			List<SolicitudDespachoCabecera> lstSDC = solicitudDespacho.getControlSolicitudDespachoC(strNumeroSolicitud[0], 
																									strUnidadNegocio[0], 
																									strNumeroCotizacion[0], 
																									strCodigoCliente[0]);
			
			GenericEntity<List<SolicitudDespachoCabecera>> listentity = 
		            new GenericEntity<List<SolicitudDespachoCabecera>>(lstSDC) {};

			return Response.status(201).entity(listentity).build();
		}
		catch(Exception e)
		{
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	/**
	 * @author luisfonseca
	 * @param headers
	 * @return
	 */
	@GET
	@Path("/getControlSolicitudDespachoD")
	@Produces({ MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON})
	public Response getControlSolicitudDespachoD(@Context HttpHeaders headers)
	{
		if (!keyAcces.requestAccess(headers)) {
  			return ResponseCode.status403();
  		}
		
		String strTsNumeroSolicitud = headers.getRequestHeaders().get("NumeroSolicitud").get(0);
		String strTsCodigoArticulo = headers.getRequestHeaders().get("CodigoArticulo").get(0);
		String strTsChasis = headers.getRequestHeaders().get("Chasis").get(0);

		Gson gson = new Gson();
		
		Parameter paramNumeroSolicitud =  (strTsNumeroSolicitud.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsNumeroSolicitud, Parameter.class);
		Parameter paramCodigoArticulo =  (strTsCodigoArticulo.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsCodigoArticulo, Parameter.class);
		Parameter paramChasis =  (strTsChasis.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsChasis, Parameter.class);

		String[] strNumeroSolicitud = (paramNumeroSolicitud != null) ? paramNumeroSolicitud.getParameters().toArray( new String[paramNumeroSolicitud.getParameters().size()]) : null;
		String[] strCodigoArticulo = (paramCodigoArticulo != null) ? paramCodigoArticulo.getParameters().toArray( new String[paramCodigoArticulo.getParameters().size()]) : null;
		String[] strChasis = (paramChasis != null) ? paramChasis.getParameters().toArray( new String[paramChasis.getParameters().size()]) : null;
		
		try
		{
			List<SolicitudDespachoDetalle> lstSDC = solicitudDespacho.getControlSolicitudDespachoD(strNumeroSolicitud[0], 
																									strCodigoArticulo[0], 
																									strChasis[0]);
			
			GenericEntity<List<SolicitudDespachoDetalle>> listentity = 
		            new GenericEntity<List<SolicitudDespachoDetalle>>(lstSDC) {};

			return Response.status(201).entity(listentity).build();
		}
		catch(Exception e)
		{
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	/**
	 * @author luisfonseca
	 * @param headers
	 * @return
	 */
	@POST
	@Path("/setControlSolicitudDespachoCIns")
	public Response setControlSolicitudDespachoCIns(@Context HttpHeaders headers)
	{
		if (!keyAcces.requestAccess(headers)) {
  			return ResponseCode.status403();
  		}
		
		String strTsCodCompania = headers.getRequestHeaders().get("CodCompania").get(0);
		String strTsCodSucursal = headers.getRequestHeaders().get("CodSucursal").get(0);
		String strTsCodUniNeg = headers.getRequestHeaders().get("CodUniNeg").get(0);
		String strTsNoCotizacion = headers.getRequestHeaders().get("NoCotizacion").get(0);
		String strTsCodCliente = headers.getRequestHeaders().get("CodCliente").get(0);
		String strTsUsuarioCreo = headers.getRequestHeaders().get("UsuarioCreo").get(0);
		String strTsPantallaCreo = headers.getRequestHeaders().get("PantallaCreo").get(0);
		String strTsProgramaCreo = headers.getRequestHeaders().get("ProgramaCreo").get(0);
		
		Gson gson = new Gson();
		
		Parameter paramCodCompania =  (strTsCodCompania.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsCodCompania, Parameter.class);
		Parameter paramCodSucursal =  (strTsCodSucursal.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsCodSucursal, Parameter.class);
		Parameter paramCodUniNeg =  (strTsCodUniNeg.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsCodUniNeg, Parameter.class);
		Parameter paramNoCotizacion =  (strTsNoCotizacion.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsNoCotizacion, Parameter.class);
		Parameter paramCodCliente =  (strTsCodCliente.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsCodCliente, Parameter.class);
		Parameter paramUsuarioCreo =  (strTsUsuarioCreo.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsUsuarioCreo, Parameter.class);
		Parameter paramPantallaCreo =  (strTsPantallaCreo.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsPantallaCreo, Parameter.class);
		Parameter paramProgramaCreo =  (strTsProgramaCreo.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsProgramaCreo, Parameter.class);
		
		String[] strCodCompania = (paramCodCompania != null) ? paramCodCompania.getParameters().toArray( new String[paramCodCompania.getParameters().size()]) : null;
		String[] strCodSucursal = (paramCodSucursal != null) ? paramCodSucursal.getParameters().toArray( new String[paramCodSucursal.getParameters().size()]) : null;
		String[] strCodUniNeg = (paramCodUniNeg != null) ? paramCodUniNeg.getParameters().toArray( new String[paramCodUniNeg.getParameters().size()]) : null;
		String[] strNoCotizacion = (paramNoCotizacion != null) ? paramNoCotizacion.getParameters().toArray( new String[paramNoCotizacion.getParameters().size()]) : null;
		String[] strCodCliente = (paramCodCliente != null) ? paramCodCliente.getParameters().toArray( new String[paramCodCliente.getParameters().size()]) : null;
		String[] strUsuarioCreo = (paramUsuarioCreo != null) ? paramUsuarioCreo.getParameters().toArray( new String[paramUsuarioCreo.getParameters().size()]) : null;
		String[] strPantallaCreo = (paramPantallaCreo != null) ? paramPantallaCreo.getParameters().toArray( new String[paramPantallaCreo.getParameters().size()]) : null;
		String[] strProgramaCreo = (paramProgramaCreo != null) ? paramProgramaCreo.getParameters().toArray( new String[paramProgramaCreo.getParameters().size()]) : null;
		
		try
		{
			String strResultado = solicitudDespacho.setControlSolicitudDespachoCIns(strCodCompania[0], 
																				    strCodSucursal[0], 
																				    strCodUniNeg[0], 
																				    strNoCotizacion[0], 
																				    strCodCliente[0], 
																				    strUsuarioCreo[0], 
																				    strPantallaCreo[0], 
																				    strProgramaCreo[0]);
			
			return ResponseCodes.status201(strResultado);
		}
		catch(Exception e)
		{
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	/**
	 * @author luisfonseca
	 * @param headers
	 * @return
	 */
	@POST
	@Path("/setControlSolicitudDespachoDIns")
	public Response setControlSolicitudDespachoDIns(@Context HttpHeaders headers)
	{
		if (!keyAcces.requestAccess(headers)) {
  			return ResponseCode.status403();
  		}
		
		String strTsCodCompania = headers.getRequestHeaders().get("CodCompaniaDesp").get(0);
		String strTsCodSucursal = headers.getRequestHeaders().get("CodSucursalDesp").get(0);
		String strTsCodUniNeg = headers.getRequestHeaders().get("CodUniNegDesp").get(0);
		String strTsIdSolicitud = headers.getRequestHeaders().get("IdSolicitud").get(0);
		String strTsCodArticulo = headers.getRequestHeaders().get("CodArticulo").get(0);
		String strTsCodSerie = headers.getRequestHeaders().get("CodSerie").get(0);
		String strTsNoChasis = headers.getRequestHeaders().get("NoChasis").get(0);
		String strTsPrecio = headers.getRequestHeaders().get("Precio").get(0);
		String strTsCosto = headers.getRequestHeaders().get("Costo").get(0);
		String strTsDescuento = headers.getRequestHeaders().get("Descuento").get(0);
		String strTsCantidad = headers.getRequestHeaders().get("Cantidad").get(0);
		String strTsEstado = headers.getRequestHeaders().get("Estado").get(0);
		String strTsSIM = headers.getRequestHeaders().get("CodSIM").get(0);
		String strTsUsuarioCreo = headers.getRequestHeaders().get("UsuarioCreo").get(0);
		String strTsPantallaCreo = headers.getRequestHeaders().get("PantallaCreo").get(0);
		String strTsProgramaCreo = headers.getRequestHeaders().get("ProgramaCreo").get(0);
		
		Gson gson = new Gson();
		
		Parameter paramCodCompania =  (strTsCodCompania.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsCodCompania, Parameter.class);
		Parameter paramCodSucursal =  (strTsCodSucursal.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsCodSucursal, Parameter.class);
		Parameter paramCodUniNeg =  (strTsCodUniNeg.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsCodUniNeg, Parameter.class);
		Parameter paramIdSolicitud =  (strTsIdSolicitud.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsIdSolicitud, Parameter.class);
		Parameter paramCodArticulo =  (strTsCodArticulo.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsCodArticulo, Parameter.class);
		Parameter paramCodSerie =  (strTsCodSerie.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsCodSerie, Parameter.class);
		Parameter paramNoChasis =  (strTsNoChasis.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsNoChasis, Parameter.class);
		Parameter paramPrecio =  (strTsPrecio.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsPrecio, Parameter.class);
		Parameter paramCosto =  (strTsCosto.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsCosto, Parameter.class);
		Parameter paramDescuento =  (strTsDescuento.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsDescuento, Parameter.class);
		Parameter paramCantidad =  (strTsCantidad.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsCantidad, Parameter.class);
		Parameter paramEstado =  (strTsEstado.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsEstado, Parameter.class);
		Parameter paramSIM =  (strTsSIM.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsSIM, Parameter.class);
		Parameter paramUsuarioCreo =  (strTsUsuarioCreo.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsUsuarioCreo, Parameter.class);
		Parameter paramPantallaCreo =  (strTsPantallaCreo.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsPantallaCreo, Parameter.class);
		Parameter paramProgramaCreo =  (strTsProgramaCreo.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsProgramaCreo, Parameter.class);
		
		String[] strCodCompaniaDesp = (paramCodCompania != null) ? paramCodCompania.getParameters().toArray( new String[paramCodCompania.getParameters().size()]) : null;
		String[] strCodSucursalDesp = (paramCodSucursal != null) ? paramCodSucursal.getParameters().toArray( new String[paramCodSucursal.getParameters().size()]) : null;
		String[] strCodUniNegDesp = (paramCodUniNeg != null) ? paramCodUniNeg.getParameters().toArray( new String[paramCodUniNeg.getParameters().size()]) : null;
		String[] strIdSolicitud = (paramIdSolicitud != null) ? paramIdSolicitud.getParameters().toArray( new String[paramIdSolicitud.getParameters().size()]) : null;
		String[] strCodArticulo = (paramCodArticulo != null) ? paramCodArticulo.getParameters().toArray( new String[paramCodArticulo.getParameters().size()]) : null;
		String[] strCodSerie = (paramCodSerie != null) ? paramCodSerie.getParameters().toArray( new String[paramCodSerie.getParameters().size()]) : null;
		String[] strNoChasis = (paramNoChasis != null) ? paramNoChasis.getParameters().toArray( new String[paramNoChasis.getParameters().size()]) : null;
		String[] strPrecio = (paramPrecio != null) ? paramPrecio.getParameters().toArray( new String[paramPrecio.getParameters().size()]) : null;
		String[] strCosto = (paramCosto != null) ? paramCosto.getParameters().toArray( new String[paramCosto.getParameters().size()]) : null;
		String[] strDescuento = (paramDescuento != null) ? paramDescuento.getParameters().toArray( new String[paramDescuento.getParameters().size()]) : null;
		String[] strCantidad = (paramCantidad != null) ? paramCantidad.getParameters().toArray( new String[paramCantidad.getParameters().size()]) : null;
		String[] strEstado = (paramEstado != null) ? paramEstado.getParameters().toArray( new String[paramEstado.getParameters().size()]) : null;
		String[] strSIM = (paramSIM != null) ? paramSIM.getParameters().toArray( new String[paramSIM.getParameters().size()]) : null;
		String[] strUsuarioCreo = (paramUsuarioCreo != null) ? paramUsuarioCreo.getParameters().toArray( new String[paramUsuarioCreo.getParameters().size()]) : null;
		String[] strPantallaCreo = (paramPantallaCreo != null) ? paramPantallaCreo.getParameters().toArray( new String[paramPantallaCreo.getParameters().size()]) : null;
		String[] strProgramaCreo = (paramProgramaCreo != null) ? paramProgramaCreo.getParameters().toArray( new String[paramProgramaCreo.getParameters().size()]) : null;
		
		try
		{
			String strResultado = solicitudDespacho.setControlSolicitudDespachoDIns(strIdSolicitud[0], 
																					strCodCompaniaDesp[0], 
																					strCodSucursalDesp[0], 
																					strCodUniNegDesp[0], 
																					strCodArticulo[0], 
																					strCodSerie[0], 
																					strNoChasis[0], 
																					strPrecio[0], 
																					strCosto[0], 
																					strDescuento[0], 
																					strCantidad[0], 
																					strEstado[0], 
																					strSIM[0],
																					strUsuarioCreo[0], 
																					strPantallaCreo[0], 
																					strProgramaCreo[0]);
			
			return ResponseCodes.status201(strResultado);
		}
		catch(Exception e)
		{
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	/**
	 * @author luisfonseca
	 * @param headers
	 * @return
	 */
	@POST
	@Path("/setControlSolicitudDespachoIns")
	public Response setControlSolicitudDespachoIns(Map<String,Parameter> map, @Context HttpHeaders headers)
	{
		if (!keyAcces.requestAccess(headers)) {
  			return ResponseCode.status403();
  		}
		
		String strTsCodCompania = headers.getRequestHeaders().get("CodCompania").get(0);
		String strTsCodSucursal = headers.getRequestHeaders().get("CodSucursal").get(0);
		String strTsCodUniNeg = headers.getRequestHeaders().get("CodUniNeg").get(0);
		String strTsNoCotizacion = headers.getRequestHeaders().get("NoCotizacion").get(0);
		String strTsCodCliente = headers.getRequestHeaders().get("CodCliente").get(0);
		String strTsUsuarioCreo = headers.getRequestHeaders().get("UsuarioCreo").get(0);
		String strTsPantallaCreo = headers.getRequestHeaders().get("PantallaCreo").get(0);
		String strTsProgramaCreo = headers.getRequestHeaders().get("ProgramaCreo").get(0);
		
		Gson gson = new Gson();
		
		Parameter paramCodCompania =  (strTsCodCompania.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsCodCompania, Parameter.class);
		Parameter paramCodSucursal =  (strTsCodSucursal.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsCodSucursal, Parameter.class);
		Parameter paramCodUniNeg =  (strTsCodUniNeg.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsCodUniNeg, Parameter.class);
		Parameter paramNoCotizacion =  (strTsNoCotizacion.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsNoCotizacion, Parameter.class);
		Parameter paramCodCliente =  (strTsCodCliente.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsCodCliente, Parameter.class);
		Parameter paramUsuarioCreo =  (strTsUsuarioCreo.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsUsuarioCreo, Parameter.class);
		Parameter paramPantallaCreo =  (strTsPantallaCreo.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsPantallaCreo, Parameter.class);
		Parameter paramProgramaCreo =  (strTsProgramaCreo.compareToIgnoreCase("") == 0) ? null : gson.fromJson(strTsProgramaCreo, Parameter.class);
		
		String[] strCodCompania = (paramCodCompania != null) ? paramCodCompania.getParameters().toArray( new String[paramCodCompania.getParameters().size()]) : null;
		String[] strCodSucursal = (paramCodSucursal != null) ? paramCodSucursal.getParameters().toArray( new String[paramCodSucursal.getParameters().size()]) : null;
		String[] strCodUniNeg = (paramCodUniNeg != null) ? paramCodUniNeg.getParameters().toArray( new String[paramCodUniNeg.getParameters().size()]) : null;
		String[] strNoCotizacion = (paramNoCotizacion != null) ? paramNoCotizacion.getParameters().toArray( new String[paramNoCotizacion.getParameters().size()]) : null;
		String[] strCodCliente = (paramCodCliente != null) ? paramCodCliente.getParameters().toArray( new String[paramCodCliente.getParameters().size()]) : null;
		String[] strUsuarioCreo = (paramUsuarioCreo != null) ? paramUsuarioCreo.getParameters().toArray( new String[paramUsuarioCreo.getParameters().size()]) : null;
		String[] strPantallaCreo = (paramPantallaCreo != null) ? paramPantallaCreo.getParameters().toArray( new String[paramPantallaCreo.getParameters().size()]) : null;
		String[] strProgramaCreo = (paramProgramaCreo != null) ? paramProgramaCreo.getParameters().toArray( new String[paramProgramaCreo.getParameters().size()]) : null;
		
		
		//----------------------------------------
		
		Parameter paramCodCompaniaDesp =  getParameterMap(map, "CodCompaniaDesp");
		Parameter paramCodSucursalDesp =  getParameterMap(map, "CodSucursalDesp");
		Parameter paramCodUniNegDesp =  getParameterMap(map, "UniNegDesp");
		Parameter paramCodArticulo =  getParameterMap(map, "CodArticulo");
		Parameter paramCodSerie =  getParameterMap(map, "CodSerie");
		Parameter paramNoChasis =  getParameterMap(map, "NoChasis");
		Parameter paramPrecio =  getParameterMap(map, "Precio");
		Parameter paramCosto =  getParameterMap(map, "Costo");
		Parameter paramDescuento =  getParameterMap(map, "Descuento");
		Parameter paramCantidad =  getParameterMap(map, "Cantidad");
		Parameter paramEstado =  getParameterMap(map, "Estado");
		Parameter paramCodSIM =  getParameterMap(map, "CodSIM");
		
		String[] strCodCompaniaDesp = (paramCodCompaniaDesp != null) ? paramCodCompaniaDesp.getParameters().toArray( new String[paramCodCompaniaDesp.getParameters().size()]) : null;
		String[] strCodSucursalDesp = (paramCodSucursalDesp != null) ? paramCodSucursalDesp.getParameters().toArray( new String[paramCodSucursalDesp.getParameters().size()]) : null;
		String[] strCodUniNegDesp = (paramCodUniNegDesp != null) ? paramCodUniNegDesp.getParameters().toArray( new String[paramCodUniNegDesp.getParameters().size()]) : null;
		String[] strCodArticulo = (paramCodArticulo != null) ? paramCodArticulo.getParameters().toArray( new String[paramCodArticulo.getParameters().size()]) : null;
		String[] strCodSerie = (paramCodSerie != null) ? paramCodSerie.getParameters().toArray( new String[paramCodSerie.getParameters().size()]) : null;
		String[] strNoChasis = (paramNoChasis != null) ? paramNoChasis.getParameters().toArray( new String[paramNoChasis.getParameters().size()]) : null;
		String[] strPrecio = (paramPrecio != null) ? paramPrecio.getParameters().toArray( new String[paramPrecio.getParameters().size()]) : null;
		String[] strCosto = (paramCosto != null) ? paramCosto.getParameters().toArray( new String[paramCosto.getParameters().size()]) : null;
		String[] strDescuento = (paramDescuento != null) ? paramDescuento.getParameters().toArray( new String[paramDescuento.getParameters().size()]) : null;
		String[] strCantidad = (paramCantidad != null) ? paramCantidad.getParameters().toArray( new String[paramCantidad.getParameters().size()]) : null;
		String[] strEstado = (paramEstado != null) ? paramEstado.getParameters().toArray( new String[paramEstado.getParameters().size()]) : null;
		String[] strSIM = (paramCodSIM != null) ? paramCodSIM.getParameters().toArray( new String[paramCodSIM.getParameters().size()]) : null;
		
		//----------------------------------------
		try
		{
			String strResultado = solicitudDespacho.setControlSolicitudDespachoIns(strCodCompania[0], 
																				   strCodSucursal[0], 
																				   strCodUniNeg[0], 
																				   strNoCotizacion[0], 
																				   strCodCliente[0], 
																				   strCodCompaniaDesp, 
																				   strCodSucursalDesp, 
																				   strCodUniNegDesp, 
																				   strCodArticulo, 
																				   strCodSerie, 
																				   strNoChasis, 
																				   strPrecio, 
																				   strCosto, 
																				   strDescuento, 
																				   strCantidad, 
																				   strEstado, 
																				   strSIM,
																				   strUsuarioCreo[0], 
																				   strPantallaCreo[0], 
																				   strProgramaCreo[0]);
			
			return ResponseCodes.status201(strResultado);
		}
		catch(Exception e)
		{
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	/**
	 * @author Luis Fonseca
	 * @param map
	 * @param key
	 * @return
	 */
	private static Parameter getParameterMap(Map<String,Parameter> map, String key){
		Parameter parameter = null;
		if(map.containsKey(key)){
			parameter =  map.get(key);
		}
		return parameter;
	}
}
