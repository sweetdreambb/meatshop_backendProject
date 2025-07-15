package com.fsse2506.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UpdateProductQuantityNegativeException extends RuntimeException {
    public UpdateProductQuantityNegativeException(Integer quantity){
        super("Update quantity cannot be negative! "+quantity);
    }
}
