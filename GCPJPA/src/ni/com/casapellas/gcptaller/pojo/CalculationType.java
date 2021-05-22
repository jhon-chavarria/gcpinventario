package ni.com.casapellas.gcptaller.pojo;

public class CalculationType {
	private String CodCompania;
	private String CodTaller;
	private String CodTipoCalculo;
	private String Descripcion;
	private String Orden;
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
	public String getCodTipoCalculo() {
		return CodTipoCalculo;
	}
	public void setCodTipoCalculo(String codTipoCalculo) {
		CodTipoCalculo = codTipoCalculo;
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
}
