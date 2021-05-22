package ni.com.casapellas.ejb.erp.inventario.inventariofisico.inventorylog;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ni.com.casapellas.erp.inventario.inventariofisico.inventoryavailability.ClsWineryInventoryCPD;
import ni.com.casapellas.erp.inventario.inventariofisico.inventorylog.ClsInventaryLog;
import ni.com.casapellas.erp.inventario.ventas.proform.ClsProform;
import ni.com.casapellas.gcpsisinv.pojo.InventoryLog;
import ni.com.casapellas.gcpsisinv.pojo.Proform;
import ni.com.casapellas.gcpsisinv.pojo.WineryInventoryCPD;

/**
 * 
 * @author Luis Fonseca
 *
 */
@Stateless
@LocalBean
public class ReserveSparePartsBl {
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	
	/**
	 * @author Luis Fonseca
	 * @param strCompanyCode
	 * @param strSucursCode
	 * @param strWareHouse
	 * @param strProformNumber
	 * @param strBudgetNumber
	 * @return
	 * @throws Exception
	 */
	public List<InventoryLog> getReserveSpareParts(String strCompanyCode,
												   String strSucursCode,
												   String strWareHouse,
												   String strProformNumber,
												   String strBudgetNumber) throws Exception
	{
		ClsInventaryLog inventoryLog = new ClsInventaryLog();
		return inventoryLog.getInventoryLog(em, 
											strCompanyCode, 
											strSucursCode, 
											null, 
											strWareHouse, 
											null, 
											strProformNumber, 
											strBudgetNumber, 
											null);
	}
	
	/**
	 * @author Luis Fonseca
	 * @param strCompanyCode
	 * @param strWorkshopCode
	 * @param strDatingNumer
	 * @param strDateInitial
	 * @param strDateFinal
	 * @return
	 * @throws Exception
	 */
	public List<InventoryLog> getReserveSparePartsByDating(String strCompanyCode,
															  String strWorkshopCode,
															  String strDatingNumer,
															  String strDateInitial,
															  String strDateFinal) throws Exception
	{
		ClsInventaryLog inventoryLog = new ClsInventaryLog();
		return inventoryLog.getInventoryLogByDatingNumber(em, 
														  strCompanyCode, 
														  strWorkshopCode, 
														  strDatingNumer, 
														  strDateInitial, 
														  strDateFinal);
	}
	
	/**
	 * @author Luis Fonseca
	 * @param strCompanyCode
	 * @param strSucursCode
	 * @param strWareHouse
	 * @param strDocumentNumber
	 * @param strProformNumber
	 * @param strBudgetNumber
	 * @param strItemCode
	 * @param strQuantityReserve
	 * @param strCPD1Reserve
	 * @param strCPD8Reserve
	 * @param strCustomerCode
	 * @param strCustomerName
	 * @param strUserName
	 * @return
	 * @throws Exception
	 */
	public String setReserveSpareParts(String strCompanyCode,
									   String strSucursCode,
									   String strWareHouse,
									   String strDocumentNumber, 
									   String strProformNumber,
									   String strBudgetNumber,
									   String[] strItemCode,
									   String[] strQuantityReserve,
									   String[] strCPD1Reserve,
									   String[] strCPD8Reserve,
									   String strCustomerCode,
									   String strCustomerName,
									   String strUserName) throws Exception
	{
		String sResult = "N";
		
		if(strProformNumber.equals("0"))
			ClsInventaryLog.StrSQLException(em, "No se puede reservar articulos por falta de proformas");
		
		if(strBudgetNumber.equals("0"))
			ClsInventaryLog.StrSQLException(em, "No se puede reservar articulos por falta de Presupuesto asociado a proforma");
		
		
		if(strQuantityReserve.equals("0"))
			ClsInventaryLog.StrSQLException(em, "Cantidad a reservar no puede ser cero");
		
		ClsInventaryLog inventoryLog = new ClsInventaryLog();
		ClsProform proform = new ClsProform();
		ClsWineryInventoryCPD inventoryCPD = new ClsWineryInventoryCPD();
		
		List<InventoryLog> lstIL = inventoryLog.getInventoryLog(em, 
																strCompanyCode, 
																strSucursCode, 
																null,
																strWareHouse, 
																strDocumentNumber, 
																null, 
																null, 
																null);
		

		
		if(lstIL.size() == 0)
		{
			for(int i = 0; i < strItemCode.length; i++)
			{
				List<Proform> lstProforms = proform.getProformAll(em, 
																   strCompanyCode, 
																   strSucursCode,
																   strWareHouse,
																   strProformNumber, 
																   null,
																   new String[]{strBudgetNumber},
																   new String[]{null},
																   new String[]{null},
																   new String[]{null},
																   strItemCode[i]);
				
				if(lstProforms.size() == 0)
					ClsInventaryLog.StrSQLException(em, "Proforma no existe o no esta asociado al numero de presupuesto enviado o Articulo no esta asociado a la proforma");
				
				int iQuantityReserve = Integer.parseInt(strQuantityReserve[i]);
				int iCantidadProformada = 0;
				int iCantidadReservadaP = 0;
				
				for(Object o : lstProforms)
				{
					Proform proform2 = (Proform)o;
					
					iCantidadProformada = proform2.getCantidad();
					iCantidadReservadaP = proform2.getCantReservado();
					
					break;
				}
				
				int iCantidadPorReservarP = iCantidadProformada - iCantidadReservadaP;
				
				if(iQuantityReserve > iCantidadPorReservarP)
					ClsInventaryLog.StrSQLException(em, "Se esta intentado reservar mas de lo solicidado en proforma, revisar proforma #" + strProformNumber + " Articulo Codigo " + strItemCode);
				
				String strDepartment = "";
				String strItem ="";
				
				if(!strCPD1Reserve.equals("0") || !strCPD8Reserve.equals("0"))
				{
					List<WineryInventoryCPD> lstInventoryCPDs = new ArrayList<WineryInventoryCPD>();
					if(strCompanyCode.equals("01"))
					{
						lstInventoryCPDs = inventoryCPD.getWineryInventoryCPD(em, 
																			  new String[]{strItemCode[i]});
					}
					else
					{
						lstInventoryCPDs = inventoryCPD.getWineryInventoryCPDAnotherCompany(em, 
																							strCompanyCode,
								   														 	new String[]{strItemCode[i]});
					}
					
					int iCantidadCPD1 = 0;
					int iCantidadCPD8 = 0;
					int iCantidadReservadoCPD1 = 0;
					int iCantidadReservadoCPD8 = 0;
					
					for(Object o : lstInventoryCPDs)
					{
						WineryInventoryCPD wineryInventoryCPD = (WineryInventoryCPD)o;
						
						iCantidadCPD1 = wineryInventoryCPD.getExisteBodega1();
						iCantidadCPD8 = wineryInventoryCPD.getExisteBodega8();
						
						iCantidadReservadoCPD1 = wineryInventoryCPD.getReservaB1();
						iCantidadReservadoCPD8 = wineryInventoryCPD.getReservaB8();
						
						strDepartment = wineryInventoryCPD.getDepartamento();
						strItem = wineryInventoryCPD.getDescripcionCorta().trim();
						break;
					}
					
					if(strDepartment.equals(""))
						ClsInventaryLog.StrSQLException(em, "Articulo no existe en la compania seleccionado");
					
					int iCantidadPorReservarCPD1 = iCantidadCPD1 - iCantidadReservadoCPD1;
					int iCantidadPorReservarCPD8 = iCantidadCPD8 - iCantidadReservadoCPD8;
					
					int iCPD1Reserve = Integer.parseInt(strCPD1Reserve[i]);
					int iCPD8Reserve = Integer.parseInt(strCPD8Reserve[i]);
					
					if(iCPD1Reserve > iCantidadPorReservarCPD1)
						ClsInventaryLog.StrSQLException(em, "No hay suficiente disponibilidad en bodega 1 de CPD para reservar el articulo " + strItemCode);
					
					if(iCPD8Reserve > iCantidadPorReservarCPD8)
						ClsInventaryLog.StrSQLException(em, "No hay suficiente disponibilidad en bodega 8 de CPD para reservar el articulo " + strItemCode);
					
					
				}
				
				
				String sRInsertLog = inventoryLog.setInventoryLogIns(em, 
																	 strCompanyCode, 
																	 strSucursCode, 
																	 strDepartment, 
																	 strWareHouse, 
																	 strDocumentNumber, 
																	 strProformNumber, 
																	 strBudgetNumber, 
																	 strItemCode[i], 
																	 strItem, 
																	 strQuantityReserve[i], 
																	 strCPD1Reserve[i], 
																	 strCPD8Reserve[i], 
																	 strCustomerCode, 
																	 strCustomerName, 
																	 "RESERVA HECHA POR TALLER", 
																	 strUserName);
				
				if(sRInsertLog.equals("N"))
					ClsInventaryLog.StrSQLException(em, "Error al momento de insertar movimiento a invd38");
				
				
				String sRUpdateRProf = proform.setProformReserve(em, 
																 strCompanyCode, 
																 strProformNumber, 
																 strBudgetNumber, 
																 null, 
																 strItemCode[i],
																 strQuantityReserve[i], 
																 strUserName);
				
				if(sRUpdateRProf.equals("N"))
					ClsInventaryLog.StrSQLException(em, "Error al momento de actualizar reserva en la tabla de proforma");
				
				
				if(!strCPD1Reserve.equals("0") || !strCPD8Reserve.equals("0"))
				{
					
					String sRUpdateInvd01 = "";
					if(strCompanyCode.equals("01"))
					{
						sRUpdateInvd01 = inventoryCPD.setWineryInventoryCPDReserve(em, 
																				  strItemCode[i], 
																				  strCPD1Reserve[i], 
																				  strCPD8Reserve[i]);
					}
					else
					{
						sRUpdateInvd01 = inventoryCPD.setWineryInventoryCPDReserveAnotherCompany(em,
																								strCompanyCode,
																								strItemCode[i], 
																								strCPD1Reserve[i], 
																								strCPD8Reserve[i]);
					}
					
					if(sRUpdateInvd01.equals("N"))
						ClsInventaryLog.StrSQLException(em, "Error al momento de actualizar reserva de CPD");
					
				}
			}
			sResult = "S";
			
		}
		else
			ClsInventaryLog.StrSQLException(em, "No se pudo reservar inventario, conflicto al asignar numero de documento");
		
		return sResult;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param strCompanyCode
	 * @param strSucursCode
	 * @param strWareHouse
	 * @param strProformNumber
	 * @param strBudgetNumber
	 * @param strItemCode
	 * @param strQuantityUnReserve
	 * @param strCPD1UnReserve
	 * @param strCPD8UnReserve
	 * @param strCustomerCode
	 * @param strCustomerName
	 * @param strUserName
	 * @return
	 * @throws Exception
	 */
	public String setUnReserveSpareParts(String strCompanyCode,
									   String strSucursCode,
									   String strWareHouse,
									   String strProformNumber,
									   String strBudgetNumber,
									   String[] strItemCode,
									   String[] strQuantityUnReserve,
									   String[] strCPD1UnReserve,
									   String[] strCPD8UnReserve,
									   String strCustomerCode,
									   String strCustomerName,
									   String strUserName) throws Exception
	{
		String sResult = "N";
		
		if(strProformNumber.equals("0"))
			ClsInventaryLog.StrSQLException(em, "No se puede des reservar articulos por falta de proformas");
		
		if(strBudgetNumber.equals("0"))
			ClsInventaryLog.StrSQLException(em, "No se puede des reservar articulos por falta de Presupuesto asociado a proforma");
		
		
		if(strQuantityUnReserve.equals("0"))
			ClsInventaryLog.StrSQLException(em, "Cantidad a reservar no puede ser cero");
		
		ClsInventaryLog inventoryLog = new ClsInventaryLog();
		ClsProform proform = new ClsProform();
		ClsWineryInventoryCPD inventoryCPD = new ClsWineryInventoryCPD();
		
		for(int i = 0; i < strItemCode.length; i++)
		{
			String strDepartment = "";
			
			if(!strCPD1UnReserve.equals("0") || !strCPD8UnReserve.equals("0"))
			{
				List<WineryInventoryCPD> lstInventoryCPDs = new ArrayList<WineryInventoryCPD>();
				if(strCompanyCode.equals("01"))
				{
					lstInventoryCPDs = inventoryCPD.getWineryInventoryCPD(em, 
																		  new String[]{strItemCode[i]});
				}
				else
				{
					lstInventoryCPDs = inventoryCPD.getWineryInventoryCPDAnotherCompany(em, 
																						strCompanyCode,
							   														 	new String[]{strItemCode[i]});
				}
				
				int iCantidadReservadoCPD1 = 0;
				int iCantidadReservadoCPD8 = 0;
				
				for(Object o : lstInventoryCPDs)
				{
					WineryInventoryCPD wineryInventoryCPD = (WineryInventoryCPD)o;
					
					iCantidadReservadoCPD1 = wineryInventoryCPD.getReservaB1();
					iCantidadReservadoCPD8 = wineryInventoryCPD.getReservaB8();
					
					strDepartment = wineryInventoryCPD.getDepartamento();
					break;
				}
				
				if(strDepartment.equals(""))
					ClsInventaryLog.StrSQLException(em, "Articulo no existe en la compania seleccionado");
				
				int iCPD1Reserve = Integer.parseInt(strCPD1UnReserve[i]);
				int iCPD8Reserve = Integer.parseInt(strCPD8UnReserve[i]);
				
				if(iCPD1Reserve > iCantidadReservadoCPD1)
					ClsInventaryLog.StrSQLException(em, "No hay suficiente item reservado en bodega 1 de CPD para desreservar el articulo " + strItemCode[i]);
				
				if(iCPD8Reserve > iCantidadReservadoCPD8)
					ClsInventaryLog.StrSQLException(em, "No hay suficiente item reservado en bodega 8 de CPD para desreservar el articulo " + strItemCode[i]);
				
				
			}
			
			List<Proform> lstProforms = proform.getProformAll(em, 
															   strCompanyCode, 
															   strSucursCode,
															   strWareHouse,
															   strProformNumber, 
															   null,
															   new String[]{strBudgetNumber},
															   new String[]{null},
															   new String[]{null},
															   new String[]{null},
															   strItemCode[i]);
			
			if(lstProforms.size() == 0)
				ClsInventaryLog.StrSQLException(em, "Proforma no existe o no esta asociado al numero de presupuesto enviado o Articulo no esta asociado a la proforma");
			
			int iQuantityReserve = Integer.parseInt(strQuantityUnReserve[i]);
			int iCantidadReservadaP = 0;
			
			for(Object o : lstProforms)
			{
				Proform proform2 = (Proform)o;
				iCantidadReservadaP = proform2.getCantReservado();
//				System.out.println("Entro: " + iQuantityReserve);
				break;
			}
			
			if(iQuantityReserve > iCantidadReservadaP)
				ClsInventaryLog.StrSQLException(em, "Se esta intendado desreservar mas de lo reservado en proforma, revisar proforma #" + strProformNumber + " Articulo Codigo " + strItemCode[i]);
			
			List<InventoryLog> lstIL = inventoryLog.getInventoryLog(em, 
																	strCompanyCode, 
																	strSucursCode, 
																	strDepartment,
																	strWareHouse, 
																	null, 
																	strProformNumber, 
																	strBudgetNumber, 
																	strItemCode[i]);
			
			if(lstIL.size() > 0)
			{
				
//				String strDocumentNumber = "0";
//				for(Object o : lstIL)
//				{
//					InventoryLog inventory = (InventoryLog)o;
//					strDocumentNumber = String.valueOf(inventory.getNoDocumento());
//				}
				
				String sRInsertLog = inventoryLog.setInventoryLogCancel(em, 
																		strCompanyCode, 
																		strSucursCode, 
																		strWareHouse, 
																		null,
																		strItemCode[i],
																		strUserName);
				
				if(sRInsertLog.equals("N"))
					ClsInventaryLog.StrSQLException(em, "Error al momento de insertar movimiento a invd38");
				
				
				String sRUpdateRProf = proform.setProformUnReserve(em, 
																 strCompanyCode, 
																 strProformNumber, 
																 strBudgetNumber, 
																 null,
																 strItemCode[i],
																 strQuantityUnReserve[i], 
																 strUserName);
				
				if(sRUpdateRProf.equals("N"))
					ClsInventaryLog.StrSQLException(em, "Error al momento de actualizar reserva en la tabla de proforma");
				
				
				if(!strCPD1UnReserve.equals("0") || !strCPD8UnReserve.equals("0"))
				{
					
					String sRUpdateInvd01 = "";
					if(strCompanyCode.equals("01"))
					{
						sRUpdateInvd01 = inventoryCPD.setWineryInventoryCPDUnReserve(em, 
																				  strItemCode[i], 
																				  strCPD1UnReserve[i], 
																				  strCPD8UnReserve[i]);
					}
					else
					{
						sRUpdateInvd01 = inventoryCPD.setWineryInventoryCPDUnReserveAnotherCompany(em,
																								strCompanyCode,
																								strItemCode[i], 
																								strCPD1UnReserve[i], 
																								strCPD8UnReserve[i]);
					}
					
					if(sRUpdateInvd01.equals("N"))
						ClsInventaryLog.StrSQLException(em, "Error al momento de actualizar reserva de CPD");
					
				}
			}
			else
				ClsInventaryLog.StrSQLException(em, "No se pudo desreservar inventario, presupuesto y proforma no correponden a un movimiento de inventario, o el item que desea desreservar no es valido");
		
			sResult = "S";
			
		}
		
		
		return sResult;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param strCompanyCode
	 * @param strSucursCode
	 * @param strWareHouse
	 * @param strProformNumber
	 * @param strBudgetNumber
	 * @param strItemCode
	 * @param strQuantityUnReserve
	 * @param strCPD1UnReserve
	 * @param strCPD8UnReserve
	 * @param strCustomerCode
	 * @param strCustomerName
	 * @param strUserName
	 * @return
	 * @throws Exception
	 */
	public String setUnReserveSparePartsAll(String strCompanyCode,
											   String strSucursCode,
											   String strWareHouse,
											   String strBudgetNumber,
											   String strUserName) throws Exception
	{
		String sResult = "N";
		
		if(strBudgetNumber.equals("0"))
			ClsInventaryLog.StrSQLException(em, "No se puede des reservar articulos por falta de Presupuesto asociado a proforma");
		
		ClsInventaryLog inventoryLog = new ClsInventaryLog();
		ClsProform proform = new ClsProform();
		ClsWineryInventoryCPD inventoryCPD = new ClsWineryInventoryCPD();
		
		List<Proform> lstProf = proform.getProformAll(em, 
													  strCompanyCode, 
													  strSucursCode, 
													  strWareHouse, 
													  null,
													  null,
													  new String[]{strBudgetNumber},
													  new String[]{null},
													  new String[]{null},
													  new String[]{null},
													  null);
		
		int iProforma = 0;
		for(Object o : lstProf)
		{
			Proform prof = (Proform)o;
			
			if(iProforma != prof.getNoProforma())
			{
				List<InventoryLog> lstInv = inventoryLog.getInventoryLog(em, 
																		 strCompanyCode, 
																		 strSucursCode, 
																		 null, 
																		 strWareHouse, 
																		 null, 
																		 String.valueOf(prof.getNoProforma()), 
																		 strBudgetNumber, 
																		 null);
				
				for(Object o1 : lstInv)
				{
					InventoryLog il = (InventoryLog)o1;
					
					if(!il.getEstadoDesReserva().trim().equals("A"))
					{
						int iCPD1Reserve = il.getCantidadResercadaCPD1();
						int iReserve = il.getCantidadReservada();
						int iCPD8Reserve = il.getCantidadReservadaCPD8();
						
						List<WineryInventoryCPD> lstInventoryCPDs = new ArrayList<WineryInventoryCPD>();
						if(strCompanyCode.equals("01"))
						{
							lstInventoryCPDs = inventoryCPD.getWineryInventoryCPD(em, 
																				  new String[]{il.getCodArticulo()});
						}
						else
						{
							lstInventoryCPDs = inventoryCPD.getWineryInventoryCPDAnotherCompany(em, 
																								strCompanyCode,
									   														 	new String[]{il.getCodArticulo()});
						}
						
						int iCantidadReservadoCPD1 = 0;
						int iCantidadReservadoCPD8 = 0;
						String strDepartment = "";
						
						for(Object o2 : lstInventoryCPDs)
						{
							WineryInventoryCPD wineryInventoryCPD = (WineryInventoryCPD)o2;
							
							iCantidadReservadoCPD1 = wineryInventoryCPD.getReservaB1();
							iCantidadReservadoCPD8 = wineryInventoryCPD.getReservaB8();
							
							strDepartment = wineryInventoryCPD.getDepartamento();
							break;
						}
						
						if(strDepartment.equals(""))
							ClsInventaryLog.StrSQLException(em, "Articulo no existe en la compania seleccionado");
	
						
						if(iCPD1Reserve > iCantidadReservadoCPD1)
							ClsInventaryLog.StrSQLException(em, "No hay suficiente item reservado en bodega 1 de CPD para desreservar el articulo " + il.getCodArticulo());
						
						if(iCPD8Reserve > iCantidadReservadoCPD8)
							ClsInventaryLog.StrSQLException(em, "No hay suficiente item reservado en bodega 8 de CPD para desreservar el articulo " + il.getCodArticulo());
						
						
						List<Proform> lstProforms = proform.getProformAll(em, 
																		   strCompanyCode, 
																		   strSucursCode,
																		   strWareHouse,
																		   String.valueOf(prof.getNoProforma()),
																		   null,
																		   new String[]{strBudgetNumber},
																		   new String[]{null},
																		   new String[]{null},
																		   new String[]{null},
																		   il.getCodArticulo());
						
						if(lstProforms.size() == 0)
							ClsInventaryLog.StrSQLException(em, "Proforma no existe o no esta asociado al numero de presupuesto enviado o Articulo no esta asociado a la proforma");
						
						int iQuantityReserve = il.getCantidadReservada();
						int iCantidadReservadaP = 0;
						
						for(Object o2 : lstProforms)
						{
							Proform proform2 = (Proform)o2;
							iCantidadReservadaP = proform2.getCantReservado();
//							System.out.println("Entro: " + iQuantityReserve);
							break;
						}
						
						if(iQuantityReserve > iCantidadReservadaP)
							ClsInventaryLog.StrSQLException(em, "Se esta intendado desreservar mas de lo reservado en proforma, revisar proforma #" + String.valueOf(prof.getNoProforma()) + " Articulo Codigo " + il.getCodArticulo());
						
						String sRInsertLog = inventoryLog.setInventoryLogCancel(em, 
																				strCompanyCode, 
																				strSucursCode, 
																				strWareHouse, 
																				null,
																				String.valueOf(il.getCodArticulo()),
																				strUserName);
					
						if(sRInsertLog.equals("N"))
							ClsInventaryLog.StrSQLException(em, "Error al momento de insertar movimiento a invd38");
						
						
						String sRUpdateRProf = proform.setProformUnReserve(em, 
																			 strCompanyCode, 
																			 String.valueOf(prof.getNoProforma()), 
																			 strBudgetNumber, 
																			 null,
																			 il.getCodArticulo(),
																			 String.valueOf(iReserve), 
																			 strUserName);
						
						if(sRUpdateRProf.equals("N"))
							ClsInventaryLog.StrSQLException(em, "Error al momento de actualizar reserva en la tabla de proforma");
						
						
						String sRUpdateInvd01 = "";
						if(strCompanyCode.equals("01"))
						{
							sRUpdateInvd01 = inventoryCPD.setWineryInventoryCPDUnReserve(em, 
																						 String.valueOf(il.getCodArticulo()), 
																						 String.valueOf(iCPD1Reserve), 
																						 String.valueOf(iCPD8Reserve));
						}
						else
						{
							sRUpdateInvd01 = inventoryCPD.setWineryInventoryCPDUnReserveAnotherCompany(em,
																										strCompanyCode,
																										String.valueOf(il.getCodArticulo()), 
																										 String.valueOf(iCPD1Reserve), 
																										 String.valueOf(iCPD8Reserve));
						}
						
						if(sRUpdateInvd01.equals("N"))
							ClsInventaryLog.StrSQLException(em, "Error al momento de actualizar reserva de CPD");
									
					}
				}
			}
		}
		
		sResult = "S";
		
		return sResult;
	}
	
}
