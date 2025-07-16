package com.fsse2506.project.mapper.transactionProduct;

import com.fsse2506.project.data.transaction.domainObject.request.CreateTransactionRequestData;
import com.fsse2506.project.data.transactionProduct.domainObject.request.CreateTransactionProductRequestData;
import com.fsse2506.project.data.transactionProduct.dto.request.CreateTransactionProductRequestDto;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class TransactionProductDataMapper {
    public CreateTransactionProductRequestData toCreateTransactionProductRequestData(CreateTransactionProductRequestDto createTransactionProductRequestDto){
        CreateTransactionProductRequestData createTransactionProductRequestData=new CreateTransactionProductRequestData();
        createTransactionProductRequestData.setProductEntity(createTransactionProductRequestDto.getProductEntity());
        createTransactionProductRequestData.setSubtotal(createTransactionProductRequestDto.getSubtotal());
        createTransactionProductRequestData.setTpid(createTransactionProductRequestDto.getTpid());
        createTransactionProductRequestData.setQuantity(createTransactionProductRequestDto.getQuantity());
        return createTransactionProductRequestData;
    }
    public List<CreateTransactionProductRequestData> toCreateTransactionProductRequestDataList(List<CreateTransactionProductRequestDto> createTransactionProductRequestDtoList){
        List<CreateTransactionProductRequestData> createTransactionProductRequestDataList=new ArrayList<>();
        for (CreateTransactionProductRequestDto createTransactionProductRequestDto: createTransactionProductRequestDtoList){
            createTransactionProductRequestDataList.add(toCreateTransactionProductRequestData(createTransactionProductRequestDto));
        }
        return createTransactionProductRequestDataList;
    }
}
