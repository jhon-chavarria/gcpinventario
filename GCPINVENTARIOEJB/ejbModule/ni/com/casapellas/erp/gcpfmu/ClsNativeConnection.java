package ni.com.casapellas.erp.gcpfmu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ClsNativeConnection {
	
	private String userName = "appcp";
	private String password = "appcp1810";
	private String serverName;
	private String portNumber;
	private String dbName;
	private String dbms = "db2";	
	
	public Connection getConnection() throws SQLException {

	    Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", this.userName);
	    connectionProps.put("password", this.password);

	    if (this.dbms.equals("mysql")) {
	        conn = DriverManager.getConnection(
	                   "jdbc:" + this.dbms + "://" +
	                   this.serverName +
	                   ":" + this.portNumber + "/",
	                   connectionProps);
	    } else if (this.dbms.equals("derby")) {
	        conn = DriverManager.getConnection(
	                   "jdbc:" + this.dbms + ":" +
	                   this.dbName +
	                   ";create=true",
	                   connectionProps);
	    } else if (this.dbms.equals("db2")) {
	    	try {
				Class.forName("com.ibm.as400.access.AS400JDBCDriver");
				conn = DriverManager.getConnection("jdbc:as400:192.168.1.3/CRPCPMU;prompt=false",
		                   connectionProps);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	    }
	    //System.out.println("Connected to database");
	    return conn;
	}
	
}
