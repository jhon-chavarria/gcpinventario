/**
 * 
 */
package ni.com.casapellas.erp.inventario.inventariofisico.inventoryavailability;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import ni.com.casapellas.ejb.erp.inventario.util.SqlQuery;
import ni.com.casapellas.gcpsisinv.pojo.WineryInventoryAdditional;
import ni.com.casapellas.util.CollectionScheme;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Talleres
 * Objetivo       :  
 * Fecha Creacion :  02/02/2015 17:18:16
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */

public class ClsWineryInventoryAdditional {

	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param strCompanyCode
	 * @param strBranchCode
	 * @param strWineryCode
	 * @param strProductCode
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<WineryInventoryAdditional> getWineryInventoryAdditional(EntityManager em, 
					  										  	        String strCompanyCode,
					  										  	        String strBranchCode,
					  										  	        String strWineryCode,
					  										  	        String[] strProductCode) throws Exception
	{
		List<WineryInventoryAdditional> lstWICPD = new ArrayList<WineryInventoryAdditional>();
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sWhere = "";
			String[] sField = {"BCOMPAN", "BSUCURS", "BBODEGA", "BINOPAR"};
			
			String[] sDataType = {"String", "String", "String", "String"};
			Object[] sValues = {strCompanyCode, strBranchCode, strWineryCode, strProductCode};
			String[] sConditionType = {"I", "I", "I", "IN"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			
			sQuery = "select BCOMPAN CodCompania, " +
							"BSUCURS CodSucursal, " +
							"TRIM(BBODEGA) CodBodega, " +
							"BINOPAR CodArticulo, " +
							"(BEXISTEE + BEXISTED) Existencia, " +
							"(BCANRESER + BCANINVES) Reservas, " +
							"Descri DescripSucursal, " +
							"P4 SucursalManagua, " +
							"BSUbl00 Ubicacion  " +
					 "from " + CollectionScheme.SchemeInventario + ".invd03 " +
					 "inner join " + CollectionScheme.SchemeInventario + ".tabmul on codide = BSucurs and " +
					 							 "codtab = '02' " +
					 							 "" + sWhere + "  order by BSUCURS ASC";
						
			lstWICPD = em.createNativeQuery(sQuery, WineryInventoryAdditional.class).getResultList();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return lstWICPD;
	}
}
