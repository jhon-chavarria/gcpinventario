package ni.com.casapellas.gcpsisinv.pojo;

public class Proform {
	private String CodCompania;
	private String Linea;
	private String Bodega;
	private int NoProforma;
	private int CodCliente;
	private String NombreCliente;
	private String Chasis;
	private String Modelo;
	private int Cantidad; 
	private String CodItem;
	private String DescripcionItem;
	private String CodCortoVendedor; 
	private int CodVendedor; 
	private double Precio;
	private double TipoCambio; 
	private String Moneda;
	private double PorcImpuesto;
	private double PorcDescuento; 
	private int NoFactura;
	private int FechaFactura;
	private int CantidadFacturada;
	private double PrecioFacturado;
	private int CantPendienteFact;
	
	private int CantReservado;
	
	private String Placa;
	private String Marca;
	private String DescMarca;
	
	private int NoPresupuesto;
	private String FechaProforma;
	private String Sucursalproforma;
	
	private String TipoPresupuesto;
	private String CodTaller;
	private String DescSucursalproforma;
	
	public String getTipoPresupuesto() {
		return TipoPresupuesto;
	}
	public void setTipoPresupuesto(String tipoPresupuesto) {
		TipoPresupuesto = tipoPresupuesto;
	}
	public String getCodTaller() {
		return CodTaller;
	}
	public void setCodTaller(String codTaller) {
		CodTaller = codTaller;
	}
	public String getPlaca() {
		return Placa;
	}
	public void setPlaca(String placa) {
		Placa = placa;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getDescMarca() {
		return DescMarca;
	}
	public void setDescMarca(String descMarca) {
		DescMarca = descMarca;
	}
	public String getChasis() {
		return Chasis;
	}
	public void setChasis(String chasis) {
		Chasis = chasis;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getCodCompania() {
		return CodCompania;
	}
	public void setCodCompania(String codCompania) {
		CodCompania = codCompania;
	}
	public String getLinea() {
		return Linea;
	}
	public void setLinea(String linea) {
		Linea = linea;
	}
	public String getBodega() {
		return Bodega;
	}
	public void setBodega(String bodega) {
		Bodega = bodega;
	}
	public int getNoProforma() {
		return NoProforma;
	}
	public void setNoProforma(int noProforma) {
		NoProforma = noProforma;
	}
	public int getCodCliente() {
		return CodCliente;
	}
	public void setCodCliente(int codCliente) {
		CodCliente = codCliente;
	}
	public String getNombreCliente() {
		return NombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public String getCodItem() {
		return CodItem;
	}
	public void setCodItem(String codItem) {
		CodItem = codItem;
	}
	public String getDescripcionItem() {
		return DescripcionItem;
	}
	public void setDescripcionItem(String descripcionItem) {
		DescripcionItem = descripcionItem;
	}
	public String getCodCortoVendedor() {
		return CodCortoVendedor;
	}
	public void setCodCortoVendedor(String codCortoVendedor) {
		CodCortoVendedor = codCortoVendedor;
	}
	public int getCodVendedor() {
		return CodVendedor;
	}
	public void setCodVendedor(int codVendedor) {
		CodVendedor = codVendedor;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	public double getTipoCambio() {
		return TipoCambio;
	}
	public void setTipoCambio(double tipoCambio) {
		TipoCambio = tipoCambio;
	}
	public String getMoneda() {
		return Moneda;
	}
	public void setMoneda(String moneda) {
		Moneda = moneda;
	}
	public double getPorcImpuesto() {
		return PorcImpuesto;
	}
	public void setPorcImpuesto(double porcImpuesto) {
		PorcImpuesto = porcImpuesto;
	}
	public double getPorcDescuento() {
		return PorcDescuento;
	}
	public void setPorcDescuento(double porcDescuento) {
		PorcDescuento = porcDescuento;
	}
	public int getNoFactura() {
		return NoFactura;
	}
	public void setNoFactura(int noFactura) {
		NoFactura = noFactura;
	}
	public int getCantidadFacturada() {
		return CantidadFacturada;
	}
	public void setCantidadFacturada(int cantidadFacturada) {
		CantidadFacturada = cantidadFacturada;
	}
	public double getPrecioFacturado() {
		return PrecioFacturado;
	}
	public void setPrecioFacturado(double precioFacturado) {
		PrecioFacturado = precioFacturado;
	}
	public int getCantPendienteFact() {
		return CantPendienteFact;
	}
	public void setCantPendienteFact(int cantPendienteFact) {
		CantPendienteFact = cantPendienteFact;
	}
	public int getFechaFactura() {
		return FechaFactura;
	}
	public void setFechaFactura(int fechaFactura) {
		FechaFactura = fechaFactura;
	}
	public int getNoPresupuesto() {
		return NoPresupuesto;
	}
	public void setNoPresupuesto(int noPresupuesto) {
		NoPresupuesto = noPresupuesto;
	}
	public String getFechaProforma() {
		return FechaProforma;
	}
	public void setFechaProforma(String fechaProforma) {
		FechaProforma = fechaProforma;
	}
	public int getCantReservado() {
		return CantReservado;
	}
	public void setCantReservado(int cantReservado) {
		CantReservado = cantReservado;
	}
	public String getSucursalproforma() {
		return Sucursalproforma;
	}
	public void setSucursalproforma(String sucursalproforma) {
		Sucursalproforma = sucursalproforma;
	}
	public String getDescSucursalproforma() {
		return DescSucursalproforma;
	}
	public void setDescSucursalproforma(String descSucursalproforma) {
		DescSucursalproforma = descSucursalproforma;
	}
}
