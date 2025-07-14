package com.fsse2506.project.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="product")
@Getter @Setter @NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    @Column(nullable = false)
    private String name;
    @Column
    private String description;
    @Column
    private String imageUrl;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Integer stock;
}
