package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.Constants;
import com.spring.henallux.transpLux.dataAccess.dao.CategoryDAO;
import com.spring.henallux.transpLux.model.Cart;
import com.spring.henallux.transpLux.model.User;
import com.spring.henallux.transpLux.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Locale;

@Configuration
@RequestMapping()
@SessionAttributes({Constants.CART})
public class WelcomeController {

    private CategoryService categoryService;

    @Autowired
    public WelcomeController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @ModelAttribute(Constants.CART)
    public Cart cart() {
        return new Cart();
    }

    @RequestMapping(value="",method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value = Constants.CART) Cart cart, Locale locale){
        model.addAttribute("title", "Welcome Page");
        model.addAttribute("categories", categoryDAO.findAllCategory());
        model.addAttribute("locale",locale.getLanguage());
        model.addAttribute("nbItemsCart", cart.getProducts().size());

        return "integrated:home";
    }

    @RequestMapping(value = "/myAccount",method = RequestMethod.GET)
    public String myAccount(Model model){
        model.addAttribute("title", "My Account");
        return "integrated:account";
    }
    @RequestMapping(value = "/shoppingCart",method = RequestMethod.GET)
    public String shoppingCart(Model model){
        model.addAttribute("title", "Shopping Cart");
        return "integrated:shopping-cart";
    }

    @RequestMapping(value = "/aboutus",method = RequestMethod.GET)
    public String aboutUse(Model model){
        model.addAttribute("title", "About Us");
        return "integrated:about-us";
    }


}
