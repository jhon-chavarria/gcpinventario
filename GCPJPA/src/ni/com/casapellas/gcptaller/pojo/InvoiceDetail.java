package ni.com.casapellas.gcptaller.pojo;

public class InvoiceDetail {
	private String CodCompania;
	private String CodTaller;
	private String TipoFactura;
	private int NoFactura;
	private int NoOrden;
	private String TipoItem;
	private String CodigoItem;
	private String Estado;
	private String DescripcionItem;
	private int NoRequisa;
	private Double Valor;
	private Double Descuento;
	private Double ValorTotal;
	private String chasis;
	
	private Double Cantidad;
	
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
	public String getTipoItem() {
		return TipoItem;
	}
	public void setTipoItem(String tipoItem) {
		TipoItem = tipoItem;
	}
	public String getCodigoItem() {
		return CodigoItem;
	}
	public void setCodigoItem(String codigoItem) {
		CodigoItem = codigoItem;
	}
	public String getDescripcionItem() {
		return DescripcionItem;
	}
	public void setDescripcionItem(String descripcionItem) {
		DescripcionItem = descripcionItem;
	}
	public int getNoRequisa() {
		return NoRequisa;
	}
	public void setNoRequisa(int noRequisa) {
		NoRequisa = noRequisa;
	}
	public Double getValor() {
		return Valor;
	}
	public void setValor(Double valor) {
		Valor = valor;
	}
	public Double getDescuento() {
		return Descuento;
	}
	public void setDescuento(Double descuento) {
		Descuento = descuento;
	}
	public Double getValorTotal() {
		return ValorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		ValorTotal = valorTotal;
	}
	public String getCodCompania() {
		return CodCompania;
	}
	public void setCodCompania(String codCompania) {
		CodCompania = codCompania;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public Double getCantidad() {
		return Cantidad;
	}
	public void setCantidad(Double cantidad) {
		Cantidad = cantidad;
	}
	public String getChasis() {
		return chasis;
	}
	public void setChasis(String chasis) {
		this.chasis = chasis;
	}
	
}
