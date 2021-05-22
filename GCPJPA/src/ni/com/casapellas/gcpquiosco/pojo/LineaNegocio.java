package ni.com.casapellas.gcpquiosco.pojo;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Descripcion de LineaNegocio.java
 * Sistemas: Quiosco
 * Objetivos: Pojo que se utilizara para retener informacion relacionada a
 *            la tabla LineaNegocio.
 * Fecha Creacion: may 04, 2016
 * @author MLlamas
 * Version:
 * @since
 * @see
 *
 *
 */
@Entity
public class LineaNegocio {

	@Id
	private String codigoLineaNegocio;
	private String descripcionLineaNegocio;
	private String codigoLineaNegocioJde;
	private String transaccionInicial;
	private String fechaCreacion;
	private String horaCreacion;
	private String usuarioCreacion;
	private String programaCreacion;
	private String fechaUltimaModificacion;
	private String horaUltimaModificacion;
	private String usuarioUltimaModificacion;
	private String programaUltimaModificacion;

	private String habilitarPagoParcial;

	@Lob
	private String logo;
	

	private String icono;
	private String color;
	

	private String Telefono;
	private String Extension;

	private String configImpresion;

	private String ImprimirRecomendaciones;
	private String ImprimirMaterialesRepuestos;
	
	
	
	public String getCodigoLineaNegocio() {
		return codigoLineaNegocio;
	}
	public void setCodigoLineaNegocio(String _CodigoLineaNegocio) {
		codigoLineaNegocio = _CodigoLineaNegocio;
	}

	public String getDescripcionLineaNegocio() {
		return descripcionLineaNegocio;
	}
	public void setDescripcionLineaNegocio(String _DescripcionLineaNegocio) {
		descripcionLineaNegocio = _DescripcionLineaNegocio;
	}

	public String getCodigoLineaNegocioJde() {
		return codigoLineaNegocioJde;
	}
	public void setCodigoLineaNegocioJde(String _CodigoLineaNegocioJde) {
		codigoLineaNegocioJde = _CodigoLineaNegocioJde;
	}
	
	public String getTransaccionInicial() {
		return transaccionInicial;
	}
	public void setTransaccionInicial(String _TransaccionInicial) {
		transaccionInicial = _TransaccionInicial;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String _FechaCreacion) {
		fechaCreacion = _FechaCreacion;
	}

	public String getHoraCreacion() {
		return horaCreacion;
	}
	public void setHoraCreacion(String _HoraCreacion) {
		horaCreacion = _HoraCreacion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(String _UsuarioCreacion) {
		usuarioCreacion = _UsuarioCreacion;
	}

	public String getProgramaCreacion() {
		return programaCreacion;
	}
	public void setProgramaCreacion(String _ProgramaCreacion) {
		programaCreacion = _ProgramaCreacion;
	}

	public String getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}
	public void setFechaUltimaModificacion(String _FechaUltimaModificacion) {
		fechaUltimaModificacion = _FechaUltimaModificacion;
	}

	public String getHoraUltimaModificacion() {
		return horaUltimaModificacion;
	}
	public void setHoraUltimaModificacion(String _HoraUltimaModificacion) {
		horaUltimaModificacion = _HoraUltimaModificacion;
	}

	public String getUsuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}
	public void setUsuarioUltimaModificacion(String _UsuarioUltimaModificacion) {
		usuarioUltimaModificacion = _UsuarioUltimaModificacion;
	}

	public String getProgramaUltimaModificacion() {
		return programaUltimaModificacion;
	}
	public void setProgramaUltimaModificacion(String _ProgramaUltimaModificacion) {
		programaUltimaModificacion = _ProgramaUltimaModificacion;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String _logo) {
		logo = _logo;
	}
 
	public String getIcono() {
		return icono;
	}
	public void setIcono(String _icono) {
		icono = _icono;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String _color) {
		color = _color;
	}
	

	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String _Telefono) {
		Telefono = _Telefono;
	}

	public String getExtension() {
		return Extension;
	}
	public void setExtension(String _Extension) {
		Extension = _Extension;
	}
	public String getHabilitarPagoParcial() {
		return habilitarPagoParcial;
	}
	public void setHabilitarPagoParcial(String habilitarPagoParcial) {
		this.habilitarPagoParcial = habilitarPagoParcial;
	}

	
	

	public String getConfigImpresion() {
		return configImpresion;
	}
	public void setConfigImpresion(String configImpresion) {
		this.configImpresion = configImpresion;
	}
	
	

	public String getImprimirRecomendaciones() {
		return ImprimirRecomendaciones;
	}
	public void setImprimirRecomendaciones(String imprimirRecomendaciones) {
		ImprimirRecomendaciones = imprimirRecomendaciones;
	}
	public String getImprimirMaterialesRepuestos() {
		return ImprimirMaterialesRepuestos;
	}
	public void setImprimirMaterialesRepuestos(String imprimirMaterialesRepuestos) {
		ImprimirMaterialesRepuestos = imprimirMaterialesRepuestos;
	}
	
	
}

