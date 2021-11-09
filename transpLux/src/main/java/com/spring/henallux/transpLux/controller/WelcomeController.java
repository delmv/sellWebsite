package com.spring.henallux.transpLux.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Configuration
@RequestMapping()
public class WelcomeController {
    @RequestMapping(value="/home",method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("title", "Welcome Page");
        return "integrated:page-index-3";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String products(Model model){
        model.addAttribute("title", "Products");
        return "integrated:page-listing-large-prod";
    }
    @RequestMapping(value = "/myAccount",method = RequestMethod.GET)
    public String myAccount(Model model){
        model.addAttribute("title", "My Account");
        return "integrated:page-profile-main";
    }
    @RequestMapping(value = "/shoppingCart",method = RequestMethod.GET)
    public String shoppingCart(Model model){
        model.addAttribute("title", "Shopping Cart");
        return "integrated:page-shopping-cart";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("title", "Login");
        return "integrated:page-user-login";
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("title", "Register");
        return "integrated:page-user-register";
    }
}
