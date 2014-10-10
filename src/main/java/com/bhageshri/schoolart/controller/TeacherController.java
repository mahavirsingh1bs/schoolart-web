/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.controller;

import com.bhageshri.schoolart.bean.TeacherBean;
import com.bhageshri.schoolart.dao.TeacherDAO;
import com.bhageshri.schoolart.domain.Address;
import com.bhageshri.schoolart.domain.Teacher;
import com.bhageshri.schoolart.exception.DAOException;
import com.bhageshri.schoolart.util.BeanUtil;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mahavir.singh
 */
@RestController
public class TeacherController {
   /**
    * Initiate logger
    */
   private static final Logger LOGGER = LoggerFactory.getLogger(TeacherController.class);
   
   @Inject
   private TeacherDAO teacherDAO;

   @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
   public String addTeacher(@RequestBody TeacherBean teacherBean) {
       Address address = new Address(teacherBean.getStreet(), teacherBean.getCity(), teacherBean.getZipcode());
       Teacher teacher = new Teacher(teacherBean.getFirstName(), teacherBean.getLastName(), address);
       try {
            teacherDAO.create(teacher);
       } catch (DAOException ex) {
           LOGGER.error("an error occurred while creating teacher: " + ex.getMessage());
       }
       return "teachers";
   }
   
   @RequestMapping(value = "/teachers", method = RequestMethod.GET)
   public List<TeacherBean> addTeacher(HttpSession session) {
       List<TeacherBean> teachers = new LinkedList<>();
       try {
           for (Teacher teacher : teacherDAO.findAll()) {
               Address address = teacher.getAddress();
               TeacherBean teacherBean = new TeacherBean(teacher.getId(), 
                       teacher.getFirstName(), teacher.getLastName(), address.getStreet(),
                       address.getCity(), address.getZipcode());
               teachers.add(teacherBean);
           }
       } catch (DAOException ex) {
           LOGGER.error("an error occurred while creating teacher: " + ex.getMessage());
       }
       return teachers;
   }
}
