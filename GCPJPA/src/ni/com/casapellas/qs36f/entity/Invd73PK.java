package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Invd73PK implements Serializable {

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
	private BigDecimal esclclie;
	private String escompan;
	private BigDecimal escosto;
	private String esdepart;
	private BigDecimal esdescuent;
	private BigDecimal esdevoluci;
	private String esregion;
	private String esruta;
	private String essucurs;
	private BigDecimal estasa;
	private BigDecimal esventab;
	private String eszona;
	private BigDecimal esventabe;
	private BigDecimal esdevoluce;
	private BigDecimal esdescuene;

	public Invd73PK() {
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

	public BigDecimal getEsclclie() {
		return this.esclclie;
	}

	public void setEsclclie(BigDecimal esclclie) {
		this.esclclie = esclclie;
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

	public String getEsregion() {
		return this.esregion;
	}

	public void setEsregion(String esregion) {
		this.esregion = esregion;
	}

	public String getEsruta() {
		return this.esruta;
	}

	public void setEsruta(String esruta) {
		this.esruta = esruta;
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

	public BigDecimal getEsventab() {
		return this.esventab;
	}

	public void setEsventab(BigDecimal esventab) {
		this.esventab = esventab;
	}

	public String getEszona() {
		return this.eszona;
	}

	public void setEszona(String eszona) {
		this.eszona = eszona;
	}

	public BigDecimal getEsventabe() {
		return esventabe;
	}

	public void setEsventabe(BigDecimal esventabe) {
		this.esventabe = esventabe;
	}

	public BigDecimal getEsdevoluce() {
		return esdevoluce;
	}

	public void setEsdevoluce(BigDecimal esdevoluce) {
		this.esdevoluce = esdevoluce;
	}

	public BigDecimal getEsdescuene() {
		return esdescuene;
	}

	public void setEsdescuene(BigDecimal esdescuene) {
		this.esdescuene = esdescuene;
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
				+ ((esclclie == null) ? 0 : esclclie.hashCode());
		result = prime * result
				+ ((escompan == null) ? 0 : escompan.hashCode());
		result = prime * result + ((escosto == null) ? 0 : escosto.hashCode());
		result = prime * result
				+ ((esdepart == null) ? 0 : esdepart.hashCode());
		result = prime * result
				+ ((esdescuene == null) ? 0 : esdescuene.hashCode());
		result = prime * result
				+ ((esdescuent == null) ? 0 : esdescuent.hashCode());
		result = prime * result
				+ ((esdevoluce == null) ? 0 : esdevoluce.hashCode());
		result = prime * result
				+ ((esdevoluci == null) ? 0 : esdevoluci.hashCode());
		result = prime * result
				+ ((esregion == null) ? 0 : esregion.hashCode());
		result = prime * result + ((esruta == null) ? 0 : esruta.hashCode());
		result = prime * result
				+ ((essucurs == null) ? 0 : essucurs.hashCode());
		result = prime * result + ((estasa == null) ? 0 : estasa.hashCode());
		result = prime * result
				+ ((esventab == null) ? 0 : esventab.hashCode());
		result = prime * result
				+ ((esventabe == null) ? 0 : esventabe.hashCode());
		result = prime * result + ((eszona == null) ? 0 : eszona.hashCode());
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
		Invd73PK other = (Invd73PK) obj;
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
		if (esclclie == null) {
			if (other.esclclie != null)
				return false;
		} else if (!esclclie.equals(other.esclclie))
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
		if (esdescuene == null) {
			if (other.esdescuene != null)
				return false;
		} else if (!esdescuene.equals(other.esdescuene))
			return false;
		if (esdescuent == null) {
			if (other.esdescuent != null)
				return false;
		} else if (!esdescuent.equals(other.esdescuent))
			return false;
		if (esdevoluce == null) {
			if (other.esdevoluce != null)
				return false;
		} else if (!esdevoluce.equals(other.esdevoluce))
			return false;
		if (esdevoluci == null) {
			if (other.esdevoluci != null)
				return false;
		} else if (!esdevoluci.equals(other.esdevoluci))
			return false;
		if (esregion == null) {
			if (other.esregion != null)
				return false;
		} else if (!esregion.equals(other.esregion))
			return false;
		if (esruta == null) {
			if (other.esruta != null)
				return false;
		} else if (!esruta.equals(other.esruta))
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
		if (esventab == null) {
			if (other.esventab != null)
				return false;
		} else if (!esventab.equals(other.esventab))
			return false;
		if (esventabe == null) {
			if (other.esventabe != null)
				return false;
		} else if (!esventabe.equals(other.esventabe))
			return false;
		if (eszona == null) {
			if (other.eszona != null)
				return false;
		} else if (!eszona.equals(other.eszona))
			return false;
		return true;
	}
	
}
