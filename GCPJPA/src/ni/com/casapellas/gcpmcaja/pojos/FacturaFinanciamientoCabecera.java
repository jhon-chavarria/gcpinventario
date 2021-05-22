package ni.com.casapellas.gcpmcaja.pojos;

/**
 * 
 * Descripcion de FacturaFinanciamientoCabecera.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Jul 5, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class FacturaFinanciamientoCabecera {
	private String codigoCompania;
	private String codigoSucursal;
	private String linea;
	private String nombreLinea;
	private int numeroSolicitud;
	private String tipoSolicitud;
	private String fecha;
	private String recibido;
	private long codigoCliente;
	private String nombreCliente; 
	private Double tasa;
	private String moneda;
	private Double valorCordobas;
	private Double saldoCuotaCordobas;
	private Double saldoPrincipalCordoba;
	private Double saldoInteresesCordobas;
	private Double valorDolares;
	private Double saldoCuotaDolares;
	private Double saldoPrincipalDolares;
	private Double saldoInteresesDolares;
	private Double monto;
	private Double montoPendiente;
	private Double principal;
	private Double interes;
	private Double impuesto;
	private Double mora;
	
	private String nombreCompania;
	private String nombreSucursal;
	
	private String concepto;
	private int numeroCuotas;
	private String productoFinanciado;
	private Double tasaInteres;
	private Double montoPrimaCordobas;
	private Double montoPrimaDolar;
	  
	private String atendidoPor;
	private String telefono;
	private String extension;
	  
	private String codigoProducto;
	private String producto;
	private String marca;
	private String modelo;
	  
	private String serie;
	private String codItem;
	private String color;
	private String anio;
	
	private Long codigoVendedor;
	private String nombreVendedor;
	private String telefonoVendedor;
	private String extensionVendedor;
	
	public Long getCodigoVendedor() {
		return codigoVendedor;
	}
	public void setCodigoVendedor(Long codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	public String getNombreVendedor() {
		return nombreVendedor;
	}
	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}
	public String getTelefonoVendedor() {
		return telefonoVendedor;
	}
	public void setTelefonoVendedor(String telefonoVendedor) {
		this.telefonoVendedor = telefonoVendedor;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getCodItem() {
		return codItem;
	}
	public void setCodItem(String codItem) {
		this.codItem = codItem;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAtendidoPor() {
		return atendidoPor;
	}
	public void setAtendidoPor(String atendidoPor) {
		this.atendidoPor = atendidoPor;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public Double getTasaInteres() {
		return tasaInteres;
	}
	public void setTasaInteres(Double tasaInteres) {
		this.tasaInteres = tasaInteres;
	}
	public Double getMontoPrimaCordobas() {
		return montoPrimaCordobas;
	}
	public void setMontoPrimaCordobas(Double montoPrimaCordobas) {
		this.montoPrimaCordobas = montoPrimaCordobas;
	}
	public Double getMontoPrimaDolar() {
		return montoPrimaDolar;
	}
	public void setMontoPrimaDolar(Double montoPrimaDolar) {
		this.montoPrimaDolar = montoPrimaDolar;
	}
	public int getNumeroCuotas() {
		return numeroCuotas;
	}
	public void setNumeroCuotas(int numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}
	public String getNombreCompania() {
		return nombreCompania;
	}
	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
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
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public String getNombreLinea() {
		return nombreLinea;
	}
	public void setNombreLinea(String nombreLinea) {
		this.nombreLinea = nombreLinea;
	}
	public int getNumeroSolicitud() {
		return numeroSolicitud;
	}
	public void setNumeroSolicitud(int numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}
	public String getTipoSolicitud() {
		return tipoSolicitud;
	}
	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getRecibido() {
		return recibido;
	}
	public void setRecibido(String recibido) {
		this.recibido = recibido;
	}
	public long getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public Double getTasa() {
		return tasa;
	}
	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Double getValorCordobas() {
		return valorCordobas;
	}
	public void setValorCordobas(Double valorCordobas) {
		this.valorCordobas = valorCordobas;
	}
	public Double getSaldoCuotaCordobas() {
		return saldoCuotaCordobas;
	}
	public void setSaldoCuotaCordobas(Double saldoCuotaCordobas) {
		this.saldoCuotaCordobas = saldoCuotaCordobas;
	}
	public Double getSaldoPrincipalCordoba() {
		return saldoPrincipalCordoba;
	}
	public void setSaldoPrincipalCordoba(Double saldoPrincipalCordoba) {
		this.saldoPrincipalCordoba = saldoPrincipalCordoba;
	}
	public Double getSaldoInteresesCordobas() {
		return saldoInteresesCordobas;
	}
	public void setSaldoInteresesCordobas(Double saldoInteresesCordobas) {
		this.saldoInteresesCordobas = saldoInteresesCordobas;
	}
	public Double getValorDolares() {
		return valorDolares;
	}
	public void setValorDolares(Double valorDolares) {
		this.valorDolares = valorDolares;
	}
	public Double getSaldoCuotaDolares() {
		return saldoCuotaDolares;
	}
	public void setSaldoCuotaDolares(Double saldoCuotaDolares) {
		this.saldoCuotaDolares = saldoCuotaDolares;
	}
	public Double getSaldoPrincipalDolares() {
		return saldoPrincipalDolares;
	}
	public void setSaldoPrincipalDolares(Double saldoPrincipalDolares) {
		this.saldoPrincipalDolares = saldoPrincipalDolares;
	}
	public Double getSaldoInteresesDolares() {
		return saldoInteresesDolares;
	}
	public void setSaldoInteresesDolares(Double saldoInteresesDolares) {
		this.saldoInteresesDolares = saldoInteresesDolares;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Double getMontoPendiente() {
		return montoPendiente;
	}
	public void setMontoPendiente(Double montoPendiente) {
		this.montoPendiente = montoPendiente;
	}
	public Double getPrincipal() {
		return principal;
	}
	public void setPrincipal(Double principal) {
		this.principal = principal;
	}
	public Double getInteres() {
		return interes;
	}
	public void setInteres(Double interes) {
		this.interes = interes;
	}
	public Double getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}
	public Double getMora() {
		return mora;
	}
	public void setMora(Double mora) {
		this.mora = mora;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getProductoFinanciado() {
		return productoFinanciado;
	}
	public void setProductoFinanciado(String productoFinanciado) {
		this.productoFinanciado = productoFinanciado;
	}
	public String getExtensionVendedor() {
		return extensionVendedor;
	}
	public void setExtensionVendedor(String extensionVendedor) {
		this.extensionVendedor = extensionVendedor;
	}
}
