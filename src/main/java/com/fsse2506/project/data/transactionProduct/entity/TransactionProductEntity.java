package com.fsse2506.project.data.transactionProduct.entity;

import com.fsse2506.project.data.transaction.entity.TransactionEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="transaction_product", indexes={
        @Index(name="idx_transaction_product_tid_pid", columnList = "tid,pid")
})
@Getter @Setter
public class TransactionProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tpid;

    @ManyToOne
    @JoinColumn(name="tid",nullable = false)
    private TransactionEntity transactionEntity;

    @Column(nullable = false)
    private Integer pid;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(name="image_url")
    private String imageUrl;

    @Column(nullable = false)
    @Min(0)
    private BigDecimal price;

    @Column(nullable = false)
    @Min(0)
    private Integer stock;

    @Column(nullable = false)
    @Min(0)
    private Integer quantity;
}
