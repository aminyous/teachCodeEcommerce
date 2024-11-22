package com.teachCode.ecommerce.exceptions;

import com.teachCode.ecommerce.exceptions.ErrorResponse;
import com.teachCode.ecommerce.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = { ProductNotFoundException.class })
//    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException exception){
//        ErrorResponse productNotFound = new ErrorResponse(LocalDateTime.now(), exception.getMessage(), "Product not found");
//        return new ResponseEntity<>(productNotFound, HttpStatus.NOT_FOUND);
//    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundExceptionVersion2(ProductNotFoundException exception){


        ProductException productException = new ProductException(
                exception.getMessage(),
                exception.getCause(),
                HttpStatus.NOT_FOUND

        );
        return new ResponseEntity<>(productException, HttpStatus.NOT_FOUND);
    }

}
