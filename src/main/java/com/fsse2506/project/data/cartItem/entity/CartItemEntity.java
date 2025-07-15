package com.fsse2506.project.data.cartItem.entity;

import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.user.entity.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cart_item")
@Data
@NoArgsConstructor @AllArgsConstructor
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
    @Min(0)
    private Integer quantity;

}
