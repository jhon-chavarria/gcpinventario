package ni.com.casapellas.qs36f.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Embeddable
public class VtabmulPK implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@NotNull
	@Column(name = "CODTAB")
	private String codtab;
	@Basic(optional = false)
	@NotNull
	@Column(name = "CODIDE")
	private String codide;
	@Basic(optional = false)
	@NotNull
	@Column(name = "DESCRI")
	private String descri;
	@Basic(optional = false)
	@NotNull
	@Column(name = "TDESCRI1")
	private String tdescri1;
	@Basic(optional = false)
	@NotNull
	@Column(name = "OTROS")
	private String otros;
	@Basic(optional = false)
	@NotNull
	@Column(name = "ORDEN")
	private String orden;
	@Basic(optional = false)
	@NotNull
	@Column(name = "TCODIGO")
	private String tcodigo;
	@Basic(optional = false)
	@NotNull
	@Column(name = "OTROS1")
	private String otros1;
	@Basic(optional = false)
	@NotNull
	@Column(name = "P1")
	private String p1;
	@Basic(optional = false)
	@NotNull
	@Column(name = "P2")
	private String p2;
	@Basic(optional = false)
	@NotNull
	@Column(name = "P3")
	private String p3;
	@Basic(optional = false)
	@NotNull
	@Column(name = "P4")
	private String p4;
	@Basic(optional = false)
	@NotNull
	@Column(name = "P5")
	private String p5;
	@NotNull
	@Column(name = "P25")
	private String p25;

	public VtabmulPK() {
	}

	public String getCodtab() {
		return codtab;
	}

	public void setCodtab(String codtab) {
		this.codtab = codtab;
	}

	public String getCodide() {
		return codide;
	}

	public void setCodide(String codide) {
		this.codide = codide;
	}

	public String getDescri() {
		return descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	public String getTdescri1() {
		return tdescri1;
	}

	public void setTdescri1(String tdescri1) {
		this.tdescri1 = tdescri1;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getTcodigo() {
		return tcodigo;
	}

	public void setTcodigo(String tcodigo) {
		this.tcodigo = tcodigo;
	}

	public String getOtros1() {
		return otros1;
	}

	public void setOtros1(String otros1) {
		this.otros1 = otros1;
	}

	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}

	public String getP3() {
		return p3;
	}

	public void setP3(String p3) {
		this.p3 = p3;
	}

	public String getP4() {
		return p4;
	}

	public void setP4(String p4) {
		this.p4 = p4;
	}

	public String getP5() {
		return p5;
	}

	public void setP5(String p5) {
		this.p5 = p5;
	}

	public String getP25() {
		return p25;
	}

	public void setP25(String p25) {
		this.p25 = p25;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codide == null) ? 0 : codide.hashCode());
		result = prime * result + ((codtab == null) ? 0 : codtab.hashCode());
		result = prime * result + ((descri == null) ? 0 : descri.hashCode());
		result = prime * result + ((orden == null) ? 0 : orden.hashCode());
		result = prime * result + ((otros == null) ? 0 : otros.hashCode());
		result = prime * result + ((otros1 == null) ? 0 : otros1.hashCode());
		result = prime * result + ((p1 == null) ? 0 : p1.hashCode());
		result = prime * result + ((p2 == null) ? 0 : p2.hashCode());
		result = prime * result + ((p3 == null) ? 0 : p3.hashCode());
		result = prime * result + ((p4 == null) ? 0 : p4.hashCode());
		result = prime * result + ((p5 == null) ? 0 : p5.hashCode());
		result = prime * result + ((tcodigo == null) ? 0 : tcodigo.hashCode());
		result = prime * result
				+ ((tdescri1 == null) ? 0 : tdescri1.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VtabmulPK other = (VtabmulPK) obj;
		if (codide == null) {
			if (other.codide != null)
				return false;
		} else if (!codide.equals(other.codide))
			return false;
		if (codtab == null) {
			if (other.codtab != null)
				return false;
		} else if (!codtab.equals(other.codtab))
			return false;
		if (descri == null) {
			if (other.descri != null)
				return false;
		} else if (!descri.equals(other.descri))
			return false;
		if (orden == null) {
			if (other.orden != null)
				return false;
		} else if (!orden.equals(other.orden))
			return false;
		if (otros == null) {
			if (other.otros != null)
				return false;
		} else if (!otros.equals(other.otros))
			return false;
		if (otros1 == null) {
			if (other.otros1 != null)
				return false;
		} else if (!otros1.equals(other.otros1))
			return false;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		if (p3 == null) {
			if (other.p3 != null)
				return false;
		} else if (!p3.equals(other.p3))
			return false;
		if (p4 == null) {
			if (other.p4 != null)
				return false;
		} else if (!p4.equals(other.p4))
			return false;
		if (p5 == null) {
			if (other.p5 != null)
				return false;
		} else if (!p5.equals(other.p5))
			return false;
		if (tcodigo == null) {
			if (other.tcodigo != null)
				return false;
		} else if (!tcodigo.equals(other.tcodigo))
			return false;
		if (tdescri1 == null) {
			if (other.tdescri1 != null)
				return false;
		} else if (!tdescri1.equals(other.tdescri1))
			return false;
		return true;
	}

}
