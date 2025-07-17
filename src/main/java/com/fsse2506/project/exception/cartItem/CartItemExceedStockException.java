package com.fsse2506.project.exception.cartItem;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CartItemExceedStockException extends RuntimeException {
    public CartItemExceedStockException(Integer pid) {
        super("Cannot put cart Item pid:"+pid+" into cart; quantity exceeds stock.");
    }
}
