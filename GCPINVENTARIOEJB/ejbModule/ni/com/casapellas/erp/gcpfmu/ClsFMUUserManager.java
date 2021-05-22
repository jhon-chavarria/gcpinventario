package ni.com.casapellas.erp.gcpfmu;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ni.com.casapellas.gcpfmu.pojo.AppSetting;
import ni.com.casapellas.gcpfmu.pojo.Device;
import ni.com.casapellas.gcpfmu.pojo.FMUUtil;
import ni.com.casapellas.gcpfmu.pojo.GeneralCatalog;
import ni.com.casapellas.gcpfmu.pojo.ResponseApi;
import ni.com.casapellas.gcpfmu.pojo.Section;
import ni.com.casapellas.gcpfmu.pojo.Seller;
import ni.com.casapellas.gcpfmu.pojo.SellerConfig;
import ni.com.casapellas.gcpfmu.pojo.SyncSection;
import ni.com.casapellas.gcpfmu.pojo.User;
import ni.com.casapellas.gcpfmu.pojo.UserRole;
import ni.com.casapellas.gcpfmu.pojo.VersionFMU;
import ni.com.casapellas.util.CollectionScheme;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN) 
@SuppressWarnings({"unchecked"})
public class ClsFMUUserManager {

	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	
	@EJB
	private ClsFMUCatalog clsFMUCatalog;
	
	private String userAdmin = "PRUEBAE1PY";

	
	@Inject
	public ClsFMUUserManager() {
		// Nothing
	}

	/**
	 * Get Devices List
	 * 
	 * @param em
	 * @return
	 * @throws Exception
	 */
	
	public Device getDevice(String deviceId) throws Exception {
		Device device;

		try {
			String sQuery = "select a.uuid uuid, a.version, a.brand, a.description, a.printer_mac printer, a.active  "
					+ "from " + CollectionScheme.GCPFMU_SCHEMA + ".devices a where a.uuid = ? ";
			device = (Device) em.createNativeQuery(sQuery, Device.class).setParameter(1, deviceId).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return device;
	}
	

	/**
	 * Get Devices List
	 * 
	 * @param em
	 * @return
	 * @throws Exception
	 */
	public ResponseApi doLogin(String user, String password, String deviceId) throws Exception {
		ResponseApi response = new ResponseApi();
		List<Device> devices = new ArrayList<Device>();
		List<User> users = new ArrayList<User>();
		List<UserRole> userRoles = new ArrayList<UserRole>();
		List<Section> sections = new ArrayList<Section>();

		List<SellerConfig> sellerConfigs = new ArrayList<SellerConfig>();
		List<Object> companies = new ArrayList<Object>();
		List<Object> lines = new ArrayList<Object>();

		List<Object> deliverList = new ArrayList<Object>();

		List<GeneralCatalog> companiesCatalog = new ArrayList<GeneralCatalog>();
		List<GeneralCatalog> linesCatalog = new ArrayList<GeneralCatalog>();
		List<GeneralCatalog> branches = new ArrayList<GeneralCatalog>();

		List<Seller> seller = new ArrayList<Seller>();
				
		try {
			
			String sQuery = "SELECT TRIM(codide) username, TRIM(descri) name, TRIM(otros) password, TRIM(p3) state "
					+ "FROM " + CollectionScheme.SchemeInventario + ".TABMUL where codtab='09' and "
							+ "TRIM(codide) like ?  and TRIM(otros) like ? ";
			
			response.setError(0);

			users = em.createNativeQuery(sQuery, User.class).setParameter(1, user).
					setParameter(2, password).getResultList();
			
			if (users.isEmpty()) {
				response.setError(1);
				response.setMessage("Usuario o clave incorrecta.");
				return response;
			} 
			
			String sQueryUserDevices = "select a.uuid, IFNULL(b.user_id, '') user_id, IFNULL(b.active, 0) active " + " from " + CollectionScheme.GCPFMU_SCHEMA + ".devices a LEFT OUTER "
					+ "JOIN " + CollectionScheme.GCPFMU_SCHEMA + ".user_devices b on a.uuid = b.uuid  " + "WHERE a.uuid in (?) and b.user_id = ? and b.active = 1";
			devices = em.createNativeQuery(sQueryUserDevices, Device.class).setParameter(1, deviceId).setParameter(2, user).getResultList();
			
			if (devices.isEmpty() && !user.equals(userAdmin)) {
				response.setError(1);
				response.setMessage("Este dispositivo no esta registrado para ser usado con este usuario o ha sido desactivado.");
				return response;
			}
			
			String sQueryUserRoles = "select TRIM(a.user_id) userId, TRIM(a.role_Id) roleId from "
			+ CollectionScheme.GCPFMU_SCHEMA +  ".user_roles a where a.user_id = ?";
			userRoles = em.createNativeQuery(sQueryUserRoles, UserRole.class).setParameter(1, user).getResultList();
			
			if (userRoles.isEmpty()) {
				response.setError(1);
				response.setMessage("Usuario no tiene rol asignado.");
				return response;
			}
						
			String sellerConfig = "select TRIM(IFNULL(a.seller_id, 0)) sellerId, TRIM(IFNULL(a.cellar_id,'')) cellarId, TRIM(IFNULL(a.zone_id,'')) zoneId, TRIM(IFNULL(a.branch_id, '')) branchId from "
					+ CollectionScheme.GCPFMU_SCHEMA +  ".seller_config a  where user_id = ? ";
			sellerConfigs = em.createNativeQuery(sellerConfig, SellerConfig.class).setParameter(1, user).
					getResultList();
			
			if (sellerConfigs.isEmpty()) {
				response.setError(1);
				response.setMessage("El usuario no tiene configuracion para venta.");
				return response;
			}
		
			String rolesId = "";

			for (UserRole userRole :userRoles) {
				rolesId += "" + userRole.getRoleId() + ",";
			}
			
			rolesId = rolesId.length() > 0 ? rolesId.substring(0, rolesId.length() - 1) : "";
						
			sections = getSections(rolesId);
		
			
			if (sections.isEmpty()) {
				response.setError(1);
				response.setMessage("No hay Secciones definidas dentro del Rol.");
				return response;
			}
			
			boolean needcreateBill = isBillingAction(sections);
			//boolean needCxC = findRoleAction(sections, FMUUtil.CXC_ROLE_SECTION);
			boolean needClientActivities = findRoleAction(sections, FMUUtil.CLIENT_ACTIVITIES_ROLE_ID);
			boolean needCashAction = findRoleAction(sections, FMUUtil.CASH_ACTIVITY);
			boolean needOrder = findRoleAction(sections, FMUUtil.ORDER_ACTIVITY);

			SellerConfig sellerConfigItem = sellerConfigs.get(0);
			
			
			if (sellerConfigItem.getSellerId() == 0) {
				response.setError(1);
				response.setMessage("No hay cÃ³digo de vendedor configurado para este usuario.");
				return response;
			}
			
			if ((sellerConfigItem.getCellarId() == null || sellerConfigItem.getCellarId().equals("")) && 
					(needcreateBill || needOrder))  {
				response.setError(1);
				response.setMessage("No hay bodega configurada para este usuario.");
				return response;
			}
			
			if ((sellerConfigItem.getBranchId() == null || sellerConfigItem.getBranchId().equals("")) &&  
				(needcreateBill || needOrder)) {
				response.setError(1);
				response.setMessage("No hay Sucursales de ventas configurada para este usuario.");
				return response;
			}
			
			
			if ((sellerConfigItem.getZoneId() == null || sellerConfigItem.getZoneId().equals("")) &&
					(needClientActivities ||  needcreateBill)) {
				response.setError(1);
				response.setMessage("No hay Zona de ventas configurada para este usuario.");
				return response;
			}
			
		
			branches = clsFMUCatalog.getBranches(FMUUtil.BRANCHES_ID, sellerConfigItem.getBranchId());
			
			if (branches.isEmpty() && (needcreateBill || needOrder)) {
				response.setError(1);
				response.setMessage("Error al obtener informacion de las sucursal");
				return response;
			}
			

			seller = clsFMUCatalog.getSellers(String.valueOf(sellerConfigItem.getSellerId()));
			
			if (seller.isEmpty() && (needCashAction || needcreateBill || needOrder)) {
				response.setError(1);
				response.setMessage("Error al obtener informacion del vendedor");
				return response;
			}
			
			String sellerCompanies = "select TRIM(a.company_id) from "
					+ CollectionScheme.GCPFMU_SCHEMA +  ".seller_company a where seller_id = ?";
			
			companies = em.createNativeQuery(sellerCompanies, Object.class).
					setParameter(1, sellerConfigItem.getSellerId()).getResultList();
			
			String companyIdFilter = "";
			
			for (Object object : companies) {
				companyIdFilter += "'" + object.toString() + "',";
			}
			
			companyIdFilter = companyIdFilter.length() > 0 ? companyIdFilter.substring(0, companyIdFilter.length() - 1) : "";
			
			if (companyIdFilter.equals("") && (needcreateBill || needClientActivities)) {
				response.setError(1);
				response.setMessage("No hay CompaÃ±Ã­as de ventas configurada para este usuario.");
				return response;
			}
			
			String sellerLines = "select TRIM(a.line_id) from "
					+ CollectionScheme.GCPFMU_SCHEMA +  ".seller_line a where seller_id = ?";
			lines = em.createNativeQuery(sellerLines, Object.class).setParameter(1, sellerConfigItem.getSellerId()).
					getResultList();
			
			String linesFilter = "";
			
			for (Object object : lines) {
				linesFilter += "'" + object.toString() + "',";
			}
			
			linesFilter = linesFilter.length() > 0 ? linesFilter.substring(0, linesFilter.length() - 1) : "";
			
			if (linesFilter.equals("") && (needcreateBill || needClientActivities)) {
				response.setError(1);
				response.setMessage("No hay Lineas de ventas configurada para este usuario.");
				return response;
			}

			
			
			if (needOrder) {
				
				String deliverQuery = "select deliver_id from "
						+ CollectionScheme.GCPFMU_SCHEMA +  ".deliver a where seller_id = ?";
		
				deliverList = em.createNativeQuery(deliverQuery).setParameter(1, sellerConfigItem.getSellerId()).
						getResultList();
			
				String deliverId = "";
			
				if (deliverList.size() > 0) {
					deliverId = (deliverList.get(0) == null ? "" : deliverList.get(0).toString());
				}
						
				if (deliverId == null || deliverId.equals("") && (needOrder)) {
					response.setError(1);
					response.setMessage("No hay Entregador configurado para este vendedor.");
					return response;
				}
			
		
			//if (needOrder) {
				users.get(0).setDeliverId(deliverId);
			//}
				
			}
			
			if (needcreateBill || needClientActivities) {
				linesCatalog = clsFMUCatalog.getCatalogByCode(FMUUtil.LINES_ID, linesFilter);
				companiesCatalog = clsFMUCatalog.getCompanies(FMUUtil.COMPANY_ID, companyIdFilter);
			}
			
			response.setUser(users.get(0));
			response.setSections(sections);
			
			if (needcreateBill || needOrder) {
				sellerConfigItem.setBranches(branches);
			}

			if (needClientActivities || needcreateBill) {
				sellerConfigItem.setLines(linesCatalog);
				sellerConfigItem.setCompanies(companiesCatalog);
			}
			
			if (needCashAction || needcreateBill || needOrder) {
				sellerConfigItem.setSeller(seller.get(0));
			}
			
			response.setSellerConfig(sellerConfigItem);
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return response;
	}
	
	/**
	 * Get Settings List
	 * 
	 * @param em
	 * @return
	 * @throws Exception
	 */
	public List<AppSetting> getAppSettings() throws Exception {
		List<AppSetting> devices = new ArrayList<AppSetting>();

		try {
			String sQuery = "select a.name name, a.value, a.description  "
					+ "from " + CollectionScheme.GCPFMU_SCHEMA + ".setting a";
			devices = em.createNativeQuery(sQuery, AppSetting.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return devices;
	}
	
	private boolean findRoleAction(List<Section> sections, int sectionId) {
		for (Section section : sections) {
			if (section.getSectionId() == sectionId) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isBillingAction(List<Section> sections) {
		for (Section section : sections) {
			if (section.getSectionId() == FMUUtil.CREATE_BILL_ROLE_ID || 
					section.getSectionId() == FMUUtil.CANCEL_BILL_ROLE_ID ||
					section.getSectionId() == FMUUtil.DEV_BILL_ROLE_ID || 
					section.getSectionId() == FMUUtil.VIEW_BILL) {
				
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Get Current Version
	 * 
	 * @param em
	 * @return
	 * @throws Exception
	 */
	public VersionFMU getActiveVersion() throws Exception {
		VersionFMU versionFMU = new VersionFMU();

		try {
			String sQuery = "select a.name name, a.version_name versionName, a.version_code versionCode, a.active  "
					+ "from " + CollectionScheme.GCPFMU_SCHEMA + ".version a where a.active = 1 order by a.id desc FETCH FIRST 1 ROWS ONLY";
			versionFMU = (VersionFMU) em.createNativeQuery(sQuery, VersionFMU.class).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return versionFMU;
	}
	
	
	/**
	 * Get Sections
	 * 
	 * @param em
	 * @return
	 * @throws Exception
	 */
	public List<Section> getSections(String roleId) throws Exception {
		List<Section> sections = new ArrayList<Section>();
		roleId = "(" + roleId + ")";

		
		try {
			String sQuery = "select a.id sectionId, a.active, a.name name, a.image, "
					+ "a.class_name className, a.class_type classType, a.order order, a.menu menu from " 
					+ CollectionScheme.GCPFMU_SCHEMA + ".role_section b left outer join " 
					+ CollectionScheme.GCPFMU_SCHEMA + ".section a on a.id = b.section_id  "
							+ "where b.role_id in " + roleId + " order by a.order";
					
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
	 * Get User Roles
	 * 
	 * @param em
	 * @return
	 * @throws Exception
	 */
	/*@SuppressWarnings("unchecked")
	public List<UserRole> getUserRoles(EntityManager em) throws Exception {
		List<UserRole> userRoles = new ArrayList<UserRole>();

		try {
			String sQuery = "select a.user_id userId, a.role_Id roleId from " + FMUUtil.GCPFMU_SCHEMA +  ".user_roles a";
			userRoles = em.createNativeQuery(sQuery, UserRole.class).getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return userRoles;
	}*/

	/**
	 * User And Devices Assigns
	 * 
	 * @param em
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	/*@SuppressWarnings("unchecked")
	public List<Device> getUserByDeviceUUID(EntityManager em, String UUID) throws Exception {
		List<Device> devices = new ArrayList<Device>();

		System.out.println("Entro  : " + UUID);
		try {
			String sQuery = "select a.uuid, IFNULL(b.user_id, '') user_id, IFNULL(b.active, 0) active " + " from " + FMUUtil.GCPFMU_SCHEMA + ".devices a LEFT OUTER "
					+ "JOIN " + FMUUtil.GCPFMU_SCHEMA + ".user_devices b on a.uuid = b.uuid  " + "WHERE a.uuid in (?)";
			devices = em.createNativeQuery(sQuery, Device.class).setParameter(1, UUID).getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return devices;
	}*/

	
	/**
	 * Insert new Device
	 * 
	 * @param em
	 * @param uuid
	 * @param system
	 * @param branch
	 * @return
	 * @throws Exception
	 */
	public ResponseApi newDevice(String uuid, String system, String branch) throws Exception {
		List<Device> devices = new ArrayList<Device>();
		ResponseApi response = new ResponseApi();

		try {
			String sQueryExist = "SELECT a.UUID  FROM " + CollectionScheme.GCPFMU_SCHEMA +  ".DEVICES a WHERE a.UUID = ?";
			devices = em.createNativeQuery(sQueryExist, Device.class).setParameter(1, uuid).getResultList();

			if (devices.size() > 0) {
				response.setError(1);
				response.setMessage("Este dispositivo ya se encuentra registrado en la base de datos.");
			
			} else {

				String sQuery = "INSERT INTO " + CollectionScheme.GCPFMU_SCHEMA +  ".DEVICES (UUID, VERSION, BRAND, ACTIVE) VALUES (?, ?, ?, 0)";
				int valor = em.createNativeQuery(sQuery).setParameter(1, uuid).setParameter(2, system).setParameter(3, branch)
						.executeUpdate();

				if (valor > 0) {
					response.setError(0);
					response.setMessage("dispositivo Registrado correctamente");
				} else {
					response.setError(1);
					response.setMessage("dispositivo registrado incorrectamente");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setError(1);
			response.setMessage("dispositivo registrado incorrectamente");
			e.printStackTrace();

			throw new Exception(e.getMessage());
		}
		return response;
	}

	/**
	 * List of section for SYNC
	 * @return
	 * @throws Exception
	 */
	public List<SyncSection> getSyncSections() throws Exception {
		List<SyncSection> syncSections = new ArrayList<SyncSection>();

		try {
			String sQuerySections = "select "
					+ "name name, "
					+ "value value, "
					+ "id sectionId, "
					+ "created, "
					+ "updated, "
					+ "order, IFNULL(refresh, 1) refresh from " + CollectionScheme.GCPFMU_SCHEMA + ".sync_sections";
			syncSections = em.createNativeQuery(sQuerySections, SyncSection.class).getResultList();
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return syncSections;
	}

}