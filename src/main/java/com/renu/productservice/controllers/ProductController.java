package com.renu.productservice.controllers;

import com.renu.productservice.dtos.ProductDto;
import com.renu.productservice.exceptions.InvalidProductIdException;
import com.renu.productservice.exceptions.ProductControllerSpecificException;
import com.renu.productservice.models.Product;
import com.renu.productservice.services.ProductService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws InvalidProductIdException {
        Product product = productService.getProductById(id);
        //return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));
        //return new ResponseEntity<>(product, HttpStatus.OK);
        return ResponseEntity.ok(product);
    }

    //localhost:8080/products
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    //create a Product
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }

    //partial update
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto){
        return new Product();
    }

    //Replace product
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto){
        return productService.replaceProduct(id, productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
    }

    @ExceptionHandler(ProductControllerSpecificException.class)
    public ResponseEntity<Void> handleProductControllerSpecificException(){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
