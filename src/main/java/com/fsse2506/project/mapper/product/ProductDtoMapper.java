package com.fsse2506.project.mapper.product;

import com.fsse2506.project.data.product.domainObject.response.GetAllProductResponseData;
import com.fsse2506.project.data.product.domainObject.response.ProductResponseData;
import com.fsse2506.project.data.product.dto.response.GetAllProductResponseDto;
import com.fsse2506.project.data.product.dto.response.ProductResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDtoMapper {
    public ProductDtoMapper() {
    }

    public GetAllProductResponseDto toGetAllProductResponseDto(GetAllProductResponseData getAllProductResponseData){
        GetAllProductResponseDto getAllProductResponseDto =new GetAllProductResponseDto();
        getAllProductResponseDto.setName(getAllProductResponseData.getName());
        getAllProductResponseDto.setPid(getAllProductResponseData.getPid());
        getAllProductResponseDto.setPrice(getAllProductResponseData.getPrice());
        getAllProductResponseDto.setHasStock(getAllProductResponseData.isHasStock());
        getAllProductResponseDto.setImageUrl(getAllProductResponseData.getImageUrl());
        return getAllProductResponseDto;
    }
    public List<GetAllProductResponseDto> toGetAllProductResponseDtoList(List<GetAllProductResponseData> getAllProductResponseDataList){
        List<GetAllProductResponseDto> getAllProductResponseDtoList =new ArrayList<>();
        for (GetAllProductResponseData getAllProductResponseData : getAllProductResponseDataList){
            getAllProductResponseDtoList.add(toGetAllProductResponseDto(getAllProductResponseData));
        }
        return getAllProductResponseDtoList;
    }
    public ProductResponseDto toProductResponseDto(ProductResponseData productResponseData){
        ProductResponseDto productResponseDto=new ProductResponseDto();
        productResponseDto.setImageUrl(productResponseData.getImageUrl());
        productResponseDto.setStock(productResponseData.getStock());
        productResponseDto.setDescription(productResponseData.getDescription());
        productResponseDto.setName(productResponseData.getName());
        productResponseDto.setPid(productResponseData.getPid());
        productResponseDto.setPrice(productResponseData.getPrice());
        return productResponseDto;
    }
}
