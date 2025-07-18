package com.fsse2506.project.mapper.transaction;

import com.fsse2506.project.data.transaction.domainObject.response.TransactionResponseData;
import com.fsse2506.project.data.transaction.entity.TransactionEntity;
import com.fsse2506.project.data.transactionProduct.domainObject.response.TransactionProductResponseData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel="spring")
public interface TransactionDataMapper {
    @Mapping(source="transactionEntity.userEntity.uid", target="buyerUid")
    TransactionResponseData toTransactionResponseData(TransactionEntity transactionEntity, List<TransactionProductResponseData> transactionProductResponseDataList);

//        transactionResponseData.setTid(transactionEntity.getTid());
//        transactionResponseData.setBuyerUid(transactionEntity.getUserEntity().getUid());
//        transactionResponseData.setDatetime(transactionEntity.getDatetime());
//        transactionResponseData.setStatus(transactionEntity.getStatus());
//        transactionResponseData.setTotal(transactionEntity.getTotal());
//        transactionResponseData.setTransactionProductResponseDataList(transactionProductResponseDataList);

}
