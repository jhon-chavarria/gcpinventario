package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class SotkcsvPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String compan;

	private BigDecimal fecham;

	private String hechop;

	private BigDecimal horam;

	private String kcsact;

	private String kcsacta;

	private BigDecimal kcsano;

	private String kcschas;

	private String kcsmdsc;

	private String kcsmod;

	private String kcsmrk;

	private String kcspgt;

    @Temporal( TemporalType.DATE)
	private Date kcsrfa;

    @Temporal( TemporalType.DATE)
	private Date kcsrfd;

	private BigDecimal kcssecv;

	private String kcsvds;

	private String kcsvisa;

	private String kcsvisd;

	private String kcswmi;

	private String nprogr;

	private String pantal;

	private String sucurs;

    public SotkcsvPK() {
    }

	public String getCompan() {
		return this.compan;
	}

	public void setCompan(String compan) {
		this.compan = compan;
	}

	public BigDecimal getFecham() {
		return this.fecham;
	}

	public void setFecham(BigDecimal fecham) {
		this.fecham = fecham;
	}

	public String getHechop() {
		return this.hechop;
	}

	public void setHechop(String hechop) {
		this.hechop = hechop;
	}

	public BigDecimal getHoram() {
		return this.horam;
	}

	public void setHoram(BigDecimal horam) {
		this.horam = horam;
	}

	public String getKcsact() {
		return this.kcsact;
	}

	public void setKcsact(String kcsact) {
		this.kcsact = kcsact;
	}

	public String getKcsacta() {
		return this.kcsacta;
	}

	public void setKcsacta(String kcsacta) {
		this.kcsacta = kcsacta;
	}

	public BigDecimal getKcsano() {
		return this.kcsano;
	}

	public void setKcsano(BigDecimal kcsano) {
		this.kcsano = kcsano;
	}

	public String getKcschas() {
		return this.kcschas;
	}

	public void setKcschas(String kcschas) {
		this.kcschas = kcschas;
	}

	public String getKcsmdsc() {
		return this.kcsmdsc;
	}

	public void setKcsmdsc(String kcsmdsc) {
		this.kcsmdsc = kcsmdsc;
	}

	public String getKcsmod() {
		return this.kcsmod;
	}

	public void setKcsmod(String kcsmod) {
		this.kcsmod = kcsmod;
	}

	public String getKcsmrk() {
		return this.kcsmrk;
	}

	public void setKcsmrk(String kcsmrk) {
		this.kcsmrk = kcsmrk;
	}

	public String getKcspgt() {
		return this.kcspgt;
	}

	public void setKcspgt(String kcspgt) {
		this.kcspgt = kcspgt;
	}

	public Date getKcsrfa() {
		return this.kcsrfa;
	}

	public void setKcsrfa(Date kcsrfa) {
		this.kcsrfa = kcsrfa;
	}

	public Date getKcsrfd() {
		return this.kcsrfd;
	}

	public void setKcsrfd(Date kcsrfd) {
		this.kcsrfd = kcsrfd;
	}

	public BigDecimal getKcssecv() {
		return this.kcssecv;
	}

	public void setKcssecv(BigDecimal kcssecv) {
		this.kcssecv = kcssecv;
	}

	public String getKcsvds() {
		return this.kcsvds;
	}

	public void setKcsvds(String kcsvds) {
		this.kcsvds = kcsvds;
	}

	public String getKcsvisa() {
		return this.kcsvisa;
	}

	public void setKcsvisa(String kcsvisa) {
		this.kcsvisa = kcsvisa;
	}

	public String getKcsvisd() {
		return this.kcsvisd;
	}

	public void setKcsvisd(String kcsvisd) {
		this.kcsvisd = kcsvisd;
	}

	public String getKcswmi() {
		return this.kcswmi;
	}

	public void setKcswmi(String kcswmi) {
		this.kcswmi = kcswmi;
	}

	public String getNprogr() {
		return this.nprogr;
	}

	public void setNprogr(String nprogr) {
		this.nprogr = nprogr;
	}

	public String getPantal() {
		return this.pantal;
	}

	public void setPantal(String pantal) {
		this.pantal = pantal;
	}

	public String getSucurs() {
		return this.sucurs;
	}

	public void setSucurs(String sucurs) {
		this.sucurs = sucurs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compan == null) ? 0 : compan.hashCode());
		result = prime * result + ((fecham == null) ? 0 : fecham.hashCode());
		result = prime * result + ((hechop == null) ? 0 : hechop.hashCode());
		result = prime * result + ((horam == null) ? 0 : horam.hashCode());
		result = prime * result + ((kcsact == null) ? 0 : kcsact.hashCode());
		result = prime * result + ((kcsacta == null) ? 0 : kcsacta.hashCode());
		result = prime * result + ((kcsano == null) ? 0 : kcsano.hashCode());
		result = prime * result + ((kcschas == null) ? 0 : kcschas.hashCode());
		result = prime * result + ((kcsmdsc == null) ? 0 : kcsmdsc.hashCode());
		result = prime * result + ((kcsmod == null) ? 0 : kcsmod.hashCode());
		result = prime * result + ((kcsmrk == null) ? 0 : kcsmrk.hashCode());
		result = prime * result + ((kcspgt == null) ? 0 : kcspgt.hashCode());
		result = prime * result + ((kcsrfa == null) ? 0 : kcsrfa.hashCode());
		result = prime * result + ((kcsrfd == null) ? 0 : kcsrfd.hashCode());
		result = prime * result + ((kcssecv == null) ? 0 : kcssecv.hashCode());
		result = prime * result + ((kcsvds == null) ? 0 : kcsvds.hashCode());
		result = prime * result + ((kcsvisa == null) ? 0 : kcsvisa.hashCode());
		result = prime * result + ((kcsvisd == null) ? 0 : kcsvisd.hashCode());
		result = prime * result + ((kcswmi == null) ? 0 : kcswmi.hashCode());
		result = prime * result + ((nprogr == null) ? 0 : nprogr.hashCode());
		result = prime * result + ((pantal == null) ? 0 : pantal.hashCode());
		result = prime * result + ((sucurs == null) ? 0 : sucurs.hashCode());
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
		SotkcsvPK other = (SotkcsvPK) obj;
		if (compan == null) {
			if (other.compan != null)
				return false;
		} else if (!compan.equals(other.compan))
			return false;
		if (fecham == null) {
			if (other.fecham != null)
				return false;
		} else if (!fecham.equals(other.fecham))
			return false;
		if (hechop == null) {
			if (other.hechop != null)
				return false;
		} else if (!hechop.equals(other.hechop))
			return false;
		if (horam == null) {
			if (other.horam != null)
				return false;
		} else if (!horam.equals(other.horam))
			return false;
		if (kcsact == null) {
			if (other.kcsact != null)
				return false;
		} else if (!kcsact.equals(other.kcsact))
			return false;
		if (kcsacta == null) {
			if (other.kcsacta != null)
				return false;
		} else if (!kcsacta.equals(other.kcsacta))
			return false;
		if (kcsano == null) {
			if (other.kcsano != null)
				return false;
		} else if (!kcsano.equals(other.kcsano))
			return false;
		if (kcschas == null) {
			if (other.kcschas != null)
				return false;
		} else if (!kcschas.equals(other.kcschas))
			return false;
		if (kcsmdsc == null) {
			if (other.kcsmdsc != null)
				return false;
		} else if (!kcsmdsc.equals(other.kcsmdsc))
			return false;
		if (kcsmod == null) {
			if (other.kcsmod != null)
				return false;
		} else if (!kcsmod.equals(other.kcsmod))
			return false;
		if (kcsmrk == null) {
			if (other.kcsmrk != null)
				return false;
		} else if (!kcsmrk.equals(other.kcsmrk))
			return false;
		if (kcspgt == null) {
			if (other.kcspgt != null)
				return false;
		} else if (!kcspgt.equals(other.kcspgt))
			return false;
		if (kcsrfa == null) {
			if (other.kcsrfa != null)
				return false;
		} else if (!kcsrfa.equals(other.kcsrfa))
			return false;
		if (kcsrfd == null) {
			if (other.kcsrfd != null)
				return false;
		} else if (!kcsrfd.equals(other.kcsrfd))
			return false;
		if (kcssecv == null) {
			if (other.kcssecv != null)
				return false;
		} else if (!kcssecv.equals(other.kcssecv))
			return false;
		if (kcsvds == null) {
			if (other.kcsvds != null)
				return false;
		} else if (!kcsvds.equals(other.kcsvds))
			return false;
		if (kcsvisa == null) {
			if (other.kcsvisa != null)
				return false;
		} else if (!kcsvisa.equals(other.kcsvisa))
			return false;
		if (kcsvisd == null) {
			if (other.kcsvisd != null)
				return false;
		} else if (!kcsvisd.equals(other.kcsvisd))
			return false;
		if (kcswmi == null) {
			if (other.kcswmi != null)
				return false;
		} else if (!kcswmi.equals(other.kcswmi))
			return false;
		if (nprogr == null) {
			if (other.nprogr != null)
				return false;
		} else if (!nprogr.equals(other.nprogr))
			return false;
		if (pantal == null) {
			if (other.pantal != null)
				return false;
		} else if (!pantal.equals(other.pantal))
			return false;
		if (sucurs == null) {
			if (other.sucurs != null)
				return false;
		} else if (!sucurs.equals(other.sucurs))
			return false;
		return true;
	}

}
