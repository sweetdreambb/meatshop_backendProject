package com.fsse2506.project.exception.cartItem;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CartItemDeleteFailException extends RuntimeException {
    public CartItemDeleteFailException(String email, Integer pid) {
        super("Cannot find cart item, email="+email+", pid="+pid);
    }
}
