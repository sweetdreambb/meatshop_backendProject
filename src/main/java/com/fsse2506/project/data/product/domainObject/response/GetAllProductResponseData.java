package com.fsse2506.project.data.product.domainObject.response;

import lombok.*;

import java.math.BigDecimal;

@Data

public class GetAllProductResponseData {

    private Integer pid;

    private String name;

    private String imageUrl;

    private BigDecimal price;

    private boolean hasStock;
}
