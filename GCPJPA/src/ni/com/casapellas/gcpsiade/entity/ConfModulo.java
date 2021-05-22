package ni.com.casapellas.gcpsiade.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CONF_MODULOS database table.
 * 
 */
@Entity
@Table(name = "CONF_MODULOS", catalog = "SYSTEMIP", schema = "GCPSIADE")
public class ConfModulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private short activo;

	private String descripcion;

	private String nombre;

    public ConfModulo() {
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

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}