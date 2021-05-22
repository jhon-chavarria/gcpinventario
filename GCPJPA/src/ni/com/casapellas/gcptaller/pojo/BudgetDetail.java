package ni.com.casapellas.gcptaller.pojo;

public class BudgetDetail {
	private String CodCompania;
	private String CodTaller;
	private int NoPresupuesto;
	private String CodActividad;
	private String DescripcionAct;
	private String TipoActividad;
	private int Secuencia;
	private Double ValorActividadCliente;
	private Double ValorActividadMec;
	private Double PorcentajeDescuento;
	private String Comentario;
	private Double DuracionActividad;
	private String EsReal;
	
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
	public int getNoPresupuesto() {
		return NoPresupuesto;
	}
	public void setNoPresupuesto(int noPresupuesto) {
		NoPresupuesto = noPresupuesto;
	}
	public String getCodActividad() {
		return CodActividad;
	}
	public void setCodActividad(String codActividad) {
		CodActividad = codActividad;
	}
	public String getDescripcionAct() {
		return DescripcionAct;
	}
	public void setDescripcionAct(String descripcionAct) {
		DescripcionAct = descripcionAct;
	}
	public String getTipoActividad() {
		return TipoActividad;
	}
	public void setTipoActividad(String tipoActividad) {
		TipoActividad = tipoActividad;
	}
	public int getSecuencia() {
		return Secuencia;
	}
	public void setSecuencia(int secuencia) {
		Secuencia = secuencia;
	}
	public Double getValorActividadCliente() {
		return ValorActividadCliente;
	}
	public void setValorActividadCliente(Double valorActividadCliente) {
		ValorActividadCliente = valorActividadCliente;
	}
	public Double getValorActividadMec() {
		return ValorActividadMec;
	}
	public void setValorActividadMec(Double valorActividadMec) {
		ValorActividadMec = valorActividadMec;
	}
	public Double getPorcentajeDescuento() {
		return PorcentajeDescuento;
	}
	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		PorcentajeDescuento = porcentajeDescuento;
	}
	public String getComentario() {
		return Comentario;
	}
	public void setComentario(String comentario) {
		Comentario = comentario;
	}
	public Double getDuracionActividad() {
		return DuracionActividad;
	}
	public void setDuracionActividad(Double duracionActividad) {
		DuracionActividad = duracionActividad;
	}
	public String getEsReal() {
		return EsReal;
	}
	public void setEsReal(String esReal) {
		EsReal = esReal;
	}
}
