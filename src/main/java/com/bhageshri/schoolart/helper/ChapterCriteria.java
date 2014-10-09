/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.helper;

import com.bhageshri.schoolart.util.Operand;
import java.io.Serializable;

/**
 *
 * @author mahavir.singh
 */
public class ChapterCriteria implements Serializable {
    private int chapter;
    private Operand operand;
    private ChapterCriteria next;

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

    public void setNext(ChapterCriteria next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ChapterCriteria{" + "chapter=" + chapter + ", operand=" + operand + ", next=" + next + '}';
    }

    
}
