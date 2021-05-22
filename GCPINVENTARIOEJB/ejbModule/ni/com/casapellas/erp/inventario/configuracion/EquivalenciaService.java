package ni.com.casapellas.erp.inventario.configuracion;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ni.com.casapellas.erp.util.AuditLogService;
import ni.com.casapellas.gcpinventario.InventarioEquivalencia;
import ni.com.casapellas.util.CollectionScheme;

public class EquivalenciaService {
	EntityManager connection = null;
	String Guid;
	/**
	 * 
	 */
	public EquivalenciaService(EntityManager em) {
		this.connection = em;
	}
	
	public EquivalenciaService(EntityManager em,String GuidMaster) {
		this.connection = em;
		this.Guid = GuidMaster;
	}
	
	public Boolean IsValidConfiguration(String pCompany, String pBranch) {
		Boolean isValid = false;
		try {
			InventarioEquivalencia inv = GetConfiguration(pCompany, pBranch, "");
			
			isValid = inv != null;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
		return isValid;
	}
	
	public Boolean IsValidConfiguration(String pCompany, String pBranch, String pDepartment) {
		Boolean isValid = false;
		try {
			InventarioEquivalencia inv = GetConfiguration(pCompany, pBranch, pDepartment);
			
			isValid = inv != null;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return isValid;
	}
	
	public InventarioEquivalencia GetConfigurationRow(String pCompany, String pBranch) {
		return GetConfiguration(pCompany, pBranch, "");
	}
	
	public InventarioEquivalencia GetConfigurationRow(String pCompany, String pBranch, String pDepartment) {
		return GetConfiguration(pCompany, pBranch, pDepartment);
	}
	
	private InventarioEquivalencia GetConfiguration(String pCompany, String pBranch, String pDepartment) {
		InventarioEquivalencia config = null;
		Query q = null;
		String strQuery = "";
		try {
			strQuery = "SELECT "
					+ "CODTAB AS CODIGOTABLA, "
					+ "COMPAN AS CODIGOCOMPANIA, "
					+ "SUCURS AS CODIGOSUCURSAL, "
					+ "DEPART AS CODIGODEPARTAMENTO, "
					+ "CODIDE AS CODIGOSUBTIPOTABLA, "
					+ "CODIGO AS CODIGOELEMENTO, "
					+ "DESCRI AS DESCRIPCION, "
					+ "JDCOMPAN AS CODIGOCOMPANIAJDE, "
					+ "JDSUCURS AS CODIGOSUCURSALJDE, "
					+ "JDDEPART AS CODIGODEPARTAMENTOJDE "
					+ "FROM " + CollectionScheme.SchemeInventario + ".INVD00 "
					+ "WHERE CODTAB = '001' AND COMPAN = ?1 AND SUCURS = ?2";
			
			if (!pDepartment.trim().isEmpty()) {
				strQuery += " AND DEPART = ?3 AND NIVEL = 4";
			} else {
				strQuery += " AND NIVEL = 3";
			}
			
			q = this.connection.createNativeQuery(strQuery, InventarioEquivalencia.class);
			q.setParameter(1, pCompany);
			q.setParameter(2, pBranch);
			
			if (!pDepartment.trim().isEmpty()) {
				q.setParameter(3, pDepartment);
			}
			
			AuditLogService.SaveLogDetail("GetConfiguration",strQuery,Guid);
			
			@SuppressWarnings("unchecked")
			List<InventarioEquivalencia> result = (List<InventarioEquivalencia>)q.getResultList();
			
			if (result != null && result.size() > 0) {
				config = result.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return config;
	}
}
