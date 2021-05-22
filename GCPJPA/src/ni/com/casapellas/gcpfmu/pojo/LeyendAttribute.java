package ni.com.casapellas.gcpfmu.pojo;

public class LeyendAttribute implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String code;
	private String name;
	private String shortName;

	public LeyendAttribute() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
