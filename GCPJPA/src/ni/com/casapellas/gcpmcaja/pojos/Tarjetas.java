package ni.com.casapellas.gcpmcaja.pojos;

/**
 * 
 * @author Luis Fonseca
 *
 */
public class Tarjetas {
	private int idTarjeta;
	private int idTarjetad;
	private String key;
	private int codCliente;
	private int cotizacion;
	private int contrato;
	private String noTarjeta;
	private String codigoSeguridad;
	private String fechaVencimiento;
	private String usuarioCreo;
	private String fechaCreo;
	private String horaCreo;
	private String usuarioSistema;
	private String estado;
	private String primario;
	private String moneda;
	private String marca;

	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public int getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(int cotizacion) {
		this.cotizacion = cotizacion;
	}
	public int getContrato() {
		return contrato;
	}
	public void setContrato(int contrato) {
		this.contrato = contrato;
	}
	public int getIdTarjeta() {
		return idTarjeta;
	}
	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
	public int getIdTarjetad() {
		return idTarjetad;
	}
	public void setIdTarjetad(int idTarjetad) {
		this.idTarjetad = idTarjetad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPrimario() {
		return primario;
	}
	public void setPrimario(String primario) {
		this.primario = primario;
	}
	public String getNoTarjeta() {
		return noTarjeta;
	}
	public void setNoTarjeta(String noTarjeta) {
		this.noTarjeta = noTarjeta;
	}
	public String getCodigoSeguridad() {
		return codigoSeguridad;
	}
	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUsuarioCreo() {
		return usuarioCreo;
	}
	public void setUsuarioCreo(String usuarioCreo) {
		this.usuarioCreo = usuarioCreo;
	}
	public String getFechaCreo() {
		return fechaCreo;
	}
	public void setFechaCreo(String fechaCreo) {
		this.fechaCreo = fechaCreo;
	}
	public String getHoraCreo() {
		return horaCreo;
	}
	public void setHoraCreo(String horaCreo) {
		this.horaCreo = horaCreo;
	}
	public String getUsuarioSistema() {
		return usuarioSistema;
	}
	public void setUsuarioSistema(String usuarioSistema) {
		this.usuarioSistema = usuarioSistema;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
}
