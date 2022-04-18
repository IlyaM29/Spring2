package ru.gb.less2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    public List<Product> productList = new ArrayList<>();

    public void putProduct(Product product) {
        productList.add(product);
        System.out.println(product + " put in cart");
    }

    public void removeProduct(Long id) {
        productList.remove(productList.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new));
        System.out.println("Product with id:" + id + " has been removed from cart");
    }

    public List<Product> all() {
        return productList;
    }
}

