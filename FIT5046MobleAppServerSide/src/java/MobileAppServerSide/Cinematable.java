/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MobileAppServerSide;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author 61402
 */
@Entity
@Table(name = "CINEMATABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cinematable.findAll", query = "SELECT c FROM Cinematable c")
    , @NamedQuery(name = "Cinematable.findByCinemaid", query = "SELECT c FROM Cinematable c WHERE c.cinemaid = :cinemaid")
    , @NamedQuery(name = "Cinematable.findByCinemaname", query = "SELECT c FROM Cinematable c WHERE c.cinemaname = :cinemaname")
    , @NamedQuery(name = "Cinematable.findBySuburb", query = "SELECT c FROM Cinematable c WHERE c.suburb = :suburb")
    , @NamedQuery(name = "Cinematable.findByPostcode", query = "SELECT c FROM Cinematable c WHERE c.postcode = :postcode")})
public class Cinematable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CINEMAID")
    private Integer cinemaid;
    @Size(max = 20)
    @Column(name = "CINEMANAME")
    private String cinemaname;
    @Size(max = 20)
    @Column(name = "SUBURB")
    private String suburb;
    @Size(max = 20)
    @Column(name = "POSTCODE")
    private String postcode;
    @OneToMany(mappedBy = "cinemaid")
    private Collection<Memoirtable> memoirtableCollection;

    public Cinematable() {
    }

    public Cinematable(Integer cinemaid) {
        this.cinemaid = cinemaid;
    }

    public Integer getCinemaid() {
        return cinemaid;
    }

    public void setCinemaid(Integer cinemaid) {
        this.cinemaid = cinemaid;
    }

    public String getCinemaname() {
        return cinemaname;
    }

    public void setCinemaname(String cinemaname) {
        this.cinemaname = cinemaname;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @XmlTransient
    public Collection<Memoirtable> getMemoirtableCollection() {
        return memoirtableCollection;
    }

    public void setMemoirtableCollection(Collection<Memoirtable> memoirtableCollection) {
        this.memoirtableCollection = memoirtableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cinemaid != null ? cinemaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cinematable)) {
            return false;
        }
        Cinematable other = (Cinematable) object;
        if ((this.cinemaid == null && other.cinemaid != null) || (this.cinemaid != null && !this.cinemaid.equals(other.cinemaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MobileAppServerSide.Cinematable[ cinemaid=" + cinemaid + " ]";
    }
    
}
