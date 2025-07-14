package com.fsse2506.project.mapper;

import com.fsse2506.project.data.domainObject.response.ProductResponseData;
import com.fsse2506.project.data.dto.response.ProductResponseDto;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDtoMapper {
    public ProductResponseDto toProductResponseDto(ProductResponseData productResponseData){
        ProductResponseDto productResponseDto=new ProductResponseDto();
        productResponseDto.setName(productResponseData.getName());
        productResponseDto.setPid(productResponseData.getPid());
        productResponseDto.setPrice(productResponseData.getPrice());
        productResponseDto.setHasStock(productResponseData.isHasStock());
        productResponseDto.setImageUrl(productResponseData.getImageUrl());
        return productResponseDto;
    }
    public List<ProductResponseDto> toProductResponseDtoList(List<ProductResponseData> productResponseDataList){
        List<ProductResponseDto> productResponseDtoList=new ArrayList<>();
        for (ProductResponseData productResponseData: productResponseDataList){
            productResponseDtoList.add(toProductResponseDto(productResponseData));
        }
        return productResponseDtoList;
    }
}
