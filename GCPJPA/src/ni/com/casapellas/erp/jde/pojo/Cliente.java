package ni.com.casapellas.erp.jde.pojo;


/**
 * Descripcion de Cliente.java
 * Sistemas: Quiosco
 * Objetivos: Pojo que se utilizara para retener informacion relacionada a
 *            la tabla Cliente.
 * Fecha Creacion: jul 25, 2016
 * @author MLlamas
 * Version:
 * @since
 * @see
 *
 *
 */
public class Cliente {

	private Long codigoCliente;
	private String fecha;
	private double pago;
	private String claseContable;

	private Integer fechaJuliano;
	private double monto;
	
	private double limiteCredito;
	private double montoDisponible;
	
	private Long payor;
	private String estado;
	
	private Integer diasCredito;
	

	public double getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	public double getMontoDisponible() {
		return montoDisponible;
	}
	public void setMontoDisponible(double montoDisponible) {
		this.montoDisponible = montoDisponible;
	}
	public Long getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public Long getPayor() {
		return payor;
	}
	public void setPayor(Long payor) {
		this.payor = payor;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String _Fecha) {
		fecha = _Fecha;
	}

	public double getPago() {
		return pago;
	}
	public void setPago(double _Pago) {
		pago = _Pago;
	}
 

	
	
	public Integer getFechaJuliano() {
		return fechaJuliano;
	}
	public void setFechaJuliano(Integer _fechaJuliano) {
		fechaJuliano = _fechaJuliano;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double _monto) {
		monto = _monto;
	}
	public String getClaseContable() {
		return claseContable;
	}
	public void setClaseContable(String claseContable) {
		this.claseContable = claseContable;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getDiasCredito() {
		return diasCredito;
	}
	public void setDiasCredito(Integer diasCredito) {
		this.diasCredito = diasCredito;
	}
	
	
}

