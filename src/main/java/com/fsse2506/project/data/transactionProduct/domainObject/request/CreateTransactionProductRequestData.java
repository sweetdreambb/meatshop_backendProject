package com.fsse2506.project.data.transactionProduct.domainObject.request;

import com.fsse2506.project.data.product.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CreateTransactionProductRequestData {
    private Integer tpid;
    private ProductEntity productEntity;
    private Integer quantity;
    private BigDecimal subtotal;
}
