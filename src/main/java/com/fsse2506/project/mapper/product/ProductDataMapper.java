package com.fsse2506.project.mapper.product;

import com.fsse2506.project.data.product.domainObject.response.GetAllProductResponseData;
import com.fsse2506.project.data.product.domainObject.response.ProductResponseData;
import com.fsse2506.project.data.product.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface ProductDataMapper {

    @Mapping(target = "hasStock", expression = "java(productEntity.getStock()>0)")
    GetAllProductResponseData toGetAllProductReponseData(ProductEntity productEntity);

    List<GetAllProductResponseData> toGetAllProductResponseDataList(List<ProductEntity> productEntityList);

    ProductResponseData toProductResponseData(ProductEntity productEntity);

    List<ProductResponseData> toProductResponseDataList(List<ProductEntity> productEntityList);

}
