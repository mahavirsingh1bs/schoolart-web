/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author mahavir.singh
 */
@Controller
public class SchoolartController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showSchoolart() {
        return "schoolart";
    }
}
