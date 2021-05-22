package ni.com.casapellas.gcpsisinv.pojo;

public class RequestPartsInventory {
	private String CodCompania;
	private String CodSucursalOrigen;
	private String CodSucursalDestino;
	private int NumeroCita;
	
	private int CodProforma;
	private int CodPresupuesto;
	private String CodArticulo;
	private String DescArticulo;
	private int CantidadSolicitado;

	private String DescSucursalOrigen;
	private String DescSucursalDestino;
	
	public String getDescSucursalOrigen() {
		return DescSucursalOrigen;
	}
	public void setDescSucursalOrigen(String descSucursalOrigen) {
		DescSucursalOrigen = descSucursalOrigen;
	}
	public String getDescSucursalDestino() {
		return DescSucursalDestino;
	}
	public void setDescSucursalDestino(String descSucursalDestino) {
		DescSucursalDestino = descSucursalDestino;
	}
	public String getCodCompania() {
		return CodCompania;
	}
	public void setCodCompania(String codCompania) {
		CodCompania = codCompania;
	}
	public String getCodSucursalOrigen() {
		return CodSucursalOrigen;
	}
	public void setCodSucursalOrigen(String codSucursalOrigen) {
		CodSucursalOrigen = codSucursalOrigen;
	}
	public String getCodSucursalDestino() {
		return CodSucursalDestino;
	}
	public void setCodSucursalDestino(String codSucursalDestino) {
		CodSucursalDestino = codSucursalDestino;
	}
	public int getNumeroCita() {
		return NumeroCita;
	}
	public void setNumeroCita(int numeroCita) {
		NumeroCita = numeroCita;
	}
	public int getCodProforma() {
		return CodProforma;
	}
	public void setCodProforma(int codProforma) {
		CodProforma = codProforma;
	}
	public int getCodPresupuesto() {
		return CodPresupuesto;
	}
	public void setCodPresupuesto(int codPresupuesto) {
		CodPresupuesto = codPresupuesto;
	}
	public String getCodArticulo() {
		return CodArticulo;
	}
	public void setCodArticulo(String codArticulo) {
		CodArticulo = codArticulo;
	}
	public String getDescArticulo() {
		return DescArticulo;
	}
	public void setDescArticulo(String descArticulo) {
		DescArticulo = descArticulo;
	}
	public int getCantidadSolicitado() {
		return CantidadSolicitado;
	}
	public void setCantidadSolicitado(int cantidadSolicitado) {
		CantidadSolicitado = cantidadSolicitado;
	}
	
}
