/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MobileAppServerSide;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 61402
 */
@Entity
@Table(name = "CREDENTIALSTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credentialstable.findAll", query = "SELECT c FROM Credentialstable c")
    , @NamedQuery(name = "Credentialstable.findByCredentialsid", query = "SELECT c FROM Credentialstable c WHERE c.credentialsid = :credentialsid")
    , @NamedQuery(name = "Credentialstable.findByUsername", query = "SELECT c FROM Credentialstable c WHERE c.username = :username")
    , @NamedQuery(name = "Credentialstable.findByPasswordhash", query = "SELECT c FROM Credentialstable c WHERE c.passwordhash = :passwordhash")
    , @NamedQuery(name = "Credentialstable.findBySignupdate", query = "SELECT c FROM Credentialstable c WHERE c.signupdate = :signupdate")})
public class Credentialstable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREDENTIALSID")
    private Integer credentialsid;
    @Size(max = 20)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 20)
    @Column(name = "PASSWORDHASH")
    private String passwordhash;
    @Column(name = "SIGNUPDATE")
    @Temporal(TemporalType.DATE)
    private Date signupdate;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private Usertable userid;

    public Credentialstable() {
    }

    public Credentialstable(Integer credentialsid) {
        this.credentialsid = credentialsid;
    }

    public Integer getCredentialsid() {
        return credentialsid;
    }

    public void setCredentialsid(Integer credentialsid) {
        this.credentialsid = credentialsid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public Date getSignupdate() {
        return signupdate;
    }

    public void setSignupdate(Date signupdate) {
        this.signupdate = signupdate;
    }

    public Usertable getUserid() {
        return userid;
    }

    public void setUserid(Usertable userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (credentialsid != null ? credentialsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credentialstable)) {
            return false;
        }
        Credentialstable other = (Credentialstable) object;
        if ((this.credentialsid == null && other.credentialsid != null) || (this.credentialsid != null && !this.credentialsid.equals(other.credentialsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MobileAppServerSide.Credentialstable[ credentialsid=" + credentialsid + " ]";
    }
    
}
