package ni.com.casapellas.gcptaller.pojo;

public class OrderPDF {
	private String CodCompania;
	private String CodTaller;
	private int CodCliente;
	private int NoOrden;
	private String ArchivoPDF;
	private String Chasis;
	private int NoPagina;
	
	public String getCodCompania() {
		return CodCompania;
	}
	public void setCodCompania(String codCompania) {
		CodCompania = codCompania;
	}
	public String getCodTaller() {
		return CodTaller;
	}
	public void setCodTaller(String codTaller) {
		CodTaller = codTaller;
	}
	public int getCodCliente() {
		return CodCliente;
	}
	public void setCodCliente(int codCliente) {
		CodCliente = codCliente;
	}
	public int getNoOrden() {
		return NoOrden;
	}
	public void setNoOrden(int noOrden) {
		NoOrden = noOrden;
	}
	public String getArchivoPDF() {
		return ArchivoPDF;
	}
	public void setArchivoPDF(String archivoPDF) {
		ArchivoPDF = archivoPDF;
	}
	public String getChasis() {
		return Chasis;
	}
	public void setChasis(String chasis) {
		Chasis = chasis;
	}
	public int getNoPagina() {
		return NoPagina;
	}
	public void setNoPagina(int noPagina) {
		NoPagina = noPagina;
	}
}
