package ni.com.casapellas.gcpquiosco.pojo;

import java.io.Serializable;

import javax.persistence.Id;


public class ReciboTicketKey implements Serializable {


	
	private Integer NumeroRecibo;
	private String TipoRecibo;
	private String CodigoCompania;
	private String CodigoSucursal;
	private String TipoTicket;
	private String Identificador2;
	
	public Integer getNumeroRecibo() {
		return NumeroRecibo;
	}
	public void setNumeroRecibo(Integer numeroRecibo) {
		NumeroRecibo = numeroRecibo;
	}
	public String getTipoRecibo() {
		return TipoRecibo;
	}
	public void setTipoRecibo(String tipoRecibo) {
		TipoRecibo = tipoRecibo;
	}
	public String getCodigoCompania() {
		return CodigoCompania;
	}
	public void setCodigoCompania(String codigoCompania) {
		CodigoCompania = codigoCompania;
	}
	public String getCodigoSucursal() {
		return CodigoSucursal;
	}
	public void setCodigoSucursal(String codigoSucursal) {
		CodigoSucursal = codigoSucursal;
	}
	
	
	
	

	public String getTipoTicket() {
		return TipoTicket;
	}
	public void setTipoTicket(String tipoTicket) {
		TipoTicket = tipoTicket;
	}
	public String getIdentificador2() {
		return Identificador2;
	}
	public void setIdentificador2(String identificador2) {
		Identificador2 = identificador2;
	}
	@Override
	public int hashCode() {
		
		 // Start with a non-zero constant. Prime is preferred
	    int result = 31;
	    result = 31 * result + NumeroRecibo;                   // 1 bit   » 32-bit

	    result = 31 * result + (TipoRecibo == null ? 0 : TipoRecibo.hashCode());
	    result = 31 * result + (CodigoCompania == null ? 0 : CodigoCompania.hashCode());
	    result = 31 * result + (CodigoSucursal == null ? 0 :CodigoSucursal.hashCode());
	    result = 31 * result + (TipoTicket == null ? 0 :TipoTicket.hashCode());
	    result = 31 * result + (Identificador2 == null ? 0 :Identificador2.hashCode());
		return result;
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReciboTicket other = (ReciboTicket) obj;
		
		
		if (NumeroRecibo == null) {
			if (other.getNumeroRecibo() != null)
				return false;
		} else if (!NumeroRecibo.equals(other.getNumeroRecibo()))
			return false;
		

		if (TipoRecibo == null) {
			if (other.getTipoRecibo() != null)
				return false;
		} else if (!TipoRecibo.equals(other.getTipoRecibo()))
			return false;
		

		if (CodigoCompania == null) {
			if (other.getCodigoCompania() != null)
				return false;
		} else if (!CodigoCompania.equals(other.getCodigoCompania()))
			return false;
		

		if (CodigoSucursal == null) {
			if (other.getCodigoSucursal() != null)
				return false;
		} else if (!CodigoSucursal.equals(other.getCodigoSucursal()))
			return false;
		
		

		if (TipoTicket == null) {
			if (other.getTipoTicket() != null)
				return false;
		} else if (!TipoTicket.equals(other.getTipoTicket()))
			return false;
		

		if (Identificador2 == null) {
			if (other.getIdentificador2() != null)
				return false;
		} else if (!Identificador2.equals(other.getIdentificador2()))
			return false;
		
		
		
		return true;
	}
	
}
