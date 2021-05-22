package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Invd736PK implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal ifecham;

	private BigDecimal ifechamm;

	private String ihechop;

	private String ihechopm;

	private BigDecimal ihoram;

	private BigDecimal ihoramm;

	private BigDecimal inanno;

	private BigDecimal incantidu;

	private String incompan;

	private String indepart;

	private BigDecimal inporcen1;

	private BigDecimal inporcen2;

	private BigDecimal inporcen3;

	private String inprogr;

	private String inprogrm;

	private String insucurs;

	private String intipo;

	private BigDecimal invalor1;

	private BigDecimal invalor2;

	private BigDecimal invalor3;

	public Invd736PK() {
	}

	public BigDecimal getIfecham() {
		return this.ifecham;
	}

	public void setIfecham(BigDecimal ifecham) {
		this.ifecham = ifecham;
	}

	public BigDecimal getIfechamm() {
		return this.ifechamm;
	}

	public void setIfechamm(BigDecimal ifechamm) {
		this.ifechamm = ifechamm;
	}

	public String getIhechop() {
		return this.ihechop;
	}

	public void setIhechop(String ihechop) {
		this.ihechop = ihechop;
	}

	public String getIhechopm() {
		return this.ihechopm;
	}

	public void setIhechopm(String ihechopm) {
		this.ihechopm = ihechopm;
	}

	public BigDecimal getIhoram() {
		return this.ihoram;
	}

	public void setIhoram(BigDecimal ihoram) {
		this.ihoram = ihoram;
	}

	public BigDecimal getIhoramm() {
		return this.ihoramm;
	}

	public void setIhoramm(BigDecimal ihoramm) {
		this.ihoramm = ihoramm;
	}

	public BigDecimal getInanno() {
		return this.inanno;
	}

	public void setInanno(BigDecimal inanno) {
		this.inanno = inanno;
	}

	public BigDecimal getIncantidu() {
		return this.incantidu;
	}

	public void setIncantidu(BigDecimal incantidu) {
		this.incantidu = incantidu;
	}

	public String getIncompan() {
		return this.incompan;
	}

	public void setIncompan(String incompan) {
		this.incompan = incompan;
	}

	public String getIndepart() {
		return this.indepart;
	}

	public void setIndepart(String indepart) {
		this.indepart = indepart;
	}

	public BigDecimal getInporcen1() {
		return this.inporcen1;
	}

	public void setInporcen1(BigDecimal inporcen1) {
		this.inporcen1 = inporcen1;
	}

	public BigDecimal getInporcen2() {
		return this.inporcen2;
	}

	public void setInporcen2(BigDecimal inporcen2) {
		this.inporcen2 = inporcen2;
	}

	public BigDecimal getInporcen3() {
		return this.inporcen3;
	}

	public void setInporcen3(BigDecimal inporcen3) {
		this.inporcen3 = inporcen3;
	}

	public String getInprogr() {
		return this.inprogr;
	}

	public void setInprogr(String inprogr) {
		this.inprogr = inprogr;
	}

	public String getInprogrm() {
		return this.inprogrm;
	}

	public void setInprogrm(String inprogrm) {
		this.inprogrm = inprogrm;
	}

	public String getInsucurs() {
		return this.insucurs;
	}

	public void setInsucurs(String insucurs) {
		this.insucurs = insucurs;
	}

	public String getIntipo() {
		return this.intipo;
	}

	public void setIntipo(String intipo) {
		this.intipo = intipo;
	}

	public BigDecimal getInvalor1() {
		return this.invalor1;
	}

	public void setInvalor1(BigDecimal invalor1) {
		this.invalor1 = invalor1;
	}

	public BigDecimal getInvalor2() {
		return this.invalor2;
	}

	public void setInvalor2(BigDecimal invalor2) {
		this.invalor2 = invalor2;
	}

	public BigDecimal getInvalor3() {
		return this.invalor3;
	}

	public void setInvalor3(BigDecimal invalor3) {
		this.invalor3 = invalor3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ifecham == null) ? 0 : ifecham.hashCode());
		result = prime * result
				+ ((ifechamm == null) ? 0 : ifechamm.hashCode());
		result = prime * result + ((ihechop == null) ? 0 : ihechop.hashCode());
		result = prime * result
				+ ((ihechopm == null) ? 0 : ihechopm.hashCode());
		result = prime * result + ((ihoram == null) ? 0 : ihoram.hashCode());
		result = prime * result + ((ihoramm == null) ? 0 : ihoramm.hashCode());
		result = prime * result + ((inanno == null) ? 0 : inanno.hashCode());
		result = prime * result
				+ ((incantidu == null) ? 0 : incantidu.hashCode());
		result = prime * result
				+ ((incompan == null) ? 0 : incompan.hashCode());
		result = prime * result
				+ ((indepart == null) ? 0 : indepart.hashCode());
		result = prime * result
				+ ((inporcen1 == null) ? 0 : inporcen1.hashCode());
		result = prime * result
				+ ((inporcen2 == null) ? 0 : inporcen2.hashCode());
		result = prime * result
				+ ((inporcen3 == null) ? 0 : inporcen3.hashCode());
		result = prime * result + ((inprogr == null) ? 0 : inprogr.hashCode());
		result = prime * result
				+ ((inprogrm == null) ? 0 : inprogrm.hashCode());
		result = prime * result
				+ ((insucurs == null) ? 0 : insucurs.hashCode());
		result = prime * result + ((intipo == null) ? 0 : intipo.hashCode());
		result = prime * result
				+ ((invalor1 == null) ? 0 : invalor1.hashCode());
		result = prime * result
				+ ((invalor2 == null) ? 0 : invalor2.hashCode());
		result = prime * result
				+ ((invalor3 == null) ? 0 : invalor3.hashCode());
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
		Invd736PK other = (Invd736PK) obj;
		if (ifecham == null) {
			if (other.ifecham != null)
				return false;
		} else if (!ifecham.equals(other.ifecham))
			return false;
		if (ifechamm == null) {
			if (other.ifechamm != null)
				return false;
		} else if (!ifechamm.equals(other.ifechamm))
			return false;
		if (ihechop == null) {
			if (other.ihechop != null)
				return false;
		} else if (!ihechop.equals(other.ihechop))
			return false;
		if (ihechopm == null) {
			if (other.ihechopm != null)
				return false;
		} else if (!ihechopm.equals(other.ihechopm))
			return false;
		if (ihoram == null) {
			if (other.ihoram != null)
				return false;
		} else if (!ihoram.equals(other.ihoram))
			return false;
		if (ihoramm == null) {
			if (other.ihoramm != null)
				return false;
		} else if (!ihoramm.equals(other.ihoramm))
			return false;
		if (inanno == null) {
			if (other.inanno != null)
				return false;
		} else if (!inanno.equals(other.inanno))
			return false;
		if (incantidu == null) {
			if (other.incantidu != null)
				return false;
		} else if (!incantidu.equals(other.incantidu))
			return false;
		if (incompan == null) {
			if (other.incompan != null)
				return false;
		} else if (!incompan.equals(other.incompan))
			return false;
		if (indepart == null) {
			if (other.indepart != null)
				return false;
		} else if (!indepart.equals(other.indepart))
			return false;
		if (inporcen1 == null) {
			if (other.inporcen1 != null)
				return false;
		} else if (!inporcen1.equals(other.inporcen1))
			return false;
		if (inporcen2 == null) {
			if (other.inporcen2 != null)
				return false;
		} else if (!inporcen2.equals(other.inporcen2))
			return false;
		if (inporcen3 == null) {
			if (other.inporcen3 != null)
				return false;
		} else if (!inporcen3.equals(other.inporcen3))
			return false;
		if (inprogr == null) {
			if (other.inprogr != null)
				return false;
		} else if (!inprogr.equals(other.inprogr))
			return false;
		if (inprogrm == null) {
			if (other.inprogrm != null)
				return false;
		} else if (!inprogrm.equals(other.inprogrm))
			return false;
		if (insucurs == null) {
			if (other.insucurs != null)
				return false;
		} else if (!insucurs.equals(other.insucurs))
			return false;
		if (intipo == null) {
			if (other.intipo != null)
				return false;
		} else if (!intipo.equals(other.intipo))
			return false;
		if (invalor1 == null) {
			if (other.invalor1 != null)
				return false;
		} else if (!invalor1.equals(other.invalor1))
			return false;
		if (invalor2 == null) {
			if (other.invalor2 != null)
				return false;
		} else if (!invalor2.equals(other.invalor2))
			return false;
		if (invalor3 == null) {
			if (other.invalor3 != null)
				return false;
		} else if (!invalor3.equals(other.invalor3))
			return false;
		return true;
	}
}
