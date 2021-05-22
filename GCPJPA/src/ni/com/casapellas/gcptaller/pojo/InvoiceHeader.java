package ni.com.casapellas.gcptaller.pojo;

public class InvoiceHeader {
	private String CodCompania;
	private String CodTaller;
	private String TipoFactura;
	private int NoFactura;
	private int NoOrden;
	private Double Descuento;
	private Double IVA;
	private Double TotalFactura;
	private int CodCliente;
	private String chasis;
	private String fechaOrden;
	private String codigoTipoOrden;
	private String descripcionTipoOrden;
	private String fechaFactura;
	
	public String getFechaOrden() {
		return fechaOrden;
	}
	public void setFechaOrden(String fechaOrden) {
		this.fechaOrden = fechaOrden;
	}
	public String getCodigoTipoOrden() {
		return codigoTipoOrden;
	}
	public void setCodigoTipoOrden(String codigoTipoOrden) {
		this.codigoTipoOrden = codigoTipoOrden;
	}
	public String getDescripcionTipoOrden() {
		return descripcionTipoOrden;
	}
	public void setDescripcionTipoOrden(String descripcionTipoOrden) {
		this.descripcionTipoOrden = descripcionTipoOrden;
	}
	public String getCodTaller() {
		return CodTaller;
	}
	public void setCodTaller(String codTaller) {
		CodTaller = codTaller;
	}
	public String getTipoFactura() {
		return TipoFactura;
	}
	public void setTipoFactura(String tipoFactura) {
		TipoFactura = tipoFactura;
	}
	public int getNoFactura() {
		return NoFactura;
	}
	public void setNoFactura(int noFactura) {
		NoFactura = noFactura;
	}
	public int getNoOrden() {
		return NoOrden;
	}
	public void setNoOrden(int noOrden) {
		NoOrden = noOrden;
	}
	public Double getDescuento() {
		return Descuento;
	}
	public void setDescuento(Double descuento) {
		Descuento = descuento;
	}
	public Double getIVA() {
		return IVA;
	}
	public void setIVA(Double iVA) {
		IVA = iVA;
	}
	public Double getTotalFactura() {
		return TotalFactura;
	}
	public void setTotalFactura(Double totalFactura) {
		TotalFactura = totalFactura;
	}
	public int getCodCliente() {
		return CodCliente;
	}
	public void setCodCliente(int codCliente) {
		CodCliente = codCliente;
	}
	public String getCodCompania() {
		return CodCompania;
	}
	public void setCodCompania(String codCompania) {
		CodCompania = codCompania;
	}
	public String getChasis() {
		return chasis;
	}
	public void setChasis(String chasis) {
		this.chasis = chasis;
	}
	public String getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(String fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	
}
