package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.Constants;
import com.spring.henallux.transpLux.model.Cart;
import com.spring.henallux.transpLux.model.CartItem;
import com.spring.henallux.transpLux.model.Product;
import com.spring.henallux.transpLux.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Configuration
@RequestMapping()
@SessionAttributes({Constants.CURRENT_USER})
public class WelcomeController {
    @ModelAttribute(Constants.CURRENT_USER)
    public User user(){
        return new User();
    }

    @RequestMapping(value="",method = RequestMethod.GET)
    public String home(Model model,@ModelAttribute(value = Constants.CURRENT_USER) User user){
        model.addAttribute("title", "Welcome Page");
        model.addAttribute("firstName",user.getFirstName());

        return "integrated:page-index-3";
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

}
