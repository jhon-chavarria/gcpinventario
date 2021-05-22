package ni.com.casapellas.geninfo.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SimpleStructPO {

	private String code;
	private String codeAlt1;
	private String codeAlt2;
	private String name;
	private String description;
	private double valuenumeric;

	public SimpleStructPO() {
	}

	public SimpleStructPO(String code, String name, String description, String codeAlt1) {
		this.code = code;
		this.name = name;
		this.description = description;
	}

	public SimpleStructPO(String code, String name, String description,
			double valuenumeric) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.valuenumeric = valuenumeric;
	}
	
	

	public SimpleStructPO(String code, String codeAlt1, String codeAlt2,
			String name, String description, double valuenumeric) {
		super();
		this.code = code;
		this.codeAlt1 = codeAlt1;
		this.codeAlt2 = codeAlt2;
		this.name = name;
		this.description = description;
		this.valuenumeric = valuenumeric;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getValuenumeric() {
		return valuenumeric;
	}

	public void setValuenumeric(double valuenumeric) {
		this.valuenumeric = valuenumeric;
	}

	public String getCodeAlt1() {
		return codeAlt1;
	}

	public void setCodeAlt1(String codeAlt1) {
		this.codeAlt1 = codeAlt1;
	}

	public String getCodeAlt2() {
		return codeAlt2;
	}

	public void setCodeAlt2(String codeAlt2) {
		this.codeAlt2 = codeAlt2;
	}

}
