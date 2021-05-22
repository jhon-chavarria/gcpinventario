package ni.com.casapellas.gcptaller.pojo;

public class DatingObservation {
	private String CodCompania;
	private String CodTaller;
	private int NoCita;
	private int Secuencia;
	private String Observacion;
	
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
	public int getNoCita() {
		return NoCita;
	}
	public void setNoCita(int noCita) {
		NoCita = noCita;
	}
	public int getSecuencia() {
		return Secuencia;
	}
	public void setSecuencia(int secuencia) {
		Secuencia = secuencia;
	}
	public String getObservacion() {
		return Observacion;
	}
	public void setObservacion(String observacion) {
		Observacion = observacion;
	}
	
}
