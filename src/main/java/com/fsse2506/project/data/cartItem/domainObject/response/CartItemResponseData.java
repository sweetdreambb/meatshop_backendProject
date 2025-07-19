package com.fsse2506.project.data.cartItem.domainObject.response;


import lombok.Data;

import java.math.BigDecimal;
@Data
public class CartItemResponseData {
    private Integer pid;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Integer cartQuantity;
    private Integer stock;
}
