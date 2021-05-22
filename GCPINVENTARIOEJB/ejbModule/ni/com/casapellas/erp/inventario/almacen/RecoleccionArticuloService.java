package ni.com.casapellas.erp.inventario.almacen;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ni.com.casapellas.ejb.erp.inventario.util.SqlQuery;
import ni.com.casapellas.erp.util.AuditLogService;
import ni.com.casapellas.gcpinventario.RecoleccionArticulo;
import ni.com.casapellas.util.CollectionScheme;

public class RecoleccionArticuloService {
	EntityManager connection = null;
	String Guid;

	/**
	 * @param em 
	 * 
	 */
	public RecoleccionArticuloService(EntityManager em) {
		this.connection = em;
	}
	
	public RecoleccionArticuloService(EntityManager em, String uGuid) {
		this.connection = em;
		this.Guid = uGuid;
	}
	
	public void Insert(RecoleccionArticulo objInput) throws Exception {
		SqlQuery sq = new SqlQuery();
		Query q = null;
		String strQuery = "";
		
		try {
			String[] strDataType = new String[]{
					"String", "String", "String", "String", "Number", "Number", "Number", "String", "String", "String"
			};
			
			String[] strValidationRequired = new String[]{
					"S", "S", "S", "S", "S", "S", "S", "S", "S", "S"
			};
			
			String[] strValues = new String[]{
					objInput.getCodigoCompania(), objInput.getCodigoSucursal(), objInput.getCodigoBodega(),
					objInput.getTipoDocumento(), objInput.getNumeroDocumento().toString(), objInput.getFecha().toString(),
					objInput.getHora().toString(), objInput.getPantalla(), objInput.getUsuario(), objInput.getPrograma()
			};
			
			strQuery = "INSERT INTO " + CollectionScheme.SchemeInventario + ".INVD76(C3COMPAN, C3SUCURS, C3BODEGA, C3TIPO, C3DOCUME, SFECHAM, SHORAM, SPANTAL, SHECHOP, SNPROGR)";
			
			String strValuesInsert =  sq.BodyValuesInsert(strValues, strValidationRequired, strDataType);
			
			strQuery += " " + strValuesInsert;
			
			AuditLogService.SaveLogDetail("Insert", strQuery, Guid);
			
			q = this.connection.createNativeQuery(strQuery);
			sq.QueryParameterValue(q, strValues, strValidationRequired, strDataType);
			q.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("No se ha podido crear la requisa de bodega " + e.getMessage());
		}
	}
}
