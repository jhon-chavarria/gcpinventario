package ni.com.casapellas.gcptaller.pojo;

/**
 * 
 * Descripcion de FacturaTallerDetalle.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Oct 14, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class FacturaTallerDetalle {
	private String codigoCompania;
	private String codigoSucursal;
	private String codigoInventario;
	private String codigoBodega;
	private String tipoFactura;
	private String tipoDocumento;
	private String fechaFactura;
	private String horaFactura;
	private Long numeroFactura;
	private Long numeroOrden;
	private String tipoItem;
	private String codigoItem;
	private String descripcionItem;
	private String flagFacturado;
	private Double cantidad;
	private Double fraccionFacturada;
	private Double valorFacturado;
	private Double valorConDescuentoAplicado;
	private Double costoFacturado;
	private String moneda;
	private Double tipoCambio;
	private Double valorFacturadoDol;
	private Double costoFacturadoDol;
	private int grupoClienteFacturado;
	private String codigoZona;
	private Long codigoVendedor;
	private Long codigoClienteOrden;
	private Long codigoClienteFactura;
	private String codigoAsiento;
	private String tipoNegocio;
	private String codigoUnidadNegocio;
	private String codigoUnicdadNegocio2;
	private String equipo;
	private String codigoSucursalContab;
	private String tipoDocumentoContab;
	private Long numeroDocumentoContab;
	private Long numerBatch;
	private String tipoBatch;
	private String subLibro;
	private String tipoSubLibro;
	private String fechaFacReferDev;
	private String documentoFacReferDev;
	private String tipoFacReferDev;
	private String numeroFacReferDev;
	
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
	public String getCodigoInventario() {
		return codigoInventario;
	}
	public void setCodigoInventario(String codigoInventario) {
		this.codigoInventario = codigoInventario;
	}
	public String getCodigoBodega() {
		return codigoBodega;
	}
	public void setCodigoBodega(String codigoBodega) {
		this.codigoBodega = codigoBodega;
	}
	public String getTipoFactura() {
		return tipoFactura;
	}
	public void setTipoFactura(String tipoFactura) {
		this.tipoFactura = tipoFactura;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(String fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public String getHoraFactura() {
		return horaFactura;
	}
	public void setHoraFactura(String horaFactura) {
		this.horaFactura = horaFactura;
	}
	public Long getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(Long numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public Long getNumeroOrden() {
		return numeroOrden;
	}
	public void setNumeroOrden(Long numeroOrden) {
		this.numeroOrden = numeroOrden;
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
	public String getFlagFacturado() {
		return flagFacturado;
	}
	public void setFlagFacturado(String flagFacturado) {
		this.flagFacturado = flagFacturado;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public Double getFraccionFacturada() {
		return fraccionFacturada;
	}
	public void setFraccionFacturada(Double fraccionFacturada) {
		this.fraccionFacturada = fraccionFacturada;
	}
	public Double getValorFacturado() {
		return valorFacturado;
	}
	public void setValorFacturado(Double valorFacturado) {
		this.valorFacturado = valorFacturado;
	}
	public Double getValorConDescuentoAplicado() {
		return valorConDescuentoAplicado;
	}
	public void setValorConDescuentoAplicado(Double valorConDescuentoAplicado) {
		this.valorConDescuentoAplicado = valorConDescuentoAplicado;
	}
	public Double getCostoFacturado() {
		return costoFacturado;
	}
	public void setCostoFacturado(Double costoFacturado) {
		this.costoFacturado = costoFacturado;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Double getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public Double getValorFacturadoDol() {
		return valorFacturadoDol;
	}
	public void setValorFacturadoDol(Double valorFacturadoDol) {
		this.valorFacturadoDol = valorFacturadoDol;
	}
	public Double getCostoFacturadoDol() {
		return costoFacturadoDol;
	}
	public void setCostoFacturadoDol(Double costoFacturadoDol) {
		this.costoFacturadoDol = costoFacturadoDol;
	}

	public String getCodigoZona() {
		return codigoZona;
	}
	public void setCodigoZona(String codigoZona) {
		this.codigoZona = codigoZona;
	}
	public Long getCodigoVendedor() {
		return codigoVendedor;
	}
	public void setCodigoVendedor(Long codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	public Long getCodigoClienteOrden() {
		return codigoClienteOrden;
	}
	public void setCodigoClienteOrden(Long codigoClienteOrden) {
		this.codigoClienteOrden = codigoClienteOrden;
	}
	public Long getCodigoClienteFactura() {
		return codigoClienteFactura;
	}
	public void setCodigoClienteFactura(Long codigoClienteFactura) {
		this.codigoClienteFactura = codigoClienteFactura;
	}
	public String getCodigoAsiento() {
		return codigoAsiento;
	}
	public void setCodigoAsiento(String codigoAsiento) {
		this.codigoAsiento = codigoAsiento;
	}
	public String getTipoNegocio() {
		return tipoNegocio;
	}
	public void setTipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}
	public String getCodigoUnidadNegocio() {
		return codigoUnidadNegocio;
	}
	public void setCodigoUnidadNegocio(String codigoUnidadNegocio) {
		this.codigoUnidadNegocio = codigoUnidadNegocio;
	}
	public String getCodigoUnicdadNegocio2() {
		return codigoUnicdadNegocio2;
	}
	public void setCodigoUnicdadNegocio2(String codigoUnicdadNegocio2) {
		this.codigoUnicdadNegocio2 = codigoUnicdadNegocio2;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public String getCodigoSucursalContab() {
		return codigoSucursalContab;
	}
	public void setCodigoSucursalContab(String codigoSucursalContab) {
		this.codigoSucursalContab = codigoSucursalContab;
	}
	public String getTipoDocumentoContab() {
		return tipoDocumentoContab;
	}
	public void setTipoDocumentoContab(String tipoDocumentoContab) {
		this.tipoDocumentoContab = tipoDocumentoContab;
	}
	public Long getNumeroDocumentoContab() {
		return numeroDocumentoContab;
	}
	public void setNumeroDocumentoContab(Long numeroDocumentoContab) {
		this.numeroDocumentoContab = numeroDocumentoContab;
	}
	public Long getNumerBatch() {
		return numerBatch;
	}
	public void setNumerBatch(Long numerBatch) {
		this.numerBatch = numerBatch;
	}
	public String getTipoBatch() {
		return tipoBatch;
	}
	public void setTipoBatch(String tipoBatch) {
		this.tipoBatch = tipoBatch;
	}
	public String getSubLibro() {
		return subLibro;
	}
	public void setSubLibro(String subLibro) {
		this.subLibro = subLibro;
	}
	public String getTipoSubLibro() {
		return tipoSubLibro;
	}
	public void setTipoSubLibro(String tipoSubLibro) {
		this.tipoSubLibro = tipoSubLibro;
	}
	public String getFechaFacReferDev() {
		return fechaFacReferDev;
	}
	public void setFechaFacReferDev(String fechaFacReferDev) {
		this.fechaFacReferDev = fechaFacReferDev;
	}
	public String getDocumentoFacReferDev() {
		return documentoFacReferDev;
	}
	public void setDocumentoFacReferDev(String documentoFacReferDev) {
		this.documentoFacReferDev = documentoFacReferDev;
	}
	public String getTipoFacReferDev() {
		return tipoFacReferDev;
	}
	public void setTipoFacReferDev(String tipoFacReferDev) {
		this.tipoFacReferDev = tipoFacReferDev;
	}
	public String getNumeroFacReferDev() {
		return numeroFacReferDev;
	}
	public void setNumeroFacReferDev(String numeroFacReferDev) {
		this.numeroFacReferDev = numeroFacReferDev;
	}
	public int getGrupoClienteFacturado() {
		return grupoClienteFacturado;
	}
	public void setGrupoClienteFacturado(int grupoClienteFacturado) {
		this.grupoClienteFacturado = grupoClienteFacturado;
	}
	
	
}
