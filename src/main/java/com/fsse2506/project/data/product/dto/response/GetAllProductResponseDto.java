package com.fsse2506.project.data.product.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Getter @Setter
public class GetAllProductResponseDto {

    private Integer pid;

    private String name;

    private String imageUrl;

    private BigDecimal price;

    private Boolean hasStock;
}
