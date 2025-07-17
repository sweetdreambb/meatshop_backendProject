package com.fsse2506.project.repository;

import com.fsse2506.project.data.cartItem.entity.CartItemEntity;
import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.user.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends CrudRepository<CartItemEntity, Integer> {
        List<CartItemEntity> findByUserEntity(UserEntity userEntity);
    Optional<CartItemEntity> findByUserEntityAndProductEntity(UserEntity userEntity, ProductEntity productEntity);
    Integer deleteByUserEntity_EmailAndProductEntity_Pid(String email, Integer pid);
}
