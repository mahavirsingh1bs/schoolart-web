/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.bean;

import com.bhageshri.schoolart.util.Operand;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mahavir.singh
 */
public class ChaptersTest {
    
    @Test
    public void testChapterTree() {
        ChapterCriteria chapters = ChapterCriteria.instance(1, Operand.TO);
        chapters.setNext(
                ChapterCriteria.instance(5, Operand.AND).setNext(
                    ChapterCriteria.instance(7, Operand.AND).setNext(
                        ChapterCriteria.instance(9))));

        ChapterCriteria temp = chapters;
        StringBuilder sb = new StringBuilder();
        while (temp.getOperand() != null) {
            sb.append(temp.getChapter());
            sb.append(" ");
            sb.append(temp.getOperand());
            sb.append(" ");
            temp = temp.getNext();
        }
        sb.append(temp.getChapter());
        System.out.println(sb.toString());
    }
}