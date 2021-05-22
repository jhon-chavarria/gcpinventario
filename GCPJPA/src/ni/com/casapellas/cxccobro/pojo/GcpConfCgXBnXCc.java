package ni.com.casapellas.cxccobro.pojo;

import java.io.Serializable;

public class GcpConfCgXBnXCc implements Serializable {
	private int id_Business_Name;
	private int id_Customer_Category;
	private int id_Customer_Group;
	private short status;

	public GcpConfCgXBnXCc() {
	}

	public int getId_Business_Name() {
		return id_Business_Name;  
	}

	public void setId_Business_Name(int id_Business_Name) {
		this.id_Business_Name = id_Business_Name;
	}

	public int getId_Customer_Category() {
		return id_Customer_Category;
	}

	public void setId_Customer_Category(int id_Customer_Category) {
		this.id_Customer_Category = id_Customer_Category;
	}


	public int getId_Customer_Group() {
		return id_Customer_Group;
	}

	public void setId_Customer_Group(int id_Customer_Group) {
		this.id_Customer_Group = id_Customer_Group;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}  

	

}