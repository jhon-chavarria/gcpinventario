package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;

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
@Table(name = "GCP_CONF_REALLOCATE_DETAIL", catalog = "SISTEMIP", schema = CollectionScheme.Scheme)
public class GcpConfReallocateDatail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ID_MASTER")
	private int idMaster;

	@Column(name = "USER_FROM")
	private int userFrom;

	@Column(name = "USER_TO")
	private int userTo;

	@Column(name = "QUANTITY")
	private int quantity;

	@Column(name = "STATUS")
	private int status;

	public GcpConfReallocateDatail() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMaster() {
		return idMaster;
	}

	public void setIdMaster(int idMaster) {
		this.idMaster = idMaster;
	}

	public int getUserFrom() {
		return userFrom;
	}

	public void setUserFrom(int userFrom) {
		this.userFrom = userFrom;
	}

	public int getUserTo() {
		return userTo;
	}

	public void setUserTo(int userTo) {
		this.userTo = userTo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
