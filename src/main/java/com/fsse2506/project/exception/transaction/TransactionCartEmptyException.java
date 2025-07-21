package com.fsse2506.project.exception.transaction;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TransactionCartEmptyException extends RuntimeException {
    public TransactionCartEmptyException(Integer uid) {
        super("Cart items cannot be zero total!  Uid: "+uid);
    }
}
