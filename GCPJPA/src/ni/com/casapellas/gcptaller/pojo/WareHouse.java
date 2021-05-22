package ni.com.casapellas.gcptaller.pojo;

public class WareHouse {
	private String CodCompania;
	private String CodTaller;
	private String Descripcion;
	private String SucursalInv;
	private String BodegaInv;
	private String Estado;
	
	public String getCodTaller() {
		return CodTaller;
	}
	public void setCodTaller(String codTaller) {
		CodTaller = codTaller;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getSucursalInv() {
		return SucursalInv;
	}
	public void setSucursalInv(String sucursalInv) {
		SucursalInv = sucursalInv;
	}
	public String getBodegaInv() {
		return BodegaInv;
	}
	public void setBodegaInv(String bodegaInv) {
		BodegaInv = bodegaInv;
	}
	public String getCodCompania() {
		return CodCompania;
	}
	public void setCodCompania(String CodCompania) {
		this.CodCompania = CodCompania;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
}
