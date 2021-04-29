package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/prod_list")
    public String getAllProducts(Model model) {
        model.addAttribute("allProducts", productService.getAllProducts());
        return "products_list";
    }

    @GetMapping("/add_prod")
    public String addProduct(@RequestParam(name = "product_id") int id, @RequestParam(name = "name") String name, @RequestParam(name = "cost") int cost) {
        productService.addProduct(id, name, cost);
        return "redirect:/prod_list";
    }

    @GetMapping("/delete_prod/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/prod_list";
    }

}
