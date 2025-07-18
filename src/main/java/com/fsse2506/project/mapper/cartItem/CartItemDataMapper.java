package com.fsse2506.project.mapper.cartItem;

import com.fsse2506.project.data.cartItem.domainObject.response.CartItemResponseData;
import com.fsse2506.project.data.cartItem.entity.CartItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartItemDataMapper {
    @Mapping(source = "productEntity.pid", target = "pid")
    @Mapping(source = "productEntity.name", target = "name")
    @Mapping(source = "productEntity.imageUrl", target = "imageUrl")
    @Mapping(source = "productEntity.price", target = "price")
    @Mapping(source = "productEntity.stock", target = "stock")
    @Mapping(source = "quantity", target = "cartQuantity")
    CartItemResponseData toCartItemResponseData(CartItemEntity cartItemEntity);

    List<CartItemResponseData> toCartItemResponseDataList(List<CartItemEntity> cartItemEntityList);
}