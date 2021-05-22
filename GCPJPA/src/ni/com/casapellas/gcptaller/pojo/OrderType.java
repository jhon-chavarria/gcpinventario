package ni.com.casapellas.gcptaller.pojo;

//catalogo de Tipo de Orden tabla sottab condicion
//tbcodi = '063'
public class OrderType {
	private String CodCompania;
	private String CodTaller;
	private String CodTipoOrden;
	private String Descripcion;
	private String CodIcon;
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
	public String getCodTipoOrden() {
		return CodTipoOrden;
	}
	public void setCodTipoOrden(String codTipoOrden) {
		CodTipoOrden = codTipoOrden;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public void setCodIcon(String codIcon) {
		CodIcon = codIcon;
	}
	public String getCodIcon() {
		return CodIcon;
	}
}
