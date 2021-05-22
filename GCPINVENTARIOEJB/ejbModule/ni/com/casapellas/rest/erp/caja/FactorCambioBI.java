package ni.com.casapellas.rest.erp.caja;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ni.com.casapellas.ejb.erp.util.DateTimeHelper;
import ni.com.casapellas.erp.caja.FactorCambioService;
import ni.com.casapellas.erp.util.AuditMastersBean;
import ni.com.casapellas.gcpmcaja.pojos.FactorCambio;

@Stateless
@LocalBean
public class FactorCambioBI {
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	@EJB
	private AuditMastersBean audit;
	
	FactorCambioService service = null;
	
	public FactorCambio ObtenerFactorCambioPorFecha(String pFecha) throws Exception {
		FactorCambio fc = null;
		try {
			if (service == null) {
				service = new FactorCambioService(em,audit.getGuid());
			}
			audit.logAuditDetailRequestEJB("ObtenerFactorCambioPorFecha",audit.getGuid());
			fc = service.getExchangeRateByDate(DateTimeHelper.CastStringToDate(pFecha, "yyyy-MM-dd"));
			audit.logAuditDetailResponseEJB("ObtenerFactorCambioPorFecha",audit.getGuid());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		 finally {
			service = null;
		}
		return fc;
	}
}
