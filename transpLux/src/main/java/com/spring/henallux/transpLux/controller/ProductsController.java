package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.Constants;
import com.spring.henallux.transpLux.dataAccess.dao.ProductAccessDAO;
import com.spring.henallux.transpLux.dataAccess.dao.ProductDAO;
import com.spring.henallux.transpLux.exceptions.EmptyProductListException;
import com.spring.henallux.transpLux.model.Cart;
import com.spring.henallux.transpLux.model.CartItem;
import com.spring.henallux.transpLux.model.Product;
import com.spring.henallux.transpLux.model.Quantity;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
@Controller
@SessionAttributes({Constants.CART})
@RequestMapping(value = "/products")
public class ProductsController {

    private ProductDAO productDAO;

    @Autowired
    private ProductsController(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @ModelAttribute(Constants.CART)
    public Cart cart() {
        return new Cart();
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

    @RequestMapping(value = "/addToCart/{productId}", method = RequestMethod.POST)
    public String addToCart(Model model, @PathVariable String productId, @Valid @ModelAttribute(value = "quantity")Quantity quantity, @ModelAttribute(value = Constants.CART)Cart cart, final BindingResult errors) {

        if (errors.hasErrors()) {

            return "integrated:page-listing-large-prod";

        }

        // MODIFIER L'EXCEPTION
        try {
            Product product = productDAO.findProductById(Integer.parseInt(productId));
            cart.addProduct(product, quantity.getNumber());
        } catch (Exception e) {
            System.out.println("Erreur lors du parse");
        }

        return "integrated:page-listing-large-prod";
    }

}
