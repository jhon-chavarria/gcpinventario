package ni.com.casapellas.gcpsisinv.pojo;

public class ConsecutiveNumber {
	private String CodCompania;
	private String Sucursal;
	private String Bodega;
	private String TipoMovimiento; 
	private int NumeroConsecutivo;
	
	public String getCodCompania() {
		return CodCompania;
	}
	public void setCodCompania(String codCompania) {
		CodCompania = codCompania;
	}
	public String getSucursal() {
		return Sucursal;
	}
	public void setSucursal(String sucursal) {
		Sucursal = sucursal;
	}
	public String getBodega() {
		return Bodega;
	}
	public void setBodega(String bodega) {
		Bodega = bodega;
	}
	public String getTipoMovimiento() {
		return TipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		TipoMovimiento = tipoMovimiento;
	}
	public int getNumeroConsecutivo() {
		return NumeroConsecutivo;
	}
	public void setNumeroConsecutivo(int numeroConsecutivo) {
		NumeroConsecutivo = numeroConsecutivo;
	}
	
}
