package com.fsse2506.project.data.transactionProduct.dto.response;

import com.fsse2506.project.data.product.dto.response.ProductResponseDto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter @Setter
public class TransactionProductResponseDto {
    private Integer tpid;
    private ProductResponseDto productResponseDto;
    private Integer quantity;
    private BigDecimal subtotal;
}
