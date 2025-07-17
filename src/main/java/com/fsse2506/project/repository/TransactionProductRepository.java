package com.fsse2506.project.repository;

import com.fsse2506.project.data.transaction.entity.TransactionEntity;
import com.fsse2506.project.data.transactionProduct.entity.TransactionProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionProductRepository extends CrudRepository<TransactionProductEntity,Integer> {
    List<TransactionProductEntity> findAllByTransactionEntity(TransactionEntity transactionEntity);
}
