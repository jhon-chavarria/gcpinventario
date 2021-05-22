package ni.com.casapellas.ens.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private String login;
	private int codreg;
	private String nombre;
	private String codper;
	private String nomper;
	private String depart;
	private String title;
	private String token;

	public User() {

	}

	public User(String login, int codreg, String nombre, String codper,
			String nomper, String depart, String title) {
		super();
		this.login = login;
		this.codreg = codreg;
		this.nombre = nombre;
		this.codper = codper;
		this.nomper = nomper;
		this.depart = depart;
		this.title = title;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getCodreg() {
		return codreg;
	}

	public void setCodreg(int codreg) {
		this.codreg = codreg;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodper() {
		return codper;
	}

	public void setCodper(String codper) {
		this.codper = codper;
	}

	public String getNomper() {
		return nomper;
	}

	public void setNomper(String nomper) {
		this.nomper = nomper;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
