package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class SotcsrPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String csracr;

	private String csrcha;

	private String csrcia;

	private String csrcmb;

    @Temporal( TemporalType.DATE)
	private Date csrfech;

	private String csrhech;

	private Time csrhora;

	private BigDecimal csrkfin;

	private BigDecimal csrkini;

	private String csrmar;

	private String csrmod;

	private String csrpant;

	private String csrprog;

	private String csrrec;

	private String csrstat;

	private String csrsuc;

    public SotcsrPK() {
    }

	public String getCsracr() {
		return this.csracr;
	}

	public void setCsracr(String csracr) {
		this.csracr = csracr;
	}

	public String getCsrcha() {
		return this.csrcha;
	}

	public void setCsrcha(String csrcha) {
		this.csrcha = csrcha;
	}

	public String getCsrcia() {
		return this.csrcia;
	}

	public void setCsrcia(String csrcia) {
		this.csrcia = csrcia;
	}

	public String getCsrcmb() {
		return this.csrcmb;
	}

	public void setCsrcmb(String csrcmb) {
		this.csrcmb = csrcmb;
	}

	public Date getCsrfech() {
		return this.csrfech;
	}

	public void setCsrfech(Date csrfech) {
		this.csrfech = csrfech;
	}

	public String getCsrhech() {
		return this.csrhech;
	}

	public void setCsrhech(String csrhech) {
		this.csrhech = csrhech;
	}

	public Time getCsrhora() {
		return this.csrhora;
	}

	public void setCsrhora(Time csrhora) {
		this.csrhora = csrhora;
	}

	public BigDecimal getCsrkfin() {
		return this.csrkfin;
	}

	public void setCsrkfin(BigDecimal csrkfin) {
		this.csrkfin = csrkfin;
	}

	public BigDecimal getCsrkini() {
		return this.csrkini;
	}

	public void setCsrkini(BigDecimal csrkini) {
		this.csrkini = csrkini;
	}

	public String getCsrmar() {
		return this.csrmar;
	}

	public void setCsrmar(String csrmar) {
		this.csrmar = csrmar;
	}

	public String getCsrmod() {
		return this.csrmod;
	}

	public void setCsrmod(String csrmod) {
		this.csrmod = csrmod;
	}

	public String getCsrpant() {
		return this.csrpant;
	}

	public void setCsrpant(String csrpant) {
		this.csrpant = csrpant;
	}

	public String getCsrprog() {
		return this.csrprog;
	}

	public void setCsrprog(String csrprog) {
		this.csrprog = csrprog;
	}

	public String getCsrrec() {
		return this.csrrec;
	}

	public void setCsrrec(String csrrec) {
		this.csrrec = csrrec;
	}

	public String getCsrstat() {
		return this.csrstat;
	}

	public void setCsrstat(String csrstat) {
		this.csrstat = csrstat;
	}

	public String getCsrsuc() {
		return this.csrsuc;
	}

	public void setCsrsuc(String csrsuc) {
		this.csrsuc = csrsuc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((csracr == null) ? 0 : csracr.hashCode());
		result = prime * result + ((csrcha == null) ? 0 : csrcha.hashCode());
		result = prime * result + ((csrcia == null) ? 0 : csrcia.hashCode());
		result = prime * result + ((csrcmb == null) ? 0 : csrcmb.hashCode());
		result = prime * result + ((csrfech == null) ? 0 : csrfech.hashCode());
		result = prime * result + ((csrhech == null) ? 0 : csrhech.hashCode());
		result = prime * result + ((csrhora == null) ? 0 : csrhora.hashCode());
		result = prime * result + ((csrkfin == null) ? 0 : csrkfin.hashCode());
		result = prime * result + ((csrkini == null) ? 0 : csrkini.hashCode());
		result = prime * result + ((csrmar == null) ? 0 : csrmar.hashCode());
		result = prime * result + ((csrmod == null) ? 0 : csrmod.hashCode());
		result = prime * result + ((csrpant == null) ? 0 : csrpant.hashCode());
		result = prime * result + ((csrprog == null) ? 0 : csrprog.hashCode());
		result = prime * result + ((csrrec == null) ? 0 : csrrec.hashCode());
		result = prime * result + ((csrstat == null) ? 0 : csrstat.hashCode());
		result = prime * result + ((csrsuc == null) ? 0 : csrsuc.hashCode());
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
		SotcsrPK other = (SotcsrPK) obj;
		if (csracr == null) {
			if (other.csracr != null)
				return false;
		} else if (!csracr.equals(other.csracr))
			return false;
		if (csrcha == null) {
			if (other.csrcha != null)
				return false;
		} else if (!csrcha.equals(other.csrcha))
			return false;
		if (csrcia == null) {
			if (other.csrcia != null)
				return false;
		} else if (!csrcia.equals(other.csrcia))
			return false;
		if (csrcmb == null) {
			if (other.csrcmb != null)
				return false;
		} else if (!csrcmb.equals(other.csrcmb))
			return false;
		if (csrfech == null) {
			if (other.csrfech != null)
				return false;
		} else if (!csrfech.equals(other.csrfech))
			return false;
		if (csrhech == null) {
			if (other.csrhech != null)
				return false;
		} else if (!csrhech.equals(other.csrhech))
			return false;
		if (csrhora == null) {
			if (other.csrhora != null)
				return false;
		} else if (!csrhora.equals(other.csrhora))
			return false;
		if (csrkfin == null) {
			if (other.csrkfin != null)
				return false;
		} else if (!csrkfin.equals(other.csrkfin))
			return false;
		if (csrkini == null) {
			if (other.csrkini != null)
				return false;
		} else if (!csrkini.equals(other.csrkini))
			return false;
		if (csrmar == null) {
			if (other.csrmar != null)
				return false;
		} else if (!csrmar.equals(other.csrmar))
			return false;
		if (csrmod == null) {
			if (other.csrmod != null)
				return false;
		} else if (!csrmod.equals(other.csrmod))
			return false;
		if (csrpant == null) {
			if (other.csrpant != null)
				return false;
		} else if (!csrpant.equals(other.csrpant))
			return false;
		if (csrprog == null) {
			if (other.csrprog != null)
				return false;
		} else if (!csrprog.equals(other.csrprog))
			return false;
		if (csrrec == null) {
			if (other.csrrec != null)
				return false;
		} else if (!csrrec.equals(other.csrrec))
			return false;
		if (csrstat == null) {
			if (other.csrstat != null)
				return false;
		} else if (!csrstat.equals(other.csrstat))
			return false;
		if (csrsuc == null) {
			if (other.csrsuc != null)
				return false;
		} else if (!csrsuc.equals(other.csrsuc))
			return false;
		return true;
	}

}
