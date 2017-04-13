/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "groupcoursedata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupcoursedata.findAll", query = "SELECT g FROM Groupcoursedata g")
    , @NamedQuery(name = "Groupcoursedata.findById", query = "SELECT g FROM Groupcoursedata g WHERE g.id = :id")})
public class Groupcoursedata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "goursedataid", referencedColumnName = "id")
    @ManyToOne
    private Coursedata goursedataid;
    @JoinColumn(name = "groupid", referencedColumnName = "id")
    @ManyToOne
    private Group1 groupid;
    @OneToMany(mappedBy = "groupcoursedataid")
    private Collection<Attendance> attendanceCollection;

    public Groupcoursedata() {
    }

    public Groupcoursedata(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Coursedata getGoursedataid() {
        return goursedataid;
    }

    public void setGoursedataid(Coursedata goursedataid) {
        this.goursedataid = goursedataid;
    }

    public Group1 getGroupid() {
        return groupid;
    }

    public void setGroupid(Group1 groupid) {
        this.groupid = groupid;
    }

    @XmlTransient
    public Collection<Attendance> getAttendanceCollection() {
        return attendanceCollection;
    }

    public void setAttendanceCollection(Collection<Attendance> attendanceCollection) {
        this.attendanceCollection = attendanceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupcoursedata)) {
            return false;
        }
        Groupcoursedata other = (Groupcoursedata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.attendanceapp.entities.Groupcoursedata[ id=" + id + " ]";
    }
    
}
