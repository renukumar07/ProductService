package com.renu.productservice.exceptions;

import lombok.Getter;

@Getter
public class InvalidProductIdException extends Exception{

    Long productId;
    public InvalidProductIdException(String message, Long productId) {
        super(message);
        this.productId = productId;
    }
}
