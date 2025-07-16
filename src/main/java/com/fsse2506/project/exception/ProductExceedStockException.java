package com.fsse2506.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductExceedStockException extends RuntimeException {
    public ProductExceedStockException(Integer stock) {
        super("Product quantity exceeds stock: "+stock);
    }
}
