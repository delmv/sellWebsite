package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.Constants;
import com.spring.henallux.transpLux.model.Cart;
import com.spring.henallux.transpLux.model.Product;
import com.spring.henallux.transpLux.model.Quantity;
import com.spring.henallux.transpLux.model.User;
import com.spring.henallux.transpLux.services.CartService;
import com.spring.henallux.transpLux.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@SessionAttributes({Constants.CURRENT_USER, Constants.CART})
@RequestMapping("/cart")
public class CartController {

    private ProductService productService;
    private CartService cartService;

    @Autowired
    public CartController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @ModelAttribute(Constants.CART)
    public Cart cart() {
        return new Cart();
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public User user() {
        return new User();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String cart(Model model, @ModelAttribute(value = Constants.CART)Cart cart, @ModelAttribute(value = Constants.CURRENT_USER) User user) {

        model.addAttribute("cart", cart);
        model.addAttribute("quantity", new Quantity());
        model.addAttribute("nbItemsCart", cart.getProducts().size());
        model.addAttribute("user", user);
        model.addAttribute("cartPriceWithoutDiscounts", cartService.getCartTotalPriceWithoutDiscounts(cart));
        model.addAttribute("cartTotalDiscount", cartService.getTotalDiscounts(cart));
        model.addAttribute("cartTotalPrice", cartService.getTotalPriceWithDiscounts(cart));

        return "integrated:shopping-cart";
    }

    @RequestMapping(value = "/addToCart/{productId}", method = RequestMethod.POST)
    public String addToCart(Model model, @PathVariable String productId, @Valid @ModelAttribute(value = "quantity") Quantity quantity, @ModelAttribute(value = Constants.CART) Cart cart, final BindingResult errors) {

        if (errors.hasErrors()) {

            return null;

        }

        // MODIFIER L'EXCEPTION
        try {
            Product product = productService.findProductById(Integer.parseInt(productId));
            System.out.println(quantity.getNumber());
            cart.addProduct(product, quantity.getNumber());
        } catch (Exception e) {
            System.out.println("Erreur lors du parse");
        }

        return "redirect:/products/details/" + productId;
    }

    @RequestMapping(value = "/changeQuantity/{productId}", method = RequestMethod.POST)
    public String changeQuantity(Model model,
                                 @PathVariable String productId,
                                 @Valid @ModelAttribute(value = "quantity")Quantity quantity,
                                 @ModelAttribute(value = Constants.CART) Cart cart,
                                 final BindingResult errors) {

        if (errors.hasErrors()) {
            return "integrated:shopping-cart";
        }

        int productIdInt = Integer.parseInt(productId);
        System.out.println(productIdInt);

        if (cart.getProducts().containsKey(productIdInt)) {
            cart.getProducts().get(productIdInt).setQuantity(quantity.getNumber());
        }

        model.addAttribute("cart", cart);
        model.addAttribute("nbItemsCart", cart.getProducts().size());
        model.addAttribute("cartService", cartService);
        model.addAttribute("cartPriceWithoutDiscounts", cartService.getCartTotalPriceWithoutDiscounts(cart));
        model.addAttribute("cartTotalDiscount", cartService.getTotalDiscounts(cart));
        model.addAttribute("cartTotalPrice", cartService.getTotalPriceWithDiscounts(cart));

        return "integrated:shopping-cart";
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.POST)
    public String removeItem(Model model,
                             @PathVariable String productId,
                             @ModelAttribute(value = Constants.CART) Cart cart) {

        int productIdInt = Integer.parseInt(productId);
        System.out.println(productIdInt);

        if (cart.getProducts().containsKey(productIdInt)) {
            cart.getProducts().remove(productIdInt);
        }

        model.addAttribute("quantity", new Quantity());
        model.addAttribute("cart", cart);
        model.addAttribute("nbItemsCart", cart.getProducts().size());
        model.addAttribute("cartService", cartService);
        model.addAttribute("cartPriceWithoutDiscounts", cartService.getCartTotalPriceWithoutDiscounts(cart));
        model.addAttribute("cartTotalDiscount", cartService.getTotalDiscounts(cart));
        model.addAttribute("cartTotalPrice", cartService.getTotalPriceWithDiscounts(cart));

        return "integrated:shopping-cart";
    }
}
