/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.com.casapellas.ens.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Francisco Landeros
 */
@Entity
@Table(name = "TOKENXTRANS", catalog = "SYSTEMIP", schema = "ENS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tokenxtrans.findAll", query = "SELECT t FROM Tokenxtrans t")})
public class Tokenxtrans implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TokenxtransPK tokenxtransPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CODAPP")
    private String codapp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TRANSACTION")
    private String transaction;
    @JoinColumn(name = "IDTOKENAPP", referencedColumnName = "IDTOKEN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Appsession appsession;

    public Tokenxtrans() {
    }

    public Tokenxtrans(TokenxtransPK tokenxtransPK) {
        this.tokenxtransPK = tokenxtransPK;
    }

    public Tokenxtrans(TokenxtransPK tokenxtransPK, String codapp, String transaction) {
        this.tokenxtransPK = tokenxtransPK;
        this.codapp = codapp;
        this.transaction = transaction;
    }

    public Tokenxtrans(String idtokenapp, String tokentrans) {
        this.tokenxtransPK = new TokenxtransPK(idtokenapp, tokentrans);
    }

    public TokenxtransPK getTokenxtransPK() {
        return tokenxtransPK;
    }

    public void setTokenxtransPK(TokenxtransPK tokenxtransPK) {
        this.tokenxtransPK = tokenxtransPK;
    }

    public String getCodapp() {
        return codapp;
    }

    public void setCodapp(String codapp) {
        this.codapp = codapp;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public Appsession getAppsession() {
        return appsession;
    }

    public void setAppsession(Appsession appsession) {
        this.appsession = appsession;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tokenxtransPK != null ? tokenxtransPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tokenxtrans)) {
            return false;
        }
        Tokenxtrans other = (Tokenxtrans) object;
        if ((this.tokenxtransPK == null && other.tokenxtransPK != null) || (this.tokenxtransPK != null && !this.tokenxtransPK.equals(other.tokenxtransPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.com.casapellas.ens.entity.Tokenxtrans[ tokenxtransPK=" + tokenxtransPK + " ]";
    }
    
}
