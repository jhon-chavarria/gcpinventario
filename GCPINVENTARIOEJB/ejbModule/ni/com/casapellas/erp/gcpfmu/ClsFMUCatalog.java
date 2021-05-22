package ni.com.casapellas.erp.gcpfmu;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;


import ni.com.casapellas.gcpfmu.pojo.AuthorizationCode;
import ni.com.casapellas.gcpfmu.pojo.BillSequence;
import ni.com.casapellas.gcpfmu.pojo.Brand;
import ni.com.casapellas.gcpfmu.pojo.BrandDiscount;
import ni.com.casapellas.gcpfmu.pojo.CLientBrandDiscount;
import ni.com.casapellas.gcpfmu.pojo.CashBillReceiptRelation;
import ni.com.casapellas.gcpfmu.pojo.ClientCreditInfo;
import ni.com.casapellas.gcpfmu.pojo.ClientExchangeRatesCatalog;
import ni.com.casapellas.gcpfmu.pojo.DeliveryDeadlines;
import ni.com.casapellas.gcpfmu.pojo.ExchangeRate;
import ni.com.casapellas.gcpfmu.pojo.FMUUtil;
import ni.com.casapellas.gcpfmu.pojo.GeneralCatalog;
import ni.com.casapellas.gcpfmu.pojo.GlobalProductCatalog;
import ni.com.casapellas.gcpfmu.pojo.InitDay;
import ni.com.casapellas.gcpfmu.pojo.InitDayAction;
import ni.com.casapellas.gcpfmu.pojo.InvoiceCustomerExcept;
import ni.com.casapellas.gcpfmu.pojo.JDECatalog;
import ni.com.casapellas.gcpfmu.pojo.Leyend;
import ni.com.casapellas.gcpfmu.pojo.LeyendAttribute;
import ni.com.casapellas.gcpfmu.pojo.OrderReservationConfig;
import ni.com.casapellas.gcpfmu.pojo.PostObjectReturn;
import ni.com.casapellas.gcpfmu.pojo.Product;
import ni.com.casapellas.gcpfmu.pojo.ProductPrices;
import ni.com.casapellas.gcpfmu.pojo.PromotionalCombo;
import ni.com.casapellas.gcpfmu.pojo.ResponseApi;
import ni.com.casapellas.gcpfmu.pojo.RoutePosition;
import ni.com.casapellas.gcpfmu.pojo.Seller;
import ni.com.casapellas.geninfo.pojo.CustomerInfo;
import ni.com.casapellas.util.CollectionScheme;

/**
 * Este modulo encapsula la lista de catalogos provenientes del sistema FMU
 * Catalogos de usuarios
 * Roles y perfiles de usuarios
 * Prueba de branch 123
 * 
 * @author Jonathan Chavarria
 *
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN) 
@SuppressWarnings({"unchecked"})
public class ClsFMUCatalog {

	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	
	@Resource 
	private SessionContext sessionContext;  
	
	public static final int SET_SIZE_REQUIRED = 50;
	public static final int NUMBER_RANGE = 100000000;

	@Inject
	public ClsFMUCatalog() {
		// Nothing
	}
	
	/**
	 * InventoryType
	 * 
	 * @param em
	 * @param codtab
	 * @param inventoryTypeIds
	 * @return
	 * @throws Exception
	 */
	public List<GeneralCatalog> getInventoryTypeCatalog(String codtab)
			throws Exception {
		List<GeneralCatalog> generalCatalogs = new ArrayList<GeneralCatalog>();

		try {
			String sQuery = "SELECT TRIM(CODIDE) id, "
					+ "TRIM(DESCRI) name, "
					+ "TRIM(ORDEN) orden, "
					+ "TRIM(OTROS1) otros1, "
					+ "TRIM(P25) p25, "
					+ "TRIM(tdescri1) description "
						+ "FROM " + CollectionScheme.SchemeInventario + ".TABMUL " 
							+ "where CODTAB = ?  " 
							+ "AND ( P25 =' ')  "
							+ "AND CODIDE!='' "
							+ "AND p3!='I' "
								+ "ORDER BY CODIDE ASC ";

			generalCatalogs = em.createNativeQuery(sQuery, GeneralCatalog.class).setParameter(1, codtab)
					.getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return generalCatalogs;
	}

	/**
	 * Brands
	 * 
	 * @param em
	 * @param codtab
	 * @param brandsId
	 * @return
	 * @throws Exception
	 */
	public List<Brand> getBrands(String codtab, String brandId) throws Exception {
		List<Brand> brands = new ArrayList<Brand>();

		
		if (!brandId.equals("")) {
			brandId = " AND a.codide = '" + brandId + "'";
		}
		
		try {
			String sQuery = "SELECT TRIM(a.CODIDE) id, "
					+ "IFNULL((select  c.tasacambio from " + CollectionScheme.SchemeInventario +".tabmul b left outer join " + CollectionScheme.SchemeInventario + ".invd58 c on b.otros = c.codlistap where b.codtab='77'  and a.Codide = b.Codide) ,0) exchange, "
					+ "IFNULL((select  b.otros from " + CollectionScheme.SchemeInventario + ".tabmul b left outer join " + CollectionScheme.SchemeInventario + ".invd58 c on b.otros = c.codlistap where b.codtab='77'  and a.Codide = b.Codide),0) isPriceList, "
					+ "TRIM(a.DESCRI) name, TRIM(a.ORDEN) orden, TRIM(a.OTROS1) otros1, TRIM(a.P25) p25, "
					+ "TRIM(a.tdescri1) description FROM " + CollectionScheme.SchemeInventario + ".TABMUL a" + " " + "where a.CODTAB = ?  "
					+ "AND ( a.P25 =' ') AND a.p3!='I' " + " AND a.CODIDE!='' " + brandId + " ORDER BY a.CODIDE ASC";

			brands = em.createNativeQuery(sQuery, Brand.class).setParameter(1, codtab).getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return brands;
	}

	/**
	 * @author Jonathan Chavarria
	 * @return
	 * @throws Exception
	 */
	public List<GeneralCatalog> getRoutes(EntityManager em) throws Exception {
		List<GeneralCatalog> generalCatalogs = new ArrayList<GeneralCatalog>();

		try {
			String sQuery = "SELECT TRIM(CODIDE) id, "
					+ "TRIM(DESCRI) name, "
					+ "TRIM(ORDEN) orden, "
					+ "TRIM(OTROS1) otros1, "
					+ "TRIM(P25) p25 "
					+ "FROM " + CollectionScheme.SchemeInventario +".TABMUL " 
						+ "where CODTAB = '03'  AND ( P25 = ' ')  " + "AND orden='RU' "
						+ "AND CODIDE!=''";

			generalCatalogs = em.createNativeQuery(sQuery, GeneralCatalog.class).getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return generalCatalogs;
	}

	public List<GeneralCatalog> getMeasureList(EntityManager em, String codtab) throws Exception {
		List<GeneralCatalog> generalCatalogs = new ArrayList<GeneralCatalog>();

		try {
			String sQuery = "SELECT "
					+ "TRIM(CODIDE) id, "
					+ "TRIM(DESCRI) name, "
					+ "TRIM(ORDEN) orden, "
					+ "TRIM(OTROS1) otros1, "
					+ "TRIM(P25) p25 "
						+ "FROM " + CollectionScheme.SchemeInventario + ".TABMUL "
								+ "where CODTAB = ?  " 
								+ "AND CODIDE!=''";

			generalCatalogs = em.createNativeQuery(sQuery, GeneralCatalog.class).setParameter(1, codtab)
					.getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return generalCatalogs;
	}

	
	/**
	 * Global Product Catalog
	 * 
	 * @param em
	 * @param companyIds
	 * @param lineIds
	 * @return
	 * @throws Exception
	 */
	public List<GlobalProductCatalog> getGlobalProductCatalog(String companyIds, String lineIds, String branchId)
			throws Exception {
		List<GlobalProductCatalog> productCatalogs = new ArrayList<GlobalProductCatalog>();
		List<GlobalProductCatalog> productsFinal = new ArrayList<GlobalProductCatalog>();

		String[] itemsId = companyIds.split(",");
		lineIds = "(" + lineIds + ")";

		String filterQuery = "";
		String innorJoin = "";
		
		if (branchId.equals(FMUUtil.CPD_BRANCH_CODE)) {
			innorJoin = "";
			filterQuery = " AND " +
							"((IEXT01 - (ILOCA1 + ICAV01 + ICALB3)) + (IEXT08 - (ILOCA4 + ICAV08 +  SUSLB3))) > 0 ";
		} else {
			filterQuery = " AND SSUCURS= '" + branchId + "' AND  (SSEXL00 - SCANR00) > 0";
			
			innorJoin = " LEFT outer join " + CollectionScheme.SchemeInventario + ".INVD02 on "
					+  " (TRIM(INOPAR) = TRIM(SINOPAR) AND TRIM(SCOMPAN) = TRIM(ICOMPAN) AND TRIM(ILINEA) = TRIM(SDEPART)) ";
		}
		
		try {
			for (String item : itemsId) {
				String ClientCompany = "(" + item + ")";
				String tableName = item.equals("'01'") ?  CollectionScheme.SchemeInventario + "." + "INVD01" : CollectionScheme.SchemeInventario + "." + "INVV01";

				String sQueryPrices = "SELECT TRIM(ICOMPAN) companyId,  TRIM(INOPAR) productId, TRIM(IDESCR) productName, TRIM(IDESCI) productDescription, TRIM(ILINEA)  lineId, "
						+ "TRIM(ICODPROVEE) providerId, TRIM(ICOTROLLOT) controlLot, TRIM(IUMEDIDAC) measureType, "
						+ "IUMEDIDAA measureType2, TRIM(IGRUPO01) inventoryId ,TRIM(IGRUPO02) brandId,  (IIIVA / 100) iva, "
						+ "iprven price, "
						+ "TRIM(icateg) categoryId, "
						+ "TRIM(linea.otros1) coin "
						+ "from "
						+ tableName 
						+ " left outer join  " + CollectionScheme.SchemeInventario + ".TABMUL linea on ILINEA = linea.codide "
						+ innorJoin
						
						+ " where linea.codtab = '20' "
						+ "AND ICOMPAN in " + ClientCompany + " "
						+ "AND ILINEA in " + lineIds
						+ " AND imar4k = '1' " + filterQuery;

				productCatalogs = em.createNativeQuery(sQueryPrices, GlobalProductCatalog.class).getResultList();
				
				if (productCatalogs.size() > 0) {
					productsFinal.addAll(productCatalogs);
				}
			}
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return productsFinal;
	}

	/**
	 * Local Cellar
	 * 
	 * @param em
	 * @param companyId
	 * @param sucur
	 * @param cellar
	 * @param linea
	 * @return
	 * @throws Exception
	 */
	public List<Product> getProductsByCellar(String companyId, String sucur, String cellar,
			String linea) throws Exception {
		List<Product> products = new ArrayList<Product>();
		List<Product> productsFinal = new ArrayList<Product>();

		String[] itemsId = companyId.split(",");
		String ClientBranches = sucur.equals("") ? "('')" : "(" + sucur + ")";
		String ClientLineas = linea.equals("") ? "('')" : "(" + linea + ")";

		try {

			for (String item : itemsId) {
				String ClientCompany = "(" + item + ")";
				String tableName = item.equals("'01'") ?   CollectionScheme.SchemeInventario + "." 
									+ " INVD01" : CollectionScheme.SchemeInventario + "." + "INVV01";

				String sQuery = "SELECT  bodega.BCOMPAN companyId, "
						+ "TRIM(linea.otros1) coin,"
						+ "TRIM(CP.ILINEA) LineaId, "
						+ "TRIM(bodega.BINOPAR) productId, "
						+ "TRIM(IFNULL(CP.IDESCR, '')) productName,  "
						+ "TRIM(IFNULL(CP.IDESCI, '')) productDescription, "
						+ "bodega.BSUCURS branchId, "
						+ "TRIM(sucursal.descri) branchName, "
						+ "bodega.BDEPART department, "
						+ "TRIM(bodega.BBODEGA) cellarId, "
						+ "TRIM(ruta.descri) cellarName, "
						+ "(bodega.BEXISTEE -  (bodega.BCANRESER + bodega.BCANINVES)) as totalAvailable, "
						+ "TRIM(bodega.bsubl00) cellarLocation, "
						+ "CP.iprven price, "
						+ "CP.IIIVA IVA, "
						+ "CP.iiISC ISC, "
						+ "TRIM(CP.IGRUPO01) inventoryId, "
						+ "TRIM(CP.IUMEDIDAC) measureType, "
						+ "TRIM(CP.IUMEDIDAA) measureType2, "
						+ "TRIM(CP.IGRUPO02) brandId, "
						
						+ "(SELECT  IFNULL(TRIM(codide), '') FROM  " + CollectionScheme.SchemeInventario + ".TABMUL excludeCost WHERE CODTAB ='8B' and excludeCost.codide = CP.IGRUPO02) excludeCostGroup, " 

						+ "(SELECT  IFNULL(TRIM(JDDEPART), '') FROM  " + CollectionScheme.SchemeInventario + ".invd00 WHERE CODTAB ='001' and nivel=4 and compan=bodega.BCOMPAN  and sucurs=bodega.BSUCURS and depart=bodega.BDEPART) jdeLineId, " 
						+ "(SELECT  IFNULL(TRIM(JDSUCURS), '') FROM  " + CollectionScheme.SchemeInventario + ".invd00 WHERE CODTAB ='001' and nivel=4 and compan=bodega.BCOMPAN  and sucurs=bodega.BSUCURS and depart=bodega.BDEPART) jdeBranchId, " 
						+ "(SELECT  IFNULL(TRIM(JDCOMPAN), '') FROM  " + CollectionScheme.SchemeInventario + ".invd00 WHERE CODTAB ='001' and nivel=4 and compan=bodega.BCOMPAN  and sucurs=bodega.BSUCURS and depart=bodega.BDEPART) jdeCompanyId, "
						
						+ " (select IFNULL(TRIM(DRDl01), '') from " + CollectionScheme.SchemeJDECOM + ".f0005 where drsy='00'  and drrt='01' and TRIM(drky) = "
						+ " (SELECT  IFNULL(TRIM(JDCOMPAN), '') FROM  " + CollectionScheme.SchemeInventario + ".invd00 WHERE CODTAB ='001' and nivel=4 and compan=bodega.BCOMPAN  and sucurs=bodega.BSUCURS and depart=bodega.BDEPART)) "
									+ "jdCompanyName, " 				
							
						+ " (SELECT  IFNULL(TRIM(mcdl01), '') FROM  " + CollectionScheme.SchemeJDE + ".f0006  where TRIM(mcmcu) like "
							+ " (SELECT  IFNULL(TRIM(JDDEPART), '') FROM  " + CollectionScheme.SchemeInventario + ".invd00 WHERE CODTAB ='001' and nivel=4 and compan=bodega.BCOMPAN  and sucurs=bodega.BSUCURS and depart=bodega.BDEPART)"
									+ " and TRIM(mcrp01) = (SELECT  IFNULL(TRIM(JDCOMPAN), '') FROM  " + CollectionScheme.SchemeInventario + ".invd00 WHERE CODTAB ='001' and nivel=4 and compan=bodega.BCOMPAN  and sucurs=bodega.BSUCURS and depart=bodega.BDEPART)) jdLineName " 

					 
						+ " FROM " + CollectionScheme.SchemeInventario + ".INVD03 bodega  "
						+ "LEFT OUTER JOIN " + tableName + " CP on bodega.BINOPAR = CP.INOPAR  "
						+ "left outer join  " + CollectionScheme.SchemeInventario  + ".TABMUL sucursal on bodega.BSUCURS = sucursal.codide "
						+ "left outer join  " + CollectionScheme.SchemeInventario + ".TABMUL ruta on bodega.BBODEGA = ruta.codide "
						+ "left outer join  " + CollectionScheme.SchemeInventario + ".TABMUL linea on CP.ILINEA = linea.codide "

						+ "WHERE sucursal.codtab = '02' AND linea.codtab = '20' "
						+ "  AND ruta.codtab = '03'  AND ruta.orden = 'RU' "

						// Filter
						+ "AND bodega.BCOMPAN in " + ClientCompany + "   AND  bodega.BSUCURS in " + ClientBranches
						+ "  AND bodega.BBODEGA = '" + cellar + "' AND CP.ILINEA in " + ClientLineas + "";

				products = em.createNativeQuery(sQuery, Product.class).getResultList();
				

				if (products.size() > 0) {
					productsFinal.addAll(products);
				}
			}
		}
		

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return productsFinal;
	}

	/**
	 * GET BILL SEQUENCES
	 * 
	 * @param em
	 * @param companyIds
	 * @param branchesId
	 * @param cellarId
	 * @return
	 * @throws Exception
	 */
	public List<BillSequence> getBillSequence(String companyIds, String branchesId, String cellarId)
			throws Exception {
		List<BillSequence> billSequences = new ArrayList<BillSequence>();

		companyIds = companyIds.equals("") ? "('')" : "(" + companyIds + ")";
		branchesId = branchesId.equals("") ? "('')" : "(" + branchesId + ")";

		try {
			String sQuery = "Select TRIM(compa) companyId, "
					+ "TRIM(Sucur) brandId, "
					+ "TRIM(Bodeg) cellarId,  "
					+ "Numcon sequenceNumber, "
					+ "tipom movementType  "
					+ "From " + CollectionScheme.SchemeInventario + ".invcon "
							+ "where bodeg = ? "
							+ "and compa in " + companyIds + " "
							+ "and Sucur in " + branchesId
							+ "  and tipom in ('21','PR','P1')";
			
			System.out.println(sQuery);

			billSequences = em.createNativeQuery(sQuery, BillSequence.class).setParameter(1, cellarId).getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return billSequences;
	}

	/**
	 * Promotional Combo
	 * 
	 * @param em
	 * @param companyIds
	 * @return
	 * @throws Exception
	 */
	public List<PromotionalCombo> getPromotionalCombo(String companyIds) throws Exception {
		List<PromotionalCombo> promotionalCombos = new ArrayList<PromotionalCombo>();

		companyIds = "(" + companyIds + ")";

		try {
			String sQuery = "Select a.codigocompania companyId, "
					+ "a.lineacombo lineId, "
					+ "TRIM(a.codigocombo) comboId,  "
					+ "TRIM(b.codigoparte) productId, "
					+ "b.cantidadparte quantity, "
					+ "b.descuento discount, "
					+ "a.fechainicio initialDate, "
					+ "a.Fechavencimiento endDate, "
					+ "TRIM(a.nombrecombo) comboName,  "
					+ "a.statuscombo comboState "
					+ "from " + CollectionScheme.SchemeInventario + ".Inv_Combos_Promocionales_Cabecera a "
					+ "left outer join " + CollectionScheme.SchemeInventario +  ".Inv_Combos_Promocionales_Detalle b on a.codigocombo = b.codigocombo "
							+ "WHERE a.statuscombo = 'A' AND a.fechainicio <= ? AND a.Fechavencimiento >= ? AND a.codigocompania in "
					+ companyIds;

			promotionalCombos = em.createNativeQuery(sQuery, PromotionalCombo.class)
					.setParameter(1, FMUUtil.getIntegerDate()).setParameter(2, FMUUtil.getIntegerDate())
					.getResultList();
		}
	
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return promotionalCombos;
	}

	/**
	 * AQUI QUEDO
	 */
	/**
	 * 
	 * Client Exchange
	 * 
	 * @param em
	 * @param codtab
	 * @return
	 * @throws Exception
	 */
	public List<ClientExchangeRatesCatalog> getTypePrices(String codtab, String codeId) throws Exception {
		List<ClientExchangeRatesCatalog> typePrices = new ArrayList<ClientExchangeRatesCatalog>();
		String sQuery;
		
		if (!codeId.equals("")) {
			codeId = " AND a.codide = '" + codeId + "'";
		} else {
			codeId = " AND a.CODIDE!=''";
		}

		try {
			sQuery = "SELECT "
					+ "TRIM(a.CODIDE) id, "
					+ "IFNULL(b.tasacambio,0) exchange, "
					+ "IFNULL(b.fechainici, 0) initDay, "
					+ "IFNULL(b.fechafinal, 0) endDay, "
					+ "TRIM(a.DESCRI) name, "
					+ "TRIM(a.ORDEN) orden, "
					+ "TRIM(a.OTROS1) otros1, "
					+ "TRIM(a.P25) p25 "
					
					+ " FROM " + CollectionScheme.SchemeInventario + ".TABMUL a left outer join " + CollectionScheme.SchemeInventario  + ".invd58 b on a.CODIDE = b.codlistap  "
					+ "where a.CODTAB = ?  " 
					+ "AND ( P25 =' ')  " + " " + codeId + " ORDER BY a.CODIDE ASC";

			typePrices = em.createNativeQuery(sQuery, ClientExchangeRatesCatalog.class).setParameter(1, codtab)
					.getResultList();
			
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return typePrices;
	}
	
	/**
	 * Sellers data
	 * 
	 * @param em
	 * @return
	 * @throws Exception
	 */
	public List<Seller> getSellers(String sellerId) throws Exception {
		List<Seller> sellers = new ArrayList<Seller>();

		try {
			String sQuery = "SELECT TRIM(DESCRI) name, TRIM(ORDEN) orden, TRIM(codide) sellerId, TRIM(otros) sellerNumber "
					+ "FROM " + CollectionScheme.SchemeInventario + " .TABMUL " + "where CODTAB = '05' " + "AND ( P25 =' ')  "
					+ " AND otros = ? ORDER by orden";
			sellers = em.createNativeQuery(sQuery, Seller.class).setParameter(1, sellerId).getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return sellers;
	}

	/**
	 * Client Credit INFO
	 * 
	 * @param em
	 * @param clientsId
	 * @param companIds 
	 * @return
	 * @throws Exception
	 */
	// Obtienen la lista de documentos de credito a cobtrar
	public List<ClientCreditInfo> getClientCreditAvailableInfo(String clientsId, String companyIds) throws Exception {
		List<ClientCreditInfo> clientCreditInfos = new ArrayList<ClientCreditInfo>();

		String codes = "(" + clientsId + ")";
		companyIds = "(" + companyIds + ")";
		
		try {
			String sQueryPrices = "Select  rpAn8 clientId, "
					+ "CAST(TRIM(rpkco) AS VARCHAR(250) CCSID 37)  branchId,"
					+ "CAST(TRIM(rpMCU) AS VARCHAR(250) CCSID 37) lineId, "
					+ "CAST(TRIM(rpdct) AS VARCHAR(250) CCSID 37)  documentType,"
					+ "rpDoc billId, CAST(CAST( ((CAST( (rpDivj - MOD(rpDivj, 1000)) / 1000 AS INT) + 1900) * 1000) + MOD(rpDivj, 1000) AS CHAR(7)) AS DATE)  date,  "
					+ "CAST(CAST( ((CAST( (rpddj - MOD(rpddj, 1000)) / 1000 AS INT) + 1900) * 1000) + MOD(rpddj, 1000) AS CHAR(7)) AS DATE) paymentDay, "
					+ "rpag importeBrutoCR, "
					+ "rpaap corBalance, "
					+ "IFNULL(TRIM(rpaid), '') accountRegistered, "
					+ "RPATXA corImporteNotiva, "
					+ "RPSTAM corIva, "
					+ "rpAcr importeBrutoDR,"
					+ "rpFap drBalance, "
					+ "RPCTXA drImporteNotiva, "
					+ "RPCTXA drImporteNotiva, "
					+ "RPCRR exchange, "
					+ "RPDDJ payDate, "
					+ "RPGLC clientType, "
					+ "RPCTAM drIva, "
					+ "TRIM(RPALPH) clientName, "
					+ "CAST(TRIM(rpcrcd) AS VARCHAR(250) CCSID 37) coin, "
					+ "CAST(TRIM(rpSFx) AS VARCHAR(250) CCSID 37)  fee, "
					+ "CAST(TRIM(MCDL01) AS VARCHAR(250) CCSID 37) jdLineName, "
					+ "CAST(TRIM(MCRP01) AS VARCHAR(250) CCSID 37)  jdCompanyId, "
					+ "CAST(TRIM(DRDL01) AS VARCHAR(250) CCSID 37)  jdCompanyName "
					+ "from " + CollectionScheme.SchemeJDE + ".F03B11 left outer join " 
					+ CollectionScheme.SchemeJDE + ".f0006 on trim ( mcmcu ) = trim (RPMCU) "
					+ " left outer join " + CollectionScheme.SchemeJDECOM + ".f0005 on TRIM(drky) = TRIM(MCRP01) "
					+ " where rpan8 in "
					+ codes +  "  AND drsy='00'  and drrt='01' AND (rpaap > 0 or  rpfap>0) ";
			
			clientCreditInfos = em.createNativeQuery(sQueryPrices, ClientCreditInfo.class).getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return clientCreditInfos;
	}

	/**
	 * Delivery Deadlines
	 * 
	 * @param em
	 * @return
	 * @throws Exceptionno
	 */
	public List<DeliveryDeadlines> getDeliveryDeadlines() throws Exception {
		List<DeliveryDeadlines> deliveryDeadlines = new ArrayList<DeliveryDeadlines>();

		try {
			String sQueryPrices = "Select  CAST(TRIM(pnptc) AS VARCHAR(250) CCSID 37) codeId, "
					+ "TRIM(pnptd) name, pnnsp feeNumber, pnndtp daysLimit from " + CollectionScheme.SchemeJDE + ".F0014";
			deliveryDeadlines = em.createNativeQuery(sQueryPrices, DeliveryDeadlines.class).getResultList();

		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return deliveryDeadlines;
	}

	/**
	 * Exchange Value
	 * 
	 * @param em
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public List<ExchangeRate> getExchangeRate(String date) throws Exception {
		List<ExchangeRate> exchangeRates = new ArrayList<ExchangeRate>();

			
		try {

			String sQueryPrices = "SELECT cxcrrd currentCRExchange, "
					+ "( select tcambiom from " + CollectionScheme.SchemeCAJA + ".TPARARELA ) "
					+ "parallelRate from " + CollectionScheme.SchemeJDE + ".f0015 "
					+ "where cxcrcd='COR'  and cxcrdc='USD' and cxeft = ?";
						
			exchangeRates = em.createNativeQuery(sQueryPrices, ExchangeRate.class).setParameter(1, date)
					.getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return exchangeRates;

	}

	/**
	 * Client data for Cellar
	 * 
	 * @param em
	 * @param linesId
	 * @param zoneId
	 * @return
	 * @throws Exception
	 */
	public List<CustomerInfo> getCustomerByCodeList(String linesId, String zoneId, String notInClientIds) throws Exception {
		List<CustomerInfo> lstCustomer = new ArrayList<CustomerInfo>();

		try {
			linesId = "(" + linesId + ")";
			zoneId = "('" + zoneId + "')";
			
			String queryZoneField = " ";
			
			if (!notInClientIds.equals("")) {
				notInClientIds = "(" + notInClientIds + ")";
			} else {
				queryZoneField = "IFNULL(z1zona, 0) zoneId, ";
			}

			String sQuery = "";
			String sWhere = "Where ";
			
			sWhere += notInClientIds.equals("") ? "z1zona=" + zoneId : "z1depart in " +  linesId  +  " AND aban8 not in " + notInClientIds + " AND z1zona!=''";
			
			sQuery = "SELECT \n"
		            + "\n"
		            + "ABAN8 CodCliente, \n"
		            + "IFNULL(CASE WHEN DVFLAG = -1 THEN 0 ELSE DVIDLN END, 0) CodContacto, \n"
		            + "CAST(TRIM(AbalKY) AS VARCHAR(20) CCSID 37) Identificacion1, \n"
		        	+ "TRIM(ctipoc) segmentId, "
					+ "TRIM(z1diavisi) visitDayCode, "
					+ "TRIM(IFNULL(z1secvisi, 0)) sequence, "
					+ "TRIM(ctippr) priceTypeId, " 
					+ "IFNULL(aIAcl,0) limitCredit, \n"
					+ "direccion.LATITUD, "
					+ "direccion.LONGITUD, " 
					+ "z1depart departId, " 
					+ "IFNULL((select AIHDAR from " + CollectionScheme.SchemeJDE + ".F03012  where AIAN8 = ABAN8), 'N') clientStatus,  "
					
					+ "z1compan companyId, " 
					 + "CAST(TRIM(aitsta) AS VARCHAR(250) CCSID 37) creditCode, "
					+ "CAST(TRIM(abcm) AS VARCHAR(250) CCSID 37) creditCodeCondition, "
					+ "CAST(TRIM(aItrar) AS VARCHAR(250) CCSID 37)  termCode, "
		            + "CAST(TRIM(Abtax) AS VARCHAR(20) CCSID 37) Identificacion2, \n"
					+ queryZoneField
		            + "CAST(TRIM(Abalph) AS VARCHAR(90) CCSID 37) NombreCliente, \n"
		            + "CAST(TRIM(Abac19) AS VARCHAR(20) CCSID 37) CodSegmentoCliente, \n"
		            + "CAST(TRIM(Abac07) AS VARCHAR(20) CCSID 37) CodCategoria7, \n"
		            + "CAST(TRIM(Abac08) AS VARCHAR(20) CCSID 37) CodCategoria8,\n"
		            + "CASE WHEN DVFLAG = -1 THEN '1' ELSE '' END ESDIRPRINCIPAL,\n"
		            + "Cast(DVADDX as varchar(150) ccsid 37)  DIRECCION,\n"
		            + "Cast(DVATYPE as varchar(10) ccsid 37) CodTipoDireccion,\n"
		            + "(CASE WHEN ABTAXC = '1' THEN 'Natural' ELSE 'Juridico' END) AS TipoCliente, \n"
		            + "CAST(TRIM(WWTYC) AS VARCHAR(20) ccsid 37) TipificacionContacto, \n"
		            + "IFNULL(CASE WHEN WWALPH <> '' THEN CAST(TRIM(WWALPH) AS VARCHAR(20) CCSID 37) ELSE CAST(TRIM(WWMLNM) AS VARCHAR(20) CCSID 37) END, '') Contacto,\n"
		            + "Cast(Trim(DVCTR) as varchar(50) ccsid 37) Pais,  \n"
		            + "Cast(Trim(DVADDS) as varchar(50) ccsid 37) Departamento, \n"
		            + "Cast(Trim(DVCOUN) as varchar(50) ccsid 37) Municipio, \n"
		            + "Cast(Trim(DVTY1) as varchar(50) ccsid 37) Ciudad,\n"
		            + "\n"
		            + "CAST(TRIM(eaeclass) AS VARCHAR(20) CCSID 37) CategoriaEmail, \n"
		            + "'mailto:' || CAST(TRIM(eaemal) AS VARCHAR(80) CCSID 37) Email,\n"
		            + "\n"
		            + "IFNULL(CAST(TRIM(wpphtp) AS VARCHAR(20) CCSID 37),'') CategoriaTelefono, \n"
		            + "IFNULL(CAST(TRIM(wpar1) AS VARCHAR(20) CCSID 37),'') CodigoAreaPais, \n"
		            + "IFNULL(CAST(TRIM(wpph1) AS VARCHAR(20) CCSID 37),'') Telefono,\n"
		            + "\n"
		            + "Cast(Trim(a.Drdl01) as Varchar(80) ccsid 37) DescripcionPais,  \n"
		            + "Cast(Trim(b.Drdl01) as Varchar(80) ccsid 37) DescripcionDepart, \n"
		            + "Cast(Trim(c.Drdl01) as Varchar(80) ccsid 37) DescripcionCategTel, \n"
		            + "Cast(Trim(d.Drdl01) as Varchar(80) ccsid 37) DescripcionTipoDireccion, \n"
		            + "Cast(Trim(e.Drdl01) as Varchar(80) ccsid 37) DescripcionSegmento, \n"
		            + "Cast(Trim(f.Drdl01) as Varchar(80) ccsid 37) DescripcionCategoria07, \n"
		            + "Cast(Trim(g.Drdl01) as Varchar(80) ccsid 37) DescripcionCategoria08, " 
		            + "Cast(Trim(Abac09) as varchar(20) ccsid 37) CodCategoria9, "  
		            + "Cast(Trim(Abac10) as varchar(20) ccsid 37) CodCategoria10, " 
		            + "Cast(Trim(Abac01) as varchar(20) ccsid 37) CodCategoria1, " 
		            + "Cast(Trim(Abac02) as varchar(20) ccsid 37) CodCategoria2, " 
		            + "Cast(Trim(Abac03) as varchar(20) ccsid 37) CodCategoria3, " 
		            + "Cast(Trim(Abac04) as varchar(20) ccsid 37) CodCategoria4, " 
		            + "Cast(Trim(Abac05) as varchar(20) ccsid 37) CodCategoria5, " 
		            + "Cast(Trim(Abac06) as varchar(20) ccsid 37) CodCategoria6," 
		            + "Cast(Trim(abat1) as Varchar(20) ccsid 37) TipoCliente1, " 
		            + "Cast(Trim(abat2) as Varchar(20) ccsid 37) TipoCliente2, " 
		            + "Cast(Trim(abat3) as Varchar(20) ccsid 37) TipoCliente3, " 
		            + "Cast(Trim(abat4) as Varchar(20) ccsid 37) TipoCliente4, " 
		            + "Cast(Trim(abat5) as Varchar(20) ccsid 37) TipoCliente5 \n"
		            + "  \n"
		            + "FROM "+CollectionScheme.SchemeJdeErp+".F0101 TF0101\n"
		            + "LEFT OUTER JOIN "+CollectionScheme.getScheme() +".VF01116X VVF01116X ON (VVF01116X.DVAN8 = TF0101.ABAN8) \n"
		            + "LEFT OUTER JOIN "+CollectionScheme.SchemeJdeErp+".F0111 TF0111 ON (TF0111.WWAN8 = TF0101.ABAN8  AND TF0111.WWIDLN = VVF01116X.DVIDLN)\n"
		            + "LEFT OUTER JOIN "+CollectionScheme.SchemeJdeErp+".F01151 TF01151 ON (TF01151.EAAN8 = TF0101.ABAN8 AND TF01151.EAIDLN = VVF01116X.DVIDLN )\n"
		            + "LEFT OUTER JOIN "+CollectionScheme.SchemeJdeErp+".F0115 TF0115 ON (TF0115.WPAN8 = TF0101.ABAN8 AND TF0115.WPIDLN = VVF01116X.DVIDLN ) \n"
		            + "\n"
					+ "left outer join " + CollectionScheme.SchemeJDE + ".F03012  on aIAn8 = aban8 \n"
					+ "left outer join  " + CollectionScheme.SchemeInventario + ".invd43 zc on cclien = aban8 "
						+ "left outer join  " + CollectionScheme.SchemeInventario + ".invd431 lz on TRIM(z1cclien) = TRIM(zc.cclien) AND "
							+ " TRIM(zc.ccompan) = TRIM(z1compan) AND TRIM(zc.cdepart) = TRIM(lz.z1depart) \n"
		            + "left outer join "+CollectionScheme.SchemeJdeCfg+".F0005 a on a.drsy = '00'  and a.drrt = 'CN' and trim(a.DrKy) = trim(DVCTR) \n"
		            + "left outer join "+CollectionScheme.SchemeJdeCfg+".F0005 b on b.drsy = '00'  and b.drrt = 'S' and trim(b.DrKy) = trim(DVADDS) \n"
		            + "left outer join "+CollectionScheme.SchemeJdeCfg+".F0005 c on c.drsy = '01'  and c.drrt = 'PH' and trim(c.DrKy) = trim(wpphtp) \n"
		            + "left outer join "+CollectionScheme.SchemeJdeCfg+".F0005 d on d.drsy = '01'  and d.drrt = 'AT' and trim(d.DrKy) = trim(DVaTYPE) \n"
		            + "left outer join "+CollectionScheme.SchemeJdeCfg+".F0005 e on e.drsy = '01'  and e.drrt = '19' and trim(e.DrKy) = trim(Abac19) \n"
		            + "left outer join  " + CollectionScheme.SchemeMAG + ".DIRECCIONCOORDENADAS direccion on (codcliente = aban8 and "
					+ "trim(direccion.tipodireccion) = trim(DVATYPE)) \n"
		            
		            + "left outer join "+CollectionScheme.SchemeJdeCfg+".F0005 f on f.drsy = '01'  and f.drrt = '07' and trim(f.DrKy) = trim(Abac07) \n"
		            + "left outer join "+CollectionScheme.SchemeJdeCfg+".F0005 g on g.drsy = '01'  and g.drrt = '08' and trim(g.DrKy) = trim(Abac08)  "
					+ sWhere + " fetch first 2000 rows only";
			
					lstCustomer = em.createNativeQuery(sQuery, CustomerInfo.class).getResultList();
					
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al momento de realizar la consulta de cliente");
		}

		return lstCustomer;
	}

	
	/**
	 * Get Company List
	 * 
	 * @param em
	 * @param codtab
	 * @return
	 * @throws Exception
	 */
	public List<GeneralCatalog> getCompanies(String codtab, String companyIds) throws Exception {		
		List<GeneralCatalog> generalCatalogs = new ArrayList<GeneralCatalog>();
		
		companyIds = "(" + companyIds + ")";

		try {
			// For companies
			String sQuery = "SELECT TRIM(a.CODIDE) id, TRIM(a.DESCRI) name, TRIM(a.ORDEN) orden, TRIM(a.OTROS1) otros1, TRIM(a.P25) p25, "
					+ "TRIM(a.tdescri1) description, TRIM(b.tdescri1) dgiCode, TRIM(c.tdescri1) postal "
					+ "FROM " + CollectionScheme.SchemeInventario + ".TABMUL a left outer join " + CollectionScheme.SchemeInventario  +  ".TABMUL b on a.codide = b.codide "
					+ "left outer join " + CollectionScheme.SchemeInventario  + ".TABMUL c on c.codide = a.codide " + "where a.CODTAB = ?  "
					+ "AND ( a.P25 =' ')  "
					+ "AND b.codtab='1A' AND c.codtab = '1C' AND a.codide in " + companyIds + " ORDER BY a.CODIDE ASC";

			generalCatalogs = em.createNativeQuery(sQuery, GeneralCatalog.class).setParameter(1, codtab)
					.getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return generalCatalogs;
	}

	/**
	 * Get Branches List
	 * 
	 * @param em
	 * @param codtab
	 * @return
	 * @throws Exception
	 */
	public List<GeneralCatalog> getBranches(String codtab, String branchId) throws Exception {
		List<GeneralCatalog> generalCatalogs = new ArrayList<GeneralCatalog>();
		
		String filter = "";
		
		if (branchId.equals("")) {
			filter = " AND a.CODIDE!=''";
		} else {
			filter = " AND a.CODIDE = '" + branchId + "'";
		}

		try {
			String sQuery = "SELECT TRIM(a.CODIDE) id, "
					+ "TRIM(a.DESCRI) name, "
					+ "TRIM(a.ORDEN) orden, "
					+ "TRIM(a.OTROS1) otros1, "
					+ "TRIM(a.P25) p25, "
					+ "TRIM(a.tdescri1) description, "
					+ "(SELECT TRIM(descri) FROM "+ CollectionScheme.SchemeInventario + ".TABMUL WHERE codtab='18' AND a.codide = codide) phones "

					+ " FROM " + CollectionScheme.SchemeInventario + ".TABMUL a "
					+ "where a.CODTAB = ?  " + "AND ( a.P25 =' ')  "
					+ " " + filter + "  ORDER BY a.CODIDE ASC";

			generalCatalogs = em.createNativeQuery(sQuery, GeneralCatalog.class).setParameter(1, codtab)
					.getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return generalCatalogs;
	}
	
	/**
	 * 
	 * @param em
	 * @return
	 * @throws Exception
	 */
	public List<JDECatalog> getJDCatalog(String companiesId, String branchsId, String linesId) throws Exception {
		List<JDECatalog> jdeCatalogs = new ArrayList<JDECatalog>();
		
		companiesId = "(" + companiesId + ")";
		branchsId = "(" + branchsId + ")";
		linesId = "(" + linesId + ")";

		try {
			String sQuery = "SELECT TRIM(DRDL01) companyName, "
					+ "(SELECT TRIM(mcdl01) from " + CollectionScheme.SchemeJDE + ".f0006 "
							+ "where mcco = JDSUCURS and mcrp01 = JDCOMPAN  and Cast(Trim(MCSTYL) as Varchar(20) ccsid 37)  = 'BS' ) branchName,  "
							+ "Cast(Trim(MCSTYL) as Varchar(20) ccsid 37) itemType, TRIM(COMPAN) companyId, TRIM(mcdl01) lineName, "
							+ "TRIM(SUCURS) branchId, TRIM(DEPART) lineId, TRIM(JDCOMPAN) jdCompanyId, TRIM(JDSUCURS) jdBranchId, "
					+ "TRIM(JDDEPART) jdLineId,  cast(TRIM(mcrp07) as varchar(6) ccsid 37 ) jdLineId2, "
					+ "(SELECT  IFNULL(TRIM(codigo), '') FROM  " + CollectionScheme.SchemeInventario + ".invd00 WHERE CODTAB ='001' and codide='01' and orden='07' and compan=a.COMPAN  and sucurs=a.SUCURS and depart=a.DEPART) account, " 
					+ "(SELECT  IFNULL(TRIM(codigo), '') FROM  " + CollectionScheme.SchemeInventario + ".invd00 WHERE CODTAB ='001' and codide='01' and orden='03' and compan=a.COMPAN  and sucurs=a.SUCURS and depart=a.DEPART) accountDev " 

					+ "FROM " + CollectionScheme.SchemeInventario + ".invd00 a"
					+ " left outer join " + CollectionScheme.SchemeJDE + ".f0006 on mcmcu = JDDEPART "
					+ " left outer join  " + CollectionScheme.SchemeJDECOM + ".f0005 on TRIM(DRKY) = JDCOMPAN "

					+ "WHERE nivel = 4 AND  drsy = '00' AND Cast(Trim(MCSTYL) as Varchar(20) ccsid 37) = 'IS'  "
					+ "and drrt='01'  AND CODTAB ='001' and  compan in " + companiesId + " and depart in " + linesId + " and sucurs in " + branchsId;
						
			jdeCatalogs = em.createNativeQuery(sQuery, JDECatalog.class)
					.getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return jdeCatalogs;
	}
	

	/**
	 * General Catalog
	 * 
	 * @param em
	 * @param codtab
	 * @return
	 * @throws Exception
	 */
	public List<GeneralCatalog> getCatalogByCode(String codtab, String where) throws Exception {
		List<GeneralCatalog> generalCatalogs = new ArrayList<GeneralCatalog>();
		
		String filter = "";
		
		if (where.equals("")) {
			filter = "  AND CODIDE!=''";
		} else {
			filter = " AND CODIDE in "+ "(" + where + ")"; 
		}
		
		try {

			String sQuery = "SELECT TRIM(CODIDE) id, TRIM(DESCRI) name, TRIM(ORDEN) orden, TRIM(OTROS1) otros1, TRIM(P25) p25, "
					+ "TRIM(tdescri1) description FROM " + CollectionScheme.SchemeInventario + ".TABMUL " 
					+ "where CODTAB = ?  AND p3!='I' " + filter;

			if (codtab.equals("5A")) {
				sQuery += " AND p25 = '' ";
			}

			sQuery += " ORDER BY CODIDE ASC";

			generalCatalogs = em.createNativeQuery(sQuery, GeneralCatalog.class).setParameter(1, codtab)
					.getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return generalCatalogs;
	}

	/**
	 * Client Discounts TYPE
	 * 
	 * @param em
	 * @param clientId
	 * @return
	 * @throws Exception
	 */
	public List<CLientBrandDiscount> getClientsDiscounts(String clientId) throws Exception {
		List<CLientBrandDiscount> cLientBrandDiscounts = new ArrayList<CLientBrandDiscount>();

		String value = "(" + clientId + ")";

		try {
			String sQueryPrices = "SELECT compan companyId, clclie clientId, codMarca brandId, porcentad1 percentDiscount "
					+ "from " + CollectionScheme.SchemeInventario +".invd52 WHERE clclie in " + value;
			cLientBrandDiscounts = em.createNativeQuery(sQueryPrices, CLientBrandDiscount.class).getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return cLientBrandDiscounts;
	}

	
	/**
	 * Brand Discounts
	 * 
	 * @param em
	 * @param brandId
	 * @return
	 * @throws Exception
	 */
	public List<BrandDiscount> getBrandDiscounts(String brandId) throws Exception {
		List<BrandDiscount> brandDiscounts = new ArrayList<BrandDiscount>();

		String value = "(" + brandId + ")";

		try {
			String sQueryPrices = "SELECT compan companyId, depart departmentId, codmarca brandId, nolinea lineId, "
					+ "montofactI montoFactI, montoFactS montoFactS, PorcenDesc percentDiscount "
					+ "from " + CollectionScheme.SchemeInventario +".invd53 where codmarca in " + value;

			brandDiscounts = em.createNativeQuery(sQueryPrices, BrandDiscount.class).getResultList();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return brandDiscounts;
	}

	
	/**
	 * Product Prices
	 * 
	 * @param em
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public List<ProductPrices> getPricesByProductIdAndType(String productId) throws Exception {
		List<ProductPrices> productPrices = new ArrayList<ProductPrices>();

		List<ProductPrices> finalPrices = new ArrayList<ProductPrices>();
		
		String value = "";
		
		if (!productId.equals("")) {
					
			value = " WHERE iparte in " + "(" + productId + ")";
			
			String sQueryPrices = "SELECT TRIM(pcompan) companyId, TRIM(itippr) type, "
					+ "TRIM(iparte) productId ,ipreci price, TRIM(itipmo) coinType  "
					+ "from " + CollectionScheme.SchemeInventario + " .invd20  " + value;

			productPrices = em.createNativeQuery(sQueryPrices, ProductPrices.class).getResultList();

			if (productPrices.size() > 0) {
				finalPrices.addAll(productPrices);
			}
			
		} else {
			
		    String[] itemsId = {"01", "02"};
			
			for (String item : itemsId) {
				
				String tableName = item.equals("01") ?  CollectionScheme.SchemeInventario + "." + "INVD01" : CollectionScheme.SchemeInventario + "." + "INVV01";

				String sQueryPrices = "SELECT TRIM(pcompan) companyId, TRIM(itippr) type, "
						+ "TRIM(iparte) productId ,ipreci price, TRIM(itipmo) coinType  "
						+ "from " + CollectionScheme.SchemeInventario + " .invd20 left outer join  " 
						+ tableName + " b on (TRIM(iparte) = TRIM(b.inopar) AND  "
								+ " TRIM(pcompan) = TRIM(b.icompan)) WHERE imar4k = '1' AND "
								+ " ((IEXT01 - (ILOCA1 + ICAV01 + ICALB3)) + (IEXT08 - (ILOCA4 + ICAV08 +  SUSLB3))) > 0  "  + value;

				productPrices = em.createNativeQuery(sQueryPrices, ProductPrices.class).getResultList();

				if (productPrices.size() > 0) {
					finalPrices.addAll(productPrices);
				}
			}
		
		}
	
		return finalPrices;
	}
	
	/**
	 * Generate Discount Codes
	 * @param em
	 * @param userId
	 * @param cellarId
	 * @return
	 * @throws Exception
	 */
	public List<AuthorizationCode> getDiscountCodes(String userId, String cellarId) throws Exception {
		List<AuthorizationCode> discountCodes = new ArrayList<AuthorizationCode>();
			
		if (cellarId.equals("") && userId.equals("")) {
			discountCodes = getCodesForUser("", "");
			return discountCodes;
		}
		
		discountCodes = getCodesForUser(userId, cellarId);
				
		if (discountCodes.size() > 0) {
			return discountCodes;
		}
		
		UserTransaction utx = sessionContext.getUserTransaction();

		utx.begin();
		
		Random random = new Random();
		Set<Integer> set = new HashSet<Integer>(SET_SIZE_REQUIRED);

		while (set.size() < SET_SIZE_REQUIRED) {
			while (set.add(random.nextInt(NUMBER_RANGE)) != true);
		}
		
		assert set.size() == SET_SIZE_REQUIRED;
		String queryInsert = "INSERT INTO " + CollectionScheme.GCPFMU_SCHEMA + ".authorization_codes (CODE_ID, CELLAR_ID, DATE, USER_ID, STATUS) VALUES ";

		Object[] array = set.toArray();
		String values = "";

		for (int i = 0; i < array.length; i++) {
			Object code = array[i];
			values += "(" + code + ", '" + cellarId  + "', " + FMUUtil.getIntegerDate()  +", '" + userId + "', " + 0 + ")";
		
			if (array.length != (i + 1)) {
				values += ",";
			} 
		}
		
		try {
			
			deleteDiscountCodes(cellarId, userId, em);
			
			int result = 0;
			if (!values.equals("")) { 
				result = em.createNativeQuery(queryInsert + values).executeUpdate();
			}
		
			if (result > 0) {
				utx.commit();
			} else {
				utx.rollback();
			}
			
			discountCodes = getCodesForUser(userId, cellarId);
			
			return discountCodes;

		} catch (Exception e) {
			// TODO: handle exception
			utx.rollback();
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	private List<AuthorizationCode> getCodesForUser(String userId,  String cellarId) {
		
		String queryStatus = "";
		
		if (!cellarId.equals("") && !userId.equals("")) {
			queryStatus += " and user_id = '" + userId + "' and cellar_id = '" + cellarId + "'  and status = 0";
		}
		
		String sQueryCodes = "SELECT "
				+ "code_id codeId, "
				+ "cellar_id cellarId, "
				+ "USER_ID user, "
				+ "date,"
				+ " status state, "
				+ " IFNULL(hour, 0) hourTime, "
				+ "company_d companyId, "
				+ "branch_id branchId, type type, IFNULL(foreign_key,0) foreign from " + CollectionScheme.GCPFMU_SCHEMA +  ".authorization_codes where "
						+ " date = " + FMUUtil.getIntegerDate() + queryStatus;	
	
		return  em.createNativeQuery(sQueryCodes, AuthorizationCode.class).getResultList();
		
	}	
	
	/**
	 * Delete Discount Codes
	 * @param cellarId
	 * @param userId
	 * @param date
	 * @param em
	 * @return
	 */
	private int deleteDiscountCodes(String cellarId, String userId, EntityManager em) {
		String sQuery = "delete from " + CollectionScheme.GCPFMU_SCHEMA +".authorization_codes "
				+ "where user_id = ? and cellar_id = ?  and status = 0";
		return em.createNativeQuery(sQuery).setParameter(1, userId).setParameter(2, cellarId).executeUpdate();
	}
	

	/**
	 * Process close day
	 * @param initDay
	 * @return
	 */
	public ResponseApi sendInitDayLogs(InitDay initDay) {
		ResponseApi response = null;
		
		UserTransaction utx = sessionContext.getUserTransaction();
		
		if (initDay.getId() == 0) {
			response = insertInitDay(utx, initDay);
		} else if (initDay.getId() > 0) {
			response = closeInitDay(utx, initDay);
		}
			
		return response;
	}

	private ResponseApi insertInitDay(UserTransaction utx, InitDay initDay) {
		
		ResponseApi response = new ResponseApi();

		try {
		
			List<Object> initDayObject = new ArrayList<Object>();

			utx.begin();
			
			// Force close
			String sQueryClose = "UPDATE  " + CollectionScheme.GCPFMU_SCHEMA +".init_day "
					+ " set end_date = ?, end_hour = ?, active = 0 where active = 1 and USER_ID = ?";
			
			em.createNativeQuery(sQueryClose).
					setParameter(1, initDay.getEndDate()).
					setParameter(2, initDay.getEndHour()).
					setParameter(3, initDay.getUserId()).
					executeUpdate();
			
			String sQuery = "INSERT INTO " + CollectionScheme.GCPFMU_SCHEMA +  ".init_day (" +
				"DATE," +
				"HOUR," +
				"CELLAR_ID," +
				"USER_ID," +
				"BRANCH_ID," +		
				"ZONE_ID," +				
				"ACTIVE) " +
				
			"VALUES (" +	
			 		"" + initDay.getDate() + ", " +
			 		"" + initDay.getHourTime() + ", " +
			 		"'" + initDay.getCellarId() + "', " +
			 		"'" + initDay.getUserId() + "', " +
			 		"'" + initDay.getBranchId() + "', " +
			 		"'" + initDay.getZoneId() + "', " +
			 		"'" + 1 + "')";
						
				Query statementInsert = em.createNativeQuery(sQuery);
				statementInsert.executeUpdate();
				response.setError(0);


				String initDayItemQuery = "select a.id from " + CollectionScheme.GCPFMU_SCHEMA
						+ ".init_day a order by id DESC FETCH FIRST 1 ROWS ONLY ";

				initDayObject = em.createNativeQuery(initDayItemQuery, Object.class).getResultList();

				int dayId = 0;

				if (initDayObject.size() > 0) {
					dayId = Integer.parseInt(initDayObject.get(0).toString());
				}

				response.setInitDayId(dayId);
				utx.commit();

			} catch (Exception e) {
				// TODO: handle exception
				try {
					utx.rollback();
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SystemException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				e.printStackTrace();
				response.setError(1);
				response.setMessage(e.getMessage());
			}
		
			return response;
	}
	
	private ResponseApi closeInitDay(UserTransaction utx, InitDay initDay) {
		ResponseApi response = new ResponseApi();
		
		if (!initDay.getInitDayActionList().isEmpty()) {

			try {
				utx.begin();
				
				String sQuery = "UPDATE  " + CollectionScheme.GCPFMU_SCHEMA +".init_day "
						+ " set end_date = ?, end_hour = ?, active = 0 where id = ?";
				
				int result = em.createNativeQuery(sQuery).
						setParameter(1, initDay.getEndDate()).
						setParameter(2, initDay.getEndHour()).
						setParameter(3, initDay.getId()).
						executeUpdate();
				
				if (result > 0 && !initDay.getInitDayActionList().isEmpty()) {
					
					String queryInsert = "INSERT INTO " + CollectionScheme.GCPFMU_SCHEMA + ".init_day_action "
							+ "(IDINITDAY, HOUR, ACTION, OBJECT_ID, CLIENT_ID, DESCRIPTION, COMPANY_ID) VALUES ";
					
					String values = "";

					for (InitDayAction initDayAction : initDay.getInitDayActionList()) {
						// Insert
						values += "(" + initDay.getId() + ", " + initDayAction.getHour() + ", '"
								+ initDayAction.getAction() + "', '" + initDayAction.getObjectId() + "', "
								+ initDayAction.getClientId() + ", '" + initDayAction.getDescription() + "', '" 
								+ initDayAction.getCompanyId() + "')";
						values += ",";
					}
					
					if (values.length() > 0 && !values.equals("")) {
						values = values.substring(0, values.length() -1); 						
						String completeQuery = queryInsert + "\n" + values;							
						em.createNativeQuery(completeQuery).executeUpdate();
					}
				}
				
				response.setError(0);
				utx.commit();
				
			} catch (Exception e) {
				// TODO: handle exception
				try {
					utx.rollback();
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SystemException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				response.setMessage(e.getMessage());
				response.setError(1);
			}
		}
		
		return response;
	}
	
	
	public ResponseApi sendDevicePosition(List<RoutePosition> postGeneralObject) {
		ResponseApi response = new ResponseApi();

		UserTransaction utx = sessionContext.getUserTransaction();

		String queryInsert = "INSERT INTO " + CollectionScheme.GCPFMU_SCHEMA + ".route_position "
				+ "(CELLAR_ID, SELLER_ID, LATITUD, LONGITUD, DATE, HOUR, ZONE_ID, BRANCH_ID) VALUES ";

		String values = "";

		try {
			utx.begin();

			for (RoutePosition routePosition : postGeneralObject) {

				values += "('" + routePosition.getCellarId() + "', '" + routePosition.getSellerId() + "', '"
						+ routePosition.getLatitude() + "', '" + routePosition.getLongitude() + "', "
						+ routePosition.getDate() + ", " + routePosition.getHour() + ", '" + routePosition.getZoneId()
						+ "', '" + routePosition.getBranchId() + "')";
				values += ",";
			}

			if (values.length() > 0 && !values.equals("")) {
				values = values.substring(0, values.length() - 1);
				String completeQuery = queryInsert + "\n" + values;
				em.createNativeQuery(completeQuery).executeUpdate();
			}
			
			response.setError(0);
			utx.commit();

		} catch (Exception e) {
			// TODO: handle exception
			try {
				utx.rollback();
			} catch (IllegalStateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			response.setMessage(e.getMessage());
			response.setError(1);
		}

		return response;
	}
	
	/**
	 * General Catalog
	 * 
	 * @param em
	 * @param codtab
	 * @return
	 * @throws Exception
	 */
	public PostObjectReturn getClientProductPrice(String productId, String companyId, String priceType,
			String brandId, int clientId, String branchId, int sellerId) throws Exception {
		
		List<PostObjectReturn> postObjectReturns = new ArrayList<PostObjectReturn>();
		List<PostObjectReturn> postObjectReturnDiscounts = new ArrayList<PostObjectReturn>();
		
		List<PostObjectReturn> returnAvailableObject = new ArrayList<PostObjectReturn>();

		List<Brand> brands = new ArrayList<Brand>();
		List<ClientExchangeRatesCatalog> clientExchangeRatesCatalogs = new ArrayList<ClientExchangeRatesCatalog>();

		PostObjectReturn postObjectReturn = null;
		
		String tableName = companyId.equals("01") ? "INVD01" : "INVV01";		

		try {
			String sQuery = "SELECT CAST(DECIMAL( ipreci, 10, 2 ) as varchar(10)) billId, IFNULL(itipmo, '') movementType, "
					+ "IFNULL((SELECT  cast(porcentad1 as integer)   from  " 
					+ CollectionScheme.SchemeInventario  + ".invd52 WHERE clclie = " + clientId + "  "
							+ "and codMarca ='" + brandId + "'), 0) jdeNumber "
							
					+ "from " + CollectionScheme.SchemeInventario + ".invd20 "
							+ "where pcompan='" + companyId + "' "
							+ "and trim(iparte) = '" + productId + "' and itippr = '" + priceType + "'";
		
			String  queryTotal = "";
			
			int available = 0;
			postObjectReturn = new PostObjectReturn();

			if (branchId.equals(FMUUtil.CPD_BRANCH_CODE)) {
				
				queryTotal = "SELECT ((IEXT01 - (ILOCA1 + ICAV01 + ICALB3)) + (IEXT08 - (ILOCA4 + ICAV08 +  SUSLB3))) batchNumber, "
						+ "IFNULL((select BSTATU1 from " + CollectionScheme.SchemeInventario + ".INVD03  where trim(binopar) ="
						+ " trim(inopar) and trim(bsucurs)='00' and trim(bcompan)='01' and trim(bdepart)=trim(ilinea) and bbodega='01'), '') billId,  "
						+ "IFNULL((select BSTATU1 from " + CollectionScheme.SchemeInventario + ".INVD03  where trim(binopar) ="
						+ " trim(inopar) and trim(bsucurs)='00' and trim(bcompan)='01' and trim(bdepart)=trim(ilinea) and bbodega='08'), '') companyId  "
						+ "from  " 
						+ CollectionScheme.SchemeInventario  + "." + tableName + " "
								+ "WHERE TRIM(inopar) = '" + productId + "' FOR READ ONLY";

				returnAvailableObject = em.createNativeQuery(queryTotal, PostObjectReturn.class).getResultList();

				if (!returnAvailableObject.isEmpty()) {
					if (!returnAvailableObject.get(0).getBillId().equals("9") || 
							!returnAvailableObject.get(0).getCompanyId().equals("9")) { 
						available = returnAvailableObject.get(0).getBatchNumber();
					}
				}
				
				postObjectReturn.setBatchNumber(available);
				
			} else {	
				getOrderReservationFieldArray(sellerId, productId, postObjectReturn);
			}
			
			postObjectReturns = em.createNativeQuery(sQuery, PostObjectReturn.class)
					.getResultList();
						
		
			postObjectReturn.setBillId(postObjectReturns.isEmpty() ? "0" : 
				(postObjectReturns.get(0).getBillId()));
			
			postObjectReturn.setMovementType(postObjectReturns.isEmpty() ? "" : 
				(postObjectReturns.get(0).getMovementType()));
			

			if (clientId !=0 && !brandId.equals("")) {
				String sQueryDiscount = "SELECT  cast(porcentad1 as integer) jdeNumber  from  " 
						+ CollectionScheme.SchemeInventario  + ".invd52 WHERE clclie = " + clientId + " "
								+ "and codMarca ='" + brandId + "'  ";
				
				postObjectReturnDiscounts = em.createNativeQuery(sQueryDiscount, PostObjectReturn.class)
						.getResultList();
			
				postObjectReturn.setJdeNumber(postObjectReturnDiscounts.isEmpty() ? 0 : 
					(postObjectReturnDiscounts.get(0).getJdeNumber()));
			}
			
			float exchange = 0;
			
			brands = getBrands(FMUUtil.BRAND_CATALOG, brandId);
			
			if (brands != null && brands.size() > 0) {
				exchange = brands.get(0).getExchange();
			}
			
			if (exchange == 0) {
				clientExchangeRatesCatalogs = getTypePrices(FMUUtil.TYPE_PRICES_CATALOG_ID, priceType);
			
				if (clientExchangeRatesCatalogs != null && clientExchangeRatesCatalogs.size() > 0) {
					exchange = clientExchangeRatesCatalogs.get(0).getExchange();					
				}
			}
			
			postObjectReturn.setCompanyId(exchange == 0 ? "0" : String.valueOf(exchange));		
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return postObjectReturn;
	}
	
	public List<GlobalProductCatalog> getProductsByCode(String productId, String brandId, String inventoryId)
			throws Exception {
		List<GlobalProductCatalog> productCatalogs = new ArrayList<GlobalProductCatalog>();
		List<GlobalProductCatalog> productsFinal = new ArrayList<GlobalProductCatalog>();

	    String[] itemsId = {"01", "02", "10"};
	    	    
	    if (!inventoryId.equals("")) {
	    	inventoryId = " AND  TRIM(IGRUPO01) = '" + inventoryId + "'";
	    }
	   
	    if (!brandId.equals("")) {
	    	brandId = " AND  TRIM(IGRUPO02) = '" + brandId + "'";
	    }
	  
		try {
			
			for (String item : itemsId) {
				String tableName = item.equals("01") ?  CollectionScheme.SchemeInventario + "." + "INVD01" : CollectionScheme.SchemeInventario + "." + "INVV01";

				String sQueryPrices = "SELECT TRIM(ICOMPAN) companyId,  TRIM(INOPAR) productId, TRIM(IDESCR) productName, TRIM(IDESCI) productDescription, TRIM(ILINEA)  lineId, "
						+ "TRIM(ICODPROVEE) providerId, TRIM(ICOTROLLOT) controlLot, TRIM(IUMEDIDAC) measureType, "
						+ "TRIM(linea.otros1) coin, "
						+ " (IIIVA / 100) iva, "
						+ "TRIM(icateg) categoryId, "			
						
						+ "IUMEDIDAA measureType2, TRIM(IGRUPO01) inventoryId ,TRIM(IGRUPO02) brandId, "
						+ "iprven price from "
						+ tableName
						+ " left outer join  " + CollectionScheme.SchemeInventario + ".TABMUL linea on ILINEA = linea.codide "
					
						+ " where linea.codtab = '20' AND  TRIM(INOPAR) like  '%" + productId + "%'  OR   TRIM(IDESCI) "
								+ "like  '%" + productId + "%'  " + inventoryId + brandId 
										+ " FETCH FIRST 100 ROW ONLY ";
				
				productCatalogs = em.createNativeQuery(sQueryPrices, GlobalProductCatalog.class).getResultList();

				if (productCatalogs.size() > 0) {
					productsFinal.addAll(productCatalogs);
				}
			}
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return productsFinal;
	}
	
	private void getOrderReservationFieldArray(int sellerId, String productId, PostObjectReturn postObjectReturn) {
		
		List<PostObjectReturn> returnAvailableObject = new ArrayList<PostObjectReturn>();
		
		int available = 0;
		String field = "";
		
		List<OrderReservationConfig> orderReservations = ClsOrderManager.getOrderReservationConfig(sellerId, em);

		for (OrderReservationConfig orderReservationConfig : orderReservations) {
			
			if (orderReservationConfig.getCellarId().equals("01")) {
				
				field = "SELECT (SSEXL00 - (SCANR00 + SCANINVES + SSCVL00)) batchNumber, "
						+ "IFNULL((select BSTATU1 from " + CollectionScheme.SchemeInventario + ".INVD03  where trim(binopar) ="
						+ " trim(sinopar) and trim(bsucurs)='" + orderReservationConfig.getBranchId() 
						+ "' and trim(bcompan) = '" 
						+ orderReservationConfig.getCompanyId() 
						+ "' and trim(bdepart)=trim(sdepart) and bbodega='" + orderReservationConfig.getCellarId() + "'), '') billId  "
						+ "from  " 
						+ CollectionScheme.SchemeInventario  + ".INVD02 "
								+ "WHERE TRIM(SINOPAR) = '" + productId + "'  and TRIM(scompan) = '" 
						+ orderReservationConfig.getCompanyId() + "' and TRIM(ssucurs) = '" 
								+ orderReservationConfig.getBranchId() + "'  "
							+ "and sdepart = '" + orderReservationConfig.getLineId() + "' FOR READ ONLY";
			} else {
				
				field = "select (bexistee - (BCANRESER + BCANINVES)) batchNumber,"
						+ " TRIM(BSTATU1) billId "
						+ "FROM " + CollectionScheme.SchemeInventario + ".invd03 where binopar = '" + productId + 
						"' and TRIM(bcompan) = '" + orderReservationConfig.getCompanyId() + "' and TRIM(bsucurs) = '"
						+ orderReservationConfig.getBranchId() + "'"
								+ " and TRIM(bdepart) = '" + orderReservationConfig.getLineId() + "'"
										+ " and bbodega = '" + orderReservationConfig.getCellarId() + "' FOR READ ONLY" ;
			}
			
			returnAvailableObject = em.createNativeQuery(field, PostObjectReturn.class).getResultList();
			
			if (!returnAvailableObject.isEmpty()) {				
				if (!returnAvailableObject.get(0).getBillId().equals("9")) { 					
					available+= returnAvailableObject.get(0).getBatchNumber();
				}
			}
		}
				
		postObjectReturn.setBatchNumber(available);
	}
	
	public List<Leyend> getLeyendUsd() {
		
		List<Leyend> lst = new ArrayList<Leyend>();
		
		String query = "SELECT 1 id, IFNULL(   SUBSTR(xmlserialize(xmlagg(xmltext(CONCAT( ' ', TRIM(LYLEYENDA) )) ORDER BY LYCODIGO ASC) "
				+ "as VARCHAR(1024)), 2) , '') leyend  FROM " + CollectionScheme.SchemeTaller +  ".INVD87 WHERE LYTIPOMO = 'Y1' "
				+ "UNION \n" 
				+ "SELECT T.* FROM ( \n" + 
				" SELECT 2 ID, IFNULL(  LYLEYENDA, '') AS LEYEND  FROM " + CollectionScheme.SchemeTaller +  ".INVD87  WHERE LYTIPOMO = '21' AND LYCODIGO = 1 AND LYCOMPAN = '' FETCH FIRST ROWS ONLY \n" + 
				") AS T";
		
		lst = em.createNativeQuery(query, Leyend.class).getResultList();
	
		return  lst;
		
	}
	
	public List<LeyendAttribute> getLeyendAttribute() {
		List<LeyendAttribute> lst = new ArrayList<LeyendAttribute>();
		
		String query = "SELECT TRIM(CODIDE) CODE, TRIM(DESCRI) NAME, TRIM(TDESCRI1) SHORTNAME FROM " + 
				CollectionScheme.SchemeTaller +  ".TABMUL WHERE CODTAB = '1D' AND CODIDE <> '' ";
		
		lst = em.createNativeQuery(query, LeyendAttribute.class).getResultList();
	
		return  lst;
	}
	
	public List<InvoiceCustomerExcept> getInvoiceCustomerExcept() {
		List<InvoiceCustomerExcept> lst = new ArrayList<InvoiceCustomerExcept>();
		
		String query = "SELECT CFAN8 CODCUSTOMER, TRIM(CFCRCD) CODCURRENCY \n" + 
				"FROM " + CollectionScheme.SchemeJDE + ".F5501001";
		
		lst = em.createNativeQuery(query, InvoiceCustomerExcept.class).getResultList();
	
		return  lst;
	}
	
}
