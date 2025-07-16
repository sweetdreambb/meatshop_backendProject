package com.fsse2506.project.controller;

import com.fsse2506.project.data.transaction.dto.response.TransactionResponseDto;
import com.fsse2506.project.mapper.transaction.TransactionDataMapper;
import com.fsse2506.project.mapper.transaction.TransactionDtoMapper;
import com.fsse2506.project.mapper.user.UserDataMapper;
import com.fsse2506.project.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final UserDataMapper userDataMapper;
    private final TransactionDtoMapper transactionDtoMapper;

    public TransactionController(TransactionService transactionService, UserDataMapper userDataMapper, TransactionDtoMapper transactionDtoMapper) {
        this.transactionService = transactionService;
        this.userDataMapper = userDataMapper;
        this.transactionDtoMapper = transactionDtoMapper;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponseDto createTransaction(@AuthenticationPrincipal Jwt jwt){
        return transactionDtoMapper.toTransactionResponseDto(
                transactionService.createTransaction(
                userDataMapper.toFirebaseUserData(jwt)
            )
        );
    }
}
