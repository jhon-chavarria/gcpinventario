package ni.com.casapellas.gcptaller.pojo;

public class Department {
	private String CodPais;
	private String CodDepartamento;
	private String Descripcion;
	
	public String getCodDepartamento() {
		return CodDepartamento;
	}
	public void setCodDepartamento(String codDepartamento) {
		CodDepartamento = codDepartamento;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getCodPais() {
		return CodPais;
	}
	public void setCodPais(String codPais) {
		CodPais = codPais;
	}
}
