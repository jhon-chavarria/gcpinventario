package ni.com.casapellas.gcptaller.pojo;

public class BudgetMitchellDetail {
	private int NoPresupuesto;
	private String NoEstimacion;
	private String CodActividad;
	private String Descripcion;
	private String DescripcionItem;
	private int Secuencia;
	private double Valor;
	private double Horas;
	private double Cantidad;
	private double Cantidad2;
	private int CodSupervisor;
	private double PrecioItem;
	private String TipoLinea;

	public double getPrecioItem() {
		return PrecioItem;
	}
	public void setPrecioItem(double precioItem) {
		PrecioItem = precioItem;
	}
	public String getTipoLinea() {
		return TipoLinea;
	}
	public void setTipoLinea(String tipoLinea) {
		TipoLinea = tipoLinea;
	}
	public String getDescripcionItem() {
		return DescripcionItem;
	}
	public void setDescripcionItem(String descripcionItem) {
		DescripcionItem = descripcionItem;
	}
	public double getCantidad2() {
		return Cantidad2;
	}
	public void setCantidad2(double cantidad2) {
		Cantidad2 = cantidad2;
	}
	public int getCodSupervisor() {
		return CodSupervisor;
	}
	public void setCodSupervisor(int codSupervisor) {
		CodSupervisor = codSupervisor;
	}
	public int getNoPresupuesto() {
		return NoPresupuesto;
	}
	public void setNoPresupuesto(int noPresupuesto) {
		NoPresupuesto = noPresupuesto;
	}
	public String getCodActividad() {
		return CodActividad;
	}
	public void setCodActividad(String codActividad) {
		CodActividad = codActividad;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getSecuencia() {
		return Secuencia;
	}
	public void setSecuencia(int secuencia) {
		Secuencia = secuencia;
	}
	public double getValor() {
		return Valor;
	}
	public void setValor(double valor) {
		Valor = valor;
	}
	public double getHoras() {
		return Horas;
	}
	public void setHoras(double horas) {
		Horas = horas;
	}
	public double getCantidad() {
		return Cantidad;
	}
	public void setCantidad(double cantidad) {
		Cantidad = cantidad;
	}
	public String getNoEstimacion() {
		return NoEstimacion;
	}
	public void setNoEstimacion(String noEstimacion) {
		NoEstimacion = noEstimacion;
	}
	
}
