package ni.com.casapellas.ejb.erp.inventario.inventariofisico.setting;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ni.com.casapellas.erp.inventario.inventariofisico.setting.ClsEmailNotificationSetting;
import ni.com.casapellas.gcpsisinv.pojo.EmailNotificationSetting;

@Stateless
@LocalBean
public class EmailNotificationSettingBl {
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	
	/**
	 * @author Luis Fonseca
	 * @param sCompanyCode
	 * @param sWorkshopCode
	 * @param sProformNumber
	 * @param sCustomerCode
	 * @param sChassis
	 * @return
	 * @throws Exception 
	 */
	public List<EmailNotificationSetting> getEmailNotificationSetting(String sCompanyCode,  
																	  String sSucursCode,
																	  String sWareHouse,
																	  String sMoveType) throws Exception
	{
		ClsEmailNotificationSetting emailN = new ClsEmailNotificationSetting();
		return emailN.getEmailNotificationSetting(em, 
												  sCompanyCode, 
												  sSucursCode, 
												  sWareHouse, 
												  sMoveType);
	
	}
	
	/**
	 * @author Luis Fonseca
	 * @param sCompanyCode
	 * @param sWorkshopCode
	 * @param sProformNumber
	 * @param sCustomerCode
	 * @param sChassis
	 * @return
	 * @throws Exception 
	 */
	public String setEmailNotificationSetting(String sCompanyCode,  
											  String sSucursCode,
											  String sWareHouse,
											  String sMoveType, 
											  String sPrimaryEmail, 
											  String sSecundaryEmail, 
											  String sUserName) throws Exception
	{
		String sResult = "N";
		ClsEmailNotificationSetting emailN = new ClsEmailNotificationSetting();
		
		
		
		if(emailN.getEmailNotificationSetting(em, sCompanyCode, sSucursCode, sWareHouse, sMoveType).size() == 0)
			sResult = emailN.setEmailNotificationSettingIns(em, 
															sCompanyCode, 
															sSucursCode, 
															sWareHouse, 
															sMoveType, 
															sPrimaryEmail, 
															sSecundaryEmail, 
															sUserName);
		else
			sResult = emailN.setEmailNotificationSettingUpd(em, 
															sCompanyCode, 
															sSucursCode, 
															sWareHouse, 
															sMoveType, 
															sPrimaryEmail, 
															sSecundaryEmail);
		
		return sResult;
	}
}
