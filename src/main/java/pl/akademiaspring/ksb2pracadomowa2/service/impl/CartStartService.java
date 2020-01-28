package pl.akademiaspring.ksb2pracadomowa2.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.akademiaspring.ksb2pracadomowa2.model.Product;
import pl.akademiaspring.ksb2pracadomowa2.service.CartService;

import java.math.BigDecimal;
import java.util.List;

@Service
@Profile("Start")
public class CartStartService extends CartService {


    @Override
    public void start() {
        super.addProductsToCart();
        List<Product> productList = super.getProductList();
        BigDecimal calculatedCartSum = super.calculateSum(productList);
        System.out.println("Sklep w wersji: START");
        productList.forEach(System.out::println);
        System.out.println("Suma: " + calculatedCartSum);
    }
}
