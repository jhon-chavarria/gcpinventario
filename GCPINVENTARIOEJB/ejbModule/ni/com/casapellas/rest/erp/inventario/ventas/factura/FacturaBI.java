package ni.com.casapellas.rest.erp.inventario.ventas.factura;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import ni.com.casapellas.ejb.erp.util.DateTimeHelper;
import ni.com.casapellas.ejb.erp.util.PagedInfo;
import ni.com.casapellas.ejb.erp.util.PagedResult;
import ni.com.casapellas.erp.inventario.almacen.RecoleccionArticuloService;
import ni.com.casapellas.erp.inventario.ventas.factura.FacturaService;
import ni.com.casapellas.erp.util.AuditLogService;
import ni.com.casapellas.erp.util.AuditMastersBean;
import ni.com.casapellas.erp.util.CustomFormat;
import ni.com.casapellas.erp.util.CustomValidation;
import ni.com.casapellas.gcpinventario.ConsultaFacturaHistorico;
import ni.com.casapellas.gcpinventario.Factura;
import ni.com.casapellas.gcpinventario.FacturaBatch;
import ni.com.casapellas.gcpinventario.FacturaDetalle;
import ni.com.casapellas.gcpinventario.FacturaTaller;
import ni.com.casapellas.gcpinventario.Invd35;
import ni.com.casapellas.gcpinventario.RecoleccionArticulo;
import ni.com.casapellas.util.CollectionScheme;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
//@Singleton
@LocalBean
public class FacturaBI {
	@PersistenceContext(unitName = "GCPSIADEJPA", type = PersistenceContextType.TRANSACTION)
	protected EntityManager em;
	@Resource
	SessionContext sessionContext;
	@EJB
	private AuditMastersBean audit;
	CustomFormat format = new CustomFormat();

	UserTransaction userTransaction = null;

	/**
	 * 
	 */
	public FacturaBI() {
	}

	@PostConstruct
	public void PostConstruct_FacturaBI() {
		userTransaction = sessionContext.getUserTransaction();
		try {
			userTransaction.setTransactionTimeout(60);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PagedResult<ConsultaFacturaHistorico> ObtenerListaFacturas(String pCompania, String pSucursal,
			PagedInfo pageInfo) throws Exception {
		PagedResult<ConsultaFacturaHistorico> result = null;
		FacturaService service = null;
		try {
			audit.logAuditDetailRequestEJB("ObtenerListaFacturas",audit.getGuid());
			service = new FacturaService(em,audit.getGuid());
			
			result = service.GetInvoices(pCompania, pSucursal, pageInfo);
			audit.logAuditDetailResponseEJB("ObtenerListaFacturas",audit.getGuid());
		} catch (Exception e) {
			audit.logAuditDetailErrorEJB(e.getMessage(),audit.getGuid());
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	public ConsultaFacturaHistorico ObtenerFacturaByNumero(String pCompania, String pSucursal, String pFecha,
			Integer pNoDocumento) throws Exception {
		ConsultaFacturaHistorico result = null;
		FacturaService service = null;

		try {
			audit.logAuditDetailRequestEJB("ObtenerFacturaByNumero",audit.getGuid());
			service = new FacturaService(em,audit.getGuid());

			result = service.GetInvoiceByNumber(pCompania, pSucursal, pFecha, pNoDocumento);
			audit.logAuditDetailResponseEJB("ObtenerFacturaByNumero",audit.getGuid());
		} catch (Exception e) {
			audit.logAuditDetailErrorEJB(e.getMessage(),audit.getGuid());
			e.printStackTrace();
			throw e;
		}

		return result;
	}

	@Lock(LockType.WRITE)
	public String Facturar(Factura factura) throws Exception {
		List<Invd35> table = null;
		CustomValidation validarDatos = new CustomValidation(em,audit.getGuid());
		Query q = null;
		String strQuery = "";
		String strQuery2 = "";
		String strQuery3 = "";
		String strQueryV = "";
		String strQueryV1 = "";
		String strQueryV2 = "";
		String result = "success";

		try {
			userTransaction.begin();
			
			table = validarDatos.getInvd35Format(factura);

			strQuery = "INSERT INTO " + CollectionScheme.SchemeInventario + ".INVD35 ("
					+ "COMPAN, SUCURS, DEPART, BODEGA, TIPOMO, DOCUME,FECHAM, HISECUE, NPARTE,"
					+ " CANTID,TIPOCA,  HORAM, PANTAL, HECHOP, NPROGR, VENDED, CVCANAL, CVENDED, CLCLIE"
					+ ",CLNOMB,   DESCUE, IMPUES, PRECIO, PRECIOUF, CODMONEDA, TFACTU, TDESCU, "
					+ "TIGV, TFACTUF, TDESCUF, TIGVF,  FECHAA, NLIQUI,NFACTU, NBATCH, INDCT";

			strQuery2 += ") Values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16,?17,?18,?19,?20,?21,?22,?23,?24,?25,?26,?27,?28,?29,?30,?31,?32,?33,?34,?35,?36";
			strQuery3 += ")";

			for (Invd35 item : table) {

				strQueryV = strQuery;
				strQueryV1 = strQuery2;
				strQueryV2 = strQuery3;

				if (item.getTIPOFD().length() > 0) {
					strQueryV += ",TIPOFD";
					strQueryV1 += ",?";
				}

				if (item.getTIPOFA().length() > 0) {
					strQueryV += ",TIPOFA";
					strQueryV1 += ",?";
				}
				if (item.getISTAT2().length() > 0) {
					strQueryV += ",ISTAT2";
					strQueryV1 += ",?";
				}
				if (item.getISTAT4().length() > 0) {
					strQueryV += ",ISTAT4";
					strQueryV1 += ",?";
				}
				if (item.getVALORG() != null && item.getVALORG().floatValue() > 0) {
					strQueryV += ",VALORG";
					strQueryV1 += ",?";
				}
				if (item.getVALORU() != null && item.getVALORU().floatValue() > 0) {
					strQueryV += ",VALORU";
					strQueryV1 += ",?";
				}
				if (item.getTIPOMV().length() > 0) {
					strQueryV += ",TIPOMV";
					strQueryV1 += ",?";
				}
				if (item.getREFERE() != null && item.getREFERE().floatValue() > 0) {
					strQueryV += ",REFERE";
					strQueryV1 += ",?";
				}

				if (item.getNCAJA() != null && item.getNCAJA().length() > 0) {
					strQueryV += ",NCAJA";
					strQueryV1 += ",?";
				}

				if (item.getTIPOTR() != null && item.getTIPOTR().length() > 0) {
					strQueryV += ",TIPOTR";
					strQueryV1 += ",?";
				}
				
				if (item.getDEPARD() != null && item.getDEPARD().length() > 0) {
					strQueryV += ",DEPARD";
					strQueryV1 += ",?";
				}
				
				if (item.getHCODPROMO() != null && item.getHCODPROMO().length() > 0) {
					strQueryV += ",HCODPROMO";
					strQueryV1 += ",?";
				}
				
				if (item.getIUSUAR() != null && item.getIUSUAR().length() > 0) {
					strQueryV += ",IUSUAR";
					strQueryV1 += ",?";
				}
				
				q = em.createNativeQuery(strQueryV + strQueryV1 + strQueryV2);

				q.setParameter(1, item.getCOMPAN());
				q.setParameter(2, item.getSUCURS());
				q.setParameter(3, item.getDEPART().trim());
				q.setParameter(4, item.getBODEGA());
				q.setParameter(5, item.getTIPOMO());
				q.setParameter(6, item.getDOCUME());
				q.setParameter(7, item.getFECHAM());
				q.setParameter(8, item.getHISECUE());
				q.setParameter(9, item.getNPARTE());
				q.setParameter(10, item.getCANTID());
				q.setParameter(11, item.getTIPOCA());
				q.setParameter(12, item.getHORAM());
				q.setParameter(13, item.getPANTAL());
				q.setParameter(14, item.getHECHOP());
				q.setParameter(15, item.getNPROGR());
				q.setParameter(16, item.getVENDED());
				q.setParameter(17, item.getCVCANAL());
				q.setParameter(18, item.getCVENDED());
				q.setParameter(19, item.getCLCLIE());
				q.setParameter(20, item.getCLNOMB());
				q.setParameter(21, item.getDESCUE());
				q.setParameter(22, item.getIMPUES());
				q.setParameter(23, item.getPRECIO());
				q.setParameter(24, item.getPRECIOUF());
				q.setParameter(25, item.getCODMONEDA());
				q.setParameter(26, item.getTFACTU());
				q.setParameter(27, item.getTDESCU());
				q.setParameter(28, item.getTIGV());
				q.setParameter(29, item.getTFACTUF());
				q.setParameter(30, item.getTDESCUF());
				q.setParameter(31, item.getTIGVF());
				q.setParameter(32, item.getFECHAA());
				q.setParameter(33, item.getNLIQUI());
				q.setParameter(34, item.getNFACTU());
				q.setParameter(35, item.getNBATCH());
				q.setParameter(36, item.getINDCT());

				if (item.getTIPOFD().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getTIPOFD());
				}

				if (item.getTIPOFA().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getTIPOFA());
				}
				if (item.getISTAT2().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getISTAT2());
				}

				if (item.getISTAT4().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getISTAT4());
				}

				if (item.getVALORG() != null && item.getVALORG().floatValue() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getVALORG());
				}
				if (item.getVALORU() != null && item.getVALORU().floatValue() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getVALORU());
				}
				if (item.getTIPOMV().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getTIPOMV());
				}
				if (item.getREFERE() != null && item.getREFERE().floatValue() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getREFERE());
				}
				if (item.getNCAJA() != null && item.getNCAJA().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getNCAJA());
				}
				if (item.getTIPOTR() != null && item.getTIPOTR().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getTIPOTR());
				}

				if (item.getDEPARD() != null && item.getDEPARD().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getDEPARD());
				}
				if (item.getHCODPROMO() != null && item.getHCODPROMO().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getHCODPROMO());
				}
				
				if (item.getIUSUAR() != null && item.getIUSUAR().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getIUSUAR());
				}
				
				AuditLogService.SaveLogDetail("Facturar",strQueryV + strQueryV1 + strQueryV2,audit.getGuid());
				
				q.executeUpdate();
			}
			
			strQuery = "{CALL " + CollectionScheme.SchemeInventario + ".PR_PROCESAR_DOCUMENTO_INVENTARIO(?1,?2,?3,?4,?5)}";
			
			AuditLogService.SaveLogDetail("Facturar-PR_PROCESAR_DOCUMENTO_INVENTARIO",strQuery,audit.getGuid());
			// Llamar al procedimiento que recalcula las existencias
			em.createNativeQuery(strQuery)
				.setParameter(1, table.get(0).getCOMPAN())
				.setParameter(2, table.get(0).getSUCURS())
				.setParameter(3, table.get(0).getTIPOMO())
				.setParameter(4, table.get(0).getDOCUME())
				.setParameter(5, table.get(0).getFECHAM())
				.executeUpdate();
			
			strQuery = "{CALL " + CollectionScheme.SchemeInventario + ".PR_INSERTAR_DOCUMENTO_CAJA(?1,?2,?3,?4,?5,?6)}";
			
			AuditLogService.SaveLogDetail("Facturar-PR_INSERTAR_DOCUMENTO_CAJA",strQuery,audit.getGuid());
			// Llamar al procedimiento de caja
			if (factura.getTIPO_CONDICION_PAGO().toLowerCase().equals("contado")
					|| factura.getTIPO_CONDICION_PAGO().toLowerCase().equals("credito")
					|| factura.getTIPO_CONDICION_PAGO().toLowerCase().equals("anulacion")) {

				em.createNativeQuery(strQuery)
					.setParameter(1, table.get(0).getCOMPAN().trim())
					.setParameter(2, table.get(0).getSUCURS().trim())
					.setParameter(3, table.get(0).getDEPART().trim())
					.setParameter(4, table.get(0).getTIPOMO().trim())
					.setParameter(5, table.get(0).getDOCUME())
					.setParameter(6, table.get(0).getFECHAM())
					.executeUpdate();
			}
			
			// Insertar en la INVD76
			InsertInvd76(
					factura.getCODIGO_COMPANNIA(), 
					factura.getCODIGO_SUCURSAL(),
					factura.getTIPO_MOVIMIENTO(), 
					Integer.parseInt(factura.getNUMERO_DOCUMENTO()), 
					factura.getUSUARIO(), 
					factura.getProductos());
			
			userTransaction.commit();

		} catch (Exception e) {
			// STATUS_ACTIVE
			if (userTransaction.getStatus() == 0) {
				userTransaction.rollback();
			}			
			throw e;
		}
		
		return result;
	}

	@Lock(LockType.WRITE)
	public String FacturarTaller(FacturaTaller factura) throws Exception {
		List<Invd35> table = null;
		CustomValidation validarDatos = new CustomValidation(em, audit.getGuid());
		Query q = null;
		String strQuery = "";
		String strQuery2 = "";
		String strQuery3 = "";
		String strQueryV = "";
		String strQueryV1 = "";
		String strQueryV2 = "";
		String result = "success";

		try {
			userTransaction.begin();

			table = validarDatos.getInvd35FormatTaller(factura);

			strQuery = "INSERT INTO " + CollectionScheme.SchemeInventario + ".INVD35 ("
					+ "COMPAN, SUCURS, DEPART, BODEGA, TIPOMO, DOCUME,FECHAM, HISECUE, NPARTE,"
					+ "CANTID,TIPOCA,  HORAM, PANTAL, HECHOP, NPROGR, VENDED, CVCANAL, CVENDED, CLCLIE, "
					+ "CLNOMB, DESCUE, IMPUES, PRECIO, PRECIOUF, CODMONEDA, TFACTU, TDESCU, "
					+ "TIGV, TFACTUF, TDESCUF, TIGVF,  FECHAA, NLIQUI,NFACTU, HIID, INDCT";

			strQuery2 += ") Values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16,?17,?18,?19,?20,?21,?22,?23,?24,?25,?26,?27,?28,?29,?30,?31,?32,?33,?34,?35,?36";
			strQuery3 += ")";

			for (Invd35 item : table) {

				strQueryV = strQuery;
				strQueryV1 = strQuery2;
				strQueryV2 = strQuery3;

				if (item.getTIPOFD().length() > 0) {
					strQueryV += ",TIPOFD";
					strQueryV1 += ",?";
				}

				if (item.getTIPOFA().length() > 0) {
					strQueryV += ",TIPOFA";
					strQueryV1 += ",?";
				}
				if (item.getISTAT2().length() > 0) {
					strQueryV += ",ISTAT2";
					strQueryV1 += ",?";
				}
				if (item.getISTAT4().length() > 0) {
					strQueryV += ",ISTAT4";
					strQueryV1 += ",?";
				}
				if (item.getVALORG() != null && item.getVALORG().floatValue() > 0) {
					strQueryV += ",VALORG";
					strQueryV1 += ",?";
				}
				if (item.getVALORU() != null && item.getVALORU().floatValue() > 0) {
					strQueryV += ",VALORU";
					strQueryV1 += ",?";
				}
				if (item.getTIPOMV().length() > 0) {
					strQueryV += ",TIPOMV";
					strQueryV1 += ",?";
				}

				if (item.getREFERE() != null && item.getREFERE().floatValue() > 0) {
					strQueryV += ",REFERE";
					strQueryV1 += ",?";
				}

				if (item.getNCAJA().length() > 0) {
					strQueryV += ",NCAJA";
					strQueryV1 += ",?";
				}

				if (item.getTIPOTR().length() > 0) {
					strQueryV += ",TIPOTR";
					strQueryV1 += ",?";
				}
				if (item.getIUSUAR().length() > 0) {
					strQueryV += ",IUSUAR";
					strQueryV1 += ",?";
				}
				q = em.createNativeQuery(strQueryV + strQueryV1 + strQueryV2);

				q.setParameter(1, item.getCOMPAN());
				q.setParameter(2, item.getSUCURS());
				q.setParameter(3, item.getDEPART().trim());
				q.setParameter(4, item.getBODEGA());
				q.setParameter(5, item.getTIPOMO());
				q.setParameter(6, item.getDOCUME());
				q.setParameter(7, item.getFECHAM());
				q.setParameter(8, item.getHISECUE());
				q.setParameter(9, item.getNPARTE());
				q.setParameter(10, item.getCANTID());
				q.setParameter(11, item.getTIPOCA());
				q.setParameter(12, item.getHORAM());
				q.setParameter(13, item.getPANTAL());
				q.setParameter(14, item.getHECHOP());
				q.setParameter(15, item.getNPROGR());
				q.setParameter(16, item.getVENDED());
				q.setParameter(17, item.getCVCANAL());
				q.setParameter(18, item.getCVENDED());
				q.setParameter(19, item.getCLCLIE());
				q.setParameter(20, item.getCLNOMB());
				q.setParameter(21, item.getDESCUE());
				q.setParameter(22, item.getIMPUES());
				q.setParameter(23, item.getPRECIO());
				q.setParameter(24, item.getPRECIOUF());
				q.setParameter(25, item.getCODMONEDA());
				q.setParameter(26, item.getTFACTU());
				q.setParameter(27, item.getTDESCU());
				q.setParameter(28, item.getTIGV());
				q.setParameter(29, item.getTFACTUF());
				q.setParameter(30, item.getTDESCUF());
				q.setParameter(31, item.getTIGVF());
				q.setParameter(32, item.getFECHAA());
				q.setParameter(33, item.getNLIQUI());
				q.setParameter(34, item.getNFACTU());
				q.setParameter(35, item.getHIID());
				q.setParameter(36, item.getINDCT());

				if (item.getTIPOFD().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getTIPOFD());
				}

				if (item.getTIPOFA().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getTIPOFA());
				}
				if (item.getISTAT2().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getISTAT2());
				}

				if (item.getISTAT4().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getISTAT4());
				}

				if (item.getVALORG() != null && item.getVALORG().floatValue() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getVALORG());
				}
				if (item.getVALORU() != null && item.getVALORU().floatValue() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getVALORU());
				}
				if (item.getTIPOMV().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getTIPOMV());
				}
				if (item.getREFERE() != null && item.getREFERE().floatValue() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getREFERE());
				}
				if (item.getNCAJA().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getNCAJA());
				}
				if (item.getTIPOTR().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getTIPOTR());
				}
				if (item.getIUSUAR().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getIUSUAR());
				}
				/*
				if (item.getDEPARD().length() > 0) {
					int paramSize = q.getParameters().size() + 1;
					q.setParameter(paramSize, item.getDEPARD());
				}
				*/
				
				AuditLogService.SaveLogDetail("FacturarTaller", strQueryV + strQueryV1 + strQueryV2, audit.getGuid());
				
				q.executeUpdate();
			}
			
			strQuery = "{CALL " + CollectionScheme.SchemeInventario + ".PR_PROCESAR_DOCUMENTO_INVENTARIO(?1,?2,?3,?4,?5)}";
			AuditLogService.SaveLogDetail("FacturarTaller-PR_PROCESAR_DOCUMENTO_INVENTARIO", strQuery, audit.getGuid());
			
			// Llamar al procedimiento para descargue de inventario
			em.createNativeQuery(strQuery)
					.setParameter(1, table.get(0).getCOMPAN())
					.setParameter(2, table.get(0).getSUCURS())
					.setParameter(3, table.get(0).getTIPOMO())
					.setParameter(4, table.get(0).getDOCUME())
					.setParameter(5, table.get(0).getFECHAM())
					.executeUpdate();
			
			strQuery = "{CALL " + CollectionScheme.SchemeInventario + ".PR_INSERTAR_MATERIALES_ORDEN_TALLER(?1,?2,?3,?4,?5,?6)}";
			AuditLogService.SaveLogDetail("FacturarTaller-PR_INSERTAR_MATERIALES_ORDEN_TALLER", strQuery, audit.getGuid());
			
			// Llamar al procedimiento para insercion de materiales
			em.createNativeQuery(strQuery)
				.setParameter(1, table.get(0).getCOMPAN().trim())
				.setParameter(2, table.get(0).getSUCURS().trim())
				.setParameter(3, table.get(0).getDEPART().trim())
				.setParameter(4, table.get(0).getTIPOMO().trim())
				.setParameter(5, table.get(0).getDOCUME())
				.setParameter(6, table.get(0).getFECHAM())
				.executeUpdate();
			
			strQuery = "{CALL " + CollectionScheme.SchemeInventario + ".PR_INSERTAR_DOCUMENTO_CAJA(?1,?2,?3,?4,?5,?6)}";
			AuditLogService.SaveLogDetail("FacturarTaller-PR_INSERTAR_DOCUMENTO_CAJA", strQuery, audit.getGuid());
			
			// Inserta en caja
			em.createNativeQuery(strQuery)
				.setParameter(1, table.get(0).getCOMPAN().trim())
				.setParameter(2, table.get(0).getSUCURS().trim())
				.setParameter(3, table.get(0).getDEPART().trim())
				.setParameter(4, table.get(0).getTIPOMO().trim())
				.setParameter(5, table.get(0).getDOCUME())
				.setParameter(6, table.get(0).getFECHAM())
				.executeUpdate();
			
			// Llamar al procedimiento para poner en cola de impresion las requisas
			InsertInvd76(
					factura.getCODIGO_COMPANNIA(), 
					factura.getCODIGO_SUCURSAL(),
					factura.getTIPO_MOVIMIENTO(), 
					Integer.parseInt(factura.getNUMERO_DOCUMENTO()), 
					factura.getUSUARIO(), 
					factura.getProductos());

			userTransaction.commit();

		} catch (Exception e) {
			// STATUS_ACTIVE
			if (userTransaction.getStatus() == 0) {
				userTransaction.rollback();
			}			
			throw e;
		}

		return result;
	}

	public String updateBatch(FacturaBatch bill) throws Exception {
		Query q = null;
		String strQuery = "";
		try {
			userTransaction.begin();
			
			Date movementDate = DateTimeHelper.CastStringToDate(bill.getFechaMovimiento(), "yyyy-MM-dd HH:mm:ss");
			Date documentDate = DateTimeHelper.CastStringToDate(bill.getFechaDocumento(), "yyyy-MM-dd HH:mm:ss");
			
			int numericMovDate = DateTimeHelper.CastDateToNumber(movementDate, "yyyyMMdd");
			int numericMovTime = DateTimeHelper.CastTimeToNumber(movementDate);
			int numericDocDate = DateTimeHelper.CastDateToNumber(documentDate, "yyyyMMdd");
			
			strQuery = "UPDATE  " + CollectionScheme.SchemeInventario + ".INVD35  " + "SET";

			strQuery += " Nbatch =" + bill.getNumeroBatch() + "";
			strQuery += " ,USUAIN ='" + bill.getUsuario() + "'";
			strQuery += " ,HORAIN =" + numericMovTime + "";
			strQuery += " ,FECHIN =" + numericMovDate + "";
			strQuery += " ,STATIN = 'F'";
			strQuery += " WHERE " 
					+ " DOCUME = ?1 " 
					+ " AND COMPAN = ?2 " 
					+ " AND SUCURS = ?3" 
					+ " AND DEPART = ?4"
					+ " AND TIPOMO = ?5" 
					+ " AND FECHAM = ?6 ";

			AuditLogService.SaveLogDetail("updateBatch", strQuery, audit.getGuid());
			
			q = em.createNativeQuery(strQuery);

			q.setParameter(1, bill.getNumeroDocumento());
			q.setParameter(2, bill.getCodigoCompania());
			q.setParameter(3, bill.getCodigoSucursal());
			q.setParameter(4, bill.getCodigoDepartamento());
			q.setParameter(5, bill.getTipoDocumento());
			q.setParameter(6, numericDocDate);

			q.executeUpdate();

			userTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();

			userTransaction.rollback();

			throw new Exception("" + e.getMessage());
		}

		return "Success";
	}
	
	private void InsertInvd76(String pCompanyCode, String pBranchCode, String pMovementType, Integer pDocumentCode, String pUser, List<FacturaDetalle> pDetailItem) {
		try {
			RecoleccionArticuloService recArticuloService = new RecoleccionArticuloService(this.em, audit.getGuid());
			
			Date inputDate = DateTimeHelper.GetCurrentDate();
			Integer numericDate = DateTimeHelper.CastDateToNumber(inputDate, "yyyyMMdd");
			Integer numericTime = DateTimeHelper.CastTimeToNumber(inputDate);
			
			//Verificar las bodegas que vienen y obtener las distintas
			List<String> listaBodegas = pDetailItem.stream()
					.collect(Collectors.groupingBy(x -> x.getCODIGO_BODEGA(), Collectors.counting()))
					.entrySet().stream()
					.map(m -> m.getKey()).collect(Collectors.toList());
			
			for (Iterator<String> iterator = listaBodegas.iterator(); iterator.hasNext();) {
				String codigoBodega = (String) iterator.next();
				
				RecoleccionArticulo entity = new RecoleccionArticulo(
						pCompanyCode, 
						pBranchCode, 
						codigoBodega, 
						pMovementType, 
						new BigDecimal(pDocumentCode),
						new BigDecimal(numericDate), 
						new BigDecimal(numericTime), 
						"LSR", 
						"LSRWS", 
						pUser
						);
				
				recArticuloService.Insert(entity);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	@SuppressWarnings("unused")
	private Boolean ProcessInventory(String pCompany, String pBranch, String pTipoMov, BigDecimal pDocumentNumber, BigDecimal pDateMov) {
		Boolean isSuccess = false;
		try {
			userTransaction.begin();
			
			em.createNativeQuery("{call " + CollectionScheme.SchemeInventario + ".PR_PROCESAR_DOCUMENTO_INVENTARIO(?1,?2,?3,?4,?5)}")
					.setParameter(1, pCompany)
					.setParameter(2, pBranch)
					.setParameter(3, pTipoMov)
					.setParameter(4, pDocumentNumber)
					.setParameter(5, pDateMov)
					.executeUpdate();

			userTransaction.commit();
			
			isSuccess = true;
		} catch (Exception e) {
			try {
				if (userTransaction != null && userTransaction.getStatus() == 0) {
					userTransaction.rollback();
				}
				
				// Log Exception
				userTransaction.begin();
				
				em.createNativeQuery("DELETE FROM " + CollectionScheme.SchemeInventario + ".INVD35 WHERE COMPAN = ?1 AND SUCURS = ?2 AND TIPOMO = ?3 AND DOCUME = ?4 AND FECHAM = ?5")
					.setParameter(1, pCompany)
					.setParameter(2, pBranch)
					.setParameter(3, pTipoMov)
					.setParameter(4, pDocumentNumber)
					.setParameter(5, pDateMov)
					.executeUpdate();
				
				userTransaction.commit();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		try {
			logAuditDetailQueryEJB("Facturar","DELETE FROM " + CollectionScheme.SchemeInventario + ".INVD35 WHERE COMPAN = ?1 AND SUCURS = ?2 AND TIPOMO = ?3 AND DOCUME = ?4 AND FECHAM = ?5",audit.getGuid());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isSuccess;
	}

	
	//Log
	public  void logAuditDetailQueryEJB(String methodName,String query,String GuidString) {
		String date;
		
		date = format.getCurrentStringDate();
		AuditDetail detail = new AuditDetail();
		detail.setAuditMasterGID(GuidString);
		detail.setCallType(methodName);
		detail.setCreatedOn(date);	
		detail.setMessage(query);
		
		try {
		saveLogDetail(detail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String saveLogDetail(AuditDetail item) throws Exception {
		String strQuery;
		Query q = null;
		strQuery="INSERT INTO "+CollectionScheme.SchemeInventario+".AuditDetail ("
				+ "AuditMasterGID, CallType, Message, "				
				+ "CreatedOn) Values (?1,?2,?3,?4)";
		
		try {				
			
			//userTransaction.begin();
			q = em.createNativeQuery(strQuery);
			
			q.setParameter(1, item.getAuditMasterGID());
			q.setParameter(2, item.getCallType());
			q.setParameter(3, item.getMessage());
			q.setParameter(4, item.getCreatedOn());
	
			q.executeUpdate();
			//userTransaction.commit();
		}catch(Exception e) {
			
			throw e;
		}
		return "LogMasterCreated";
	}
	*/
}
