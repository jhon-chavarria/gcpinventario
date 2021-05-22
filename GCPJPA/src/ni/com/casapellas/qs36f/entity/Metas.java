package ni.com.casapellas.qs36f.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Metas {

	private int idmeta;
	private String valormeta;
	private int idsec;
	private String nombresec;
	private String descripcionsec;
	private int ordensec;
	private int iddef;
	private String nombredef;
	private String descripciondef;
	private String titulodef;

	public Metas() {
	}

	public int getIdmeta() {
		return idmeta;
	}

	public void setIdmeta(int idmeta) {
		this.idmeta = idmeta;
	}

	public String getValormeta() {
		return valormeta;
	}

	public void setValormeta(String valormeta) {
		this.valormeta = valormeta;
	}

	public int getIdsec() {
		return idsec;
	}

	public void setIdsec(int idsec) {
		this.idsec = idsec;
	}

	public String getNombresec() {
		return nombresec;
	}

	public void setNombresec(String nombresec) {
		this.nombresec = nombresec;
	}

	public String getDescripcionsec() {
		return descripcionsec;
	}

	public void setDescripcionsec(String descripcionsec) {
		this.descripcionsec = descripcionsec;
	}

	public int getOrdensec() {
		return ordensec;
	}

	public void setOrdensec(int ordensec) {
		this.ordensec = ordensec;
	}

	public int getIddef() {
		return iddef;
	}

	public void setIddef(int iddef) {
		this.iddef = iddef;
	}

	public String getNombredef() {
		return nombredef;
	}

	public void setNombredef(String nombredef) {
		this.nombredef = nombredef;
	}

	public String getDescripciondef() {
		return descripciondef;
	}

	public void setDescripciondef(String descripciondef) {
		this.descripciondef = descripciondef;
	}

	public String getTitulodef() {
		return titulodef;
	}

	public void setTitulodef(String titulodef) {
		this.titulodef = titulodef;
	}

}
