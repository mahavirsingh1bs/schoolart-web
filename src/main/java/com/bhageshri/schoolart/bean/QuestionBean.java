/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.bean;

import java.util.Objects;

/**
 *
 * @author mahavir.singh
 */
public class QuestionBean {
    private Long id;
    private String question;
    private String options;
    private String answer;

    public QuestionBean() { }
    
    public QuestionBean(Long id, String question, String options, String answer) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.answer = answer;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.question);
        hash = 29 * hash + Objects.hashCode(this.options);
        hash = 29 * hash + Objects.hashCode(this.answer);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QuestionBean other = (QuestionBean) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (!Objects.equals(this.options, other.options)) {
            return false;
        }
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "QuestionBean{" + "id=" + id + ", question=" + question + ", options=" + options + ", answer=" + answer + '}';
    }
    
}
