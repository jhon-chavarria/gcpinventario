package ni.com.casapellas.gcpquiosco.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;


/**
 * Descripcion de TipoTarjeta.java
 * Sistemas: Quiosco
 * Objetivos: Pojo que se utilizara para retener informacion relacionada a
 *            la tabla TipoTarjeta.
 * Fecha Creacion: dic 02, 2016
 * @author MLlamas
 * Version:
 * @since
 * @see
 *
 *
 */
@Entity
public class TipoTarjeta {

	@Id
	private String Tipo;
	private String Descripcion;
	@Lob
	private String Logo;
	private String FechaCreacionRegistro;
	private String HoraCreacionRegistro;
	private String UsuarioCreacionRegistro;
	private String ProgramaCreacionRegistro;
	private String FechaModificacionRegistro;
	private String HoraModificacionRegistro;
	private String UsuarioModificacionRegistro;
	private String ProgramaModificacionRegistro;

	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String _Tipo) {
		Tipo = _Tipo;
	}

	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String _Descripcion) {
		Descripcion = _Descripcion;
	}

	public String getLogo() {
		return Logo;
	}
	public void setLogo(String _Logo) {
		Logo = _Logo;
	}

	public String getFechaCreacionRegistro() {
		return FechaCreacionRegistro;
	}
	public void setFechaCreacionRegistro(String _FechaCreacionRegistro) {
		FechaCreacionRegistro = _FechaCreacionRegistro;
	}

	public String getHoraCreacionRegistro() {
		return HoraCreacionRegistro;
	}
	public void setHoraCreacionRegistro(String _HoraCreacionRegistro) {
		HoraCreacionRegistro = _HoraCreacionRegistro;
	}

	public String getUsuarioCreacionRegistro() {
		return UsuarioCreacionRegistro;
	}
	public void setUsuarioCreacionRegistro(String _UsuarioCreacionRegistro) {
		UsuarioCreacionRegistro = _UsuarioCreacionRegistro;
	}

	public String getProgramaCreacionRegistro() {
		return ProgramaCreacionRegistro;
	}
	public void setProgramaCreacionRegistro(String _ProgramaCreacionRegistro) {
		ProgramaCreacionRegistro = _ProgramaCreacionRegistro;
	}

	public String getFechaModificacionRegistro() {
		return FechaModificacionRegistro;
	}
	public void setFechaModificacionRegistro(String _FechaModificacionRegistro) {
		FechaModificacionRegistro = _FechaModificacionRegistro;
	}

	public String getHoraModificacionRegistro() {
		return HoraModificacionRegistro;
	}
	public void setHoraModificacionRegistro(String _HoraModificacionRegistro) {
		HoraModificacionRegistro = _HoraModificacionRegistro;
	}

	public String getUsuarioModificacionRegistro() {
		return UsuarioModificacionRegistro;
	}
	public void setUsuarioModificacionRegistro(String _UsuarioModificacionRegistro) {
		UsuarioModificacionRegistro = _UsuarioModificacionRegistro;
	}

	public String getProgramaModificacionRegistro() {
		return ProgramaModificacionRegistro;
	}
	public void setProgramaModificacionRegistro(String _ProgramaModificacionRegistro) {
		ProgramaModificacionRegistro = _ProgramaModificacionRegistro;
	}
 

	
	
}

