package ni.com.casapellas.gcptaller.pojo;

public class PhotosDamage {
	private String CodCompania;
	private String CodTaller;
	private int NoOrden;
	private String CodAreaImgCoord;
	private String CodDanio;
	private String Foto1;
	private String Foto2;
	private String Foto3;
	private int PosicionX;
	private int PosicionY;
	
	public int getPosicionX() {
		return PosicionX;
	}
	public void setPosicionX(int posicionX) {
		PosicionX = posicionX;
	}
	public int getPosicionY() {
		return PosicionY;
	}
	public void setPosicionY(int posicionY) {
		PosicionY = posicionY;
	}
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
	public String getCodAreaImgCoord() {
		return CodAreaImgCoord;
	}
	public void setCodAreaImgCoord(String codAreaImgCoord) {
		CodAreaImgCoord = codAreaImgCoord;
	}
	public String getCodDanio() {
		return CodDanio;
	}
	public void setCodDanio(String codDanio) {
		CodDanio = codDanio;
	}
	public String getFoto1() {
		return Foto1;
	}
	public void setFoto1(String foto1) {
		Foto1 = foto1;
	}
	public String getFoto2() {
		return Foto2;
	}
	public void setFoto2(String foto2) {
		Foto2 = foto2;
	}
	public String getFoto3() {
		return Foto3;
	}
	public void setFoto3(String foto3) {
		Foto3 = foto3;
	}
	public int getNoOrden() {
		return NoOrden;
	}
	public void setNoOrden(int noOrden) {
		NoOrden = noOrden;
	}
	
}
