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
@Table(name="NIVEL_INDICADOR", schema = "GCPSIADE")
public class NivelIndicador implements Serializable {
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;

	private int nivel;

	private String svlt;

	@Column(name="PARAMETRO_NIVEL")
	private short parametroNivel;

	private int modo;

	@ManyToOne
	@JoinColumn(name="TIPO_VISUALIZACION")
	private TipoVisualizacionIndicador tipoVisualizacion;

	@ManyToOne
	@JoinColumn(name="ID_INDICADORXUND", referencedColumnName="ID")
	private IndicadoresxindicadorUnidadNegocio idIndicadorxund;

	@ManyToOne
	@JoinColumn(name="TIPO_INDICADOR")
	private TipoIndicador tipoIndicador;

	@ManyToOne
	@JoinColumn(name="TIPO_GRAFICO")
	private TipoGrafico tipoGrafico;

	@OneToMany(mappedBy="idNivelInd")
	private Set<IndexIndicadorexusuarioxperfil> indexIndicadorexusuarioxperfilCollection;

	private static final long serialVersionUID = 1L;

	public NivelIndicador() {
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

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getSvlt() {
		return this.svlt;
	}

	public void setSvlt(String svlt) {
		this.svlt = svlt;
	}

	public short getParametroNivel() {
		return this.parametroNivel;
	}

	public void setParametroNivel(short parametroNivel) {
		this.parametroNivel = parametroNivel;
	}

	public int getModo() {
		return this.modo;
	}

	public void setModo(int modo) {
		this.modo = modo;
	}

	public TipoVisualizacionIndicador getTipoVisualizacion() {
		return this.tipoVisualizacion;
	}

	public void setTipoVisualizacion(TipoVisualizacionIndicador tipoVisualizacion) {
		this.tipoVisualizacion = tipoVisualizacion;
	}

	public IndicadoresxindicadorUnidadNegocio getIdIndicadorxund() {
		return this.idIndicadorxund;
	}

	public void setIdIndicadorxund(IndicadoresxindicadorUnidadNegocio idIndicadorxund) {
		this.idIndicadorxund = idIndicadorxund;
	}

	public TipoIndicador getTipoIndicador() {
		return this.tipoIndicador;
	}

	public void setTipoIndicador(TipoIndicador tipoIndicador) {
		this.tipoIndicador = tipoIndicador;
	}

	public TipoGrafico getTipoGrafico() {
		return this.tipoGrafico;
	}

	public void setTipoGrafico(TipoGrafico tipoGrafico) {
		this.tipoGrafico = tipoGrafico;
	}

	public Set<IndexIndicadorexusuarioxperfil> getIndexIndicadorexusuarioxperfilCollection() {
		return this.indexIndicadorexusuarioxperfilCollection;
	}

	public void setIndexIndicadorexusuarioxperfilCollection(Set<IndexIndicadorexusuarioxperfil> indexIndicadorexusuarioxperfilCollection) {
		this.indexIndicadorexusuarioxperfilCollection = indexIndicadorexusuarioxperfilCollection;
	}

}
