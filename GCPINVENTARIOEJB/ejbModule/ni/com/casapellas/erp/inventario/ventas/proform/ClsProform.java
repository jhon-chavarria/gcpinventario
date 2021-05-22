/**
 * 
 */
package ni.com.casapellas.erp.inventario.ventas.proform;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import ni.com.casapellas.ejb.erp.inventario.util.SqlQuery;
import ni.com.casapellas.gcpsisinv.pojo.Proform;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Talleres
 * Objetivo       :  
 * Fecha Creacion :  03/02/2015 18:54:11
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */
public class ClsProform {
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param sCompanyCode
	 * @param sProformNumber
	 * @param sCustomerCode
	 * @param sChassis
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<Proform> getProformList(EntityManager em,
										String sCompanyCode, 
										String sSucursCode,
										String sWareHouse,
									    String sProformNumber, 
									    String sCustomerCode,
									    String sChassis) throws Exception
	{
		List<Proform> lstP = new ArrayList<Proform>();
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sWhere = "";
			String[] sField = {"Compan", "Sucurs", "Bodega", "Docume", 
							   "Client", "IChasi", "StaFac", "(Cantid - Cantif)"};
			
			String[] sDataType = {"String","String", "String", "Number", 
								  "Number","String", "String", "Number"};
			
			Object[] sValues = {sCompanyCode, sSucursCode, sWareHouse, sProformNumber, 
								sCustomerCode, sChassis, "C", "0"};
			
			String[] sConditionType = {"I", "I", "I","I", 
									   "I", "I", "D", "D"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			
			sQuery = "select Compan CodCompania, " +
							"Sucurs Sucursalproforma, " +
							"Depart Linea, " +
							"Bodega, " +
							"Docume NoProforma, " +
							"Client CodCliente, " +
							"Trim(Nombre) NombreCliente, " +
							"IChasi Chasis, " +
							"Cantid Cantidad, " +
							"NParte CodItem, " +
							"IDesci DescripcionItem, " +
							"Vended CodCortoVendedor, " +
							"CVended CodVendedor, " +
							"(Case when Trim(CMoneda) = 'USD' then (Precio * TipoCa) else Precio end) as Precio, " +
							"TipoCa TipoCambio, " +
							"CMoneda Moneda,  " +
							"PImpue PorcImpuesto, " +
							"Descue PorcDescuento, " +
							"Factur NoFactura, " +
							"FechaF FechaFactura, " +
							"CantiF CantidadFacturada, " +
							"PrecIF PrecioFacturado, " +
							"(Cantid - Cantif) CantPendienteFact, " +
							"AutMde Modelo, " +
							"AutMar Marca, " +
							"AutPlc Placa, " +
							"tbdesc DescMarca," +
							"NoPresu NoPresupuesto, " +
							"NCanRes CantReservado, " +
							"TipoPres TipoPresupuesto, " +
							"NNSucu CodTaller, " +
							"a.Descri DescSucursalproforma, " +
							"substr(fecham, 1, 4) concat '-' concat substr(fecham, 5, 2) concat '-' concat substr(fecham, 7, 2) FechaProforma " +
					 "from invprof " +
					 "inner join invd01 on iCompan = Compan and " +
					 							 "INoPar = NParte " +
					 "inner join tabmul a on a.codide = Sucurs and " +
					 							 "a.codtab = '02' and " +
					 							 "a.P2 = 'S' " +
					 "left outer join sotaut on client  = clclie and " +
					 							 "autcha = iChasi " +
					 "left outer join sottab on tbespe = AutMar and   " +
					 								  "tbcodi = '034' " + sWhere;
			
			
//			private String TipoPresupuesto;
//			private String CodTaller;
			
//			System.out.print(sQuery);
			
			lstP = em.createNativeQuery(sQuery, Proform.class).getResultList();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return lstP;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param sCompanyCode
	 * @param sProformCode
	 * @param sBudgetCode
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<Proform> getProformAll(EntityManager em,
										String sCompanyCode,
										String sSucursCode,
										String sWareHouse,
										String sProformCode,
									    String sWorkshopCode,
									    String[] sBudgetCode,
									    String[] sBudgetType,
									    String[] sBudgetDate,
									    String[] sBudgetApp,
									    String sItemCode) throws Exception
	{
		List<Proform> lstP = new ArrayList<Proform>();
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sWhere = "";
			String[] sField = {"Compan", "Sucurs", "Bodega", "Docume", 
							   "NoPresu", "NParte", "StaFac", "nnsucu", 
							   "tipopres", "pfecha", "pnprogrp"};
			
			String[] sDataType = {"String", "String", "String", "Number", 
								  "Number", "String", "String", "String", 
								  "String", "Number", "String"};
			
			Object[] sValues = {sCompanyCode, sSucursCode, sWareHouse, sProformCode, 
								(sBudgetCode[0] == null ? null : sBudgetCode), sItemCode, "C", sWorkshopCode,
								(sBudgetType[0] == null ? null : sBudgetType), (sBudgetDate[0] == null ? null : sBudgetDate), (sBudgetApp[0] == null ? null : sBudgetApp)};
			
			String[] sConditionType = {"I", "I", "I", "I", 
									   "IN", "I", "D", "I",
									   "IN","IN", "IN"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			
			sQuery = "select Compan CodCompania, " +
							"Sucurs Sucursalproforma, " +
							"Depart Linea, " +
							"Bodega, " +
							"Docume NoProforma, " +
							"Client CodCliente, " +
							"Trim(Nombre) NombreCliente, " +
							"IChasi Chasis, " +
							"Cantid Cantidad, " +
							"NParte CodItem, " +
							"IDesci DescripcionItem, " +
							"Vended CodCortoVendedor, " +
							"CVended CodVendedor, " +
							"(Case when Trim(CMoneda) = 'USD' then (Precio * TipoCa) else Precio end) as Precio, " +
							"TipoCa TipoCambio, " +
							"CMoneda Moneda,  " +
							"PImpue PorcImpuesto, " +
							"Descue PorcDescuento, " +
							"Factur NoFactura, " +
							"FechaF FechaFactura, " +
							"CantiF CantidadFacturada, " +
							"PrecIF PrecioFacturado, " +
							"(Cantid - Cantif) CantPendienteFact, " +
							"AutMde Modelo, " +
							"AutMar Marca, " +
							"AutPlc Placa, " +
							"tbdesc DescMarca," +
							"NoPresu NoPresupuesto, " +
							"NCanRes CantReservado, " +
							"TipoPres TipoPresupuesto, " +
							"NNSucu CodTaller, " +
							"a.Descri DescSucursalproforma, " +
							"substr(fecham, 1, 4) concat '-' concat substr(fecham, 5, 2) concat '-' concat substr(fecham, 7, 2) FechaProforma " +
					 "from invprof " +
					 "inner join invd01 on iCompan = Compan and " +
					 							 "INoPar = NParte " +
					 "inner join tabmul a on a.codide = Sucurs and " +
					 							 "a.codtab = '02' and " +
					 							 "a.P2 = 'S' " +
					 "left outer join sotaut on client  = clclie and " +
					 							 "autcha = iChasi " +
					 "left outer join sottab on tbespe = AutMar and   " +
					 								  "tbcodi = '034' " + sWhere;
			
//			System.out.print(sQuery);
			
			lstP = em.createNativeQuery(sQuery, Proform.class).getResultList();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return lstP;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param sWorkshopCode
	 * @param sBudgetCode
	 * @param sBudgetType
	 * @param sBudgetDate
	 * @param sBudgetDateNew
	 * @param sBudgetApp
	 * @param sUserName
	 * @return
	 * @throws Exception
	 */
	public String setProformCBudgetDate(EntityManager em,
										String sWorkshopCode,  
									    String sBudgetCode,
									    String sBudgetType,
									    String sBudgetDate,
									    String sBudgetDateNew,
									    String sBudgetApp,
									    String sUserName) throws Exception
	{
		String sResult = "N";
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sBody = "";
			String sWhere = "";
			
			String[] sField = {"pftaller", "pfpresu", "pftipopre", "pffecha", "pfnprogrp"};
			String[] sDataType = {"String", "Number", "String", "Number", "String"};
			Object[] sValues = {sWorkshopCode, sBudgetCode, sBudgetType, sBudgetDate, sBudgetApp};
			String[] sConditionType = {"I", "I", "I", "I", "I"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			
			sField = new String[]{"pffecha", "pfHoraMM", "pfFechaMM", 
								  "pfPantalM", "pfHechoPM", "pfNProgrM"};
			
			sDataType = new String[]{"Number", "Number","Number", 
									 "String", "String", "String"};
			
			sValues = new String[]{sBudgetDateNew, "cast(HOUR(CURRENT TIME) || MINUTE(CURRENT TIME) || SECOND(CURRENT TIME) as Numeric(6, 0) )", "Cast(YEAR(CURRENT DATE) * 10000 + MONTH(CURRENT DATE) * 100 + DAY(CURRENT DATE) AS Numeric(8))", 
									"MITCHELL2", sUserName, "WEBTALL"};
			
			sBody = sq.BodyQuery(sField, sValues, sDataType);
			
			sQuery = "Update invproc set  " + sBody + " " + sWhere;
			
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
	 * @param sWorkshopCode
	 * @param sBudgetCode
	 * @param sBudgetType
	 * @param sBudgetDate
	 * @param sBudgetDateNew
	 * @param sBudgetApp
	 * @param sUserName
	 * @return
	 * @throws Exception
	 */
	public String setProformDBudgetDate(EntityManager em,
										String sWorkshopCode,  
									    String sBudgetCode,
									    String sBudgetType,
									    String sBudgetDate,
									    String sBudgetDateNew,
									    String sBudgetApp,
									    String sUserName) throws Exception
	{
		String sResult = "N";
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sBody = "";
			String sWhere = "";
			
			String[] sField = {"nnsucu", "NoPresu", "tipopres", "pfecha", "pnprogrp"};
			String[] sDataType = {"String", "Number", "String", "Number", "String"};
			Object[] sValues = {sWorkshopCode, sBudgetCode, sBudgetType, sBudgetDate, sBudgetApp};
			String[] sConditionType = {"I", "I", "I", "I", "I"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			
			sField = new String[]{"pfecha", "HoraMM", "FechaMM", 
								  "PantalM", "HechoPM", "NProgrM"};
			
			sDataType = new String[]{"Number", "Number","Number", 
									 "String", "String", "String"};
			
			sValues = new String[]{sBudgetDateNew, "cast(HOUR(CURRENT TIME) || MINUTE(CURRENT TIME) || SECOND(CURRENT TIME) as Numeric(6, 0) )", "Cast(YEAR(CURRENT DATE) * 10000 + MONTH(CURRENT DATE) * 100 + DAY(CURRENT DATE) AS Numeric(8))", 
									"MITCHELL2", sUserName, "WEBTALL"};
			
			sBody = sq.BodyQuery(sField, sValues, sDataType);
			
			sQuery = "Update invprof set  " + sBody + " " + sWhere;
			
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
	 * @param sCompanyCode
	 * @param sProformNumber
	 * @param sBudgetCode
	 * @param sCustomerCode
	 * @param sQuantityB1
	 * @param sQuantityB8
	 * @param sUserName
	 * @return
	 * @throws Exception 
	 */
	public String setProformUnReserve(EntityManager em,
										String sCompanyCode,  
									    String sProformNumber,
									    String sBudgetCode,
									    String sCustomerCode,
									    String sItemCode,
									    String sQuantity,
									    String sUserName) throws Exception
	{
		String sResult = "N";
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sBody = "";
			String sWhere = "";
			String[] sField = {"Compan", "Docume", "Client", "NoPresu", 
							   "NParte"};
			
			String[] sDataType = {"String", "Number", "Number","Number", 
								  "String"};
			
			Object[] sValues = {sCompanyCode, sProformNumber, sCustomerCode,sBudgetCode, 
								sItemCode};
			
			String[] sConditionType = {"I", "I", "I", "I", 
									   "I"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			
			sField = new String[]{"NCANRES", "HoraMM", "FechaMM", 
								  "PantalM", "HechoPM", "NProgrM",
								  "NFecha", "NHecho", "RNProgr"};
			
			sDataType = new String[]{"Number", "Number","Number", 
									 "String", "String", "String",
									 "Number", "String", "String"};
			
			sValues = new String[]{(sQuantity == null ? null : "NCANRES - " + sQuantity), "cast(HOUR(CURRENT TIME) || MINUTE(CURRENT TIME) || SECOND(CURRENT TIME) as Numeric(6, 0) )", "Cast(YEAR(CURRENT DATE) * 10000 + MONTH(CURRENT DATE) * 100 + DAY(CURRENT DATE) AS Numeric(8))", 
									"DispRep", sUserName, "WEBCIT",  
									"Cast(YEAR(CURRENT DATE) * 10000 + MONTH(CURRENT DATE) * 100 + DAY(CURRENT DATE) AS Numeric(8))", sUserName, "WEBCIT"};
			
			sBody = sq.BodyQuery(sField, sValues, sDataType);
			
			sQuery = "Update invprof set  " + sBody + " " + sWhere;
			
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
	 * @param sCompanyCode
	 * @param sProformNumber
	 * @param sBudgetCode
	 * @param sCustomerCode
	 * @param sQuantityB1
	 * @param sQuantityB8
	 * @param sUserName
	 * @return
	 * @throws Exception 
	 */
	public String setProformReserve(EntityManager em,
									String sCompanyCode,  
								    String sProformNumber,
								    String sBudgetCode,
								    String sCustomerCode,
								    String sItemCode,
								    String sQuantity,
								    String sUserName) throws Exception
	{
		String sResult = "N";
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sBody = "";
			String sWhere = "";
			String[] sField = {"Compan", "Docume", "Client", "NoPresu", 
						   	   "NParte"};
			
			String[] sDataType = {"String", "Number", "Number","Number", 
								  "String"};
			
			Object[] sValues = {sCompanyCode, sProformNumber, sCustomerCode,sBudgetCode, 
								sItemCode};
			
			String[] sConditionType = {"I", "I", "I", "I", 
									   "I"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			
			sField = new String[]{"NCANRES", "HoraMM", "FechaMM",  
								  "PantalM", "HechoPM", "NProgrM"};
			
			sDataType = new String[]{"Number", "Number","Number", 
									 "String", "String", "String"};
			
			sValues = new String[]{(sQuantity == null ? null : "NCANRES + " + sQuantity), "cast(HOUR(CURRENT TIME) || MINUTE(CURRENT TIME) || SECOND(CURRENT TIME) as Numeric(6, 0) )", "Cast(YEAR(CURRENT DATE - 1 DAY) * 10000 + MONTH(CURRENT DATE - 1 DAY) * 100 + DAY(CURRENT DATE - 1 DAY) AS Numeric(8))", 
									"DispRep", sUserName, "WEBCIT"};
			
			sBody = sq.BodyQuery(sField, sValues, sDataType);
			sQuery = "Update invprof  set " + sBody + " " + sWhere;
			
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
