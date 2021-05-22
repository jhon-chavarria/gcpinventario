package ni.com.casapellas.gcptaller.pojo;

public class OrderStatus {
	private String CodCompania;
	private String CodTaller;
	private String CodEstado;
	private String Descripcion;
	private String Orden;
	private String Estado;
	private String PuedeEntregar;
	
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
	public String getCodEstado() {
		return CodEstado;
	}
	public void setCodEstado(String codEstado) {
		CodEstado = codEstado;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getPuedeEntregar() {
		return PuedeEntregar;
	}
	public void setPuedeEntregar(String puedeEntregar) {
		PuedeEntregar = puedeEntregar;
	}
}
