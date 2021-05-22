/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.com.casapellas.ens.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Francisco Landeros
 */
@Entity
@Table(name = "APPSESSION", catalog = "SYSTEMIP", schema = "ENS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appsession.findAll", query = "SELECT a FROM Appsession a")})
public class Appsession implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "IDTOKEN")
    private String idtoken;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CODAPP")
    private String codapp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appsession")
    private Collection<Tokenxtrans> tokenxtransCollection;

    public Appsession() {
    }

    public Appsession(String idtoken) {
        this.idtoken = idtoken;
    }

    public Appsession(String idtoken, String usuario, String password, String codapp) {
        this.idtoken = idtoken;
        this.usuario = usuario;
        this.password = password;
        this.codapp = codapp;
    }

    public String getIdtoken() {
        return idtoken;
    }

    public void setIdtoken(String idtoken) {
        this.idtoken = idtoken;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCodapp() {
        return codapp;
    }

    public void setCodapp(String codapp) {
        this.codapp = codapp;
    }

    @XmlTransient
    public Collection<Tokenxtrans> getTokenxtransCollection() {
        return tokenxtransCollection;
    }

    public void setTokenxtransCollection(Collection<Tokenxtrans> tokenxtransCollection) {
        this.tokenxtransCollection = tokenxtransCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtoken != null ? idtoken.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appsession)) {
            return false;
        }
        Appsession other = (Appsession) object;
        if ((this.idtoken == null && other.idtoken != null) || (this.idtoken != null && !this.idtoken.equals(other.idtoken))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ni.com.casapellas.ens.entity.Appsession[ idtoken=" + idtoken + " ]";
    }
    
}
