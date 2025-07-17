package com.fsse2506.project.mapper.cartItem;

import com.fsse2506.project.data.cartItem.entity.CartItemEntity;
import com.fsse2506.project.data.cartItem.domainObject.response.CartItemResponseData;
import com.fsse2506.project.data.product.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CartItemDataMapper {
    public CartItemResponseData toCartItemResponseData(CartItemEntity cartItemEntity){
        CartItemResponseData cartItemResponseData=new CartItemResponseData();
        ProductEntity productEntity=cartItemEntity.getProductEntity();
        cartItemResponseData.setPid(productEntity.getPid());
        cartItemResponseData.setName(productEntity.getName());
        cartItemResponseData.setImageUrl(productEntity.getImageUrl());
        cartItemResponseData.setPrice(productEntity.getPrice());
        cartItemResponseData.setCartQuantity(cartItemEntity.getQuantity());
        cartItemResponseData.setStock(productEntity.getStock());
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
