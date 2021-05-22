package ni.com.casapellas.gcpmcaja.pojos;

/**
 * 
 * Descripcion de CatalogosTerminales.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Jun 30, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class CatalogosTerminales {
	private String CodigoTerminal;
	private String DescripcionTerminal;
	private String Afiliado;
	
	public String getCodigoTerminal() {
		return CodigoTerminal;
	}
	public void setCodigoTerminal(String codigoTerminal) {
		CodigoTerminal = codigoTerminal;
	}
	public String getDescripcionTerminal() {
		return DescripcionTerminal;
	}
	public void setDescripcionTerminal(String descripcionTerminal) {
		DescripcionTerminal = descripcionTerminal;
	}
	public String getAfiliado() {
		return Afiliado;
	}
	public void setAfiliado(String afiliado) {
		Afiliado = afiliado;
	}
	
}
