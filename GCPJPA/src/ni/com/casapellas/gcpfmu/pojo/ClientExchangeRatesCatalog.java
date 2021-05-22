package ni.com.casapellas.gcpfmu.pojo;

public class ClientExchangeRatesCatalog {
	
	private String id;
	private String name;
	private String orden;
	private String otros1;
	private String P25;
	private float exchange;
	private int initDay;
	private int endDay;

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
	public float getExchange() {
		return exchange;
	}
	public void setExchange(float exchange) {
		this.exchange = exchange;
	}
	public int getInitDay() {
		return initDay;
	}
	public void setInitDay(int initDay) {
		this.initDay = initDay;
	}
	public int getEndDay() {
		return endDay;
	}
	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}
}
