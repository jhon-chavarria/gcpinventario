package ni.com.casapellas.qs36f.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClientPO {

	private String code;
	private String name;

	public ClientPO() {
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

}
