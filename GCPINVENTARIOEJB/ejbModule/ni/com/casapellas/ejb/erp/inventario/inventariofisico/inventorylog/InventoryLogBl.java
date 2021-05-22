package ni.com.casapellas.ejb.erp.inventario.inventariofisico.inventorylog;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ni.com.casapellas.util.CollectionScheme;

/**
 * 
 * @author Luis Fonseca
 *
 */
@Stateless
@LocalBean
public class InventoryLogBl {
	public String getDocumentNumberInv(String strCompanyCode,
										  String strSucursCode,
										  String strWareHouse,
										  String strMoveType)
	{

		String sResultado = "0";
		
		try {

		 String DRIVER = "com.ibm.as400.access.AS400JDBCDriver"; 
		 String URL = "jdbc:as400:" + CollectionScheme.ipServer + "/" + CollectionScheme.SchemeInventario + ";prompt=false;translate binary=true";
		 Connection conn = null;
		 
		 //Connect to iSeries 
		 Class.forName(DRIVER); 
		 conn = DriverManager.getConnection(URL, "APPCP6", "APPCP608"); 
		 
		 CallableStatement callableStatement = conn.prepareCall("{CALL " + CollectionScheme.SchemeTaller + ".SP_GETDOCUMENTNUMBERINV(?, ?, ?, ?, ?)}");

//		 System.out.println("Compania: " + strCompanyCode.trim() + " Sucursal: " + strSucursCode.trim() + " Bodega: " + strWareHouse.trim() + " TipoMovimiento: " + strMoveType.trim());
		 
		callableStatement.setString(1, strCompanyCode.trim());
		callableStatement.setString(2, strSucursCode.trim());
		callableStatement.setString(3, strWareHouse.trim());
		callableStatement.setString(4, strMoveType.trim());
		callableStatement.registerOutParameter(5, java.sql.Types.NUMERIC);

		callableStatement.execute();

		Object out2 = callableStatement.getObject(5);
//		System.out.print("Resultado es: " + out2.toString() + "  .>>>>>> \n");
		sResultado = out2.toString();
		
		 conn.close();
		 
		}
		catch (Exception e) {
			e.printStackTrace();
//		 System.out.println(e);
		}
		return sResultado;
	}
	
	
}
