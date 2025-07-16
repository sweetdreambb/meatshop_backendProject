package com.fsse2506.project.mapper.transaction;

import com.fsse2506.project.data.transaction.domainObject.request.CreateTransactionRequestData;
import com.fsse2506.project.data.transaction.dto.request.CreateTransactionRequestDto;
import com.fsse2506.project.mapper.transactionProduct.TransactionProductDataMapper;
import org.springframework.stereotype.Component;

@Component
public class TransactionDataMapper {
    private final TransactionProductDataMapper transactionProductDataMapper;

    public TransactionDataMapper(TransactionProductDataMapper transactionProductDataMapper) {
        this.transactionProductDataMapper = transactionProductDataMapper;
    }

    public CreateTransactionRequestData toCreateTransactionRequestData(CreateTransactionRequestDto createTransactionRequestDto){
        CreateTransactionRequestData createTransactionRequestData=new CreateTransactionRequestData();
        createTransactionRequestData.setCreateTransactionProductRequestDataList(
                transactionProductDataMapper.toCreateTransactionProductRequestDataList(
                        createTransactionRequestDto.getCreateTransactionProductRequestDtoList()
                )
        );
        createTransactionRequestData.setTid(createTransactionRequestDto.getTid());
        createTransactionRequestData.setTotal(createTransactionRequestDto.getTotal());
        createTransactionRequestData.setStatus(createTransactionRequestDto.getStatus());
        createTransactionRequestData.setDatetime(createTransactionRequestDto.getDatetime());
        createTransactionRequestData.setBuyerUid(createTransactionRequestDto.getBuyerUid());
        return createTransactionRequestData;
    }
}
