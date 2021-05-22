package ni.com.casapellas.gcpquiosco.pojo;

/**
 * 
 * Descripcion de ProcesoPagoDetalle.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: May 20, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class ProcesoPagoDetalle {
	 private int codigoDetalleMovimiento;
	 private int codigoMovimiento;
	 private String codigoConsultaInicial;
	 private String codigoActividad;
	 private String estado;

	private String fechaCreacionRegistro;
	private String horaCreacionRegistro;
	private String usuarioCreoRegistro;
	private String programaCreoRegistro;
	private String fechaMoficacionRegistro;
	private String horaMoficacionRegistro;
	private String usuarioMoficacionRegistro;
	private String programaMoficacionRegistro;
	

	private String numeroTarjeta;
	private String titular;
	private String fechaVencimiento; 
	private String numeroAutorizacion;
	private String numeroGenerado; 
	private String observacion;  
	private Double valor; 
	private String moneda; 

	private String descripcionActividad; 
	private String descripcionFuncionInicial; 
	
	private String terminal;
	
	
	public int getCodigoDetalleMovimiento() {
		return codigoDetalleMovimiento;
	}
	public void setCodigoDetalleMovimiento(int _codigoDetalleMovimiento) {
		codigoDetalleMovimiento = _codigoDetalleMovimiento;
	}
	public int getCodigoMovimiento() {
		return codigoMovimiento;
	}
	public void setCodigoMovimiento(int _codigoMovimiento) {
		codigoMovimiento = _codigoMovimiento;
	}
	public String getCodigoConsultaInicial() {
		return codigoConsultaInicial;
	}
	public void setCodigoConsultaInicial(String _codigoConsultaInicial) {
		codigoConsultaInicial = _codigoConsultaInicial;
	}
	public String getCodigoActividad() {
		return codigoActividad;
	}
	public void setCodigoActividad(String _codigoActividad) {
		codigoActividad = _codigoActividad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String _estado) {
		estado = _estado;
	}
	


	public String getFechaCreacionRegistro() {
		return fechaCreacionRegistro;
	}
	public void setFechaCreacionRegistro(String _FechaCreacionRegistro) {
		fechaCreacionRegistro = _FechaCreacionRegistro;
	}

	public String getHoraCreacionRegistro() {
		return horaCreacionRegistro;
	}
	public void setHoraCreacionRegistro(String _HoraCreacionRegistro) {
		horaCreacionRegistro = _HoraCreacionRegistro;
	}

	public String getUsuarioCreoRegistro() {
		return usuarioCreoRegistro;
	}
	public void setUsuarioCreoRegistro(String _UsuarioCreoRegistro) {
		usuarioCreoRegistro = _UsuarioCreoRegistro;
	}

	public String getProgramaCreoRegistro() {
		return programaCreoRegistro;
	}
	public void setProgramaCreoRegistro(String _ProgramaCreoRegistro) {
		programaCreoRegistro = _ProgramaCreoRegistro;
	}

	public String getFechaMoficacionRegistro() {
		return fechaMoficacionRegistro;
	}
	public void setFechaMoficacionRegistro(String _FechaMoficacionRegistro) {
		fechaMoficacionRegistro = _FechaMoficacionRegistro;
	}

	public String getHoraMoficacionRegistro() {
		return horaMoficacionRegistro;
	}
	public void setHoraMoficacionRegistro(String _HoraMoficacionRegistro) {
		horaMoficacionRegistro = _HoraMoficacionRegistro;
	}

	public String getUsuarioMoficacionRegistro() {
		return usuarioMoficacionRegistro;
	}
	public void setUsuarioMoficacionRegistro(String _UsuarioMoficacionRegistro) {
		usuarioMoficacionRegistro = _UsuarioMoficacionRegistro;
	}

	public String getProgramaMoficacionRegistro() {
		return programaMoficacionRegistro;
	}
	public void setProgramaMoficacionRegistro(String _ProgramaMoficacionRegistro) {
		programaMoficacionRegistro = _ProgramaMoficacionRegistro;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}
	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}
	public String getNumeroGenerado() {
		return numeroGenerado;
	}
	public void setNumeroGenerado(String numeroGenerado) {
		this.numeroGenerado = numeroGenerado;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getDescripcionActividad() {
		return descripcionActividad;
	}
	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}
	public String getDescripcionFuncionInicial() {
		return descripcionFuncionInicial;
	}
	public void setDescripcionFuncionInicial(String descripcionFuncionInicial) {
		this.descripcionFuncionInicial = descripcionFuncionInicial;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
 
	
	

}
