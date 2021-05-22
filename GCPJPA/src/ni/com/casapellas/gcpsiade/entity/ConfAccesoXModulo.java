package ni.com.casapellas.gcpsiade.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CONF_ACCESO_X_MODULO database table.
 * 
 */
@Entity
@Table(name = "CONF_ACCESO_X_MODULO", catalog = "SYSTEMIP", schema = "GCPSIADE")
public class ConfAccesoXModulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private short activo;

	@Column(name="COD_APP")
	private String codApp;

	@Column(name="COD_MODULO")
	private int codModulo;

	private String key;

    public ConfAccesoXModulo() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public short getActivo() {
		return this.activo;
	}

	public void setActivo(short activo) {
		this.activo = activo;
	}

	public String getCodApp() {
		return this.codApp;
	}

	public void setCodApp(String codApp) {
		this.codApp = codApp;
	}

	public int getCodModulo() {
		return this.codModulo;
	}

	public void setCodModulo(int codModulo) {
		this.codModulo = codModulo;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}