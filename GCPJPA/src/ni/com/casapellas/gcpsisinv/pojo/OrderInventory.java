/**
 * 
 */
package ni.com.casapellas.gcpsisinv.pojo;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Talleres
 * Objetivo       :  
 * Fecha Creacion :  18/02/2015 17:43:04
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */

public class OrderInventory {
	 private int NoPedido;
	 private String FechaPedido;
	 private String CodArticulo;
	 private int CantidadPedida;
	 private String TipoPedido;
	 private String FechaLlegada;
	 private String Estado;
	 private int CantidadRecibida;
	 
	public int getNoPedido() {
		return NoPedido;
	}
	public void setNoPedido(int noPedido) {
		NoPedido = noPedido;
	}
	public String getFechaPedido() {
		return FechaPedido;
	}
	public void setFechaPedido(String fechaPedido) {
		FechaPedido = fechaPedido;
	}
	public String getCodArticulo() {
		return CodArticulo;
	}
	public void setCodArticulo(String codArticulo) {
		CodArticulo = codArticulo;
	}
	public int getCantidadPedida() {
		return CantidadPedida;
	}
	public void setCantidadPedida(int cantidadPedida) {
		CantidadPedida = cantidadPedida;
	}
	public String getTipoPedido() {
		return TipoPedido;
	}
	public void setTipoPedido(String tipoPedido) {
		TipoPedido = tipoPedido;
	}
	public String getFechaLlegada() {
		return FechaLlegada;
	}
	public void setFechaLlegada(String fechaLlegada) {
		FechaLlegada = fechaLlegada;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public int getCantidadRecibida() {
		return CantidadRecibida;
	}
	public void setCantidadRecibida(int cantidadRecibida) {
		CantidadRecibida = cantidadRecibida;
	}
	 
}
