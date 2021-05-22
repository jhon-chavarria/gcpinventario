package ni.com.casapellas.gcptaller.pojo;

public class IndicatorCatalog {
	private String CodCatalogo;
	private String CodItem;
	private String Descripcion;
	private String Orden;
	private String Estado;
	private String CodIcon;
	private String CodIndicador;
	private String CodGrupo;
	
	public String getCodIndicador() {
		return CodIndicador;
	}
	public void setCodIndicador(String codIndicador) {
		CodIndicador = codIndicador;
	}
	public String getCodGrupo() {
		return CodGrupo;
	}
	public void setCodGrupo(String codGrupo) {
		CodGrupo = codGrupo;
	}
	public String getCodCatalogo() {
		return CodCatalogo;
	}
	public void setCodCatalogo(String codCatalogo) {
		CodCatalogo = codCatalogo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getOrden() {
		return Orden;
	}
	public void setOrden(String orden) {
		Orden = orden;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getCodIcon() {
		return CodIcon;
	}
	public void setCodIcon(String codIcon) {
		CodIcon = codIcon;
	}
	public String getCodItem() {
		return CodItem;
	}
	public void setCodItem(String codItem) {
		CodItem = codItem;
	}
}
