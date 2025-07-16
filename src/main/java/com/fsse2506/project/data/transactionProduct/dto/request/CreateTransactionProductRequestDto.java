package com.fsse2506.project.data.transactionProduct.dto.request;

import com.fsse2506.project.data.product.entity.ProductEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CreateTransactionProductRequestDto {
    private Integer tpid;
    private ProductEntity productEntity;
    private Integer quantity;
    private BigDecimal subtotal;
}
