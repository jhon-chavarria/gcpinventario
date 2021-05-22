package ni.com.casapellas.geninfo.pojo;

public class ContactPO {
	private String code;
	private String name;
	private String value;

	public ContactPO() {
	}

	public ContactPO(String code, String name, String value) {
		this.code = code;
		this.name = name;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
