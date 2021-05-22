package ni.com.casapellas.gcpmcaja.pojos;

/**
 * 
 * Descripcion de ReciboSec.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Jan 27, 2017
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class ReciboSec {
	private String codigoCompania;
	private String codigoSucursal;
	private Integer numeroCaja;
	private Integer numeroRecibo;
	private String tipoRecibo;
	private String estado;
	private String usuario;
	private String pantalla;
	private String programa;
	private String fecha;
	private String hora;
	private String codigoUnico;
	
	public String getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public String getCodigoSucursal() {
		return codigoSucursal;
	}
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}
	public Integer getNumeroCaja() {
		return numeroCaja;
	}
	public void setNumeroCaja(Integer numeroCaja) {
		this.numeroCaja = numeroCaja;
	}
	public Integer getNumeroRecibo() {
		return numeroRecibo;
	}
	public void setNumeroRecibo(Integer numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}
	public String getTipoRecibo() {
		return tipoRecibo;
	}
	public void setTipoRecibo(String tipoRecibo) {
		this.tipoRecibo = tipoRecibo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPantalla() {
		return pantalla;
	}
	public void setPantalla(String pantalla) {
		this.pantalla = pantalla;
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getCodigoUnico() {
		return codigoUnico;
	}
	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}
}
