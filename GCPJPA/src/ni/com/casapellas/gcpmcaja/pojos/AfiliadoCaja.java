package ni.com.casapellas.gcpmcaja.pojos;

public class AfiliadoCaja {

	private int Caja;
	private String CodigoAfiliado;
	private String Afiliado;
	private String UnidadNegocio;
	private String CodigoCompaniaJDE;
	private String LineaNegocio;
	private double PorcentajeComision;
	private String Estado;
	private int CodigoBanco;
	private int CalificarMarca;
	private String moneda;
	
	private String sucursalCaja;
	private long cajeroTitular;
	
	private String codigoTerminal;
	
	public String getSucursalCaja() {
		return sucursalCaja;
	}
	public void setSucursalCaja(String sucursalCaja) {
		this.sucursalCaja = sucursalCaja;
	}
	public long getCajeroTitular() {
		return cajeroTitular;
	}
	public void setCajeroTitular(long cajeroTitular) {
		this.cajeroTitular = cajeroTitular;
	}
	public String getCodigoTerminal() {
		return codigoTerminal;
	}
	public void setCodigoTerminal(String codigoTerminal) {
		this.codigoTerminal = codigoTerminal;
	}
	public int getCodigoBanco() {
		return CodigoBanco;
	}
	public void setCodigoBanco(int codigoBanco) {
		CodigoBanco = codigoBanco;
	}
	public int getCalificarMarca() {
		return CalificarMarca;
	}
	public void setCalificarMarca(int calificarMarca) {
		CalificarMarca = calificarMarca;
	}
	public int getCaja() {
		return Caja;
	}
	public void setCaja(int caja) {
		Caja = caja;
	}
	public String getCodigoAfiliado() {
		return CodigoAfiliado;
	}
	public void setCodigoAfiliado(String codigoAfiliado) {
		CodigoAfiliado = codigoAfiliado;
	}
	public String getAfiliado() {
		return Afiliado;
	}
	public void setAfiliado(String afiliado) {
		Afiliado = afiliado;
	}
	public String getUnidadNegocio() {
		return UnidadNegocio;
	}
	public void setUnidadNegocio(String unidadNegocio) {
		UnidadNegocio = unidadNegocio;
	}
	public String getCodigoCompaniaJDE() {
		return CodigoCompaniaJDE;
	}
	public void setCodigoCompaniaJDE(String codigoCompaniaJDE) {
		CodigoCompaniaJDE = codigoCompaniaJDE;
	}
	public String getLineaNegocio() {
		return LineaNegocio;
	}
	public void setLineaNegocio(String lineaNegocio) {
		LineaNegocio = lineaNegocio;
	}
	public double getPorcentajeComision() {
		return PorcentajeComision;
	}
	public void setPorcentajeComision(double porcentajeComision) {
		PorcentajeComision = porcentajeComision;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}


}
