package com.fsse2506.project.controller;

import com.fsse2506.project.data.transaction.dto.response.TransactionResponseDto;
import com.fsse2506.project.mapper.transaction.TransactionDtoMapper;
import com.fsse2506.project.mapper.user.UserDataMapper;
import com.fsse2506.project.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final UserDataMapper userDataMapper;
    private final TransactionDtoMapper transactionDtoMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponseDto createTransaction(@AuthenticationPrincipal Jwt jwt){
        return transactionDtoMapper.toTransactionResponseDto(
                transactionService.createTransaction(
                userDataMapper.toFirebaseUserData(jwt)
            )
        );
    }
    @GetMapping("/{tid}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionResponseDto getTransactionById(@AuthenticationPrincipal Jwt jwt, @PathVariable Integer tid){
        return transactionDtoMapper.toTransactionResponseDto(
                transactionService.getTransactionById(
                        userDataMapper.toFirebaseUserData(jwt),
                        tid
                )
        );
    }
    @PatchMapping("/{tid}/payment")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTransactionStatusProcessing(@AuthenticationPrincipal Jwt jwt, @PathVariable Integer tid){
        transactionService.updateTransactionStatusProcessing(userDataMapper.toFirebaseUserData(jwt),tid);
    }
    @PatchMapping("/{tid}/success")
    @ResponseStatus(HttpStatus.OK)
    public TransactionResponseDto updateTransactionStatusSuccess(@AuthenticationPrincipal Jwt jwt, @PathVariable Integer tid){
        return transactionDtoMapper.toTransactionResponseDto(
                transactionService.updateTransactionStatusSuccess(
                        userDataMapper.toFirebaseUserData(jwt),tid
                )
        );
    }
}
