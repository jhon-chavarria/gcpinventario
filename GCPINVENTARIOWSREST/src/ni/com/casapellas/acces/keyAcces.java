package ni.com.casapellas.acces;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.HttpHeaders;

import ni.com.casapellas.inventario.acces.KeyAccesBl;

@Stateless
public class keyAcces {

	@EJB
	private KeyAccesBl keyAccesBl;
	
	private static String strKey = "GCP-API-KEY";
	private static String strModCode = "APP-MOD-CODE";
	private static String strAppCode = "APP-CODE";
	
	public  boolean requestAccess(HttpHeaders headers){
		String tmpApiKey = headers.getRequestHeaders().get(strKey).get(0);
		String tmpCodApp = headers.getRequestHeaders().get(strAppCode).get(0);
		String tmpCodModApp = headers.getRequestHeaders().get(strModCode).get(0);
//		System.err.println(" valores pasadoss ====---===>> "+tmpApiKey+" --->> "+tmpCodApp+" =====--->> "+tmpCodModApp);
//		System.out.println("--> " + keyAccesBl.loadKeyApp(tmpCodApp,tmpCodModApp));
//		System.out.println("--> " + tmpApiKey);
		if(keyAccesBl.loadKeyApp(tmpCodApp,tmpCodModApp).compareTo(tmpApiKey)==0){
			return true;
		}
		return false;
	}
	
	
}
