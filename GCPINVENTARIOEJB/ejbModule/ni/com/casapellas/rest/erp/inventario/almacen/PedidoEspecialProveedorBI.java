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

import ni.com.casapellas.erp.inventario.almacen.PedidoEspecialProveedorService;
import ni.com.casapellas.erp.util.AuditMastersBean;
import ni.com.casapellas.gcpinventario.ConsultaPedidoConfirmado;
import ni.com.casapellas.gcpinventario.ConsultaPedidoEspecialProveedor;
import ni.com.casapellas.gcpinventario.ConsultaPedidoTransito;
import ni.com.casapellas.gcpinventario.PedidoEspecialProveedor;

@Stateless
@LocalBean
public class PedidoEspecialProveedorBI {
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	@EJB
	private AuditMastersBean audit;
	PedidoEspecialProveedorService service = null;
	
	public PedidoEspecialProveedorBI() {
	}

	@Lock(LockType.WRITE)
	public String CrearPedidoProveedor(PedidoEspecialProveedor objInput) throws Exception {
		String result = "";
	
		try {
			service = new PedidoEspecialProveedorService(em,audit.getGuid());
			audit.logAuditDetailRequestEJB("CrearPedidoProveedor",audit.getGuid());
			result = service.Insert(objInput);
			audit.logAuditDetailResponseEJB("CrearPedidoProveedor",audit.getGuid());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return result;
	}
	
	public List<ConsultaPedidoTransito> ObtenerPedidosTransitoPorArticulo(String pCompania, String pArticulo){
		List<ConsultaPedidoTransito> result = null;
		
		try {
			service = new PedidoEspecialProveedorService(em,audit.getGuid());
			
			audit.logAuditDetailRequestEJB("ObtenerPedidosTransitoPorArticulo",audit.getGuid());
			result = service.getOrderInTransit(pCompania, pArticulo);
			audit.logAuditDetailResponseEJB("ObtenerPedidosTransitoPorArticulo",audit.getGuid());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return result;
	}
	
	public List<ConsultaPedidoConfirmado> ObtenerPedidosConfirmadosPorArticulo(String pCompania, String pArticulo) {
		List<ConsultaPedidoConfirmado> result = null;
		
		try {
			audit.logAuditDetailRequestEJB("ObtenerPedidosConfirmadosPorArticulo",audit.getGuid());
			service = new PedidoEspecialProveedorService(em,audit.getGuid());
			
			result = service.getConfirmedOrder(pCompania, pArticulo);
			audit.logAuditDetailResponseEJB("ObtenerPedidosConfirmadosPorArticulo",audit.getGuid());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return result;
	}
	
	public List<ConsultaPedidoEspecialProveedor> ObtenerPedidosConfirmados(String pCompania, String pSucursal) throws Exception {
		List<ConsultaPedidoEspecialProveedor> result = null;
		
		try {
			service = new PedidoEspecialProveedorService(em,audit.getGuid());
			audit.logAuditDetailRequestEJB("ObtenerPedidosConfirmados",audit.getGuid());
			result = service.GetConfirmedOrders(pCompania, pSucursal);
			audit.logAuditDetailResponseEJB("ObtenerPedidosConfirmados",audit.getGuid());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return result;
	}
}
