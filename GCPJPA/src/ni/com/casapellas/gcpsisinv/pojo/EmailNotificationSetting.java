package ni.com.casapellas.gcpsisinv.pojo;

public class EmailNotificationSetting {
	private String CodCompania;
	private String CodSucursal;
	private String CodBodega;
	private String TipoTransaccion;
	private String EmailPrincipal;
	private String EmailSecundario;
	
	public String getCodCompania() {
		return CodCompania;
	}
	public void setCodCompania(String codCompania) {
		CodCompania = codCompania;
	}
	public String getCodSucursal() {
		return CodSucursal;
	}
	public void setCodSucursal(String codSucursal) {
		CodSucursal = codSucursal;
	}
	public String getCodBodega() {
		return CodBodega;
	}
	public void setCodBodega(String codBodega) {
		CodBodega = codBodega;
	}
	public String getTipoTransaccion() {
		return TipoTransaccion;
	}
	public void setTipoTransaccion(String tipoTransaccion) {
		TipoTransaccion = tipoTransaccion;
	}
	public String getEmailPrincipal() {
		return EmailPrincipal;
	}
	public void setEmailPrincipal(String emailPrincipal) {
		EmailPrincipal = emailPrincipal;
	}
	public String getEmailSecundario() {
		return EmailSecundario;
	}
	public void setEmailSecundario(String emailSecundario) {
		EmailSecundario = emailSecundario;
	}
	
	
}
