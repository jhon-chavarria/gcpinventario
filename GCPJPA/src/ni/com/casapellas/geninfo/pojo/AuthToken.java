/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.com.casapellas.geninfo.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Francisco Landeros
 */
@XmlRootElement
public class AuthToken {
    private String user;
    private String token;
    private String line;

    public AuthToken() {
    }

    public AuthToken(String user, String token) {
        this.user = user;
        this.token = token;
    }

    public AuthToken(String user, String token, String line) {
		super();
		this.user = user;
		this.token = token;
		this.line = line;
	}

	public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @XmlAttribute
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	@Override
	public String toString() {
		return "AuthToken [user=" + user + ", token=" + token + ", line="
				+ line + "]";
	}
	
	
}
