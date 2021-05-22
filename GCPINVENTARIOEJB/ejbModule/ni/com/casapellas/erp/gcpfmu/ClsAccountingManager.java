package ni.com.casapellas.erp.gcpfmu;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.openjpa.lib.conf.StringValue;
import org.apache.openjpa.persistence.HintValueConverter.StringToInteger;

import ni.com.casapellas.gcpfmu.pojo.AccountCash;
import ni.com.casapellas.gcpfmu.pojo.CashBillReceiptRelation;
import ni.com.casapellas.gcpfmu.pojo.CashReceipt;
import ni.com.casapellas.gcpfmu.pojo.CashReceiptPaymentItem;
import ni.com.casapellas.gcpfmu.pojo.ClientCreditType;
import ni.com.casapellas.gcpfmu.pojo.FMUUtil;
import ni.com.casapellas.gcpfmu.pojo.SurplusExchange;
import ni.com.casapellas.gcptaller.pojo.TechnicalRecommendations;
import ni.com.casapellas.util.CollectionScheme;

/**
 * Accounting Class
 * @author jhon
 *
 */
@Singleton
public class ClsAccountingManager {
	

	@Inject
	public ClsAccountingManager() {
		
	}

	/**
	 * Create batch header
	 * @param em
	 * @param batchNumber
	 * @param receiptJde
	 * @param userId
	 * @param date
	 * @param amount
	 * @return
	 */
	public static int createBatchHeader(int idJsonLog, EntityManager em, String batchType, 
			int batchNumber, String userId, int date, float amount, 
			int totalDocuments, String softwareId, boolean isCreeditBill) {
	
		int result = 0;
		
		try {
			
		String sQuery =
				
		"INSERT INTO " + CollectionScheme.SchemeJDE + ".F0011 (" +
				"ICICUT," +
				"ICICU," +
				"ICAICU," +
				"ICUSER," +
				"ICDICJ," +
				"ICBAL," +
				"ICBALJ," +
				"ICDOCN," +
				"ICAUSR," +
				"ICAIPT," +
				"ICUPMJ," +
				"ICUPMT," +
				"ICJOBN, " +
				"ICIST, " +
				"ICIAPP, " +
				"ICNDO, " +
				"ICPOB, " +
				"ICAME, " +
				"ICIBOI, " +
				"ICOFFP, " +
				"ICPID, " +
				"ICDRSP, " +
				"IC52PP, " +
				"ICCBP) " +
				
		"VALUES ('" + batchType + "', " +
			 		"" + batchNumber + ", " +
			 		"" + 0 + ", " +
			 		"'" + userId + "', " +
			 		"" + date + ", " +
			 		"'" + FMUUtil.ICBAL + "', " +
			 		"'" + FMUUtil.ICBALJ + "', " +
			 		"" + totalDocuments +  ", " +
			 		"'" + "" + "', " +
			 		"" + 0 + ", " +
			 		"" + date + ", " +
			 		"" + FMUUtil.getIntegerHour(new Date()) + ", " +
			 		"'" + "" + "'," + 
			 		"'" + "A" + "'," + 
			 		"'" + "A" + "'," + 
			 		"" + 0 + ", " +
			 		"'" + "N" + "', " +
 					"" + amount + "," +
					"'" + ""  + "'," +
					"'" + "" + "'," +
					"'" + softwareId + "'," +
					"'" + ""  + "'," +
					"'" + "" + "'," +
					"'" + "" + "')";

			result = em.createNativeQuery(sQuery).executeUpdate();
	
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
			ClsCashManager.setErrorMsg2(e.getMessage());
			ClsBillManager.setErrorMsg(e.getMessage());
		}
		return result;
	}
	
	
	/**
	 * Header String for insert batch detail
	 * @return
	 */
	public static String getF0911HeaderInsert() {
	
		try {
			String sQuery = "INSERT INTO " + CollectionScheme.SchemeJDE + ".F0911 (" +
		
				"GLKCO," +
				"GLDCT," +
				"GLDOC," +
				"GLDGJ," +
				"GLJELN," +
				"GLICU," +
				"GLICUT," +
				"GLDICJ," +
				"GLDSYJ," +
				"GLTICU," +
				"GLCO," +
				"GLANI," +
				"GLAM," +
				"GlAID," +
				"GLMCU," +
				"GLOBJ," +
				"GLSUB," +
				"GLLT," +
				"GLPN," +
				"GLCTRY," +
				"GLFY," +
				"GLCRCD," +
				"GLCRR," +
				"GLAA," +
				"GLEXA," +
				"GLEXR," +
				"GLDKJ," +
				"GLDSVJ," +
				"GLTORG," +
				"GLBCRC," +
				"GLCRRM," +
				"GLUSER," +
				"GLJOBN," +
				"GLUPMJ," +		
				"GLUPMT," +	
				"GLAN8," +				
				"GLPID," +
				"GLEXTL, " +
				"GLODOC, " +
				"GLDKC, " +
				"GLIVD, " +
				"GLLNID, " +
				"GLWY, " +
				"GLWN, " +
				"GLOPSQ, " +
				"GLDOI, " +
				"GLREG#, " +
				"GLITM, " +
				"GLACR, " +
				"GLPYID, " +
				"GLTXITM, " +
				"GLDLNID," +
				"GLRC5, " +
				"GLSFXE, " +
				"GLHDGJ, " +
				"GLPOST," +
				
				// Default Values
				"GLSBL, " + // cadena
				"GLSBLT, " + // Cadena
				"GLFQ, " + // Cadena
				"GLHCRR, " + // Cadena
				"GLU, " + // cadena
				"GLUM, " + // cadena
				"GLGLC, " + // Cadena
				"GLRE, " + // Cadena
				"GLR1, " + // cadena
				"GLR2, " + // cadena
				"GLR3, " + // cadena
				"GLSFX, " + // cadena
				"GLODCT, " + // cadena
				"GLOSFX, " + // cadena
				"GLPKCO, " + // cadena
				"GLOKCO, " + // cadena
				"GLPDCT, " + // cadena
				"GLCN, " + // cadena /TEST
				"GLASID, " + //cadena
				"GLBRE, " + // cadena 
				"GLRCND, " + // cadena
				"GLSUMM, " + // Cadena
				"GLPRGE, " + // cadena
				"GLTNN, " + // cadena
				"GLALT1, " + // cadena
				"GLALT2, " + // cadena
				"GLALT3, " + // cadena
				"GLALT4, " + // cadena
				"GLALT5, " + // cadena
				"GLALT6, " + // cadena
				"GLALT7, " + // cadena
				"GLALT8, " + // cadena
				"GLALT9, " + // cadena
				"GLALT0, " + // cadena
				"GLALTT, " + // cadena
				"GLALTU, " + // cadena
				"GLALTV, " + // Cadena
				"GLALTW, " + // cadena
				"GLALTX, " + // cadena
				"GLALTZ, " + // cadena
				"GLDLNA, " + // cadna
				"GLCFF1, " + // cadena
				"GLCFF2, " + // cadena
				"GLASM, " + // cadena		
				"GLBC, " + // cadena
				"GLVINV, " + // cadena
				"GLWR01, " + // cadena
				"GLPO, " + // cadena
				"GLPSFX, " + // cadena
				"GLDCTO, " + // cadena
				"GLFNLP, " + // cadena
				"GLJBCD, " + // cadena
				"GLJBST, " + // cadena
				"GLHMCU, " + // cadena
				"GLALID, " + // cadena
				"GLALTY, " + // cadena
				"GLABR1, " + // cadena
				"GLABR2, " + // cadena
				"GLABR3, " + // cadena
				"GLABR4, " + // cadena
				"GLABT1, " + // cadena
				"GLABT2, " + // cadena
				"GLABT3, " + // cadena
				"GLABT4, " + // cadena
				"GLPM01, " + // cadena
				"GLPM02, " + // cadena
				"GLPM03, " + // cadena
				"GLPM04, " + // cadena
				"GLPM05, " + // cadena
				"GLPM06, " + // cadena
				"GLPM07, " + // cadena
				"GLPM08, " + // cadena
				"GLPM09, " + // cadena
				"GLPM10, " + // cadena
				"GLPRGF, " + // cadena
				"GLTXA1, " + // cadena
				"GLEXR1, " + // cadena
				"GLACTB, " + // cadena
				"GLGPF1, " + // cadena
				"GLCKNU, " + // cadena
				"GLBUPC, " + // cadena
				"GLAHBU, " + // cadena
				"GLEPGC, " + // cadena
				"GLJPGC, " + // cadena
				"GLOFM) " + // cadena*/

			"VALUES ";
		
			return sQuery;
	
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Creamos este método para obtener la contra cuenta del método del método de pago para efectivo.
	 * @param em
	 * @param lineId
	 * @param objectId
	 * @param part3
	 * @return
	 */
	public static AccountCash getSurplusAccount(EntityManager em, String lineId, String objectId, String part3) {
		AccountCash accountCash = new AccountCash();
		
		String subId = "";
		
		if (!part3.equals("")) {
			subId = "AND  TRIM(GMSUB) = '" + part3 + "'";
		}
		
		try {
			String sQuery = "SELECT cast(GMCO as varchar(37) ccsid 37) companyId, "
					+ "cast(GMAID as varchar(37) ccsid 37) account "
					+ "FROM " + CollectionScheme.SchemeJDE  + ".F0901 where TRIM(GMMCU) = '" 
					+ lineId + "' AND TRIM(GMOBJ) = '" + objectId +"' " +  subId;
			accountCash = (AccountCash)  em.createNativeQuery(sQuery, AccountCash.class).getSingleResult();
					
			if (accountCash == null) {
				return null;
			}
		
			return accountCash;
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}	
	}
	
	/**
	 * Create account movements
	 * @param em
	 * @param cashBillReceiptRelations
	 * @param cashReceiptPaymentItems
	 * @param cashReceipt
	 * @param batchNumber
	 * @param jdeNumber
	 */
	public static void createBatchDetail(int idJsonLog, EntityManager em, List<CashBillReceiptRelation> cashBillReceiptRelations, List<CashReceiptPaymentItem> cashReceiptPaymentItems,
			CashReceipt cashReceipt, int batchNumber, int jdeNumber) {

		String companyId = "";
		String queryInsert = "";
		int sequence = 1;
		float totalBatch = 0;
						
		
		System.out.println("Entro si : " + batchNumber);

		DecimalFormat df = new DecimalFormat("#0.##");
		DecimalFormat format = new DecimalFormat(".00");

		for (CashReceiptPaymentItem cashReceiptPaymentItem : cashReceiptPaymentItems) {
			cashReceiptPaymentItem.setEquivalent(
					new BigDecimal(format.format(cashReceiptPaymentItem.getEquivalent())).multiply(new BigDecimal(100)).floatValue());
		}
		
		pago:
		for (CashReceiptPaymentItem cashReceiptPaymentItem : cashReceiptPaymentItems) {
		
			for (CashBillReceiptRelation cashBillReceiptRelation : cashBillReceiptRelations) {
				
				float exchange = cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID) ? cashReceipt.getExchange() : 0;
				
				String concept = "R:" + cashReceipt.getReceiptNumber() +  " Ca:" + cashReceipt.getCashId() + " Com:" + cashReceipt.getJdCompanyId();				
				final String otherConcept = "Met: " + cashReceiptPaymentItem.getMethod() + " f: " + cashBillReceiptRelation.getBillId();

				if (companyId.equals("")) {
					companyId = cashBillReceiptRelation.getJdBranchId();
				}

				/// case
				if (cashReceiptPaymentItem.getEquivalent() > cashBillReceiptRelation.getAmount()) {
		
					float total = new BigDecimal(df.format(cashBillReceiptRelation.getAmount())).floatValue();
										
					if (total == 0) {
						continue;
					}
					
					totalBatch+= total;
										
					queryInsert += createValuesArray(
							FMUUtil.GLDCT, 
							FMUUtil.GLICUT, 
							companyId, 
							jdeNumber, 
							sequence, 
							batchNumber, 
							FMUUtil.getIntegerHour(new java.util.Date()), 
							cashReceiptPaymentItem.getCashAccountPart1(), 
							cashReceiptPaymentItem.getCashAccountPart2(), 
							cashReceiptPaymentItem.getCashAccountPart3(), 
							cashReceiptPaymentItem.getCompanyId2(),
							cashReceiptPaymentItem.getCashAccount2(), 
							FMUUtil.getJdLineNumberSpace(cashReceiptPaymentItem.getCashAccountPart1()) + cashReceiptPaymentItem.getCashAccount(), 
							cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.DOL_CA_LETTER : FMUUtil.COR_AA_LETTER, 
							exchange, 
							total, 
							cashBillReceiptRelation.getBillId(), 
							cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.F_CA_LETTER : FMUUtil.D_CA_LETTER, 
							concept, 
							cashReceipt.getCoin(), 
							cashReceipt.getUserId(),
							cashReceipt.getSoftwareId(),
							cashReceipt.getCodCli(),
							0,
							otherConcept);	
					
					queryInsert +=",\n";
					
					queryInsert += createValuesArray(
							FMUUtil.GLDCT, 
							FMUUtil.GLICUT, 
							companyId, 
							jdeNumber, 
							(sequence + 1), 
							batchNumber, 
							FMUUtil.getIntegerHour(new java.util.Date()), 
							cashBillReceiptRelation.getAccountPart1(), 
							cashBillReceiptRelation.getAccountPart2(), 
							"", 
							cashBillReceiptRelation.getCompanyId2(),
							cashBillReceiptRelation.getAccount2(), 
							FMUUtil.getJdLineNumberSpace(cashBillReceiptRelation.getAccountPart1()) + cashBillReceiptRelation.getAccount(), 
							cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.DOL_CA_LETTER : FMUUtil.COR_AA_LETTER, 
							exchange, 
							-total, 
							cashBillReceiptRelation.getBillId(), 
							cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.F_CA_LETTER : FMUUtil.D_CA_LETTER, 
							concept, 
							cashReceipt.getCoin(), 
							cashReceipt.getUserId(),
							cashReceipt.getSoftwareId(),
							cashReceipt.getCodCli(),
							0,
							otherConcept);
					
					queryInsert +=",\n";
					
					if (!iSameCoinReceipt(cashReceipt.getCoin(), cashReceiptPaymentItem)) {

						String totalCR = "";
						String typeMovement = "";
						String typeMovementLetter = "";

						if (cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID)) {
							typeMovement = FMUUtil.COR_AA_LETTER;
							typeMovementLetter = FMUUtil.F_CA_LETTER;
							 							
							float totalDivide = new BigDecimal(cashBillReceiptRelation.getAmount()).
									divide(new BigDecimal(100)).floatValue();
														
							 totalCR = df.format(new BigDecimal(totalDivide
						    		 * cashReceipt.getExchange()));
						} else {
							typeMovement = FMUUtil.DOL_CA_LETTER;
							typeMovementLetter = FMUUtil.F_CA_LETTER;
							
							float totalDivide = new BigDecimal(cashBillReceiptRelation.getAmount()).
									divide(new BigDecimal(100)).floatValue();
														
							totalCR = df.format(new BigDecimal(totalDivide
						    		 / cashReceipt.getExchange()));
						}
										
					    float totalAmount = new BigDecimal(totalCR).multiply(new BigDecimal(100)).floatValue();

						queryInsert += createValuesArray(
								FMUUtil.GLDCT, 
								FMUUtil.GLICUT, 
								companyId, 
								jdeNumber, 
								sequence, 
								batchNumber, 
								FMUUtil.getIntegerHour(new java.util.Date()), 
								cashReceiptPaymentItem.getCashAccountPart1(), 
								cashReceiptPaymentItem.getCashAccountPart2(), 
								cashReceiptPaymentItem.getCashAccountPart3(), 
								cashReceiptPaymentItem.getCompanyId2(),
								cashReceiptPaymentItem.getCashAccount2(), 
								FMUUtil.getJdLineNumberSpace(cashReceiptPaymentItem.getCashAccountPart1()) + cashReceiptPaymentItem.getCashAccount(), 
								typeMovement, 
								exchange, 
								totalAmount, 
								cashBillReceiptRelation.getBillId(), 
								typeMovementLetter, 
								concept, 
								cashReceipt.getCoin(), 
								cashReceipt.getUserId(),
								cashReceipt.getSoftwareId(),
								cashReceipt.getCodCli(),
								total,
								otherConcept);	
						
						queryInsert +=",\n";
						
						queryInsert += createValuesArray(
								FMUUtil.GLDCT, 
								FMUUtil.GLICUT, 
								companyId, 
								jdeNumber, 
								(sequence + 1), 
								batchNumber, 
								FMUUtil.getIntegerHour(new java.util.Date()), 
								cashBillReceiptRelation.getAccountPart1(), 
								cashBillReceiptRelation.getAccountPart2(), 
								"", 
								cashBillReceiptRelation.getCompanyId2(),
								cashBillReceiptRelation.getAccount2(), 
								FMUUtil.getJdLineNumberSpace(cashBillReceiptRelation.getAccountPart1()) + cashBillReceiptRelation.getAccount(), 
								typeMovement, 
								exchange, 
								-totalAmount, 
								cashBillReceiptRelation.getBillId(), 
								typeMovementLetter, 
								concept, 
								cashReceipt.getCoin(), 
								cashReceipt.getUserId(),
								cashReceipt.getSoftwareId(),
								cashReceipt.getCodCli(),
								-total,
								otherConcept);
						
						queryInsert +=",\n";
					}
					
					sequence = sequence + 2;
				
					cashReceiptPaymentItem.setEquivalent(cashReceiptPaymentItem.getEquivalent() - cashBillReceiptRelation.getAmount());
					cashBillReceiptRelation.setAmount(0);
					
					continue;
				
				} else if (cashReceiptPaymentItem.getEquivalent() < cashBillReceiptRelation.getAmount()) {
					
					float total = new BigDecimal(df.format(cashReceiptPaymentItem.getEquivalent())).floatValue();
					
					totalBatch+= total;
					
					queryInsert += createValuesArray(
							FMUUtil.GLDCT, 
							FMUUtil.GLICUT, 
							companyId, 
							jdeNumber, 
							sequence, 
							batchNumber, 
							FMUUtil.getIntegerHour(new java.util.Date()), 
							cashReceiptPaymentItem.getCashAccountPart1(), 
							cashReceiptPaymentItem.getCashAccountPart2(), 
							cashReceiptPaymentItem.getCashAccountPart3(), 
							cashReceiptPaymentItem.getCompanyId2(),
							cashReceiptPaymentItem.getCashAccount2(), 
							FMUUtil.getJdLineNumberSpace(cashReceiptPaymentItem.getCashAccountPart1()) + cashReceiptPaymentItem.getCashAccount(), 
							cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.DOL_CA_LETTER : FMUUtil.COR_AA_LETTER, 
							exchange, 
							total, 
							cashBillReceiptRelation.getBillId(), 
							cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.F_CA_LETTER : FMUUtil.D_CA_LETTER, 
							concept, 
							cashReceipt.getCoin(), 
							cashReceipt.getUserId(),
							cashReceipt.getSoftwareId(),
							cashReceipt.getCodCli(),
							0,
							otherConcept);	
					
					queryInsert +=",\n";
					
					queryInsert += createValuesArray(
							FMUUtil.GLDCT, 
							FMUUtil.GLICUT, 
							companyId, 
							jdeNumber, 
							(sequence + 1), 
							batchNumber, 
							FMUUtil.getIntegerHour(new java.util.Date()), 
							cashBillReceiptRelation.getAccountPart1(), 
							cashBillReceiptRelation.getAccountPart2(), 
							"", 
							cashBillReceiptRelation.getCompanyId2(),
							cashBillReceiptRelation.getAccount2(), 
							FMUUtil.getJdLineNumberSpace(cashBillReceiptRelation.getAccountPart1()) + cashBillReceiptRelation.getAccount(), 
							cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.DOL_CA_LETTER : FMUUtil.COR_AA_LETTER, 
							exchange, 
							-total, 
							cashBillReceiptRelation.getBillId(), 
							cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.F_CA_LETTER : FMUUtil.D_CA_LETTER, 
							concept, 
							cashReceipt.getCoin(), 
							cashReceipt.getUserId(),
							cashReceipt.getSoftwareId(),
							cashReceipt.getCodCli(),
							0,
							otherConcept);
					
					queryInsert +=",\n";
				
					if (!iSameCoinReceipt(cashReceipt.getCoin(), cashReceiptPaymentItem)) {						
						String totalCR = "";						
						String typeMovement = "";
						String typeMovementLetter = "";

						if (cashReceiptPaymentItem.getCoin().equals(FMUUtil.COR_COIN_ID)) {
							typeMovement = FMUUtil.COR_AA_LETTER;

							float totalDivide = new BigDecimal(cashReceiptPaymentItem.getEquivalent()).
									divide(new BigDecimal(100)).floatValue();
							
							 totalCR = df.format(new BigDecimal(totalDivide
						    		 * cashReceipt.getExchange()));
						} else {
							
							typeMovementLetter = FMUUtil.F_CA_LETTER;

							if (cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID)) {
								typeMovement = FMUUtil.COR_AA_LETTER;
								
								float totalDivide = new BigDecimal(cashReceiptPaymentItem.getEquivalent()).
										divide(new BigDecimal(100)).floatValue();
								
								totalCR = df.format(new BigDecimal(totalDivide 
							    		 * cashReceipt.getExchange()));
							} else {
								typeMovement = FMUUtil.DOL_CA_LETTER;
								
								float totalDivide = new BigDecimal(cashReceiptPaymentItem.getEquivalent()).
										divide(new BigDecimal(100)).floatValue();
								
								 totalCR = df.format(new BigDecimal(totalDivide
							    		 / cashReceipt.getExchange()));
							}
						}
			
					    float totalAmount = new BigDecimal(totalCR).multiply(new BigDecimal(100)).floatValue();
					     			
						queryInsert += createValuesArray(
								FMUUtil.GLDCT, 
								FMUUtil.GLICUT, 
								companyId, 
								jdeNumber, 
								sequence, 
								batchNumber, 
								FMUUtil.getIntegerHour(new java.util.Date()), 
								cashReceiptPaymentItem.getCashAccountPart1(), 
								cashReceiptPaymentItem.getCashAccountPart2(), 
								cashReceiptPaymentItem.getCashAccountPart3(), 
								cashReceiptPaymentItem.getCompanyId2(),
								cashReceiptPaymentItem.getCashAccount2(), 
								FMUUtil.getJdLineNumberSpace(cashReceiptPaymentItem.getCashAccountPart1()) + cashReceiptPaymentItem.getCashAccount(), 
								typeMovement, 
								exchange, 
								totalAmount, 
								cashBillReceiptRelation.getBillId(), 
								typeMovementLetter, 
								concept, 
								cashReceipt.getCoin(), 
								cashReceipt.getUserId(),
								cashReceipt.getSoftwareId(),
								cashReceipt.getCodCli(),
								total,
								otherConcept);	
					
						queryInsert +=",\n";
						
						queryInsert += createValuesArray(
								FMUUtil.GLDCT, 
								FMUUtil.GLICUT, 
								companyId, 
								jdeNumber, 
								(sequence + 1), 
								batchNumber, 
								FMUUtil.getIntegerHour(new java.util.Date()), 
								cashBillReceiptRelation.getAccountPart1(), 
								cashBillReceiptRelation.getAccountPart2(), 
								"", 
								cashBillReceiptRelation.getCompanyId2(),
								cashBillReceiptRelation.getAccount2(), 
								FMUUtil.getJdLineNumberSpace(cashBillReceiptRelation.getAccountPart1()) + cashBillReceiptRelation.getAccount(), 
								typeMovement, 
								exchange, 
								-totalAmount, 
								cashBillReceiptRelation.getBillId(), 
								typeMovementLetter, 
								concept, 
								cashReceipt.getCoin(), 
								cashReceipt.getUserId(),
								cashReceipt.getSoftwareId(),
								cashReceipt.getCodCli(),
								-total,
								otherConcept);
						
						queryInsert +=",\n";
					}
			
					sequence = sequence + 2;
					
					cashBillReceiptRelation.setAmount(cashBillReceiptRelation.getAmount() - cashReceiptPaymentItem.getEquivalent());
					cashReceiptPaymentItem.setEquivalent(0);
					
					continue pago;
			
				} else if (cashReceiptPaymentItem.getEquivalent() == cashBillReceiptRelation.getAmount()) {
				
					float total = new BigDecimal(cashReceiptPaymentItem.getEquivalent()).floatValue();

					totalBatch+= total;

					queryInsert += createValuesArray(
							FMUUtil.GLDCT, 
							FMUUtil.GLICUT, 
							companyId, 
							jdeNumber, 
							sequence, 
							batchNumber, 
							FMUUtil.getIntegerHour(new java.util.Date()), 
							cashReceiptPaymentItem.getCashAccountPart1(), 
							cashReceiptPaymentItem.getCashAccountPart2(), 
							cashReceiptPaymentItem.getCashAccountPart3(), 
							cashReceiptPaymentItem.getCompanyId2(),
							cashReceiptPaymentItem.getCashAccount2(), 
							FMUUtil.getJdLineNumberSpace(cashReceiptPaymentItem.getCashAccountPart1()) + cashReceiptPaymentItem.getCashAccount(), 
							cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.DOL_CA_LETTER : FMUUtil.COR_AA_LETTER, 
							exchange, 
							total, 
							cashBillReceiptRelation.getBillId(), 
							cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.F_CA_LETTER : FMUUtil.D_CA_LETTER, 
							concept, 
							cashReceipt.getCoin(), 
							cashReceipt.getUserId(),
							cashReceipt.getSoftwareId(),
							cashReceipt.getCodCli(),
							0,
							otherConcept);	
					
					queryInsert +=",\n";
					
					queryInsert += createValuesArray(
							FMUUtil.GLDCT, 
							FMUUtil.GLICUT, 
							companyId, 
							jdeNumber, 
							(sequence + 1), 
							batchNumber, 
							FMUUtil.getIntegerHour(new java.util.Date()), 
							cashBillReceiptRelation.getAccountPart1(), 
							cashBillReceiptRelation.getAccountPart2(), 
							"", 
							cashBillReceiptRelation.getCompanyId2(),
							cashBillReceiptRelation.getAccount2(),
							FMUUtil.getJdLineNumberSpace(cashBillReceiptRelation.getAccountPart1()) + cashBillReceiptRelation.getAccount(), 
							cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.DOL_CA_LETTER : FMUUtil.COR_AA_LETTER, 
							exchange, 
							-total, 
							cashBillReceiptRelation.getBillId(), 
							cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.F_CA_LETTER : FMUUtil.D_CA_LETTER, 
							concept, 
							cashReceipt.getCoin(), 
							cashReceipt.getUserId(),
							cashReceipt.getSoftwareId(),
							cashReceipt.getCodCli(),
							0,
							otherConcept);
					
					queryInsert +=",\n";
				
					if (!iSameCoinReceipt(cashReceipt.getCoin(), cashReceiptPaymentItem)) {

						String totalCR = "";						
						String typeMovement = "";
						String typeMovementLetter = FMUUtil.F_CA_LETTER;
						
						if (cashReceiptPaymentItem.getCoin().equals(FMUUtil.COR_COIN_ID)) {
							typeMovement = FMUUtil.COR_AA_LETTER;
							
							float totalDivide = new BigDecimal(cashBillReceiptRelation.getAmount()).
									divide(new BigDecimal(100)).floatValue();
														
							 totalCR = df.format(new BigDecimal(totalDivide
						    		 * cashReceipt.getExchange()));
						
						} else {
							if (cashReceipt.getCoin().equals(FMUUtil.US_COIN_ID)) {
								typeMovement = FMUUtil.COR_AA_LETTER;
								 
								float totalDivide = new BigDecimal(cashReceiptPaymentItem.getEquivalent()).
										divide(new BigDecimal(100)).floatValue();
															
								 totalCR = df.format(new BigDecimal(totalDivide
							    		 * cashReceipt.getExchange()));
							} else {
								typeMovement = FMUUtil.DOL_CA_LETTER;
								 
								float totalDivide = new BigDecimal(cashReceiptPaymentItem.getEquivalent()).
										divide(new BigDecimal(100)).floatValue();
															
								 totalCR = df.format(new BigDecimal(totalDivide 
							    		 / cashReceipt.getExchange()));
							}
						}
						
					     float totalAmount = new BigDecimal(totalCR).multiply(new BigDecimal(100)).floatValue();
									
						queryInsert += createValuesArray(
								FMUUtil.GLDCT, 
								FMUUtil.GLICUT, 
								companyId, 
								jdeNumber, 
								sequence, 
								batchNumber, 
								FMUUtil.getIntegerHour(new java.util.Date()), 
								cashReceiptPaymentItem.getCashAccountPart1(), 
								cashReceiptPaymentItem.getCashAccountPart2(), 
								cashReceiptPaymentItem.getCashAccountPart3(), 
								cashReceiptPaymentItem.getCompanyId2(),
								cashReceiptPaymentItem.getCashAccount2(), 
								FMUUtil.getJdLineNumberSpace(cashReceiptPaymentItem.getCashAccountPart1()) + cashReceiptPaymentItem.getCashAccount(), 
								typeMovement, 
								exchange, 
								totalAmount, 
								cashBillReceiptRelation.getBillId(), 
								typeMovementLetter, 
								concept, 
								cashReceipt.getCoin(), 
								cashReceipt.getUserId(),
								cashReceipt.getSoftwareId(),
								cashReceipt.getCodCli(),
								total,
								otherConcept);	
					
						queryInsert +=",\n";
						
						queryInsert += createValuesArray(
								FMUUtil.GLDCT, 
								FMUUtil.GLICUT, 
								companyId, 
								jdeNumber, 
								(sequence + 1), 
								batchNumber,  
								FMUUtil.getIntegerHour(new java.util.Date()), 
								cashBillReceiptRelation.getAccountPart1(), 
								cashBillReceiptRelation.getAccountPart2(), 
								"", 
								cashBillReceiptRelation.getCompanyId2(),
								cashBillReceiptRelation.getAccount2(), 
								FMUUtil.getJdLineNumberSpace(cashBillReceiptRelation.getAccountPart1()) + cashBillReceiptRelation.getAccount(), 
								typeMovement, 
								exchange, 
								-totalAmount, 
								cashBillReceiptRelation.getBillId(), 
								typeMovementLetter, 
								concept, 
								cashReceipt.getCoin(), 
								cashReceipt.getUserId(),
								cashReceipt.getSoftwareId(),
								cashReceipt.getCodCli(),
								-total,
								otherConcept);
						
						queryInsert +=",\n";
					}
					
					cashBillReceiptRelation.setAmount(0);
					cashReceiptPaymentItem.setEquivalent(0);
										
					sequence = sequence + 2;

					continue pago;
				}
			}
		}

		if (!queryInsert.equals("")) {
			
			queryInsert = queryInsert.substring(0, queryInsert.length() -2); 
			String completeQuery = getF0911HeaderInsert() + "\n" + queryInsert;	
					
			try {						
				if (createBatchHeader(idJsonLog, em, FMUUtil.ICICUT, batchNumber, 
						cashReceipt.getUserId(), FMUUtil.dateToJulian(new java.util.Date()), /*(int)*/ (totalBatch),
						cashBillReceiptRelations.size(), cashReceipt.getSoftwareId(), false) > 0) {
					
					int rows = em.createNativeQuery(completeQuery).executeUpdate();
					
					ClsSystemLogs.createQueryLog(idJsonLog, "createBatchDetail", completeQuery, true, rows);
					
				}
					
			} catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
				ClsCashManager.setErrorMsg2(e.getMessage());
			}
		}
	
	}
	
	/**
	 * Usamos este metodo para definir si necesitamos crear o no movimientos contables tipo D en la 0911.
	 * @param billCoin
	 * @param cashReceiptPaymentItem
	 * @return
	 */
	private static boolean iSameCoinReceipt(String billCoin, CashReceiptPaymentItem cashReceiptPaymentItem) {
		return (cashReceiptPaymentItem.getCoin().equals(FMUUtil.COR_COIN_ID) && billCoin.equals(FMUUtil.COR_COIN_ID));		
	}
	
	
	/**
	 * Sheet format
	 * @param em
	 * @param cashReceiptPaymentItems
	 * @param batchNumber
	 * @param cashReceipt
	 * @param date
	 * @param jdeNumber
	 * @param cashSheetReceiptPaymentItem 
	 */
	public static void createBatchDetailsheet(EntityManager em, int batchNumber, CashReceipt cashReceipt,
			int jdeNumber, CashReceiptPaymentItem cashSheetReceiptPaymentItem) {
		
			String corAccount = "";
			String queryInsert = "";
		
			String concept = cashReceipt.getReceiptNumber() +  " Ca:" 
			+ cashReceipt.getCashId() + " Com:" + cashReceipt.getJdCompanyId();
			
			corAccount = cashReceipt.getCorAccount();
						
			float totalDr = new BigDecimal(cashReceipt.getApplyAmount()).multiply(new BigDecimal(100)).floatValue();
			float diffAmount = new BigDecimal(cashSheetReceiptPaymentItem.getDiffAmount()).multiply(new BigDecimal(100)).floatValue();

			// default
			cashReceipt.setCoin(FMUUtil.US_COIN_ID);

			queryInsert += createValuesArray(
					FMUUtil.GLDCT, 
					FMUUtil.GLICUT, 
					cashSheetReceiptPaymentItem.getCompanyId2(), 
					jdeNumber, 
					1, 
					batchNumber, 
					FMUUtil.getIntegerHour(new java.util.Date()), 
					cashSheetReceiptPaymentItem.getCashAccountPart1(), 
					cashSheetReceiptPaymentItem.getCashAccountPart2(), 
					cashSheetReceiptPaymentItem.getCashAccountPart3(), 
					cashSheetReceiptPaymentItem.getCompanyId2(),
					cashSheetReceiptPaymentItem.getCashAccount2(), 
					FMUUtil.getJdLineNumberSpace(cashSheetReceiptPaymentItem.getCashAccountPart1()) + cashSheetReceiptPaymentItem.getCashAccount(), 
					FMUUtil.DOL_CA_LETTER, 
					cashReceipt.getExchange(), 
					totalDr, 
					2, 
					FMUUtil.F_CA_LETTER, 
					concept, 
					cashReceipt.getCoin(), 
					cashReceipt.getUserId(),
					cashReceipt.getSoftwareId(),
					cashReceipt.getCodCli(),
					0,
					"");	
			
			queryInsert +=",\n";
			
			queryInsert += createValuesArray(
					FMUUtil.GLDCT, 
					FMUUtil.GLICUT, 
					cashReceipt.getCompanyId2(), 
					jdeNumber, 2, 
					batchNumber, 
					FMUUtil.getIntegerHour(new java.util.Date()), 
					cashReceipt.getCorAccountPart1(), 
					cashReceipt.getCorAccountPart2(), 
					cashReceipt.getCorAccountPart3(), 
					cashReceipt.getCompanyId2(),
					cashReceipt.getAccount(), 
					FMUUtil.getJdLineNumberSpace(cashReceipt.getCorAccountPart1()) + corAccount, 
					FMUUtil.DOL_CA_LETTER, 
					cashReceipt.getExchange(), 
					-totalDr, 
					2, 
					FMUUtil.F_CA_LETTER, 
					concept, 
					cashReceipt.getCoin(), 
					cashReceipt.getUserId(),
					cashReceipt.getSoftwareId(),
					cashReceipt.getCodCli(),
					0,
					"");	
				
			queryInsert +=",\n";

			queryInsert += createValuesArray(
					FMUUtil.GLDCT, 
					FMUUtil.GLICUT, 
					cashSheetReceiptPaymentItem.getCompanyId2(), 
					jdeNumber, 
					1, 
					batchNumber, 
					FMUUtil.getIntegerHour(new java.util.Date()), 
					cashSheetReceiptPaymentItem.getCashAccountPart1(), 
					cashSheetReceiptPaymentItem.getCashAccountPart2(), 
					cashSheetReceiptPaymentItem.getCashAccountPart3(), 
					cashSheetReceiptPaymentItem.getCompanyId2(),
					cashSheetReceiptPaymentItem.getCashAccount2(), 
					FMUUtil.getJdLineNumberSpace(cashSheetReceiptPaymentItem.getCashAccountPart1()) + cashSheetReceiptPaymentItem.getCashAccount(), 
					FMUUtil.COR_AA_LETTER, 
					cashReceipt.getExchange(), 
					diffAmount, 
					2, 
					FMUUtil.F_CA_LETTER, 
					concept, 
					cashReceipt.getCoin(), 
					cashReceipt.getUserId(),
					cashReceipt.getSoftwareId(),
					cashReceipt.getCodCli(),
					totalDr,
					"");	
			
			queryInsert +=",\n";

			queryInsert += createValuesArray(
					FMUUtil.GLDCT, 
					FMUUtil.GLICUT, 
					cashReceipt.getCompanyId2(), 
					jdeNumber, 
					2, 
					batchNumber, 
					FMUUtil.getIntegerHour(new java.util.Date()), 
					cashReceipt.getCorAccountPart1(), 
					cashReceipt.getCorAccountPart2(), 
					cashReceipt.getCorAccountPart3(), 
					cashReceipt.getCompanyId2(),
					cashReceipt.getAccount(),
					FMUUtil.getJdLineNumberSpace(cashReceipt.getCorAccountPart1()) + corAccount, 
					FMUUtil.COR_AA_LETTER, 
					cashReceipt.getExchange(), 
					-diffAmount, 
					2, 
					FMUUtil.F_CA_LETTER, 
					concept, 
					cashReceipt.getCoin(), 
					cashReceipt.getUserId(),
					cashReceipt.getSoftwareId(),
					cashReceipt.getCodCli(),
					-totalDr,
					"");	
		
			String completeQuery = getF0911HeaderInsert() + queryInsert;
				
			try {
				em.createNativeQuery(completeQuery).executeUpdate();
			} catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
				ClsCashManager.setErrorMsg2(e.getMessage());
			}
	}
	
	/**
	 * Genear Sobrante si necesario.
	 * @param em
	 * @param surplusExchange
	 * @param cashReceipt
	 */
	public static void createSurplusExchange(int idJsonLog, EntityManager em, SurplusExchange surplusExchange, CashReceipt cashReceipt) {
		
		String queryInsert = "";
		String query1= cashReceipt.getJdLineId();
		String query2= "66000";
		String query3= "01";

		if (surplusExchange.getCoinLastPaymentItem().equals(cashReceipt.getCoin())) {
			query2= "65100";
			query3= "10";
		}
		
		int batchNumber = ClsCashManager.getBatchSequenceNumber(em);
		int jdeNumber = ClsCashManager.getReciboJdeSequence(idJsonLog, em, cashReceipt.getJdCompanyId(), true);
			
		if (ClsCashManager.insertReciboJDERelation(idJsonLog, em, cashReceipt, batchNumber, jdeNumber, FMUUtil.SBR_LABEL) == 0) {
			return;
		}
			
		AccountCash accountCashSurplus = getSurplusAccount(em, query1, query2, query3);
		
		String concept = "Sobrante en Rc:" + cashReceipt.getReceiptNumber() + " Ca:" + cashReceipt.getCashId() + "";
		
		queryInsert += createValuesArray(
				FMUUtil.GLDCT, 
				FMUUtil.GLICUT, 
				surplusExchange.getCompanyId2(), 
				jdeNumber, 
				1, 
				batchNumber, 
				FMUUtil.getIntegerHour(new java.util.Date()), 
				surplusExchange.getAccountPart1(), 
				surplusExchange.getAccountPart2(), 
				surplusExchange.getAccountPart3(), 
				surplusExchange.getCompanyId2(),
				surplusExchange.getAccount2(), 
				FMUUtil.getJdLineNumberSpace(surplusExchange.getAccountPart1()) + surplusExchange.getAccount(), 
				surplusExchange.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.DOL_CA_LETTER : FMUUtil.COR_AA_LETTER, 
				surplusExchange.getCoin().equals(FMUUtil.US_COIN_ID) ? surplusExchange.getExchange() : 0, 
				surplusExchange.getCoin().equals(FMUUtil.US_COIN_ID) ?  surplusExchange.getDiffAmount() : surplusExchange.getAmount(), 
				2, 
				surplusExchange.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.F_CA_LETTER : FMUUtil.D_CA_LETTER, 
				concept, 
				cashReceipt.getCoin(), 
				cashReceipt.getUserId(),
				cashReceipt.getSoftwareId(),
				cashReceipt.getCodCli(),
				0,
				"");	
		
		queryInsert +=",\n";
		
		queryInsert += createValuesArray(
				FMUUtil.GLDCT, 
				FMUUtil.GLICUT, 
				accountCashSurplus.getCompanyId(),
				jdeNumber, 
				2, 
				batchNumber, 
				FMUUtil.getIntegerHour(new java.util.Date()), 
				query1, 
				query2, 
				query3, 
				accountCashSurplus.getCompanyId(),
				accountCashSurplus.getAccount(), 
				FMUUtil.getJdLineNumberSpace(query1) + query1 + "." + query2 + "." + query3, 
				surplusExchange.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.DOL_CA_LETTER : FMUUtil.COR_AA_LETTER, 
				surplusExchange.getCoin().equals(FMUUtil.US_COIN_ID) ? surplusExchange.getExchange() : 0, 
				- (surplusExchange.getCoin().equals(FMUUtil.US_COIN_ID) ? surplusExchange.getDiffAmount() :  surplusExchange.getAmount()), 
				2, 
				surplusExchange.getCoin().equals(FMUUtil.US_COIN_ID) ? FMUUtil.F_CA_LETTER : FMUUtil.D_CA_LETTER, 
				concept, 
				surplusExchange.getCoin(), 
				cashReceipt.getUserId(),
				cashReceipt.getSoftwareId(),
				cashReceipt.getCodCli(),
				0,
				"");	
			
				
		if (surplusExchange.getCoin().equals(FMUUtil.US_COIN_ID)) {
			
			queryInsert +=",\n";
							
			queryInsert += createValuesArray(
					FMUUtil.GLDCT, 
					FMUUtil.GLICUT, 
					surplusExchange.getCompanyId2(), 
					jdeNumber, 
					1, 
					batchNumber, 
					FMUUtil.getIntegerHour(new java.util.Date()), 
					surplusExchange.getAccountPart1(), 
					surplusExchange.getAccountPart2(), 
					surplusExchange.getAccountPart3(), 
					surplusExchange.getCompanyId2(), 
					surplusExchange.getAccount2(), 
					FMUUtil.getJdLineNumberSpace(surplusExchange.getAccountPart1()) + surplusExchange.getAccount(), 
					FMUUtil.COR_AA_LETTER, 
					surplusExchange.getCoin().equals(FMUUtil.US_COIN_ID) ? surplusExchange.getExchange() : 0, 
					surplusExchange.getAmount(), 
					2, 
					FMUUtil.D_CA_LETTER, 
					concept, 
					cashReceipt.getCoin(), 
					cashReceipt.getUserId(),
					cashReceipt.getSoftwareId(),
					cashReceipt.getCodCli(),
					surplusExchange.getDiffAmount(),
					"");	
		
			queryInsert +=",\n";
		
			queryInsert += createValuesArray(
					FMUUtil.GLDCT, 
					FMUUtil.GLICUT, 
					accountCashSurplus.getCompanyId(),
					jdeNumber, 
					2, 
					batchNumber, 
					FMUUtil.getIntegerHour(new java.util.Date()), 
					query1, 
					query2, 
					query3, 
					accountCashSurplus.getCompanyId(),
					accountCashSurplus.getAccount(), 
					FMUUtil.getJdLineNumberSpace(query1) + query1 + "." + query2 + "." + query3, 
					FMUUtil.COR_AA_LETTER, 
					surplusExchange.getCoin().equals(FMUUtil.US_COIN_ID) ? surplusExchange.getExchange() : 0, 
					-surplusExchange.getAmount(), 
					2, 
					FMUUtil.D_CA_LETTER, 
					concept, 
					cashReceipt.getCoin(), 
					cashReceipt.getUserId(),
					cashReceipt.getSoftwareId(),
					cashReceipt.getCodCli(),
					-surplusExchange.getDiffAmount(),
					"");	
		}
	
		String completeQuery = getF0911HeaderInsert() + "\n" +  queryInsert;
								
		try {
			int result =ClsAccountingManager.createBatchHeader(idJsonLog,
					em, FMUUtil.ICICUT_SURPLUS_BILL, batchNumber, cashReceipt.getUserId(), 
					FMUUtil.dateToJulian(new Date()), /*(int)*/ surplusExchange.getDiffAmount(), 1, cashReceipt.getSoftwareId(), false);
			
			if (result > 0) {
				em.createNativeQuery(completeQuery).executeUpdate();	
			}
			
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
			ClsCashManager.setErrorMsg2(e.getMessage());
		}
		
	}
	
	/**{@link TechnicalRecommendations} 
	 * This create {@link Array} values
	 * @param total 
	 * @param glcrrm 
	 * @return
	 */
	public static String createValuesArray(String type, 
			String typeLicut, String companyId, int jdeReceipt, int sequence, 
			int batchNumber, int hour, String lineId, String objectId, String subId, String paymentItemCompanyId,
			String accountEnter, String accountLeave, String coinType, float exchange, 
			float total, int billId, String glcrrm, String concept, String billCoin, String userId, 
			String softwareId, int glan8, float totalCRGLACR, String otherConcept) {
		
		int date = FMUUtil.dateToJulian(new Date());
		
		 String valueQuery =  
				 "('" + companyId + "', " +
		 		"'" + type + "', " +
		 		"" + jdeReceipt + ", " +
		 		"" + date + ", " +
		 		"" + sequence + ", " +
		 		"" + batchNumber + ", " +
		 		"'" + typeLicut +  "', " +
		 		"" + date + ", " +
		 		"" + date + ", " +
		 		"" + hour + ", " +
		 		"'" + paymentItemCompanyId + "', " +
		 		"'" + accountLeave + "', " +
		 		"'" + 2 + "', " +
		 		"'" + accountEnter + "', " +
		 		"'" + FMUUtil.getJdLineNumberSpace(lineId) + lineId + "', " +
		 		"'" + objectId + "', " +
		 		"'" + subId + "', " +
		 		"'" + coinType + "', " +
		 		"" + FMUUtil.getMonthInt(new java.util.Date()) + ", " +
		 		"" + Integer.toString(FMUUtil.getYearInt(new java.util.Date())).substring(0, 2) + ", " +
		 		"" + Integer.toString(FMUUtil.getYearInt(new java.util.Date())).substring(2, 4) + ", " +
		 		"'" + billCoin + "', " +
		 		"" + String.format("%.4f", exchange) + ", " +
		 		"" + String.format("%.0f", total) + ", " +
		 		"'" + concept  + "', " +
		 		"'" + otherConcept +  "', " +
		 		"" + date + ", " +
		 		"" + date + ", " +
		 		"'" + userId + "', " +
		 		"'" + (coinType.equals(FMUUtil.COR_AA_LETTER) ? FMUUtil.COR_COIN_ID : FMUUtil.US_COIN_ID) + "', " +
		 		"'" + glcrrm + "', " +
		 		"'" + userId + "', " +
		 		"'" + softwareId + "', " +
		 		"" + date + ", " +
		 		"" + hour + ", " +
		 		"" + glan8 + ", " +
		 		"'" + softwareId + "'," +
	 			"'" + "" + "'," +
				"" + 0 + "," +
				"" + 0 + "," +
				"" + 0 + "," +
				"" + 0 + "," + 
		 		"" + 0 + "," +
		 		"" + 0 + "," +
		 		"" + 0 + "," +
		 		"" + 0 + "," +
		 		"" + 0 + "," +
		 		"" + 0 + "," +
	 			"" + totalCRGLACR + "," +
	 			"" + 0 + "," + 
	 			"" + 0 + "," +
	 			"" + 0 + "," +
	 			"" + 0 + "," +
	 			"" + 0 + "," +
	 			"" + 0 + "," +
		 		"'" + "" + "'," +
		 			
		 		// Default values
		 		"'" + "" + "'," +
		 		"'" + "" + "'," +
		 		"'" + "" + "'," +
		 		"" + 0 + "," +
		 		"" + 0 + "," +
		 		"'" + "" + "'," +
		 		"'" + "" + "'," +
		 		"'" + "" + "'," +
		 		"'" + "" + "'," +
		 		"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
		 		"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," + 
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "'," +
				"'" + "" + "')";	
		 
		 return valueQuery;
	}
}
