/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.service;

import com.bhageshri.schoolart.bean.ChapterCriteria;
import com.bhageshri.schoolart.bean.QuestionsCriteria;
import com.bhageshri.schoolart.bean.SectionCriteria;
import com.bhageshri.schoolart.dao.QuestionDAO;
import com.bhageshri.schoolart.domain.Question;
import com.bhageshri.schoolart.domain.School;
import com.bhageshri.schoolart.service.impl.ExamServiceImpl;
import com.bhageshri.schoolart.util.Operand;
import com.bhageshri.schoolart.util.QuestionType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static com.bhageshri.schoolart.util.QuestionType.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mahavir Singh
 */
public class ExamServiceTest {
    
    private QuestionDAO questionDAO;
    private ExamServiceImpl examService;
    
    public ExamServiceTest() {
        
    }
    
    @Before
    public void setUp() {
        questionDAO = mock(QuestionDAO.class);
    }
    
    @After
    public void tearDown() {
        
    }
    
    @Test
    public void testCreateExam() {
        Long classId = 1l;
        Long subjectId = 6l;
        List<Question> shortQuestions = prepareQuestions(SHORT);
        List<Question> fillBlankQuestions = prepareQuestions(FILL_IN_THE_BLANK);
        List<Question> matchQuestions = prepareQuestions(MATCH);
        QuestionsCriteria criteria = prepareCriteria();
        when(questionDAO.findQuestionByTypeAndSubject(classId, subjectId, SHORT, criteria.getChapterCriteria())).thenReturn(shortQuestions);
        when(questionDAO.findQuestionByTypeAndSubject(classId, subjectId, FILL_IN_THE_BLANK, criteria.getChapterCriteria())).thenReturn(fillBlankQuestions);
        when(questionDAO.findQuestionByTypeAndSubject(classId, subjectId, MATCH, criteria.getChapterCriteria())).thenReturn(matchQuestions);
        examService = new ExamServiceImpl();
        examService.setQuestionDAO(questionDAO);
        
        Map<QuestionType, List<Question>> examPaper = examService.createExam(criteria);
        assertEquals(examPaper.get(SHORT).size(), 4);
        assertEquals(examPaper.get(FILL_IN_THE_BLANK).get(0).getQuestion(), "Fill in the blank question 1");
    }

    private List<Question> prepareQuestions(QuestionType type) {
        List<Question> questions = new ArrayList<>();
        School school = new School("New Green Lawns", "UGC");
        if (type == SHORT) {
            questions.add(new Question(type, "Short Question 1", "Short Answer 1", school));
            questions.add(new Question(type, "Short Question 2", "Short Answer 2", school));
            questions.add(new Question(type, "Short Question 3", "Short Answer 3", school));
            questions.add(new Question(type, "Short Question 4", "Short Answer 4", school));
        } else if (type == FILL_IN_THE_BLANK) {
            questions.add(new Question(type, "Fill in the blank question 1", "Fill Answer 1", school));
            questions.add(new Question(type, "Fill in the blank question 2", "Fill Answer 2", school));
            questions.add(new Question(type, "Fill in the blank question 3", "Fill Answer 3", school));
            questions.add(new Question(type, "Fill in the blank question 4", "Fill Answer 4", school));
        } else {
            questions.add(new Question(type, "Match question 1", "Match Answer 1", school));
            questions.add(new Question(type, "Match question 2", "Match Answer 2", school));
            questions.add(new Question(type, "Match question 3", "Match Answer 3", school));
            questions.add(new Question(type, "Match question 4", "Match Answer 4", school));
        }
        return questions;
    }

    private QuestionsCriteria prepareCriteria() {
        List<SectionCriteria> sections = new ArrayList<>();
        sections.add(new SectionCriteria(SHORT, 5, new BigDecimal("3")));
        sections.add(new SectionCriteria(FILL_IN_THE_BLANK, 5, new BigDecimal("2")));
        sections.add(new SectionCriteria(MATCH, 5, new BigDecimal("2")));
        
        ChapterCriteria chapterCriteria = ChapterCriteria.instance(1, Operand.TO);
        chapterCriteria.setNext(
                ChapterCriteria.instance(5, Operand.AND).setNext(
                    ChapterCriteria.instance(7, Operand.AND).setNext(
                        ChapterCriteria.instance(9))));
        
        QuestionsCriteria questions = new QuestionsCriteria();
        questions.setClassId(1l);
        questions.setSubjectId(6l);
        questions.setChapterCriteria(chapterCriteria);
        questions.setSections(sections);
        return questions;
    }
    
}