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
@Table(name="TIPO_VISUALIZACION_INDICADOR", schema = "GCPSIADE")
public class TipoVisualizacionIndicador implements Serializable {
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="TIPO_INDICADOR")
	private String tipoIndicador;

	private String descripcion;

	@OneToMany(mappedBy="tipoVisualizacion")
	private Set<NivelIndicador> nivelIndicadorCollection;

	private static final long serialVersionUID = 1L;

	public TipoVisualizacionIndicador() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoIndicador() {
		return this.tipoIndicador;
	}

	public void setTipoIndicador(String tipoIndicador) {
		this.tipoIndicador = tipoIndicador;
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
