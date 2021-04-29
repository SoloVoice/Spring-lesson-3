package com.geekbrains.spring.mvc.services;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private ProductsRepository productsRepository;

    @Autowired
    public ProductService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> getAllProducts() {
        return productsRepository.getProducts();
    }

    public Product getProductById(int id) {
        for (Product p: productsRepository.getAllProducts()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    public void addProduct(int id, String name, int cost) {
        productsRepository.addProduct(new Product(id, name, cost));
    }
    public void deleteProduct(int id) {
        productsRepository.deleteById(id);
    }
}
