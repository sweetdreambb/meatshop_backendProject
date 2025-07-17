package com.fsse2506.project.repository;

import com.fsse2506.project.data.transaction.entity.TransactionEntity;
import com.fsse2506.project.data.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {

    Optional<TransactionEntity> findByUserEntityAndTid(UserEntity userEntityByFirebaseUserData, Integer tid);
}
