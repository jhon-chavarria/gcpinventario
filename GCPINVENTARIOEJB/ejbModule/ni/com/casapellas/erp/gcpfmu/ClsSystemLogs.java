package ni.com.casapellas.erp.gcpfmu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ni.com.casapellas.util.CollectionScheme;

/**
 * Manejo de logs dede la movil, solicitud de json enviado por la movil
 * y manejo de consultas enviadas de la movil hacia el servidor, esto con
 * el fin de verificar la corecta transaccion de los metodos de inserciones 
 * y actualizaciones a las tablas del JDE y sistema de caja, verificando 
 * cualquier posible error que pueda ocasionar problemas en JDE.   
 * 
 * @author Francisco Landeros
 *
 */

@Singleton
public class ClsSystemLogs {
	
	private static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat sdfTime = new SimpleDateFormat("HHmmss");
	
	@Inject
	public ClsSystemLogs() {}
	
	/**
	 * Metodo encargado de almacenar el json que envia la movil al momento
	 * de sincronizar con el servidor.
	 * 
	 * @param em EntityManager
	 * @param json Json que envia la movil
	 * @return Id generado de la insercion del log
	 */
	public static int createJsonLog(String json) {
		
		String sqlQueryIns = "SELECT ID FROM NEW TABLE (INSERT INTO " + CollectionScheme.GCPFMU_SCHEMA 
				+ ".JSON_LOG(IDATE, ITIME, SJSON) "
				+ "VALUES (?, ?, ?))";
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		Date date = Calendar.getInstance().getTime();
		
		Integer id = 0;
		
		try {
			
			ClsNativeConnection dbnc = new ClsNativeConnection();
			dbConnection = dbnc.getConnection();
			preparedStatement = dbConnection.prepareStatement(sqlQueryIns);
			preparedStatement.setInt(1, Integer.parseInt(sdfDate.format(date)));
			preparedStatement.setInt(2, Integer.parseInt(sdfTime.format(date)));			
			preparedStatement.setString(3, json);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				id = rs.getInt("ID");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}
		
		return id;
	}
	
	/**
	 * Metodo encargado de inserttar la consulta ejecutada dentro del proceso de un metodo
	 * del sistema, y cantoidad de registros afectados en la transaccion.
	 * 
	 * @param idJsonLog Id generado de la transaccion del log de la movil
	 * @param methodName Nombre del metodo desde el que se invoca la insercion del registro
	 * @param sQuery Consulta ejecutada desde la movil, verificando que parametros se envian
	 * @param isTransact Si la consulta es de insert o update parametro es true
	 */
	public static void createQueryLog(int idJsonLog, String methodName, String sQuery, boolean isTransact) {
		createQueryLog(idJsonLog,methodName, sQuery, isTransact, 0);
	}
	
	/**
	 * Metodo encargado de inserttar la consulta ejecutada dentro del proceso de un metodo
	 * del sistema, y cantoidad de registros afectados en la transaccion.
	 * 
	 * @param em EntityManager
	 * @param idJsonLog Id generado de la transaccion del log de la movil
	 * @param methodName Nombre del metodo desde el que se invoca la insercion del registro
	 * @param sQuery Consulta ejecutada desde la movil, verificando que parametros se envian
	 * @param isTransact Si la consulta es de insert o update o solo read
	 * @param rowsAffected Registros afectados si la consulta es de insert o update
	 */
	public static void createQueryLog(int idJsonLog, String methodName, String sQuery, boolean isTransact, int rowsAffected) {
		
		String sqlQueryIns = "INSERT INTO " + CollectionScheme.GCPFMU_SCHEMA + ".QUERY_LOG(ID_JSON_LOG, IDATE, ITIME, METHOD_NAME, QUERY, IS_TRANSACT, ROWS_AFFECTED)" + 
				"VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		Date date = Calendar.getInstance().getTime();
		
		try {
			
			ClsNativeConnection dbnc = new ClsNativeConnection();
			dbConnection = dbnc.getConnection();
			preparedStatement = dbConnection.prepareStatement(sqlQueryIns);
			preparedStatement.setInt(1, idJsonLog);
			preparedStatement.setInt(2, Integer.parseInt(sdfDate.format(date)));
			preparedStatement.setInt(3, Integer.parseInt(sdfTime.format(date)));
			preparedStatement.setString(4, methodName);
			preparedStatement.setString(5, sQuery);
			preparedStatement.setInt(6, ((isTransact) ? 1 : 0));
			preparedStatement.setInt(7, ((isTransact) ? rowsAffected : 0));
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}

	}
	
	/**
	 * Metodo encargado de inserttar la consulta ejecutada dentro del proceso de un metodo
	 * del sistema, y cantoidad de registros afectados en la transaccion.
	 * 
	 * @param em EntityManager
	 * @param idJsonLog Id generado de la transaccion del log de la movil
	 * @param methodName Nombre del metodo desde el que se invoca la insercion del registro
	 * @param sQuery Consulta ejecutada desde la movil, verificando que parametros se envian
	 * @param isTransact Si la consulta es de insert o update o solo read
	 * @param rowsAffected Registros afectados si la consulta es de insert o update
	 * @param params Lista de parametros inyectados en la consulta
	 */
	public static void createQueryLog(int idJsonLog, String methodName, String sQuery, boolean isTransact, int rowsAffected, Object[] params) {
		String sqlQueryIns = "INSERT INTO " + CollectionScheme.GCPFMU_SCHEMA + ".QUERY_LOG(ID_JSON_LOG, IDATE, ITIME, METHOD_NAME, QUERY, IS_TRANSACT, ROWS_AFFECTED)" + 
				"VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		StringBuilder sb = new StringBuilder();
		if(params != null) {
			sb.append(" ").append("[");
			for (int i = 0; i < params.length; i++) {
				sb.append(String.valueOf(params[i]));
				if(i < params.length - 1) {
					sb.append(" , ");
				}
			}
			sb.append("]");
			
			sQuery = sQuery + sb.toString();
		}
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		Date date = Calendar.getInstance().getTime();
		
		try {
			
			ClsNativeConnection dbnc = new ClsNativeConnection();
			dbConnection = dbnc.getConnection();
			preparedStatement = dbConnection.prepareStatement(sqlQueryIns);
			preparedStatement.setInt(1, idJsonLog);
			preparedStatement.setInt(2, Integer.parseInt(sdfDate.format(date)));
			preparedStatement.setInt(3, Integer.parseInt(sdfTime.format(date)));
			preparedStatement.setString(4, methodName);
			preparedStatement.setString(5, sQuery);
			preparedStatement.setInt(6, ((isTransact) ? 1 : 0));
			preparedStatement.setInt(7, ((isTransact) ? rowsAffected : 0));
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}
	}
}
