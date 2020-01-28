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
@Profile("Start")
public class CartStartController implements CartController {

    private CartService cartStartService;

    @Autowired
    public CartStartController(
            @Qualifier("cartStartService") CartService cartStartService
    ) {
        this.cartStartService = cartStartService;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void startShop() {
        cartStartService.start();
    }
}
