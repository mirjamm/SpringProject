/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "attendance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attendance.findAll", query = "SELECT a FROM Attendance a")
    , @NamedQuery(name = "Attendance.findById", query = "SELECT a FROM Attendance a WHERE a.id = :id")
    , @NamedQuery(name = "Attendance.findByDate", query = "SELECT a FROM Attendance a WHERE a.date = :date")
    , @NamedQuery(name = "Attendance.findByStatus", query = "SELECT a FROM Attendance a WHERE a.status = :status")
    , @NamedQuery(name = "Attendance.findByPairnumber", query = "SELECT a FROM Attendance a WHERE a.pairnumber = :pairnumber")})
public class Attendance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "date")
    private String date;
    @Size(max = 100)
    @Column(name = "status")
    private String status;
    @Size(max = 100)
    @Column(name = "pairnumber")
    private String pairnumber;
    @JoinColumn(name = "groupcoursedataid", referencedColumnName = "id")
    @ManyToOne
    private Groupcoursedata groupcoursedataid;
    @JoinColumn(name = "studentid", referencedColumnName = "id")
    @ManyToOne
    private Student studentid;
    @JoinColumn(name = "typeid", referencedColumnName = "id")
    @ManyToOne
    private Type typeid;

    public Attendance() {
    }

    public Attendance(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPairnumber() {
        return pairnumber;
    }

    public void setPairnumber(String pairnumber) {
        this.pairnumber = pairnumber;
    }

    public Groupcoursedata getGroupcoursedataid() {
        return groupcoursedataid;
    }

    public void setGroupcoursedataid(Groupcoursedata groupcoursedataid) {
        this.groupcoursedataid = groupcoursedataid;
    }

    public Student getStudentid() {
        return studentid;
    }

    public void setStudentid(Student studentid) {
        this.studentid = studentid;
    }

    public Type getTypeid() {
        return typeid;
    }

    public void setTypeid(Type typeid) {
        this.typeid = typeid;
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
        if (!(object instanceof Attendance)) {
            return false;
        }
        Attendance other = (Attendance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.attendanceapp.entities.Attendance[ id=" + id + " ]";
    }
    
}
