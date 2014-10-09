/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.domain;

import com.bhageshri.schoolart.util.ExamStatus;
import com.bhageshri.schoolart.util.QuestionType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author Mahavir Singh
 */
@Entity
@Table(name = "EXAM")
public class Exam implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @TableGenerator(name = "examIdGenerator", 
            table = "ID_GENERATOR", 
            pkColumnName = "PK_NAME", 
            pkColumnValue = "EXAM_ID", 
            valueColumnName = "PK_VALUE")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "examIdGenerator")
    private Long id;

    @Column(name = "NAME")
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private ExamStatus status;
    
    @ManyToOne
    @JoinColumn(name = "FK_SUBJECT_ID")
    private Subject subject;
    
    @OneToOne
    @JoinColumn(name = "FK_TEACHER_ID")
    private Teacher createdBy;
    
    @ManyToMany
    @JoinTable(name = "EXAM_QUESTION",
            joinColumns = @JoinColumn(name = "FK_EXAM_ID"),
            inverseJoinColumns = @JoinColumn(name = "FK_QUESTION_ID"))
    private List<Question> questions = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "SCHOOL_ID")
    private School school;
    
    public Exam() { }
    
    public Exam(String name, Subject subject, List<Question> questions) {
        this.name = name;
        this.subject = subject;
        this.questions = questions;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExamStatus getStatus() {
        return status;
    }

    public void setStatus(ExamStatus status) {
        this.status = status;
    }

    public Teacher getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Teacher createdBy) {
        this.createdBy = createdBy;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
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
        if (!(object instanceof Exam)) {
            return false;
        }
        Exam other = (Exam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bhageshri.schoolart.domain.Exam[ id=" + id + " ]";
    }
    
}
