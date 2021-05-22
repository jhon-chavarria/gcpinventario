package ni.com.casapellas.erp.inventario.cponline;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ni.com.casapellas.ejb.erp.inventario.util.SqlQuery;
import ni.com.casapellas.gcpsisinv.pojo.SolicitudDespachoCabecera;
import ni.com.casapellas.gcpsisinv.pojo.SolicitudDespachoDetalle;
import ni.com.casapellas.util.CollectionScheme;

/**
 * 
 * @author luisfonseca
 *
 */
public class ClsSolicitudDespacho {
	
	/**
	 * @author luisfonseca
	 * @param em
	 * @param strNumeroSolicitud
	 * @param strUnidadNegocio
	 * @param strNumeroCotizacion
	 * @param strCodigoCliente
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SolicitudDespachoCabecera> getControlSolicitudDespachoC(EntityManager em, 
					  										  	        String strNumeroSolicitud, 
					  										  	        String strUnidadNegocio, 
					  										  	        String strNumeroCotizacion, 
					  										  	        String strCodigoCliente) throws Exception
	{
		List<SolicitudDespachoCabecera> lstWICPD = new ArrayList<SolicitudDespachoCabecera>();
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sWhere = "";
			String[] sField = {"idSolicitud", "codUniNeg", "noCotizacion", "codCliente"};
			
			String[] sDataType = {"Number", "String", "Number", "Number"};
			Object[] sValues = {strNumeroSolicitud, strUnidadNegocio, strNumeroCotizacion, strCodigoCliente};
			String[] sConditionType = {"I", "I", "I", "I"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			
			sQuery = "select idSolicitud numeroSolicitud, codCompania codigoCompaniaSolicita, codSucursal codigoSucursalSolicita, codUniNeg codigoUnidadNegocioSolicita, "
						  + "noCotizacion numeroCotizacion, codCliente codigoCliente, usuarioCreo, fechaCreo, "
						  + "horaCreo, pantallaCreo, programaCreo, usuarioModifico, "
						  + "fechaModifico, horaModifico, pantallaModifico, programaModifico "
						  + "from " + CollectionScheme.SchemeInventario + ".invd101 " + sWhere;
						
			lstWICPD = em.createNativeQuery(sQuery, SolicitudDespachoCabecera.class).getResultList();
			

			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return lstWICPD;
	}
	
	/**
	 * @author luisfonseca
	 * @param em
	 * @param strNumeroSolicitud
	 * @param strCodigoArticulo
	 * @param strChasis
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SolicitudDespachoDetalle> getControlSolicitudDespachoD(EntityManager em, 
					  										  	        String strNumeroSolicitud, 
					  										  	        String strCodigoArticulo, 
					  										  	        String strChasis) throws Exception
	{
		List<SolicitudDespachoDetalle> lstWICPD = new ArrayList<SolicitudDespachoDetalle>();
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sWhere = "";
			String[] sField = {"idSolicitud", "codArticulo", "noChasis"};
			String[] sDataType = {"Number", "String", "String"};
			Object[] sValues = {strNumeroSolicitud, strCodigoArticulo, strChasis};
			String[] sConditionType = {"I", "I", "I"};
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			
			sQuery = "select idSolicitud numeroSolicitud, codCompaniaDesp codigoCompaniaDespacha, codSucursalDesp codigoSucursalDespacha, codUniNegDesp codigoUnidadNegocioDespacha, "
						  + "codArticulo codigoArticulos, codSerie codigoSerie, noChasis chasis, precio, "
						  + "costo, descuento, usuarioCreo, fechaCreo, "
						  + "horaCreo, pantallaCreo, programaCreo, usuarioModifico, "
						  + "fechaModifico, horaModifico, pantallaModifico, programaModifico, cantidad, estado,"
						  + "cantidaddesp cantidadDespachada, codsim codigoSIM "
						  + "from " + CollectionScheme.SchemeInventario + ".invd102 " + sWhere;

			
			lstWICPD = em.createNativeQuery(sQuery, SolicitudDespachoDetalle.class).getResultList();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return lstWICPD;
	}
	
	
	/**
	 * @author luisfonseca
	 * @param em
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
	@SuppressWarnings("unchecked")
	public String setControlSolicitudDespachoCIns(EntityManager em,
         									   String strCodCompania, 
         									   String strCodSucursal, 
         									   String strCodUniNeg, 
         									   String strNoCotizacion, 
         									   String strCodCliente, 
         									   String strUsuarioCreo, 
         									   String strPantallaCreo, 
         									   String strProgramaCreo) throws Exception
	{
		String strResult = "N";
		SqlQuery sq = new SqlQuery();		

		String strValuesInsert = "";
		try
		{	
			String[] strDataType = new String[]{"String","String","String",
												"Number","Number","String","Date",
												"Time","String","String" };
			
			String[] strValues = new String[]{strCodCompania, strCodSucursal, strCodUniNeg, 
											  strNoCotizacion, strCodCliente, strUsuarioCreo, "Current Date", 
											  "Current Time", strPantallaCreo, strProgramaCreo};
			
			String[] strValidationRequired = new String[]{"S","S","S",
														  "S","S","S","S",
														  "S","S","S"};

			strValuesInsert =  sq.BodyValuesInsert(strValues, strValidationRequired, strDataType);
			
			String strQuery = "SELECT idSolicitud numeroSolicitud FROM FINAL TABLE (" +
							  "insert into " + CollectionScheme.SchemeInventario + ".invd101( " +
                                    		"codCompania, codSucursal, codUniNeg, " + 
                                    		"noCotizacion, codCliente, usuarioCreo, fechaCreo, " + 
                                    		"horaCreo, pantallaCreo, programaCreo " +
                                    		" )  " + strValuesInsert + ")  ";

			Query q = em.createNativeQuery(strQuery, SolicitudDespachoCabecera.class);
			sq.QueryParameterValue(q, strValues, strValidationRequired, strDataType);
			List<SolicitudDespachoCabecera> lstT =  q.getResultList();
			
			if(lstT.size()==0)
				throw new Exception("No se pudo insertar cabecera de tarjeta");
			
			String strNumeroSolicitud = "";
			for(Object o : lstT)
			{
				SolicitudDespachoCabecera tar = (SolicitudDespachoCabecera)o;
				strNumeroSolicitud = String.valueOf(tar.getNumeroSolicitud());
			}
			
//			Query q = em.createNativeQuery(strQuery);
//			sq.QueryParameterValue(q, strValues, strValidationRequired, strDataType);
//			q.executeUpdate();
			
			strResult = strNumeroSolicitud;

		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al momento de realizar el consulta en tabla de invd101 " + e.getMessage() + strValuesInsert);
		}
		
		return strResult;
	}
	
	/**
	 * @author luisfonseca
	 * @param em
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
	public String setControlSolicitudDespachoDIns(EntityManager em,
											   String strIdSolicitud,
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
		String strResult = "N";
		SqlQuery sq = new SqlQuery();		

		String strNumeroRecibo = "";
		String strValuesInsert = "";
		try
		{	
			String[] strDataType = new String[]{"Number","String","String","String",
												"String","String","String","Number",
												"Number","Number","String", "Date",
												"Time","String","String","Number",
												"String","Number","String"};
			
			String[] strValues = new String[]{strIdSolicitud, strCodCompaniaDesp, strCodSucursalDesp, strCodUniNegDesp, 
											  strCodArticulo, strCodSerie, strNoChasis, strPrecio, 
											  strCosto, strDescuento, strUsuarioCreo, "Current Date", 
											  "Current Time", strPantallaCreo, strProgramaCreo,strCantidad,
											  strEstado, "0", strSIM};
			
			String[] strValidationRequired = new String[]{"S","S","S","S",
														  "S","S","S","S",
														  "S","S","S","S",
														  "S","S","S","S",
														  "S","S","S"};

			strValuesInsert =  sq.BodyValuesInsert(strValues, strValidationRequired, strDataType);
			
			String strQuery = "insert into " + CollectionScheme.SchemeInventario + ".invd102( " +
                                    		"idSolicitud, codCompaniaDesp, codSucursalDesp, codUniNegDesp, " +
                                    		"codArticulo, codSerie, noChasis, precio, " +
                                    		"costo, descuento, usuarioCreo, fechaCreo, " +
                                    		"horaCreo, pantallaCreo, programaCreo, cantidad, " + 
                                    		"estado, cantidaddesp, codsim " +
                                    		" )  " + strValuesInsert;

			Query q = em.createNativeQuery(strQuery);
			sq.QueryParameterValue(q, strValues, strValidationRequired, strDataType);
			q.executeUpdate();
			
			strResult = strNumeroRecibo;

		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al momento de realizar el consulta en tabla de invd101 " + e.getMessage() + strValuesInsert);
		}
		
		return strResult;
	}
	
}
