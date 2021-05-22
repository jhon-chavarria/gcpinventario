package ni.com.casapellas.gcpfmu.pojo;

public class Brand {
	private String id;
	private String name;
	private String orden;
	private String otros1;
	private String P25;
	private String description;
	private float exchange;
	private int isPriceList;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public String getOtros1() {
		return otros1;
	}
	public void setOtros1(String otros1) {
		this.otros1 = otros1;
	}
	public String getP25() {
		return P25;
	}
	public void setP25(String p25) {
		P25 = p25;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public float getExchange() {
		return exchange;
	}
	public void setExchange(Float exchange) {
		this.exchange = exchange;
	}
	public int getIsPriceList() {
		return isPriceList;
	}
	public void setIsPriceList(int isPriceList) {
		this.isPriceList = isPriceList;
	}
	
}
