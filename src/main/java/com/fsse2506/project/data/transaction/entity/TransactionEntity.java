package com.fsse2506.project.data.transaction.entity;

import com.fsse2506.project.data.user.entity.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="transaction")
@Data

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
    private String status;
    @Column(nullable = false)
    @Min(0)
    private BigDecimal total;

}
