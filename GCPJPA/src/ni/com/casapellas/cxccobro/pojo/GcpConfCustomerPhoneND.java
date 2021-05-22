package ni.com.casapellas.cxccobro.pojo;//ni.com.casapellas.cxccobro.entity.GcpConfCatalogo

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GcpConfCustomerPhoneND {

    private int id;
    private int idCustomerN;
    private int type;
    private int phoneNumber;
    private String contactName;
    private String phoneType;
    private String email = "";
    private int reminder;
    private int accountStatement;
    private int collectionNotice;
    private int status;
    private List<GcpConfCustNDBussLine> lstDet;

    public GcpConfCustomerPhoneND() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCustomerN() {
        return idCustomerN;
    }

    public void setIdCustomerN(int idCustomerN) {
        this.idCustomerN = idCustomerN;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getReminder() {
        return reminder;
    }

    public void setReminder(int reminder) {
        this.reminder = reminder;
    }

    public int getAccountStatement() {
        return accountStatement;
    }

    public void setAccountStatement(int accountStatement) {
        this.accountStatement = accountStatement;
    }

    public int getCollectionNotice() {
        return collectionNotice;
    }

    public void setCollectionNotice(int collectionNotice) {
        this.collectionNotice = collectionNotice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<GcpConfCustNDBussLine> getLstDet() {
        return lstDet;
    }

    public void setLstDet(List<GcpConfCustNDBussLine> lstDet) {
        this.lstDet = lstDet;
    }

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

}
