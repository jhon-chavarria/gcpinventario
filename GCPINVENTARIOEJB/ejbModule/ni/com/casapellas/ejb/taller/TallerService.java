package ni.com.casapellas.ejb.taller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ni.com.casapellas.ejb.erp.util.StringHelper;
import ni.com.casapellas.erp.util.AuditLogService;
import ni.com.casapellas.gcptaller.pojo.OrdenTrabajo;
import ni.com.casapellas.gcptaller.pojo.Taller;
import ni.com.casapellas.gcptaller.pojo.Tecnico;
import ni.com.casapellas.util.CollectionScheme;

public class TallerService {
	EntityManager connection = null;
	String Guid;

	/**
	 * 
	 */
	public TallerService(EntityManager em,String GuidMaster) {
		this.connection = em;
		this.Guid = GuidMaster;
	}
	
	@SuppressWarnings("unchecked")
	public List<Taller> getWorkShopList(String pCompania) {
		List<Taller> result = null;
		Query q = null;
		String strQuery = "";

		try {
			strQuery = "SELECT"
					+ "    T.TBCIA AS codigoCompania,"
					+ "    T.TBESPE AS codigoTaller,"
					+ "    T.TBDESC AS Descripcion,"
					+ "    T.TBCLAS AS codigoClasificacion,"
					+ "    S.CCNAME AS clasificacion,"
					+ "    T.TBNIV1 AS controlNivelUno,"
					+ "    T.TBNIV2 AS controlNivelDos,"
					+ "    T.TBNIV3 AS controlNivelTres,"
					+ "    T.TBNIV4 AS controlNivelCuatro "
					+ "FROM"
					+ "    " + CollectionScheme.SchemeTaller + ".SOTTAB T LEFT JOIN " + CollectionScheme.SchemeJdeErp + ".F0010 S"
					+ "        ON T.TBCLAS = S.CCCO "
					+ "WHERE"
					+ "    TBCODI='012' AND T.TBCIA = ?1";
			
			q = this.connection.createNativeQuery(strQuery, Taller.class);
			q.setParameter(1, pCompania);
			//
			AuditLogService.SaveLogDetail("getWorkShopList",strQuery,Guid);
			
			result = q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	public Taller getWorkShopByCode(String pCompania, String pTaller) {
		Taller result = null;
		Query q = null;
		String strQuery = "";
		
		try {
			strQuery = "SELECT"
					+ "    T.TBCIA AS codigoCompania,"
					+ "    T.TBESPE AS codigoTaller,"
					+ "    T.TBDESC AS Descripcion,"
					+ "    T.TBCLAS AS codigoClasificacion,"
					+ "    S.CCNAME AS clasificacion,"
					+ "    T.TBNIV1 AS controlNivelUno,"
					+ "    T.TBNIV2 AS controlNivelDos,"
					+ "    T.TBNIV3 AS controlNivelTres,"
					+ "    T.TBNIV4 AS controlNivelCuatro "
					+ "FROM"
					+ "    " + CollectionScheme.SchemeTaller + ".SOTTAB T LEFT JOIN " + CollectionScheme.SchemeJdeErp + ".F0010 S"
					+ "        ON T.TBCLAS = S.CCCO "
					+ "WHERE"
					+ "    TBCODI='012' AND T.TBCIA = ?1 AND T.TBESPE = ?2";
			
			q = this.connection.createNativeQuery(strQuery, Taller.class);
			q.setParameter(1, pCompania);
			q.setParameter(2, pTaller);
			
			AuditLogService.SaveLogDetail("getWorkShopByCode",strQuery,Guid);
			
			List<Taller> list = q.getResultList();
			
			if (list != null && list.size() > 0) {
				result = list.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Taller> getWorkShopListByBranch(String pCompania, String pSucursal) {
		List<Taller> result = null;
		Query q = null;
		String strQuery = "";
		
		try {
			strQuery = "SELECT"
					+ "    T.TBESPE AS codigoTaller,"
					+ "    T.TBDESC AS Descripcion,"
					+ "    T.TBCLAS AS codigoClasificacion,"
					+ "    S.CCNAME AS clasificacion,"
					+ "    T.TBNIV1 AS controlNivelUno,"
					+ "    T.TBNIV2 AS controlNivelDos,"
					+ "    T.TBNIV3 AS controlNivelTres,"
					+ "    T.TBNIV4 AS controlNivelCuatro "
					+ "FROM"
					+ "    " + CollectionScheme.SchemeTaller + ".SOTTAB T LEFT JOIN " + CollectionScheme.SchemeJdeErp + ".F0010 S"
					+ "        ON T.TBCLAS = S.CCCO "
					+ "WHERE"
					+ "    TBCODI='012' AND T.TBCIA = ?1 AND T.TBCLAS = ?2";
			
			q = this.connection.createNativeQuery(strQuery, Taller.class);
			q.setParameter(1, pCompania);
			q.setParameter(2, StringHelper.padLeft(pSucursal, 5, "0"));
			
			AuditLogService.SaveLogDetail("getWorkShopListByBranch",strQuery,Guid);
			
			result = q.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tecnico> getTechnicianListByBranch(String pTaller) {
		List<Tecnico> result = null;
		Query q = null;
		String strQuery = "";
		
		try {
			strQuery = "SELECT TECEMP AS codigoTecnico, TECNOM AS tecnicoNombre FROM " + CollectionScheme.SchemeTaller + ".SOTTEC WHERE CNSUCU = ?1 AND TECSDJE = '0'";
			
			q = this.connection.createNativeQuery(strQuery, Tecnico.class);
			q.setParameter(1, pTaller);
			
			AuditLogService.SaveLogDetail("getTechnicianListByBranch",strQuery,Guid);
			
			result = (List<Tecnico>)q.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return result;
	}
	
	public Tecnico getTechnicianByBranch(String pTaller, Integer pCodigoTecnico) {
		Tecnico technician = null;
		Query q = null;
		String strQuery = "";
		
		try {
			strQuery = "SELECT TECEMP AS codigoTecnico, TECNOM AS tecnicoNombre "
					+ "FROM " + CollectionScheme.SchemeTaller + ".SOTTEC "
					+ "WHERE CNSUCU = ?1 AND TECEMP = ?2";
			
			q = this.connection.createNativeQuery(strQuery, Tecnico.class);
			q.setParameter(1, pTaller);
			q.setParameter(2, pCodigoTecnico);
			
			AuditLogService.SaveLogDetail("getTechnicianByBranch",strQuery,Guid);
			
			@SuppressWarnings("unchecked")
			List<Tecnico> result = (List<Tecnico>)q.getResultList();
			
			if (result != null && result.size() > 0) {
				technician = result.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return technician;
	}
	
	@SuppressWarnings("unchecked")
	public List<OrdenTrabajo> getWorkShopOrderList(String pCompania, String pTaller) {
		List<OrdenTrabajo> result = null;
		Query q = null;
		String strQuery = "";
		
		try {
			strQuery = "SELECT" + 
					"    O.CNCOMP AS codigoCompania, " + 
					"    O.CNSUCU AS codigoTaller, " + 
					"    TT.TBDESC AS nombreTaller," + 
					"    O.OTNUME AS numeroOrden, " + 
					"    O.OTTIPO AS codigoTipoOrden, " + 
					"    TOD.TBDESC AS tipoOrdenDescripcion, " + 
					"    O.OTTMM  AS codigoModalidadMant, " + 
					"    MMT.TBDESC AS modalidadMantDescripcion, " + 
					"    O.OTTMA AS codigoTipoMantenimiento, " + 
					"    TMT.TBDESC AS tipoMantenimientoDescripcion, " + 
					"    O.TIPMANP AS tipoKit, " + 
					"    O.CODVARI AS codigoVariante, " + 
					"    O.CICKMS AS codigoKm, " + 
					"    O.CLCLIE AS codigoCliente, " + 
					"    F01.ABALPH AS nombreCliente," + 
					"    O.AUTCHA AS numeroChasis, " + 
					"    O.AUTMOT AS numeroMotor, " + 
					"    O.AUTTIP AS tipoMovil, " + 
					"    O.AUTMDE AS modeloDescriptivo, " + 
					"    O.AUTCOL AS codigoColorExterno, " + 
					"    TCL.TBDESC AS colorExternoDescripcion, " + 
					"    O.AUTMAR AS codigoMarca, " + 
					"    TMC.TBDESC AS marcaDescripcion, " + 
					"    O.AUTPLC AS noPlaca, " + 
					"    O.AUTANO AS anno, " + 
					"    O.OTFEC1 AS fechaIngreso, " + 
					"    O.OTASESOR AS codigoAsesor, " + 
					"    TEC.TECNOM AS nombreAsesor " + 
					"FROM " + 
					"    " + CollectionScheme.SchemeTaller + ".SOTORD O LEFT OUTER JOIN (SELECT TBESPE, TBDESC FROM " + CollectionScheme.SchemeTaller + ".SOTTAB WHERE TBCODI = '063') TOD" + 
					"        ON O.OTTIPO = TOD.TBESPE" + 
					"    LEFT OUTER JOIN (SELECT TBESPE, TBDESC FROM " + CollectionScheme.SchemeTaller + ".SOTTAB WHERE TBCODI = '061') MMT" + 
					"        ON MMT.TBESPE = O.OTTMM" + 
					"    LEFT OUTER JOIN (SELECT TBESPE, TBDESC FROM " + CollectionScheme.SchemeTaller + ".SOTTAB WHERE TBCODI = '064') TMT    " + 
					"        ON TMT.TBESPE = O.OTTMA" + 
					"    LEFT OUTER JOIN (SELECT TBESPE, TBDESC FROM " + CollectionScheme.SchemeTaller + ".SOTTAB WHERE TBCODI = '033') TCL" + 
					"        ON TCL.TBESPE = O.AUTCOL" + 
					"    LEFT OUTER JOIN (SELECT TBCIA, TBESPE, TBDESC FROM " + CollectionScheme.SchemeTaller + ".SOTTAB WHERE TBCODI = '034') TMC" + 
					"        ON TMC.TBCIA = O.CNCOMP AND TMC.TBESPE = O.AUTMAR" + 
					"    LEFT OUTER JOIN " + CollectionScheme.SchemeJdeErp + ".F0101 F01" + 
					"        ON F01.ABAN8 = O.CLCLIE" + 
					"    LEFT OUTER JOIN " + CollectionScheme.SchemeTaller + ".SOTTEC TEC" + 
					"        ON TEC.TECEMP = O.OTASESOR" + 
					"    LEFT OUTER JOIN (SELECT TBCIA, TBESPE, TBDESC FROM " + CollectionScheme.SchemeTaller + ".SOTTAB WHERE TBCODI = '012') TT" + 
					"        ON TT.TBCIA = O.CNCOMP AND TT.TBESPE = O.CNSUCU " + 
					"WHERE " + 
					"    O.CNCOMP = ?1" + 
					"    AND O.CNSUCU = ?2" + 
					"    AND O.OTFEC2 = '0001-01-01'" + 
					"    AND O.OTSTT1 = ''";
			
			q = this.connection.createNativeQuery(strQuery, OrdenTrabajo.class);
			q.setParameter(1, pCompania);
			q.setParameter(2, pTaller);
			
			AuditLogService.SaveLogDetail("getWorkShopOrderList",strQuery,Guid);
			
			result = q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return result;
	}
	
	public OrdenTrabajo getWorkShopOrder(String pCompania, String pTaller, Integer pOrden) {
		OrdenTrabajo result = null;
		Query q = null;
		String strQuery = "";
		
		try {
			strQuery = "SELECT" + 
					"    O.CNCOMP AS codigoCompania, " + 
					"    O.CNSUCU AS codigoTaller, " + 
					"    TT.TBDESC AS nombreTaller," + 
					"    O.OTNUME AS numeroOrden, " + 
					"    O.OTTIPO AS codigoTipoOrden, " + 
					"    TOD.TBDESC AS tipoOrdenDescripcion, " + 
					"    O.OTTMM  AS codigoModalidadMant, " + 
					"    MMT.TBDESC AS modalidadMantDescripcion, " + 
					"    O.OTTMA AS codigoTipoMantenimiento, " + 
					"    TMT.TBDESC AS tipoMantenimientoDescripcion, " + 
					"    O.TIPMANP AS tipoKit, " + 
					"    O.CODVARI AS codigoVariante, " + 
					"    O.CICKMS AS codigoKm, " + 
					"    O.CLCLIE AS codigoCliente, " + 
					"    F01.ABALPH AS nombreCliente," + 
					"    O.AUTCHA AS numeroChasis, " + 
					"    O.AUTMOT AS numeroMotor, " + 
					"    O.AUTTIP AS tipoMovil, " + 
					"    O.AUTMDE AS modeloDescriptivo, " + 
					"    O.AUTCOL AS codigoColorExterno, " + 
					"    TCL.TBDESC AS colorExternoDescripcion, " + 
					"    O.AUTMAR AS codigoMarca, " + 
					"    TMC.TBDESC AS marcaDescripcion, " + 
					"    O.AUTPLC AS noPlaca, " + 
					"    O.AUTANO AS anno, " + 
					"    O.OTFEC1 AS fechaIngreso, " + 
					"    O.OTASESOR AS codigoAsesor, " + 
					"    TEC.TECNOM AS nombreAsesor " + 
					"FROM " + 
					"    " + CollectionScheme.SchemeTaller + ".SOTORD O LEFT OUTER JOIN (SELECT TBESPE, TBDESC FROM " + CollectionScheme.SchemeTaller + ".SOTTAB WHERE TBCODI = '063') TOD" + 
					"        ON O.OTTIPO = TOD.TBESPE" + 
					"    LEFT OUTER JOIN (SELECT TBESPE, TBDESC FROM " + CollectionScheme.SchemeTaller + ".SOTTAB WHERE TBCODI = '061') MMT" + 
					"        ON MMT.TBESPE = O.OTTMM" + 
					"    LEFT OUTER JOIN (SELECT TBESPE, TBDESC FROM " + CollectionScheme.SchemeTaller + ".SOTTAB WHERE TBCODI = '064') TMT    " + 
					"        ON TMT.TBESPE = O.OTTMA" + 
					"    LEFT OUTER JOIN (SELECT TBESPE, TBDESC FROM " + CollectionScheme.SchemeTaller + ".SOTTAB WHERE TBCODI = '033') TCL" + 
					"        ON TCL.TBESPE = O.AUTCOL" + 
					"    LEFT OUTER JOIN (SELECT TBCIA, TBESPE, TBDESC FROM " + CollectionScheme.SchemeTaller + ".SOTTAB WHERE TBCODI = '034') TMC" + 
					"        ON TMC.TBCIA = O.CNCOMP AND TMC.TBESPE = O.AUTMAR" + 
					"    LEFT OUTER JOIN " + CollectionScheme.SchemeJdeErp + ".F0101 F01" + 
					"        ON F01.ABAN8 = O.CLCLIE" + 
					"    LEFT OUTER JOIN " + CollectionScheme.SchemeTaller + ".SOTTEC TEC" + 
					"        ON TEC.TECEMP = O.OTASESOR" + 
					"    LEFT OUTER JOIN (SELECT TBCIA, TBESPE, TBDESC FROM " + CollectionScheme.SchemeTaller + ".SOTTAB WHERE TBCODI = '012') TT" + 
					"        ON TT.TBCIA = O.CNCOMP AND TT.TBESPE = O.CNSUCU " + 
					"WHERE " + 
					"    O.CNCOMP = ?1" + 
					"    AND O.CNSUCU = ?2" +
					"    AND O.OTNUME = ?3" + 
					"    AND O.OTFEC2 = '0001-01-01'" + 
					"    AND O.OTSTT1 = ''";
			
			q = this.connection.createNativeQuery(strQuery, OrdenTrabajo.class);
			q.setParameter(1, pCompania);
			q.setParameter(2, pTaller);
			q.setParameter(3, pOrden);
			
			AuditLogService.SaveLogDetail("getWorkShopOrder",strQuery,Guid);
			
			@SuppressWarnings("unchecked")
			List<OrdenTrabajo> orderList = q.getResultList();
			
			if (orderList != null && orderList.size() > 0) {
				result = orderList.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return result;
	}
}
