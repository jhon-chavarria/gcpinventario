package ni.com.casapellas.gcpsiade.pojos;

public class PendingOrdersP {

	private int npedid;
	private int canped;
	private String arrive_date;
	private String order_date;
	private String type;
	private String user;
	private String state;

	public int getCanped() {
		return canped;
	}

	public String getArrive_date() {
		return arrive_date;
	}

	public String getOrder_date() {
		return order_date;
	}

	public String getType() {
		return type;
	}

	public String getUser() {
		return user;
	}

	public String getState() {
		return state;
	}

	public void setCanped(int canped) {
		this.canped = canped;
	}

	public void setArrive_date(String arrive_date) {
		this.arrive_date = arrive_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getNpedid() {
		return npedid;
	}

	public void setNpedid(int npedid) {
		this.npedid = npedid;
	}

}
