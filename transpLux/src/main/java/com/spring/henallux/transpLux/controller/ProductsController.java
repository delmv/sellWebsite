package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.Constants;
import com.spring.henallux.transpLux.dataAccess.dao.CategoryDAO;
import com.spring.henallux.transpLux.dataAccess.dao.ProductDAO;
import com.spring.henallux.transpLux.model.*;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Locale;

@Controller
@SessionAttributes({Constants.CURRENT_USER, Constants.CART})
@RequestMapping(value = "/products")
public class ProductsController {

    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;

    @Autowired
    public ProductsController(ProductDAO productDAO, CategoryDAO categoryDAO){
        this.productDAO = productDAO;
        this.categoryDAO = categoryDAO;
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public User user() {
        return new User();
    }

    @ModelAttribute(Constants.CART)
    public Cart cart() {
        return new Cart();
    }

   @RequestMapping(value = "/{category}",method = RequestMethod.GET)
    public String test(@PathVariable String category, Model model, @ModelAttribute(Constants.CART) Cart cart, Locale locale) {
        model.addAttribute("title", "Products");
        boolean noCategory = category.equals("all");
        model.addAttribute("noCategory",noCategory);
        model.addAttribute("categories", categoryDAO.findAllCategory());
        model.addAttribute("nbItemsCart", cart.getProducts().size());
       model.addAttribute("locale",locale.getLanguage());

       try {
            ArrayList<Product> products;
            if(noCategory)
                products = productDAO.findAllProducts();
            else
                products = productDAO.findProductByCategory(category);

            model.addAttribute("products", products);
            model.addAttribute("quantity", new Quantity());

            return "integrated:listing-products";
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
