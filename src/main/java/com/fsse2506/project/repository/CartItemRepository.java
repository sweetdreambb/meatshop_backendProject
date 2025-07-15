package com.fsse2506.project.repository;

import com.fsse2506.project.data.cartItem.entity.CartItemEntity;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItemEntity, Integer> {
}
