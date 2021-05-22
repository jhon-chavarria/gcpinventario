package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class SotactPK  implements Serializable {
	private static final long serialVersionUID = 1L;

	private String accoen;

	private String accoment;

	private String accote;

	private String acdct;

	private BigDecimal acdoc;

	private BigDecimal acdsbe;

	private BigDecimal acdsbp;

	private BigDecimal acdsbt;

	private BigDecimal acfec1;

	private BigDecimal acfec2;

	private BigDecimal acfech;

	private BigDecimal acfein;

	private BigDecimal achofi;

	private BigDecimal achoin;

	private BigDecimal acicu;

	private String acicut;

	private String ackco;

	private String acmcu;

	private String acmcu2;

	private BigDecimal acnumb;

	private String acsbl;

	private String acsblt;

	private BigDecimal actden;

	private BigDecimal actdme;

	private String actflc;

	private String actflg;

	private BigDecimal actgrp;

	private String actifa;

	private String actipd;

	private BigDecimal actnfa;

	private BigDecimal actpin;

	private BigDecimal actpre;

	private String actsubcon;

	private BigDecimal acttec;

	private BigDecimal acttep;

	private String acttmm;

	private BigDecimal acttpe;

	private BigDecimal acttpp;

	private BigDecimal actven;

	private BigDecimal actvme;

	private BigDecimal acvalo;

	private String asignpor;

	private String asigpant;

	private String autcat;

	private String autcha;

	private String autcmb;

	private String autmar;

	private String autmde;

	private String autmot;

	private String auttip;

	private BigDecimal cdsuper;

	private String cierrepor;

	private String cierrpant;

	private BigDecimal clclie;

	private String cncomp;

	private String cnsucu;

	private String deacti;

    @Temporal( TemporalType.DATE)
	private Date fcasign;

    @Temporal( TemporalType.DATE)
	private Date fccierre;

	private Time hrasign;

	private Time hrcierre;

	private String othech;

	private BigDecimal othora;

	private BigDecimal otnume;

	private String otpant;

	private String otprog;

	private BigDecimal sttdol;

	private String tasact;

	private BigDecimal tashor;

    public SotactPK() {
    }

	public String getAccoen() {
		return this.accoen;
	}

	public void setAccoen(String accoen) {
		this.accoen = accoen;
	}

	public String getAccoment() {
		return this.accoment;
	}

	public void setAccoment(String accoment) {
		this.accoment = accoment;
	}

	public String getAccote() {
		return this.accote;
	}

	public void setAccote(String accote) {
		this.accote = accote;
	}

	public String getAcdct() {
		return this.acdct;
	}

	public void setAcdct(String acdct) {
		this.acdct = acdct;
	}

	public BigDecimal getAcdoc() {
		return this.acdoc;
	}

	public void setAcdoc(BigDecimal acdoc) {
		this.acdoc = acdoc;
	}

	public BigDecimal getAcdsbe() {
		return this.acdsbe;
	}

	public void setAcdsbe(BigDecimal acdsbe) {
		this.acdsbe = acdsbe;
	}

	public BigDecimal getAcdsbp() {
		return this.acdsbp;
	}

	public void setAcdsbp(BigDecimal acdsbp) {
		this.acdsbp = acdsbp;
	}

	public BigDecimal getAcdsbt() {
		return this.acdsbt;
	}

	public void setAcdsbt(BigDecimal acdsbt) {
		this.acdsbt = acdsbt;
	}

	public BigDecimal getAcfec1() {
		return this.acfec1;
	}

	public void setAcfec1(BigDecimal acfec1) {
		this.acfec1 = acfec1;
	}

	public BigDecimal getAcfec2() {
		return this.acfec2;
	}

	public void setAcfec2(BigDecimal acfec2) {
		this.acfec2 = acfec2;
	}

	public BigDecimal getAcfech() {
		return this.acfech;
	}

	public void setAcfech(BigDecimal acfech) {
		this.acfech = acfech;
	}

	public BigDecimal getAcfein() {
		return this.acfein;
	}

	public void setAcfein(BigDecimal acfein) {
		this.acfein = acfein;
	}

	public BigDecimal getAchofi() {
		return this.achofi;
	}

	public void setAchofi(BigDecimal achofi) {
		this.achofi = achofi;
	}

	public BigDecimal getAchoin() {
		return this.achoin;
	}

	public void setAchoin(BigDecimal achoin) {
		this.achoin = achoin;
	}

	public BigDecimal getAcicu() {
		return this.acicu;
	}

	public void setAcicu(BigDecimal acicu) {
		this.acicu = acicu;
	}

	public String getAcicut() {
		return this.acicut;
	}

	public void setAcicut(String acicut) {
		this.acicut = acicut;
	}

	public String getAckco() {
		return this.ackco;
	}

	public void setAckco(String ackco) {
		this.ackco = ackco;
	}

	public String getAcmcu() {
		return this.acmcu;
	}

	public void setAcmcu(String acmcu) {
		this.acmcu = acmcu;
	}

	public String getAcmcu2() {
		return this.acmcu2;
	}

	public void setAcmcu2(String acmcu2) {
		this.acmcu2 = acmcu2;
	}

	public BigDecimal getAcnumb() {
		return this.acnumb;
	}

	public void setAcnumb(BigDecimal acnumb) {
		this.acnumb = acnumb;
	}

	public String getAcsbl() {
		return this.acsbl;
	}

	public void setAcsbl(String acsbl) {
		this.acsbl = acsbl;
	}

	public String getAcsblt() {
		return this.acsblt;
	}

	public void setAcsblt(String acsblt) {
		this.acsblt = acsblt;
	}

	public BigDecimal getActden() {
		return this.actden;
	}

	public void setActden(BigDecimal actden) {
		this.actden = actden;
	}

	public BigDecimal getActdme() {
		return this.actdme;
	}

	public void setActdme(BigDecimal actdme) {
		this.actdme = actdme;
	}

	public String getActflc() {
		return this.actflc;
	}

	public void setActflc(String actflc) {
		this.actflc = actflc;
	}

	public String getActflg() {
		return this.actflg;
	}

	public void setActflg(String actflg) {
		this.actflg = actflg;
	}

	public BigDecimal getActgrp() {
		return this.actgrp;
	}

	public void setActgrp(BigDecimal actgrp) {
		this.actgrp = actgrp;
	}

	public String getActifa() {
		return this.actifa;
	}

	public void setActifa(String actifa) {
		this.actifa = actifa;
	}

	public String getActipd() {
		return this.actipd;
	}

	public void setActipd(String actipd) {
		this.actipd = actipd;
	}

	public BigDecimal getActnfa() {
		return this.actnfa;
	}

	public void setActnfa(BigDecimal actnfa) {
		this.actnfa = actnfa;
	}

	public BigDecimal getActpin() {
		return this.actpin;
	}

	public void setActpin(BigDecimal actpin) {
		this.actpin = actpin;
	}

	public BigDecimal getActpre() {
		return this.actpre;
	}

	public void setActpre(BigDecimal actpre) {
		this.actpre = actpre;
	}

	public String getActsubcon() {
		return this.actsubcon;
	}

	public void setActsubcon(String actsubcon) {
		this.actsubcon = actsubcon;
	}

	public BigDecimal getActtec() {
		return this.acttec;
	}

	public void setActtec(BigDecimal acttec) {
		this.acttec = acttec;
	}

	public BigDecimal getActtep() {
		return this.acttep;
	}

	public void setActtep(BigDecimal acttep) {
		this.acttep = acttep;
	}

	public String getActtmm() {
		return this.acttmm;
	}

	public void setActtmm(String acttmm) {
		this.acttmm = acttmm;
	}

	public BigDecimal getActtpe() {
		return this.acttpe;
	}

	public void setActtpe(BigDecimal acttpe) {
		this.acttpe = acttpe;
	}

	public BigDecimal getActtpp() {
		return this.acttpp;
	}

	public void setActtpp(BigDecimal acttpp) {
		this.acttpp = acttpp;
	}

	public BigDecimal getActven() {
		return this.actven;
	}

	public void setActven(BigDecimal actven) {
		this.actven = actven;
	}

	public BigDecimal getActvme() {
		return this.actvme;
	}

	public void setActvme(BigDecimal actvme) {
		this.actvme = actvme;
	}

	public BigDecimal getAcvalo() {
		return this.acvalo;
	}

	public void setAcvalo(BigDecimal acvalo) {
		this.acvalo = acvalo;
	}

	public String getAsignpor() {
		return this.asignpor;
	}

	public void setAsignpor(String asignpor) {
		this.asignpor = asignpor;
	}

	public String getAsigpant() {
		return this.asigpant;
	}

	public void setAsigpant(String asigpant) {
		this.asigpant = asigpant;
	}

	public String getAutcat() {
		return this.autcat;
	}

	public void setAutcat(String autcat) {
		this.autcat = autcat;
	}

	public String getAutcha() {
		return this.autcha;
	}

	public void setAutcha(String autcha) {
		this.autcha = autcha;
	}

	public String getAutcmb() {
		return this.autcmb;
	}

	public void setAutcmb(String autcmb) {
		this.autcmb = autcmb;
	}

	public String getAutmar() {
		return this.autmar;
	}

	public void setAutmar(String autmar) {
		this.autmar = autmar;
	}

	public String getAutmde() {
		return this.autmde;
	}

	public void setAutmde(String autmde) {
		this.autmde = autmde;
	}

	public String getAutmot() {
		return this.autmot;
	}

	public void setAutmot(String autmot) {
		this.autmot = autmot;
	}

	public String getAuttip() {
		return this.auttip;
	}

	public void setAuttip(String auttip) {
		this.auttip = auttip;
	}

	public BigDecimal getCdsuper() {
		return this.cdsuper;
	}

	public void setCdsuper(BigDecimal cdsuper) {
		this.cdsuper = cdsuper;
	}

	public String getCierrepor() {
		return this.cierrepor;
	}

	public void setCierrepor(String cierrepor) {
		this.cierrepor = cierrepor;
	}

	public String getCierrpant() {
		return this.cierrpant;
	}

	public void setCierrpant(String cierrpant) {
		this.cierrpant = cierrpant;
	}

	public BigDecimal getClclie() {
		return this.clclie;
	}

	public void setClclie(BigDecimal clclie) {
		this.clclie = clclie;
	}

	public String getCncomp() {
		return this.cncomp;
	}

	public void setCncomp(String cncomp) {
		this.cncomp = cncomp;
	}

	public String getCnsucu() {
		return this.cnsucu;
	}

	public void setCnsucu(String cnsucu) {
		this.cnsucu = cnsucu;
	}

	public String getDeacti() {
		return this.deacti;
	}

	public void setDeacti(String deacti) {
		this.deacti = deacti;
	}

	public Date getFcasign() {
		return this.fcasign;
	}

	public void setFcasign(Date fcasign) {
		this.fcasign = fcasign;
	}

	public Date getFccierre() {
		return this.fccierre;
	}

	public void setFccierre(Date fccierre) {
		this.fccierre = fccierre;
	}

	public Time getHrasign() {
		return this.hrasign;
	}

	public void setHrasign(Time hrasign) {
		this.hrasign = hrasign;
	}

	public Time getHrcierre() {
		return this.hrcierre;
	}

	public void setHrcierre(Time hrcierre) {
		this.hrcierre = hrcierre;
	}

	public String getOthech() {
		return this.othech;
	}

	public void setOthech(String othech) {
		this.othech = othech;
	}

	public BigDecimal getOthora() {
		return this.othora;
	}

	public void setOthora(BigDecimal othora) {
		this.othora = othora;
	}

	public BigDecimal getOtnume() {
		return this.otnume;
	}

	public void setOtnume(BigDecimal otnume) {
		this.otnume = otnume;
	}

	public String getOtpant() {
		return this.otpant;
	}

	public void setOtpant(String otpant) {
		this.otpant = otpant;
	}

	public String getOtprog() {
		return this.otprog;
	}

	public void setOtprog(String otprog) {
		this.otprog = otprog;
	}

	public BigDecimal getSttdol() {
		return this.sttdol;
	}

	public void setSttdol(BigDecimal sttdol) {
		this.sttdol = sttdol;
	}

	public String getTasact() {
		return this.tasact;
	}

	public void setTasact(String tasact) {
		this.tasact = tasact;
	}

	public BigDecimal getTashor() {
		return this.tashor;
	}

	public void setTashor(BigDecimal tashor) {
		this.tashor = tashor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accoen == null) ? 0 : accoen.hashCode());
		result = prime * result
				+ ((accoment == null) ? 0 : accoment.hashCode());
		result = prime * result + ((accote == null) ? 0 : accote.hashCode());
		result = prime * result + ((acdct == null) ? 0 : acdct.hashCode());
		result = prime * result + ((acdoc == null) ? 0 : acdoc.hashCode());
		result = prime * result + ((acdsbe == null) ? 0 : acdsbe.hashCode());
		result = prime * result + ((acdsbp == null) ? 0 : acdsbp.hashCode());
		result = prime * result + ((acdsbt == null) ? 0 : acdsbt.hashCode());
		result = prime * result + ((acfec1 == null) ? 0 : acfec1.hashCode());
		result = prime * result + ((acfec2 == null) ? 0 : acfec2.hashCode());
		result = prime * result + ((acfech == null) ? 0 : acfech.hashCode());
		result = prime * result + ((acfein == null) ? 0 : acfein.hashCode());
		result = prime * result + ((achofi == null) ? 0 : achofi.hashCode());
		result = prime * result + ((achoin == null) ? 0 : achoin.hashCode());
		result = prime * result + ((acicu == null) ? 0 : acicu.hashCode());
		result = prime * result + ((acicut == null) ? 0 : acicut.hashCode());
		result = prime * result + ((ackco == null) ? 0 : ackco.hashCode());
		result = prime * result + ((acmcu == null) ? 0 : acmcu.hashCode());
		result = prime * result + ((acmcu2 == null) ? 0 : acmcu2.hashCode());
		result = prime * result + ((acnumb == null) ? 0 : acnumb.hashCode());
		result = prime * result + ((acsbl == null) ? 0 : acsbl.hashCode());
		result = prime * result + ((acsblt == null) ? 0 : acsblt.hashCode());
		result = prime * result + ((actden == null) ? 0 : actden.hashCode());
		result = prime * result + ((actdme == null) ? 0 : actdme.hashCode());
		result = prime * result + ((actflc == null) ? 0 : actflc.hashCode());
		result = prime * result + ((actflg == null) ? 0 : actflg.hashCode());
		result = prime * result + ((actgrp == null) ? 0 : actgrp.hashCode());
		result = prime * result + ((actifa == null) ? 0 : actifa.hashCode());
		result = prime * result + ((actipd == null) ? 0 : actipd.hashCode());
		result = prime * result + ((actnfa == null) ? 0 : actnfa.hashCode());
		result = prime * result + ((actpin == null) ? 0 : actpin.hashCode());
		result = prime * result + ((actpre == null) ? 0 : actpre.hashCode());
		result = prime * result
				+ ((actsubcon == null) ? 0 : actsubcon.hashCode());
		result = prime * result + ((acttec == null) ? 0 : acttec.hashCode());
		result = prime * result + ((acttep == null) ? 0 : acttep.hashCode());
		result = prime * result + ((acttmm == null) ? 0 : acttmm.hashCode());
		result = prime * result + ((acttpe == null) ? 0 : acttpe.hashCode());
		result = prime * result + ((acttpp == null) ? 0 : acttpp.hashCode());
		result = prime * result + ((actven == null) ? 0 : actven.hashCode());
		result = prime * result + ((actvme == null) ? 0 : actvme.hashCode());
		result = prime * result + ((acvalo == null) ? 0 : acvalo.hashCode());
		result = prime * result
				+ ((asignpor == null) ? 0 : asignpor.hashCode());
		result = prime * result
				+ ((asigpant == null) ? 0 : asigpant.hashCode());
		result = prime * result + ((autcat == null) ? 0 : autcat.hashCode());
		result = prime * result + ((autcha == null) ? 0 : autcha.hashCode());
		result = prime * result + ((autcmb == null) ? 0 : autcmb.hashCode());
		result = prime * result + ((autmar == null) ? 0 : autmar.hashCode());
		result = prime * result + ((autmde == null) ? 0 : autmde.hashCode());
		result = prime * result + ((autmot == null) ? 0 : autmot.hashCode());
		result = prime * result + ((auttip == null) ? 0 : auttip.hashCode());
		result = prime * result + ((cdsuper == null) ? 0 : cdsuper.hashCode());
		result = prime * result
				+ ((cierrepor == null) ? 0 : cierrepor.hashCode());
		result = prime * result
				+ ((cierrpant == null) ? 0 : cierrpant.hashCode());
		result = prime * result + ((clclie == null) ? 0 : clclie.hashCode());
		result = prime * result + ((cncomp == null) ? 0 : cncomp.hashCode());
		result = prime * result + ((cnsucu == null) ? 0 : cnsucu.hashCode());
		result = prime * result + ((deacti == null) ? 0 : deacti.hashCode());
		result = prime * result + ((fcasign == null) ? 0 : fcasign.hashCode());
		result = prime * result
				+ ((fccierre == null) ? 0 : fccierre.hashCode());
		result = prime * result + ((hrasign == null) ? 0 : hrasign.hashCode());
		result = prime * result
				+ ((hrcierre == null) ? 0 : hrcierre.hashCode());
		result = prime * result + ((othech == null) ? 0 : othech.hashCode());
		result = prime * result + ((othora == null) ? 0 : othora.hashCode());
		result = prime * result + ((otnume == null) ? 0 : otnume.hashCode());
		result = prime * result + ((otpant == null) ? 0 : otpant.hashCode());
		result = prime * result + ((otprog == null) ? 0 : otprog.hashCode());
		result = prime * result + ((sttdol == null) ? 0 : sttdol.hashCode());
		result = prime * result + ((tasact == null) ? 0 : tasact.hashCode());
		result = prime * result + ((tashor == null) ? 0 : tashor.hashCode());
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
		SotactPK other = (SotactPK) obj;
		if (accoen == null) {
			if (other.accoen != null)
				return false;
		} else if (!accoen.equals(other.accoen))
			return false;
		if (accoment == null) {
			if (other.accoment != null)
				return false;
		} else if (!accoment.equals(other.accoment))
			return false;
		if (accote == null) {
			if (other.accote != null)
				return false;
		} else if (!accote.equals(other.accote))
			return false;
		if (acdct == null) {
			if (other.acdct != null)
				return false;
		} else if (!acdct.equals(other.acdct))
			return false;
		if (acdoc == null) {
			if (other.acdoc != null)
				return false;
		} else if (!acdoc.equals(other.acdoc))
			return false;
		if (acdsbe == null) {
			if (other.acdsbe != null)
				return false;
		} else if (!acdsbe.equals(other.acdsbe))
			return false;
		if (acdsbp == null) {
			if (other.acdsbp != null)
				return false;
		} else if (!acdsbp.equals(other.acdsbp))
			return false;
		if (acdsbt == null) {
			if (other.acdsbt != null)
				return false;
		} else if (!acdsbt.equals(other.acdsbt))
			return false;
		if (acfec1 == null) {
			if (other.acfec1 != null)
				return false;
		} else if (!acfec1.equals(other.acfec1))
			return false;
		if (acfec2 == null) {
			if (other.acfec2 != null)
				return false;
		} else if (!acfec2.equals(other.acfec2))
			return false;
		if (acfech == null) {
			if (other.acfech != null)
				return false;
		} else if (!acfech.equals(other.acfech))
			return false;
		if (acfein == null) {
			if (other.acfein != null)
				return false;
		} else if (!acfein.equals(other.acfein))
			return false;
		if (achofi == null) {
			if (other.achofi != null)
				return false;
		} else if (!achofi.equals(other.achofi))
			return false;
		if (achoin == null) {
			if (other.achoin != null)
				return false;
		} else if (!achoin.equals(other.achoin))
			return false;
		if (acicu == null) {
			if (other.acicu != null)
				return false;
		} else if (!acicu.equals(other.acicu))
			return false;
		if (acicut == null) {
			if (other.acicut != null)
				return false;
		} else if (!acicut.equals(other.acicut))
			return false;
		if (ackco == null) {
			if (other.ackco != null)
				return false;
		} else if (!ackco.equals(other.ackco))
			return false;
		if (acmcu == null) {
			if (other.acmcu != null)
				return false;
		} else if (!acmcu.equals(other.acmcu))
			return false;
		if (acmcu2 == null) {
			if (other.acmcu2 != null)
				return false;
		} else if (!acmcu2.equals(other.acmcu2))
			return false;
		if (acnumb == null) {
			if (other.acnumb != null)
				return false;
		} else if (!acnumb.equals(other.acnumb))
			return false;
		if (acsbl == null) {
			if (other.acsbl != null)
				return false;
		} else if (!acsbl.equals(other.acsbl))
			return false;
		if (acsblt == null) {
			if (other.acsblt != null)
				return false;
		} else if (!acsblt.equals(other.acsblt))
			return false;
		if (actden == null) {
			if (other.actden != null)
				return false;
		} else if (!actden.equals(other.actden))
			return false;
		if (actdme == null) {
			if (other.actdme != null)
				return false;
		} else if (!actdme.equals(other.actdme))
			return false;
		if (actflc == null) {
			if (other.actflc != null)
				return false;
		} else if (!actflc.equals(other.actflc))
			return false;
		if (actflg == null) {
			if (other.actflg != null)
				return false;
		} else if (!actflg.equals(other.actflg))
			return false;
		if (actgrp == null) {
			if (other.actgrp != null)
				return false;
		} else if (!actgrp.equals(other.actgrp))
			return false;
		if (actifa == null) {
			if (other.actifa != null)
				return false;
		} else if (!actifa.equals(other.actifa))
			return false;
		if (actipd == null) {
			if (other.actipd != null)
				return false;
		} else if (!actipd.equals(other.actipd))
			return false;
		if (actnfa == null) {
			if (other.actnfa != null)
				return false;
		} else if (!actnfa.equals(other.actnfa))
			return false;
		if (actpin == null) {
			if (other.actpin != null)
				return false;
		} else if (!actpin.equals(other.actpin))
			return false;
		if (actpre == null) {
			if (other.actpre != null)
				return false;
		} else if (!actpre.equals(other.actpre))
			return false;
		if (actsubcon == null) {
			if (other.actsubcon != null)
				return false;
		} else if (!actsubcon.equals(other.actsubcon))
			return false;
		if (acttec == null) {
			if (other.acttec != null)
				return false;
		} else if (!acttec.equals(other.acttec))
			return false;
		if (acttep == null) {
			if (other.acttep != null)
				return false;
		} else if (!acttep.equals(other.acttep))
			return false;
		if (acttmm == null) {
			if (other.acttmm != null)
				return false;
		} else if (!acttmm.equals(other.acttmm))
			return false;
		if (acttpe == null) {
			if (other.acttpe != null)
				return false;
		} else if (!acttpe.equals(other.acttpe))
			return false;
		if (acttpp == null) {
			if (other.acttpp != null)
				return false;
		} else if (!acttpp.equals(other.acttpp))
			return false;
		if (actven == null) {
			if (other.actven != null)
				return false;
		} else if (!actven.equals(other.actven))
			return false;
		if (actvme == null) {
			if (other.actvme != null)
				return false;
		} else if (!actvme.equals(other.actvme))
			return false;
		if (acvalo == null) {
			if (other.acvalo != null)
				return false;
		} else if (!acvalo.equals(other.acvalo))
			return false;
		if (asignpor == null) {
			if (other.asignpor != null)
				return false;
		} else if (!asignpor.equals(other.asignpor))
			return false;
		if (asigpant == null) {
			if (other.asigpant != null)
				return false;
		} else if (!asigpant.equals(other.asigpant))
			return false;
		if (autcat == null) {
			if (other.autcat != null)
				return false;
		} else if (!autcat.equals(other.autcat))
			return false;
		if (autcha == null) {
			if (other.autcha != null)
				return false;
		} else if (!autcha.equals(other.autcha))
			return false;
		if (autcmb == null) {
			if (other.autcmb != null)
				return false;
		} else if (!autcmb.equals(other.autcmb))
			return false;
		if (autmar == null) {
			if (other.autmar != null)
				return false;
		} else if (!autmar.equals(other.autmar))
			return false;
		if (autmde == null) {
			if (other.autmde != null)
				return false;
		} else if (!autmde.equals(other.autmde))
			return false;
		if (autmot == null) {
			if (other.autmot != null)
				return false;
		} else if (!autmot.equals(other.autmot))
			return false;
		if (auttip == null) {
			if (other.auttip != null)
				return false;
		} else if (!auttip.equals(other.auttip))
			return false;
		if (cdsuper == null) {
			if (other.cdsuper != null)
				return false;
		} else if (!cdsuper.equals(other.cdsuper))
			return false;
		if (cierrepor == null) {
			if (other.cierrepor != null)
				return false;
		} else if (!cierrepor.equals(other.cierrepor))
			return false;
		if (cierrpant == null) {
			if (other.cierrpant != null)
				return false;
		} else if (!cierrpant.equals(other.cierrpant))
			return false;
		if (clclie == null) {
			if (other.clclie != null)
				return false;
		} else if (!clclie.equals(other.clclie))
			return false;
		if (cncomp == null) {
			if (other.cncomp != null)
				return false;
		} else if (!cncomp.equals(other.cncomp))
			return false;
		if (cnsucu == null) {
			if (other.cnsucu != null)
				return false;
		} else if (!cnsucu.equals(other.cnsucu))
			return false;
		if (deacti == null) {
			if (other.deacti != null)
				return false;
		} else if (!deacti.equals(other.deacti))
			return false;
		if (fcasign == null) {
			if (other.fcasign != null)
				return false;
		} else if (!fcasign.equals(other.fcasign))
			return false;
		if (fccierre == null) {
			if (other.fccierre != null)
				return false;
		} else if (!fccierre.equals(other.fccierre))
			return false;
		if (hrasign == null) {
			if (other.hrasign != null)
				return false;
		} else if (!hrasign.equals(other.hrasign))
			return false;
		if (hrcierre == null) {
			if (other.hrcierre != null)
				return false;
		} else if (!hrcierre.equals(other.hrcierre))
			return false;
		if (othech == null) {
			if (other.othech != null)
				return false;
		} else if (!othech.equals(other.othech))
			return false;
		if (othora == null) {
			if (other.othora != null)
				return false;
		} else if (!othora.equals(other.othora))
			return false;
		if (otnume == null) {
			if (other.otnume != null)
				return false;
		} else if (!otnume.equals(other.otnume))
			return false;
		if (otpant == null) {
			if (other.otpant != null)
				return false;
		} else if (!otpant.equals(other.otpant))
			return false;
		if (otprog == null) {
			if (other.otprog != null)
				return false;
		} else if (!otprog.equals(other.otprog))
			return false;
		if (sttdol == null) {
			if (other.sttdol != null)
				return false;
		} else if (!sttdol.equals(other.sttdol))
			return false;
		if (tasact == null) {
			if (other.tasact != null)
				return false;
		} else if (!tasact.equals(other.tasact))
			return false;
		if (tashor == null) {
			if (other.tashor != null)
				return false;
		} else if (!tashor.equals(other.tashor))
			return false;
		return true;
	}
}
