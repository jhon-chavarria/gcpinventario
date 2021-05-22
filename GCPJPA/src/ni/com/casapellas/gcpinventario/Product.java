package ni.com.casapellas.gcpinventario;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Vista Productos")
public class Product {
	@ApiModelProperty(value = "Codigo de Compania", dataType = "String")
	private String codigoCompania;
	@ApiModelProperty(value = "Codigo de Articulo", dataType = "String")
	private String codigoArticulo;
	@ApiModelProperty(value = "Descripcion corta del producto", dataType = "String")
	private String descripcionCorta;
	@ApiModelProperty(value = "Descripcion larga del producto", dataType = "String")
	private String descripcionLarga;
	@ApiModelProperty(value = "Campo que indica si se genera un pedido con el articulo", dataType = "String")
	private String codigoPedido;
	@ApiModelProperty(value = "Codigo Agrupador del Articulo", dataType = "String")
	private String codigoAgrupador;
	@ApiModelProperty(value = "Codigo Equivalente del producto", dataType = "String")
	private String codigoEquivalente;
	@ApiModelProperty(value = "Codigo de producto", dataType = "String")
	private String codigoProductoUno;
	@ApiModelProperty(value = "Codigo de Producto", dataType = "String")
	private String codigoProductoDos;
	@ApiModelProperty(value = "Codigo de Aplicacion", dataType = "String")
	private String codigoAplicacion;
	@ApiModelProperty(value = "Codigo de categoria asignada", dataType = "String")
	private String codigoCategoria;
	@ApiModelProperty(value = "Codigo de Arancel", dataType = "String")
	private BigDecimal codigoArancel;
	@ApiModelProperty(value = "Codigo de Partida", dataType = "String")
	private String codigoPartida;
	@ApiModelProperty(value = "Cantidad por Vehiculo", dataType = "String")
	private BigDecimal cantidadXVehiculo;
	@ApiModelProperty(value = "Precio de Venta", dataType = "String")
	private BigDecimal precioVenta;
	@ApiModelProperty(value = "Precio Costo", dataType = "String")
	private BigDecimal precioFob;
	@ApiModelProperty(value = "Piezas en desarme", dataType = "String")
	private BigDecimal piezasDesarme;
	@ApiModelProperty(value = "Unidades por Empaque", dataType = "String")
	private BigDecimal unidadesEmpaque;
	@ApiModelProperty(value = "Codigo de Descuento", dataType = "String")
	private String codigoDescuento;
	@ApiModelProperty(value = "Grupo de Pieza", dataType = "String")
	private String grupoPieza;
	@ApiModelProperty(value = "Codigo de Precio", dataType = "String")
	private String codigoPrecio;
	@ApiModelProperty(value = "Factor de Conversion", dataType = "String")
	private BigDecimal factorConversion;
	@ApiModelProperty(value = "Codigo de Barra", dataType = "String")
	private String codigoBarra;
	@ApiModelProperty(value = "Codigo del Proveedor", dataType = "String")
	private BigDecimal codigoProveedor;
	@ApiModelProperty(value = "Control por Lote", dataType = "String")
	private String controlXLote;
	@ApiModelProperty(value = "Codigo de Marca de Articulo", dataType = "String")
	private String codigoMarcaArticulo;
	@ApiModelProperty(value = "Unidad de medida de compra", dataType = "String")
	private String unidadMedidaCompra;
	@ApiModelProperty(value = "Unidad de medida para almacenaje", dataType = "String")
	private String unidadMedidaAlmacena;
	@ApiModelProperty(value = "Codigo de Linea", dataType = "String")
	private String codigoLinea;
	@ApiModelProperty(value = "Grupo de Marca", dataType = "String")
	private String grupoMarca;
	@ApiModelProperty(value = "Codigo de Marca", dataType = "String")
	private String codigoMarca;
	@ApiModelProperty(value = "Grupo 03", dataType = "String")
	private String grupo03;
	@ApiModelProperty(value = "Grupo 04", dataType = "String")
	private String grupo04;
	@ApiModelProperty(value = "Grupo 05", dataType = "String")
	private String grupo05;
	@ApiModelProperty(value = "Grupo 06", dataType = "String")
	private String grupo06;
	@ApiModelProperty(value = "Grupo 07", dataType = "String")
	private String grupo07;
	@ApiModelProperty(value = "Grupo 08", dataType = "String")
	private String grupo08;
	@ApiModelProperty(value = "Grupo 09", dataType = "String")
	private String grupo09;
	@ApiModelProperty(value = "Grupo 10", dataType = "String")
	private String grupo10;
	@ApiModelProperty(value = "Grupo 11", dataType = "String")
	private String grupo11;
	@ApiModelProperty(value = "Indica si el producto paga IVA", dataType = "String")
	private String pagaIva;
	@ApiModelProperty(value = "Porcentaje de impuesto IVA", dataType = "String")
	private BigDecimal impuestoVenta;
	@ApiModelProperty(value = "Codigo de Barra de la Caja", dataType = "String")
	private String codigoBarraCaja;
	@ApiModelProperty(value = "Estado", dataType = "String")
	private String estado;
	@ApiModelProperty(value = "Usuario que registro el Articulo", dataType = "String")
	private String usuarioInclusion;
	@ApiModelProperty(value = "Fecha de registro del Articulo", dataType = "String")
	private BigDecimal fechaInclusion;
	@ApiModelProperty(value = "Hora de inclusion del Articulo", dataType = "String")
	private BigDecimal horaInclusion;
	@ApiModelProperty(value = "Ultimo usuario que modifico el producto", dataType = "String")
	private String usuarioModificacion;
	@ApiModelProperty(value = "Ultima fecha de modificacion", dataType = "String")
	private BigDecimal fechaModificacion;
	@ApiModelProperty(value = "Ultima hora de modificacion", dataType = "String")
	private BigDecimal horaModificacion;
	
	/**
	 * @return the codigoCompania
	 */
	public String getCodigoCompania() {
		return codigoCompania;
	}
	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	/**
	 * @return the descripcionCorta
	 */
	public String getDescripcionCorta() {
		return descripcionCorta;
	}
	/**
	 * @param descripcionCorta the descripcionCorta to set
	 */
	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}
	/**
	 * @return the descripcionLarga
	 */
	public String getDescripcionLarga() {
		return descripcionLarga;
	}
	/**
	 * @param descripcionLarga the descripcionLarga to set
	 */
	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}
	/**
	 * @return the codigoPedido
	 */
	public String getCodigoPedido() {
		return codigoPedido;
	}
	/**
	 * @param codigoPedido the codigoPedido to set
	 */
	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	/**
	 * @return the codigoAgrupador
	 */
	public String getCodigoAgrupador() {
		return codigoAgrupador;
	}
	/**
	 * @param codigoAgrupador the codigoAgrupador to set
	 */
	public void setCodigoAgrupador(String codigoAgrupador) {
		this.codigoAgrupador = codigoAgrupador;
	}
	/**
	 * @return the codigoEquivalente
	 */
	public String getCodigoEquivalente() {
		return codigoEquivalente;
	}
	/**
	 * @param codigoEquivalente the codigoEquivalente to set
	 */
	public void setCodigoEquivalente(String codigoEquivalente) {
		this.codigoEquivalente = codigoEquivalente;
	}
	/**
	 * @return the codigoProductoUno
	 */
	public String getCodigoProductoUno() {
		return codigoProductoUno;
	}
	/**
	 * @param codigoProductoUno the codigoProductoUno to set
	 */
	public void setCodigoProductoUno(String codigoProductoUno) {
		this.codigoProductoUno = codigoProductoUno;
	}
	/**
	 * @return the codigoProductoDos
	 */
	public String getCodigoProductoDos() {
		return codigoProductoDos;
	}
	/**
	 * @param codigoProductoDos the codigoProductoDos to set
	 */
	public void setCodigoProductoDos(String codigoProductoDos) {
		this.codigoProductoDos = codigoProductoDos;
	}
	/**
	 * @return the codigoAplicacion
	 */
	public String getCodigoAplicacion() {
		return codigoAplicacion;
	}
	/**
	 * @param codigoAplicacion the codigoAplicacion to set
	 */
	public void setCodigoAplicacion(String codigoAplicacion) {
		this.codigoAplicacion = codigoAplicacion;
	}
	/**
	 * @return the codigoCategoria
	 */
	public String getCodigoCategoria() {
		return codigoCategoria;
	}
	/**
	 * @param codigoCategoria the codigoCategoria to set
	 */
	public void setCodigoCategoria(String codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}
	/**
	 * @return the codigoArancel
	 */
	public BigDecimal getCodigoArancel() {
		return codigoArancel;
	}
	/**
	 * @param codigoArancel the codigoArancel to set
	 */
	public void setCodigoArancel(BigDecimal codigoArancel) {
		this.codigoArancel = codigoArancel;
	}
	/**
	 * @return the codigoPartida
	 */
	public String getCodigoPartida() {
		return codigoPartida;
	}
	/**
	 * @param codigoPartida the codigoPartida to set
	 */
	public void setCodigoPartida(String codigoPartida) {
		this.codigoPartida = codigoPartida;
	}
	/**
	 * @return the cantidadXVehiculo
	 */
	public BigDecimal getCantidadXVehiculo() {
		return cantidadXVehiculo;
	}
	/**
	 * @param cantidadXVehiculo the cantidadXVehiculo to set
	 */
	public void setCantidadXVehiculo(BigDecimal cantidadXVehiculo) {
		this.cantidadXVehiculo = cantidadXVehiculo;
	}
	/**
	 * @return the precioVenta
	 */
	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}
	/**
	 * @param precioVenta the precioVenta to set
	 */
	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}
	/**
	 * @return the precioFob
	 */
	public BigDecimal getPrecioFob() {
		return precioFob;
	}
	/**
	 * @param precioFob the precioFob to set
	 */
	public void setPrecioFob(BigDecimal precioFob) {
		this.precioFob = precioFob;
	}
	/**
	 * @return the piezasDesarme
	 */
	public BigDecimal getPiezasDesarme() {
		return piezasDesarme;
	}
	/**
	 * @param piezasDesarme the piezasDesarme to set
	 */
	public void setPiezasDesarme(BigDecimal piezasDesarme) {
		this.piezasDesarme = piezasDesarme;
	}
	/**
	 * @return the unidadesEmpaque
	 */
	public BigDecimal getUnidadesEmpaque() {
		return unidadesEmpaque;
	}
	/**
	 * @param unidadesEmpaque the unidadesEmpaque to set
	 */
	public void setUnidadesEmpaque(BigDecimal unidadesEmpaque) {
		this.unidadesEmpaque = unidadesEmpaque;
	}
	/**
	 * @return the codigoDescuento
	 */
	public String getCodigoDescuento() {
		return codigoDescuento;
	}
	/**
	 * @param codigoDescuento the codigoDescuento to set
	 */
	public void setCodigoDescuento(String codigoDescuento) {
		this.codigoDescuento = codigoDescuento;
	}
	/**
	 * @return the grupoPieza
	 */
	public String getGrupoPieza() {
		return grupoPieza;
	}
	/**
	 * @param grupoPieza the grupoPieza to set
	 */
	public void setGrupoPieza(String grupoPieza) {
		this.grupoPieza = grupoPieza;
	}
	/**
	 * @return the codigoPrecio
	 */
	public String getCodigoPrecio() {
		return codigoPrecio;
	}
	/**
	 * @param codigoPrecio the codigoPrecio to set
	 */
	public void setCodigoPrecio(String codigoPrecio) {
		this.codigoPrecio = codigoPrecio;
	}
	/**
	 * @return the factorConversion
	 */
	public BigDecimal getFactorConversion() {
		return factorConversion;
	}
	/**
	 * @param factorConversion the factorConversion to set
	 */
	public void setFactorConversion(BigDecimal factorConversion) {
		this.factorConversion = factorConversion;
	}
	/**
	 * @return the codigoBarra
	 */
	public String getCodigoBarra() {
		return codigoBarra;
	}
	/**
	 * @param codigoBarra the codigoBarra to set
	 */
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	/**
	 * @return the codigoProveedor
	 */
	public BigDecimal getCodigoProveedor() {
		return codigoProveedor;
	}
	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(BigDecimal codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	/**
	 * @return the controlXLote
	 */
	public String getControlXLote() {
		return controlXLote;
	}
	/**
	 * @param controlXLote the controlXLote to set
	 */
	public void setControlXLote(String controlXLote) {
		this.controlXLote = controlXLote;
	}
	/**
	 * @return the codigoMarcaArticulo
	 */
	public String getCodigoMarcaArticulo() {
		return codigoMarcaArticulo;
	}
	/**
	 * @param codigoMarcaArticulo the codigoMarcaArticulo to set
	 */
	public void setCodigoMarcaArticulo(String codigoMarcaArticulo) {
		this.codigoMarcaArticulo = codigoMarcaArticulo;
	}
	/**
	 * @return the unidadMedidaCompra
	 */
	public String getUnidadMedidaCompra() {
		return unidadMedidaCompra;
	}
	/**
	 * @param unidadMedidaCompra the unidadMedidaCompra to set
	 */
	public void setUnidadMedidaCompra(String unidadMedidaCompra) {
		this.unidadMedidaCompra = unidadMedidaCompra;
	}
	/**
	 * @return the unidadMedidaAlmacena
	 */
	public String getUnidadMedidaAlmacena() {
		return unidadMedidaAlmacena;
	}
	/**
	 * @param unidadMedidaAlmacena the unidadMedidaAlmacena to set
	 */
	public void setUnidadMedidaAlmacena(String unidadMedidaAlmacena) {
		this.unidadMedidaAlmacena = unidadMedidaAlmacena;
	}
	/**
	 * @return the codigoLinea
	 */
	public String getCodigoLinea() {
		return codigoLinea;
	}
	/**
	 * @param codigoLinea the codigoLinea to set
	 */
	public void setCodigoLinea(String codigoLinea) {
		this.codigoLinea = codigoLinea;
	}
	/**
	 * @return the grupoMarca
	 */
	public String getGrupoMarca() {
		return grupoMarca;
	}
	/**
	 * @param grupoMarca the grupoMarca to set
	 */
	public void setGrupoMarca(String grupoMarca) {
		this.grupoMarca = grupoMarca;
	}
	/**
	 * @return the codigoMarca
	 */
	public String getCodigoMarca() {
		return codigoMarca;
	}
	/**
	 * @param codigoMarca the codigoMarca to set
	 */
	public void setCodigoMarca(String codigoMarca) {
		this.codigoMarca = codigoMarca;
	}
	/**
	 * @return the grupo03
	 */
	public String getGrupo03() {
		return grupo03;
	}
	/**
	 * @param grupo03 the grupo03 to set
	 */
	public void setGrupo03(String grupo03) {
		this.grupo03 = grupo03;
	}
	/**
	 * @return the grupo04
	 */
	public String getGrupo04() {
		return grupo04;
	}
	/**
	 * @param grupo04 the grupo04 to set
	 */
	public void setGrupo04(String grupo04) {
		this.grupo04 = grupo04;
	}
	/**
	 * @return the grupo05
	 */
	public String getGrupo05() {
		return grupo05;
	}
	/**
	 * @param grupo05 the grupo05 to set
	 */
	public void setGrupo05(String grupo05) {
		this.grupo05 = grupo05;
	}
	/**
	 * @return the grupo06
	 */
	public String getGrupo06() {
		return grupo06;
	}
	/**
	 * @param grupo06 the grupo06 to set
	 */
	public void setGrupo06(String grupo06) {
		this.grupo06 = grupo06;
	}
	/**
	 * @return the grupo07
	 */
	public String getGrupo07() {
		return grupo07;
	}
	/**
	 * @param grupo07 the grupo07 to set
	 */
	public void setGrupo07(String grupo07) {
		this.grupo07 = grupo07;
	}
	/**
	 * @return the grupo08
	 */
	public String getGrupo08() {
		return grupo08;
	}
	/**
	 * @param grupo08 the grupo08 to set
	 */
	public void setGrupo08(String grupo08) {
		this.grupo08 = grupo08;
	}
	/**
	 * @return the grupo09
	 */
	public String getGrupo09() {
		return grupo09;
	}
	/**
	 * @param grupo09 the grupo09 to set
	 */
	public void setGrupo09(String grupo09) {
		this.grupo09 = grupo09;
	}
	/**
	 * @return the grupo10
	 */
	public String getGrupo10() {
		return grupo10;
	}
	/**
	 * @param grupo10 the grupo10 to set
	 */
	public void setGrupo10(String grupo10) {
		this.grupo10 = grupo10;
	}
	/**
	 * @return the grupo11
	 */
	public String getGrupo11() {
		return grupo11;
	}
	/**
	 * @param grupo11 the grupo11 to set
	 */
	public void setGrupo11(String grupo11) {
		this.grupo11 = grupo11;
	}
	/**
	 * @return the pagaIva
	 */
	public String getPagaIva() {
		return pagaIva;
	}
	/**
	 * @param pagaIva the pagaIva to set
	 */
	public void setPagaIva(String pagaIva) {
		this.pagaIva = pagaIva;
	}
	/**
	 * @return the impuestoVenta
	 */
	public BigDecimal getImpuestoVenta() {
		return impuestoVenta;
	}
	/**
	 * @param impuestoVenta the impuestoVenta to set
	 */
	public void setImpuestoVenta(BigDecimal impuestoVenta) {
		this.impuestoVenta = impuestoVenta;
	}
	/**
	 * @return the codigoBarraCaja
	 */
	public String getCodigoBarraCaja() {
		return codigoBarraCaja;
	}
	/**
	 * @param codigoBarraCaja the codigoBarraCaja to set
	 */
	public void setCodigoBarraCaja(String codigoBarraCaja) {
		this.codigoBarraCaja = codigoBarraCaja;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the usuarioInclusion
	 */
	public String getUsuarioInclusion() {
		return usuarioInclusion;
	}
	/**
	 * @param usuarioInclusion the usuarioInclusion to set
	 */
	public void setUsuarioInclusion(String usuarioInclusion) {
		this.usuarioInclusion = usuarioInclusion;
	}
	/**
	 * @return the fechaInclusion
	 */
	public BigDecimal getFechaInclusion() {
		return fechaInclusion;
	}
	/**
	 * @param fechaInclusion the fechaInclusion to set
	 */
	public void setFechaInclusion(BigDecimal fechaInclusion) {
		this.fechaInclusion = fechaInclusion;
	}
	/**
	 * @return the horaInclusion
	 */
	public BigDecimal getHoraInclusion() {
		return horaInclusion;
	}
	/**
	 * @param horaInclusion the horaInclusion to set
	 */
	public void setHoraInclusion(BigDecimal horaInclusion) {
		this.horaInclusion = horaInclusion;
	}
	/**
	 * @return the usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}
	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
	/**
	 * @return the fechaModificacion
	 */
	public BigDecimal getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(BigDecimal fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	/**
	 * @return the horaModificacion
	 */
	public BigDecimal getHoraModificacion() {
		return horaModificacion;
	}
	/**
	 * @param horaModificacion the horaModificacion to set
	 */
	public void setHoraModificacion(BigDecimal horaModificacion) {
		this.horaModificacion = horaModificacion;
	}

}
