package com.renu.productservice.services;

import com.renu.productservice.dtos.FakeStoreProductDto;
import com.renu.productservice.models.Category;
import com.renu.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
    @Override
    public Product getProductById(Long id) {
        //Call the FakeStore API to get the product with given ID here.
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
        //Convert fakeStoreProductDto to product object.
        if(null==fakeStoreProductDto) return null;
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products/", FakeStoreProductDto[].class);
        return Arrays.stream(fakeStoreProductDtos).map(this::convertFakeStoreProductDtoToProduct).toList();
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
    public Product replaceProduct() {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}
