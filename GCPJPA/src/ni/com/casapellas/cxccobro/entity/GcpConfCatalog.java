package ni.com.casapellas.cxccobro.entity;//ni.com.casapellas.cxccobro.entity.GcpConfCatalogo

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
@Table(name = "GCP_CONF_CATALOG", catalog = "SISTEMIP", schema = CollectionScheme.Scheme)
public class GcpConfCatalog {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="ID_PARENT")
	private int idParent;
	private String code;
	private String name;
	private String description;
	@Column(name="ID_HIERARCHY")
	private int idHierarchy;
	private int editable;
	private int status;
	private int visible;
	@Column(name="CODE_HIERARCHY")
	private String codeHierarchy = "";
	
	public GcpConfCatalog() {
	}
	
	public int getStatus() {  
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdParent() {
		return idParent;
	}

	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEditable() {
		return editable;
	}

	public void setEditable(int editable) {
		this.editable = editable;
	}
 

	public int getVisible() {
		return visible;
	}

	public void setVisible(int visible) {
		this.visible = visible;
	}

	public int getIdHierarchy() {
		return idHierarchy;
	}

	public void setIdHierarchy(int idHierarchy) {
		this.idHierarchy = idHierarchy;
	}

	public String getCodeHierarchy() {
		return codeHierarchy;
	}

	public void setCodeHierarchy(String codeHierarchy) {
		this.codeHierarchy = codeHierarchy;
	}

	

}
