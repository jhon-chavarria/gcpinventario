package ni.com.casapellas.inventario.acces;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * 
 * CASA PELLAS S.A.
 * Author            : Mario Osorno.
 * Fecha Creación    : 24/03/2014
 * Descripción       : Consulta tabla para cargar llaves de acceso.
 */

@Stateless
@LocalBean
public class KeyAccesBl {

	
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	
	
	public String loadKeyApp(String App,String AppCode) {

	    String strCadKey = "SELECT KEY FROM GCPSIADE.CONF_ACCESO_X_MODULO M WHERE COD_APP = ?1 ";
		try {
			if(AppCode!=null && AppCode.compareToIgnoreCase("")!=0){
				strCadKey+= "AND COD_MODULO = "+AppCode;
			}else{
				strCadKey+= "AND COD_MODULO = 0";
			}
			
//			System.out.print(strCadKey + "  -- " + App);
			Object obj = (Object) em.createNativeQuery(strCadKey).setParameter(1, App).getSingleResult();			
			return  obj.toString();
		} catch (Exception e) {    
			e.printStackTrace();
		}
		return "";
	}
}
