package ni.com.casapellas.gcpmcaja.pojos;



public class MetodoPagoCaja  {

	private int caja;
	private String codigoCompania;
	private String moneda;
	private String codigoMetodoPago;
	private String metodoPago;
	private long montoMinimo;
	private long montoMaximo;
	private String estado;
	private int orden;

	public int getCaja() {
		return caja;
	}
	public void setCaja(int _caja) {
		caja = _caja;
	}
	public String getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(String _codigoCompania) {
		codigoCompania = _codigoCompania;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String _moneda) {
		moneda = _moneda;
	}
	public String getCodigoMetodoPago() {
		return codigoMetodoPago;
	}
	public void setCodigoMetodoPago(String _codigoMetodoPago) {
		codigoMetodoPago = _codigoMetodoPago;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String _metodoPago) {
		metodoPago = _metodoPago;
	}
	public long getMontoMinimo() {
		return montoMinimo;
	}
	public void setMontoMinimo(long _montoMinimo) {
		montoMinimo = _montoMinimo;
	}
	public long getMontoMaximo() {
		return montoMaximo;
	}
	public void setMontoMaximo(long _montoMaximo) {
		montoMaximo = _montoMaximo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String _estado) {
		estado = _estado;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	
	
	

}
