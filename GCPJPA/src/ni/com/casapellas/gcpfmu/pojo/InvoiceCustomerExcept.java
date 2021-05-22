package ni.com.casapellas.gcpfmu.pojo;

public class InvoiceCustomerExcept implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer codCustomer;
	private String codCurrency;
	
	public InvoiceCustomerExcept() {
		
	}

	public Integer getCodCustomer() {
		return codCustomer;
	}

	public void setCodCustomer(Integer codCustomer) {
		this.codCustomer = codCustomer;
	}

	public String getCodCurrency() {
		return codCurrency;
	}

	public void setCodCurrency(String codCurrency) {
		this.codCurrency = codCurrency;
	}
	
	

}
