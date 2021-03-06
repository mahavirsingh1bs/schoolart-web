/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.helper;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author mahavir.singh
 */
public class QuestionsCriteria implements Serializable {
    private long classId;
    private long subjectId;
    private ChapterCriteria chapterCriteria;
    private List<SectionCriteria> sections;

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public ChapterCriteria getChapterCriteria() {
        return chapterCriteria;
    }

    public void setChapterCriteria(ChapterCriteria chapterCriteria) {
        this.chapterCriteria = chapterCriteria;
    }

    public List<SectionCriteria> getSections() {
        return sections;
    }

    public void setSections(List<SectionCriteria> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "QuestionsCriteria{" + "classId=" + classId + ", subjectId=" + subjectId + ", chapterCriteria=" + chapterCriteria + ", sections=" + sections + '}';
    }
    
}
