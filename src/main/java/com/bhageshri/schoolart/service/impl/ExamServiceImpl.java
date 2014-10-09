/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.service.impl;

import com.bhageshri.schoolart.bean.QuestionsCriteria;
import com.bhageshri.schoolart.bean.SectionCriteria;
import com.bhageshri.schoolart.controller.ExamRestController;
import com.bhageshri.schoolart.dao.ExamDAO;
import com.bhageshri.schoolart.dao.QuestionDAO;
import com.bhageshri.schoolart.dao.SubjectDAO;
import com.bhageshri.schoolart.domain.Exam;
import com.bhageshri.schoolart.domain.Question;
import com.bhageshri.schoolart.domain.Subject;
import com.bhageshri.schoolart.exception.DAOException;
import com.bhageshri.schoolart.service.ExamService;
import com.bhageshri.schoolart.util.QuestionType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mahavir Singh
 */
@Service
public class ExamServiceImpl implements ExamService {
    /**
    * Initiate logger
    */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExamServiceImpl.class);
    
    @Autowired
    private QuestionDAO questionDAO;
    
    @Autowired
    private ExamDAO examDAO;

    @Autowired
    private SubjectDAO subjectDAO;
    
    public void setQuestionDAO(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Map<QuestionType, List<Question>> createExam(QuestionsCriteria criteria) {
        long classId = criteria.getClassId();
        long subjectId = criteria.getSubjectId();
        Map<QuestionType, List<Question>> examPaper = new HashMap<>();
        List<Question> examQuestions = new ArrayList<>();
        for (SectionCriteria sectionCriteria : criteria.getSections()) {
            QuestionType type = sectionCriteria.getType();
            List<Question> questions = questionDAO.findQuestionByTypeAndSubject(classId, subjectId, type, criteria.getChapterCriteria());
            examQuestions.addAll(questions);
            examPaper.put(sectionCriteria.getType(), questions);
        }
        try {
            Subject subject = subjectDAO.find(criteria.getSubjectId());
            examDAO.create(new Exam(criteria.getExamName(), subject, examQuestions));
        } catch(DAOException ex) {
            LOGGER.error("got error while creating exam : " + ex.getMessage());
        }
        return examPaper;
    }
    
}
