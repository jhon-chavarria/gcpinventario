package ni.com.casapellas.gcpinventario;

import java.math.BigDecimal;

public class RecoleccionArticulo {
	private String codigoCompania;
	private String codigoSucursal;
	private String codigoBodega;
	private String tipoDocumento;
	private BigDecimal numeroDocumento;
	private BigDecimal fecha;
	private BigDecimal hora;
	private String pantalla;
	private String programa;
	private String usuario;
	/**
	 * @return the codigoCompania
	 */
	public String getCodigoCompania() {
		return codigoCompania;
	}
	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	/**
	 * @return the codigoSucursal
	 */
	public String getCodigoSucursal() {
		return codigoSucursal;
	}
	/**
	 * @param codigoSucursal the codigoSucursal to set
	 */
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}
	/**
	 * @return the codigoBodega
	 */
	public String getCodigoBodega() {
		return codigoBodega;
	}
	/**
	 * @param codigoBodega the codigoBodega to set
	 */
	public void setCodigoBodega(String codigoBodega) {
		this.codigoBodega = codigoBodega;
	}
	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	/**
	 * @return the numeroDocumento
	 */
	public BigDecimal getNumeroDocumento() {
		return numeroDocumento;
	}
	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(BigDecimal numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	/**
	 * @return the fecha
	 */
	public BigDecimal getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(BigDecimal fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the hora
	 */
	public BigDecimal getHora() {
		return hora;
	}
	/**
	 * @param hora the hora to set
	 */
	public void setHora(BigDecimal hora) {
		this.hora = hora;
	}
	/**
	 * @return the pantalla
	 */
	public String getPantalla() {
		return pantalla;
	}
	/**
	 * @param pantalla the pantalla to set
	 */
	public void setPantalla(String pantalla) {
		this.pantalla = pantalla;
	}
	/**
	 * @return the programa
	 */
	public String getPrograma() {
		return programa;
	}
	/**
	 * @param programa the programa to set
	 */
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * 
	 */
	public RecoleccionArticulo() {
	}
	/**
	 * @param codigoCompania
	 * @param codigoSucursal
	 * @param codigoBodega
	 * @param tipoDocumento
	 * @param numeroDocumento
	 * @param fecha
	 * @param hora
	 * @param pantalla
	 * @param programa
	 * @param usuario
	 */
	public RecoleccionArticulo(String codigoCompania, String codigoSucursal, String codigoBodega, String tipoDocumento,
			BigDecimal numeroDocumento, BigDecimal fecha, BigDecimal hora, String pantalla, String programa,
			String usuario) {
		super();
		this.codigoCompania = codigoCompania;
		this.codigoSucursal = codigoSucursal;
		this.codigoBodega = codigoBodega;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fecha = fecha;
		this.hora = hora;
		this.pantalla = pantalla;
		this.programa = programa;
		this.usuario = usuario;
	}
}
