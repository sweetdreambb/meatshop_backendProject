package com.fsse2506.project.exception.cartItem;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CartItemNotFoundException extends RuntimeException {
    public CartItemNotFoundException(Integer uid, Integer pid) {
      super("Cart item Not Found: uid=" +uid+", pid="+pid);
    }
}
