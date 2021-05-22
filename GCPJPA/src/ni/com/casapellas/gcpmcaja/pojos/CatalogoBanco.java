package ni.com.casapellas.gcpmcaja.pojos;

/**
 * 
 * Descripcion de CatalogoBanco.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Aug 1, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class CatalogoBanco {
	private int codigoBanco;
	private String banco;
	private int orden; 
	private String estado; 
	private int conciliar;
	private int leerrecbanco;
	
	public int getCodigoBanco() {
		return codigoBanco;
	}
	public void setCodigoBanco(int codigoBanco) {
		this.codigoBanco = codigoBanco;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getConciliar() {
		return conciliar;
	}
	public void setConciliar(int conciliar) {
		this.conciliar = conciliar;
	}
	public int getLeerrecbanco() {
		return leerrecbanco;
	}
	public void setLeerrecbanco(int leerrecbanco) {
		this.leerrecbanco = leerrecbanco;
	}
}
