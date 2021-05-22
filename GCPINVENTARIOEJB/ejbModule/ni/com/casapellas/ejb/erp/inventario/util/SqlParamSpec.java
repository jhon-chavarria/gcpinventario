package ni.com.casapellas.ejb.erp.inventario.util;

public class SqlParamSpec {
	
	String[] sField;
	String[] sConditionType;
	Object[] sValues;
	String[] sDataType;
	String[] sValidationRequired;
	
	
	
	
	
	public SqlParamSpec(String[] sField, String[] sConditionType,
			Object[] sValues, String[] sDataType, String[] sValidationRequired) {
		super();
		this.sField = sField;
		this.sConditionType = sConditionType;
		this.sValues = sValues;
		this.sDataType = sDataType;
		this.sValidationRequired = sValidationRequired;
	}
	
	
	public String[] getsField() {
		return sField;
	}
	public void setsField(String[] sField) {
		this.sField = sField;
	}
	public String[] getsConditionType() {
		return sConditionType;
	}
	public void setsConditionType(String[] sConditionType) {
		this.sConditionType = sConditionType;
	}
	public Object[] getsValues() {
		return sValues;
	}
	public void setsValues(Object[] sValues) {
		this.sValues = sValues;
	}
	public String[] getsDataType() {
		return sDataType;
	}
	public void setsDataType(String[] sDataType) {
		this.sDataType = sDataType;
	}
	public String[] getsValidationRequired() {
		return sValidationRequired;
	}
	public void setsValidationRequired(String[] sValidationRequired) {
		this.sValidationRequired = sValidationRequired;
	}
	
	
	
	
	

}
