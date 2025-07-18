package com.fsse2506.project.mapper.cartItem;

import com.fsse2506.project.data.cartItem.entity.CartItemEntity;
import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.user.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface CartItemEntityMapper {
    CartItemEntity toCartItemEntity(Integer quantity, UserEntity userEntity, ProductEntity productEntity);
}
