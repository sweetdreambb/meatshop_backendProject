package com.fsse2506.project.mapper.transactionProduct;

import com.fsse2506.project.data.transactionProduct.domainObject.response.TransactionProductResponseData;
import com.fsse2506.project.data.transactionProduct.dto.response.TransactionProductResponseDto;
import com.fsse2506.project.mapper.product.ProductDtoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionProductDtoMapper {

    private final ProductDtoMapper productDtoMapper;

    public TransactionProductDtoMapper(ProductDtoMapper productDtoMapper) {

        this.productDtoMapper = productDtoMapper;
    }

    public TransactionProductResponseDto toTransactionProductResponseDto(TransactionProductResponseData transactionProductResponseData){
        TransactionProductResponseDto transactionProductResponseDto=new TransactionProductResponseDto();
        transactionProductResponseDto.setTpid(transactionProductResponseData.getTpid());
        transactionProductResponseDto.setProductResponseDto(
                productDtoMapper.toProductResponseDto(
                        transactionProductResponseData.getProductResponseData()
                )
        );
        transactionProductResponseDto.setSubtotal(transactionProductResponseData.getSubtotal());
        transactionProductResponseDto.setQuantity(transactionProductResponseData.getQuantity());
        return transactionProductResponseDto;
    }
    public List<TransactionProductResponseDto> toTransactionProductResponseDtoList(List<TransactionProductResponseData> transactionProductResponseDataList){
        List<TransactionProductResponseDto> transactionProductResponseDtoList=new ArrayList<>();
        for (TransactionProductResponseData transactionProductResponseData: transactionProductResponseDataList){
            transactionProductResponseDtoList.add(toTransactionProductResponseDto(transactionProductResponseData));
        }
        return transactionProductResponseDtoList;
    }
}
