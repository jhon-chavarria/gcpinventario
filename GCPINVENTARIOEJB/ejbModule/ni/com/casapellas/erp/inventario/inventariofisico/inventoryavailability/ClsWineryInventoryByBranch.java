/**
 * 
 */
package ni.com.casapellas.erp.inventario.inventariofisico.inventoryavailability;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import ni.com.casapellas.ejb.erp.inventario.util.SqlQuery;
import ni.com.casapellas.gcpsisinv.pojo.WineryInventoryByBranch;
import ni.com.casapellas.util.CollectionScheme;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Talleres
 * Objetivo       :  
 * Fecha Creacion :  02/02/2015 16:50:46
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */

public class ClsWineryInventoryByBranch {

	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param strCompanyCode
	 * @param strBranchCode
	 * @param strProductCode
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<WineryInventoryByBranch> getWineryInventoryByBranch(EntityManager em, 
					  										  	    String strCompanyCode,
					  										  	    String strBranchCode,
					  										  	    String[] strProductCode) throws Exception
	{
		List<WineryInventoryByBranch> lstWICPD = new ArrayList<WineryInventoryByBranch>();
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sWhere = "";
			String[] sField = {"SCOMPAN", "SSUCURS", "SINOPAR"};
			
			String[] sDataType = {"String", "String", "String"};
			Object[] sValues = {strCompanyCode, strBranchCode, strProductCode};
			String[] sConditionType = {"I", "I", "IN"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			
			sQuery = "select SCOMPAN CodCompania, " +
							"SSUCURS CodSucursal, " +
							"SINOPAR CodArticulo, " +
							"SSEXL00 ExisteBodPrincipal, " +
							"(SCANR00 + SCANINVES + SSCVL00) ReservaBodPrincipal, " +
							"Descri DescripSucursal, " +
							"P4 SucursalManagua " +
					 "from " + CollectionScheme.SchemeInventario + ".invd02 " +
					 "inner join " + CollectionScheme.SchemeInventario + ".tabmul on codide = SSUCURS and " +
					 							 "codtab = '02' and " +
					 							 "P2 = 'S' " + sWhere;
						
			lstWICPD = em.createNativeQuery(sQuery, WineryInventoryByBranch.class).getResultList();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return lstWICPD;
	}
}
