package ni.com.casapellas.rest.erp.inventario.almacen;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ni.com.casapellas.ejb.erp.util.PagedResult;
import ni.com.casapellas.erp.inventario.almacen.ProductoService;
import ni.com.casapellas.erp.util.AuditMastersBean;
import ni.com.casapellas.gcpinventario.Product;
import ni.com.casapellas.gcpinventario.ProductExistence;
//@Singleton
@Stateless
@LocalBean
// @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ProductBI {

	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;

	ProductoService service = null;
	
	@EJB
	private AuditMastersBean audit;

	public ProductBI() {
	}

	public List<Product> obtenerProductosTodos() throws Exception {
		List<Product> result = new ArrayList<Product>();
		try {

			if (service == null) {
				service = new ProductoService(em,audit.getGuid());
			}
			audit.logAuditDetailRequestEJB("obtenerProductosTodos",audit.getGuid());
			result = service.GetAllProducts();
			audit.logAuditDetailResponseEJB("obtenerProductosTodos",audit.getGuid());
		} catch (Exception e) {
			audit.logAuditDetailErrorEJB(e.getMessage(),audit.getGuid());
			throw e;
		} finally {
			service = null;
		}

		return result;
	}
	
	public PagedResult<Product> obtenerProductosTodos(String pCompany, int pPageNumber, int pPageSize) throws Exception {
		PagedResult<Product> result = null;
		try {

			if (service == null) {
				service = new ProductoService(em,audit.getGuid());
			}
			audit.logAuditDetailRequestEJB("obtenerProductosTodos",audit.getGuid());
			result = service.GetAllProducts(pCompany, pPageNumber, pPageSize);
			audit.logAuditDetailResponseEJB("obtenerProductosTodos",audit.getGuid());
		} catch (Exception e) {
			audit.logAuditDetailErrorEJB(e.getMessage(),audit.getGuid());
			throw e;
		} finally {
			service = null;
		}

		return result;
	}
	

	public List<Product> obtenerUltimosProducto(int daysnumber) throws Exception {
		List<Product> result = new ArrayList<Product>();
		try {

			if (service == null) {
				service = new ProductoService(em,audit.getGuid());
			}
			audit.logAuditDetailRequestEJB("obtenerUltimosProducto",audit.getGuid());
			result = service.GetLatestUpdatedProduct(daysnumber);
			audit.logAuditDetailResponseEJB("obtenerUltimosProducto",audit.getGuid());
		} catch (Exception e) {
			audit.logAuditDetailErrorEJB(e.getMessage(),audit.getGuid());
			throw e;
		} finally {
			service = null;
		}

		return result;
	}

	public Product obtenerProducto(String codigoCompania, String codigoArticulo) throws Exception {

		Product result = null;
		try {

			if (service == null) {
				service = new ProductoService(em,audit.getGuid());
			}
			audit.logAuditDetailRequestEJB("obtenerProducto",audit.getGuid());
			result = service.GetProduct(codigoCompania, codigoArticulo);
			audit.logAuditDetailResponseEJB("obtenerProducto",audit.getGuid());
		} catch (Exception e) {
			audit.logAuditDetailErrorEJB(e.getMessage(),audit.getGuid());
			throw e;
		} finally {
			service = null;
		}

		return result;
	}

	public List<ProductExistence> obtenerExistenciaProducto(String compania, String sucursal, String producto) throws Exception {
		List<ProductExistence> result = new ArrayList<ProductExistence>();
		try {

			if (service == null) {
				service = new ProductoService(em,audit.getGuid());
			}
			audit.logAuditDetailRequestEJB("obtenerExistenciaProducto",audit.getGuid());
			result = service.GetBranchStock(compania, sucursal, producto);
			audit.logAuditDetailResponseEJB("obtenerExistenciaProducto",audit.getGuid());
		} catch (Exception e) {
			audit.logAuditDetailErrorEJB(e.getMessage(),audit.getGuid());
			throw e;
		} finally {
			service = null;
		}

		return result;
	}

	public ProductExistence obtenerExistenciaPorProducto(String compania, String sucursal, String bodega, String producto) throws Exception {
		ProductExistence result = null;
		try {

			if (service == null) {
				service = new ProductoService(em,audit.getGuid());
			}
			audit.logAuditDetailRequestEJB("obtenerExistenciaPorProducto",audit.getGuid());
			result = service.GetProductStock(compania, sucursal, bodega, producto);
			audit.logAuditDetailResponseEJB("obtenerExistenciaPorProducto",audit.getGuid());

		} catch (Exception e) {
			audit.logAuditDetailErrorEJB(e.getMessage(),audit.getGuid());
			throw e;
		} finally {
			service = null;
		}

		return result;

	}
	
	public List<ProductExistence> obtenerExistenciaNacional(String compania, String producto) throws Exception {
		List<ProductExistence> result = new ArrayList<ProductExistence>();
		try {

			if (service == null) {
				service = new ProductoService(em,audit.getGuid());
			}
			audit.logAuditDetailRequestEJB("obtenerExistenciaNacional",audit.getGuid());
			result = service.GetCompanyStockByProduct(compania, producto);
			audit.logAuditDetailResponseEJB("obtenerExistenciaNacional",audit.getGuid());
		} catch (Exception e) {
			audit.logAuditDetailErrorEJB(e.getMessage(),audit.getGuid());
			throw e;
		} finally {
			service = null;
		}

		return result;
	}
}
