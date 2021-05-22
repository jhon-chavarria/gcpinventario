package ni.com.casapellas.gcpquiosco.pojo;

/**
 * 
 * Descripcion de RegistroAcceso.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Dec 12, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class RegistroAcceso {
	private String codigoAcceso;
	private Long codigoCliente;
	private Long codigoDocumento;
	private String tipoDocumento;
	private String codigoCompania;
	private String codigoSucursal;
	private String codigoUsado;
	
	public String getCodigoAcceso() {
		return codigoAcceso;
	}
	public void setCodigoAcceso(String codigoAcceso) {
		this.codigoAcceso = codigoAcceso;
	}
	public Long getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public Long getCodigoDocumento() {
		return codigoDocumento;
	}
	public void setCodigoDocumento(Long codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
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
	public String getCodigoUsado() {
		return codigoUsado;
	}
	public void setCodigoUsado(String codigoUsado) {
		this.codigoUsado = codigoUsado;
	} 
}
