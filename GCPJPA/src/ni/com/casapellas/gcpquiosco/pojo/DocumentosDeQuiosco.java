package ni.com.casapellas.gcpquiosco.pojo;

/**
 * 
 * Descripcion de OrderByQuiosco.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Jun 3, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class DocumentosDeQuiosco {
		
	//Cabecera de tabla en pantalla de quiosco
	private String codigoCompania;
	private String codigoSucursal;
	private Long codigoCliente;
	private String nombreCliente;
	private Long codigoAsignado;
	private String nombreAsignado;
	private Integer numeroDocumento;
	private String tipoDocumento;
	private String descripcion;
	private String codigoObjeto;
	private Double totalPagar;
	private String fechaVencimiento;
	private String fechaCreacionDocumento;
	private String monedaFactura;
	
	private Long codAsesorServicio;
	private String nombreAsesor;
	private String telefono;
	private String extencion;

	//Detalle de la pantalla de quiosco
	private String codigoActividad;
	private String descripcionActividad;
	private Double precioActividad;
	private Double cantidadActividad;
	private String tipoActividad; //Este es el agrupador  "Actividad", "Abonos Pendientes"
	
	private String tipoItem; // Es un agrupador adicional "Repuesto", "Materiales"
	private String codigoItem;
	private String descripcionItem;
	private Double cantidadItem;
	private Double valorItem;
	private String estado;
	private String moneda;
	private Double principal; 
	private Double interes;
	private Double mora;
	private String lineaProduccion;
	private int DocumentosPendientes;
	
	private Double montoFacturado;
	private Double montoPendiente;
	
	private Double prima;
	private Double tasaInteres;
	private String nombreCompania;
	private String nombreSucursal;
	private String nombreLinea;
	private Double tasaCambio;
	
	private Double subTotal;
	private Double totalDescuento;
	private Double totalImpuesto;
	
	/*-----------------------------------------
	Informacion de facturas
	------------------------------------------*/
	private String clienteRUC;
	private String clienteDireccion;
	private String productoMarca;
	private String productoModelo;
	private String productoColor;
	private String productoSerie;
	private String productoSerie2;
	private String productoIdentificador;
	private Integer productoAnio;
	private Integer productoDesgaste;
	
	private Long codigoTecnico;
	private Double descuentoItem;
	private Double descuentoActividad;
	
	private String direccionSucursal;
	private String telefonoSucursal;
	
	private Double valorItemDespues;
	
	private String numeroRUC;
	private String companiaLeyenda;
	private String companiaCortaLeyenda;
	private String dominio;
	
	

	public String getCompaniaLeyenda() {
		return companiaLeyenda;
	}

	public void setCompaniaLeyenda(String companiaLeyenda) {
		this.companiaLeyenda = companiaLeyenda;
	}

	public String getCompaniaCortaLeyenda() {
		return companiaCortaLeyenda;
	}

	public void setCompaniaCortaLeyenda(String companiaCortaLeyenda) {
		this.companiaCortaLeyenda = companiaCortaLeyenda;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public Integer getProductoAnio() {
		return productoAnio;
	}

	public void setProductoAnio(Integer productoAnio) {
		this.productoAnio = productoAnio;
	}

	public Integer getProductoDesgaste() {
		return productoDesgaste;
	}

	public void setProductoDesgaste(Integer productoDesgaste) {
		this.productoDesgaste = productoDesgaste;
	}

	public Long getCodigoTecnico() {
		return codigoTecnico;
	}

	public void setCodigoTecnico(Long codigoTecnico) {
		this.codigoTecnico = codigoTecnico;
	}

	public String getClienteRUC() {
		return clienteRUC;
	}

	public void setClienteRUC(String clienteRUC) {
		this.clienteRUC = clienteRUC;
	}

	public String getClienteDireccion() {
		return clienteDireccion;
	}

	public void setClienteDireccion(String clienteDireccion) {
		this.clienteDireccion = clienteDireccion;
	}

	public String getProductoMarca() {
		return productoMarca;
	}

	public void setProductoMarca(String productoMarca) {
		this.productoMarca = productoMarca;
	}

	public String getProductoModelo() {
		return productoModelo;
	}

	public void setProductoModelo(String productoModelo) {
		this.productoModelo = productoModelo;
	}

	public String getProductoColor() {
		return productoColor;
	}

	public void setProductoColor(String productoColor) {
		this.productoColor = productoColor;
	}

	public String getProductoSerie() {
		return productoSerie;
	}

	public void setProductoSerie(String productoSerie) {
		this.productoSerie = productoSerie;
	}

	public String getProductoSerie2() {
		return productoSerie2;
	}

	public void setProductoSerie2(String productoSerie2) {
		this.productoSerie2 = productoSerie2;
	}

	public String getProductoIdentificador() {
		return productoIdentificador;
	}

	public void setProductoIdentificador(String productoIdentificador) {
		this.productoIdentificador = productoIdentificador;
	}


	public Double getDescuentoItem() {
		return descuentoItem;
	}

	public void setDescuentoItem(Double descuentoItem) {
		this.descuentoItem = descuentoItem;
	}

	public Double getDescuentoActividad() {
		return descuentoActividad;
	}

	public void setDescuentoActividad(Double descuentoActividad) {
		this.descuentoActividad = descuentoActividad;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getTotalDescuento() {
		return totalDescuento;
	}

	public void setTotalDescuento(Double totalDescuento) {
		this.totalDescuento = totalDescuento;
	}

	public Double getTasaInteres() {
		return tasaInteres;
	}

	public void setTasaInteres(Double tasaInteres) {
		this.tasaInteres = tasaInteres;
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

	public String getNombreLinea() {
		return nombreLinea;
	}

	public void setNombreLinea(String nombreLinea) {
		this.nombreLinea = nombreLinea;
	}

	public Double getMontoFacturado() {
		return montoFacturado;
	}

	public void setMontoFacturado(Double montoFacturado) {
		this.montoFacturado = montoFacturado;
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

	public Double getMora() {
		return mora;
	}

	public void setMora(Double mora) {
		this.mora = mora;
	}

	public String getLineaProduccion() {
		return lineaProduccion;
	}

	public void setLineaProduccion(String lineaProduccion) {
		this.lineaProduccion = lineaProduccion;
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

	public Long getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Long getCodigoAsignado() {
		return codigoAsignado;
	}

	public void setCodigoAsignado(Long codigoAsignado) {
		this.codigoAsignado = codigoAsignado;
	}

	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigoObjeto() {
		return codigoObjeto;
	}

	public void setCodigoObjeto(String codigoObjeto) {
		this.codigoObjeto = codigoObjeto;
	}

	public Double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(Double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getFechaCreacionDocumento() {
		return fechaCreacionDocumento;
	}

	public void setFechaCreacionDocumento(String fechaCreacionDocumento) {
		this.fechaCreacionDocumento = fechaCreacionDocumento;
	}

	public Long getCodAsesorServicio() {
		return codAsesorServicio;
	}

	public void setCodAsesorServicio(Long codAsesorServicio) {
		this.codAsesorServicio = codAsesorServicio;
	}

	public String getNombreAsesor() {
		return nombreAsesor;
	}

	public void setNombreAsesor(String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getExtencion() {
		return extencion;
	}

	public void setExtencion(String extencion) {
		this.extencion = extencion;
	}

	public String getCodigoActividad() {
		return codigoActividad;
	}

	public void setCodigoActividad(String codigoActividad) {
		this.codigoActividad = codigoActividad;
	}

	public String getDescripcionActividad() {
		return descripcionActividad;
	}

	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}

	public Double getPrecioActividad() {
		return precioActividad;
	}

	public void setPrecioActividad(Double precioActividad) {
		this.precioActividad = precioActividad;
	}

	public Double getCantidadActividad() {
		return cantidadActividad;
	}

	public void setCantidadActividad(Double cantidadActividad) {
		this.cantidadActividad = cantidadActividad;
	}

	public String getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	public String getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}

	public String getDescripcionItem() {
		return descripcionItem;
	}

	public void setDescripcionItem(String descripcionItem) {
		this.descripcionItem = descripcionItem;
	}

	public Double getCantidadItem() {
		return cantidadItem;
	}

	public void setCantidadItem(Double cantidadItem) {
		this.cantidadItem = cantidadItem;
	}

	public Double getValorItem() {
		return valorItem;
	}

	public void setValorItem(Double valorItem) {
		this.valorItem = valorItem;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreAsignado() {
		return nombreAsignado;
	}

	public void setNombreAsignado(String nombreAsignado) {
		this.nombreAsignado = nombreAsignado;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public int getDocumentosPendientes() {
		return DocumentosPendientes;
	}

	public void setDocumentosPendientes(int documentosPendientes) {
		DocumentosPendientes = documentosPendientes;
	}

	public Double getPrima() {
		return prima;
	}

	public void setPrima(Double prima) {
		this.prima = prima;
	}

	public Double getTasaCambio() {
		return tasaCambio;
	}

	public void setTasaCambio(Double tasaCambio) {
		this.tasaCambio = tasaCambio;
	}

	public Double getTotalImpuesto() {
		return totalImpuesto;
	}

	public void setTotalImpuesto(Double totalImpuesto) {
		this.totalImpuesto = totalImpuesto;
	}

	public String getDireccionSucursal() {
		return direccionSucursal;
	}

	public void setDireccionSucursal(String direccionSucursal) {
		this.direccionSucursal = direccionSucursal;
	}

	public String getTelefonoSucursal() {
		return telefonoSucursal;
	}

	public void setTelefonoSucursal(String telefonoSucursal) {
		this.telefonoSucursal = telefonoSucursal;
	}

	public String getNumeroRUC() {
		return numeroRUC;
	}

	public void setNumeroRUC(String numeroRUC) {
		this.numeroRUC = numeroRUC;
	}

	public String getMonedaFactura() {
		return monedaFactura;
	}

	public void setMonedaFactura(String monedaFactura) {
		this.monedaFactura = monedaFactura;
	}

	public Double getValorItemDespues() {
		return valorItemDespues;
	}

	public void setValorItemDespues(Double valorItemDespues) {
		this.valorItemDespues = valorItemDespues;
	}
	
}
