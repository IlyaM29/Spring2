package ru.gb.less2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    private ProductInMemoryRepository productInMemoryRepository;
    @Autowired
    private Cart cart;

    public Product getProduct(Long id) {
        return productInMemoryRepository.findById(id);
    }

    public List<Product> getAllProduct() {
        return productInMemoryRepository.allProduct();
    }

    public void putInCart(Long id) {
        cart.putProduct(productInMemoryRepository.findById(id));
    }

    public void removeFromCart(Long id) {
        cart.removeProduct(id);
    }

    public List<Product> showCart () {
        return cart.all();
    }
}
