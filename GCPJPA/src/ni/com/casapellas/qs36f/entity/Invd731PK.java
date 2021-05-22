package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the INVD731 database table.
 * 
 */

@Embeddable
public class Invd731PK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String egrupo01;

	private String egrupo02;

	private String egrupo04;

	private String egrupo05;

	private String egrupo06;

	private String egrupo07;

	private BigDecimal esanno;

	private BigDecimal escantidc;

	private BigDecimal escantidcd;

	private BigDecimal escantidu;

	private BigDecimal escantidud;

	private String escompan;

	private BigDecimal escosto;

	private String esdepart;

	private BigDecimal esdescuent;

	private BigDecimal esdevoluci;

	private String esmodalida;

	private String essucurs;

	private BigDecimal estasa;

	private BigDecimal esvendedor;

	private BigDecimal esventab;

	public Invd731PK() {
	}

	public String getEgrupo01() {
		return this.egrupo01;
	}

	public void setEgrupo01(String egrupo01) {
		this.egrupo01 = egrupo01;
	}

	public String getEgrupo02() {
		return this.egrupo02;
	}

	public void setEgrupo02(String egrupo02) {
		this.egrupo02 = egrupo02;
	}

	public String getEgrupo04() {
		return this.egrupo04;
	}

	public void setEgrupo04(String egrupo04) {
		this.egrupo04 = egrupo04;
	}

	public String getEgrupo05() {
		return this.egrupo05;
	}

	public void setEgrupo05(String egrupo05) {
		this.egrupo05 = egrupo05;
	}

	public String getEgrupo06() {
		return this.egrupo06;
	}

	public void setEgrupo06(String egrupo06) {
		this.egrupo06 = egrupo06;
	}

	public String getEgrupo07() {
		return this.egrupo07;
	}

	public void setEgrupo07(String egrupo07) {
		this.egrupo07 = egrupo07;
	}

	public BigDecimal getEsanno() {
		return this.esanno;
	}

	public void setEsanno(BigDecimal esanno) {
		this.esanno = esanno;
	}

	public BigDecimal getEscantidc() {
		return this.escantidc;
	}

	public void setEscantidc(BigDecimal escantidc) {
		this.escantidc = escantidc;
	}

	public BigDecimal getEscantidcd() {
		return this.escantidcd;
	}

	public void setEscantidcd(BigDecimal escantidcd) {
		this.escantidcd = escantidcd;
	}

	public BigDecimal getEscantidu() {
		return this.escantidu;
	}

	public void setEscantidu(BigDecimal escantidu) {
		this.escantidu = escantidu;
	}

	public BigDecimal getEscantidud() {
		return this.escantidud;
	}

	public void setEscantidud(BigDecimal escantidud) {
		this.escantidud = escantidud;
	}

	public String getEscompan() {
		return this.escompan;
	}

	public void setEscompan(String escompan) {
		this.escompan = escompan;
	}

	public BigDecimal getEscosto() {
		return this.escosto;
	}

	public void setEscosto(BigDecimal escosto) {
		this.escosto = escosto;
	}

	public String getEsdepart() {
		return this.esdepart;
	}

	public void setEsdepart(String esdepart) {
		this.esdepart = esdepart;
	}

	public BigDecimal getEsdescuent() {
		return this.esdescuent;
	}

	public void setEsdescuent(BigDecimal esdescuent) {
		this.esdescuent = esdescuent;
	}

	public BigDecimal getEsdevoluci() {
		return this.esdevoluci;
	}

	public void setEsdevoluci(BigDecimal esdevoluci) {
		this.esdevoluci = esdevoluci;
	}

	public String getEsmodalida() {
		return this.esmodalida;
	}

	public void setEsmodalida(String esmodalida) {
		this.esmodalida = esmodalida;
	}

	public String getEssucurs() {
		return this.essucurs;
	}

	public void setEssucurs(String essucurs) {
		this.essucurs = essucurs;
	}

	public BigDecimal getEstasa() {
		return this.estasa;
	}

	public void setEstasa(BigDecimal estasa) {
		this.estasa = estasa;
	}

	public BigDecimal getEsvendedor() {
		return this.esvendedor;
	}

	public void setEsvendedor(BigDecimal esvendedor) {
		this.esvendedor = esvendedor;
	}

	public BigDecimal getEsventab() {
		return this.esventab;
	}

	public void setEsventab(BigDecimal esventab) {
		this.esventab = esventab;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((egrupo01 == null) ? 0 : egrupo01.hashCode());
		result = prime * result
				+ ((egrupo02 == null) ? 0 : egrupo02.hashCode());
		result = prime * result
				+ ((egrupo04 == null) ? 0 : egrupo04.hashCode());
		result = prime * result
				+ ((egrupo05 == null) ? 0 : egrupo05.hashCode());
		result = prime * result
				+ ((egrupo06 == null) ? 0 : egrupo06.hashCode());
		result = prime * result
				+ ((egrupo07 == null) ? 0 : egrupo07.hashCode());
		result = prime * result + ((esanno == null) ? 0 : esanno.hashCode());
		result = prime * result
				+ ((escantidc == null) ? 0 : escantidc.hashCode());
		result = prime * result
				+ ((escantidcd == null) ? 0 : escantidcd.hashCode());
		result = prime * result
				+ ((escantidu == null) ? 0 : escantidu.hashCode());
		result = prime * result
				+ ((escantidud == null) ? 0 : escantidud.hashCode());
		result = prime * result
				+ ((escompan == null) ? 0 : escompan.hashCode());
		result = prime * result + ((escosto == null) ? 0 : escosto.hashCode());
		result = prime * result
				+ ((esdepart == null) ? 0 : esdepart.hashCode());
		result = prime * result
				+ ((esdescuent == null) ? 0 : esdescuent.hashCode());
		result = prime * result
				+ ((esdevoluci == null) ? 0 : esdevoluci.hashCode());
		result = prime * result
				+ ((esmodalida == null) ? 0 : esmodalida.hashCode());
		result = prime * result
				+ ((essucurs == null) ? 0 : essucurs.hashCode());
		result = prime * result + ((estasa == null) ? 0 : estasa.hashCode());
		result = prime * result
				+ ((esvendedor == null) ? 0 : esvendedor.hashCode());
		result = prime * result
				+ ((esventab == null) ? 0 : esventab.hashCode());
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
		Invd731PK other = (Invd731PK) obj;
		if (egrupo01 == null) {
			if (other.egrupo01 != null)
				return false;
		} else if (!egrupo01.equals(other.egrupo01))
			return false;
		if (egrupo02 == null) {
			if (other.egrupo02 != null)
				return false;
		} else if (!egrupo02.equals(other.egrupo02))
			return false;
		if (egrupo04 == null) {
			if (other.egrupo04 != null)
				return false;
		} else if (!egrupo04.equals(other.egrupo04))
			return false;
		if (egrupo05 == null) {
			if (other.egrupo05 != null)
				return false;
		} else if (!egrupo05.equals(other.egrupo05))
			return false;
		if (egrupo06 == null) {
			if (other.egrupo06 != null)
				return false;
		} else if (!egrupo06.equals(other.egrupo06))
			return false;
		if (egrupo07 == null) {
			if (other.egrupo07 != null)
				return false;
		} else if (!egrupo07.equals(other.egrupo07))
			return false;
		if (esanno == null) {
			if (other.esanno != null)
				return false;
		} else if (!esanno.equals(other.esanno))
			return false;
		if (escantidc == null) {
			if (other.escantidc != null)
				return false;
		} else if (!escantidc.equals(other.escantidc))
			return false;
		if (escantidcd == null) {
			if (other.escantidcd != null)
				return false;
		} else if (!escantidcd.equals(other.escantidcd))
			return false;
		if (escantidu == null) {
			if (other.escantidu != null)
				return false;
		} else if (!escantidu.equals(other.escantidu))
			return false;
		if (escantidud == null) {
			if (other.escantidud != null)
				return false;
		} else if (!escantidud.equals(other.escantidud))
			return false;
		if (escompan == null) {
			if (other.escompan != null)
				return false;
		} else if (!escompan.equals(other.escompan))
			return false;
		if (escosto == null) {
			if (other.escosto != null)
				return false;
		} else if (!escosto.equals(other.escosto))
			return false;
		if (esdepart == null) {
			if (other.esdepart != null)
				return false;
		} else if (!esdepart.equals(other.esdepart))
			return false;
		if (esdescuent == null) {
			if (other.esdescuent != null)
				return false;
		} else if (!esdescuent.equals(other.esdescuent))
			return false;
		if (esdevoluci == null) {
			if (other.esdevoluci != null)
				return false;
		} else if (!esdevoluci.equals(other.esdevoluci))
			return false;
		if (esmodalida == null) {
			if (other.esmodalida != null)
				return false;
		} else if (!esmodalida.equals(other.esmodalida))
			return false;
		if (essucurs == null) {
			if (other.essucurs != null)
				return false;
		} else if (!essucurs.equals(other.essucurs))
			return false;
		if (estasa == null) {
			if (other.estasa != null)
				return false;
		} else if (!estasa.equals(other.estasa))
			return false;
		if (esvendedor == null) {
			if (other.esvendedor != null)
				return false;
		} else if (!esvendedor.equals(other.esvendedor))
			return false;
		if (esventab == null) {
			if (other.esventab != null)
				return false;
		} else if (!esventab.equals(other.esventab))
			return false;
		return true;
	}

}