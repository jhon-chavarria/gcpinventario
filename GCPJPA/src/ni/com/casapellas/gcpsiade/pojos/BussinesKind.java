package ni.com.casapellas.gcpsiade.pojos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BussinesKind {

	private String code;
	private String name;

	public BussinesKind() {
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

	@Override
	public String toString() {
		return "ClientPO [code=" + code + ", name=" + name + "]";
	}

}
