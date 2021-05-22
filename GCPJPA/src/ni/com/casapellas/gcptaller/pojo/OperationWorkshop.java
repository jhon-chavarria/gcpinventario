/**
 * 
 */
package ni.com.casapellas.gcptaller.pojo;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Talleres
 * Objetivo       :  
 * Fecha Creacion :  05/02/2015 18:45:30
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */

public class OperationWorkshop {
	private String CodCompania;
	private String CodTaller;
	private String CodOperacional;
	private String Descripcion;
	private String Orden;
	private String Estado;
	private String Defecto;
	private String AreaAsesor;
	private String AreaMecanico;
	private String AreaAT;
	
	private String CodLineaProduccion;
	private String CodTurno;
	private String HoraInicio;
	private String HoraFin;
	
	private String DescLineaProduccion;
	private String DescTurno;
	
	private String RecepcionVariado;
	
	public String getCodLineaProduccion() {
		return CodLineaProduccion;
	}
	public void setCodLineaProduccion(String codLineaProduccion) {
		CodLineaProduccion = codLineaProduccion;
	}
	public String getCodTurno() {
		return CodTurno;
	}
	public void setCodTurno(String codTurno) {
		CodTurno = codTurno;
	}
	public String getHoraInicio() {
		return HoraInicio;
	}
	public void setHoraInicio(String horaInicio) {
		HoraInicio = horaInicio;
	}
	public String getHoraFin() {
		return HoraFin;
	}
	public void setHoraFin(String horaFin) {
		HoraFin = horaFin;
	}
	public String getDescLineaProduccion() {
		return DescLineaProduccion;
	}
	public void setDescLineaProduccion(String descLineaProduccion) {
		DescLineaProduccion = descLineaProduccion;
	}
	public String getDescTurno() {
		return DescTurno;
	}
	public void setDescTurno(String descTurno) {
		DescTurno = descTurno;
	}
	public String getAreaAsesor() {
		return AreaAsesor;
	}
	public void setAreaAsesor(String areaAsesor) {
		AreaAsesor = areaAsesor;
	}
	public String getAreaMecanico() {
		return AreaMecanico;
	}
	public void setAreaMecanico(String areaMecanico) {
		AreaMecanico = areaMecanico;
	}
	public String getDefecto() {
		return Defecto;
	}
	public void setDefecto(String defecto) {
		Defecto = defecto;
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
	public String getCodOperacional() {
		return CodOperacional;
	}
	public void setCodOperacional(String codOperacional) {
		CodOperacional = codOperacional;
	}
	public String getAreaAT() {
		return AreaAT;
	}
	public void setAreaAT(String areaAT) {
		AreaAT = areaAT;
	}
	public String getRecepcionVariado() {
		return RecepcionVariado;
	}
	public void setRecepcionVariado(String recepcionVariado) {
		RecepcionVariado = recepcionVariado;
	}
	
	
}
