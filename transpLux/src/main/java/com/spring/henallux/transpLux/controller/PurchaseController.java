package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.Constants;
import com.spring.henallux.transpLux.model.Cart;
import com.spring.henallux.transpLux.model.LineItem;
import com.spring.henallux.transpLux.model.Command;
import com.spring.henallux.transpLux.model.User;
import com.spring.henallux.transpLux.services.CartService;
import com.spring.henallux.transpLux.services.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/purchase")
@SessionAttributes({Constants.CART})
public class PurchaseController {

    private CommandService orderService;
    private CartService cartService;

    @Autowired
    public PurchaseController(CommandService orderService, CartService cartService) {
        this.orderService = orderService;
        this.cartService = cartService;
    }

    @ModelAttribute(Constants.CART)
    public Cart cart() {
        return new Cart();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String purchase(Model model, @ModelAttribute(value = Constants.CART) Cart cart) {

        if (cart.isEmpty())
                return "redirect:/fail";

        model.addAttribute("paypalButtonHidden", true);

        return "integrated:purchase";
    }

    @RequestMapping(value = "/registerCommand", method = RequestMethod.POST)
    public String registerCommand(Model model,
                                  Authentication auth,
                                  @ModelAttribute(value = Constants.CART) Cart cart) {
        Command order = new Command();
        ArrayList<LineItem> items = new ArrayList<>();

        User user = (User) auth.getPrincipal();
        order.setUserEmail(user.getEmail());

        cart.getProducts().values().forEach(p -> {
            items.add( new LineItem(p.getQuantity(), p.getProduct().getPriceWithDiscount(), p.getProduct().getId()));
        });
        try{
            user.setCurrentOrderId(orderService.insertNewCommand(order, items));

            model.addAttribute("paypalButtonHidden", false);
            model.addAttribute("totalAmount", cartService.getTotalPriceWithDiscounts(cart));
        }catch(Exception e){
            return "integrated:fail";
        }

        return "integrated:purchase";
    }

    @RequestMapping(value = "/validateOrder", method = RequestMethod.GET)
    public String validateCommand(Model model,
                                  Authentication auth) {
        User user = (User) auth.getPrincipal();

        int orderId = user.getCurrentOrderId();
        if (orderId != 0){
            try {
                orderService.validatePayment(orderId);
            }catch (Exception e){
                return "integrated:fail";
            }
        }

        return "redirect:/";
    }

}
