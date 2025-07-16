package com.fsse2506.project.mapper.transactionProduct;

import com.fsse2506.project.data.cartItem.domainObject.response.CartItemResponseData;
import com.fsse2506.project.data.transaction.entity.TransactionEntity;
import com.fsse2506.project.data.transactionProduct.entity.TransactionProductEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionProductEntityMapper {

    public List<TransactionProductEntity> toTransactionProductEntityList(List<CartItemResponseData> cartItemResponseDataList, TransactionEntity transactionEntity) {
        List<TransactionProductEntity> transactionProductEntityList = new ArrayList<>();
        for (CartItemResponseData cartItemResponseData : cartItemResponseDataList) {
            TransactionProductEntity transactionProductEntity = new TransactionProductEntity();
            transactionProductEntity.setTransactionEntity(transactionEntity);
            transactionProductEntity.setPid(cartItemResponseData.getPid());
            transactionProductEntity.setName(cartItemResponseData.getName());
            transactionProductEntity.setDescription(cartItemResponseData.getImageUrl());
            transactionProductEntity.setImageUrl(cartItemResponseData.getImageUrl());
            transactionProductEntity.setPrice(cartItemResponseData.getPrice());
            transactionProductEntity.setStock(cartItemResponseData.getStock());
            transactionProductEntity.setQuantity(cartItemResponseData.getCartQuantity());
            transactionProductEntityList.add(transactionProductEntity);
        }
        return transactionProductEntityList;
    }
}
