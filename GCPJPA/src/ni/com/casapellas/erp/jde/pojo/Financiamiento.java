package ni.com.casapellas.erp.jde.pojo;

/**
 * 
 * Descripcion de Financiamiento.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Oct 6, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class Financiamiento {
	
	private String codigoSucursal; 
	private Long numeroSolicitud; 
	private String tipoSolicitud;
	private Long codigoCliente; 
	private int cuota; 
	private String moneda;
	private Double montoPendienteCordobas;
	private Double montoPendienteDolares;
	
	public String getCodigoSucursal() {
		return codigoSucursal;
	}
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}
	public Long getNumeroSolicitud() {
		return numeroSolicitud;
	}
	public void setNumeroSolicitud(Long numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}
	public String getTipoSolicitud() {
		return tipoSolicitud;
	}
	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	public Long getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public int getCuota() {
		return cuota;
	}
	public void setCuota(int cuota) {
		this.cuota = cuota;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Double getMontoPendienteCordobas() {
		return montoPendienteCordobas;
	}
	public void setMontoPendienteCordobas(Double montoPendienteCordobas) {
		this.montoPendienteCordobas = montoPendienteCordobas;
	}
	public Double getMontoPendienteDolares() {
		return montoPendienteDolares;
	}
	public void setMontoPendienteDolares(Double montoPendienteDolares) {
		this.montoPendienteDolares = montoPendienteDolares;
	}
}
