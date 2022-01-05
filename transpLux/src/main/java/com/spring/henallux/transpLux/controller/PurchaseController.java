package com.spring.henallux.transpLux.controller;

import com.spring.henallux.transpLux.Constants;
import com.spring.henallux.transpLux.dataAccess.dao.OrderDAO;
import com.spring.henallux.transpLux.model.Cart;
import com.spring.henallux.transpLux.model.LineItem;
import com.spring.henallux.transpLux.model.Order;
import com.spring.henallux.transpLux.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.sound.sampled.Line;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/purchase")
@SessionAttributes({Constants.CURRENT_USER, Constants.CART})
public class PurchaseController {

    private OrderDAO orderDAO;

    @Autowired
    public PurchaseController(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public User user(){
        return new User();
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
                                  @ModelAttribute(value = Constants.CURRENT_USER) User user,
                                  @ModelAttribute(value = Constants.CART) Cart cart) {

        Order order = new Order();
        ArrayList<LineItem> items = new ArrayList<>();

        order.setUserEmail(user.getEmail());

        cart.getProducts().values().forEach(p -> {
            items.add( new LineItem(p.getQuantity(), p.getProduct().getPrice(), p.getProduct().getId()));
        });

        orderDAO.insertNewOrder(order, items);

        model.addAttribute("paypalButtonHidden", false);
        model.addAttribute("totalAmount", cart.getTotalPrice());

        return "integrated:purchase";

    }

}
