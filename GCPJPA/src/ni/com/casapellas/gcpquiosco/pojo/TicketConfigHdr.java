package ni.com.casapellas.gcpquiosco.pojo;


/**
 * Descripcion de TicketConfigHdr.java
 * Sistemas: Quiosco
 * Objetivos: Pojo que se utilizara para retener informacion relacionada a
 *            la tabla TicketConfigHdr.
 * Fecha Creacion: ene 05, 2017
 * @author MLlamas
 * Version:
 * @since
 * @see
 *
 *
 */
public class TicketConfigHdr {

	private String tipo;
	private String linea;
	private String anchoCaracteresLinea;
	private String fechaCreacionRegistro;
	private String unidadNegocio;
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public String getAnchoCaracteresLinea() {
		return anchoCaracteresLinea;
	}
	public void setAnchoCaracteresLinea(String anchoCaracteresLinea) {
		this.anchoCaracteresLinea = anchoCaracteresLinea;
	}
	
	

	public String getUnidadNegocio() {
		return unidadNegocio;
	}
	public void setUnidadNegocio(String unidadNegocio) {
		this.unidadNegocio = unidadNegocio;
	}
	
	public String getFechaCreacionRegistro() {
		return fechaCreacionRegistro;
	}
	public void setFechaCreacionRegistro(String fechaCreacionRegistro) {
		this.fechaCreacionRegistro = fechaCreacionRegistro;
	}
	public String getHoraCreacionRegistro() {
		return horaCreacionRegistro;
	}
	public void setHoraCreacionRegistro(String horaCreacionRegistro) {
		this.horaCreacionRegistro = horaCreacionRegistro;
	}
	public String getUsuarioCreacionRegistro() {
		return usuarioCreacionRegistro;
	}
	public void setUsuarioCreacionRegistro(String usuarioCreacionRegistro) {
		this.usuarioCreacionRegistro = usuarioCreacionRegistro;
	}
	public String getProgramaCreacionRegistro() {
		return programaCreacionRegistro;
	}
	public void setProgramaCreacionRegistro(String programaCreacionRegistro) {
		this.programaCreacionRegistro = programaCreacionRegistro;
	}
	public String getFechaModificacionRegistro() {
		return fechaModificacionRegistro;
	}
	public void setFechaModificacionRegistro(String fechaModificacionRegistro) {
		this.fechaModificacionRegistro = fechaModificacionRegistro;
	}
	public String getHoraModificacionRegistro() {
		return horaModificacionRegistro;
	}
	public void setHoraModificacionRegistro(String horaModificacionRegistro) {
		this.horaModificacionRegistro = horaModificacionRegistro;
	}
	public String getUsuarioModificacionRegistro() {
		return usuarioModificacionRegistro;
	}
	public void setUsuarioModificacionRegistro(String usuarioModificacionRegistro) {
		this.usuarioModificacionRegistro = usuarioModificacionRegistro;
	}
	public String getProgramaModificacionRegistro() {
		return programaModificacionRegistro;
	}
	public void setProgramaModificacionRegistro(String programaModificacionRegistro) {
		this.programaModificacionRegistro = programaModificacionRegistro;
	}
	private String horaCreacionRegistro;
	private String usuarioCreacionRegistro;
	private String programaCreacionRegistro;
	private String fechaModificacionRegistro;
	private String horaModificacionRegistro;
	private String usuarioModificacionRegistro;
	private String programaModificacionRegistro;

	
	
	
}

