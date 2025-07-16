package com.fsse2506.project.mapper.transactionProduct;

import com.fsse2506.project.data.transaction.domainObject.request.CreateTransactionRequestData;
import com.fsse2506.project.data.transaction.entity.TransactionEntity;
import com.fsse2506.project.data.transactionProduct.domainObject.request.CreateTransactionProductRequestData;
import com.fsse2506.project.data.transactionProduct.entity.TransactionProductEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionProductEntityMapper {
    public TransactionProductEntity toTransactionProductEntity(CreateTransactionProductRequestData createTransactionProductRequestData, TransactionEntity transactionEntity){
        TransactionProductEntity transactionProductEntity=new TransactionProductEntity();
        transactionProductEntity.setTpid(createTransactionProductRequestData.getTpid());
        transactionProductEntity.setTransactionEntity(transactionEntity);
        transactionProductEntity.setPid(createTransactionProductRequestData.getProductEntity().getPid());
        transactionProductEntity.setName(createTransactionProductRequestData.getProductEntity().getName());
        transactionProductEntity.setDescription(createTransactionProductRequestData.getProductEntity().getDescription());
        transactionProductEntity.setImageUrl(createTransactionProductRequestData.getProductEntity().getImageUrl());
        transactionProductEntity.setPrice(createTransactionProductRequestData.getProductEntity().getPrice());
        transactionProductEntity.setStock(createTransactionProductRequestData.getProductEntity().getStock());
        transactionProductEntity.setQuantity(createTransactionProductRequestData.getQuantity());
        return transactionProductEntity;
    }
    public List<TransactionProductEntity> toTransactionProductEntityList(List<CreateTransactionProductRequestData> createTransactionProductRequestDataList, TransactionEntity transactionEntity){
        List<TransactionProductEntity> transactionProductEntityList=new ArrayList<>();
        for (CreateTransactionProductRequestData createTransactionProductRequestData: createTransactionProductRequestDataList){
            transactionProductEntityList.add(toTransactionProductEntity(createTransactionProductRequestData,transactionEntity));
        }
        return transactionProductEntityList;
    }
}
