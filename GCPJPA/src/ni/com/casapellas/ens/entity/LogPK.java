package ni.com.casapellas.ens.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LOG database table.
 * 
 */
@Embeddable
public class LogPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String codlog;

	private long numlog;

	public LogPK() {
	}

	public String getCodlog() {
		return this.codlog;
	}

	public void setCodlog(String codlog) {
		this.codlog = codlog;
	}

	public long getNumlog() {
		return this.numlog;
	}

	public void setNumlog(long numlog) {
		this.numlog = numlog;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LogPK)) {
			return false;
		}
		LogPK castOther = (LogPK) other;
		return this.codlog.equals(castOther.codlog)
				&& (this.numlog == castOther.numlog);

	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codlog.hashCode();
		hash = hash * prime + ((int) (this.numlog ^ (this.numlog >>> 32)));

		return hash;
	}
}