package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class SotcsoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String autcha;

	private BigDecimal clclie;

	private String compan;

	private BigDecimal diaokmt;

    @Temporal( TemporalType.DATE)
	private Date fccreado;

    @Temporal( TemporalType.DATE)
	private Date fcllamad;

	private String filtcons;

	private Time hrllamad;

	private String observ;

	private BigDecimal ordobs;

	private String pantllam;

	private String patenlla;

	private String pccall;

	private String pccd;

	private String pcemail;

	private String pcontac;

	private String pcorrec;

	private String pcsms;

    @Temporal( TemporalType.DATE)
	private Date pfecco;

	private Time phoraca;

	private Time phoracd;

	private BigDecimal pllanum;

	private String psmsrec;

	private String ptelco;

	private String ptelexc;

	private String refllam;

	private String sucurs;

	private String tipcsc;

	private String usuallam;

    public SotcsoPK() {
    }

	public String getAutcha() {
		return this.autcha;
	}

	public void setAutcha(String autcha) {
		this.autcha = autcha;
	}

	public BigDecimal getClclie() {
		return this.clclie;
	}

	public void setClclie(BigDecimal clclie) {
		this.clclie = clclie;
	}

	public String getCompan() {
		return this.compan;
	}

	public void setCompan(String compan) {
		this.compan = compan;
	}

	public BigDecimal getDiaokmt() {
		return this.diaokmt;
	}

	public void setDiaokmt(BigDecimal diaokmt) {
		this.diaokmt = diaokmt;
	}

	public Date getFccreado() {
		return this.fccreado;
	}

	public void setFccreado(Date fccreado) {
		this.fccreado = fccreado;
	}

	public Date getFcllamad() {
		return this.fcllamad;
	}

	public void setFcllamad(Date fcllamad) {
		this.fcllamad = fcllamad;
	}

	public String getFiltcons() {
		return this.filtcons;
	}

	public void setFiltcons(String filtcons) {
		this.filtcons = filtcons;
	}

	public Time getHrllamad() {
		return this.hrllamad;
	}

	public void setHrllamad(Time hrllamad) {
		this.hrllamad = hrllamad;
	}

	public String getObserv() {
		return this.observ;
	}

	public void setObserv(String observ) {
		this.observ = observ;
	}

	public BigDecimal getOrdobs() {
		return this.ordobs;
	}

	public void setOrdobs(BigDecimal ordobs) {
		this.ordobs = ordobs;
	}

	public String getPantllam() {
		return this.pantllam;
	}

	public void setPantllam(String pantllam) {
		this.pantllam = pantllam;
	}

	public String getPatenlla() {
		return this.patenlla;
	}

	public void setPatenlla(String patenlla) {
		this.patenlla = patenlla;
	}

	public String getPccall() {
		return this.pccall;
	}

	public void setPccall(String pccall) {
		this.pccall = pccall;
	}

	public String getPccd() {
		return this.pccd;
	}

	public void setPccd(String pccd) {
		this.pccd = pccd;
	}

	public String getPcemail() {
		return this.pcemail;
	}

	public void setPcemail(String pcemail) {
		this.pcemail = pcemail;
	}

	public String getPcontac() {
		return this.pcontac;
	}

	public void setPcontac(String pcontac) {
		this.pcontac = pcontac;
	}

	public String getPcorrec() {
		return this.pcorrec;
	}

	public void setPcorrec(String pcorrec) {
		this.pcorrec = pcorrec;
	}

	public String getPcsms() {
		return this.pcsms;
	}

	public void setPcsms(String pcsms) {
		this.pcsms = pcsms;
	}

	public Date getPfecco() {
		return this.pfecco;
	}

	public void setPfecco(Date pfecco) {
		this.pfecco = pfecco;
	}

	public Time getPhoraca() {
		return this.phoraca;
	}

	public void setPhoraca(Time phoraca) {
		this.phoraca = phoraca;
	}

	public Time getPhoracd() {
		return this.phoracd;
	}

	public void setPhoracd(Time phoracd) {
		this.phoracd = phoracd;
	}

	public BigDecimal getPllanum() {
		return this.pllanum;
	}

	public void setPllanum(BigDecimal pllanum) {
		this.pllanum = pllanum;
	}

	public String getPsmsrec() {
		return this.psmsrec;
	}

	public void setPsmsrec(String psmsrec) {
		this.psmsrec = psmsrec;
	}

	public String getPtelco() {
		return this.ptelco;
	}

	public void setPtelco(String ptelco) {
		this.ptelco = ptelco;
	}

	public String getPtelexc() {
		return this.ptelexc;
	}

	public void setPtelexc(String ptelexc) {
		this.ptelexc = ptelexc;
	}

	public String getRefllam() {
		return this.refllam;
	}

	public void setRefllam(String refllam) {
		this.refllam = refllam;
	}

	public String getSucurs() {
		return this.sucurs;
	}

	public void setSucurs(String sucurs) {
		this.sucurs = sucurs;
	}

	public String getTipcsc() {
		return this.tipcsc;
	}

	public void setTipcsc(String tipcsc) {
		this.tipcsc = tipcsc;
	}

	public String getUsuallam() {
		return this.usuallam;
	}

	public void setUsuallam(String usuallam) {
		this.usuallam = usuallam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autcha == null) ? 0 : autcha.hashCode());
		result = prime * result + ((clclie == null) ? 0 : clclie.hashCode());
		result = prime * result + ((compan == null) ? 0 : compan.hashCode());
		result = prime * result + ((diaokmt == null) ? 0 : diaokmt.hashCode());
		result = prime * result
				+ ((fccreado == null) ? 0 : fccreado.hashCode());
		result = prime * result
				+ ((fcllamad == null) ? 0 : fcllamad.hashCode());
		result = prime * result
				+ ((filtcons == null) ? 0 : filtcons.hashCode());
		result = prime * result
				+ ((hrllamad == null) ? 0 : hrllamad.hashCode());
		result = prime * result + ((observ == null) ? 0 : observ.hashCode());
		result = prime * result + ((ordobs == null) ? 0 : ordobs.hashCode());
		result = prime * result
				+ ((pantllam == null) ? 0 : pantllam.hashCode());
		result = prime * result
				+ ((patenlla == null) ? 0 : patenlla.hashCode());
		result = prime * result + ((pccall == null) ? 0 : pccall.hashCode());
		result = prime * result + ((pccd == null) ? 0 : pccd.hashCode());
		result = prime * result + ((pcemail == null) ? 0 : pcemail.hashCode());
		result = prime * result + ((pcontac == null) ? 0 : pcontac.hashCode());
		result = prime * result + ((pcorrec == null) ? 0 : pcorrec.hashCode());
		result = prime * result + ((pcsms == null) ? 0 : pcsms.hashCode());
		result = prime * result + ((pfecco == null) ? 0 : pfecco.hashCode());
		result = prime * result + ((phoraca == null) ? 0 : phoraca.hashCode());
		result = prime * result + ((phoracd == null) ? 0 : phoracd.hashCode());
		result = prime * result + ((pllanum == null) ? 0 : pllanum.hashCode());
		result = prime * result + ((psmsrec == null) ? 0 : psmsrec.hashCode());
		result = prime * result + ((ptelco == null) ? 0 : ptelco.hashCode());
		result = prime * result + ((ptelexc == null) ? 0 : ptelexc.hashCode());
		result = prime * result + ((refllam == null) ? 0 : refllam.hashCode());
		result = prime * result + ((sucurs == null) ? 0 : sucurs.hashCode());
		result = prime * result + ((tipcsc == null) ? 0 : tipcsc.hashCode());
		result = prime * result
				+ ((usuallam == null) ? 0 : usuallam.hashCode());
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
		SotcsoPK other = (SotcsoPK) obj;
		if (autcha == null) {
			if (other.autcha != null)
				return false;
		} else if (!autcha.equals(other.autcha))
			return false;
		if (clclie == null) {
			if (other.clclie != null)
				return false;
		} else if (!clclie.equals(other.clclie))
			return false;
		if (compan == null) {
			if (other.compan != null)
				return false;
		} else if (!compan.equals(other.compan))
			return false;
		if (diaokmt == null) {
			if (other.diaokmt != null)
				return false;
		} else if (!diaokmt.equals(other.diaokmt))
			return false;
		if (fccreado == null) {
			if (other.fccreado != null)
				return false;
		} else if (!fccreado.equals(other.fccreado))
			return false;
		if (fcllamad == null) {
			if (other.fcllamad != null)
				return false;
		} else if (!fcllamad.equals(other.fcllamad))
			return false;
		if (filtcons == null) {
			if (other.filtcons != null)
				return false;
		} else if (!filtcons.equals(other.filtcons))
			return false;
		if (hrllamad == null) {
			if (other.hrllamad != null)
				return false;
		} else if (!hrllamad.equals(other.hrllamad))
			return false;
		if (observ == null) {
			if (other.observ != null)
				return false;
		} else if (!observ.equals(other.observ))
			return false;
		if (ordobs == null) {
			if (other.ordobs != null)
				return false;
		} else if (!ordobs.equals(other.ordobs))
			return false;
		if (pantllam == null) {
			if (other.pantllam != null)
				return false;
		} else if (!pantllam.equals(other.pantllam))
			return false;
		if (patenlla == null) {
			if (other.patenlla != null)
				return false;
		} else if (!patenlla.equals(other.patenlla))
			return false;
		if (pccall == null) {
			if (other.pccall != null)
				return false;
		} else if (!pccall.equals(other.pccall))
			return false;
		if (pccd == null) {
			if (other.pccd != null)
				return false;
		} else if (!pccd.equals(other.pccd))
			return false;
		if (pcemail == null) {
			if (other.pcemail != null)
				return false;
		} else if (!pcemail.equals(other.pcemail))
			return false;
		if (pcontac == null) {
			if (other.pcontac != null)
				return false;
		} else if (!pcontac.equals(other.pcontac))
			return false;
		if (pcorrec == null) {
			if (other.pcorrec != null)
				return false;
		} else if (!pcorrec.equals(other.pcorrec))
			return false;
		if (pcsms == null) {
			if (other.pcsms != null)
				return false;
		} else if (!pcsms.equals(other.pcsms))
			return false;
		if (pfecco == null) {
			if (other.pfecco != null)
				return false;
		} else if (!pfecco.equals(other.pfecco))
			return false;
		if (phoraca == null) {
			if (other.phoraca != null)
				return false;
		} else if (!phoraca.equals(other.phoraca))
			return false;
		if (phoracd == null) {
			if (other.phoracd != null)
				return false;
		} else if (!phoracd.equals(other.phoracd))
			return false;
		if (pllanum == null) {
			if (other.pllanum != null)
				return false;
		} else if (!pllanum.equals(other.pllanum))
			return false;
		if (psmsrec == null) {
			if (other.psmsrec != null)
				return false;
		} else if (!psmsrec.equals(other.psmsrec))
			return false;
		if (ptelco == null) {
			if (other.ptelco != null)
				return false;
		} else if (!ptelco.equals(other.ptelco))
			return false;
		if (ptelexc == null) {
			if (other.ptelexc != null)
				return false;
		} else if (!ptelexc.equals(other.ptelexc))
			return false;
		if (refllam == null) {
			if (other.refllam != null)
				return false;
		} else if (!refllam.equals(other.refllam))
			return false;
		if (sucurs == null) {
			if (other.sucurs != null)
				return false;
		} else if (!sucurs.equals(other.sucurs))
			return false;
		if (tipcsc == null) {
			if (other.tipcsc != null)
				return false;
		} else if (!tipcsc.equals(other.tipcsc))
			return false;
		if (usuallam == null) {
			if (other.usuallam != null)
				return false;
		} else if (!usuallam.equals(other.usuallam))
			return false;
		return true;
	}

}
