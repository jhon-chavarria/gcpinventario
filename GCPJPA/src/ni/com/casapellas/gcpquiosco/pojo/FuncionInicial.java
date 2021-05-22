package ni.com.casapellas.gcpquiosco.pojo;

/**
 * 
 * Descripcion de FuncionInicial.java Sistemas: GCPJPA Objetivos:
 * 
 * Fecha Creacion: May 12, 2016
 * 
 * @author Luis Fonseca Version:
 * @since
 * @see
 * 
 */
public class FuncionInicial {
	private String codMetodoInicial;
	private String descMetodoInicial;
	private String tipoControl;
	private String filtroDefault;

	private int secuencia;
	private String codActividad;
	private String descActividad;
	private String metodoAsociado;
	private String estado;

	private String codFiltros;
	private String descFiltros;
	private String tipoDatoFiltro;

	// Manuel este campo seria el que ocuparia
	// para indicar el nombre del campo por el cual
	// se filtrara a nivel de base de datos

	private String campoDB2;
	private String usaTCliente;

	public String getCodMetodoInicial() {
		return codMetodoInicial;
	}

	public void setCodMetodoInicial(String codMetodoInicial) {
		this.codMetodoInicial = codMetodoInicial;
	}

	public String getDescMetodoInicial() {
		return descMetodoInicial;
	}

	public void setDescMetodoInicial(String descMetodoInicial) {
		this.descMetodoInicial = descMetodoInicial;
	}

	public String getTipoControl() {
		return tipoControl;
	}

	public void setTipoControl(String tipoControl) {
		this.tipoControl = tipoControl;
	}

	public String getFiltroDefault() {
		return filtroDefault;
	}

	public void setFiltroDefault(String filtroDefault) {
		this.filtroDefault = filtroDefault;
	}

	public int getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(int secuencia) {
		this.secuencia = secuencia;
	}

	public String getCodActividad() {
		return codActividad;
	}

	public void setCodActividad(String codActividad) {
		this.codActividad = codActividad;
	}

	public String getDescActividad() {
		return descActividad;
	}

	public void setDescActividad(String descActividad) {
		this.descActividad = descActividad;
	}

	public String getMetodoAsociado() {
		return metodoAsociado;
	}

	public void setMetodoAsociado(String metodoAsociado) {
		this.metodoAsociado = metodoAsociado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodFiltros() {
		return codFiltros;
	}

	public void setCodFiltros(String codFiltros) {
		this.codFiltros = codFiltros;
	}

	public String getDescFiltros() {
		return descFiltros;
	}

	public void setDescFiltros(String descFiltros) {
		this.descFiltros = descFiltros;
	}

	public String getTipoDatoFiltro() {
		return tipoDatoFiltro;
	}

	public void setTipoDatoFiltro(String tipoDatoFiltro) {
		this.tipoDatoFiltro = tipoDatoFiltro;
	}

	public String getCampoDB2() {
		return campoDB2;
	}

	public void setCampoDB2(String campoDB2) {
		this.campoDB2 = campoDB2;
	}

	public String getUsaTCliente() {
		return usaTCliente;
	}

	public void setUsaTCliente(String usaTCliente) {
		this.usaTCliente = usaTCliente;
	}

}
