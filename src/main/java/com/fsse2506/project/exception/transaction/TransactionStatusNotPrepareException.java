package com.fsse2506.project.exception.transaction;

import com.fsse2506.project.enumeration.Status;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TransactionStatusNotPrepareException extends RuntimeException {
    public TransactionStatusNotPrepareException(Status currentStatus) {
        super("Expected transaction status PREPARE, but current status is " + currentStatus.name());
    }
}
