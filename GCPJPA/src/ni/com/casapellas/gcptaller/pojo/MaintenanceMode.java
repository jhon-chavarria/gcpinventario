package ni.com.casapellas.gcptaller.pojo;

//catalogo de Modalidad de Mantenimiento tabla sottab condicion
//tbcodi = '061'
public class MaintenanceMode {
	private String CodCompania;
	private String CodTaller;
	private String CodModalidadMant;
	private String Descripcion;
	private String CodTipoOrden;
	private String Orden;
	private String Estado;
	
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
	public String getCodModalidadMant() {
		return CodModalidadMant;
	}
	public void setCodModalidadMant(String codModalidadMant) {
		CodModalidadMant = codModalidadMant;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getCodTipoOrden() {
		return CodTipoOrden;
	}
	public void setCodTipoOrden(String codTipoOrden) {
		CodTipoOrden = codTipoOrden;
	}
}
