package ni.com.casapellas.gcpmcaja.pojos;

import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Api(value = "Tasa de Cambio(Caja)")
public class FactorCambio {

	@ApiModelProperty(value = "Codigo de la moneda local", dataType = "String")
	private String codigoMonedaLocal;
	@ApiModelProperty(value = "Codigo de la moneda foranea", dataType = "String")
	private String codigoMonedaForanea;
	@ApiModelProperty(value = "Valor del tipo de cambio", dataType = "Number")
	private BigDecimal factorCambio;
	@ApiModelProperty(value = "Factor divisor o conversor", dataType = "Number")
	private BigDecimal factorDivisor;
	@ApiModelProperty(value = "Direccion", dataType = "String")
	private String direccion;
	@ApiModelProperty(value = "Fecha de inicio de vigencia del factor", dataType = "String")
	private String fechaInicial;
	@ApiModelProperty(value = "Fecha final de vigencia del factor", dataType = "String")
	private String fechaFinal;
	/**
	 * @return the codigoMonedaLocal
	 */
	public String getCodigoMonedaLocal() {
		return codigoMonedaLocal;
	}
	/**
	 * @param codigoMonedaLocal the codigoMonedaLocal to set
	 */
	public void setCodigoMonedaLocal(String codigoMonedaLocal) {
		this.codigoMonedaLocal = codigoMonedaLocal;
	}
	/**
	 * @return the codigoMonedaForanea
	 */
	public String getCodigoMonedaForanea() {
		return codigoMonedaForanea;
	}
	/**
	 * @param codigoMonedaForanea the codigoMonedaForanea to set
	 */
	public void setCodigoMonedaForanea(String codigoMonedaForanea) {
		this.codigoMonedaForanea = codigoMonedaForanea;
	}
	/**
	 * @return the factorCambio
	 */
	public BigDecimal getFactorCambio() {
		return factorCambio;
	}
	/**
	 * @param factorCambio the factorCambio to set
	 */
	public void setFactorCambio(BigDecimal factorCambio) {
		this.factorCambio = factorCambio;
	}
	/**
	 * @return the factorDivisor
	 */
	public BigDecimal getFactorDivisor() {
		return factorDivisor;
	}
	/**
	 * @param factorDivisor the factorDivisor to set
	 */
	public void setFactorDivisor(BigDecimal factorDivisor) {
		this.factorDivisor = factorDivisor;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the fechaInicial
	 */
	public String getFechaInicial() {
		return fechaInicial;
	}
	/**
	 * @param fechaInicial the fechaInicial to set
	 */
	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	/**
	 * @return the fechaFinal
	 */
	public String getFechaFinal() {
		return fechaFinal;
	}
	/**
	 * @param fechaFinal the fechaFinal to set
	 */
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	/**
	 * 
	 */
	public FactorCambio() {
	}
}
