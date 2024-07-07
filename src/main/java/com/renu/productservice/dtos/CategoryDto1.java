package com.renu.productservice.dtos;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.renu.productservice.models.Category}
 */
@Value
public class CategoryDto1 implements Serializable {
    Long id;
    Date createdAt;
    Date updatedAt;
    String title;
}