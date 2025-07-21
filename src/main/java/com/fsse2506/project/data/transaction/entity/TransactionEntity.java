package com.fsse2506.project.data.transaction.entity;

import com.fsse2506.project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2506.project.enumeration.Status;
import com.fsse2506.project.data.user.entity.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="transaction", indexes={
        @Index(name="idx_transaction_tid_buyer", columnList="tid,buyer_uid")
})
@Getter
@Setter
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;
    @ManyToOne
    @JoinColumn(name="buyer_uid",nullable = false)
    private UserEntity userEntity;
    @Column(nullable = false)
    private LocalDateTime datetime;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    @Min(0)
    private BigDecimal total;

    @OneToMany(mappedBy ="transactionEntity")
    private List<TransactionProductEntity> transactionProductEntityList=new ArrayList<>();

}
