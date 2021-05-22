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
@Table(name = "GCP_CONF_CUST_PHONE_ND_BUSS_LINE", catalog = "SISTEMIP", schema = CollectionScheme.Scheme)
public class GcpConfCustNDBussLine {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ID_CUST_ND")
	private int idCustNd;
	
	@Column(name = "ID_CUST_CTACT_ND")
	private int idCustCtactNd;

	@Column(name = "BUSINESS_LINE")
	private String businessLine;

	private int status;

	public GcpConfCustNDBussLine() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCustNd() {
		return idCustNd;
	}

	public void setIdCustNd(int idCustNd) {
		this.idCustNd = idCustNd;
	}

	public String getBusinessLine() {
		return businessLine;
	}

	public void setBusinessLine(String businessLine) {
		this.businessLine = businessLine;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIdCustCtactNd() {
		return idCustCtactNd;
	}

	public void setIdCustCtactNd(int idCustCtactNd) {
		this.idCustCtactNd = idCustCtactNd;
	}

}
