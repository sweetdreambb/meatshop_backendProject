package com.fsse2506.project.service.serviceImpl;

import com.fsse2506.project.data.transaction.domainObject.request.CreateTransactionRequestData;
import com.fsse2506.project.data.transaction.domainObject.response.TransactionResponseData;
import com.fsse2506.project.data.transaction.entity.TransactionEntity;
import com.fsse2506.project.data.transactionProduct.domainObject.request.CreateTransactionProductRequestData;
import com.fsse2506.project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2506.project.data.user.domainObject.request.FirebaseUserData;
import com.fsse2506.project.data.user.entity.UserEntity;
import com.fsse2506.project.mapper.transaction.TransactionEntityMapper;
import com.fsse2506.project.mapper.transactionProduct.TransactionProductDataMapper;
import com.fsse2506.project.mapper.transactionProduct.TransactionProductEntityMapper;
import com.fsse2506.project.repository.TransactionProductRepository;
import com.fsse2506.project.repository.TransactionRepository;
import com.fsse2506.project.service.TransactionService;
import com.fsse2506.project.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final UserService userService;
    private final TransactionEntityMapper transactionEntityMapper;
    private final TransactionProductEntityMapper transactionProductEntityMapper;
    private final TransactionProductRepository transactionProductRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionProductDataMapper transactionProductDataMapper;

    public TransactionServiceImpl(UserService userService, TransactionEntityMapper transactionEntityMapper, TransactionProductEntityMapper transactionProductEntityMapper, TransactionProductRepository transactionProductRepository, TransactionRepository transactionRepository, TransactionProductDataMapper transactionProductDataMapper) {
        this.userService = userService;
        this.transactionEntityMapper = transactionEntityMapper;
        this.transactionProductEntityMapper = transactionProductEntityMapper;
        this.transactionProductRepository = transactionProductRepository;
        this.transactionRepository = transactionRepository;
        this.transactionProductDataMapper = transactionProductDataMapper;
    }

    public TransactionResponseData createTransaction(FirebaseUserData firebaseUserData, CreateTransactionRequestData createTransactionRequestData){

        UserEntity userEntity=userService.getUserEntityByEmail(firebaseUserData);
        TransactionEntity transactionEntity=transactionEntityMapper.toTransactionEntity(createTransactionRequestData,userEntity);

        transactionProductRepository.saveAll(
                transactionProductEntityMapper.toTransactionProductEntityList(
                        createTransactionProductRequestDataList,transactionEntity
                )
        );

        transactionRepository.save(transactionEntity);


    }

}
