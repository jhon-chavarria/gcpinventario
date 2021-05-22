package ni.com.casapellas.cxccobro.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GenericItemPojo {
	private int iCode;
	private String sCode;
	private String sName;
	private int iValue;

	public GenericItemPojo() {
	}

	public int getiCode() {
		return iCode;
	}

	public void setiCode(int iCode) {
		this.iCode = iCode;
	}

	public String getsCode() {
		return sCode;
	}

	public void setsCode(String sCode) {
		this.sCode = sCode;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getiValue() {
		return iValue;
	}

	public void setiValue(int iValue) {
		this.iValue = iValue;
	}


}
