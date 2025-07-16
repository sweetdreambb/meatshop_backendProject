package com.fsse2506.project.mapper.transaction;

import com.fsse2506.project.data.transaction.domainObject.response.TransactionResponseData;
import com.fsse2506.project.data.transaction.entity.TransactionEntity;
import com.fsse2506.project.data.transactionProduct.domainObject.response.TransactionProductResponseData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionDataMapper {

    public TransactionResponseData toTransactionResponseData(TransactionEntity transactionEntity, List<TransactionProductResponseData> transactionProductResponseDataList){
        TransactionResponseData transactionResponseData=new TransactionResponseData();
        transactionResponseData.setTid(transactionEntity.getTid());
        transactionResponseData.setBuyerUid(transactionEntity.getUserEntity().getUid());
        transactionResponseData.setDatetime(transactionEntity.getDatetime());
        transactionResponseData.setStatus(transactionEntity.getStatus());
        transactionResponseData.setTotal(transactionEntity.getTotal());
        transactionResponseData.setTransactionProductResponseDataList(transactionProductResponseDataList);
        return transactionResponseData;
    }
}
