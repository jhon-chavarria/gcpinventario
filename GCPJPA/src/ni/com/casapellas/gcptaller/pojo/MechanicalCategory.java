package ni.com.casapellas.gcptaller.pojo;

public class MechanicalCategory {
	private String CodCompania;
	private String CodTaller;
	private String CodMarca;
	private String CodModelo;
	private String CodCategoriaMec;
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
	public String getCodMarca() {
		return CodMarca;
	}
	public void setCodMarca(String codMarca) {
		CodMarca = codMarca;
	}
	public String getCodModelo() {
		return CodModelo;
	}
	public void setCodModelo(String codModelo) {
		CodModelo = codModelo;
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
	public String getCodCategoriaMec() {
		return CodCategoriaMec;
	}
	public void setCodCategoriaMec(String codCategoriaMec) {
		CodCategoriaMec = codCategoriaMec;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
}
