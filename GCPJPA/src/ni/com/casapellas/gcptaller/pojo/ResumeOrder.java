package ni.com.casapellas.gcptaller.pojo;

public class ResumeOrder {
	private String CodEmpleado;
	private String TipoOrden;
	private String EstadoOrden;
	private int ContadorOrdenRecepcion;
	private String Marca;
	private String Modelo;
	private String TipoMantenimiento;
	
	private String AplicacionCreo;
	
	
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getTipoMantenimiento() {
		return TipoMantenimiento;
	}
	public void setTipoMantenimiento(String tipoMantenimiento) {
		TipoMantenimiento = tipoMantenimiento;
	}
	public int getContadorOrdenRecepcion() {
		return ContadorOrdenRecepcion;
	}
	public void setContadorOrdenRecepcion(int contadorOrdenRecepcion) {
		ContadorOrdenRecepcion = contadorOrdenRecepcion;
	}
	
	private int ContadorOrdenEntrego;
	
	public int getContadorOrdenEntrego() {
		return ContadorOrdenEntrego;
	}
	public void setContadorOrdenEntrego(int contadorOrdenEntrego) {
		ContadorOrdenEntrego = contadorOrdenEntrego;
	}
	
	private int ContadorCitas;
	private int CitasDia;
	
	public String getCodEmpleado() {
		return CodEmpleado;
	}
	public void setCodEmpleado(String codEmpleado) {
		CodEmpleado = codEmpleado;
	}
	public String getTipoOrden() {
		return TipoOrden;
	}
	public void setTipoOrden(String tipoOrden) {
		TipoOrden = tipoOrden;
	}
	public String getEstadoOrden() {
		return EstadoOrden;
	}
	public void setEstadoOrden(String estadoOrden) {
		EstadoOrden = estadoOrden;
	}
	public int getContadorCitas() {
		return ContadorCitas;
	}
	public void setContadorCitas(int contadorCitas) {
		ContadorCitas = contadorCitas;
	}
	public int getCitasDia() {
		return CitasDia;
	}
	public void setCitasDia(int citasDia) {
		CitasDia = citasDia;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getAplicacionCreo() {
		return AplicacionCreo;
	}
	public void setAplicacionCreo(String aplicacionCreo) {
		AplicacionCreo = aplicacionCreo;
	}
}
