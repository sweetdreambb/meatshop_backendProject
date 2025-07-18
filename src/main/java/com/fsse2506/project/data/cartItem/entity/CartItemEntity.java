package com.fsse2506.project.data.cartItem.entity;

import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.user.entity.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="cart_item")
@Getter @Setter
@Data  // Add this annotation
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    @ManyToOne
    @JoinColumn(name="pid", nullable = false)
    private ProductEntity productEntity;
    @ManyToOne
    @JoinColumn(name="uid", nullable = false)
    private UserEntity userEntity;
    @Column(nullable = false)
    @Min(0)
    private Integer quantity;
}
