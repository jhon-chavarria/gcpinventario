package ni.com.casapellas.erp.inventario.inventariofisico.setting;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import ni.com.casapellas.ejb.erp.inventario.util.SqlQuery;
import ni.com.casapellas.gcpsisinv.pojo.EmailNotificationSetting;

public class ClsEmailNotificationSetting {
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param sCompanyCode
	 * @param sSucursCode
	 * @param sWareHouse
	 * @param sMoveType
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<EmailNotificationSetting> getEmailNotificationSetting(EntityManager em,
																	  String sCompanyCode, 
																	  String sSucursCode, 
																	  String sWareHouse,
																	  String sMoveType) throws Exception
	{
		List<EmailNotificationSetting> lstENS = new ArrayList<EmailNotificationSetting>();
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sWhere = "";
			
			String[] sField = {"compan", "sucurs", "bodega", "tipotrans"};
			String[] sDataType = {"String", "String", "String", "String"};
			Object[] sValues = {sCompanyCode, sSucursCode, sWareHouse, sMoveType};
			String[] sConditionType = {"I", "I", "I", "I"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			
			sQuery = "select compan CodCompania, " +
							"sucurs CodSucursal, " +
							"bodega CodBodega, " +
							"tipotrans TipoTransaccion, " +
							"emailprincipal EmailPrincipal, " +
							"emailsecundario EmailSecundario " +
					 "from invd89 " + sWhere;
			
			lstENS = em.createNativeQuery(sQuery, EmailNotificationSetting.class).getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("No se pudo realizar la consulta de notificacion de email");
		}
		
		return lstENS;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param sCompanyCode
	 * @param sSucursCode
	 * @param sWareHouse
	 * @param sMoveType
	 * @param sPrimaryEmail
	 * @param sSecundaryEmail
	 * @param sUserName
	 * @return
	 * @throws Exception
	 */
	public String setEmailNotificationSettingIns(EntityManager em,
												  String sCompanyCode, 
												  String sSucursCode, 
												  String sWareHouse,
												  String sMoveType,
												  String sPrimaryEmail,
												  String sSecundaryEmail,
												  String sUserName) throws Exception
	{
		String sResult = "N";
		try
		{
			String sQuery = "";
			
			sQuery = "insert into invd89(compan, " +
										"sucurs, " +
										"bodega, " +
										"tipotrans, " +
										"emailprincipal, " +
										"emailsecundario, " +
										"HechoP, " +
										"Fecha, " +
										"Hora, " +
										"Progr) " +
					 "values('" + sCompanyCode + "', " +
					 		"'" + sSucursCode + "', " +
					 		"'" + sWareHouse + "', " +
					 		"'" + sMoveType + "', " +
					 		"'" + sPrimaryEmail + "', " +
					 		"'" + sSecundaryEmail + "', " +
					 		"'" + sUserName + "', " +
					 		"current date, " +
					 		"current time, " +
					 		"'WebCit') ";
			
			em.createNativeQuery(sQuery).executeUpdate();
			sResult = "S";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("No se pudo realizar la insercion de notificacion de email");
		}
		
		return sResult;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param sCompanyCode
	 * @param sSucursCode
	 * @param sWareHouse
	 * @param sMoveType
	 * @param sPrimaryEmail
	 * @param sSecundaryEmail
	 * @param sUserName
	 * @return
	 * @throws Exception
	 */
	public String setEmailNotificationSettingUpd(EntityManager em,
												  String sCompanyCode, 
												  String sSucursCode, 
												  String sWareHouse,
												  String sMoveType,
												  String sPrimaryEmail,
												  String sSecundaryEmail) throws Exception
	{
		String sResult = "N";
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sWhere = "";
			
			String[] sField = {"compan", "sucurs", "bodega", "tipotrans"};
			String[] sDataType = {"String", "String", "String", "String"};
			Object[] sValues = {sCompanyCode, sSucursCode, sWareHouse, sMoveType};
			String[] sConditionType = {"I", "I", "I", "I"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			
			sField = new String[]{"emailprincipal", "emailsecundario"};
			sDataType = new String[]{"String", "String"};
			sValues = new String[]{sPrimaryEmail, sSecundaryEmail};
			
			String sBody = sq.BodyQuery(sField, sValues, sDataType);
			sQuery = "update invd89 set " + sBody + " " + sWhere + "  ";
			
			em.createNativeQuery(sQuery).executeUpdate();
			sResult = "S";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("No se pudo realizar la actualizacion de notificacion de email");
		}
		
		return sResult;
	}
}
