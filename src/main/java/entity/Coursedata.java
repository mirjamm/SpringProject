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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "coursedata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coursedata.findAll", query = "SELECT c FROM Coursedata c")
    , @NamedQuery(name = "Coursedata.findById", query = "SELECT c FROM Coursedata c WHERE c.id = :id")
    , @NamedQuery(name = "Coursedata.findByPractice", query = "SELECT c FROM Coursedata c WHERE c.practice = :practice")
    , @NamedQuery(name = "Coursedata.findByLecture", query = "SELECT c FROM Coursedata c WHERE c.lecture = :lecture")
    , @NamedQuery(name = "Coursedata.findByExcercise", query = "SELECT c FROM Coursedata c WHERE c.excercise = :excercise")
    , @NamedQuery(name = "Coursedata.findByLecturesperweek", query = "SELECT c FROM Coursedata c WHERE c.lecturesperweek = :lecturesperweek")
    , @NamedQuery(name = "Coursedata.findBySemester", query = "SELECT c FROM Coursedata c WHERE c.semester = :semester")})
public class Coursedata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "practice")
    private Integer practice;
    @Column(name = "lecture")
    private Integer lecture;
    @Column(name = "excercise")
    private Integer excercise;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "lecturesperweek")
    private Double lecturesperweek;
    @Size(max = 5)
    @Column(name = "semester")
    private String semester;
    @JoinColumn(name = "courseid", referencedColumnName = "id")
    @ManyToOne
    private Course courseid;
    @JoinColumn(name = "languageid", referencedColumnName = "id")
    @ManyToOne
    private Language languageid;
    @JoinColumn(name = "teacherid", referencedColumnName = "id")
    @ManyToOne
    private Person teacherid;
    @OneToMany(mappedBy = "goursedataid")
    private Collection<Groupcoursedata> groupcoursedataCollection;

    public Coursedata() {
    }

    public Coursedata(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPractice() {
        return practice;
    }

    public void setPractice(Integer practice) {
        this.practice = practice;
    }

    public Integer getLecture() {
        return lecture;
    }

    public void setLecture(Integer lecture) {
        this.lecture = lecture;
    }

    public Integer getExcercise() {
        return excercise;
    }

    public void setExcercise(Integer excercise) {
        this.excercise = excercise;
    }

    public Double getLecturesperweek() {
        return lecturesperweek;
    }

    public void setLecturesperweek(Double lecturesperweek) {
        this.lecturesperweek = lecturesperweek;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Course getCourseid() {
        return courseid;
    }

    public void setCourseid(Course courseid) {
        this.courseid = courseid;
    }

    public Language getLanguageid() {
        return languageid;
    }

    public void setLanguageid(Language languageid) {
        this.languageid = languageid;
    }

    public Person getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Person teacherid) {
        this.teacherid = teacherid;
    }

    @XmlTransient
    public Collection<Groupcoursedata> getGroupcoursedataCollection() {
        return groupcoursedataCollection;
    }

    public void setGroupcoursedataCollection(Collection<Groupcoursedata> groupcoursedataCollection) {
        this.groupcoursedataCollection = groupcoursedataCollection;
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
        if (!(object instanceof Coursedata)) {
            return false;
        }
        Coursedata other = (Coursedata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.attendanceapp.entities.Coursedata[ id=" + id + " ]";
    }
    
}
