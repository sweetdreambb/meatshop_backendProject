package com.fsse2506.project.data.product.domainObject.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponseData {

    private Integer pid;

    private String name;

    private String description;

    private String imageUrl;

    private BigDecimal price;

    private Integer stock;
}
