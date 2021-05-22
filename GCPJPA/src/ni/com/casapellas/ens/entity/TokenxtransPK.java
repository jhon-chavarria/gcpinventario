/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.com.casapellas.ens.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Francisco Landeros
 */
@Embeddable
public class TokenxtransPK implements Serializable {
 
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "IDTOKENAPP")
    private String idtokenapp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TOKENTRANS")
    private String tokentrans;

    public TokenxtransPK() {
    }

    public TokenxtransPK(String idtokenapp, String tokentrans) {
        this.idtokenapp = idtokenapp;
        this.tokentrans = tokentrans;
    }

    public String getIdtokenapp() {
        return idtokenapp;
    }

    public void setIdtokenapp(String idtokenapp) {
        this.idtokenapp = idtokenapp;
    }

    public String getTokentrans() {
        return tokentrans;
    }

    public void setTokentrans(String tokentrans) {
        this.tokentrans = tokentrans;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtokenapp != null ? idtokenapp.hashCode() : 0);
        hash += (tokentrans != null ? tokentrans.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TokenxtransPK)) {
            return false;
        }
        TokenxtransPK other = (TokenxtransPK) object;
        if ((this.idtokenapp == null && other.idtokenapp != null) || (this.idtokenapp != null && !this.idtokenapp.equals(other.idtokenapp))) {
            return false;
        }
        if ((this.tokentrans == null && other.tokentrans != null) || (this.tokentrans != null && !this.tokentrans.equals(other.tokentrans))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.com.casapellas.ens.entity.TokenxtransPK[ idtokenapp=" + idtokenapp + ", tokentrans=" + tokentrans + " ]";
    }
    
}
