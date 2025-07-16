package com.fsse2506.project.mapper.transactionProduct;

import com.fsse2506.project.data.product.domainObject.response.ProductResponseData;
import com.fsse2506.project.data.transaction.domainObject.request.CreateTransactionRequestData;
import com.fsse2506.project.data.transaction.entity.TransactionEntity;
import com.fsse2506.project.data.transactionProduct.domainObject.request.CreateTransactionProductRequestData;
import com.fsse2506.project.data.transactionProduct.domainObject.response.TransactionProductResponseData;
import com.fsse2506.project.data.transactionProduct.dto.request.CreateTransactionProductRequestDto;
import com.fsse2506.project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2506.project.mapper.product.ProductDataMapper;
import com.fsse2506.project.repository.ProductRepository;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Component
public class TransactionProductDataMapper {

    public TransactionProductResponseData toTransactionProductResponseData(TransactionProductEntity transactionProductEntity,ProductResponseData productResponseData){
        TransactionProductResponseData transactionProductResponseData=new TransactionProductResponseData();
        transactionProductResponseData.setTpid(transactionProductEntity.getTpid());
        transactionProductResponseData.setProductResponseData(productResponseData);
        transactionProductResponseData.setQuantity(
                transactionProductEntity.getQuantity()
        );
        transactionProductResponseData.setSubtotal(
                productResponseData.getPrice().multiply(
                        BigDecimal.valueOf(transactionProductEntity.getQuantity()
                        )
                )
        );
        return transactionProductResponseData;
    }
    public List<TransactionProductResponseData> toTransactionProductResponseDataList(List<TransactionProductEntity> transactionProductEntityList, List<ProductResponseData> productResponseDataList){
        List<TransactionProductResponseData> transactionProductResponseDataList=new ArrayList<>();
        int count=transactionProductResponseDataList.size();
        for (int i=0; i<count; i++){
            transactionProductResponseDataList.add(
                    toTransactionProductResponseData(
                            transactionProductEntityList.get(i),
                            productResponseDataList.get(i)
                    )
            );
        }
        return transactionProductResponseDataList;
    }

}
