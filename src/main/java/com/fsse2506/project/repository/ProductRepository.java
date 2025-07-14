package com.fsse2506.project.repository;

import com.fsse2506.project.data.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
}
