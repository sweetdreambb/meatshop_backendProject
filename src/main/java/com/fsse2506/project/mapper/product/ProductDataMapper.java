package com.fsse2506.project.mapper.product;

import com.fsse2506.project.data.product.domainObject.response.GetAllProductResponseData;
import com.fsse2506.project.data.product.domainObject.response.ProductResponseData;
import com.fsse2506.project.data.product.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDataMapper {
    public GetAllProductResponseData toGetAllProductReponseData(ProductEntity productEntity){
        GetAllProductResponseData getAllProductResponseData =new GetAllProductResponseData();
        getAllProductResponseData.setName(productEntity.getName());
        getAllProductResponseData.setPid(productEntity.getPid());
        getAllProductResponseData.setPrice(productEntity.getPrice());
        getAllProductResponseData.setHasStock(productEntity.getStock()>0);
        getAllProductResponseData.setImageUrl(productEntity.getImageUrl());
        return getAllProductResponseData;
    }
    public List<GetAllProductResponseData> toGetAllProductResponseDataList(List<ProductEntity> productEntityList){
        List<GetAllProductResponseData> getAllProductResponseDataList =new ArrayList<>();
        for (ProductEntity productEntity: productEntityList){
            getAllProductResponseDataList.add(toGetAllProductReponseData(productEntity));
        }
        return getAllProductResponseDataList;
    }
    public ProductResponseData toProductResponseData(ProductEntity productEntity){
        ProductResponseData productResponseData =new ProductResponseData();
        productResponseData.setImageUrl(productEntity.getImageUrl());
        productResponseData.setName(productEntity.getName());
        productResponseData.setPid(productEntity.getPid());
        productResponseData.setStock(productEntity.getStock());
        productResponseData.setDescription(productEntity.getDescription());
        productResponseData.setPrice(productEntity.getPrice());
        return productResponseData;
    }


}
