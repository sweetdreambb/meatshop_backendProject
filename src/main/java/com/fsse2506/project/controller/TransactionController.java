package com.fsse2506.project.controller;

import com.fsse2506.project.data.transaction.domainObject.request.CreateTransactionRequestData;
import com.fsse2506.project.data.transaction.dto.request.CreateTransactionRequestDto;
import com.fsse2506.project.data.transaction.dto.response.TransactionResponseDto;
import com.fsse2506.project.mapper.transaction.TransactionDataMapper;
import com.fsse2506.project.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final TransactionDataMapper transactionDataMapper;

    public TransactionController(TransactionService transactionService, TransactionDataMapper transactionDataMapper) {
        this.transactionService = transactionService;
        this.transactionDataMapper = transactionDataMapper;
    }

    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponseDto createTransaction(@AuthenticationPrincipal Jwt jwt, @RequestBody CreateTransactionRequestDto createTransactionRequestDto){
        CreateTransactionRequestData createTransactionRequestData=transactionDataMapper.toCreateTransactionRequestData(createTransactionRequestDto);
    }
}
