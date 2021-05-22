package ni.com.casapellas.erp.caja;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ni.com.casapellas.ejb.erp.util.DateTimeHelper;
import ni.com.casapellas.erp.util.AuditLogService;
import ni.com.casapellas.gcpmcaja.pojos.FactorCambio;
import ni.com.casapellas.util.CollectionScheme;

public class FactorCambioService {
	EntityManager connection = null;
	String Guid;
	
	public FactorCambioService(EntityManager em) {
		this.connection = em;
	}
	
	public FactorCambioService(EntityManager em,String GuidS) {
		this.connection = em;
		this.Guid = GuidS;
	}
	
	public FactorCambio getExchangeRateByDate(Date dt) {
		FactorCambio factorCambio = null;
		Query q = null;
		String strQuery = "";
		
		try {
			
			int integerDate = DateTimeHelper.CastDateToNumber(dt, "yyyyMMdd");

			strQuery = "WITH CTE AS ( " 
					+ "SELECT " 
					+ "    CMONO, CMOND, TCAMBIOM, TCAMBIOD, DIREC," 
					+ "    CASE LENGTH(CAST(FECHAI AS VARCHAR(8))) WHEN 8 THEN RIGHT(FECHAI, 4) || SUBSTR(FECHAI, 3, 2) || SUBSTR(FECHAI, 1, 2) ELSE RIGHT(FECHAI, 4) || SUBSTR(FECHAI, 2, 2) || '0' ||SUBSTR(FECHAI, 1, 1) END AS FECHAI," 
					+ "    CASE LENGTH(CAST(FECHAF AS VARCHAR(8))) WHEN 8 THEN RIGHT(FECHAF, 4) || SUBSTR(FECHAF, 3, 2) || SUBSTR(FECHAF, 1, 2) ELSE RIGHT(FECHAF, 4) || SUBSTR(FECHAF, 2, 2) || '0' ||SUBSTR(FECHAF, 1, 1) END AS FECHAF " 
					+ "FROM " 
					+ "    " + CollectionScheme.SchemeCAJA + ".F55CA021 " 
					+ ") " 
					+ "SELECT "
					+ "    CMONO AS codigoMonedaLocal, "
					+ "    CMOND AS codigoMonedaForanea, "
					+ "    TCAMBIOM AS factorCambio, "
					+ "    TCAMBIOD AS factorDivisor, "
					+ "    DIREC AS direccion, "
					+ "    FECHAI AS fechaInicial, "
					+ "    FECHAF AS fechaFinal "
					+ "FROM CTE WHERE FECHAI <= ?1 AND FECHAF >= ?2";
			
			q = this.connection.createNativeQuery(strQuery, FactorCambio.class);
			q.setParameter(1, integerDate);
			q.setParameter(2, integerDate);
			
			AuditLogService.SaveLogDetail("getExchangeRateByDate",strQuery,Guid);
			
			@SuppressWarnings("unchecked")
			List<FactorCambio> result = (List<FactorCambio>)q.getResultList();
			
			if (result != null && result.size() > 0) {
				factorCambio = result.get(0);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

		return factorCambio;
	}
}
