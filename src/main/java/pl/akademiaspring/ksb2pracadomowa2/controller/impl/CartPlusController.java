package pl.akademiaspring.ksb2pracadomowa2.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import pl.akademiaspring.ksb2pracadomowa2.controller.CartController;
import pl.akademiaspring.ksb2pracadomowa2.service.CartService;

@Controller
@Profile("Plus")
public class CartPlusController implements CartController {


    private CartService cartPlusService;

    @Autowired
    public CartPlusController(
            @Qualifier("cartPlusService") CartService cartPlusService
    ) {
        this.cartPlusService = cartPlusService;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void startShop() {
        cartPlusService.start();
    }
}
