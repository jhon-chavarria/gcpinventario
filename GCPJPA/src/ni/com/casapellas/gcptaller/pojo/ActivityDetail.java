package ni.com.casapellas.gcptaller.pojo;

public class ActivityDetail {
	private String CodCompania;
	private String CodSucursal;
	private Integer NoCitas;
	private String CodActividad;
	private String Grupo;
	private Double TiempoAct;
	private Double ValorVac;
	private String DescripcionAct;
	private String Status;
	
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
	public Integer getNoCitas() {
		return NoCitas;
	}
	public void setNoCitas(Integer noCitas) {
		NoCitas = noCitas;
	}
	public String getCodActividad() {
		return CodActividad;
	}
	public void setCodActividad(String codActividad) {
		CodActividad = codActividad;
	}
	public String getGrupo() {
		return Grupo;
	}
	public void setGrupo(String grupo) {
		Grupo = grupo;
	}
	public Double getTiempoAct() {
		return TiempoAct;
	}
	public void setTiempoAct(Double tiempoAct) {
		TiempoAct = tiempoAct;
	}
	public Double getValorVac() {
		return ValorVac;
	}
	public void setValorVac(Double valorVac) {
		ValorVac = valorVac;
	}
	public String getDescripcionAct() {
		return DescripcionAct;
	}
	public void setDescripcionAct(String descripcionAct) {
		DescripcionAct = descripcionAct;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
}
