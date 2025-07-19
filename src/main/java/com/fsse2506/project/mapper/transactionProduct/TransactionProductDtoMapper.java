package com.fsse2506.project.mapper.transactionProduct;

import com.fsse2506.project.data.transactionProduct.domainObject.response.TransactionProductResponseData;
import com.fsse2506.project.data.transactionProduct.dto.response.TransactionProductResponseDto;
import com.fsse2506.project.mapper.product.ProductDtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses=ProductDtoMapper.class, componentModel="spring")
public interface TransactionProductDtoMapper {

    ProductDtoMapper INSTANCE= Mappers.getMapper(ProductDtoMapper.class);

    @Mapping(target="productResponseDto", source="productResponseData")
    TransactionProductResponseDto toTransactionProductResponseDto(TransactionProductResponseData transactionProductResponseData);

//        transactionProductResponseDto.setProductResponseDto(
//                productDtoMapper.toProductResponseDto(
//                        transactionProductResponseData.getProductResponseData()
//                )
//        );

    List<TransactionProductResponseDto> toTransactionProductResponseDtoList(
            List<TransactionProductResponseData> transactionProductResponseDataList
    );
}
