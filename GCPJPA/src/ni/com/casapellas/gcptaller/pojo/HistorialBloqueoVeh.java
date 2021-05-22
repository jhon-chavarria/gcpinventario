package ni.com.casapellas.gcptaller.pojo;

/**
 * 
 * Descripcion de HistorialBloqueoVeh.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Aug 21, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class HistorialBloqueoVeh {
	private Long codigoCliente;
	private String chasis;
	private String codigoMotivo;
	private String descripcionMotivo;
	private String clienteCompro;
	private String telefonoCompro;
	private String estado;
	
	public Long getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getChasis() {
		return chasis;
	}
	public void setChasis(String chasis) {
		this.chasis = chasis;
	}
	public String getCodigoMotivo() {
		return codigoMotivo;
	}
	public void setCodigoMotivo(String codigoMotivo) {
		this.codigoMotivo = codigoMotivo;
	}
	public String getDescripcionMotivo() {
		return descripcionMotivo;
	}
	public void setDescripcionMotivo(String descripcionMotivo) {
		this.descripcionMotivo = descripcionMotivo;
	}
	public String getClienteCompro() {
		return clienteCompro;
	}
	public void setClienteCompro(String clienteCompro) {
		this.clienteCompro = clienteCompro;
	}
	public String getTelefonoCompro() {
		return telefonoCompro;
	}
	public void setTelefonoCompro(String telefonoCompro) {
		this.telefonoCompro = telefonoCompro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
