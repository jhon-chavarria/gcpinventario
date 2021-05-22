 package ni.com.casapellas.erp.gcpfmu;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ni.com.casapellas.gcpfmu.pojo.Device;
import ni.com.casapellas.gcpfmu.pojo.ErrorLog;
import ni.com.casapellas.gcpfmu.pojo.FMUUtil;
import ni.com.casapellas.gcpfmu.pojo.GeneralCatalog;
import ni.com.casapellas.gcpfmu.pojo.InitDay;
import ni.com.casapellas.gcpfmu.pojo.Order;
import ni.com.casapellas.gcpfmu.pojo.OrderDetail;
import ni.com.casapellas.gcpfmu.pojo.Role;
import ni.com.casapellas.gcpfmu.pojo.Section;
import ni.com.casapellas.gcpfmu.pojo.SellerConfig;
import ni.com.casapellas.gcpfmu.pojo.VersionFMU;
import ni.com.casapellas.util.CollectionScheme;

/**
 * FMU ADMIN WEBSITE
 * @author jhon
 *
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN) 
public class ClsFmuAdmin {
	
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;

	
	@Resource 
	private SessionContext sessionContext;  

	@SuppressWarnings("unchecked")
	public List<SellerConfig> getSellerConfigList(String isOrder) throws Exception {
		List<SellerConfig> sellerConfigs = new ArrayList<SellerConfig>();
		
		String whereQuery = "";
		
		if (!isOrder.equals("")) {
			whereQuery = " WHERE c.role_id = 4";
		}

		try {
			String sQuery = "SELECT "
					+ "DISTINCT(a.user_id) userId, "
					+ "a.seller_id sellerId, "
					+ "a.zone_id  zoneId,  "
					+ "a.cellar_id cellarId, "
					+ "d.deliver_id deliverIdPre, "

					+ "a.deliver_id deliverId, "
					+ "TRIM(b.descri) branchName "
					+ "from " + CollectionScheme.GCPFMU_SCHEMA + ".seller_config a "
							+ "left outer join "  + CollectionScheme.SchemeInventario + ".TABMUL b "
									+ "on TRIM(codide) = TRIM(branch_id) and codtab='02' "
									+ " left outer join " + CollectionScheme.GCPFMU_SCHEMA 
									+ ".deliver d on d.seller_id = a.seller_id " 
									+ " left outer join " + CollectionScheme.GCPFMU_SCHEMA 
									+ ".user_roles c on c.user_id = a.user_id " + whereQuery;
			sellerConfigs = em.createNativeQuery(sQuery, SellerConfig.class).getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return sellerConfigs;
	}

	
	/**
	 * Get Devices List
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Device> getDevicesList() throws Exception {
		List<Device> devices = new ArrayList<Device>();
		
		try {
			String sQuery = "SELECT UUID UUID, "
					+ "version version, "
					+ "IFNULL(brand,'') brand, "
					+ "description description, "
					+ "IFNULL(active,0) active, "
					+ "IFNULL(printer_mac,'') printer from " + CollectionScheme.GCPFMU_SCHEMA + ".devices";
			
			devices = em.createNativeQuery(sQuery, Device.class).getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return devices;
	}
	
	/**
	 * Section List
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Section> getSectionList() throws Exception {
		List<Section> sections = new ArrayList<Section>();
		
		try {
			String sQuery = "SELECT  "
					+ "id sectionId, "
					+ "name name, "
					+ "active active, "
					+ "menu menu, "
					+ "order order, "
					+ "class_name  className,"
					+ "image  image,"
					+ "class_type classType "
					+ "from " + CollectionScheme.GCPFMU_SCHEMA + ".section";
			
			sections = em.createNativeQuery(sQuery, Section.class).getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return sections;
	}
	
	/**
	 * Role List
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Role> getRoleList() throws Exception {
		List<Role> roles = new ArrayList<Role>();
		
		try {
			String sQuery = "SELECT  "
					+ "id roleId, "
					+ "name name, "
					+ "description description "
					+ "from " + CollectionScheme.GCPFMU_SCHEMA + ".role";
			
			roles = em.createNativeQuery(sQuery, Role.class).getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return roles;
	}
	
	
	/**
	 * Get  Version List
	 * 
	 * @param em
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<VersionFMU> getVersions() throws Exception {
		List<VersionFMU> versionFMU = new ArrayList<VersionFMU>();

		try {
			String sQuery = "select "
					+ "a.name name, "
					+ "a.id versionId, "
					+ "a.version_name versionName, "
					+ "a.version_code versionCode, "
					+ "a.active  "
					+ "from " + CollectionScheme.GCPFMU_SCHEMA + ".version a where a.active = 1 order by a.id";
			
			versionFMU = em.createNativeQuery(sQuery, VersionFMU.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return versionFMU;
	}
	
	/**
	 * Get  Version List
	 * 
	 * @param em
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<InitDay> getInitDayList() throws Exception {
		List<InitDay> initDays = new ArrayList<InitDay>();
		try {
			String sQuery = "select "
					+ "id id, "
					+ "IFNULL(user_id,'') userId, "
					+ "IFNULL(cellar_id,'') cellarId, "
					+ "IFNULL(zone_id,'') zoneId, "
					+ "IFNULL(hour, 0) hourTime, "
					+ "IFNULL(date,0) date, "
					+ "active available, "
					+ "TRIM(descri) branchName, "
					+ "branch_id branchId "
					+ "from " + CollectionScheme.GCPFMU_SCHEMA + ".init_day "
						+ "left outer join " 
					+ CollectionScheme.SchemeInventario + ".TABMUL on TRIM(codide) = TRIM(branch_id) and codtab='02'"
							+ " where active = 1";
			
			initDays = em.createNativeQuery(sQuery, InitDay.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return initDays;
	}
	
	/**
	 * Get  Version List
	 * 
	 * @param em
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ErrorLog> getErrorLogs() throws Exception {
		List<ErrorLog> errorLogs = new ArrayList<ErrorLog>();
		
		try {
			String sQuery = "select "
					+ "user_id as userId, "
					+ "description description, "
					+ "section section, "
					+ "cellar_id cellarId, "
					+ "company_id companyId, "
					+ "hour, "
					+ "object_id objectId, "
					+ "date, "
					+ "TRIM(descri) branchName "
					+ "from " + CollectionScheme.GCPFMU_SCHEMA + ".error_log "
						+ "left outer join " 
					+ CollectionScheme.SchemeInventario + ".TABMUL on TRIM(codide) = TRIM(branch_id) and codtab='02'"
							;
			
			errorLogs = em.createNativeQuery(sQuery, ErrorLog.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return errorLogs;
	}
	
	
	/**
	 * Get  Version List
	 * 
	 * @param em
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getOrders() throws Exception {
		List<Order> orders = new ArrayList<Order>();
		
			
		try {
			String sQuery = "select "
					+ "order_id as orderId, "
					+ "zone_id zoneId, "
					+ "seller_id sellerId, "
					+ "cellar_id cellarId, "
					+ "client_id clientId, "
					+ "user_id as userId, "
					+ "deliver_id deliverId, "
					+ "client_name clientName, "
					+ "TRIM(descri) branchName, "
					+ "state state, "
					+ "created_at createdAt, "
					+ "hour, "
					+ "condition payCondition "
					+ "from " + CollectionScheme.GCPFMU_SCHEMA + ".order "
						+ "left outer join " 
					+ CollectionScheme.SchemeInventario + ".TABMUL on TRIM(codide) = TRIM(branch_id) and codtab='02' "
							+ "where created_at = " + FMUUtil.getIntegerDate();
			
			orders = em.createNativeQuery(sQuery, Order.class).getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return orders;
	}
	
	
	 /* @param em
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<OrderDetail> getOrderDetail(String orderId, String sellerId) throws Exception {
		List<OrderDetail> orders = new ArrayList<OrderDetail>();
	
		try {
			String sQuery = "select "
					+ "order_detail_id orderDetailId, "
					+ "order_id orderId "
					
					+ "from " + CollectionScheme.GCPFMU_SCHEMA + ".order_detail WHERE seller_id = " + sellerId + ""
							+ " AND order_id = " + orderId + "";
								
			orders = em.createNativeQuery(sQuery, OrderDetail.class).getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return orders;
	}
	
	/**
	 * Get  Version List
	 * 
	 * @param em
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<GeneralCatalog> getBranches() throws Exception {
		List<GeneralCatalog> generalCatalogs = new ArrayList<GeneralCatalog>();
		
		try {
			String sQuery = "select "
					+ "TRIM(codide)  id, "
					+ "TRIM(descri)  name "
					+ "from " + CollectionScheme.SchemeInventario + ".TABMUL "
							+ "where codtab = '02' and codide!=''";
			
			generalCatalogs = em.createNativeQuery(sQuery, GeneralCatalog.class).getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return generalCatalogs;
	}
	
	/**
	 * Get line List
	 * 
	 * @param em
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<GeneralCatalog> getCompanies() throws Exception {
		List<GeneralCatalog> lines = new ArrayList<GeneralCatalog>();
		System.out.println(CollectionScheme.GCPFMU_SCHEMA);

		
		try {
			String sQuery = "select "
					+ "TRIM(codide)  id, "
					+ "TRIM(descri)  name "
					+ "from " + CollectionScheme.SchemeInventario + ".TABMUL "
							+ "where codtab = '01' and codide!=''";
			
			lines = em.createNativeQuery(sQuery, GeneralCatalog.class).getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return lines;
	}

	/**
	 * Get  Version List
	 * 
	 * @param em
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<GeneralCatalog> getLines() throws Exception {
		List<GeneralCatalog> lines = new ArrayList<GeneralCatalog>();
		
		try {
			String sQuery = "select "
					+ "TRIM(codide)  id, "
					+ "TRIM(descri)  name "
					+ "from " + CollectionScheme.SchemeInventario + ".TABMUL "
							+ "where codtab = '20' and codide!=''";
			
			lines = em.createNativeQuery(sQuery, GeneralCatalog.class).getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return lines;
	}


	
}
