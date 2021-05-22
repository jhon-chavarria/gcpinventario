package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class SotrecoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String compan;

	private BigDecimal norden;

	private BigDecimal numlin;

    @Temporal( TemporalType.DATE)
	private Date rcfech;

	private String rchech;

	private Time rchora;

	private String rcpant;

	private String rcprog;

	private String recomen;

	private String sucurs;

    public SotrecoPK() {
    }

	public String getCompan() {
		return this.compan;
	}

	public void setCompan(String compan) {
		this.compan = compan;
	}

	public BigDecimal getNorden() {
		return this.norden;
	}

	public void setNorden(BigDecimal norden) {
		this.norden = norden;
	}

	public BigDecimal getNumlin() {
		return this.numlin;
	}

	public void setNumlin(BigDecimal numlin) {
		this.numlin = numlin;
	}

	public Date getRcfech() {
		return this.rcfech;
	}

	public void setRcfech(Date rcfech) {
		this.rcfech = rcfech;
	}

	public String getRchech() {
		return this.rchech;
	}

	public void setRchech(String rchech) {
		this.rchech = rchech;
	}

	public Time getRchora() {
		return this.rchora;
	}

	public void setRchora(Time rchora) {
		this.rchora = rchora;
	}

	public String getRcpant() {
		return this.rcpant;
	}

	public void setRcpant(String rcpant) {
		this.rcpant = rcpant;
	}

	public String getRcprog() {
		return this.rcprog;
	}

	public void setRcprog(String rcprog) {
		this.rcprog = rcprog;
	}

	public String getRecomen() {
		return this.recomen;
	}

	public void setRecomen(String recomen) {
		this.recomen = recomen;
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
		result = prime * result + ((norden == null) ? 0 : norden.hashCode());
		result = prime * result + ((numlin == null) ? 0 : numlin.hashCode());
		result = prime * result + ((rcfech == null) ? 0 : rcfech.hashCode());
		result = prime * result + ((rchech == null) ? 0 : rchech.hashCode());
		result = prime * result + ((rchora == null) ? 0 : rchora.hashCode());
		result = prime * result + ((rcpant == null) ? 0 : rcpant.hashCode());
		result = prime * result + ((rcprog == null) ? 0 : rcprog.hashCode());
		result = prime * result + ((recomen == null) ? 0 : recomen.hashCode());
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
		SotrecoPK other = (SotrecoPK) obj;
		if (compan == null) {
			if (other.compan != null)
				return false;
		} else if (!compan.equals(other.compan))
			return false;
		if (norden == null) {
			if (other.norden != null)
				return false;
		} else if (!norden.equals(other.norden))
			return false;
		if (numlin == null) {
			if (other.numlin != null)
				return false;
		} else if (!numlin.equals(other.numlin))
			return false;
		if (rcfech == null) {
			if (other.rcfech != null)
				return false;
		} else if (!rcfech.equals(other.rcfech))
			return false;
		if (rchech == null) {
			if (other.rchech != null)
				return false;
		} else if (!rchech.equals(other.rchech))
			return false;
		if (rchora == null) {
			if (other.rchora != null)
				return false;
		} else if (!rchora.equals(other.rchora))
			return false;
		if (rcpant == null) {
			if (other.rcpant != null)
				return false;
		} else if (!rcpant.equals(other.rcpant))
			return false;
		if (rcprog == null) {
			if (other.rcprog != null)
				return false;
		} else if (!rcprog.equals(other.rcprog))
			return false;
		if (recomen == null) {
			if (other.recomen != null)
				return false;
		} else if (!recomen.equals(other.recomen))
			return false;
		if (sucurs == null) {
			if (other.sucurs != null)
				return false;
		} else if (!sucurs.equals(other.sucurs))
			return false;
		return true;
	}

}
