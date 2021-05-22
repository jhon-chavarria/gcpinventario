package ni.com.casapellas.gcptaller.pojo;

/**
 * 
 * @author Luis Fonseca
 *
 */
public class ActivitiesDetailMaintenance {
	private String CodCompania;
	private String CodTaller;
	private String CodMantenimiento;
	private String CodCombustible;
	private String DescActividad;
	private int Orden;
	private String Estado;
	
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
	public String getCodMantenimiento() {
		return CodMantenimiento;
	}
	public void setCodMantenimiento(String codMantenimiento) {
		CodMantenimiento = codMantenimiento;
	}
	public String getCodCombustible() {
		return CodCombustible;
	}
	public void setCodCombustible(String codCombustible) {
		CodCombustible = codCombustible;
	}
	public String getDescActividad() {
		return DescActividad;
	}
	public void setDescActividad(String descActividad) {
		DescActividad = descActividad;
	}
	public int getOrden() {
		return Orden;
	}
	public void setOrden(int orden) {
		Orden = orden;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
}
