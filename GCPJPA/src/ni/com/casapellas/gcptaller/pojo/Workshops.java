package ni.com.casapellas.gcptaller.pojo;

//catalogo de talleres tabla sottab condicion
//tbcodi = '012'
public class Workshops {
	private String CodCompania;
	private String CodTaller;
	private String Descripcion;
	private String ClienteGenerico;
	private String CodCompaniaReal;
	
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
	public String getClienteGenerico() {
		return ClienteGenerico;
	}
	public void setClienteGenerico(String clienteGenerico) {
		ClienteGenerico = clienteGenerico;
	}
	public String getCodCompaniaReal() {
		return CodCompaniaReal;
	}
	public void setCodCompaniaReal(String codCompaniaReal) {
		CodCompaniaReal = codCompaniaReal;
	}
}
