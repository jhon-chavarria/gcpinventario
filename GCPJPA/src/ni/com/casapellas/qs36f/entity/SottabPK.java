package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SottabPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String tbcia;
	private String tbclas;
	private String tbcodi;
	private String tbdesc;
	private String tbespe;
	private String tbicon;
	private String tbniv1;
	private String tbniv2;
	private String tbniv3;
	private String tbniv4;
	private String tbniv5;
	private String tbstat;
	private String tbsuc;

    public SottabPK() {
    }

	public String getTbcia() {
		return tbcia;
	}

	public void setTbcia(String tbcia) {
		this.tbcia = tbcia;
	}

	public String getTbclas() {
		return tbclas;
	}

	public void setTbclas(String tbclas) {
		this.tbclas = tbclas;
	}

	public String getTbcodi() {
		return tbcodi;
	}

	public void setTbcodi(String tbcodi) {
		this.tbcodi = tbcodi;
	}

	public String getTbdesc() {
		return tbdesc;
	}

	public void setTbdesc(String tbdesc) {
		this.tbdesc = tbdesc;
	}

	public String getTbespe() {
		return tbespe;
	}

	public void setTbespe(String tbespe) {
		this.tbespe = tbespe;
	}

	public String getTbicon() {
		return tbicon;
	}

	public void setTbicon(String tbicon) {
		this.tbicon = tbicon;
	}

	public String getTbniv1() {
		return tbniv1;
	}

	public void setTbniv1(String tbniv1) {
		this.tbniv1 = tbniv1;
	}

	public String getTbniv2() {
		return tbniv2;
	}

	public void setTbniv2(String tbniv2) {
		this.tbniv2 = tbniv2;
	}

	public String getTbniv3() {
		return tbniv3;
	}

	public void setTbniv3(String tbniv3) {
		this.tbniv3 = tbniv3;
	}

	public String getTbniv4() {
		return tbniv4;
	}

	public void setTbniv4(String tbniv4) {
		this.tbniv4 = tbniv4;
	}

	public String getTbniv5() {
		return tbniv5;
	}

	public void setTbniv5(String tbniv5) {
		this.tbniv5 = tbniv5;
	}

	public String getTbstat() {
		return tbstat;
	}

	public void setTbstat(String tbstat) {
		this.tbstat = tbstat;
	}

	public String getTbsuc() {
		return tbsuc;
	}

	public void setTbsuc(String tbsuc) {
		this.tbsuc = tbsuc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tbcia == null) ? 0 : tbcia.hashCode());
		result = prime * result + ((tbclas == null) ? 0 : tbclas.hashCode());
		result = prime * result + ((tbcodi == null) ? 0 : tbcodi.hashCode());
		result = prime * result + ((tbdesc == null) ? 0 : tbdesc.hashCode());
		result = prime * result + ((tbespe == null) ? 0 : tbespe.hashCode());
		result = prime * result + ((tbicon == null) ? 0 : tbicon.hashCode());
		result = prime * result + ((tbniv1 == null) ? 0 : tbniv1.hashCode());
		result = prime * result + ((tbniv2 == null) ? 0 : tbniv2.hashCode());
		result = prime * result + ((tbniv3 == null) ? 0 : tbniv3.hashCode());
		result = prime * result + ((tbniv4 == null) ? 0 : tbniv4.hashCode());
		result = prime * result + ((tbniv5 == null) ? 0 : tbniv5.hashCode());
		result = prime * result + ((tbstat == null) ? 0 : tbstat.hashCode());
		result = prime * result + ((tbsuc == null) ? 0 : tbsuc.hashCode());
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
		SottabPK other = (SottabPK) obj;
		if (tbcia == null) {
			if (other.tbcia != null)
				return false;
		} else if (!tbcia.equals(other.tbcia))
			return false;
		if (tbclas == null) {
			if (other.tbclas != null)
				return false;
		} else if (!tbclas.equals(other.tbclas))
			return false;
		if (tbcodi == null) {
			if (other.tbcodi != null)
				return false;
		} else if (!tbcodi.equals(other.tbcodi))
			return false;
		if (tbdesc == null) {
			if (other.tbdesc != null)
				return false;
		} else if (!tbdesc.equals(other.tbdesc))
			return false;
		if (tbespe == null) {
			if (other.tbespe != null)
				return false;
		} else if (!tbespe.equals(other.tbespe))
			return false;
		if (tbicon == null) {
			if (other.tbicon != null)
				return false;
		} else if (!tbicon.equals(other.tbicon))
			return false;
		if (tbniv1 == null) {
			if (other.tbniv1 != null)
				return false;
		} else if (!tbniv1.equals(other.tbniv1))
			return false;
		if (tbniv2 == null) {
			if (other.tbniv2 != null)
				return false;
		} else if (!tbniv2.equals(other.tbniv2))
			return false;
		if (tbniv3 == null) {
			if (other.tbniv3 != null)
				return false;
		} else if (!tbniv3.equals(other.tbniv3))
			return false;
		if (tbniv4 == null) {
			if (other.tbniv4 != null)
				return false;
		} else if (!tbniv4.equals(other.tbniv4))
			return false;
		if (tbniv5 == null) {
			if (other.tbniv5 != null)
				return false;
		} else if (!tbniv5.equals(other.tbniv5))
			return false;
		if (tbstat == null) {
			if (other.tbstat != null)
				return false;
		} else if (!tbstat.equals(other.tbstat))
			return false;
		if (tbsuc == null) {
			if (other.tbsuc != null)
				return false;
		} else if (!tbsuc.equals(other.tbsuc))
			return false;
		return true;
	}

}
