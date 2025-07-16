package com.fsse2506.project.data.transactionProduct.dto.response;

import com.fsse2506.project.data.product.dto.response.ProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.convert.DataSizeUnit;

import java.math.BigDecimal;
@Data
@NoArgsConstructor @AllArgsConstructor
public class TransactionProductResponseDto {
    private Integer tpid;
    private ProductResponseDto productResponseDto;
    private Integer quantity;
    private BigDecimal subtotal;
}
