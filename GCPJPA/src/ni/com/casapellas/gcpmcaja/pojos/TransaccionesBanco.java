package ni.com.casapellas.gcpmcaja.pojos;

public class TransaccionesBanco {
	private int codigoTransaccion; 
	private String codigoTerminal;
	private String cuentaContable;
	private String numeroTransaccionSistema; 
	private String numeroAuthorizacion;
	private String numeroTarjeta;
	private Double monto;
	private String fechaExpiracion;
	private String numeroReferencia;
	private String horaTransaccion;
	private String fechaTransaccion;
	private String moneda;
	private int numeroCaja;
	private String codigoCompania; 
	private String nombreCliente; 
	private String codigoRespuesta; 
	private String Estado;
	private String tipoRecibo;
	private int cierreTerminalAplicada;
	
	public int getCodigoTransaccion() {
		return codigoTransaccion;
	}
	public void setCodigoTransaccion(int codigoTransaccion) {
		this.codigoTransaccion = codigoTransaccion;
	}
	public String getCodigoTerminal() {
		return codigoTerminal;
	}
	public void setCodigoTerminal(String codigoTerminal) {
		this.codigoTerminal = codigoTerminal;
	}
	public String getCuentaContable() {
		return cuentaContable;
	}
	public void setCuentaContable(String cuentaContable) {
		this.cuentaContable = cuentaContable;
	}
	public String getNumeroTransaccionSistema() {
		return numeroTransaccionSistema;
	}
	public void setNumeroTransaccionSistema(String numeroTransaccionSistema) {
		this.numeroTransaccionSistema = numeroTransaccionSistema;
	}
	public String getNumeroAuthorizacion() {
		return numeroAuthorizacion;
	}
	public void setNumeroAuthorizacion(String numeroAuthorizacion) {
		this.numeroAuthorizacion = numeroAuthorizacion;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public String getFechaExpiracion() {
		return fechaExpiracion;
	}
	public void setFechaExpiracion(String fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}
	public String getNumeroReferencia() {
		return numeroReferencia;
	}
	public void setNumeroReferencia(String numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}
	public String getHoraTransaccion() {
		return horaTransaccion;
	}
	public void setHoraTransaccion(String horaTransaccion) {
		this.horaTransaccion = horaTransaccion;
	}
	public String getFechaTransaccion() {
		return fechaTransaccion;
	}
	public void setFechaTransaccion(String fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public int getNumeroCaja() {
		return numeroCaja;
	}
	public void setNumeroCaja(int numeroCaja) {
		this.numeroCaja = numeroCaja;
	}
	public String getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getTipoRecibo() {
		return tipoRecibo;
	}
	public void setTipoRecibo(String tipoRecibo) {
		this.tipoRecibo = tipoRecibo;
	}
	public int getCierreTerminalAplicada() {
		return cierreTerminalAplicada;
	}
	public void setCierreTerminalAplicada(int cierreTerminalAplicada) {
		this.cierreTerminalAplicada = cierreTerminalAplicada;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Estado == null) ? 0 : Estado.hashCode());
		result = prime * result + cierreTerminalAplicada;
		result = prime * result
				+ ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		result = prime * result
				+ ((codigoRespuesta == null) ? 0 : codigoRespuesta.hashCode());
		result = prime * result
				+ ((codigoTerminal == null) ? 0 : codigoTerminal.hashCode());
		result = prime * result + codigoTransaccion;
		result = prime * result
				+ ((cuentaContable == null) ? 0 : cuentaContable.hashCode());
		result = prime * result
				+ ((fechaExpiracion == null) ? 0 : fechaExpiracion.hashCode());
		result = prime
				* result
				+ ((fechaTransaccion == null) ? 0 : fechaTransaccion.hashCode());
		result = prime * result
				+ ((horaTransaccion == null) ? 0 : horaTransaccion.hashCode());
		result = prime * result + ((moneda == null) ? 0 : moneda.hashCode());
		result = prime * result + ((monto == null) ? 0 : monto.hashCode());
		result = prime * result
				+ ((nombreCliente == null) ? 0 : nombreCliente.hashCode());
		result = prime
				* result
				+ ((numeroAuthorizacion == null) ? 0 : numeroAuthorizacion
						.hashCode());
		result = prime * result + numeroCaja;
		result = prime
				* result
				+ ((numeroReferencia == null) ? 0 : numeroReferencia.hashCode());
		result = prime * result
				+ ((numeroTarjeta == null) ? 0 : numeroTarjeta.hashCode());
		result = prime
				* result
				+ ((numeroTransaccionSistema == null) ? 0
						: numeroTransaccionSistema.hashCode());
		result = prime * result
				+ ((tipoRecibo == null) ? 0 : tipoRecibo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransaccionesBanco other = (TransaccionesBanco) obj;
		if (Estado == null) {
			if (other.Estado != null)
				return false;
		} else if (!Estado.equals(other.Estado))
			return false;
		if (cierreTerminalAplicada != other.cierreTerminalAplicada)
			return false;
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		if (codigoRespuesta == null) {
			if (other.codigoRespuesta != null)
				return false;
		} else if (!codigoRespuesta.equals(other.codigoRespuesta))
			return false;
		if (codigoTerminal == null) {
			if (other.codigoTerminal != null)
				return false;
		} else if (!codigoTerminal.equals(other.codigoTerminal))
			return false;
		if (codigoTransaccion != other.codigoTransaccion)
			return false;
		if (cuentaContable == null) {
			if (other.cuentaContable != null)
				return false;
		} else if (!cuentaContable.equals(other.cuentaContable))
			return false;
		if (fechaExpiracion == null) {
			if (other.fechaExpiracion != null)
				return false;
		} else if (!fechaExpiracion.equals(other.fechaExpiracion))
			return false;
		if (fechaTransaccion == null) {
			if (other.fechaTransaccion != null)
				return false;
		} else if (!fechaTransaccion.equals(other.fechaTransaccion))
			return false;
		if (horaTransaccion == null) {
			if (other.horaTransaccion != null)
				return false;
		} else if (!horaTransaccion.equals(other.horaTransaccion))
			return false;
		if (moneda == null) {
			if (other.moneda != null)
				return false;
		} else if (!moneda.equals(other.moneda))
			return false;
		if (monto == null) {
			if (other.monto != null)
				return false;
		} else if (!monto.equals(other.monto))
			return false;
		if (nombreCliente == null) {
			if (other.nombreCliente != null)
				return false;
		} else if (!nombreCliente.equals(other.nombreCliente))
			return false;
		if (numeroAuthorizacion == null) {
			if (other.numeroAuthorizacion != null)
				return false;
		} else if (!numeroAuthorizacion.equals(other.numeroAuthorizacion))
			return false;
		if (numeroCaja != other.numeroCaja)
			return false;
		if (numeroReferencia == null) {
			if (other.numeroReferencia != null)
				return false;
		} else if (!numeroReferencia.equals(other.numeroReferencia))
			return false;
		if (numeroTarjeta == null) {
			if (other.numeroTarjeta != null)
				return false;
		} else if (!numeroTarjeta.equals(other.numeroTarjeta))
			return false;
		if (numeroTransaccionSistema == null) {
			if (other.numeroTransaccionSistema != null)
				return false;
		} else if (!numeroTransaccionSistema
				.equals(other.numeroTransaccionSistema))
			return false;
		if (tipoRecibo == null) {
			if (other.tipoRecibo != null)
				return false;
		} else if (!tipoRecibo.equals(other.tipoRecibo))
			return false;
		return true;
	}
	public TransaccionesBanco(int codigoTransaccion, String codigoTerminal,
			String cuentaContable, String numeroTransaccionSistema,
			String numeroAuthorizacion, String numeroTarjeta, Double monto,
			String fechaExpiracion, String numeroReferencia,
			String horaTransaccion, String fechaTransaccion, String moneda,
			int numeroCaja, String codigoCompania, String nombreCliente,
			String codigoRespuesta, String estado, String tipoRecibo,
			int cierreTerminalAplicada) {
		super();
		this.codigoTransaccion = codigoTransaccion;
		this.codigoTerminal = codigoTerminal;
		this.cuentaContable = cuentaContable;
		this.numeroTransaccionSistema = numeroTransaccionSistema;
		this.numeroAuthorizacion = numeroAuthorizacion;
		this.numeroTarjeta = numeroTarjeta;
		this.monto = monto;
		this.fechaExpiracion = fechaExpiracion;
		this.numeroReferencia = numeroReferencia;
		this.horaTransaccion = horaTransaccion;
		this.fechaTransaccion = fechaTransaccion;
		this.moneda = moneda;
		this.numeroCaja = numeroCaja;
		this.codigoCompania = codigoCompania;
		this.nombreCliente = nombreCliente;
		this.codigoRespuesta = codigoRespuesta;
		Estado = estado;
		this.tipoRecibo = tipoRecibo;
		this.cierreTerminalAplicada = cierreTerminalAplicada;
	}
	public TransaccionesBanco() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
