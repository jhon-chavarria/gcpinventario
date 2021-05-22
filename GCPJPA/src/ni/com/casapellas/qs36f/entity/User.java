package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name = "USER")
@XmlRootElement
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private UserPK userPK;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public void setUserPK(UserPK userPK) {
		this.userPK = userPK;
	}

	public UserPK getUserPK() {
		return userPK;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userPK == null) ? 0 : userPK.hashCode());
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
		User other = (User) obj;
		if (userPK == null) {
			if (other.userPK != null)
				return false;
		} else if (!userPK.equals(other.userPK))
			return false;
		return true;
	}
}