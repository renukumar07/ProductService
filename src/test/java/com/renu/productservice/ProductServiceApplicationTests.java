package com.renu.productservice;

import com.renu.productservice.models.Category;
import com.renu.productservice.models.Product;
import com.renu.productservice.repositories.CategoryRepository;
import com.renu.productservice.repositories.ProductRepository;
import com.renu.productservice.repositories.projections.ProductWithIdAndTitle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testQueries(){
//        List<Product> productList = productRepository.someRandomQuery();

//        List<Product> productList = productRepository.someRandomQuery2();
//        List<Product> productList = productRepository.someRandomQuery3();
//        List<ProductWithIdAndTitle> productList = productRepository.someRandomQuery3();
//        List<ProductWithIdAndTitle> productList = productRepository.someRandomQuery4();
//        for(ProductWithIdAndTitle product: productList){
//            System.out.println(product.getId());
//            System.out.println(product.getTitle());
//        }
//        System.out.println("DEBUG");
//        ProductWithIdAndTitle product = productRepository.doSomething(2L);
//        System.out.println(product.getId());
//        System.out.println(product.getTitle());
//
//        Product product1 = productRepository.doSomethingSQL();
//        Optional<Product> product1Optional = productRepository.findById(1L);
//        if(product1Optional.isPresent()){
//            Product product2 = product1Optional.get();
//        }
//
//        System.out.println("DEBUG");

//        categoryRepository.deleteById(102L);

//        Optional<Category> optionalCategory = categoryRepository.findById(1L);
//        Category category = optionalCategory.get();
//        System.out.println("DEBUG");
//        List<Product> products = category.getProducts();
//        System.out.println("DEBUG");
    }
}
