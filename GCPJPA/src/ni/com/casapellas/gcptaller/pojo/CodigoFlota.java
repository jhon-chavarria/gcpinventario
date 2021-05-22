package ni.com.casapellas.gcptaller.pojo;


/**
 * Descripcion de CodigoFlota.java
 * Sistemas: Quiosco
 * Objetivos: Pojo que se utilizara para retener informacion relacionada a
 *            la tabla CodigoFlota.
 * Fecha Creacion: ago 10, 2016
 * @author MLlamas
 * Version:
 * @since
 * @see
 *
 *
 */
public class CodigoFlota {

	private int codCliente;
	private String codFlota;
	private String codTitulo;
	private String descFlota;
	private int codResponsable;
	private String registradoPor;
	private String fechaRegistro;
	private String horaRegistro;
	private String pantallaRegistro;
	private String programaRegistro;
	private String cambioPor;
	private String fechaCambio;
	private String horaCambio;
	private String pantallaCambio;
	private String programaCambio;
	private String estado;
	private String nombreEncargado;

	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int _CodCliente) {
		codCliente = _CodCliente;
	}

	public String getCodFlota() {
		return codFlota;
	}
	public void setCodFlota(String _CodFlota) {
		codFlota = _CodFlota;
	}

	public String getCodTitulo() {
		return codTitulo;
	}
	public void setCodTitulo(String _CodTitulo) {
		codTitulo = _CodTitulo;
	}

	public String getDescFlota() {
		return descFlota;
	}
	public void setDescFlota(String _DescFlota) {
		descFlota = _DescFlota;
	}

	public int getCodResponsable() {
		return codResponsable;
	}
	public void setCodResponsable(int _CodResponsable) {
		codResponsable = _CodResponsable;
	}

	public String getRegistradoPor() {
		return registradoPor;
	}
	public void setRegistradoPor(String _RegistradoPor) {
		registradoPor = _RegistradoPor;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String _FechaRegistro) {
		fechaRegistro = _FechaRegistro;
	}

	public String getHoraRegistro() {
		return horaRegistro;
	}
	public void setHoraRegistro(String _HoraRegistro) {
		horaRegistro = _HoraRegistro;
	}

	public String getPantallaRegistro() {
		return pantallaRegistro;
	}
	public void setPantallaRegistro(String _PantallaRegistro) {
		pantallaRegistro = _PantallaRegistro;
	}

	public String getProgramaRegistro() {
		return programaRegistro;
	}
	public void setProgramaRegistro(String _ProgramaRegistro) {
		programaRegistro = _ProgramaRegistro;
	}


	public String getFechaCambio() {
		return fechaCambio;
	}
	public void setFechaCambio(String _FechaCambio) {
		fechaCambio = _FechaCambio;
	}

	public String getHoraCambio() {
		return horaCambio;
	}
	public void setHoraCambio(String _HoraCambio) {
		horaCambio = _HoraCambio;
	}

	public String getPantallaCambio() {
		return pantallaCambio;
	}
	public void setPantallaCambio(String _PantallaCambio) {
		pantallaCambio = _PantallaCambio;
	}

	public String getProgramaCambio() {
		return programaCambio;
	}
	public void setProgramaCambio(String _ProgramaCambio) {
		programaCambio = _ProgramaCambio;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String _estado) {
		estado = _estado;
	}
	public String getCambioPor() {
		return cambioPor;
	}
	public void setCambioPor(String cambioPor) {
		this.cambioPor = cambioPor;
	}
	public String getNombreEncargado() {
		return nombreEncargado;
	}
	public void setNombreEncargado(String nombreEncargado) {
		this.nombreEncargado = nombreEncargado;
	}
	
	
}

