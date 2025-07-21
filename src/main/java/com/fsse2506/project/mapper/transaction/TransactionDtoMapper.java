package com.fsse2506.project.mapper.transaction;

import com.fsse2506.project.data.transaction.domainObject.response.TransactionResponseData;
import com.fsse2506.project.data.transaction.dto.response.TransactionResponseDto;
import com.fsse2506.project.mapper.transactionProduct.TransactionProductDtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses=TransactionProductDtoMapper.class, componentModel="spring")
public interface TransactionDtoMapper {

    @Mapping(target="transactionProductResponseDtoList",source="transactionProductResponseDataList")
    TransactionResponseDto toTransactionResponseDto (TransactionResponseData transactionResponseData);

//        transactionResponseDto.setTransactionProductResponseDtoList(
//                transactionProductDtoMapper.toTransactionProductResponseDtoList(
//                        transactionResponseData.getTransactionProductResponseDataList()
//                )
//        );

}
