package ni.com.casapellas.gcptaller.pojo;

import java.util.Date;

public class TechnicalRecommendations {
	private String CodCompania;
	private String Codtaller;
	private int NoOrden;
	private String Justificacion;
	private String CodActividad;
	private String Actividad;
	private int NoTecnicoRecomendo;
	private int NoCita;
	private Date Fecha;
	private int NoOrdenAplica;
	private String Estado;
	private Double DuracionActividad;
	private Double ValActCliente;
	private Double ValActMecanico;
	private String ClasifActiv;
	
	private String NombreTecnico;
	
	public int getNoOrdenAplica() {
		return NoOrdenAplica;
	}
	public void setNoOrdenAplica(int noOrdenAplica) {
		NoOrdenAplica = noOrdenAplica;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public int getNoCita() {
		return NoCita;
	}
	public void setNoCita(int noCita) {
		NoCita = noCita;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public String getJustificacion() {
		return Justificacion;
	}
	public void setJustificacion(String justificacion) {
		Justificacion = justificacion;
	}
	public String getCodActividad() {
		return CodActividad;
	}
	public void setCodActividad(String codActividad) {
		CodActividad = codActividad;
	}
	public String getActividad() {
		return Actividad;
	}
	public void setActividad(String actividad) {
		Actividad = actividad;
	}
	public String getCodCompania() {
		return CodCompania;
	}
	public void setCodCompania(String codCompania) {
		CodCompania = codCompania;
	}
	public String getCodtaller() {
		return Codtaller;
	}
	public void setCodtaller(String codtaller) {
		Codtaller = codtaller;
	}
	public void setNoOrden(int noOrden) {
		NoOrden = noOrden;
	}
	public int getNoOrden() {
		return NoOrden;
	}
	public int getNoTecnicoRecomendo() {
		return NoTecnicoRecomendo;
	}
	public void setNoTecnicoRecomendo(int noTecnicoRecomendo) {
		NoTecnicoRecomendo = noTecnicoRecomendo;
	}
	public Double getDuracionActividad() {
		return DuracionActividad;
	}
	public void setDuracionActividad(Double duracionActividad) {
		DuracionActividad = duracionActividad;
	}
	public Double getValActCliente() {
		return ValActCliente;
	}
	public void setValActCliente(Double valActCliente) {
		ValActCliente = valActCliente;
	}
	public Double getValActMecanico() {
		return ValActMecanico;
	}
	public void setValActMecanico(Double valActMecanico) {
		ValActMecanico = valActMecanico;
	}
	public String getClasifActiv() {
		return ClasifActiv;
	}
	public void setClasifActiv(String clasifActiv) {
		ClasifActiv = clasifActiv;
	}
	public String getNombreTecnico() {
		return NombreTecnico;
	}
	public void setNombreTecnico(String nombreTecnico) {
		NombreTecnico = nombreTecnico;
	}
}
