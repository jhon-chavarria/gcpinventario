package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SOTMPC database table.
 * 
 */
@Embeddable
public class SotmpcPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String compancto;

	private String sucurscto;

	private long numctto;

    public SotmpcPK() {
    }
	public String getCompancto() {
		return this.compancto;
	}
	public void setCompancto(String compancto) {
		this.compancto = compancto;
	}
	public String getSucurscto() {
		return this.sucurscto;
	}
	public void setSucurscto(String sucurscto) {
		this.sucurscto = sucurscto;
	}
	public long getNumctto() {
		return this.numctto;
	}
	public void setNumctto(long numctto) {
		this.numctto = numctto;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SotmpcPK)) {
			return false;
		}
		SotmpcPK castOther = (SotmpcPK)other;
		return 
			this.compancto.equals(castOther.compancto)
			&& this.sucurscto.equals(castOther.sucurscto)
			&& (this.numctto == castOther.numctto);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.compancto.hashCode();
		hash = hash * prime + this.sucurscto.hashCode();
		hash = hash * prime + ((int) (this.numctto ^ (this.numctto >>> 32)));
		
		return hash;
    }
}