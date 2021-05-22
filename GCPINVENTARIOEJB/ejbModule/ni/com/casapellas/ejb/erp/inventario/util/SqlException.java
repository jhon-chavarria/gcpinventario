package ni.com.casapellas.ejb.erp.inventario.util;

import javax.persistence.EntityManager;

/**
 * 
 * Descripcion de SqlException.java
 * Sistemas: GCPQUIOSCOEJB
 * Objetivos: 
 *
 * Fecha Creacion: May 12, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class SqlException {
	
	/**
	 * @author Luis Fonseca
	 * @param em
	 * @param sMensaje
	 * @return
	 * @throws Exception
	 */
	public static String StrSQLException(EntityManager em, String sMensaje) throws Exception
	{
		try
		{
			String sQuery = "insert into sottab(tbcodi) values(dd)";
			em.createNativeQuery(sQuery).executeUpdate();
		}
		catch(Exception ex)
		{
//			ex.printStackTrace();
			throw new Exception(sMensaje);
		}
		
		return "";
	}
}
