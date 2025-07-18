package com.fsse2506.project.data.product.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name="product")
@Getter @Setter
@Data  // Add this annotation

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    @Column(nullable = false)
    private String name;

    private String description;

    private String imageUrl;
    @Column(nullable = false)
    @Min(0)
    private BigDecimal price;
    @Column(nullable = false)
    @Min(0)
    private Integer stock;
}
