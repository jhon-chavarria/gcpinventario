package ni.com.casapellas.gcpinventario;

public class ProductInfoLocation {
	private String codigoCompania;
	private String codigoSucursal;
	private String codigoLinea;
	private String codigoBodega;
	private String codigoArticulo;
	private String ubicacionActual;
	private String ubicacionAnterior;
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
	 * @return the codigoSucursal
	 */
	public String getCodigoSucursal() {
		return codigoSucursal;
	}
	/**
	 * @param codigoSucursal the codigoSucursal to set
	 */
	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
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
	 * @return the codigoBodega
	 */
	public String getCodigoBodega() {
		return codigoBodega;
	}
	/**
	 * @param codigoBodega the codigoBodega to set
	 */
	public void setCodigoBodega(String codigoBodega) {
		this.codigoBodega = codigoBodega;
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
	 * @return the ubicacionActual
	 */
	public String getUbicacionActual() {
		return ubicacionActual;
	}
	/**
	 * @param ubicacionActual the ubicacionActual to set
	 */
	public void setUbicacionActual(String ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
	}
	/**
	 * @return the ubicacionAnterior
	 */
	public String getUbicacionAnterior() {
		return ubicacionAnterior;
	}
	/**
	 * @param ubicacionAnterior the ubicacionAnterior to set
	 */
	public void setUbicacionAnterior(String ubicacionAnterior) {
		this.ubicacionAnterior = ubicacionAnterior;
	}
	/**
	 * 
	 */
	public ProductInfoLocation() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param codigoCompania
	 * @param codigoSucursal
	 * @param codigoLinea
	 * @param codigoBodega
	 * @param codigoArticulo
	 * @param ubicacionActual
	 * @param ubicacionAnterior
	 */
	public ProductInfoLocation(String codigoCompania, String codigoSucursal, String codigoLinea, String codigoBodega,
			String codigoArticulo, String ubicacionActual, String ubicacionAnterior) {
		super();
		this.codigoCompania = codigoCompania;
		this.codigoSucursal = codigoSucursal;
		this.codigoLinea = codigoLinea;
		this.codigoBodega = codigoBodega;
		this.codigoArticulo = codigoArticulo;
		this.ubicacionActual = ubicacionActual;
		this.ubicacionAnterior = ubicacionAnterior;
	}
	
}
