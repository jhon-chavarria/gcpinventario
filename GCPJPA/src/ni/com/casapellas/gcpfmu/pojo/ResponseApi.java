package ni.com.casapellas.gcpfmu.pojo;

import java.util.List;

public class ResponseApi {
	
	private int error;
	private String message;
	
	// For login
	private User user;
	
	private SellerConfig sellerConfig;
	
	private List<Section> sections;
	
	 // Init Day
    private int initDayId;
	
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public SellerConfig getSellerConfig() {
		return sellerConfig;
	}
	public void setSellerConfig(SellerConfig sellerConfig) {
		this.sellerConfig = sellerConfig;
	}
	public int getInitDayId() {
		return initDayId;
	}
	public void setInitDayId(int initDayId) {
		this.initDayId = initDayId;
	}
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

}
