package ni.com.casapellas.gcpmcaja.pojos;

public class MaestroCaja {
	private int NoCaja;
	private String DescripcionCaja;
	private String sucursal;
	private long CodSupervisor;
	private long CajeroTitular;
	private long AutorizadorTitular;
	private long AutorizadorSuplente; 
	private long Contador;
	private String IdentificadorCaja;
	private String Observaciones;
	private String EstadoCaja;
	private String Impresora;
	private String UsaSocketPos;
	public int getNoCaja() {
		return NoCaja;
	}
	public void setNoCaja(int noCaja) {
		NoCaja = noCaja;
	}
	public String getDescripcionCaja() {
		return DescripcionCaja;
	}
	public void setDescripcionCaja(String descripcionCaja) {
		DescripcionCaja = descripcionCaja;
	}
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public long getCodSupervisor() {
		return CodSupervisor;
	}
	public void setCodSupervisor(long codSupervisor) {
		CodSupervisor = codSupervisor;
	}
	public long getCajeroTitular() {
		return CajeroTitular;
	}
	public void setCajeroTitular(long cajeroTitular) {
		CajeroTitular = cajeroTitular;
	}
	public long getAutorizadorTitular() {
		return AutorizadorTitular;
	}
	public void setAutorizadorTitular(long autorizadorTitular) {
		AutorizadorTitular = autorizadorTitular;
	}
	public long getAutorizadorSuplente() {
		return AutorizadorSuplente;
	}
	public void setAutorizadorSuplente(long autorizadorSuplente) {
		AutorizadorSuplente = autorizadorSuplente;
	}
	public long getContador() {
		return Contador;
	}
	public void setContador(long contador) {
		Contador = contador;
	}
	public String getIdentificadorCaja() {
		return IdentificadorCaja;
	}
	public void setIdentificadorCaja(String identificadorCaja) {
		IdentificadorCaja = identificadorCaja;
	}
	public String getObservaciones() {
		return Observaciones;
	}
	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}
	public String getEstadoCaja() {
		return EstadoCaja;
	}
	public void setEstadoCaja(String estadoCaja) {
		EstadoCaja = estadoCaja;
	}
	public String getImpresora() {
		return Impresora;
	}
	public void setImpresora(String impresora) {
		Impresora = impresora;
	}
	public String getUsaSocketPos() {
		return UsaSocketPos;
	}
	public void setUsaSocketPos(String usaSocketPos) {
		UsaSocketPos = usaSocketPos;
	}
	
}
