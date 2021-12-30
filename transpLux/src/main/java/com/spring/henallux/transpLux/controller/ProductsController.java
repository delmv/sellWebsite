package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.Constants;
import com.spring.henallux.transpLux.dataAccess.dao.ProductAccessDAO;
import com.spring.henallux.transpLux.dataAccess.dao.ProductDAO;
import com.spring.henallux.transpLux.exceptions.EmptyProductListException;
import com.spring.henallux.transpLux.model.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
@Controller
@SessionAttributes({Constants.CURRENT_USER})
@RequestMapping(value = "/products")
public class ProductsController {

    private ProductDAO productDAO;

    @Autowired
    private ProductsController(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public User user() {
        return new User();
    }

    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public String products(@PathVariable String category,Model model) {
        model.addAttribute("title", "Products");
        boolean noCategory = category.equals("all");
        model.addAttribute("noCategory",noCategory);

        try {
            ArrayList<Product> products;
            if(noCategory)
                products = productDAO.findAllProducts();
            else
                products = productDAO.findProductByCategory(category);

            model.addAttribute("products", products);
            model.addAttribute("quantity", new Quantity());

            return "integrated:page-listing-large-prod";
        }catch(Exception e){
            System.out.println(e);
            return "redirect:/";
        }
    }



}
