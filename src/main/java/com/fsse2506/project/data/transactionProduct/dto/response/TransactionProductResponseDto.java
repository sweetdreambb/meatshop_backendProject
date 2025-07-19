package com.fsse2506.project.data.transactionProduct.dto.response;

import com.fsse2506.project.data.product.dto.response.ProductResponseDto;

import lombok.Data;

import java.math.BigDecimal;
@Data

public class TransactionProductResponseDto {
    private Integer tpid;
    private ProductResponseDto productResponseDto;
    private Integer quantity;
    private BigDecimal subtotal;
}
