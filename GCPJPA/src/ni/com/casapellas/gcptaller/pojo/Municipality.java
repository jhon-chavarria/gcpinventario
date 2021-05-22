package ni.com.casapellas.gcptaller.pojo;

public class Municipality {
	private String CodPais;
	private String CodDepartamento;
	private String CodMunicipio;
	private String Descripcion;
	
	public String getCodMunicipio() {
		return CodMunicipio;
	}
	public void setCodMunicipio(String codMunicipio) {
		CodMunicipio = codMunicipio;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getCodDepartamento() {
		return CodDepartamento;
	}
	public void setCodDepartamento(String codDepartamento) {
		CodDepartamento = codDepartamento;
	}
	public String getCodPais() {
		return CodPais;
	}
	public void setCodPais(String codPais) {
		CodPais = codPais;
	}
}
