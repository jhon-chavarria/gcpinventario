package ni.com.casapellas.erp.jde.pojo;

/**
 * 
 * @author Luis Fonseca
 *
 */
public class Sucurs {
	private String CodCompania;
	private String CodSucursal;
	private String Descripcion;
	private String TipoSucursal;
	
	public String getCodCompania() {
		return CodCompania;
	}
	public void setCodCompania(String codCompania) {
		CodCompania = codCompania;
	}
	public String getCodSucursal() {
		return CodSucursal;
	}
	public void setCodSucursal(String codSucursal) {
		CodSucursal = codSucursal;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getTipoSucursal() {
		return TipoSucursal;
	}
	public void setTipoSucursal(String tipoSucursal) {
		TipoSucursal = tipoSucursal;
	}
}
