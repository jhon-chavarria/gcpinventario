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
@Table(name="WIDGET", schema = "GCPSIADE")
public class Widget implements Serializable { 
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;

	private String svlt;

	private int modo;

	@ManyToOne
	@JoinColumn(name="TIPO_INDICADOR")
	private TipoIndicador tipoIndicador;

	@ManyToOne
	@JoinColumn(name="ID_INDICADORXUNDNEG")
	private IndicadoresUnidadNegocio idIndicadorxundneg;

	@OneToMany(mappedBy="idWidget")
	private Set<IndexWidgetxusuarioxperfil> indexWidgetxusuarioxperfilCollection;

	private static final long serialVersionUID = 1L;

	public Widget() {
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

	public String getSvlt() {
		return this.svlt;
	}

	public void setSvlt(String svlt) {
		this.svlt = svlt;
	}

	public int getModo() {
		return this.modo;
	}

	public void setModo(int modo) {
		this.modo = modo;
	}

	public TipoIndicador getTipoIndicador() {
		return this.tipoIndicador;
	}

	public void setTipoIndicador(TipoIndicador tipoIndicador) {
		this.tipoIndicador = tipoIndicador;
	}

	public IndicadoresUnidadNegocio getIdIndicadorxundneg() {
		return this.idIndicadorxundneg;
	}

	public void setIdIndicadorxundneg(IndicadoresUnidadNegocio idIndicadorxundneg) {
		this.idIndicadorxundneg = idIndicadorxundneg;
	}

	public Set<IndexWidgetxusuarioxperfil> getIndexWidgetxusuarioxperfilCollection() {
		return this.indexWidgetxusuarioxperfilCollection;
	}

	public void setIndexWidgetxusuarioxperfilCollection(Set<IndexWidgetxusuarioxperfil> indexWidgetxusuarioxperfilCollection) {
		this.indexWidgetxusuarioxperfilCollection = indexWidgetxusuarioxperfilCollection;
	}

}
