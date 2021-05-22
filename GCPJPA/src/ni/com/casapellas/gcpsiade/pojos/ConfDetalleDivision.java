package ni.com.casapellas.gcpsiade.pojos;

public class ConfDetalleDivision {
	private int idDivision;
	private int codEmpleado;
	private String codLinea;
	private String nombreDivision;
	private String codigoLineaInv;

	public ConfDetalleDivision() {

	}

	public int getIdDivision() {
		return idDivision;
	}

	public void setIdDivision(int idDivision) {
		this.idDivision = idDivision;
	}

	public String getCodLinea() {
		return codLinea;
	}

	public void setCodLinea(String codLinea) {
		this.codLinea = codLinea;
	}

	public String getNombreDivision() {
		return nombreDivision;
	}

	public void setNombreDivision(String nombreDivision) {
		this.nombreDivision = nombreDivision;
	}

	public int getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getCodigoLineaInv() {
		return codigoLineaInv;
	}

	public void setCodigoLineaInv(String codigoLineaInv) {
		this.codigoLineaInv = codigoLineaInv;
	}

}
