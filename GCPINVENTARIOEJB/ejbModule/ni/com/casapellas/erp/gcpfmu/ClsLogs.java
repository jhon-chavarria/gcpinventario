 package ni.com.casapellas.erp.gcpfmu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.openjpa.lib.conf.StringValue;

import ni.com.casapellas.gcpfmu.pojo.BillHeader;
import ni.com.casapellas.gcpfmu.pojo.BillPost;
import ni.com.casapellas.gcpfmu.pojo.CashBillPost;
import ni.com.casapellas.gcpfmu.pojo.CashBillReceiptRelation;
import ni.com.casapellas.gcpfmu.pojo.CashChangeDetail;
import ni.com.casapellas.gcpfmu.pojo.CashReceipt;
import ni.com.casapellas.gcpfmu.pojo.CashReceiptPaymentItem;
import ni.com.casapellas.gcpfmu.pojo.FMUUtil;
import ni.com.casapellas.gcpfmu.pojo.PostObjectReturn;
import ni.com.casapellas.util.CollectionScheme;

/**
 * 
 * @author jhon
 *
 */

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN) 
public class ClsLogs {
	
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;

	@Resource 
	private SessionContext sessionContext;  
 	
	public void insertErrorLogDetail(String cellarId, String description,
			String userId, String branchId, String section, String objectId, String companyId) {
		
		UserTransaction utx = sessionContext.getUserTransaction();
		
		try {
			
			utx.begin();

			String sQuery = "INSERT INTO " + CollectionScheme.GCPFMU_SCHEMA +  ".error_log (" +
				"CELLAR_ID," +
				"DATE," +
				"HOUR," +
				"DESCRIPTION," +
				"USER_ID," +
				"BRANCH_ID," +				
				"SECTION," +		
				"OBJECT_ID," +		
				"COMPANY_ID) " +
				
		"VALUES ('" + cellarId + "', " +
			 		"" + FMUUtil.getIntegerDate() + ", " +
			 		"" + FMUUtil.getIntegerHour(new java.util.Date()) + ", " +
			 		"'" + description + "', " +
			 		"'" + userId + "', " +
			 		"'" + branchId + "', " +
			 		"'" + section + "', " +
			 		"'" + objectId + "', " +
			 		"'" + companyId + "')";
						
			em.createNativeQuery(sQuery).executeUpdate();
			
			utx.commit();
	
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
		}		
	}
	
}
