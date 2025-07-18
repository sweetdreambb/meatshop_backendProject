package com.fsse2506.project.mapper.transactionProduct;

import com.fsse2506.project.data.product.domainObject.response.ProductResponseData;
import com.fsse2506.project.data.transactionProduct.domainObject.response.TransactionProductResponseData;
import com.fsse2506.project.data.transactionProduct.entity.TransactionProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Mapper(componentModel="spring")
public interface TransactionProductDataMapper {

    @Mapping(target="tpid", source="transactionProductEntity.tpid")
    @Mapping(target="productResponseData",source="productResponseData")
    @Mapping(target="quantity",source="transactionProductEntity.quantity")
    @Mapping(target="subtotal",expression="java(calculateSubtotal(productResponseData.getPrice(),transactionProductEntity.getQuantity()))")
    TransactionProductResponseData toTransactionProductResponseData(
            TransactionProductEntity transactionProductEntity,
            ProductResponseData productResponseData
    );

    default BigDecimal calculateSubtotal(BigDecimal price, Integer quantity){
        return price.multiply(BigDecimal.valueOf(quantity));
    }
//        transactionProductResponseData.setTpid(transactionProductEntity.getTpid());
//        transactionProductResponseData.setProductResponseData(productResponseData);
//        transactionProductResponseData.setQuantity(
//                transactionProductEntity.getQuantity()
//        );
//        transactionProductResponseData.setSubtotal(
//                productResponseData.getPrice().multiply(
//                        BigDecimal.valueOf(transactionProductEntity.getQuantity()
//                        )
//                )
//        );
//
    default List<TransactionProductResponseData> toTransactionProductResponseDataList(
            List<TransactionProductEntity> transactionProductEntityList,
            List<ProductResponseData> productResponseDataList
    ){
        List<TransactionProductResponseData> transactionProductResponseDataList=new ArrayList<>();
                for (int i=0; i<transactionProductEntityList.size(); i++){
            transactionProductResponseDataList.add(
                    toTransactionProductResponseData(
                            transactionProductEntityList.get(i),
                            productResponseDataList.get(i)
                    )
            );
        }
        return transactionProductResponseDataList;
    }

//    public List<TransactionProductResponseData> toTransactionProductResponseDataList(List<TransactionProductEntity> transactionProductEntityList, List<ProductResponseData> productResponseDataList){
//        List<TransactionProductResponseData> transactionProductResponseDataList=new ArrayList<>();
//        for (int i=0; i<transactionProductEntityList.size(); i++){
//            transactionProductResponseDataList.add(
//                    toTransactionProductResponseData(
//                            transactionProductEntityList.get(i),
//                            productResponseDataList.get(i)
//                    )
//            );
//        }
//        return transactionProductResponseDataList;
//    }

}
