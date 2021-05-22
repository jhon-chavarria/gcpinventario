package ni.com.casapellas.qs36f.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class SotcitPK implements Serializable {
	private static final long serialVersionUID = 1L;

    @Temporal( TemporalType.DATE)
	private Date cfecem;

	private BigDecimal cfechc;

	private String chasis;

	private String chechc;

	private BigDecimal chorac;

	private Time chorem;

    @Temporal( TemporalType.DATE)
	private Date cifeen;

	private Time cihoen;

	private BigDecimal client;

	private String cmodki;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cfecem == null) ? 0 : cfecem.hashCode());
		result = prime * result + ((cfechc == null) ? 0 : cfechc.hashCode());
		result = prime * result + ((chasis == null) ? 0 : chasis.hashCode());
		result = prime * result + ((chechc == null) ? 0 : chechc.hashCode());
		result = prime * result + ((chorac == null) ? 0 : chorac.hashCode());
		result = prime * result + ((chorem == null) ? 0 : chorem.hashCode());
		result = prime * result + ((cifeen == null) ? 0 : cifeen.hashCode());
		result = prime * result + ((cihoen == null) ? 0 : cihoen.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((cmodki == null) ? 0 : cmodki.hashCode());
		result = prime * result + ((codase == null) ? 0 : codase.hashCode());
		result = prime * result + ((compan == null) ? 0 : compan.hashCode());
		result = prime * result + ((conduc == null) ? 0 : conduc.hashCode());
		result = prime * result + ((direcc == null) ? 0 : direcc.hashCode());
		result = prime * result + ((feccit == null) ? 0 : feccit.hashCode());
		result = prime * result + ((fecham == null) ? 0 : fecham.hashCode());
		result = prime * result + ((frepci == null) ? 0 : frepci.hashCode());
		result = prime * result + ((hechop == null) ? 0 : hechop.hashCode());
		result = prime * result + ((hecrep == null) ? 0 : hecrep.hashCode());
		result = prime * result + ((horaci == null) ? 0 : horaci.hashCode());
		result = prime * result + ((horam == null) ? 0 : horam.hashCode());
		result = prime * result + ((hrepci == null) ? 0 : hrepci.hashCode());
		result = prime * result + ((mano == null) ? 0 : mano.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((mofabr == null) ? 0 : mofabr.hashCode());
		result = prime * result + ((motico == null) ? 0 : motico.hashCode());
		result = prime * result + ((motiv == null) ? 0 : motiv.hashCode());
		result = prime * result + ((motivc == null) ? 0 : motivc.hashCode());
		result = prime * result + ((motor == null) ? 0 : motor.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((noorde == null) ? 0 : noorde.hashCode());
		result = prime * result + ((nopres == null) ? 0 : nopres.hashCode());
		result = prime * result + ((numcit == null) ? 0 : numcit.hashCode());
		result = prime * result + ((pantal == null) ? 0 : pantal.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((statu1 == null) ? 0 : statu1.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((sucurs == null) ? 0 : sucurs.hashCode());
		result = prime * result + ((telef == null) ? 0 : telef.hashCode());
		result = prime * result + ((tipcit == null) ? 0 : tipcit.hashCode());
		result = prime * result + ((tipma1 == null) ? 0 : tipma1.hashCode());
		result = prime * result + ((tipman == null) ? 0 : tipman.hashCode());
		result = prime * result + ((tipoca == null) ? 0 : tipoca.hashCode());
		result = prime * result + ((tipord == null) ? 0 : tipord.hashCode());
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
		SotcitPK other = (SotcitPK) obj;
		if (cfecem == null) {
			if (other.cfecem != null)
				return false;
		} else if (!cfecem.equals(other.cfecem))
			return false;
		if (cfechc == null) {
			if (other.cfechc != null)
				return false;
		} else if (!cfechc.equals(other.cfechc))
			return false;
		if (chasis == null) {
			if (other.chasis != null)
				return false;
		} else if (!chasis.equals(other.chasis))
			return false;
		if (chechc == null) {
			if (other.chechc != null)
				return false;
		} else if (!chechc.equals(other.chechc))
			return false;
		if (chorac == null) {
			if (other.chorac != null)
				return false;
		} else if (!chorac.equals(other.chorac))
			return false;
		if (chorem == null) {
			if (other.chorem != null)
				return false;
		} else if (!chorem.equals(other.chorem))
			return false;
		if (cifeen == null) {
			if (other.cifeen != null)
				return false;
		} else if (!cifeen.equals(other.cifeen))
			return false;
		if (cihoen == null) {
			if (other.cihoen != null)
				return false;
		} else if (!cihoen.equals(other.cihoen))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (cmodki == null) {
			if (other.cmodki != null)
				return false;
		} else if (!cmodki.equals(other.cmodki))
			return false;
		if (codase == null) {
			if (other.codase != null)
				return false;
		} else if (!codase.equals(other.codase))
			return false;
		if (compan == null) {
			if (other.compan != null)
				return false;
		} else if (!compan.equals(other.compan))
			return false;
		if (conduc == null) {
			if (other.conduc != null)
				return false;
		} else if (!conduc.equals(other.conduc))
			return false;
		if (direcc == null) {
			if (other.direcc != null)
				return false;
		} else if (!direcc.equals(other.direcc))
			return false;
		if (feccit == null) {
			if (other.feccit != null)
				return false;
		} else if (!feccit.equals(other.feccit))
			return false;
		if (fecham == null) {
			if (other.fecham != null)
				return false;
		} else if (!fecham.equals(other.fecham))
			return false;
		if (frepci == null) {
			if (other.frepci != null)
				return false;
		} else if (!frepci.equals(other.frepci))
			return false;
		if (hechop == null) {
			if (other.hechop != null)
				return false;
		} else if (!hechop.equals(other.hechop))
			return false;
		if (hecrep == null) {
			if (other.hecrep != null)
				return false;
		} else if (!hecrep.equals(other.hecrep))
			return false;
		if (horaci == null) {
			if (other.horaci != null)
				return false;
		} else if (!horaci.equals(other.horaci))
			return false;
		if (horam == null) {
			if (other.horam != null)
				return false;
		} else if (!horam.equals(other.horam))
			return false;
		if (hrepci == null) {
			if (other.hrepci != null)
				return false;
		} else if (!hrepci.equals(other.hrepci))
			return false;
		if (mano == null) {
			if (other.mano != null)
				return false;
		} else if (!mano.equals(other.mano))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (mofabr == null) {
			if (other.mofabr != null)
				return false;
		} else if (!mofabr.equals(other.mofabr))
			return false;
		if (motico == null) {
			if (other.motico != null)
				return false;
		} else if (!motico.equals(other.motico))
			return false;
		if (motiv == null) {
			if (other.motiv != null)
				return false;
		} else if (!motiv.equals(other.motiv))
			return false;
		if (motivc == null) {
			if (other.motivc != null)
				return false;
		} else if (!motivc.equals(other.motivc))
			return false;
		if (motor == null) {
			if (other.motor != null)
				return false;
		} else if (!motor.equals(other.motor))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (noorde == null) {
			if (other.noorde != null)
				return false;
		} else if (!noorde.equals(other.noorde))
			return false;
		if (nopres == null) {
			if (other.nopres != null)
				return false;
		} else if (!nopres.equals(other.nopres))
			return false;
		if (numcit == null) {
			if (other.numcit != null)
				return false;
		} else if (!numcit.equals(other.numcit))
			return false;
		if (pantal == null) {
			if (other.pantal != null)
				return false;
		} else if (!pantal.equals(other.pantal))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (statu1 == null) {
			if (other.statu1 != null)
				return false;
		} else if (!statu1.equals(other.statu1))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (sucurs == null) {
			if (other.sucurs != null)
				return false;
		} else if (!sucurs.equals(other.sucurs))
			return false;
		if (telef == null) {
			if (other.telef != null)
				return false;
		} else if (!telef.equals(other.telef))
			return false;
		if (tipcit == null) {
			if (other.tipcit != null)
				return false;
		} else if (!tipcit.equals(other.tipcit))
			return false;
		if (tipma1 == null) {
			if (other.tipma1 != null)
				return false;
		} else if (!tipma1.equals(other.tipma1))
			return false;
		if (tipman == null) {
			if (other.tipman != null)
				return false;
		} else if (!tipman.equals(other.tipman))
			return false;
		if (tipoca == null) {
			if (other.tipoca != null)
				return false;
		} else if (!tipoca.equals(other.tipoca))
			return false;
		if (tipord == null) {
			if (other.tipord != null)
				return false;
		} else if (!tipord.equals(other.tipord))
			return false;
		return true;
	}

	private String codase;

	private String compan;

	private String conduc;

	private String direcc;

	private BigDecimal feccit;

	private BigDecimal fecham;

	private BigDecimal frepci;

	private String hechop;

	private String hecrep;

	private BigDecimal horaci;

	private BigDecimal horam;

	private BigDecimal hrepci;

	private BigDecimal mano;

	private String marca;

	private String modelo;

	private String mofabr;

	private String motico;

	private String motiv;

	private String motivc;

	private String motor;

	private String nombre;

	private BigDecimal noorde;

	private BigDecimal nopres;

	private BigDecimal numcit;

	private String pantal;

	private String placa;

	private String statu1;

	private String status;

	private String sucurs;

	private BigDecimal telef;

	private String tipcit;

	private String tipma1;

	private String tipman;

	private String tipoca;

	private String tipord;

    public SotcitPK() {
    }

	public Date getCfecem() {
		return this.cfecem;
	}

	public void setCfecem(Date cfecem) {
		this.cfecem = cfecem;
	}

	public BigDecimal getCfechc() {
		return this.cfechc;
	}

	public void setCfechc(BigDecimal cfechc) {
		this.cfechc = cfechc;
	}

	public String getChasis() {
		return this.chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getChechc() {
		return this.chechc;
	}

	public void setChechc(String chechc) {
		this.chechc = chechc;
	}

	public BigDecimal getChorac() {
		return this.chorac;
	}

	public void setChorac(BigDecimal chorac) {
		this.chorac = chorac;
	}

	public Time getChorem() {
		return this.chorem;
	}

	public void setChorem(Time chorem) {
		this.chorem = chorem;
	}

	public Date getCifeen() {
		return this.cifeen;
	}

	public void setCifeen(Date cifeen) {
		this.cifeen = cifeen;
	}

	public Time getCihoen() {
		return this.cihoen;
	}

	public void setCihoen(Time cihoen) {
		this.cihoen = cihoen;
	}

	public BigDecimal getClient() {
		return this.client;
	}

	public void setClient(BigDecimal client) {
		this.client = client;
	}

	public String getCmodki() {
		return this.cmodki;
	}

	public void setCmodki(String cmodki) {
		this.cmodki = cmodki;
	}

	public String getCodase() {
		return this.codase;
	}

	public void setCodase(String codase) {
		this.codase = codase;
	}

	public String getCompan() {
		return this.compan;
	}

	public void setCompan(String compan) {
		this.compan = compan;
	}

	public String getConduc() {
		return this.conduc;
	}

	public void setConduc(String conduc) {
		this.conduc = conduc;
	}

	public String getDirecc() {
		return this.direcc;
	}

	public void setDirecc(String direcc) {
		this.direcc = direcc;
	}

	public BigDecimal getFeccit() {
		return this.feccit;
	}

	public void setFeccit(BigDecimal feccit) {
		this.feccit = feccit;
	}

	public BigDecimal getFecham() {
		return this.fecham;
	}

	public void setFecham(BigDecimal fecham) {
		this.fecham = fecham;
	}

	public BigDecimal getFrepci() {
		return this.frepci;
	}

	public void setFrepci(BigDecimal frepci) {
		this.frepci = frepci;
	}

	public String getHechop() {
		return this.hechop;
	}

	public void setHechop(String hechop) {
		this.hechop = hechop;
	}

	public String getHecrep() {
		return this.hecrep;
	}

	public void setHecrep(String hecrep) {
		this.hecrep = hecrep;
	}

	public BigDecimal getHoraci() {
		return this.horaci;
	}

	public void setHoraci(BigDecimal horaci) {
		this.horaci = horaci;
	}

	public BigDecimal getHoram() {
		return this.horam;
	}

	public void setHoram(BigDecimal horam) {
		this.horam = horam;
	}

	public BigDecimal getHrepci() {
		return this.hrepci;
	}

	public void setHrepci(BigDecimal hrepci) {
		this.hrepci = hrepci;
	}

	public BigDecimal getMano() {
		return this.mano;
	}

	public void setMano(BigDecimal mano) {
		this.mano = mano;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMofabr() {
		return this.mofabr;
	}

	public void setMofabr(String mofabr) {
		this.mofabr = mofabr;
	}

	public String getMotico() {
		return this.motico;
	}

	public void setMotico(String motico) {
		this.motico = motico;
	}

	public String getMotiv() {
		return this.motiv;
	}

	public void setMotiv(String motiv) {
		this.motiv = motiv;
	}

	public String getMotivc() {
		return this.motivc;
	}

	public void setMotivc(String motivc) {
		this.motivc = motivc;
	}

	public String getMotor() {
		return this.motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getNoorde() {
		return this.noorde;
	}

	public void setNoorde(BigDecimal noorde) {
		this.noorde = noorde;
	}

	public BigDecimal getNopres() {
		return this.nopres;
	}

	public void setNopres(BigDecimal nopres) {
		this.nopres = nopres;
	}

	public BigDecimal getNumcit() {
		return this.numcit;
	}

	public void setNumcit(BigDecimal numcit) {
		this.numcit = numcit;
	}

	public String getPantal() {
		return this.pantal;
	}

	public void setPantal(String pantal) {
		this.pantal = pantal;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getStatu1() {
		return this.statu1;
	}

	public void setStatu1(String statu1) {
		this.statu1 = statu1;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSucurs() {
		return this.sucurs;
	}

	public void setSucurs(String sucurs) {
		this.sucurs = sucurs;
	}

	public BigDecimal getTelef() {
		return this.telef;
	}

	public void setTelef(BigDecimal telef) {
		this.telef = telef;
	}

	public String getTipcit() {
		return this.tipcit;
	}

	public void setTipcit(String tipcit) {
		this.tipcit = tipcit;
	}

	public String getTipma1() {
		return this.tipma1;
	}

	public void setTipma1(String tipma1) {
		this.tipma1 = tipma1;
	}

	public String getTipman() {
		return this.tipman;
	}

	public void setTipman(String tipman) {
		this.tipman = tipman;
	}

	public String getTipoca() {
		return this.tipoca;
	}

	public void setTipoca(String tipoca) {
		this.tipoca = tipoca;
	}

	public String getTipord() {
		return this.tipord;
	}

	public void setTipord(String tipord) {
		this.tipord = tipord;
	}

}
