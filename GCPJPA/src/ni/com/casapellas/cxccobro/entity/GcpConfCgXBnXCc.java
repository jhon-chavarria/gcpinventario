package ni.com.casapellas.cxccobro.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import ni.com.casapellas.util.CollectionScheme;

import java.sql.Timestamp;


/**
 * The persistent class for the GCP_CONF_SG_X_BN_X_CC database table.
 * 
 */
@Entity  
@Table(name="GCP_CONF_CG_X_BN_X_CC", schema=CollectionScheme.Scheme)
public class GcpConfCgXBnXCc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@Column(name="ID_BUSINESS_LINE")
	private int idBusinessLine;

	@Column(name="ID_BUSINESS_NAME")
	private int idBusinessName;

	@Column(name="ID_CONFIGURATION_BLOCK")
	private int idConfigurationBlock;

	@Column(name="ID_CREDIT_LINE")
	private int idCreditLine;

	@Column(name="ID_CUSTOMER_CATEGORY")  
	private int idCustomerCategory;

	@Column(name="ID_SEGMENT")
	private int idSegment;

	@Column(name="ID_CUSTOMER_GROUP")
	private int idCustomerGroup;

	private short status;

	@Column(name="USER")
	private String user;

	public GcpConfCgXBnXCc() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getIdBusinessLine() {
		return this.idBusinessLine;
	}

	public void setIdBusinessLine(int idBusinessLine) {
		this.idBusinessLine = idBusinessLine;
	}

	public int getIdBusinessName() {
		return this.idBusinessName;
	}

	public void setIdBusinessName(int idBusinessName) {
		this.idBusinessName = idBusinessName;
	}

	public int getIdConfigurationBlock() {
		return this.idConfigurationBlock;
	}

	public void setIdConfigurationBlock(int idConfigurationBlock) {
		this.idConfigurationBlock = idConfigurationBlock;
	}

	public int getIdCreditLine() {
		return this.idCreditLine;
	}

	public void setIdCreditLine(int idCreditLine) {
		this.idCreditLine = idCreditLine;
	}

	public int getIdCustomerCategory() {
		return this.idCustomerCategory;
	}

	public void setIdCustomerCategory(int idCustomerCategory) {
		this.idCustomerCategory = idCustomerCategory;
	}

	public int getIdSegment() {
		return this.idSegment;
	}

	public void setIdSegment(int idSegment) {
		this.idSegment = idSegment;
	}
	

	public int getIdCustomerGroup() {
		return idCustomerGroup;
	}

	public void setIdCustomerGroup(int idCustomerGroup) {
		this.idCustomerGroup = idCustomerGroup;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}