/**
 * 
 */
package ni.com.casapellas.gcptaller.pojo;

/**
 * Compania       :  Casa Pellas S,A.
 * Sistema        :  Talleres
 * Objetivo       :  
 * Fecha Creacion :  06/02/2015 11:19:48
 * Modificado Por :  Luis Fonseca
 * @author        :  Luis Fonseca
 * @version       :  1.0
 * @since         :
 * @see           :  http://www.casapellas.com.ni 
 */

public class MaintenanceKit {
	private String Marca;
	private String Modelo;
	private String TipoVehiculo; 
	private String Combustible;
	private String Categoria; 
	private String CodKit; 
	private String TipoMantenimiento; 
	private String TipoItem; 
	private String CodItem;
	private String DescripcionItem;
	private int Cantidad;
	private double Precio;
	private double PrecioActividad;
	private double DuracionActividad;
	
	private String ClasifActiv;
	private String EsReal;
	
	public double getDuracionActividad() {
		return DuracionActividad;
	}
	public void setDuracionActividad(double duracionActividad) {
		DuracionActividad = duracionActividad;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getTipoVehiculo() {
		return TipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		TipoVehiculo = tipoVehiculo;
	}
	public String getCombustible() {
		return Combustible;
	}
	public void setCombustible(String combustible) {
		Combustible = combustible;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	public String getCodKit() {
		return CodKit;
	}
	public void setCodKit(String codKit) {
		CodKit = codKit;
	}
	public String getTipoMantenimiento() {
		return TipoMantenimiento;
	}
	public void setTipoMantenimiento(String tipoMantenimiento) {
		TipoMantenimiento = tipoMantenimiento;
	}
	public String getTipoItem() {
		return TipoItem;
	}
	public void setTipoItem(String tipoItem) {
		TipoItem = tipoItem;
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
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	
	public double getPrecioActividad() {
		return PrecioActividad;
	}
	public void setPrecioActividad(double precioActividad) {
		PrecioActividad = precioActividad;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	public String getClasifActiv() {
		return ClasifActiv;
	}
	public void setClasifActiv(String clasifActiv) {
		ClasifActiv = clasifActiv;
	}
	public String getEsReal() {
		return EsReal;
	}
	public void setEsReal(String esReal) {
		EsReal = esReal;
	}
}
