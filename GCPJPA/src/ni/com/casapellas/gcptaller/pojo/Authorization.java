package ni.com.casapellas.gcptaller.pojo;

public class Authorization {
	private String CodUsuario;
	private String AccesoMenu;
	private String AccesoOpcion;
	private String Estado;
	private String CodTaller;
	
	public String getCodUsuario() {
		return CodUsuario;
	}
	public void setCodUsuario(String codUsuario) {
		CodUsuario = codUsuario;
	}
	public String getAccesoMenu() {
		return AccesoMenu;
	}
	public void setAccesoMenu(String accesoMenu) {
		AccesoMenu = accesoMenu;
	}
	public String getAccesoOpcion() {
		return AccesoOpcion;
	}
	public void setAccesoOpcion(String accesoOpcion) {
		AccesoOpcion = accesoOpcion;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public void setCodTaller(String codTaller) {
		CodTaller = codTaller;
	}
	public String getCodTaller() {
		return CodTaller;
	}
	
}
