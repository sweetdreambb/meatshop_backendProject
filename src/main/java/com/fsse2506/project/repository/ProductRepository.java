package com.fsse2506.project.repository;

import com.fsse2506.project.data.product.entity.ProductEntity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategory(String category);
}
