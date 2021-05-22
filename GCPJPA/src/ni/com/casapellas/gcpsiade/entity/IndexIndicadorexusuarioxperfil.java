package ni.com.casapellas.gcpsiade.entity; 



import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INDEX_INDICADOREXUSUARIOXPERFIL", schema = "GCPSIADE")
public class IndexIndicadorexusuarioxperfil implements Serializable {
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ID_INDICADOR")
	private int idIndicador;

	private String login;

	@Column(name = "COD_PERFIL")
	private String codPerfil;

	private short tabla;

	private int orden;

	private int nivel;

	@ManyToOne
	@JoinColumn(name = "ID_NIVEL_IND")
	private NivelIndicador idNivelInd;

	private static final long serialVersionUID = 1L;

	public IndexIndicadorexusuarioxperfil() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdIndicador() {
		return this.idIndicador;
	}

	public void setIdIndicador(int idIndicador) {
		this.idIndicador = idIndicador;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getCodPerfil() {
		return this.codPerfil;
	}

	public void setCodPerfil(String codPerfil) {
		this.codPerfil = codPerfil;
	}

	public short getTabla() {
		return this.tabla;
	}

	public void setTabla(short tabla) {
		this.tabla = tabla;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public NivelIndicador getIdNivelInd() {
		return this.idNivelInd;
	}

	public void setIdNivelInd(NivelIndicador idNivelInd) {
		this.idNivelInd = idNivelInd;
	}

}
