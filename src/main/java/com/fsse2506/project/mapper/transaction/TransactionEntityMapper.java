package com.fsse2506.project.mapper.transaction;

import com.fsse2506.project.data.transaction.domainObject.request.CreateTransactionRequestData;
import com.fsse2506.project.data.transaction.entity.TransactionEntity;
import com.fsse2506.project.data.user.domainObject.request.FirebaseUserData;
import com.fsse2506.project.data.user.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionEntityMapper {
    public TransactionEntity toTransactionEntity(CreateTransactionRequestData createTransactionRequestData, UserEntity userEntity){
        TransactionEntity transactionEntity=new TransactionEntity();
        transactionEntity.setUserEntity(userEntity);
        transactionEntity.setDatetime(createTransactionRequestData.getDatetime());
        transactionEntity.setStatus(createTransactionRequestData.getStatus());
        transactionEntity.setTid(createTransactionRequestData.getTid());
        transactionEntity.setTotal(createTransactionRequestData.getTotal());
        return transactionEntity;
    }
}
