package ni.com.casapellas.gcpmcaja.pojos;

/**
 * 
 * Descripcion de HistoricoCuotaRecibo.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Jan 23, 2017
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class HistoricoCuotaRecibo {
		private Integer numeroSolicitud;
		private Integer codigoCliente;
		private String codigoCompania;
		private String codigoSucursal;
		private String codigoUniNeg;
		private Integer numeroCaja;
		private Integer numeroRecibo;
		private Integer numeroCuota;
		private Double montoPendiente;
		private Double montoAplicadoCuota;
		private Double montoInteresMoratorioCuota;
		private Double saldo;
		private String monedaDocumento;
		private String fechaRecibo;
		private String horaRecibo;
		private Integer codigoUsuario;
		private String loginUsuario;
		
		private Double montoAplicadoFactura;
		private Double montoInteresMoratorioFactura;
		
		public Integer getNumeroSolicitud() {
			return numeroSolicitud;
		}
		public void setNumeroSolicitud(Integer numeroSolicitud) {
			this.numeroSolicitud = numeroSolicitud;
		}
		public Integer getCodigoCliente() {
			return codigoCliente;
		}
		public void setCodigoCliente(Integer codigoCliente) {
			this.codigoCliente = codigoCliente;
		}
		public String getCodigoCompania() {
			return codigoCompania;
		}
		public void setCodigoCompania(String codigoCompania) {
			this.codigoCompania = codigoCompania;
		}
		public String getCodigoSucursal() {
			return codigoSucursal;
		}
		public void setCodigoSucursal(String codigoSucursal) {
			this.codigoSucursal = codigoSucursal;
		}
		public String getCodigoUniNeg() {
			return codigoUniNeg;
		}
		public void setCodigoUniNeg(String codigoUniNeg) {
			this.codigoUniNeg = codigoUniNeg;
		}
		public Integer getNumeroCaja() {
			return numeroCaja;
		}
		public void setNumeroCaja(Integer numeroCaja) {
			this.numeroCaja = numeroCaja;
		}
		public Integer getNumeroRecibo() {
			return numeroRecibo;
		}
		public void setNumeroRecibo(Integer numeroRecibo) {
			this.numeroRecibo = numeroRecibo;
		}
		public Integer getNumeroCuota() {
			return numeroCuota;
		}
		public void setNumeroCuota(Integer numeroCuota) {
			this.numeroCuota = numeroCuota;
		}
		public Double getMontoPendiente() {
			return montoPendiente;
		}
		public void setMontoPendiente(Double montoPendiente) {
			this.montoPendiente = montoPendiente;
		}
		public Double getMontoAplicadoCuota() {
			return montoAplicadoCuota;
		}
		public void setMontoAplicadoCuota(Double montoAplicadoCuota) {
			this.montoAplicadoCuota = montoAplicadoCuota;
		}
		public Double getMontoInteresMoratorioCuota() {
			return montoInteresMoratorioCuota;
		}
		public void setMontoInteresMoratorioCuota(Double montoInteresMoratorioCuota) {
			this.montoInteresMoratorioCuota = montoInteresMoratorioCuota;
		}
		public Double getSaldo() {
			return saldo;
		}
		public void setSaldo(Double saldo) {
			this.saldo = saldo;
		}
		public String getMonedaDocumento() {
			return monedaDocumento;
		}
		public void setMonedaDocumento(String monedaDocumento) {
			this.monedaDocumento = monedaDocumento;
		}
		public String getFechaRecibo() {
			return fechaRecibo;
		}
		public void setFechaRecibo(String fechaRecibo) {
			this.fechaRecibo = fechaRecibo;
		}
		public String getHoraRecibo() {
			return horaRecibo;
		}
		public void setHoraRecibo(String horaRecibo) {
			this.horaRecibo = horaRecibo;
		}
		public Integer getCodigoUsuario() {
			return codigoUsuario;
		}
		public void setCodigoUsuario(Integer codigoUsuario) {
			this.codigoUsuario = codigoUsuario;
		}
		public String getLoginUsuario() {
			return loginUsuario;
		}
		public void setLoginUsuario(String loginUsuario) {
			this.loginUsuario = loginUsuario;
		}
		public Double getMontoAplicadoFactura() {
			return montoAplicadoFactura;
		}
		public void setMontoAplicadoFactura(Double montoAplicadoFactura) {
			this.montoAplicadoFactura = montoAplicadoFactura;
		}
		public Double getMontoInteresMoratorioFactura() {
			return montoInteresMoratorioFactura;
		}
		public void setMontoInteresMoratorioFactura(Double montoInteresMoratorioFactura) {
			this.montoInteresMoratorioFactura = montoInteresMoratorioFactura;
		}
		
}
