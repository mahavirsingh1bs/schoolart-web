/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author mahavir.singh
 */
@Controller
public class ViewController {
    /**
     * Initiate logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ViewController.class);
    
    @RequestMapping(value = "/ShowAddTeacher", method = RequestMethod.GET)
    public String showAddTeacher() {
        return "add_teacher";
    }
}
