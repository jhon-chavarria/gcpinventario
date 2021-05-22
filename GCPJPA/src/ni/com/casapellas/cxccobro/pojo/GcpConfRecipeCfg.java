package ni.com.casapellas.cxccobro.pojo;


public class GcpConfRecipeCfg {
	private int id;
	private String name;
	private String description;
	private int status;
	private double percentage;
	private String activityTypes;

	public GcpConfRecipeCfg() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public String getActivityTypes() {
		return activityTypes;
	}

	public void setActivityTypes(String activityTypes) {
		this.activityTypes = activityTypes;
	}

}
