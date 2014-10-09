/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

/**
 *
 * @author mahavir.singh
 */
@Entity
public class Chapter implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @TableGenerator(name = "chapterIdGenerator", 
            table = "ID_GENERATOR", 
            pkColumnName = "PK_NAME", 
            pkColumnValue = "CHAPTER_ID", 
            valueColumnName = "PK_VALUE")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "chapterIdGenerator")
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "SERIAL_NO")
    private Integer serialNo;
    
    @Column(name = "NAME")
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "FK_SUBJECT_ID")
    private Subject subject;
    
    @ManyToOne
    @JoinColumn(name = "SCHOOL_ID")
    private School school;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Chapter)) {
            return false;
        }
        Chapter other = (Chapter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bhageshri.schoolart.domain.Chapter[ id=" + id + " ]";
    }
    
}
