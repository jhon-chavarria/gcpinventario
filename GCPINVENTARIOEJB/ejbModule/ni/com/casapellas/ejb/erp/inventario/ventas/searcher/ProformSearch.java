/**
 * 
 */
package ni.com.casapellas.ejb.erp.inventario.ventas.searcher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ni.com.casapellas.ejb.erp.inventario.util.JAXBHelper;
import ni.com.casapellas.gcpsisinv.pojo.Proform;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Inventario
 * Objetivo       :  
 * Fecha Creacion :  19/01/2015 09:13:01
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */
@Stateless
@LocalBean
public class ProformSearch {
	@PersistenceContext(unitName = "GCPSIADEJPA")
	protected EntityManager em;
	
	/**
	 * @author Luis Fonseca
	 * @param sCompanyCode
	 * @param sWorkshopCode
	 * @param sProformNumber
	 * @param sCustomerCode
	 * @param sChassis
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Proform> getProformList(String sCompanyCode,  
										String sItem)
	{
		List<Proform> lstP = new ArrayList<Proform>();
		
		try
		{
			String sQuery = "";
			JAXBHelper util = new JAXBHelper();
			int iDate = util.getDateToNumeric(new Date());
			
			if(sItem!=null)
				sItem = sItem.trim().replace("'","");
			
			if(JAXBHelper.isNumber(sItem))
			{
				sQuery = "select a.Compan CodCompania, " +
								"a.Depart Linea, " +
								"a.Bodega, " +
								"a.Docume NoProforma, " +
								"a.Client CodCliente, " +
								"Trim(a.Nombre) NombreCliente, " +
								"a.IChasi Chasis, " +
								"a.Cantid Cantidad, " +
								"a.NParte CodItem, " +
								"IDesci DescripcionItem, " +
								"a.Vended CodCortoVendedor, " +
								"a.CVended CodVendedor, " +
								"(Case when Trim(CMoneda) = 'USD' then (Precio * TipoCa) else Precio end) as Precio, " +
								"a.TipoCa TipoCambio, " +
								"a.CMoneda Moneda,  " +
								"a.PImpue PorcImpuesto, " +
								"a.Descue PorcDescuento, " +
								"a.Factur NoFactura, " +
								"a.FechaF FechaFactura, " +
								"a.CantiF CantidadFacturada, " +
								"a.PrecIF PrecioFacturado, " +
								"(a.Cantid - a.Cantif) CantPendienteFact, " +
								"AutMde Modelo, " +
								"AutMar Marca, " +
								"AutPlc Placa, " +
								"tbdesc DescMarca," +
								"NoPresu NoPresupuesto, " +
								"substr(a.fecham, 1, 4) concat '-' concat substr(a.fecham, 5, 2) " +
													   "concat '-' concat substr(a.fecham, 7, 2) FechaProforma " +
						 "from invprof a " +
						 "inner join invd01 on iCompan = a.Compan and " +
						 							 "INoPar = NParte " +
						 "inner join invproc b on a.sucurs = b.sucurs and " +
					 									"a.bodega = b.bodega and " +
					 									"pfdocum = docume and " +
					 									"pffcdoc =  fecham " +
						 "left outer join sotaut on a.client  = clclie and " +
						 							 "autcha = iChasi " +
						 "left outer join sottab on tbespe = AutMar and   " +
						 								  "tbcodi = '034' " +
						 "where a.Compan = '" + sCompanyCode + "' and " +
						 		"pffvencd >= " + iDate + " and " +
						 		"a.StaFac <> 'C' and " +
						 		"(a.Cantid - a.Cantif) <> 0  AND " +
						 		"(a.Client = " + sItem + " or a.Docume = " + sItem + " )";
			}
			else
			{
				sQuery = "select a.Compan CodCompania, " +
								"a.Depart Linea, " +
								"a.Bodega, " +
								"a.Docume NoProforma, " +
								"a.Client CodCliente, " +
								"Trim(a.Nombre) NombreCliente, " +
								"a.IChasi Chasis, " +
								"a.Cantid Cantidad, " +
								"a.NParte CodItem, " +
								"IDesci DescripcionItem, " +
								"a.Vended CodCortoVendedor, " +
								"a.CVended CodVendedor, " +
								"(Case when Trim(CMoneda) = 'USD' then (Precio * TipoCa) else Precio end) as Precio, " +
								"a.TipoCa TipoCambio, " +
								"a.CMoneda Moneda,  " +
								"a.PImpue PorcImpuesto, " +
								"a.Descue PorcDescuento, " +
								"a.Factur NoFactura, " +
								"a.FechaF FechaFactura, " +
								"a.CantiF CantidadFacturada, " +
								"a.PrecIF PrecioFacturado, " +
								"(a.Cantid - a.Cantif) CantPendienteFact, " +
								"AutMde Modelo, " +
								"AutMar Marca, " +
								"AutPlc Placa, " +
								"tbdesc DescMarca," +
								"NoPresu NoPresupuesto, " +
								"substr(a.fecham, 1, 4) concat '-' concat substr(a.fecham, 5, 2) " +
													   "concat '-' concat substr(a.fecham, 7, 2) FechaProforma " +
						 "from invprof a " +
						 "inner join invd01 on iCompan = a.Compan and " +
						 							 "INoPar = a.NParte " +
						 "inner join invproc b on a.sucurs = b.sucurs and " +
						 								"a.bodega = b.bodega and " +
						 								"pfdocum = docume and " +
						 								"pffcdoc =  fecham " +
						 "left outer join sotaut on a.client  = clclie and " +
						 							      "autcha = iChasi " +
						 "left outer join sottab c on tbespe = AutMar and   " +
						 								  "tbcodi = '034' " +
						 "where a.Compan = '" + sCompanyCode + "' and " +
						 	   "pffvencd >= " + iDate + " and " +
						 	   "a.StaFac <> 'C' and " +
						 	   "(a.Cantid - a.Cantif) <> 0 and " +
						 	   "((UPPER(Trim(Nombre)) like '%" +  sItem.trim().toUpperCase().replaceAll(" ", "%' and UPPER(Trim(Nombre)) like '%") + "%') )";
				
			}
			
//			System.out.print(sQuery);
			
			lstP = em.createNativeQuery(sQuery, Proform.class).getResultList();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lstP;
	}
}
