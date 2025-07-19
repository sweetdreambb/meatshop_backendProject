package com.fsse2506.project.data.transaction.domainObject.response;

import com.fsse2506.project.data.transactionProduct.domainObject.response.TransactionProductResponseData;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data

public class TransactionResponseData {
    private Integer tid;
    private Integer buyerUid;
    private LocalDateTime datetime;
    private String status;
    private BigDecimal total;
    private List<TransactionProductResponseData> transactionProductResponseDataList;
}
