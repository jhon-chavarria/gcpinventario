package ni.com.casapellas.gcpfmu.pojo;

public class DeliveryDeadlines {
	private String codeId;
	private String name;
	private int feeNumber;

	private int daysLimit;
	
	public String getCodeId() {
		return codeId;
	}
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDaysLimit() {
		return daysLimit;
	}
	public void setDaysLimit(int daysLimit) {
		this.daysLimit = daysLimit;
	}
	public int getFeeNumber() {
		return feeNumber;
	}
	public void setFeeNumber(int feeNumber) {
		this.feeNumber = feeNumber;
	}	
}
