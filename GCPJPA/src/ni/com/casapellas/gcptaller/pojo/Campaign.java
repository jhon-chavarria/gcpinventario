package ni.com.casapellas.gcptaller.pojo;

public class Campaign {
	private String CodMarca;
	private String CodActividad;
	private String Modelo;
	private String Actividad;
	private String Chasis;
	private Double DuracionActividad;
	private Double ValActCliente;
	private Double ValActMecanico;
	private String ClasifActiv;
	private String EsReal;
	
	public String getCodMarca() {
		return CodMarca;
	}
	public void setCodMarca(String codMarca) {
		CodMarca = codMarca;
	}
	public String getCodActividad() {
		return CodActividad;
	}
	public void setCodActividad(String codActividad) {
		CodActividad = codActividad;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getChasis() {
		return Chasis;
	}
	public void setChasis(String chasis) {
		Chasis = chasis;
	}
	public String getActividad() {
		return Actividad;
	}
	public void setActividad(String actividad) {
		Actividad = actividad;
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
	public String getEsReal() {
		return EsReal;
	}
	public void setEsReal(String esReal) {
		EsReal = esReal;
	}
}
