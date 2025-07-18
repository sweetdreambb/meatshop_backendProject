package com.fsse2506.project.data.transaction.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2506.project.data.transactionProduct.dto.response.TransactionProductResponseDto;

import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data

public class TransactionResponseDto {
    private Integer tid;
    private Integer buyerUid;
    private LocalDateTime datetime;
    private String status;
    private BigDecimal total;
    @JsonProperty("items")
    private List<TransactionProductResponseDto> transactionProductResponseDtoList;
}
