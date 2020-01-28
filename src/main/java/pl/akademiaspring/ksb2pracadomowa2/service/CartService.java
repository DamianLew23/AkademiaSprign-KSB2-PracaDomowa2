package pl.akademiaspring.ksb2pracadomowa2.service;

import pl.akademiaspring.ksb2pracadomowa2.model.Product;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;


public abstract class CartService {


    private List<Product> productList = new ArrayList<>();


    protected void addProductsToCart() {
        productList.add(new Product("Iphone 5", randomPrice()));
        productList.add(new Product("Iphone 6", randomPrice()));
        productList.add(new Product("Iphone 7", randomPrice()));
        productList.add(new Product("Iphone 8", randomPrice()));
        productList.add(new Product("Iphone XS", randomPrice()));
    }


    private BigDecimal randomPrice() {
        return new BigDecimal(BigInteger.valueOf(new Random().nextInt(25001) + 5000), 2);
    }

    protected BigDecimal calculateSum(List<Product> productList) {
        Function<Product, BigDecimal> totalMapper = Product::getPrice;
        return productList.stream()
                .map(totalMapper)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    public void start() {}

    protected List<Product> getProductList() {
        return productList;
    }

    protected void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
