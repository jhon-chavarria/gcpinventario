package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class SottecPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cnsucu;

	private String tcatte;

	private String tecarea;

	private String teccarg;

	private String teccod;

	private BigDecimal tecdpt;

	private BigDecimal tecemp;

	private String tecnom;

	private String tecsdje;

	private String tecsta;

	private BigDecimal tepoac;

	private BigDecimal teporc;

	private String tequip;

    public SottecPK() {
    }

	public String getCnsucu() {
		return this.cnsucu;
	}

	public void setCnsucu(String cnsucu) {
		this.cnsucu = cnsucu;
	}

	public String getTcatte() {
		return this.tcatte;
	}

	public void setTcatte(String tcatte) {
		this.tcatte = tcatte;
	}

	public String getTecarea() {
		return this.tecarea;
	}

	public void setTecarea(String tecarea) {
		this.tecarea = tecarea;
	}

	public String getTeccarg() {
		return this.teccarg;
	}

	public void setTeccarg(String teccarg) {
		this.teccarg = teccarg;
	}

	public String getTeccod() {
		return this.teccod;
	}

	public void setTeccod(String teccod) {
		this.teccod = teccod;
	}

	public BigDecimal getTecdpt() {
		return this.tecdpt;
	}

	public void setTecdpt(BigDecimal tecdpt) {
		this.tecdpt = tecdpt;
	}

	public BigDecimal getTecemp() {
		return this.tecemp;
	}

	public void setTecemp(BigDecimal tecemp) {
		this.tecemp = tecemp;
	}

	public String getTecnom() {
		return this.tecnom;
	}

	public void setTecnom(String tecnom) {
		this.tecnom = tecnom;
	}

	public String getTecsdje() {
		return this.tecsdje;
	}

	public void setTecsdje(String tecsdje) {
		this.tecsdje = tecsdje;
	}

	public String getTecsta() {
		return this.tecsta;
	}

	public void setTecsta(String tecsta) {
		this.tecsta = tecsta;
	}

	public BigDecimal getTepoac() {
		return this.tepoac;
	}

	public void setTepoac(BigDecimal tepoac) {
		this.tepoac = tepoac;
	}

	public BigDecimal getTeporc() {
		return this.teporc;
	}

	public void setTeporc(BigDecimal teporc) {
		this.teporc = teporc;
	}

	public String getTequip() {
		return this.tequip;
	}

	public void setTequip(String tequip) {
		this.tequip = tequip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnsucu == null) ? 0 : cnsucu.hashCode());
		result = prime * result + ((tcatte == null) ? 0 : tcatte.hashCode());
		result = prime * result + ((tecarea == null) ? 0 : tecarea.hashCode());
		result = prime * result + ((teccarg == null) ? 0 : teccarg.hashCode());
		result = prime * result + ((teccod == null) ? 0 : teccod.hashCode());
		result = prime * result + ((tecdpt == null) ? 0 : tecdpt.hashCode());
		result = prime * result + ((tecemp == null) ? 0 : tecemp.hashCode());
		result = prime * result + ((tecnom == null) ? 0 : tecnom.hashCode());
		result = prime * result + ((tecsdje == null) ? 0 : tecsdje.hashCode());
		result = prime * result + ((tecsta == null) ? 0 : tecsta.hashCode());
		result = prime * result + ((tepoac == null) ? 0 : tepoac.hashCode());
		result = prime * result + ((teporc == null) ? 0 : teporc.hashCode());
		result = prime * result + ((tequip == null) ? 0 : tequip.hashCode());
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
		SottecPK other = (SottecPK) obj;
		if (cnsucu == null) {
			if (other.cnsucu != null)
				return false;
		} else if (!cnsucu.equals(other.cnsucu))
			return false;
		if (tcatte == null) {
			if (other.tcatte != null)
				return false;
		} else if (!tcatte.equals(other.tcatte))
			return false;
		if (tecarea == null) {
			if (other.tecarea != null)
				return false;
		} else if (!tecarea.equals(other.tecarea))
			return false;
		if (teccarg == null) {
			if (other.teccarg != null)
				return false;
		} else if (!teccarg.equals(other.teccarg))
			return false;
		if (teccod == null) {
			if (other.teccod != null)
				return false;
		} else if (!teccod.equals(other.teccod))
			return false;
		if (tecdpt == null) {
			if (other.tecdpt != null)
				return false;
		} else if (!tecdpt.equals(other.tecdpt))
			return false;
		if (tecemp == null) {
			if (other.tecemp != null)
				return false;
		} else if (!tecemp.equals(other.tecemp))
			return false;
		if (tecnom == null) {
			if (other.tecnom != null)
				return false;
		} else if (!tecnom.equals(other.tecnom))
			return false;
		if (tecsdje == null) {
			if (other.tecsdje != null)
				return false;
		} else if (!tecsdje.equals(other.tecsdje))
			return false;
		if (tecsta == null) {
			if (other.tecsta != null)
				return false;
		} else if (!tecsta.equals(other.tecsta))
			return false;
		if (tepoac == null) {
			if (other.tepoac != null)
				return false;
		} else if (!tepoac.equals(other.tepoac))
			return false;
		if (teporc == null) {
			if (other.teporc != null)
				return false;
		} else if (!teporc.equals(other.teporc))
			return false;
		if (tequip == null) {
			if (other.tequip != null)
				return false;
		} else if (!tequip.equals(other.tequip))
			return false;
		return true;
	}

}
