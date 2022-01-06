package com.spring.henallux.transpLux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/fail")
public class ErrorController {

    @RequestMapping(method = RequestMethod.GET)
    public String error(Model model) {

        System.out.println("test");
        return "integrated:fail";

    }

}
