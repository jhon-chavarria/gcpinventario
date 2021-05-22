package ni.com.casapellas.erp.gcpfmu;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import ni.com.casapellas.gcpfmu.pojo.CashReceipt;
import ni.com.casapellas.gcpfmu.pojo.FMUUtil;
import ni.com.casapellas.util.CollectionScheme;

public class ClsJdeReceipt {
	
	public ClsJdeReceipt() {};
	
	public int getReciboJdeSequence(EntityManager em, int idJsonLog, String companyId, boolean isCash) {
		List<Object> object = new ArrayList<Object>();

		String sTabla = "";
		String sPosicion = "";
		
		if (companyId.equals("E01")) {
			sTabla = "03";
			sPosicion = "005";
		} else if (companyId.equals("E02")) {
			sTabla = "5555";
			sPosicion = "001";
		} else if (companyId.equals("E08")) {
			sTabla = "5555";
			sPosicion = "003";
		} else if (companyId.equals("E03")) {
			sTabla = "5803";
			sPosicion = "005";
		} else if (companyId.equals("E10")) {
			sTabla = "5655";
			sPosicion = "001";
		}

		if (isCash) {
			sTabla = "09";
			sPosicion = "002";
		}		
		
		try {
			
			String sQuery = "select (nnn" + sPosicion + " + 1)  from " + CollectionScheme.SchemeJDECOM + ".f0002 "
					+ "where nnsy = '" +  sTabla  +"'";			
			object = em.createNativeQuery(sQuery, Object.class).getResultList();
			
			ClsSystemLogs.createQueryLog(idJsonLog, "getReciboJdeSequence", sQuery, false, 0);
			
			int number = object.get(0) == null ? 0 : Integer.parseInt(object.get(0).toString());
			
			if (number > 0) {
				String sQueryUpdate = "update " + CollectionScheme.SchemeJDECOM + ".f0002 set nnn" + sPosicion  + " = (nnn" + sPosicion + " + 1) "
					+ "where nnsy = '" +  sTabla  +"'";
				int rows = em.createNativeQuery(sQueryUpdate).executeUpdate();
				ClsSystemLogs.createQueryLog(idJsonLog, "getReciboJdeSequence", sQueryUpdate, true, rows);
			}
		
			return number;	
		}

		catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
		
	}
	
	// Quitar metodo static
	public int insertReciboJDERelation(EntityManager em, int idJsonLog, CashReceipt cajaReceipt, int batchNumber, int receiptNumber, String type) {
		
		try {
			String sQuery = "INSERT INTO " + CollectionScheme.SchemeCAJA + ".RECIBOJDE (" +
				"NUMREC," +
				"CODCOMP," +
				"RECJDE," +
				"NOBATCH," +
				"CAID," +
				"CODSUC," +
				"TIPODOC," +
				"TIPOREC) " +
				
			"VALUES (" + cajaReceipt.getReceiptNumber() + ", " +
			 		"'" + cajaReceipt.getJdCompanyId() + "', " +
			 		"" + receiptNumber + ", " +
			 		"" + batchNumber + ", " +
			 		"" + cajaReceipt.getCashId() + ", " +
			 		"'" + cajaReceipt.getJdBranchId() + "', " +
			 		"'" + (cajaReceipt.getTypeReceipt().equals(FMUUtil.CASH_LETTER) ? "A" : "R") +  "', " +
			 		"'" + type + "')";
			
			int rows = em.createNativeQuery(sQuery).executeUpdate();
			
			ClsSystemLogs.createQueryLog(idJsonLog, "insertReciboJDERelation", sQuery, true, rows);
			
			return rows;
	
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}		
	}
}
