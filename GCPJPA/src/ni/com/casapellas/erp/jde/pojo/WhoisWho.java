package ni.com.casapellas.erp.jde.pojo;

/**
 * 
 * @author Luis Fonseca
 *
 */
public class WhoisWho {
	private int CodCliente;
	private int CodContacto;
	private String NombreContacto;
	private String Email;
	
	public int getCodCliente() {
		return CodCliente;
	}
	public void setCodCliente(int codCliente) {
		CodCliente = codCliente;
	}
	public int getCodContacto() {
		return CodContacto;
	}
	public void setCodContacto(int codContacto) {
		CodContacto = codContacto;
	}
	public String getNombreContacto() {
		return NombreContacto;
	}
	public void setNombreContacto(String nombreContacto) {
		NombreContacto = nombreContacto;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
}
