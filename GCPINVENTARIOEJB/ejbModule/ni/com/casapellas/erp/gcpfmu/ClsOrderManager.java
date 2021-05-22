package ni.com.casapellas.erp.gcpfmu;


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
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import ni.com.casapellas.gcpfmu.pojo.FMUUtil;
import ni.com.casapellas.gcpfmu.pojo.Order;
import ni.com.casapellas.gcpfmu.pojo.OrderDetail;
import ni.com.casapellas.gcpfmu.pojo.OrderReservation;
import ni.com.casapellas.gcpfmu.pojo.OrderReservationConfig;
import ni.com.casapellas.gcpfmu.pojo.PostObjectReturn;
import ni.com.casapellas.util.CollectionScheme;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN) 
@SuppressWarnings({"unchecked"})
public class ClsOrderManager {

	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;

	@Resource 
	private SessionContext sessionContext;  
	
	@EJB
	private ClsLogs clsLogs;
	
	private static String errorMsg;


	@Inject
	public ClsOrderManager() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param PostObjectReturn
	 * @return
	 * @throws Exception
	 */
	public List<PostObjectReturn> createOrder(List<ni.com.casapellas.gcpfmu.pojo.Order> orders, List<Order> cancelOrderList) throws Exception {
		List<PostObjectReturn> billListPostReturns = new ArrayList<PostObjectReturn>();	

		UserTransaction utx = sessionContext.getUserTransaction();

		for (Order order : orders) {
			
			PostObjectReturn orderList = new PostObjectReturn();
			
			setErrorMsg("");

			if (checkIfOrderExits(order) > 0 && !order.isEdited()) {
				orderList.setErrorMsg(getErrorMsg());
				orderList.setBillId(String.valueOf(order.getOrderId()));
				orderList.setMovementType("");
				billListPostReturns.add(orderList);
				continue;
			}
			
			utx.begin();
			
			if (order.isEdited()) {
				// delete and insert
				deleteOrder(order, orderList);
			}
			
			if (insertOrderHeader(order) > 0) {
				for (OrderDetail orderDetail : order.getOrderDetails()) {
					
					orderDetail.setQuantityTemp(orderDetail.getQuantity());
					
					if (insertOrderDetail(orderDetail, order.getOrderId(), order.getUserId(), order.getSellerId()) > 0) {
						if (orderDetail.getCode() !=0) {
							ClsBillManager.updateDiscountCode(em, orderDetail.getCompanyId(), order.getBranchId(),
									orderDetail.getTypeCode(), order.getUserId(),
									order.getCellarId(), orderDetail.getCode(), 
									order.getHour(), order.getOrderId());
						}
					}
				}

				createOrderReservation(order, orderList);
			}
			
			orderList.setErrorMsg(getErrorMsg());

			if (orderList.getErrorMsg().equals("")) {
				utx.commit();
				//utx.rollback();
			} else {
				// Save logs
				clsLogs.insertErrorLogDetail(order.getCellarId(), FMUUtil.getSubsString(orderList.getErrorMsg()), 
						order.getUserId(), order.getBranchId(), FMUUtil.ORDER_CODE, String.valueOf(order.getOrderId()),
						"");
				utx.rollback();
			}

			orderList.setBillId(String.valueOf(order.getOrderId()));
			orderList.setMovementType("");
			billListPostReturns.add(orderList);
		}
		
		if (!cancelOrderList.isEmpty()) {

			cancelOrder:
			for (Order order : cancelOrderList) {
				
				// Check if is approved
				if (checkOrderStatus(order.getOrderId(), order.getUserId()) > 0) {
					PostObjectReturn postObjectReturn = new PostObjectReturn();
					postObjectReturn.setBillId(String.valueOf(order.getOrderId()));
					postObjectReturn.setCompanyId(order.getUserId());
					postObjectReturn.setMovementType("CANCEL_ORDER");
					postObjectReturn.setErrorMsg("ORDER_ON_WAY");
					billListPostReturns.add(postObjectReturn);
					continue cancelOrder;
				}
				
				billListPostReturns.add(cancelOrder(order, utx));

				if (order.getCode() != 0) {
					utx.begin();
					int result = ClsBillManager.updateDiscountCode(em, "0",
							order.getBranchId(), order.getTypeCode(), order.getUserId(),
							order.getCellarId(), order.getCode(), order.getHour(),
							order.getOrderId());

					if (result > 0) {
						utx.commit();
					} else {
						clsLogs.insertErrorLogDetail(order.getCellarId(), "ERROR REGISTRANDO CODIGO AUTORIZACION", 
								order.getUserId(), order.getBranchId(), FMUUtil.RECEIPT_CODE, 
								String.valueOf(order.getOrderId()), 
								"");
						utx.rollback();
					}
				}
			}
		}
		
		return billListPostReturns;
	}
	
	private int checkOrderStatus(int orderId, String userId) {
		
		List<Object> object = new ArrayList<Object>();
		int total = 0;

		try {
			
		String sQuery = "select count(PEDSUC) "
				+ "FROM " + CollectionScheme.SchemeInventario + ".invpeds WHERE PEDSUC = ?  "
					+ "AND HECHOP = ? AND TRIM(NSTAT4) = 'I' FOR READ ONLY";
		
		object = em.createNativeQuery(sQuery).setParameter(1, orderId)
				.setParameter(2, userId).
				getResultList();
		
		if (object.size() > 0) {
			total = (object.get(0) == null ? 0 : Integer.parseInt(object.get(0).toString()));
		}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage());
		}
		
		return total;
	}
	
	private int insertOrderHeader(ni.com.casapellas.gcpfmu.pojo.Order order) {
		
		try {
			String sQuery = "INSERT INTO " + CollectionScheme.GCPFMU_SCHEMA + ".ORDER (" +
				"ORDER_ID," +
				"ZONE_ID," +
				"SELLER_ID," +
				"CLIENT_ID," +
				"CLIENT_NAME," +
				"STATE," +
				"CREATED_AT," +
				"HOUR," +
				"CONDITION," +
				"BRANCH_ID," +
				"DELIVER_ID," +
				"CELLAR_ID," +
				"USER_ID)" +
				
		"VALUES (" + order.getOrderId() + ", " +
			 		"" + order.getZoneId() + ", " +
			 		"" + order.getSellerId() + ", " +
			 		"'" + order.getClientId() + "', " +
			 		"'" + order.getClientName() +  "', " +
			 		"'" + order.getState() + "', " +
			 		"" + order.getCreatedAt() + ", " +
			 		"" + order.getHour() + ", " +
			 		"'" + order.getPayCondition() + "', " +
			 		"'" + order.getBranchId() + "', " +
			 		"'" + order.getDeliverId() + "', " +
			 		"'" + order.getCellarId() + "', " +
			 		"'" + order.getUserId() + "')";
			
			return em.createNativeQuery(sQuery).executeUpdate();
	
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage());
		}
		
		return 0;
	}
	
	
	private void deleteOrderCellarReservation(Order order) {
		try {
			em.createNativeQuery("DELETE FROM " + CollectionScheme.GCPFMU_SCHEMA + ".ORDER_RESERVATION  WHERE ORDER_ID = ? "
					+ " AND SELLER_ID = ?").setParameter(1, order.getOrderId()).
					setParameter(2, order.getSellerId()).executeUpdate();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage());
		}
	}

	private int insertOrderDetail(ni.com.casapellas.gcpfmu.pojo.OrderDetail orderDetail, int orderId, String userId, int sellerId) {
		
		try {
			String sQuery = "INSERT INTO " + CollectionScheme.GCPFMU_SCHEMA + ".ORDER_DETAIL (" +
				"ORDER_ID," +
				"COMPANY_ID," +
				"LINE_ID," +
				"PRODUCT_ID," +
				"PRODUCT_NAME," +
				"COIN," +
				"MEASURE_TYPE," +
				"IVA," +
				"PRICE," +
				"EXCHANGE," +
				"QUANTITY," +
				"SELLER_ID," +
				"CATEGORY_ID," +
				"USER_ID," +
				"BRAND_ID," +
				"DISCOUNT_PERCENT)" +
				
		"VALUES (" + orderId + ", " +
			 		"'" + orderDetail.getCompanyId() + "', " +
			 		"'" + orderDetail.getLineId() + "', " +
			 		"'" + orderDetail.getProductId() + "', " +
			 		"'" + orderDetail.getProductName() +  "', " +
			 		"'" + orderDetail.getCoin() + "', " +
			 		"'" + orderDetail.getMeasureType() + "', " +
			 		"" + orderDetail.getIva() + ", " +
			 		"" + orderDetail.getPrice() + ", " +
			 		"" + orderDetail.getExchange() + ", " +
			 		"" + orderDetail.getQuantity() + ", " +
			 		"" + sellerId + ", " +
			 		"'" + orderDetail.getCategoryId() + "', " +
			 		"'" + userId + "', " +
			 		"'" + orderDetail.getBrandId() + "', " +
			 		"" + orderDetail.getDiscountPercent() + ")";
			
			return em.createNativeQuery(sQuery).executeUpdate();
	
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage());
		}
		
		return 0;
	}
	
	public static String getErrorMsg() {
		return errorMsg;
	}
	
	public static void setErrorMsg(String errorMsg) {
		ClsOrderManager.errorMsg = errorMsg;
	}
	
	/**
	 * 
	 * @param em
	 * @param companyIds
	 * @return
	 * @throws Exception
	 */
	public List<Order> getOrders(int sellerId) throws Exception {
		List<OrderDetail> orders = new ArrayList<OrderDetail>();
		List<Order> ordersFinalList = new ArrayList<Order>();

		List<Object> object = new ArrayList<Object>();

		try {
			
			String billDates = "SELECT TRIM(value) from " + CollectionScheme.GCPFMU_SCHEMA + ".setting "
					+ "where name = 'ORDER_DAYS'";

			object = em.createNativeQuery(billDates, Object.class).getResultList();
			
			int dayFilter = object.get(0) == null ? 0 : Integer.parseInt(object.get(0).toString());
			
			String sQuery = "Select "
					+ "a.order_id orderId, "
					+ "a.zone_id zoneId, "
					+ "IFNULL(a.seller_id,0) sellerId, "
					+ "a.client_id clientId, "
					+ "a.client_name clientName, "
					+ "IFNULL(a.state,'') state, "
					+ "a.created_at createdAt, "
					+ "a.hour, "
					+ "a.condition payCondition, "
					+ "IFNULL(a.branch_id,'') branchId, "
					+ "a.user_id userId, "
					+ "a.cellar_id cellarId, "
					+ "a.deliver_id deliverId, "

					+ "b.company_id companyId, "
					+ "b.line_id lineId, "
					+ "b.product_id productId,  "
					+ "IFNULL((SELECT SUM(c.quantity_reservation) from " + CollectionScheme.GCPFMU_SCHEMA + ".order_reservation c"
							+ " WHERE (c.product_id = b.product_id AND c.order_id = b.order_id AND "
							+ " c.seller_id = b.seller_id)), 0) totalReserved,  "

					+ "b.product_name productName, "
					+ "b.iva iva, "
					+ "b.price price, "
					+ "b.exchange exchange, "
					+ "b.coin coin, "
					+ "b.quantity quantity,  "
					+ "b.discount_percent discountPercent, "
					+ "b.category_id categoryId, "
					+ "b.measure_type measureType, "
					+ "b.brand_id brandId "

					+ "from " + CollectionScheme.GCPFMU_SCHEMA + ".order a "
					+ "left outer join " + CollectionScheme.GCPFMU_SCHEMA +  ".order_detail b on (a.order_id = b.order_id  "
							+ " AND a.seller_id = b.seller_id)"
							+ " WHERE a.seller_id = " + sellerId + " AND "
									+ " a.created_at >= " + FMUUtil.getIntegerDateFromDays(dayFilter) 
									+ " AND a.created_at <=" + FMUUtil.getIntegerDate() 
									+ "   ORDER BY a.order_id ASC FOR READ ONLY";
			
			
			orders = em.createNativeQuery(sQuery, OrderDetail.class)
				.getResultList();
			
			HashMap<MapKeyUtil, List<OrderDetail>> map = new HashMap<MapKeyUtil, List<OrderDetail>>();

			for (OrderDetail orderDetail : orders) {
			
				String key = String.valueOf(orderDetail.getOrderId());
				String key2 = String.valueOf(orderDetail.getUserId());
				
				MapKeyUtil mapKey = new MapKeyUtil();
				mapKey.setKey1(key);
				mapKey.setKey2(key2);

				put(mapKey, orderDetail, map);
			}
						
			for (Entry<MapKeyUtil, List<OrderDetail>> entry : map.entrySet()) {
				
				Order orderItem = new Order();
				orderItem.setOrderId(Integer.parseInt(entry.getKey().getKey1().toString()));
				List<OrderDetail> billPostsData = entry.getValue();
				
				for (OrderDetail orderDetail :  billPostsData) {
					orderItem.setCreatedAt(orderDetail.getCreatedAt());
					orderItem.setZoneId(orderDetail.getZoneId());
					orderItem.setSellerId(orderDetail.getSellerId());
					orderItem.setPayCondition(orderDetail.getPayCondition());
					orderItem.setBranchId(orderDetail.getBranchId());
					orderItem.setHour(orderDetail.getHour());
					orderItem.setState(orderDetail.getState());
					orderItem.setClientId(orderDetail.getClientId());
					orderItem.setClientName(orderDetail.getClientName());
					orderItem.setUserId(orderDetail.getUserId());
					orderItem.setSyncState(true);
					orderItem.setCancelStateSync(true);
					orderItem.setOpen(false);
				}
				
				orderItem.setOrderDetails(billPostsData);
				ordersFinalList.add(orderItem);
			}
		}		

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return ordersFinalList;
	}
	
	/**
	 * Create {@link HashMap} Two Keys
	 * @param mapKey2	
	 * @param list
	 * @param mapWithTwoKeys
	 */
	private static void put(MapKeyUtil mapKey2, OrderDetail list, HashMap<MapKeyUtil, List<OrderDetail>> mapWithTwoKeys) {
		if (mapWithTwoKeys.get(mapKey2) == null) {
			List<OrderDetail> listAll = new ArrayList<OrderDetail>();
			listAll.add(list);
		    mapWithTwoKeys.put(mapKey2, listAll);
		} else { 
			mapWithTwoKeys.get(mapKey2).add(list);
		}
	}
	
	
	private PostObjectReturn cancelOrder(Order order, UserTransaction utx) {
		
		PostObjectReturn postObjectReturn = new PostObjectReturn();
		
		List<OrderReservation> orderCellarReservations = new ArrayList<OrderReservation>();

		
		postObjectReturn.setBillId(String.valueOf(order.getOrderId()));
		postObjectReturn.setCompanyId(order.getUserId());
		postObjectReturn.setMovementType("CANCEL_ORDER");

		setErrorMsg("");
		
		try {
			postObjectReturn.setErrorMsg("");
			
			utx.begin();

			em.createNativeQuery("UPDATE " + CollectionScheme.GCPFMU_SCHEMA + ".ORDER set STATE = 'A' WHERE ORDER_ID = ? "
					+ " AND SELLER_ID = ?").setParameter(1, order.getOrderId()).
					setParameter(2, order.getSellerId()).executeUpdate();
			
			orderCellarReservations = getOrderDetailReservationByOrder(order, "");
			
			// Rever changes Inventario
			revertReservation(orderCellarReservations, order);
			
			// delete detail
			deleteOrderCellarReservation(order);
			
			deleteOrderOnInvPeds(order);
			
			postObjectReturn.setErrorMsg(getErrorMsg());
			
			if (postObjectReturn.getErrorMsg().equals("")) {
				utx.commit();
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
	
	private List<OrderReservation> getOrderDetailReservationByOrder(Order order, String productId) {
		return getOrderDetailReservationByOrder(order, productId, false);
	}
	private List<OrderReservation> getOrderDetailReservationByOrder(Order order, String productId, boolean completSelect) {

		List<OrderReservation> orderDetails = new ArrayList<OrderReservation>();
		
		if (!productId.equals("")) {
			productId = " AND b.product_id = '" + productId + "'";
		}
		
		String sQuery = "";
		
		try {

			if (completSelect) {
				
				sQuery = "SELECT "
						+ "b.seller_id sellerId "
						+ " from  "+ CollectionScheme.GCPFMU_SCHEMA + ".order_reservation b "
						+ "where b.seller_id = ? and b.order_id = ? " + productId  + " FOR READ ONLY";
				
			} else {
				sQuery = "SELECT "
					+ "b.seller_id sellerId, "
					+ "IFNULL(b.branch_reservation_id, '0') branchReservationId, "
					+ "IFNULL(b.cellar_reservation_id, '0') cellarReservationId, "
					+ "IFNULL(b.quantity_reservation, 0) quantityReservation, "
					+ "IFNULL(b.company_reservation_id, '0') companyReservationId, "
					+ "IFNULL(b.line_reservation_id, '0') lineReservationId, "
					+ "IFNULL(b.line_reservation_id,'0') lineReservationId, "
					+ "b.product_id productId, "
					+ "b.order_id orderId, "
					+ "IFNULL(c.quantity, 0) quantity, "
					+ "IFNULL(c.category_id, '') categoryId, "
					+ "c.company_id companyId, "

					+ "c.line_id lineId "

					+ " from  "+ CollectionScheme.GCPFMU_SCHEMA + ".order_reservation b left outer join  "
							+ "" + CollectionScheme.GCPFMU_SCHEMA + ".order_detail c on (b.seller_id = c.seller_id AND "
									+ " b.order_id = c.order_id  and b.product_id = c.product_id) "
					+ "where b.seller_id = ? and b.order_id = ? " + productId + " FOR READ ONLY";
			}

			orderDetails = em.createNativeQuery(sQuery, OrderReservation.class).
					setParameter(1, order.getSellerId()).
					setParameter(2, order.getOrderId()).
					getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(getErrorMsg());
		}
		
		return orderDetails;
	}
	
	private int getItemAvailable(String companyId, String branchId, String cellarId, String productId, String lineId,
			String productCompanyId) {
		
		List<Object> object = new ArrayList<Object>();
				
		List<PostObjectReturn> postObjectReturnItem = new ArrayList<>();
		
		int total = 0;

		// invd01
		if (branchId.equals("00") && (
				cellarId.equals("01") ||
				cellarId.equals("02") ||
				cellarId.equals("04") || 
				cellarId.equals("08"))) {
						
			
			String tableName = productCompanyId.equals("01") ? CollectionScheme.SchemeInventario + ".invd01" :
				CollectionScheme.SchemeInventario + ".invv01";

			String sQuery = "select (" + getInvd01CellarField(cellarId) + " - " + getInvd01ReservationField(cellarId, true) + ") batchNumber, "
					+ "IFNULL((select BSTATU1 from " + CollectionScheme.SchemeInventario + ".INVD03  where trim(binopar) ="
					+ " trim(inopar) and trim(bsucurs)='00' and trim(bcompan)='01' and trim(bdepart)=trim(ilinea) and bbodega='" + cellarId + "'), '') billId "
					+ "FROM " +
					tableName + "  where TRIM(inopar) = '" + productId + "'  and "
					+ "ilinea = '" + lineId + "' "
					+ " FOR READ ONLY";			
			
			postObjectReturnItem =  em.createNativeQuery(sQuery, PostObjectReturn.class).
					getResultList();
			
			if (postObjectReturnItem.size() > 0) {

				if (postObjectReturnItem.get(0).getBatchNumber() > 0 && !postObjectReturnItem.get(0).getBillId().equals("9")) {
					total = postObjectReturnItem.get(0).getBatchNumber();
				}
			}	

			// Invd02
		} else if (!branchId.equals("00") && cellarId.equals("01")) {
			
			String sQuery = "select (SSEXL00 - SCANR00) totalAvailable "
					+ "FROM " + CollectionScheme.SchemeInventario + ".invd02 where sinopar = ? and scompan = ? and ssucurs = ?"
							+ "and sdepart = ? FOR READ ONLY";
			
			object = em.createNativeQuery(sQuery).setParameter(1, productId)
					.setParameter(2, companyId).
					setParameter(3, branchId).
					setParameter(4, lineId).getResultList();
			
			if (object.size() > 0) {
				
				total = (object.get(0) == null ? 0 : Integer.parseInt(object.get(0).toString()));
			}

			// invd03
		} else {
			String sQuery = "select (bexistee - (BCANRESER + BCANINVES)) totalAvailable "
					+ "FROM " + CollectionScheme.SchemeInventario + ".invd03 where binopar = '" + productId + 
					"' and bcompan = '" + companyId + "' and bsucurs = '" + branchId + "'"
							+ " and bdepart = '" + lineId + "' and bbodega = '" + cellarId + "' FOR READ ONLY" ;
						
			object = em.createNativeQuery(sQuery).getResultList();
			
			if (object.size() > 0) {
				total = (object.get(0) == null ? 0 : Integer.parseInt(object.get(0).toString()));
			}
		}
		
		return total;
	}
	
	private void deleteOrder(Order order, PostObjectReturn postObjectReturn) {
		
		try {
			// revert reservation;
			List<OrderReservation> orderDetails = new ArrayList<OrderReservation>();

			orderDetails = getOrderDetailReservationByOrder(order, "");
			
			revertReservation(orderDetails, order);
			
			// delete detail
			deleteOrderCellarReservation(order);
			
			deleteOrderOnInvPeds(order);

			int result = em.createNativeQuery("DELETE FROM " + CollectionScheme.GCPFMU_SCHEMA + ".ORDER  WHERE ORDER_ID = ? "
					+ " AND SELLER_ID = ?").setParameter(1, order.getOrderId()).
					setParameter(2, order.getSellerId()).executeUpdate();
			
			if (result > 0) {
				em.createNativeQuery("DELETE FROM " + CollectionScheme.GCPFMU_SCHEMA + ".ORDER_DETAIL  WHERE ORDER_ID = ? "
						+ " AND SELLER_ID = ?").setParameter(1, order.getOrderId()).
						setParameter(2, order.getSellerId()).executeUpdate();
			}
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage());
		}
	}
	
	public static List<OrderReservationConfig> getOrderReservationConfig(int sellerId, EntityManager em) {
		
		List<OrderReservationConfig> orderReservations = new ArrayList<OrderReservationConfig>();

		try {			
			String sQuery = "SELECT seller_id sellerId, branch_id branchId, cellar_id cellarId, company_id companyId, "
					+ " line_id lineId "
					+ "FROM " + CollectionScheme.GCPFMU_SCHEMA + ".ORDER_RESERVATION_CONFIG where seller_id = ?"
							+ " ORDER BY ORDER_RESERVATION_ID ASC FOR READ ONLY";
			
			orderReservations = em.createNativeQuery(sQuery, OrderReservationConfig.class).setParameter(1, sellerId).
					getResultList();
			
	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage());
		}
	
		return orderReservations;
	}
	
	private void createOrderReservation(Order order, PostObjectReturn orderReturn) {
	
		try {

			List<OrderReservationConfig> orderReservations = getOrderReservationConfig(order.getSellerId(), em);
			
			String queryInsert = "";
			int sequence = 1;
			ArrayList<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
			
			// Logic
			orderDetail: for (OrderDetail orderDetail : order.getOrderDetails()) {
				
				orderReservation: for (OrderReservationConfig orderReservation : orderReservations) {

					int totalAvailable = getItemAvailable(orderReservation.getCompanyId(),
							orderReservation.getBranchId(), orderReservation.getCellarId(),
							orderDetail.getProductId(),
							orderReservation.getLineId(), orderDetail.getCompanyId());

					orderReservation.setTotalAvailable(totalAvailable);
					
					if (orderReservation.getTotalAvailable() <= 0 ) {
						continue orderReservation;
					}
					
					if (orderReservation.getTotalAvailable() > orderDetail.getQuantity()) {
						
						int totalReservation = orderReservation.getTotalAvailable() - orderDetail.getQuantity();
						
						int result = makeReservation(orderReservation.getCompanyId(), orderReservation.getBranchId(),
								orderReservation.getLineId(), orderReservation.getCellarId(), orderDetail.getProductId(), 
								orderDetail.getQuantity(), "+", order.getOrderId(), order.getSellerId(),
								orderDetail.getCompanyId());
						
						if (result > 0) {
							
							insertOrderDetailReservationInfo(orderReservation.getBranchId(), orderReservation.getCellarId(),
									orderDetail.getQuantity(), order.getOrderId(), order.getSellerId(), orderDetail.getProductId(),
									orderDetail.getCompanyId(), 
									orderReservation.getLineId());

									queryInsert +="\n";

									queryInsert += createValuesArray(orderDetail, 
											orderDetail.getCompanyId(),
											orderReservation.getBranchId(),
											orderReservation.getLineId(),
											orderReservation.getCellarId(),
											orderDetail.getQuantity(),
											order,
											sequence);
									queryInsert +=",\n";
									
									// Add to the list
									
									OrderDetail orderDetailItem = new OrderDetail();
									orderDetailItem.setProductId(orderDetail.getProductId());
									orderDetailItem.setCompanyId(orderDetail.getCompanyId());
									orderDetailItem.setLineId(orderDetail.getLineId());
									orderDetailItem.setTotalReserved(orderDetail.getQuantity());
									
									orderDetails.add(orderDetailItem);
									
									sequence++;

						} 
						
						orderReservation.setTotalAvailable(totalReservation);
						orderDetail.setQuantity(0);

						// UPDATE quantity
						continue orderDetail;
						
					} else if (orderReservation.getTotalAvailable() < orderDetail.getQuantity()) {
						
						int totalReservation = orderDetail.getQuantity() - orderReservation.getTotalAvailable();
						
						int result = makeReservation(orderReservation.getCompanyId(), orderReservation.getBranchId(),
								orderReservation.getLineId(), orderReservation.getCellarId(), orderDetail.getProductId(), 
								orderReservation.getTotalAvailable(), "+", order.getOrderId(), order.getSellerId(),
								orderDetail.getCompanyId());
						
						
						if (result > 0) {
							insertOrderDetailReservationInfo(orderReservation.getBranchId(), orderReservation.getCellarId(),
									orderReservation.getTotalAvailable(), order.getOrderId(), order.getSellerId(), 
									orderDetail.getProductId(), orderDetail.getCompanyId(), 
									orderReservation.getLineId());

									queryInsert +="\n";
							
									queryInsert += createValuesArray(orderDetail, 
											orderDetail.getCompanyId(),
											orderReservation.getBranchId(),
											orderReservation.getLineId(),
											orderReservation.getCellarId(),
											orderReservation.getTotalAvailable(),
											order,
											sequence);
									queryInsert +=",\n";
									
									OrderDetail orderDetailItem = new OrderDetail();
									orderDetailItem.setProductId(orderDetail.getProductId());
									orderDetailItem.setCompanyId(orderDetail.getCompanyId());
									orderDetailItem.setLineId(orderDetail.getLineId());
									orderDetailItem.setTotalReserved(orderReservation.getTotalAvailable());
									
									orderDetails.add(orderDetailItem);
									
									sequence++;

						} 
						
						orderDetail.setQuantity(totalReservation);
						orderReservation.setTotalAvailable(0);
						
						continue orderReservation;
						
					} else if (orderDetail.getQuantity() ==  orderReservation.getTotalAvailable()) {
						
						int result = makeReservation(orderReservation.getCompanyId(), orderReservation.getBranchId(),
								orderReservation.getLineId(), orderReservation.getCellarId(), orderDetail.getProductId(), 
								orderDetail.getQuantity(), "+", order.getOrderId(), order.getSellerId(),
								orderDetail.getCompanyId());
						
						
						if (result > 0) {
							insertOrderDetailReservationInfo(orderReservation.getBranchId(), orderReservation.getCellarId(),
									orderDetail.getQuantity(), order.getOrderId(), order.getSellerId(), orderDetail.getProductId(),
									orderDetail.getCompanyId(), 
									orderReservation.getLineId());

									queryInsert +="\n";

									queryInsert += createValuesArray(orderDetail, 
											orderDetail.getCompanyId(),
											orderReservation.getBranchId(),
											orderReservation.getLineId(),
											orderReservation.getCellarId(),
											orderDetail.getQuantity(),
											order,
											sequence);
									
									queryInsert +=",\n";
											
									OrderDetail orderDetailItem = new OrderDetail();
									orderDetailItem.setProductId(orderDetail.getProductId());
									orderDetailItem.setCompanyId(orderDetail.getCompanyId());
									orderDetailItem.setLineId(orderDetail.getLineId());
									orderDetailItem.setTotalReserved(orderDetail.getQuantity());
									
									orderDetails.add(orderDetailItem);
									
									sequence++;

						} 
						
						orderDetail.setQuantity(0);
						orderReservation.setTotalAvailable(0);
				
						continue orderDetail;
					}
				}
						
			}
			
			orderReturn.setOrderDetails(orderDetails);
			
			// Check if product got reserved 
			for (OrderDetail orderDetail : order.getOrderDetails()) {
				int total = 
						getOrderDetailReservationByOrder(order, orderDetail.getProductId(), true).size();
				
				if (total == 0) {
					// get Last cellar
					OrderReservationConfig orderReservation = orderReservations.get(orderReservations.size() - 1);

					if (orderReservation !=null) {
						insertOrderDetailReservationInfo(orderReservation.getBranchId(),
								orderReservation.getCellarId(), 0, order.getOrderId(), 
								order.getSellerId(), orderDetail.getProductId(), orderDetail.getCompanyId(), 
								orderDetail.getLineId());
					}	
				}
			}
			
			if (!queryInsert.equals("")) {
				
				queryInsert = queryInsert.substring(0, queryInsert.length() -2); 
				
				String completeQuery = getHeaderInsert() + "\n" +  queryInsert;		
								
				try {
					em.createNativeQuery(completeQuery).executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					ClsCashManager.setErrorMsg2(e.getMessage());
				}
			}
		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage());
		}
	}
	
	private int makeReservation(String companyId, String branchId, String lineId, String cellarId, 
			String productId, int quantity, String mathAction, int orderId, int sellerId, 
			String productCompanyId) {

		int result = 0;
		
		try {
	
			// invd01
			if (branchId.equals("00") && (
					cellarId.equals("01") ||
					cellarId.equals("02") ||
					cellarId.equals("03") || 
					cellarId.equals("04"))) {
				
				String tableName = productCompanyId.equals("01") ? CollectionScheme.SchemeInventario + ".invd01" :
					CollectionScheme.SchemeInventario + ".invv01";
					
				result = em.createNativeQuery("UPDATE " + tableName + " " 
						+ " set " + getInvd01ReservationField(cellarId, false) 
						+ " = (" + getInvd01ReservationField(cellarId, false) + " " + mathAction + " " + quantity + ") where TRIM(inopar) = '" + productId + 
					"' and TRIM(ILINEA) = '" + lineId  + "'")
						.executeUpdate();
				
				// Invd02
			} else if (!branchId.equals("00") && cellarId.equals("01")) {
				
				result = em.createNativeQuery("UPDATE " + CollectionScheme.SchemeInventario + ".invd02 "
						+ " set SCANR00 = (SCANR00 "  + mathAction + " " + quantity + ") where sinopar = '" + productId + 
					"' and scompan = '" + companyId + "' and ssucurs = '" + branchId + "'"
							+ " and sdepart = '" + lineId + "'")
						.executeUpdate();
				
				// invd03
			} else if (!branchId.equals("00") && !cellarId.equals("01")) {					
				result = em.createNativeQuery("UPDATE " + CollectionScheme.SchemeInventario + ".invd03 "
						+ " set BCANRESER = (BCANRESER " + mathAction + " " + quantity + ") where TRIM(binopar) = '" + productId + 
					"' and TRIM(bcompan) = '" + companyId + "' and TRIM(bsucurs) = '" + branchId + "'"
							+ " and TRIM(bdepart) = '" + lineId + "' and TRIM(bbodega) = '" + cellarId + "'")
						.executeUpdate();
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage());
		}
		
		return result;
	}
		
	/**
	 * Header String for insert
	 * @return
	 */
	public static String getHeaderInsert() {
	
		try {
			String sQuery = "INSERT INTO " + CollectionScheme.SchemeInventario + ".invpeds (" +
				"COMPAO," + // company pide
				"SUCURO," + // sucur pide
				"DEPARO," + //  linea pide
				"BODEGO," + // bodega pide
				"PEDSUC," + // order id
				"TIPOTR," + // PM
				"SUCDES," + // sucur pide
				"FECHAM," + // fecha
				"NPARTE," + // productId
				"CANTID," + // cantidad
				"CCATEG," + // categoria ?
				"MOTIVO," + // Relleno venta
				"SECUEN," + // Secuencia
				"HORAM," + // hora
				"PANTAL," + // programa
				"HECHOP," + // USER_ID
				"NPROGR," + // prgrama
				"FECHA2," + // fecha
				"HORAM2," + // hora
				"PANTA2," + // prgrama
				"HECHO2," + // user_id (entregador ? )
				"NPROG2," +  // FMU
				"NSTAT2," + //  "" (vacio) no aprobado
				"FECHA3," + // fecha
				"HORAM3," + // hora 
				"PANTA3," + // programa
				"HECHO3," + // userId
				"NPROG3," + // programa
				"NSTAT3," + // Impreso ? (blanco)
				"COMPAN," + // compan destino
				"SUCURS," + // sucur destino
				"DEPART," + // linea destino
				"BODEGA," + // bodega destino
				"RUTARE," +  // A ?
				"CANTRE," + // Cantidad reservada
				"UBICAC," + // Ubicacion bid
				"NSTAT4," +		
				"NCLCLIE)" +	
				
			"VALUES ";
		
			return sQuery;
	
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
			//state = false;
		}
		return null;
	}
	
	private String getInvd01ReservationField(String cellarId, boolean isSelect) {
		
		if (cellarId.equals("01")) {
			return isSelect ? "(ILOCA1 + ICAV01 + ICALB3)" : "ILOCA1";
			
		} else if (cellarId.equals("02")) {
			return "ILOCA2";

		} else if (cellarId.equals("04")) {
			return "ILOCA3";

		} else if (cellarId.equals("08")) {
			return isSelect ? "(ILOCA4 + ICAV08 +  SUSLB3)" : "ILOCA4";
		} 
		
		return "ILOCA1";
	}
	
	private String getInvd01CellarField(String cellarId) {
		
		if (cellarId.equals("01")) {
			return "IEXT01";
		} else if (cellarId.equals("02")) {
			return "IEXT02";
		} else if (cellarId.equals("04")) {
			return "IEXT04";
		} else if (cellarId.equals("08")) {
			return "IEXT08";
		}
		
		return "IEXT01";
	}
	
	private void revertReservation(List<OrderReservation> orderDetails, Order order) {
		for (OrderReservation OrderCellarReservation : orderDetails) {
			makeReservation(OrderCellarReservation.getCompanyId(), 
					OrderCellarReservation.getBranchReservationId(), 
					OrderCellarReservation.getLineId(), OrderCellarReservation.getCellarReservationId(), 
					OrderCellarReservation.getProductId(), OrderCellarReservation.getQuantityReservation(), "-", order.getOrderId(), order.getSellerId(), 
					OrderCellarReservation.getCompanyId());
		}
	}
	
	private void insertOrderDetailReservationInfo(String branch_reservation_id, 
			String cellar_reservation_id, int quantityReservation, int orderId, int sellerId, String productId,
			String companyId, String lineId) {
		

		try {
			String sQuery = "INSERT INTO "
					+ CollectionScheme.GCPFMU_SCHEMA + ".ORDER_RESERVATION (" +
				"SELLER_ID," +
				"BRANCH_RESERVATION_ID," +
				"CELLAR_RESERVATION_ID," +
				"COMPANY_RESERVATION_ID," +
				"LINE_RESERVATION_ID," +
				"QUANTITY_RESERVATION," +
				"PRODUCT_ID," +
				"ORDER_ID)" +
				
		"VALUES (" + sellerId + ", " +
			 		"'" + branch_reservation_id + "', " +
			 		"'" + cellar_reservation_id + "', " +
			 		"'" + companyId + "', " +
			 		"'" + lineId + "', " +
			 		"" + quantityReservation +  ", " +
			 		"'" + productId + "', " +
			 		"" + orderId + ")";
			
			em.createNativeQuery(sQuery).executeUpdate();
	
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage());
		}
			
	}
	
	/**
	 * This create {@link Array} values
	 * @param total 
	 * @param glcrrm 
	 * @return
	 */
	public String createValuesArray(OrderDetail orderDetailItem, String companyReservation,
			String branchReservation, String lineReservation, String cellarReservation,
			int quantityReservation, Order order, int sequende) {		
				
		 String valueQuery =  
				"('" + orderDetailItem.getCompanyId() + "', " +
		 		"'" + order.getBranchId() + "', " +
		 		"'" + orderDetailItem.getLineId() + "', " +
		 		"'" + order.getCellarId() + "', " +
		 		"" + order.getOrderId() + ", " +
		 		"'" + "PM" + "', " +
		 		"'" + order.getBranchId() +  "', " +
		 		"" + order.getCreatedAt() + ", " +
		 		"'" + orderDetailItem.getProductId() + "', " +
		 		"" + orderDetailItem.getQuantityTemp() + ", " +
		 		"'" + orderDetailItem.getCategoryId() + "', " + // category
		 		"'" + "Relleno venta" + "', " +
		 		"" + sequende + ", " +
		 		"" + order.getHour() + ", " +
		 		"'" + order.getSoftwareId() + "', " +
		 		"'" + order.getUserId() + "', " +
		 		"'" + order.getSoftwareId() + "', " +
		 		"" + order.getCreatedAt() + ", " +
		 		"" + order.getHour() + ", " +
		 		"'" + order.getSoftwareId() + "', " +
		 		"'" + order.getUserId() + "', " +
		 		"'" + order.getSoftwareId() + "', " +
		 		"'" + "A" + "', " + 
		 		"" + order.getCreatedAt() + ", " +
		 		"" + order.getHour() + ", " +
		 		"'" + order.getSoftwareId() + "', " +
		 		"'" + order.getUserId() + "', " + 
		 		"'" + order.getSoftwareId() + "', " +
		 		"'" + "I" + "', " + //
		 		"'" + companyReservation + "', " +
		 		"'" + branchReservation + "', " +
		 		"'" + lineReservation + "', " +
		 		"'" + cellarReservation + "', " +
		 		"'" + order.getDeliverId() + "', " + 
		 		"" + quantityReservation + ", " +
		 		"'" + getCellarLocation(lineReservation, branchReservation, orderDetailItem.getProductId(), 
		 				companyReservation,cellarReservation) + "', " + 
		 		"'" + "R" + "', " + // 
		 		"" + order.getClientId() + ")";
		 
		 return valueQuery;
	}
	
	private String getCellarLocation(String lineReservationId, String branchReservationId, String productId,
			String companyReservationId, String cellarReservationId) {
		String location = "";

		try {

			List<Object> object = new ArrayList<Object>();
			
			String sQuery = "SELECT BSUBL00 "
					+ "FROM " + CollectionScheme.SchemeInventario + ".invd03 where TRIM(binopar) = '"
								+ productId + "' AND"
							+ " TRIM(BDEPART) = '" + lineReservationId + "' AND TRIM(BSUCURS) = '" + branchReservationId + "'"
							+ " AND BCOMPAN = '" + companyReservationId + 
							"' AND BBODEGA = '" + cellarReservationId + "' FOR READ ONLY";
							
			object = em.createNativeQuery(sQuery)
					.getResultList();
			
			if (object.size() > 0) {
				location = (object.get(0) == null ? "" : object.get(0).toString());
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage());
		}
		
		return location;
	}
	

	private void deleteOrderOnInvPeds(Order order) {
		try {
			em.createNativeQuery("DELETE FROM " + CollectionScheme.SchemeInventario + ".invpeds  WHERE PEDSUC = ?  "
					+ "AND HECHOP = ?"
					+ " ").setParameter(1, order.getOrderId()).
					setParameter(2, order.getUserId()).executeUpdate();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage());
		}
	}
	
	private int checkIfOrderExits(Order order) {
		
		List<Object> object = new ArrayList<Object>();
		int total = 0;

		try {
			
		String sQuery = "select count(order_id)  "
				+ "FROM " + CollectionScheme.GCPFMU_SCHEMA + ".ORDER where seller_id = ? and order_id = ? FOR READ ONLY";
		
		object = em.createNativeQuery(sQuery).setParameter(1, order.getSellerId())
				.setParameter(2, order.getOrderId()).
				getResultList();
		
		if (object.size() > 0) {
			total = (object.get(0) == null ? 0 : Integer.parseInt(object.get(0).toString()));
		}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			setErrorMsg(e.getMessage());
		}
		
		return total;
	}
}
