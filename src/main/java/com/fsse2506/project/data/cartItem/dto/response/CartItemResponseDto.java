package com.fsse2506.project.data.cartItem.dto.response;
import lombok.Data;


import java.math.BigDecimal;
@Data

public class CartItemResponseDto {
    private Integer pid;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Integer cartQuantity;
    private Integer stock;
}
