package ni.com.casapellas.gcptaller.pojo;

import java.util.Date;

public class Indicator {
	private String CodIndicador;
	private String DescIndicador;
	private String TipoDato;
	private String TipoControl;
	private String CodGrupo;
	private String Orden;
	private String SubOrden;
	private String CodCatalogInd;
	private String CodNivelCatalog;
	private String LongitudVal;
	private String EstadoReg;
	private String Requerido;
	private Date FechaUltimaMod;
	
	public String getCodIndicador() {
		return CodIndicador;
	}
	public void setCodIndicador(String codIndicador) {
		CodIndicador = codIndicador;
	}
	public String getDescIndicador() {
		return DescIndicador;
	}
	public void setDescIndicador(String descIndicador) {
		DescIndicador = descIndicador;
	}
	public String getTipoDato() {
		return TipoDato;
	}
	public void setTipoDato(String tipoDato) {
		TipoDato = tipoDato;
	}
	public String getTipoControl() {
		return TipoControl;
	}
	public void setTipoControl(String tipoControl) {
		TipoControl = tipoControl;
	}
	public String getCodGrupo() {
		return CodGrupo;
	}
	public void setCodGrupo(String codGrupo) {
		CodGrupo = codGrupo;
	}
	public String getOrden() {
		return Orden;
	}
	public void setOrden(String orden) {
		Orden = orden;
	}
	public String getSubOrden() {
		return SubOrden;
	}
	public void setSubOrden(String subOrden) {
		SubOrden = subOrden;
	}
	public String getCodCatalogInd() {
		return CodCatalogInd;
	}
	public void setCodCatalogInd(String codCatalogInd) {
		CodCatalogInd = codCatalogInd;
	}
	public String getLongitudVal() {
		return LongitudVal;
	}
	public void setLongitudVal(String longitudVal) {
		LongitudVal = longitudVal;
	}
	public String getEstadoReg() {
		return EstadoReg;
	}
	public void setEstadoReg(String estadoReg) {
		EstadoReg = estadoReg;
	}
	public String getCodNivelCatalog() {
		return CodNivelCatalog;
	}
	public void setCodNivelCatalog(String codNivelCatalog) {
		CodNivelCatalog = codNivelCatalog;
	}
	public String getRequerido() {
		return Requerido;
	}
	public void setRequerido(String requerido) {
		Requerido = requerido;
	}
	public Date getFechaUltimaMod() {
		return FechaUltimaMod;
	}
	public void setFechaUltimaMod(Date fechaUltimaMod) {
		FechaUltimaMod = fechaUltimaMod;
	}
	
}
