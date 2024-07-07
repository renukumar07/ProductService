package com.renu.productservice.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.renu.productservice.models.Product}
 */
@Value
public class ProductDto1 implements Serializable {
    String title;
    Double price;
    CategoryDto1 category;
    String description;
    String image;
}