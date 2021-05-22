package ni.com.casapellas.geninfo.pojo;

/**
 * 
 * Descripcion de TasaCambio.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Jul 26, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class TasaCambio {
	private String moneda; 
	private String fecha;
	private double valorCordobasVsForaneo;
	private String monedaExtranjera;
	private double valorForaneoVsCordobas;
	
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public Double getValorCordobasVsForaneo() {
		return valorCordobasVsForaneo;
	}
	public void setValorCordobasVsForaneo(Double valorCordobasVsForaneo) {
		this.valorCordobasVsForaneo = valorCordobasVsForaneo;
	}
	public String getMonedaExtranjera() {
		return monedaExtranjera;
	}
	public void setMonedaExtranjera(String monedaExtranjera) {
		this.monedaExtranjera = monedaExtranjera;
	}
	public Double getValorForaneoVsCordobas() {
		return valorForaneoVsCordobas;
	}
	public void setValorForaneoVsCordobas(Double valorForaneoVsCordobas) {
		this.valorForaneoVsCordobas = valorForaneoVsCordobas;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
