package com.fsse2506.project.mapper.product;

import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.transactionProduct.entity.TransactionProductEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductEntityMapper {
    public ProductEntity toProductEntity(TransactionProductEntity transactionProductEntity){
        ProductEntity productEntity=new ProductEntity();
        productEntity.setPid(transactionProductEntity.getPid());
        productEntity.setStock(transactionProductEntity.getStock());
        productEntity.setDescription(transactionProductEntity.getDescription());
        productEntity.setName(transactionProductEntity.getName());
        productEntity.setImageUrl(transactionProductEntity.getImageUrl());
        productEntity.setPrice(transactionProductEntity.getPrice());
        return productEntity;
    }
    public List<ProductEntity> toProductEntityList(List<TransactionProductEntity> transactionProductEntityList){
        List<ProductEntity> productEntityList=new ArrayList<>();
        for (TransactionProductEntity transactionProductEntity: transactionProductEntityList){
            productEntityList.add(toProductEntity(transactionProductEntity));
        }
        return productEntityList;
    }
}
