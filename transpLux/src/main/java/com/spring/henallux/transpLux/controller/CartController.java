package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.Constants;
import com.spring.henallux.transpLux.dataAccess.dao.ProductDAO;
import com.spring.henallux.transpLux.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({Constants.CURRENT_USER})
public class CartController {

    private ProductDAO productDAO;

    @Autowired
    public CartController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public User user() {
        return new User();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String cart(Model model) {
        model.getAttribute(Constants.CURRENT_USER);
        return "integrated:page-shopping-cart";
    }
    
}
