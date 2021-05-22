/**
 * 
 */
package ni.com.casapellas.erp.inventario.ventas.proform;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import ni.com.casapellas.ejb.erp.inventario.util.SqlQuery;
import ni.com.casapellas.gcpsisinv.pojo.OrderInventory;
import ni.com.casapellas.util.CollectionScheme;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Talleres
 * Objetivo       :  
 * Fecha Creacion :  18/02/2015 17:23:08
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */

public class ClsOrderInventory {
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param strOrderNumber
	 * @param strProductCode
	 * @param strOrderDate1
	 * @param strOrderDate2
	 * @param strStatus
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<OrderInventory> getOrderInventory(EntityManager em,
												  String strOrderNumber,
												  String[] strProductCode,
												  String strOrderDate1,
												  String strOrderDate2,
												  String strStatus) throws Exception
	{
		List<OrderInventory> lstOrderInventories = new ArrayList<OrderInventory>();
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sWhere = "";
			
			String[] sField = {"NPEDID", "NPARTE", "STAPAG", 
							   "Cast (SubStr(FecPed, 1, 4) concat '-' concat  SubStr(FecPed, 5, 2)  concat '-' concat  SubStr(FecPed, 7, 2) as Date)",
							   "Cast (SubStr(FecPed, 1, 4) concat '-' concat  SubStr(FecPed, 5, 2)  concat '-' concat  SubStr(FecPed, 7, 2) as Date)",
							   "CANPED"};
			String[] sDataType = {"Number", "String", "String", 
								  "String", "String", "Number"};
			Object[] sValues = {strOrderNumber, strProductCode, strStatus, 
								strOrderDate1, strOrderDate2, "CANREC"};
			
			if (strOrderDate1 != null && strOrderDate2 != null)
			{
				String[] sConditionType = {"I", "IN", "I",
								  		   "MEI", "MAI", "MA"};
				
				sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			}
			else
			{
				String[] sConditionType = {"I", "IN", "I",
					  			  		   "I", "I", "MA"};
				
				
				sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			}
			
			sQuery = "select  NPEDID NoPedido, " +
							 "Cast (SubStr(FecPed, 1, 4) concat '-' concat  SubStr(FecPed, 5, 2)  concat '-' concat  SubStr(FecPed, 7, 2) as Varchar(12)) FechaPedido, " +
							 "NPARTE CodArticulo, " +
							 "CANPED CantidadPedida, " +
							 "TIPOPE TipoPedido, " +
							 "Cast (SubStr(FECLLE, 1, 4) concat '-' concat  SubStr(FECLLE, 5, 2)  concat '-' concat  SubStr(FECLLE, 7, 2) as Varchar(12)) FechaLlegada, " +
							 "STAPAG Estado, " +
							 "CANREC CantidadRecibida " +
					 "from "+ CollectionScheme.SchemeInventario +".invd08 " + sWhere;
			
			
//			System.out.print(sQuery);
			lstOrderInventories = em.createNativeQuery(sQuery, OrderInventory.class).getResultList();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return lstOrderInventories;
	}
	
}
