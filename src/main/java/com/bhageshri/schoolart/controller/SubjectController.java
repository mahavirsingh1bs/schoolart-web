/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.controller;

import com.bhageshri.schoolart.bean.SubjectBean;
import com.bhageshri.schoolart.dao.SubjectDAO;
import com.bhageshri.schoolart.domain.Subject;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mahavir.singh
 */
@RestController
public class SubjectController {
    /**
     * Initiate logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectController.class);
    
    @Inject
    private SubjectDAO subjectDAO;
    
    @RequestMapping(value = "/subjects/{id}")
    public List<SubjectBean> subjects(@PathVariable Long id) {
        List<SubjectBean> subjects = new ArrayList<>();   
        for (Subject subject : subjectDAO.findSubjectsByClass(id)) {
            subjects.add(new SubjectBean(subject.getId(), 
                    subject.getName()));
        }
        return subjects;
    }
}
