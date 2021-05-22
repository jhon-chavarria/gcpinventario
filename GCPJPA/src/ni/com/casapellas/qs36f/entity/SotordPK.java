package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class SotordPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal autano;

	private String autcha;

	private String autcol;

	private String autmar;

	private String autmot;

	private String autplc;

	private BigDecimal clclie;

	private String cncomp;

	private String cnsucu;

	private String mtcasi;

	private BigDecimal otacc1;

	private BigDecimal otacc2;

	private String otases;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autano == null) ? 0 : autano.hashCode());
		result = prime * result + ((autcha == null) ? 0 : autcha.hashCode());
		result = prime * result + ((autcol == null) ? 0 : autcol.hashCode());
		result = prime * result + ((autmar == null) ? 0 : autmar.hashCode());
		result = prime * result + ((autmot == null) ? 0 : autmot.hashCode());
		result = prime * result + ((autplc == null) ? 0 : autplc.hashCode());
		result = prime * result + ((clclie == null) ? 0 : clclie.hashCode());
		result = prime * result + ((cncomp == null) ? 0 : cncomp.hashCode());
		result = prime * result + ((cnsucu == null) ? 0 : cnsucu.hashCode());
		result = prime * result + ((mtcasi == null) ? 0 : mtcasi.hashCode());
		result = prime * result + ((otacc1 == null) ? 0 : otacc1.hashCode());
		result = prime * result + ((otacc2 == null) ? 0 : otacc2.hashCode());
		result = prime * result + ((otases == null) ? 0 : otases.hashCode());
		result = prime * result
				+ ((otasesor == null) ? 0 : otasesor.hashCode());
		result = prime * result + ((otcesp == null) ? 0 : otcesp.hashCode());
		result = prime * result + ((otcita == null) ? 0 : otcita.hashCode());
		result = prime * result + ((otco == null) ? 0 : otco.hashCode());
		result = prime * result + ((otcod2 == null) ? 0 : otcod2.hashCode());
		result = prime * result + ((otcod3 == null) ? 0 : otcod3.hashCode());
		result = prime * result + ((otcod4 == null) ? 0 : otcod4.hashCode());
		result = prime * result + ((otcod5 == null) ? 0 : otcod5.hashCode());
		result = prime * result + ((otcod6 == null) ? 0 : otcod6.hashCode());
		result = prime * result
				+ ((otcoment == null) ? 0 : otcoment.hashCode());
		result = prime * result + ((otdacc == null) ? 0 : otdacc.hashCode());
		result = prime * result + ((otdesm == null) ? 0 : otdesm.hashCode());
		result = prime * result + ((otdeso == null) ? 0 : otdeso.hashCode());
		result = prime * result + ((otdesr == null) ? 0 : otdesr.hashCode());
		result = prime * result + ((otdser == null) ? 0 : otdser.hashCode());
		result = prime * result + ((otdsmp == null) ? 0 : otdsmp.hashCode());
		result = prime * result
				+ ((otestado == null) ? 0 : otestado.hashCode());
		result = prime * result + ((otfec1 == null) ? 0 : otfec1.hashCode());
		result = prime * result + ((otfec2 == null) ? 0 : otfec2.hashCode());
		result = prime * result + ((otfec3 == null) ? 0 : otfec3.hashCode());
		result = prime * result + ((otfec4 == null) ? 0 : otfec4.hashCode());
		result = prime * result + ((otfecr == null) ? 0 : otfecr.hashCode());
		result = prime * result + ((otfee2 == null) ? 0 : otfee2.hashCode());
		result = prime * result + ((otfee3 == null) ? 0 : otfee3.hashCode());
		result = prime * result + ((otfee4 == null) ? 0 : otfee4.hashCode());
		result = prime * result + ((otfee5 == null) ? 0 : otfee5.hashCode());
		result = prime * result + ((otfee6 == null) ? 0 : otfee6.hashCode());
		result = prime * result + ((otfemo == null) ? 0 : otfemo.hashCode());
		result = prime * result + ((othech == null) ? 0 : othech.hashCode());
		result = prime * result + ((othocr == null) ? 0 : othocr.hashCode());
		result = prime * result + ((othoe2 == null) ? 0 : othoe2.hashCode());
		result = prime * result + ((othoe3 == null) ? 0 : othoe3.hashCode());
		result = prime * result + ((othoe4 == null) ? 0 : othoe4.hashCode());
		result = prime * result + ((othoe5 == null) ? 0 : othoe5.hashCode());
		result = prime * result + ((othoe6 == null) ? 0 : othoe6.hashCode());
		result = prime * result + ((othoen == null) ? 0 : othoen.hashCode());
		result = prime * result + ((othomo == null) ? 0 : othomo.hashCode());
		result = prime * result + ((othora == null) ? 0 : othora.hashCode());
		result = prime * result + ((othorm == null) ? 0 : othorm.hashCode());
		result = prime * result + ((otkm == null) ? 0 : otkm.hashCode());
		result = prime * result + ((otmat1 == null) ? 0 : otmat1.hashCode());
		result = prime * result + ((otmat2 == null) ? 0 : otmat2.hashCode());
		result = prime * result + ((otmob1 == null) ? 0 : otmob1.hashCode());
		result = prime * result + ((otmob2 == null) ? 0 : otmob2.hashCode());
		result = prime * result + ((otmop1 == null) ? 0 : otmop1.hashCode());
		result = prime * result + ((otmop2 == null) ? 0 : otmop2.hashCode());
		result = prime * result + ((otnume == null) ? 0 : otnume.hashCode());
		result = prime * result + ((otorel == null) ? 0 : otorel.hashCode());
		result = prime * result + ((ototg1 == null) ? 0 : ototg1.hashCode());
		result = prime * result + ((ototg2 == null) ? 0 : ototg2.hashCode());
		result = prime * result + ((otprac == null) ? 0 : otprac.hashCode());
		result = prime * result + ((otprcr == null) ? 0 : otprcr.hashCode());
		result = prime * result + ((otprmo == null) ? 0 : otprmo.hashCode());
		result = prime * result + ((otprog == null) ? 0 : otprog.hashCode());
		result = prime * result + ((otrep1 == null) ? 0 : otrep1.hashCode());
		result = prime * result + ((otrep2 == null) ? 0 : otrep2.hashCode());
		result = prime * result + ((otstt1 == null) ? 0 : otstt1.hashCode());
		result = prime * result + ((otstt2 == null) ? 0 : otstt2.hashCode());
		result = prime * result + ((otstt3 == null) ? 0 : otstt3.hashCode());
		result = prime * result + ((otstt4 == null) ? 0 : otstt4.hashCode());
		result = prime * result + ((ottclt == null) ? 0 : ottclt.hashCode());
		result = prime * result + ((ottipo == null) ? 0 : ottipo.hashCode());
		result = prime * result + ((ottma == null) ? 0 : ottma.hashCode());
		result = prime * result + ((ottmm == null) ? 0 : ottmm.hashCode());
		result = prime * result + ((otuscr == null) ? 0 : otuscr.hashCode());
		result = prime * result + ((otuser == null) ? 0 : otuser.hashCode());
		result = prime * result + ((otusmo == null) ? 0 : otusmo.hashCode());
		result = prime * result + ((otvend == null) ? 0 : otvend.hashCode());
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
		SotordPK other = (SotordPK) obj;
		if (autano == null) {
			if (other.autano != null)
				return false;
		} else if (!autano.equals(other.autano))
			return false;
		if (autcha == null) {
			if (other.autcha != null)
				return false;
		} else if (!autcha.equals(other.autcha))
			return false;
		if (autcol == null) {
			if (other.autcol != null)
				return false;
		} else if (!autcol.equals(other.autcol))
			return false;
		if (autmar == null) {
			if (other.autmar != null)
				return false;
		} else if (!autmar.equals(other.autmar))
			return false;
		if (autmot == null) {
			if (other.autmot != null)
				return false;
		} else if (!autmot.equals(other.autmot))
			return false;
		if (autplc == null) {
			if (other.autplc != null)
				return false;
		} else if (!autplc.equals(other.autplc))
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
		if (mtcasi == null) {
			if (other.mtcasi != null)
				return false;
		} else if (!mtcasi.equals(other.mtcasi))
			return false;
		if (otacc1 == null) {
			if (other.otacc1 != null)
				return false;
		} else if (!otacc1.equals(other.otacc1))
			return false;
		if (otacc2 == null) {
			if (other.otacc2 != null)
				return false;
		} else if (!otacc2.equals(other.otacc2))
			return false;
		if (otases == null) {
			if (other.otases != null)
				return false;
		} else if (!otases.equals(other.otases))
			return false;
		if (otasesor == null) {
			if (other.otasesor != null)
				return false;
		} else if (!otasesor.equals(other.otasesor))
			return false;
		if (otcesp == null) {
			if (other.otcesp != null)
				return false;
		} else if (!otcesp.equals(other.otcesp))
			return false;
		if (otcita == null) {
			if (other.otcita != null)
				return false;
		} else if (!otcita.equals(other.otcita))
			return false;
		if (otco == null) {
			if (other.otco != null)
				return false;
		} else if (!otco.equals(other.otco))
			return false;
		if (otcod2 == null) {
			if (other.otcod2 != null)
				return false;
		} else if (!otcod2.equals(other.otcod2))
			return false;
		if (otcod3 == null) {
			if (other.otcod3 != null)
				return false;
		} else if (!otcod3.equals(other.otcod3))
			return false;
		if (otcod4 == null) {
			if (other.otcod4 != null)
				return false;
		} else if (!otcod4.equals(other.otcod4))
			return false;
		if (otcod5 == null) {
			if (other.otcod5 != null)
				return false;
		} else if (!otcod5.equals(other.otcod5))
			return false;
		if (otcod6 == null) {
			if (other.otcod6 != null)
				return false;
		} else if (!otcod6.equals(other.otcod6))
			return false;
		if (otcoment == null) {
			if (other.otcoment != null)
				return false;
		} else if (!otcoment.equals(other.otcoment))
			return false;
		if (otdacc == null) {
			if (other.otdacc != null)
				return false;
		} else if (!otdacc.equals(other.otdacc))
			return false;
		if (otdesm == null) {
			if (other.otdesm != null)
				return false;
		} else if (!otdesm.equals(other.otdesm))
			return false;
		if (otdeso == null) {
			if (other.otdeso != null)
				return false;
		} else if (!otdeso.equals(other.otdeso))
			return false;
		if (otdesr == null) {
			if (other.otdesr != null)
				return false;
		} else if (!otdesr.equals(other.otdesr))
			return false;
		if (otdser == null) {
			if (other.otdser != null)
				return false;
		} else if (!otdser.equals(other.otdser))
			return false;
		if (otdsmp == null) {
			if (other.otdsmp != null)
				return false;
		} else if (!otdsmp.equals(other.otdsmp))
			return false;
		if (otestado == null) {
			if (other.otestado != null)
				return false;
		} else if (!otestado.equals(other.otestado))
			return false;
		if (otfec1 == null) {
			if (other.otfec1 != null)
				return false;
		} else if (!otfec1.equals(other.otfec1))
			return false;
		if (otfec2 == null) {
			if (other.otfec2 != null)
				return false;
		} else if (!otfec2.equals(other.otfec2))
			return false;
		if (otfec3 == null) {
			if (other.otfec3 != null)
				return false;
		} else if (!otfec3.equals(other.otfec3))
			return false;
		if (otfec4 == null) {
			if (other.otfec4 != null)
				return false;
		} else if (!otfec4.equals(other.otfec4))
			return false;
		if (otfecr == null) {
			if (other.otfecr != null)
				return false;
		} else if (!otfecr.equals(other.otfecr))
			return false;
		if (otfee2 == null) {
			if (other.otfee2 != null)
				return false;
		} else if (!otfee2.equals(other.otfee2))
			return false;
		if (otfee3 == null) {
			if (other.otfee3 != null)
				return false;
		} else if (!otfee3.equals(other.otfee3))
			return false;
		if (otfee4 == null) {
			if (other.otfee4 != null)
				return false;
		} else if (!otfee4.equals(other.otfee4))
			return false;
		if (otfee5 == null) {
			if (other.otfee5 != null)
				return false;
		} else if (!otfee5.equals(other.otfee5))
			return false;
		if (otfee6 == null) {
			if (other.otfee6 != null)
				return false;
		} else if (!otfee6.equals(other.otfee6))
			return false;
		if (otfemo == null) {
			if (other.otfemo != null)
				return false;
		} else if (!otfemo.equals(other.otfemo))
			return false;
		if (othech == null) {
			if (other.othech != null)
				return false;
		} else if (!othech.equals(other.othech))
			return false;
		if (othocr == null) {
			if (other.othocr != null)
				return false;
		} else if (!othocr.equals(other.othocr))
			return false;
		if (othoe2 == null) {
			if (other.othoe2 != null)
				return false;
		} else if (!othoe2.equals(other.othoe2))
			return false;
		if (othoe3 == null) {
			if (other.othoe3 != null)
				return false;
		} else if (!othoe3.equals(other.othoe3))
			return false;
		if (othoe4 == null) {
			if (other.othoe4 != null)
				return false;
		} else if (!othoe4.equals(other.othoe4))
			return false;
		if (othoe5 == null) {
			if (other.othoe5 != null)
				return false;
		} else if (!othoe5.equals(other.othoe5))
			return false;
		if (othoe6 == null) {
			if (other.othoe6 != null)
				return false;
		} else if (!othoe6.equals(other.othoe6))
			return false;
		if (othoen == null) {
			if (other.othoen != null)
				return false;
		} else if (!othoen.equals(other.othoen))
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
		if (othorm == null) {
			if (other.othorm != null)
				return false;
		} else if (!othorm.equals(other.othorm))
			return false;
		if (otkm == null) {
			if (other.otkm != null)
				return false;
		} else if (!otkm.equals(other.otkm))
			return false;
		if (otmat1 == null) {
			if (other.otmat1 != null)
				return false;
		} else if (!otmat1.equals(other.otmat1))
			return false;
		if (otmat2 == null) {
			if (other.otmat2 != null)
				return false;
		} else if (!otmat2.equals(other.otmat2))
			return false;
		if (otmob1 == null) {
			if (other.otmob1 != null)
				return false;
		} else if (!otmob1.equals(other.otmob1))
			return false;
		if (otmob2 == null) {
			if (other.otmob2 != null)
				return false;
		} else if (!otmob2.equals(other.otmob2))
			return false;
		if (otmop1 == null) {
			if (other.otmop1 != null)
				return false;
		} else if (!otmop1.equals(other.otmop1))
			return false;
		if (otmop2 == null) {
			if (other.otmop2 != null)
				return false;
		} else if (!otmop2.equals(other.otmop2))
			return false;
		if (otnume == null) {
			if (other.otnume != null)
				return false;
		} else if (!otnume.equals(other.otnume))
			return false;
		if (otorel == null) {
			if (other.otorel != null)
				return false;
		} else if (!otorel.equals(other.otorel))
			return false;
		if (ototg1 == null) {
			if (other.ototg1 != null)
				return false;
		} else if (!ototg1.equals(other.ototg1))
			return false;
		if (ototg2 == null) {
			if (other.ototg2 != null)
				return false;
		} else if (!ototg2.equals(other.ototg2))
			return false;
		if (otprac == null) {
			if (other.otprac != null)
				return false;
		} else if (!otprac.equals(other.otprac))
			return false;
		if (otprcr == null) {
			if (other.otprcr != null)
				return false;
		} else if (!otprcr.equals(other.otprcr))
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
		if (otrep1 == null) {
			if (other.otrep1 != null)
				return false;
		} else if (!otrep1.equals(other.otrep1))
			return false;
		if (otrep2 == null) {
			if (other.otrep2 != null)
				return false;
		} else if (!otrep2.equals(other.otrep2))
			return false;
		if (otstt1 == null) {
			if (other.otstt1 != null)
				return false;
		} else if (!otstt1.equals(other.otstt1))
			return false;
		if (otstt2 == null) {
			if (other.otstt2 != null)
				return false;
		} else if (!otstt2.equals(other.otstt2))
			return false;
		if (otstt3 == null) {
			if (other.otstt3 != null)
				return false;
		} else if (!otstt3.equals(other.otstt3))
			return false;
		if (otstt4 == null) {
			if (other.otstt4 != null)
				return false;
		} else if (!otstt4.equals(other.otstt4))
			return false;
		if (ottclt == null) {
			if (other.ottclt != null)
				return false;
		} else if (!ottclt.equals(other.ottclt))
			return false;
		if (ottipo == null) {
			if (other.ottipo != null)
				return false;
		} else if (!ottipo.equals(other.ottipo))
			return false;
		if (ottma == null) {
			if (other.ottma != null)
				return false;
		} else if (!ottma.equals(other.ottma))
			return false;
		if (ottmm == null) {
			if (other.ottmm != null)
				return false;
		} else if (!ottmm.equals(other.ottmm))
			return false;
		if (otuscr == null) {
			if (other.otuscr != null)
				return false;
		} else if (!otuscr.equals(other.otuscr))
			return false;
		if (otuser == null) {
			if (other.otuser != null)
				return false;
		} else if (!otuser.equals(other.otuser))
			return false;
		if (otusmo == null) {
			if (other.otusmo != null)
				return false;
		} else if (!otusmo.equals(other.otusmo))
			return false;
		if (otvend == null) {
			if (other.otvend != null)
				return false;
		} else if (!otvend.equals(other.otvend))
			return false;
		return true;
	}

	private BigDecimal otasesor;

	private String otcesp;

	private BigDecimal otcita;

	private String otco;

	private BigDecimal otcod2;

	private BigDecimal otcod3;

	private BigDecimal otcod4;

	private BigDecimal otcod5;

	private BigDecimal otcod6;

	private String otcoment;

	private BigDecimal otdacc;

	private BigDecimal otdesm;

	private BigDecimal otdeso;

	private BigDecimal otdesr;

	private BigDecimal otdser;

	private BigDecimal otdsmp;

	private String otestado;

	private BigDecimal otfec1;

	private BigDecimal otfec2;

	private BigDecimal otfec3;

	private BigDecimal otfec4;

    @Temporal( TemporalType.DATE)
	private Date otfecr;

	private BigDecimal otfee2;

	private BigDecimal otfee3;

	private BigDecimal otfee4;

	private BigDecimal otfee5;

	private BigDecimal otfee6;

    @Temporal( TemporalType.DATE)
	private Date otfemo;

	private String othech;

	private Time othocr;

	private BigDecimal othoe2;

	private BigDecimal othoe3;

	private BigDecimal othoe4;

	private BigDecimal othoe5;

	private BigDecimal othoe6;

	private BigDecimal othoen;

	private Time othomo;

	private BigDecimal othora;

	private BigDecimal othorm;

	private BigDecimal otkm;

	private BigDecimal otmat1;

	private BigDecimal otmat2;

	private BigDecimal otmob1;

	private BigDecimal otmob2;

	private BigDecimal otmop1;

	private BigDecimal otmop2;

	private BigDecimal otnume;

	private BigDecimal otorel;

	private BigDecimal ototg1;

	private BigDecimal ototg2;

	private String otprac;

	private String otprcr;

	private String otprmo;

	private String otprog;

	private BigDecimal otrep1;

	private BigDecimal otrep2;

	private String otstt1;

	private String otstt2;

	private String otstt3;

	private String otstt4;

	private String ottclt;

	private String ottipo;

	private String ottma;

	private String ottmm;

	private String otuscr;

	private String otuser;

	private String otusmo;

	private BigDecimal otvend;

    public SotordPK() {
    }

	public BigDecimal getAutano() {
		return this.autano;
	}

	public void setAutano(BigDecimal autano) {
		this.autano = autano;
	}

	public String getAutcha() {
		return this.autcha;
	}

	public void setAutcha(String autcha) {
		this.autcha = autcha;
	}

	public String getAutcol() {
		return this.autcol;
	}

	public void setAutcol(String autcol) {
		this.autcol = autcol;
	}

	public String getAutmar() {
		return this.autmar;
	}

	public void setAutmar(String autmar) {
		this.autmar = autmar;
	}

	public String getAutmot() {
		return this.autmot;
	}

	public void setAutmot(String autmot) {
		this.autmot = autmot;
	}

	public String getAutplc() {
		return this.autplc;
	}

	public void setAutplc(String autplc) {
		this.autplc = autplc;
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

	public String getMtcasi() {
		return this.mtcasi;
	}

	public void setMtcasi(String mtcasi) {
		this.mtcasi = mtcasi;
	}

	public BigDecimal getOtacc1() {
		return this.otacc1;
	}

	public void setOtacc1(BigDecimal otacc1) {
		this.otacc1 = otacc1;
	}

	public BigDecimal getOtacc2() {
		return this.otacc2;
	}

	public void setOtacc2(BigDecimal otacc2) {
		this.otacc2 = otacc2;
	}

	public String getOtases() {
		return this.otases;
	}

	public void setOtases(String otases) {
		this.otases = otases;
	}

	public BigDecimal getOtasesor() {
		return this.otasesor;
	}

	public void setOtasesor(BigDecimal otasesor) {
		this.otasesor = otasesor;
	}

	public String getOtcesp() {
		return this.otcesp;
	}

	public void setOtcesp(String otcesp) {
		this.otcesp = otcesp;
	}

	public BigDecimal getOtcita() {
		return this.otcita;
	}

	public void setOtcita(BigDecimal otcita) {
		this.otcita = otcita;
	}

	public String getOtco() {
		return this.otco;
	}

	public void setOtco(String otco) {
		this.otco = otco;
	}

	public BigDecimal getOtcod2() {
		return this.otcod2;
	}

	public void setOtcod2(BigDecimal otcod2) {
		this.otcod2 = otcod2;
	}

	public BigDecimal getOtcod3() {
		return this.otcod3;
	}

	public void setOtcod3(BigDecimal otcod3) {
		this.otcod3 = otcod3;
	}

	public BigDecimal getOtcod4() {
		return this.otcod4;
	}

	public void setOtcod4(BigDecimal otcod4) {
		this.otcod4 = otcod4;
	}

	public BigDecimal getOtcod5() {
		return this.otcod5;
	}

	public void setOtcod5(BigDecimal otcod5) {
		this.otcod5 = otcod5;
	}

	public BigDecimal getOtcod6() {
		return this.otcod6;
	}

	public void setOtcod6(BigDecimal otcod6) {
		this.otcod6 = otcod6;
	}

	public String getOtcoment() {
		return this.otcoment;
	}

	public void setOtcoment(String otcoment) {
		this.otcoment = otcoment;
	}

	public BigDecimal getOtdacc() {
		return this.otdacc;
	}

	public void setOtdacc(BigDecimal otdacc) {
		this.otdacc = otdacc;
	}

	public BigDecimal getOtdesm() {
		return this.otdesm;
	}

	public void setOtdesm(BigDecimal otdesm) {
		this.otdesm = otdesm;
	}

	public BigDecimal getOtdeso() {
		return this.otdeso;
	}

	public void setOtdeso(BigDecimal otdeso) {
		this.otdeso = otdeso;
	}

	public BigDecimal getOtdesr() {
		return this.otdesr;
	}

	public void setOtdesr(BigDecimal otdesr) {
		this.otdesr = otdesr;
	}

	public BigDecimal getOtdser() {
		return this.otdser;
	}

	public void setOtdser(BigDecimal otdser) {
		this.otdser = otdser;
	}

	public BigDecimal getOtdsmp() {
		return this.otdsmp;
	}

	public void setOtdsmp(BigDecimal otdsmp) {
		this.otdsmp = otdsmp;
	}

	public String getOtestado() {
		return this.otestado;
	}

	public void setOtestado(String otestado) {
		this.otestado = otestado;
	}

	public BigDecimal getOtfec1() {
		return this.otfec1;
	}

	public void setOtfec1(BigDecimal otfec1) {
		this.otfec1 = otfec1;
	}

	public BigDecimal getOtfec2() {
		return this.otfec2;
	}

	public void setOtfec2(BigDecimal otfec2) {
		this.otfec2 = otfec2;
	}

	public BigDecimal getOtfec3() {
		return this.otfec3;
	}

	public void setOtfec3(BigDecimal otfec3) {
		this.otfec3 = otfec3;
	}

	public BigDecimal getOtfec4() {
		return this.otfec4;
	}

	public void setOtfec4(BigDecimal otfec4) {
		this.otfec4 = otfec4;
	}

	public Date getOtfecr() {
		return this.otfecr;
	}

	public void setOtfecr(Date otfecr) {
		this.otfecr = otfecr;
	}

	public BigDecimal getOtfee2() {
		return this.otfee2;
	}

	public void setOtfee2(BigDecimal otfee2) {
		this.otfee2 = otfee2;
	}

	public BigDecimal getOtfee3() {
		return this.otfee3;
	}

	public void setOtfee3(BigDecimal otfee3) {
		this.otfee3 = otfee3;
	}

	public BigDecimal getOtfee4() {
		return this.otfee4;
	}

	public void setOtfee4(BigDecimal otfee4) {
		this.otfee4 = otfee4;
	}

	public BigDecimal getOtfee5() {
		return this.otfee5;
	}

	public void setOtfee5(BigDecimal otfee5) {
		this.otfee5 = otfee5;
	}

	public BigDecimal getOtfee6() {
		return this.otfee6;
	}

	public void setOtfee6(BigDecimal otfee6) {
		this.otfee6 = otfee6;
	}

	public Date getOtfemo() {
		return this.otfemo;
	}

	public void setOtfemo(Date otfemo) {
		this.otfemo = otfemo;
	}

	public String getOthech() {
		return this.othech;
	}

	public void setOthech(String othech) {
		this.othech = othech;
	}

	public Time getOthocr() {
		return this.othocr;
	}

	public void setOthocr(Time othocr) {
		this.othocr = othocr;
	}

	public BigDecimal getOthoe2() {
		return this.othoe2;
	}

	public void setOthoe2(BigDecimal othoe2) {
		this.othoe2 = othoe2;
	}

	public BigDecimal getOthoe3() {
		return this.othoe3;
	}

	public void setOthoe3(BigDecimal othoe3) {
		this.othoe3 = othoe3;
	}

	public BigDecimal getOthoe4() {
		return this.othoe4;
	}

	public void setOthoe4(BigDecimal othoe4) {
		this.othoe4 = othoe4;
	}

	public BigDecimal getOthoe5() {
		return this.othoe5;
	}

	public void setOthoe5(BigDecimal othoe5) {
		this.othoe5 = othoe5;
	}

	public BigDecimal getOthoe6() {
		return this.othoe6;
	}

	public void setOthoe6(BigDecimal othoe6) {
		this.othoe6 = othoe6;
	}

	public BigDecimal getOthoen() {
		return this.othoen;
	}

	public void setOthoen(BigDecimal othoen) {
		this.othoen = othoen;
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

	public BigDecimal getOthorm() {
		return this.othorm;
	}

	public void setOthorm(BigDecimal othorm) {
		this.othorm = othorm;
	}

	public BigDecimal getOtkm() {
		return this.otkm;
	}

	public void setOtkm(BigDecimal otkm) {
		this.otkm = otkm;
	}

	public BigDecimal getOtmat1() {
		return this.otmat1;
	}

	public void setOtmat1(BigDecimal otmat1) {
		this.otmat1 = otmat1;
	}

	public BigDecimal getOtmat2() {
		return this.otmat2;
	}

	public void setOtmat2(BigDecimal otmat2) {
		this.otmat2 = otmat2;
	}

	public BigDecimal getOtmob1() {
		return this.otmob1;
	}

	public void setOtmob1(BigDecimal otmob1) {
		this.otmob1 = otmob1;
	}

	public BigDecimal getOtmob2() {
		return this.otmob2;
	}

	public void setOtmob2(BigDecimal otmob2) {
		this.otmob2 = otmob2;
	}

	public BigDecimal getOtmop1() {
		return this.otmop1;
	}

	public void setOtmop1(BigDecimal otmop1) {
		this.otmop1 = otmop1;
	}

	public BigDecimal getOtmop2() {
		return this.otmop2;
	}

	public void setOtmop2(BigDecimal otmop2) {
		this.otmop2 = otmop2;
	}

	public BigDecimal getOtnume() {
		return this.otnume;
	}

	public void setOtnume(BigDecimal otnume) {
		this.otnume = otnume;
	}

	public BigDecimal getOtorel() {
		return this.otorel;
	}

	public void setOtorel(BigDecimal otorel) {
		this.otorel = otorel;
	}

	public BigDecimal getOtotg1() {
		return this.ototg1;
	}

	public void setOtotg1(BigDecimal ototg1) {
		this.ototg1 = ototg1;
	}

	public BigDecimal getOtotg2() {
		return this.ototg2;
	}

	public void setOtotg2(BigDecimal ototg2) {
		this.ototg2 = ototg2;
	}

	public String getOtprac() {
		return this.otprac;
	}

	public void setOtprac(String otprac) {
		this.otprac = otprac;
	}

	public String getOtprcr() {
		return this.otprcr;
	}

	public void setOtprcr(String otprcr) {
		this.otprcr = otprcr;
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

	public BigDecimal getOtrep1() {
		return this.otrep1;
	}

	public void setOtrep1(BigDecimal otrep1) {
		this.otrep1 = otrep1;
	}

	public BigDecimal getOtrep2() {
		return this.otrep2;
	}

	public void setOtrep2(BigDecimal otrep2) {
		this.otrep2 = otrep2;
	}

	public String getOtstt1() {
		return this.otstt1;
	}

	public void setOtstt1(String otstt1) {
		this.otstt1 = otstt1;
	}

	public String getOtstt2() {
		return this.otstt2;
	}

	public void setOtstt2(String otstt2) {
		this.otstt2 = otstt2;
	}

	public String getOtstt3() {
		return this.otstt3;
	}

	public void setOtstt3(String otstt3) {
		this.otstt3 = otstt3;
	}

	public String getOtstt4() {
		return this.otstt4;
	}

	public void setOtstt4(String otstt4) {
		this.otstt4 = otstt4;
	}

	public String getOttclt() {
		return this.ottclt;
	}

	public void setOttclt(String ottclt) {
		this.ottclt = ottclt;
	}

	public String getOttipo() {
		return this.ottipo;
	}

	public void setOttipo(String ottipo) {
		this.ottipo = ottipo;
	}

	public String getOttma() {
		return this.ottma;
	}

	public void setOttma(String ottma) {
		this.ottma = ottma;
	}

	public String getOttmm() {
		return this.ottmm;
	}

	public void setOttmm(String ottmm) {
		this.ottmm = ottmm;
	}

	public String getOtuscr() {
		return this.otuscr;
	}

	public void setOtuscr(String otuscr) {
		this.otuscr = otuscr;
	}

	public String getOtuser() {
		return this.otuser;
	}

	public void setOtuser(String otuser) {
		this.otuser = otuser;
	}

	public String getOtusmo() {
		return this.otusmo;
	}

	public void setOtusmo(String otusmo) {
		this.otusmo = otusmo;
	}

	public BigDecimal getOtvend() {
		return this.otvend;
	}

	public void setOtvend(BigDecimal otvend) {
		this.otvend = otvend;
	}

}
