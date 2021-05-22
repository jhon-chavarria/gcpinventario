package ni.com.casapellas.gcptaller.pojo;

/**
 * 
 * Descripcion de FacturaTallerCabecera.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: Oct 13, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class FacturaTallerCabecera {
	
	private String codigoCompania;
	private String codigoSucursal;
	private String fechaFactura;
	private String tipoDocumento;
	private String tipoFactura;
	private Long numeroFactura;
	private Long  numeroOrden;
	private Long codigoClienteOrden;
	private Long codigoClienteFactura;
	private String nombreClienteFacturo;
	private Double valorManoObra;
	private Double descuentoManoObra;
	private Double costoManoObra;
	private Double valorManoObraCarr;
	private Double descuentoManoObraCarr;
	private Double costoManoObraCarr;
	private Double valorRepuesto;
	private Double descuentoRepuesto;
	private Double costoRepuesto;
	private Double valorMateriales;
	private Double descuentoMateriales;
	private Double costoMateriales;
	private Double valorRubro3;
	private Double descuentoRubro3;
	private Double costoRubro3;
	private Double valorRubro4;
	private Double descuentoRubro4;
	private Double costoRubro4;
	private Double impuestoIVA;
	private Double impuestoIEC;
	private Double impuestoOtros;
	private Double valorTotalFactura;
	private String moneda;
	private Double tipoCambio;
	private Double valorManoObraDol;
	private Double descuentoManoObraDol;
	private Double valorManoObraCarrDol;
	private Double descuentoManoObraCarrDol;
	private Double valorRepuestoDol;
	private Double descuentoRepuestoDol;
	private Double valorMaterialDol;
	private Double descuentoMaterialDol;
	private Double valorRubro3Dol;
	private Double descuentoRubro3Dol;
	private Double valorRubro4Dol;
	private Double descuentoRubro4Dol;
	private String codigoInventario;
	private String codigoBodega;
	private Long grupoClienteFacturado;
	private String cuentaInventario;
	private Integer numeroCuotas;
	private Long frecuenciaPago;
	private String codigoVendedor;
	private String codigoZona;
	private String tipoNegocio;
	private String cuentaConsignacionDir;
	private Double valorConductDir;
	private Double valorCombustDir;
	private Double valorIndemnizacion;
	private String tipoFacturaMPP;
	private String referencia;
	private String estado;
	private String unidadNegocio;
	private String unidadNegocio2;
	private String cuentaObjeto;
	private String cuentaSubsidiaria;
	private String subLibro;
	private String tipoSubLibro;
	private Long equipo;
	private String sucursal;
	private String tipoDocumentoContab;
	private Long documentoContab;
	private Long bach;
	private String tipoBatch;
	private String numeroReclamo;
	private String condicionesPago;
//	private String hechoPor;
//	private String fechaCreacion;
//	private String horaCreacion;
//	private String programaCreo;
//	private String modificadoPor;
//	private String fechaModificacion;
//	private String horaModificacion;
//	private String pantallaModificacion;
//	private String programaModificacion;
	
	public String getCodigoVendedor() {
		return codigoVendedor;
	}
	public Long getFrecuenciaPago() {
		return frecuenciaPago;
	}
	public void setFrecuenciaPago(Long frecuenciaPago) {
		this.frecuenciaPago = frecuenciaPago;
	}
	public void setNumeroCuotas(Integer numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}
	public void setCodigoVendedor(String codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	public String getTipoDocumentoContab() {
		return tipoDocumentoContab;
	}
	public void setTipoDocumentoContab(String tipoDocumentoContab) {
		this.tipoDocumentoContab = tipoDocumentoContab;
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
	public String getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(String fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getTipoFactura() {
		return tipoFactura;
	}
	public void setTipoFactura(String tipoFactura) {
		this.tipoFactura = tipoFactura;
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
	public String getNombreClienteFacturo() {
		return nombreClienteFacturo;
	}
	public void setNombreClienteFacturo(String nombreClienteFacturo) {
		this.nombreClienteFacturo = nombreClienteFacturo;
	}
	public Double getValorManoObra() {
		return valorManoObra;
	}
	public void setValorManoObra(Double valorManoObra) {
		this.valorManoObra = valorManoObra;
	}
	public Double getDescuentoManoObra() {
		return descuentoManoObra;
	}
	public void setDescuentoManoObra(Double descuentoManoObra) {
		this.descuentoManoObra = descuentoManoObra;
	}
	public Double getCostoManoObra() {
		return costoManoObra;
	}
	public void setCostoManoObra(Double costoManoObra) {
		this.costoManoObra = costoManoObra;
	}
	public Double getValorManoObraCarr() {
		return valorManoObraCarr;
	}
	public void setValorManoObraCarr(Double valorManoObraCarr) {
		this.valorManoObraCarr = valorManoObraCarr;
	}
	public Double getDescuentoManoObraCarr() {
		return descuentoManoObraCarr;
	}
	public void setDescuentoManoObraCarr(Double descuentoManoObraCarr) {
		this.descuentoManoObraCarr = descuentoManoObraCarr;
	}
	public Double getCostoManoObraCarr() {
		return costoManoObraCarr;
	}
	public void setCostoManoObraCarr(Double costoManoObraCarr) {
		this.costoManoObraCarr = costoManoObraCarr;
	}
	public Double getValorRepuesto() {
		return valorRepuesto;
	}
	public void setValorRepuesto(Double valorRepuesto) {
		this.valorRepuesto = valorRepuesto;
	}
	public Double getDescuentoRepuesto() {
		return descuentoRepuesto;
	}
	public void setDescuentoRepuesto(Double descuentoRepuesto) {
		this.descuentoRepuesto = descuentoRepuesto;
	}
	public Double getCostoRepuesto() {
		return costoRepuesto;
	}
	public void setCostoRepuesto(Double costoRepuesto) {
		this.costoRepuesto = costoRepuesto;
	}
	public Double getValorMateriales() {
		return valorMateriales;
	}
	public void setValorMateriales(Double valorMateriales) {
		this.valorMateriales = valorMateriales;
	}
	public Double getDescuentoMateriales() {
		return descuentoMateriales;
	}
	public void setDescuentoMateriales(Double descuentoMateriales) {
		this.descuentoMateriales = descuentoMateriales;
	}
	public Double getCostoMateriales() {
		return costoMateriales;
	}
	public void setCostoMateriales(Double costoMateriales) {
		this.costoMateriales = costoMateriales;
	}
	public Double getValorRubro3() {
		return valorRubro3;
	}
	public void setValorRubro3(Double valorRubro3) {
		this.valorRubro3 = valorRubro3;
	}
	public Double getDescuentoRubro3() {
		return descuentoRubro3;
	}
	public void setDescuentoRubro3(Double descuentoRubro3) {
		this.descuentoRubro3 = descuentoRubro3;
	}
	public Double getCostoRubro3() {
		return costoRubro3;
	}
	public void setCostoRubro3(Double costoRubro3) {
		this.costoRubro3 = costoRubro3;
	}
	public Double getValorRubro4() {
		return valorRubro4;
	}
	public void setValorRubro4(Double valorRubro4) {
		this.valorRubro4 = valorRubro4;
	}
	public Double getDescuentoRubro4() {
		return descuentoRubro4;
	}
	public void setDescuentoRubro4(Double descuentoRubro4) {
		this.descuentoRubro4 = descuentoRubro4;
	}
	public Double getCostoRubro4() {
		return costoRubro4;
	}
	public void setCostoRubro4(Double costoRubro4) {
		this.costoRubro4 = costoRubro4;
	}
	public Double getImpuestoIVA() {
		return impuestoIVA;
	}
	public void setImpuestoIVA(Double impuestoIVA) {
		this.impuestoIVA = impuestoIVA;
	}
	public Double getImpuestoIEC() {
		return impuestoIEC;
	}
	public void setImpuestoIEC(Double impuestoIEC) {
		this.impuestoIEC = impuestoIEC;
	}
	public Double getImpuestoOtros() {
		return impuestoOtros;
	}
	public void setImpuestoOtros(Double impuestoOtros) {
		this.impuestoOtros = impuestoOtros;
	}
	public Double getValorTotalFactura() {
		return valorTotalFactura;
	}
	public void setValorTotalFactura(Double valorTotalFactura) {
		this.valorTotalFactura = valorTotalFactura;
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
	public Double getValorManoObraDol() {
		return valorManoObraDol;
	}
	public void setValorManoObraDol(Double valorManoObraDol) {
		this.valorManoObraDol = valorManoObraDol;
	}
	public Double getDescuentoManoObraDol() {
		return descuentoManoObraDol;
	}
	public void setDescuentoManoObraDol(Double descuentoManoObraDol) {
		this.descuentoManoObraDol = descuentoManoObraDol;
	}
	public Double getValorManoObraCarrDol() {
		return valorManoObraCarrDol;
	}
	public void setValorManoObraCarrDol(Double valorManoObraCarrDol) {
		this.valorManoObraCarrDol = valorManoObraCarrDol;
	}
	public Double getDescuentoManoObraCarrDol() {
		return descuentoManoObraCarrDol;
	}
	public void setDescuentoManoObraCarrDol(Double descuentoManoObraCarrDol) {
		this.descuentoManoObraCarrDol = descuentoManoObraCarrDol;
	}
	public Double getValorRepuestoDol() {
		return valorRepuestoDol;
	}
	public void setValorRepuestoDol(Double valorRepuestoDol) {
		this.valorRepuestoDol = valorRepuestoDol;
	}
	public Double getDescuentoRepuestoDol() {
		return descuentoRepuestoDol;
	}
	public void setDescuentoRepuestoDol(Double descuentoRepuestoDol) {
		this.descuentoRepuestoDol = descuentoRepuestoDol;
	}
	public Double getValorMaterialDol() {
		return valorMaterialDol;
	}
	public void setValorMaterialDol(Double valorMaterialDol) {
		this.valorMaterialDol = valorMaterialDol;
	}
	public Double getDescuentoMaterialDol() {
		return descuentoMaterialDol;
	}
	public void setDescuentoMaterialDol(Double descuentoMaterialDol) {
		this.descuentoMaterialDol = descuentoMaterialDol;
	}
	public Double getValorRubro3Dol() {
		return valorRubro3Dol;
	}
	public void setValorRubro3Dol(Double valorRubro3Dol) {
		this.valorRubro3Dol = valorRubro3Dol;
	}
	public Double getDescuentoRubro3Dol() {
		return descuentoRubro3Dol;
	}
	public void setDescuentoRubro3Dol(Double descuentoRubro3Dol) {
		this.descuentoRubro3Dol = descuentoRubro3Dol;
	}
	public Double getValorRubro4Dol() {
		return valorRubro4Dol;
	}
	public void setValorRubro4Dol(Double valorRubro4Dol) {
		this.valorRubro4Dol = valorRubro4Dol;
	}
	public Double getDescuentoRubro4Dol() {
		return descuentoRubro4Dol;
	}
	public void setDescuentoRubro4Dol(Double descuentoRubro4Dol) {
		this.descuentoRubro4Dol = descuentoRubro4Dol;
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
	public String getCuentaInventario() {
		return cuentaInventario;
	}
	public void setCuentaInventario(String cuentaInventario) {
		this.cuentaInventario = cuentaInventario;
	}
	public Integer getNumeroCuotas() {
		return numeroCuotas;
	}
	public String getCodigoZona() {
		return codigoZona;
	}
	public void setCodigoZona(String codigoZona) {
		this.codigoZona = codigoZona;
	}
	public String getTipoNegocio() {
		return tipoNegocio;
	}
	public void setTipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}
	public String getCuentaConsignacionDir() {
		return cuentaConsignacionDir;
	}
	public void setCuentaConsignacionDir(String cuentaConsignacionDir) {
		this.cuentaConsignacionDir = cuentaConsignacionDir;
	}
	public Double getValorConductDir() {
		return valorConductDir;
	}
	public void setValorConductDir(Double valorConductDir) {
		this.valorConductDir = valorConductDir;
	}
	public Double getValorCombustDir() {
		return valorCombustDir;
	}
	public void setValorCombustDir(Double valorCombustDir) {
		this.valorCombustDir = valorCombustDir;
	}
	public Double getValorIndemnizacion() {
		return valorIndemnizacion;
	}
	public void setValorIndemnizacion(Double valorIndemnizacion) {
		this.valorIndemnizacion = valorIndemnizacion;
	}
	public String getTipoFacturaMPP() {
		return tipoFacturaMPP;
	}
	public void setTipoFacturaMPP(String tipoFacturaMPP) {
		this.tipoFacturaMPP = tipoFacturaMPP;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	public String getCuentaObjeto() {
		return cuentaObjeto;
	}
	public void setCuentaObjeto(String cuentaObjeto) {
		this.cuentaObjeto = cuentaObjeto;
	}
	public String getCuentaSubsidiaria() {
		return cuentaSubsidiaria;
	}
	public void setCuentaSubsidiaria(String cuentaSubsidiaria) {
		this.cuentaSubsidiaria = cuentaSubsidiaria;
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
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public Long getBach() {
		return bach;
	}
	public void setBach(Long bach) {
		this.bach = bach;
	}
	public String getCondicionesPago() {
		return condicionesPago;
	}
	public void setCondicionesPago(String condicionesPago) {
		this.condicionesPago = condicionesPago;
	}
//	public String getHechoPor() {
//		return hechoPor;
//	}
//	public void setHechoPor(String hechoPor) {
//		this.hechoPor = hechoPor;
//	}
//	public String getFechaCreacion() {
//		return fechaCreacion;
//	}
//	public void setFechaCreacion(String fechaCreacion) {
//		this.fechaCreacion = fechaCreacion;
//	}
//	public String getHoraCreacion() {
//		return horaCreacion;
//	}
//	public void setHoraCreacion(String horaCreacion) {
//		this.horaCreacion = horaCreacion;
//	}
//	public String getProgramaCreo() {
//		return programaCreo;
//	}
//	public void setProgramaCreo(String programaCreo) {
//		this.programaCreo = programaCreo;
//	}
//	public String getModificadoPor() {
//		return modificadoPor;
//	}
//	public void setModificadoPor(String modificadoPor) {
//		this.modificadoPor = modificadoPor;
//	}
//	public String getFechaModificacion() {
//		return fechaModificacion;
//	}
//	public void setFechaModificacion(String fechaModificacion) {
//		this.fechaModificacion = fechaModificacion;
//	}
//	public String getHoraModificacion() {
//		return horaModificacion;
//	}
//	public void setHoraModificacion(String horaModificacion) {
//		this.horaModificacion = horaModificacion;
//	}
//	public String getPantallaModificacion() {
//		return pantallaModificacion;
//	}
//	public void setPantallaModificacion(String pantallaModificacion) {
//		this.pantallaModificacion = pantallaModificacion;
//	}
//	public String getProgramaModificacion() {
//		return programaModificacion;
//	}
//	public void setProgramaModificacion(String programaModificacion) {
//		this.programaModificacion = programaModificacion;
//	}
	public String getTipoBatch() {
		return tipoBatch;
	}
	public void setTipoBatch(String tipoBatch) {
		this.tipoBatch = tipoBatch;
	}
	public Long getGrupoClienteFacturado() {
		return grupoClienteFacturado;
	}
	public void setGrupoClienteFacturado(Long grupoClienteFacturado) {
		this.grupoClienteFacturado = grupoClienteFacturado;
	}
	public Long getEquipo() {
		return equipo;
	}
	public void setEquipo(Long equipo) {
		this.equipo = equipo;
	}
	public Long getDocumentoContab() {
		return documentoContab;
	}
	public void setDocumentoContab(Long documentoContab) {
		this.documentoContab = documentoContab;
	}
	public String getNumeroReclamo() {
		return numeroReclamo;
	}
	public void setNumeroReclamo(String numeroReclamo) {
		this.numeroReclamo = numeroReclamo;
	}
	
}
