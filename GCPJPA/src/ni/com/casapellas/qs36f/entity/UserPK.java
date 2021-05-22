package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UserPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String usecia;

	private String usecls;

	private String usemnm;

	private String useopt;

	private String usepsw;

	private String usesta;

	private String useuid;

    public UserPK() {
    }

	public String getUsecia() {
		return this.usecia;
	}

	public void setUsecia(String usecia) {
		this.usecia = usecia;
	}

	public String getUsecls() {
		return this.usecls;
	}

	public void setUsecls(String usecls) {
		this.usecls = usecls;
	}

	public String getUsemnm() {
		return this.usemnm;
	}

	public void setUsemnm(String usemnm) {
		this.usemnm = usemnm;
	}

	public String getUseopt() {
		return this.useopt;
	}

	public void setUseopt(String useopt) {
		this.useopt = useopt;
	}

	public String getUsepsw() {
		return this.usepsw;
	}

	public void setUsepsw(String usepsw) {
		this.usepsw = usepsw;
	}

	public String getUsesta() {
		return this.usesta;
	}

	public void setUsesta(String usesta) {
		this.usesta = usesta;
	}

	public String getUseuid() {
		return this.useuid;
	}

	public void setUseuid(String useuid) {
		this.useuid = useuid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usecia == null) ? 0 : usecia.hashCode());
		result = prime * result + ((usecls == null) ? 0 : usecls.hashCode());
		result = prime * result + ((usemnm == null) ? 0 : usemnm.hashCode());
		result = prime * result + ((useopt == null) ? 0 : useopt.hashCode());
		result = prime * result + ((usepsw == null) ? 0 : usepsw.hashCode());
		result = prime * result + ((usesta == null) ? 0 : usesta.hashCode());
		result = prime * result + ((useuid == null) ? 0 : useuid.hashCode());
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
		UserPK other = (UserPK) obj;
		if (usecia == null) {
			if (other.usecia != null)
				return false;
		} else if (!usecia.equals(other.usecia))
			return false;
		if (usecls == null) {
			if (other.usecls != null)
				return false;
		} else if (!usecls.equals(other.usecls))
			return false;
		if (usemnm == null) {
			if (other.usemnm != null)
				return false;
		} else if (!usemnm.equals(other.usemnm))
			return false;
		if (useopt == null) {
			if (other.useopt != null)
				return false;
		} else if (!useopt.equals(other.useopt))
			return false;
		if (usepsw == null) {
			if (other.usepsw != null)
				return false;
		} else if (!usepsw.equals(other.usepsw))
			return false;
		if (usesta == null) {
			if (other.usesta != null)
				return false;
		} else if (!usesta.equals(other.usesta))
			return false;
		if (useuid == null) {
			if (other.useuid != null)
				return false;
		} else if (!useuid.equals(other.useuid))
			return false;
		return true;
	}

}
