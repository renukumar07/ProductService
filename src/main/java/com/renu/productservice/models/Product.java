package com.renu.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
//    @Id
//    private Long id; ---> Moved to Base Model
    private String title;
    private Double price;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category; // By default Eager fetch
    private String description;
    private String image;
    private int quantity;
}

/*
    1               1
    Product ----- Category  ===> M:1
    M               1
    -----------------------
    M               1

    1                M
    Movie --------- Actor
    M               1
    ----------------------
    M               M
 */