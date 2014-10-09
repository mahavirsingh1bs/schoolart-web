/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.controller;

import com.bhageshri.schoolart.service.ExamService;
import javax.inject.Inject;
// import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author mahavir.singh
 */
@Controller
public class ExamController {
       /**
        * Initiate logger
        */
       private static final Logger LOGGER = LoggerFactory.getLogger(ExamController.class);
       
       private static final String SHOW_CREATE_EXAM = "exam";
       private static final String SHOW_TAKE_EXAM = "take_exam";
       
       @Inject
       private ExamService examService;
       
        /**
         * It opens up the create exam page.
         * @param modelMap
         * @return
         */
        @RequestMapping(value="/showCreateExam", method=RequestMethod.GET)
        public String showCreateExam(ModelMap modelMap){
            // modelMap.addAttribute("examReg", new ExamReg());			
            return SHOW_CREATE_EXAM;
        }
        
        @RequestMapping(value="/showTakeExam", method=RequestMethod.GET)
        public String showTakeExam() {
            return SHOW_TAKE_EXAM;
        }
        
}
