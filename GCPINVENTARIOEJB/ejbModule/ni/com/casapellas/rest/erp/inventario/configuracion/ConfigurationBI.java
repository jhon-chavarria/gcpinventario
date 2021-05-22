package ni.com.casapellas.rest.erp.inventario.configuracion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import ni.com.casapellas.ejb.erp.inventario.util.SqlQuery;
import ni.com.casapellas.erp.util.AuditLogService;
import ni.com.casapellas.gcpinventario.TABMUL;
import ni.com.casapellas.util.CollectionScheme;

public class ConfigurationBI {
	protected EntityManager em = null;
	String Guid;
	
	public ConfigurationBI(EntityManager en) {
		this.em = en;
	}
	
	public ConfigurationBI(EntityManager en, String uGuid) {
		this.em = en;
		this.Guid = uGuid;
	}
	
	@SuppressWarnings("unchecked")
	public List<TABMUL> getVerificarTaller(String sucursal, String taller) throws Exception{
		List<TABMUL> returnList = new ArrayList<TABMUL>();
		@SuppressWarnings("unused")
		SqlQuery sq = new SqlQuery();
		
		try {
			String sQuery = "SELECT CODTAB, CODIDE, DESCRI, TDESCRI1, OTROS, ORDEN, TCODIGO,"+				
						  "OTROS1, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13,"+
						  "P14, P15, P16, P17, P18, P19, P20, P21, P22, P23, P24, P25,"+
						  "C1, C2, C3, C4, C5, S1, S2, S3, S4, S5, S6, S7, S8, S9, S10,"+
						  "S11, S12, S13, S14, S15, TFECHAM, THORAM, THECHOP, TNPROGR,"+
						  "TFECHAMM, THORAMM, THECHOPM, TNPROGRM"+
						  " FROM "+ CollectionScheme.SchemeInventario+".TABMUL WHERE CODTAB ='48'"
						  		+ "and CODIDE ='"+ sucursal
						  		+"' and  tdescri1 like '%"+taller+"%'"
						  +" limit 1";
			
			
			AuditLogService.SaveLogDetail("getVerificarTaller",sQuery,Guid);
			
			returnList = em.createNativeQuery(sQuery, TABMUL.class).getResultList();
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return returnList;
	}
}
