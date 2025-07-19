package com.fsse2506.project.data.transactionProduct.domainObject.response;

import com.fsse2506.project.data.product.domainObject.response.ProductResponseData;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class TransactionProductResponseData {
    private Integer tpid;
    private ProductResponseData productResponseData;
    private Integer quantity;
    private BigDecimal subtotal;
}
