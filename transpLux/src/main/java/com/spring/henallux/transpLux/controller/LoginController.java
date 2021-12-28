package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.model.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/login")
public class LoginController {



    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("title", "Login");
        model.addAttribute("loginForm",new LoginForm());
        return "integrated:page-user-login";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(Model model,
                              @Valid @ModelAttribute(value = "loginForm") LoginForm loginForm,
                                final BindingResult errors){
        if (!errors.hasErrors()) {
            System.out.println("ok");
            return "redirect:/home";

        } else {
            System.out.println("aie");
            return "integrated:page-user-login";
        }

    }
}
