package ni.com.casapellas.gcpsiade.entity;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TIPO_GRAFICO", schema = "GCPSIADE")
public class TipoGrafico implements Serializable {
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	@OneToMany(mappedBy="tipoGrafico")
	private Set<NivelIndicador> nivelIndicadorCollection;

	private static final long serialVersionUID = 1L;

	public TipoGrafico() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<NivelIndicador> getNivelIndicadorCollection() {
		return this.nivelIndicadorCollection;
	}

	public void setNivelIndicadorCollection(Set<NivelIndicador> nivelIndicadorCollection) {
		this.nivelIndicadorCollection = nivelIndicadorCollection;
	}

}
