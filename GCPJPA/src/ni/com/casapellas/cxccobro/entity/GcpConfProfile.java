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
@Table(name = "GCP_CONF_PROFILE", catalog = "SISTEMIP", schema = CollectionScheme.Scheme)
public class GcpConfProfile {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "USER")
	private int user;
	@Column(name = "ID_PROFILE")
	private int idProfile;
	@Column(name = "ID_COMPANY")
	private String idCompany;
	@Column(name = "ID_BRANCH")
	private String idBranch;
	@Column(name = "ID_LINE")
	private String idLine;
	@Column(name = "ID_COLLECTION_GROUP")
	private String idCollectionGroup;
	@Column(name = "ID_CUSTOMER_GROUP")
	private String idCustomerGroup;
	@Column(name = "STATUS")
	private int status;
	@Column(name = "IDUSERS")
	private String idUsers;
	
	@Column(name = "COMPANY_LABEL")
	private String compayLabel;	
	@Column(name = "BRANCH_OFFICE_LABEL")
	private String branchOfficeLabel;	
	@Column(name = "BUSINESS_LINE_LABEL")
	private String businessLineLabel;
	
	@Column(name = "CONFIGURE")
	private int configure;
	@Column(name = "COLLECTOR_ZONE")
	private String collectorZone;
	@Column(name = "CONFIGURE_LWY")
	private int configureLwy;

	public GcpConfProfile() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(int idProfile) {
		this.idProfile = idProfile;
	}

	public String getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(String idCompany) {
		this.idCompany = idCompany;
	}

	public String getIdBranch() {
		return idBranch;
	}

	public void setIdBranch(String idBranch) {
		this.idBranch = idBranch;
	}

	public String getIdLine() {
		return idLine;
	}

	public void setIdLine(String idLine) {
		this.idLine = idLine;
	}

	public String getIdCollectionGroup() {
		return idCollectionGroup;
	}

	public void setIdCollectionGroup(String idCollectionGroup) {
		this.idCollectionGroup = idCollectionGroup;
	}

	public String getIdCustomerGroup() {
		return idCustomerGroup;
	}

	public void setIdCustomerGroup(String idCustomerGroup) {
		this.idCustomerGroup = idCustomerGroup;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(String idUsers) {
		this.idUsers = idUsers;
	}

	public String getCompayLabel() {
		return compayLabel;
	}

	public void setCompayLabel(String compayLabel) {
		this.compayLabel = compayLabel;
	}

	public String getBranchOfficeLabel() {
		return branchOfficeLabel;
	}

	public void setBranchOfficeLabel(String branchOfficeLabel) {
		this.branchOfficeLabel = branchOfficeLabel;
	}

	public String getBusinessLineLabel() {
		return businessLineLabel;
	}

	public void setBusinessLineLabel(String businessLineLabel) {
		this.businessLineLabel = businessLineLabel;
	}

	public int getConfigure() {
		return configure;
	}

	public void setConfigure(int configure) {
		this.configure = configure;
	}

	public String getCollectorZone() {
		return collectorZone;
	}

	public void setCollectorZone(String collectorZone) {
		this.collectorZone = collectorZone;
	}

	public int getConfigureLwy() {
		return configureLwy;
	}

	public void setConfigureLwy(int configureLwy) {
		this.configureLwy = configureLwy;
	}


}
