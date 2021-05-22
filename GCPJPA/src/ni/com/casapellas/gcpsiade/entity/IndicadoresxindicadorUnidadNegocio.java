package ni.com.casapellas.gcpsiade.entity;



import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="INDICADORESXINDICADOR_UNIDAD_NEGOCIO", schema = "GCPSIADE")
public class IndicadoresxindicadorUnidadNegocio implements Serializable {
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="COD_SECCION")
	private String codSeccion;

	@ManyToOne
	@JoinColumn(name="ID_IND_UND")
	private IndicadoresUnidadNegocio idIndUnd;

	@OneToMany(mappedBy="idIndicadorxund")
	private Set<NivelIndicador> nivelIndicadorCollection;

	private static final long serialVersionUID = 1L;

	public IndicadoresxindicadorUnidadNegocio() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodSeccion() {
		return this.codSeccion;
	}

	public void setCodSeccion(String codSeccion) {
		this.codSeccion = codSeccion;
	}

	public IndicadoresUnidadNegocio getIdIndUnd() {
		return this.idIndUnd;
	}

	public void setIdIndUnd(IndicadoresUnidadNegocio idIndUnd) {
		this.idIndUnd = idIndUnd;
	}

	public Set<NivelIndicador> getNivelIndicadorCollection() {
		return this.nivelIndicadorCollection;
	}

	public void setNivelIndicadorCollection(Set<NivelIndicador> nivelIndicadorCollection) {
		this.nivelIndicadorCollection = nivelIndicadorCollection;
	}

}
