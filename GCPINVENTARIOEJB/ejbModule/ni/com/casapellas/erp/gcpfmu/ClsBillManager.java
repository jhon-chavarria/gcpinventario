package ni.com.casapellas.erp.gcpfmu;


import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 
 * @author jhon
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;


import ni.com.casapellas.gcpfmu.pojo.BillHeader;
import ni.com.casapellas.gcpfmu.pojo.PostObjectReturn;
import ni.com.casapellas.gcpfmu.pojo.BillPost;
import ni.com.casapellas.gcpfmu.pojo.ClientCreditInfo;
import ni.com.casapellas.gcpfmu.pojo.FMUUtil;
import ni.com.casapellas.gcpfmu.pojo.ProductAvailability;
import ni.com.casapellas.gcpfmu.pojo.ProductCost;
import ni.com.casapellas.util.CollectionScheme;

/**
 * Bill Manager
 * @author jhon
 *
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN) 
@SuppressWarnings({"unchecked"})
public class ClsBillManager {

	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;

	@Resource 
	private SessionContext sessionContext;  
	
	@EJB
	private ClsLogs clsLogs;

    private ClsCashManager CalendarData_ja = new ClsCashManager();
    private ClsCreditManager cajaManager = new ClsCreditManager();;

	private static String errorMsg;

	DecimalFormat format = new DecimalFormat(".00");

	@Inject
	public ClsBillManager() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param billPostList
	 * @return
	 * @throws Exception
	 */
	public List<PostObjectReturn> createBillHistory(int idJsonLog, List<BillHeader> billPostList ) throws Exception {
	
		List<PostObjectReturn> billListPostReturns = new ArrayList<PostObjectReturn>();	
	
		UserTransaction utx = sessionContext.getUserTransaction();

		bill:
		for (BillHeader billHeader : billPostList) {
					
			int batchNumber = 0;
			
			utx.begin();
			
			errorMsg = "";

			PostObjectReturn bill = new PostObjectReturn();
			
			BillPost billPostItem = billHeader.getBillPosts().get(0);
			
			if  ((billPostItem.getConditionType().equals(FMUUtil.CREDIT_LETTER) || billPostItem.getConditionType().equals(FMUUtil.DEV_CREDIT_LETTER)) &&
					billHeader.getTypeMove().equals(FMUUtil.MAKE_BILL_ACTION_ID)) {
					batchNumber = ClsCashManager.getBatchSequenceNumber(em);					
			}
		
			if (!billHeader.getTypeMove().equals(FMUUtil.CANCEL_BILL_CODE)) {
				updateSequence(em, billPostItem, false);
			}
			
			// If bill  exists
			if (checkIfBillRowExists(em, billPostItem) > 0) {	
				bill.setBillId(String.valueOf(billHeader.getBillId()));
				bill.setCompanyId(billHeader.getCompanyId());
				bill.setClientId(billHeader.getClientId());		
				bill.setState(true);
				bill.setMovementType(billHeader.getTypeMove());
				billListPostReturns.add(bill);
				
				bill.setErrorMsg("");
				utx.rollback();
				continue bill;
			}
			
			// Update authorization code if was used
			if (billHeader.getCode() !=0) {
				updateDiscountCode(em, billPostItem.getJdCompanyId(), billPostItem.getJdBranchId(), billHeader.getTypeCode(), billPostItem.getUserId(),
						billPostItem.getCellarId(), billHeader.getCode(), billPostItem.getHora(), billPostItem.getBillId());
			}
			
			for (BillPost billPost : billHeader.getBillPosts()) {
				
				ProductAvailability productAvailability = null;
				ProductCost productCost = null;
									
				try {
					if (!billPost.isExcludeCost()) {
						productAvailability = getProductAvailability(em, billPost.getProductId(), billPost.getBranchId(), billPost.getCellarId(), billPost.getCompanyId());
						productCost = getProductCost(em, billPost.getCompanyId(), billPost.getProductId(), billPost.getBranchId());
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					setErrorMsg("Error al obtener informacion de los productos");
					//continue;
				}				
				
				if ((productAvailability == null || productCost == null) && !billPost.isExcludeCost()) {
					setErrorMsg("Error al obtener informacion de los productos");
					//continue;
				}
				
				// Category from Product
				billPost.setISTAT2(!billPost.isExcludeCost() ? (productCost.getCategoryId() == null ? "" : productCost.getCategoryId()) : "");

				// Before bill
				billPost.setCOSTGA(!billPost.isExcludeCost() ? (productAvailability.getAvailable() * productCost.getUniqueCost()) : 0);
				billPost.setCOSTUA(!billPost.isExcludeCost() ? productCost.getUniqueCost() : 0);
				billPost.setEXISTA(!billPost.isExcludeCost() ? productAvailability.getAvailable() : 0);

				// During bill
				billPost.setVALORG(!billPost.isExcludeCost() ? (
						 new BigDecimal(format.format(billPost.getBillQuantity())).multiply(
									new BigDecimal(format.format(productCost.getUniqueCost()))).floatValue()) : 0);
				billPost.setVALORU(!billPost.isExcludeCost() ? productCost.getUniqueCost() : 0);
				
				billPost.setStatcv("");
				
				int totalAfterBill = 0;
				float totalGlobalCost = 0;
				
				String mathAction = "";
				
				// if is DEV		
				if (!billPost.isExcludeCost()) {
					
					if (billPost.getConditionType().equals(FMUUtil.DEV_CREDIT_LETTER) || billPost.getConditionType().equals(FMUUtil.DEV_CASH_LETTER)) {
						
						if (billPost.getTipoMo().equals(FMUUtil.CANCEL_BILL_CODE)) {
							totalAfterBill = productAvailability.getAvailable() - billPost.getBillQuantity();
							totalGlobalCost = productCost.getGlobalCost() - billPost.getVALORG();
							mathAction = "+";
							updateOriginalBillReturnQuantity(em, billPost, "-");
						} else {
							totalAfterBill = productAvailability.getAvailable() + billPost.getBillQuantity();
							totalGlobalCost = productCost.getGlobalCost() + billPost.getVALORG();
							mathAction = "-";
							updateOriginalBillReturnQuantity(em, billPost, "+");
						}
					
						billPost.setReturnQuantity(0);
					
					} else {
					
						if (billPost.getTipoMo().equals(FMUUtil.CANCEL_BILL_CODE)) {
							totalAfterBill = productAvailability.getAvailable() + billPost.getBillQuantity();
							mathAction = "-";
							totalGlobalCost = productCost.getGlobalCost() + billPost.getVALORG();
						} else {
							totalAfterBill = productAvailability.getAvailable() - billPost.getBillQuantity();
							mathAction = "+";
							totalGlobalCost = productCost.getGlobalCost() - billPost.getVALORG();
						}			
					}
				}
				
				if (billPost.getTipoMo().equals(FMUUtil.CANCEL_BILL_CODE)) {
					// update status
					updateBillCancelStatus(em, billPost);
					billPost.setStatcv("A");
				}
						
				// Total COST
				billPost.setCOSTGD(!billPost.isExcludeCost() ? (
						new BigDecimal(format.format(totalAfterBill)).multiply(
								new BigDecimal(format.format(productCost.getUniqueCost()))).floatValue()) : 0);
				
				billPost.setCOSTUD(!billPost.isExcludeCost() ? productCost.getUniqueCost() : 0);
				billPost.setEXISTD(totalAfterBill);
				billPost.settCostoCR(!billPost.isExcludeCost() ? (getTotalCostByBill(billHeader.getBillPosts(), billPost.getBillId(), em)) : 0);
				billPost.settCosto(!billPost.isExcludeCost() ? billPost.gettCostoCR() / billPost.getExchange() : 0);
				
				try {
									
					if (!billPost.isExcludeCost()) {
						updateProductCellarAvailable(em, totalAfterBill, productAvailability, billPost); 
						updateTotalCost(em, totalGlobalCost, billPost, mathAction, productCost.getUniqueCost());
					}
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
								
				insertBill(em, billPost, batchNumber);	
				
				if (billPost.getDiscountCode() !=0) {
					updateDiscountCode(em, billPost.getJdCompanyId(), billPost.getJdBranchId(), billPost.getTypeCode(), billPost.getUserId(),
							billPost.getCellarId(), billPost.getDiscountCode(), billPost.getHora(), billPost.getBillId());
				}
			}
			
			bill.setBillId(String.valueOf(billHeader.getBillId()));
			bill.setCompanyId(billHeader.getCompanyId());
			bill.setClientId(billHeader.getClientId());
			
			bill.setState(true);

			bill.setMovementType(billHeader.getTypeMove());
			
			// If is credit bill
			String payCondition = billHeader.getBillPosts().get(0).getConditionType();
			
			if ((payCondition.equals(FMUUtil.CREDIT_LETTER) || payCondition.equals(FMUUtil.DEV_CREDIT_LETTER)) &&
					billHeader.getTypeMove().equals(FMUUtil.MAKE_BILL_ACTION_ID) && billHeader.getCreditBills() !=null) {

				// Insert credit bill
				String userId = billHeader.getBillPosts().get(0).getUserId();
				String softwareId = billHeader.getBillPosts().get(0).getSoftwareId();

				cajaManager.createCreditBillRow(idJsonLog, em, billHeader.getFeedAmount(), billHeader.getDaysLimit(),
						billHeader.getCashId(), billHeader.getCreditBills(), userId, softwareId, billHeader.getBillPosts().get(0), batchNumber);			
			}
			
			// If bill is saved correctly , let's create c bill
			if (bill.isState()) {
				// save Cash
				if (billHeader.getTypeMove().equals(FMUUtil.CANCEL_BILL_CODE)) {
					CalendarData_ja.setCajaBillAsCancel(billHeader, em);
					
					if (payCondition.equals(FMUUtil.CREDIT_LETTER) || payCondition.equals(FMUUtil.DEV_CREDIT_LETTER)) {
						ClsCreditManager.deleteAccountMovementCredit(em, Integer.parseInt(bill.getBillId()), bill.getClientId());
					}
					
				} else {
					if (CalendarData_ja.cajaBillExists(billHeader, em) == 0)  {
						CalendarData_ja.insertCajaFactura(billHeader, em);
					}	
				}
			}
			
			bill.setErrorMsg(getErrorMsg());
			
			if (bill.getErrorMsg().equals("") && bill.getErrorMsg().length() == 0) {
				utx.commit();
			} else {
				addLogItem(billPostItem.getCellarId(), getErrorMsg(), billPostItem.getUserId(), 
						String.valueOf(billPostItem.getBillId()), billPostItem.getBranchId(), billPostItem.getCompanyId());
				
				utx.rollback();
			}
						
			billListPostReturns.add(bill);
		}

		return billListPostReturns;
	}
	
	/**
	 * Log Item
	 * @param cellarId
	 * @param textMessage
	 * @param userId
	 * @param billId
	 * @param branchId
	 * @param companyId
	 */
	private void addLogItem(String cellarId, String textMessage, String userId, String billId, String branchId, String companyId) {
		clsLogs.insertErrorLogDetail(cellarId,  FMUUtil.getSubsString(textMessage), 
				userId, branchId, FMUUtil.BILL_CODE, billId, 
				companyId);
	}
	
	
	/**
	 * Check product available for particular item.
	 * @param em
	 * @param ProductId
	 * @param branchId
	 * @param cellarId
	 * @param companyId
	 * @return
	 * @throws Exception
	 */
	public ProductAvailability getProductAvailability(EntityManager em, String ProductId, String branchId, String cellarId, String companyId) throws Exception {
		ProductAvailability productAvailability = new ProductAvailability();	
		try {
			
			String sQuery = "select bcompan companyId, bsucurs branchId, bbodega cellarId, binopar productId, bexistee available "
					+ "from  " + CollectionScheme.SchemeInventario + ".invd03 where bsucurs = ? and binopar = ? and bbodega = ? and bcompan = ?"
							+ " FOR READ ONLY";
			productAvailability = (ProductAvailability) em.createNativeQuery(sQuery, ProductAvailability.class).setParameter(1, branchId).setParameter(2, ProductId).setParameter(3, cellarId).setParameter(4, companyId).getSingleResult();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage());
		}
		return productAvailability;
	}
	
	public ProductCost getProductCost(EntityManager em, String companyId, String ProductId, String branchId) throws Exception {
		ProductCost productCost = new ProductCost();	
		
		String table = companyId.equals("01") ? CollectionScheme.SchemeInventario + ".invd01" :  CollectionScheme.SchemeInventario + ".invv01";
		String sQuery = "";
		
		try {
			
			if (branchId.equals(FMUUtil.CPD_BRANCH_CODE)) {
				
				sQuery = "select "
						+ "a.icompan companyId, "
						+ "a.inopar productId,"
						+ "a.icateg categoryId, "
						+ "a.icosul uniqueCost, "
						+ "a.icostg globalCost "
						+ "from  " + table  +  " a "
								+ "where a.inopar = ? and a.icompan = ? FOR READ ONLY";
				
			 	productCost = (ProductCost) em.createNativeQuery(sQuery, ProductCost.class)
			 			.setParameter(1, ProductId)
			 			.setParameter(2, companyId).getSingleResult();

			} else {
				
				 sQuery = "select "
				 		+ "a.scompan companyId, "
				 		+ "a.sinopar productId, "
				 		+ "IFNULL(b.icateg,'') categoryId, "
				 		+ "a.sscul00 uniqueCost, "
				 		+ "a.sscgl00 globalCost "
							
				 		+ "from " + CollectionScheme.SchemeInventario + ".invd02 a "
									+ "left outer join " + table + " b on "
											+ "b.inopar = a.sinopar "
											+ "where a.ssucurs = ? and a.sinopar = ? and scompan = ? FOR READ ONLY";
				
				 productCost = (ProductCost) em.createNativeQuery(sQuery, ProductCost.class).setParameter(1, branchId).setParameter(2, ProductId).setParameter(3, companyId).getSingleResult();
			}
		}

		catch (Exception e) {
			// TODO: handle exception
			setErrorMsg(e.getMessage() + " - SELECT COST");
		}

		return productCost;
	}

	private void updateBillCancelStatus(EntityManager em, BillPost billPost) throws Exception {
		try {
						
			String sQuery = "UPDATE " + CollectionScheme.SchemeInventario + ".invd35 set STATUA = ? "
					+ "where compan = ? and sucurs = ? and bodega = ? and docume = ? and fecham = ?  and TIPOMO = '21";
			
			em.createNativeQuery(sQuery).
					setParameter(1, "A").
					setParameter(2, billPost.getCompanyId()).
					setParameter(3, billPost.getBranchId()).
					setParameter(4, billPost.getCellarId()).
					setParameter(5, billPost.getBillId()).
					setParameter(6, billPost.getDate()).
					executeUpdate();
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage() + " - UPDATE CANCEL STATUS BILL");
		}	
	}
	
	/**
	 * Update product Amount
	 * @param em
	 * @param total
	 * @param product
	 * @return
	 * @throws Exception
	 */
	private void updateProductCellarAvailable(EntityManager em, int total, ProductAvailability product, BillPost billPost) throws Exception {
		try {
			String sQuery = "UPDATE " + CollectionScheme.SchemeInventario + ".invd03 set bexistee = ? "
					+ "where bsucurs = ? "
					+ "and bbodega = ? "
					+ "and binopar = ?";
			
			 em.createNativeQuery(sQuery).
					setParameter(1, total).
					setParameter(2, product.getBranchId()).
					setParameter(3, product.getCellarId()).
					setParameter(4, product.getProductId()).
					executeUpdate();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage() + " - UPDATE AMOUNT INVD03");
			addLogItem(billPost.getCellarId(), e.getMessage(), billPost.getUserId(), String.valueOf(billPost.getBillId()), billPost.getBranchId(), 
					billPost.getCompanyId());
		}	
	}
	
	/**
	 * Update cost Amount
	 * @param em
	 * @param totalCost
	 * @param billPost
	 * @param mathAction
	 * @param uniqueCost 
	 * @return
	 * @throws Exception
	 */
	private void updateTotalCost(EntityManager em, float totalCost, BillPost billPost, String mathAction, float uniqueCost) throws Exception {
		try {
			
			String sQuery = null;
			
			String updateDailySell = "";			
			
			
			if (billPost.getBranchId().equals(FMUUtil.CPD_BRANCH_CODE)) {
				
				updateDailySell = " ivmesa = ivmesa " + mathAction +  " " + billPost.getBillQuantity();	
				String table = billPost.getCompanyId().equals("01") ? "invd01" : "invv01";
				
				sQuery = "UPDATE " + CollectionScheme.SchemeInventario + "." + table + " set icostg = ?, "
						+ "usumod = ?, "
						+ "IFEULS1 = ?, "
						+ "IFECFA1 = ?, " + updateDailySell
						+ " WHERE inopar = ? and icompan = ?";
							
				em.createNativeQuery(sQuery).setParameter(1, totalCost).setParameter(2, billPost.getUserId()).setParameter(3, billPost.getDate()).setParameter(4, billPost.getDate()).setParameter(5, billPost.getProductId()).setParameter(6, billPost.getCompanyId()).executeUpdate();

			} else {
								
				if (billPost.getConditionType().equals(FMUUtil.DEV_CREDIT_LETTER) || billPost.getConditionType().equals(FMUUtil.DEV_CASH_LETTER)) {
					sQuery += " AND SSUEL00 = " + billPost.getDate();
				}
				
				updateDailySell = ", SSVML00 = SSVML00 " + mathAction + " " + billPost.getBillQuantity();	
				
				System.out.println("Entro 1 : " +totalCost );
				
				String globalCostoLong = String.valueOf(totalCost).concat("000000");
				String uniqueCostLong = String.valueOf(uniqueCost).concat("000000");

				
				sQuery = "UPDATE " + CollectionScheme.SchemeInventario + ".invd02 "
						+ "set sscgl00 = ?, "
						+ "SSCGl00NL = ?,  "
						+ "SSCUL00NL = ?,  " 
						+ "SSUSL00 = ?, "
						+ "SSUFL00 = ?  " 
						+ updateDailySell
						+ " where ssucurs = ? and sinopar = ? and SCOMPAN = ? ";		
				
				em.createNativeQuery(sQuery).
						setParameter(1, totalCost).
						setParameter(2, globalCostoLong).
						setParameter(3, uniqueCostLong).
						setParameter(4, billPost.getDate()).
						setParameter(5, billPost.getDate()).
						setParameter(6, billPost.getBranchId()).
						setParameter(7, billPost.getProductId()).
						setParameter(8, billPost.getCompanyId()).
						executeUpdate();
			}
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage() + " -  UPDATE COST");
			addLogItem(billPost.getCellarId(), (e.getMessage() + "-  UPDATE COST"), billPost.getUserId(), String.valueOf(billPost.getBillId()), billPost.getBranchId(), 
					billPost.getCompanyId());
			
		}	
	}
	/**
	 * Actualizar sequencia de factura en ( + 1)
	 * @param em
	 * @param billPost
	 * @return
	 * @throws Exception
	 */
	private void updateSequence(EntityManager em, BillPost billPost, boolean increase) throws Exception {
		try {
			
			String updateQuery = " numcon = (numcon + 1) ";
			
			if (increase) {
				updateQuery = " numcon = " + (billPost.getBillId() + 1) + " ";
			}
			
			String sQuery = "update " + CollectionScheme.SchemeInventario + ".invcon "
					+ "set " + updateQuery
					+ "where compa = ? and sucur = ? and bodeg = ? and tipom='21'";
			 em.createNativeQuery(sQuery).
					setParameter(1, billPost.getCompanyId()).
					setParameter(2, billPost.getBranchId()).
					setParameter(3, billPost.getCellarId()).executeUpdate();
			
			validateSequenceNumber(billPost.getCompanyId(), billPost.getBranchId(), billPost.getCellarId(),
					billPost.getBillId(), billPost);
			
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage());
		}	
	}
	
	private void validateSequenceNumber(String companyId, String branchId, String cellarId, int billId, BillPost billPost) {
		
		List<Object> object = new ArrayList<Object>();;
	
		String billDates = "Select Numcon From " + CollectionScheme.SchemeInventario + ".invcon where "
				+ "compa='" + companyId + "' and sucur='" + branchId + "' and bodeg='" + cellarId + "' and tipom='21'";

		object = em.createNativeQuery(billDates, Object.class).getResultList();
		
		int secuenceNumber = object.get(0) == null ? 0 : Integer.parseInt(object.get(0).toString());

		try {
			if (secuenceNumber == billId) {
				updateSequence(em, billPost, false);

			} else if (secuenceNumber < billId) {				
				updateSequence(em, billPost, true);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	/**
	 * Get total cost
	 * @param billPostList
	 * @param billPost
	 * @return 
	 */
	private float getTotalCostByBill(List<BillPost> billPostList, int billId, EntityManager em) {
		float total = 0;
		for (BillPost billPostItem : billPostList) {
			if (billPostItem.getBillId() == billId) {
				try {
					ProductCost productCost = getProductCost(em, billPostItem.getCompanyId(), billPostItem.getProductId(), billPostItem.getBranchId());
					total += (new BigDecimal(format.format(billPostItem.getBillQuantity())).multiply(
							new BigDecimal(format.format(productCost.getUniqueCost()))).floatValue());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					setErrorMsg(e.getMessage() + " -  SELECT COST");
					return 0;
				}
			}
		}
					
		return total;
	}
	/**
	 * Bill Action
	 * @param em 
	 * @param string 
	 */
	private void updateOriginalBillReturnQuantity(EntityManager em, BillPost billPost, String action) {
		try {
						
			String sQuery = "UPDATE " + CollectionScheme.SchemeInventario +  ".invd35 set CANVEN = CANVEN " + action + " ? "
					+ "where compan = ? "
					+ "and sucurs = ? and bodega = ? and docume = ? and NPARTE = ?"
					+ " and HISECUE = ?  and TIPOMO='21'";
		
			em.createNativeQuery(sQuery).
					setParameter(1, billPost.getReturnQuantity()).
					setParameter(2, billPost.getCompanyId()).
					setParameter(3, billPost.getBranchId()).
					setParameter(4, billPost.getCellarId()).
					setParameter(5, billPost.getNfactu()).
					setParameter(6, billPost.getProductId()).
					setParameter(7, billPost.getReturnSequenceId())

					.executeUpdate();
		}

		catch (Exception e) {
			// TODO: handle exception
			setErrorMsg(e.getMessage());
			e.printStackTrace();
		}	
	}
	
	/**
	 * Insert bill
	 * @param em
	 * @param billPost
	 * @param batchNumber 
	 * @return
	 */
	private void insertBill(EntityManager em, BillPost billPost, int batchNumber) {
		try {

			String sQuery = "INSERT INTO " + CollectionScheme.SchemeInventario + ".invd35 (" +
				"COMPAN," +
				"SUCURS," +
				"DEPART," +
				"BODEGA," +
				"TIPOMO," +
				"TIPOMV," +
				"DOCUME," +
				"FECHAM," +
				"HISECUE," +
				"NPARTE," +
				"ISTAT2," +
				"COSTGA," +
				"COSTUA," +
				"EXISTA," +
				"VALORG," +
				"VALORU," +
				"CANTID," +
				"CANVEN," +
				"COSTGD," +
				"COSTUD," +
				"EXISTD," +
				"STATUA," +
				"TIPOCA," +
				"HORAM," +
				"PANTAL," +
				"HECHOP," +
				"NPROGR," +
				"VENDED," +
				"CVENDED," +
				"CLCLIE," +
				"CLNOMB," +
				"TIPOFA," +
				"TIPOFD," +
				"CONDPAGO," +
				"DESCUE," +
				"IMPUES," +
				"PRECIO," +
				"PRECIOUF," +
				"CODMONEDA," +
				"TFACTU," +
				"TDESCU," +
				"TIGV," +
				"TCOSTO," +
				"TFACTUF," +
				"TDESCUF," +
				"TIGVF," +
				"TCOSTOF," +
				"ISTAT4," +
				"FECHAA," +
				"NLIQUI," +
				"NFACTU," +
				"IFECHR," +
				"IHORAR," +
				"STATIN," +
				"NBATCH," +
				"STATCV," +
				"CVCANAL," +
				"HCODCOMBO ," +
				"INDCT) " +
				
		"VALUES ('" + billPost.getCompanyId() + "', " +
			 		"'" + billPost.getBranchId() + "', " +
			 		"'" + billPost.getLineId() + "', " +
			 		"'" + billPost.getCellarId() + "', " +
			 		"'" + billPost.getTipoMo() + "', " +
			 		"'" + billPost.getTipoMV() + "', " +
			 		" " + billPost.getBillId() + ", " +
			 		" " + billPost.getDate() + ", " +
			 		" " + billPost.getSequenceId() + ", " +
			 		"'" + billPost.getProductId() + "', " +
			 		"'" + billPost.getISTAT2() + "', " +
			 		" " + billPost.getCOSTGA() + ", " +
			 		" " + billPost.getCOSTUA() + ", " +
			 		" " + billPost.getEXISTA() + ", " +
			 		" " + billPost.getVALORG() + ", " +
			 		" " + billPost.getVALORU() + ", " +
			 		" " + billPost.getBillQuantity() + ", " +
			 		" " + billPost.getReturnQuantity() + ", " +
			 		" " + billPost.getCOSTGD() + ", " +
			 		" " + billPost.getCOSTUD() + ", " +
			 		" " + billPost.getEXISTD() + ", " +
			 		"'" + billPost.getCancelState() + "', " +
			 		" " + String.format("%.4f", billPost.getExchange()) + ", " +
			 		" " + billPost.getHora() + ", " +
			 		"'" + billPost.getDeviceId() + "', " +
			 		"'" + billPost.getUserId() + "', " +
			 		"'" + billPost.getSoftwareId() + "', " +
			 		"'" + billPost.getSellerId() + "', " +
			 		" " + billPost.getSellerNumber() + ", " +
			 		" " + billPost.getClientId() + ", " +
			 		"'" + billPost.getClientName() + "', " +
			 		"'" + billPost.getIstat1() + "', " +
			 		"'" + billPost.getConditionType() + "', " +
			 		"'" + billPost.getCreditPayCondition() + "', " +
			 		" " + billPost.getDiscountPercent() + ", " +
			 		" " + (billPost.getIva()) + ", " +
			 		" " + (billPost.getPriceCR() / 100)+ ", " +
			 		" " + ((FMUUtil.COR_COIN_ID.compareToIgnoreCase(billPost.getCoin()) == 0 ? 0 : billPost.getPrice()) / 100) + ", " +
			 		"'" + billPost.getCoin() + "', " +
			 		" " + (billPost.getTotalCR() / 100)+ ", " +
			 		" " + (billPost.getTotalDiscountCR() /100) + ", " +
			 		" " + (billPost.getTotalIvaCR() /100) + ", " +
			 		" " + billPost.gettCostoCR() + ", " +
			 		" " + ((FMUUtil.COR_COIN_ID.compareToIgnoreCase(billPost.getCoin()) == 0 ? 0 : billPost.getTotal()) / 100) + ", " +
			 		" " + ((FMUUtil.COR_COIN_ID.compareToIgnoreCase(billPost.getCoin()) == 0 ? 0 : billPost.getTotalDiscount()) / 100)+ ", " +
			 		" " + ((FMUUtil.COR_COIN_ID.compareToIgnoreCase(billPost.getCoin()) == 0 ? 0 : billPost.getTotalIva()) / 100)+ ", " +
			 		" " + billPost.gettCosto() + ", " +
			 		"'" + billPost.getIstat4() + "', " +
			 		" " + billPost.getDateDev() + ", " +
			 		"'" + billPost.getCoin() + "', " +
			 		" " + billPost.getNfactu() + ", " +
			 		" " + billPost.getBillItemId() + ", " +
			 		" " + billPost.getReturnSequenceId() + ", " +
			 		"'" + (billPost.getConditionType().equals(FMUUtil.CREDIT_LETTER) || 
			 				billPost.getConditionType().equals(FMUUtil.DEV_CREDIT_LETTER) ? "F" : "") + "', " +
			 		"" +  batchNumber + ", " +
			 		"'" +  billPost.getStatcv() + "', " +
			 		"'" + "R" + "', " +
			 		"'" +  billPost.getComboId() + "', " +
			 		"'" + billPost.getIndct() + "')";
	
		 em.createNativeQuery(sQuery).executeUpdate();

		} catch (Exception e) {
		// TODO: handle exception
			setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void debugBillPost(BillPost billPost) {
		System.out.println("BILL :  " + billPost.getBillId()  +  " - IFECHR-DetailBillId : : " +  billPost.getBillItemId());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - ISTAT2 : : " +  billPost.getISTAT2());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - COMPAN : : " +  	billPost.getCompanyId());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - SUCURS : : " +  billPost.getBranchId());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - DEPART : : " +  billPost.getLineId());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - BODEGA : : " +  billPost.getCellarId());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - TIPOMO : : " +  billPost.getTipoMo());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - TIPOMV : : " +  billPost.getTipoMV());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - DOCUME : : " +  billPost.getBillId());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - FECHAM : : " +  billPost.getDate());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - HISECUE : : " +  billPost.getSequenceId());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - NPARTE : : " +  billPost.getProductId());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - COSTGA : : " +  billPost.getCOSTGA());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - COSTUA : : " +  billPost.getCOSTUA());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - EXISTA : : " +  billPost.getEXISTA());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - VALORG : : " +  billPost.getVALORG());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - VALORU : : " +  billPost.getVALORU());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - CANTID : : " +  billPost.getBillQuantity());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - CANVEN : : " +  billPost.getReturnQuantity());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - COSTGD : : " +  billPost.getCOSTGD());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - COSTUD : : " +  billPost.getCOSTUD());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - EXISTD : : " +  billPost.getEXISTD());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - STATUA : : " +  billPost.getCancelState());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - TIPOCA : : " +  String.format("%.4f", billPost.getExchange()));
		System.out.println("BILL :  " + billPost.getBillId()  +  " - HORAM : : " +  billPost.getHora());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - PANTAL : : " +  billPost.getDeviceId());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - HECHOP : : " +  billPost.getUserId());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - NPROGR : : " +  billPost.getSoftwareId());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - VENDED : : " +  billPost.getSellerId());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - CVENDED : : " +  billPost.getSellerNumber());
		
		System.out.println("BILL :  " + billPost.getBillId()  +  " - CLCLIE  : " +  billPost.getClientId());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - CLNOMB  : " +  billPost.getClientName());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - TIPOFA  : " +  billPost.getIstat1());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - TIPOFD  : " +  billPost.getConditionType());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - CONDPAGO  : " +  billPost.getCreditPayCondition());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - DESCUE  : " +  billPost.getDiscountPercent());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - IMPUES  : " +  billPost.getIva());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - PRECIO  : " +  (billPost.getPriceCR() / 100));
		System.out.println("BILL :  " + billPost.getBillId()  +  " - PRECIOUF  : " +  (billPost.getPrice() / 100));
		System.out.println("BILL :  " + billPost.getBillId()  +  " - CODMONEDA  : " +  billPost.getCoin());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - TFACTU  : " +  (billPost.getTotalCR() / 100));
		System.out.println("BILL :  " + billPost.getBillId()  +  " - TDESCU  : " +  (billPost.getTotalDiscountCR() / 100));
		System.out.println("BILL :  " + billPost.getBillId()  +  " - TIGV  : " +  (billPost.getTotalIvaCR() / 100));
		System.out.println("BILL :  " + billPost.getBillId()  +  " - TCOSTO  : " +  billPost.gettCostoCR());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - TFACTUF  : " +  (billPost.getTotal() / 100));
		System.out.println("BILL :  " + billPost.getBillId()  +  " - TDESCUF  : " +  (billPost.getTotalDiscount() / 100));
		System.out.println("BILL :  " + billPost.getBillId()  +  " - TIGVF  : " +  (billPost.getTotalIva() / 100));
		System.out.println("BILL :  " + billPost.getBillId()  +  " - TCOSTOF  : " +  billPost.gettCosto());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - ISTAT4  : " +  billPost.getIstat4());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - FECHAA  : " +  billPost.getDateDev());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - NLIQUI  : " +  billPost.getCoin());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - NFACTU  : " +  billPost.getNfactu());
		System.out.println("BILL :  " + billPost.getBillId()  +  " - INDCT  : " +  billPost.getIndct());
	
	}
	
	/**
	 * Check if bill exist
	 * @param em
	 * @param billPost
	 * @return
	 */
	private int checkIfBillRowExists(EntityManager em, BillPost billPost) {
		try {
			String sQuery = "SELECT * from  "+ CollectionScheme.SchemeInventario + ".invd35 "
					+ "where sucurs = ? and compan = ? "
					+ "and bodega = ? and docume = ?  and tipomo = ? and fecham = ?";
			return em.createNativeQuery(sQuery).
					setParameter(1, billPost.getBranchId()).
					setParameter(2, billPost.getCompanyId()).
					setParameter(3, billPost.getCellarId()).
					setParameter(4, billPost.getBillId()).
					setParameter(5, billPost.getTipoMo()).
					setParameter(6, FMUUtil.getIntegerDate()).
					getResultList().size();
		} catch (Exception e) {
		// TODO: handle exception
			setErrorMsg(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	
	/**
	 * Update discount  code
	 * @param em
	 * @param billPost
	 */
	public static int updateDiscountCode(EntityManager em, String jdCompamyId, String jdBranchId, 
			String type, String userId, String cellarId, int code, int hour, int foreign_key) {
	try {
		 String sQuery = "UPDATE  "  + CollectionScheme.GCPFMU_SCHEMA +  ".authorization_codes "
		 		+ "set status = 1, "
		 		+ "company_d = ?, "
		 		+ "branch_id = ?, hour = ?,  "
		 		+ "type = ?, "
		 		+ "foreign_key = ? "
		 			+ "where user_id = ? "
		 				+ "and cellar_id = ? and code_id = ? ";
		
		 int result = em.createNativeQuery(sQuery).
		 setParameter(1, jdCompamyId).
		 setParameter(2, jdBranchId).
		 setParameter(3, hour).
		 setParameter(4, type).
		 setParameter(5, foreign_key).
		 setParameter(6, userId).	
		 setParameter(7, cellarId).
		 setParameter(8, code).

		 executeUpdate();
		 
		return result;
		 
	} catch (Exception e) {
		// TODO: handle exception
			setErrorMsg(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	
	}
	
	/**
	 * Get bills from particular cellarId
	 * @param branchId
	 * @param cellarId
	 * @param companyIds
	 * @param zoneId
	 * @return
	 * @throws Exception
	 */
	public List<BillHeader> geBillsByCellar (String branchId, 
			String cellarId, String companyIds, String zoneId, String sellerId) throws Exception {
		
		List<BillPost> billPosts = new ArrayList<BillPost>();
		List<BillHeader> finalBillList = new ArrayList<BillHeader>();
				
		List<Object> object = new ArrayList<Object>();;

		companyIds = "(" + companyIds + ")";

		String billDates = "SELECT TRIM(value) from " + CollectionScheme.GCPFMU_SCHEMA + ".setting "
				+ "where name = 'BILL_DAYS'";

		object = em.createNativeQuery(billDates, Object.class).getResultList();
		
		int dayFilter = object.get(0) == null ? 0 : Integer.parseInt(object.get(0).toString());
				
		try {
			
			String queryBills = "SELECT "
					+ "a.COMPAN companyId, "
					+ "a.SUCURS branchId, "
					+ "a.DEPART lineId,"
					+ "TRIM(a.BODEGA) cellarId," 
					+ "TRIM(a.TIPOMO) tipoMo," 
					+ "TRIM(a.TIPOMV) tipoMV," 
					+ "a.DOCUME billId," 
					+ "a.FECHAM date,"
					+ "HISECUE sequenceId," 
					+ "IHORAR returnSequenceId," 
					+ "TRIM(NPARTE) productId," 
					+ "CANTID billQuantity,"
					+ "CANVEN returnQuantity," 
					+ "TRIM(STATUA) cancelState," 
					+ "TIPOCA exchange," 
					+ "HORAM hora,"
					+ "TRIM(PANTAL) deviceId, "
					+ "TRIM(NPROGR) softwareId," 
					+ "TRIM(VENDED) sellerId," 
					+ "CVENDED sellerNumber," 
					+ "CLCLIE clientId,"
					+ "TRIM(CLNOMB) clientName," 
					+ "TIPOFA istat1," 
					+ "TRIM(TIPOFD) conditionType,"
					+ "TRIM(CONDPAGO) creditPayCondition," 
					+ "DESCUE discountPercent," 
					+ "IMPUES iva,"
					+ "PRECIO priceCR," 
					+ "PRECIOUF price," 
					+ "CODMONEDA coin," 
					+ "TFACTU totalCR,"
					+ "TDESCU totalDiscountCR," 
					+ "TIGV totalIvaCR," 
					+ "TFACTUF total," 
					+ "TDESCUF totalDiscount,"
					+ "TIGVF totalIva," 
					+ "TRIM(ISTAT4) istat4," 
					+ "FECHAA dateDev," 
					+ "TRIM(NLIQUI) coin,"
					+ "NFACTU nfactu," 
					+ "IFECHR billItemId, "
					+ "INDCT indct, "
					+ "IFNULL(TRIM(b.IDESCR), "
					+ "TRIM(c.IDESCR)) productName, "
					+ "IFNULL(TRIM(b.IDESCI), "
					+ "TRIM(c.IDESCI)) productDescription, "
					+ "IFNULL(TRIM(b.IUMEDIDAC), "
					+ "TRIM(c.IUMEDIDAC)) measureType,"
					+ " IFNULL(TRIM(b.IGRUPO02), "
					+ "TRIM(c.IGRUPO02)) brandId, "
					
					+ " (SELECT  IFNULL(TRIM(JDDEPART), '') FROM  " + CollectionScheme.SchemeInventario + ".invd00 WHERE CODTAB ='001' and nivel=4 and compan=a.COMPAN  and sucurs=a.SUCURS and depart=a.DEPART) jdLineId, " 
					+ " (SELECT  IFNULL(TRIM(JDSUCURS), '') FROM  " + CollectionScheme.SchemeInventario + ".invd00 WHERE CODTAB ='001' and nivel=4 and compan=a.COMPAN  and sucurs=a.SUCURS and depart=a.DEPART) jdBranchId, " 
					+ " (SELECT  IFNULL(TRIM(JDCOMPAN), '') FROM  " + CollectionScheme.SchemeInventario + ".invd00 WHERE CODTAB ='001' and nivel=4 and compan=a.COMPAN  and sucurs=a.SUCURS and depart=a.DEPART) jdCompanyId, " 
							
					+ " (select IFNULL(TRIM(DRDl01), '') from " + CollectionScheme.SchemeJDECOM + ".f0005 where drsy='00'  and drrt='01' and TRIM(drky) = "
							+ "(SELECT  IFNULL(TRIM(JDCOMPAN), '') FROM  " + CollectionScheme.SchemeInventario + ".invd00 WHERE CODTAB ='001' and nivel=4 and compan=a.COMPAN  and sucurs=a.SUCURS and depart=a.DEPART)) "
									+ "jdCompanyName, " 				
					
					+ " (SELECT  IFNULL(TRIM(mcdl01), '') FROM  " + CollectionScheme.SchemeJDE + ".f0006  where TRIM(mcmcu) like "
							+ " (SELECT  IFNULL(TRIM(JDDEPART), '') FROM  " + CollectionScheme.SchemeInventario + ".invd00 WHERE CODTAB ='001' and nivel=4 and compan=a.COMPAN  and sucurs=a.SUCURS and depart=a.DEPART)"
									+ " and TRIM(mcrp01) = (SELECT  IFNULL(TRIM(JDCOMPAN), '') FROM  " + CollectionScheme.SchemeInventario + ".invd00 WHERE CODTAB ='001' and nivel=4 and compan=a.COMPAN  and sucurs=a.SUCURS and depart=a.DEPART)) jdLineName, " 

					+ " (Select  TRIM(czona) from  "+ CollectionScheme.SchemeInventario + ".invd43  where cclien = CLCLIE  and TRIM(czona)= '" + zoneId + "'  fetch first 1 rows only) zoneId,"
					+ " (Select  CAST(NUMREC AS VARCHAR(25))  from " + CollectionScheme.SchemeCAJA + ".RECIBOFAC  where codcli = CLCLIE and numfac = DOCUME "
							+ " AND  caid = (SELECT  cast(caid  as integer)   FROM " + CollectionScheme.SchemeCAJA + ".F55CA01 WHERE CACATI = " + sellerId + " fetch first 1 rows only)    AND estado ='' and "
							+ "		CODCOMP = (SELECT  IFNULL(TRIM(JDCOMPAN), '') FROM  " + CollectionScheme.SchemeInventario + ".invd00 WHERE CODTAB ='001' and nivel=4 and compan=a.COMPAN  and sucurs=a.SUCURS and depart=a.DEPART)  fetch first 1 rows only) receiptNumber"
					
					+ " from " + CollectionScheme.SchemeInventario + ".invd35 a left outer join " 
					
					+ CollectionScheme.SchemeInventario + ".INVD01 b on b.INOPAR = NPARTE"
					+ " left outer join " + CollectionScheme.SchemeInventario + ".INVV01 c on c.INOPAR = NPARTE "
					+ "where a.SUCURS = " + branchId + " and  a.COMPAN in " + companyIds + "  AND a.BODEGA = ?  AND  a.tipomo in ('21','AF')  and a.fecham >= "
					+ FMUUtil.getIntegerDateFromDays(dayFilter) + " AND a.fecham <=" + FMUUtil.getIntegerDate()
					+ "  AND a.PANTAL = 'FMU' ORDER  BY a.fecham desc, a.docume ASC, a.tipoMo ASC";
			
			billPosts = em.createNativeQuery(queryBills, BillPost.class).setParameter(1, cellarId).getResultList();
			
	
			HashMap<MapKeyUtil, List<BillPost>> map = new HashMap<MapKeyUtil, List<BillPost>>();

			for (BillPost billPost : billPosts) {
			
				String key = String.valueOf(billPost.getBillId());
				String key2 = String.valueOf(billPost.getCompanyId());
				
				MapKeyUtil mapKey = new MapKeyUtil();
				mapKey.setKey1(key);
				mapKey.setKey2(key2);

				put(mapKey, billPost, map);
			}
						
			for (Entry<MapKeyUtil, List<BillPost>> entry : map.entrySet()) {
				
				BillHeader billHeaderitem = new BillHeader();
				billHeaderitem.setBillId(Integer.parseInt(entry.getKey().getKey1().toString()));
				List<BillPost> billPostsData = entry.getValue();
				billHeaderitem.setBillPosts(billPostsData);

				finalBillList.add(billHeaderitem);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage());
			throw new Exception(e.getMessage());
		}

		return finalBillList;
	}
	
	
	
	/**
	 * Create {@link HashMap} Two Keys
	 * @param mapKey2	
	 * @param list
	 * @param mapWithTwoKeys
	 */
	private static void put(MapKeyUtil mapKey2, BillPost list, HashMap<MapKeyUtil, List<BillPost>> mapWithTwoKeys) {
		if (mapWithTwoKeys.get(mapKey2) == null) {
			List<BillPost> listAll = new ArrayList<BillPost>();
			listAll.add(list);
		    mapWithTwoKeys.put(mapKey2, listAll);
		} else { 
			mapWithTwoKeys.get(mapKey2).add(list);
		}
	}

	public static String getErrorMsg() {
		return errorMsg;
	}

	public static void setErrorMsg(String errorMsg) {
		ClsBillManager.errorMsg = errorMsg;
	}
}