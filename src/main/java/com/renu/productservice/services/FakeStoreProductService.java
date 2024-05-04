package com.renu.productservice.services;

import com.renu.productservice.dtos.ProductDto;
import com.renu.productservice.models.Category;
import com.renu.productservice.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    private Product convertProductDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());
        product.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setTitle(productDto.getCategory());
        product.setCategory(category);
        return product;
    }
    @Override
    public Product getProductById(Long id) {
        //Call the FakeStore API to get the product with given ID here.
        ProductDto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, ProductDto.class);
        //Convert productDto to product object.
        if(null==productDto) return null;
        return convertProductDtoToProduct(productDto);
    }

    @Override
    public List<Product> getAllProducts() {
        ProductDto[] productDtos = restTemplate.getForObject("https://fakestoreapi.com/products/", ProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(ProductDto productDto: productDtos){
            products.add(convertProductDtoToProduct(productDto));
        }
        return products;
    }

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public Product updateProduct() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, ProductDto productDto) {
        //PUT Method
        //Replace the product with given id with the input product
        //and return the updated product in the output.

        //Convert the input into the right request param as per the Requirement
        RequestCallback requestCallback = restTemplate.httpEntityCallback(productDto, ProductDto.class);
        HttpMessageConverterExtractor<ProductDto> responseExtractor =
                new HttpMessageConverterExtractor<>(ProductDto.class, restTemplate.getMessageConverters());
        ProductDto returnedProductDto = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertProductDtoToProduct(returnedProductDto);
    }



    @Override
    public void deleteProduct() {

    }
}
