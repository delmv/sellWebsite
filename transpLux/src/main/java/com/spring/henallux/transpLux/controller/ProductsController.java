package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.Constants;
import com.spring.henallux.transpLux.dataAccess.dao.ProductDAO;
import com.spring.henallux.transpLux.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@Controller
@SessionAttributes({Constants.CURRENT_USER})
@RequestMapping(value = "/products")
public class ProductsController {

    private ProductDAO productDAO;

    @Autowired
    public ProductsController(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public User user() {
        return new User();
    }

   @RequestMapping(value = "/{category}",method = RequestMethod.GET)
    public String test(@PathVariable String category,Model model) {
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

            return "integrated:page-listing-large";
        }catch(Exception e){
            System.out.println(e);
            return "redirect:/";
        }
    }
    @RequestMapping(value = "/details/{id}",method = RequestMethod.GET)
    public String details(@PathVariable String id,Model model) {
        model.addAttribute("title", "Product Details");
        try {
            Product product = productDAO.findProductById(Integer.parseInt(id));

            model.addAttribute("product", product);
            model.addAttribute("quantity", new Quantity());

            return "integrated:product-details";
        }catch(Exception e){
            System.out.println(e);
            return "redirect:/";
        }
    }

}
