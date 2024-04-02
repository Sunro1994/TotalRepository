package com.practice.springboot.ToDoListApplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {



        ///login => com.in28minutes.springboot.myfirstwebapp.login.LoginController => login.jsp

        //http://localhost:8080/login?name=Ranga
        //Model

        Logger log = LoggerFactory.getLogger(getClass());
        @RequestMapping("/login")
        public ModelAndView gotoLoginPage(@RequestParam String name) {
            ModelAndView mav = new ModelAndView();
            mav.addObject("name", name);
            log.info("show me my info {}",name);
            System.out.println("Request param is " + name); //NOT RECOMMENDED FOR PROD CODE
            mav.setViewName("login");
            return mav;
        }
    }

