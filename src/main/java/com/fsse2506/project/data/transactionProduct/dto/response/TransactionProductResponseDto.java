package com.fsse2506.project.data.transactionProduct.dto.response;

import com.fsse2506.project.data.product.dto.response.ProductResponseDto;

import java.math.BigDecimal;

public class TransactionProductResponseDto {
    private Integer tpid;
    private ProductResponseDto productResponseDto;
    private Integer quantity;
    private BigDecimal subtotal;
}
