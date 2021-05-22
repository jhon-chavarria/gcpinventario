package ni.com.casapellas.rest.erp.inventario.configuracion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ni.com.casapellas.erp.util.AuditLogService;
import ni.com.casapellas.gcpinventario.Contador;
import ni.com.casapellas.util.CollectionScheme;

public class ContadorService {
	EntityManager connection = null;
	String Guid;
	/**
	 * 
	 */
	public ContadorService(EntityManager em) {
		this.connection = em;
	}
	
	public ContadorService(EntityManager em, String uGuid) {
		this.connection = em;
		this.Guid = uGuid;
	}
	
	public Integer getNextCounterValue(String pCompania, String pSucursal, String pBodega, String pTipoMovimiento) throws Exception {
		String strQuery = "";
		Query q = null;
		Integer result = 0;
		ArrayList<Object> queryParams = new ArrayList<Object>();
		
		try {
			// strQuery = "SELECT COALESCE(NUMCON, 0) AS NUMCON FROM " + CollectionScheme.SchemeInventario + ".INVCON WHERE COMPA = ?1 AND SUCUR = ?2";
			strQuery = "SELECT COMPA, SUCUR, BODEG, TIPOM, NUMCON, SSZONA, SSBODABAST, SFECHAM, SHORAM, SHECHOP, SPANTAL, SNPROGR, "
					+ "SFECHAMM, SHORAMM, SHECHOPM, SPANTALM, SNPROGRM, SIMPRES1, SIMPRES2, SIMPRES3, SIMPRES4, SIMPRES5 "
					+ "FROM " + CollectionScheme.SchemeInventario + ".INVCON WHERE COMPA = ?1 AND SUCUR = ?2";
			
			if (!pBodega.isEmpty() && !pTipoMovimiento.isEmpty()) {
				strQuery = strQuery + " AND BODEG = ?3 AND TIPOM = ?4";
			} else if (!pBodega.isEmpty()) {
				strQuery = strQuery + " AND BODEG = ?3";
			} else if (!pTipoMovimiento.isEmpty()) {
				strQuery = strQuery + " AND TIPOM = ?3"; 
			}
			
			q = this.connection.createNativeQuery(strQuery, Contador.class);

			queryParams.add(pCompania);
			queryParams.add(pSucursal);
			
			if (!pBodega.isEmpty() && !pTipoMovimiento.isEmpty()) {
				queryParams.add(pBodega);
				queryParams.add(pTipoMovimiento);
			} else if (!pBodega.isEmpty()) {
				queryParams.add(pBodega);
			} else if (!pTipoMovimiento.isEmpty()) {
				queryParams.add(pTipoMovimiento); 
			}
			
			// Asignar los parametros
			for (int i = 0; i < queryParams.size(); i++) {
				q.setParameter((i + 1), queryParams.get(i));
			}
			
			// Obtener el valor
			//BigDecimal contadorActual = (BigDecimal) q.getSingleResult();
			BigDecimal contadorActual = new BigDecimal(0);
			
			AuditLogService.SaveLogDetail("getNextCounterValue",strQuery,Guid);
			
			@SuppressWarnings("unchecked")
			List<Contador> listCounter = (List<Contador>)q.getResultList();
			
			if (listCounter != null && listCounter.size() > 0) {
				Contador counter = listCounter.get(0);
				
				contadorActual = counter.getNumcon();
			}
			
			result = contadorActual.intValue() + 1;
			
			setNextCounterValue(pCompania, pSucursal, pBodega, pTipoMovimiento, result);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("No se ha podido consultar el correlativo " + e.getMessage());
		}
		
		return result;
	}
	
	private void setNextCounterValue(String pCompania, String pSucursal, String pBodega, String pTipoMovimiento, Integer pNewValue) throws Exception {
		String strQuery = "";
		Query q = null;
		ArrayList<Object> queryParams = new ArrayList<Object>();
		
		try {
			strQuery = "UPDATE " + CollectionScheme.SchemeInventario + ".INVCON SET NUMCON = ?1 WHERE COMPA = ?2 AND SUCUR = ?3";
			
			if (!pBodega.isEmpty() && !pTipoMovimiento.isEmpty()) {
				strQuery = strQuery + " AND BODEG = ?4 AND TIPOM = ?5";
			} else if (!pBodega.isEmpty()) {
				strQuery = strQuery + " AND BODEG = ?4";
			} else if (!pTipoMovimiento.isEmpty()) {
				strQuery = strQuery + " AND TIPOM = ?4"; 
			}
			
			q = this.connection.createNativeQuery(strQuery);
			queryParams.add(pNewValue);
			queryParams.add(pCompania);
			queryParams.add(pSucursal);
			
			if (!pBodega.isEmpty() && !pTipoMovimiento.isEmpty()) {
				queryParams.add(pBodega);
				queryParams.add(pTipoMovimiento);
			} else if (!pBodega.isEmpty()) {
				queryParams.add(pBodega);
			} else if (!pTipoMovimiento.isEmpty()) {
				queryParams.add(pTipoMovimiento); 
			}
			
			// Asignar los parametros
			for (int i = 0; i < queryParams.size(); i++) {
				q.setParameter((i + 1), queryParams.get(i));
			}

			AuditLogService.SaveLogDetail("setNextCounterValue",strQuery,Guid);
			
			q.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("No se ha podido generar el correlativo " + e.getMessage());
		}
	}
	
}
