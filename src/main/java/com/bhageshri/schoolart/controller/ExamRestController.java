/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.controller;

import com.bhageshri.schoolart.bean.ExamBean;
import com.bhageshri.schoolart.bean.QuestionBean;
import com.bhageshri.schoolart.bean.QuestionsCriteria;
import com.bhageshri.schoolart.dao.ExamDAO;
import com.bhageshri.schoolart.domain.Exam;
import com.bhageshri.schoolart.domain.Question;
import com.bhageshri.schoolart.exception.DAOException;
import com.bhageshri.schoolart.service.ExamService;
import com.bhageshri.schoolart.util.QuestionType;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mahavir.singh
 */
@RestController
public class ExamRestController {
    /**
    * Initiate logger
    */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExamRestController.class);
    
    @Inject
    private ExamService examService;
    
    @Inject
    private ExamDAO examDAO;
    
    /**
     * Creates an exam
     * @param ExamReg
     * @param modelMap
     * @param session
     * @return 
     */
    @RequestMapping(value = "/createExam", method = RequestMethod.POST)
    public String createExam(@RequestBody QuestionsCriteria questionsCrtieria) {
       Map<QuestionType, List<Question>> examPaper = examService.createExam(questionsCrtieria);
       System.out.println(examPaper.size());
       return "examCreated";
    }
    
    @RequestMapping(value = "/exams", method = RequestMethod.GET)
    public List<ExamBean> exams() {
        List<ExamBean> exams = new LinkedList<>();
        try {
            for (Exam exam : examDAO.findAll()) {
                exams.add(new ExamBean(exam.getId(), exam.getName()));
            }
        } catch (DAOException ex) {
            LOGGER.error("Error while getting exams" + ex.getMessage());
        }
        return exams;
    }
    
    @RequestMapping(value = "/exam/{examId}", method = RequestMethod.GET)
    public Map<QuestionType, List<QuestionBean>> exam(@PathVariable Long examId) {
        Map<QuestionType, List<QuestionBean>> questions = new HashMap<>();
        try {
            Exam exam = examDAO.find(examId);
            for (Question question : exam.getQuestions()) {
                if (questions.get(question.getQuestionType()) == null) {
                    QuestionBean questionBean = new QuestionBean(question.getId(), question.getQuestion(), question.getOptions(), question.getAnswer());
                    List<QuestionBean> questionBeans = new LinkedList<>();
                    questionBeans.add(questionBean);
                    questions.put(question.getQuestionType(), questionBeans);
                } else {
                    QuestionBean questionBean = new QuestionBean(question.getId(), question.getQuestion(), question.getOptions(), question.getAnswer());
                    questions.get(question.getQuestionType()).add(questionBean);
                }
            }
        } catch (DAOException ex) {
            LOGGER.error("Error while getting exam" + ex.getMessage());
        }
        return questions;
    }
}
