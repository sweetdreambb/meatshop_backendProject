package com.fsse2506.project.exception.transactionProduct;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TransactionProductExceedStockException extends RuntimeException {
    public TransactionProductExceedStockException(Integer tpid) {

        super("Cannot process transaction product item tpid:"+tpid+"; quantity exceeds stock.");
    }
}
