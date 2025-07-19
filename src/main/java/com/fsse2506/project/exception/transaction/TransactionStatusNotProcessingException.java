package com.fsse2506.project.exception.transaction;

import com.fsse2506.project.data.transaction.status.Status;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TransactionStatusNotProcessingException extends RuntimeException {
    public TransactionStatusNotProcessingException(Status currentStatus) {
        super("Expected transaction status PROCESSING, but current status is " + currentStatus.name());
    }
}
