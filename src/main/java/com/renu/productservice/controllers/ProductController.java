package com.renu.productservice.controllers;

import com.renu.productservice.models.Product;
import com.renu.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    // localhost:8080/products/10
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    //localhost:8080/products
    @GetMapping
    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }

    //create a Product
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }

    //partial update
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    //Replace product
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
    }
}
