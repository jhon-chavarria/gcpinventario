package ni.com.casapellas.erp.inventario.inventariofisico.inventorylog;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import ni.com.casapellas.ejb.erp.inventario.util.SqlQuery;
import ni.com.casapellas.gcpsisinv.pojo.ConsecutiveNumber;
import ni.com.casapellas.gcpsisinv.pojo.InventoryLog;
import ni.com.casapellas.util.CollectionScheme;

public class ClsInventaryLog {
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param strCompanyCode
	 * @param strSucursCode
	 * @param strWareHouse
	 * @param strMoveType
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ConsecutiveNumber> getConsecutiveNumber(EntityManager em, 
														  String strCompanyCode,
														  String strSucursCode,
														  String strWareHouse,
														  String strMoveType) throws Exception
	{
		List<ConsecutiveNumber> lstCN = new ArrayList<ConsecutiveNumber>();
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sWhere = "";
			String[] sField = {"compa", "sucur", "bodeg", "tipom"};
			
			String[] sDataType = {"String", "String", "String", "String"};
			Object[] sValues = {strCompanyCode, strSucursCode, strWareHouse, strMoveType};
			String[] sConditionType = {"I", "I", "I", "I"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			
			sQuery = "select Compa CodCompania, " +
							"Sucur Sucursal, " +
							"Bodeg Bodega, " +
							"TipoM TipoMovimiento, " +
							"NumCon NumeroConsecutivo " +
					 "from invcon " + sWhere;
			
//			System.out.print(sQuery);
			
			lstCN = em.createNativeQuery(sQuery, ConsecutiveNumber.class).getResultList();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return lstCN;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param strCompanyCode
	 * @param strSucursCode
	 * @param strWareHouse
	 * @param strDocumentNumber
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryLog> getInventoryLog(EntityManager em, 
											  String strCompanyCode,
											  String strSucursCode,
											  String strDepartment,
											  String strWareHouse,
											  String strDocumentNumber,
											  String strProformNumber,
											  String strBudgetNumber,
											  String strItemCode) throws Exception
	{
		List<InventoryLog> lstIL = new ArrayList<InventoryLog>();
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sWhere = "";
			String[] sField = {"compan", "sucurs", "bodega", "Docume", 
							   "Depart", "NProfo", "NPresu", "NParte", 
							   "StaDes"};
			
			String[] sDataType = {"String", "String", "String", "Number", 
								  "String", "Number", "Number", "String",
								  "String"};
			
			Object[] sValues = {strCompanyCode, strSucursCode, strWareHouse, strDocumentNumber, 
								strDepartment, strProformNumber, strBudgetNumber, strItemCode, 
								""};
			
			String[] sConditionType = {"I", "I", "I", "I", 
									   "I", "I", "I", "I", 
									   "I"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			
			sQuery = "select compan CodCompania, " +
							"Sucurs  Sucursal, " +
							"Depart Departamento, " +
							"Bodega, " +
							"Docume NoDocumento, " +
							"NProfo NoProforma, " +
							"NPresu NoPresupuesto, " +
							"FechaM FechaMovimiento, " +
							"NParte CodArticulo, " +
							"Descri Descripcion, " +
							"CanRes CantidadReservada, " +
							"CanRCPD1 CantidadResercadaCPD1, " +
							"CanRCPD8 CantidadReservadaCPD8, " +
							"Client CodCliente, " +
							"ClNomb Cliente, " +
							"Motivo, " +
							"StsRes EstadoReservado, " +
							"StaDes EstadoDesReserva   " +
					 "from invd38  " + sWhere;
			
//			System.out.print(sQuery);
			
			lstIL = em.createNativeQuery(sQuery, InventoryLog.class).getResultList();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return lstIL;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param strCompanyCode
	 * @param strSucursCode
	 * @param strWareHouse
	 * @param strDocumentNumber
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<InventoryLog> getInventoryLogByDatingNumber(EntityManager em, 
															  String strCompanyCode,
															  String strWorkshopCode,
															  String strDatingNumer,
															  String strDateInitial,
															  String strDateFinal) throws Exception
	{
		List<InventoryLog> lstIL = new ArrayList<InventoryLog>();
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sWhere = "";
			String[] sField = {"c.compan", "c.sucurs", "NumCit", "a.FechaM",  
							   "cast(substr(a.FechaM, 1, 4) concat '-' concat substr(a.FechaM, 5, 2) concat '-' concat substr(a.FechaM, 7, 2) as date)", 
							   "cast(substr(a.FechaM, 1, 4) concat '-' concat substr(a.FechaM, 5, 2) concat '-' concat substr(a.FechaM, 7, 2) as date)"};
			
			String[] sDataType = {"String", "String", "String", "Number", 
								  "String", "String"};
			
			Object[] sValues = {strCompanyCode, strWorkshopCode, strDatingNumer, "0",
								strDateInitial, strDateFinal};
			
			String[] sConditionType = {"I", "I", "I", "D",
									   "MAI", "MEI"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			
			sQuery = "select distinct a.compan CodCompania, " +
							"a.Sucurs  Sucursal, " +
							"a.Depart Departamento, " +
							"a.Bodega, " +
							"a.Docume NoDocumento, " +
							"a.NProfo NoProforma, " +
							"a.NPresu NoPresupuesto, " +
							"a.FechaM FechaMovimiento, " +
							"c.c1linea LineaProduccion, " +
							"c.NumCit NumeroCita, " +
							"d.tbdesc DescMarca, " +
							"c.modelo Modelo, " +
							"c.placa Placa, " +
							"a.NParte CodArticulo, " +
							"a.Descri Descripcion, " +
							"a.CanRes CantidadReservada, " +
							"a.CanRCPD1 CantidadResercadaCPD1, " +
							"a.CanRCPD8 CantidadReservadaCPD8, " +
							"a.Client CodCliente, " +
							"a.ClNomb Cliente, " +
							"a.Motivo, " +
							"a.StsRes EstadoReservado, " +
							"a.StaDes EstadoDesReserva   " +
					 "from invd38 a " +
					 "inner join " + CollectionScheme.SchemePresupuesto + ".preshdr b on b.nopres = a.npresu " +
					 "inner join sotcit c on c.numcit = b.ncita and " +
					 						"c.sucurs = b.codtaller " +
					 "inner join sottab e on c.sucurs = e.tbespe and " +
					 						"e.tbcodi = '131' and " +
					 						"a.sucurs = e.TBNIV1 " +
					 "left outer join SotTab d on c.Marca = d.tbespe and " +
												 "d.tbcodi = '034'  " + sWhere;
			
//			System.out.print(sQuery);
			
			lstIL = em.createNativeQuery(sQuery, InventoryLog.class).getResultList();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return lstIL;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param strCompanyCode
	 * @param strSucursCode
	 * @param strWareHouse
	 * @param strDocumentNumber
	 * @param strUserName
	 * @return
	 * @throws Exception
	 */
	public String setInventoryLogCancel(EntityManager em, 
									  String strCompanyCode,
									  String strSucursCode,
									  String strWareHouse,
									  String strDocumentNumber,
									  String strItemCode,
									  String strUserName) throws Exception
	{
		String sResult = "N";
		SqlQuery sq = new SqlQuery();
		
		try
		{
			String sQuery = "";
			String sWhere = "";
			String sBody = "";
			String[] sField = {"compan", "sucurs", "bodega", "Docume", 
							   "NParte", "STADES"};
			
			String[] sDataType = {"String", "String", "String", "Number", 
								  "String", "String"};
			
			Object[] sValues = {strCompanyCode, strSucursCode, strWareHouse, strDocumentNumber, 
								strItemCode, ""};
			
			String[] sConditionType = {"I", "I", "I", "I", 
									   "I", "I"};
			
			sWhere = sq.ConditionQuery(sField, sConditionType, sValues, sDataType);
			
			sField = new String[]{"STADES", "Rhoram", "RPantal", "RHechoP", 
								  "RNPROGR"};
			
			sDataType = new String[]{"String", "Number", "String", "String", 
									 "Number"};
			
			sValues = new String[]{"A", "cast(HOUR(CURRENT TIME) || MINUTE(CURRENT TIME) || SECOND(CURRENT TIME) as Numeric(6, 0) )", "DispRep", strUserName, 
								   "Cast(YEAR(CURRENT DATE) * 10000 + MONTH(CURRENT DATE) * 100 + DAY(CURRENT DATE) AS VARCHAR(8))"};
			
			sBody = sq.BodyQuery(sField, sValues, sDataType);
			sQuery = "update invd38 set " + sBody + " " + sWhere;
			
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
	 * @param strSucursCode
	 * @param strDepartment
	 * @param strWareHouse
	 * @param strDocumentNumber
	 * @param strProformNumber
	 * @param strBudgetNumber
	 * @param strItemCode
	 * @param strItem
	 * @param strQuantityReserve
	 * @param strLocalReserve
	 * @param strCPD1Reserve
	 * @param strCPD8Reserve
	 * @param strCustomerCode
	 * @param strCustomerName
	 * @param strReason
	 * @param strUserName
	 * @return
	 * @throws Exception
	 */
	public String setInventoryLogIns(EntityManager em, 
									 String strCompanyCode,
									 String strSucursCode,
									 String strDepartment,
									 String strWareHouse,
									 String strDocumentNumber,
									 String strProformNumber,
									 String strBudgetNumber,
									 String strItemCode,
									 String strItem,
									 String strQuantityReserve,
									 String strCPD1Reserve,
									 String strCPD8Reserve,
									 String strCustomerCode,
									 String strCustomerName,
									 String strReason,
									 String strUserName) throws Exception
	{
		String sResult = "N";
		try
		{
			String sQuery = "";
			sQuery = "insert into invd38(COMPAN," +
										"SUCURS," +
										"DEPART," +
										"BODEGA," +
										"DOCUME," +
										"NPROFO," +
										"NPRESU," +
										"NOPEDI," +
										"FECHAM," +
										"NPARTE," +
										"DESCRI," +
										"CANRES," +
										"CANRLO," +
										"CANRCPD1," +
										"CANRCPD4," +
										"CANRCPD8," +
										"CANRPED," +
										"RSLOTE," +
										"RSUNIMED," +
										"RSCANTIDR," +
										"NORDEN," +
										"VENDED," +
										"CLIENT," +
										"CLNOMB," +
										"MOTIVO," +
										"MVALOR," +
										"STSRES," +
										"NATURA," +
										"HORAM," +
										"PANTAL," +
										"HECHOP," +
										"NPROGR," +
										"STADES," +
										"RHORAM," +
										"RPANTAL," +
										"RHECHOP," +
										"RNPROGR," +
										"CANRMV," +
										"NFACTU," +
										"NLIQUI," +
										"CAJA1," +
										"FECHAT," +
										"STDESP," +
										"RHORAMD," +
										"RPANTALD," +
										"RHECHOPD," +
										"RNPROGRD," +
										"RSCANTIDF," +
										"RHORAMF," +
										"RPANTALF," +
										"RHECHOPF," +
										"RNPROGRF) " +
					 "values('" + strCompanyCode + "', " +
					 		"'" + strSucursCode + "', " +
					 		"'" + strDepartment + "', " +
					 		"'" + strWareHouse + "', " +
					 		" " + strDocumentNumber + ", " +
					 		" " + strProformNumber + ", " +
					 		" " + strBudgetNumber + ", " +
					 		"0, " +
					 		"YEAR(CURRENT DATE) * 10000 + MONTH(CURRENT DATE) * 100 + DAY(CURRENT DATE),  " +
					 		"'" + strItemCode + "', " +
					 		"'" + strItem + "', " +
					 		" " + strQuantityReserve + ", " +
					 		"0, " +
					 		" " + strCPD1Reserve + ", " +
					 		"0, " +
					 		" " + strCPD8Reserve + ", " +
					 		"0, " +
					 		"'', " +
					 		"'', " +
					 		"0, " +
					 		"0, " +
					 		"'MC', " +
					 		" " + strCustomerCode + ", " +
					 		"'" + strCustomerName + "', " +
					 		"'" + strReason + "', " +
					 		"0, " +
					 		"'R', " +
					 		"'O', " +
					 		"cast(HOUR(CURRENT TIME) || MINUTE(CURRENT TIME) || SECOND(CURRENT TIME) as Numeric(6, 0) ), " +
					 		"'DispRep', " +
					 		"'" + strUserName + "', " +
					 		"'WEBCIT', " +
					 		"'', " +
					 		"0, " +
					 		"'', " +
					 		"'', " +
					 		"0, " +
					 		"0, " +
					 		"0, " +
					 		"0, " +
					 		"'', " +
					 		"0, " +
					 		"'', " +
					 		"0, " +
					 		"'', " +
					 		"'', " +
					 		"'', " +
					 		"0, " +
					 		"0, " +
					 		"'', " +
					 		"'', " +
					 		"'') ";
			
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
	
	public static String StrSQLException(EntityManager em, String sMensaje) throws Exception
	{
		try
		{
			String sQuery = "insert into sottab(tbcodi) values(dd)";
			em.createNativeQuery(sQuery).executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new Exception(sMensaje);
		}
		
		return "";
	}
}
