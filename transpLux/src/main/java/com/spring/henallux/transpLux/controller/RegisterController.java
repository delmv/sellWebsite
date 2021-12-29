package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.Constants;
import com.spring.henallux.transpLux.dataAccess.dao.UserDataAccess;
import com.spring.henallux.transpLux.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/register")
@SessionAttributes({Constants.CURRENT_USER})
public class RegisterController {

    private UserDataAccess userDataAccess;

    @Autowired
    public RegisterController(UserDataAccess userDataAccess){
        this.userDataAccess = userDataAccess;
    }
    @ModelAttribute(Constants.CURRENT_USER)
    public User user(){
        return new User();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("title", "Register");
        model.addAttribute("registerForm", new User());
        return "integrated:page-user-register";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(Model model,
                              @Valid @ModelAttribute(value = Constants.CURRENT_USER) User user,
                              final BindingResult errors) {
        if (!errors.hasErrors() && user.getPassword().equals(user.getRepeatPassword())) {
            try {
                userDataAccess.setUser(user);
                return "redirect:/home";
            }catch(Exception e){
                System.out.println(e);
                return "integrated:page-user-register";
            }
        } else {
            System.out.println("aie");
            return "integrated:page-user-register";
        }
    }
}
