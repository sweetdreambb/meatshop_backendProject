package com.fsse2506.project.service;

import com.fsse2506.project.data.cartItem.domainObject.response.CartItemResponseData;
import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.transaction.entity.TransactionEntity;
import com.fsse2506.project.data.transactionProduct.domainObject.response.TransactionProductResponseData;
import com.fsse2506.project.data.transactionProduct.entity.TransactionProductEntity;

import java.util.List;

public interface TransactionProductService {

    List<TransactionProductResponseData> createTransactionProductResponseDataList(TransactionEntity transactionEntity, List<CartItemResponseData> cartItemResponseDataList);

    List<TransactionProductResponseData> getTransactionProductResponseDataList(
            TransactionEntity transactionEntity);

    List<ProductEntity> getProductEntityList(List<TransactionProductEntity> transactionProductEntityList);
}
