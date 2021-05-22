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
@Table(name="TIPO_INDICADOR", schema = "GCPSIADE")
public class TipoIndicador implements Serializable {
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;

	@OneToMany(mappedBy="tipoIndicador")
	private Set<Widget> widgetCollection;

	@OneToMany(mappedBy="tipoIndicador")
	private Set<NivelIndicador> nivelIndicadorCollection;

	private static final long serialVersionUID = 1L;

	public TipoIndicador() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Widget> getWidgetCollection() {
		return this.widgetCollection;
	}

	public void setWidgetCollection(Set<Widget> widgetCollection) {
		this.widgetCollection = widgetCollection;
	}

	public Set<NivelIndicador> getNivelIndicadorCollection() {
		return this.nivelIndicadorCollection;
	}

	public void setNivelIndicadorCollection(Set<NivelIndicador> nivelIndicadorCollection) {
		this.nivelIndicadorCollection = nivelIndicadorCollection;
	}

}
