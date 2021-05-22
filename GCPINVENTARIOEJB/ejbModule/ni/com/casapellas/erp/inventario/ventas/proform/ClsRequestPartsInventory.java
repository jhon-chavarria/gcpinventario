package ni.com.casapellas.erp.inventario.ventas.proform;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import ni.com.casapellas.ejb.erp.inventario.util.SqlQuery;
import ni.com.casapellas.gcpsisinv.pojo.RequestPartsInventory;

public class ClsRequestPartsInventory {
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param strCompanyCode
	 * @param strSucursOrigen
	 * @param strSucursDestiny
	 * @param strDatingCode
	 * @param strProformCode
	 * @param strBudgetCode
	 * @param strProductCode
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<RequestPartsInventory> getRequestPartsInventory(EntityManager em,
																  String strCompanyCode,
																  String strSucursOrigen,
																  String strSucursDestiny,
																  String strDatingCode,
																  String strProformCode,
																  String strWorkshopCode,
																  String strBudgetCode,
																  String strBudgetType,
																  String[] strProductCode) throws Exception
	{
		List<RequestPartsInventory> lstOrderInventories = new ArrayList<RequestPartsInventory>();
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sWhere = "";
			
			String[] sField = {"PCompan", "PSucurO", "PSucurD", "PNumCit",
							   "PProform","PPresup", "PCodItem", "NNSucu",
							   "TipoPres"};
			
			String[] sDataType = {"String", "String", "String", "Number", 
								  "Number", "Number", "String", "String", 
								  "String"};
			
			Object[] sValues = {strCompanyCode, strSucursOrigen, strSucursDestiny, strDatingCode, 
								strProformCode, strBudgetCode, (strProductCode[0] == null ? null : strProductCode), strWorkshopCode,
								strBudgetType};

			String[] sConditionType = {"I", "I", "I", "I",
				  			  		   "I", "I", "IN", "I", 
				  			  		   "I"};
			
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			
			sQuery = "select PCompan CodCompania, " +
							"PSucurO CodSucursalOrigen, " +
							"PSucurD CodSucursalDestino, " +
							"PNumCit NumeroCita, " +
							"PProform CodProforma, " +
							"PPresup CodPresupuesto, " +
							"PCodItem CodArticulo, " +
							"PDesItem DescArticulo, " +
							"PCantid CantidadSolicitado " +
					 "from invd88 " +
					 "inner join invprof on Sucurs = PSucurO and " +
					 					   "docume = PProform and " +
					 					   "NoPresu = PPresup and " +
					 					   "PCodItem = PCodItem " + sWhere;
			
			
//			System.out.println(sQuery);
			lstOrderInventories = em.createNativeQuery(sQuery, RequestPartsInventory.class).getResultList();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return lstOrderInventories;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param strCompanyCode
	 * @param strSucursOrigen
	 * @param strSucursDestiny
	 * @param strDatingCode
	 * @param strProformCode
	 * @param strBudgetCode
	 * @param strProductCode
	 * @return
	 * @throws Exception
	 */
	public String delRequestPartsInventory(EntityManager em,
										  String strCompanyCode,
										  String strSucursOrigen,
										  String strSucursDestiny,
										  String strDatingCode,
										  String strProformCode,
										  String strBudgetCode,
										  String strProductCode) throws Exception
	{
		String sResultado = "N";
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sWhere = "";
			
			String[] sField = {"PCompan", "PSucurO", "PSucurD", "PNumCit",
							   "PProform","PPresup", "PCodItem"};
			
			String[] sDataType = {"Number", "String", "String", "Number", 
								  "Number", "Number", "String"};
			
			Object[] sValues = {strCompanyCode, strSucursOrigen, strSucursDestiny, strDatingCode, 
								strProformCode, strBudgetCode, strProductCode};

			String[] sConditionType = {"I", "I", "I", "I",
				  			  		   "I", "I", "I"};
			
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			sQuery = "delete from invd88 " + sWhere;
			
			em.createNativeQuery(sQuery).executeUpdate();
			
			sResultado = "S";
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return sResultado;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param strCompanyCode
	 * @param strSucursOrigen
	 * @param strSucursDestiny
	 * @param strDatingCode
	 * @param strProformCode
	 * @param strBudgetCode
	 * @param strProductCode
	 * @return
	 * @throws Exception
	 */
	public String setRequestPartsInventoryIns(EntityManager em,
										  	  String strCompanyCode,
										  	  String strSucursOrigen,
										  	  String strSucursDestiny,
										  	  String strDatingCode,
										  	  String strProformCode,
										  	  String strBudgetCode,
										  	  String strProductCode,
										  	  String strProductDescription,
										  	  String strQuantity,
										  	  String strUserName) throws Exception
	{
		
		String strResultado = "N";
		try
		{

			String sQuery = "Insert into invd88(PCompan, " +
											   "PSucurO, " +
											   "PSucurD, " +
											   "PNumCit, " +
											   "PProform, " +
											   "PPresup, " +
											   "PCodItem, " +
											   "PDesItem, " +
											   "PCantid, " +
											   "PUser, " +
											   "PFecha, " +
											   "PHora, " +
											   "PProgr) " +
							"values('" + strCompanyCode + "', " +
								   "'" + strSucursOrigen + "', " +
								   "'" + strSucursDestiny + "', " +
								   " " + strDatingCode + ", " +
								   " " + strProformCode + ", " +
								   " " + strBudgetCode + ", " +
								   "'" + strProductCode + "', " +
								   "'" + strProductDescription + "', " +
								   " " + strQuantity + ", " +
								   "'" + strUserName + "', " +
								   "Current Date, " +
								   "Current Time, " +
								   "'WEBCIT') ";
			
			em.createNativeQuery(sQuery).executeUpdate();
			
			strResultado = "S";
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return strResultado;
	}
}
