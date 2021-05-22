package ni.com.casapellas.gcpquiosco.pojo;


public class InformacionProcesoPago {
	

	private String tarjeta;
	private String titular;
	private String fechaVencimiento;
	private String autorizacion;
	private String numeroGenerado;
	private String valorCargado;
	private String moneda;
	private String terminal;
	private String afiliado;
	private String referencia;
	


	private String numeroRecibo;
	private String numeroCaja;
	//private String tasa;
	//private String monedaBase;
	//private String nombreCliente;
	private String sucursalCaja;
	private String tipoRecibo;
	private String numeroDocumento;
	private String observaciones;
	
	public String getNumeroRecibo() {
		return numeroRecibo;
	}
	public void setNumeroRecibo(String numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}
	public String getNumeroCaja() {
		return numeroCaja;
	}
	public void setNumeroCaja(String numeroCaja) {
		this.numeroCaja = numeroCaja;
	}
	
	public String getSucursalCaja() {
		return sucursalCaja;
	}
	public void setSucursalCaja(String sucursalCaja) {
		this.sucursalCaja = sucursalCaja;
	}
	public String getTipoRecibo() {
		return tipoRecibo;
	}
	public void setTipoRecibo(String tipoRecibo) {
		this.tipoRecibo = tipoRecibo;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	
	
	public String getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
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
	public String getAutorizacion() {
		return autorizacion;
	}
	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}
	public String getNumeroGenerado() {
		return numeroGenerado;
	}
	public void setNumeroGenerado(String numeroGenerado) {
		this.numeroGenerado = numeroGenerado;
	}
	public String getValorCargado() {
		return valorCargado;
	}
	public void setValorCargado(String valorCargado) {
		this.valorCargado = valorCargado;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public String getAfiliado() {
		return afiliado;
	}
	public void setAfiliado(String afiliado) {
		this.afiliado = afiliado;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	

}
