 package ni.com.casapellas.erp.gcpfmu;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.openjpa.lib.conf.StringValue;

import com.google.gson.Gson;

import ni.com.casapellas.apikey.inventario.authentication.GCPInventarioAccountsServiceAuthenticator;
import ni.com.casapellas.apikey.resource.key.ApiKey;
import ni.com.casapellas.gcpfmu.pojo.BillHeader;
import ni.com.casapellas.gcpfmu.pojo.BillPost;
import ni.com.casapellas.gcpfmu.pojo.CardResponse;
import ni.com.casapellas.gcpfmu.pojo.CashBillPost;
import ni.com.casapellas.gcpfmu.pojo.CashBillReceiptRelation;
import ni.com.casapellas.gcpfmu.pojo.CashChangeDetail;
import ni.com.casapellas.gcpfmu.pojo.CashReceipt;
import ni.com.casapellas.gcpfmu.pojo.CashReceiptPaymentItem;
import ni.com.casapellas.gcpfmu.pojo.FMUUtil;
import ni.com.casapellas.gcpfmu.pojo.PostObjectReturn;
import ni.com.casapellas.geninfo.pojo.Parameter;
import ni.com.casapellas.tool.restful.connection.RestConnection;
import ni.com.casapellas.tool.restful.connection.RestResponse;
import ni.com.casapellas.util.CollectionScheme;

/**
 * 
 * @author Jonathan
 *
 */

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN) 
@SuppressWarnings({"unchecked"})
public class ClsCashManager {
	
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;

	@Resource 
	private SessionContext sessionContext;  

	@EJB
	private ClsLogs clsLogs;
	
	private static String errorMsg2;
	
	 private static ApiKey apiKey = null;
	    
	private DecimalFormat format = new DecimalFormat("##.00");	
	  
	static {
	    apiKey = new GCPInventarioAccountsServiceAuthenticator();
	}
	   
	public boolean insertCajaFactura(BillHeader billHeader, EntityManager em) {
		
		boolean billSaved = false;
			
		// Get Row 0 of the bill
		BillPost billPost = billHeader.getBillPosts().get(0);
		
		debugCaja(billPost, billHeader);
		
		if(insertCajaCabecera(billPost, em, billHeader) > 0) {
			billSaved = insertCajaDetalle(billHeader.getBillPosts(), em); 
		}
		
		return billSaved;
	}
	
	
	private int insertCajaCabecera(BillPost billPost, EntityManager em, BillHeader billHeader) {
		
		try {
			String sQuery = "INSERT INTO " + CollectionScheme.SchemeCAJA +  ".A02FACTCO (" +
				"NOFACTURA," +
				"TIPOFACTURA," +
				"CODCLI," +
				"NOMCLIE," +
				"CODUNINEG," +
				"UNINEG," +
				"CODSUC," +
				"NOMSUC," +
				"CODCOMP," +
				"NOMCOMP," +
				"FECHA," +
				"SUBTOTAL," +
				"MONEDA," +
				"TASA," +
				"TIPOPAGO," +
				"FECHAGRAB," +
				"HECHOPOR," +
				"PANTALLA," +
				"HORA," +
				"ESTADO," +
				"NODOCO," +
				"TIPODOCO," +
				"TOTAL," +
				"SDLOCN," +				
				"PROGRAMAID," +
				"CODVENDOR," +
				"SUBTOTALF," +
				"TOTALF," +
				"TOTALCOSTO," +
				"ENVIADOA," +		
				"FECHADOCO) " +
				
		"VALUES (" + billPost.getBillId() + ", " +
			 		"'" + billPost.getIndct() + "', " +
			 		"" + billPost.getClientId() + ", " +
			 		"'" + billPost.getClientName() + "', " +
			 		"'" + FMUUtil.getJdLineNumberSpace(billPost.getJdLineId()) + billPost.getJdLineId() + "', " +
			 		"'" + billPost.getJdLineName() + "', " +
			 		"'" + billPost.getJdBranchId() + "', " +
			 		"'" + billPost.getJdBranchName() + "', " +
			 		"'" + billPost.getJdCompanyId() + "', " +
			 		"'" + billPost.getJdCompanyName() + "', " +
			 		"" + FMUUtil.dateToJulian(new Date()) + ", " +
			 		" " + (billPost.getCoin().equals(FMUUtil.US_COIN_ID) ? (billPost.getSubtotalCR()) : (billPost.getSubtotal())) + ", " +
			 		"'" + billPost.getCoin() + "', " +
			 		" " + String.valueOf(billPost.getExchange()) + ", " +
			 		"'" + ((billPost.getConditionType().equals(FMUUtil.CREDIT_LETTER)) ? FMUUtil.CREDIT_TYPE : FMUUtil.CASH_TYPE)  + "', " +
			 		" " + FMUUtil.dateToJulian(new Date()) + ", " +
			 		"'" + billPost.getUserId() + "', " +
			 		"'" + billPost.getSoftwareId() + "', " +
			 		" " + billPost.getHora() + ", " +
			 		"'" + "" + "', " +
			 		" " + billHeader.getReturnBillId() + ", " +
			 		"'" + billHeader.getType() + "', " +
			 		" " + (billPost.getCoin().equals(FMUUtil.US_COIN_ID) ? (String.valueOf(billPost.getTotalCR())) : (String.valueOf(billPost.getTotal())))  + ", " +
			 		"'" + billPost.getSellerId() + "', " +
			 		"'" + billPost.getSoftwareId() + "', " +
			 		" " + billPost.getSellerNumber() + ", " +
			 		" " + (billPost.getCoin().equals(FMUUtil.US_COIN_ID) ? (billPost.getSubtotal()) : 0) + ", " +
			 		" " + (billPost.getCoin().equals(FMUUtil.US_COIN_ID) ? (billPost.getTotal()) : 0) + ", " +
			 		" " + (billPost.gettCostoCR()) + ", " +
			 		" " + billPost.getClientId() + ", " +
			 		" " + billHeader.getReturnBillDate() + ")";
						
		return em.createNativeQuery(sQuery).executeUpdate();
	
		} catch (Exception e) {
		// TODO: handle exception
			ClsBillManager.setErrorMsg(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	private boolean insertCajaDetalle(List<BillPost> billPosts, EntityManager em) {
	
		boolean state = true;
		int i = 1;
		
		for (BillPost billPost : billPosts) {
			
			try {
				String sQuery = "INSERT INTO " + CollectionScheme.SchemeCAJA +".A03FACTCO (" +
					"NOFACTURA," +
					"TIPOFACTURA," +
					"CODITEM," +
					"DESCITEM," +
					"PRECIOUNIT," +
					"CANT," +
					"IMPUESTO," +
					"FACTOR," +
					"CODUNINEG," +
					"CODSUC," +
					"PCOSTO," +
					"DESCUENTO," +
					"CODCLI," +
					"FECHA," +
					"ENVIADOA," +	
					"LINEA) " +
					
			"VALUES (" + billPost.getBillId() + ", " +
				 		"'" + billPost.getIndct() + "', " +
				 		"'" + billPost.getProductId() + "', " +
				 		"'" + billPost.getProductName().replace("\n", "").trim() + "', " +
				 		" " + (billPost.getPriceWithDiscount())  +  ", " +
				 		" " + billPost.getBillQuantity() + ", " +
				 		"'" + (billPost.getIva() > 0 ? "IMP" : "EXE") + "', " +
				 		" " + new BigDecimal(billPost.getIva()).multiply(new BigDecimal(1000)) + ", " +
				 		"'" + FMUUtil.getJdLineNumberSpace(billPost.getJdLineId()) + billPost.getJdLineId() + "', " +
				 		"'" + billPost.getJdBranchId() + "', " +
				 		" " + billPost.getVALORG() + ", " +
				 		" " + (billPost.getDiscount()) + ", " +
				 		" " + billPost.getClientId() + ", " +
				 		" " + FMUUtil.dateToJulian(new Date()) + ", " +
				 		" " + billPost.getClientId() + ", " +
				 		" " + i + ")";
				
				em.createNativeQuery(sQuery).executeUpdate();
		
			} catch (Exception e) {
			// TODO: handle exception
				ClsBillManager.setErrorMsg(e.getMessage());
				e.printStackTrace();
				state = false;
			}
			
			i++;			
		}
		
		return state;
	}
	
	private void debugCaja(BillPost billPost, BillHeader billHeader) {
		
		System.out.println("===========  CAJA ==============\n\n");
		
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - TIPOFACTURA  : " +  billPost.getIndct());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - CODCLI  : " +  billPost.getClientId());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - NOMBRECLIE  : " +  billPost.getClientName());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - CODUNINEG  : " +  billPost.getJdLineId());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - UNINEG  : " +  billPost.getJdLineName());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - CODSUC  : " +  billPost.getJdBranchId());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - NOMSUC  : " +  billPost.getJdBranchName());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - CODCOMP  : " +  billPost.getJdCompanyId());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - NOMCOMP  : " +  billPost.getJdCompanyName());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - FECHA  : " +  billPost.getDate());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - SUBTOTAL  : " +  (billPost.getSubtotal()));
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - MONEDA  : " +  billPost.getCoin());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - TASA  : " +  String.format("%.4f", billPost.getExchange()));
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - TIPOPAGO  : " +  FMUUtil.CASH_TYPE);
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - FECHAGRAB - : " +  FMUUtil.dateToJulian(new Date()));
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - HECHOPOR  : " +  billPost.getUserId());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - PANTALLA  : " +  billPost.getSoftwareId());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - HORA  : " +  billPost.getHora());
		
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - ESTADO  : " +  "");
		
		// Numero de factura cuando es devolucion
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - NODOCO  : " +  billHeader.getReturnBillId());
		
		// Tipo factura
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - TIPOQDOCO  : " +  billHeader.getType());
		
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - TOTAL  : " +  (billPost.getTotalCR()));
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - SDLOCN  : " +  billPost.getSellerId());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - PROGRAMAID  : " +  billPost.getSoftwareId());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - CODVENDOR  : " +  billPost.getSellerNumber());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - SUBTOTALF  : " +  (billPost.getSubtotal()));
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - TOTALF  : " +  (billPost.getTotal()));
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - TOTALCR  : " +  (billPost.getTotalCR()));
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - TOTALCOSTO  : " +  (billPost.gettCostoCR()));
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - ENVIADOA  : " +  billPost.getClientId());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - IVA  : " +  billPost.getTotalIva());
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - IVACR  : " +  billPost.getTotalIvaCR());
		
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - SUBTOTAL  : " +  billPost.getSubtotal());

		System.out.println("CAJA :  " + billPost.getBillId()  +  " - SUBTOTALCR  : " +  billPost.getSubtotalCR());

		// Fecha retorno factura original
		System.out.println("CAJA :  " + billPost.getBillId()  +  " - FECHADOCO  : " +  0);

	}
	
	public void setCajaBillAsCancel(BillHeader billHeader, EntityManager em) {
		try {
	
			BillPost billPost = billHeader.getBillPosts().get(0);
				
			if (billPost == null) {
				return;
			}
			
			String sQuery = "update " + CollectionScheme.SchemeCAJA + ".A02FACTCO set ESTADO = 'A'  "
					+ "where NOFACTURA = ? "
					+ "and CODCLI = ? "
					+ "and FECHA = ?";
			
			em.createNativeQuery(sQuery).
					setParameter(1, billPost.getBillId()).
					setParameter(2, billPost.getClientId()).
					setParameter(3, FMUUtil.dateToJulian(new Date())).executeUpdate();
		}

		catch (Exception e) {
			// TODO: handle exception
			ClsBillManager.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}	
	}

	/****************************************************************************************************************
	 * Metodo que se encarga de crear recibos en el sistema de caja.
	 *  
	 * <ul>
	 * <li>Modificado por  : Francisco Landeros
	 * <li>Mofificado el   : 31/07/2018
	 * <li>Cambio realizado: Modificacion de consulta del metodo checkIfReceiptExits, se agrego parametro de
	 * 		codigo de compania
	 * </ul>
	 * --------------------------------------------------------------------------------------------------------------
	 * @param cajaBillPosts
	 * @param cashCancelList
	 * @return
	 * @throws Exception
	 */
	public List<PostObjectReturn> createCajaReceipt(List<CashBillPost> cajaBillPosts, List<CashBillPost> cashCancelList, String sJson) throws Exception {
    
		UserTransaction utx = sessionContext.getUserTransaction();

		ArrayList<PostObjectReturn> billCajaListPostReturns = new ArrayList<PostObjectReturn>();
		ArrayList<CashReceiptPaymentItem> cashReceiptPaymentItems = new ArrayList<CashReceiptPaymentItem>();

		boolean iTechPay = false;
		
		int idJsonLog = ClsSystemLogs.createJsonLog(sJson);

		try {
			for (CashBillPost cajaBillPost : cajaBillPosts) {

				PostObjectReturn billCajaListPostReturn = new PostObjectReturn();
			
				PostObjectReturn checkIfExits = null;
				
				checkIfExits = checkIfReceiptExits(idJsonLog, cajaBillPost.getCashReceipt().getReceiptNumber(),
						cajaBillPost.getCashReceipt().getCashId(), cajaBillPost.getCashReceipt().getUserId(), 
						cajaBillPost.getCashReceipt().getJdCompanyId());
				
				if (checkIfExits !=null) {				
					checkIfExits.setErrorMsg("");
					checkIfExits.setBillId(String.valueOf(cajaBillPost.getCashReceipt().getReceiptNumber()));
					checkIfExits.setCompanyId(cajaBillPost.getCashReceipt().getJdCompanyId());
					checkIfExits.setMovementType("");
					checkIfExits.setState(true);
					checkIfExits.setUseCustomErrorMsg(false);
					billCajaListPostReturns.add(checkIfExits);
					continue;
				}
				
				utx.begin();
				errorMsg2 = "";

				billCajaListPostReturn.setBillId(String.valueOf(cajaBillPost.getCashReceipt().getReceiptNumber()));
				billCajaListPostReturn.setCompanyId(cajaBillPost.getCashReceipt().getJdCompanyId());
				billCajaListPostReturn.setMovementType("");

				if (insertReceipt(idJsonLog, em, cajaBillPost.getCashReceipt()) > 0) {
					
					for (CashReceiptPaymentItem cajaPaymentItem : cajaBillPost.getCashReceiptPaymentItems()) {
						
						iTechPay = cajaPaymentItem.getMethod().equals(FMUUtil.CREDIT_CARD_PAYMENT_METHOD) 
								&& !cajaPaymentItem.getCardNumber().equals("") &&
								!cajaPaymentItem.getEndDate().equals("");												
					}

					for (CashReceiptPaymentItem cajaPaymentItem : cajaBillPost.getCashReceiptPaymentItems()) {
						insertReceiptDetail(idJsonLog, em, cajaPaymentItem, cajaBillPost.getCashReceipt());
					}

					for (CashBillReceiptRelation cajaBillReceiptRelation : cajaBillPost.getCashBillReceiptRelations()) {
						insertReciboFact(idJsonLog, em, cajaBillReceiptRelation, cajaBillPost.getCashReceipt());
					}

					for (CashChangeDetail cajaReceiptChange : cajaBillPost.getCashChangeDetails()) {
						insertChangeReceipt(idJsonLog, em, cajaReceiptChange, cajaBillPost.getCashReceipt());
					}

					// update receipt Sequence
					if (updateReceiptSequence(idJsonLog, em, cajaBillPost.getCashReceipt()) > 0) {
						int batchNumber = getBatchSequenceNumber(em);
						boolean isCash = cajaBillPost.getCashReceipt().getTypeReceipt().equals(FMUUtil.CASH_LETTER);

						int numberReceiptJDE = getReciboJdeSequence(idJsonLog, em, cajaBillPost.getCashReceipt().getJdCompanyId(),
								isCash);

						if (insertReciboJDERelation(idJsonLog, em, cajaBillPost.getCashReceipt(), batchNumber, numberReceiptJDE,
								cajaBillPost.getCashReceipt().getTypeReceipt()) > 0) {
							billCajaListPostReturn.setBatchNumber(batchNumber);
							billCajaListPostReturn.setJdeNumber(numberReceiptJDE);
							billCajaListPostReturn.setState(true);
						}

						if (isCash) {
							ClsAccountingManager.createBatchDetail(idJsonLog, em, cajaBillPost.getCashBillReceiptRelations(),
									cajaBillPost.getCashReceiptPaymentItems(), cajaBillPost.getCashReceipt(),
									batchNumber, numberReceiptJDE);
						} else {
							
							/**
							 * Change: create receipt before update pending amount. 2020-08-19 ch
							 */
							/*
							ClsCreditManager.updatePendingAmount(idJsonLog, em, cajaBillPost.getCashReceipt(),
									cajaBillPost.getCashBillReceiptRelations());
							ClsCreditManager.createReceiptDetail(idJsonLog, em, cajaBillPost.getCashBillReceiptRelations(),
									cajaBillPost.getCashReceiptPaymentItems(), cajaBillPost.getCashReceipt(),
									batchNumber, numberReceiptJDE, cajaBillPost.getCashChangeDetails().get(0));
							*/		
							 
							List<CashBillReceiptRelation>listForUpdateF03b11 = new ArrayList<CashBillReceiptRelation>();
							for (CashBillReceiptRelation crpr : cajaBillPost.getCashBillReceiptRelations()) {
								listForUpdateF03b11.add(copyValuesNotReference(crpr));
							}							
							
							ClsCreditManager.createReceiptDetail(idJsonLog, em, cajaBillPost.getCashBillReceiptRelations(),
									cajaBillPost.getCashReceiptPaymentItems(), cajaBillPost.getCashReceipt(),
									batchNumber, numberReceiptJDE, cajaBillPost.getCashChangeDetails().get(0));	
							
							ClsCreditManager.updatePendingAmount(idJsonLog, em, cajaBillPost.getCashReceipt(),
									listForUpdateF03b11, batchNumber);
							
							billCajaListPostReturn.setCashBillReceiptRelation(listForUpdateF03b11);

						}
						
						if (cajaBillPost.getSurplusExchange() != null) {
							if (cajaBillPost.getSurplusExchange().getType().equals(FMUUtil.SOBRANTE_LETTER)) {
								ClsAccountingManager.createSurplusExchange(idJsonLog, em, cajaBillPost.getSurplusExchange(),
										cajaBillPost.getCashReceipt());
							}
						}

						if (cajaBillPost.getCashSheetReceipt() != null
								&& cajaBillPost.getCashSheetReceiptPaymentItem() != null) {
							createFichaCambio(idJsonLog, em, cajaBillPost.getCashSheetReceiptPaymentItem(),
									cajaBillPost.getCashSheetReceipt());
						}
					}
				}

				billCajaListPostReturn.setErrorMsg(getErrorMsg2());

				if (billCajaListPostReturn.getErrorMsg().equals("")) {
					
					if (iTechPay) {// Consultar, Se puede realizar pagos de tarjetas de creditos?
						for (CashReceiptPaymentItem cajaPaymentItem : cajaBillPost.getCashReceiptPaymentItems()) {


							if (cajaPaymentItem.getMethod().equals(FMUUtil.CREDIT_CARD_PAYMENT_METHOD)
									&& !cajaPaymentItem.getCardNumber().equals("")
									&& !cajaPaymentItem.getEndDate().equals("")) {

								System.out.println("Tarjeta : " + cajaPaymentItem.getCardNumber());
								System.out.println("Tarjeta Fecha FIN : " + cajaPaymentItem.getEndDate());
								System.out.println("Codigo Seguridad : " + cajaPaymentItem.getRefer3());
								System.out.println("Numero recibo : " + cajaBillPost.getCashReceipt().getReceiptNumber());
								System.out.println("Monto : " + "1.00");
								System.out.println("Numero CAJA : " + cajaBillPost.getCashReceipt().getReceiptNumber());
								System.out.println("Numero recibo : " + cajaBillPost.getCashReceipt().getReceiptNumber());
								System.out.println("Numero Terminal : " + cajaPaymentItem.getRefer5());
								System.out.println("Usuario : " + cajaBillPost.getCashReceipt().getUserId());
								System.out.println("SoftwareId : " + cajaBillPost.getCashReceipt().getSoftwareId());
								System.out.println("SoftwareId : " + cajaBillPost.getCashReceipt().getSoftwareId());
								System.out.println("DeviceId : " + cajaBillPost.getCashReceipt().getDeviceId());

								RestResponse result = setAplicarPagos(
										cajaPaymentItem.getCardNumber(),
										cajaPaymentItem.getEndDate(),
										//"0821",
										cajaPaymentItem.getRefer3(),
										//"072",
										String.valueOf(cajaBillPost.getCashReceipt().getReceiptNumber()), 
										format.format(cajaPaymentItem.getAmount()),
										//"1.00",
										String.valueOf(cajaBillPost.getCashReceipt().getCashId()),
										String.valueOf(cajaBillPost.getCashReceipt().getReceiptNumber()),
										cajaPaymentItem.getRefer5(), 
										cajaBillPost.getCashReceipt().getUserId(),
										cajaBillPost.getCashReceipt().getSoftwareId(),
										cajaBillPost.getCashReceipt().getSoftwareId(),
										cajaBillPost.getCashReceipt().getDeviceId());

								String data = result.getDataAsString();
							
								if (!data.equals("")) {
									
									Gson gson = new Gson();
									CardResponse responseData = gson.fromJson(data, CardResponse.class);

									if (responseData.getCodigoRespuesta().trim().equals("1")) {
										// set Transaction Id
										cajaPaymentItem.setTransactionId(responseData.getTransactionId());
										cajaPaymentItem.setRefer5(cajaPaymentItem.getRefer5());

										cashReceiptPaymentItems.add(cajaPaymentItem);
										billCajaListPostReturn.setCashReceiptPaymentItems(cashReceiptPaymentItems);

										// Update receipt
										updateReceiptRefer(cajaBillPost.getCashReceipt().getCashId(), cajaPaymentItem.getReceiptNumber(),
												responseData.getTransactionId());
										
									} else {
										setErrorMsg2(responseData.getDescripcionRespuesta());
										billCajaListPostReturn.setUseCustomErrorMsg(true);
									}
								} else {
									setErrorMsg2("Hubo un error al procesar el pago de su tarjeta");
									billCajaListPostReturn.setUseCustomErrorMsg(true);
								}
							}
						}
						
						billCajaListPostReturn.setErrorMsg(getErrorMsg2());
						
						if (billCajaListPostReturn.getErrorMsg().equals("")) {
							utx.commit();
						}	else {
							CashReceipt cashReceipt = cajaBillPost.getCashReceipt();
							clsLogs.insertErrorLogDetail(cashReceipt.getCellarId(), FMUUtil.getSubsString(billCajaListPostReturn.getErrorMsg()), 
									cashReceipt.getUserId(), cashReceipt.getJdBranchId(), FMUUtil.RECEIPT_CODE, String.valueOf(cashReceipt.getReceiptNumber()),
									cashReceipt.getJdCompanyId());
							utx.rollback();
						}
					} else {
						utx.commit();
					}
					
				} else {
					// Save logs
					CashReceipt cashReceipt = cajaBillPost.getCashReceipt();
					clsLogs.insertErrorLogDetail(cashReceipt.getCellarId(), FMUUtil.getSubsString(billCajaListPostReturn.getErrorMsg()), 
							cashReceipt.getUserId(), cashReceipt.getJdBranchId(), FMUUtil.RECEIPT_CODE, String.valueOf(cashReceipt.getReceiptNumber()),
							cashReceipt.getJdCompanyId());
					utx.rollback();
				}

				billCajaListPostReturns.add(billCajaListPostReturn);
			}
			
			if (cashCancelList.size() > 0) {

				for (CashBillPost cajaBillPost : cashCancelList) {

					CashReceipt cashReceipt = cajaBillPost.getCashReceipt();
					
					boolean isTechPay = false;

					for (CashReceiptPaymentItem cajaPaymentItem : cajaBillPost.getCashReceiptPaymentItems()) {
						isTechPay = cajaPaymentItem.getMethod().equals(FMUUtil.CREDIT_CARD_PAYMENT_METHOD) 
							&& !cajaPaymentItem.getCardNumber().equals("") &&
							!cajaPaymentItem.getEndDate().equals("");
					}

					billCajaListPostReturns.add(cancelReceipt(cashReceipt.getJdeReceiptNumber(),
							cashReceipt.getBatchNumber(), cashReceipt.getReceiptNumber(), cashReceipt.getCashId(),
							cashReceipt.getJdCompanyId(), cashReceipt.getCashSheetId(), cashReceipt.getTypeReceipt(),
							cajaBillPost.getCashBillReceiptRelations(), utx,  cajaBillPost.getCashReceiptPaymentItems(), isTechPay,
							cashReceipt));

					if (cashReceipt.getCode() != 0) {
						utx.begin();
						int result = ClsBillManager.updateDiscountCode(em, cashReceipt.getJdCompanyId(),
								cashReceipt.getJdBranchId(), cashReceipt.getTypeCode(), cashReceipt.getUserId(),
								cashReceipt.getCellarId(), cashReceipt.getCode(), cashReceipt.getHour(),
								cashReceipt.getReceiptNumber());

						if (result > 0) {
							utx.commit();
						} else {
							clsLogs.insertErrorLogDetail(cashReceipt.getCellarId(), "ERROR REGISTRANDO CODIGO AUTORIZACION", 
									cashReceipt.getUserId(), cashReceipt.getJdBranchId(), FMUUtil.RECEIPT_CODE, String.valueOf(cashReceipt.getReceiptNumber()), 
									cashReceipt.getCompanyId2());
							utx.rollback();
						}
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg2(e.getMessage());
			utx.rollback();
			// state = false;
		}
	
		return billCajaListPostReturns;
	}
	
	
	private CashBillReceiptRelation copyValuesNotReference(CashBillReceiptRelation c2) {

		CashBillReceiptRelation c1 = new CashBillReceiptRelation();
		c1.setAccount(c2.getAccount());
		c1.setAccount2(c2.getAccount2());
		c1.setAccountPart1(c2.getAccountPart1());
		c1.setAmount(c2.getAmount());
		c1.setBillExchange(c2.getBillExchange());
		c1.setBillId(c2.getBillId());
		c1.setBillType(c2.getBillType());
		c1.setCajaId(c2.getCajaId());
		c1.setCalculatedExchange(c2.getCalculatedExchange());
		c1.setCancelAmount(c2.getCancelAmount());
		c1.setCancelCompleteBill(c2.isCancelCompleteBill());
		c1.setCancelCrAmount(c2.getCancelCrAmount());
		c1.setClientType(c2.getClientType());
		c1.setCodCli(c2.getCodCli());
		c1.setCoin(c2.getCoin());
		c1.setCompanyId2(c2.getCompanyId2());
		c1.setCrAmount(c2.getCrAmount());
		c1.setCrBalance(c2.getCrBalance());
		c1.setFee(c2.getFee());
		c1.setJdBranchId(c2.getJdBranchId());
		c1.setJdCompanyId(c2.getJdCompanyId());
		c1.setJdLineId(c2.getJdLineId());
		c1.setReceiptNumber(c2.getReceiptNumber());
		c1.setSequenceNumber(c2.getSequenceNumber());
		c1.setNewCorAmount(c2.getNewCorAmount());
		
		return c1;
	}
	
	
	
	private void updateReceiptRefer(int cashid, int receiptNumber, String refer3) {
		try {
			String sQuery = "UPDATE " + CollectionScheme.SchemeCAJA + ".RECIBODET SET " 
			 + "REFER3 = '" 
			 + refer3 + "' WHERE NUMREC = " 
			 + receiptNumber + " AND CAID = " 
			 + cashid + "" ;
		
			em.createNativeQuery(sQuery).executeUpdate();
	
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
			setErrorMsg2(e.getMessage());
		}
	}

	private int insertReceipt(int idJsonLog, EntityManager em, CashReceipt cajaReceipt) {
		
		try {
			String sQuery = "INSERT INTO " + CollectionScheme.SchemeCAJA + ".RECIBO (" +
				"NUMREC," +
				"MONTOAPL," +
				"MONTOREC," +
				"CONCEPTO," +
				"TIPOREC," +
				"CLIENTE," +
				"CODCLI," +
				"CAJERO," +
				"CODCOMP," +
				"NUMRECM," +
				"RECJDE," +
				"CAID," +
				"CODSUC," +
				"ESTADO," +	
				"MOTIVO," +	
				"CODUSERA," +	
				"CODUSER," +	
				"CODUNINEG," +	
				"MONEDAAPL) " +
				
		"VALUES (" + cajaReceipt.getReceiptNumber() + ", " +
			 		"" + cajaReceipt.getApplyAmount() + ", " +
			 		"" + cajaReceipt.getReceivedAmount() + ", " +
			 		"'" + (cajaReceipt.getConcept().length() > 250 ? (cajaReceipt.getConcept().substring(0, 249)) : cajaReceipt.getConcept()) + "', " +
			 		"'" + cajaReceipt.getTypeReceipt()  +  "', " +
			 		"'" + cajaReceipt.getClientName() + "', " +
			 		"" + cajaReceipt.getCodCli() + ", " +
			 		"'" + cajaReceipt.getSellerName() + "', " +
			 		"'" + cajaReceipt.getJdCompanyId() + "', " +
			 		"" + 0 + ", " +
			 		"" + cajaReceipt.getCashSheetId() + ", " +
			 		"" + cajaReceipt.getCashId() + ", " +
			 		"'" + cajaReceipt.getJdBranchId() + "', " +
			 		"'" + "" + "', " +
			 		"'" + "" + "', " +
			 		"'" + "" + "', " +
			 		"'" + cajaReceipt.getUserId() + "', " +
			 		"'" + FMUUtil.getJdLineNumberSpace(cajaReceipt.getJdLineId()) + cajaReceipt.getJdLineId() + "', " +
			 		"'" + cajaReceipt.getCoin() + "')";
			
			int rows = em.createNativeQuery(sQuery).executeUpdate();
			
			ClsSystemLogs.createQueryLog(idJsonLog, "insertReceipt", sQuery, true, rows);
			
			return rows;
	
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
			setErrorMsg2(e.getMessage());
		}
		
		return 0;
	}
	
	private int insertReceiptDetail(int idJsonLog, EntityManager em, CashReceiptPaymentItem cajaPaymentItem, CashReceipt cajaReceipt) {
			
		try {
			String sQuery = "INSERT INTO " + CollectionScheme.SchemeCAJA + ".RECIBODET (" +
				"NUMREC," +
				"MONTO," +
				"MONEDA," +
				"MPAGO," +
				"TASA," +
				"EQUIV," +
				"REFER1," +
				"REFER2," +
				"REFER3," +
				"REFER4," +
				"CODCOMP," +
				"DEPCTATRAN," +
				"CAID," +
				"CODSUC," +	
				"TIPOREC," +	
				"CAIDPOS," +	
				"CODIGOMARCATARJETA," +
				"MARCATARJETA," +	
				"REFERENCENUMBER," +	
				"LIQUIDARPORMARCA) " +
				
		"VALUES (" +  cajaPaymentItem.getReceiptNumber() + ", " +
			"" + cajaPaymentItem.getAmount() + ", " +
			"'" + cajaPaymentItem.getCoin() + "', " +
			"'" + cajaPaymentItem.getMethod() + "', " +
			"" + cajaPaymentItem.getExchange()  +  ", " +
			"" + cajaPaymentItem.getEquivalent() + ", " +
			"'" + cajaPaymentItem.getRefer1() + "', " +
			"'" + cajaPaymentItem.getRefer2() + "', " +
			"'" + cajaPaymentItem.getRefer3() + "', " +
			"'" + cajaPaymentItem.getRefer4() + "', " +
			"'" + cajaPaymentItem.getCompanyId() + "', " +
			"" + isConciliacion(em, cajaPaymentItem, cajaReceipt) + ", " +
			"" + cajaReceipt.getCashId() + ", " +
			"'" + cajaReceipt.getJdBranchId() + "', " +
			"'" + cajaReceipt.getTypeReceipt() + "', " +
			"" + cajaReceipt.getCashId() + ", " +
			"'" + cajaPaymentItem.getCodeTarget() + "', " +
			"'" + cajaPaymentItem.getBranchTarget() + "', " +
			//"" + ((cajaPaymentItem.getMethod().equals(FMUUtil.DEPOSIT_PAYMENT_METHOD) || cajaPaymentItem.getMethod().equals(FMUUtil.TRANSFER_PAYMENT_METHOD)) ? cajaPaymentItem.getRefer2() : 0) + ", " +
			"" + 0 + "," +
			"'" + 0 + "')";
			
			int rows = em.createNativeQuery(sQuery).executeUpdate();
			
			ClsSystemLogs.createQueryLog(idJsonLog, "insertReceiptDetail", sQuery, true, rows);
			
			return rows;
	
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
			setErrorMsg2(e.getMessage());
		}
		
		return 0;
	}
	
	private int insertReciboFact(int idJsonLog, EntityManager em, CashBillReceiptRelation cajaBillReceiptRelation, CashReceipt cajaReceipt) {
		
		try {
			String sQuery = "INSERT INTO " + CollectionScheme.SchemeCAJA + ".RECIBOFAC (" +
				"NUMREC," +
				"NUMFAC," +
				"CODCOMP," +
				"MONTO," +
				"TIPOFACTURA," +
				"CODSUC," +
				"CAID," +
				"ESTADO," +
				"CODUNINEG," +
				"TIPOREC," +
				"CODCLI," +
				"FECHA," +
				"PARTIDA," +
				"HORA) " +
				
		"VALUES (" + cajaBillReceiptRelation.getReceiptNumber() + ", " +
			 		"" + cajaBillReceiptRelation.getBillId() + ", " +
			 		"'" + cajaBillReceiptRelation.getJdCompanyId() + "', " +
			 		"" + String.valueOf(cajaBillReceiptRelation.getAmount() / 100) + ", " +
			 		"'" + cajaBillReceiptRelation.getBillType()  +  "', " +
			 		"'" + cajaBillReceiptRelation.getJdBranchId() + "', " +
			 		"" + cajaBillReceiptRelation.getCajaId() + ", " +
			 		"'" + "" + "', " +
			 		"'" + FMUUtil.getJdLineNumberSpace(cajaBillReceiptRelation.getJdLineId()) + cajaBillReceiptRelation.getJdLineId() + "', " +
			 		"'" + cajaReceipt.getTypeReceipt() + "', " +
			 		"" + cajaBillReceiptRelation.getCodCli() + ", " +
			 		"" + FMUUtil.dateToJulian(new Date()) + ", " +
			 		"'" + cajaBillReceiptRelation.getFee() + "', " +
			 		"'" + 0 + "')";
			
			int rows = em.createNativeQuery(sQuery).executeUpdate();
			
			ClsSystemLogs.createQueryLog(idJsonLog, "insertReciboFact", sQuery, true, rows);
			
			return rows;
	
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
			setErrorMsg2(e.getMessage());
		}
		
		return 0;
	}
	
	
	private int insertChangeReceipt(int idJsonLog, EntityManager em, CashChangeDetail cajaReceiptChange, CashReceipt cajaReceipt) {
		
		try {
			String sQuery = "INSERT INTO " + CollectionScheme.SchemeCAJA + ".CAMBIODET (" +
				"NUMREC," +
				"MONEDA," +
				"CODCOMP," +
				"CAMBIO," +
				"CODSUC," +
				"CAID," +
				"TASA," +
				"TIPOREC) " +
				
		"VALUES (" + cajaReceiptChange.getReceiptNumber() + ", " +
			 		"'" + cajaReceiptChange.getCoin() + "', " +
			 		"'" + cajaReceiptChange.getJdCompanyId() + "', " +
			 		"" + cajaReceiptChange.getChange() + ", " +
			 		"'" + cajaReceiptChange.getBranchId() + "', " +
			 		"" + cajaReceiptChange.getCashId() + ", " +
			 		"" + cajaReceiptChange.getExchange() + ", " +
			 		"'" + cajaReceiptChange.getType() + "')";
			
			int rows = em.createNativeQuery(sQuery).executeUpdate();
			
			ClsSystemLogs.createQueryLog(idJsonLog, "insertChangeReceipt", sQuery, true, rows);
			
			return rows;
	
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
			setErrorMsg2(e.getMessage());
		}
		
		return 0;
	}
	

	private int updateReceiptSequence(int idJsonLog, EntityManager em, CashReceipt cajaReceipt) throws Exception {
		try {
		
			String update = "C4NNCU = (C4NNCU + 1)";
			
			int receiptServerNumber = getReceiptNumberSequence(idJsonLog, cajaReceipt.getCashId(), cajaReceipt.getJdCompanyId(), em);
			
			if (receiptServerNumber < cajaReceipt.getReceiptNumber()) {
				update = "C4NNCU = " + (cajaReceipt.getReceiptNumber());
			}
					
			String sQuery = "update " + CollectionScheme.SchemeCAJA + " .F55CA014 set  " + update
					+ " where C4RP01 = ? and C4ID = ?";
			
			int rows = em.createNativeQuery(sQuery).
					setParameter(1, cajaReceipt.getJdCompanyId()).
					setParameter(2, cajaReceipt.getCashId()).executeUpdate();
			
			ClsSystemLogs.createQueryLog(idJsonLog, "updateReceiptSequence", sQuery, true, rows, 
					new Object[]{cajaReceipt.getJdCompanyId(), cajaReceipt.getCashId()});
			
			return rows;
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg2(e.getMessage());
			return 0;
		}	
	}
	
	public static int getBatchSequenceNumber(EntityManager em) {
		try {
			return numeroSiguienteJdeE1();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg2(e.getMessage());
			return 0;
		}	
	}
	
	public static int getReciboJdeSequence(int idJsonLog, EntityManager em, String companyId, boolean isCash) {
		List<Object> object = new ArrayList<Object>();

		String sTabla = "";
		String sPosicion = "";
		
		if (companyId.equals("E01")) {
			sTabla = "03";
			sPosicion = "005";
		} else if (companyId.equals("E02")) {
			sTabla = "5555";
			sPosicion = "001";
		} else if (companyId.equals("E08")) {
			sTabla = "5555";
			sPosicion = "003";
		} else if (companyId.equals("E03")) {
			sTabla = "5803";
			sPosicion = "005";
		} else if (companyId.equals("E10")) {
			sTabla = "5655";
			sPosicion = "001";
		}

		if (isCash) {
			sTabla = "09";
			sPosicion = "002";
		}		
		
		try {
			
			String sQuery = "select (nnn" + sPosicion + " + 1)  from " + CollectionScheme.SchemeJDECOM + ".f0002 "
					+ "where nnsy = '" +  sTabla  +"'";	
			
			ClsSystemLogs.createQueryLog(idJsonLog, "getReciboJdeSequence", sQuery, false);
			
			object = em.createNativeQuery(sQuery, Object.class).getResultList();
			
			int number = object.get(0) == null ? 0 : Integer.parseInt(object.get(0).toString());
			
			if (number > 0) {
				String sQueryUpdate = "update " + CollectionScheme.SchemeJDECOM + ".f0002 set nnn" + sPosicion  + " = (nnn" + sPosicion + " + 1) "
					+ "where nnsy = '" +  sTabla  +"'";
				int rows = em.createNativeQuery(sQueryUpdate).executeUpdate();
				
				ClsSystemLogs.createQueryLog(idJsonLog, "getReciboJdeSequence", sQueryUpdate, true, rows);
				
			}
		
			return number;	
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg2(e.getMessage());
			return 0;
		}	
	}
	
	
	public static int insertReciboJDERelation(int idJsonLog, EntityManager em, CashReceipt cajaReceipt, int batchNumber, int receiptNumber, String type) {
		
		try {
			String sQuery = "INSERT INTO " + CollectionScheme.SchemeCAJA + ".RECIBOJDE (" +
				"NUMREC," +
				"CODCOMP," +
				"RECJDE," +
				"NOBATCH," +
				"CAID," +
				"CODSUC," +
				"TIPODOC," +
				"TIPOREC) " +
				
		"VALUES (" + cajaReceipt.getReceiptNumber() + ", " +
			 		"'" + cajaReceipt.getJdCompanyId() + "', " +
			 		"" + receiptNumber + ", " +
			 		"" + batchNumber + ", " +
			 		"" + cajaReceipt.getCashId() + ", " +
			 		"'" + cajaReceipt.getJdBranchId() + "', " +
			 		"'" + (cajaReceipt.getTypeReceipt().equals(FMUUtil.CASH_LETTER) ? "A" : "R") +  "', " +
			 		"'" + type + "')";
			
			int rows = em.createNativeQuery(sQuery).executeUpdate();
			
			ClsSystemLogs.createQueryLog(idJsonLog, "checkIfReceiptExits", sQuery, true, rows);
			
			return rows;
	
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
			setErrorMsg2(e.getMessage());
			return 0;
		}		
	}
	
	
	private int isConciliacion(EntityManager em, CashReceiptPaymentItem cajaReceiptItem, CashReceipt cajaReceipt) {

		if (!cajaReceiptItem.getMethod().equals(FMUUtil.DEPOSIT_PAYMENT_METHOD)) {
			return 0;
		}
		
		List<Object> object = new ArrayList<Object>();;
		List<Object> objectBank = new ArrayList<Object>();;

		try {

			String sQuery = "select confrmauto from " + CollectionScheme.SchemeCAJA + ".f55ca014 where c4id = ? and c4rp01 = ?";
			object = em.createNativeQuery(sQuery, Object.class).setParameter(1, cajaReceipt.getCashId()).setParameter(2, cajaReceipt.getJdCompanyId()).getResultList();
			
			if (object.size() > 0) {
				int number = object.get(0) == null ? 0 : Integer.parseInt(object.get(0).toString());
			
				String sQueryBanks = "select conciliar from " + CollectionScheme.SchemeCAJA + ".f55ca022 where codb = ?";
				objectBank = em.createNativeQuery(sQueryBanks, Object.class).setParameter(1, cajaReceiptItem.getRefer1()).getResultList();
			
				if (objectBank.size() > 0) {
					int numberBank = objectBank.get(0) == null ? 0 : Integer.parseInt(objectBank.get(0).toString());
					
					return (number == 1 && numberBank == 1) ? 1 : 0;
					
				} else {
					return 0;
				}
				
			} else {
				return 0;
			}
			
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg2(e.getMessage());
			return 0;
		}	
	}
	
	private void createFichaCambio(int idJsonLog, EntityManager em, CashReceiptPaymentItem cashSheetReceiptPaymentItem, CashReceipt cashSheetReceipt) throws Exception {
		if (insertReceipt(idJsonLog, em, cashSheetReceipt) > 0) {
			if (insertReceiptDetail(idJsonLog, em, cashSheetReceiptPaymentItem, cashSheetReceipt) > 0) {
				updateFichaReceiptSequence(em, cashSheetReceipt);

				int batchNumber = getBatchSequenceNumber(em);
				int numberReceiptJDE = getReciboJdeSequence(idJsonLog, em, cashSheetReceipt.getJdCompanyId(), true);
												
				if (insertReciboJDERelation(idJsonLog, em, cashSheetReceipt, batchNumber, numberReceiptJDE, cashSheetReceipt.getTypeReceipt()) > 0) {		
					if (ClsAccountingManager.createBatchHeader(idJsonLog, em, FMUUtil.ICICUT, batchNumber, cashSheetReceipt.getUserId(), FMUUtil.dateToJulian(new Date()),
							/*(int)*/ (cashSheetReceipt.getApplyAmount() * 100),
								1, cashSheetReceipt.getSoftwareId(), false) > 0) {
							ClsAccountingManager.createBatchDetailsheet(em, batchNumber, cashSheetReceipt, numberReceiptJDE, cashSheetReceiptPaymentItem);
						}
					}
				}	
			}	
	}
	
	/**
	 * Update sheet sequence
	 * @param em
	 * @param cajaReceipt
	 * @return
	 * @throws Exception
	 */
	private int updateFichaReceiptSequence(EntityManager em, CashReceipt cajaReceipt) throws Exception {
		try {
			String sQuery = "update " + CollectionScheme.SchemeCAJA + ".NUMCAJA "
					+ "set nosiguiente = (nosiguiente + 1) "
					+ "WHERE  CAID = ? "
					+ "and codcomp = ? "
					+ "and codnumeracion='FICHACV' ";
			return em.createNativeQuery(sQuery).
					setParameter(1, cajaReceipt.getCashId()).
					setParameter(2, cajaReceipt.getJdCompanyId()).executeUpdate();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg2(getErrorMsg2());
			return 0;
		}	
	}

	public static String getErrorMsg2() {
		return errorMsg2;
	}


	public static void setErrorMsg2(String errorMsg2) {
		if (ClsCashManager.errorMsg2.equals("")) {
			ClsCashManager.errorMsg2 = errorMsg2;
		}
	}
	
	public PostObjectReturn cancelReceipt(int jdeReceiptNumber, int batchNumber, int receiptNumber, int cashNumber,
			String companyId, int sheetId, String receiptType, List<CashBillReceiptRelation> cashBillReceiptRelations,
			UserTransaction utx, List<CashReceiptPaymentItem> cashReceiptPaymentItems, boolean isItechPay, 
			CashReceipt cashReceipt) {

		List<Object> object = new ArrayList<Object>();

		PostObjectReturn postObjectReturn = new PostObjectReturn();

		try {

			postObjectReturn.setBillId(String.valueOf(receiptNumber));
			postObjectReturn.setBatchNumber(batchNumber);
			postObjectReturn.setJdeNumber(jdeReceiptNumber);
			postObjectReturn.setErrorMsg("");
			postObjectReturn.setCompanyId(companyId);
			postObjectReturn.setUseCustomErrorMsg(false);

			postObjectReturn.setMovementType("CANCEL_RECEIPT");

			utx.begin();

			em.createNativeQuery("UPDATE " + CollectionScheme.SchemeCAJA + ".RECIBO set ESTADO = 'A' WHERE NUMREC = ? "
					+ " AND CAID = ?  AND CODCOMP = ?").setParameter(1, receiptNumber).

					setParameter(2, cashNumber).setParameter(3, companyId).executeUpdate();

			em.createNativeQuery("UPDATE " + CollectionScheme.SchemeCAJA
					+ ".RECIBOFAC set ESTADO = 'A' WHERE NUMREC = ? " + " AND CAID = ? AND CODCOMP =  ?")
					.setParameter(1, receiptNumber).setParameter(2, cashNumber).setParameter(3, companyId)
					.executeUpdate();

			if (sheetId > 0) {

				int resultSheetRecipt = em
						.createNativeQuery("UPDATE " + CollectionScheme.SchemeCAJA
								+ ".RECIBO set ESTADO = 'A' WHERE NUMREC = ? " + " AND CAID = ?  AND CODCOMP = ?")
						.setParameter(1, sheetId).setParameter(2, cashNumber).setParameter(3, companyId)
						.executeUpdate();

				if (resultSheetRecipt > 0) {
					String sQueryBatchSheet = "SELECT NOBATCH FROM  " + CollectionScheme.SchemeCAJA
							+ ".RECIBOJDE WHERE NUMREC = ? " + "AND CODCOMP = ? AND CAID = ? AND TIPOREC = ?";

					object = em.createNativeQuery(sQueryBatchSheet, Object.class).setParameter(1, sheetId).
							setParameter(2, companyId).
							setParameter(3, cashNumber)
							.setParameter(4, "FCV")
							.getResultList();

					int batchNumberResult = object.get(0) == null ? 0 : Integer.parseInt(object.get(0).toString());

					if (batchNumberResult > 0) {
						String sDeleteSheetBatch = "DELETE FROM " + CollectionScheme.SchemeJDE + ".F0011 WHERE ICICU = "
								+ batchNumberResult;
						int resultSheet = em.createNativeQuery(sDeleteSheetBatch).executeUpdate();

						if (resultSheet > 0) {
							String sDeleteSheetBatchDetail = "DELETE FROM " + CollectionScheme.SchemeJDE
									+ ".F0911 WHERE GLICU = ? ";
							em.createNativeQuery(sDeleteSheetBatchDetail).setParameter(1, batchNumberResult);
						}
					}
				}
			}

			if (receiptType.equals(FMUUtil.CREDIT_LETTER_CASH)) {
				
				for (CashBillReceiptRelation cashBillReceiptRelation : cashBillReceiptRelations) {
					
					String crSql = "RPAAP = " + (cashBillReceiptRelation.getCancelCrAmount()) + ""; 
					float total = cashBillReceiptRelation.getCancelAmount();
										
					String sQuery = "UPDATE " + CollectionScheme.SchemeJDE  + ".F03B11 set RPFAP = " + total + ", " + crSql + "  "
							+ ", RPPST = 'A' "
							+ "where RPDOC = ? and RPAN8 = ?  AND TRIM(RPSFX) = '" + cashBillReceiptRelation.getFee()  +"' "
							+ " AND RPKCO = '" + cashBillReceiptRelation.getJdBranchId() + "'";

					em.createNativeQuery(sQuery).setParameter(1, cashBillReceiptRelation.getBillId()).
					setParameter(2, cashBillReceiptRelation.getCodCli()).executeUpdate();
				}
				
				// Delete batch header
				em.createNativeQuery(
						"DELETE FROM " + CollectionScheme.SchemeJDE + ".F0011 WHERE ICICU = " + batchNumber)
						.executeUpdate();
						
				// Delete receipt F03B13 - F03B14
				String deleteReceiptHeader = "DELETE FROM " + CollectionScheme.SchemeJDE + ".F03B13 WHERE RYICU = ? ";
				int rowDeleted = em.createNativeQuery(deleteReceiptHeader).setParameter(1, batchNumber).executeUpdate();
				
				
				if (rowDeleted <=0) {
					
					// Try deleting with receiptNumber 
					String deleteReceiptNumber = "DELETE FROM " + CollectionScheme.SchemeJDE + ".F03B13 WHERE RYCKNU = ? AND "
							+ " RYAN8 = ? AND RYDGJ = ?";
					
					em.createNativeQuery(deleteReceiptNumber).
					setParameter(1, receiptNumber).
					setParameter(2, cashReceipt.getCodCli()).
					setParameter(3, FMUUtil.dateToJulian(new Date())).
					executeUpdate();
				}

				String deleteReceiptDetail = "DELETE FROM " + CollectionScheme.SchemeJDE + ".F03B14 WHERE RZICU = ? ";
				int rowDeleted3b14 = em.createNativeQuery(deleteReceiptDetail).setParameter(1, batchNumber).executeUpdate();
				
				
				if (rowDeleted3b14 <=0) {
					
					String deleteReceiptDetailF0b14 = "DELETE FROM " + CollectionScheme.SchemeJDE + ".F03B14 WHERE "
							+ " RZCKNU = ? AND RZAN8 = ? AND RZDGJ = ? ";
					
					em.createNativeQuery(deleteReceiptDetailF0b14).
					setParameter(1, receiptNumber).
					setParameter(2, cashReceipt.getCodCli()).
					setParameter(3, FMUUtil.dateToJulian(new Date())).
					executeUpdate();
				}
				
				
				// Sobrante
				String sQuery = "SELECT NOBATCH FROM  " + CollectionScheme.SchemeCAJA + ".RECIBOJDE WHERE  NUMREC = ? "
						+ " AND CAID = ? AND TIPOREC = 'SBR' AND CODCOMP = ?";

				object = em.createNativeQuery(sQuery, Object.class).setParameter(1, receiptNumber)
						.setParameter(2, cashNumber).setParameter(3, companyId).getResultList();

				int batchNumberResult = 0;

				if (object.size() > 0) {
					batchNumberResult = object.get(0) == null ? 0 : Integer.parseInt(object.get(0).toString());
				}

				if (batchNumberResult > 0) {
					String sDeleteBatch = "DELETE FROM " + CollectionScheme.SchemeJDE + ".F0011 WHERE ICICU = "
							+ batchNumberResult;
					int result = em.createNativeQuery(sDeleteBatch).executeUpdate();

					if (result > 0) {
						String sDeleteBatchDetail = "DELETE FROM " + CollectionScheme.SchemeJDE
								+ ".F0911 WHERE GLICU = ? ";
						em.createNativeQuery(sDeleteBatchDetail).setParameter(1, batchNumberResult).executeUpdate();
					}
				}

			} else {
				// if batch is not approved
				String sQuery = "SELECT ICIST FROM  " + CollectionScheme.SchemeJDE + ".F0011 WHERE ICICU = "
						+ batchNumber;
				object = em.createNativeQuery(sQuery, Object.class).getResultList();

				if (object.size() > 0) {
					String state = object.get(0) == null ? "" : object.get(0).toString();

					if (state.equals("D")) {
						postObjectReturn
								.setErrorMsg("Este recibo ya fue procesado contablemente y no puede ser anulado");

					} else {
						// delete batch
						String sDeleteBatch = "DELETE FROM " + CollectionScheme.SchemeJDE + ".F0011 WHERE ICICU = "
								+ batchNumber;
						int result = em.createNativeQuery(sDeleteBatch).executeUpdate();

						if (result > 0) {
							String sDeleteBatchDetail = "DELETE FROM " + CollectionScheme.SchemeJDE
									+ ".F0911 WHERE GLICU = ? " + " AND GLDOC = ?";
							em.createNativeQuery(sDeleteBatchDetail).setParameter(1, batchNumber)
									.setParameter(2, jdeReceiptNumber).executeUpdate();
						}
					}

				} else {
					postObjectReturn.setErrorMsg("No se encontro el numero de batch : " + batchNumber);
				}
			}
			
			if (postObjectReturn.getErrorMsg().equals("")) {
				
				if (isItechPay) {

					for (CashReceiptPaymentItem cajaPaymentItem : cashReceiptPaymentItems) {

						if (cajaPaymentItem.getMethod().equals(FMUUtil.CREDIT_CARD_PAYMENT_METHOD)
								&& !cajaPaymentItem.getCardNumber().equals("")
								&& !cajaPaymentItem.getEndDate().equals("")) {

							System.out.println("Tarjeta : " + cajaPaymentItem.getCardNumber());
							System.out.println("Numero Transaction : " + cajaPaymentItem.getEndDate());
							System.out.println("Codigo Seguridad : " + cajaPaymentItem.getTransactionId());
							System.out.println("Monto : " + "1.00");
							System.out.println("Numero Terminal : " + cajaPaymentItem.getRefer5());
							System.out.println("Usuario : " + cashReceipt.getUserId());
							System.out.println("SoftwareId : " + cashReceipt.getSoftwareId());
							System.out.println("SoftwareId : " + cashReceipt.getSoftwareId());
							System.out.println("DeviceId : " + cashReceipt.getDeviceId());
							
							RestResponse result = setAnularPagos(
									cajaPaymentItem.getCardNumber(),
									cajaPaymentItem.getTransactionId(), 
									format.format(cajaPaymentItem.getAmount()),
									//"1.00",
									cajaPaymentItem.getRefer5(), 
									cashReceipt.getUserId(),
									cashReceipt.getSoftwareId(), 
									cashReceipt.getSoftwareId(),
									cashReceipt.getDeviceId());

							String data = result.getDataAsString();

							if (!data.equals("")) {
								Gson gson = new Gson();
								CardResponse responseData = gson.fromJson(data, CardResponse.class);
																
								if (!responseData.getCodigoRespuesta().equals("1")) {
									postObjectReturn.setErrorMsg(responseData.getDescripcionRespuesta());
									postObjectReturn.setUseCustomErrorMsg(false);
								}
								
							} else {
								postObjectReturn.setErrorMsg("Hubo un error al procesar la anulacion en su tarjeta");
								postObjectReturn.setUseCustomErrorMsg(false);
							}
						}
					}
					
					if (postObjectReturn.getErrorMsg().equals("")) {
						utx.commit();
					}	else {
						clsLogs.insertErrorLogDetail(cashReceipt.getCellarId(), FMUUtil.getSubsString(postObjectReturn.getErrorMsg()), 
								cashReceipt.getUserId(), cashReceipt.getJdBranchId(), FMUUtil.RECEIPT_CODE, String.valueOf(cashReceipt.getReceiptNumber()),
								cashReceipt.getJdCompanyId());
						utx.rollback();
					}
					
				} else {
					utx.commit();
				}
				
			} else {
				utx.rollback();
			}

		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			postObjectReturn.setErrorMsg(e.getMessage());
			try {
				utx.rollback();
			} catch (IllegalStateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return postObjectReturn;
	}
	
	public static int getReceiptNumberSequence(int idJsonLog, int cashId, String companyId, EntityManager em) {
		try {
			
			List<Object> object = new ArrayList<Object>();

			String query = "SELECT  c4nncu  FROM " + CollectionScheme.SchemeCAJA + ".F55CA014 where c4id=" + cashId + " and c4rp01='" + companyId + "'";

			ClsSystemLogs.createQueryLog(idJsonLog, "getReceiptNumberSequence", query, false);
			
			object = em.createNativeQuery(query)
					.getResultList();
			
			int receiptNumber = 0;
			
			if (object.size() > 0) {
				receiptNumber = (object.get(0) == null ? 0 : Integer.parseInt(object.get(0).toString()));
			}
			
			return receiptNumber;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg2(getErrorMsg2());
			return 0;
		}	
	}
	
	
	public static int getReceiptNumber(int billId,  int cashId, String companyId, int clientId, EntityManager em) {
		try {
			
			List<Object> object = new ArrayList<Object>();

			String query = "Select  NUMREC  from " + CollectionScheme.SchemeCAJA
					+ ".RECIBOFAC  where  "
					+ "numfac = ? AND "
					+ "estado ='' and "
					+ "CODCOMP = ? "
					+ "and caid = ? "
						+ "fetch first 1 rows only ";

			object = em.createNativeQuery(query).
			setParameter(1, billId).
			setParameter(2, companyId).
			setParameter(3, cashId).

			getResultList();
			
			int receiptNumber = 0;
			
			if (object.size() > 0) {
				receiptNumber = (object.get(0) == null ? 0 : Integer.parseInt(object.get(0).toString()));
			}
			
			return receiptNumber;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg2(getErrorMsg2());
			return 0;
		}	
	}
	
	public int cajaBillExists(BillHeader billHeader, EntityManager em) {
		try {
			BillPost billPost = billHeader.getBillPosts().get(0);
		 	String sQuery = "SELECT NOFACTURA from " + CollectionScheme.SchemeCAJA + ".A02FACTCO  "
		 			+ "where NOFACTURA = ? "
		 			+ "and CODCLI = ? "
		 			+ "and FECHA = ? "
		 			+ "and CODCOMP = ?";
		 	
		 	return em.createNativeQuery(sQuery).
		 			setParameter(1, billPost.getBillId()).
		 			setParameter(2, billPost.getClientId()).
		 			setParameter(3, FMUUtil.dateToJulian(new Date())).
		 			setParameter(4, billPost.getJdCompanyId()).getResultList().size();

		} catch (Exception e) {
				// TODO: handle exception
				ClsBillManager.setErrorMsg(e.getMessage());
				e.printStackTrace();
				return 0;
		}	
	}
	
	/****************************************************************************************************************
	 * Metodo que se encarga de verificar si el recibo ya ha sido generado con ese numero
	 * 
	 * <ul>
	 * <li>Modificado por  : Francisco Landeros
	 * <li>Mofificado el   : 31/07/2018
	 * <li>Cambio realizado: Modificacion de consulta, Se agrego validacion de codigo de compania en las dos tablas
	 * 					 y se agrego el parametro de la compania
	 * </ul>
	 * --------------------------------------------------------------------------------------------------------------
	 * @param receiptNumber Numero de recibo
	 * @param cashId Numero de caja
	 * @param userId Codigo de usuario
	 * @param codComp Codigo de compania jde
	 * @return
	 */
	private PostObjectReturn checkIfReceiptExits(int idJsonLog, int receiptNumber, int cashId, String userId, 	String codComp) {
		
		List<PostObjectReturn> postObjectReturn = new ArrayList<PostObjectReturn>();

		try {
			
			String sQuery = "select a.numrec clientId, b.recjde jdeNumber, b.nobatch batchNumber  "
					+ "FROM " + CollectionScheme.SchemeCAJA + ".RECIBO a "
							+ "left outer join " + CollectionScheme.SchemeCAJA  + ".RECIBOJDE b "
									+ "on (a.NUMREC = b.NUMREC AND a.CAID = b.CAID AND a.CODCOMP = b.CODCOMP) where a.NUMREC = ? and a.CAID = ?"
									+ " AND a.CODUSER = ? AND a.CODCOMP = ?  FOR READ ONLY";
			
			String sParamsMethod = "{ parmsMethod : { Rc:" + receiptNumber + ", Cj: " + cashId + ", Uid:" + userId + ",Cmp:" + codComp + " } }";
			ClsSystemLogs.createQueryLog(idJsonLog, "checkIfReceiptExits", sQuery + sParamsMethod, false, 0, 
					 new Object[] {receiptNumber, cashId, userId, codComp});
			
			postObjectReturn = em.createNativeQuery(sQuery, PostObjectReturn.class).
					setParameter(1, receiptNumber)
					.setParameter(2, cashId)
					.setParameter(3, userId)
					.setParameter(4, codComp)
					.getResultList();
		
		if (postObjectReturn.isEmpty()) {
			return null;
		}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg2(e.getMessage());
		}
		
		return postObjectReturn.get(0);
	}
	
	public static RestResponse setAplicarPagos(String strNumeroTarjeta, String strFechaVencimiento,
			String strCodigoSeguridad, String strOrderId, String strMonto, String strNoCaja, String strNoRecibo,
			String strTerminalId, String strUsuario, String strPantalla, String strPrograma, String strDispositivo)
			throws IOException {
		
		Gson gson = new Gson();

		Parameter pNumeroTarjeta = new Parameter();
		pNumeroTarjeta.addValue(strNumeroTarjeta);
		String strONumeroTarjeta = pNumeroTarjeta != null ? gson.toJson(pNumeroTarjeta) : "";

		Parameter pFechaVencimiento = new Parameter();
		pFechaVencimiento.addValue(strFechaVencimiento);
		String strOFechaVencimiento = pFechaVencimiento != null ? gson.toJson(pFechaVencimiento) : "";

		Parameter pCodigoSeguridad = new Parameter();
		pCodigoSeguridad.addValue(strCodigoSeguridad);
		String strOCodigoSeguridad = pCodigoSeguridad != null ? gson.toJson(pCodigoSeguridad) : "";

		Parameter pOrderId = new Parameter();
		pOrderId.addValue(strOrderId);
		String strOOrderId = pOrderId != null ? gson.toJson(pOrderId) : "";

		Parameter pMonto = new Parameter();
		pMonto.addValue(strMonto);
		String strOMonto = pMonto != null ? gson.toJson(pMonto) : "";

		Parameter pNoCaja = new Parameter();
		pNoCaja.addValue(strNoCaja);
		String strONoCaja = pNoCaja != null ? gson.toJson(pNoCaja) : "";

		Parameter pNoRecibo = new Parameter();
		pNoRecibo.addValue(strNoRecibo);
		String strONoRecibo = pNoRecibo != null ? gson.toJson(pNoRecibo) : "";

		Parameter pTerminalId = new Parameter();
		pTerminalId.addValue(strTerminalId);
		String strOTerminalId = pTerminalId != null ? gson.toJson(pTerminalId) : "";

		Parameter pUsuario = new Parameter();
		pUsuario.addValue(strUsuario);
		String strOUsuario = pUsuario != null ? gson.toJson(pUsuario) : "";

		Parameter pPantalla = new Parameter();
		pPantalla.addValue(strPantalla);
		String strOPantalla = pPantalla != null ? gson.toJson(pPantalla) : "";

		Parameter pPrograma = new Parameter();
		pPrograma.addValue(strPrograma);
		String strOPrograma = pPrograma != null ? gson.toJson(pPrograma) : "";

		Parameter pDispositivo = new Parameter();
		pDispositivo.addValue(strDispositivo);
		String strODispositivo = pDispositivo != null ? gson.toJson(pDispositivo) : "";

		String[][] queryHeaders = new String[][] {
				{ "NumeroTarjeta", strONumeroTarjeta != null ? strONumeroTarjeta : "" },
				{ "FechaVencimiento", strOFechaVencimiento != null ? strOFechaVencimiento : "" },
				{ "CodigoSeguridad", strCodigoSeguridad != null ? strOCodigoSeguridad : "" },
				{ "OrderId", strOOrderId != null ? strOOrderId : "" }, { "Monto", strOMonto != null ? strOMonto : "" },
				{ "NoCaja", strONoCaja != null ? strONoCaja : "" },
				{ "NoRecibo", strONoRecibo != null ? strONoRecibo : "" },
				{ "TerminalId", strOTerminalId != null ? strOTerminalId : "" },
				{ "Usuario", strOUsuario != null ? strOUsuario : "" },
				{ "Pantalla", strOPantalla != null ? strOPantalla : "" },
				{ "Programa", strOPrograma != null ? strOPrograma : "" },
				{ "Dispositivo", strODispositivo != null ? strODispositivo : "" } };

		String str = CollectionScheme.SERVER
				+ CollectionScheme.CONTEXT_NAME_WS_Servicios + "/" + CollectionScheme.CONTEXT_NAME_Servicios
				+ "/EcommercesRest/setAplicarPagos";
		
		System.out.println(str);		
		
		RestConnection conn = new RestConnection(apiKey, str);
		RestResponse response = conn.post(queryHeaders, RestConnection.CONTENT_TYPE_JSON);
		conn.closeConection();
		return response;
	}
	
	 /**
     * @author Luis Fonseca
     * @param strNumeroTarjeta
     * @param strTransactionId
     * @param strMonto
     * @param strTerminalId
     * @param strUsuario
     * @param strPantalla
     * @param strPrograma
     * @param strDispositivo
     * @return
     * @throws IOException
     */
    public static RestResponse setAnularPagos(String strNumeroTarjeta,
							         			String strTransactionId,
							         			String strMonto,
							         			String strTerminalId,
							         			String strUsuario,
							         			String strPantalla,
							         			String strPrograma,
							         			String strDispositivo 
    ) throws IOException
    {
    	Gson gson = new Gson();
    	
    	

    	Parameter pNumeroTarjeta = new Parameter();
    	pNumeroTarjeta.addValue(strNumeroTarjeta);
    	String strONumeroTarjeta = pNumeroTarjeta != null ? gson.toJson(pNumeroTarjeta) : "";

    	Parameter pTransactionId = new Parameter();
    	pTransactionId.addValue(strTransactionId);
    	String strOTransactionId = pTransactionId != null ? gson.toJson(pTransactionId) : "";

    	Parameter pMonto = new Parameter();
    	pMonto.addValue(strMonto);
    	String strOMonto = pMonto != null ? gson.toJson(pMonto) : "";

    	Parameter pTerminalId = new Parameter();
    	pTerminalId.addValue(strTerminalId);
    	String strOTerminalId = pTerminalId != null ? gson.toJson(pTerminalId) : "";

    	Parameter pUsuario = new Parameter();
    	pUsuario.addValue(strUsuario);
    	String strOUsuario = pUsuario != null ? gson.toJson(pUsuario) : "";

    	Parameter pPantalla = new Parameter();
    	pPantalla.addValue(strPantalla);
    	String strOPantalla = pPantalla != null ? gson.toJson(pPantalla) : "";

    	Parameter pPrograma = new Parameter();
    	pPrograma.addValue(strPrograma);
    	String strOPrograma = pPrograma != null ? gson.toJson(pPrograma) : "";

    	Parameter pDispositivo = new Parameter();
    	pDispositivo.addValue(strDispositivo);
    	String strODispositivo = pDispositivo != null ? gson.toJson(pDispositivo) : "";
 
   
    	String[][] queryHeaders = new String[][] {
    			{ "NumeroTarjeta", strONumeroTarjeta != null ? strONumeroTarjeta : "" },
    			{ "TransactionId", strOTransactionId != null ? strOTransactionId : "" },
    			{ "Monto", strOMonto != null ? strOMonto : "" },
    			{ "TerminalId", strOTerminalId != null ? strOTerminalId : "" },
    			{ "Usuario", strOUsuario != null ? strOUsuario : "" },
    			{ "Pantalla", strOPantalla != null ? strOPantalla : "" },
    			{ "Programa", strOPrograma != null ? strOPrograma : "" },
    			{ "Dispositivo", strODispositivo != null ? strODispositivo : "" } 
    			};
    			
    	String str = CollectionScheme.SERVER
    			+ CollectionScheme.CONTEXT_NAME_WS_Servicios + "/" + CollectionScheme.CONTEXT_NAME_Servicios
    			+ "/EcommercesRest/setAnularPagos";
    	
    	System.out.println(str);
    	
    	RestConnection conn = new RestConnection(apiKey, str);
    	RestResponse response = conn.post(queryHeaders, RestConnection.CONTENT_TYPE_JSON);
        conn.closeConection();
        return response;
    }
    
   
    public static Connection getConnectionForBatchNumber(){
    	Connection cn = null;
        try {
        	
            Class.forName( "com.ibm.as400.access.AS400JDBCDriver" );
           
            String URLSERVER = "jdbc:as400://@SERVERIP; libraries = @INV, @JDECOM; prompt=false "; URLSERVER = "jdbc:as400://192.168.1.3; libraries = INV, CRPCTL; prompt=false ";
    		URLSERVER = URLSERVER
    				.replace("@SERVERIP", CollectionScheme.ipServer)
    				.replace("@JDECOM", CollectionScheme.SchemeJDECOM)
    				.replace("@INV", CollectionScheme.INV) ;
    		
			cn =  DriverManager.getConnection(URLSERVER,  CollectionScheme.Usuario, CollectionScheme.Contrasenia);
            
        }catch(Exception e){
        	cn = null;
        	e.printStackTrace();
        }
        return cn;
    }

	public static int numeroSiguienteJdeE1() {
		int numeroSiguiente = 0;

		try {

			int delay = Integer.parseInt(new Random().nextInt(3) + "" + new Random().nextInt(1000));
			Thread.currentThread();
			Thread.sleep(delay);

			Connection cn = getConnectionForBatchNumber();

			CallableStatement callableStatement = cn.prepareCall("{CALL GETBATCHNUMBERFROMF0002( ? )}");
			callableStatement.registerOutParameter(1, java.sql.Types.DECIMAL);
			callableStatement.execute();
			Object out2 = callableStatement.getObject(1);

			String sResultado = out2.toString();

			try {
				numeroSiguiente = Integer.parseInt(sResultado.trim());
			} catch (Exception e) {
				e.printStackTrace();
				numeroSiguiente = 0;
			}

			cn.close();

		} catch (Exception e) {
			e.printStackTrace();
			numeroSiguiente = 0;
		}

		return numeroSiguiente;
	}
}
