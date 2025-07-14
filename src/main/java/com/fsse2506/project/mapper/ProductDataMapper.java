package com.fsse2506.project.mapper;

import com.fsse2506.project.data.domainObject.response.ProductResponseData;
import com.fsse2506.project.data.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDataMapper {
    public ProductResponseData toProductReponseData(ProductEntity productEntity){
        ProductResponseData productResponseData=new ProductResponseData();
        productResponseData.setName(productEntity.getName());
        productResponseData.setPid(productEntity.getPid());
        productResponseData.setPrice(productEntity.getPrice());
        productResponseData.setHasStock(productEntity.getStock()>0);
        productResponseData.setImageUrl(productEntity.getImageUrl());
        return productResponseData;
    }
    public List<ProductResponseData> toProductResponseDataList(List<ProductEntity> productEntityList){
        List<ProductResponseData> productResponseDataList=new ArrayList<>();
        for (ProductEntity productEntity: productEntityList){
            productResponseDataList.add(toProductReponseData(productEntity));
        }
        return productResponseDataList;
    }

}
