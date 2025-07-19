package com.fsse2506.project.mapper.product;

import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.transactionProduct.entity.TransactionProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface ProductEntityMapper {
    ProductEntity toProductEntity(TransactionProductEntity transactionProductEntity);
}
