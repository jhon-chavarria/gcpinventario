package ni.com.casapellas.erp.inventario.almacen;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ni.com.casapellas.ejb.erp.util.DateTimeHelper;
import ni.com.casapellas.ejb.erp.util.PagedResult;
import ni.com.casapellas.erp.util.AuditLogService;
import ni.com.casapellas.erp.util.CustomItemStock;
import ni.com.casapellas.gcpinventario.GenericValidation;
import ni.com.casapellas.gcpinventario.InvExistGlobal;
import ni.com.casapellas.gcpinventario.Invd35;
import ni.com.casapellas.gcpinventario.Product;
import ni.com.casapellas.gcpinventario.ProductExistence;
import ni.com.casapellas.gcpinventario.ProductInfo;
import ni.com.casapellas.gcpinventario.ProductInfoLocation;
import ni.com.casapellas.gcpinventario.ProductoRelacionados;
import ni.com.casapellas.util.CollectionScheme;

public class ProductoService {
	EntityManager connection = null;
	String Guid;
	
	/**
	 */
	public ProductoService(EntityManager em,String GuidMaster) {
		this.connection = em;
		this.Guid = GuidMaster;
	}
	
	public ProductoService(EntityManager em) {
		this.connection = em;
	}

	@SuppressWarnings("unchecked")
	public ProductInfo getProductInfo(String compania, String sucursal, String bodega, String articulo)
			throws Exception {
		String strQuery = "";
		Query q = null;
		ProductInfo obj = null;

		try {
			List<ProductInfo> listProductInfo = null;

			if (compania.equals("01") && sucursal.equals("00")) {
				strQuery = "SELECT " + "ICOMPAN AS codigoCompania, " + "INOPAR AS codigoArticulo, "
						+ "IDESCR AS descripcion, " + "GRPARE AS CodigoAgrupacion, " + "INPARE AS articuloEquivalente, "
						+ "ICATEG AS codigoCategoria, " + "IARANA AS codigoArancel, "
						+ "IPARTID AS partidaArancelaria, " + "ICOSUL AS costo, ICOSTG AS costoTotal, " + "IUMEDIDAA AS unidadMedida, "
						+ "ILINEA AS codigoLinea, " + "IIIVA AS iva, " + "IIISC AS isc " + "FROM "
						+ CollectionScheme.SchemeInventario + ".INVD01 " + "WHERE ICOMPAN = ?1 AND INOPAR = ?2";

				q = this.connection.createNativeQuery(strQuery, ProductInfo.class);
				q.setParameter(1, compania);
				q.setParameter(2, articulo);
			}

			if (!compania.equals("01") && sucursal.equals("00")) {
				strQuery = "SELECT " + "ICOMPAN AS codigoCompania, " + "INOPAR AS codigoArticulo, "
						+ "IDESCR AS descripcion, " + "GRPARE AS CodigoAgrupacion, " + "INPARE AS articuloEquivalente, "
						+ "ICATEG AS codigoCategoria, " + "IARANA AS codigoArancel, "
						+ "IPARTID AS partidaArancelaria, " + "ICOSUL AS costo, ICOSTG AS costoTotal, " + "IUMEDIDAA AS unidadMedida, "
						+ "ILINEA AS codigoLinea, " + "IIIVA AS iva, " + "IIISC AS isc " + "FROM "
						+ CollectionScheme.SchemeInventario + ".INVV01 " + "WHERE ICOMPAN = ?1 AND INOPAR = ?2";

				q = this.connection.createNativeQuery(strQuery, ProductInfo.class);
				q.setParameter(1, compania);
				q.setParameter(2, articulo);
			}

			if (!sucursal.equals("00")) {
				String pFile = (compania.equals("01") ? "INVD01" : "INVV01");
				strQuery = "SELECT " + "D02.SCOMPAN AS codigoCompania, " + "D02.SINOPAR AS codigoArticulo, "
						+ "D01.IDESCR AS descripcion, " + "D01.GRPARE AS CodigoAgrupacion, "
						+ "D01.INPARE AS articuloEquivalente, " + "D01.ICATEG AS codigoCategoria, "
						+ "D01.IARANA AS codigoArancel, " + "D01.IPARTID AS partidaArancelaria, "
						+ "D02.SSCUL00 AS costo, SSCGL00 AS costoTotal, " + "D01.IUMEDIDAA AS unidadMedida, " + "D01.ILINEA AS codigoLinea, "
						+ "D01.IIIVA AS iva, " + "D01.IIISC AS isc " + "FROM " + CollectionScheme.SchemeInventario
						+ ".INVD02 D02 INNER JOIN " + CollectionScheme.SchemeInventario + "." + pFile
						+ " D01 ON D02.SCOMPAN = D01.ICOMPAN AND D02.SDEPART = D01.ILINEA AND D02.SINOPAR = D01.INOPAR "
						+ "WHERE D02.SCOMPAN = ?1 AND D02.SINOPAR = ?2 AND D02.SSUCURS = ?3";

				q = this.connection.createNativeQuery(strQuery, ProductInfo.class);
				q.setParameter(1, compania);
				q.setParameter(2, articulo);
				q.setParameter(3, sucursal);
			}

			AuditLogService.SaveLogDetail("getProductInfo",strQuery,Guid);
			
			listProductInfo = q.getResultList();

			if (listProductInfo.size() > 0) {
				obj = listProductInfo.get(0);
			}

			if (obj != null) {
				// Traer la informacion adicional
				ProductInfoLocation location = getProductLocation(compania, sucursal, obj.getCodigoLinea(), bodega,
						articulo);

				if (location != null) {
					obj.setUbicacion(location.getUbicacionActual().equals("") ? location.getUbicacionAnterior()
							: location.getUbicacionActual());
				} else {
					obj.setUbicacion("");
				}

				InvExistGlobal pExistencia = getProductExistenceByProduct(compania, sucursal, bodega,
						obj.getCodigoLinea(), articulo);

				if (pExistencia != null) {
					obj.setArchivoExistencia(pExistencia.getiFile());
					obj.setExistenciaBodega(pExistencia.getExistencia());
					obj.setExistenciaNacional(getTotalStock(compania, obj.getCodigoLinea(), articulo));
					// Toda la existencia no solo la disponible
					obj.setExistenciaTotalSucursal(getTotalBranchStock(compania, obj.getCodigoLinea(), sucursal, articulo));
				}

				// Extraer el precio fob
				obj.setPrecioFob(getProductFob(compania, obj.getCodigoLinea(), articulo));
				
				// Extraer si el articulo esta bloqueado a no
				obj.setArticuloBloqueado(IsProductBlock(compania, sucursal, bodega, obj.getCodigoLinea(), articulo));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("No se ha podido extraer la informacion del producto " + articulo);

		}

		return obj;
	}

	private ProductInfoLocation getProductLocation(String compania, String sucursal, String linea, String bodega,
			String articulo) throws Exception {
		String strQuery = "";
		Query q = null;
		ProductInfoLocation location = null;

		try {
			strQuery = "SELECT " + "BCOMPAN AS codigoCompania, " + "BSUCURS AS codigoSucursal, "
					+ "BDEPART AS codigoLinea, " + "BBODEGA AS codigoBodega, " + "BINOPAR AS codigoArticulo, "
					+ "BSUBL00 AS ubicacionActual, " + "BSUBLAN AS ubicacionAnterior " + "FROM "
					+ CollectionScheme.SchemeInventario + ".INVD03 "
					+ "WHERE BCOMPAN = ?1 AND BSUCURS = ?2 AND BDEPART = ?3 AND BBODEGA = ?4 AND BINOPAR = ?5";

			q = this.connection.createNativeQuery(strQuery, ProductInfoLocation.class);
			q.setParameter(1, compania);
			q.setParameter(2, sucursal);
			q.setParameter(3, linea);
			q.setParameter(4, bodega);
			q.setParameter(5, articulo);

			AuditLogService.SaveLogDetail("getProductLocation",strQuery,Guid);
			
			@SuppressWarnings("unchecked")
			List<ProductInfoLocation> listLocation = q.getResultList();

			if (listLocation.size() > 0) {
				location = listLocation.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("No se ha logrado extraer la informacion de ubicacion del producto");
		}

		return location;
	}
	
	@SuppressWarnings("unchecked")
	public List<InvExistGlobal> getProductExistenceTotal(String pCompania, String pSucursal, String pLinea, List<String> pArticulo) throws Exception {
		String strQuery = "";
		Query q = null;
		List<InvExistGlobal> result = null;
		try {
			strQuery = "SELECT COMPANIA, SUCURSAL, BODEGA, LINEA, ARTICULO, CANT_DISPONIBLE AS EXISTENCIA, CANT_TOTAL AS EXISTENCIATOTAL, COSTO, IFILE, IPFILE "
					+ "FROM " + CollectionScheme.SchemeInventario + ".INV_EXIST_GLOBAL "
					+ "WHERE COMPANIA = ?1 AND SUCURSAL = ?2 AND LINEA = ?3";// AND ARTICULO IN (?4)";

			strQuery += " AND ARTICULO IN ('" + String.join("','", pArticulo) + "')";
			
			q = this.connection.createNativeQuery(strQuery, InvExistGlobal.class);
			q.setParameter(1, pCompania);
			q.setParameter(2, pSucursal);
			q.setParameter(3, pLinea);

			AuditLogService.SaveLogDetail("getProductExistenceTotal",strQuery,Guid);
			
			result = q.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("No se ha logrado extraer la informacion del producto");
		}

		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<InvExistGlobal> getProductExistenceTotal(String pCompania, String pSucursal, String pLinea, String pBodega, List<String> pArticulo) throws Exception {
		String strQuery = "";
		Query q = null;
		List<InvExistGlobal> result = null;
		try {
			strQuery = "SELECT COMPANIA, SUCURSAL, BODEGA, LINEA, ARTICULO, CANT_DISPONIBLE AS EXISTENCIA, CANT_TOTAL AS EXISTENCIATOTAL, COSTO, COSTO_SUCURSAL AS COSTOSUCURSAL, IFILE, IPFILE "
					+ "FROM " + CollectionScheme.SchemeInventario + ".INV_EXIST_GLOBAL "
					+ "WHERE COMPANIA = ?1 AND SUCURSAL = ?2 AND LINEA = ?3 AND BODEGA = ?4";// AND ARTICULO IN (?4)";

			strQuery += " AND ARTICULO IN ('" + String.join("','", pArticulo) + "')";
			
			q = this.connection.createNativeQuery(strQuery, InvExistGlobal.class);
			q.setParameter(1, pCompania);
			q.setParameter(2, pSucursal);
			q.setParameter(3, pLinea);
			q.setParameter(4, pBodega);

			AuditLogService.SaveLogDetail("getProductExistenceTotal",strQuery,Guid);
			
			result = q.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("No se ha logrado extraer la informacion del producto");
		}

		return result;
	}

	public InvExistGlobal getProductExistenceByProduct(String pCompania, String pSucursal, String pBodega,
			String pLinea, String pArticulo) throws Exception {
		String strQuery = "";
		Query q = null;
		InvExistGlobal obj = null;
		try {
			strQuery = "SELECT COMPANIA, SUCURSAL, BODEGA, LINEA, ARTICULO, CANT_DISPONIBLE AS EXISTENCIA, CANT_TOTAL AS EXISTENCIATOTAL, COSTO, COSTO_SUCURSAL AS COSTOSUCURSAL, IFILE, IPFILE "
					+ "FROM " + CollectionScheme.SchemeInventario + ".INV_EXIST_GLOBAL "
					+ "WHERE COMPANIA = ?1 AND SUCURSAL = ?2 AND BODEGA = ?3 AND LINEA = ?4 AND ARTICULO = ?5";

			q = this.connection.createNativeQuery(strQuery, InvExistGlobal.class);
			q.setParameter(1, pCompania);
			q.setParameter(2, pSucursal);
			q.setParameter(3, pBodega);
			q.setParameter(4, pLinea);
			q.setParameter(5, pArticulo);

			AuditLogService.SaveLogDetail("getProductExistenceByProduct",strQuery,Guid);
			
			@SuppressWarnings("unchecked")
			List<InvExistGlobal> result = q.getResultList();

			if (result.size() > 0) {
				obj = result.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("No se ha logrado extraer la informacion del producto");
		}

		return obj;
	}

	private BigDecimal getTotalStock(String pCompania, String pLinea, String pArticulo) {
		BigDecimal result = new BigDecimal(0);
		String strQuery = "";
		Query q = null;

		try {
			strQuery = "SELECT COALESCE(SUM(CANT_DISPONIBLE), 0) AS CANT_DISPONIBLE " + "FROM "
					+ CollectionScheme.SchemeInventario + ".INV_EXIST_GLOBAL "
					+ "WHERE COMPANIA = ?1 AND LINEA = ?2 AND ARTICULO = ?3";

			q = this.connection.createNativeQuery(strQuery);
			q.setParameter(1, pCompania);
			q.setParameter(2, pLinea);
			q.setParameter(3, pArticulo);

			AuditLogService.SaveLogDetail("getTotalStock",strQuery,Guid);
			
			result = (BigDecimal) q.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public BigDecimal getTotalBranchStock(String pCompania, String pLinea, String pSucursal, String pArticulo) {
		BigDecimal result = new BigDecimal(0);
		String strQuery = "";
		Query q = null;

		try {
			strQuery = "SELECT COALESCE(SUM(CANT_TOTAL), 0) AS TOTAL " + "FROM "
					+ CollectionScheme.SchemeInventario + ".INV_EXIST_GLOBAL "
					+ "WHERE COMPANIA = ?1 AND LINEA = ?2 AND ARTICULO = ?3 AND SUCURSAL = ?4";

			q = this.connection.createNativeQuery(strQuery);
			q.setParameter(1, pCompania);
			q.setParameter(2, pLinea);
			q.setParameter(3, pArticulo);
			q.setParameter(4, pSucursal);

			AuditLogService.SaveLogDetail("getTotalBranchStock",strQuery,Guid);
			
			result = (BigDecimal) q.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public BigDecimal getAVailableBranchStock(String pCompania, String pLinea, String pSucursal, String pArticulo) {
		BigDecimal result = new BigDecimal(0);
		String strQuery = "";
		Query q = null;

		try {
			strQuery = "SELECT COALESCE(SUM(CANT_DISPONIBLE), 0) AS TOTAL " + "FROM "
					+ CollectionScheme.SchemeInventario + ".INV_EXIST_GLOBAL "
					+ "WHERE COMPANIA = ?1 AND LINEA = ?2 AND ARTICULO = ?3 AND SUCURSAL = ?4";

			q = this.connection.createNativeQuery(strQuery);
			q.setParameter(1, pCompania);
			q.setParameter(2, pLinea);
			q.setParameter(3, pArticulo);
			q.setParameter(4, pSucursal);

			AuditLogService.SaveLogDetail("getAVailableBranchStock",strQuery,Guid);
			
			result = (BigDecimal) q.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	private BigDecimal getProductFob(String pCompania, String pLinea, String pArticulo) throws Exception {
		BigDecimal fob = new BigDecimal(0);
		String strQuery = "";
		Query q = null;

		try {
			String iFile = pCompania.equals("01") ? "INVD01" : "INVV01";

			strQuery = "SELECT COALESCE(IPRFOB, 0) AS IPRFOB FROM " + CollectionScheme.SchemeInventario + "." + iFile
					+ " WHERE ICOMPAN = ?1 AND ILINEA = ?2 AND INOPAR = ?3";

			q = this.connection.createNativeQuery(strQuery);
			q.setParameter(1, pCompania);
			q.setParameter(2, pLinea);
			q.setParameter(3, pArticulo);

			AuditLogService.SaveLogDetail("getProductFob",strQuery,Guid);
			
			fob = (BigDecimal) q.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return fob;
	}
	
	public Boolean IsProductBlock(String pCompania, String pSucursal, String pBodega, String pLinea, String pArticulo) {
		Boolean isBlock = false;
		String strQuery = "";
		Query q = null;
		
		try {
			strQuery = "SELECT "
					+ "    COUNT(1) AS CANTIDAD " 
					+ "FROM "
					+ "    " + CollectionScheme.SchemeInventario + ".INVD03 " 
					+ "WHERE "
					+ "    BCOMPAN = ?1"
					+ "    AND BSUCURS = ?2" 
					+ "    AND BDEPART = ?3" 
					+ "    AND BBODEGA = ?4"
					+ "    AND BINOPAR = ?5" 
					+ "    AND BSTATU1 = '9'";
			
			q = this.connection.createNativeQuery(strQuery);
			q.setParameter(1, pCompania);
			q.setParameter(2, pSucursal);
			q.setParameter(3, pLinea);
			q.setParameter(4, pBodega);
			q.setParameter(5, pArticulo);
			
			AuditLogService.SaveLogDetail("IsProductBlock",strQuery,Guid);
			
			Integer res = (Integer) q.getSingleResult();
			
			isBlock = res == 1 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return isBlock;
	}
	
	@SuppressWarnings("unchecked")
	public List<CustomItemStock> GetProductToInvoice(String pCompany, String pBranch, List<String> pWarehouseList, List<String> pItemList) {
		List<CustomItemStock> result = null;
		Query q = null;
		
		try {
			String strQuery = "WITH CTE_DISPONIBLE AS ("
					+ "    SELECT "
					+ "        COMPANIA, SUCURSAL, BODEGA, LINEA, ARTICULO, CANT_DISPONIBLE, CANT_TOTAL, COSTO, COSTO_SUCURSAL " 
					+ "    FROM "
					+ "        " + CollectionScheme.SchemeInventario + ".INV_EXIST_GLOBAL "
					+ "    WHERE "
					+ "        COMPANIA = ?1 "
					+ "        AND SUCURSAL = ?2"
					+ "        AND BODEGA IN ('" + String.join("','", pWarehouseList) + "')"
					+ "        AND ARTICULO IN ('" + String.join("','", pItemList) + "')"
					+ "), CTE_EXISTENCIA_SUCURSAL AS ("
					+ "    SELECT "
					+ "        COMPANIA, SUCURSAL, LINEA, ARTICULO, SUM(CANT_TOTAL) AS CANT_SUCURSAL, COSTO, COSTO_SUCURSAL "
					+ "    FROM "
					+ "        " + CollectionScheme.SchemeInventario + ".INV_EXIST_GLOBAL "
					+ "    WHERE "
					+ "        COMPANIA = ?1 "
					+ "        AND SUCURSAL = ?2 "
					+ "        AND ARTICULO IN ('" + String.join("','", pItemList) + "')"
					+ "    GROUP BY "
					+ "        COMPANIA, SUCURSAL, LINEA, ARTICULO, COSTO, COSTO_SUCURSAL" 
					+ ")"
					+ "SELECT " 
					+ "    C1.COMPANIA AS CODIGOCOMPANIA, "
					+ "    C1.SUCURSAL AS CODIGOSUCURSAL, "
					+ "    C1.BODEGA AS CODIGOBODEGA, "
					+ "    C1.LINEA AS CODIGOLINEA, "
					+ "    C1.ARTICULO AS CODIGOARTICULO, "
					+ "    C1.CANT_DISPONIBLE AS EXISTENCIADISPBODEGA, "
					+ "    C1.CANT_TOTAL AS EXISTENCIATOTALBODEGA, "
					+ "    C1.COSTO AS COSTOUNITARIO, "
					+ "    C1.COSTO_SUCURSAL AS COSTOTOTALSUCURSAL, "
					+ "    C2.CANT_SUCURSAL AS EXISTENCIATOTALSUCURSAL, "
					+ "    CASE WHEN D03.BSTATU1 = '9' THEN 1 ELSE 0 END AS BLOQUEADO " 
					+ "FROM " 
					+ "    CTE_DISPONIBLE C1 INNER JOIN CTE_EXISTENCIA_SUCURSAL C2" 
					+ "        ON C1.COMPANIA = C2.COMPANIA AND C1.SUCURSAL = C2.SUCURSAL AND C1.LINEA = C2.LINEA AND C1.ARTICULO = C2.ARTICULO" 
					+ "    LEFT OUTER JOIN " + CollectionScheme.SchemeInventario + ".INVD03 D03"
					+ "        ON D03.BCOMPAN = C1.COMPANIA AND D03.BSUCURS = C1.SUCURSAL AND D03.BDEPART = C1.LINEA AND D03.BINOPAR = C1.ARTICULO AND D03.BBODEGA = C1.BODEGA";
			
			q = this.connection.createNativeQuery(strQuery, CustomItemStock.class);
			
			q.setParameter(1, pCompany);
			q.setParameter(2, pBranch);
			
			AuditLogService.SaveLogDetail("GetProductToInvoice",strQuery,Guid);
			
			result = (List<CustomItemStock>)q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return result;
	}

	/*
	 * Metodos Byron
	 */
	
	@SuppressWarnings("unchecked")
	public PagedResult<Product> GetAllProducts(String pCompany, int pPageNumber, int pPageSize) throws Exception {
		PagedResult<Product> result = null;
		Query q = null;
		
		String selectCount = "SELECT COUNT(1) "
				+ "FROM " + CollectionScheme.SchemeInventario + ".INV_MAESTRO_PRODUCTO_GLOBAL "
				+ "WHERE CODIGOCOMPANIA = ?1";

		String strQueryFullSelect = "SELECT " 
				+ "    CODIGOCOMPANIA, "
				+ "    CODIGOARTICULO, "
				+ "    DESCRIPCIONCORTA, "
				+ "    DESCRIPCIONLARGA, "
				+ "    CODIGOPEDIDO, "
				+ "    CODIGOAGRUPADOR, "
				+ "    CODIGOEQUIVALENTE, "
				+ "    CODIGOPRODUCTOUNO, "
				+ "    CODIGOPRODUCTODOS, "
				+ "    CODIGOAPLICACION, "
				+ "    CODIGOCATEGORIA, "
				+ "    CODIGOARANCEL, "
				+ "    CODIGOPARTIDA, "
				+ "    CANTIDADXVEHICULO, "
				+ "    PRECIOVENTA, "
				+ "    PRECIOFOB, "
				+ "    PIEZASDESARME, "
				+ "    UNIDADESEMPAQUE, "
				+ "    CODIGODESCUENTO, "
				+ "    GRUPOPIEZA, "
				+ "    CODIGOPRECIO, "
				+ "    FACTORCONVERSION, "
				+ "    CODIGOBARRA, "
				+ "    CODIGOPROVEEDOR, "
				+ "    CONTROLXLOTE, "
				+ "    CODIGOMARCAARTICULO, "
				+ "    UNIDADMEDIDACOMPRA, "
				+ "    UNIDADMEDIDAALMACENA, "
				+ "    CODIGOLINEA, "
				+ "    GRUPOMARCA, "
				+ "    CODIGOMARCA, "
				+ "    GRUPO03, "
				+ "    GRUPO04, "
				+ "    GRUPO05, "
				+ "    GRUPO06, "
				+ "    GRUPO07, "
				+ "    GRUPO08, "
				+ "    GRUPO09, "
				+ "    GRUPO10, "
				+ "    GRUPO11, "
				+ "    PAGAIVA, "
				+ "    IMPUESTOVENTA, "
				+ "    CODIGOBARRACAJA, "
				+ "    ESTADO, "
				+ "    USUARIOINCLUSION, "
				+ "    FECHAINCLUSION, "
				+ "    HORAINCLUSION, "
				+ "    USUARIOMODIFICACION, "
				+ "    FECHAMODIFICACION, "
				+ "    HORAMODIFICACION "
				+ "FROM " 
				+ "    " + CollectionScheme.SchemeInventario + ".INV_MAESTRO_PRODUCTO_GLOBAL "
				+ "WHERE "
				+ "    CODIGOCOMPANIA = ?1";
		try {
			
			q = this.connection.createNativeQuery(selectCount);
			q.setParameter(1, pCompany);
			
			Integer rowCount = (Integer)q.getSingleResult();
			
			q = this.connection.createNativeQuery(strQueryFullSelect, Product.class);
			q.setParameter(1, pCompany);
			// Pagination
			q.setFirstResult((pPageNumber - 1) * pPageSize);
			q.setMaxResults(pPageSize);
			
			AuditLogService.SaveLogDetail("GetAllProducts",strQueryFullSelect,Guid);
			
			List<Product> listProduct = (List<Product>)q.getResultList();
			
			result = new PagedResult<Product>(rowCount, pPageNumber, pPageSize, listProduct);

		} catch (Exception e) {
			throw e;
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Product> GetAllProducts() throws Exception {

		List<Product> returnListProduct = new ArrayList<Product>();

		String query = "SELECT " 
				+ "CODIGOCOMPANIA, CODIGOARTICULO, DESCRIPCIONCORTA, DESCRIPCIONLARGA, CODIGOPEDIDO, CODIGOAGRUPADOR, CODIGOEQUIVALENTE, CODIGOPRODUCTOUNO, "
				+ "CODIGOPRODUCTODOS, CODIGOAPLICACION, CODIGOCATEGORIA, CODIGOARANCEL, CODIGOPARTIDA, CANTIDADXVEHICULO, PRECIOVENTA, PRECIOFOB, PIEZASDESARME, "
				+ "UNIDADESEMPAQUE, CODIGODESCUENTO, GRUPOPIEZA, CODIGOPRECIO, FACTORCONVERSION, CODIGOBARRA, CODIGOPROVEEDOR, CONTROLXLOTE, CODIGOMARCAARTICULO, "
				+ "UNIDADMEDIDACOMPRA, UNIDADMEDIDAALMACENA, CODIGOLINEA, GRUPOMARCA, CODIGOMARCA, GRUPO03, GRUPO04, GRUPO05, GRUPO06, GRUPO07, GRUPO08, GRUPO09, "
				+ "GRUPO10, GRUPO11, PAGAIVA, IMPUESTOVENTA, CODIGOBARRACAJA, ESTADO, USUARIOINCLUSION, FECHAINCLUSION, HORAINCLUSION, USUARIOMODIFICACION, "
				+ "FECHAMODIFICACION, HORAMODIFICACION "
				+ "FROM " 
				+ "    " + CollectionScheme.SchemeInventario + ".INV_MAESTRO_PRODUCTO_GLOBAL ";
		try {

			AuditLogService.SaveLogDetail("GetAllProducts",query,Guid);
			
			returnListProduct = this.connection.createNativeQuery(query, Product.class).getResultList();

		} catch (Exception e) {
			throw e;
		}

		return returnListProduct;
	}

	@SuppressWarnings("unchecked")
	public List<Product> GetLatestUpdatedProduct(int daysnumber) throws Exception {
		List<Product> result = new ArrayList<Product>();
		Query q = null;
		Integer fromDate = DateTimeHelper.CastDateToNumber(DateTimeHelper.AddDatePartToDate(new Date(), "d", daysnumber*-1), "yyyyMMdd");
		
		String query = "SELECT " 
				+ "CODIGOCOMPANIA, CODIGOARTICULO, DESCRIPCIONCORTA, DESCRIPCIONLARGA, CODIGOPEDIDO, CODIGOAGRUPADOR, CODIGOEQUIVALENTE, CODIGOPRODUCTOUNO, "
				+ "CODIGOPRODUCTODOS, CODIGOAPLICACION, CODIGOCATEGORIA, CODIGOARANCEL, CODIGOPARTIDA, CANTIDADXVEHICULO, PRECIOVENTA, PRECIOFOB, PIEZASDESARME, "
				+ "UNIDADESEMPAQUE, CODIGODESCUENTO, GRUPOPIEZA, CODIGOPRECIO, FACTORCONVERSION, CODIGOBARRA, CODIGOPROVEEDOR, CONTROLXLOTE, CODIGOMARCAARTICULO, "
				+ "UNIDADMEDIDACOMPRA, UNIDADMEDIDAALMACENA, CODIGOLINEA, GRUPOMARCA, CODIGOMARCA, GRUPO03, GRUPO04, GRUPO05, GRUPO06, GRUPO07, GRUPO08, GRUPO09, "
				+ "GRUPO10, GRUPO11, PAGAIVA, IMPUESTOVENTA, CODIGOBARRACAJA, ESTADO, USUARIOINCLUSION, FECHAINCLUSION, HORAINCLUSION, USUARIOMODIFICACION, "
				+ "FECHAMODIFICACION, HORAMODIFICACION "
				+ "FROM " 
				+ "    " + CollectionScheme.SchemeInventario + ".INV_MAESTRO_PRODUCTO_GLOBAL "
				+ "WHERE "
				+ "    FECHAMODIFICACION >= ?1";
		try {

			q = this.connection.createNativeQuery(query, Product.class);
			q.setParameter(1, fromDate);
			
			AuditLogService.SaveLogDetail("GetLatestUpdatedProduct",query,Guid);
			
			result = q.getResultList();

		} catch (Exception e) {
			throw e;
		}

		return result;
	}

	public Product GetProduct(String codigoCompania, String codigoArticulo) throws Exception {
		Product product = null;
		Query q = null;
		
		String query = "SELECT " 
				+ "CODIGOCOMPANIA, CODIGOARTICULO, DESCRIPCIONCORTA, DESCRIPCIONLARGA, CODIGOPEDIDO, CODIGOAGRUPADOR, CODIGOEQUIVALENTE, CODIGOPRODUCTOUNO, "
				+ "CODIGOPRODUCTODOS, CODIGOAPLICACION, CODIGOCATEGORIA, CODIGOARANCEL, CODIGOPARTIDA, CANTIDADXVEHICULO, PRECIOVENTA, PRECIOFOB, PIEZASDESARME, "
				+ "UNIDADESEMPAQUE, CODIGODESCUENTO, GRUPOPIEZA, CODIGOPRECIO, FACTORCONVERSION, CODIGOBARRA, CODIGOPROVEEDOR, CONTROLXLOTE, CODIGOMARCAARTICULO, "
				+ "UNIDADMEDIDACOMPRA, UNIDADMEDIDAALMACENA, CODIGOLINEA, GRUPOMARCA, CODIGOMARCA, GRUPO03, GRUPO04, GRUPO05, GRUPO06, GRUPO07, GRUPO08, GRUPO09, "
				+ "GRUPO10, GRUPO11, PAGAIVA, IMPUESTOVENTA, CODIGOBARRACAJA, ESTADO, USUARIOINCLUSION, FECHAINCLUSION, HORAINCLUSION, USUARIOMODIFICACION, "
				+ "FECHAMODIFICACION, HORAMODIFICACION " 
				+ "FROM " 
				+ "    " + CollectionScheme.SchemeInventario + ".INV_MAESTRO_PRODUCTO_GLOBAL "
				+ "WHERE "
				+ "    CODIGOCOMPANIA = ?1"
				+ "    AND CODIGOARTICULO = ?2";
		try {

			q = this.connection.createNativeQuery(query, Product.class);
			q.setParameter(1, codigoCompania);
			q.setParameter(2, codigoArticulo);
			
			AuditLogService.SaveLogDetail("GetProduct",query,Guid);
			
			@SuppressWarnings("unchecked")
			List<Product> result = q.getResultList();
			
			if (result != null && result.size() > 0) {
				product = result.get(0);
			}

		} catch (Exception e) {
			throw e;
		}

		return product;
	}

	@SuppressWarnings("unchecked")
	public List<ProductExistence> GetBranchStock(String compania, String sucursal, String producto) throws Exception {
		Query q = null;
		List<ProductExistence> result = null;

		String query = "WITH CTE AS (" 
				+ "SELECT " 
				+ "    GL.COMPANIA, GL.SUCURSAL, GL.BODEGA, GL.LINEA, GL.ARTICULO, GL.CANT_DISPONIBLE " 
				+ "FROM " 
				+ "    " + CollectionScheme.SchemeInventario + ".INV_EXIST_GLOBAL GL " 
				+ "WHERE " 
				+ "    GL.COMPANIA = ?1 AND GL.SUCURSAL = ?2 AND GL.ARTICULO = ?3 AND GL.CANT_DISPONIBLE > 0 " 
				+ ") " 
				+ "SELECT " 
				+ "    EXT.COMPANIA AS codigoCompania,"
				+ "    EXT.SUCURSAL AS codigoSucursal,"
				+ "    EXT.BODEGA AS codigoBodega,"
				+ "    EXT.LINEA AS codigoLinea,"
				+ "    EXT.ARTICULO AS codigoArticulo,"
				+ "    MP.DESCRIPCIONCORTA AS descripcionArticulo,"
				+ "    EXT.CANT_DISPONIBLE AS cantidadDisponible,"
				+ "    D03.BSUBL00 AS ubicacion,"
				+ "    TM.ORDEN AS tipoBodega "  
				+ "FROM " 
				+ "    CTE EXT INNER JOIN " + CollectionScheme.SchemeInventario + ".INV_MAESTRO_PRODUCTO_GLOBAL MP " 
				+ "        ON EXT.COMPANIA = MP.CODIGOCOMPANIA AND EXT.ARTICULO = MP.CODIGOARTICULO " 
				+ "    LEFT OUTER JOIN " + CollectionScheme.SchemeInventario + ".INVD03 D03 " 
				+ "        ON EXT.COMPANIA = D03.BCOMPAN AND EXT.SUCURSAL = D03.BSUCURS AND EXT.BODEGA = D03.BBODEGA "
				+ "        AND EXT.ARTICULO = D03.BINOPAR AND EXT.LINEA = D03.BDEPART " 
				+ "    LEFT OUTER JOIN " + CollectionScheme.SchemeInventario + ".TABMUL TM " 
				+ "        ON TM.CODIDE = EXT.BODEGA AND TM.CODTAB = '03'";
		try {

			q = this.connection.createNativeQuery(query, ProductExistence.class);
			q.setParameter(1, compania);
			q.setParameter(2, sucursal);
			q.setParameter(3, producto);
			
			AuditLogService.SaveLogDetail("GetBranchStock",query,Guid);
			
			result = q.getResultList();

		} catch (Exception e) {
			throw e;
		}

		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductExistence> GetCompanyStockByProduct(String compania, String producto) throws Exception {
		Query q = null;
		List<ProductExistence> result = null;

		String query = "WITH CTE AS (" 
				+ "SELECT " 
				+ "    GL.COMPANIA, GL.SUCURSAL, GL.BODEGA, GL.LINEA, GL.ARTICULO, GL.CANT_DISPONIBLE " 
				+ "FROM " 
				+ "    " + CollectionScheme.SchemeInventario + ".INV_EXIST_GLOBAL GL " 
				+ "WHERE " 
				+ "    GL.COMPANIA = ?1 AND GL.ARTICULO = ?2 AND GL.CANT_DISPONIBLE > 0 " 
				+ ") " 
				+ "SELECT " 
				+ "    EXT.COMPANIA AS codigoCompania,"
				+ "    EXT.SUCURSAL AS codigoSucursal,"
				+ "    EXT.BODEGA AS codigoBodega,"
				+ "    EXT.LINEA AS codigoLinea,"
				+ "    EXT.ARTICULO AS codigoArticulo,"
				+ "    MP.DESCRIPCIONCORTA AS descripcionArticulo,"
				+ "    EXT.CANT_DISPONIBLE AS cantidadDisponible,"
				+ "    D03.BSUBL00 AS ubicacion,"
				+ "    TM.ORDEN AS tipoBodega "  
				+ "FROM " 
				+ "    CTE EXT INNER JOIN " + CollectionScheme.SchemeInventario + ".INV_MAESTRO_PRODUCTO_GLOBAL MP " 
				+ "        ON EXT.COMPANIA = MP.CODIGOCOMPANIA AND EXT.ARTICULO = MP.CODIGOARTICULO " 
				+ "    LEFT OUTER JOIN " + CollectionScheme.SchemeInventario + ".INVD03 D03 " 
				+ "        ON EXT.COMPANIA = D03.BCOMPAN AND EXT.SUCURSAL = D03.BSUCURS AND EXT.BODEGA = D03.BBODEGA "
				+ "        AND EXT.ARTICULO = D03.BINOPAR AND EXT.LINEA = D03.BDEPART " 
				+ "    LEFT OUTER JOIN " + CollectionScheme.SchemeInventario + ".TABMUL TM " 
				+ "        ON TM.CODIDE = EXT.BODEGA AND TM.CODTAB = '03'";
		
		try {

			q = this.connection.createNativeQuery(query, ProductExistence.class);
			q.setParameter(1, compania);
			q.setParameter(2, producto);
			
			AuditLogService.SaveLogDetail("GetCompanyStockByProduct",query,Guid);
			
			result = q.getResultList();

		} catch (Exception e) {
			throw e;
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public ProductExistence GetProductStock(String compania, String sucursal, String bodega, String producto) throws Exception {
		Query q = null;
		ProductExistence result = null;

		String query = "WITH CTE AS (" 
				+ "SELECT " 
				+ "    GL.COMPANIA, GL.SUCURSAL, GL.BODEGA, GL.LINEA, GL.ARTICULO, GL.CANT_DISPONIBLE " 
				+ "FROM " 
				+ "    " + CollectionScheme.SchemeInventario + ".INV_EXIST_GLOBAL GL " 
				+ "WHERE " 
				+ "    GL.COMPANIA = ?1 AND GL.SUCURSAL = ?2 AND GL.ARTICULO = ?3 AND GL.BODEGA = ?4" 
				+ ") " 
				+ "SELECT " 
				+ "    EXT.COMPANIA AS codigoCompania,"
				+ "    EXT.SUCURSAL AS codigoSucursal,"
				+ "    EXT.BODEGA AS codigoBodega,"
				+ "    EXT.LINEA AS codigoLinea,"
				+ "    EXT.ARTICULO AS codigoArticulo,"
				+ "    MP.DESCRIPCIONCORTA AS descripcionArticulo,"
				+ "    EXT.CANT_DISPONIBLE AS cantidadDisponible,"
				+ "    D03.BSUBL00 AS ubicacion,"
				+ "    TM.ORDEN AS tipoBodega " 
				+ "FROM " 
				+ "    CTE EXT INNER JOIN " + CollectionScheme.SchemeInventario + ".INV_MAESTRO_PRODUCTO_GLOBAL MP " 
				+ "        ON EXT.COMPANIA = MP.CODIGOCOMPANIA AND EXT.ARTICULO = MP.CODIGOARTICULO " 
				+ "    LEFT OUTER JOIN " + CollectionScheme.SchemeInventario + ".INVD03 D03 " 
				+ "        ON EXT.COMPANIA = D03.BCOMPAN AND EXT.SUCURSAL = D03.BSUCURS AND EXT.BODEGA = D03.BBODEGA AND EXT.ARTICULO = D03.BINOPAR AND EXT.LINEA = D03.BDEPART " 
				+ "    LEFT OUTER JOIN " + CollectionScheme.SchemeInventario + ".TABMUL TM " 
				+ "        ON TM.CODIDE = EXT.BODEGA AND TM.CODTAB = '03'";
		try {

			q = this.connection.createNativeQuery(query, ProductExistence.class);
			q.setParameter(1, compania);
			q.setParameter(2, sucursal);
			q.setParameter(3, producto);
			q.setParameter(4, bodega);
			
			AuditLogService.SaveLogDetail("GetProductStock",query,Guid);
			
			List<ProductExistence> products = q.getResultList();
			
			if (products != null && products.size() > 0) {
				result = products.get(0);
				
				if (result != null) {
					List<ProductoRelacionados> relatedProducts = GetRelatedProduct(compania, producto);
					if (relatedProducts != null && relatedProducts.size() > 0) {
						// Por cada uno de los productos obtener la existencia
						List<String> distinctProduct = relatedProducts
								.stream()
								.map(m -> m.getCodigoArticulo())
								.collect(Collectors.toList());
						
						List<InvExistGlobal> invExistGlobalList = this.getProductExistenceTotal(
								compania, 
								sucursal, 
								result.getCodigoLinea(), 
								bodega, 
								distinctProduct
								);
						
						if (invExistGlobalList != null && invExistGlobalList.size() > 0) {
							for (Iterator<ProductoRelacionados> iterator = relatedProducts.iterator(); iterator.hasNext();) {
								ProductoRelacionados prod = (ProductoRelacionados) iterator.next();
								
								List<InvExistGlobal> tmpList = invExistGlobalList.stream()
									.filter(x -> x.getArticulo().trim().equals(prod.getCodigoArticulo().trim()))
									.collect(Collectors.toList());
								
								if (tmpList != null && tmpList.size() > 0) {
									prod.setExistencia(tmpList.get(0).getExistencia());
								}
								
							}
						}
						
						result.setProductoRelacionado(relatedProducts);	
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return result;
	}
	
	@SuppressWarnings("unchecked")
	private List<ProductoRelacionados> GetRelatedProduct(String compania, String producto) {
		Query q = null;
		List<ProductoRelacionados> result = null;
		String strQuery;
		
		try {
			 strQuery = "SELECT " 
					+ "    CODIGOARTICULO, DESCRIPCIONCORTA, DESCRIPCIONLARGA, CODIGOLINEA " 
					+ "FROM " 
					+ "    " + CollectionScheme.SchemeInventario + ".INV_MAESTRO_PRODUCTO_GLOBAL " 
					+ "WHERE " 
					+ "    CODIGOCOMPANIA = ?1 " 
					+ "START WITH " 
					+ "    CODIGOARTICULO = ?2 " 
					+ "CONNECT BY NOCYCLE PRIOR " 
					+ "    CODIGOEQUIVALENTE = CODIGOARTICULO " 
					+ "ORDER SIBLINGS BY " 
					+ "    CODIGOARTICULO ASC";
			
			q = this.connection.createNativeQuery(strQuery, ProductoRelacionados.class);
			q.setParameter(1, compania);
			q.setParameter(2, producto);
			
			AuditLogService.SaveLogDetail("GetRelatedProduct",strQuery,Guid);
			
			result = q.getResultList();

		} catch (Exception ex) {
			throw ex;
		}

		return result;
	}
	
	public Invd35 getBillInformation(String doc, String producto,String compan,String sucur,String fecha, String bodega) throws Exception {
		Query q = null;
		Invd35 result = null;
		String strQuery;
		
		try {
			 strQuery = "select COMPAN, SUCURS, DEPART, BODEGA, TIPOMO, TIPOMV, DOCUME," + 
					"  FECHAM, HISECUE, NPARTE, ISTAT2, COSTGA, COSTUA, EXISTA, VALORG," + 
					"  VALORU, CANTID, CANTIDD, CANVEN, CANVEND, COSTGD, COSTUD, EXISTD," + 
					"  COSGLB, EXISTB, STATUA, TIPOCA, MOTIVO, REFERE, HORAM, PANTAL," + 
					"  HECHOP, NPROGR, VENDED, CVCANAL, CVENDED, CLCLIE, CLNOMB, TIPOFA," + 
					"  ISTAT1, TIPOFD, CONDPAGO, DESCUE, IMPVENTA, IMPUES, IMPISC," + 
					"  PRECIO, PRECIOUF, CODMONEDA, HITIPPREC, HITIPDESC, PREDES, VALORISC," + 
					"  VALORDESCV, VALORDESCI, TFACTU, TDESCU, TIGV, TISC, TCOSTO," + 
					"  TFACTUF, TDESCUF, TIGVF, TISCF, TCOSTOF, TCOST1, NOTELF, ISTAT4," + 
					"  ISTAT5, ISTAT6, FECHAA, VIAAPL, USUAPL, HORAPL, NLIQUI, NCAJA," + 
					"  NFACTU, NPEDID, NOMARC, TIPOTR, SUCDES, DEPARD, TIPODO, CIAJDE," + 
					"  UNINEG, CTAOBJ, CTASUB, NBATCH, USUAIN, HORAIN, FECHIN, STATIN," + 
					"  NBATCV, USUACV, HORACV, FECHCV, STATCV, INMCU, INMCU2, INNUMB," + 
					"  INKCO, INDCT, INDOC, INICU, INICUT, INSBL, INSBLT, INDOCO, INDCTO," + 
					"  INITM, INLITM, INAITM, HLOTE, HUMEDIDA, HLINEA, HGRUPO01, HGRUPO02," + 
					"  HGRUPO03, HGRUPO04, HGRUPO05, HGRUPO06, HGRUPO07, HGRUPO08," + 
					"  HGRUPO09, HGRUPO10, HCODPROMO, HCODCOMBO, HIID, HICANTID, HDEPTOGEO," + 
					"  HMUNICIPIO, HAREACOMER, HREGION, HGRUPOCLTE, HZONACLIE, HRUTACLIE," + 
					"  HSCUL00NL, ISTA11, ISTA12, ISTA13, ISTA14, IFORMP, IDESCP, IUSUAR," + 
					"  IHORAR, IFECHR, IUSUAE, IHORAE, IFECHE, IUSUAD, CLAVEA, ISTAT3," + 
					"  ISTAT7, ISTAT8, ISTAT9, ISTADI, ISTAOC from " + CollectionScheme.SchemeInventario + ".invd35 " + 
					"  WHERE " + 
					"  Docume = ?1" + 
					"  and tipomo = '21'" + 
					"  and nparte = ?2" + 
					"  and compan = ?3" + 
					"  and sucurs = ?4" +
					"  and fecham = ?5"
					+ "  and BODEGA = ?6"
					+ "Limit 1";
			
			q = this.connection.createNativeQuery(strQuery, Invd35.class);
			q.setParameter(1, doc);
			q.setParameter(2, producto);
			q.setParameter(3, compan);
			q.setParameter(4, sucur);
			q.setParameter(5, fecha);
			q.setParameter(6, bodega);
			
			AuditLogService.SaveLogDetail("getBillInformation",strQuery,Guid);
			
			result = (Invd35) q.getSingleResult();

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("No se encontro el articulo asociado al documento");
		}

		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<GenericValidation> validateProductState(String compania, String sucursal,String bodega, String producto) throws Exception {
		Query q = null;
		List<GenericValidation> result = null;

		String query = "select Binopar CustomString from "+ CollectionScheme.SchemeInventario +".invd03 " + 
				" where" + 
				" BCompan =?1" + 
				" and BSucurs =?2" + 
				" and BBodega = ?3" + 
				" and Binopar = ?4" + 
				" and BSTATU1 = '9'" + 
				" limit 1";
		try {

			q = this.connection.createNativeQuery(query, ProductExistence.class);
			q.setParameter(1, compania);
			q.setParameter(2, sucursal);
			q.setParameter(3, bodega);
			q.setParameter(4, producto);
			
			AuditLogService.SaveLogDetail("validateProductState",query,Guid);
			
			result = q.getResultList();

		} catch (Exception e) {
			throw e;
		}

		return result;
	}

}
