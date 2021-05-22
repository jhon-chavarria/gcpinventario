package ni.com.casapellas.gcpquiosco.pojo;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;


/**
 * Descripcion de ReciboTicket.java
 * Sistemas: Quiosco
 * Objetivos: Pojo que se utilizara para retener informacion relacionada a
 *            la tabla ReciboTicket.
 * Fecha Creacion: oct 25, 2016
 * @author MLlamas
 * Version:
 * @since
 * @see
 *
 *
 */

@Entity
@IdClass(ReciboTicketKey.class)
public class ReciboTicket {

	@Id
	private Integer NumeroRecibo;
	@Id
	private String TipoRecibo;
	@Id
	private String CodigoCompania;
	@Id
	private String CodigoSucursal;
	@Id
	private String TipoTicket;
	@Id
	private String Identificador2;
	
	private Integer CodigoCliente;
	
	@Lob
	private String Imagen;
	
	@Lob
	private String Comando;
	
	private String Cedula;
	
	private String FechaCreacion;
	private String HoraCreacion;
	private String UsuarioCreacion;
	private String ProgramaCreacion;
	private String FechaModificacion;
	private String HoraModificacion;
	private String UsuarioModificacion;
	private String ProgramaModificacion;

	public Integer getNumeroRecibo() {
		return NumeroRecibo;
	}
	public void setNumeroRecibo(Integer _NumeroRecibo) {
		NumeroRecibo = _NumeroRecibo;
	}

	public String getTipoRecibo() {
		return TipoRecibo;
	}
	public void setTipoRecibo(String _TipoRecibo) {
		TipoRecibo = _TipoRecibo;
	}

	public String getCodigoCompania() {
		return CodigoCompania;
	}
	public void setCodigoCompania(String _CodigoCompania) {
		CodigoCompania = _CodigoCompania;
	}

	public String getCodigoSucursal() {
		return CodigoSucursal;
	}
	public void setCodigoSucursal(String _CodigoSucursal) {
		CodigoSucursal = _CodigoSucursal;
	}
	

	public String getTipoTicket() {
		return TipoTicket;
	}
	public void setTipoTicket(String tipoTicket) {
		TipoTicket = tipoTicket;
	}
	public String getIdentificador2() {
		return Identificador2;
	}
	public void setIdentificador2(String identificador2) {
		Identificador2 = identificador2;
	}

	public Integer getCodigoCliente() {
		return CodigoCliente;
	}
	public void setCodigoCliente(Integer _CodigoCliente) {
		CodigoCliente = _CodigoCliente;
	}

	public String getImagen() {
		return Imagen;
	}
	public void setImagen(String _Imagen) {
		Imagen = _Imagen;
	}

	public String getComando() {
		return Comando;
	}
	public void setComando(String _Comando) {
		Comando = _Comando;
	}

	
	
	
	public String getCedula() {
		return Cedula;
	}
	public void setCedula(String cedula) {
		Cedula = cedula;
	}
	public String getFechaCreacion() {
		return FechaCreacion;
	}
	public void setFechaCreacion(String _FechaCreacion) {
		FechaCreacion = _FechaCreacion;
	}

	public String getHoraCreacion() {
		return HoraCreacion;
	}
	public void setHoraCreacion(String _HoraCreacion) {
		HoraCreacion = _HoraCreacion;
	}

	public String getUsuarioCreacion() {
		return UsuarioCreacion;
	}
	public void setUsuarioCreacion(String _UsuarioCreacion) {
		UsuarioCreacion = _UsuarioCreacion;
	}

	public String getProgramaCreacion() {
		return ProgramaCreacion;
	}
	public void setProgramaCreacion(String _ProgramaCreacion) {
		ProgramaCreacion = _ProgramaCreacion;
	}

	public String getFechaModificacion() {
		return FechaModificacion;
	}
	public void setFechaModificacion(String _FechaModificacion) {
		FechaModificacion = _FechaModificacion;
	}

	public String getHoraModificacion() {
		return HoraModificacion;
	}
	public void setHoraModificacion(String _HoraModificacion) {
		HoraModificacion = _HoraModificacion;
	}

	public String getUsuarioModificacion() {
		return UsuarioModificacion;
	}
	public void setUsuarioModificacion(String _UsuarioModificacion) {
		UsuarioModificacion = _UsuarioModificacion;
	}

	public String getProgramaModificacion() {
		return ProgramaModificacion;
	}
	public void setProgramaModificacion(String _ProgramaModificacion) {
		ProgramaModificacion = _ProgramaModificacion;
	}
 

	
	
}

