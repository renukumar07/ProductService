package com.renu.productservice.services;

import com.renu.productservice.dtos.ProductDto;
import com.renu.productservice.exceptions.InvalidProductIdException;
import com.renu.productservice.models.Category;
import com.renu.productservice.models.Product;
import com.renu.productservice.repositories.CategoryRepository;
import com.renu.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long id) throws InvalidProductIdException {
        //Fetch Product with the given id from DB.
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            //throw an Excepiton -> ProductNotFound
            return null;
        }
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        //Fetch all the Products from DB.
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

//        if(category.getId() == null){
//            //first save the category in the DB
//            Category savedCategory = categoryRepository.save(category);
//            product.setCategory(savedCategory);
//        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new RuntimeException("Product not found");
        }

        if(product == null) throw new RuntimeException("Invalid input exception to update method");
        Product currentProduct = optionalProduct.get();
        if(product.getTitle() != null){
            // If title isn't null that means we want to update the title.
            currentProduct.setTitle(product.getTitle());
        }
        if(product.getDescription() != null){
            currentProduct.setDescription(product.getDescription());
        }
        if(product.getPrice() != null){
            currentProduct.setPrice(product.getPrice());
        }
        return productRepository.save(currentProduct);
    }

    @Override
    public Product replaceProduct(Long id, ProductDto productDto) {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}
