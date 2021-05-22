package ni.com.casapellas.rest.erp.gcpfmu;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import ni.com.casapellas.ejb.erp.inventario.inventariofisico.inventoryavailability.InventoryAvailabilityBl;
import ni.com.casapellas.erp.gcpfmu.ClsBillManager;
import ni.com.casapellas.erp.gcpfmu.ClsCashManager;
import ni.com.casapellas.erp.gcpfmu.ClsFMUCatalog;
import ni.com.casapellas.erp.gcpfmu.ClsFMUUserManager;
import ni.com.casapellas.erp.gcpfmu.ClsFmuAdmin;
import ni.com.casapellas.erp.gcpfmu.ClsOrderManager;
import ni.com.casapellas.erp.gcpfmu.ClsSystemLogs;
import ni.com.casapellas.erp.inventario.pojo.AvailabilityWineryInventory;
import ni.com.casapellas.gcpfmu.pojo.AppSetting;
import ni.com.casapellas.gcpfmu.pojo.BillHeader;
import ni.com.casapellas.gcpfmu.pojo.BillSequence;
import ni.com.casapellas.gcpfmu.pojo.Brand;
import ni.com.casapellas.gcpfmu.pojo.BrandDiscount;
import ni.com.casapellas.gcpfmu.pojo.CLientBrandDiscount;
import ni.com.casapellas.gcpfmu.pojo.ClientCreditInfo;
import ni.com.casapellas.gcpfmu.pojo.ClientExchangeRatesCatalog;
import ni.com.casapellas.gcpfmu.pojo.DeliveryDeadlines;
import ni.com.casapellas.gcpfmu.pojo.Device;
import ni.com.casapellas.gcpfmu.pojo.ErrorLog;
import ni.com.casapellas.gcpfmu.pojo.AuthorizationCode;
import ni.com.casapellas.gcpfmu.pojo.ExchangeRate;
import ni.com.casapellas.gcpfmu.pojo.FMUUtil;
import ni.com.casapellas.gcpfmu.pojo.GeneralCatalog;
import ni.com.casapellas.gcpfmu.pojo.GlobalProductCatalog;
import ni.com.casapellas.gcpfmu.pojo.InitDay;
import ni.com.casapellas.gcpfmu.pojo.InvoiceCustomerExcept;
import ni.com.casapellas.gcpfmu.pojo.JDECatalog;
import ni.com.casapellas.gcpfmu.pojo.Leyend;
import ni.com.casapellas.gcpfmu.pojo.LeyendAttribute;
import ni.com.casapellas.gcpfmu.pojo.Order;
import ni.com.casapellas.gcpfmu.pojo.OrderDetail;
import ni.com.casapellas.gcpfmu.pojo.PostGeneralObject;
import ni.com.casapellas.gcpfmu.pojo.PostObjectReturn;
import ni.com.casapellas.gcpfmu.pojo.Product;
import ni.com.casapellas.gcpfmu.pojo.ProductPrices;
import ni.com.casapellas.gcpfmu.pojo.PromotionalCombo;
import ni.com.casapellas.gcpfmu.pojo.ResponseApi;
import ni.com.casapellas.gcpfmu.pojo.Role;
import ni.com.casapellas.gcpfmu.pojo.RoutePosition;
import ni.com.casapellas.gcpfmu.pojo.Section;
import ni.com.casapellas.gcpfmu.pojo.SellerConfig;
import ni.com.casapellas.gcpfmu.pojo.SyncSection;
import ni.com.casapellas.gcpfmu.pojo.User;
import ni.com.casapellas.gcpfmu.pojo.VersionFMU;
import ni.com.casapellas.geninfo.pojo.CustomerInfo;
import ni.com.casapellas.rest.erp.inventario.responsecodes.ResponseCodes;
import ni.com.casapellas.restful.ResponseCode;


/**
 * 
 * @author Jonathan Chavarria
 *
 */
@Stateless
@Path("/RequestRepuestosRest/")
@Singleton
public class RequestRepuestosRest {
	
	@EJB
	private ClsCashManager clsCashManager;
	
	@EJB
	private ClsBillManager clsBillManager;
	
	@EJB
	private ClsFMUUserManager clsFMUUserManager;
	
	@EJB
	private ClsFMUCatalog clsFMUCatalog;

	@EJB
	private ni.com.casapellas.acces.keyAcces keyAcces;
	
	@EJB
	private InventoryAvailabilityBl inventoryAvailabilityBl;
	
	@EJB
	private ClsOrderManager clsOrderManager;
	
	@EJB
	private ClsFmuAdmin clsFmuAdmin;
	
	/**
	 * FMU CONFIG REST
	 */

	/*@GET
	@Path("/getLines")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLines(@Context HttpHeaders headers) {

		
		
		try {
			List<GeneralCatalog> generalCatalogs = requestRepuestosBl.getCatalogByCode(LINES_ID);
			GenericEntity<List<GeneralCatalog>> listentity = new GenericEntity<List<GeneralCatalog>>(generalCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}*/
	
	@POST
	@Path("/getJDCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJDCatalog(String body, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject productResponse = gson.fromJson(body, PostGeneralObject.class);

		if (productResponse == null) {
			return ResponseCode.status403();
		}
	
		try {
			
			List<JDECatalog> jdeCatalogs = clsFMUCatalog.getJDCatalog(
					productResponse.getParameter1(), 
					productResponse.getParameter2(), 
					productResponse.getParameter3());

			GenericEntity<List<JDECatalog>> listentity = new GenericEntity<List<JDECatalog>>(jdeCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	/*@GET
	@Path("/getCompanies")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompanies(@Context HttpHeaders headers) {
		
		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		try {
			List<GeneralCatalog> generalCatalogs = requestRepuestosBl.getCompanies(COMPANY_ID);
			GenericEntity<List<GeneralCatalog>> listentity = new GenericEntity<List<GeneralCatalog>>(generalCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}*/

	/*@GET
	@Path("/getBranches")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBranches(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		try {
			List<GeneralCatalog> generalCatalogs = requestRepuestosBl.getBranches(BRANCHES_ID);
			GenericEntity<List<GeneralCatalog>> listentity = new GenericEntity<List<GeneralCatalog>>(generalCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	@GET
	@Path("/getZones")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientZones(@Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}
		try {
			List<GeneralCatalog> generalCatalogs = requestRepuestosBl.getCatalogByCode(ZONES_ID, "");
			GenericEntity<List<GeneralCatalog>> listentity = new GenericEntity<List<GeneralCatalog>>(generalCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	@GET
	@Path("/getRoutes") // Bodegas
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRoutes(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		try {
			List<GeneralCatalog> generalCatalogs = requestRepuestosBl.getRoutes();
			GenericEntity<List<GeneralCatalog>> listentity = new GenericEntity<List<GeneralCatalog>>(generalCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	/*\\@GET
	@Path("/getSellers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSellers(@Context HttpHeaders headers) {

		

		try {
			List<Seller> sellers = requestRepuestosBl.getSellers();
			GenericEntity<List<Seller>> listentity = new GenericEntity<List<Seller>>(sellers) {
			};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}*/

	
	/**
	 * Catalog REST
	 * 
	 * @param headers
	 * @return
	 */

	@GET
	@Path("/getMeasureCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMeasureList(@Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		try {
			List<GeneralCatalog> generalCatalogs = clsFMUCatalog.getCatalogByCode(FMUUtil.MEASURE_CATALOG, "");
			GenericEntity<List<GeneralCatalog>> listentity = new GenericEntity<List<GeneralCatalog>>(generalCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	@GET
	@Path("/getInventoryMovementTypeCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMovementType(@Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		try {
			List<GeneralCatalog> generalCatalogs = clsFMUCatalog.getCatalogByCode(FMUUtil.INVENTORY_MOVEMENT_TYPE_CATALOG, "");
			GenericEntity<List<GeneralCatalog>> listentity = new GenericEntity<List<GeneralCatalog>>(generalCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	@GET
	@Path("/getPayConditionCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPayConditions(@Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		try {
			List<GeneralCatalog> generalCatalogs = clsFMUCatalog.getCatalogByCode(FMUUtil.PAY_CONDITION_CATALOG, "");
			GenericEntity<List<GeneralCatalog>> listentity = new GenericEntity<List<GeneralCatalog>>(generalCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	/****************************************************************************************************************
	 * Servicio que muestra la lista de clientes con toda la infoeracion principal a sincronizar en la movil.
	 * --------------------------------------------------------------------------------------------------------------
	 * @param body
	 * @param headers
	 * @return
	 */
	@POST
	@Path("/getZoneClients")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomerList(String body, @Context HttpHeaders headers) {

		Gson gson = new Gson();
		PostGeneralObject productResponse = gson.fromJson(body, PostGeneralObject.class);

		if (productResponse == null) {
			return ResponseCode.status403();
		}
		
		try {
			List<CustomerInfo> lstGS = clsFMUCatalog.getCustomerByCodeList(productResponse.getParameter1(),
					productResponse.getParameter2(), productResponse.getParameter3());
			GenericEntity<List<CustomerInfo>> listentity = new GenericEntity<List<CustomerInfo>>(lstGS) {
			};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	@POST
	@Path("/getProductsCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGlobalProductCatalog(String body, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject productResponse = gson.fromJson(body, PostGeneralObject.class);

		if (productResponse == null) {
			return ResponseCode.status403();
		}

		try {
			List<GlobalProductCatalog> generalCatalogs = clsFMUCatalog
					.getGlobalProductCatalog(productResponse.getParameter1(), productResponse.getParameter2(),
							productResponse.getParameter3());
			GenericEntity<List<GlobalProductCatalog>> listentity = new GenericEntity<List<GlobalProductCatalog>>(
					generalCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	@POST
	@Path("/getProductsByCode")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductsByCode(String body, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject productResponse = gson.fromJson(body, PostGeneralObject.class);

		if (productResponse == null) {
			return ResponseCode.status403();
		}

		try {
			List<GlobalProductCatalog> generalCatalogs = clsFMUCatalog
					.getProductsByCode(productResponse.getParameter1(), productResponse.getParameter2(), 
							productResponse.getParameter3());
			GenericEntity<List<GlobalProductCatalog>> listentity = new GenericEntity<List<GlobalProductCatalog>>(
					generalCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}


	
	@GET
	@Path("/getReturnAndCancelDocumentCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReturnBillTermns(@Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		try {
			List<GeneralCatalog> generalCatalogs = clsFMUCatalog.getCatalogByCode(FMUUtil.RETURN_CANCEL_DOCUMENT_CATALOG, "");
			GenericEntity<List<GeneralCatalog>> listentity = new GenericEntity<List<GeneralCatalog>>(generalCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	@GET
	@Path("/getInventoryCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInventoryType(String body, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		try {
			List<GeneralCatalog> generalCatalogs = clsFMUCatalog.getInventoryTypeCatalog(FMUUtil.INVENTORY_CATALOG);
			GenericEntity<List<GeneralCatalog>> listentity = new GenericEntity<List<GeneralCatalog>>(generalCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}

	}


	@GET
	@Path("/getBrandCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBrands(String body, @Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}
		
		try {
			List<Brand> brands = clsFMUCatalog.getBrands(FMUUtil.BRAND_CATALOG, "");
			GenericEntity<List<Brand>> listentity = new GenericEntity<List<Brand>>(brands) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}

	}
	@GET
	@Path("/getDaysOfTheWeek")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDaysOfTheWeek(@Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		try {
			List<GeneralCatalog> generalCatalogs = clsFMUCatalog.getCatalogByCode(FMUUtil.DAY_WEEK_CATALOG, "");
			GenericEntity<List<GeneralCatalog>> listentity = new GenericEntity<List<GeneralCatalog>>(generalCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	@GET
	@Path("/getClientSegmentCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientSegments(@Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		try {
			List<GeneralCatalog> generalCatalogs = clsFMUCatalog.getCatalogByCode(FMUUtil.CLIENT_SEGMENT_CATALOG, "");
			GenericEntity<List<GeneralCatalog>> listentity = new GenericEntity<List<GeneralCatalog>>(generalCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	@GET
	@Path("/getClientExchangeRatesCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTypePrices(@Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		try {
			List<ClientExchangeRatesCatalog> typePrices = clsFMUCatalog.getTypePrices(FMUUtil.TYPE_PRICES_CATALOG_ID, "");
			GenericEntity<List<ClientExchangeRatesCatalog>> listentity = new GenericEntity<List<ClientExchangeRatesCatalog>>(
					typePrices) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
		
	}

	@POST
	@Path("/getExchangeRatesCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getExchangeRate(String data, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject responseData = gson.fromJson(data, PostGeneralObject.class);

		if (responseData == null) {
			return ResponseCode.status403();
		}
	
		try {
			List<ExchangeRate> exchangeRates = clsFMUCatalog.getExchangeRate(responseData.getParameter1());
			GenericEntity<List<ExchangeRate>> listentity = new GenericEntity<List<ExchangeRate>>(exchangeRates) {
			};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}

	}

	@GET
	@Path("/getCreditDeadlinesCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDeliveryDeadlines(@Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		try {
			List<DeliveryDeadlines> deliveryDeadlines = clsFMUCatalog.getDeliveryDeadlines();
			GenericEntity<List<DeliveryDeadlines>> listentity = new GenericEntity<List<DeliveryDeadlines>>(
					deliveryDeadlines) {
			};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	@POST
	@Path("/getDocumentSequenceCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBillSequence(String data, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject responseData = gson.fromJson(data, PostGeneralObject.class);

		if (responseData == null) {
			return ResponseCode.status403();
		}

		try {
			List<BillSequence> deliveryDeadlines = clsFMUCatalog.getBillSequence(responseData.getParameter1(),
					responseData.getParameter2(), responseData.getParameter3());
			GenericEntity<List<BillSequence>> listentity = new GenericEntity<List<BillSequence>>(deliveryDeadlines) {
			};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	//Rest que se encarga de obtener los creditos de los clientes (FALL)
	@POST
	@Path("/getClientCreditCodes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientCreditAvailableInfo(String data, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject responseData = gson.fromJson(data, PostGeneralObject.class);

		if (responseData == null) {
			return ResponseCode.status403();
		}
		

		try {
			List<ClientCreditInfo> clientCredits = clsFMUCatalog
					.getClientCreditAvailableInfo(responseData.getParameter1(), responseData.getParameter2());
			GenericEntity<List<ClientCreditInfo>> listentity = new GenericEntity<List<ClientCreditInfo>>(
					clientCredits) {
			};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	/*@POST
	@Path("/getSellerInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSellersInfo(String data, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject response = gson.fromJson(data, PostGeneralObject.class);

		if (response == null) {
			return ResponseCode.status403();
		}

		try {
			
			Seller sellers = requestRepuestosBl.getSellersInfo(response.getParameter1());
			GenericEntity<Seller> listentity = new GenericEntity<Seller>(sellers) {
			};

			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}

	}*/

	@POST
	@Path("/getProductsByCellar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductsByCellarId(String body, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject response = gson.fromJson(body, PostGeneralObject.class);

		if (response == null) {
			return ResponseCode.status403();
		}

		try {
			List<Product> products = clsFMUCatalog.getProductsByCellar(response.getParameter1(),
					response.getParameter2(), response.getParameter3(), response.getParameter4());
			GenericEntity<List<Product>> listentity = new GenericEntity<List<Product>>(products) {
			};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}

	}

	
	@POST
	@Path("/getProductPrices")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPricesByProductIdAndType(String body, @Context HttpHeaders headers) {
		
		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}
		
		Gson gson = new Gson();
		PostGeneralObject response = gson.fromJson(body, PostGeneralObject.class);

		if (response == null) {
			return ResponseCode.status403();
		}

		try {
			List<ProductPrices> products = clsFMUCatalog.getPricesByProductIdAndType(response.getParameter1());
			GenericEntity<List<ProductPrices>> listentity = new GenericEntity<List<ProductPrices>>(products) {
			};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception0
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}

	}

	@POST
	@Path("/getBrandDiscountCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBrandDiscounts(String body, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject response = gson.fromJson(body, PostGeneralObject.class);

		if (response == null) {
			return ResponseCode.status403();
		}

		try {
			List<BrandDiscount> products = clsFMUCatalog.getBrandDiscounts(response.getParameter1());
			GenericEntity<List<BrandDiscount>> listentity = new GenericEntity<List<BrandDiscount>>(products) {

			};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}

	}

	@POST
	@Path("/getClientBrandDiscountCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientsDiscounts(String body, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject response = gson.fromJson(body, PostGeneralObject.class);

		if (response == null) {
			return ResponseCode.status403();
		}

		try {
			List<CLientBrandDiscount> products = clsFMUCatalog.getClientsDiscounts(response.getParameter1());
			GenericEntity<List<CLientBrandDiscount>> listentity = new GenericEntity<List<CLientBrandDiscount>>(
					products) {
			};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	@POST
	@Path("/getPromotionalComboCatalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPromotionalCombo(String body, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject response = gson.fromJson(body, PostGeneralObject.class);

		if (response == null) {
			return ResponseCode.status403();
		}

		try {
			List<PromotionalCombo> promotionalCombos = clsFMUCatalog.getPromotionalCombo(response.getParameter1());
			GenericEntity<List<PromotionalCombo>> listentity = new GenericEntity<List<PromotionalCombo>>(
					promotionalCombos) {
			};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}

	}

	// End catalog

	// Bodega Local

	// End Bodega Local

	@POST
	@Path("/getInventoryAvailability")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInventoryAvailability(String body, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject response = gson.fromJson(body, PostGeneralObject.class);

		if (response == null) {
			return ResponseCode.status403();
		}

		String[] strProductCode = { response.getParameter1() };

		try {
						
			List<AvailabilityWineryInventory> lstAvailabilityWineryInventories = inventoryAvailabilityBl
					.getAvailabilityWineryInventory(strProductCode, response.getParameter2());

			GenericEntity<List<AvailabilityWineryInventory>> listentity = new GenericEntity<List<AvailabilityWineryInventory>>(
					lstAvailabilityWineryInventories) {
			};

			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	/**
	 * User Managment
	 * 
	 * @param headers
	 * @return
	 */
	/*@GET
	@Path("/getUserRoles")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserRoles(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		try {
			List<UserRole> sections = requestRepuestosBl.getUserRoles();
			GenericEntity<List<UserRole>> listentity = new GenericEntity<List<UserRole>>(sections) {
			};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}*/
	
	/**
	 * Do Login
	 * 
	 * @param headers
	 * @return
	 */
	@POST
	@Path("/doLogin")
	@Produces(MediaType.APPLICATION_JSON)
	public Response doLogin(String data, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject responseData = gson.fromJson(data, PostGeneralObject.class);

		if (responseData == null) {
			return ResponseCode.status403();
		}

		try {
			//ni.com.casapellas.gcpfmu.pojo.ResponseApi response = clsFMUUserManager.doLogin("ELOSIS",
				//	"R", "6b57914075219dd9");
			ni.com.casapellas.gcpfmu.pojo.ResponseApi response = clsFMUUserManager.doLogin(responseData.getParameter1(),
				responseData.getParameter2(), responseData.getParameter3());
			return Response.status(201).entity(response).build();
		} catch (Exception e) {
			// TODO: handle exceptio	n
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	

	/*@POST
	@Path("/getSections")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSections(@Context HttpHeaders headers, String data) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}
		
		Gson gson = new Gson();
		PostGeneralObject response = gson.fromJson(data, PostGeneralObject.class);

		if (response == null) {
			return ResponseCode.status403();
		}
		
		try {
			List<ni.com.casapellas.gcpfmu.pojo.Section> sections = clsFMUUserManager.getSections(response.getParameter1());
			GenericEntity<List<ni.com.casapellas.gcpfmu.pojo.Section>> listentity = new GenericEntity<List<ni.com.casapellas.gcpfmu.pojo.Section>>(
					sections) {
			};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	@GET
	@Path("/getRoles")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRoles(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		try {
			List<Role> products = clsFMUUserManager.getRoles();
				GenericEntity<List<Role>> listentity = new GenericEntity<List<Role>>(products) {
			};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}*/
	

	@POST
	@Path("getDevice")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDevice(String data, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject response = gson.fromJson(data, PostGeneralObject.class);

		if (response == null) {
			return ResponseCode.status403();
		}
		
		try {
			Device device = clsFMUUserManager.getDevice(response.getParameter1());
			GenericEntity<Device> listentity = new GenericEntity<Device>(device) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	
	@GET
	@Path("getAppSettings")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAppSetting(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		try {
			List<AppSetting> devices = clsFMUUserManager.getAppSettings();
			GenericEntity<List<AppSetting>> listentity = new GenericEntity<List<AppSetting>>(devices) {
			};
			
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	@GET
	@Path("getActiveVersion")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getActiveVersion(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		try {
			VersionFMU versionFMU = clsFMUUserManager.getActiveVersion();
			GenericEntity<VersionFMU> listentity = new GenericEntity<VersionFMU>(versionFMU) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	

	@POST
	@Path("newDevice")
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDevice(String data, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject responseData = gson.fromJson(data, PostGeneralObject.class);

		if (responseData == null) {
			return ResponseCode.status403();
		}

		try {
			ni.com.casapellas.gcpfmu.pojo.ResponseApi response = clsFMUUserManager.newDevice(
					responseData.getParameter1(), responseData.getParameter2(), responseData.getParameter3());
			return Response.status(201).entity(response).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	/*@POST
	@Path("getUserByDeviceUUID")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByDeviceUUID(String data, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject response = gson.fromJson(data, PostGeneralObject.class);

		if (response == null) {
			return ResponseCode.status403();
		}

		try {
			List<Device> generalCatalogs = requestRepuestosBl.getUserByDeviceUUID(response.getParameter1());
			GenericEntity<List<Device>> listentity = new GenericEntity<List<Device>>(generalCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}*/

	/*@GET
	@Path("/getUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		try {
			List<User> generalCatalogs = clsFMUUserManager.getUsers();
			GenericEntity<List<User>> listentity = new GenericEntity<List<User>>(generalCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}*/

	@GET
	@Path("/getSyncSections")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSyncSections(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		try {
			List<SyncSection> seSyncSections = clsFMUUserManager.getSyncSections();
			GenericEntity<List<SyncSection>> listentity = new GenericEntity<List<SyncSection>>(seSyncSections) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	/**
	 * Testing web Services {@link AvailabilityWineryInventory} lability
	 * 
	 * 
	 * @param headers
	 * @return
	 */
	@GET
	@Path("/checkServerStatus")
	@Produces(MediaType.APPLICATION_JSON)
	public ni.com.casapellas.gcpfmu.pojo.ResponseApi getCheckServerStatus(@Context HttpHeaders headers) {
		ni.com.casapellas.gcpfmu.pojo.ResponseApi response = new ni.com.casapellas.gcpfmu.pojo.ResponseApi();
		response.setError(0);
		response.setMessage("ok");
		return response;
	}

	/**
	 * Bill Action
	 * 
	 */

	@POST
	@Path("/createBillHistory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createBillHistory(String body, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		System.out.println("Entro : " + body);
		Gson gson = new Gson();
		PostGeneralObject response = gson.fromJson(body, PostGeneralObject.class);

		if (response.getBillPostList() == null) {
			return ResponseCode.status403();
		}

		List<BillHeader> billHeaders = response.getBillPostList();
	
		int idJsonLog = ClsSystemLogs.createJsonLog(body);	
		
		try {
			
			List<PostObjectReturn> billPosts = clsBillManager.createBillHistory(idJsonLog, billHeaders);
			GenericEntity<List<PostObjectReturn>> listentity = new GenericEntity<List<PostObjectReturn>>(
					billPosts) {
			};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	/**
	 * Generate random codes
	 * @param headers
	 * @return
	 */
	@POST
	@Path("/getDiscountCodes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDiscountCodes(String body, @Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}
		
		Gson gson = new Gson();
		PostGeneralObject response = gson.fromJson(body, PostGeneralObject.class);
		
		if (response == null) {
			return ResponseCode.status403();
		}
		
		try {
			List<AuthorizationCode> discountCodes = clsFMUCatalog.getDiscountCodes(response.getParameter1(), response.getParameter2());
			GenericEntity<List<AuthorizationCode>> listentity = new GenericEntity<List<AuthorizationCode>>(
					discountCodes) {
			};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	
	@POST
	@Path("/geBillsByCellar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response geBillsBycellar(String body, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject response = gson.fromJson(body, PostGeneralObject.class);

		if (response == null) {
			return ResponseCode.status403();
		}
		
		try {
			//List<BillHeader> billPosts = 		requestRepuestosBl.geBillsBycellar("'00'", "301", "01,02,10", "200");
			List<BillHeader> billPosts = clsBillManager.geBillsByCellar(response.getParameter1(), response.getParameter2(), response.getParameter3(),
					response.getParameter4(), response.getParameter5());
			GenericEntity<List<BillHeader>> listentity = new GenericEntity<List<BillHeader>>(
					billPosts) {
			};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}

	// Metodo que crea los recibos de caja (Todo recibo inicia por aca)
	@POST
	@Path("/createCajaReceipt")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCajaReceipt(String body, @Context HttpHeaders headers) {//Primera

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		//System.out.println("Entro  si " + body);

		Gson gson = new Gson();
		PostGeneralObject response = gson.fromJson(body, PostGeneralObject.class);		
		
		if (response == null) {
			return ResponseCode.status403();
		}
			
		try {
			List<PostObjectReturn> billCajaListPostReturns = clsCashManager.createCajaReceipt(response.getCashBillPosts(),
					response.getCancelReceiptList(), body);
				
			GenericEntity<List<PostObjectReturn>> listentity = new GenericEntity<List<PostObjectReturn>>(
					billCajaListPostReturns) {
			};
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	

	@POST
	@Path("/sendInitDayLogs")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendInitDayLogs(String body, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		InitDay response = gson.fromJson(body, InitDay.class);		
		
		if (response == null) {
			return ResponseCode.status403();
		}
							
	
		try {
			
			ResponseApi responseApi = clsFMUCatalog.sendInitDayLogs(response);	
			GenericEntity<ResponseApi> listentity = new GenericEntity<ResponseApi>(
					responseApi) {};
			
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	
	@POST
	@Path("/sendDevicePosition")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendDevicePosition(String body, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		System.out.println("Entro si : " + body);

		Gson gson = new Gson();
		PostGeneralObject response = gson.fromJson(body, PostGeneralObject.class);		
		
		if (response == null) {
			return ResponseCode.status403();
		}
		
		try {
			
			ResponseApi responseApi = clsFMUCatalog.sendDevicePosition(response.getRoutePositions());	
			GenericEntity<ResponseApi> listentity = new GenericEntity<ResponseApi>(
					responseApi) {};
			
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	
	@POST
	@Path("/getClientProductPrice")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientProductPrice(String body, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		Gson gson = new Gson();
		PostGeneralObject productResponse = gson.fromJson(body, PostGeneralObject.class);

		if (productResponse == null) {
			return ResponseCode.status403();
		}
			
		try {
			
			PostObjectReturn jdeCatalogs = clsFMUCatalog.getClientProductPrice(
					productResponse.getParameter1(), productResponse.getParameter2(),
					productResponse.getParameter3(),
					productResponse.getParameter4(),
					Integer.parseInt(productResponse.getParameter5()),
					productResponse.getParameter6(),
					Integer.parseInt(productResponse.getParameter7())
					);

			GenericEntity<PostObjectReturn> listentity = new GenericEntity<PostObjectReturn>(jdeCatalogs) {
			};
			return Response.status(201).entity(listentity).build();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	@POST
	@Path("/createOrder")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createOrder(String body, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		
		System.out.println(body);
		Gson gson = new Gson();
		PostGeneralObject productResponse = gson.fromJson(body, PostGeneralObject.class);
		
		try {
			List<PostObjectReturn> billCajaListPostReturns = clsOrderManager.createOrder(productResponse.getOrderList(),
					productResponse.getOrderCancelList());
				
			GenericEntity<List<PostObjectReturn>> listentity = new GenericEntity<List<PostObjectReturn>>(
					billCajaListPostReturns) {
			};
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	@POST
	@Path("/getOrders")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrders(String body, @Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		//System.out.println(body);
		Gson gson = new Gson();
		PostGeneralObject productResponse = gson.fromJson(body, PostGeneralObject.class);
		
		try {
			List<Order> billCajaListPostReturns = clsOrderManager.getOrders(Integer.parseInt(productResponse.getParameter1()));
				
			GenericEntity<List<Order>> listentity = new GenericEntity<List<Order>>(
					billCajaListPostReturns) {
			};
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	/**
	 * FMU ADMIN
	 */
	
	@GET
	@Path("/getDevices")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDevices(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		try {
			List<Device> billCajaListPostReturns = clsFmuAdmin.getDevicesList();
				
			GenericEntity<List<Device>> listentity = new GenericEntity<List<Device>>(
					billCajaListPostReturns) {
			};
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	@GET
	@Path("/getSections")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSections(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		try {
			List<Section> billCajaListPostReturns = clsFmuAdmin.getSectionList();
				
			GenericEntity<List<Section>> listentity = new GenericEntity<List<Section>>(
					billCajaListPostReturns) {
			};
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	
	@GET
	@Path("/getRoles")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRoles(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		try {
			List<Role> roles = clsFmuAdmin.getRoleList();
				
			GenericEntity<List<Role>> listentity = new GenericEntity<List<Role>>(
					roles) {
			};
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	
	@GET
	@Path("/getVersions")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVersions(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		try {
			List<VersionFMU> versionFMUs = clsFmuAdmin.getVersions();
				
			GenericEntity<List<VersionFMU>> listentity = new GenericEntity<List<VersionFMU>>(
					versionFMUs) {
			};
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	
	@POST
	@Path("/getSellers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSellers(String body, @Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		System.out.println(body);
		Gson gson = new Gson();
		PostGeneralObject productResponse = gson.fromJson(body, PostGeneralObject.class);
				
		try {
			List<SellerConfig> versionFMUs = clsFmuAdmin.getSellerConfigList(productResponse.getParameter1());
				
			GenericEntity<List<SellerConfig>> listentity = new GenericEntity<List<SellerConfig>>(
					versionFMUs) {
			};
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	
	@GET
	@Path("/getInitDayList")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInitDayList(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		try {
			List<InitDay> versionFMUs = clsFmuAdmin.getInitDayList();
				
			GenericEntity<List<InitDay>> listentity = new GenericEntity<List<InitDay>>(
					versionFMUs) {
			};
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	
	@GET
	@Path("/getErrorLogs")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getErrorLogs(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		try {
			List<ErrorLog> versionFMUs = clsFmuAdmin.getErrorLogs();
				
			GenericEntity<List<ErrorLog>> listentity = new GenericEntity<List<ErrorLog>>(
					versionFMUs) {
			};
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	
	@GET
	@Path("/getOrdersFilter")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrdersFilter(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		
		try {
			List<Order> versionFMUs = clsFmuAdmin.getOrders();
				
			GenericEntity<List<Order>> listentity = new GenericEntity<List<Order>>(
					versionFMUs) {
			};
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	@POST
	@Path("/getOrderDetail")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrderDetail(String body, @Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		Gson gson = new Gson();
		PostGeneralObject productResponse = gson.fromJson(body, PostGeneralObject.class);
		
		try {
			List<OrderDetail> versionFMUs = clsFmuAdmin.getOrderDetail(productResponse.getParameter1(), productResponse.getParameter2());
				
			GenericEntity<List<OrderDetail>> listentity = new GenericEntity<List<OrderDetail>>(
					versionFMUs) {
			};
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	
	@GET
	@Path("/getBranches")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBranches(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		
		try {
			List<GeneralCatalog> versionFMUs = clsFmuAdmin.getBranches();
				
			GenericEntity<List<GeneralCatalog>> listentity = new GenericEntity<List<GeneralCatalog>>(
					versionFMUs) {
			};
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	
	@GET
	@Path("/getLines")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLines(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		
		try {
			List<GeneralCatalog> versionFMUs = clsFmuAdmin.getLines();
				
			GenericEntity<List<GeneralCatalog>> listentity = new GenericEntity<List<GeneralCatalog>>(
					versionFMUs) {
			};
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	
	@GET
	@Path("/getCompanies")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompanies(@Context HttpHeaders headers) {

		//if (!keyAcces.requestAccess(headers)) {
			//return ResponseCode.status403();
		//}

		
		try {
			List<GeneralCatalog> versionFMUs = clsFmuAdmin.getCompanies();
				
			GenericEntity<List<GeneralCatalog>> listentity = new GenericEntity<List<GeneralCatalog>>(
					versionFMUs) {
			};
			return Response.status(201).entity(listentity).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	
	@GET
	@Path("/getLeyendUsd")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLeyendUsd(@Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		try {
			List<Leyend> generalCatalogs = clsFMUCatalog.getLeyendUsd();
			GenericEntity<List<Leyend>> listentity = new GenericEntity<List<Leyend>>(generalCatalogs) {};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	
	@GET
	@Path("/getLeyendAttribute")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLeyendAttribute(@Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		try {
			List<LeyendAttribute> items = clsFMUCatalog.getLeyendAttribute();
			GenericEntity<List<LeyendAttribute>> listentity = new GenericEntity<List<LeyendAttribute>>(items) {};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
	
	@GET
	@Path("/getInvoiceCustomerExcept")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInvoiceCustomerExcept(@Context HttpHeaders headers) {

		if (!keyAcces.requestAccess(headers)) {
			return ResponseCode.status403();
		}

		try {
			List<InvoiceCustomerExcept> items = clsFMUCatalog.getInvoiceCustomerExcept();
			GenericEntity<List<InvoiceCustomerExcept>> listentity = new GenericEntity<List<InvoiceCustomerExcept>>(items) {};
			return Response.status(201).entity(listentity).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseCodes.status201(e.getMessage());
		}
	}
	
}