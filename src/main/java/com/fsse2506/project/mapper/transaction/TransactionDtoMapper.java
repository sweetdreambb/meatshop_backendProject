package com.fsse2506.project.mapper.transaction;

import com.fsse2506.project.data.transaction.domainObject.response.TransactionResponseData;
import com.fsse2506.project.data.transaction.dto.response.TransactionResponseDto;
import com.fsse2506.project.mapper.transactionProduct.TransactionProductDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoMapper {
    private final TransactionProductDtoMapper transactionProductDtoMapper;

    public TransactionDtoMapper(TransactionProductDtoMapper transactionProductDtoMapper) {
        this.transactionProductDtoMapper = transactionProductDtoMapper;
    }

    public TransactionResponseDto toTransactionResponseDto (TransactionResponseData transactionResponseData){
        TransactionResponseDto transactionResponseDto=new TransactionResponseDto();
        transactionResponseDto.setTid(transactionResponseData.getTid());
        transactionResponseDto.setBuyerUid(transactionResponseData.getBuyerUid());
        transactionResponseDto.setDatetime(transactionResponseData.getDatetime());
        transactionResponseDto.setStatus(transactionResponseData.getStatus());
        transactionResponseDto.setTotal(transactionResponseData.getTotal());
        transactionResponseDto.setTransactionProductResponseDtoList(
                transactionProductDtoMapper.toTransactionProductResponseDtoList(
                        transactionResponseData.getTransactionProductResponseDataList()
                )
        );
        return transactionResponseDto;
    }
}
