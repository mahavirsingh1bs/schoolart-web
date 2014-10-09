/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.dao;

import com.bhageshri.schoolart.bean.ChapterCriteria;
import com.bhageshri.schoolart.util.BeanResolverUtil;
import com.bhageshri.schoolart.util.Operand;
import com.bhageshri.schoolart.util.QuestionType;
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
public class QuestionDAOTest {
    
    private QuestionDAO questionDAO;
    
    public QuestionDAOTest() {
    }
    
    @Before
    public void setUp() {
        questionDAO = (QuestionDAO )BeanResolverUtil.getBean("questionDAO");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testFindQuestionByTypeAndSubject() {
        /**
        ChapterCriteria chapters = ChapterCriteria.instance(1, Operand.TO);
        chapters.setNext(
                ChapterCriteria.instance(5, Operand.AND).setNext(
                    ChapterCriteria.instance(7, Operand.AND).setNext(
                        ChapterCriteria.instance(9))));
        System.out.println(chapters);
        questionDAO.findQuestionByTypeAndSubject(QuestionType.SHORT, 2L, chapters);
        */
    }
}