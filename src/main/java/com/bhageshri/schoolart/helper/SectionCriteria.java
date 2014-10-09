/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.helper;

import com.bhageshri.schoolart.util.QuestionType;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author mahavir.singh
 */
public class SectionCriteria implements Serializable {
    private QuestionType type;
    private int noOfQuestions;
    private BigDecimal marksPerQuestion;

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public int getNoOfQuestions() {
        return noOfQuestions;
    }

    public void setNoOfQuestions(int noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }

    public BigDecimal getMarksPerQuestion() {
        return marksPerQuestion;
    }

    public void setMarksPerQuestion(BigDecimal marksPerQuestion) {
        this.marksPerQuestion = marksPerQuestion;
    }

    @Override
    public String toString() {
        return "SectionCriteria{" + "type=" + type + ", noOfQuestions=" + noOfQuestions + ", marksPerQuestion=" + marksPerQuestion + '}';
    }

}
