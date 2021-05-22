package ni.com.casapellas.gcptaller.pojo;

public class BudgetDetailIntegration {
	private int CodPresupuesto;
	private String CodItem;
	private String CodReferencia;
	private String DescripcionItem;
	private int Secuencia;
	private double Precio;
	private double Horas;
	
	private double PrecioAdicional;
	private String TipoItem;
	
	public double getPrecioAdicional() {
		return PrecioAdicional;
	}
	public void setPrecioAdicional(double precioAdicional) {
		PrecioAdicional = precioAdicional;
	}
	public String getTipoItem() {
		return TipoItem;
	}
	public void setTipoItem(String tipoItem) {
		TipoItem = tipoItem;
	}
	public int getCodPresupuesto() {
		return CodPresupuesto;
	}
	public void setCodPresupuesto(int codPresupuesto) {
		CodPresupuesto = codPresupuesto;
	}
	public String getCodItem() {
		return CodItem;
	}
	public void setCodItem(String codItem) {
		CodItem = codItem;
	}
	public String getCodReferencia() {
		return CodReferencia;
	}
	public void setCodReferencia(String codReferencia) {
		CodReferencia = codReferencia;
	}
	public String getDescripcionItem() {
		return DescripcionItem;
	}
	public void setDescripcionItem(String descripcionItem) {
		DescripcionItem = descripcionItem;
	}
	public int getSecuencia() {
		return Secuencia;
	}
	public void setSecuencia(int secuencia) {
		Secuencia = secuencia;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	public double getHoras() {
		return Horas;
	}
	public void setHoras(double horas) {
		Horas = horas;
	}
	
}
