package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.Constants;
import com.spring.henallux.transpLux.model.Cart;
import com.spring.henallux.transpLux.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/purchase")
@SessionAttributes({Constants.CURRENT_USER, Constants.CART})
public class PurchaseController {

    @ModelAttribute(Constants.CURRENT_USER)
    public User user(){
        return new User();
    }

    @ModelAttribute(Constants.CART)
    public Cart cart() {
        return new Cart();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String purchase(Model model,
                           @ModelAttribute(value = Constants.CART) Cart cart,
                           @ModelAttribute(value = Constants.CURRENT_USER) User user) {

        return "integrated:purchase";

    }

}
