package ni.com.casapellas.gcpsiade.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the INVMETASN database table.
 * 
 */
@Embeddable
public class InvmetasnPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int group;

	private String valor;

	@Column(name = "ID_SECCION")
	private int idSeccion;

	public InvmetasnPK() {
	}

	public int getGroup() {
		return this.group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getIdSeccion() {
		return this.idSeccion;
	}

	public void setIdSeccion(int idSeccion) {
		this.idSeccion = idSeccion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InvmetasnPK)) {
			return false;
		}
		InvmetasnPK castOther = (InvmetasnPK) other;
		return (this.group == castOther.group)
				&& this.valor.equals(castOther.valor)
				&& (this.idSeccion == castOther.idSeccion);

	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.group;
		hash = hash * prime + this.valor.hashCode();
		hash = hash * prime + this.idSeccion;

		return hash;
	}
}