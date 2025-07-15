package com.fsse2506.project.repository;

import com.fsse2506.project.data.cartItem.entity.CartItemEntity;
import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.user.entity.UserEntity;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends CrudRepository<CartItemEntity, Integer> {
        List<CartItemEntity> findByUserEntity(UserEntity userEntity);


    Optional<CartItemEntity> findByUserEntityAndProductEntity(UserEntity userEntity, ProductEntity productEntity);
}
