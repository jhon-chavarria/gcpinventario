/**
 * 
 */
package ni.com.casapellas.gcptaller.pojo;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Talleres
 * Objetivo       :  
 * Fecha Creacion :  11/02/2015 10:50:10
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */

public class TimeIntervals {

	private String CodCompania;
	private String CodTaller;
	private String TipoEvento;
	private String Evento;
	private int TiempoEvento;
	private int TiempoIntermedio; 
	private String UnidadTiempo;
	private String Estado;
	
	//Variables Secundarias
	private String DescTipoEvento;
	private String DescTaller;
	private String DescEstado;
	
	private String DescEvento;
	
	public String getDescTaller() {
		return DescTaller;
	}
	public void setDescTaller(String descTaller) {
		DescTaller = descTaller;
	}
	public String getDescEstado() {
		return DescEstado;
	}
	public void setDescEstado(String descEstado) {
		DescEstado = descEstado;
	}
	public String getCodCompania() {
		return CodCompania;
	}
	public void setCodCompania(String codCompania) {
		CodCompania = codCompania;
	}
	public String getCodTaller() {
		return CodTaller;
	}
	public void setCodTaller(String codTaller) {
		CodTaller = codTaller;
	}
	public String getTipoEvento() {
		return TipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		TipoEvento = tipoEvento;
	}
	public String getEvento() {
		return Evento;
	}
	public void setEvento(String evento) {
		Evento = evento;
	}
	public int getTiempoEvento() {
		return TiempoEvento;
	}
	public void setTiempoEvento(int tiempoEvento) {
		TiempoEvento = tiempoEvento;
	}
	public int getTiempoIntermedio() {
		return TiempoIntermedio;
	}
	public void setTiempoIntermedio(int tiempoIntermedio) {
		TiempoIntermedio = tiempoIntermedio;
	}
	public String getUnidadTiempo() {
		return UnidadTiempo;
	}
	public void setUnidadTiempo(String unidadTiempo) {
		UnidadTiempo = unidadTiempo;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getDescTipoEvento() {
		return DescTipoEvento;
	}
	public void setDescTipoEvento(String descTipoEvento) {
		DescTipoEvento = descTipoEvento;
	}
	public String getDescEvento() {
		return DescEvento;
	}
	public void setDescEvento(String descEvento) {
		DescEvento = descEvento;
	}
	
}
