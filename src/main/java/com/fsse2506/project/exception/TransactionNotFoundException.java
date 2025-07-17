package com.fsse2506.project.exception;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(Integer tid) {

      super("Transaction Not Found: "+tid);
    }
}
