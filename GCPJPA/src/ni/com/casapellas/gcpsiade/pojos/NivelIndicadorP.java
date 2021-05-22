package ni.com.casapellas.gcpsiade.pojos;

import java.io.Serializable;

public class NivelIndicadorP implements Serializable {

	private int id;

	private String nombre;

	private int nivel;

	private String svlt;

	private short parametroNivel;

	private int modo;

	private int tipoVisualizacion;

	private int idIndicadorxund;

	private int tipoIndicador;

	private int tipoGrafico;

	private static final long serialVersionUID = 1L;

	public NivelIndicadorP() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getSvlt() {
		return this.svlt;
	}

	public void setSvlt(String svlt) {
		this.svlt = svlt;
	}

	public short getParametroNivel() {
		return this.parametroNivel;
	}

	public void setParametroNivel(short parametroNivel) {
		this.parametroNivel = parametroNivel;
	}

	public int getModo() {
		return this.modo;
	}

	public void setModo(int modo) {
		this.modo = modo;
	}

	public void setTipoVisualizacion(int tipoVisualizacion) {
		this.tipoVisualizacion = tipoVisualizacion;
	}

	public int getTipoVisualizacion() {
		return tipoVisualizacion;
	}

	public void setIdIndicadorxund(int idIndicadorxund) {
		this.idIndicadorxund = idIndicadorxund;
	}

	public int getIdIndicadorxund() {
		return idIndicadorxund;
	}

	public void setTipoIndicador(int tipoIndicador) {
		this.tipoIndicador = tipoIndicador;
	}

	public int getTipoIndicador() {
		return tipoIndicador;
	}

	public void setTipoGrafico(int tipoGrafico) {
		this.tipoGrafico = tipoGrafico;
	}

	public int getTipoGrafico() {
		return tipoGrafico;
	}

}
