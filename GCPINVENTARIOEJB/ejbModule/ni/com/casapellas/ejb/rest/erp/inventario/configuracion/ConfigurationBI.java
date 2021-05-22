package ni.com.casapellas.ejb.rest.erp.inventario.configuracion;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ni.com.casapellas.gcpinventario.TABMUL;
import ni.com.casapellas.rest.erp.inventario.configuracion.Configuration;

@Stateless
@LocalBean
public class ConfigurationBI {
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	
	public List<TABMUL> getCustomInformation(String code) throws Exception{
		Configuration conf = new Configuration();
		
		return conf.getCustomInformation(code);
	}
}
