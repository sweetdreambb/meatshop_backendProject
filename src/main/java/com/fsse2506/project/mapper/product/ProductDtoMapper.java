package com.fsse2506.project.mapper.product;

import com.fsse2506.project.data.product.domainObject.response.GetAllProductResponseData;
import com.fsse2506.project.data.product.domainObject.response.ProductResponseData;
import com.fsse2506.project.data.product.dto.response.GetAllProductResponseDto;
import com.fsse2506.project.data.product.dto.response.ProductResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface ProductDtoMapper {

    GetAllProductResponseDto toGetAllProductResponseDto(GetAllProductResponseData getAllProductResponseData);

    List<GetAllProductResponseDto> toGetAllProductResponseDtoList(List<GetAllProductResponseData> getAllProductResponseDataList);

    ProductResponseDto toProductResponseDto(ProductResponseData productResponseData);

}
