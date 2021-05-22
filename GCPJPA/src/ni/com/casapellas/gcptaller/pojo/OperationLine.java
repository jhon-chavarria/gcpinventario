/**
 * 
 */
package ni.com.casapellas.gcptaller.pojo;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Talleres
 * Objetivo       :  
 * Fecha Creacion :  05/02/2015 18:48:31
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */

public class OperationLine {
	private String CodCompania;
	private String CodTaller;
	private String CodModalidadOperacional;
	private String CodLineaOperacion;
	private String Descripcion;
	private String Orden;
	private String Estado;
	private int  IntervaloTiempo;
	private String UnidadTiempo;
	private String Defecto;
	
	private String CodModalidadMantenimiento;
	private String CodTipoOrden;
	private String CodSupervisor;
	
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
	public String getCodLineaOperacion() {
		return CodLineaOperacion;
	}
	public void setCodLineaOperacion(String codLineaOperacion) {
		CodLineaOperacion = codLineaOperacion;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getOrden() {
		return Orden;
	}
	public void setOrden(String orden) {
		Orden = orden;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public int getIntervaloTiempo() {
		return IntervaloTiempo;
	}
	public void setIntervaloTiempo(int intervaloTiempo) {
		IntervaloTiempo = intervaloTiempo;
	}
	public String getUnidadTiempo() {
		return UnidadTiempo;
	}
	public void setUnidadTiempo(String unidadTiempo) {
		UnidadTiempo = unidadTiempo;
	}
	public String getDefecto() {
		return Defecto;
	}
	public void setDefecto(String defecto) {
		Defecto = defecto;
	}
	public String getCodModalidadOperacional() {
		return CodModalidadOperacional;
	}
	public void setCodModalidadOperacional(String codModalidadOperacional) {
		CodModalidadOperacional = codModalidadOperacional;
	}
	public String getCodModalidadMantenimiento() {
		return CodModalidadMantenimiento;
	}
	public void setCodModalidadMantenimiento(String codModalidadMantenimiento) {
		CodModalidadMantenimiento = codModalidadMantenimiento;
	}
	public String getCodTipoOrden() {
		return CodTipoOrden;
	}
	public void setCodTipoOrden(String codTipoOrden) {
		CodTipoOrden = codTipoOrden;
	}
	public String getCodSupervisor() {
		return CodSupervisor;
	}
	public void setCodSupervisor(String codSupervisor) {
		CodSupervisor = codSupervisor;
	}
}
