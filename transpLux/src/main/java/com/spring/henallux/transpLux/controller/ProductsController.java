package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.dataAccess.dao.ProductAccessDAO;
import com.spring.henallux.transpLux.dataAccess.dao.ProductDAO;
import com.spring.henallux.transpLux.exceptions.EmptyProductListException;
import com.spring.henallux.transpLux.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
@Controller
@RequestMapping(value = "/products")
public class ProductsController {

    private ProductDAO productDAO;

    @Autowired
    public ProductsController(ProductDAO productDAO){
        this.productDAO = productDAO;
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
            return "integrated:page-listing-large-prod";
        }catch(Exception e){
            System.out.println(e);
            return "redirect:/";
        }
    }

}
