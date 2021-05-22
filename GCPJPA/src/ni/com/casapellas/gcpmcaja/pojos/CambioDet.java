package ni.com.casapellas.gcpmcaja.pojos;

import java.io.Serializable;

/**
 * Descripcion de CambioDet.java
 * Sistemas: Quiosco
 * Objetivos: Pojo que se utilizara para retener informacion relacionada a
 *            la tabla CambioDet.
 * Fecha Creacion: jul 15, 2016
 * @author MLlamas
 * Version:
 * @since
 * @see
 *
 *
 */
public class CambioDet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer numeroRecibo;
	private String monedaDelCambio;
	private String codigoCompania;
	private double cambioOtorgado;
	private String sucursal;
	private int noCaja;
	private double tasaDelCambio;
	private String tipoRecibo;

	public Integer getNumeroRecibo() {
		return numeroRecibo;
	}
	public void setNumeroRecibo(Integer _NumeroRecibo) {
		numeroRecibo = _NumeroRecibo;
	}

	public String getMonedaDelCambio() {
		return monedaDelCambio;
	}
	public void setMonedaDelCambio(String _MonedaDelCambio) {
		monedaDelCambio = _MonedaDelCambio;
	}

	public String getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(String _CodigoCompania) {
		codigoCompania = _CodigoCompania;
	}

	public double getCambioOtorgado() {
		return cambioOtorgado;
	}
	public void setCambioOtorgado(double _CambioOtorgado) {
		cambioOtorgado = _CambioOtorgado;
	}

	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String _Sucursal) {
		sucursal = _Sucursal;
	}

	public int getNoCaja() {
		return noCaja;
	}
	public void setNoCaja(int _NoCaja) {
		noCaja = _NoCaja;
	}

	public double getTasaDelCambio() {
		return tasaDelCambio;
	}
	public void setTasaDelCambio(double _TasaDelCambio) {
		tasaDelCambio = _TasaDelCambio;
	}

	public String getTipoRecibo() {
		return tipoRecibo;
	}
	public void setTipoRecibo(String _TipoRecibo) {
		tipoRecibo = _TipoRecibo;
	}
 

	
	
}
