package com.geekbrains.spring.mvc.repositories;

import com.geekbrains.spring.mvc.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductsRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Prod 1", 10000));
        products.add(new Product(2, "Prod 2", 12000));
        products.add(new Product(3, "Prod 3", 14000));
        products.add(new Product(4, "Prod 4", 16000));
        products.add(new Product(5, "Prod 5", 18000));
        products.add(new Product(6, "Prod 6", 20000));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
    public void deleteById(int id) {
        products.removeIf(b -> b.getId() == (id));
    }
}
