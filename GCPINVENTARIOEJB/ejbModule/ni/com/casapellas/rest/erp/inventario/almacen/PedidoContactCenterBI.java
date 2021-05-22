package ni.com.casapellas.rest.erp.inventario.almacen;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ni.com.casapellas.erp.inventario.almacen.PedidoContactCenterService;
import ni.com.casapellas.erp.util.AuditMastersBean;
import ni.com.casapellas.gcpinventario.ConsultaPedidoCallCenter;
import ni.com.casapellas.gcpinventario.PedidoContactCenter;

@Stateless
//@Singleton
@LocalBean
public class PedidoContactCenterBI {
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	
	@EJB
	private AuditMastersBean audit;
	
	@Lock(LockType.WRITE)
	public String CrearPedidoContactCenter(PedidoContactCenter objInput) throws Exception {
		String result = "";
		try {
			PedidoContactCenterService service = new PedidoContactCenterService(em,audit.getGuid());
			audit.logAuditDetailRequestEJB("CrearPedidoContactCenter",audit.getGuid());
			result = service.Insert(objInput);
			audit.logAuditDetailResponseEJB("CrearPedidoContactCenter",audit.getGuid());
		} catch (Exception e) {
			audit.logAuditDetailErrorEJB(e.getMessage(),audit.getGuid());
			e.printStackTrace();
			throw e;
		}

		return result;
	}
	
	public List<ConsultaPedidoCallCenter> ObtenerPedidoConfirmado(String pCompania, String pSucursal) throws Exception {
		List<ConsultaPedidoCallCenter> result = null;
		
		try {
			PedidoContactCenterService service = new PedidoContactCenterService(em,audit.getGuid());
			
			audit.logAuditDetailRequestEJB("ObtenerPedidoConfirmado",audit.getGuid());
			result = service.GetConfirmedOrders(pCompania, pSucursal);
			audit.logAuditDetailResponseEJB("ObtenerPedidoConfirmado",audit.getGuid());
			
		} catch (Exception e) {
			audit.logAuditDetailErrorEJB(e.getMessage(),audit.getGuid());
			e.printStackTrace();
			throw e;
		}
		
		return result;
	}
}
