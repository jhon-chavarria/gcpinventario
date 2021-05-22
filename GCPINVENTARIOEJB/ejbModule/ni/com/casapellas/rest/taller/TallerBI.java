package ni.com.casapellas.rest.taller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ni.com.casapellas.ejb.taller.TallerService;
import ni.com.casapellas.erp.util.AuditMastersBean;
import ni.com.casapellas.gcptaller.pojo.OrdenTrabajo;
import ni.com.casapellas.gcptaller.pojo.Taller;
import ni.com.casapellas.gcptaller.pojo.Tecnico;

@Stateless
@LocalBean
//@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class TallerBI {
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	
	@EJB
	private AuditMastersBean audit;
	
	
	TallerService service = null;

	/**
	 * 
	 */
	public TallerBI() {
	}
	public TallerBI(String Guid) {
	}
	
	public List<Taller> ObtenerListaTalleres(String pCompania) {
		List<Taller> result = null;
		try {
			if (service == null) {
				service = new TallerService(em,audit.getGuid());
			}
			audit.logAuditDetailRequestEJB("ObtenerListaTalleres",audit.getGuid());
			result = service.getWorkShopList(pCompania);
			audit.logAuditDetailResponseEJB("ObtenerListaTalleres",audit.getGuid());
		} catch (Exception e) {			
			audit.logAuditDetailErrorEJB(e.getMessage(),audit.getGuid());
			e.printStackTrace();
			throw e;
		} finally {
			service = null;
		}
		
		return result;
	}
	
	public Taller ObtenerTallerPorCodigo(String pCompania, String pTaller) {
		Taller result = null;
		try {
			if (service == null) {
				service = new TallerService(em,audit.getGuid());
			}
			audit.logAuditDetailRequestEJB("ObtenerTallerPorCodigo",audit.getGuid());
			result = service.getWorkShopByCode(pCompania, pTaller);
			audit.logAuditDetailResponseEJB("ObtenerTallerPorCodigo",audit.getGuid());
		} catch (Exception e) {
			audit.logAuditDetailErrorEJB(e.getMessage(),audit.getGuid());
			e.printStackTrace();
			throw e;
		} finally {
			service = null;
		}
		
		return result;
	}

	public List<Taller> ObtenerListaTalleresSucursal(String pCompania, String pSucursal) {
		List<Taller> result = null;
		try {
			if (service == null) {
				service = new TallerService(em,audit.getGuid());
			}
			audit.logAuditDetailRequestEJB("ObtenerListaTalleresSucursal",audit.getGuid());
			result = service.getWorkShopListByBranch(pCompania, pSucursal);
			audit.logAuditDetailResponseEJB("ObtenerListaTalleresSucursal",audit.getGuid());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			service = null;
		}
		
		return result;
	}
	
	public List<Tecnico> ObtenerListaTecnicoSucursal(String pTaller) {
		List<Tecnico> result = null;
		try {
			if (service == null) {
				service = new TallerService(em,audit.getGuid());
			}
			audit.logAuditDetailRequestEJB("ObtenerListaTecnicoSucursal",audit.getGuid());
			result = service.getTechnicianListByBranch(pTaller);
			audit.logAuditDetailResponseEJB("ObtenerListaTecnicoSucursal",audit.getGuid());
		} catch (Exception e) {
			audit.logAuditDetailErrorEJB(e.getMessage(),audit.getGuid());
			e.printStackTrace();
			throw e;
		} finally {
			service = null;
		}
		
		return result;
	}
	
	public List<OrdenTrabajo> ObtenerListaOrdenesActivas(String pCompania, String pTaller) {
		List<OrdenTrabajo> result = null;
		try {
			if (service == null) {
				service = new TallerService(em,audit.getGuid());
			}
			audit.logAuditDetailRequestEJB("ObtenerListaOrdenesActivas",audit.getGuid());
			result = service.getWorkShopOrderList(pCompania, pTaller);
			audit.logAuditDetailResponseEJB("ObtenerListaOrdenesActivas",audit.getGuid());
		} catch (Exception e) {
			audit.logAuditDetailErrorEJB(e.getMessage(),audit.getGuid());
			e.printStackTrace();
			throw e;
		} finally {
			service = null;
		}
		
		return result;
	}
	
	public OrdenTrabajo ObtenerOrden(String pCompania, String pTaller, Integer pOrden) {
		OrdenTrabajo result = null;
		try {
			if (service == null) {
				service = new TallerService(em,audit.getGuid());
			}
			audit.logAuditDetailRequestEJB("ObtenerOrden",audit.getGuid());
			result = service.getWorkShopOrder(pCompania, pTaller, pOrden);
			audit.logAuditDetailResponseEJB("ObtenerOrden",audit.getGuid());
		} catch (Exception e) {
			audit.logAuditDetailErrorEJB(e.getMessage(),audit.getGuid());
			e.printStackTrace();
			throw e;
		} finally {
			service = null;
		}
		
		return result;
	}
}
