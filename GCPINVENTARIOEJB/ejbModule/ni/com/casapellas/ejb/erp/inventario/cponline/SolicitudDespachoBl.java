package ni.com.casapellas.ejb.erp.inventario.cponline;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ni.com.casapellas.erp.inventario.cponline.ClsSolicitudDespacho;
import ni.com.casapellas.gcpsisinv.pojo.SolicitudDespachoCabecera;
import ni.com.casapellas.gcpsisinv.pojo.SolicitudDespachoDetalle;

/**
 * 
 * @author luisfonseca
 *
 */
@Stateless
@LocalBean
public class SolicitudDespachoBl {
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	
	/**
	 * @author luisfonseca
	 * @param strNumeroSolicitud
	 * @param strUnidadNegocio
	 * @param strNumeroCotizacion
	 * @param strCodigoCliente
	 * @return
	 * @throws Exception
	 */
	public List<SolicitudDespachoCabecera> getControlSolicitudDespachoC(String strNumeroSolicitud, 
					  										  	        String strUnidadNegocio, 
					  										  	        String strNumeroCotizacion, 
					  										  	        String strCodigoCliente) throws Exception
	{
		
		try
		{
			ClsSolicitudDespacho solicitudDespacho = new ClsSolicitudDespacho();
			return solicitudDespacho.getControlSolicitudDespachoC(em, 
																  strNumeroSolicitud, 
																  strUnidadNegocio, 
																  strNumeroCotizacion, 
																  strCodigoCliente);
			

			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * @author luisfonseca
	 * @param strNumeroSolicitud
	 * @param strCodigoArticulo
	 * @param strChasis
	 * @return
	 * @throws Exception
	 */
	public List<SolicitudDespachoDetalle> getControlSolicitudDespachoD(String strNumeroSolicitud, 
					  										  	        String strCodigoArticulo, 
					  										  	        String strChasis) throws Exception
	{
		try
		{
			ClsSolicitudDespacho solicitudDespacho = new ClsSolicitudDespacho();
			return solicitudDespacho.getControlSolicitudDespachoD(em, 
																  strNumeroSolicitud, 
																  strCodigoArticulo, 
																  strChasis);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
	
	
	/**
	 * @author luisfonseca
	 * @param strCodCompania
	 * @param strCodSucursal
	 * @param strCodUniNeg
	 * @param strNoCotizacion
	 * @param strCodCliente
	 * @param strUsuarioCreo
	 * @param strFechaCreo
	 * @param strHoraCreo
	 * @param strPantallaCreo
	 * @param strProgramaCreo
	 * @return
	 * @throws Exception
	 */
	public String setControlSolicitudDespachoCIns(String strCodCompania, 
         									      String strCodSucursal, 
         									      String strCodUniNeg, 
         									      String strNoCotizacion, 
         									      String strCodCliente, 
         									      String strUsuarioCreo, 
         									      String strPantallaCreo, 
         									      String strProgramaCreo) throws Exception
	{
		try
		{
			ClsSolicitudDespacho solicitudDespacho = new ClsSolicitudDespacho();
			return solicitudDespacho.setControlSolicitudDespachoCIns(em, 
																	 strCodCompania, 
																	 strCodSucursal, 
																	 strCodUniNeg, 
																	 strNoCotizacion, 
																	 strCodCliente, 
																	 strUsuarioCreo, 
																	 strPantallaCreo, 
																	 strProgramaCreo);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * @author luisfonseca
	 * @param strCodCompania
	 * @param strCodSucursal
	 * @param strCodUniNeg
	 * @param strNoCotizacion
	 * @param strCodCliente
	 * @param strUsuarioCreo
	 * @param strFechaCreo
	 * @param strHoraCreo
	 * @param strPantallaCreo
	 * @param strProgramaCreo
	 * @return
	 * @throws Exception
	 */
	public String setControlSolicitudDespachoDIns(String strIdSolicitud,
         									   	  String strCodCompaniaDesp, 
         									   	  String strCodSucursalDesp, 
         									   	  String strCodUniNegDesp, 
         									   	  String strCodArticulo, 
         									   	  String strCodSerie, 
         									   	  String strNoChasis, 
         									   	  String strPrecio, 
         									   	  String strCosto, 
         									   	  String strDescuento,
         									   	  String strCantidad,
         									   	  String strEstado,
         									   	  String strSIM,
         									   	  String strUsuarioCreo, 
         									   	  String strPantallaCreo, 
         									   	  String strProgramaCreo) throws Exception
	{
		try
		{
			ClsSolicitudDespacho solicitudDespacho = new ClsSolicitudDespacho();
			return solicitudDespacho.setControlSolicitudDespachoDIns(em, 
																	 strIdSolicitud, 
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
																	 strUsuarioCreo, 
																	 strPantallaCreo, 
																	 strProgramaCreo);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	/**
	 * @author luisfonseca
	 * @param strCodCompania
	 * @param strCodSucursal
	 * @param strCodUniNeg
	 * @param strNoCotizacion
	 * @param strCodCliente
	 * @param strUsuarioCreo
	 * @param strFechaCreo
	 * @param strHoraCreo
	 * @param strPantallaCreo
	 * @param strProgramaCreo
	 * @return
	 * @throws Exception
	 */
	public String setControlSolicitudDespachoIns(String strCodCompania, 
         									     String strCodSucursal, 
         									     String strCodUniNeg, 
         									     String strNoCotizacion, 
         									     String strCodCliente, 
         									     String[] strCodCompaniaDesp, 
       									   	  	 String[] strCodSucursalDesp, 
       									   	  	 String[] strCodUniNegDesp, 
       									   	  	 String[] strCodArticulo, 
       									   	  	 String[] strCodSerie, 
       									   	  	 String[] strNoChasis, 
       									   	  	 String[] strPrecio, 
       									   	  	 String[] strCosto, 
       									   	  	 String[] strDescuento,
       									   	  	 String[] strCantidad,
       									   	  	 String[] strEstado,
       									   	  	 String[] strSIM,
         									     String strUsuarioCreo, 
         									     String strPantallaCreo, 
         									     String strProgramaCreo) throws Exception
	{
		try
		{
			ClsSolicitudDespacho solicitudDespacho = new ClsSolicitudDespacho();
			String strNumeroSolicitud = solicitudDespacho.setControlSolicitudDespachoCIns(em, 
																						 strCodCompania, 
																						 strCodSucursal, 
																						 strCodUniNeg, 
																						 strNoCotizacion, 
																						 strCodCliente, 
																						 strUsuarioCreo, 
																						 strPantallaCreo, 
																						 strProgramaCreo);
			
			if(strNumeroSolicitud.equals("N"))
				throw new Exception("No se pudo insertar el control de solicitud de despacho cabecera");
			
			
			String strResultado = "";
			for(int i=0;i<strCodArticulo.length;i++)
			{
				strResultado = solicitudDespacho.setControlSolicitudDespachoDIns(em, 
																				 strNumeroSolicitud, 
																				 strCodCompaniaDesp[i], 
																				 strCodSucursalDesp[i], 
																				 strCodUniNegDesp[i], 
																				 strCodArticulo[i], 
																				 strCodSerie[i], 
																				 strNoChasis[i], 
																				 strPrecio[i], 
																				 strCosto[i], 
																				 strDescuento[i], 
																				 strCantidad[i], 
																				 strEstado[i],
																				 strSIM[i],
																				 strUsuarioCreo, 
																				 strPantallaCreo, 
																				 strProgramaCreo);
				
				if(strResultado.equals("N"))
					throw new Exception("No se pudo insertar el control de solicitud de despacho detalle");
			}
			
			return strNumeroSolicitud;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
