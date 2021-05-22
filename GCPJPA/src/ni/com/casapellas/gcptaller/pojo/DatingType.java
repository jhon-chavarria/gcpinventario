package ni.com.casapellas.gcptaller.pojo;

//catalogo de Tipo de citas en la tabla de sottab
//con la condicion tbcodi = '075'
public class DatingType {
	private String CodCompania;
	private String CodTaller;
	private String CodTipoCita;
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
	public String getCodTipoCita() {
		return CodTipoCita;
	}
	public void setCodTipoCita(String codTipoCita) {
		CodTipoCita = codTipoCita;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}	
	
}
