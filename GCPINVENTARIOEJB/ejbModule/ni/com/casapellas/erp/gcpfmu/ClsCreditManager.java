package ni.com.casapellas.erp.gcpfmu;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;


import ni.com.casapellas.gcpfmu.pojo.AccountCash;
import ni.com.casapellas.gcpfmu.pojo.BillPost;
import ni.com.casapellas.gcpfmu.pojo.CashBillReceiptRelation;
import ni.com.casapellas.gcpfmu.pojo.CashChangeDetail;
import ni.com.casapellas.gcpfmu.pojo.CashReceipt;
import ni.com.casapellas.gcpfmu.pojo.CashReceiptPaymentItem;
import ni.com.casapellas.gcpfmu.pojo.ClientCreditInfo;
import ni.com.casapellas.gcpfmu.pojo.ClientCreditType;
import ni.com.casapellas.gcpfmu.pojo.ExchangeRate;
import ni.com.casapellas.gcpfmu.pojo.F03b14FieldUtil;
import ni.com.casapellas.gcpfmu.pojo.FMUUtil;
import ni.com.casapellas.gcpfmu.pojo.GlobalProductCatalog;
import ni.com.casapellas.gcpfmu.pojo.PostObjectReturn;
import ni.com.casapellas.util.CollectionScheme;

/**
 * Clase encargada de crear las inserciones correspondientes para facturas de
 * credito
 * 
 * @author Jonathan Chavarria
 *
 *         **********************************************************************
 *         <p>
 *         Modificado por : Franciso Landeros Fecha modificacion : 27/07/2018
 *         Metodos : getF03B11HeaderInsert, createF03B11ValuesArray Detalle
 *         modificacion : Organizacion de campos y posicion de valores segun la
 *         definicion de tablas, campos con valores por defecto.
 *         **********************************************************************
 *         <p>
 *         Modificado por : Franciso Landeros Fecha modificacion : 03/08/2018
 *         Metodos : getF03B11HeaderInsert, createF03B11ValuesArray,
 *         getHeaderF03B13Insert, createF03B13ValuesArray,
 *         getHeaderF03B14Insert, createF03B14ValuesArray Detalle modificacion :
 *         Organizacion de campos y posicion de valores segun la definicion de
 *         tablas, campos con valores por defecto.
 *         **********************************************************************
 */

@Singleton
public class ClsCreditManager {

	private static final String GLICUT = "IB";
	private static final String RPDCTM = "RC";
	public static final String RPDCTM_DIFF_EXCHANGE = "RG";
	public static final String RPYICUT = "RB";

	@Inject
	public ClsCreditManager() {

	}

	public void createCreditBillRow(int idJsonLog, EntityManager em, int feedAmount, int dayLimits, int cashId,
			List<ClientCreditInfo> creditInfos, String userId, String softwareId, BillPost boBillPost,
			int batchNumber) {

		String queryValues = "";

		ClientCreditInfo clientCreditInfoItem = creditInfos.get(0);

		ClientCreditType clientType = isClientEmployee(em, clientCreditInfoItem.getBranchId(),
				clientCreditInfoItem.getClientId());

		AccountCash accountCash = ClsAccountingManager.getSurplusAccount(em, creditInfos.get(0).getAccountPart1(),
				creditInfos.get(0).getAccountPart2(), creditInfos.get(0).getAccountPart3());

		float subtotal = boBillPost.getSubtotal();
		float subtotalCr = boBillPost.getSubtotalCR();
		
		if (feedAmount == 0 && !boBillPost.getConditionType().equals(FMUUtil.DEV_CREDIT_LETTER)) {

			queryValues += "\n";
			queryValues += createF03B11ValuesArray(clientCreditInfoItem.getBranchId(),
					clientCreditInfoItem.getDocumentType(), clientCreditInfoItem.getBillId(),
					clientCreditInfoItem.getClientId(), clientCreditInfoItem.getLineId(), userId, softwareId,
					clientCreditInfoItem.getClientName(), clientCreditInfoItem.getCoin(), boBillPost.getExchange(),
					clientCreditInfoItem.getFee(), batchNumber, (boBillPost.getTotalCR()), (boBillPost.getTotalCR()),
					(boBillPost.getSubtotalCR()), (boBillPost.getTotalIvaCR()),
					(clientCreditInfoItem.getCoin().equals("USD") ? boBillPost.getTotal() : 0),
					(clientCreditInfoItem.getCoin().equals("USD") ? boBillPost.getTotal() : 0),
					(clientCreditInfoItem.getCoin().equals("USD") ? boBillPost.getSubtotal() : 0),
					(clientCreditInfoItem.getCoin().equals("USD") ? boBillPost.getTotalIva() : 0),
					FMUUtil.dateToJulian(clientCreditInfoItem.getPaymentDay()), clientType);

			queryValues += ",\n";

		} else {

			subtotal = 0;
			subtotalCr = 0;
			
			for (ClientCreditInfo clientCreditInfo : creditInfos) {

				queryValues += "\n";
				queryValues += createF03B11ValuesArray(clientCreditInfo.getBranchId(),
						clientCreditInfo.getDocumentType(), clientCreditInfo.getBillId(),
						clientCreditInfo.getClientId(), clientCreditInfo.getLineId(), userId, softwareId,
						clientCreditInfo.getClientName(), clientCreditInfo.getCoin(), clientCreditInfo.getExchange(),
						clientCreditInfo.getFee(), batchNumber, (clientCreditInfo.getImporteBrutoCR()),
						(clientCreditInfo.getCorBalance()), (clientCreditInfo.getCorImporteNotIva()),
						(clientCreditInfo.getCorIva()), (clientCreditInfo.getImporteBrutoDR()),
						(clientCreditInfo.getDrBalance()), (clientCreditInfo.getDrImporteNotIva()),
						(clientCreditInfo.getDrIva()), FMUUtil.dateToJulian(clientCreditInfo.getPaymentDay()),
						clientType);

				queryValues += ",\n";
				
				subtotal+=clientCreditInfo.getDrImporteNotIva();
				subtotalCr+=clientCreditInfo.getCorImporteNotIva();

			}
		}

		if (!queryValues.equals("")) {
			queryValues = queryValues.substring(0, queryValues.length() - 2);

			String completeQuery = getF03B11HeaderInsert() + queryValues;

			try {
				int row = em.createNativeQuery(completeQuery).executeUpdate();
				if (row > 0) {
					createAccountDetail(idJsonLog, em, creditInfos.get(0), batchNumber, subtotalCr,
							subtotal, cashId, userId, accountCash, softwareId);
				}
			} catch (Exception e) {
				// TODO: handle exception
				ClsBillManager.setErrorMsg(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	private void createAccountDetail(int idJsonLog, EntityManager em, ClientCreditInfo clientCreditInfo,
			int batchNumber, float amountCR, float totalAmountDr, int cashId, String userId, AccountCash accountCash,
			String softwareId) {
		String queryInsert = "";

		queryInsert += "\n";

		if (clientCreditInfo.getDocumentType().equals("RM")) {
			amountCR = Math.abs(amountCR);
			totalAmountDr = Math.abs(totalAmountDr);

		} else {
			amountCR = -amountCR;
			totalAmountDr = -totalAmountDr;
		}

		queryInsert += ClsAccountingManager.createValuesArray(clientCreditInfo.getDocumentType(), GLICUT,
				accountCash.getCompanyId(), clientCreditInfo.getBillId(), 1, batchNumber,
				FMUUtil.getIntegerHour(new java.util.Date()), clientCreditInfo.getAccountPart1(),
				clientCreditInfo.getAccountPart2(), (clientCreditInfo.getDocumentType().equals("RM") ? "10" : ""),
				accountCash.getCompanyId(), accountCash.getAccount(),
				FMUUtil.getJdLineNumberSpace(clientCreditInfo.getAccountPart1()) + clientCreditInfo.getAccount(),
				clientCreditInfo.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.DOL_CA_LETTER : FMUUtil.COR_AA_LETTER,
				clientCreditInfo.getExchange(), clientCreditInfo.getCoin().equals("COR") ? amountCR : totalAmountDr,
				clientCreditInfo.getBillId(),
				clientCreditInfo.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.F_CA_LETTER : FMUUtil.D_CA_LETTER,
				clientCreditInfo.getClientName(), clientCreditInfo.getCoin(), userId, softwareId,
				clientCreditInfo.getClientId(), 0, "");

		if (clientCreditInfo.getCoin().equals(FMUUtil.US_COIN_ID)) {

			queryInsert += "\n,";

			queryInsert += ClsAccountingManager.createValuesArray(clientCreditInfo.getDocumentType(), GLICUT,
					accountCash.getCompanyId(), clientCreditInfo.getBillId(), 1, batchNumber,
					FMUUtil.getIntegerHour(new java.util.Date()), clientCreditInfo.getAccountPart1(),
					clientCreditInfo.getAccountPart2(),
					// "",
					(clientCreditInfo.getDocumentType().equals("RM") ? "10" : ""), accountCash.getCompanyId(),
					accountCash.getAccount(),
					FMUUtil.getJdLineNumberSpace(clientCreditInfo.getAccountPart1()) + clientCreditInfo.getAccount(),
					FMUUtil.COR_AA_LETTER, clientCreditInfo.getExchange(), amountCR, clientCreditInfo.getBillId(),
					FMUUtil.F_CA_LETTER, clientCreditInfo.getClientName(), clientCreditInfo.getCoin(), userId,
					softwareId, clientCreditInfo.getClientId(), 0, "");
		}

		if (!queryInsert.equals("")) {

			String completeQuery = ClsAccountingManager.getF0911HeaderInsert() + queryInsert;

			try {
				if (ClsAccountingManager.createBatchHeader(idJsonLog, em, FMUUtil.ICICUT_CREDIT_BILL, batchNumber,
						userId, FMUUtil.dateToJulian(new Date()),
						clientCreditInfo.getCoin().equals(FMUUtil.COR_COIN_ID)
								? /* (int) */ (clientCreditInfo.getDocumentType().equals("RM") ? -amountCR
										: Math.abs(amountCR))
								: /* (int) */ (clientCreditInfo.getDocumentType().equals("RM") ? -totalAmountDr
										: Math.abs(totalAmountDr)),
						1, softwareId, true) > 0) {

					em.createNativeQuery(completeQuery).executeUpdate();
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				ClsBillManager.setErrorMsg(e.getMessage());
			}
		}
	}

	public static ClientCreditType isClientEmployee(EntityManager em, String branchId, int codCliente) {
		ClientCreditType clientCreditType = new ClientCreditType();

		try {
			String sQuery = "SELECT cast(TRIM(a.AIARC) as varchar(37) ccsid 37) a5ar, aItrar creditCode, "
					+ "aicoll, aiafc, aidnlt, airyin, aiac01, aiac02, "
					+ "aiac03, aiac04, aiac05, aiac06, aiac07, aiac08, aiac09, aiac10, " +

					"(select gmaid from " + CollectionScheme.SchemeJDE + ".f0901 "
					+ "where trim(gmmcu)=TRIM((select kgmcu from " + CollectionScheme.SchemeJDE
					+ ".f0012 where kgitem=(concat('RC',TRIM(a.AIARC))) and TRIM(kgco) = '" + branchId + "')) "
					+ " and gmobj=TRIM((select KGOBJ from " + CollectionScheme.SchemeJDE
					+ ".f0012 where kgitem=(concat('RC',TRIM(a.AIARC))) " + "and TRIM(kgco)='" + branchId
					+ "')) and gmsub=TRIM((select kgsub from " + CollectionScheme.SchemeJDE
					+ ".f0012 where kgitem=(concat('RC', TRIM(a.AIARC))) and TRIM(kgco)='" + branchId
					+ "'))) creditAccount " +

					" FROM " + CollectionScheme.SchemeJDE + ".F03012 a " + "left outer join "
					+ CollectionScheme.SchemeCAJA + ".vf0101 on aIAn8 = aban8 where aIAn8 = ? FETCH FIRST 1 ROWS ONLY";

			clientCreditType = (ClientCreditType) em.createNativeQuery(sQuery, ClientCreditType.class)
					.setParameter(1, codCliente).getSingleResult();

			return clientCreditType;
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ClsBillManager.setErrorMsg(e.getMessage());
			return null;
		}
	}

	private static String getBillAccount(String account, EntityManager em, String branchId, int codCli, int billId,
			String billType, String fee) {

		if (account != null && !account.equals("")) {
			return account;
		}

		ClientCreditType clientType = isClientEmployee(em, branchId, codCli);

		String sql = " RPAID = " + clientType.getCreditAccount();

		try {
			String sQuery = "UPDATE " + CollectionScheme.SchemeJDE + ".F03B11 set " + sql + "  "
					+ "where RPDOC = ?  and  RPAN8 = ? and TRIM(RPKCO) = '" + branchId + "' and TRIM(RPDCT) = '"
					+ billType + "'  AND TRIM(RPSFX) = '" + fee + "'";

			em.createNativeQuery(sQuery).setParameter(1, billId).setParameter(2, codCli).executeUpdate();
		}

		catch (Exception e) {
			// TODO: handle exception
			ClsCashManager.setErrorMsg2(e.getMessage());
			e.printStackTrace();
		}

		return clientType.getCreditAccount();

	}
	
	public  static ExchangeRate getActualExchangeRate(EntityManager em, String date) {
		ExchangeRate ex = null;	
		try { 
			
			String sQueryPrices = "SELECT cxcrrd currentCRExchange, "
					+ "( select tcambiom from " + CollectionScheme.SchemeCAJA + ".TPARARELA ) "
					+ "parallelRate from " + CollectionScheme.SchemeJDE + ".f0015 "
					+ "where cxcrcd='COR'  and cxcrdc='USD' and cxeft = ?";
						
			List<ExchangeRate> exchangeRates =  em.createNativeQuery(sQueryPrices, ExchangeRate.class).setParameter(1, date).getResultList();
			ex = exchangeRates.get(0);
		}
		catch (Exception e) {			 
			e.printStackTrace();
			ex = new ExchangeRate();
			ex.setCurrentCRExchange(0);
			ex.setParallelRate(0);
		}
		return ex;

	}
	
	
	
	

	public static void createReceiptDetail(int idJsonLog, EntityManager em,
			List<CashBillReceiptRelation> cashBillReceiptRelations,
			List<CashReceiptPaymentItem> cashReceiptPaymentItems, CashReceipt cashReceipt, int batchNumber,
			int numberReceiptJDE, CashChangeDetail cashChangeDetail) {

		String queryValues = "";
		String queryDetailValues = "";
		DecimalFormat format = new DecimalFormat(".00");
		float totalBatch = 0;
		List<String> vaList = new ArrayList<String>();

		ExchangeRate excrt = getActualExchangeRate(em, String.valueOf( FMUUtil.dateToJulian(new SimpleDateFormat("yyyy-MM-dd").format(new Date())) ) );
		 
				
		// update amount
		for (CashReceiptPaymentItem cashReceiptPaymentItem : cashReceiptPaymentItems) {
			cashReceiptPaymentItem.setEquivalent(new BigDecimal(format.format(cashReceiptPaymentItem.getEquivalent()))
					.multiply(new BigDecimal(100)).floatValue());
		}

		pago: for (CashReceiptPaymentItem cashReceiptPaymentItem : cashReceiptPaymentItems) {

			int sequenceNumber = getBatchSequenceNumber(em);

			CashBillReceiptRelation clBillReceiptRelation = cashBillReceiptRelations.get(0);

			ClientCreditType clientType = isClientEmployee(em, clBillReceiptRelation.getJdBranchId(),
					clBillReceiptRelation.getCodCli());

			// Save Receipt Header
			queryValues += "\n";
			queryValues += createF03B13ValuesArray(sequenceNumber, cashReceipt.getCodCli(),
					clBillReceiptRelation.getJdBranchId(), cashReceipt.getCoin(), cashChangeDetail.getExchange(), "0",
					("Recibo de Caja # " + cashReceipt.getReceiptNumber()), cashReceipt.getClientName(),
					cashReceipt.getUserId(), cashReceipt.getSoftwareId(), batchNumber, "0",
					cashReceiptPaymentItem.getCashAccount2(), cashReceipt.getReceiptNumber());

			queryValues += ",\n";

			vaList.add(String.valueOf(sequenceNumber));

			int sequenceNumberItem = 1;

			for (CashBillReceiptRelation cashBillReceiptRelation : cashBillReceiptRelations) {

				cashBillReceiptRelation.setSequenceNumber(sequenceNumber);

				if (cashReceiptPaymentItem.getEquivalent() > cashBillReceiptRelation.getAmount()) {

					float total = new BigDecimal(format.format(cashBillReceiptRelation.getAmount())).floatValue();

					if (total == 0) {
						continue;
					}

					totalBatch += total;

					float amountCr = total;
					float amountDr = 0;

					if (cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID)) {
						
						/*
						 * if( cashBillReceiptRelations.size() == 1 && cashReceiptPaymentItems.size() ==
						 * 1 && cashBillReceiptRelation.isCancelCompleteBill() &&
						 * cashReceiptPaymentItems.get(0).getCoin().compareTo(FMUUtil.US_COIN_ID) == 0 )
						 * {
						 * 
						 * amountCr = (new BigDecimal(format.format(total)).divide(new
						 * BigDecimal("100")).floatValue());
						 * 
						 * amountCr = (new BigDecimal(format.format(amountCr)) .multiply(new BigDecimal(
						 * Float.toString( excrt.getCurrentCRExchange() ) )) .floatValue());
						 * 
						 * amountCr = (new BigDecimal(format.format(amountCr)).multiply(new
						 * BigDecimal(100)).floatValue());
						 * 
						 * amountCr = new BigDecimal(format.format(amountCr)).floatValue();
						 * 
						 * cashBillReceiptRelation.setBillExchange( excrt.getCurrentCRExchange() );
						 * 
						 * }
						 * 
						 * else
						 */
								if (cashBillReceiptRelations.size() == 1 && cashReceiptPaymentItems.size() == 1
								&& cashBillReceiptRelation.isCancelCompleteBill()) {
								
								
								//amountCr = cashBillReceiptRelation.getCrBalance();
								
								
								amountCr = (new BigDecimal(format.format(total)).divide(new BigDecimal("100")).floatValue());
								
								amountCr = (new BigDecimal(format.format(amountCr))
										.multiply(new BigDecimal(cashBillReceiptRelation.getCalculatedExchange()))
										.floatValue());
	
								amountCr = (new BigDecimal(format.format(amountCr)).multiply(new BigDecimal(100))
										.floatValue());
	
								amountCr = new BigDecimal(format.format(amountCr)).floatValue();
								
								
								
								
							} else {
								amountCr = (new BigDecimal(format.format(total)).divide(new BigDecimal(100)).floatValue());
	
								amountCr = (new BigDecimal(format.format(amountCr))
										.multiply(new BigDecimal(cashBillReceiptRelation.getCalculatedExchange()))
										.floatValue());
	
								amountCr = (new BigDecimal(format.format(amountCr)).multiply(new BigDecimal(100))
										.floatValue());
	
								amountCr = new BigDecimal(format.format(amountCr)).floatValue();
							}

						amountDr = total;
											
						//------------------------------------------------------------------------------------------------------
						//----------- calcular el diferencial cambiario.
						BigDecimal montoTasaFechaActual = new BigDecimal(String.valueOf(amountCr));
						BigDecimal montoTasaFechaFactura = new BigDecimal (String.valueOf( cashBillReceiptRelation.getBillExchangeAmountGainLoss() ) ) ;						
						montoTasaFechaFactura = montoTasaFechaFactura.multiply(new BigDecimal(String.valueOf(amountDr))).setScale(2, RoundingMode.HALF_UP);
												
						BigDecimal diferencialCambiario = montoTasaFechaActual.subtract(montoTasaFechaFactura);
						
						if(diferencialCambiario.compareTo(BigDecimal.ZERO) != 0){							
							cashBillReceiptRelation.setAccountPart3(diferencialCambiario.toString() );	
							
							String query1 = cashBillReceiptRelation.getJdLineId();
							String query2 = "66000";
							String query3 = "01";

							AccountCash accountCashSurplus = ClsAccountingManager.getSurplusAccount(em, query1, query2, query3);
							cashBillReceiptRelation.setAccount(accountCashSurplus.getAccount());

						}
						//------------------------------------------------------------------------------------------------------
						
						
					}

					queryDetailValues += "\n";
					queryDetailValues += createF03B14ValuesArray(sequenceNumber, cashBillReceiptRelation.getBillId(),
							cashBillReceiptRelation.getBillType(), cashBillReceiptRelation.getJdBranchId(),
							cashBillReceiptRelation.getJdLineId(), cashBillReceiptRelation.getFee(),
							cashReceipt.getCodCli(), batchNumber, cashBillReceiptRelation.getCoin(),
							cashReceipt.getUserId(), cashReceipt.getSoftwareId(),
							("Recibo de Caja # " + cashReceipt.getReceiptNumber()),
							getBillAccount(cashBillReceiptRelation.getAccountPart1(), em,
									cashBillReceiptRelation.getJdBranchId(), cashBillReceiptRelation.getCodCli(),
									cashBillReceiptRelation.getBillId(), cashBillReceiptRelation.getBillType(),
									cashBillReceiptRelation.getFee()),
							-amountCr, cashBillReceiptRelation.getBillExchange(), -amountDr, sequenceNumberItem,
							Integer.parseInt(cashBillReceiptRelation.getAccountPart2()),
							cashBillReceiptRelation.getAccount(), cashBillReceiptRelation.getAccountPart3(),
							cashBillReceiptRelation.isCancelCompleteBill(), cashReceipt.getReceiptNumber(),
							clientType.getA5ar(),
							cashBillReceiptRelation.getBillExchangeAmountGainLoss()
							);

					queryDetailValues += ",\n";
					sequenceNumberItem++;
					cashReceiptPaymentItem.setEquivalent(
							cashReceiptPaymentItem.getEquivalent() - cashBillReceiptRelation.getAmount());
					cashBillReceiptRelation.setAmount(0);

					continue;

				} else if (cashReceiptPaymentItem.getEquivalent() < cashBillReceiptRelation.getAmount()) {

					float total = new BigDecimal(format.format(cashReceiptPaymentItem.getEquivalent())).floatValue();

					totalBatch += total;

					float amountCr = total;
					float amountDr = 0;

					if (cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID)) {
							
						amountCr = (new BigDecimal(format.format(total)).divide(new BigDecimal(100)).floatValue());

						amountCr = (new BigDecimal(format.format(amountCr))
								.multiply(new BigDecimal(cashBillReceiptRelation.getCalculatedExchange()))
								.floatValue());

						amountCr = (new BigDecimal(format.format(amountCr)).multiply(new BigDecimal(100)).floatValue());

						amountDr = total;

						//------------------------------------------------------------------------------------------------------
						//----------- calcular el diferencial cambiario.
						BigDecimal montoTasaFechaActual = new BigDecimal(String.valueOf(amountCr));
						BigDecimal montoTasaFechaFactura = new BigDecimal (String.valueOf( cashBillReceiptRelation.getBillExchangeAmountGainLoss() ) ) ;						
						montoTasaFechaFactura = montoTasaFechaFactura.multiply(new BigDecimal(String.valueOf(amountDr))).setScale(2, RoundingMode.HALF_UP);
												
						BigDecimal diferencialCambiario = montoTasaFechaActual.subtract(montoTasaFechaFactura).setScale(2, RoundingMode.HALF_UP);
						
						if(diferencialCambiario.compareTo(BigDecimal.ZERO) != 0){							
							cashBillReceiptRelation.setAccountPart3(diferencialCambiario.toString() );	
							
							String query1 = cashBillReceiptRelation.getJdLineId();
							String query2 = "66000";
							String query3 = "01";

							AccountCash accountCashSurplus = ClsAccountingManager.getSurplusAccount(em, query1, query2, query3);
							cashBillReceiptRelation.setAccount(accountCashSurplus.getAccount());

						}
						//------------------------------------------------------------------------------------------------------
						
					}

					queryDetailValues += createF03B14ValuesArray(sequenceNumber, cashBillReceiptRelation.getBillId(),
							cashBillReceiptRelation.getBillType(), cashBillReceiptRelation.getJdBranchId(),
							cashBillReceiptRelation.getJdLineId(), cashBillReceiptRelation.getFee(),
							cashReceipt.getCodCli(), batchNumber, cashBillReceiptRelation.getCoin(),
							cashReceipt.getUserId(), cashReceipt.getSoftwareId(),
							("Recibo de Caja # " + cashReceipt.getReceiptNumber()),
							getBillAccount(cashBillReceiptRelation.getAccountPart1(), em,
									cashBillReceiptRelation.getJdBranchId(), cashBillReceiptRelation.getCodCli(),
									cashBillReceiptRelation.getBillId(), cashBillReceiptRelation.getBillType(),
									cashBillReceiptRelation.getFee()),
							-amountCr, cashBillReceiptRelation.getBillExchange(), -amountDr, sequenceNumberItem,
							Integer.parseInt(cashBillReceiptRelation.getAccountPart2()),
							cashBillReceiptRelation.getAccount(), cashBillReceiptRelation.getAccountPart3(),
							cashBillReceiptRelation.isCancelCompleteBill(), cashReceipt.getReceiptNumber(),
							clientType.getA5ar(),
							cashBillReceiptRelation.getBillExchangeAmountGainLoss()
							);

					cashBillReceiptRelation
							.setAmount(cashBillReceiptRelation.getAmount() - cashReceiptPaymentItem.getEquivalent());
					cashReceiptPaymentItem.setEquivalent(0);

					queryDetailValues += ",\n";
					sequenceNumberItem++;

					continue pago;

				} else if (cashReceiptPaymentItem.getEquivalent() == cashBillReceiptRelation.getAmount()) {

					float total = new BigDecimal(format.format(cashReceiptPaymentItem.getEquivalent())).floatValue();
					float amountCr = total;
					float amountDr = 0;

					totalBatch += total;

					if (cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID)) {

						if (cashBillReceiptRelations.size() == 1 && cashReceiptPaymentItems.size() == 1
								&& cashBillReceiptRelation.isCancelCompleteBill()) {

								//amountCr = cashBillReceiptRelation.getCrBalance();
								
							amountCr = (new BigDecimal(format.format(total)).divide(new BigDecimal("100")).floatValue());

							amountCr = (new BigDecimal(format.format(amountCr))
									.multiply(new BigDecimal(cashBillReceiptRelation.getCalculatedExchange()))
									.floatValue());

							amountCr = (new BigDecimal(format.format(amountCr)).multiply(new BigDecimal(100))
									.floatValue());
							
							
							
						} else {

							amountCr = (new BigDecimal(format.format(total)).divide(new BigDecimal(100)).floatValue());

							amountCr = (new BigDecimal(format.format(amountCr))
									.multiply(new BigDecimal(cashBillReceiptRelation.getCalculatedExchange()))
									.floatValue());

							amountCr = (new BigDecimal(format.format(amountCr)).multiply(new BigDecimal(100))
									.floatValue());
						}
						amountDr = total;
						
						//------------------------------------------------------------------------------------------------------
						//----------- calcular el diferencial cambiario.
						
						BigDecimal montoTasaFechaActual = new BigDecimal(String.valueOf(amountCr));
						BigDecimal montoTasaFechaFactura = new BigDecimal (String.valueOf( cashBillReceiptRelation.getBillExchangeAmountGainLoss() ) ) ;						
						montoTasaFechaFactura = montoTasaFechaFactura.multiply(new BigDecimal(String.valueOf(amountDr))).setScale(2, RoundingMode.HALF_UP);
												
						BigDecimal diferencialCambiario = montoTasaFechaActual.subtract(montoTasaFechaFactura);
						
						if(diferencialCambiario.compareTo(BigDecimal.ZERO) != 0){							
							cashBillReceiptRelation.setAccountPart3(diferencialCambiario.toString() );		
							
							String query1 = cashBillReceiptRelation.getJdLineId();
							String query2 = "66000";
							String query3 = "01";

							AccountCash accountCashSurplus = ClsAccountingManager.getSurplusAccount(em, query1, query2, query3);
							cashBillReceiptRelation.setAccount(accountCashSurplus.getAccount());

						}
						//------------------------------------------------------------------------------------------------------	
						
					}

					queryDetailValues += createF03B14ValuesArray(sequenceNumber, cashBillReceiptRelation.getBillId(),
							cashBillReceiptRelation.getBillType(), cashBillReceiptRelation.getJdBranchId(),
							cashBillReceiptRelation.getJdLineId(), cashBillReceiptRelation.getFee(),
							cashReceipt.getCodCli(), batchNumber, cashBillReceiptRelation.getCoin(),
							cashReceipt.getUserId(), cashReceipt.getSoftwareId(),
							("Recibo de Caja # " + cashReceipt.getReceiptNumber()),
							getBillAccount(cashBillReceiptRelation.getAccountPart1(), em,
									cashBillReceiptRelation.getJdBranchId(), cashBillReceiptRelation.getCodCli(),
									cashBillReceiptRelation.getBillId(), cashBillReceiptRelation.getBillType(),
									cashBillReceiptRelation.getFee()),
							-amountCr, cashBillReceiptRelation.getBillExchange(), -amountDr, sequenceNumberItem,
							Integer.parseInt(cashBillReceiptRelation.getAccountPart2()),
							cashBillReceiptRelation.getAccount(), cashBillReceiptRelation.getAccountPart3(),
							cashBillReceiptRelation.isCancelCompleteBill(), cashReceipt.getReceiptNumber(),
							clientType.getA5ar(),
							cashBillReceiptRelation.getBillExchangeAmountGainLoss()
							);

					queryDetailValues += ",\n";

					cashBillReceiptRelation.setAmount(0);
					cashReceiptPaymentItem.setEquivalent(0);
					sequenceNumberItem++;

					continue pago;
				}
			}
		}

		if (!queryValues.equals("") && !queryDetailValues.equals("")) {

			queryValues = queryValues.substring(0, queryValues.length() - 2);
			queryDetailValues = queryDetailValues.substring(0, queryDetailValues.length() - 2);

			String completeQuery = getHeaderF03B13Insert() + "\n" + queryValues;

			String completeDetailQuery = getHeaderF03B14Insert() + "\n" + queryDetailValues;

			try {

				if (ClsAccountingManager.createBatchHeader(idJsonLog, em, FMUUtil.ICICUT_CREDIT_PAY, batchNumber,
						cashReceipt.getUserId(), FMUUtil.dateToJulian(new java.util.Date()), /* (int) */ (totalBatch),
						cashBillReceiptRelations.size(), cashReceipt.getSoftwareId(), false) > 0) {
					int result = em.createNativeQuery(completeQuery).executeUpdate();

					ClsSystemLogs.createQueryLog(idJsonLog, "createReceiptDetail", completeQuery, true, result);

					if (result > 0) {

						int rows = em.createNativeQuery(completeDetailQuery).executeUpdate();

						ClsSystemLogs.createQueryLog(idJsonLog, "createReceiptDetail", completeDetailQuery, true, rows);

						if (!vaList.isEmpty()) {

							for (String item : vaList) {

								F03b14FieldUtil f03b14FieldUtil;

								String sQuery = "SELECT sum(rzpfap) amountDr, sum(rzpaap) amountCr from "
										+ CollectionScheme.SchemeJDE + ".F03B14 " + "where  rzpyid = " + item;

								f03b14FieldUtil = (F03b14FieldUtil) em.createNativeQuery(sQuery, F03b14FieldUtil.class)
										.getSingleResult();

								if (f03b14FieldUtil != null) {
									// update
									String sQueryUpdate = "UPDATE  " + CollectionScheme.SchemeJDE + ".F03B13 "
											+ "set RYFCAM =  " + Math.abs(f03b14FieldUtil.getAmountDr()) + ", RYCKAM = "
											+ Math.abs(f03b14FieldUtil.getAmountCr()) + "  where rypyid = " + item;

									em.createNativeQuery(sQueryUpdate).executeUpdate();
								}
							}
						}
					}
					/*
					// check RG
					for (CashBillReceiptRelation cashBillReceiptRelation : cashBillReceiptRelations) {
						if (cashBillReceiptRelation.isCancelCompleteBill()
								&& cashBillReceiptRelation.getCoin().equals(FMUUtil.US_COIN_ID)) {
							setRGCreditBill(cashBillReceiptRelation, em,
									cashReceiptPaymentItems.get(cashReceiptPaymentItems.size() - 1));
						}
					}
					*/
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				ClsCashManager.setErrorMsg2(e.getMessage());
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static void setRGCreditBill(CashBillReceiptRelation cashBillReceiptRelation, EntityManager em,
			CashReceiptPaymentItem cashReceiptPaymentItem) {

		PostObjectReturn postObjectReturn = new PostObjectReturn();
		List<GlobalProductCatalog> postObjectReturns = new ArrayList<>();

		int totalSum = 0;
		int totalBill = 0;

		try {
			// Get receives, total y tasa de cambio
			String sQueryTotal = "select " + "RZPAAP price, " + "RZCRR iva " + "FROM "
					+ CollectionScheme.SchemeJDE + ".F03B14 " + "where RZAN8 = " + cashBillReceiptRelation.getCodCli()
					+ " and RZDOC = " + cashBillReceiptRelation.getBillId() + " AND  TRIM(RZSFX) = '"
					+ cashBillReceiptRelation.getFee() + "' AND RZDCT='" + cashBillReceiptRelation.getBillType() + "'";

			postObjectReturns = em.createNativeQuery(sQueryTotal, GlobalProductCatalog.class).getResultList();

			int total = 0;
			DecimalFormat format = new DecimalFormat(".00");

			// float
			for (GlobalProductCatalog postItem : postObjectReturns) {
				float amount = Math.abs(postItem.getPrice());
				//total += new BigDecimal(amount).multiply(new BigDecimal(postItem.getIva())).floatValue();
				total += amount;
			}

			//totalSum = new BigDecimal(format.format(total)).multiply(new BigDecimal(100)).intValue();
			totalSum = total;
			
			// Se agrega la sucursal, para evitar duplicados de cuentas por cobrar
			String sQuery = "Select RPAG batchNumber FROM " + CollectionScheme.SchemeJDE + ".F03B11 " + "where RPAN8 = "
					+ cashBillReceiptRelation.getCodCli() + " " + " AND TRIM(RPSFX) = '"
					+ cashBillReceiptRelation.getFee() + "'  " + "and RPDOC = " + cashBillReceiptRelation.getBillId()
					+ " AND RPDCT='" + cashBillReceiptRelation.getBillType() + "' " + " AND RPKCO = '"
					+ cashBillReceiptRelation.getJdBranchId() + "'";

			postObjectReturn = (PostObjectReturn) em.createNativeQuery(sQuery, PostObjectReturn.class)
					.getSingleResult();

			if (postObjectReturn != null) {
				totalBill = Math.abs(postObjectReturn.getBatchNumber());
			}

			int totalRg = 0;
			
			System.out.println("Entro sum 1 " + totalSum);
			System.out.println("Entro sum 2 " + totalBill);

			if (totalSum > totalBill) {
				totalRg = (totalSum - totalBill);
			} else if (totalSum < totalBill) {
				totalRg = (totalSum - totalBill);
				totalRg = -totalRg;
			}

			if (totalRg != 0) {

				String query1 = cashBillReceiptRelation.getJdLineId();
				String query2 = "66000";
				String query3 = "01";

				AccountCash accountCashSurplus = ClsAccountingManager.getSurplusAccount(em, query1, query2, query3);

				String queryDiff = "UPDATE " + CollectionScheme.SchemeJDE + ".F03B14 SET " + "RZAGL = " + totalRg
						+ ",RZAIDT = " + accountCashSurplus.getAccount() + " " + "WHERE RZPYID = "
						+ cashBillReceiptRelation.getSequenceNumber() + " " + "AND RZDCT='"
						+ cashBillReceiptRelation.getBillType() + "'";

				em.createNativeQuery(queryDiff).executeUpdate();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ClsCashManager.setErrorMsg2(e.getMessage());
		}
	}

	public static void updatePendingAmount(int idJsonLog, EntityManager em, CashReceipt cashReceipt,
			List<CashBillReceiptRelation> cashBillReceiptRelations, int batchNumber) {

		String totalAppliedInDetailReceipt = 
				" (select ABS(sum(f.rzpaap) + sum(f.rzagl)) "
				+ "from @JDEDTA.f03b14 f "
				+ "where rzdoc = '@RZDOC' and rzan8 = '@RZAN8' and rzicu = '@RZICU' )" ;
		
		for (CashBillReceiptRelation cashBillReceiptRelation : cashBillReceiptRelations) {

			float total = new BigDecimal(cashBillReceiptRelation.getAmount()).floatValue();

			float amountCr = total;
			float amountDr = 0;

			String crSql = "";
			String drSql = "";
//			String drY = ""; 	

			String amountToSubtrack = totalAppliedInDetailReceipt
						.replace("@JDEDTA",  CollectionScheme.SchemeJDE )
						.replace("@RZDOC", String.valueOf( cashBillReceiptRelation.getBillId() ) )
						.replace("@RZAN8", String.valueOf( cashBillReceiptRelation.getCodCli() ) )
						.replace("@RZICU", String.valueOf(batchNumber) );			
			
			boolean checkDomesticPendingAmount =  
					cashReceipt.getCoin().compareTo(FMUUtil.US_COIN_ID) == 0 &&
					cashBillReceiptRelation.isCancelCompleteBill();			
			
			String drY = ", RPPST = 'A'"; 
			
			if (cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID)) {
				
				amountCr = new BigDecimal(cashBillReceiptRelation.getCrAmount()).floatValue();
				amountDr = total;
				
				crSql = "RPAAP = ( RPAAP - " + amountToSubtrack + ")";
				drSql = "RPFAP = (RPFAP - " + amountDr + "),";
				
		
				if (cashBillReceiptRelation.isCancelCompleteBill()) {
					drSql = "RPFAP = 0,";
					//crSql = "RPAAP = 0";
					 drY = ", RPPST = 'P'";
				}

			} else {
				drSql = "";
				crSql = "RPAAP = ( RPAAP - " + amountCr + ")";
			}

			//String drY = ", RPPST = (CASE WHEN ( RPAAP - " + amountCr + ") = 0.0 THEN 'P' ELSE 'A' END )";

			try {
				String sQuery = "UPDATE " + CollectionScheme.SchemeJDE + ".F03B11 " + "set " + drSql + " " + crSql
						+ "  " + "  " + drY + "where RPDOC = ?  " + "and  RPAN8 = ? " + "and TRIM(RPKCO) = '"
						+ cashBillReceiptRelation.getJdBranchId() + "' and TRIM(RPDCT) = '"
						+ cashBillReceiptRelation.getBillType() + "'  AND TRIM(RPSFX) = '"
						+ cashBillReceiptRelation.getFee() + "'";
				
				System.out.println("query update f03b11 " + sQuery);

				int rows = em.createNativeQuery(sQuery).setParameter(1, cashBillReceiptRelation.getBillId())
						.setParameter(2, cashBillReceiptRelation.getCodCli()).executeUpdate();
				
				
				int value = ClsCreditManager.get03b11CorBalanceDocument(em, cashBillReceiptRelation.getBillId(), cashBillReceiptRelation.getCodCli(),
						cashBillReceiptRelation.getFee(), cashBillReceiptRelation.getBillType(), cashBillReceiptRelation.getJdBranchId());
			
				
				 cashBillReceiptRelation.setNewCorAmount(value);
				 

				ClsSystemLogs.createQueryLog(idJsonLog, "updatePendingAmount", sQuery, true, rows,
						new Object[] { cashBillReceiptRelation.getBillId(), cashBillReceiptRelation.getCodCli() });
			}

			catch (Exception e) {
				ClsCashManager.setErrorMsg2(e.getMessage());
				e.printStackTrace();
			}
			
			if(checkDomesticPendingAmount) {
				checkDomesticPendingAmount(em, 
						batchNumber, 
						cashBillReceiptRelation.getBillId(),
						cashBillReceiptRelation.getCodCli(), 
						cashBillReceiptRelation.getBillType(),
						cashBillReceiptRelation.getFee(),
						idJsonLog
					);			
			}
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void checkDomesticPendingAmount(EntityManager em, int rpicu, int rpdoc, int rpan8, String rpdct, String rpsfx, int idJsonLog) {
		try {
			

			String billToCheckSearchCriteria = 
					"where	 rpdoc = '@RPDOC' and rpan8 = '@RPAN8' and trim(rpdct) = trim('@RPDCT') and trim(rpsfx) = trim('@RPSFX') and rpfap = 0 and rpaap <> 0";
			
			billToCheckSearchCriteria = billToCheckSearchCriteria					 
					.replace("@RPDOC", String.valueOf( rpdoc ) )
					.replace("@RPAN8", String.valueOf( rpan8 ) )
					.replace("@RPDCT", String.valueOf( rpdct ) )
					.replace("@RPSFX", String.valueOf( rpsfx ) )
					;		
			
			String queryCheckBill = 
					 " select cast(rpaap as integer) rpaap" 
					+" from @JDEDTA.F03B11 " 
					+  billToCheckSearchCriteria ;
			
			queryCheckBill = queryCheckBill
					.replace("@JDEDTA",  CollectionScheme.SchemeJDE )
					;
			
			System.out.println(" buscar factura : " + queryCheckBill);
			
			ClsSystemLogs.createQueryLog(idJsonLog, "CheckDomPendAmount-SearchBill", queryCheckBill, false, 1,  null);
			
			List<Object> object = em.createNativeQuery(queryCheckBill, Object.class).getResultList();

			int rpaap = (object == null || object.isEmpty() || object.get(0) == null ) ? 0 : Integer.parseInt(object.get(0).toString());

			if (rpaap == 0) {
				return;
			}
			
			String lastRowReceiptSearchCriteria = " where rzicu = '@RZICU' and rzan8 = '@RZAN8' and rzdoc = '@RZDOC' and trim(rzdct) = trim('@RZDCT') and trim(rzsfx) = trim('@RZSFX') ";
			lastRowReceiptSearchCriteria = lastRowReceiptSearchCriteria
					.replace("@JDEDTA",  CollectionScheme.SchemeJDE )
					.replace("@RZICU", String.valueOf( rpicu ) )
					.replace("@RZAN8", String.valueOf( rpan8 ) )
					.replace("@RZDOC", String.valueOf( rpdoc ) )					
					.replace("@RZDCT", String.valueOf( rpdct ) )
					.replace("@RZSFX", String.valueOf( rpsfx ) )
					;
			
			String getLastRowReceipt =
				 " select cast( rzpyid as integer) || '@' || cast(  rzrc5 as integer) "
				+" from @JDEDTA.F03B14 "
				+ lastRowReceiptSearchCriteria
				+" order by rzpyid desc "
				+" fetch first rows only " 
				;
			
			getLastRowReceipt = getLastRowReceipt.replace("@JDEDTA",  CollectionScheme.SchemeJDE );
			
			System.out.println(" buscar ultimo pago en recibos : " + getLastRowReceipt);
			ClsSystemLogs.createQueryLog(idJsonLog, "CheckDomPendAmount-getLastRowReceipt", getLastRowReceipt, false, 1,  null);
			
			object = em.createNativeQuery(getLastRowReceipt, Object.class).getResultList();
			String paymentId = (object == null || object.isEmpty() || object.get(0) == null )? "" : String.valueOf(object.get(0).toString());
			
			if(paymentId.isEmpty())
				return;
			
			String queryModifyGainLossReceiptAmount =
				 " update @JDEDTA.F03B14 "
				+" set rzagl = rzagl @OPERATOR @RPAAP "
				+ lastRowReceiptSearchCriteria + " and rzpyid = '@RZPYID' and rzrc5 = '@RZRC5' "
				;
 
			queryModifyGainLossReceiptAmount = queryModifyGainLossReceiptAmount
				.replace("@JDEDTA",  CollectionScheme.SchemeJDE )
				.replace("@OPERATOR", ( rpaap > 0? "-" : "+" ) )
				.replace("@RPAAP",  String.valueOf( Math.abs(rpaap) ) )
				.replace("@RZPYID", String.valueOf( paymentId.split("@")[0] ) )
				.replace("@RZRC5",  String.valueOf( paymentId.split("@")[1] ) );
			
			String updateDomesticPendingAmount = 
					"UPDATE @JDEDTA.F03B11 SET RPAAP = 0 "
					+ billToCheckSearchCriteria;
			updateDomesticPendingAmount = updateDomesticPendingAmount.replace("@JDEDTA",  CollectionScheme.SchemeJDE );
			
			System.out.println(" actualizar dif cambiario:  " + queryModifyGainLossReceiptAmount);
						
			int rowsAffected = 0;
			rowsAffected =  em.createNativeQuery(queryModifyGainLossReceiptAmount).executeUpdate();
			ClsSystemLogs.createQueryLog(idJsonLog, "CheckDomPendAmount-updateGainLoss", queryModifyGainLossReceiptAmount, true, rowsAffected,  null);
			if(rowsAffected != 1 )
				return;
			
			System.out.println(" actualizar saldo pendiente factura :  " + updateDomesticPendingAmount ) ;
			rowsAffected =  em.createNativeQuery(updateDomesticPendingAmount).executeUpdate();
			ClsSystemLogs.createQueryLog(idJsonLog, "CheckDomPendAmount-updateDomesticPendingAmount", updateDomesticPendingAmount, true, rowsAffected,  null);
			if(rowsAffected != 1 )
				return;			
			
		} catch (Exception e) {
			ClsCashManager.setErrorMsg2(e.getMessage());
			e.printStackTrace();
		}
	}
	
	


	@SuppressWarnings("unchecked")
	public static int get03b11CorBalanceDocument(EntityManager em, int billId, int clientId, String fee, String billType, String branchId) {
		int batchNumber = 0;
		try {

			List<Object> object = new ArrayList<Object>();
			;

			String sQuery = "Select RPAAP batchNumber FROM " + CollectionScheme.SchemeJDE + ".F03B11 " + "where RPAN8 = "
					+ clientId + " " + " AND TRIM(RPSFX) = '"
					+ fee + "'  " + "and RPDOC = " + billId
					+ " AND RPDCT='" + billType + "' " + " AND RPKCO = '"
					+ branchId + "'";

			object = em.createNativeQuery(sQuery, Object.class).setParameter(1, billId).setParameter(2, clientId)
					.getResultList();

			if (object.size() > 0) {
				batchNumber = object.get(0) == null ? 0 : Integer.parseInt(object.get(0).toString());
			}
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return batchNumber;
	}
	
	/**
	 * 
	 * {@link Util} functions
	 * 
	 */

	@SuppressWarnings("unchecked")
	public static void deleteAccountMovementCredit(EntityManager em, int billId, int clientId) {
		try {

			List<Object> object = new ArrayList<Object>();
			;

			int batchNumber = 0;

			String sQuery = "SELECT " + "RPICU " + "from " + CollectionScheme.SchemeJDE + ".F03B11 "
					+ "where RPDOC = ? " + "AND rpan8 = ?  " + "AND RPSFX='001'";

			object = em.createNativeQuery(sQuery, Object.class).setParameter(1, billId).setParameter(2, clientId)
					.getResultList();

			if (object.size() > 0) {
				batchNumber = object.get(0) == null ? 0 : Integer.parseInt(object.get(0).toString());
			}

			if (batchNumber == 0) {
				return;
			}

			String sQueryF0311 = "delete from " + CollectionScheme.SchemeJDE + ".F03B11 " + "where  RPDOC = ? "
					+ "AND rpan8 = ? " + "AND rpicu = ?  " + "AND  (RPAG = RPAAP) " + "AND (RPACR = RPACR)";

			int result = em.createNativeQuery(sQueryF0311).setParameter(1, billId).setParameter(2, clientId)
					.setParameter(3, batchNumber).executeUpdate();

			if (result > 0) {

				String sQueryDeleteF0911 = "delete" + " from " + CollectionScheme.SchemeJDE + ".F0911 "
						+ "where GLICU = ? " + "and GLDOC = ?";

				int resultF0911 = em.createNativeQuery(sQueryDeleteF0911).setParameter(1, batchNumber)
						.setParameter(2, billId).executeUpdate();

				if (resultF0911 > 0) {

					String sQueryDeleteF0011 = "delete " + "from " + CollectionScheme.SchemeJDE + ".F0011 "
							+ "where ICICU = ?  " + "AND ICICUT='IB'";

					em.createNativeQuery(sQueryDeleteF0011).setParameter(1, batchNumber).executeUpdate();
				}
			} else {
				System.out.println("No se proceso porque tiene recibos asociados");
			}
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public static int getBatchSequenceNumber(EntityManager em) {
		List<Object> object = new ArrayList<Object>();
		;

		try {
			String sQuery = "Select " + "cast(NNN010  as integer)  " + "from " + CollectionScheme.SchemeJDECOM
					+ ".f0002 " + "where TRIM(nnsy) = '03B'";

			object = em.createNativeQuery(sQuery, Object.class).getResultList();

			int number = object.get(0) == null ? 0 : Integer.parseInt(object.get(0).toString());

			if (number > 0) {
				String sQueryUpdate = "update " + CollectionScheme.SchemeJDECOM + ".f0002 "
						+ "set NNN010 = (NNN010 + 1)" + " where nnsy = '03B'";
				em.createNativeQuery(sQueryUpdate).executeUpdate();
			}

			return number;
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Header String for insert batch detail
	 * 
	 * @return
	 */
	public static String getF03B11HeaderInsert() {

		try {
			String sQuery = "INSERT INTO " + CollectionScheme.SchemeJDE + ".F03B11 (" + "RPKCO," + // --> [Pos 001]
																									// Branch id
																									// **Sequence Number
					"RPAN8," + // --> [Pos 002] Client Id
					"RPDCT," + // --> [Pos 003] Document type
					"RPDOC," + // --> [Pos 004] Bill id
					"RPSFX," + // --> [Pos 005] Sequence id
					"RPDIVJ," + // --> [Pos 006] Julian date
					"RPDGJ," + // --> [Pos 007] Julian date
					"RPFY," + // --> [Pos 008] Fiscal Year
					"RPCTRY," + // --> [Pos 009] Century
					"RPPN," + // --> [Pos 010] Julian date (Period Number - General Ledger)
					"RPCO," + // --> [Pos 011] Company
					"RPICUT," + // --> [Pos 012] Batch Type
					"RPICU," + // --> [Pos 013] Batch Number
					"RPDICJ," + // --> [Pos 014] Date - Batch (Julian)
					"RPPA8," + // --> [Pos 015] Address Number - Parent
					"RPAN8J," + // --> [Pos 016] Address Number - Alternate Payee
					"RPPYR," + // --> [Pos 017] Payor Address Number
					"RPBALJ," + // --> [Pos 018] Balanced - Journal Entries
					"RPPST," + // --> [Pos 019] Pay Status Code
					"RPAG," + // --> [Pos 020] Amount - Gross
					"RPAAP," + // --> [Pos 021] Amount Open
					"RPATXA," + // --> [Pos 022] Amount - Taxable
					"RPSTAM," + // --> [Pos 023] Amount - Tax
					"RPCRRM," + // --> [Pos 024] Currency Mode-Foreign or Domestic Entry
					"RPCRCD," + // --> [Pos 025] Currency Code - From
					"RPCRR," + // --> [Pos 026] Currency Conversion Rate - Spot Rate
					"RPACR," + // --> [Pos 027] Amount - Currency
					"RPFAP," + // --> [Pos 028] Amount - Foreign Open
					"RPCTXA," + // --> [Pos 029] Amount - Foreign Taxable
					"RPCTAM," + // --> [Pos 030] Amount - Foreign Tax
					"RPTXA1," + // --> [Pos 031] Tax Rate/Area
					"RPEXR1," + // --> [Pos 032] Tax Expl Code 1
					"RPDSVJ," + // --> [Pos 033] Date - Service/Tax
					"RPGLC," + // --> [Pos 034] G/L Offset
					"RPGLBA," + // --> [Pos 035] G/L Bank Account
					"RPAM," + // --> [Pos 036] Account Mode - G/L
					"RPMCU," + // --> [Pos 037] Business Unit
					"RPDDJ," + // --> [Pos 038] Date - Net Due
					"RPDDNJ," + // --> [Pos 039] Date - Discount Due - Julian
					"RPRMK," + // --> [Pos 040] Name - Remark
					"RPALPH," + // --> [Pos 041] Name - Alpha
					"RPTORG," + // --> [Pos 042] Transaction Originator
					"RPUSER," + // --> [Pos 043] User ID
					"RPPID," + // --> [Pos 044] Program ID *******
					"RPUPMJ," + // --> [Pos 045] Date - Updated
					"RPUPMT," + // --> [Pos 046] Time - Last Updated
					"RPJOBN," + // --> [Pos 047] Work Station ID
					"RPAID," + // --> [Pos 048] Account ID *******
					"RPADSC," + // --> [Pos 049] Discount Available +++
					"RPADSA," + // --> [Pos 050] Discount Taken
					"RPATXN," + // --> [Pos 051] Amount - Non-Taxable
					"RPCDS," + // --> [Pos 052] Amount - Foreign Discount Available
					"RPCDSA," + // --> [Pos 053] Amount - Foreign Discount Taken
					"RPCTXN," + // --> [Pos 054] Amount - Foreign Non-Taxable
					"RPRDDJ," + // --> [Pos 055] Date of Last Sent Reminder
					"RPRDSJ," + // --> [Pos 056] Date - Reminder Stop Until Date
					"RPLFCJ," + // --> [Pos 057] Date - Last Fee Calculated (Julian)
					"RPSMTJ," + // --> [Pos 058] Date - Last Fee Calculated (Julian)
					"RPLNID," + // --> [Pos 059] Line Number
					"RPSDOC," + // --> [Pos 060] Sales Document Number
					"RPVLDT," + // --> [Pos 061] Date - Cleared/Value
					"RPCMC1," + // --> [Pos 062] Commission Code 1
					"RPPYID," + // --> [Pos 063] Payment ID (Internal)
					"RPURDT," + // --> [Pos 064] User Reserved Date
					"RPURAT," + // --> [Pos 065] User Reserved Amount
					"RPURAB," + // --> [Pos 066] User Reserved Number
					"RPRNID," + // --> [Pos 067] Batch Run ID (Internal)
					"RPPPDI," + // --> [Pos 068] Date - Invoice Printed
					"RPJCL," + // --> [Pos 069] Date Invoice Closed
					"RPHCRR," + // --> [Pos 070] Historical Currency Conversion Rate
					"RPHDGJ," + // --> [Pos 071] Historical Date - Julian
					"RPSHPN," + // --> [Pos 072] Shipment Number
					"RPOMOD," + // --> [Pos 073] Originating System
					"RPNRTA," + // --> [Pos 074] Non-Recoverable Tax Amount
					"RPFNRT," + // --> [Pos 075] Foreign Non-Recoverable Tax
					"RPDOCO," + // --> [Pos 076] Document (Order No Invoice etc.)
					"RPSOTF," + // --> [Pos 077] Sales Order Tax Flag
					"RPDTPB," + // --> [Pos 078] Notification Payment Date
					"RPPWPG," + // --> [Pos 079] Pay When Paid Group Number
					"RPNETTCID," + // --> [Pos 080] Netting Transaction ID
					"RPNETDOC," + // --> [Pos 081] Netting Document Number
					"RPNETRC5," + // --> [Pos 082] Netting Line ID
					"RPNETST," + // --> [Pos 083] Netting Status Code
					"RPAJCL," + // --> [Pos 084] Actual Date Invoice Closed
					"RPPTC," + // --> [Pos 085] Payment Terms Code
					"RPCOLL," + // --> [Pos 086] Collection Report (Y/N)
					"RPAFC," + // --> [Pos 087] Apply Finance Charges - Y/N
					"RPDNLT," + // --> [Pos 088] Delinquency Notice (Y/N)
					"RPODOC," + // --> [Pos 089] Document - Original
					"RPODCT," + // --> [Pos 090] Document Type - Original
					"RPOKCO," + // --> [Pos 091] Document Company (Original Order)
					"RPOSFX," + // --> [Pos 092] Document Pay Item - Original
					"RPRYIN," + // --> [Pos 093] Payment Instrument
					"RPAR01," + // --> [Pos 094] A/R Reporting Code 1
					"RPAR02," + // --> [Pos 095] A/R Reporting Code 2
					"RPAR03," + // --> [Pos 096] A/R Reporting Code 3
					"RPAR04," + // --> [Pos 097] A/R Reporting Code 4
					"RPAR05," + // --> [Pos 098] A/R Reporting Code 5
					"RPAR06," + // --> [Pos 099] A/R Reporting Code 6
					"RPAR07," + // --> [Pos 100] A/R Reporting Code 7
					"RPAR08," + // --> [Pos 101] A/R Reporting Code 8
					"RPAR09," + // --> [Pos 102] A/R Reporting Code 8
					"RPAR10," + // --> [Pos 103] A/R Reporting Code 10
					"RPATAD," + // --> [Pos 104] Amount - To Distribute
					"RPCTAD," + // --> [Pos 105] Amount - Currency To Distribute
					"RPERDJ," + // --> [Pos 106] Date - For Exchange Rate - Julian
					"RPURRF," + // --> [Pos 107] User Reserved Reference
					"RPRP2," + // --> [Pos 108] A/R - A/P - Miscellaneous Code 2
					"RPVOD," + // --> [Pos 109] Void Flag
					"RPPO," + // --> [Pos 110] Purchase Order
					"RPPOST," + // --> [Pos 111] G/L Posted Code
					"RPBCRC," + // --> [Pos 112] Currency Code - Base
					"RPDCTO," + // --> [Pos 113] Order Type ((OK))

					// Default Values
					"RPISTR," + // --> [Pos 114 (cadena)] A/R Post Status
					"RPDMCD," + // --> [Pos 115 (cadena)] Domestic Entry w/Mult Currency Distr
					"RPAID2," + // --> [Pos 116 (cadena)] Account ID
					"RPAM2," + // --> [Pos 117 (cadena)] Account Mode - G/L
					"RPOBJ," + // --> [Pos 118 (cadena)] Object Account
					"RPSUB," + // --> [Pos 119 (cadena)] Subsidiary
					"RPSBLT," + // --> [Pos 120 (cadena)] Subledger Type
					"RPSBL," + // --> [Pos 121 (cadena)] Subledger - G/L
					"RPNBRR," + // --> [Pos 122 (cadena)] Reminders - Number of Reminders to Send
					"RPRDRL," + // --> [Pos 123 (cadena)] Level of Last Sent Reminder
					"RPRMDS," + // --> [Pos 124 (numero)] Number of Sent Reminders - Total
					"RPCORC," + // --> [Pos 125 (cadena)] Collection Reason Code
					"RPRSCO," + // --> [Pos 126 (cadena)] Write-Off Reason Code
					"RPVINV," + // --> [Pos 127 (cadena)] Supplier Invoice Number
					"RPPDCT," + // --> [Pos 128 (cadena)] Document Type - Purchase Order
					"RPPKCO," + // --> [Pos 129 (cadena)] Document Company (Purchase Order)
					"RPSDCT," + // --> [Pos 130 (cadena)] Sales Document Type
					"RPSKCO," + // --> [Pos 131 (cadena)] Document Company (Sales Order)
					"RPSFXO," + // --> [Pos 132 (cadena)] Order Suffix
					"RPVR01," + // --> [Pos 133 (cadena)] Reference
					"RPUNIT," + // --> [Pos 134 (cadena)] Unit
					"RPMCU2," + // --> [Pos 135 (cadena)] Business Unit 2
					"RPRF," + // --> [Pos 136 (cadena)] Frequency - Recurring
					"RPDRF," + // --> [Pos 137 (numero)] Recurring Frequency # of Payments
					"RPFNLP," + // --> [Pos 138 (cadena)] Closed Item - As Of Processing
					"RPITM," + // --> [Pos 139 (numero)] Item Number - Short
					"RPU," + // --> [Pos 140 (numero)] Units
					"RPUM," + // --> [Pos 141 (cadena)] Unit of Measure
					"RPALT6," + // --> [Pos 142 (cadena)] G/L Posting Code - Cash Basis Acct
					"RPVDGJ," + // --> [Pos 143 (numero)] Void Date - For G/L - Julian
					"RPRP1," + // --> [Pos 144 (cadena)] A/R - A/P - Miscellaneous Code 1
					"RPRP3," + // --> [Pos 145 (cadena)] A/R - A/P - Cash Rcpts/Inv Reg Code
					"RPISTC," + // --> [Pos 146 (cadena)] A/R Post to Cash Management
					"RPURC1," + // --> [Pos 147 (cadena)] User Reserved Code
					"RPDDEX," + // --> [Pos 148 (cadena)] Deduction Reason Code
					"RPDTXS," + // --> [Pos 149 (cadena)] Deferred Tax Status - VAT
					"RPCLMG," + // --> [Pos 150 (cadena)] Collection Manager
					"RPCMGR," + // --> [Pos 151 (cadena)] Credit Manager
					"RPPRGF," + // --> [Pos 152 (cadena)] Purge Flag
					"RPGFL1," + // --> [Pos 153 (cadena)] Generic Flag 1
					"RPGFL2," + // --> [Pos 154 (cadena)] Generic Flag 2
					"RPKCOO," + // --> [Pos 155 (cadena)] Order Company (Order Number)
					"RPCTL," + // --> [Pos 156 (cadena)] Control/Statement Field
					"RPRMR1)" + // --> [Pos 157 (cadena)] Generic AR Receipt Matching Reference1

					"VALUES ";

			return sQuery;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	// Final de modificacion Francisco Landeros

	/**
	 * This create {@link Array} values
	 * 
	 * @param batchNumber
	 * @param totalAmountDr
	 * @param totalAmountCr
	 * @param payDate
	 * @param segmentCode
	 * @param clientType
	 * @param total
	 * @param glcrrm
	 * @return
	 */
	public static String createF03B11ValuesArray(String jdBranchId, String documentype, int billId, int clientId,
			String jdLineId, String userId, String softwareId, String clientName, String coin, float exchange,
			String sequence, int batchNumber, float totalImporteCr, float totalBalanceCr, float totalImporteCrNotIva,
			float totalIvaCr, float totalImporteDr, float totalBalanceDr, float totalImporteDrNotIva, float totalIvaDr,
			int payDate, ClientCreditType clientType) {

		String valueQuery = "('" + jdBranchId + "', " + // --> [Pos 001]
				"" + clientId + ", " + // --> [Pos 002]
				"'" + documentype + "', " + // --> [Pos 003]
				"" + billId + ", " + // --> [Pos 004]
				"'" + sequence + "', " + // --> [Pos 005]
				"" + FMUUtil.dateToJulian(new Date()) + ", " + // --> [Pos 006]
				"" + FMUUtil.dateToJulian(new Date()) + ", " + // --> [Pos 007]
				"" + Integer.toString(FMUUtil.getYearInt(new java.util.Date())).substring(2, 4) + ", " + // --> [Pos
																											// 008]
				"" + Integer.toString(FMUUtil.getYearInt(new java.util.Date())).substring(0, 2) + ", " + // --> [Pos
																											// 009]
				"" + FMUUtil.getMonthInt(new java.util.Date()) + ", " + // --> [Pos 010]
				"'" + jdBranchId + "', " + // --> [Pos 011]
				"'" + GLICUT + "', " + // --> [Pos 012]
				"" + batchNumber + ", " + // --> [Pos 013]
				"" + FMUUtil.dateToJulian(new Date()) + ", " + // --> [Pos 014]
				"" + clientId + ", " + // --> [Pos 015]
				"" + clientId + ", " + // --> [Pos 016]
				"" + clientId + ", " + // --> [Pos 017]
				"'" + "Y" + "', " + // --> [Pos 018]
				"'" + "A" + "', " + // --> [Pos 019]
				"" + String.valueOf(totalImporteCr) + ", " + // --> [Pos 020]
				"" + String.valueOf(totalImporteCr) + ", " + // --> [Pos 021]
				// "" + totalBalanceCr + ", " + // --> [Pos 021]
				"" + totalImporteCrNotIva + ", " + // --> [Pos 022]
				"" + totalIvaCr + ", " + // --> [Pos 023]
				"'" + (coin.equals(FMUUtil.COR_COIN_ID) ? FMUUtil.D_CA_LETTER : FMUUtil.F_CA_LETTER) + "', " + // -->
																												// [Pos
																												// 024]
				"'" + coin + "', " + // --> [Pos 025]
				"'" + (coin.equals(FMUUtil.US_COIN_ID) ? exchange : 0) + "', " + // --> [Pos 026]
				"" + String.valueOf(totalImporteDr) + ", " + // --> [Pos 027]
				"" + String.valueOf(totalImporteDr) + ", " + // --> [Pos 028]
				// "" + totalBalanceDr + ", " + // --> [Pos 028]
				"" + totalImporteDrNotIva + ", " + // --> [Pos 029]
				"" + totalIvaDr + ", " + // --> [Pos 030]
				"'" + "IMP" + "', " + // --> [Pos 031]
				"'" + "V" + "', " + // --> [Pos 032]
				"" + FMUUtil.dateToJulian(new Date()) + ", " + // --> [Pos 033]
				"'" + clientType.getA5ar() + "', " + // --> [Pos 034]
				"'" + "0" + "', " + // --> [Pos 035]
				"" + "0" + ", " + // --> [Pos 036]
				"'" + FMUUtil.getJdLineNumberSpace(jdLineId) + jdLineId + "', " + // --> [Pos 037]
				"" + payDate + ", " + // --> [Pos 038]
				"" + payDate + ", " + // --> [Pos 039]
				"'" + "" + "', " + // --> [Pos 040]
				"'" + clientName + "', " + // --> [Pos 041]
				"'" + userId + "', " + // --> [Pos 042]
				"'" + userId + "', " + // --> [Pos 043]
				"'" + softwareId + "', " + // --> [Pos 044]
				"" + FMUUtil.dateToJulian(new Date()) + ", " + // --> [Pos 045]
				"" + FMUUtil.getIntegerHour(new Date()) + ", " + // --> [Pos 046]
				"'" + userId + "'," + // --> [Pos 047]
				"'" + clientType.getCreditAccount() + "', " + // --> [Pos 048]
				"" + 0 + "," + // --> [Pos 049]
				"" + 0 + "," + // --> [Pos 050]
				"" + 0 + "," + // --> [Pos 051]
				"" + 0 + "," + // --> [Pos 052]
				"" + 0 + "," + // --> [Pos 053]
				"" + 0 + "," + // --> [Pos 054]
				"" + 0 + "," + // --> [Pos 055]
				"" + 0 + "," + // --> [Pos 056]
				"" + 0 + "," + // --> [Pos 057]
				"" + 0 + "," + // --> [Pos 058]
				"" + 0 + "," + // --> [Pos 059]
				"" + 0 + "," + // --> [Pos 060]
				"" + 0 + "," + // --> [Pos 061]
				"" + 0 + "," + // --> [Pos 062]
				"" + 0 + "," + // --> [Pos 063]
				"" + 0 + "," + // --> [Pos 064]
				"" + 0 + "," + // --> [Pos 065]
				"" + 0 + "," + // --> [Pos 066]
				"" + 0 + "," + // --> [Pos 067]
				"" + 0 + "," + // --> [Pos 068]
				"" + 0 + "," + // --> [Pos 069]
				"" + 0 + "," + // --> [Pos 070]
				"" + 0 + "," + // --> [Pos 071]
				"" + 0 + "," + // --> [Pos 072]
				"" + 0 + "," + // --> [Pos 073]
				"" + 0 + "," + // --> [Pos 074]
				"" + 0 + "," + // --> [Pos 075]
				"" + 0 + "," + // --> [Pos 076]
				"" + 1 + "," + // --> [Pos 077]
				"" + 0 + "," + // --> [Pos 078]
				"" + 0 + "," + // --> [Pos 079]
				"" + 0 + "," + // --> [Pos 080]
				"" + 0 + "," + // --> [Pos 081]
				"" + 0 + "," + // --> [Pos 082]
				"" + 0 + "," + // --> [Pos 083]
				"" + 0 + "," + // --> [Pos 084]
				"'" + clientType.getCreditCode() + "'," + // --> [Pos 085] // Payment termns code
				"'" + clientType.getAicoll() + "'," + // --> [Pos 086]
				"'" + clientType.getAiafc() + "'," + // --> [Pos 087]
				"'" + clientType.getAidnlt() + "'," + // --> [Pos 088]
				"" + billId + "," + // --> [Pos 089]
				"'" + documentype + "'," + // --> [Pos 090]
				"'" + jdBranchId + "'," + // --> [Pos 091]
				"'" + sequence + "'," + // --> [Pos 092]
				"'" + clientType.getAiryin() + "'," + // --> [Pos 093]
				"'" + clientType.getAiac01() + "'," + // --> [Pos 094]
				"'" + clientType.getAiac02() + "'," + // --> [Pos 095]
				"'" + clientType.getAiac03() + "'," + // --> [Pos 096]
				"'" + clientType.getAiac04() + "'," + // --> [Pos 097]
				"'" + clientType.getAiac05() + "'," + // --> [Pos 098]
				"'" + clientType.getAiac06() + "'," + // --> [Pos 099]
				"'" + clientType.getAiac07() + "'," + // --> [Pos 100]
				"'" + clientType.getAiac08() + "'," + // --> [Pos 101]
				"'" + clientType.getAiac09() + "'," + // --> [Pos 102]
				"'" + clientType.getAiac10() + "'," + // --> [Pos 103]
				"" + totalImporteCrNotIva + ", " + // --> [Pos 104] // Change
				"" + totalImporteDrNotIva + "," + // --> [Pos 105]
				"" + (coin.equals(FMUUtil.US_COIN_ID) ? FMUUtil.dateToJulian(new Date()) : 0) + "," + // --> [Pos 106]
				"'" + "" + "'," + // --> [Pos 107]
				"'" + "" + "'," + // --> [Pos 108]
				"'" + "" + "'," + // --> [Pos 109]
				"'" + "" + "'," + // --> [Pos 110]
				"'" + "" + "'," + // --> [Pos 111]
				"'" + FMUUtil.COR_COIN_ID + "'," + // --> [Pos 112]
				"'" + "" + "'," + // --> [Pos 113]

				// Default Values
				"'" + "" + "'," + // --> [Pos 114]
				"'" + "" + "'," + // --> [Pos 115]
				"'" + "" + "'," + // --> [Pos 116]
				"'" + "" + "'," + // --> [Pos 117]
				"'" + "" + "'," + // --> [Pos 118]
				"'" + "" + "'," + // --> [Pos 119]
				"'" + "" + "'," + // --> [Pos 120]
				"'" + "" + "'," + // --> [Pos 121]
				"'" + "" + "'," + // --> [Pos 122]
				"'" + "" + "'," + // --> [Pos 123]
				"'" + 0 + "'," + // --> [Pos 124]
				"'" + "" + "'," + // --> [Pos 125]
				"'" + "" + "'," + // --> [Pos 126]
				"'" + "" + "'," + // --> [Pos 127]
				"'" + "" + "'," + // --> [Pos 128]
				"'" + "" + "'," + // --> [Pos 129]
				"'" + "" + "'," + // --> [Pos 130]
				"'" + "" + "'," + // --> [Pos 131]
				"'" + "" + "'," + // --> [Pos 132]
				"'" + "" + "'," + // --> [Pos 133]
				"'" + "" + "'," + // --> [Pos 134]
				"'" + "" + "'," + // --> [Pos 135]
				"'" + "" + "'," + // --> [Pos 136]
				"'" + 0 + "'," + // --> [Pos 137]
				"'" + "" + "'," + // --> [Pos 138]
				"'" + 0 + "'," + // --> [Pos 139]
				"'" + 0 + "'," + // --> [Pos 140]
				"'" + "" + "'," + // --> [Pos 141]
				"'" + "" + "'," + // --> [Pos 142]
				"'" + 0 + "'," + // --> [Pos 143]
				"'" + "" + "'," + // --> [Pos 144]
				"'" + "" + "'," + // --> [Pos 145]
				"'" + "" + "'," + // --> [Pos 146]
				"'" + "" + "'," + // --> [Pos 147]
				"'" + "" + "'," + // --> [Pos 148]
				"'" + "" + "'," + // --> [Pos 149]
				"'" + "" + "'," + // --> [Pos 150]
				"'" + "" + "'," + // --> [Pos 151]
				"'" + "" + "'," + // --> [Pos 152]
				"'" + "" + "'," + // --> [Pos 153]
				"'" + "" + "'," + // --> [Pos 154]
				"'" + "" + "'," + // --> [Pos 155]
				"'" + "" + "'," + // --> [Pos 156]
				"'" + "" + "')"; // --> [Pos 157]

		return valueQuery;
	}

	private static String getHeaderF03B13Insert() {

		String sQuery = "INSERT INTO " + CollectionScheme.SchemeJDE + ".F03B13 (" + "RYPYID," + // --> [Pos 01] Sequence
																								// Number
				"RYCKNU," + // --> [Pos 02] Concept
				"RYAN8," + // --> [Pos 03] Client Id
				"RYPYR," + // --> [Pos 04] CLient Id
				"RYDMTJ," + // --> [Pos 05] Date Julian
				"RYDGJ," + // --> [Pos 06] Date Julian
				"RYVLDT," + // --> [Pos 07] 0
				"RYCTRY," + // --> [Pos 08] Date Integer
				"RYFY," + // --> [Pos 09] Date Integer
				"RYPN," + // --> [Pos 10] Date Integer
				"RYCO," + // --> [Pos 11] BranchID
				"RYICUT," + // --> [Pos 12] Doc Type
				"RYICU," + // --> [Pos 13] BATCH number
				"RYDICJ," + // --> [Pos 14] Date Julian
				"RYPA8," + // --> [Pos 15] ClientId
				"RYCKAM," + // --> [Pos 16] Amount CR
				"RYAAP," + // --> [Pos 17] Cero
				"RYBCRC," + // --> [Pos 18] COR Coin
				"RYCRRM," + // --> [Pos 19] Coin depends
				"RYCRCD," + // --> [Pos 20] Coin payment Metod
				"RYCRR," + // --> [Pos 21] Exchange Rate
				"RYERDJ," + // --> [Pos 22] Date julian --> [Pos 22 : Este campo debe llenarse cuando el
							// recibo es moneda extranjera, corresponde a la fecha del Tipo de cambio. (PD:
							// Hcisne)]
				"RYCRCM," + // --> [Pos 23] Y
				"RYCRR1," + // --> [Pos 24] 0
				"RYCRR2," + // --> [Pos 25] 0
				"RYFCAM," + // --> [Pos 26] Amount
				"RYFAP," + // --> [Pos 27] 0
				"RYGLBA," + // --> [Pos 28] (-) select * from testdta.f0901 where gmaid = 20068904;
				"RYAM," + // --> [Pos 29] 2
				"RYTYIN," + // --> [Pos 30] Metodo d pago ID
				"RYEXR," + // --> [Pos 31] Text receipt, --> [Pos 31 : Este campo debe de llenarse y su
							// valor debe ser igual que el campo RZRMK del Archivo F03b14. (PD: Hcisne)]
				"RYALPH," + // --> [Pos 32] ClientName
				"RYDOCG," + // --> [Pos 33] 0
				"RYARS," + // --> [Pos 34] 0
				"RYTORG," + // --> [Pos 35] User ID
				"RYUSER," + // --> [Pos 36] USer Id
				"RYPID," + // --> [Pos 36] Sof ID
				"RYUPMJ," + // --> [Pos 38] Date Julian
				"RYUPMT," + // --> [Pos 39] HOUR - p
				"RYJOBN," + // --> [Pos 40] SOf Id
				"RYPOST," + // --> [Pos 41]

				// Default Values
				"RYISTR," + // --> [Pos 42] cadena
				"RYISTC," + // --> [Pos 43] cadena
				"RYEULP," + // --> [Pos 44] cadena --> [Pos 44 : Cuando son recibos que se aplican contra
							// facturas y no son recibos no aplicados, este campo debe dejarse en Blanco.
							// (PD: Hcisne)]
				"RYGLC," + // --> [Pos 45] cadena --> [Pos 45 : Cuando son recibos que se aplican contra
							// facturas y no son recibos no aplicados, este campo debe dejarse en Blanco.
							// (PD: Hcisne)]
				"RYAID," + // --> [Pos 46] cadena
				"RYALT6," + // --> [Pos 47] cadena
				"RYRYIN," + // --> [Pos 48] cadena
				"RYBKTR," + // --> [Pos 49] cadena
				"RYDCTG," + // --> [Pos 50] cadena
				"RYKCOG," + // --> [Pos 51] cadena
				"RYVDGJ," + // --> [Pos 52] numero
				"RYVRE," + // --> [Pos 53] cadena
				"RYNFVD," + // --> [Pos 54] cadena
				"RYDOCQ," + // --> [Pos 55] numero
				"RYDCTQ," + // --> [Pos 56] cadena
				"RYKCOQ," + // --> [Pos 57] cadena
				"RYICTQ," + // --> [Pos 58] cadena
				"RYICUQ," + // --> [Pos 59] numero
				"RYDIQJ," + // --> [Pos 60] numero
				"RYPSTQ," + // --> [Pos 61] cadena
				"RYCBNK," + // --> [Pos 62] cadena
				"RYTNST," + // --> [Pos 63] cadena
				"RYDKC," + // --> [Pos 64] numero (-)
				"RYATCS," + // --> [Pos 65] cadena
				"RYEAAC," + // --> [Pos 66] cadena
				"RYEUFB," + // --> [Pos 67] cadena
				"RYECLK," + // --> [Pos 68] cadena
				"RYARL," + // --> [Pos 69] cadena
				"RYALGO," + // --> [Pos 70] cadena
				"RYVERS," + // --> [Pos 71] cadena
				"RYASTA," + // --> [Pos 72] cadena
				"RYDDST," + // --> [Pos 73] cadena
				"RYRREF," + // --> [Pos 74] cadena
				"RYRRID," + // --> [Pos 75] numero (-)
				"RYDCDS," + // --> [Pos 76] cadena
				"RYDREG," + // --> [Pos 77] cadena
				"RYURC1," + // --> [Pos 78] cadena
				"RYURDT," + // --> [Pos 79] numero (-)
				"RYURAT," + // --> [Pos 80] numero
				"RYURAB," + // --> [Pos 81] numero
				"RYURRF," + // --> [Pos 82] cadena (-)
				"RYGFL1," + // --> [Pos 83] cadena
				"RYPRGF," + // --> [Pos 84] cadena
				"RYRNID," + // --> [Pos 85] numero (-)
				"RYCUID," + // --> [Pos 86] cadena
				"RYVFY," + // --> [Pos 87] numero
				"RYVFP," + // --> [Pos 88] numero
				"RYVFC," + // --> [Pos 89] numero (-)
				"RYOMOD," + // --> [Pos 90] cadena
				"RYMIP," + // --> [Pos 91] cadena
				"RYLRFL," + // --> [Pos 92] cadena
				"RYGFL2," + // --> [Pos 93] cadena
				"RYNETTCID," + // --> [Pos 94] numero
				"RYNETDOC," + // --> [Pos 95] numero
				"RYRCND," + // --> [Pos 96] cadena
				"RYR3)" + // --> [Pos 97] cadena

				" VALUES ";

		return sQuery;

	}

	public static String createF03B13ValuesArray(int sequenceNumber, int clientId, String branchId, String coin,
			float exchange, String amount, String textReceipt, String clientName, String userId, String softwareId,
			int batchNumber, String amountCR, String cashAccount, int receiptNumber) {

		String valueQuery = "(" + sequenceNumber + ", " + // // --> [Pos 01 (RYPYID)]
				"" + receiptNumber + ", " + // --> [Pos 02 (RYCKNU)]
				"" + clientId + ", " + // --> [Pos 03 (RYAN8)]
				"" + clientId + ", " + // --> [Pos 04 (RYPYR)]
				"" + FMUUtil.dateToJulian(new Date()) + ", " + // --> [Pos 05 (RYDMTJ)]
				"" + FMUUtil.dateToJulian(new Date()) + ", " + // --> [Pos 06 (RYDGJ)]
				"" + 0 + ", " + // --> [Pos 07 (RYVLDT)]
				"" + Integer.toString(FMUUtil.getYearInt(new java.util.Date())).substring(0, 2) + ", " + // --> [Pos 08
																											// (RYCTRY)]
				"" + Integer.toString(FMUUtil.getYearInt(new java.util.Date())).substring(2, 4) + ", " + // --> [Pos 09
																											// (RYFY)]
				"" + FMUUtil.getMonthInt(new java.util.Date()) + ", " + // --> [Pos 10 (RYPN)]
				"'" + branchId + "', " + // --> [Pos 11 (RYCO)]
				"'" + RPYICUT + "', " + // --> [Pos 12 (RYICUT)]
				"" + batchNumber + ", " + // --> [Pos 13 (RYICU)]
				"" + FMUUtil.dateToJulian(new Date()) + ", " + // --> [Pos 14 (RYDICJ)]
				"" + clientId + ", " + // --> [Pos 15 (RYPA8)]
				"" + amountCR + ", " + // --> [Pos 16 (RYCKAM)]
				"" + 0 + ", " + // --> [Pos 17 (RYAAP)]
				"'" + (coin.equals(FMUUtil.US_COIN_ID) ? FMUUtil.COR_COIN_ID : FMUUtil.COR_COIN_ID) + "', " + // -->
																												// [Pos
																												// 18
																												// (RYBCRC)]
				"'" + (coin.equals(FMUUtil.US_COIN_ID) ? "F" : "D") + "', " + // --> [Pos 19 (RYCRRM)]
				"'" + coin + "', " + // --> [Pos 20 (RYCRCD)]
				"" + exchange + ", " + // --> [Pos 21 (RYCRR)]
				"" + FMUUtil.dateToJulian(new Date()) + ", " + // --> [Pos 22 (RYERDJ) : Este campo debe llenarse cuando
																// el recibo es moneda extranjera, corresponde a la
																// fecha del Tipo de cambio. (PD: Hcisne)]
				"'" + (coin.equals(FMUUtil.US_COIN_ID) ? "Y" : "") + "', " + // --> [Pos 23 (RYCRCM)]
				"" + 0 + ", " + // --> [Pos 24 (RYCRR1)]
				"" + 0 + ", " + // --> [Pos 25 (RYCRR2)]
				"" + amount + ", " + // --> [Pos 26 (RYFCAM)]
				"" + 0 + ", " + // --> [Pos 27 (RYFAP)]
				"'" + cashAccount + "', " + // --> [Pos 28 (RYGLBA)]
				"" + 2 + ", " + // --> [Pos 29 (RYAM)]
				"'" + "A" + "', " + // --> [Pos 30 (RYTYIN)]
				"'" + textReceipt + "', " + // [Pos 31 (RYEXR) : Este campo debe de llenarse y su valor debe ser igual
											// que el campo RZRMK del Archivo F03b14. (PD: Hcisne)]
				"'" + clientName + "', " + // --> [Pos 32 (RYALPH)]
				"" + 0 + ", " + // --> [Pos 33 (RYDOCG)]
				"" + 0 + ", " + // --> [Pos 34 (RYARS)]
				"'" + userId + "', " + // --> [Pos 35 (RYTORG)]
				"'" + userId + "', " + // --> [Pos 36 (RYUSER)]
				"'" + softwareId + "', " + // --> [Pos 37 (RYPID)]
				"" + FMUUtil.dateToJulian(new Date()) + ", " + // --> [Pos 38 (RYUPMJ)]
				"" + FMUUtil.getIntegerHour(new Date()) + ", " + // --> [Pos 39 (RYUPMT)]
				"'" + softwareId + "'," + // --> [Pos 40 (RYJOBN)]
				"'" + "" + "'," + // --> [Pos 41 (RYPOST)]

				// Default Values
				"'" + "" + "', " + // cadena --> [Pos 42 (RYISTR)]
				"'" + "" + "', " + // cadena --> [Pos 43 (RYISTC)]
				"'" + "" + "', " + // cadena --> [Pos 44 (RYEULP) : Cuando son recibos que se aplican contra
									// facturas y no son recibos no aplicados, este campo debe dejarse en Blanco.
									// (PD: Hcisne)]
				"'" + "" + "', " + // cadena --> [Pos 45 (RYGLC) : Cuando son recibos que se aplican contra
									// facturas y no son recibos no aplicados, este campo debe dejarse en Blanco.
									// (PD: Hcisne)]
				"'" + "" + "', " + // cadena --> [Pos 46 (RYAID)]
				"'" + "" + "', " + // cadena --> [Pos 47 (RYALT6)]
				"'" + "" + "', " + // cadena --> [Pos 48 (RYRYIN)]
				"'" + "" + "', " + // cadena --> [Pos 49 (RYBKTR)]
				"'" + "" + "', " + // cadena --> [Pos 50 (RYDCTG)]
				"'" + "" + "', " + // cadena --> [Pos 51 (RYKCOG)]
				"" + 0 + ", " + // numero --> [Pos 52 (RYVDGJ)]
				"'" + "" + "', " + // cadena --> [Pos 53 (RYVRE)]
				"'" + "" + "', " + // cadena --> [Pos 54 (RYNFVD)]
				"" + 0 + ", " + // numero --> [Pos 55 (RYDOCQ)]
				"'" + "" + "', " + // cadena --> [Pos 56 (RYDCTQ)]
				"'" + "" + "', " + // cadena --> [Pos 57 (RYKCOQ)]
				"'" + "" + "', " + // cadena --> [Pos 58 (RYICTQ)]
				"" + 0 + ", " + // numero --> [Pos 59 (RYICUQ)]
				"" + 0 + ", " + // numero --> [Pos 60 (RYDIQJ)]
				"'" + "" + "', " + // cadena --> [Pos 61 (RYPSTQ)]
				"'" + "" + "', " + // cadena --> [Pos 62 (RYCBNK)]
				"'" + "" + "', " + // cadena --> [Pos 63 (RYTNST)]
				"" + 0 + ", " + // numero --> [Pos 64 (RYDKC)]
				"'" + "" + "', " + // cadena --> [Pos 65 (RYATCS)]
				"'" + "" + "', " + // cadena --> [Pos 66 (RYEAAC)]
				"'" + "" + "', " + // cadena --> [Pos 67 (RYEUFB)]
				"'" + "" + "', " + // cadena --> [Pos 68 (RYECLK)]
				"'" + "" + "', " + // cadena --> [Pos 69 (RYARL)]
				"'" + "" + "', " + // cadena --> [Pos 70 (RYALGO)]
				"'" + "" + "', " + // cadena --> [Pos 71 (RYVERS)]
				"'" + "" + "', " + // cadena --> [Pos 72 (RYASTA)]
				"'" + "" + "', " + // cadena --> [Pos 73 (RYDDST)]
				"'" + "" + "', " + // cadena --> [Pos 74 (RYRREF)]
				"" + 0 + ", " + // numero --> [Pos 75 (RYRRID)]
				"'" + "" + "', " + // cadena --> [Pos 76 (RYDCDS)]
				"'" + "" + "', " + // cadena --> [Pos 77 (RYDREG)]
				"'" + "" + "', " + // cadena --> [Pos 78 (RYURC1)]
				"" + 0 + ", " + // numero --> [Pos 79 (RYURDT)]
				"" + 0 + ", " + // numero --> [Pos 80 (RYURAT)]
				"" + 0 + ", " + // numero --> [Pos 81 (RYURAB)]
				"'" + "" + "', " + // cadena --> [Pos 82 (RYURRF)]
				"'" + "" + "', " + // cadena --> [Pos 83 (RYGFL1)]
				"'" + "" + "', " + // cadena --> [Pos 84 (RYPRGF)]
				"" + 0 + ", " + // numero --> [Pos 85 (RYRNID)]
				"'" + "" + "', " + // cadena --> [Pos 86 (RYCUID)]
				"" + 0 + ", " + // numero --> [Pos 87 (RYVFY)]
				"" + 0 + ", " + // numero --> [Pos 88 (RYVFP)]
				"" + 0 + ", " + // numero --> [Pos 89 (RYVFC)]
				"'" + "" + "', " + // cadena --> [Pos 90 (RYOMOD)]
				"'" + "" + "', " + // cadena --> [Pos 91 (RYMIP)]
				"'" + "" + "', " + // cadena --> [Pos 92 (RYLRFL)]
				"'" + "" + "', " + // cadena --> [Pos 93 (RYGFL2)]
				"" + 0 + ", " + // numero --> [Pos 94 (RYNETTCID)]
				"" + 0 + ", " + // numero --> [Pos 96 (RYNETDOC)]
				"'" + "" + "', " + // cadena --> [Pos 96 (RYRCND)]
				"'" + "" + "')"; // cadena --> [Pos 97 (RYR3)]

		return valueQuery;
	}

	private static String getHeaderF03B14Insert() {

		String sQuery = "INSERT INTO " + CollectionScheme.SchemeJDE + ".F03B14 (" + "RZPYID," + // --> [Pos 001] f03b13
																								// ID
				"RZRC5," + // --> [Pos 002] Secuence item number
				"RZDOC," + // --> [Pos 003] Bill Id
				"RZDCT," + // --> [Pos 004] Bill Doc Type
				"RZKCO," + // --> [Pos 005] Branch ID
				"RZSFX," + // --> [Pos 006] fee number
				"RZAN8," + // --> [Pos 007] clientId
				"RZDCTM," + // --> [Pos 008] RC type
				"RZDMTJ," + // --> [Pos 009] JUlian Date
				"RZDGJ," + // --> [Pos 010] Julian Date
				"RZAID," + // --> [Pos 011] account BIll
				"RZCTRY," + // --> [Pos 012] Julian Date
				"RZFY," + // --> [Pos 013] Julian Date
				"RZPN," + // --> [Pos 014] Julian Date
				"RZCO," + // --> [Pos 015] BanchId bill
				"RZICUT," + // --> [Pos 016] batch type
				"RZICU," + // --> [Pos 017] batch number
				"RZDICJ," + // --> [Pos 018] julian date
				"RZPA8," + // --> [Pos 019] client Id
				"RZRPID," + // --> [Pos 020] Payment Id
				"RZRLIN," + // --> [Pos 021] 0
				"RZPAAP," + // --> [Pos 022] Amount CR (Bill amount conversion with payment method exchange)
				"RZBCRC," + // --> [Pos 023] COR ------
				"RZCRRM," + // --> [Pos 024] F
				"RZCRCD," + // --> [Pos 025] USD
				"RZCRR," + // --> [Pos 026] exchange
				"RZPFAP," + // --> [Pos 027] dolar amount (bill Amount)
				"RZAGL," + // --> [Pos 028] DIFERENCIAL CAMBIARO - PENDIENTE
				"RZAIDT," + // --> [Pos 029] DIFERENCIAL CAMBARIO - PENDIENTE (CUENTA DIFERENCIAL)
				"RZTCRC," + // --> [Pos 030] COIN BILL -->
				"RZTAAP," + // --> [Pos 031] dolar amount -->
				"RZACRR," + // --> [Pos 032] 0 -->
				"RZACR1," + // --> [Pos 033] 0 -->
				"RZACR2," + // --> [Pos 034] 0 -->
				"RZTYIN," + // --> [Pos 035]
				"RZUTIC," + // --> [Pos 036]
				"RZMCU," + // --> [Pos 037] Line Id
				"RZRMK," + // --> [Pos 038] Text receipt
				"RZHCRR," + // --> [Pos 039] exchange
				"RZPDLT, " + // --> [Pos 040] IsPayComplete
				"RZDDJ, " + // --> [Pos 041] payDate
				"RZDDNJ," + // --> [Pos 042] payDate
				"RZIDGJ," + // --> [Pos 043] julian date
				"RZTORG," + // --> [Pos 044] USER
				"RZUSER, " + // --> [Pos 045] USER
				"RZPID," + // --> [Pos 046] soft
				"RZUPMJ," + // --> [Pos 047] julia date
				"RZUPMT," + // --> [Pos 048] HOUR
				"RZJOBN," + // --> [Pos 049] SOF
				"RZCKNU," + // --> [Pos 050] Receipt Number
				"RZPOST," + // --> [Pos 051] G/L Posted Code
				"RZGLC," + // --> [Pos 052] G/L Offset
				// Default values
				"RZADSC," + // --> [Pos 053] numero Discount Available
				"RZADSA," + // --> [Pos 054] numero Discount Taken
				"RZAAAJ," + // --> [Pos 055] numero Amount - Write Off
				"RZECBA," + // --> [Pos 056] numero Amount - Chargeback
				"RZDDA," + // --> [Pos 057] numero Amount - Deduction
				"RZCDS," + // --> [Pos 058] numero Amount - Foreign Discount Available
				"RZCDSA," + // --> [Pos 059] numero Amount - Foreign Discount Taken
				"RZFCHG," + // --> [Pos 060] numero Amount - Foreign Changed Amount
				"RZECBF," + // --> [Pos 061] numero Amount - Foreign Chargeback
				"RZFDA," + // --> [Pos 062] numero Amount - Foreign Deduction
				"RZTADA," + // --> [Pos 063] numero Transaction Discount Amount
				"RZTAAJ," + // --> [Pos 064] numero Transaction Write Off Amount
				"RZTCBA," + // --> [Pos 065] numero Transaction Charge Back Amount
				"RZTDA," + // --> [Pos 066] numero Transaction Deduction Amount
				"RZACRM," + // --> [Pos 067] cadena Alt Currency Conversion Y/Z
				"RZAGLA," + // --> [Pos 068] numero Alternate Currency Gain/Loss
				"RZAIDA," + // --> [Pos 069] cadena Alt Curr Gain/Loss Account ID
				"RZRSCO," + // --> [Pos 070] cadena Write-Off Reason Code
				"RZAIDW," + // --> [Pos 071] cadena Write-Off Account ID
				"RZECBR," + // --> [Pos 072] cadena Chargeback Reason Code
				"RZGLCC," + // --> [Pos 073] cadena G/L Offset Chargebacks
				"RZAIDC," + // --> [Pos 074] cadena Chargeback Account ID
				"RZDDEX," + // --> [Pos 075] cadena Deduction Reason Code
				"RZDAID," + // --> [Pos 076] cadena Deduction Account ID
				"RZUCTF," + // --> [Pos 077] cadena Unapplied Cash Transfer
				"RZAID2," + // --> [Pos 078] cadena Account ID
				"RZAM2," + // --> [Pos 079] cadena Account Mode - G/L
				"RZSBL," + // --> [Pos 080] cadena Subledger - G/L
				"RZSBLT," + // --> [Pos 081] cadena Subledger Type
				"RZPKCO," + // --> [Pos 082] cadena Document Company (Purchase Order)
				"RZPO," + // --> [Pos 083] cadena Purchase Order
				"RZPDCT," + // --> [Pos 084] cadena Document Type - Purchase Order
				"RZNUMB," + // --> [Pos 085] numero Asset Item Number
				"RZUNIT," + // --> [Pos 086] cadena Unit
				"RZMCU2," + // --> [Pos 087] cadena Business Unit 2
				"RZFNLP," + // --> [Pos 088] cadena Closed Item - As Of Processing
				"RZALT6," + // --> [Pos 089] cadena G/L Posting Code - Cash Basis Acct
				"RZODOC," + // --> [Pos 090] numero Document - Original
				"RZODCT," + // --> [Pos 091] cadena Document Type - Original
				"RZOKCO," + // --> [Pos 092] cadena Document Company (Original Order)
				"RZOSFX," + // --> [Pos 093] cadena Document Pay Item - Original
				"RZGDOC," + // --> [Pos 094] numero Deduction Document Number
				"RZGDCT," + // --> [Pos 095] cadena Deduction Document Type
				"RZGKCO," + // --> [Pos 096] cadena Deduction Document Company
				"RZGSFX," + // --> [Pos 097] cadena Deduction Document Pay Item
				"RZDCTG," + // --> [Pos 098] cadena Document Type - JE
				"RZDOCG," + // --> [Pos 099] numero Document Number - JE
				"RZKCOG," + // --> [Pos 100] cadena Document Company - JE
				"RZCTL," + // --> [Pos 101] cadena Control/Statement Field
				"RZSMTJ," + // --> [Pos 102] numero Date - Statement
				"RZVDGJ," + // --> [Pos 103] numero Void Date - For G/L - Julian
				"RZVRE," + // --> [Pos 104] cadena Void Reason Code
				"RZNFVD," + // --> [Pos 105] cadena Receipt NSF/Void Code
				"RZISTC," + // --> [Pos 106] cadena A/R Post to Cash Management
				"RZDDST," + // --> [Pos 107] cadena Draft Status
				"RZVR01," + // --> [Pos 108] cadena Reference
				"RZRFID," + // --> [Pos 109] numero Reference ID (Internal)
				"RZRIDC," + // --> [Pos 110] cadena Reference ID Code
				"RZPRGF," + // --> [Pos 111] cadena Purge Flag
				"RZGFL1," + // --> [Pos 112] cadena Generic Flag 1
				"RZRNID," + // --> [Pos 113] numero Batch Run ID (Internal)
				"RZURAB," + // --> [Pos 114] numero User Reserved Number
				"RZURAT," + // --> [Pos 115] numero User Reserved Amount
				"RZURC1," + // --> [Pos 116] cadena User Reserved Code
				"RZURDT," + // --> [Pos 117] numero User Reserved Date
				"RZURRF," + // --> [Pos 118] cadena User Reserved Reference
				"RZSHPN," + // --> [Pos 119] numero Shipment Numbe
				"RZOMOD," + // --> [Pos 120] cadena Originating System
				"RZDOCO," + // --> [Pos 121] numero Document (Order No Invoice etc.)
				"RZRASI," + // --> [Pos 122] cadena Rounding Account Short ID
				"RZSFXO," + // --> [Pos 123] cadena Order Suffix
				"RZKCOO," + // --> [Pos 124] cadena Order Company (Order Number)
				"RZDCTO," + // --> [Pos 125] cadena Order Type
				"RZRAMT," + // --> [Pos 126] numero Rounding Amount
				"RZLRFL," + // --> [Pos 127] cadena Localization Reserved Flag
				"RZGFL2," + // --> [Pos 128] cadena Generic Flag 2
				"RZDRCO," + // --> [Pos 129] cadena Discount Reason Code
				"RZLFCJ," + // --> [Pos 130] numero Date - Last Fee Calculated (Julian)
				"RZAIDD," + // --> [Pos 131] cadena Discount Account ID
				"RZNETTCID," + // --> [Pos 132] numero Netting Transaction ID
				"RZNETDOC," + // --> [Pos 133] numero Netting Document Number
				"RZNETRC5," + // --> [Pos 134] numero Netting Line ID
				"RZADGJ)" + // --> [Pos 135] numero Actual Receipt Date

				"VALUES ";

		return sQuery;
	}

	public static String createF03B14ValuesArray(int paymentMethodId, int billId, String billType, String branchId,
			String lineId, String feeNumber, int clientId, int batchNumber, String coin, String userId,
			String softwareId, String receiptTxt, String billAccount, float amountCR, float exchange, float amountDR,
			int secuenceItemNumber, int payDate, String surpluxAccount, String surpluxDiffAmount,
			boolean isCancelComplete, int receiptNumber, String clientType, float historicalExchangeRate) {

		String valueQuery = "(" + paymentMethodId + ", " + // --> [Pos 001 (RZPYID)]
				" " + secuenceItemNumber + ", " + // --> [Pos 002 (RZRC5)]
				" " + billId + ", " + // --> [Pos 003 (RZDOC)]
				"'" + billType + "', " + // --> [Pos 004 (RZDCT)]
				"'" + branchId + "', " + // --> [Pos 005 (RZKCO)]
				"'" + feeNumber + "', " + // --> [Pos 006 (RZSFX)]
				" " + clientId + ", " + // --> [Pos 007 (RZAN8)]
				"'" + RPDCTM + "', " + // --> [Pos 008 (RZDCTM)]
				" " + FMUUtil.dateToJulian(new Date()) + ", " + // --> [Pos 009 (RZDMTJ)]
				" " + FMUUtil.dateToJulian(new Date()) + ", " + // --> [Pos 010 (RZDGJ)]
				"'" + billAccount + "', " + // --> [Pos 011 (RZAID)]
				" " + Integer.toString(FMUUtil.getYearInt(new java.util.Date())).substring(0, 2) + ", " + // --> [Pos
																											// 012
																											// (RZCTRY)]
				" " + Integer.toString(FMUUtil.getYearInt(new java.util.Date())).substring(2, 4) + ", " + // --> [Pos
																											// 013
																											// (RZFY)]
				" " + FMUUtil.getMonthInt(new java.util.Date()) + ", " + // --> [Pos 014 (RZPN)]
				"'" + branchId + "', " + // --> [Pos 015 (RZCO)]
				"'" + RPYICUT + "', " + // --> [Pos 016 (RZICUT)]
				" " + batchNumber + ", " + // --> [Pos 017 (RZICU)]
				" " + FMUUtil.dateToJulian(new Date()) + ", " + // --> [Pos 018 (RZDICJ)]
				" " + clientId + ", " + // --> [Pos 019 (RZPA8)]
				" " + paymentMethodId + ", " + // --> [Pos 020 (RZRPID)]
				" " + 0 + ", " + // --> [Pos 021 (RZRLIN)]
				" " + amountCR + ", " + // --> [Pos 022 (RZPAAP)]
				"'" + (coin.equals(FMUUtil.US_COIN_ID) ? FMUUtil.COR_COIN_ID : FMUUtil.COR_COIN_ID) + "', " + // -->
																												// [Pos
																												// 023
																												// (RZBCRC)]
				"'" + (coin.equals(FMUUtil.US_COIN_ID) ? "F" : "D") + "', " + // --> [Pos 024 (RZCRRM)]
				"'" + coin + "', " + // --> [Pos 025 (RZCRCD)]
				" " + exchange + ", " + // --> [Pos 026 (RZCRR)]
				" " + amountDR + ", " + // --> [Pos 027 (RZPFAP)]
				"'" + surpluxDiffAmount + "', " + // DIFERENCIAL CAMBIARO // --> [Pos 028 (RZAGL)]
				"'" + surpluxAccount + "', " + // DIFERENCIAL CAMBIARO CUENTA // --> [Pos 029 (RZAIDT)]
				"'" + coin + "', " + // --> [Pos 030 (RZTCRC)]
				" " + (coin.equals(FMUUtil.US_COIN_ID) ? amountDR : amountCR) + ", " + // --> [Pos 031 (RZTAAP)]
				" " + 0 + ", " + // --> [Pos 032 (RZACRR)]
				" " + 0 + ", " + // --> [Pos 033 (RZACR1)]
				" " + 0 + ", " + // --> [Pos 034 (RZACR2)]
				"'" + "A" + "', " + // --> [Pos 035 (RZTYIN)]
				" " + 10 + ", " + // --> [Pos 036 (RZUTIC)]
				"'" + FMUUtil.getJdLineNumberSpace(lineId) + lineId + "', " + // --> [Pos 037 (RZMCU)]
				"'" + receiptTxt + "', " + // --> [Pos 038 (RZRMK)]
				
				//" " + exchange + ", " + // --> [Pos 039 (RZHCRR)]
				" " + historicalExchangeRate + ", " + /** Mod: set bill exchange rate for historical and gain/loss calculate 2020-08-19 ch*/ // --> [Pos 039 (RZHCRR)] 
				
				
				" " + (isCancelComplete ? 0 : 1) + ", " + // --> [Pos 040 (RZPDLT)]
				" " + payDate + ", " + // --> [Pos 041 (RZDDJ)]
				" " + payDate + ", " + // --> [Pos 042 (RZDDNJ)]
				" " + FMUUtil.dateToJulian(new Date()) + ", " + // --> [Pos 043 (RZIDGJ)]
				"'" + userId + "', " + // --> [Pos 044 (RZTORG)]
				"'" + userId + "', " + // --> [Pos 045 (RZUSER)]
				"'" + softwareId + "', " + // --> [Pos 046 (RZPID)]
				" " + FMUUtil.dateToJulian(new Date()) + ", " + // --> [Pos 047 (RZUPMJ)]
				" " + FMUUtil.getIntegerHour(new Date()) + ", " + // --> [Pos 048 (RZUPMT)]
				"'" + softwareId + "'," + // --> [Pos 049 (RZJOBN)]
				"'" + receiptNumber + "'," + // --> [Pos 050 (RZCKNU)]
				"'" + "" + "'," + // --> [Pos 051 (RZPOST)]
				"'" + clientType + "'," + // --> [Pos 052 (RZGLC)]
				// Default Values
				" " + 0 + ", " + // --> [Pos 053 (RZADSC)] numero
				" " + 0 + ", " + // --> [Pos 054 (RZADSA)] numero
				" " + 0 + ", " + // --> [Pos 055 (RZAAAJ)] numero
				" " + 0 + ", " + // --> [Pos 056 (RZECBA)] numero
				" " + 0 + ", " + // --> [Pos 057 (RZDDA )] numero
				" " + 0 + ", " + // --> [Pos 058 (RZCDS )] numero
				" " + 0 + ", " + // --> [Pos 059 (RZCDSA)] numero
				" " + 0 + ", " + // --> [Pos 060 (RZFCHG)] numero
				" " + 0 + ", " + // --> [Pos 061 (RZECBF)] numero
				" " + 0 + ", " + // --> [Pos 062 (RZFDA )] numero
				" " + 0 + ", " + // --> [Pos 063 (RZTADA)] numero
				" " + 0 + ", " + // --> [Pos 064 (RZTAAJ)] numero
				" " + 0 + ", " + // --> [Pos 065 (RZTCBA)] numero
				" " + 0 + ", " + // --> [Pos 066 (RZTDA )] numero
				"'" + "" + "', " + // --> [Pos 067 (RZACRM)] cadena
				" " + 0 + ", " + // --> [Pos 068 (RZAGLA)] numero
				"'" + "" + "', " + // --> [Pos 069 (RZAIDA)] cadena
				"'" + "" + "', " + // --> [Pos 070 (RZRSCO)] cadena
				"'" + "" + "', " + // --> [Pos 071 (RZAIDW)] cadena
				"'" + "" + "', " + // --> [Pos 072 (RZECBR)] cadena
				"'" + "" + "', " + // --> [Pos 073 (RZGLCC)] cadena
				"'" + "" + "', " + // --> [Pos 074 (RZAIDC)] cadena
				"'" + "" + "', " + // --> [Pos 075 (RZDDEX)] cadena
				"'" + "" + "', " + // --> [Pos 076 (RZDAID)] cadena
				"'" + "" + "', " + // --> [Pos 077 (RZUCTF)] cadena
				"'" + "" + "', " + // --> [Pos 078 (RZAID2)] cadena
				"'" + "" + "', " + // --> [Pos 079 (RZAM2 )] cadena
				"'" + "" + "', " + // --> [Pos 080 (RZSBL )] cadena
				"'" + "" + "', " + // --> [Pos 081 (RZSBLT)] cadena
				"'" + "" + "', " + // --> [Pos 082 (RZPKCO)] cadena
				"'" + "" + "', " + // --> [Pos 083 (RZPO )] cadena
				"'" + "" + "', " + // --> [Pos 084 (RZPDCT)] cadena
				" " + 0 + ", " + // --> [Pos 085 (RZNUMB)] numero
				"'" + "" + "', " + // --> [Pos 086 (RZUNIT)] cadena
				"'" + "" + "', " + // --> [Pos 087 (RZMCU2)] cadena
				"'" + "" + "', " + // --> [Pos 088 (RZFNLP)] cadena
				"'" + "" + "', " + // --> [Pos 089 (RZALT6)] cadena
				" " + 0 + ", " + // --> [Pos 090 (RZODOC)] numero
				"'" + "" + "', " + // --> [Pos 091 (RZODCT)] cadena
				"'" + "" + "', " + // --> [Pos 092 (RZOKCO)] cadena
				"'" + "" + "', " + // --> [Pos 093 (RZOSFX)] cadena
				" " + 0 + ", " + // --> [Pos 094 (RZGDOC)] numero
				"'" + "" + "', " + // --> [Pos 095 (RZGDCT)] cadena
				"'" + "" + "', " + // --> [Pos 096 (RZGKCO)] cadena
				"'" + "" + "', " + // --> [Pos 097 (RZGSFX)] cadena
				"'" + "" + "', " + // --> [Pos 098 (RZDCTG)] cadena
				" " + 0 + ", " + // --> [Pos 099 (RZDOCG)] numero
				"'" + "" + "', " + // --> [Pos 100 (RZKCOG)] cadena
				"'" + "" + "', " + // --> [Pos 101 (RZCTL) ] cadena
				" " + 0 + ", " + // --> [Pos 102 (RZSMTJ)] numero
				" " + 0 + ", " + // --> [Pos 103 (RZVDGJ)] numero
				"'" + "" + "', " + // --> [Pos 104 (RZVRE) ] cadena
				"'" + "" + "', " + // --> [Pos 105 (RZNFVD)] cadena
				"'" + "" + "', " + // --> [Pos 106 (RZISTC)] cadena
				"'" + "" + "', " + // --> [Pos 107 (RZDDST)] cadena
				"'" + "" + "', " + // --> [Pos 108 (RZVR01)] cadena
				" " + 0 + ", " + // --> [Pos 109 (RZRFID)] numero
				"'" + "" + "', " + // --> [Pos 110 (RZRIDC)] cadena
				"'" + "" + "', " + // --> [Pos 111 (RZPRGF)] cadena
				"'" + "" + "', " + // --> [Pos 112 (RZGFL1)] cadena
				" " + 0 + ", " + // --> [Pos 113 (RZRNID)] numero
				" " + 0 + ", " + // --> [Pos 114 (RZURAB)] numero
				" " + 0 + ", " + // --> [Pos 115 (RZURAT)] numero
				"'" + "" + "', " + // --> [Pos 116 (RZURC1)] cadena
				" " + 0 + ", " + // --> [Pos 117 (RZURDT)] numero
				"'" + "" + "', " + // --> [Pos 118 (RZURRF)] cadena
				" " + 0 + ", " + // --> [Pos 119 (RZSHPN)] numero
				"'" + "" + "', " + // --> [Pos 120 (RZOMOD)] cadena
				" " + 0 + ", " + // --> [Pos 121 (RZDOCO)] numero
				"'" + "" + "', " + // --> [Pos 122 (RZRASI)] cadena
				"'" + "" + "', " + // --> [Pos 123 (RZSFXO)] cadena
				"'" + "" + "', " + // --> [Pos 124 (RZKCOO)] cadena
				"'" + "" + "', " + // --> [Pos 125 (RZDCTO)] cadena
				" " + 0 + ", " + // --> [Pos 126 (RZRAMT)] numero
				"'" + "" + "', " + // --> [Pos 127 (RZLRFL)] cadena
				"'" + "" + "', " + // --> [Pos 128 (RZGFL2)] cadena
				"'" + "" + "', " + // --> [Pos 129 (RZDRCO)] cadena
				" " + 0 + ", " + // --> [Pos 130 (RZLFCJ)] numero
				"'" + "" + "', " + // --> [Pos 131 (RZAIDD)] cadena
				" " + 0 + ", " + // --> [Pos 132 (RZNETTCID)] numero
				" " + 0 + ", " + // --> [Pos 133 (RZNETDOC)] numero
				" " + 0 + ", " + // --> [Pos 134 (RZNETRC5)] numero
				" " + 0 + ")"; // --> [Pos 135 (RZADGJ)] numero

		return valueQuery;
	}

}
