package ni.com.casapellas.gcpmcaja.pojos;


/**
 * Descripcion de LimiteCaja.java
 * Sistemas: Quiosco
 * Objetivos: Pojo que se utilizara para retener informacion relacionada a
 *            la tabla LimiteCaja.
 * Fecha Creacion: jul 26, 2016
 * @author MLlamas
 * Version:
 * @since
 * @see
 *
 *
 */
public class LimiteCaja {

	private Integer noCaja ;
	private String codigoCompania ;
	private String nombreCompania ;
	private long limiteInferior;
	private long limiteSuperior;
	private String estado;
	private String unidadNegocio ;
	private int objeto;
	private int confirmAuto;
	private String monedaBase;
	private int consecutivoRecibo;
	private int fichaNum;
	private int codigoBanco;
	
	public int getConfirmAuto() {
		return confirmAuto;
	}
	public void setConfirmAuto(int confirmAuto) {
		this.confirmAuto = confirmAuto;
	}
	public String getMonedaBase() {
		return monedaBase;
	}
	public void setMonedaBase(String monedaBase) {
		this.monedaBase = monedaBase;
	}
	public Integer getNoCaja() {
		return noCaja;
	}
	public void setNoCaja(Integer noCaja) {
		this.noCaja = noCaja;
	}
	public String getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public String getNombreCompania() {
		return nombreCompania;
	}
	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}
	public long getLimiteInferior() {
		return limiteInferior;
	}
	public void setLimiteInferior(long limiteInferior) {
		this.limiteInferior = limiteInferior;
	}
	public long getLimiteSuperior() {
		return limiteSuperior;
	}
	public void setLimiteSuperior(long limiteSuperior) {
		this.limiteSuperior = limiteSuperior;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUnidadNegocio() {
		return unidadNegocio;
	}
	public void setUnidadNegocio(String unidadNegocio) {
		this.unidadNegocio = unidadNegocio;
	}
	public int getObjeto() {
		return objeto;
	}
	public void setObjeto(int objeto) {
		this.objeto = objeto;
	}
	public int getConsecutivoRecibo() {
		return consecutivoRecibo;
	}
	public void setConsecutivoRecibo(int consecutivoRecibo) {
		this.consecutivoRecibo = consecutivoRecibo;
	}
	public int getFichaNum() {
		return fichaNum;
	}
	public void setFichaNum(int fichaNum) {
		this.fichaNum = fichaNum;
	}
	public int getCodigoBanco() {
		return codigoBanco;
	}
	public void setCodigoBanco(int codigoBanco) {
		this.codigoBanco = codigoBanco;
	}



}

