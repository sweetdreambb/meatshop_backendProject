package com.fsse2506.project.mapper.cartItem;

import com.fsse2506.project.data.cartItem.domainObject.response.CartItemResponseData;
import com.fsse2506.project.data.cartItem.dto.response.CartItemResponseDto;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel="spring")
public interface CartItemDtoMapper {
    List<CartItemResponseDto> toCartItemResponseDtoList(List<CartItemResponseData> cartItemReponseDataList);
    CartItemResponseDto toCartItemResponseDto(CartItemResponseData cartItemResponseData);
}
