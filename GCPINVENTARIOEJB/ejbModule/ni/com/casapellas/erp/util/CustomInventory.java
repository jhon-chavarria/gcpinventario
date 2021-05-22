package ni.com.casapellas.erp.util;

import java.math.BigDecimal;

public class CustomInventory {
	private String articulo;
	private String bodega;
	private BigDecimal cantidad;
	/**
	 * @return the articulo
	 */
	public String getArticulo() {
		return articulo;
	}
	/**
	 * @param articulo the articulo to set
	 */
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	/**
	 * @return the bodega
	 */
	public String getBodega() {
		return bodega;
	}
	/**
	 * @param bodega the bodega to set
	 */
	public void setBodega(String bodega) {
		this.bodega = bodega;
	}
	/**
	 * @return the cantidad
	 */
	public BigDecimal getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * 
	 */
	public CustomInventory() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param articulo
	 * @param bodega
	 * @param cantidad
	 */
	public CustomInventory(String articulo, String bodega, BigDecimal cantidad) {
		super();
		this.articulo = articulo;
		this.bodega = bodega;
		this.cantidad = cantidad;
	}
}
