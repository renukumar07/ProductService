package com.renu.productservice.advices;

import com.renu.productservice.dtos.ArithmeticExceptionDto;
import com.renu.productservice.dtos.ArrayIndexOutOfBoundExceptionDto;
import com.renu.productservice.dtos.ExceptionDto;
import com.renu.productservice.exceptions.InvalidProductIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> handleArithmeticException(){
        ArithmeticExceptionDto dto = new ArithmeticExceptionDto();
        dto.setMessage("Something went wrong");
        dto.setDetail("Some Detail");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ArrayIndexOutOfBoundExceptionDto> handleIndexOutOfBoundsException(){
        return null;
    }

    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ExceptionDto> handleInvalidProductIdException(InvalidProductIdException e){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setProductId(e.getProductId());
        exceptionDto.setMessage(e.getMessage());
//        exceptionDto.setMessage("Invalid Product id passed, Please retry with a valid product id");
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
//        return null;
    }
}
