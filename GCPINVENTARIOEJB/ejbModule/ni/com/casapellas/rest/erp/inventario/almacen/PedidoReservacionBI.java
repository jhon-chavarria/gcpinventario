package ni.com.casapellas.rest.erp.inventario.almacen;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ni.com.casapellas.erp.inventario.almacen.PedidoReservacionService;
import ni.com.casapellas.erp.util.AuditMastersBean;
import ni.com.casapellas.gcpinventario.PedidoReservacion;

@Stateless
//@Singleton
@LocalBean
public class PedidoReservacionBI {
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	@EJB
	private AuditMastersBean audit;
	
	@Lock(LockType.WRITE)
	public String CrearReservacion(PedidoReservacion objInput) throws Exception {
		String result = "";
		PedidoReservacionService service = null;
		
		try {
			service = new PedidoReservacionService(em, audit.getGuid());
			
			audit.logAuditDetailRequestEJB("CrearReservacion",audit.getGuid());
			result = service.Insert(objInput);
			audit.logAuditDetailResponseEJB("ObtenerListaTalleres",audit.getGuid());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return result;
	}
}
