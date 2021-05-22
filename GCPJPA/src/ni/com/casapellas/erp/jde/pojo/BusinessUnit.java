package ni.com.casapellas.erp.jde.pojo;

/**
 * 
 * @author Luis Fonseca
 *
 */
public class BusinessUnit {
	private String CodCompania;
	private String CodSucursal;
	private String CodUnidadNegocio;
	private String CodLineaNegocio;
	private String Descripcion;
	private String TipoUNegocio;
	
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
	public String getCodUnidadNegocio() {
		return CodUnidadNegocio;
	}
	public void setCodUnidadNegocio(String codUnidadNegocio) {
		CodUnidadNegocio = codUnidadNegocio;
	}
	public String getCodLineaNegocio() {
		return CodLineaNegocio;
	}
	public void setCodLineaNegocio(String codLineaNegocio) {
		CodLineaNegocio = codLineaNegocio;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getTipoUNegocio() {
		return TipoUNegocio;
	}
	public void setTipoUNegocio(String tipoUNegocio) {
		TipoUNegocio = tipoUNegocio;
	}
}
