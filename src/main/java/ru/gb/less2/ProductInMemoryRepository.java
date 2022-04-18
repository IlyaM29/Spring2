package ru.gb.less2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductInMemoryRepository {

    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product(1L, "Product1", 10),
                new Product(2L, "Product2", 12),
                new Product(3L, "Product3", 16),
                new Product(4L, "Product4", 13),
                new Product(5L, "Product5", 18)
        ));
    }

    public Product findById(Long id) {
        return productList.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new);
    }

    public List<Product> allProduct() {
        return productList;
    }
}
