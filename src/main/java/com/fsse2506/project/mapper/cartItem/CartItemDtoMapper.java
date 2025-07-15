package com.fsse2506.project.mapper.cartItem;

import com.fsse2506.project.data.cartItem.domainObject.response.CartItemResponseData;
import com.fsse2506.project.data.cartItem.dto.response.CartItemResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartItemDtoMapper {
    public List<CartItemResponseDto> toCartItemResponseDtoList(List<CartItemResponseData> cartItemReponseDataList){
        List<CartItemResponseDto> cartItemResponseDtoList=new ArrayList<>();
        for (CartItemResponseData cartItemResponseData: cartItemReponseDataList){
            cartItemResponseDtoList.add(toCartItemResponseDto(cartItemResponseData));
        }
        return cartItemResponseDtoList;
    }
    public CartItemResponseDto toCartItemResponseDto(CartItemResponseData cartItemResponseData){
        CartItemResponseDto cartItemResponseDto=new CartItemResponseDto();
        cartItemResponseDto.setCartQuantity(cartItemResponseData.getCartQuantity());
        cartItemResponseDto.setName(cartItemResponseData.getName());
        cartItemResponseDto.setPid(cartItemResponseData.getPid());
        cartItemResponseDto.setStock(cartItemResponseData.getStock());
        cartItemResponseDto.setImageUrl(cartItemResponseData.getImageUrl());
        cartItemResponseDto.setPrice(cartItemResponseData.getPrice());
        return cartItemResponseDto;
    }
}
