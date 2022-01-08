package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.Constants;
import com.spring.henallux.transpLux.model.*;
import com.spring.henallux.transpLux.services.CategoryService;
import com.spring.henallux.transpLux.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Locale;

@Controller
@SessionAttributes({Constants.CURRENT_USER, Constants.CART})
@RequestMapping(value = "/products")
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService){
        this.productService = productService;
        this.categoryService = categoryService;
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
    public String test(@PathVariable String category,
                       Model model,
                       @ModelAttribute(Constants.CART) Cart cart,
                       Locale locale) {
        model.addAttribute("title", "Products");
        boolean noCategory = category.equals("all");
        model.addAttribute("noCategory",noCategory);

        ArrayList<Category> categories = categoryService.findAllCategory();
        Category currentCategory = null;
        for (Category cat : categories) {
            if (cat.getDefaultName().equals(category)) {
                currentCategory = cat;
                break;
            }
        }

        model.addAttribute("categories", categories);
        model.addAttribute("category", currentCategory);
        model.addAttribute("nbItemsCart", cart.getProducts().size());
        model.addAttribute("locale",locale.getLanguage());

       try {
            ArrayList<Product> products;
            if(noCategory)
                products = productService.findAllProducts();
            else
                products = productService.findProductsByCategory(category);

            model.addAttribute("products", products);
            model.addAttribute("quantity", new Quantity());

           return "integrated:listing-products";
        }catch(Exception e){
            return "redirect:/fail";
        }
    }
    @RequestMapping(value = "/details/{id}",method = RequestMethod.GET)
    public String details(@PathVariable String id,
                          @ModelAttribute(value = Constants.CART) Cart cart,
                          Model model) {
        model.addAttribute("title", "Product Details");
        try {
            Product product = productService.findProductById(Integer.parseInt(id));

            model.addAttribute("product", product);
            model.addAttribute("quantity", new Quantity());
            model.addAttribute("nbItemsCart", cart.getProducts().size());

            return "integrated:product-details";
        }catch(Exception e){
            return "redirect:/fail";
        }
    }

}
