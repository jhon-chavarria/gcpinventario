package ni.com.casapellas.erp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import ni.com.casapellas.gcpinventario.AuditDetail;
import ni.com.casapellas.gcpinventario.AuditMaster;
import ni.com.casapellas.util.CollectionScheme;

public class AuditLogService {
	private static Connection connection = null;
	
	private static Connection getConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				// Parece que la version del driver de as400 no soporta este metodo connection.isValid(5)
				return connection;
			}
			return create();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static Connection create() {
		try {
			Class.forName("com.ibm.as400.access.AS400JDBCDriver");

			return DriverManager.getConnection(CollectionScheme.LogUrlConnection, CollectionScheme.Usuario, CollectionScheme.Contrasenia);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void UpdateMasterResponseLog(String Guid, String date) {
		try {
			if (connection == null) {
				connection = getConnection();
			}
			String strQuery="UPDATE " + 
					CollectionScheme.SchemeInventario+".AUDITMASTER " + 
					"SET " + 
					"ResponseDate = '"+date+"' " + 
					"WHERE " + 
					"Gid = '"+Guid+"'";
			
			ExecuteCommand(strQuery);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void CreateLog(AuditMaster item) {
		try {
			connection = getConnection();
			
			String strQuery="INSERT INTO "+CollectionScheme.SchemeInventario+".AuditMaster ("
					+ "GID, ApplicationName, MethodName, MethodType, UserName, ActionType, CreatedOn,RequestPath,PuntoVenta) "
					+ "VALUES ('" + item.getGID() + "','" + item.getApplicationName() + "','"
					+ item.getMethodName() + "','" + item.getMethodType() + "','" + item.getUserName() 
					+ "','" + item.getActionType() + "','" + item.getCreatedOn() + "','" + item.getRequestPath() 
					+ "','" + item.getPuntoVenta() + "')";
			
			ExecuteCommand(strQuery);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void SaveLogDetail(AuditDetail item) {
		try {		
			connection = getConnection();
			
			String strQuery="INSERT INTO "+CollectionScheme.SchemeInventario+".AuditDetail (AuditMasterGID, CallType, Message, CreatedOn) "
					+ "Values ('" + item.getAuditMasterGID() + "','" + item.getCallType() + "','" + item.getMessage().replace("'", "''") + "', '" + item.getCreatedOn() + "')";
			
			ExecuteCommand(strQuery);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void SaveLogDetail(String methodName, String query, String GuidString) {
		try {
			CustomFormat format = new CustomFormat();
			
			AuditDetail detail = new AuditDetail();
			detail.setAuditMasterGID(GuidString);
			detail.setCallType(methodName);
			detail.setCreatedOn(format.getCurrentStringDate());
			detail.setMessage(query);
			
			SaveLogDetail(detail);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void ExecuteCommand(String strQuery) {
		try {
			Statement stmt = connection.createStatement();
			
			stmt.execute(strQuery);
			
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
