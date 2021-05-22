package ni.com.casapellas.cxccobro.pojo;

import java.io.Serializable;


public class GcpConfCustomerXSegmentGroup implements Serializable {

	private int customer_Code;
	private int id_Segment_Group;
	private short status;

	public GcpConfCustomerXSegmentGroup() {
	}

	public int getCustomer_Code() {
		return customer_Code;
	}

	public void setCustomer_Code(int customer_Code) {
		this.customer_Code = customer_Code;
	}

	public int getId_Segment_Group() {
		return id_Segment_Group;
	}

	public void setId_Segment_Group(int id_Segment_Group) {
		this.id_Segment_Group = id_Segment_Group;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	

}