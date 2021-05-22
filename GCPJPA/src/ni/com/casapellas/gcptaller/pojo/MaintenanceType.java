package ni.com.casapellas.gcptaller.pojo;

//catalogo de Tipo de Mantenimiento tabla sottab condicion
//tbcodi = '064'
public class MaintenanceType {
	private String CodCompania;
	private String CodTaller;
	private String CodTipoMant;
	private String Descripcion;
	private String CodTipoOrden;
	private String TipoCliente;
	private String Orden;
	private String Estado;
	
	private String TipoCombustible;
	
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
	public String getCodTipoMant() {
		return CodTipoMant;
	}
	public void setCodTipoMant(String codTipoMant) {
		CodTipoMant = codTipoMant;
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
	public String getTipoCliente() {
		return TipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		TipoCliente = tipoCliente;
	}
	public String getTipoCombustible() {
		return TipoCombustible;
	}
	public void setTipoCombustible(String tipoCombustible) {
		TipoCombustible = tipoCombustible;
	}
}
