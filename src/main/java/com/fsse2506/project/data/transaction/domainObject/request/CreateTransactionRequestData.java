package com.fsse2506.project.data.transaction.domainObject.request;

import com.fsse2506.project.data.transaction.dto.request.CreateTransactionRequestDto;
import com.fsse2506.project.data.transactionProduct.domainObject.request.CreateTransactionProductRequestData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CreateTransactionRequestData {
    private Integer tid;
    private Integer buyerUid;
    private LocalDateTime datetime;
    private String status;
    private BigDecimal total;
    private List<CreateTransactionProductRequestData> createTransactionProductRequestDataList;
}
