package ni.com.casapellas.cxccobro.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GcpConfDataProfile {
	private int id;
	private int user;
	private int idProfile;
	private String idCompanies;
	private String idBranchOffices;
	private String idBusinessLine;
	private int collGroupId;
	private String collGroupName;
	private int status;
	private String nomUsuario;
	private String nomPerfil;
	private String idUsers;
	private String rango;
	private String idCgBnCc;
	private String idCustGroup;
	private String nameCustGroup;
	
	private String idCollectionGroup;
	private String idCustomerGroup;
	
	private String companyLabel;	
	private String branchOfficeLabel;	
	private String businessLineLabel;
	
	private int configure;
	private String collectorZone;
	
	private int configureLwy;
	

	public GcpConfDataProfile() {
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

	public String getIdCompanies() {
		return idCompanies;
	}

	public void setIdCompanies(String idCompanies) {
		this.idCompanies = idCompanies;
	}

	public String getIdBranchOffices() {
		return idBranchOffices;
	}

	public void setIdBranchOffices(String idBranchOffices) {
		this.idBranchOffices = idBranchOffices;
	}

	public String getIdBusinessLine() {
		return idBusinessLine;
	}

	public void setIdBusinessLine(String idBusinessLine) {
		this.idBusinessLine = idBusinessLine;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getNomPerfil() {
		return nomPerfil;
	}

	public void setNomPerfil(String nomPerfil) {
		this.nomPerfil = nomPerfil;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public String getCollGroupName() {
		return collGroupName;
	}

	public void setCollGroupName(String collGroupName) {
		this.collGroupName = collGroupName;
	}

	public String getNameCustGroup() {
		return nameCustGroup;
	}

	public void setNameCustGroup(String nameCustGroup) {
		this.nameCustGroup = nameCustGroup;
	}

	public String getIdCgBnCc() {
		return idCgBnCc;
	}

	public void setIdCgBnCc(String idCgBnCc) {
		this.idCgBnCc = idCgBnCc;
	}

	public String getIdCustGroup() {
		return idCustGroup;
	}

	public void setIdCustGroup(String idCustGroup) {
		this.idCustGroup = idCustGroup;
	}

	public int getCollGroupId() {
		return collGroupId;
	}

	public void setCollGroupId(int collGroupId) {
		this.collGroupId = collGroupId;
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

	public String getCompanyLabel() {
		return companyLabel;
	}

	public void setCompanyLabel(String companyLabel) {
		this.companyLabel = companyLabel;
	}

	public String getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(String idUsers) {
		this.idUsers = idUsers;
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
