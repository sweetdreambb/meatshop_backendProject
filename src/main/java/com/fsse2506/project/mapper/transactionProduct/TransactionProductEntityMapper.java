package com.fsse2506.project.mapper.transactionProduct;

import com.fsse2506.project.data.cartItem.domainObject.response.CartItemResponseData;
import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.transaction.entity.TransactionEntity;
import com.fsse2506.project.data.transactionProduct.entity.TransactionProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel="spring")
public interface TransactionProductEntityMapper {

    @Mapping(target="transactionEntity",source="transactionEntity")
    @Mapping(target="pid",source="productEntity.pid")
    @Mapping(target="name",source="productEntity.name")
    @Mapping(target="description",source="productEntity.description")
    @Mapping(target="imageUrl",source="productEntity.imageUrl")
    @Mapping(target="price",source="productEntity.price")
    @Mapping(target="stock",source="productEntity.stock")
    @Mapping(target="quantity",source="cartItemResponseData.cartQuantity")
    TransactionProductEntity toTransactionProductEntity(
            ProductEntity productEntity,
            CartItemResponseData cartItemResponseData,
            TransactionEntity transactionEntity
    );
    default List<TransactionProductEntity> toTransactionProductEntityList(
            List<ProductEntity> productEntityList,
            List<CartItemResponseData> cartItemReponseDataList,
            TransactionEntity transactionEntity
    ){
        List<TransactionProductEntity> transactionProductEntityList=new ArrayList<>();
        int count=cartItemReponseDataList.size();
        for (int i=0;i<count;i++){
            transactionProductEntityList.add(
                    toTransactionProductEntity(
                            productEntityList.get(i),
                            cartItemReponseDataList.get(i),
                            transactionEntity
                    )
            );
        }
        return transactionProductEntityList;
    }
}
