/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.controller;

import com.bhageshri.schoolart.bean.StudentClass;
import com.bhageshri.schoolart.dao.StuClassDAO;
import com.bhageshri.schoolart.domain.StuClass;
import com.bhageshri.schoolart.exception.DAOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mahavir.singh
 */
@RestController
public class StuClassController {
    
    /**
     * Initiate logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(StuClassController.class);
    
    @Inject
    private StuClassDAO stuClassDAO;
    
    @RequestMapping(value = "/stuClasses")
    public List<StudentClass> stuClasses() {
        List<StudentClass> studentClasses = new ArrayList<>();
        try {
            List<StuClass> stuClasses = stuClassDAO.findAll();
            for (StuClass stuClass : stuClasses) {
                studentClasses.add(new StudentClass(stuClass.getId(), 
                        stuClass.getName()));
            }
        } catch (DAOException ex) {
            LOGGER.error(ex.getMessage());
        }
        return studentClasses;
    }
}
