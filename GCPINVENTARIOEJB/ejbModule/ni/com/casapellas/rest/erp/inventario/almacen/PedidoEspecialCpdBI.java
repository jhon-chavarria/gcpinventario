package ni.com.casapellas.rest.erp.inventario.almacen;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ni.com.casapellas.erp.inventario.almacen.PedidoEspecialCpdService;
import ni.com.casapellas.erp.util.AuditMastersBean;
import ni.com.casapellas.gcpinventario.PedidoEspecialCpd;

@Stateless
//@Singleton
@LocalBean
public class PedidoEspecialCpdBI {
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	@EJB
	private AuditMastersBean audit;
	
	public PedidoEspecialCpdBI() {
	}

	@Lock(LockType.WRITE)
	public String CrearPedidoEspecialCpd(PedidoEspecialCpd objInput) throws Exception {
		String result = "";
		PedidoEspecialCpdService service = null;
		
		try {
			
			service = new PedidoEspecialCpdService(em, audit.getGuid());
			
			audit.logAuditDetailRequestEJB("CrearPedidoEspecialCpd",audit.getGuid());
			result = service.Insert(objInput);
			audit.logAuditDetailResponseEJB("CrearPedidoEspecialCpd",audit.getGuid());

		} catch (Exception e) {
			e.printStackTrace();
			
			throw e;
		}
		
		return result;
	}
}
