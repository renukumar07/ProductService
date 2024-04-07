package com.renu.productservice.services;

import com.renu.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product createProduct();
    Product updateProduct();
    Product replaceProduct();
    void deleteProduct();
}
