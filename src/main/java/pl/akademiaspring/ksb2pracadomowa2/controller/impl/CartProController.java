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
@Profile("Pro")
public class CartProController implements CartController {

    private CartService cartProService;

    @Autowired
    public CartProController(
            @Qualifier("cartProService") CartService cartProService
    ) {
        this.cartProService = cartProService;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void startShop() {
        cartProService.start();
    }
}


