package ni.com.casapellas.erp.util;

import java.util.Enumeration;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;

import ni.com.casapellas.gcpinventario.AuditDetail;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
@SessionScoped
@Named
public class AuditMastersBean {

	private String user;
	private String date;
	private String puntoVenta;
	CustomFormat format = new CustomFormat();
	// ---
	private String Guid;

	public String getGuid() {
		return Guid;
	}

	public void setGuid(String guid) {
		Guid = guid;
	}

	@EJB
	private AuditMasterBI ejbService;

	public void logAuditHeaderLSSoapGet(String methodName, HttpHeaders masterHeader, String GuidString,
			String URLPath) {
		if (masterHeader.getRequestHeaders().containsKey("userAPP")) {
			user = masterHeader.getRequestHeaders().get("userAPP").get(0).toString();			
		}
		if (masterHeader.getRequestHeaders().containsKey("puntoVenta")) {
			puntoVenta = masterHeader.getRequestHeaders().get("puntoVenta").get(0).toString();
		}
		this.setGuid(GuidString);

		date = format.getCurrentStringDate();
		ni.com.casapellas.gcpinventario.AuditMaster master = new ni.com.casapellas.gcpinventario.AuditMaster();
		master.setGID(GuidString);
		master.setCreatedOn(date);
		master.setActionType("GET");
		master.setUserName(user);
		master.setApplicationName("LSRetail");
		master.setMethodName(methodName);
		master.setMethodType("SOAPService");
		master.setRequestPath(URLPath);
		master.setPuntoVenta(puntoVenta);
		try {
			//ejbService.saveLogHeader(master);
			AuditLogService.CreateLog(master);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void logAuditHeaderLSSoapPost(String methodName, HttpHeaders masterHeader, String GuidString,
			String URLPath) {
		if (masterHeader.getRequestHeaders().containsKey("userAPP")) {
			user = masterHeader.getRequestHeaders().get("userAPP").get(0).toString();
			
		}
		if (masterHeader.getRequestHeaders().containsKey("puntoVenta")) {
			puntoVenta = masterHeader.getRequestHeaders().get("puntoVenta").get(0).toString();
		}
		this.setGuid(GuidString);

		date = format.getCurrentStringDate();
		ni.com.casapellas.gcpinventario.AuditMaster master = new ni.com.casapellas.gcpinventario.AuditMaster();
		master.setGID(GuidString);
		master.setCreatedOn(date);
		master.setActionType("POST");
		master.setUserName(user);
		master.setApplicationName("LSRetail");
		master.setMethodName(methodName);
		master.setMethodType("SOAPService");
		master.setRequestPath(URLPath);
		master.setPuntoVenta("");
		try {
			//ejbService.saveLogHeader(master);
			AuditLogService.CreateLog(master);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void logAuditHeaderLSSoapPUT(String methodName, HttpHeaders masterHeader, String GuidString,
			String URLPath) {
		if (masterHeader.getRequestHeaders().containsKey("userAPP")) {
			user = masterHeader.getRequestHeaders().get("userAPP").get(0).toString();
			
		}
		if (masterHeader.getRequestHeaders().containsKey("puntoVenta")) {
			puntoVenta = masterHeader.getRequestHeaders().get("puntoVenta").get(0).toString();
		}
		this.setGuid(GuidString);

		date = format.getCurrentStringDate();
		ni.com.casapellas.gcpinventario.AuditMaster master = new ni.com.casapellas.gcpinventario.AuditMaster();
		master.setGID(GuidString);
		master.setCreatedOn(date);
		master.setActionType("PUT");
		master.setUserName(user);
		master.setApplicationName("LSRetail");
		master.setMethodName(methodName);
		master.setMethodType("SOAPService");
		master.setRequestPath(URLPath);
		master.setPuntoVenta("");
		try {
			//ejbService.saveLogHeader(master);
			AuditLogService.CreateLog(master);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void logAuditDetailLSSoap(String callType, String message, HttpHeaders masterHeader, String GuidString,
			HttpServletRequest request) {

		date = format.getCurrentStringDate();
		AuditDetail detail = new AuditDetail();
		detail.setAuditMasterGID(GuidString);
		detail.setCallType(callType);
		detail.setCreatedOn(date);
		if (message != null && !message.isEmpty()) {
			detail.setMessage(message);
		} else {
			detail.setMessage(parseSOAPMessage(request));
		}
		try {
			//ejbService.saveLogDetail(detail);
			if(callType.equals("Response")) {
				AuditLogService.UpdateMasterResponseLog(GuidString, date);
			}
			AuditLogService.SaveLogDetail(detail);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void logAuditDetailErrorSOAP(String message, HttpHeaders masterHeader, String GuidString,
			HttpServletRequest request) {

		date = format.getCurrentStringDate();
		AuditDetail detail = new AuditDetail();
		detail.setAuditMasterGID(GuidString);
		detail.setCallType("ResponseError");
		detail.setCreatedOn(date);
		if (message != null && !message.isEmpty()) {
			detail.setMessage(message);
		} else {
			detail.setMessage(parseSOAPMessage(request));
		}
		try {
			//ejbService.saveLogDetail(detail);
			AuditLogService.UpdateMasterResponseLog(GuidString, date);
			AuditLogService.SaveLogDetail(detail);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void logAuditDetailErrorEJB(String message, String GuidString) {

		date = format.getCurrentStringDate();
		AuditDetail detail = new AuditDetail();
		detail.setAuditMasterGID(GuidString);
		detail.setCallType("EJBResponseError");
		detail.setCreatedOn(date);
		if (message != null && !message.isEmpty()) {
			detail.setMessage(message);
		}

		try {
			//ejbService.saveLogDetail(detail);
			AuditLogService.SaveLogDetail(detail);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void logAuditDetailQueryEJB(String methodName, String query, String GuidString) {

		date = format.getCurrentStringDate();
		AuditDetail detail = new AuditDetail();
		detail.setAuditMasterGID(GuidString);
		detail.setCallType(methodName);
		detail.setCreatedOn(date);
		detail.setMessage(query);

		try {
			//ejbService.saveLogDetail(detail);
			AuditLogService.SaveLogDetail(detail);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void logAuditDetailRequestEJB(String method, String GuidString) {

		date = format.getCurrentStringDate();
		AuditDetail detail = new AuditDetail();
		detail.setAuditMasterGID(GuidString);
		detail.setCallType("EJBRequest");
		detail.setCreatedOn(date);
		detail.setMessage(method);

		try {
			//ejbService.saveLogDetail(detail);
			AuditLogService.SaveLogDetail(detail);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void logAuditDetailResponseEJB(String method, String GuidString) {

		date = format.getCurrentStringDate();
		AuditDetail detail = new AuditDetail();
		detail.setAuditMasterGID(GuidString);
		detail.setCallType("EJBResponse");
		detail.setCreatedOn(date);
		detail.setMessage(method);

		try {
			//ejbService.saveLogDetail(detail);
			AuditLogService.SaveLogDetail(detail);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void logAuditHeader(String methodName, String appName, String methodType, String actionType,
			HttpHeaders masterHeader, String GuidString) {
		if (masterHeader.getRequestHeaders().containsKey("userAPP")) {
			user = masterHeader.getRequestHeaders().get("userAPP").get(0).toString();

		}

		date = format.getCurrentStringDate();
		ni.com.casapellas.gcpinventario.AuditMaster master = new ni.com.casapellas.gcpinventario.AuditMaster();
		master.setGID(GuidString);
		master.setCreatedOn(date);
		master.setActionType(actionType);
		master.setUserName(user);
		master.setApplicationName(appName);
		master.setMethodName(methodName);
		master.setMethodType(methodType);
		master.setRequestPath("");
		try {
			//ejbService.saveLogHeader(master);
			AuditLogService.CreateLog(master);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String parseSOAPMessage(HttpServletRequest request) {
		String operationArgs = "";
		Enumeration<String> snum = request.getParameterNames();
		while (snum.hasMoreElements()) {
			String param = (String) snum.nextElement();
			if (!param.equalsIgnoreCase("")) {
				operationArgs += "&" + param + ":" + request.getParameter(param) + "";
			}
		}

		return operationArgs;
	}

}
