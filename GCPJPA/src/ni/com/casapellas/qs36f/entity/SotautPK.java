package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class SotautPK  implements Serializable {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autano == null) ? 0 : autano.hashCode());
		result = prime * result + ((autcap == null) ? 0 : autcap.hashCode());
		result = prime * result + ((autcat == null) ? 0 : autcat.hashCode());
		result = prime * result + ((autcc1 == null) ? 0 : autcc1.hashCode());
		result = prime * result + ((autcc2 == null) ? 0 : autcc2.hashCode());
		result = prime * result + ((autcha == null) ? 0 : autcha.hashCode());
		result = prime * result + ((autcil == null) ? 0 : autcil.hashCode());
		result = prime * result + ((autcmb == null) ? 0 : autcmb.hashCode());
		result = prime * result + ((autcoi == null) ? 0 : autcoi.hashCode());
		result = prime * result + ((autcol == null) ? 0 : autcol.hashCode());
		result = prime * result + ((auteqp == null) ? 0 : auteqp.hashCode());
		result = prime * result + ((autfech == null) ? 0 : autfech.hashCode());
		result = prime * result + ((autflm == null) ? 0 : autflm.hashCode());
		result = prime * result + ((autflt == null) ? 0 : autflt.hashCode());
		result = prime * result + ((autfmt == null) ? 0 : autfmt.hashCode());
		result = prime * result + ((authech == null) ? 0 : authech.hashCode());
		result = prime * result + ((authora == null) ? 0 : authora.hashCode());
		result = prime * result + ((autkmt == null) ? 0 : autkmt.hashCode());
		result = prime * result + ((autman == null) ? 0 : autman.hashCode());
		result = prime * result + ((autmar == null) ? 0 : autmar.hashCode());
		result = prime * result + ((autmde == null) ? 0 : autmde.hashCode());
		result = prime * result + ((autmfa == null) ? 0 : autmfa.hashCode());
		result = prime * result + ((autmo1 == null) ? 0 : autmo1.hashCode());
		result = prime * result + ((autmo2 == null) ? 0 : autmo2.hashCode());
		result = prime * result + ((autmod == null) ? 0 : autmod.hashCode());
		result = prime * result + ((autmot == null) ? 0 : autmot.hashCode());
		result = prime * result + ((autmt1 == null) ? 0 : autmt1.hashCode());
		result = prime * result + ((autmt2 == null) ? 0 : autmt2.hashCode());
		result = prime * result + ((autnve == null) ? 0 : autnve.hashCode());
		result = prime * result + ((autog1 == null) ? 0 : autog1.hashCode());
		result = prime * result + ((autog2 == null) ? 0 : autog2.hashCode());
		result = prime * result + ((autpant == null) ? 0 : autpant.hashCode());
		result = prime * result + ((autplc == null) ? 0 : autplc.hashCode());
		result = prime * result + ((autprf == null) ? 0 : autprf.hashCode());
		result = prime * result + ((autpro == null) ? 0 : autpro.hashCode());
		result = prime * result + ((autprog == null) ? 0 : autprog.hashCode());
		result = prime * result + ((autrp1 == null) ? 0 : autrp1.hashCode());
		result = prime * result + ((autrp2 == null) ? 0 : autrp2.hashCode());
		result = prime * result + ((autrut == null) ? 0 : autrut.hashCode());
		result = prime * result + ((auttca == null) ? 0 : auttca.hashCode());
		result = prime * result + ((auttip == null) ? 0 : auttip.hashCode());
		result = prime * result + ((auttma == null) ? 0 : auttma.hashCode());
		result = prime * result + ((clclas == null) ? 0 : clclas.hashCode());
		result = prime * result + ((clclie == null) ? 0 : clclie.hashCode());
		result = prime * result + ((cncomp == null) ? 0 : cncomp.hashCode());
		result = prime * result + ((cnsucu == null) ? 0 : cnsucu.hashCode());
		result = prime * result + ((diashoy == null) ? 0 : diashoy.hashCode());
		result = prime * result + ((diasprs == null) ? 0 : diasprs.hashCode());
		result = prime * result + ((diaulac == null) ? 0 : diaulac.hashCode());
		result = prime * result + ((fecenv == null) ? 0 : fecenv.hashCode());
		result = prime * result + ((fecesp == null) ? 0 : fecesp.hashCode());
		result = prime * result + ((fecgnr == null) ? 0 : fecgnr.hashCode());
		result = prime * result + ((fechoy == null) ? 0 : fechoy.hashCode());
		result = prime * result + ((fecor1 == null) ? 0 : fecor1.hashCode());
		result = prime * result + ((fecpll == null) ? 0 : fecpll.hashCode());
		result = prime * result + ((fecpxm == null) ? 0 : fecpxm.hashCode());
		result = prime * result + ((feculac == null) ? 0 : feculac.hashCode());
		result = prime * result + ((feculma == null) ? 0 : feculma.hashCode());
		result = prime * result + ((fecvll == null) ? 0 : fecvll.hashCode());
		result = prime * result + ((fecvta == null) ? 0 : fecvta.hashCode());
		result = prime * result + ((femmrs == null) ? 0 : femmrs.hashCode());
		result = prime * result + ((kmprdia == null) ? 0 : kmprdia.hashCode());
		result = prime * result + ((kmprua == null) ? 0 : kmprua.hashCode());
		result = prime * result + ((kmtarec == null) ? 0 : kmtarec.hashCode());
		result = prime * result + ((kmtchoy == null) ? 0 : kmtchoy.hashCode());
		result = prime * result + ((kmtcomp == null) ? 0 : kmtcomp.hashCode());
		result = prime * result + ((kmtinic == null) ? 0 : kmtinic.hashCode());
		result = prime * result + ((kmtulac == null) ? 0 : kmtulac.hashCode());
		result = prime * result + ((kmtulma == null) ? 0 : kmtulma.hashCode());
		result = prime * result + ((mantsg == null) ? 0 : mantsg.hashCode());
		result = prime * result + ((mrscat == null) ? 0 : mrscat.hashCode());
		result = prime * result + ((mrssct == null) ? 0 : mrssct.hashCode());
		result = prime * result + ((otfemo == null) ? 0 : otfemo.hashCode());
		result = prime * result + ((otfinc == null) ? 0 : otfinc.hashCode());
		result = prime * result + ((othech == null) ? 0 : othech.hashCode());
		result = prime * result + ((othomo == null) ? 0 : othomo.hashCode());
		result = prime * result + ((othora == null) ? 0 : othora.hashCode());
		result = prime * result + ((otpant == null) ? 0 : otpant.hashCode());
		result = prime * result + ((otprac == null) ? 0 : otprac.hashCode());
		result = prime * result + ((otprmo == null) ? 0 : otprmo.hashCode());
		result = prime * result + ((otprog == null) ? 0 : otprog.hashCode());
		result = prime * result + ((ottclt == null) ? 0 : ottclt.hashCode());
		result = prime * result + ((otusmo == null) ? 0 : otusmo.hashCode());
		result = prime * result + ((stsmrs == null) ? 0 : stsmrs.hashCode());
		result = prime * result + ((stsvec == null) ? 0 : stsvec.hashCode());
		result = prime * result + ((stsveh == null) ? 0 : stsveh.hashCode());
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
		SotautPK other = (SotautPK) obj;
		if (autano == null) {
			if (other.autano != null)
				return false;
		} else if (!autano.equals(other.autano))
			return false;
		if (autcap == null) {
			if (other.autcap != null)
				return false;
		} else if (!autcap.equals(other.autcap))
			return false;
		if (autcat == null) {
			if (other.autcat != null)
				return false;
		} else if (!autcat.equals(other.autcat))
			return false;
		if (autcc1 == null) {
			if (other.autcc1 != null)
				return false;
		} else if (!autcc1.equals(other.autcc1))
			return false;
		if (autcc2 == null) {
			if (other.autcc2 != null)
				return false;
		} else if (!autcc2.equals(other.autcc2))
			return false;
		if (autcha == null) {
			if (other.autcha != null)
				return false;
		} else if (!autcha.equals(other.autcha))
			return false;
		if (autcil == null) {
			if (other.autcil != null)
				return false;
		} else if (!autcil.equals(other.autcil))
			return false;
		if (autcmb == null) {
			if (other.autcmb != null)
				return false;
		} else if (!autcmb.equals(other.autcmb))
			return false;
		if (autcoi == null) {
			if (other.autcoi != null)
				return false;
		} else if (!autcoi.equals(other.autcoi))
			return false;
		if (autcol == null) {
			if (other.autcol != null)
				return false;
		} else if (!autcol.equals(other.autcol))
			return false;
		if (auteqp == null) {
			if (other.auteqp != null)
				return false;
		} else if (!auteqp.equals(other.auteqp))
			return false;
		if (autfech == null) {
			if (other.autfech != null)
				return false;
		} else if (!autfech.equals(other.autfech))
			return false;
		if (autflm == null) {
			if (other.autflm != null)
				return false;
		} else if (!autflm.equals(other.autflm))
			return false;
		if (autflt == null) {
			if (other.autflt != null)
				return false;
		} else if (!autflt.equals(other.autflt))
			return false;
		if (autfmt == null) {
			if (other.autfmt != null)
				return false;
		} else if (!autfmt.equals(other.autfmt))
			return false;
		if (authech == null) {
			if (other.authech != null)
				return false;
		} else if (!authech.equals(other.authech))
			return false;
		if (authora == null) {
			if (other.authora != null)
				return false;
		} else if (!authora.equals(other.authora))
			return false;
		if (autkmt == null) {
			if (other.autkmt != null)
				return false;
		} else if (!autkmt.equals(other.autkmt))
			return false;
		if (autman == null) {
			if (other.autman != null)
				return false;
		} else if (!autman.equals(other.autman))
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
		if (autmfa == null) {
			if (other.autmfa != null)
				return false;
		} else if (!autmfa.equals(other.autmfa))
			return false;
		if (autmo1 == null) {
			if (other.autmo1 != null)
				return false;
		} else if (!autmo1.equals(other.autmo1))
			return false;
		if (autmo2 == null) {
			if (other.autmo2 != null)
				return false;
		} else if (!autmo2.equals(other.autmo2))
			return false;
		if (autmod == null) {
			if (other.autmod != null)
				return false;
		} else if (!autmod.equals(other.autmod))
			return false;
		if (autmot == null) {
			if (other.autmot != null)
				return false;
		} else if (!autmot.equals(other.autmot))
			return false;
		if (autmt1 == null) {
			if (other.autmt1 != null)
				return false;
		} else if (!autmt1.equals(other.autmt1))
			return false;
		if (autmt2 == null) {
			if (other.autmt2 != null)
				return false;
		} else if (!autmt2.equals(other.autmt2))
			return false;
		if (autnve == null) {
			if (other.autnve != null)
				return false;
		} else if (!autnve.equals(other.autnve))
			return false;
		if (autog1 == null) {
			if (other.autog1 != null)
				return false;
		} else if (!autog1.equals(other.autog1))
			return false;
		if (autog2 == null) {
			if (other.autog2 != null)
				return false;
		} else if (!autog2.equals(other.autog2))
			return false;
		if (autpant == null) {
			if (other.autpant != null)
				return false;
		} else if (!autpant.equals(other.autpant))
			return false;
		if (autplc == null) {
			if (other.autplc != null)
				return false;
		} else if (!autplc.equals(other.autplc))
			return false;
		if (autprf == null) {
			if (other.autprf != null)
				return false;
		} else if (!autprf.equals(other.autprf))
			return false;
		if (autpro == null) {
			if (other.autpro != null)
				return false;
		} else if (!autpro.equals(other.autpro))
			return false;
		if (autprog == null) {
			if (other.autprog != null)
				return false;
		} else if (!autprog.equals(other.autprog))
			return false;
		if (autrp1 == null) {
			if (other.autrp1 != null)
				return false;
		} else if (!autrp1.equals(other.autrp1))
			return false;
		if (autrp2 == null) {
			if (other.autrp2 != null)
				return false;
		} else if (!autrp2.equals(other.autrp2))
			return false;
		if (autrut == null) {
			if (other.autrut != null)
				return false;
		} else if (!autrut.equals(other.autrut))
			return false;
		if (auttca == null) {
			if (other.auttca != null)
				return false;
		} else if (!auttca.equals(other.auttca))
			return false;
		if (auttip == null) {
			if (other.auttip != null)
				return false;
		} else if (!auttip.equals(other.auttip))
			return false;
		if (auttma == null) {
			if (other.auttma != null)
				return false;
		} else if (!auttma.equals(other.auttma))
			return false;
		if (clclas == null) {
			if (other.clclas != null)
				return false;
		} else if (!clclas.equals(other.clclas))
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
		if (diashoy == null) {
			if (other.diashoy != null)
				return false;
		} else if (!diashoy.equals(other.diashoy))
			return false;
		if (diasprs == null) {
			if (other.diasprs != null)
				return false;
		} else if (!diasprs.equals(other.diasprs))
			return false;
		if (diaulac == null) {
			if (other.diaulac != null)
				return false;
		} else if (!diaulac.equals(other.diaulac))
			return false;
		if (fecenv == null) {
			if (other.fecenv != null)
				return false;
		} else if (!fecenv.equals(other.fecenv))
			return false;
		if (fecesp == null) {
			if (other.fecesp != null)
				return false;
		} else if (!fecesp.equals(other.fecesp))
			return false;
		if (fecgnr == null) {
			if (other.fecgnr != null)
				return false;
		} else if (!fecgnr.equals(other.fecgnr))
			return false;
		if (fechoy == null) {
			if (other.fechoy != null)
				return false;
		} else if (!fechoy.equals(other.fechoy))
			return false;
		if (fecor1 == null) {
			if (other.fecor1 != null)
				return false;
		} else if (!fecor1.equals(other.fecor1))
			return false;
		if (fecpll == null) {
			if (other.fecpll != null)
				return false;
		} else if (!fecpll.equals(other.fecpll))
			return false;
		if (fecpxm == null) {
			if (other.fecpxm != null)
				return false;
		} else if (!fecpxm.equals(other.fecpxm))
			return false;
		if (feculac == null) {
			if (other.feculac != null)
				return false;
		} else if (!feculac.equals(other.feculac))
			return false;
		if (feculma == null) {
			if (other.feculma != null)
				return false;
		} else if (!feculma.equals(other.feculma))
			return false;
		if (fecvll == null) {
			if (other.fecvll != null)
				return false;
		} else if (!fecvll.equals(other.fecvll))
			return false;
		if (fecvta == null) {
			if (other.fecvta != null)
				return false;
		} else if (!fecvta.equals(other.fecvta))
			return false;
		if (femmrs == null) {
			if (other.femmrs != null)
				return false;
		} else if (!femmrs.equals(other.femmrs))
			return false;
		if (kmprdia == null) {
			if (other.kmprdia != null)
				return false;
		} else if (!kmprdia.equals(other.kmprdia))
			return false;
		if (kmprua == null) {
			if (other.kmprua != null)
				return false;
		} else if (!kmprua.equals(other.kmprua))
			return false;
		if (kmtarec == null) {
			if (other.kmtarec != null)
				return false;
		} else if (!kmtarec.equals(other.kmtarec))
			return false;
		if (kmtchoy == null) {
			if (other.kmtchoy != null)
				return false;
		} else if (!kmtchoy.equals(other.kmtchoy))
			return false;
		if (kmtcomp == null) {
			if (other.kmtcomp != null)
				return false;
		} else if (!kmtcomp.equals(other.kmtcomp))
			return false;
		if (kmtinic == null) {
			if (other.kmtinic != null)
				return false;
		} else if (!kmtinic.equals(other.kmtinic))
			return false;
		if (kmtulac == null) {
			if (other.kmtulac != null)
				return false;
		} else if (!kmtulac.equals(other.kmtulac))
			return false;
		if (kmtulma == null) {
			if (other.kmtulma != null)
				return false;
		} else if (!kmtulma.equals(other.kmtulma))
			return false;
		if (mantsg == null) {
			if (other.mantsg != null)
				return false;
		} else if (!mantsg.equals(other.mantsg))
			return false;
		if (mrscat == null) {
			if (other.mrscat != null)
				return false;
		} else if (!mrscat.equals(other.mrscat))
			return false;
		if (mrssct == null) {
			if (other.mrssct != null)
				return false;
		} else if (!mrssct.equals(other.mrssct))
			return false;
		if (otfemo == null) {
			if (other.otfemo != null)
				return false;
		} else if (!otfemo.equals(other.otfemo))
			return false;
		if (otfinc == null) {
			if (other.otfinc != null)
				return false;
		} else if (!otfinc.equals(other.otfinc))
			return false;
		if (othech == null) {
			if (other.othech != null)
				return false;
		} else if (!othech.equals(other.othech))
			return false;
		if (othomo == null) {
			if (other.othomo != null)
				return false;
		} else if (!othomo.equals(other.othomo))
			return false;
		if (othora == null) {
			if (other.othora != null)
				return false;
		} else if (!othora.equals(other.othora))
			return false;
		if (otpant == null) {
			if (other.otpant != null)
				return false;
		} else if (!otpant.equals(other.otpant))
			return false;
		if (otprac == null) {
			if (other.otprac != null)
				return false;
		} else if (!otprac.equals(other.otprac))
			return false;
		if (otprmo == null) {
			if (other.otprmo != null)
				return false;
		} else if (!otprmo.equals(other.otprmo))
			return false;
		if (otprog == null) {
			if (other.otprog != null)
				return false;
		} else if (!otprog.equals(other.otprog))
			return false;
		if (ottclt == null) {
			if (other.ottclt != null)
				return false;
		} else if (!ottclt.equals(other.ottclt))
			return false;
		if (otusmo == null) {
			if (other.otusmo != null)
				return false;
		} else if (!otusmo.equals(other.otusmo))
			return false;
		if (stsmrs == null) {
			if (other.stsmrs != null)
				return false;
		} else if (!stsmrs.equals(other.stsmrs))
			return false;
		if (stsvec == null) {
			if (other.stsvec != null)
				return false;
		} else if (!stsvec.equals(other.stsvec))
			return false;
		if (stsveh == null) {
			if (other.stsveh != null)
				return false;
		} else if (!stsveh.equals(other.stsveh))
			return false;
		return true;
	}

	private static final long serialVersionUID = 1L;

	private BigDecimal autano;

	private String autcap;

	private String autcat;

	private BigDecimal autcc1;

	private BigDecimal autcc2;

	private String autcha;

	private String autcil;

	private String autcmb;

	private String autcoi;

	private String autcol;

	private BigDecimal auteqp;

    @Temporal( TemporalType.DATE)
	private Date autfech;

	private BigDecimal autflm;

	private String autflt;

	private BigDecimal autfmt;

	private String authech;

	private Time authora;

	private BigDecimal autkmt;

	private String autman;

	private String autmar;

	private String autmde;

	private String autmfa;

	private BigDecimal autmo1;

	private BigDecimal autmo2;

	private String autmod;

	private String autmot;

	private BigDecimal autmt1;

	private BigDecimal autmt2;

	private BigDecimal autnve;

	private BigDecimal autog1;

	private BigDecimal autog2;

	private String autpant;

	private String autplc;

	private String autprf;

	private BigDecimal autpro;

	private String autprog;

	private BigDecimal autrp1;

	private BigDecimal autrp2;

	private String autrut;

	private String auttca;

	private String auttip;

	private String auttma;

	private String clclas;

	private BigDecimal clclie;

	private String cncomp;

	private String cnsucu;

	private BigDecimal diashoy;

	private BigDecimal diasprs;

	private BigDecimal diaulac;

    @Temporal( TemporalType.DATE)
	private Date fecenv;

    @Temporal( TemporalType.DATE)
	private Date fecesp;

    @Temporal( TemporalType.DATE)
	private Date fecgnr;

    @Temporal( TemporalType.DATE)
	private Date fechoy;

    @Temporal( TemporalType.DATE)
	private Date fecor1;

    @Temporal( TemporalType.DATE)
	private Date fecpll;

    @Temporal( TemporalType.DATE)
	private Date fecpxm;

    @Temporal( TemporalType.DATE)
	private Date feculac;

    @Temporal( TemporalType.DATE)
	private Date feculma;

    @Temporal( TemporalType.DATE)
	private Date fecvll;

    @Temporal( TemporalType.DATE)
	private Date fecvta;

    @Temporal( TemporalType.DATE)
	private Date femmrs;

	private BigDecimal kmprdia;

	private BigDecimal kmprua;

	private BigDecimal kmtarec;

	private BigDecimal kmtchoy;

	private BigDecimal kmtcomp;

	private BigDecimal kmtinic;

	private BigDecimal kmtulac;

	private BigDecimal kmtulma;

	private String mantsg;

	private String mrscat;

	private String mrssct;

    @Temporal( TemporalType.DATE)
	private Date otfemo;

	private BigDecimal otfinc;

	private String othech;

	private Time othomo;

	private BigDecimal othora;

	private String otpant;

	private String otprac;

	private String otprmo;

	private String otprog;

	private String ottclt;

	private String otusmo;

	private String stsmrs;

	private String stsvec;

	private String stsveh;

    public SotautPK() {
    }

	public BigDecimal getAutano() {
		return this.autano;
	}

	public void setAutano(BigDecimal autano) {
		this.autano = autano;
	}

	public String getAutcap() {
		return this.autcap;
	}

	public void setAutcap(String autcap) {
		this.autcap = autcap;
	}

	public String getAutcat() {
		return this.autcat;
	}

	public void setAutcat(String autcat) {
		this.autcat = autcat;
	}

	public BigDecimal getAutcc1() {
		return this.autcc1;
	}

	public void setAutcc1(BigDecimal autcc1) {
		this.autcc1 = autcc1;
	}

	public BigDecimal getAutcc2() {
		return this.autcc2;
	}

	public void setAutcc2(BigDecimal autcc2) {
		this.autcc2 = autcc2;
	}

	public String getAutcha() {
		return this.autcha;
	}

	public void setAutcha(String autcha) {
		this.autcha = autcha;
	}

	public String getAutcil() {
		return this.autcil;
	}

	public void setAutcil(String autcil) {
		this.autcil = autcil;
	}

	public String getAutcmb() {
		return this.autcmb;
	}

	public void setAutcmb(String autcmb) {
		this.autcmb = autcmb;
	}

	public String getAutcoi() {
		return this.autcoi;
	}

	public void setAutcoi(String autcoi) {
		this.autcoi = autcoi;
	}

	public String getAutcol() {
		return this.autcol;
	}

	public void setAutcol(String autcol) {
		this.autcol = autcol;
	}

	public BigDecimal getAuteqp() {
		return this.auteqp;
	}

	public void setAuteqp(BigDecimal auteqp) {
		this.auteqp = auteqp;
	}

	public Date getAutfech() {
		return this.autfech;
	}

	public void setAutfech(Date autfech) {
		this.autfech = autfech;
	}

	public BigDecimal getAutflm() {
		return this.autflm;
	}

	public void setAutflm(BigDecimal autflm) {
		this.autflm = autflm;
	}

	public String getAutflt() {
		return this.autflt;
	}

	public void setAutflt(String autflt) {
		this.autflt = autflt;
	}

	public BigDecimal getAutfmt() {
		return this.autfmt;
	}

	public void setAutfmt(BigDecimal autfmt) {
		this.autfmt = autfmt;
	}

	public String getAuthech() {
		return this.authech;
	}

	public void setAuthech(String authech) {
		this.authech = authech;
	}

	public Time getAuthora() {
		return this.authora;
	}

	public void setAuthora(Time authora) {
		this.authora = authora;
	}

	public BigDecimal getAutkmt() {
		return this.autkmt;
	}

	public void setAutkmt(BigDecimal autkmt) {
		this.autkmt = autkmt;
	}

	public String getAutman() {
		return this.autman;
	}

	public void setAutman(String autman) {
		this.autman = autman;
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

	public String getAutmfa() {
		return this.autmfa;
	}

	public void setAutmfa(String autmfa) {
		this.autmfa = autmfa;
	}

	public BigDecimal getAutmo1() {
		return this.autmo1;
	}

	public void setAutmo1(BigDecimal autmo1) {
		this.autmo1 = autmo1;
	}

	public BigDecimal getAutmo2() {
		return this.autmo2;
	}

	public void setAutmo2(BigDecimal autmo2) {
		this.autmo2 = autmo2;
	}

	public String getAutmod() {
		return this.autmod;
	}

	public void setAutmod(String autmod) {
		this.autmod = autmod;
	}

	public String getAutmot() {
		return this.autmot;
	}

	public void setAutmot(String autmot) {
		this.autmot = autmot;
	}

	public BigDecimal getAutmt1() {
		return this.autmt1;
	}

	public void setAutmt1(BigDecimal autmt1) {
		this.autmt1 = autmt1;
	}

	public BigDecimal getAutmt2() {
		return this.autmt2;
	}

	public void setAutmt2(BigDecimal autmt2) {
		this.autmt2 = autmt2;
	}

	public BigDecimal getAutnve() {
		return this.autnve;
	}

	public void setAutnve(BigDecimal autnve) {
		this.autnve = autnve;
	}

	public BigDecimal getAutog1() {
		return this.autog1;
	}

	public void setAutog1(BigDecimal autog1) {
		this.autog1 = autog1;
	}

	public BigDecimal getAutog2() {
		return this.autog2;
	}

	public void setAutog2(BigDecimal autog2) {
		this.autog2 = autog2;
	}

	public String getAutpant() {
		return this.autpant;
	}

	public void setAutpant(String autpant) {
		this.autpant = autpant;
	}

	public String getAutplc() {
		return this.autplc;
	}

	public void setAutplc(String autplc) {
		this.autplc = autplc;
	}

	public String getAutprf() {
		return this.autprf;
	}

	public void setAutprf(String autprf) {
		this.autprf = autprf;
	}

	public BigDecimal getAutpro() {
		return this.autpro;
	}

	public void setAutpro(BigDecimal autpro) {
		this.autpro = autpro;
	}

	public String getAutprog() {
		return this.autprog;
	}

	public void setAutprog(String autprog) {
		this.autprog = autprog;
	}

	public BigDecimal getAutrp1() {
		return this.autrp1;
	}

	public void setAutrp1(BigDecimal autrp1) {
		this.autrp1 = autrp1;
	}

	public BigDecimal getAutrp2() {
		return this.autrp2;
	}

	public void setAutrp2(BigDecimal autrp2) {
		this.autrp2 = autrp2;
	}

	public String getAutrut() {
		return this.autrut;
	}

	public void setAutrut(String autrut) {
		this.autrut = autrut;
	}

	public String getAuttca() {
		return this.auttca;
	}

	public void setAuttca(String auttca) {
		this.auttca = auttca;
	}

	public String getAuttip() {
		return this.auttip;
	}

	public void setAuttip(String auttip) {
		this.auttip = auttip;
	}

	public String getAuttma() {
		return this.auttma;
	}

	public void setAuttma(String auttma) {
		this.auttma = auttma;
	}

	public String getClclas() {
		return this.clclas;
	}

	public void setClclas(String clclas) {
		this.clclas = clclas;
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

	public BigDecimal getDiashoy() {
		return this.diashoy;
	}

	public void setDiashoy(BigDecimal diashoy) {
		this.diashoy = diashoy;
	}

	public BigDecimal getDiasprs() {
		return this.diasprs;
	}

	public void setDiasprs(BigDecimal diasprs) {
		this.diasprs = diasprs;
	}

	public BigDecimal getDiaulac() {
		return this.diaulac;
	}

	public void setDiaulac(BigDecimal diaulac) {
		this.diaulac = diaulac;
	}

	public Date getFecenv() {
		return this.fecenv;
	}

	public void setFecenv(Date fecenv) {
		this.fecenv = fecenv;
	}

	public Date getFecesp() {
		return this.fecesp;
	}

	public void setFecesp(Date fecesp) {
		this.fecesp = fecesp;
	}

	public Date getFecgnr() {
		return this.fecgnr;
	}

	public void setFecgnr(Date fecgnr) {
		this.fecgnr = fecgnr;
	}

	public Date getFechoy() {
		return this.fechoy;
	}

	public void setFechoy(Date fechoy) {
		this.fechoy = fechoy;
	}

	public Date getFecor1() {
		return this.fecor1;
	}

	public void setFecor1(Date fecor1) {
		this.fecor1 = fecor1;
	}

	public Date getFecpll() {
		return this.fecpll;
	}

	public void setFecpll(Date fecpll) {
		this.fecpll = fecpll;
	}

	public Date getFecpxm() {
		return this.fecpxm;
	}

	public void setFecpxm(Date fecpxm) {
		this.fecpxm = fecpxm;
	}

	public Date getFeculac() {
		return this.feculac;
	}

	public void setFeculac(Date feculac) {
		this.feculac = feculac;
	}

	public Date getFeculma() {
		return this.feculma;
	}

	public void setFeculma(Date feculma) {
		this.feculma = feculma;
	}

	public Date getFecvll() {
		return this.fecvll;
	}

	public void setFecvll(Date fecvll) {
		this.fecvll = fecvll;
	}

	public Date getFecvta() {
		return this.fecvta;
	}

	public void setFecvta(Date fecvta) {
		this.fecvta = fecvta;
	}

	public Date getFemmrs() {
		return this.femmrs;
	}

	public void setFemmrs(Date femmrs) {
		this.femmrs = femmrs;
	}

	public BigDecimal getKmprdia() {
		return this.kmprdia;
	}

	public void setKmprdia(BigDecimal kmprdia) {
		this.kmprdia = kmprdia;
	}

	public BigDecimal getKmprua() {
		return this.kmprua;
	}

	public void setKmprua(BigDecimal kmprua) {
		this.kmprua = kmprua;
	}

	public BigDecimal getKmtarec() {
		return this.kmtarec;
	}

	public void setKmtarec(BigDecimal kmtarec) {
		this.kmtarec = kmtarec;
	}

	public BigDecimal getKmtchoy() {
		return this.kmtchoy;
	}

	public void setKmtchoy(BigDecimal kmtchoy) {
		this.kmtchoy = kmtchoy;
	}

	public BigDecimal getKmtcomp() {
		return this.kmtcomp;
	}

	public void setKmtcomp(BigDecimal kmtcomp) {
		this.kmtcomp = kmtcomp;
	}

	public BigDecimal getKmtinic() {
		return this.kmtinic;
	}

	public void setKmtinic(BigDecimal kmtinic) {
		this.kmtinic = kmtinic;
	}

	public BigDecimal getKmtulac() {
		return this.kmtulac;
	}

	public void setKmtulac(BigDecimal kmtulac) {
		this.kmtulac = kmtulac;
	}

	public BigDecimal getKmtulma() {
		return this.kmtulma;
	}

	public void setKmtulma(BigDecimal kmtulma) {
		this.kmtulma = kmtulma;
	}

	public String getMantsg() {
		return this.mantsg;
	}

	public void setMantsg(String mantsg) {
		this.mantsg = mantsg;
	}

	public String getMrscat() {
		return this.mrscat;
	}

	public void setMrscat(String mrscat) {
		this.mrscat = mrscat;
	}

	public String getMrssct() {
		return this.mrssct;
	}

	public void setMrssct(String mrssct) {
		this.mrssct = mrssct;
	}

	public Date getOtfemo() {
		return this.otfemo;
	}

	public void setOtfemo(Date otfemo) {
		this.otfemo = otfemo;
	}

	public BigDecimal getOtfinc() {
		return this.otfinc;
	}

	public void setOtfinc(BigDecimal otfinc) {
		this.otfinc = otfinc;
	}

	public String getOthech() {
		return this.othech;
	}

	public void setOthech(String othech) {
		this.othech = othech;
	}

	public Time getOthomo() {
		return this.othomo;
	}

	public void setOthomo(Time othomo) {
		this.othomo = othomo;
	}

	public BigDecimal getOthora() {
		return this.othora;
	}

	public void setOthora(BigDecimal othora) {
		this.othora = othora;
	}

	public String getOtpant() {
		return this.otpant;
	}

	public void setOtpant(String otpant) {
		this.otpant = otpant;
	}

	public String getOtprac() {
		return this.otprac;
	}

	public void setOtprac(String otprac) {
		this.otprac = otprac;
	}

	public String getOtprmo() {
		return this.otprmo;
	}

	public void setOtprmo(String otprmo) {
		this.otprmo = otprmo;
	}

	public String getOtprog() {
		return this.otprog;
	}

	public void setOtprog(String otprog) {
		this.otprog = otprog;
	}

	public String getOttclt() {
		return this.ottclt;
	}

	public void setOttclt(String ottclt) {
		this.ottclt = ottclt;
	}

	public String getOtusmo() {
		return this.otusmo;
	}

	public void setOtusmo(String otusmo) {
		this.otusmo = otusmo;
	}

	public String getStsmrs() {
		return this.stsmrs;
	}

	public void setStsmrs(String stsmrs) {
		this.stsmrs = stsmrs;
	}

	public String getStsvec() {
		return this.stsvec;
	}

	public void setStsvec(String stsvec) {
		this.stsvec = stsvec;
	}

	public String getStsveh() {
		return this.stsveh;
	}

	public void setStsveh(String stsveh) {
		this.stsveh = stsveh;
	}

}
