package ni.com.casapellas.gcptaller.pojo;

/**
 * 
 * Descripcion de Materials.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Oct 17, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class Materials {
	private String codigoCompania; 
	private String codigoTaller;
	private Long numeroOrden;
	private Long codigoCliente;
	private String chasis;
	private String motor;
	private String marca;
	private Integer anio;
	private Long numeroDocumento;
	private String fechaDocumento;
	private String identificador;
	private String codigoItem;
	private String descripcionItem;
	private Double cantidadUsada;
	private Double precioItem;
	private Double precioItemAlterno;
	private Double procentajeDescuento;
	private Double valorDescuento;
	private Double tipoCambio;
	private String moneda;
	private Double valorDolar;
	private String codigoAsignacion;
	private String motorOCarroceria;
	private Integer codigoGrupo;
	private String flagFacturado;
	private String fechaFactura;
	private String tipoFactura;
	private String tipoFacturacion;
	private Long numeroFactura;
	private String fechaSalidaBodega;
	private Long codigoTecnico;
	private String unidadNegocio;
	private String unidadNegocio2;
	private Integer equipo;
	private Double costoItem;
	private Double porcentajeImpuesto;
	
	private String monedaFactura;
	
	private Double precioItemP;
	private Double precioItemAlternoP;
	private Double tipoCambioP;
	private Double valorDescuentoP;
	
	public Double getPrecioItemP() {
		return precioItemP;
	}
	public void setPrecioItemP(Double precioItemP) {
		this.precioItemP = precioItemP;
	}
	public Double getPrecioItemAlternoP() {
		return precioItemAlternoP;
	}
	public void setPrecioItemAlternoP(Double precioItemAlternoP) {
		this.precioItemAlternoP = precioItemAlternoP;
	}
	public String getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public String getCodigoTaller() {
		return codigoTaller;
	}
	public void setCodigoTaller(String codigoTaller) {
		this.codigoTaller = codigoTaller;
	}
	public Long getNumeroOrden() {
		return numeroOrden;
	}
	public void setNumeroOrden(Long numeroOrden) {
		this.numeroOrden = numeroOrden;
	}
	public Long getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getChasis() {
		return chasis;
	}
	public void setChasis(String chasis) {
		this.chasis = chasis;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getFechaDocumento() {
		return fechaDocumento;
	}
	public void setFechaDocumento(String fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
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
	public Double getCantidadUsada() {
		return cantidadUsada;
	}
	public void setCantidadUsada(Double cantidadUsada) {
		this.cantidadUsada = cantidadUsada;
	}
	public Double getPrecioItem() {
		return precioItem;
	}
	public void setPrecioItem(Double precioItem) {
		this.precioItem = precioItem;
	}
	public Double getPrecioItemAlterno() {
		return precioItemAlterno;
	}
	public void setPrecioItemAlterno(Double precioItemAlterno) {
		this.precioItemAlterno = precioItemAlterno;
	}
	public Double getProcentajeDescuento() {
		return procentajeDescuento;
	}
	public void setProcentajeDescuento(Double procentajeDescuento) {
		this.procentajeDescuento = procentajeDescuento;
	}
	public Double getValorDescuento() {
		return valorDescuento;
	}
	public void setValorDescuento(Double valorDescuento) {
		this.valorDescuento = valorDescuento;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getCodigoAsignacion() {
		return codigoAsignacion;
	}
	public void setCodigoAsignacion(String codigoAsignacion) {
		this.codigoAsignacion = codigoAsignacion;
	}
	public String getMotorOCarroceria() {
		return motorOCarroceria;
	}
	public void setMotorOCarroceria(String motorOCarroceria) {
		this.motorOCarroceria = motorOCarroceria;
	}
	public String getFlagFacturado() {
		return flagFacturado;
	}
	public void setFlagFacturado(String flagFacturado) {
		this.flagFacturado = flagFacturado;
	}
	public String getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(String fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public String getTipoFactura() {
		return tipoFactura;
	}
	public void setTipoFactura(String tipoFactura) {
		this.tipoFactura = tipoFactura;
	}
	public String getTipoFacturacion() {
		return tipoFacturacion;
	}
	public void setTipoFacturacion(String tipoFacturacion) {
		this.tipoFacturacion = tipoFacturacion;
	}
	public String getFechaSalidaBodega() {
		return fechaSalidaBodega;
	}
	public void setFechaSalidaBodega(String fechaSalidaBodega) {
		this.fechaSalidaBodega = fechaSalidaBodega;
	}
	public String getUnidadNegocio() {
		return unidadNegocio;
	}
	public void setUnidadNegocio(String unidadNegocio) {
		this.unidadNegocio = unidadNegocio;
	}
	public String getUnidadNegocio2() {
		return unidadNegocio2;
	}
	public void setUnidadNegocio2(String unidadNegocio2) {
		this.unidadNegocio2 = unidadNegocio2;
	}
	public Double getCostoItem() {
		return costoItem;
	}
	public void setCostoItem(Double costoItem) {
		this.costoItem = costoItem;
	}
	public Double getPorcentajeImpuesto() {
		return porcentajeImpuesto;
	}
	public void setPorcentajeImpuesto(Double porcentajeImpuesto) {
		this.porcentajeImpuesto = porcentajeImpuesto;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Long getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public Double getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public Double getValorDolar() {
		return valorDolar;
	}
	public void setValorDolar(Double valorDolar) {
		this.valorDolar = valorDolar;
	}
	public Integer getCodigoGrupo() {
		return codigoGrupo;
	}
	public void setCodigoGrupo(Integer codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}
	public Long getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(Long numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public Long getCodigoTecnico() {
		return codigoTecnico;
	}
	public void setCodigoTecnico(Long codigoTecnico) {
		this.codigoTecnico = codigoTecnico;
	}
	public Integer getEquipo() {
		return equipo;
	}
	public void setEquipo(Integer equipo) {
		this.equipo = equipo;
	}
	public String getMonedaFactura() {
		return monedaFactura;
	}
	public void setMonedaFactura(String monedaFactura) {
		this.monedaFactura = monedaFactura;
	}
	public Double getTipoCambioP() {
		return tipoCambioP;
	}
	public void setTipoCambioP(Double tipoCambioP) {
		this.tipoCambioP = tipoCambioP;
	}
	public Double getValorDescuentoP() {
		return valorDescuentoP;
	}
	public void setValorDescuentoP(Double valorDescuentoP) {
		this.valorDescuentoP = valorDescuentoP;
	}
	
}
