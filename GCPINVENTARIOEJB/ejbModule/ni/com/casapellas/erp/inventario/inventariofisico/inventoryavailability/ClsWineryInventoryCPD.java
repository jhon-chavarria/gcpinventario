/**
 * 
 */
package ni.com.casapellas.erp.inventario.inventariofisico.inventoryavailability;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import ni.com.casapellas.ejb.erp.inventario.util.SqlQuery;
import ni.com.casapellas.gcpsisinv.pojo.WineryInventoryCPD;
import ni.com.casapellas.util.CollectionScheme;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Talleres
 * Objetivo       :  
 * Fecha Creacion :  30/01/2015 17:12:24
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */

public class ClsWineryInventoryCPD {
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param strProductCode
	 * @return
	 * @throws Exception 
	 */
	
	
	// OverrideMethod
	
	public List<WineryInventoryCPD> getWineryInventoryCPD(EntityManager em, 
				  String[] strProductCode) throws Exception {
		return getWineryInventoryCPD (em, strProductCode, null);
			
	}
		
	@SuppressWarnings("unchecked")
	public List<WineryInventoryCPD> getWineryInventoryCPD(EntityManager em, 
														  String[] strProductCode, String companyId) throws Exception
	{
		List<WineryInventoryCPD> lstWICPD = new ArrayList<WineryInventoryCPD>();
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sWhere = "";
			String[] sField = {"InoPar"};
			String[] sDataType = {"String"};
			Object[] sValues = {strProductCode};
			String[] sConditionType = {"IN"};
			
			companyId = companyId == null ? "01" : companyId;
			
			String tableName = companyId.equals("01") ? "INVD01" : "INVV01";
			
			System.out.println("Entro company  : " + companyId);
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);

			sQuery = "select INOPAR CodArticulo, " +
							"IDESCR DescripcionCorta, " +
							"IDESCI DescripcionLarga, " +
							"ILINEA Departamento, " +
							"IEXT01 ExisteBodega1, " +
							"IEXT02 ExisteBodega2, " +
							"IEXT03 ExisteBodega3, " +
							"IEXT04 ExisteBodega4, " +
							"IEXT05 ExisteBodega5, " +
							"IEXT06 ExisteBodega6, " +
							"IEXT07 ExisteBodega7, " +
							"IEXT08 ExisteBodega8, " +
							"IEXT09 ExisteBodega9, " +
							"IEXT10 ExisteBodega10, " +
							"(IEXT01 + IEXT02 + IEXT03 + IEXT04 + IEXT05 + " +
							"IEXT06 + IEXT07 + IEXT08 + IEXT09 + IEXT10) ExisteBodegaT, " +
							"(ICAV01 + ICALB3 + ILOCA1) ReservaB1, " +
							"(ICAV04 + ILOCA3 + SUSLB2) ReservaB4, " +
							"(ICAV08 + ILOCA4 + SUSLB3) ReservaB8, " +
							"IPEDID CantPedProveedor, " +
							"ISTATU Estado " +
					"from " + CollectionScheme.SchemeInventario + "." + tableName + " " +  sWhere;
			
//			System.out.print(sQuery);
			
			lstWICPD = em.createNativeQuery(sQuery, WineryInventoryCPD.class).getResultList();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return lstWICPD;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param strProductCode
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<WineryInventoryCPD> getWineryInventoryCPDAnotherCompany(EntityManager em, 
																		String strCompanyCode,
																		String[] strProductCode) throws Exception
	{
		List<WineryInventoryCPD> lstWICPD = new ArrayList<WineryInventoryCPD>();
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sWhere = "";
			String[] sField = {"ICompan", "InoPar"};
			String[] sDataType = {"String",  "String"};
			Object[] sValues = {strCompanyCode, strProductCode};
			String[] sConditionType = {"I", "IN"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);

			sQuery = "select INOPAR CodArticulo, " +
							"IDESCR DescripcionCorta, " +
							"IDESCI DescripcionLarga, " +
							"ILINEA Departamento, " +
							"IEXT01 ExisteBodega1, " +
							"IEXT02 ExisteBodega2, " +
							"IEXT03 ExisteBodega3, " +
							"IEXT04 ExisteBodega4, " +
							"IEXT05 ExisteBodega5, " +
							"IEXT06 ExisteBodega6, " +
							"IEXT07 ExisteBodega7, " +
							"IEXT08 ExisteBodega8, " +
							"IEXT09 ExisteBodega9, " +
							"IEXT10 ExisteBodega10, " +
							"(IEXT01 + IEXT02 + IEXT03 + IEXT04 + IEXT05 + " +
							"IEXT06 + IEXT07 + IEXT08 + IEXT09 + IEXT10) ExisteBodegaT, " +
							"(ICAV01 + ICALB3 + ILOCA1) ReservaB1, " +
							"(ICAV04 + ILOCA3 + SUSLB2) ReservaB4, " +
							"(ICAV08 + ILOCA4 + SUSLB3) ReservaB8, " +
							"IPEDID CantPedProveedor, " +
							"ISTATU Estado " +
					 "from invv01 " + sWhere;
			
//			System.out.print(sQuery);
			
			lstWICPD = em.createNativeQuery(sQuery, WineryInventoryCPD.class).getResultList();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return lstWICPD;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param strProductCode
	 * @param sQuantityB1
	 * @param sQuantityB8
	 * @return
	 * @throws Exception
	 */
	public String setWineryInventoryCPDUnReserve(EntityManager em, 
									  		   String strProductCode,
									  		   String sQuantityB1,
									  		   String sQuantityB8) throws Exception
	{
		String sResult ="N";
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sBody = "";
			String sWhere = "";
			
			String[] sField = {"InoPar"};
			String[] sDataType = {"String"};
			Object[] sValues = {strProductCode};
			String[] sConditionType = {"I"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);

			sField = new String[]{"ILOCA1", "ILOCA4"};
			sDataType = new String[]{"Number", "Number"};
			sValues = new String[]{(sQuantityB1 == null ? null : "ILOCA1 - " + sQuantityB1), (sQuantityB8 == null ? null : "ILOCA4 - " + sQuantityB8)};
			
			sBody = sq.BodyQuery(sField, sValues, sDataType);
			sQuery = "Update invd01 set " + sBody + " " + sWhere;
			
//			System.out.print(sQuery);
			em.createNativeQuery(sQuery).executeUpdate();
			
			
			sResult = "S";
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return sResult;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param strProductCode
	 * @param sQuantityB1
	 * @param sQuantityB8
	 * @return
	 * @throws Exception
	 */
	public String setWineryInventoryCPDUnReserveAnotherCompany(EntityManager em,
															   String strCompanyCode,
													  		   String strProductCode,
													  		   String sQuantityB1,
													  		   String sQuantityB8) throws Exception
	{
		String sResult ="N";
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sBody = "";
			String sWhere = "";
			
			String[] sField = {"ICompan", "InoPar"};
			String[] sDataType = {"String",  "String"};
			Object[] sValues = {strCompanyCode, strProductCode};
			String[] sConditionType = {"I", "I"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);

			sField = new String[]{"ILOCA1", "ILOCA4"};
			sDataType = new String[]{"Number", "Number"};
			sValues = new String[]{(sQuantityB1 == null ? null : "ILOCA1 - " + sQuantityB1), (sQuantityB8 == null ? null : "ILOCA4 - " + sQuantityB8)};
			
			sBody = sq.BodyQuery(sField, sValues, sDataType);
			sQuery = "Update invv01 set " + sBody + " " + sWhere;
			
//			System.out.print(sQuery);
			em.createNativeQuery(sQuery).executeUpdate();
			
			
			sResult = "S";
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return sResult;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param strProductCode
	 * @param sQuantityB1
	 * @param sQuantityB8
	 * @return
	 * @throws Exception
	 */
	public String setWineryInventoryCPDReserve(EntityManager em, 
									  		   String strProductCode,
									  		   String sQuantityB1,
									  		   String sQuantityB8) throws Exception
	{
		String sResult ="N";
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sBody = "";
			String sWhere = "";
			
			String[] sField = {"InoPar"};
			String[] sDataType = {"String"};
			Object[] sValues = {strProductCode};
			String[] sConditionType = {"I"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);

			sField = new String[]{"ILOCA1", "ILOCA4"};
			sDataType = new String[]{"Number", "Number"};
			sValues = new String[]{(sQuantityB1 == null ? null : "ILOCA1 + " + sQuantityB1), (sQuantityB8 == null ? null : "ILOCA4 + " + sQuantityB8)};
			
			sBody = sq.BodyQuery(sField, sValues, sDataType);
			sQuery = "Update invd01 set  " + sBody + " " + sWhere;
			
//			System.out.print(sQuery);
			em.createNativeQuery(sQuery).executeUpdate();
			
			
			sResult = "S";
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return sResult;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param strCompanyCode
	 * @param strProductCode
	 * @param sQuantityB1
	 * @param sQuantityB8
	 * @return
	 * @throws Exception
	 */
	public String setWineryInventoryCPDReserveAnotherCompany(EntityManager em, 
															 String strCompanyCode,
															 String strProductCode,
															 String sQuantityB1,
															 String sQuantityB8) throws Exception
	{
		String sResult ="N";
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sBody = "";
			String sWhere = "";
			
			String[] sField = {"ICompan", "InoPar"};
			String[] sDataType = {"String",  "String"};
			Object[] sValues = {strCompanyCode, strProductCode};
			String[] sConditionType = {"I", "I"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);

			sField = new String[]{"ILOCA1", "ILOCA4"};
			sDataType = new String[]{"Number", "Number"};
			sValues = new String[]{(sQuantityB1 == null ? null : "ILOCA1 + " + sQuantityB1), (sQuantityB8 == null ? null : "ILOCA4 + " + sQuantityB8)};
			
			sBody = sq.BodyQuery(sField, sValues, sDataType);
			sQuery = "Update invv01 set " + sBody + " " + sWhere;
			
//			System.out.print(sQuery);
			em.createNativeQuery(sQuery).executeUpdate();
			
			
			sResult = "S";
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return sResult;
	}
}
