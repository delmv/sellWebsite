package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.Constants;
import com.spring.henallux.transpLux.exceptions.UsernameOrEmailAlreadyExistException;
import com.spring.henallux.transpLux.model.Cart;
import com.spring.henallux.transpLux.model.User;
import com.spring.henallux.transpLux.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/register")
@SessionAttributes({Constants.CURRENT_USER, Constants.CART})
public class RegisterController {

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService){
        this.userService = userService;
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public User user(){
        return new User();
    }

    @ModelAttribute(Constants.CART)
    public Cart cart() {
        return new Cart();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String register(Model model,
                           @RequestParam(value = "error", required = false) String error,
                           @ModelAttribute(value = Constants.CART) Cart cart){
        model.addAttribute("title", "Register");
        model.addAttribute("registerForm", new User());
        model.addAttribute("nbItemsCart", cart.getProducts().size());
        model.addAttribute("error",error);
        return "integrated:register";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(Model model,
                              @Valid @ModelAttribute(value = Constants.CURRENT_USER) User user,
                              final BindingResult errors) {
        if (!errors.hasErrors()) {
            try {
                userService.addUser(user);
                return "redirect:/login";
            }catch (UsernameOrEmailAlreadyExistException e){
                return "redirect:/register?error=emailOrUsername";
            }catch(Exception e){
                return "integrated:fail";
            }
        } else {
            return "integrated:register";
        }
    }
}
