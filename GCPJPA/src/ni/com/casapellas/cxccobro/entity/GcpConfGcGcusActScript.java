package ni.com.casapellas.cxccobro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import ni.com.casapellas.util.CollectionScheme;

@XmlRootElement
@Entity
@Table(name = "GCP_CONF_GC_X_GCUST_X_ACT_X_SCRIPT", catalog = "SISTEMIP", schema = CollectionScheme.Scheme)
public class GcpConfGcGcusActScript {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "ID_RECIPE")
	private int idRecipe;
	@Column(name = "ID_CATALOG_DEF")
	private int idCatalogDef;
	@Column(name = "ID_CATALOG_VALUE")
	private int idCatalogValue;
	@Column(name = "STATUS")
	private int status;

	public GcpConfGcGcusActScript() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdRecipe() {
		return idRecipe;
	}

	public void setIdRecipe(int idRecipe) {
		this.idRecipe = idRecipe;
	}

	public int getIdCatalogDef() {
		return idCatalogDef;
	}

	public void setIdCatalogDef(int idCatalogDef) {
		this.idCatalogDef = idCatalogDef;
	}

	public int getIdCatalogValue() {
		return idCatalogValue;
	}

	public void setIdCatalogValue(int idCatalogValue) {
		this.idCatalogValue = idCatalogValue;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
