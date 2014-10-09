/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhageshri.schoolart.controller;

import com.bhageshri.schoolart.bean.LoginBean;
import com.bhageshri.schoolart.service.UserService;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author mahavir.singh
 */
@Controller
public class LoginController {
    /**
     * Initiate logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    
    @Inject
    private UserService userService;
    
    @RequestMapping(value = "/showLogin", method = RequestMethod.GET)
    public String showLogin(ModelMap modelMap) {
        modelMap.put("loginBean", new LoginBean());
        return "signin";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginBean") LoginBean loginBean, ModelMap modelMap, HttpSession session) {
        String returnTo = null;
        System.out.println("Username: " + loginBean.getUsername() + " Password: " + loginBean.getPassword());
        boolean isValidUser = userService.login(loginBean.getUsername(), loginBean.getPassword());
        if (isValidUser) {
            session.setAttribute("username", loginBean.getUsername());
            session.setAttribute("isUserAuthenticated", "true");
            session.setMaxInactiveInterval(2*60);
            returnTo = "redirect:showCreateExam";
        } else {
            modelMap.put("error", "username or password is invalid");
            returnTo = "login";
        }
        
        return returnTo;
    }
}
