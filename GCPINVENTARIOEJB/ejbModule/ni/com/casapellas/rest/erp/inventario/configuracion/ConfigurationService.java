package ni.com.casapellas.rest.erp.inventario.configuracion;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ni.com.casapellas.erp.util.AuditLogService;
import ni.com.casapellas.gcpinventario.TABMUL;
import ni.com.casapellas.util.CollectionScheme;

public class ConfigurationService {
	protected EntityManager connection;
	String Guid;
	/**
	 * @param em
	 * 
	 */
	public ConfigurationService(EntityManager em,String GuidMaster) {
		this.connection = em;
		this.Guid = GuidMaster;
	}
	
	public ConfigurationService(EntityManager em) {
		this.connection = em;
	}

	public TABMUL GetCpdConfiguration() {
		TABMUL cfg = null;
		Query q = null;
		String strQuery = "";

		try {
			strQuery = "SELECT CODTAB, CODIDE, DESCRI, TDESCRI1, OTROS, ORDEN, TCODIGO,"
					+ " OTROS1, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13,"
					+ " P14, P15, P16, P17, P18, P19, P20, P21, P22, P23, P24, P25,"
					+ " C1, C2, C3, C4, C5, S1, S2, S3, S4, S5, S6, S7, S8, S9, S10,"
					+ " S11, S12, S13, S14, S15, TFECHAM, THORAM, THECHOP, TNPROGR,"
					+ " TFECHAMM, THORAMM, THECHOPM, TNPROGRM " 
					+ " FROM " + CollectionScheme.SchemeInventario + ".TABMUL " 
					+ " WHERE CODTAB ='2F' AND OTROS = '2Y'";

			q = this.connection.createNativeQuery(strQuery, TABMUL.class);
			
			AuditLogService.SaveLogDetail("GetCpdConfiguration",strQuery,Guid);

			@SuppressWarnings("unchecked")
			List<TABMUL> result = (List<TABMUL>) q.getResultList();

			if (result != null && result.size() > 0) {
				cfg = result.get(0);
			}
		} catch (Exception e) {
			throw e;
		}

		return cfg;
	}
	
	public TABMUL GetJdeTipoMov(String pDepartmentCode) {
		TABMUL cfg = null;
		Query q = null;
		String strQuery = "";

		try {
			strQuery = "SELECT CODTAB, CODIDE, DESCRI, TDESCRI1, OTROS, ORDEN, TCODIGO,"
					+ " OTROS1, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13,"
					+ " P14, P15, P16, P17, P18, P19, P20, P21, P22, P23, P24, P25,"
					+ " C1, C2, C3, C4, C5, S1, S2, S3, S4, S5, S6, S7, S8, S9, S10,"
					+ " S11, S12, S13, S14, S15, TFECHAM, THORAM, THECHOP, TNPROGR,"
					+ " TFECHAMM, THORAMM, THECHOPM, TNPROGRM " 
					+ " FROM " + CollectionScheme.SchemeInventario + ".TABMUL " 
					+ " WHERE CODTAB ='20' AND CODIDE = ?1";

			q = this.connection.createNativeQuery(strQuery, TABMUL.class);
			q.setParameter(1, pDepartmentCode);

			AuditLogService.SaveLogDetail("GetJdeTipoMov",strQuery,Guid);
			
			@SuppressWarnings("unchecked")
			List<TABMUL> result = (List<TABMUL>)q.getResultList();

			if (result != null && result.size() > 0) {
				cfg = result.get(0);
			}
		} catch (Exception e) {
			throw e;
		}

		return cfg;
	}
	
	public TABMUL GetReturnTypeByCode(String pReturnTypeCode) {
		TABMUL cfg = null;
		Query q = null;
		String strQuery = "";

		try {
			strQuery = "SELECT CODTAB, CODIDE, DESCRI, TDESCRI1, OTROS, ORDEN, TCODIGO,"
					+ " OTROS1, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13,"
					+ " P14, P15, P16, P17, P18, P19, P20, P21, P22, P23, P24, P25,"
					+ " C1, C2, C3, C4, C5, S1, S2, S3, S4, S5, S6, S7, S8, S9, S10,"
					+ " S11, S12, S13, S14, S15, TFECHAM, THORAM, THECHOP, TNPROGR,"
					+ " TFECHAMM, THORAMM, THECHOPM, TNPROGRM " 
					+ " FROM " + CollectionScheme.SchemeInventario + ".TABMUL " 
					+ " WHERE CODTAB ='53' AND CODIDE = ?1";

			q = this.connection.createNativeQuery(strQuery, TABMUL.class);
			q.setParameter(1, pReturnTypeCode);

			AuditLogService.SaveLogDetail("GetReturnTypeByCode",strQuery,Guid);
			
			@SuppressWarnings("unchecked")
			List<TABMUL> result = (List<TABMUL>) q.getResultList();

			if (result != null && result.size() > 0) {
				cfg = result.get(0);
			}
		} catch (Exception e) {
			throw e;
		}

		return cfg;
	}
	
	public TABMUL GetReservationValidity(String pValidityType) {
		TABMUL cfg = null;
		Query q = null;
		String strQuery = "";

		try {
			strQuery = "SELECT CODTAB, CODIDE, DESCRI, TDESCRI1, OTROS, ORDEN, TCODIGO,"
					+ " OTROS1, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13,"
					+ " P14, P15, P16, P17, P18, P19, P20, P21, P22, P23, P24, P25,"
					+ " C1, C2, C3, C4, C5, S1, S2, S3, S4, S5, S6, S7, S8, S9, S10,"
					+ " S11, S12, S13, S14, S15, TFECHAM, THORAM, THECHOP, TNPROGR,"
					+ " TFECHAMM, THORAMM, THECHOPM, TNPROGRM " 
					+ " FROM " + CollectionScheme.SchemeInventario + ".TABMUL " 
					+ " WHERE CODTAB ='9D' AND CODIDE = ?1";

			q = this.connection.createNativeQuery(strQuery, TABMUL.class);
			q.setParameter(1, pValidityType);

			AuditLogService.SaveLogDetail("GetReservationValidity",strQuery,Guid);
			
			@SuppressWarnings("unchecked")
			List<TABMUL> result = (List<TABMUL>) q.getResultList();

			if (result != null && result.size() > 0) {
				cfg = result.get(0);
			}
		} catch (Exception e) {
			throw e;
		}

		return cfg;
	}
	
	public TABMUL GetMaxAllowVariationCost() {
		TABMUL cfg = null;
		Query q = null;
		String strQuery = "";

		try {
			strQuery = "SELECT CODTAB, CODIDE, DESCRI, TDESCRI1, OTROS, ORDEN, TCODIGO,"
					+ " OTROS1, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13,"
					+ " P14, P15, P16, P17, P18, P19, P20, P21, P22, P23, P24, P25,"
					+ " C1, C2, C3, C4, C5, S1, S2, S3, S4, S5, S6, S7, S8, S9, S10,"
					+ " S11, S12, S13, S14, S15, TFECHAM, THORAM, THECHOP, TNPROGR,"
					+ " TFECHAMM, THORAMM, THECHOPM, TNPROGRM " 
					+ " FROM " + CollectionScheme.SchemeInventario + ".TABMUL " 
					+ " WHERE CODTAB ='7Z' AND CODIDE = 'COSTOS'";

			q = this.connection.createNativeQuery(strQuery, TABMUL.class);

			AuditLogService.SaveLogDetail("GetMaxAllowVariationCost",strQuery,Guid);
			
			@SuppressWarnings("unchecked")
			List<TABMUL> result = (List<TABMUL>) q.getResultList();

			if (result != null && result.size() > 0) {
				cfg = result.get(0);
			}
		} catch (Exception e) {
			throw e;
		}

		return cfg;
	}
}
