package ni.com.casapellas.erp.jde.pojo;

/**
 * 
 * Descripcion de BusinessLine.java
 * Sistemas: GCPJPA
 * Objetivos: 
 *
 * Fecha Creacion: May 6, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class BusinessLine {
	private String CodLineaNeg;
	private String DescripcionLN;
	private String Division;
	
	private String CodCompania;
	private String CodSucursal;
	
	public String getCodCompania() {
		return CodCompania;
	}
	public void setCodCompania(String codCompania) {
		CodCompania = codCompania;
	}
	public String getCodSucursal() {
		return CodSucursal;
	}
	public void setCodSucursal(String codSucursal) {
		CodSucursal = codSucursal;
	}
	public String getCodLineaNeg() {
		return CodLineaNeg;
	}
	public void setCodLineaNeg(String codLineaNeg) {
		CodLineaNeg = codLineaNeg;
	}
	public String getDescripcionLN() {
		return DescripcionLN;
	}
	public void setDescripcionLN(String descripcionLN) {
		DescripcionLN = descripcionLN;
	}
	public String getDivision() {
		return Division;
	}
	public void setDivision(String division) {
		Division = division;
	}
	
}
