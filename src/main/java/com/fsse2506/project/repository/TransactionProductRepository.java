package com.fsse2506.project.repository;

import com.fsse2506.project.data.transactionProduct.entity.TransactionProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionProductRepository extends CrudRepository<TransactionProductEntity,Integer> {
}
