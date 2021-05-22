package ni.com.casapellas.gcptaller.pojo;

import java.math.BigDecimal;

public class Tecnico {
	private BigDecimal codigoTecnico;
	private String tecnicoNombre;
	/**
	 * @return the codigoTecnico
	 */
	public BigDecimal getCodigoTecnico() {
		return codigoTecnico;
	}
	/**
	 * @return the tecnicoNombre
	 */
	public String getTecnicoNombre() {
		return tecnicoNombre;
	}
	/**
	 * @param codigoTecnico the codigoTecnico to set
	 */
	public void setCodigoTecnico(BigDecimal codigoTecnico) {
		this.codigoTecnico = codigoTecnico;
	}
	/**
	 * @param tecnicoNombre the tecnicoNombre to set
	 */
	public void setTecnicoNombre(String tecnicoNombre) {
		this.tecnicoNombre = tecnicoNombre;
	}
	/**
	 * 
	 */
	public Tecnico() {
		// TODO Auto-generated constructor stub
	}
}
