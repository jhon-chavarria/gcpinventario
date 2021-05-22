package ni.com.casapellas.rest.taller;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ni.com.casapellas.ejb.taller.PresupuestoService;
import ni.com.casapellas.erp.util.AuditMastersBean;
import ni.com.casapellas.gcptaller.pojo.PresupuestoTaller;

@Stateless
@LocalBean
public class PresupuestoBI {
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	@EJB
	private AuditMastersBean audit;
	
	PresupuestoService service = null;

	/**
	 * 
	 */
	public PresupuestoBI() {

	}
	
	public PresupuestoTaller ObtenerPresupuesto(String pCompania, String pTaller, String pTipoPresupuesto, String pFechaPresupuesto, BigDecimal pNumeroPresupuesto) throws Exception {
		PresupuestoTaller result = null;
		
		try {
			if (service == null) {
				service = new PresupuestoService(em, audit.getGuid());
			}
			
			audit.logAuditDetailRequestEJB("ObtenerPresupuesto",audit.getGuid());
			result = service.GetWorkshopBudget(pCompania, pTaller, pTipoPresupuesto, pFechaPresupuesto, pNumeroPresupuesto);
			audit.logAuditDetailResponseEJB("ObtenerPresupuesto",audit.getGuid());
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			service = null;
		}
		
		return result;
	}
}
