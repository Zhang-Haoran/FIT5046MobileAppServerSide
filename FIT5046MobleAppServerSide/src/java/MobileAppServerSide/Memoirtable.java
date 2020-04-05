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
@Table(name = "MEMOIRTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Memoirtable.findAll", query = "SELECT m FROM Memoirtable m")
    , @NamedQuery(name = "Memoirtable.findByMemoirid", query = "SELECT m FROM Memoirtable m WHERE m.memoirid = :memoirid")
    , @NamedQuery(name = "Memoirtable.findByMoviename", query = "SELECT m FROM Memoirtable m WHERE m.moviename = :moviename")
    , @NamedQuery(name = "Memoirtable.findByMoviereleasedate", query = "SELECT m FROM Memoirtable m WHERE m.moviereleasedate = :moviereleasedate")
    , @NamedQuery(name = "Memoirtable.findByWatchdate", query = "SELECT m FROM Memoirtable m WHERE m.watchdate = :watchdate")
    , @NamedQuery(name = "Memoirtable.findByWatchtime", query = "SELECT m FROM Memoirtable m WHERE m.watchtime = :watchtime")
    , @NamedQuery(name = "Memoirtable.findByComment", query = "SELECT m FROM Memoirtable m WHERE m.comment = :comment")
    , @NamedQuery(name = "Memoirtable.findByRatingscore", query = "SELECT m FROM Memoirtable m WHERE m.ratingscore = :ratingscore")})
public class Memoirtable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMOIRID")
    private Integer memoirid;
    @Size(max = 20)
    @Column(name = "MOVIENAME")
    private String moviename;
    @Column(name = "MOVIERELEASEDATE")
    @Temporal(TemporalType.DATE)
    private Date moviereleasedate;
    @Column(name = "WATCHDATE")
    @Temporal(TemporalType.DATE)
    private Date watchdate;
    @Column(name = "WATCHTIME")
    @Temporal(TemporalType.TIME)
    private Date watchtime;
    @Size(max = 200)
    @Column(name = "COMMENT")
    private String comment;
    @Column(name = "RATINGSCORE")
    private Integer ratingscore;
    @JoinColumn(name = "CINEMAID", referencedColumnName = "CINEMAID")
    @ManyToOne
    private Cinematable cinemaid;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private Usertable userid;

    public Memoirtable() {
    }

    public Memoirtable(Integer memoirid) {
        this.memoirid = memoirid;
    }

    public Integer getMemoirid() {
        return memoirid;
    }

    public void setMemoirid(Integer memoirid) {
        this.memoirid = memoirid;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public Date getMoviereleasedate() {
        return moviereleasedate;
    }

    public void setMoviereleasedate(Date moviereleasedate) {
        this.moviereleasedate = moviereleasedate;
    }

    public Date getWatchdate() {
        return watchdate;
    }

    public void setWatchdate(Date watchdate) {
        this.watchdate = watchdate;
    }

    public Date getWatchtime() {
        return watchtime;
    }

    public void setWatchtime(Date watchtime) {
        this.watchtime = watchtime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRatingscore() {
        return ratingscore;
    }

    public void setRatingscore(Integer ratingscore) {
        this.ratingscore = ratingscore;
    }

    public Cinematable getCinemaid() {
        return cinemaid;
    }

    public void setCinemaid(Cinematable cinemaid) {
        this.cinemaid = cinemaid;
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
        hash += (memoirid != null ? memoirid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Memoirtable)) {
            return false;
        }
        Memoirtable other = (Memoirtable) object;
        if ((this.memoirid == null && other.memoirid != null) || (this.memoirid != null && !this.memoirid.equals(other.memoirid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MobileAppServerSide.Memoirtable[ memoirid=" + memoirid + " ]";
    }
    
}
