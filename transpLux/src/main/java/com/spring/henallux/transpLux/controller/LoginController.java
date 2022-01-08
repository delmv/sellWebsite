package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.Constants;
import com.spring.henallux.transpLux.model.Cart;
import com.spring.henallux.transpLux.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/login")
@SessionAttributes({Constants.CURRENT_USER, Constants.CART})
public class LoginController {

    @ModelAttribute(Constants.CURRENT_USER)
    public User user(){
        return new User();
    }

    @ModelAttribute(Constants.CART)
    public Cart cart() {
        return new Cart();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model,
                        @ModelAttribute(value = Constants.CURRENT_USER)User currentUser,
                        @ModelAttribute(value = Constants.CART) Cart cart){
        model.addAttribute("error",error);
        model.addAttribute("logout",logout);
        model.addAttribute("title", "Login");
        model.addAttribute("nbItemsCart", cart.getProducts().size());
        model.addAttribute("user",new User());

        return "integrated:login";
    }

}
