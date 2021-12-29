package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.Constants;
import com.spring.henallux.transpLux.dataAccess.dao.UserDAO;
import com.spring.henallux.transpLux.dataAccess.dao.UserDataAccess;
import com.spring.henallux.transpLux.model.LoginForm;
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
@RequestMapping(value = "/login")
@SessionAttributes({Constants.CURRENT_USER})
public class LoginController {

    private UserDAO userDAO;

    @Autowired
    public LoginController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public User user(){
        return new User();
    }

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
            try {
                User loggedUser = userDAO.getUser(loginForm.getEmail(), loginForm.getPassword());
                model.addAttribute(Constants.CURRENT_USER, loggedUser);
            } catch (Exception e) {
                System.out.println(e);
                return "integrated:page-user-login";
            }

            return "redirect:/";
        } else {
            System.out.println("aie");
            return "integrated:page-user-login";
        }
    }
}
