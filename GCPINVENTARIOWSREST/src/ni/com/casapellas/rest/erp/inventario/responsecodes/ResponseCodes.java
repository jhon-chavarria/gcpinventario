package ni.com.casapellas.rest.erp.inventario.responsecodes;

import javax.ws.rs.core.Response;

public class ResponseCodes {
	public static Response status403() {
		return Response.status(403).entity("Error: Acceso denegado").build();
	}
	
	public static Response status201(Object objResult){
		return Response.status(201).entity(objResult).build();
	}
}
