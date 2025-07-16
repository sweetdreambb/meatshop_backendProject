package com.fsse2506.project.data.transactionProduct.domainObject.response;

import com.fsse2506.project.data.product.domainObject.response.ProductResponseData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor @AllArgsConstructor
public class TransactionProductResponseData {
    private Integer tpid;
    private ProductResponseData productResponseData;
    private Integer quantity;
    private BigDecimal subtotal;
}
