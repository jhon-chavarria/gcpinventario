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
@Table(name="INDEX_WIDGETXUSUARIOXPERFIL", schema = "GCPSIADE")
public class IndexWidgetxusuarioxperfil implements Serializable {
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int modo;

	private int orden;
	
	private String usuario;

	private String perfil;

	@ManyToOne
	@JoinColumn(name="ID_WIDGET")
	private Widget idWidget;

	private static final long serialVersionUID = 1L;

	public IndexWidgetxusuarioxperfil() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getModo() {
		return this.modo;
	}

	public void setModo(int modo) {
		this.modo = modo;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPerfil() {
		return this.perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Widget getIdWidget() {
		return this.idWidget;
	}

	public void setIdWidget(Widget idWidget) {
		this.idWidget = idWidget;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public int getOrden() {
		return orden;
	}

}
