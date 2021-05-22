/**
 * 
 */
package ni.com.casapellas.ejb.erp.inventario.ventas.proform;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ni.com.casapellas.ejb.erp.inventario.util.JAXBHelper;
import ni.com.casapellas.erp.inventario.ventas.proform.ClsProform;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Inventario
 * Objetivo       :  Consultar, Insertar y Modificar Proformas
 * Fecha Creacion :  15/01/2015 11:15:05
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */
@Stateless
@LocalBean
public class ProformBl {
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
	public List<ni.com.casapellas.gcpsisinv.pojo.Proform> getProformList(String sCompanyCode,  
																		 String sSurcursCode,
																		 String sWareHouse,
																		 String sProformNumber, 
																		 String sCustomerCode,
																		 String sChassis) throws Exception
	{
		ClsProform proform = new ClsProform();
		return proform.getProformList(em, 
									  sCompanyCode, 
									  sSurcursCode,
									  sWareHouse,
									  sProformNumber, 
									  sCustomerCode, 
									  sChassis);
	
	}
	
	/**
	 * @author Luis Fonseca
	 * @param sCompanyCode
	 * @param sSurcursCode
	 * @param sWareHouse
	 * @param sProformNumber
	 * @param sWorkshopCode
	 * @param sBudgetCode
	 * @param sBudgetType
	 * @param sItemCode
	 * @return
	 * @throws Exception
	 */
	public List<ni.com.casapellas.gcpsisinv.pojo.Proform> getProformAll(String sCompanyCode,  
																		String sSurcursCode,
																		 String sWareHouse,
																		 String sProformNumber,
																		 String sWorkshopCode,
																		 String sBudgetCode[],
																		 String sBudgetType[],
																	     String sBudgetDate[],
																	     String sBudgetApp[],
																		 String sItemCode) throws Exception
	{
		
		
		ClsProform proform = new ClsProform();
		
		if(sBudgetDate != null)
		{
			if(sBudgetDate[0] != null)
			{
				for(int i = 0; i < sBudgetDate.length; i++)
				{
					if(!sBudgetDate[i].equals(""))
					{
						if(sBudgetDate[i].toString().trim().length() > 8)
						{
							Date dFechaPresuesto = JAXBHelper.ConvertToDate(sBudgetDate[i]);
				//			String sFechaPresupuesto = JAXBHelper.getDateToString(dFechaPresuesto);
						
							JAXBHelper jutil = new JAXBHelper();
							sBudgetDate[i] =  String.valueOf(jutil.getDateToNumeric(dFechaPresuesto));
						}
					}
				}
			}
		}
		
		return proform.getProformAll(em, 
									  sCompanyCode, 
									  sSurcursCode,
									  sWareHouse,
									  sProformNumber,
									  sWorkshopCode,
									  sBudgetCode,
									  sBudgetType,
									  sBudgetDate,
									  sBudgetApp,
									  sItemCode);
	
	}
	
	/**
	 * @author Luis Fonseca
	 * @param sCompanyCode
	 * @param sProformNumber 
	 * @param sBudgetCode
	 * @param sItemCode
	 * @return
	 * @throws Exception array presupuesto
	 */
	public List<ni.com.casapellas.gcpsisinv.pojo.Proform> getProformAll(String sCompanyCode,  
																		 String sSurcursCode,
																		  String sWareHouse,
																		 String sProformNumber, 
																		 String[] sBudgetCode,
																		 String sItemCode) throws Exception
	{
		ClsProform proform = new ClsProform();
		return proform.getProformAll(em, 
									  sCompanyCode, 
									  sSurcursCode,
									  sWareHouse,
									  sProformNumber,
									  null,
									  sBudgetCode,
									  new String[]{null},
									  new String[]{null},
									  new String[]{null},
									  sItemCode);
	
	}
}
