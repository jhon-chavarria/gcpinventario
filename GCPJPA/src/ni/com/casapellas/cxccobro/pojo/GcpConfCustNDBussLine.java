package ni.com.casapellas.cxccobro.pojo;//ni.com.casapellas.cxccobro.entity.GcpConfCatalogo

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GcpConfCustNDBussLine {

    private int id;
    private int idCustNd;
    private int idCustCtactNd;
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
