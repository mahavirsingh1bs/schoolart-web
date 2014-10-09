/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.bean;

import com.bhageshri.schoolart.util.Operand;

/**
 *
 * @author mahavir.singh
 */
public class ChapterCriteria {
    private int chapter;
    private Operand operand;
    private ChapterCriteria next;

    private ChapterCriteria() { }
    
    private ChapterCriteria(int chapter) {
        this.chapter = chapter;
    }
    
    private ChapterCriteria(int chapter, Operand operand) {
        this.chapter = chapter;
        this.operand = operand;
    }
    
    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public Operand getOperand() {
        return operand;
    }

    public void setOperand(Operand operand) {
        this.operand = operand;
    }

    public ChapterCriteria getNext() {
        return next;
    }

    public ChapterCriteria setNext(ChapterCriteria next) {
        this.next = next;
        return this;
    }

    public static ChapterCriteria instance(int chapter) {
        return new ChapterCriteria(chapter);
    }
    
    public static ChapterCriteria instance(int chapter, Operand operand) {
        return new ChapterCriteria(chapter, operand);
    }
    
    @Override
    public String toString() {
        return "ChapterCriteria{" + "chapter=" + chapter + ", operand=" + operand + ", next=" + next + '}';
    }
}
