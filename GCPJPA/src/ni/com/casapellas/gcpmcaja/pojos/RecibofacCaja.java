package ni.com.casapellas.gcpmcaja.pojos;

import java.io.Serializable;
import java.util.Date;

public class RecibofacCaja extends Recibofac implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	   
		   public String getCodigoCompania() {
		    return this.getCodcomp();
		   }

		   public void setCodigoCompania(String CodigoCompania) {
		    this.setCodcomp ( CodigoCompania);
		   }
		 
		   
		   public String getCodigoSucursal() {
		    return this.getCodsuc();
		   }

		   public void setCodigoSucursal(String CodigoSucursal) {
		    this.setCodsuc ( CodigoSucursal);
		   }
		   public int getNoCaja() {
		    return this.getCaid();
		   }

		   public void setNoCaja(int NoCaja) {
		    this.setCaid ( NoCaja);
		   }
		   public String getCodigoUnidadNegocio() {
		    return this.getCodunineg();
		   }

		   public void setCodigoUnidadNegocio(String CodigoUnidadNegocio) {
		    this.setCodunineg ( CodigoUnidadNegocio);
		   }
		   public String getTipoRecibo() {
		    return this.getTiporec();
		   }

		   public void setTipoRecibo(String TipoRecibo) {
		    this.setTiporec ( TipoRecibo);
		   }
		   public int getCodigoCliente() {
		    return this.getCodcli();
		   }

		   public void setCodigoCliente(int CodigoCliente) {
		    this.setCodcli ( CodigoCliente);
		   }

		   public void setFechaFactura(Date FechaFactura) {
		    this.setFecha ( FechaFactura);
		   }
		   public int getHoraFactura() {
		    return this.getHora();
		   }

		   public void setHoraFactura(int HoraFactura) {
		    this.setHora ( HoraFactura);
		   }

	
	

}
