package pl.akademiaspring.ksb2pracadomowa2.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.akademiaspring.ksb2pracadomowa2.model.Product;
import pl.akademiaspring.ksb2pracadomowa2.service.CartService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@Profile("Plus")
public class CartPlusService extends CartService {

    @Value("${cart.vat-value}")
    private BigDecimal vatValue;

    @Override
    public void start() {
        super.addProductsToCart();
        List<Product> productList = super.getProductList();
        BigDecimal calculatedCartSum = super.calculateSum(productList);
        System.out.println("Sklep w wersji: PLUS");
        productList.forEach(System.out::println);
        System.out.println("Suma: " + calculatedCartSum + " zł netto");
        BigDecimal calculatedCartSumWithVat =
                calculatedCartSum.multiply(vatValue).setScale(2, RoundingMode.HALF_EVEN);
        System.out.println("Suma: " + calculatedCartSumWithVat + " zł brutto");
    }
}
