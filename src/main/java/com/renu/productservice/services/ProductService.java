package com.renu.productservice.services;

import com.renu.productservice.dtos.ProductDto;
import com.renu.productservice.exceptions.InvalidProductIdException;
import com.renu.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws InvalidProductIdException;
    List<Product> getAllProducts();
    Product createProduct();
    Product updateProduct();
    Product replaceProduct(Long id, ProductDto productDto);
    void deleteProduct();
}
