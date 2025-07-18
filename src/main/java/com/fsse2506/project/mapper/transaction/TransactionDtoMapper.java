package com.fsse2506.project.mapper.transaction;

import com.fsse2506.project.data.transaction.domainObject.response.TransactionResponseData;
import com.fsse2506.project.data.transaction.dto.response.TransactionResponseDto;
import com.fsse2506.project.mapper.transactionProduct.TransactionProductDtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses=TransactionProductDtoMapper.class, componentModel="spring")
public interface TransactionDtoMapper {
    TransactionDtoMapper INSTANCE= Mappers.getMapper(TransactionDtoMapper.class);

    @Mapping(target="transactionProductResponseDtoList",source="transactionProductResponseDataList")
    TransactionResponseDto toTransactionResponseDto (TransactionResponseData transactionResponseData);
//
//        transactionResponseDto.setTid(transactionResponseData.getTid());
//        transactionResponseDto.setBuyerUid(transactionResponseData.getBuyerUid());
//        transactionResponseDto.setDatetime(transactionResponseData.getDatetime());
//        transactionResponseDto.setStatus(transactionResponseData.getStatus());
//        transactionResponseDto.setTotal(transactionResponseData.getTotal());
//        transactionResponseDto.setTransactionProductResponseDtoList(
//                transactionProductDtoMapper.toTransactionProductResponseDtoList(
//                        transactionResponseData.getTransactionProductResponseDataList()
//                )
//        );

}
