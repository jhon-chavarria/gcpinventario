package ni.com.casapellas.rest.erp.inventario.listener;

import java.util.Set;
import javax.ws.rs.core.Application;

import ni.com.casapellas.rest.erp.gcpfmu.RequestRepuestosRest;
import ni.com.casapellas.rest.erp.inventario.cponline.SolicitudDespachoRest;
import ni.com.casapellas.rest.erp.inventario.inventariofisico.inventoryavailability.InventoryAvailabilityRest;
import ni.com.casapellas.rest.erp.inventario.inventariofisico.inventorylog.RequestPartsInventoryRest;
import ni.com.casapellas.rest.erp.inventario.inventariofisico.inventorylog.ReserveSparePartsRest;
import ni.com.casapellas.rest.erp.inventario.inventariofisico.setting.EmailNotificationSettingRest;
import ni.com.casapellas.rest.erp.inventario.ventas.proform.ProformRest;
import ni.com.casapellas.rest.erp.inventario.ventas.searcher.ProformSearchRest;

@javax.ws.rs.ApplicationPath("gcpinvrest")
public class ApplicationConfig extends Application {
	@Override  
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
		
		resources.add(ProformRest.class);
		resources.add(ProformSearchRest.class);
		resources.add(InventoryAvailabilityRest.class);
		resources.add(ReserveSparePartsRest.class);
		resources.add(RequestPartsInventoryRest.class);
		resources.add(EmailNotificationSettingRest.class);
		resources.add(RequestRepuestosRest.class);
		resources.add(SolicitudDespachoRest.class);

		return resources;
	}
}
