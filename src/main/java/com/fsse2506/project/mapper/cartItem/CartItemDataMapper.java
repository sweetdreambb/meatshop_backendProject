package com.fsse2506.project.mapper.cartItem;

import com.fsse2506.project.data.cartItem.entity.CartItemEntity;
import com.fsse2506.project.data.cartItem.domainObject.response.CartItemResponseData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CartItemDataMapper {
    public CartItemResponseData toCartItemResponseData(CartItemEntity cartItemEntity){
        CartItemResponseData cartItemResponseData=new CartItemResponseData();
        cartItemResponseData.setPid(cartItemEntity.getProductEntity().getPid());
        cartItemResponseData.setName(cartItemEntity.getProductEntity().getName());
        cartItemResponseData.setImageUrl(cartItemEntity.getProductEntity().getImageUrl());
        cartItemResponseData.setPrice(cartItemEntity.getProductEntity().getPrice());
        cartItemResponseData.setCartQuantity(cartItemEntity.getQuantity());
        cartItemResponseData.setStock(cartItemEntity.getProductEntity().getStock());
        return cartItemResponseData;
    }
    public List<CartItemResponseData> toCartItemResponseDataList(List<CartItemEntity> cartItemEntityList){
        List<CartItemResponseData> cartItemResponseDataList=new ArrayList<>();
        for (CartItemEntity cartItemEntity: cartItemEntityList){
            cartItemResponseDataList.add(toCartItemResponseData(cartItemEntity));
        }
        return cartItemResponseDataList;
    }
}
