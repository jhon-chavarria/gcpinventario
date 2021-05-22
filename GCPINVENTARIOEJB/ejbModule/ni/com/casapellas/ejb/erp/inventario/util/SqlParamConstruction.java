package ni.com.casapellas.ejb.erp.inventario.util;

public class SqlParamConstruction {
	private String strBody;
	private String strWhere;
	private int iParameterQuantity = 0;
	
	
	public String getStrBody() {
		return strBody;
	}
	public void setStrBody(String strBody) {
		this.strBody = strBody;
	}
	public String getStrWhere() {
		return strWhere;
	}
	public void setStrWhere(String strWhere) {
		this.strWhere = strWhere;
	}
	public int getiParameterQuantity() {
		return iParameterQuantity;
	}
	public void setiParameterQuantity(int iParameterQuantity) {
		this.iParameterQuantity = iParameterQuantity;
	}
	
	public SqlParamConstruction(String _strBody, int _iParameterQuantity)
	{
		strBody = _strBody;
		iParameterQuantity = _iParameterQuantity;
	}
	

	public SqlParamConstruction(String _strBody, String _strWhere, int _iParameterQuantity)
	{
		this(_strBody, _iParameterQuantity);
		strWhere = _strWhere;
	}

}
