package ni.com.casapellas.gcptaller.pojo;

public class IndicatorGroup {
	private String CodGrupo;
	private String Descripcion;
	private String Orden;
	private String Opcional;
	private String Estado;
	private Double DuracionDiagnostico;
	private String GrupoPadre;
	
	public String getCodGrupo() {
		return CodGrupo;
	}
	public void setCodGrupo(String codGrupo) {
		CodGrupo = codGrupo;
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
	public String getOpcional() {
		return Opcional;
	}
	public void setOpcional(String opcional) {
		Opcional = opcional;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getGrupoPadre() {
		return GrupoPadre;
	}
	public void setGrupoPadre(String grupoPadre) {
		GrupoPadre = grupoPadre;
	}
	public Double getDuracionDiagnostico() {
		return DuracionDiagnostico;
	}
	public void setDuracionDiagnostico(Double duracionDiagnostico) {
		DuracionDiagnostico = duracionDiagnostico;
	}
	
}
