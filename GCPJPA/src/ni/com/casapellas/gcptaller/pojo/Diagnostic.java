package ni.com.casapellas.gcptaller.pojo;

public class Diagnostic {
	private String CodCompania;
	private String CodTaller;
	private int NoOrden;
	private String CodGrupo;
	private String CodIndicador;
	private String IndicadorValor;
	private String CodDiagnostico;
	private String DescripDiagnostico;
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
	public String getCodGrupo() {
		return CodGrupo;
	}
	public void setCodGrupo(String codGrupo) {
		CodGrupo = codGrupo;
	}
	public String getCodIndicador() {
		return CodIndicador;
	}
	public void setCodIndicador(String codIndicador) {
		CodIndicador = codIndicador;
	}
	public String getCodDiagnostico() {
		return CodDiagnostico;
	}
	public void setCodDiagnostico(String codDiagnostico) {
		CodDiagnostico = codDiagnostico;
	}
	public String getDescripDiagnostico() {
		return DescripDiagnostico;
	}
	public void setDescripDiagnostico(String descripDiagnostico) {
		DescripDiagnostico = descripDiagnostico;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public int getNoOrden() {
		return NoOrden;
	}
	public void setNoOrden(int noOrden) {
		NoOrden = noOrden;
	}
	public String getIndicadorValor() {
		return IndicadorValor;
	}
	public void setIndicadorValor(String indicadorValor) {
		IndicadorValor = indicadorValor;
	}
	
}
