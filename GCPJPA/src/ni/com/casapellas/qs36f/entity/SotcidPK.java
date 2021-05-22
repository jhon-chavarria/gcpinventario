package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class SotcidPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cddesc;

    @Temporal( TemporalType.DATE)
	private Date cdfech;

	private String cdflag;

	private BigDecimal cdgrup;

	private String cdhech;

	private Time cdhora;

	private String cdpant;

	private String cdprog;

	private BigDecimal cdthor;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cddesc == null) ? 0 : cddesc.hashCode());
		result = prime * result + ((cdfech == null) ? 0 : cdfech.hashCode());
		result = prime * result + ((cdflag == null) ? 0 : cdflag.hashCode());
		result = prime * result + ((cdgrup == null) ? 0 : cdgrup.hashCode());
		result = prime * result + ((cdhech == null) ? 0 : cdhech.hashCode());
		result = prime * result + ((cdhora == null) ? 0 : cdhora.hashCode());
		result = prime * result + ((cdpant == null) ? 0 : cdpant.hashCode());
		result = prime * result + ((cdprog == null) ? 0 : cdprog.hashCode());
		result = prime * result + ((cdthor == null) ? 0 : cdthor.hashCode());
		result = prime * result + ((cdvalo == null) ? 0 : cdvalo.hashCode());
		result = prime * result + ((compan == null) ? 0 : compan.hashCode());
		result = prime * result + ((numcit == null) ? 0 : numcit.hashCode());
		result = prime * result + ((sucurs == null) ? 0 : sucurs.hashCode());
		result = prime * result + ((tasact == null) ? 0 : tasact.hashCode());
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
		SotcidPK other = (SotcidPK) obj;
		if (cddesc == null) {
			if (other.cddesc != null)
				return false;
		} else if (!cddesc.equals(other.cddesc))
			return false;
		if (cdfech == null) {
			if (other.cdfech != null)
				return false;
		} else if (!cdfech.equals(other.cdfech))
			return false;
		if (cdflag == null) {
			if (other.cdflag != null)
				return false;
		} else if (!cdflag.equals(other.cdflag))
			return false;
		if (cdgrup == null) {
			if (other.cdgrup != null)
				return false;
		} else if (!cdgrup.equals(other.cdgrup))
			return false;
		if (cdhech == null) {
			if (other.cdhech != null)
				return false;
		} else if (!cdhech.equals(other.cdhech))
			return false;
		if (cdhora == null) {
			if (other.cdhora != null)
				return false;
		} else if (!cdhora.equals(other.cdhora))
			return false;
		if (cdpant == null) {
			if (other.cdpant != null)
				return false;
		} else if (!cdpant.equals(other.cdpant))
			return false;
		if (cdprog == null) {
			if (other.cdprog != null)
				return false;
		} else if (!cdprog.equals(other.cdprog))
			return false;
		if (cdthor == null) {
			if (other.cdthor != null)
				return false;
		} else if (!cdthor.equals(other.cdthor))
			return false;
		if (cdvalo == null) {
			if (other.cdvalo != null)
				return false;
		} else if (!cdvalo.equals(other.cdvalo))
			return false;
		if (compan == null) {
			if (other.compan != null)
				return false;
		} else if (!compan.equals(other.compan))
			return false;
		if (numcit == null) {
			if (other.numcit != null)
				return false;
		} else if (!numcit.equals(other.numcit))
			return false;
		if (sucurs == null) {
			if (other.sucurs != null)
				return false;
		} else if (!sucurs.equals(other.sucurs))
			return false;
		if (tasact == null) {
			if (other.tasact != null)
				return false;
		} else if (!tasact.equals(other.tasact))
			return false;
		return true;
	}

	private BigDecimal cdvalo;

	private String compan;

	private BigDecimal numcit;

	private String sucurs;

	private String tasact;

    public SotcidPK() {
    }

	public String getCddesc() {
		return this.cddesc;
	}

	public void setCddesc(String cddesc) {
		this.cddesc = cddesc;
	}

	public Date getCdfech() {
		return this.cdfech;
	}

	public void setCdfech(Date cdfech) {
		this.cdfech = cdfech;
	}

	public String getCdflag() {
		return this.cdflag;
	}

	public void setCdflag(String cdflag) {
		this.cdflag = cdflag;
	}

	public BigDecimal getCdgrup() {
		return this.cdgrup;
	}

	public void setCdgrup(BigDecimal cdgrup) {
		this.cdgrup = cdgrup;
	}

	public String getCdhech() {
		return this.cdhech;
	}

	public void setCdhech(String cdhech) {
		this.cdhech = cdhech;
	}

	public Time getCdhora() {
		return this.cdhora;
	}

	public void setCdhora(Time cdhora) {
		this.cdhora = cdhora;
	}

	public String getCdpant() {
		return this.cdpant;
	}

	public void setCdpant(String cdpant) {
		this.cdpant = cdpant;
	}

	public String getCdprog() {
		return this.cdprog;
	}

	public void setCdprog(String cdprog) {
		this.cdprog = cdprog;
	}

	public BigDecimal getCdthor() {
		return this.cdthor;
	}

	public void setCdthor(BigDecimal cdthor) {
		this.cdthor = cdthor;
	}

	public BigDecimal getCdvalo() {
		return this.cdvalo;
	}

	public void setCdvalo(BigDecimal cdvalo) {
		this.cdvalo = cdvalo;
	}

	public String getCompan() {
		return this.compan;
	}

	public void setCompan(String compan) {
		this.compan = compan;
	}

	public BigDecimal getNumcit() {
		return this.numcit;
	}

	public void setNumcit(BigDecimal numcit) {
		this.numcit = numcit;
	}

	public String getSucurs() {
		return this.sucurs;
	}

	public void setSucurs(String sucurs) {
		this.sucurs = sucurs;
	}

	public String getTasact() {
		return this.tasact;
	}

	public void setTasact(String tasact) {
		this.tasact = tasact;
	}

}
