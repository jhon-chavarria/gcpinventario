package ni.com.casapellas.gcptaller.pojo;

public class Cylinder {
	private String CodCompania;
	private String CodTaller;
	private String CodCilindro;
	private String Descripcion;
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
	public String getCodCilindro() {
		return CodCilindro;
	}
	public void setCodCilindro(String codCilindro) {
		CodCilindro = codCilindro;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
}
