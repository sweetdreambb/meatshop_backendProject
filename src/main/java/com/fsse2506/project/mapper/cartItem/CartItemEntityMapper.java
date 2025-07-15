package com.fsse2506.project.mapper.cartItem;


import com.fsse2506.project.data.cartItem.entity.CartItemEntity;
import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.user.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class CartItemEntityMapper {
    public CartItemEntity toCartItemEntity(Integer quantity, UserEntity userEntity, ProductEntity productEntity){
        CartItemEntity cartItemEntity=new CartItemEntity();
        cartItemEntity.setProductEntity(productEntity);
        cartItemEntity.setUserEntity(userEntity);
        cartItemEntity.setQuantity(quantity);
        return cartItemEntity;
    }
}
